package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnLineProgrammingDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bm */
/* loaded from: classes.dex */
public final class C2831bm implements LoginFunction.InterfaceC2302b {

    /* renamed from: a */
    final /* synthetic */ OnLineProgrammingDialog f16318a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2831bm(OnLineProgrammingDialog onLineProgrammingDialog) {
        this.f16318a = onLineProgrammingDialog;
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2302b
    /* renamed from: a */
    public final void mo4628a() {
        LoginFunction.InterfaceC2302b interfaceC2302b;
        Map map;
        IFragmentCallback iFragmentCallback;
        interfaceC2302b = this.f16318a.f16289B;
        LoginFunction.m6579b(interfaceC2302b);
        Context context = this.f16318a.f16297k;
        map = this.f16318a.f16309w;
        boolean z = this.f16318a.f16288A;
        iFragmentCallback = this.f16318a.f16290a;
        new OnLineProgrammingDialog(context, 2, map, z, iFragmentCallback).show();
    }
}
