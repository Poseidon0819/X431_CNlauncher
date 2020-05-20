package com.cnlaunch.x431pro.activity.login;

import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

/* compiled from: ActivateJointActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.c */
/* loaded from: classes.dex */
final class C2355c implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ActivateJointActivity f13464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2355c(ActivateJointActivity activateJointActivity) {
        this.f13464a = activateJointActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Button button;
        if (i == 6) {
            button = this.f13464a.f13000aa;
            button.performClick();
            return true;
        }
        return false;
    }
}
