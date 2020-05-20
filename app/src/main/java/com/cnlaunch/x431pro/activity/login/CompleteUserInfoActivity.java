package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.ExtParam;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.PdfContentParser;

/* loaded from: classes.dex */
public class CompleteUserInfoActivity extends ActivityC2004c implements View.OnClickListener {

    /* renamed from: E */
    private UserAction f13019E;

    /* renamed from: F */
    private EditText f13020F;

    /* renamed from: G */
    private EditText f13021G;

    /* renamed from: H */
    private EditText f13022H;

    /* renamed from: I */
    private EditText f13023I;

    /* renamed from: J */
    private Button f13024J;

    /* renamed from: K */
    private String f13025K;

    /* renamed from: L */
    private String f13026L;

    /* renamed from: M */
    private String f13027M;

    /* renamed from: N */
    private String f13028N;

    /* renamed from: n */
    private final int f13031n = PdfContentParser.COMMAND_TYPE;

    /* renamed from: C */
    private final int f13017C = 300011;

    /* renamed from: D */
    private final int f13018D = 300013;

    /* renamed from: O */
    private UserBaseInfo f13029O = new UserBaseInfo();

    /* renamed from: P */
    private ExtParam f13030P = new ExtParam();

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.f13029O = (UserBaseInfo) getIntent().getExtras().getSerializable("USERBASEINFO");
        }
        setContentView(R.layout.complete_regist_ja);
        m7743b();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13019E = new UserAction(this);
        this.f13020F = (EditText) findViewById(R.id.edit_company_name);
        this.f13021G = (EditText) findViewById(R.id.edit_zipcode);
        this.f13022H = (EditText) findViewById(R.id.edit_address);
        this.f13023I = (EditText) findViewById(R.id.edit_phonenum);
        if (!TextUtils.isEmpty(this.f13029O.getCompany().trim())) {
            this.f13020F.setText(this.f13029O.getCompany().trim());
        }
        if (!TextUtils.isEmpty(this.f13029O.getZipcode().trim())) {
            this.f13021G.setText(this.f13029O.getZipcode().trim());
        }
        if (!TextUtils.isEmpty(this.f13029O.getAddress().trim())) {
            this.f13022H.setText(this.f13029O.getAddress().trim());
        }
        if (!TextUtils.isEmpty(this.f13029O.getCompany_phone().trim())) {
            this.f13023I.setText(this.f13029O.getCompany_phone().trim());
        }
        this.f13024J = (Button) findViewById(R.id.btn_confirm);
        this.f13024J.setOnClickListener(this);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 200) {
            return this.f13019E.m5272a(this.f13030P);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        LoadDialog.m4681b(this.f10981q);
        if (i == 200 && obj != null) {
            CommonResponse commonResponse = (CommonResponse) obj;
            if (commonResponse.getCode() == 0) {
                NToast.m9450a(this.f10981q, (int) R.string.complete_user_info_success);
                finish();
                return;
            }
            NToast.m9449a(this.f10981q, this.f10981q.getString(R.string.complete_user_info_failed, String.valueOf(commonResponse.getCode())));
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        LoadDialog.m4681b(this.f10981q);
        if (i != -999) {
            if (i == -400) {
                if (this.f10981q != null) {
                    NToast.m9450a(this.f10981q, (int) R.string.common_network_unavailable);
                    return;
                }
                return;
            } else if (i != -200) {
                return;
            }
        }
        if (this.f10981q != null) {
            NToast.m9447b(this.f10981q, (int) R.string.common_network_error);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btn_confirm) {
            return;
        }
        this.f13025K = this.f13020F.getText().toString().trim();
        this.f13026L = this.f13021G.getText().toString().trim();
        this.f13027M = this.f13022H.getText().toString().trim();
        this.f13028N = this.f13023I.getText().toString().trim();
        if (TextUtils.isEmpty(this.f13025K) || TextUtils.isEmpty(this.f13027M)) {
            NToast.m9450a(this, (int) R.string.register_input_null);
        } else if (TextUtils.isEmpty(this.f13026L)) {
            NToast.m9450a(this, (int) R.string.register_input_null);
        } else {
            if (TextUtils.isEmpty(this.f13028N)) {
                NToast.m9450a(this, (int) R.string.register_input_null);
            }
            ExtParam extParam = this.f13030P;
            extParam.f15595b = this.f13027M;
            extParam.f15594a = this.f13025K;
            extParam.f15596c = this.f13028N;
            extParam.f15597d = this.f13026L;
            m7739c(PdfContentParser.COMMAND_TYPE);
            LoadDialog.m4686a(this);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
