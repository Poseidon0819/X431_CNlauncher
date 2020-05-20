package com.cnlaunch.x431pro.utils.p286f;

import com.cnlaunch.x431pro.utils.p283db.CarVersion;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.f.e */
/* loaded from: classes.dex */
public final class C2768e implements Comparator<CarVersion> {

    /* renamed from: a */
    final /* synthetic */ CarIconUtils f15888a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2768e(CarIconUtils carIconUtils) {
        this.f15888a = carIconUtils;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(CarVersion carVersion, CarVersion carVersion2) {
        return carVersion2.f15828d.compareTo(carVersion.f15828d);
    }
}
