package com.cnlaunch.p169im.p174db;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p173d.NoticeMessageHandler;
import com.cnlaunch.p169im.p174db.FriendInfoDao;
import com.cnlaunch.p169im.p174db.GoloRemoteOrderInfoDao;
import com.cnlaunch.p169im.p174db.MessageInfoDao;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.cnlaunch.p169im.p178h.DBObserver;
import com.cnlaunch.p169im.p179i.UserInfoCache;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.model.GoloRemoteOrderInfo;
import com.cnlaunch.x431pro.module.golo.model.VerificationInfo;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.List;
import message.model.ChatMessage;

/* renamed from: com.cnlaunch.im.db.b */
/* loaded from: classes.dex */
public class GoloDBManager {

    /* renamed from: a */
    public static GoloDBManager f9219a;

    /* renamed from: b */
    public GoloDaoSession f9220b;

    /* renamed from: c */
    public Context f9221c;

    /* renamed from: d */
    private DBObserver f9222d = null;

    /* renamed from: e */
    private DBDaoManager f9223e;

    private GoloDBManager(Context context) {
        this.f9220b = null;
        this.f9221c = null;
        this.f9223e = null;
        this.f9221c = context;
        this.f9223e = new DBDaoManager(context);
        this.f9220b = this.f9223e.f9215a;
    }

    /* renamed from: a */
    public static GoloDBManager m8756a(Context context) {
        if (f9219a == null) {
            synchronized (GoloDBManager.class) {
                if (f9219a == null) {
                    f9219a = new GoloDBManager(context);
                }
            }
        }
        return f9219a;
    }

    /* renamed from: a */
    public final List<FriendInfo> m8757a() {
        return this.f9220b.f9226c.queryBuilder().list();
    }

    /* renamed from: b */
    public final List<MessageInfo> m8751b() {
        return this.f9220b.f9228e.loadAll();
    }

    /* renamed from: b */
    public static synchronized void m8750b(Context context) {
        synchronized (GoloDBManager.class) {
            Log.e("Sanda", "IMDB close");
            if (f9219a != null) {
                f9219a.f9220b = null;
                f9219a.f9223e.m8758a(context);
                f9219a = null;
            }
        }
    }

    /* renamed from: a */
    public final FriendInfo m8755a(String str) {
        QueryBuilder<FriendInfo> queryBuilder = this.f9220b.f9226c.queryBuilder();
        queryBuilder.where(FriendInfoDao.Properties.User_id.m321eq(str), new WhereCondition[0]);
        if (queryBuilder.list().size() == 0) {
            return null;
        }
        return queryBuilder.list().get(0);
    }

    /* renamed from: b */
    public final String m8749b(String str) {
        QueryBuilder<GoloRemoteOrderInfo> queryBuilder = this.f9220b.f9225b.queryBuilder();
        queryBuilder.where(GoloRemoteOrderInfoDao.Properties.User_id.m321eq(str), new WhereCondition[0]);
        queryBuilder.limit(1);
        List<GoloRemoteOrderInfo> list = queryBuilder.list();
        return (list == null || list.size() <= 0) ? "" : list.get(0).getId();
    }

    /* renamed from: a */
    public final void m8754a(List<GoloRemoteOrderInfo> list) {
        QueryBuilder<MessageInfo> queryBuilder = this.f9220b.f9228e.queryBuilder();
        queryBuilder.where(MessageInfoDao.Properties.Type.m321eq(1), new WhereCondition[0]);
        this.f9220b.f9228e.deleteInTx(queryBuilder.list());
        if (list == null) {
            return;
        }
        List<GoloRemoteOrderInfo> loadAll = this.f9220b.f9225b.loadAll();
        if (loadAll != null && loadAll.size() > 0) {
            for (GoloRemoteOrderInfo goloRemoteOrderInfo : list) {
                for (GoloRemoteOrderInfo goloRemoteOrderInfo2 : loadAll) {
                    if (goloRemoteOrderInfo.getUser_id().equalsIgnoreCase(goloRemoteOrderInfo2.getUser_id())) {
                        goloRemoteOrderInfo.setIsRead(goloRemoteOrderInfo2.getIsRead());
                    }
                }
            }
            this.f9220b.f9225b.deleteAll();
        }
        this.f9220b.f9225b.insertInTx(list);
        ArrayList arrayList = new ArrayList();
        for (GoloRemoteOrderInfo goloRemoteOrderInfo3 : list) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.f9273e = 1;
            messageInfo.f9275g = goloRemoteOrderInfo3.getDescription();
            messageInfo.f9270b = goloRemoteOrderInfo3.getUser_id();
            String m8710a = UserInfoCache.m8711a(this.f9221c, false).m8710a(goloRemoteOrderInfo3.getUser_id());
            if (TextUtils.isEmpty(m8710a)) {
                IMPresenter.m8804a(this.f9221c).m8795b(goloRemoteOrderInfo3.getUser_id());
            } else {
                messageInfo.f9271c = m8710a;
            }
            messageInfo.f9276h = Long.valueOf(goloRemoteOrderInfo3.getCreated().longValue() * 1000);
            messageInfo.f9272d = Integer.valueOf(!goloRemoteOrderInfo3.getIsRead().booleanValue());
            arrayList.add(messageInfo);
        }
        this.f9220b.f9228e.insertInTx(arrayList);
        IMPresenter.m8804a(this.f9221c).m8790e(40030);
    }

    /* renamed from: a */
    public final void m8752a(ChatMessage chatMessage, String str, int i) {
        QueryBuilder<MessageInfo> queryBuilder = this.f9220b.f9228e.queryBuilder();
        queryBuilder.where(MessageInfoDao.Properties.User_id.m321eq(str), new WhereCondition[0]);
        queryBuilder.where(MessageInfoDao.Properties.Type.m321eq(Integer.valueOf(i)), new WhereCondition[0]);
        queryBuilder.limit(1);
        List<MessageInfo> list = queryBuilder.list();
        if (list == null || list.size() <= 0) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.f9276h = chatMessage.f24062g;
            messageInfo.f9275g = NoticeMessageHandler.m8783a(this.f9221c, chatMessage);
            messageInfo.f9273e = Integer.valueOf(i);
            messageInfo.f9270b = str;
            if (messageInfo.f9270b.equalsIgnoreCase(str) && chatMessage.f24059d.equalsIgnoreCase("read")) {
                messageInfo.f9272d = 0;
            } else {
                messageInfo.f9272d = 1;
            }
            FriendInfo m8755a = m8756a(this.f9221c).m8755a(str);
            String nick_name = m8755a == null ? null : m8755a.getNick_name();
            if (TextUtils.isEmpty(nick_name)) {
                IMPresenter.m8804a(this.f9221c).m8795b(str);
            } else {
                messageInfo.f9271c = nick_name;
            }
            if (m8755a != null && !C1621v.m9121a(m8755a.getRename())) {
                messageInfo.f9271c = m8755a.getRename();
            }
            this.f9220b.f9228e.insert(messageInfo);
        } else {
            list.get(0).f9275g = NoticeMessageHandler.m8783a(this.f9221c, chatMessage);
            list.get(0).f9276h = chatMessage.f24062g;
            if (list.get(0).f9270b.equalsIgnoreCase(str) && chatMessage.f24059d.equalsIgnoreCase("read")) {
                list.get(0).f9272d = 0;
            } else {
                list.get(0).f9272d = Integer.valueOf(list.get(0).f9272d.intValue() + 1);
            }
            this.f9220b.f9228e.updateInTx(list);
        }
        IMPresenter.m8804a(this.f9221c).m8790e(40028);
    }

    @Deprecated
    /* renamed from: a */
    public final void m8753a(ChatMessage chatMessage, String str) {
        VerificationInfo verificationInfo = new VerificationInfo();
        verificationInfo.f15549f = Integer.valueOf(chatMessage.m199i());
        verificationInfo.f15545b = chatMessage.f24057b;
        verificationInfo.f15546c = ChatMessage.m213a(chatMessage.f24063h, "subcontent");
        verificationInfo.m5310a(chatMessage.f24062g);
        verificationInfo.f15547d = chatMessage.m211b();
        verificationInfo.f15552i = str;
        this.f9220b.f9227d.insert(verificationInfo);
        m8752a(chatMessage, "friend_verification", 2);
    }
}
