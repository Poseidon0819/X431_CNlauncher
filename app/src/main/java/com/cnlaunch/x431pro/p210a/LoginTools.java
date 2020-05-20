package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import android.content.Intent;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.login.LoginActivity;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.a.l */
/* loaded from: classes.dex */
public final class LoginTools {
    /* renamed from: a */
    public static boolean m7946a(Context context) {
        return PreferencesManager.m9595a(context).m9584b("login_state", "0").equals("1");
    }

    /* renamed from: a */
    public static boolean m7945a(Context context, int i) {
        boolean m7946a = m7946a(context);
        if (!m7946a) {
            if (i == 1) {
                m7944b(context);
            } else if (i == 0) {
                NToast.m9450a(context, (int) R.string.login_tip);
            } else if (i == 2) {
                NToast.m9450a(context, (int) R.string.login_tip);
                m7944b(context);
            }
        }
        return m7946a;
    }

    /* renamed from: b */
    private static void m7944b(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(67108864);
        context.startActivity(intent);
    }
}
