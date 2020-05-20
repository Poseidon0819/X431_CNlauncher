package com.mopub.mraid;

import android.content.Context;
import android.content.DialogInterface;
import com.mopub.mraid.MraidNativeCommandHandler;

/* compiled from: MraidNativeCommandHandler.java */
/* renamed from: com.mopub.mraid.x */
/* loaded from: classes.dex */
final class DialogInterface$OnClickListenerC3837x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f20732a;

    /* renamed from: b */
    final /* synthetic */ String f20733b;

    /* renamed from: c */
    final /* synthetic */ MraidNativeCommandHandler.InterfaceC3811c f20734c;

    /* renamed from: d */
    final /* synthetic */ MraidNativeCommandHandler f20735d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterface$OnClickListenerC3837x(MraidNativeCommandHandler mraidNativeCommandHandler, Context context, String str, MraidNativeCommandHandler.InterfaceC3811c interfaceC3811c) {
        this.f20735d = mraidNativeCommandHandler;
        this.f20732a = context;
        this.f20733b = str;
        this.f20734c = interfaceC3811c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f20735d.m2220a(this.f20732a, this.f20733b, this.f20734c);
    }
}
