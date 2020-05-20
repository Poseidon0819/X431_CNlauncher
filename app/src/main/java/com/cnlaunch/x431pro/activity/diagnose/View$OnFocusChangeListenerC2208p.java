package com.cnlaunch.x431pro.activity.diagnose;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.p */
/* loaded from: classes.dex */
public final class View$OnFocusChangeListenerC2208p implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnFocusChangeListenerC2208p(CarIconFragmentForAll carIconFragmentForAll) {
        this.f12482a = carIconFragmentForAll;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            return;
        }
        ((InputMethodManager) this.f12482a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
