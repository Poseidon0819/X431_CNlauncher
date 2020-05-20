package com.cnlaunch.p120d;

import android.content.Context;

/* renamed from: com.cnlaunch.d.b */
/* loaded from: classes.dex */
public final class ConfigPropertiesOperation extends AssertPropertyFileOperation {

    /* renamed from: b */
    private static ConfigPropertiesOperation f7026b;

    /* renamed from: a */
    public static ConfigPropertiesOperation m9582a(Context context) {
        if (f7026b == null) {
            f7026b = new ConfigPropertiesOperation(context);
        }
        return f7026b;
    }

    private ConfigPropertiesOperation(Context context) {
        super(context, "config.properties");
    }
}
