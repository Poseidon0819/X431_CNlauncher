package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.widget.CompoundButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseDiagnoseFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.o */
/* loaded from: classes.dex */
public final class C2177o implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ BaseDiagnoseFragment f12365a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2177o(BaseDiagnoseFragment baseDiagnoseFragment) {
        this.f12365a = baseDiagnoseFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f12365a.f12357d.mo7086c(this.f12365a.mo7100c());
        }
    }
}
