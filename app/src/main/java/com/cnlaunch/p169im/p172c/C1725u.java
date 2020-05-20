package com.cnlaunch.p169im.p172c;

import com.cnlaunch.x431pro.activity.golo.others.GoloTextWatcher;
import com.cnlaunch.x431pro.widget.ClearEditText;

/* compiled from: SearchFriendFragment.java */
/* renamed from: com.cnlaunch.im.c.u */
/* loaded from: classes.dex */
final class C1725u extends GoloTextWatcher {

    /* renamed from: a */
    final /* synthetic */ SearchFriendFragment f9172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1725u(SearchFriendFragment searchFriendFragment) {
        this.f9172a = searchFriendFragment;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        ClearEditText clearEditText;
        SearchFriendFragment searchFriendFragment = this.f9172a;
        clearEditText = searchFriendFragment.f9166j;
        SearchFriendFragment.m8816a(searchFriendFragment, clearEditText.getText().toString());
    }
}
