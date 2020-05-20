package com.cnlaunch.x431pro.activity.upgrade.p240c;

import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadLogic.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.c.l */
/* loaded from: classes.dex */
public final class C2676l implements Comparator {

    /* renamed from: a */
    final /* synthetic */ DownloadLogic f15342a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2676l(DownloadLogic downloadLogic) {
        this.f15342a = downloadLogic;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        X431PadDtoSoft x431PadDtoSoft = (X431PadDtoSoft) obj;
        X431PadDtoSoft x431PadDtoSoft2 = (X431PadDtoSoft) obj2;
        if (2 == x431PadDtoSoft.getType()) {
            return -1;
        }
        if (2 == x431PadDtoSoft2.getType()) {
            return 1;
        }
        if (1 != x431PadDtoSoft.getType() || 1 == x431PadDtoSoft2.getType()) {
            return (1 == x431PadDtoSoft.getType() || 1 != x431PadDtoSoft2.getType()) ? 0 : 1;
        }
        return -1;
    }
}
