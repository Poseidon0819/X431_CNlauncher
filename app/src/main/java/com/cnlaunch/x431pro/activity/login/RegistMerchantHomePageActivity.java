package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class RegistMerchantHomePageActivity extends ActivityC2004c {

    /* renamed from: C */
    private Button f13312C;

    /* renamed from: D */
    private Button f13313D;

    /* renamed from: E */
    private LinearLayout f13314E;

    /* renamed from: F */
    private boolean f13315F;

    /* renamed from: n */
    private Button f13316n;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_registmerchant);
        this.f13315F = getIntent().getExtras().getBoolean("FromRegister", false);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13312C = (Button) findViewById(R.id.btn_bind);
        this.f13316n = (Button) findViewById(R.id.btn_regist);
        this.f13313D = (Button) findViewById(R.id.btn_skip);
        this.f13314E = (LinearLayout) findViewById(R.id.layout_top);
        ((TextView) findViewById(R.id.text_merchant_instructions)).setText(Html.fromHtml(getResources().getString(R.string.seller_pro_register_info2)));
        if (this.f13315F) {
            m7743b();
        } else {
            this.f13314E.setVisibility(8);
            m7740c();
            m7737d(8);
        }
        this.f13312C.setOnClickListener(new View$OnClickListenerC2350bv(this));
        this.f13316n.setOnClickListener(new View$OnClickListenerC2351bw(this));
        this.f13313D.setOnClickListener(new View$OnClickListenerC2352bx(this));
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (this.f13315F) {
                Intent intent = new Intent(this, RegisterFinishActivity.class);
                intent.setFlags(67108864);
                startActivity(intent);
            }
            finish();
            return true;
        }
        return false;
    }
}
