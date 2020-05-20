package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.aw */
/* loaded from: classes.dex */
public final class InputSensingDialog extends BaseDialog implements OnDataListener {

    /* renamed from: A */
    private String[] f16196A;

    /* renamed from: B */
    private TextView f16197B;

    /* renamed from: C */
    private int f16198C;

    /* renamed from: a */
    public InputVehicleInfoDialog f16199a;

    /* renamed from: b */
    private PreferencesManager f16200b;

    /* renamed from: c */
    private View f16201c;

    /* renamed from: g */
    private Context f16202g;

    /* renamed from: h */
    private BaseDiagnoseFragment f16203h;

    /* renamed from: i */
    private TextView f16204i;

    /* renamed from: j */
    private TextView f16205j;

    /* renamed from: k */
    private TextView f16206k;

    /* renamed from: l */
    private TextView f16207l;

    /* renamed from: m */
    private TextView f16208m;

    /* renamed from: n */
    private TextView f16209n;

    /* renamed from: o */
    private TextView f16210o;

    /* renamed from: p */
    private TextView f16211p;

    /* renamed from: q */
    private TextView f16212q;

    /* renamed from: r */
    private TextView f16213r;

    /* renamed from: s */
    private TextView f16214s;

    /* renamed from: t */
    private TextView f16215t;

    /* renamed from: u */
    private TextView f16216u;

    /* renamed from: v */
    private TextView f16217v;

    /* renamed from: w */
    private TextView f16218w;

    /* renamed from: x */
    private TextView f16219x;

    /* renamed from: y */
    private TextView f16220y;

    /* renamed from: z */
    private String[] f16221z;

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        return null;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
    }

    public InputSensingDialog(Context context) {
        super(context);
        this.f16201c = null;
        this.f16203h = null;
        this.f16221z = new String[]{"", "", "", "", ""};
        this.f16196A = new String[5];
        this.f16202g = context;
        setTitle(R.string.sensing_info);
        this.f16200b = PreferencesManager.m9595a(context);
        this.f16201c = LayoutInflater.from(context).inflate(R.layout.layout_input_sensing, (ViewGroup) null);
        this.f16128e.setVisibility(0);
        this.f16129f.setVisibility(0);
        this.f16129f.setText(R.string.reselect_soft);
        this.f16128e.setText(R.string.common_confirm);
        this.f16196A[0] = this.f16202g.getString(R.string.report_sight);
        this.f16196A[1] = this.f16202g.getString(R.string.report_hear);
        this.f16196A[2] = this.f16202g.getString(R.string.report_smell);
        this.f16196A[3] = this.f16202g.getString(R.string.report_feel);
        this.f16196A[4] = this.f16202g.getString(R.string.report_other);
        String m9591a = this.f16200b.m9591a("report_sensing_normal");
        if (!C2787z.m4821a(m9591a)) {
            String[] split = m9591a.split("0X0");
            for (int i = 0; i < this.f16221z.length; i++) {
                if (i < split.length && !C2787z.m4821a(split[i])) {
                    if (split[i].equals("null")) {
                        this.f16221z[i] = "";
                    } else {
                        this.f16221z[i] = split[i];
                    }
                }
            }
        }
        this.f16204i = (TextView) this.f16201c.findViewById(R.id.tv_light);
        this.f16205j = (TextView) this.f16201c.findViewById(R.id.tv_smoke);
        this.f16206k = (TextView) this.f16201c.findViewById(R.id.tv_fluid);
        this.f16207l = (TextView) this.f16201c.findViewById(R.id.tv_corrosion);
        this.f16204i.setOnClickListener(this);
        this.f16205j.setOnClickListener(this);
        this.f16206k.setOnClickListener(this);
        this.f16207l.setOnClickListener(this);
        this.f16208m = (TextView) this.f16201c.findViewById(R.id.tv_ratting);
        this.f16209n = (TextView) this.f16201c.findViewById(R.id.tv_hissing);
        this.f16210o = (TextView) this.f16201c.findViewById(R.id.tv_squeak);
        this.f16211p = (TextView) this.f16201c.findViewById(R.id.tv_clicking);
        this.f16208m.setOnClickListener(this);
        this.f16209n.setOnClickListener(this);
        this.f16210o.setOnClickListener(this);
        this.f16211p.setOnClickListener(this);
        this.f16212q = (TextView) this.f16201c.findViewById(R.id.tv_gasoline);
        this.f16213r = (TextView) this.f16201c.findViewById(R.id.tv_oil);
        this.f16214s = (TextView) this.f16201c.findViewById(R.id.tv_coolant);
        this.f16215t = (TextView) this.f16201c.findViewById(R.id.tv_electrical);
        this.f16212q.setOnClickListener(this);
        this.f16213r.setOnClickListener(this);
        this.f16214s.setOnClickListener(this);
        this.f16215t.setOnClickListener(this);
        this.f16216u = (TextView) this.f16201c.findViewById(R.id.tv_shaking);
        this.f16217v = (TextView) this.f16201c.findViewById(R.id.tv_vibrating);
        this.f16218w = (TextView) this.f16201c.findViewById(R.id.tv_shutter);
        this.f16216u.setOnClickListener(this);
        this.f16217v.setOnClickListener(this);
        this.f16218w.setOnClickListener(this);
        this.f16219x = (TextView) this.f16201c.findViewById(R.id.tv_no_crank);
        this.f16220y = (TextView) this.f16201c.findViewById(R.id.tv_crank);
        this.f16219x.setOnClickListener(this);
        this.f16220y.setOnClickListener(this);
        m4690b();
    }

    /* renamed from: b */
    private void m4690b() {
        m4691a(0, this.f16204i, this.f16205j, this.f16206k, this.f16207l);
        m4691a(1, this.f16208m, this.f16209n, this.f16210o, this.f16211p);
        m4691a(2, this.f16212q, this.f16213r, this.f16214s, this.f16215t);
        m4691a(3, this.f16216u, this.f16217v, this.f16218w);
        m4691a(4, this.f16219x, this.f16220y);
    }

    /* renamed from: a */
    private void m4691a(int i, TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            String[] strArr = this.f16221z;
            if (i < strArr.length && strArr[i].equals(textView.getText().toString())) {
                textView.setActivated(true);
            } else {
                textView.setActivated(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16201c;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = 0;
        switch (view.getId()) {
            case R.id.button1 /* 2131296605 */:
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String[] strArr = this.f16221z;
                    if (i < strArr.length) {
                        if (!C2787z.m4821a(strArr[i])) {
                            sb.append("<b>");
                            sb.append(this.f16196A[i]);
                            sb.append("</b> ");
                            sb.append(this.f16221z[i]);
                            sb.append("<br>");
                            sb2.append(this.f16221z[i]);
                        } else {
                            sb2.append("null");
                        }
                        sb2.append("0X0");
                        i++;
                    } else {
                        if (!C2787z.m4821a(sb.toString())) {
                            sb.delete(sb.length() - 5, sb.length());
                        }
                        this.f16200b.m9588a("report_sensing_normal", sb2.toString());
                        sb2.delete(sb2.length() - 1, sb2.length());
                        if (!C2787z.m4821a(sb.toString())) {
                            this.f16200b.m9588a("report_sensing_html", sb.toString());
                            InputVehicleInfoDialog inputVehicleInfoDialog = this.f16199a;
                            if (inputVehicleInfoDialog != null) {
                                inputVehicleInfoDialog.m4688a(sb.toString());
                            }
                        }
                        dismiss();
                        return;
                    }
                }
            case R.id.button2 /* 2131296606 */:
                this.f16200b.m9588a("report_sensing_html", "");
                this.f16200b.m9588a("report_sensing_normal", "");
                this.f16221z = new String[]{"", "", "", "", ""};
                m4690b();
                InputVehicleInfoDialog inputVehicleInfoDialog2 = this.f16199a;
                if (inputVehicleInfoDialog2 != null) {
                    inputVehicleInfoDialog2.m4688a("");
                    return;
                }
                return;
            case R.id.tv_clicking /* 2131298050 */:
                this.f16197B = this.f16211p;
                this.f16198C = 1;
                break;
            case R.id.tv_coolant /* 2131298061 */:
                this.f16197B = this.f16214s;
                this.f16198C = 2;
                break;
            case R.id.tv_corrosion /* 2131298062 */:
                this.f16197B = this.f16207l;
                this.f16198C = 0;
                break;
            case R.id.tv_crank /* 2131298063 */:
                this.f16197B = this.f16220y;
                this.f16198C = 4;
                break;
            case R.id.tv_electrical /* 2131298093 */:
                this.f16197B = this.f16215t;
                this.f16198C = 2;
                break;
            case R.id.tv_fluid /* 2131298107 */:
                this.f16197B = this.f16206k;
                this.f16198C = 0;
                break;
            case R.id.tv_gasoline /* 2131298110 */:
                this.f16197B = this.f16212q;
                this.f16198C = 2;
                break;
            case R.id.tv_hissing /* 2131298113 */:
                this.f16197B = this.f16209n;
                this.f16198C = 1;
                break;
            case R.id.tv_light /* 2131298138 */:
                this.f16197B = this.f16204i;
                this.f16198C = 0;
                break;
            case R.id.tv_no_crank /* 2131298171 */:
                this.f16197B = this.f16219x;
                this.f16198C = 4;
                break;
            case R.id.tv_oil /* 2131298172 */:
                this.f16197B = this.f16213r;
                this.f16198C = 2;
                break;
            case R.id.tv_ratting /* 2131298186 */:
                this.f16197B = this.f16208m;
                this.f16198C = 1;
                break;
            case R.id.tv_shaking /* 2131298253 */:
                this.f16197B = this.f16216u;
                this.f16198C = 3;
                break;
            case R.id.tv_shutter /* 2131298266 */:
                this.f16197B = this.f16218w;
                this.f16198C = 3;
                break;
            case R.id.tv_smoke /* 2131298269 */:
                this.f16197B = this.f16205j;
                this.f16198C = 0;
                break;
            case R.id.tv_squeak /* 2131298275 */:
                this.f16197B = this.f16210o;
                this.f16198C = 1;
                break;
            case R.id.tv_vibrating /* 2131298312 */:
                this.f16197B = this.f16217v;
                this.f16198C = 3;
                break;
        }
        int i2 = this.f16198C;
        TextView textView = this.f16197B;
        if (textView.isActivated()) {
            this.f16221z[i2] = "";
            textView.setActivated(false);
        } else {
            switch (i2) {
                case 0:
                    this.f16204i.setActivated(false);
                    this.f16205j.setActivated(false);
                    this.f16206k.setActivated(false);
                    this.f16207l.setActivated(false);
                    break;
                case 1:
                    this.f16208m.setActivated(false);
                    this.f16209n.setActivated(false);
                    this.f16210o.setActivated(false);
                    this.f16211p.setActivated(false);
                    break;
                case 2:
                    this.f16212q.setActivated(false);
                    this.f16213r.setActivated(false);
                    this.f16214s.setActivated(false);
                    this.f16215t.setActivated(false);
                    break;
                case 3:
                    this.f16216u.setActivated(false);
                    this.f16217v.setActivated(false);
                    this.f16218w.setActivated(false);
                    break;
                case 4:
                    this.f16219x.setActivated(false);
                    this.f16220y.setActivated(false);
                    break;
            }
            textView.setActivated(true);
            this.f16221z[i2] = textView.getText().toString();
        }
        super.onClick(view);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
