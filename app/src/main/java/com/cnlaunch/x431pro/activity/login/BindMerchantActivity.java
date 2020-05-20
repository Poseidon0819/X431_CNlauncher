package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class BindMerchantActivity extends ActivityC2004c {

    /* renamed from: C */
    private EditText f13009C;

    /* renamed from: D */
    private Button f13010D;

    /* renamed from: E */
    private LinearLayout f13011E;

    /* renamed from: F */
    private boolean f13012F;

    /* renamed from: G */
    private String f13013G;

    /* renamed from: H */
    private String f13014H;

    /* renamed from: I */
    private Handler f13015I = new HandlerC2363d(this);

    /* renamed from: n */
    private EditText f13016n;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_registmerchant_bind);
        this.f13012F = getIntent().getExtras().getBoolean("FromRegister", false);
        this.f13016n = (EditText) findViewById(R.id.edit_merchant_name);
        this.f13009C = (EditText) findViewById(R.id.edit_merchant_password);
        this.f13010D = (Button) findViewById(R.id.btn_bind);
        this.f13011E = (LinearLayout) findViewById(R.id.layout_top);
        if (this.f13012F) {
            m7743b();
        } else {
            this.f13011E.setVisibility(8);
            setTitle(R.string.regist_merchant_bind_Merchant);
            m7740c();
            m7737d(8);
        }
        this.f13010D.setOnClickListener(new View$OnClickListenerC2364e(this));
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            Intent intent = new Intent(this.f10981q, RegistMerchantHomePageActivity.class);
            intent.setFlags(67108864);
            intent.putExtra("FromRegister", this.f13012F);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ void m6800g(BindMerchantActivity bindMerchantActivity) {
        bindMerchantActivity.f13013G = bindMerchantActivity.f13016n.getText().toString();
        bindMerchantActivity.f13014H = bindMerchantActivity.f13009C.getText().toString();
    }
}
