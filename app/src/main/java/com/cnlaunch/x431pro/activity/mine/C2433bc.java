package com.cnlaunch.x431pro.activity.mine;

import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderDTO;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyOrderFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bc */
/* loaded from: classes.dex */
public final class C2433bc implements Comparator {

    /* renamed from: a */
    final /* synthetic */ MyOrderFragment f13911a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2433bc(MyOrderFragment myOrderFragment) {
        this.f13911a = myOrderFragment;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((UserOrderDTO) obj2).getOrdertime().compareTo(((UserOrderDTO) obj).getOrdertime());
    }
}
