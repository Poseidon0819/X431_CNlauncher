package com.cnlaunch.wifiprinter;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.al */
/* loaded from: classes.dex */
final class C1893al implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ PrinterLinkLocalNet f10397a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1893al(PrinterLinkLocalNet printerLinkLocalNet) {
        this.f10397a = printerLinkLocalNet;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            ((InputMethodManager) textView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            try {
                this.f10397a.m8032a();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return false;
    }
}
