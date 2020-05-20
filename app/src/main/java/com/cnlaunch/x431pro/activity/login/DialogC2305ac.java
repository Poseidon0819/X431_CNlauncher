package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import com.cnlaunch.x431pro.module.p272k.p274b.ZipcodeInfoResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginFunction.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ac */
/* loaded from: classes.dex */
public final class DialogC2305ac extends ZipcodeInputDialog {

    /* renamed from: a */
    final /* synthetic */ LoginFunction f13409a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2305ac(LoginFunction loginFunction, Context context, ZipcodeInfoResponse zipcodeInfoResponse) {
        super(context, zipcodeInfoResponse);
        this.f13409a = loginFunction;
    }

    @Override // com.cnlaunch.x431pro.activity.login.ZipcodeInputDialog
    /* renamed from: a */
    public final void mo6541a(String str) {
        this.f13409a.f13368E = str;
        this.f13409a.m6553a(509);
    }
}
