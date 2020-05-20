package com.cnlaunch.p169im.p176f;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p160b.GoloCacheManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p167h.C1673a;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p174db.MessageInfoDao;
import com.cnlaunch.p169im.p177g.MessageInfo;
import com.cnlaunch.p169im.service.GoloMessageService;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.ifoer.expedition.pro.R;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.util.List;
import message.p378a.MessageLoginManager;
import message.p378a.MessageParameters;
import message.p382e.GoloService;
import message.p383f.ReceiveTask;
import message.p383f.SharePreferenceMsgUtils;
import message.xmpp.XConnection;

/* renamed from: com.cnlaunch.im.f.c */
/* loaded from: classes.dex */
public final class IMManager {

    /* renamed from: a */
    private static boolean f9255a = false;

    /* renamed from: a */
    public static void m8730a(Context context, String str) {
        try {
            Log.i("Sanda", "------>loginIM(new):" + DateUtils.m5094a(DateStyle.f15732j));
            User user = (User) PreferencesManager.m9595a(context).m9593a(User.class);
            ApplicationConfig.m9179a(user.getUser_id(), user.getToken());
            MessageLoginManager.m307a(str);
            PreferencesManager.m9595a(context).m9588a("IM_LOGIN_INFO", str);
            MessageParameters.f23953r = "com.cnlaunch.im.service.GoloMessageService";
            Intent intent = new Intent(context, GoloMessageService.class);
            intent.setAction("action_login");
            context.startService(intent);
            f9255a = true;
            MessageParameters.f23954s = true;
            C1673a m8965a = C1673a.m8965a();
            m8965a.m8964a("-------Login IM New:" + user.getUser_id() + "-------");
        } catch (Exception e) {
            e.printStackTrace();
            C1673a m8965a2 = C1673a.m8965a();
            m8965a2.m8964a("Login IM A Error:" + e.getMessage());
        }
        IMPresenter.m8804a(context).m8805a(40021);
        GoloDBManager m8756a = GoloDBManager.m8756a(context);
        QueryBuilder<MessageInfo> queryBuilder = m8756a.f9220b.f9228e.queryBuilder();
        queryBuilder.where(MessageInfoDao.Properties.User_id.m321eq("666666"), new WhereCondition[0]);
        queryBuilder.limit(1);
        List<MessageInfo> list = queryBuilder.list();
        if (list == null || list.size() <= 0) {
            MessageInfo messageInfo = new MessageInfo();
            messageInfo.f9276h = 0L;
            messageInfo.f9275g = "";
            messageInfo.f9273e = 0;
            messageInfo.f9270b = "666666";
            messageInfo.f9271c = m8756a.f9221c.getString(R.string.cheyunteam_name);
            m8756a.f9220b.f9228e.insert(messageInfo);
        }
    }

    /* renamed from: a */
    public static void m8731a(Context context) {
        try {
            Log.i("Sanda", "------>loginIM(old):" + DateUtils.m5094a(DateStyle.f15732j));
            String m9584b = PreferencesManager.m9595a(context).m9584b("IM_LOGIN_INFO", "");
            if (!TextUtils.isEmpty(m9584b)) {
                User user = (User) PreferencesManager.m9595a(context).m9593a(User.class);
                ApplicationConfig.m9179a(user.getUser_id(), user.getToken());
                MessageLoginManager.m307a(m9584b);
                MessageParameters.f23953r = "com.cnlaunch.im.service.GoloMessageService";
                Intent intent = new Intent(context, GoloMessageService.class);
                intent.setAction("action_login");
                context.startService(intent);
                f9255a = true;
                MessageParameters.f23954s = true;
                C1673a m8965a = C1673a.m8965a();
                m8965a.m8964a("-------Login IM Old:" + user.getUser_id() + "-------");
                return;
            }
            Log.e("Sanda", "loginIM failed");
            C1673a.m8965a().m8964a("-------Login IM Failed-------");
        } catch (Exception e) {
            e.printStackTrace();
            C1673a m8965a2 = C1673a.m8965a();
            m8965a2.m8964a("Login IM B Error:" + e.getMessage());
        }
    }

    /* renamed from: b */
    public static void m8728b(Context context) {
        try {
            Log.i("Sanda", "------>logoutIM:" + DateUtils.m5094a(DateStyle.f15732j));
            try {
                SharedPreferences.Editor edit = SharePreferenceMsgUtils.m248a().f24032a.edit();
                edit.remove("msg_login_content");
                edit.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            GoloCacheManager.m9177a().clear();
            XConnection.getInstance().UnregisterReceiver();
            XConnection.release();
            ReceiveTask.f23999c = false;
            GoloService.f23972b = false;
            GoloService.f23973c = 0;
            context.stopService(new Intent(context, GoloMessageService.class));
            f9255a = false;
            MessageParameters.f23954s = false;
            C1673a.m8965a().m8964a("-------LogOut IM-------");
        } catch (Exception e2) {
            e2.printStackTrace();
            C1673a m8965a = C1673a.m8965a();
            m8965a.m8964a("logoutIM Error:" + e2.getMessage());
        }
    }

    /* renamed from: a */
    public static boolean m8732a() {
        return f9255a;
    }
}
