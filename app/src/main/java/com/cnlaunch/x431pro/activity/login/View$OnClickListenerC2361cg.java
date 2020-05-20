package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.PdfContentParser;

/* compiled from: ResetPasswordActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.cg */
/* loaded from: classes.dex */
final class View$OnClickListenerC2361cg implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ResetPasswordActivity f13473a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2361cg(ResetPasswordActivity resetPasswordActivity) {
        this.f13473a = resetPasswordActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        ResetPasswordActivity resetPasswordActivity = this.f13473a;
        resetPasswordActivity.f13341H = resetPasswordActivity.f13336C.getText().toString();
        ResetPasswordActivity resetPasswordActivity2 = this.f13473a;
        resetPasswordActivity2.f13342I = resetPasswordActivity2.f13337D.getText().toString();
        if (TextUtils.isEmpty(this.f13473a.f13341H)) {
            context6 = this.f13473a.f10981q;
            NToast.m9450a(context6, (int) R.string.reset_password_input_password);
        } else if (!C2787z.m4813f(this.f13473a.f13341H)) {
            context5 = this.f13473a.f10981q;
            NToast.m9450a(context5, (int) R.string.reset_password_password_error);
        } else if (TextUtils.isEmpty(this.f13473a.f13342I)) {
            context4 = this.f13473a.f10981q;
            NToast.m9450a(context4, (int) R.string.reset_password_input_confirm_password);
        } else if (!C2787z.m4813f(this.f13473a.f13342I)) {
            context3 = this.f13473a.f10981q;
            NToast.m9450a(context3, (int) R.string.reset_password_confirm_password_error);
        } else if (!this.f13473a.f13341H.equals(this.f13473a.f13342I)) {
            context2 = this.f13473a.f10981q;
            NToast.m9450a(context2, (int) R.string.register_password_not_match);
        } else {
            context = this.f13473a.f10981q;
            LoadDialog.m4686a(context);
            this.f13473a.m7739c(PdfContentParser.COMMAND_TYPE);
        }
    }
}
