package com.cnlaunch.physics.p195b.p196a;

import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.Tools;

/* renamed from: com.cnlaunch.physics.b.a.e */
/* loaded from: classes.dex */
public class MyFactory {

    /* renamed from: a */
    private static final String f9823a = "e";

    /* renamed from: a */
    public static OrderMontage m8342a() {
        C1856n.m8130a(f9823a, "creatorForOrderMontage enter.");
        if (Tools.m8114a() && !Tools.m8101b()) {
            return OrderMontageForHD.m8317k();
        }
        return OrderMontageForCar.m8340k();
    }

    /* renamed from: b */
    public static Analysis m8341b() {
        C1856n.m8130a(f9823a, "creatorForAnalysis enter.");
        if (Tools.m8114a() && !Tools.m8101b()) {
            return AnalysisForHD.m8360a();
        }
        return AnalysisForCar.m8361a();
    }
}
