package com.cnlaunch.x431pro.activity.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.wiget.LoadDialog;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.info.CyUserInfo;
import com.cnlaunch.x431pro.activity.info.CyUtil;
import com.cnlaunch.x431pro.activity.info.FragmentC2297z;
import com.cnlaunch.x431pro.module.p258f.p259a.PayAction;
import com.cnlaunch.x431pro.module.p258f.p260b.CyBaseResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderInfo;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderInfoResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderInfoResult;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderResult;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderType;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderTypeResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderTypeResult;
import com.cnlaunch.x431pro.module.p258f.p260b.CyResultBase;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* loaded from: classes.dex */
public class PlaceOrderActivity extends ActivityC2004c implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: F */
    private PayAction f14380F;

    /* renamed from: G */
    private String f14381G;

    /* renamed from: H */
    private TextView f14382H;

    /* renamed from: I */
    private TextView f14383I;

    /* renamed from: J */
    private TextView f14384J;

    /* renamed from: K */
    private TextView f14385K;

    /* renamed from: L */
    private TextView f14386L;

    /* renamed from: M */
    private TextView f14387M;

    /* renamed from: N */
    private TextView f14388N;

    /* renamed from: O */
    private TextView f14389O;

    /* renamed from: P */
    private Button f14390P;

    /* renamed from: Q */
    private Button f14391Q;

    /* renamed from: R */
    private Button f14392R;

    /* renamed from: S */
    private LinearLayout f14393S;

    /* renamed from: T */
    private LinearLayout f14394T;

    /* renamed from: U */
    private ListView f14395U;

    /* renamed from: V */
    private C2502a f14396V;

    /* renamed from: W */
    private boolean f14397W;

    /* renamed from: X */
    private CyUserInfo f14398X;

    /* renamed from: Y */
    private View f14399Y;

    /* renamed from: Z */
    private View f14400Z;

    /* renamed from: aa */
    private TextView f14401aa;

    /* renamed from: ab */
    private TextView f14402ab;

    /* renamed from: ac */
    private TextView f14403ac;

    /* renamed from: n */
    private final int f14404n = 201;

    /* renamed from: C */
    private final int f14377C = 202;

    /* renamed from: D */
    private final int f14378D = 2001;

    /* renamed from: E */
    private final int f14379E = 203;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_place_order);
        m7737d(8);
        this.f10988x = false;
        m7735e(8);
        this.f14380F = new PayAction(this.f10981q);
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
            this.f14381G = getIntent().getStringExtra("LaunchOrderNO");
            this.f14397W = getIntent().getBooleanExtra("isOfficialUser", false);
            this.f14398X = (CyUserInfo) getIntent().getSerializableExtra("cyUserInfo");
        }
        StringBuilder sb = new StringBuilder("PlaceOrderActivity---launchOrderNo=");
        sb.append(this.f14381G);
        sb.append(",mIsOfficialUser=");
        sb.append(this.f14397W);
        sb.append(",mCyUserInfo=");
        sb.append(this.f14398X);
        this.f14383I = (TextView) findViewById(R.id.cy_order_type_id);
        this.f14382H = (TextView) findViewById(R.id.cy_order_num);
        this.f14384J = (TextView) findViewById(R.id.cy_order_type_name);
        this.f14385K = (TextView) findViewById(R.id.cy_order_type_price);
        this.f14386L = (TextView) findViewById(R.id.cy_order_type_remark);
        this.f14387M = (TextView) findViewById(R.id.order_remarks);
        this.f14388N = (TextView) findViewById(R.id.order_pay_tips);
        this.f14390P = (Button) findViewById(R.id.order_now);
        this.f14391Q = (Button) findViewById(R.id.enter_pay);
        this.f14392R = (Button) findViewById(R.id.cancel_order);
        this.f14390P.setOnClickListener(this);
        this.f14391Q.setOnClickListener(this);
        this.f14392R.setOnClickListener(this);
        this.f14393S = (LinearLayout) findViewById(R.id.cy_order_ordered_container);
        this.f14394T = (LinearLayout) findViewById(R.id.cy_order_list_container);
        this.f14395U = (ListView) findViewById(R.id.cy_order_list);
        this.f14396V = new C2502a(this);
        this.f14395U.setAdapter((ListAdapter) this.f14396V);
        this.f14395U.setOnItemClickListener(this);
        this.f14389O = (TextView) findViewById(R.id.cy_content_2);
        String string = getString(R.string.cy_user_specification_content_url_1);
        String string2 = getString(R.string.cy_user_specification_content_url_2);
        this.f14389O.setText(C2778n.C2779a.m4891a(this, getString(R.string.cy_user_specification_content_2, new Object[]{string, string2}), new String[]{string, string2}));
        this.f14400Z = findViewById(R.id.cy_order_user_specification);
        this.f14399Y = findViewById(R.id.cy_order_account_info);
        this.f14399Y.setVisibility(this.f14398X == null ? 8 : 0);
        if (this.f14398X != null) {
            this.f14401aa = (TextView) findViewById(R.id.cy_account);
            this.f14401aa.setText(this.f14398X.f12871sn);
            this.f14402ab = (TextView) findViewById(R.id.cy_password);
            this.f14402ab.setText(this.f14398X.password);
            this.f14403ac = (TextView) findViewById(R.id.cy_effective_date);
            this.f14403ac.setText(this.f14398X.beginTime + "---" + this.f14398X.endTime);
        }
        boolean z = !C2787z.m4821a(this.f14381G);
        m6066b(z);
        if (z) {
            m7739c(2001);
        }
        m7739c(201);
        LoadDialog.show(this, getString(R.string.pull_to_refresh_refreshing_label));
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i != 2001) {
            switch (i) {
                case 201:
                    try {
                        return this.f14380F.m5353a();
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                case 202:
                    try {
                        return this.f14380F.m5350a(CyUtil.C2276a.m6849a(), this.f14396V.m6064a().getOrderTypeId(), this.f14396V.m6064a().getOrderTypePrice().doubleValue());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        break;
                    }
                case 203:
                    try {
                        return this.f14380F.m5338k(this.f14381G);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        break;
                    }
            }
        } else {
            try {
                return this.f14380F.m5339j(this.f14381G);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        CyOrderInfoResult cyOrderInfoResult;
        CyOrderTypeResult cyOrderTypeResult;
        CyOrderResult cyOrderResult;
        if (i != 2001) {
            switch (i) {
                case 201:
                    LoadDialog.dismiss(this);
                    if (obj == null || (cyOrderTypeResult = ((CyOrderTypeResponse) obj).getCyOrderTypeResult()) == null || cyOrderTypeResult.getCode() != 0) {
                        return;
                    }
                    C2502a c2502a = this.f14396V;
                    c2502a.f14406b = cyOrderTypeResult.getCyOrderTypes();
                    c2502a.notifyDataSetChanged();
                    m6066b(!TextUtils.isEmpty(this.f14381G));
                    return;
                case 202:
                    LoadDialog.dismiss(this);
                    if (obj == null || (cyOrderResult = ((CyOrderResponse) obj).getCyOrderResult()) == null) {
                        return;
                    }
                    if (cyOrderResult.getCode() == 0) {
                        this.f14381G = cyOrderResult.getLaunchOrderNo();
                        Intent intent = new Intent();
                        intent.putExtra("LaunchOrderNO", this.f14381G);
                        intent.setClass(this.f10981q, ChoicePayModeActivity.class);
                        startActivity(intent);
                        finish();
                        return;
                    } else if (cyOrderResult.getCode() == 833) {
                        NToast.longToast(this, (int) R.string.cy_error_code_tips_833_2);
                        return;
                    } else {
                        return;
                    }
                case 203:
                    LoadDialog.dismiss(this);
                    if (obj == null || ((CyBaseResponse) obj).getCyresult().getCode() != 0) {
                        return;
                    }
                    m6066b(false);
                    this.f14381G = "";
                    Intent intent2 = getIntent();
                    if (intent2 != null) {
                        intent2.putExtra("LaunchOrderNO", "");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        LoadDialog.dismiss(this);
        if (obj == null || (cyOrderInfoResult = ((CyOrderInfoResponse) obj).getCyOrderInfoResult()) == null || cyOrderInfoResult.getCode() != 0) {
            return;
        }
        CyOrderInfo cyOrderInfo = cyOrderInfoResult.getCyOrderInfo();
        if (cyOrderInfo != null) {
            this.f14382H.setText(cyOrderInfo.getLaunchOrderNo());
            this.f14384J.setText(cyOrderInfo.getOrderTypeName());
            this.f14385K.setText(String.valueOf(cyOrderInfo.getOrderPrice()));
            this.f14387M.setText(String.format(getString(R.string.order_remarks), cyOrderInfo.getOrderCreateTime()));
        }
        m6066b(cyOrderInfo != null);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        CyOrderInfoResult cyOrderInfoResult;
        CyOrderTypeResult cyOrderTypeResult;
        CyOrderResult cyOrderResult;
        CyResultBase cyresult;
        super.onFailure(i, i2, obj);
        if (i != 2001) {
            switch (i) {
                case 201:
                    LoadDialog.dismiss(this);
                    if (obj == null || (cyOrderTypeResult = ((CyOrderTypeResponse) obj).getCyOrderTypeResult()) == null) {
                        return;
                    }
                    FragmentC2297z.m6823a(this.f10981q, cyOrderTypeResult.getCode());
                    return;
                case 202:
                    LoadDialog.dismiss(this);
                    if (!(obj instanceof CyOrderResponse) || (cyOrderResult = ((CyOrderResponse) obj).getCyOrderResult()) == null) {
                        return;
                    }
                    FragmentC2297z.m6823a(this.f10981q, cyOrderResult.getCode());
                    return;
                case 203:
                    LoadDialog.dismiss(this);
                    if (obj == null || (cyresult = ((CyBaseResponse) obj).getCyresult()) == null) {
                        return;
                    }
                    FragmentC2297z.m6823a(this.f10981q, cyresult.getCode());
                    return;
                default:
                    return;
            }
        }
        LoadDialog.dismiss(this);
        if (obj == null || (cyOrderInfoResult = ((CyOrderInfoResponse) obj).getCyOrderInfoResult()) == null) {
            return;
        }
        FragmentC2297z.m6823a(this.f10981q, cyOrderInfoResult.getCode());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel_order) {
            if (C2787z.m4821a(this.f14381G)) {
                NToast.shortToast(this.f10981q, (int) R.string.cy_error_code_tips_405);
                return;
            }
            m7739c(203);
            LoadDialog.show(this, getString(R.string.pull_to_refresh_refreshing_label));
        } else if (id != R.id.enter_pay) {
            if (id != R.id.order_now) {
                return;
            }
            if (this.f14397W) {
                new C2511f(this).m4609a(this.f10981q, this.f10981q.getString(R.string.dialog_title_default), this.f10981q.getString(R.string.cy_repeat_buy_tip, this.f14398X.endTime));
            } else {
                m6065h();
            }
        } else {
            Intent intent = new Intent();
            intent.putExtra("LaunchOrderNO", this.f14381G);
            intent.setFlags(67108864);
            intent.setClass(this.f10981q, ChoicePayModeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C2502a c2502a = this.f14396V;
        c2502a.f14407c = i;
        c2502a.notifyDataSetChanged();
    }

    /* renamed from: b */
    private void m6066b(boolean z) {
        setTitle(z ? R.string.buy_order : R.string.finish_order);
        this.f14383I.setText(z ? R.string.order_info : R.string.good_info);
        this.f14394T.setVisibility(z ? 8 : 0);
        this.f14390P.setVisibility(z ? 8 : 0);
        this.f14400Z.setVisibility(z ? 8 : 0);
        this.f14393S.setVisibility(z ? 0 : 8);
        this.f14391Q.setVisibility(z ? 0 : 8);
        this.f14392R.setVisibility(z ? 0 : 8);
        this.f14387M.setVisibility(z ? 0 : 8);
        this.f14388N.setVisibility(z ? 0 : 8);
    }

    /* renamed from: com.cnlaunch.x431pro.activity.pay.PlaceOrderActivity$a */
    /* loaded from: classes.dex */
    static class C2502a extends BaseAdapter {

        /* renamed from: a */
        Context f14405a;

        /* renamed from: b */
        List<CyOrderType> f14406b;

        /* renamed from: c */
        int f14407c = 0;

        /* renamed from: com.cnlaunch.x431pro.activity.pay.PlaceOrderActivity$a$a */
        /* loaded from: classes.dex */
        public static class C2503a {

            /* renamed from: a */
            CheckBox f14408a;

            /* renamed from: b */
            TextView f14409b;

            /* renamed from: c */
            TextView f14410c;

            /* renamed from: d */
            TextView f14411d;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return 0L;
        }

        public C2502a(Context context) {
            this.f14405a = context;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            List<CyOrderType> list = this.f14406b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public CyOrderType getItem(int i) {
            List<CyOrderType> list = this.f14406b;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }

        /* renamed from: a */
        public final CyOrderType m6064a() {
            return getItem(this.f14407c);
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            C2503a c2503a;
            if (view == null) {
                view = View.inflate(this.f14405a, R.layout.item_cy_order, null);
                c2503a = new C2503a();
                c2503a.f14408a = (CheckBox) view.findViewById(R.id.cb);
                c2503a.f14409b = (TextView) view.findViewById(R.id.tv_name);
                c2503a.f14410c = (TextView) view.findViewById(R.id.tv_price);
                c2503a.f14411d = (TextView) view.findViewById(R.id.tv_detail);
                view.setTag(c2503a);
            } else {
                c2503a = (C2503a) view.getTag();
            }
            CyOrderType cyOrderType = this.f14406b.get(i);
            c2503a.f14408a.setChecked(i == this.f14407c);
            c2503a.f14409b.setText(cyOrderType.getOrderTypeName());
            TextView textView = c2503a.f14410c;
            textView.setText("￥" + cyOrderType.getOrderTypePrice());
            c2503a.f14411d.setText(cyOrderType.getRemark());
            return view;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0 && getFragmentManager().getBackStackEntryCount() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: h */
    public final void m6065h() {
        m7739c(202);
        LoadDialog.show(this, getString(R.string.pull_to_refresh_refreshing_label));
    }
}
