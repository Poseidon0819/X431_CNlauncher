package com.cnlaunch.p169im.p172c;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: SearchFriendFragment.java */
/* renamed from: com.cnlaunch.im.c.v */
/* loaded from: classes.dex */
final class View$OnFocusChangeListenerC1726v implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ SearchFriendFragment f9173a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnFocusChangeListenerC1726v(SearchFriendFragment searchFriendFragment) {
        this.f9173a = searchFriendFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        if (z) {
            return;
        }
        ((InputMethodManager) this.f9173a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
