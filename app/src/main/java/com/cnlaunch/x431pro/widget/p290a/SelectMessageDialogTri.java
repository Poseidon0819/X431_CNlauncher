package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.cl */
/* loaded from: classes.dex */
public abstract class SelectMessageDialogTri {
    /* renamed from: a */
    public abstract void mo4604a();

    /* renamed from: b */
    public abstract void mo4602b();

    /* renamed from: c */
    public abstract void mo4601c();

    /* renamed from: a */
    public final void m4603a(Context context) {
        MessageDialog messageDialog = new MessageDialog(context, (int) R.string.tryflag_dialog_title, (int) R.string.register_dialog_content, false, (byte) 0);
        messageDialog.m4719a(R.string.register_button, true, new View$OnClickListenerC2853cm(this));
        messageDialog.m4717b(R.string.login, true, new View$OnClickListenerC2854cn(this));
        messageDialog.m4720a(R.string.btn_gam, new View$OnClickListenerC2855co(this));
        messageDialog.m4713f(2);
        messageDialog.m4713f(3);
        messageDialog.show();
    }
}
