package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: ChangeEmailFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.i */
/* loaded from: classes.dex */
final class C2487i implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ChangeEmailFragment f14229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2487i(ChangeEmailFragment changeEmailFragment) {
        this.f14229a = changeEmailFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        EditText editText;
        Context context;
        Context context2;
        if (i == 6) {
            editText = this.f14229a.f14226f;
            if (C2787z.m4816c(editText.getText().toString())) {
                context2 = this.f14229a.mContext;
                LoadDialog.m4686a(context2);
                this.f14229a.request(2107);
                return false;
            }
            context = this.f14229a.mContext;
            NToast.m9446b(context, this.f14229a.getResources().getString(R.string.mine_bind_email_error));
            return false;
        }
        return false;
    }
}
