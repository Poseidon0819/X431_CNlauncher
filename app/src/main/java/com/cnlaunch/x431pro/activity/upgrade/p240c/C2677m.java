package com.cnlaunch.x431pro.activity.upgrade.p240c;

import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.m */
/* loaded from: classes.dex */
public final class C2677m implements Comparator {

    /* renamed from: a */
    final /* synthetic */ DownloadLogic f15343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2677m(DownloadLogic downloadLogic) {
        this.f15343a = downloadLogic;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) obj;
        X431PadDtoSoft x431PadDtoSoft2 = (X431PadDtoSoft) obj2;
        if (!x431PadDtoSoft.isMust() || x431PadDtoSoft2.isMust()) {
            return (x431PadDtoSoft.isMust() || !x431PadDtoSoft2.isMust()) ? 0 : 1;
        }
        return -1;
    }
}
