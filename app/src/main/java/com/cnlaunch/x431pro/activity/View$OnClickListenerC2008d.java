package com.cnlaunch.x431pro.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.d */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2008d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ActivityC2004c f11011a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2008d(ActivityC2004c activityC2004c) {
        this.f11011a = activityC2004c;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f11011a.f10981q.getSystemService("input_method");
        if (((Activity) this.f11011a.f10981q).getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(((Activity) this.f11011a.f10981q).getCurrentFocus().getWindowToken(), 2);
        }
        this.f11011a.m7732g().m4418b();
    }
}
