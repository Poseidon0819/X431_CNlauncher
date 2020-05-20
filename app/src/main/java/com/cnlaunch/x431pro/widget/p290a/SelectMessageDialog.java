package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.ca */
/* loaded from: classes.dex */
public abstract class SelectMessageDialog {

    /* renamed from: d */
    public MessageDialog f16349d;

    /* renamed from: e */
    public int f16350e;

    /* renamed from: a */
    public abstract void mo4611a();

    /* renamed from: b */
    public abstract void mo4608b();

    /* renamed from: a */
    public final void m4609a(Context context, String str, String str2) {
        MessageDialog messageDialog = new MessageDialog(context, str, str2, true, (byte) 0);
        messageDialog.m4713f(2);
        messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2843cb(this));
        messageDialog.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2845cd(this));
        messageDialog.show();
    }

    /* renamed from: a */
    public final void m4610a(Context context, int i, int i2, boolean z) {
        MessageDialog messageDialog = new MessageDialog(context, i, i2, z, (byte) 0);
        messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2846ce(this));
        messageDialog.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2847cf(this));
        messageDialog.show();
    }

    /* renamed from: b */
    public final void m4607b(Context context, int i, int i2, boolean z) {
        this.f16350e = i2;
        this.f16349d = new MessageDialog(context, i, i2, z, (byte) 0);
        this.f16349d.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2848cg(this));
        this.f16349d.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2849ch(this));
        this.f16349d.m4713f(2);
        this.f16349d.show();
    }

    /* renamed from: b */
    public final void m4606b(Context context, String str, String str2) {
        MessageDialog messageDialog = new MessageDialog(context, str, str2, true, (byte) 0);
        messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2852ck(this));
        messageDialog.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2844cc(this));
        messageDialog.m4713f(2);
        messageDialog.show();
    }

    /* renamed from: c */
    public final boolean m4605c() {
        MessageDialog messageDialog = this.f16349d;
        return messageDialog != null && messageDialog.isShowing();
    }
}
