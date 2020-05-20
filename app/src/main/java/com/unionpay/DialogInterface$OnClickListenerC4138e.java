package com.unionpay;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.e */
/* loaded from: classes2.dex */
public final class DialogInterface$OnClickListenerC4138e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f22082a;

    /* renamed from: b */
    final /* synthetic */ String f22083b;

    /* renamed from: c */
    final /* synthetic */ String f22084c;

    /* renamed from: d */
    final /* synthetic */ String f22085d;

    /* renamed from: e */
    final /* synthetic */ String f22086e;

    /* renamed from: f */
    final /* synthetic */ String f22087f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC4138e(Context context, String str, String str2, String str3, String str4, String str5) {
        this.f22082a = context;
        this.f22083b = str;
        this.f22084c = str2;
        this.f22085d = str3;
        this.f22086e = str4;
        this.f22087f = str5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        UPPayAssistEx.m1685a(this.f22082a, this.f22083b, this.f22084c, this.f22085d, this.f22086e, this.f22087f);
    }
}
