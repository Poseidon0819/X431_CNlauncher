package com.cnlaunch.physics.wifi.p209b;

import android.content.Context;

/* renamed from: com.cnlaunch.physics.wifi.b.b */
/* loaded from: classes.dex */
public class WiFiControlManager extends BaseWiFiManager {

    /* renamed from: e */
    private static WiFiControlManager f10221e;

    private WiFiControlManager(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static WiFiControlManager m8038a(Context context) {
        if (f10221e == null) {
            synchronized (WiFiControlManager.class) {
                if (f10221e == null) {
                    f10221e = new WiFiControlManager(context);
                }
            }
        }
        return f10221e;
    }
}
