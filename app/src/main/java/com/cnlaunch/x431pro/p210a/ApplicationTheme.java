package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.a.a */
/* loaded from: classes.dex */
public final class ApplicationTheme {
    /* renamed from: a */
    public static int m7977a(int i) {
        switch (i) {
            case 1:
                return 2131755282;
            case 2:
                return 2131755283;
            case 3:
                return 2131755287;
            default:
                return R.style.LaunchTheme;
        }
    }

    /* renamed from: b */
    private static int m7975b(int i) {
        switch (i) {
            case 1:
                return 2131755285;
            case 2:
                return 2131755285;
            case 3:
                return 2131755286;
            default:
                return 2131755284;
        }
    }

    /* renamed from: a */
    public static int m7976a(Context context) {
        switch (PreferencesManager.m9595a(context).m9585b("theme_type", 0)) {
            case 1:
                return R.layout.layout_slidingmenu_blue;
            case 2:
                return R.layout.layout_slidingmenu_blue;
            default:
                return R.layout.layout_slidingmenu_default;
        }
    }

    /* renamed from: b */
    public static void m7974b(Context context) {
        context.setTheme(m7977a(PreferencesManager.m9595a(context).m9585b("theme_type", 0)));
    }

    /* renamed from: c */
    public static void m7973c(Context context) {
        context.setTheme(m7975b(PreferencesManager.m9595a(context).m9585b("theme_type", 0)));
    }

    /* renamed from: d */
    public static int m7972d(Context context) {
        switch (PreferencesManager.m9595a(context).m9585b("theme_type", 0)) {
            case 1:
                return R.color.red;
            case 2:
                return R.color.blue_violet;
            case 3:
                return R.color.glossy_green;
            default:
                return R.color.red;
        }
    }
}
