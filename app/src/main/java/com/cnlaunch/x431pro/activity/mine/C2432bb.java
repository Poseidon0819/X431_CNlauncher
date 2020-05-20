package com.cnlaunch.x431pro.activity.mine;

import com.cnlaunch.x431pro.module.p255e.p257b.CardConsumeDTO;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyOrderFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bb */
/* loaded from: classes.dex */
public final class C2432bb implements Comparator {

    /* renamed from: a */
    final /* synthetic */ MyOrderFragment f13910a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2432bb(MyOrderFragment myOrderFragment) {
        this.f13910a = myOrderFragment;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((CardConsumeDTO) obj2).getUpdateDate().compareTo(((CardConsumeDTO) obj).getUpdateDate());
    }
}
