package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.cw */
/* loaded from: classes.dex */
public abstract class TipDialog extends BaseDialog {

    /* renamed from: a */
    private View f16389a;

    /* renamed from: b */
    private CheckBox f16390b;

    /* renamed from: c */
    private TextView f16391c;

    /* renamed from: g */
    private TextView f16392g;

    /* renamed from: a */
    public abstract void mo4580a(int i, boolean z);

    private TipDialog(Context context) {
        super(context);
        this.f16389a = null;
        this.f16390b = null;
        this.f16389a = LayoutInflater.from(context).inflate(R.layout.layout_dialog_tip, (ViewGroup) null);
        this.f16389a.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.f16391c = (TextView) this.f16389a.findViewById(R.id.tv_message);
        this.f16392g = (TextView) this.f16389a.findViewById(R.id.tv_tip);
        this.f16392g.setOnClickListener(this);
        this.f16390b = (CheckBox) this.f16389a.findViewById(R.id.cb_tip);
        this.f16390b.setChecked(true);
    }

    public TipDialog(Context context, int i, int i2, boolean z) {
        this(context);
        setTitle(i);
        this.f16391c.setText(i2);
        setCancelable(z);
    }

    private TipDialog(Context context, String str, String str2) {
        this(context);
        m4716b(str);
        setCancelable(true);
        this.f16391c.setText(str2);
        this.f16391c.setText(str2);
    }

    public TipDialog(Context context, int i, int i2) {
        this(context, i, i2, true);
    }

    public TipDialog(Context context, String str, String str2, byte b) {
        this(context, str, str2);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16389a;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final void mo4579a(View view, int i) {
        super.mo4579a(view, i);
        mo4580a(i, this.f16390b.isChecked());
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: b */
    public final void mo4577b(View view, int i) {
        super.mo4577b(view, i);
        mo4580a(i, this.f16390b.isChecked());
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: c */
    public final void mo4576c(View view, int i) {
        super.mo4576c(view, i);
        mo4580a(i, this.f16390b.isChecked());
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.tv_tip) {
            this.f16390b.toggle();
        }
    }

    /* renamed from: b */
    public final void m4578b() {
        this.f16391c.setGravity(3);
    }
}
