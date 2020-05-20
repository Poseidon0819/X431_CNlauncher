package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Messenger;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.g */
/* loaded from: classes.dex */
public final class MessageBoxDialog {

    /* renamed from: a */
    public ProgressDialog f12453a = null;

    /* renamed from: b */
    public ProgressDialog f12454b = null;

    /* renamed from: c */
    public Messenger f12455c = null;

    /* renamed from: d */
    public Handler f12456d = new HandlerC2192i(this);

    /* renamed from: a */
    public final void m7052a() {
        ProgressDialog progressDialog = this.f12454b;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f12454b.dismiss();
        }
        ProgressDialog progressDialog2 = this.f12453a;
        if (progressDialog2 == null || !progressDialog2.isShowing()) {
            return;
        }
        this.f12453a.dismiss();
        this.f12453a = null;
    }
}
