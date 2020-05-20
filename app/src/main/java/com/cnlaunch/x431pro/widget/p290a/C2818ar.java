package com.cnlaunch.x431pro.widget.p290a;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputIccidDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.ar */
/* loaded from: classes.dex */
public final class C2818ar implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ InputIccidDialog f16163a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2818ar(InputIccidDialog inputIccidDialog) {
        this.f16163a = inputIccidDialog;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            this.f16163a.m4699b();
            return true;
        }
        return false;
    }
}
