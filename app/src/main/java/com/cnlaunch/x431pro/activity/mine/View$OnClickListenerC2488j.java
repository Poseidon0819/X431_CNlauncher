package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: ChangeEmailFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.j */
/* loaded from: classes.dex */
final class View$OnClickListenerC2488j implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChangeEmailFragment f14230a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2488j(ChangeEmailFragment changeEmailFragment) {
        this.f14230a = changeEmailFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        Context context;
        Context context2;
        editText = this.f14230a.f14226f;
        if (C2787z.m4816c(editText.getText().toString())) {
            context2 = this.f14230a.mContext;
            LoadDialog.m4686a(context2);
            this.f14230a.request(2107);
            return;
        }
        context = this.f14230a.mContext;
        NToast.m9446b(context, this.f14230a.getResources().getString(R.string.mine_bind_email_error));
    }
}
