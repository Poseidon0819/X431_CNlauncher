package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.view.View;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.bd */
/* loaded from: classes.dex */
public class MessageDialog extends BaseDialog {
    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return null;
    }

    public MessageDialog(Context context) {
        super(context);
    }

    public MessageDialog(Context context, String str, String str2, boolean z) {
        super(context);
        m4716b(str);
        m4715c(str2);
        setCancelable(z);
    }

    private MessageDialog(Context context, int i, int i2, boolean z) {
        super(context);
        setTitle(i);
        m4714e(i2);
        setCancelable(z);
    }

    public MessageDialog(Context context, int i, int i2) {
        this(context, i, i2, true);
    }

    public MessageDialog(Context context, int i, int i2, boolean z, byte b) {
        this(context, i, i2, z);
    }

    public MessageDialog(Context context, String str, String str2, boolean z, byte b) {
        this(context, str, str2, z);
    }

    public MessageDialog(Context context, String str) {
        this(context, (String) null, str, false);
    }

    public MessageDialog(Context context, String str, byte b) {
        this(context, (String) null, str, true);
    }

    public MessageDialog(Context context, int i) {
        this(context, (String) null, context.getResources().getString(i), true);
    }

    /* renamed from: a */
    public final void m4670a(int i, int i2) {
        setTitle(i);
        m4714e(i2);
        setCancelable(true);
        m4719a(R.string.btn_confirm, true, null);
        show();
    }

    /* renamed from: a */
    public final void m4669a(String str, String str2) {
        m4716b(str);
        m4715c(str2);
        setCancelable(true);
        m4719a(R.string.btn_confirm, true, null);
        show();
    }

    /* renamed from: b */
    public final void m4667b(String str, String str2) {
        m4716b(str);
        m4715c(str2);
        setCancelable(false);
        m4719a(R.string.btn_confirm, true, null);
        show();
    }

    /* renamed from: a */
    public final void m4671a(int i) {
        setTitle(R.string.remote_dialog_title);
        m4714e(i);
        setCancelable(true);
        m4719a(R.string.btn_confirm, true, null);
        show();
    }

    /* renamed from: a */
    public final void m4668a(String str, String str2, String str3, View.OnClickListener onClickListener) {
        m4716b(str);
        m4715c(str2);
        setCancelable(false);
        m4718a(str3, onClickListener);
        show();
    }
}
