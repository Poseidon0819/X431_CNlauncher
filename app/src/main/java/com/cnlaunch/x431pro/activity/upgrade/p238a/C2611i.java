package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.widget.CompoundButton;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;

/* compiled from: ExpiredAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.i */
/* loaded from: classes.dex */
final class C2611i implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ X431PadDtoSoft f15028a;

    /* renamed from: b */
    final /* synthetic */ ExpiredAdapter f15029b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2611i(ExpiredAdapter expiredAdapter, X431PadDtoSoft x431PadDtoSoft) {
        this.f15029b = expiredAdapter;
        this.f15028a = x431PadDtoSoft;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f15028a.setChecked(z);
        this.f15029b.f15036d.mo4708a();
    }
}
