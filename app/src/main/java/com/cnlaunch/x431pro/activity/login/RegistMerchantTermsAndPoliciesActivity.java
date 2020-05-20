package com.cnlaunch.x431pro.activity.login;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class RegistMerchantTermsAndPoliciesActivity extends ActivityC2004c {

    /* renamed from: C */
    private Button f13324C;

    /* renamed from: n */
    private TextView f13325n;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_registmerchant_regist_policies);
        this.f13325n = (TextView) findViewById(R.id.dialog_message);
        this.f13324C = (Button) findViewById(R.id.button1);
        this.f13324C.setText(R.string.statement_btn_txt);
        this.f13325n.setText(R.string.terms_and_policies);
        setTitle(R.string.terms_and_policies_tittle);
        this.f10988x = false;
        m7735e(8);
        m7740c();
        m7737d(8);
        this.f13324C.setOnClickListener(new View$OnClickListenerC2354bz(this));
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        }
        return false;
    }
}
