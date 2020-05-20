package com.cnlaunch.x431pro.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a */
/* loaded from: classes.dex */
public abstract class ApkUpgradeProgressDialog extends BaseDialog {

    /* renamed from: a */
    private View f16118a;

    /* renamed from: b */
    private ProgressBar f16119b;

    /* renamed from: c */
    private TextView f16120c;

    /* renamed from: g */
    private Context f16121g;

    /* renamed from: h */
    private boolean f16122h;

    /* renamed from: i */
    private MessageDialog f16123i;

    /* renamed from: b */
    public abstract void mo4729b();

    public ApkUpgradeProgressDialog(Context context) {
        super(context);
        this.f16122h = true;
        this.f16121g = context;
        setTitle(R.string.soft_download);
        this.f16118a = LayoutInflater.from(context).inflate(R.layout.layout_progress_dialog, (ViewGroup) null);
        this.f16119b = (ProgressBar) this.f16118a.findViewById(R.id.pb_progress_item);
        this.f16120c = (TextView) this.f16118a.findViewById(R.id.tv_state_item);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16118a;
    }

    /* renamed from: a */
    public final void m4731a(int i) {
        TextView textView = this.f16120c;
        if (textView != null) {
            textView.post(new RunnableC2885b(this, i));
        }
    }

    /* renamed from: b */
    public final void m4728b(int i) {
        ProgressBar progressBar = this.f16119b;
        if (progressBar != null) {
            progressBar.post(new RunnableC2899c(this, i));
        }
    }

    /* renamed from: c */
    public final void m4725c(int i) {
        ProgressBar progressBar = this.f16119b;
        if (progressBar != null) {
            progressBar.post(new RunnableC2905d(this, i));
        }
    }

    /* renamed from: d */
    public final void m4722d(int i) {
        TextView textView = this.f16120c;
        if (textView != null) {
            textView.post(new RunnableC2906e(this, i));
        }
    }

    /* renamed from: d */
    public final void m4723d() {
        super.dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f16122h) {
            MessageDialog messageDialog = this.f16123i;
            if (messageDialog == null || !messageDialog.isShowing()) {
                this.f16123i = new MessageDialog(this.f16121g, (int) R.string.skip_apk_download);
                this.f16123i.m4713f(2);
                this.f16123i.m4717b(R.string.no, false, new View$OnClickListenerC2907f(this));
                this.f16123i.m4719a(R.string.yes, true, new View$OnClickListenerC2908g(this));
                this.f16123i.setCancelable(false);
                this.f16123i.show();
            }
        }
    }

    /* renamed from: e */
    public final void m4721e() {
        MessageDialog messageDialog = this.f16123i;
        if (messageDialog == null || !messageDialog.isShowing()) {
            return;
        }
        this.f16123i.dismiss();
    }

    /* renamed from: c */
    public final void m4726c() {
        super.dismiss();
        mo4729b();
    }
}
