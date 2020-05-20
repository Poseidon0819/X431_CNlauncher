package com.cnlaunch.x431pro.utils.p286f;

import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconUtils.java */
/* renamed from: com.cnlaunch.x431pro.utils.f.i */
/* loaded from: classes.dex */
public final class C2772i implements Comparator<CarIcon> {

    /* renamed from: a */
    final /* synthetic */ CarIconUtils f15892a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2772i(CarIconUtils carIconUtils) {
        this.f15892a = carIconUtils;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(CarIcon carIcon, CarIcon carIcon2) {
        return carIcon.f15783g.compareTo(carIcon2.f15783g);
    }
}
