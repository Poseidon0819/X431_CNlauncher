package com.cnlaunch.x431pro.activity.mine;

import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderDTO;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyOrderFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bd */
/* loaded from: classes.dex */
public final class C2434bd implements Comparator {

    /* renamed from: a */
    final /* synthetic */ MyOrderFragment f13912a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2434bd(MyOrderFragment myOrderFragment) {
        this.f13912a = myOrderFragment;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((UserOrderDTO) obj2).getPaytime().compareTo(((UserOrderDTO) obj).getPaytime());
    }
}
