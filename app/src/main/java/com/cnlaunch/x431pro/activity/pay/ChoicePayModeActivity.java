package com.cnlaunch.x431pro.activity.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.cnlaunch.diagnosemodule.wiget.LoadDialog;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p164f.EventListener;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.info.FragmentC2297z;
import com.cnlaunch.x431pro.activity.pay.p233b.UnionpayHandler;
import com.cnlaunch.x431pro.module.p258f.p259a.PayAction;
import com.cnlaunch.x431pro.module.p258f.p260b.AlipayQrCodeCyResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderInfo;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderInfoResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderInfoResult;
import com.cnlaunch.x431pro.module.p258f.p260b.CyResultBase;
import com.cnlaunch.x431pro.module.p258f.p260b.UnionTradeResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.UnionTradeResult;
import com.cnlaunch.x431pro.module.p258f.p260b.WxPayResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.WxPayResult;
import com.ifoer.expedition.pro.R;
import com.unionpay.UPPayAssistEx;
import com.unionpay.tsmservice.data.Constant;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class ChoicePayModeActivity extends ActivityC2004c implements View.OnClickListener {

    /* renamed from: G */
    private UnionpayHandler f14355G;

    /* renamed from: H */
    private PreferencesManager f14356H;

    /* renamed from: I */
    private String f14357I;

    /* renamed from: J */
    private LinearLayout f14358J;

    /* renamed from: K */
    private LinearLayout f14359K;

    /* renamed from: L */
    private PayAction f14360L;

    /* renamed from: M */
    private TextView f14361M;

    /* renamed from: N */
    private TextView f14362N;

    /* renamed from: O */
    private TextView f14363O;

    /* renamed from: P */
    private TextView f14364P;

    /* renamed from: Q */
    private Button f14365Q;

    /* renamed from: R */
    private RadioButton f14366R;

    /* renamed from: S */
    private RadioButton f14367S;

    /* renamed from: T */
    private RadioButton f14368T;

    /* renamed from: U */
    private RadioGroup f14369U;

    /* renamed from: V */
    private int f14370V;

    /* renamed from: n */
    boolean f14376n;

    /* renamed from: C */
    private final int f14351C = 2001;

    /* renamed from: D */
    private final int f14352D = 2002;

    /* renamed from: E */
    private final int f14353E = SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED;

    /* renamed from: F */
    private final int f14354F = UIMsg.m_AppUI.MSG_APP_VERSION;

    /* renamed from: W */
    private final int f14371W = 1;

    /* renamed from: X */
    private final int f14372X = 2;

    /* renamed from: Y */
    private final int f14373Y = 3;

    /* renamed from: Z */
    private EventListener f14374Z = new C2510e(this);

    /* renamed from: aa */
    private final int f14375aa = 0;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14356H = PreferencesManager.m9595a(this.f10981q);
        setContentView(R.layout.activity_choice_pay_mode);
        m7737d(8);
        this.f10988x = false;
        m7735e(8);
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            this.f14357I = getIntent().getStringExtra("LaunchOrderNO");
        }
        LoadDialog.show(this, getString(R.string.pull_to_refresh_refreshing_label));
        m7739c(2001);
        this.f14358J = (LinearLayout) findViewById(R.id.layout_Alipay);
        this.f14359K = (LinearLayout) findViewById(R.id.layout_Unionpay);
        this.f14361M = (TextView) findViewById(R.id.cy_order_num);
        this.f14362N = (TextView) findViewById(R.id.cy_order_date);
        this.f14363O = (TextView) findViewById(R.id.cy_order_price);
        this.f14364P = (TextView) findViewById(R.id.cy_order_type_name);
        this.f14369U = (RadioGroup) findViewById(R.id.radioGroup);
        this.f14365Q = (Button) findViewById(R.id.pay_now);
        this.f14365Q.setOnClickListener(this);
        this.f14369U.setOnCheckedChangeListener(new C2509d(this));
        this.f14366R = (RadioButton) findViewById(R.id.radioAlipay);
        this.f14367S = (RadioButton) findViewById(R.id.radioUnionpay);
        this.f14368T = (RadioButton) findViewById(R.id.radioWechatPay);
        if (this.f14366R.isChecked()) {
            this.f14370V = 1;
        }
        if (this.f14367S.isChecked()) {
            this.f14370V = 2;
        }
        if (this.f14368T.isChecked()) {
            this.f14370V = 3;
        }
        this.f14361M.setText(this.f14357I);
        this.f14358J.setOnClickListener(this);
        this.f14359K.setOnClickListener(this);
        this.f14355G = new UnionpayHandler();
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        try {
            if (this.f14360L == null) {
                this.f14360L = new PayAction(this.f10981q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (i) {
            case 2001:
                return this.f14360L.m5339j(this.f14357I);
            case 2002:
                return this.f14360L.m5334o(this.f14357I);
            case SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED /* 2003 */:
                return this.f14360L.m5342g(this.f14357I);
            case UIMsg.m_AppUI.MSG_APP_VERSION /* 2004 */:
                return this.f14360L.m5351a(this.f14357I);
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        CyOrderInfoResult cyOrderInfoResult;
        UnionTradeResult wsresult;
        WxPayResult wxPayResult;
        switch (i) {
            case 2001:
                LoadDialog.dismiss(this.f10981q);
                if (obj == null || (cyOrderInfoResult = ((CyOrderInfoResponse) obj).getCyOrderInfoResult()) == null || cyOrderInfoResult.getCode() != 0) {
                    return;
                }
                CyOrderInfo cyOrderInfo = cyOrderInfoResult.getCyOrderInfo();
                this.f14362N.setText(cyOrderInfo.getOrderCreateTime());
                TextView textView = this.f14363O;
                textView.setText("￥" + cyOrderInfo.getOrderPrice());
                this.f14364P.setText(cyOrderInfo.getOrderTypeName());
                return;
            case 2002:
                LoadDialog.dismiss(this.f10981q);
                if (obj instanceof AlipayQrCodeCyResponse) {
                    AlipayQrCodeCyResponse alipayQrCodeCyResponse = (AlipayQrCodeCyResponse) obj;
                    if (alipayQrCodeCyResponse.getCode() == 0) {
                        AlipayActivity.m6071a(this, this.f14357I, alipayQrCodeCyResponse.getResultData().getQrCode(), String.valueOf(alipayQrCodeCyResponse.getResultData().getTotalPrice()));
                        return;
                    }
                    return;
                }
                return;
            case SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED /* 2003 */:
                LoadDialog.dismiss(this.f10981q);
                if (obj == null || (wsresult = ((UnionTradeResponse) obj).getWsresult()) == null || wsresult.getCode() != 0) {
                    return;
                }
                String data = wsresult.getData();
                String str = "00";
                str = (ApplicationConfig.f7812k.equals("http://golo.test.x431.com:8008/dev") || ApplicationConfig.f7812k.equals("http://192.168.85.212:8081/dev")) ? "01" : "01";
                HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                UPPayAssistEx.startPay(this, null, null, data, str);
                return;
            case UIMsg.m_AppUI.MSG_APP_VERSION /* 2004 */:
                LoadDialog.dismiss(this.f10981q);
                if (obj == null || (wxPayResult = ((WxPayResponse) obj).getWxPayResult()) == null) {
                    return;
                }
                if (wxPayResult.getCode() == 0) {
                    WechatpayActivity.m6062a(this, wxPayResult.getResultData().getOutTradeNo(), wxPayResult.getResultData().getCodeUrl(), String.valueOf(wxPayResult.getResultData().getPrice()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        CyResultBase cyresult;
        CyResultBase cyresult2;
        super.onFailure(i, i2, obj);
        switch (i) {
            case 2001:
                LoadDialog.dismiss(this);
                if (obj == null || (cyresult = ((CyOrderInfoResponse) obj).getCyresult()) == null) {
                    return;
                }
                FragmentC2297z.m6823a(this.f10981q, cyresult.getCode());
                return;
            case 2002:
                LoadDialog.dismiss(this);
                if (obj != null) {
                    FragmentC2297z.m6823a(this.f10981q, ((AlipayQrCodeCyResponse) obj).getCode());
                    return;
                }
                return;
            case SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED /* 2003 */:
                LoadDialog.dismiss(this.f10981q);
                if (obj == null || (cyresult2 = ((UnionTradeResponse) obj).getCyresult()) == null) {
                    return;
                }
                FragmentC2297z.m6823a(this.f10981q, cyresult2.getCode());
                return;
            case UIMsg.m_AppUI.MSG_APP_VERSION /* 2004 */:
                LoadDialog.dismiss(this.f10981q);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.pay_now) {
            int i = this.f14370V;
            if (i == 2) {
                m7739c(SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED);
            } else if (i != 3) {
                m7739c(2002);
            } else {
                m7739c(UIMsg.m_AppUI.MSG_APP_VERSION);
            }
            LoadDialog.show(this, getString(R.string.pull_to_refresh_refreshing_label));
            return;
        }
        switch (id) {
            case R.id.layout_Alipay /* 2131297236 */:
                m7739c(2002);
                return;
            case R.id.layout_Unionpay /* 2131297237 */:
                m7739c(SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED);
                return;
            default:
                return;
        }
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            if (i2 == -1) {
                finish();
            }
        } else if (i != 10) {
        } else {
            Context context = this.f10981q;
            if (intent == null || context == null) {
                return;
            }
            String string = intent.getExtras().getString("pay_result");
            if (string.equalsIgnoreCase(Constant.CASH_LOAD_SUCCESS)) {
                this.f10981q.sendBroadcast(new Intent("user_unionpay_finish"));
                m6067h();
                NToast.longToast(context, (int) R.string.pay_success);
            } else if (string.equalsIgnoreCase("fail")) {
                NToast.longToast(context, (int) R.string.pay_failed);
            } else if (string.equalsIgnoreCase("cancel")) {
                NToast.longToast(context, (int) R.string.pay_cancal);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            m6067h();
            return true;
        }
        return true;
    }

    /* renamed from: h */
    private void m6067h() {
        sendBroadcast(new Intent("show_repairinfo"));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m6068b(ChoicePayModeActivity choicePayModeActivity) {
        NToast.shortToast(choicePayModeActivity.f10981q, (int) R.string.pay_success);
        choicePayModeActivity.m6067h();
    }
}
