package com.cnlaunch.x431pro.activity.mine;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.module.p255e.p256a.PincardAction;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductUpgradeResult;
import com.cnlaunch.x431pro.utils.SerialNoUtils;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.mine.bx */
/* loaded from: classes.dex */
public class PinCardPayFragment extends BaseFragment {

    /* renamed from: a */
    private ClearEditText f14010a;

    /* renamed from: b */
    private Button f14011b;

    /* renamed from: c */
    private Handler f14012c = null;

    /* renamed from: d */
    private ScrollView f14013d;

    /* renamed from: e */
    private int f14014e;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_pin_card_pay, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.mine_pin_card_pay);
        this.f14013d = (ScrollView) getActivity().findViewById(R.id.scrollview);
        this.f14010a = (ClearEditText) getActivity().findViewById(R.id.card_code);
        this.f14010a.setOnTouchListener(new View$OnTouchListenerC2449by(this));
        this.f14011b = (Button) getActivity().findViewById(R.id.submit);
        this.f14011b.setOnClickListener(new View$OnClickListenerC2452ca(this));
        this.f14010a.setOnEditorActionListener(new C2453cb(this));
        SerialNoUtils.m4827a(this.mContext).m4828a();
        this.f14012c = new HandlerC2454cc(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f14014e = this.mainActivity.getWindow().getAttributes().softInputMode;
        this.mainActivity.getWindow().setSoftInputMode(16);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mainActivity.getWindow().setSoftInputMode(this.f14014e);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (1001 == i) {
            return new PincardAction(this.mContext).m5356a(getBundle().getString("serialNo"), this.f14010a.getText().toString());
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (1001 == i && obj != null && (obj instanceof ProductUpgradeResult)) {
            ProductUpgradeResult productUpgradeResult = (ProductUpgradeResult) obj;
            if (productUpgradeResult.getCode() == 0) {
                this.f14012c.sendMessage(this.f14012c.obtainMessage(100, i, productUpgradeResult.getCode(), productUpgradeResult));
            } else {
                this.f14012c.sendMessage(this.f14012c.obtainMessage(101, i, productUpgradeResult.getCode(), productUpgradeResult.getMessage()));
            }
        }
        LoadDialog.m4681b(this.mContext);
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        LoadDialog.m4681b(this.mContext);
        this.f14012c.sendMessage(this.f14012c.obtainMessage(101, i, i2));
        super.onFailure(i, i2, obj);
    }
}
