package com.cnlaunch.p169im.p176f;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.golo3.p165g.Singlton;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.p169im.p178h.DBObserver;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.List;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.p378a.UnReadMsg;
import org.json.JSONException;

/* renamed from: com.cnlaunch.im.f.a */
/* loaded from: classes.dex */
public class ChatManager {

    /* renamed from: b */
    private static ChatManager f9248b;

    /* renamed from: a */
    public MessageDao f9249a;

    /* renamed from: c */
    private DBObserver f9250c = null;

    /* renamed from: d */
    private Context f9251d;

    private ChatManager(Context context) {
        this.f9249a = null;
        this.f9251d = null;
        this.f9251d = context;
        try {
            this.f9249a = GoloDBManager.m8756a(this.f9251d).f9220b.f9224a;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static ChatManager m8741a(Context context) {
        if (f9248b == null) {
            synchronized (ChatManager.class) {
                if (f9248b == null) {
                    f9248b = new ChatManager(context);
                }
            }
        }
        return f9248b;
    }

    /* renamed from: a */
    public static void m8742a() {
        synchronized (ChatManager.class) {
            f9248b = null;
        }
    }

    /* renamed from: a */
    public final long m8739a(ChatMessage chatMessage) {
        try {
            long insert = this.f9249a.insert(chatMessage);
            GoloDBManager m8756a = GoloDBManager.m8756a(this.f9251d);
            String str = null;
            try {
                if (chatMessage.m192p().has("pub_name")) {
                    str = chatMessage.m192p().getString("pub_name");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(str)) {
                m8756a.m8752a(chatMessage, chatMessage.f24057b, 0);
            } else {
                m8756a.m8752a(chatMessage, chatMessage.f24057b, 3);
            }
            return insert;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: b */
    public final void m8736b(ChatMessage chatMessage) {
        this.f9249a.update(chatMessage);
    }

    /* renamed from: a */
    public final List<ChatMessage> m8738a(ChatRoom chatRoom, Long l) {
        try {
            QueryBuilder<ChatMessage> queryBuilder = this.f9249a.queryBuilder();
            if (l.longValue() == 0) {
                queryBuilder.where(MessageDao.Properties.roomId.m321eq(chatRoom.f24076a), new WhereCondition[0]);
                queryBuilder.orderDesc(MessageDao.Properties.f9210id);
                queryBuilder.limit(20);
            } else {
                queryBuilder.where(MessageDao.Properties.roomId.m321eq(chatRoom.f24076a), new WhereCondition[0]);
                queryBuilder.where(MessageDao.Properties.f9210id.m315lt(l), new WhereCondition[0]);
                queryBuilder.orderDesc(MessageDao.Properties.f9210id);
                queryBuilder.limit(20);
            }
            return queryBuilder.list();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    /* renamed from: a */
    public final void m8740a(String str, String str2) {
        QueryBuilder<ChatMessage> queryBuilder = this.f9249a.queryBuilder();
        queryBuilder.where(MessageDao.Properties.roomId.m321eq(str), new WhereCondition[0]);
        queryBuilder.where(MessageDao.Properties.roomType.m321eq(str2), new WhereCondition[0]);
        for (ChatMessage chatMessage : queryBuilder.list()) {
            this.f9249a.delete(chatMessage);
        }
        ((UnReadMsg) Singlton.m9123a(UnReadMsg.class)).m302a(str);
    }
}
