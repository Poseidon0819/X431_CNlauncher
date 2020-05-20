package com.cnlaunch.x431pro.activity.mine;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.module.p255e.p256a.PincardAction;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductUpgradeResult;
import com.cnlaunch.x431pro.module.p258f.p259a.PayAction;
import com.cnlaunch.x431pro.module.p258f.p260b.ConfigPriceResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.OrderCreateResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderResponse;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.mine.bn */
/* loaded from: classes.dex */
public class PayTypeFragment extends BaseFragment {

    /* renamed from: a */
    private TextView f13937a;

    /* renamed from: b */
    private TextView f13938b;

    /* renamed from: c */
    private TextView f13939c;

    /* renamed from: d */
    private TextView f13940d;

    /* renamed from: e */
    private TextView f13941e;

    /* renamed from: f */
    private ProductUpgradeResult f13942f;

    /* renamed from: g */
    private ConfigPriceResponse f13943g;

    /* renamed from: h */
    private OrderCreateResponse f13944h;

    /* renamed from: i */
    private String f13945i = "";

    /* renamed from: j */
    private Handler f13946j = null;

    /* renamed from: k */
    private boolean f13947k = true;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_pay_type, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.mine_pay_type);
        this.f13937a = (TextView) getActivity().findViewById(R.id.sn);
        this.f13938b = (TextView) getActivity().findViewById(R.id.software_name);
        this.f13939c = (TextView) getActivity().findViewById(R.id.expiration_date);
        this.f13940d = (TextView) getActivity().findViewById(R.id.fee);
        this.f13941e = (TextView) getActivity().findViewById(R.id.fee2);
        this.f13937a.setText(getString(R.string.mine_sn, new Object[]{getBundle().getString("serialNo")}));
        this.f13938b.setText(getString(R.string.mine_software_name, new Object[]{""}));
        this.f13939c.setText(getString(R.string.mine_expiration_date, new Object[]{""}));
        this.f13940d.setText(getString(R.string.mine_pay_pal_fee, new Object[]{""}));
        this.f13941e.setText(getString(R.string.mine_pay_pal_fee, new Object[]{""}));
        View findViewById = getActivity().findViewById(R.id.btn_paypal);
        View findViewById2 = getActivity().findViewById(R.id.btn_pin_card);
        View findViewById3 = getActivity().findViewById(R.id.btn_credit_card);
        findViewById.setOnClickListener(new View$OnClickListenerC2441bo(this));
        findViewById2.setOnClickListener(new View$OnClickListenerC2442bp(this));
        findViewById3.setOnClickListener(new View$OnClickListenerC2443bq(this));
        if (C2744aa.m5166c() || C2744aa.m5160d()) {
            getActivity().findViewById(R.id.paypal_title).setVisibility(8);
            getActivity().findViewById(R.id.paypal_container).setVisibility(8);
            ((TextView) getActivity().findViewById(R.id.pincard_title)).setText(this.mContext.getResources().getString(R.string.mine_pin_card_pay_title).replace("2. ", ""));
            ((TextView) getActivity().findViewById(R.id.creditcard_title)).setText(this.mContext.getResources().getString(R.string.mine_credit_card_title).replace("3. ", ""));
        }
        if (C2744aa.m5160d()) {
            getActivity().findViewById(R.id.creditcard_title).setVisibility(8);
            getActivity().findViewById(R.id.creditcard_container).setVisibility(8);
        }
        this.f13946j = new HandlerC2444br(this);
        LoadDialog.m4680b(this.mContext, getString(R.string.refresh_txt));
        request(1001);
        this.f13947k = false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        UserOrderResponse m5336m;
        switch (i) {
            case 1001:
                this.f13943g = new PayAction(this.mContext).m5337l(getBundle().getString("serialNo"));
                return this.f13943g;
            case 1002:
                this.f13942f = new PincardAction(this.mContext).m5354h(getBundle().getString("serialNo"));
                return this.f13942f;
            case 1003:
                PayAction payAction = new PayAction(this.mContext);
                this.f13944h = payAction.m5349a(getBundle().getString("serialNo"), "zh_CN");
                OrderCreateResponse orderCreateResponse = this.f13944h;
                if (orderCreateResponse != null && orderCreateResponse.getCode() == 0 && (m5336m = payAction.m5336m(this.f13944h.getOrdersn())) != null && m5336m.getCode() == 0) {
                    this.f13945i = PayAction.m5335n(Integer.toString(m5336m.getUserOrderDTO().getOrderid()));
                }
                return this.f13944h;
            case 1004:
                this.f13944h = new PayAction(this.mContext).m5349a(getBundle().getString("serialNo"), "zh_CN");
                return this.f13944h;
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (this.f13947k) {
            return;
        }
        if (1001 == i) {
            if (obj != null && (obj instanceof ConfigPriceResponse)) {
                ConfigPriceResponse configPriceResponse = (ConfigPriceResponse) obj;
                if (configPriceResponse.getCode() == 0) {
                    this.f13946j.sendMessage(this.f13946j.obtainMessage(100, i, configPriceResponse.getCode(), configPriceResponse));
                } else {
                    this.f13946j.sendMessage(this.f13946j.obtainMessage(101, i, configPriceResponse.getCode(), configPriceResponse.getMessage()));
                }
            }
            request(1002);
        } else if (1002 == i) {
            if (obj != null && (obj instanceof ProductUpgradeResult)) {
                ProductUpgradeResult productUpgradeResult = (ProductUpgradeResult) obj;
                if (productUpgradeResult.getCode() == 0) {
                    this.f13946j.sendMessage(this.f13946j.obtainMessage(100, i, productUpgradeResult.getCode(), productUpgradeResult));
                } else {
                    this.f13946j.sendMessage(this.f13946j.obtainMessage(101, i, productUpgradeResult.getCode(), productUpgradeResult.getMessage()));
                }
            }
        } else if (1003 == i) {
            if (obj != null && (obj instanceof OrderCreateResponse)) {
                OrderCreateResponse orderCreateResponse = (OrderCreateResponse) obj;
                if (orderCreateResponse.getCode() == 0) {
                    this.f13946j.sendMessage(this.f13946j.obtainMessage(100, i, orderCreateResponse.getCode(), orderCreateResponse));
                } else {
                    this.f13946j.sendMessage(this.f13946j.obtainMessage(101, i, orderCreateResponse.getCode(), orderCreateResponse.getMessage()));
                }
            }
        } else if (1004 == i && obj != null && (obj instanceof OrderCreateResponse)) {
            OrderCreateResponse orderCreateResponse2 = (OrderCreateResponse) obj;
            if (orderCreateResponse2.getCode() == 0) {
                this.f13946j.sendMessage(this.f13946j.obtainMessage(100, i, orderCreateResponse2.getCode(), orderCreateResponse2));
            } else {
                this.f13946j.sendMessage(this.f13946j.obtainMessage(101, i, orderCreateResponse2.getCode(), orderCreateResponse2.getMessage()));
            }
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (this.f13947k) {
            return;
        }
        this.f13946j.sendMessage(this.f13946j.obtainMessage(101, i, i2));
        if (1001 == i) {
            request(1002);
        }
        super.onFailure(i, i2, obj);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f13947k = true;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public Bundle getBundle() {
        return super.getBundle() == null ? getArguments() : super.getBundle();
    }
}
