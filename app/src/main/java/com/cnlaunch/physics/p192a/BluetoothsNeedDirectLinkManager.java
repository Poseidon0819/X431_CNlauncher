package com.cnlaunch.physics.p192a;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.physics.a.g */
/* loaded from: classes.dex */
public final class BluetoothsNeedDirectLinkManager {

    /* renamed from: b */
    private static BluetoothsNeedDirectLinkManager f9800b;

    /* renamed from: a */
    private Map<String, Boolean> f9801a = new HashMap();

    /* renamed from: a */
    public static BluetoothsNeedDirectLinkManager m8387a() {
        if (f9800b == null) {
            f9800b = new BluetoothsNeedDirectLinkManager();
        }
        return f9800b;
    }

    /* renamed from: a */
    public final void m8385a(String str, boolean z) {
        this.f9801a.put(str, Boolean.valueOf(z));
    }

    /* renamed from: a */
    public final boolean m8386a(String str) {
        Boolean bool = this.f9801a.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
