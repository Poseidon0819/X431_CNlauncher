package com.cnlaunch.physics;

import java.io.File;

/* renamed from: com.cnlaunch.physics.b */
/* loaded from: classes.dex */
public final class DPUDownloadbinVersionManager {

    /* renamed from: c */
    private static DPUDownloadbinVersionManager f9802c;

    /* renamed from: a */
    private String f9803a;

    /* renamed from: b */
    private PropertyFileOperation f9804b;

    /* renamed from: a */
    public static DPUDownloadbinVersionManager m8384a(String str) {
        if (f9802c == null) {
            f9802c = new DPUDownloadbinVersionManager(str);
        }
        return f9802c;
    }

    private DPUDownloadbinVersionManager(String str) {
        this.f9803a = str + File.separator + "dpu_downloadbin_information.txt";
        this.f9804b = new PropertyFileOperation(this.f9803a);
    }

    /* renamed from: b */
    public final String m8382b(String str) {
        if (DeviceFactoryManager.m8305a().m8275g()) {
            return "V99.99";
        }
        String m8090a = this.f9804b.m8090a(str);
        return m8090a == null ? "" : m8090a;
    }

    /* renamed from: a */
    public final void m8383a(String str, String str2) {
        if (DeviceFactoryManager.m8305a().m8275g() || str2 == null) {
            return;
        }
        this.f9804b.m8089a(str, str2);
    }
}
