package com.cnlaunch.x431pro.activity.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.module.p258f.p259a.PayAction;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderInfoResponse;
import com.cnlaunch.x431pro.utils.p279a.QRCodeUtils;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.io.IOException;

/* renamed from: com.cnlaunch.x431pro.activity.pay.a */
/* loaded from: classes.dex */
public abstract class BaseQrCodeActivity extends ActivityC2004c implements View.OnClickListener {

    /* renamed from: D */
    private String f14413D;

    /* renamed from: E */
    private String f14414E;

    /* renamed from: F */
    private String f14415F;

    /* renamed from: n */
    private final int f14416n = 9000;

    /* renamed from: C */
    private Handler f14412C = new Handler();

    /* renamed from: h */
    protected abstract int mo6060h();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m6061a(Activity activity, String str, String str2, String str3, Class<? extends BaseQrCodeActivity> cls) {
        if (activity == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent(activity, cls);
        intent.putExtra("orderNo", str);
        intent.putExtra("qrCodeUrl", str2);
        intent.putExtra("price", str3);
        activity.startActivityForResult(intent, 0);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.f14413D = intent.getStringExtra("orderNo");
            this.f14414E = intent.getStringExtra("qrCodeUrl");
            this.f14415F = intent.getStringExtra("price");
        }
        setContentView(R.layout.activity_base_qr_code);
        m7737d(8);
        this.f10988x = false;
        m7735e(8);
        findViewById(R.id.area_right).setVisibility(8);
        findViewById(R.id.btnCancelPay).setOnClickListener(this);
        findViewById(R.id.btnPayed).setOnClickListener(this);
        ((ImageView) findViewById(R.id.img_qr_code)).setImageBitmap(QRCodeUtils.m5194a(this.f14414E));
        ((TextView) findViewById(R.id.tv_payment_price)).setText("￥" + this.f14415F);
        ((TextView) findViewById(R.id.tv_type)).setText(mo6060h() == 0 ? R.string.start_wechat_pay : R.string.start_alipay);
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancelPay) {
            m6059i();
        } else if (id != R.id.btnPayed) {
        } else {
            this.f14412C.postDelayed(new RunnableC2507b(this), 3000L);
            LoadDialog.m4682a(this.f10981q, this.f10981q.getString(R.string.request_payment_result), true);
        }
    }

    /* renamed from: i */
    private void m6059i() {
        MessageDialog messageDialog = new MessageDialog(this.f10981q, (int) R.string.common_title_tips, (int) R.string.order_pay_tips, false, (byte) 0);
        messageDialog.m4713f(2);
        messageDialog.m4719a(R.string.yes, true, new View$OnClickListenerC2508c(this));
        messageDialog.m4717b(R.string.no, true, null);
        messageDialog.show();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 9000) {
            try {
                return new PayAction(this.f10981q).m5339j(this.f14413D);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        LoadDialog.m4681b(this.f10981q);
        if (i == 9000 && obj != null) {
            CyOrderInfoResponse cyOrderInfoResponse = (CyOrderInfoResponse) obj;
            if (cyOrderInfoResponse.getCyOrderInfoResult().getCode() == 0) {
                int orderState = cyOrderInfoResponse.getCyOrderInfoResult().getCyOrderInfo().getOrderState();
                if (orderState == 1) {
                    NToast.m9450a(this.f10981q, (int) R.string.pay_success);
                    setResult(-1);
                    finish();
                } else if (orderState == 0) {
                    NToast.m9450a(this.f10981q, (int) R.string.order_nonpayment_title);
                }
            }
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        LoadDialog.m4681b(this.f10981q);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            m6059i();
            return true;
        }
        return true;
    }
}
