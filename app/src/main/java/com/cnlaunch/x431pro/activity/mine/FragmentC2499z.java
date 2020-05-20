package com.cnlaunch.x431pro.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LcButton;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p258f.p259a.PayAction;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: CreditCardFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.z */
/* loaded from: classes.dex */
public class FragmentC2499z extends BaseFragment {

    /* renamed from: b */
    private String f14336b;

    /* renamed from: c */
    private String f14337c;

    /* renamed from: d */
    private String f14338d;

    /* renamed from: e */
    private String f14339e;

    /* renamed from: f */
    private ClearEditText f14340f;

    /* renamed from: g */
    private ClearEditText f14341g;

    /* renamed from: h */
    private ClearEditText f14342h;

    /* renamed from: i */
    private ClearEditText f14343i;

    /* renamed from: j */
    private LcButton f14344j;

    /* renamed from: a */
    private String f14335a = "";

    /* renamed from: k */
    private boolean f14345k = false;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_credit_card_pay, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.mine_credit_card);
        this.f14340f = (ClearEditText) getActivity().findViewById(R.id.card_num);
        this.f14341g = (ClearEditText) getActivity().findViewById(R.id.exp_mm);
        this.f14342h = (ClearEditText) getActivity().findViewById(R.id.exp_yy);
        this.f14343i = (ClearEditText) getActivity().findViewById(R.id.security_code);
        this.f14344j = (LcButton) getActivity().findViewById(R.id.btn_submit);
        this.f14344j.setOnClickListener(new CreditCardFragment(this));
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle bundle = getBundle();
        if (bundle != null) {
            this.f14335a = bundle.getString("order_sn");
            NLog.m9456a("CreditCardFragment", "orderSN: " + this.f14335a);
            if (bundle.containsKey("isFromOrder")) {
                this.f14345k = bundle.getBoolean("isFromOrder");
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 2001) {
            new PayAction(this.mContext);
            String str = this.f14336b;
            return PayAction.m5348a(str, this.f14337c + this.f14338d, this.f14339e, this.f14335a);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (2001 == i) {
            LoadDialog.m4681b(this.mContext);
            if (obj == null || !(obj instanceof BaseResponse)) {
                return;
            }
            BaseResponse baseResponse = (BaseResponse) obj;
            if (baseResponse.getCode() == 1) {
                NToast.m9446b(this.mContext, "Success!");
                getFragmentManager().popBackStack();
                if (this.f14345k) {
                    return;
                }
                getFragmentManager().popBackStack();
                return;
            }
            NToast.m9446b(this.mContext, baseResponse.getMessage());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        LoadDialog.m4681b(this.mContext);
        super.onFailure(i, i2, obj);
    }
}
