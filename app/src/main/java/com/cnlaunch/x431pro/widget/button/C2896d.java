package com.cnlaunch.x431pro.widget.button;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.widget.button.DynamicButtonGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DynamicButtonGroup.java */
/* renamed from: com.cnlaunch.x431pro.widget.button.d */
/* loaded from: classes.dex */
public final class C2896d implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ DynamicButtonGroup f16545a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2896d(DynamicButtonGroup dynamicButtonGroup) {
        this.f16545a = dynamicButtonGroup;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        DynamicButtonGroup.InterfaceC2888b interfaceC2888b;
        DynamicButtonGroup.InterfaceC2888b interfaceC2888b2;
        interfaceC2888b = this.f16545a.f16515v;
        if (interfaceC2888b != null) {
            interfaceC2888b2 = this.f16545a.f16515v;
            interfaceC2888b2.mo4501a((int) j);
        }
        this.f16545a.m4508b();
    }
}
