package com.cnlaunch.x431pro.activity.diagnose.p221d;

import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.widget.button.DynamicButtonGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpeciaFunctionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.cd */
/* loaded from: classes.dex */
public final class C2162cd implements DynamicButtonGroup.InterfaceC2888b {

    /* renamed from: a */
    final /* synthetic */ SpeciaFunctionFragment f12236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2162cd(SpeciaFunctionFragment speciaFunctionFragment) {
        this.f12236a = speciaFunctionFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.button.DynamicButtonGroup.InterfaceC2888b
    /* renamed from: a */
    public final void mo4501a(int i) {
        boolean z;
        if (this.f12236a.f12357d.mo7083i().getDiagnoseStatue() == 0) {
            return;
        }
        z = this.f12236a.f12195I;
        if (z) {
            return;
        }
        SpeciaFunctionFragment.m7157n(this.f12236a);
        this.f12236a.f12357d.mo7082j();
        this.f12236a.f12218v = i;
        this.f12236a.f12357d.mo7093a(DiagnoseConstants.FEEDBACK_SPECIA_FUNCTION, ByteHexHelper.intToTwoHexString(i), 3);
        SpeciaFunctionFragment.m7156o(this.f12236a);
    }
}
