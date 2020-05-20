package com.cnlaunch.x431pro.activity.login;

import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

/* compiled from: LoginActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.w */
/* loaded from: classes.dex */
final class C2380w implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f13536a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2380w(LoginActivity loginActivity) {
        this.f13536a = loginActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Button button;
        if (i == 6) {
            button = this.f13536a.f13091h;
            button.performClick();
            return true;
        }
        return false;
    }
}
