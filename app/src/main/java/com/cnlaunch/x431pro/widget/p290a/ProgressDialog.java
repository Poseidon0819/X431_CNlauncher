package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.br */
/* loaded from: classes.dex */
public abstract class ProgressDialog extends BaseDialog {

    /* renamed from: a */
    private View f16323a;

    /* renamed from: b */
    public boolean f16324b;

    /* renamed from: c */
    private ProgressBar f16325c;

    /* renamed from: g */
    private TextView f16326g;

    /* renamed from: h */
    private Context f16327h;

    /* renamed from: i */
    private MessageDialog f16328i;

    /* renamed from: a */
    public abstract void mo4625a(boolean z);

    public ProgressDialog(Context context) {
        super(context);
        this.f16324b = true;
        this.f16327h = context;
        setCancelable(false);
        setTitle(R.string.soft_download);
        this.f16323a = LayoutInflater.from(context).inflate(R.layout.layout_progress_dialog, (ViewGroup) null);
        this.f16325c = (ProgressBar) this.f16323a.findViewById(R.id.pb_progress_item);
        this.f16326g = (TextView) this.f16323a.findViewById(R.id.tv_state_item);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16323a;
    }

    /* renamed from: a */
    public final void m4627a(int i) {
        TextView textView = this.f16326g;
        if (textView != null) {
            textView.post(new RunnableC2835bs(this, i));
        }
    }

    /* renamed from: b */
    public final void m4623b(int i) {
        ProgressBar progressBar = this.f16325c;
        if (progressBar != null) {
            progressBar.post(new RunnableC2836bt(this, i));
        }
    }

    /* renamed from: c */
    public final void m4619c(int i) {
        ProgressBar progressBar = this.f16325c;
        if (progressBar != null) {
            progressBar.post(new RunnableC2837bu(this, i));
        }
    }

    /* renamed from: d */
    public final void m4617d(int i) {
        TextView textView = this.f16326g;
        if (textView != null) {
            textView.post(new RunnableC2838bv(this, i));
        }
    }

    /* renamed from: b */
    public final void m4621b(boolean z) {
        super.dismiss();
        mo4625a(z);
    }

    /* renamed from: b */
    public final void m4624b() {
        super.dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.f16324b) {
            MessageDialog messageDialog = this.f16328i;
            if (messageDialog == null || !messageDialog.isShowing()) {
                this.f16328i = new MessageDialog(this.f16327h, (int) R.string.skip_soft_download_tip);
                this.f16328i.m4713f(2);
                this.f16328i.m4717b(R.string.no, false, new View$OnClickListenerC2839bw(this));
                this.f16328i.m4719a(R.string.yes, true, new View$OnClickListenerC2840bx(this));
                this.f16328i.setCancelable(false);
                this.f16328i.show();
            }
        }
    }

    /* renamed from: c */
    public final void m4620c() {
        MessageDialog messageDialog = this.f16328i;
        if (messageDialog == null || !messageDialog.isShowing()) {
            return;
        }
        this.f16328i.dismiss();
    }
}
