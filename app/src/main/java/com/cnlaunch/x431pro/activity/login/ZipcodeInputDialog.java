package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.cnlaunch.x431pro.module.p272k.p274b.ZipcodeInfoResponse;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.login.ch */
/* loaded from: classes.dex */
public abstract class ZipcodeInputDialog extends BaseDialog {

    /* renamed from: a */
    private View f13474a;

    /* renamed from: b */
    Context f13475b;

    /* renamed from: c */
    private EditText f13476c;

    /* renamed from: g */
    private TextView f13477g;

    /* renamed from: h */
    private Button f13478h;

    /* renamed from: i */
    private ZipcodeInfoResponse f13479i;

    /* renamed from: a */
    public abstract void mo6541a(String str);

    public ZipcodeInputDialog(Context context, ZipcodeInfoResponse zipcodeInfoResponse) {
        super(context);
        this.f13475b = null;
        this.f13474a = null;
        m4712g();
        this.f13479i = zipcodeInfoResponse;
        this.f13475b = context;
        setTitle(R.string.add_zipcode);
        this.f13474a = LayoutInflater.from(context).inflate(R.layout.login_add_zipcode, (ViewGroup) null);
        this.f13476c = (EditText) this.f13474a.findViewById(R.id.zipcode);
        this.f13477g = (TextView) this.f13474a.findViewById(R.id.countryname);
        this.f13478h = (Button) this.f13474a.findViewById(R.id.submit_zipcode);
        this.f13478h.setEnabled(false);
        this.f13478h.setOnClickListener(this);
        String country = this.f13479i.getData().getCountry();
        if (!TextUtils.isEmpty(country)) {
            if (country.equalsIgnoreCase("137")) {
                this.f13477g.setText("Canada");
            } else if (country.equalsIgnoreCase("235")) {
                this.f13477g.setText("Mexico");
            } else if (country.equalsIgnoreCase("325")) {
                this.f13477g.setText("United States");
            } else {
                this.f13477g.setVisibility(8);
            }
        } else {
            this.f13477g.setVisibility(8);
        }
        this.f13476c.addTextChangedListener(new C2362ci(this));
        setCancelable(false);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.submit_zipcode) {
            return;
        }
        mo6541a(this.f13476c.getText().toString());
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f13474a;
    }
}
