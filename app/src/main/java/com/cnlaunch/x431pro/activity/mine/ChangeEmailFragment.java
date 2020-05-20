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
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.mine.g */
/* loaded from: classes.dex */
public class ChangeEmailFragment extends BaseFragment {

    /* renamed from: c */
    private UserAction f14223c;

    /* renamed from: d */
    private String f14224d;

    /* renamed from: e */
    private Button f14225e;

    /* renamed from: f */
    private EditText f14226f;

    /* renamed from: a */
    private final int f14221a = 2106;

    /* renamed from: b */
    private final int f14222b = 2107;

    /* renamed from: g */
    private String f14227g = "";

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            this.f14224d = bundle2.getString("email");
            this.f14227g = bundle2.getString("is_bind_email");
        }
        setTitle(R.string.mine_tv_email);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14226f = (EditText) getActivity().findViewById(R.id.et_mine_email);
        this.f14225e = (Button) getActivity().findViewById(R.id.but_mine_email);
        this.f14225e.setEnabled(false);
        this.f14226f.addTextChangedListener(new C2486h(this));
        if ("1".equals(this.f14227g)) {
            this.f14226f.setText(this.f14224d);
            this.f14225e.setText(getResources().getString(R.string.mine_but_update_email));
            this.f14225e.setEnabled(true);
        } else if (!this.f14224d.isEmpty()) {
            this.f14226f.setText(this.f14224d);
            this.f14225e.setEnabled(true);
        }
        this.f14226f.setOnEditorActionListener(new C2487i(this));
        this.f14225e.setOnClickListener(new View$OnClickListenerC2488j(this));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.change_email_fragment, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 2106:
                this.f14223c = new UserAction(this.mContext);
                return this.f14223c.m5273a();
            case 2107:
                this.f14223c = new UserAction(this.mContext);
                return this.f14223c.m5267a(this.f14226f.getText().toString(), LangManager.m9469a(), "1");
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        switch (i) {
            case 2106:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    if (isSuccess(((CommonResponse) obj).getCode())) {
                        getFragmentManager().popBackStack();
                        return;
                    } else {
                        NToast.m9446b(this.mContext, getResources().getString(R.string.mine_toast_bind_failure));
                        return;
                    }
                }
                return;
            case 2107:
                LoadDialog.m4681b(this.mContext);
                if (obj != null) {
                    CommonResponse commonResponse = (CommonResponse) obj;
                    if (isSuccess(commonResponse.getCode())) {
                        Bundle bundle = new Bundle();
                        bundle.putString("bindingType", "0");
                        bundle.putString("EmailOrPhone", this.f14226f.getText().toString());
                        replaceFragment(VerificationCodeFragment.class.getName(), bundle);
                        return;
                    }
                    int code = commonResponse.getCode();
                    if (code == 30040) {
                        NToast.m9450a(this.mContext, (int) R.string.more_than_sending_number);
                        return;
                    } else if (code == 110001) {
                        NToast.m9446b(this.mContext, getResources().getString(R.string.mine_toast_bind_already));
                        return;
                    } else {
                        switch (code) {
                            case 30030:
                                return;
                            case 30031:
                                NToast.m9450a(this.mContext, (int) R.string.register_fail_prompt_30007);
                                return;
                            default:
                                NToast.m9450a(this.mContext, (int) R.string.get_identify_code_fail_prompt);
                                return;
                        }
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
            case 2106:
                LoadDialog.m4681b(this.mContext);
                NToast.m9446b(this.mContext, getResources().getString(R.string.mine_toast_bind_failure));
                return;
            case 2107:
                LoadDialog.m4681b(this.mContext);
                NToast.m9446b(this.mContext, getResources().getString(R.string.set_verify_get_failure));
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
