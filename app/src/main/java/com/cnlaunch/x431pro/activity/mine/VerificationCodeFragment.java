package com.cnlaunch.x431pro.activity.mine;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.module.p272k.p274b.UserParam;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.mine.dh */
/* loaded from: classes.dex */
public class VerificationCodeFragment extends BaseFragment {

    /* renamed from: d */
    private UserAction f14206d;

    /* renamed from: g */
    private TextView f14209g;

    /* renamed from: h */
    private Button f14210h;

    /* renamed from: i */
    private Button f14211i;

    /* renamed from: j */
    private TextView f14212j;

    /* renamed from: b */
    private final int f14204b = 2110;

    /* renamed from: c */
    private final int f14205c = 2111;

    /* renamed from: e */
    private String f14207e = "";

    /* renamed from: f */
    private String f14208f = "";

    /* renamed from: k */
    private int f14213k = 0;

    /* renamed from: a */
    CountDownTimer f14203a = new CountDownTimerC2483dk(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.bundle != null) {
            this.f14207e = this.bundle.getString("bindingType");
            this.f14208f = this.bundle.getString("EmailOrPhone");
        }
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14209g = (TextView) getActivity().findViewById(R.id.tv_verify_tips);
        this.f14210h = (Button) getActivity().findViewById(R.id.bt_get_verify_code);
        this.f14210h.setOnClickListener(new View$OnClickListenerC2481di(this));
        if (!TextUtils.isEmpty(this.f14207e)) {
            if ("0".equals(this.f14207e)) {
                this.f14210h.setVisibility(8);
                this.f14209g.setText(getString(R.string.mine_set_verify_email_tips));
            } else if ("1".equals(this.f14207e)) {
                this.f14203a.start();
                this.f14210h.setVisibility(0);
                if (!TextUtils.isEmpty(this.f14208f)) {
                    this.f14209g.setText(getString(R.string.mine_set_verify_phone_tips, new Object[]{this.f14208f}));
                }
            }
        }
        this.f14211i = (Button) getActivity().findViewById(R.id.bt_send_change);
        this.f14212j = (TextView) getActivity().findViewById(R.id.et_verify_code);
        this.f14211i.setOnClickListener(new View$OnClickListenerC2482dj(this));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.verification_code_fragment, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2110:
                this.f14206d = new UserAction(this.mContext);
                return this.f14206d.m5267a(this.f14208f, LangManager.m9469a(), "1");
            case 2111:
                UserParam userParam = new UserParam();
                if ("0".equals(this.f14207e)) {
                    userParam.f15609e = this.f14208f;
                } else {
                    userParam.f15610f = this.f14208f;
                }
                userParam.f15611g = this.f14212j.getText().toString();
                this.f14206d = new UserAction(this.mContext);
                return this.f14206d.m5271a(userParam);
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        switch (i) {
            case 2110:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    if (isSuccess(((CommonResponse) obj).getCode())) {
                        NToast.m9449a(this.mContext, getResources().getString(R.string.set_verify_get_success));
                        this.f14203a.start();
                        return;
                    }
                    NToast.m9449a(this.mContext, getResources().getString(R.string.set_verify_get_failure));
                    return;
                }
                return;
            case 2111:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    CommonResponse commonResponse = (CommonResponse) obj;
                    if (isSuccess(commonResponse.getCode())) {
                        CountDownTimer countDownTimer = this.f14203a;
                        if (countDownTimer != null) {
                            countDownTimer.cancel();
                        }
                        this.f14212j.setHint(getResources().getString(R.string.mine_verification_code_prompt));
                        for (int i2 = 0; i2 < getFragmentManager().getBackStackEntryCount() - 1; i2++) {
                            getFragmentManager().popBackStack();
                        }
                        return;
                    } else if (commonResponse.getCode() == 1) {
                        NToast.m9449a(this.mContext, getResources().getString(R.string.mine_bind_verification_code_erroe));
                        return;
                    } else {
                        NToast.m9449a(this.mContext, getResources().getString(R.string.mine_bind_failure));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case 2110:
                LoadDialog.m4681b(this.mContext);
                NToast.m9449a(this.mContext, getResources().getString(R.string.set_verify_get_failure));
                return;
            case 2111:
                LoadDialog.m4681b(this.mContext);
                NToast.m9449a(this.mContext, getResources().getString(R.string.mine_bind_failure));
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public boolean isSuccess(int i) {
        return super.isSuccess(i);
    }
}
