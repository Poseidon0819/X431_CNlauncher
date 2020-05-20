package com.cnlaunch.x431pro.activity.mine;

import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

/* compiled from: ModifyPasswordFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.at */
/* loaded from: classes.dex */
final class C2408at implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ModifyPasswordFragment f13693a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2408at(ModifyPasswordFragment modifyPasswordFragment) {
        this.f13693a = modifyPasswordFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            ((InputMethodManager) textView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            ModifyPasswordFragment.m6438n(this.f13693a);
            return true;
        }
        return false;
    }
}
