package com.cnlaunch.p169im.p172c;

import android.content.Context;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.cnlaunch.x431pro.module.golo.model.AddFriendInfo;
import com.cnlaunch.x431pro.widget.p290a.InputDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: SearchFriendFragment.java */
/* renamed from: com.cnlaunch.im.c.z */
/* loaded from: classes.dex */
final class DialogC1730z extends InputDialog {

    /* renamed from: a */
    final /* synthetic */ AddFriendInfo f9177a;

    /* renamed from: b */
    final /* synthetic */ SearchFriendFragment f9178b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC1730z(SearchFriendFragment searchFriendFragment, Context context, String str, String str2, AddFriendInfo addFriendInfo) {
        super(context, str, str2);
        this.f9178b = searchFriendFragment;
        this.f9177a = addFriendInfo;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: a */
    public final void mo4705a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            SearchFriendFragment searchFriendFragment = this.f9178b;
            String user_id = this.f9177a.getUser_id();
            String name = this.f9177a.getName();
            SearchFriendFragment searchFriendFragment2 = this.f9178b;
            str2 = searchFriendFragment2.f9160d;
            SearchFriendFragment.m8815a(searchFriendFragment, user_id, name, searchFriendFragment2.getString(R.string.input_your_verification_default, new Object[]{str2}));
        } else {
            SearchFriendFragment.m8815a(this.f9178b, this.f9177a.getUser_id(), this.f9177a.getName(), str);
        }
        ((InputMethodManager) this.f9178b.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: e_ */
    public final void mo4701e_() {
        ((InputMethodManager) this.f9178b.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}
