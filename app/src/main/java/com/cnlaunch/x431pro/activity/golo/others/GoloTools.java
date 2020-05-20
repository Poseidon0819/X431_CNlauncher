package com.cnlaunch.x431pro.activity.golo.others;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p174db.GoloRemoteOrderInfoDao;
import com.cnlaunch.p169im.p180j.SendMessageTask;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.model.GoloRemoteOrderInfo;
import com.cnlaunch.x431pro.widget.sortlistview.CharacterParser;
import de.greenrobot.dao.query.QueryBuilder;
import java.util.List;
import message.model.ChatMessage;
import message.model.ChatRoom;
import message.p378a.MessageParameters;

/* renamed from: com.cnlaunch.x431pro.activity.golo.others.e */
/* loaded from: classes.dex */
public final class GoloTools {
    /* renamed from: a */
    public static void m6960a(List<GoloRemoteOrderInfo> list, Context context) {
        int i;
        if (list == null) {
            return;
        }
        for (GoloRemoteOrderInfo goloRemoteOrderInfo : list) {
            GoloDBManager m8756a = GoloDBManager.m8756a(context);
            String user_id = goloRemoteOrderInfo.getUser_id();
            String id = goloRemoteOrderInfo.getId();
            QueryBuilder<GoloRemoteOrderInfo> queryBuilder = m8756a.f9220b.f9225b.queryBuilder();
            boolean z = true;
            queryBuilder.where(GoloRemoteOrderInfoDao.Properties.User_id.m321eq(user_id), GoloRemoteOrderInfoDao.Properties.Order_id.m321eq(id));
            List<GoloRemoteOrderInfo> list2 = queryBuilder.list();
            if (list2.size() > 0) {
                while (i < list2.size()) {
                    GoloRemoteOrderInfo goloRemoteOrderInfo2 = list2.get(i);
                    i = (goloRemoteOrderInfo2.getIsRead() == null || !goloRemoteOrderInfo2.getIsRead().booleanValue()) ? i + 1 : 0;
                }
            }
            z = false;
            goloRemoteOrderInfo.setIsRead(Boolean.valueOf(z));
        }
    }

    /* renamed from: a */
    public static boolean m6964a(Context context) {
        return PreferencesManager.m9595a(context).m9583b("isConnect", false);
    }

    /* renamed from: a */
    public static void m6961a(List<FriendInfo> list) {
        if (list == null) {
            return;
        }
        for (FriendInfo friendInfo : list) {
            String nick_name = friendInfo.getNick_name();
            String nick_name2 = !TextUtils.isEmpty(nick_name) && !"null".equalsIgnoreCase(nick_name) ? friendInfo.getNick_name() : friendInfo.getUser_name();
            if (nick_name2 != null) {
                String m4390a = CharacterParser.m4391a().m4390a(nick_name2);
                if (m4390a == null || "".equals(m4390a)) {
                    friendInfo.setSortKey("#");
                } else {
                    String upperCase = m4390a.substring(0, 1).toUpperCase();
                    if (upperCase.matches("[A-Z]")) {
                        friendInfo.setSortKey(upperCase);
                    } else {
                        friendInfo.setSortKey("#");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m6959a(List<GoloRemoteOrderInfo> list, String str) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (GoloRemoteOrderInfo goloRemoteOrderInfo : list) {
            goloRemoteOrderInfo.setDiagType(str);
        }
    }

    /* renamed from: a */
    public static String m6963a(Context context, String str) {
        return UserFaceUtils.m9114a(str, null, PreferencesManager.m9595a(context).m9591a("current_country").equalsIgnoreCase("CN") ? "1" : "2");
    }

    /* renamed from: a */
    public static void m6962a(String str, String str2, String str3, String str4) {
        ChatMessage m190a = new ChatRoom(str, str2, MessageParameters.EnumC4721a.single).m190a(9);
        m190a.m210b(0);
        m190a.m214a("text", (Object) str3);
        m190a.m214a("subcontent", (Object) str4);
        new SendMessageTask().m256e(m190a);
    }
}
