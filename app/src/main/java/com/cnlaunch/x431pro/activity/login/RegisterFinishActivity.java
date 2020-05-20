package com.cnlaunch.x431pro.activity.login;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.LinearLayout;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class RegisterFinishActivity extends ActivityC2004c {

    /* renamed from: C */
    Button f13326C;

    /* renamed from: D */
    private LinearLayout f13327D;

    /* renamed from: n */
    Button f13328n;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_regit_finish);
        m7743b();
        this.f13328n = (Button) findViewById(R.id.button_toupdate);
        this.f13326C = (Button) findViewById(R.id.button_later);
        this.f13328n.setOnClickListener(new View$OnClickListenerC2356ca(this));
        this.f13327D = (LinearLayout) findViewById(R.id.merchant_title);
        if (!C2744aa.m5144h(this.f10981q)) {
            C2744aa.m5129p();
        }
        this.f13327D.setVisibility(8);
        this.f13326C.setOnClickListener(new View$OnClickListenerC2357cb(this));
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
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
