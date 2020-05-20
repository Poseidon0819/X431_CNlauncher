package com.cnlaunch.x431pro.widget.p290a;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputReportInfoDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.av */
/* loaded from: classes.dex */
public final class C2821av implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ InputReportInfoDialog f16195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2821av(InputReportInfoDialog inputReportInfoDialog) {
        this.f16195a = inputReportInfoDialog;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Button button;
        if (i == 6) {
            ((InputMethodManager) textView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            InputReportInfoDialog inputReportInfoDialog = this.f16195a;
            button = inputReportInfoDialog.f16177k;
            inputReportInfoDialog.onClick(button);
            return true;
        }
        return false;
    }
}
