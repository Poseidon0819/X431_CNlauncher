package com.cnlaunch.p169im.p172c;

import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import com.cnlaunch.x431pro.widget.ClearEditText;

/* compiled from: SearchFriendFragment.java */
/* renamed from: com.cnlaunch.im.c.w */
/* loaded from: classes.dex */
final class View$OnClickListenerC1727w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SearchFriendFragment f9174a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1727w(SearchFriendFragment searchFriendFragment) {
        this.f9174a = searchFriendFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ClearEditText clearEditText;
        ProgressBar progressBar;
        String str;
        String str2;
        String str3;
        SearchFriendFragment searchFriendFragment = this.f9174a;
        clearEditText = searchFriendFragment.f9166j;
        searchFriendFragment.f9161e = clearEditText.getText().toString();
        progressBar = this.f9174a.f9167k;
        progressBar.setVisibility(0);
        str = this.f9174a.f9161e;
        if (TextUtils.isDigitsOnly(str)) {
            str2 = this.f9174a.f9161e;
            if (str2.length() == 12) {
                SearchFriendFragment searchFriendFragment2 = this.f9174a;
                str3 = searchFriendFragment2.f9161e;
                searchFriendFragment2.f9162f = str3;
                this.f9174a.request(40033);
                ((InputMethodManager) this.f9174a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
        this.f9174a.f9162f = "";
        this.f9174a.request(40022);
        ((InputMethodManager) this.f9174a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
