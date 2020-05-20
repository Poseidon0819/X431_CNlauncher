package com.cnlaunch.physics;

import android.util.Pair;
import com.cnlaunch.physics.p197c.DPUHardwareInfo;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.physics.c */
/* loaded from: classes.dex */
public final class DPUHardwareInformation {

    /* renamed from: a */
    private static DPUHardwareInformation f9836a;

    /* renamed from: b */
    private String f9837b;

    /* renamed from: c */
    private PropertyFileOperation f9838c;

    /* renamed from: d */
    private DPUHardwareInfo f9839d = new DPUHardwareInfo();

    /* renamed from: a */
    public static DPUHardwareInformation m8315a(String str) {
        if (f9836a == null) {
            f9836a = new DPUHardwareInformation(str);
        }
        return f9836a;
    }

    private DPUHardwareInformation(String str) {
        this.f9837b = str + File.separator + "dpu_hardware_information.ini";
        this.f9838c = new PropertyFileOperation(this.f9837b);
        this.f9839d.f9855f = this.f9838c.m8090a(DPUHardwareInfo.f9850a);
        this.f9839d.f9856g = this.f9838c.m8090a(DPUHardwareInfo.f9851b);
        this.f9839d.f9857h = this.f9838c.m8090a(DPUHardwareInfo.f9852c);
        this.f9839d.f9858i = this.f9838c.m8090a(DPUHardwareInfo.f9853d);
        this.f9839d.f9859j = this.f9838c.m8090a(DPUHardwareInfo.f9854e);
    }

    /* renamed from: a */
    public final void m8316a(DPUHardwareInfo dPUHardwareInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(DPUHardwareInfo.f9850a, dPUHardwareInfo.f9855f));
        arrayList.add(new Pair(DPUHardwareInfo.f9851b, dPUHardwareInfo.f9856g));
        arrayList.add(new Pair(DPUHardwareInfo.f9852c, dPUHardwareInfo.f9857h));
        arrayList.add(new Pair(DPUHardwareInfo.f9853d, dPUHardwareInfo.f9858i));
        arrayList.add(new Pair(DPUHardwareInfo.f9854e, dPUHardwareInfo.f9859j));
        this.f9838c.m8088a(arrayList);
        this.f9839d.f9855f = this.f9838c.m8090a(DPUHardwareInfo.f9850a);
        this.f9839d.f9856g = this.f9838c.m8090a(DPUHardwareInfo.f9851b);
        this.f9839d.f9857h = this.f9838c.m8090a(DPUHardwareInfo.f9852c);
        this.f9839d.f9858i = this.f9838c.m8090a(DPUHardwareInfo.f9853d);
        this.f9839d.f9859j = this.f9838c.m8090a(DPUHardwareInfo.f9854e);
    }
}
