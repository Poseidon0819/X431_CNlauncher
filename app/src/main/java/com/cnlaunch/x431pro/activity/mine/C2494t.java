package com.cnlaunch.x431pro.activity.mine;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/* compiled from: ConnectorActivateFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.t */
/* loaded from: classes.dex */
final class C2494t implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ConnectorActivateFragment f14313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2494t(ConnectorActivateFragment connectorActivateFragment) {
        this.f14313a = connectorActivateFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            ((InputMethodManager) textView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            this.f14313a.m6099c();
            return true;
        }
        return false;
    }
}
