package com.cnlaunch.x431pro.activity.diagnose.p221d;

import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.widget.button.DynamicButtonGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpeciaFunctionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.cc */
/* loaded from: classes.dex */
public final class C2161cc implements DynamicButtonGroup.InterfaceC2889c {

    /* renamed from: a */
    final /* synthetic */ SpeciaFunctionFragment f12235a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2161cc(SpeciaFunctionFragment speciaFunctionFragment) {
        this.f12235a = speciaFunctionFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.button.DynamicButtonGroup.InterfaceC2889c
    /* renamed from: a */
    public final void mo4500a(int i, int i2) {
        int i3;
        String str;
        DynamicButtonGroup dynamicButtonGroup;
        DynamicButtonGroup dynamicButtonGroup2;
        if (this.f12235a.f12357d.mo7083i().getDiagnoseStatue() == 0) {
            return;
        }
        if (i2 == 1) {
            dynamicButtonGroup = this.f12235a.f12202P;
            if (dynamicButtonGroup != null) {
                dynamicButtonGroup2 = this.f12235a.f12202P;
                dynamicButtonGroup2.m4508b();
            }
            i3 = 0;
        } else {
            i3 = 1;
        }
        IFragmentCallback iFragmentCallback = this.f12235a.f12357d;
        str = this.f12235a.f12216t;
        iFragmentCallback.mo7099a(Integer.parseInt(str), new byte[]{1, (byte) ((i >> 8) & 255), (byte) (i & 255), (byte) (i3 & 255)});
    }
}
