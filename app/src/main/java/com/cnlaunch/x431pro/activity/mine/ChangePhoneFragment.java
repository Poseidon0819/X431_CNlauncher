package com.cnlaunch.x431pro.activity.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.UserSettingInfo;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.mine.l */
/* loaded from: classes.dex */
public class ChangePhoneFragment extends BaseFragment {

    /* renamed from: g */
    private UserAction f14253g;

    /* renamed from: j */
    private Button f14256j;

    /* renamed from: k */
    private EditText f14257k;

    /* renamed from: l */
    private Button f14258l;

    /* renamed from: m */
    private EditText f14259m;

    /* renamed from: a */
    private final int f14247a = 2108;

    /* renamed from: b */
    private final int f14248b = 2109;

    /* renamed from: c */
    private final int f14249c = 2110;

    /* renamed from: d */
    private final int f14250d = 30031;

    /* renamed from: e */
    private final int f14251e = 110001;

    /* renamed from: f */
    private final int f14252f = 110002;

    /* renamed from: h */
    private String f14254h = "";

    /* renamed from: i */
    private String f14255i = "";

    /* renamed from: n */
    private String f14260n = "";

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.bundle != null) {
            this.f14254h = this.bundle.getString("phone_number");
            this.f14255i = this.bundle.getString("is_bind_mobile");
        }
        this.f14253g = new UserAction(this.mContext);
        setTitle(R.string.mine_tv_phone);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14257k = (EditText) getActivity().findViewById(R.id.et_mine_phone);
        this.f14256j = (Button) getActivity().findViewById(R.id.but_mine_phone);
        this.f14256j.setEnabled(false);
        this.f14257k.setText(this.f14254h);
        this.f14256j.setOnClickListener(new View$OnClickListenerC2489m(this));
        this.f14258l = (Button) getActivity().findViewById(R.id.btn_get_verify_code);
        this.f14258l.setOnClickListener(new View$OnClickListenerC2490n(this));
        this.f14259m = (EditText) getActivity().findViewById(R.id.edit_verify_code);
        this.f14259m.addTextChangedListener(new C2491o(this));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.change_mobile_fragment, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2108:
                return this.f14253g.m5266a(this.f14254h, LangManager.m9469a(), "3", null);
            case 2109:
                UserSettingInfo userSettingInfo = new UserSettingInfo();
                userSettingInfo.setMobile(this.f14254h);
                this.f14260n = this.f14259m.getText().toString();
                userSettingInfo.setVcode(this.f14260n);
                return this.f14253g.m5270a(userSettingInfo);
            case 2110:
                this.f14260n = this.f14259m.getText().toString();
                return this.f14253g.m5268a(this.f14254h, this.f14260n);
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        switch (i) {
            case 2108:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    CommonResponse commonResponse = (CommonResponse) obj;
                    if (isSuccess(commonResponse.getCode())) {
                        NToast.m9449a(this.mContext, this.mContext.getString(R.string.mine_set_verify_phone_tips, this.f14254h));
                        return;
                    }
                    int code = commonResponse.getCode();
                    if (code == 30040) {
                        NToast.m9450a(this.mContext, (int) R.string.more_than_sending_number);
                        return;
                    } else if (code == 110001) {
                        NToast.m9450a(this.mContext, (int) R.string.register_fail_prompt_30007);
                        return;
                    } else {
                        switch (code) {
                            case 30030:
                                return;
                            case 30031:
                                NToast.m9450a(this.mContext, (int) R.string.retrieve_password_operate_frequently);
                                return;
                            default:
                                NToast.m9450a(this.mContext, (int) R.string.get_identify_code_fail_prompt);
                                return;
                        }
                    }
                }
                return;
            case 2109:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    CommonResponse commonResponse2 = (CommonResponse) obj;
                    if (isSuccess(commonResponse2.getCode())) {
                        getFragmentManager().popBackStack();
                        return;
                    } else if (30027 == commonResponse2.getCode()) {
                        NToast.m9446b(this.mContext, getResources().getString(R.string.mine_bind_phone_error));
                        return;
                    } else {
                        NToast.m9446b(this.mContext, getResources().getString(R.string.mine_modify_phonefile));
                        return;
                    }
                }
                return;
            case 2110:
                LoadDialog.m4681b(this.mContext);
                if (isSuccess(((CommonResponse) obj).getCode())) {
                    this.f14256j.setEnabled(true);
                    return;
                } else {
                    NToast.m9450a(getActivity(), (int) R.string.mine_bind_verification_code_erroe);
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case 2108:
                LoadDialog.m4681b(this.mContext);
                return;
            case 2109:
                LoadDialog.m4681b(this.mContext);
                NToast.m9446b(this.mContext, getResources().getString(R.string.mine_modify_phonefile));
                return;
            case 2110:
                LoadDialog.m4681b(this.mContext);
                return;
            default:
                return;
        }
    }
}
