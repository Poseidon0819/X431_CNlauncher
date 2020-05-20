package com.cnlaunch.physics;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.cnlaunch.p120d.p130d.SystemPropertiesInvoke;

/* renamed from: com.cnlaunch.physics.l */
/* loaded from: classes.dex */
public class PAD3DHCPForDoIP {

    /* renamed from: a */
    public static final String f10141a = "l";

    /* renamed from: b */
    Context f10142b;

    /* renamed from: d */
    BroadcastReceiver f10144d = new C1858m(this);

    /* renamed from: c */
    boolean f10143c = SystemPropertiesInvoke.m9431a("ro.support_lan_dhcp");

    public PAD3DHCPForDoIP(Context context) {
        this.f10142b = context;
    }
}
