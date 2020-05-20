package com.cnlaunch.wifiprinter;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.y */
/* loaded from: classes.dex */
final class C1941y implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FragmentC1934u f10540a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1941y(FragmentC1934u fragmentC1934u) {
        this.f10540a = fragmentC1934u;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            ((InputMethodManager) textView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            this.f10540a.m7986a();
            return true;
        }
        return false;
    }
}
