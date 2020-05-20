package com.cnlaunch.x431pro.activity.setting.p234a;

import android.widget.CompoundButton;
import com.cnlaunch.x431pro.activity.setting.OneKeyFeedbackFragment;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;

/* compiled from: OneKeyFeedbackAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.a.c */
/* loaded from: classes.dex */
final class C2517c implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ DiagnoseLogInfoSearchUtil.C2749a f14536a;

    /* renamed from: b */
    final /* synthetic */ OneKeyFeedbackAdapter f14537b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2517c(OneKeyFeedbackAdapter oneKeyFeedbackAdapter, DiagnoseLogInfoSearchUtil.C2749a c2749a) {
        this.f14537b = oneKeyFeedbackAdapter;
        this.f14536a = c2749a;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        OneKeyFeedbackFragment oneKeyFeedbackFragment;
        this.f14536a.setChecked(z);
        oneKeyFeedbackFragment = this.f14537b.f14530e;
        oneKeyFeedbackFragment.selectAllChanged();
    }
}
