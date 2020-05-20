package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.SimImeiInfoResponse;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.aq */
/* loaded from: classes.dex */
public final class InputIccidDialog extends BaseDialog implements OnDataListener {

    /* renamed from: a */
    private final AsyncTaskManager f16153a;

    /* renamed from: b */
    private final View f16154b;

    /* renamed from: c */
    private final Button f16155c;

    /* renamed from: g */
    private final Button f16156g;

    /* renamed from: h */
    private Context f16157h;

    /* renamed from: i */
    private String f16158i;

    /* renamed from: j */
    private String f16159j;

    /* renamed from: k */
    private String f16160k;

    /* renamed from: l */
    private EditText f16161l;

    /* renamed from: m */
    private EditText f16162m;

    public InputIccidDialog(Context context) {
        super(context);
        this.f16157h = context;
        setTitle(R.string.send_iccid);
        setCancelable(false);
        this.f16153a = AsyncTaskManager.m9574a(this.f16157h);
        this.f16154b = LayoutInflater.from(context).inflate(R.layout.layout_input_iccid, (ViewGroup) null);
        this.f16155c = (Button) this.f16154b.findViewById(R.id.btn_info_save);
        this.f16155c.setOnClickListener(this);
        this.f16156g = (Button) this.f16154b.findViewById(R.id.btn_info_skip);
        this.f16156g.setOnClickListener(this);
        this.f16158i = PreferencesManager.m9595a(this.f16157h).m9591a("sim_iccid");
        if (TextUtils.isEmpty(this.f16158i)) {
            this.f16158i = C2744aa.m5186a(this.f16157h);
        }
        this.f16160k = C2744aa.m5124r(this.f16157h);
        this.f16159j = PreferencesManager.m9595a(this.f16157h).m9591a("serialNo");
        this.f16161l = (EditText) this.f16154b.findViewById(R.id.edit_serialNum);
        this.f16162m = (EditText) this.f16154b.findViewById(R.id.edit_iccid);
        if (!TextUtils.isEmpty(this.f16159j)) {
            this.f16161l.setText(this.f16159j);
        }
        if (!TextUtils.isEmpty(this.f16158i)) {
            this.f16162m.setText(this.f16158i);
        }
        this.f16162m.setOnEditorActionListener(new C2818ar(this));
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16154b;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_info_save /* 2131296484 */:
                m4699b();
                break;
            case R.id.btn_info_skip /* 2131296485 */:
                dismiss();
                break;
        }
        super.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4699b() {
        this.f16159j = this.f16161l.getText().toString();
        if (C2787z.m4821a(this.f16159j)) {
            Context context = this.f16157h;
            NToast.m9449a(context, this.f16157h.getString(R.string.serialnumber_txt) + this.f16157h.getString(R.string.content_can_not_null));
        } else if (!C2744aa.m5162c(this.f16159j)) {
            NToast.m9450a(this.f16157h, (int) R.string.error_serialnum);
        } else {
            this.f16158i = this.f16162m.getText().toString();
            if (C2787z.m4821a(this.f16158i)) {
                Context context2 = this.f16157h;
                NToast.m9449a(context2, this.f16157h.getString(R.string.iccid_text) + this.f16157h.getString(R.string.content_can_not_null));
                return;
            }
            m4698c();
        }
    }

    /* renamed from: c */
    private void m4698c() {
        this.f16153a.m9575a(100, true, this);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i != 100) {
            return null;
        }
        return new UserAction(this.f16157h).m5255c(this.f16159j, this.f16158i, this.f16160k);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i != 100) {
            return;
        }
        SimImeiInfoResponse simImeiInfoResponse = (SimImeiInfoResponse) obj;
        if (simImeiInfoResponse.getRestBaseResult() != null && simImeiInfoResponse.getRestBaseResult().getCode() == 0) {
            NToast.m9450a(this.f16157h, (int) R.string.send_iccid_success);
            dismiss();
            return;
        }
        Context context = this.f16157h;
        NToast.m9449a(context, context.getString(R.string.send_iccid_failure));
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        if (i != 100) {
            return;
        }
        Context context = this.f16157h;
        NToast.m9449a(context, context.getString(R.string.send_iccid_failure));
    }
}
