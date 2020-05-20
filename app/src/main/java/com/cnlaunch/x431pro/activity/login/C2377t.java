package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.ifoer.expedition.pro.R;

/* compiled from: FindPasswordActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.t */
/* loaded from: classes.dex */
final class C2377t implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ FindPasswordActivity f13533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2377t(FindPasswordActivity findPasswordActivity) {
        this.f13533a = findPasswordActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        EditText editText;
        String str;
        long j;
        Context context;
        if (i == 6) {
            FindPasswordActivity findPasswordActivity = this.f13533a;
            editText = findPasswordActivity.f13065V;
            findPasswordActivity.f13074ae = editText.getText().toString();
            str = this.f13533a.f13074ae;
            if (str.length() == 12) {
                long currentTimeMillis = System.currentTimeMillis();
                j = this.f13533a.f13050G;
                if (currentTimeMillis - j < 2000) {
                    context = this.f13533a.f10981q;
                    NToast.m9450a(context, (int) R.string.retrieve_password_operate_frequently);
                    return false;
                }
                this.f13533a.f13050G = System.currentTimeMillis();
                this.f13533a.m7739c(201);
                return false;
            }
            return false;
        }
        return false;
    }
}
