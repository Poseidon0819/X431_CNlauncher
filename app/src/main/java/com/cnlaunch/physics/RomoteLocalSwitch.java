package com.cnlaunch.physics;

import com.cnlaunch.physics.p202h.IRemoteDeviceFactoryManagerCallBack;
import com.cnlaunch.physics.p205k.C1856n;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.physics.o */
/* loaded from: classes.dex */
public final class RomoteLocalSwitch {

    /* renamed from: c */
    private static RomoteLocalSwitch f10148c;

    /* renamed from: a */
    public boolean f10149a = false;

    /* renamed from: b */
    public Map<String, C1859a> f10150b = new HashMap();

    /* compiled from: RomoteLocalSwitch.java */
    /* renamed from: com.cnlaunch.physics.o$a */
    /* loaded from: classes.dex */
    public static class C1859a {

        /* renamed from: a */
        public IRemoteDeviceFactoryManagerCallBack f10151a = null;

        /* renamed from: b */
        public boolean f10152b = false;

        /* renamed from: c */
        public boolean f10153c = false;
    }

    /* renamed from: a */
    public static RomoteLocalSwitch m8086a() {
        if (f10148c == null) {
            f10148c = new RomoteLocalSwitch();
        }
        return f10148c;
    }

    /* renamed from: a */
    public final void m8085a(boolean z) {
        if (C1856n.f10135a) {
            C1856n.m8130a("RomoteLocalSwitch", "current is remote mode ".concat(String.valueOf(z)));
        }
        this.f10149a = z;
    }
}
