package com.cnlaunch.x431pro.utils.p286f;

import com.cnlaunch.x431pro.utils.p283db.CarVersion;
import java.util.Comparator;

/* compiled from: CarIconUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.f.j */
/* loaded from: classes.dex */
public final class C2773j implements Comparator<CarVersion> {

    /* renamed from: a */
    final /* synthetic */ CarIconUtils f15893a;

    public C2773j(CarIconUtils carIconUtils) {
        this.f15893a = carIconUtils;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(CarVersion carVersion, CarVersion carVersion2) {
        return carVersion2.f15828d.compareTo(carVersion.f15828d);
    }
}
