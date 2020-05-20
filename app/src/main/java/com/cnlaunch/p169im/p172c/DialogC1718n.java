package com.cnlaunch.p169im.p172c;

import android.content.Context;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.cnlaunch.x431pro.activity.golo.others.GoloTools;
import com.cnlaunch.x431pro.module.golo.model.AddFriendInfo;
import com.cnlaunch.x431pro.widget.p290a.InputDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: ProMessageFragment.java */
/* renamed from: com.cnlaunch.im.c.n */
/* loaded from: classes.dex */
final class DialogC1718n extends InputDialog {

    /* renamed from: a */
    final /* synthetic */ AddFriendInfo f9149a;

    /* renamed from: b */
    final /* synthetic */ ProMessageFragment f9150b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC1718n(ProMessageFragment proMessageFragment, Context context, String str, String str2, AddFriendInfo addFriendInfo) {
        super(context, str, str2);
        this.f9150b = proMessageFragment;
        this.f9149a = addFriendInfo;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: a */
    public final void mo4705a(String str) {
        String str2;
        Context context;
        String str3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            String user_id = this.f9149a.getUser_id();
            String name = this.f9149a.getName();
            ProMessageFragment proMessageFragment = this.f9150b;
            str3 = proMessageFragment.f9100G;
            String string = proMessageFragment.getString(R.string.input_your_verification_default, new Object[]{str3});
            str4 = this.f9150b.f9100G;
            GoloTools.m6962a(user_id, name, string, str4);
        } else {
            String user_id2 = this.f9149a.getUser_id();
            String name2 = this.f9149a.getName();
            str2 = this.f9150b.f9100G;
            GoloTools.m6962a(user_id2, name2, str, str2);
        }
        context = this.f9150b.mContext;
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null || getCurrentFocus() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: e_ */
    public final void mo4701e_() {
        Context context;
        context = this.f9150b.mContext;
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null || getCurrentFocus() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
}
