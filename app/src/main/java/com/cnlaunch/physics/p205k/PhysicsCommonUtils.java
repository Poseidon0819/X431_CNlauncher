package com.cnlaunch.physics.p205k;

import android.content.Context;
import com.cnlaunch.p120d.ConfigPropertiesOperation;

/* renamed from: com.cnlaunch.physics.k.p */
/* loaded from: classes.dex */
public final class PhysicsCommonUtils {
    /* renamed from: a */
    public static String m8115a(Context context, String str) {
        String property;
        ConfigPropertiesOperation m9582a = ConfigPropertiesOperation.m9582a(context);
        return (m9582a.f6740a == null || (property = m9582a.f6740a.getProperty(str)) == null) ? "" : property;
    }

    /* renamed from: a */
    public static String m8116a(Context context) {
        try {
            return "V".concat(String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
