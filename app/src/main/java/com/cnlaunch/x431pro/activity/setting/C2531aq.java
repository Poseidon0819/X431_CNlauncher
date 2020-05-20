package com.cnlaunch.x431pro.activity.setting;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/* compiled from: PrintEditInfoFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.aq */
/* loaded from: classes.dex */
final class C2531aq implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ PrintEditInfoFragment f14624a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2531aq(PrintEditInfoFragment printEditInfoFragment) {
        this.f14624a = printEditInfoFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            ((InputMethodManager) textView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            this.f14624a.m5988c();
            return true;
        }
        return false;
    }
}
