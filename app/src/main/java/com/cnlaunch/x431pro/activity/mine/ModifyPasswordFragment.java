package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.activity.login.RegisterInfoRecord;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p272k.p273a.UserAction;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.HashMap;

/* renamed from: com.cnlaunch.x431pro.activity.mine.an */
/* loaded from: classes.dex */
public class ModifyPasswordFragment extends BaseFragment {

    /* renamed from: b */
    private ClearEditText f13675b;

    /* renamed from: c */
    private ClearEditText f13676c;

    /* renamed from: d */
    private ClearEditText f13677d;

    /* renamed from: e */
    private Button f13678e;

    /* renamed from: f */
    private CheckBox f13679f;

    /* renamed from: g */
    private CheckBox f13680g;

    /* renamed from: h */
    private CheckBox f13681h;

    /* renamed from: i */
    private String f13682i;

    /* renamed from: j */
    private String f13683j;

    /* renamed from: k */
    private String f13684k;

    /* renamed from: l */
    private PreferencesManager f13685l;

    /* renamed from: m */
    private String f13686m;

    /* renamed from: n */
    private HashMap<String, String> f13687n = new HashMap<>();

    /* renamed from: a */
    BroadcastReceiver f13674a = new C2403ao(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f13685l = PreferencesManager.m9595a(this.mContext);
        this.f13686m = this.f13685l.m9584b("login_state", "0");
        IntentFilter intentFilter = new IntentFilter("login");
        intentFilter.addAction("logout");
        this.mContext.registerReceiver(this.f13674a, intentFilter);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setTitle(R.string.modify_password_title);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f13675b = (ClearEditText) getActivity().findViewById(R.id.et_old_password);
        this.f13676c = (ClearEditText) getActivity().findViewById(R.id.et_new_password);
        this.f13677d = (ClearEditText) getActivity().findViewById(R.id.et_confirm_password);
        this.f13678e = (Button) getActivity().findViewById(R.id.btn_submit_password);
        this.f13679f = (CheckBox) getActivity().findViewById(R.id.checkbox_oldpass);
        this.f13680g = (CheckBox) getActivity().findViewById(R.id.checkbox_newpass);
        this.f13681h = (CheckBox) getActivity().findViewById(R.id.checkbox_confirmpass);
        boolean z = true;
        if (m6457a()) {
            this.f13678e.setEnabled(true);
        } else {
            this.f13678e.setEnabled(false);
        }
        this.f13675b.addTextChangedListener(new C2404ap(this));
        this.f13676c.addTextChangedListener(new C2405aq(this));
        this.f13677d.addTextChangedListener(new C2406ar(this));
        this.f13678e.setOnClickListener(new View$OnClickListenerC2407as(this));
        this.f13677d.setOnEditorActionListener(new C2408at(this));
        String str = this.f13686m;
        if ((str == null || !str.equals("1")) ? false : false) {
            return;
        }
        NToast.m9450a(this.mContext, (int) R.string.login_tip);
        m6451a(false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.modify_password_fragment, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mContext.unregisterReceiver(this.f13674a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m6457a() {
        return this.f13681h.isChecked() && this.f13680g.isChecked() && this.f13679f.isChecked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6451a(boolean z) {
        this.f13675b.setEnabled(z);
        this.f13676c.setEnabled(z);
        this.f13677d.setEnabled(z);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 3000) {
            return new UserAction(this.mContext).m5261b(this.f13682i, this.f13683j);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 3000) {
            LoadDialog.m4681b(this.mContext);
            if (obj != null) {
                CommonResponse commonResponse = (CommonResponse) obj;
                if (isSuccess(commonResponse.getCode())) {
                    NToast.m9447b(this.mContext, (int) R.string.mine_modipass_success);
                    this.f13685l.m9588a("token", "");
                    this.f13685l.m9588a("login_state", "0");
                    this.f13685l.m9588a("if_auto_login", "0");
                    this.f13685l.m9588a("login_password", "");
                    PreferencesManager preferencesManager = this.f13685l;
                    preferencesManager.m9588a(preferencesManager.m9591a("login_username"), "");
                    this.mContext.sendBroadcast(new Intent("logout"));
                    String m9591a = this.f13685l.m9591a("login_username");
                    RegisterInfoRecord registerInfoRecord = new RegisterInfoRecord();
                    this.f13687n = registerInfoRecord.m6546a();
                    if (this.f13687n.containsKey(m9591a) && !this.f13683j.equals(this.f13687n.get(m9591a))) {
                        this.f13687n.put(m9591a, "");
                        try {
                            NLog.m9451c("weiwell register_onsuccess_map", this.f13687n);
                            String m6543a = RegisterInfoRecord.m6543a(this.f13687n);
                            NLog.m9451c("weiwell register_onsuccess", m6543a);
                            registerInfoRecord.m6544a(m6543a);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    new LoginFunction(this.mContext).m6572d();
                    getFragmentManager().popBackStack();
                    return;
                }
                this.f13675b.setText("");
                m6455a(this.f13675b);
                int code = commonResponse.getCode();
                if (code == 30001) {
                    NToast.m9450a(this.mContext, (int) R.string.login_password_incorrect);
                    return;
                } else if (code == 30003) {
                    NToast.m9447b(this.mContext, (int) R.string.mine_original_pass_incorrect);
                    return;
                } else if (code != 110202) {
                    return;
                } else {
                    NToast.m9447b(this.mContext, (int) R.string.mine_modipass_failure);
                    return;
                }
            }
            return;
        }
        LoadDialog.m4681b(this.mContext);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i == 3000) {
            LoadDialog.m4681b(this.mContext);
        } else {
            LoadDialog.m4681b(this.mContext);
        }
    }

    /* renamed from: a */
    private static void m6455a(EditText editText) {
        editText.requestFocus();
        editText.setSelection(editText.getText().toString().length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6456a(CheckBox checkBox, int i, boolean z) {
        checkBox.setVisibility(i);
        checkBox.setChecked(z);
        checkBox.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static /* synthetic */ void m6438n(ModifyPasswordFragment modifyPasswordFragment) {
        modifyPasswordFragment.f13682i = modifyPasswordFragment.f13675b.getText().toString().trim();
        modifyPasswordFragment.f13683j = modifyPasswordFragment.f13676c.getText().toString().trim();
        modifyPasswordFragment.f13684k = modifyPasswordFragment.f13677d.getText().toString().trim();
        if (!C2787z.m4813f(modifyPasswordFragment.f13682i)) {
            if (modifyPasswordFragment.f13682i.length() < 6) {
                NToast.m9450a(modifyPasswordFragment.mContext, (int) R.string.register_password_is_short);
            } else {
                NToast.m9450a(modifyPasswordFragment.mContext, (int) R.string.login_password_incorrect);
            }
            m6455a(modifyPasswordFragment.f13675b);
        } else if (!C2787z.m4813f(modifyPasswordFragment.f13683j)) {
            if (modifyPasswordFragment.f13683j.length() < 6) {
                NToast.m9450a(modifyPasswordFragment.mContext, (int) R.string.register_password_is_short);
            } else {
                NToast.m9450a(modifyPasswordFragment.mContext, (int) R.string.login_password_incorrect);
            }
            m6455a(modifyPasswordFragment.f13676c);
        } else if (!C2787z.m4813f(modifyPasswordFragment.f13684k)) {
            if (modifyPasswordFragment.f13684k.length() < 6) {
                NToast.m9450a(modifyPasswordFragment.mContext, (int) R.string.register_password_is_short);
            } else {
                NToast.m9450a(modifyPasswordFragment.mContext, (int) R.string.login_password_incorrect);
            }
        } else if (!modifyPasswordFragment.f13683j.equals(modifyPasswordFragment.f13684k)) {
            modifyPasswordFragment.f13677d.setText("");
            NToast.m9447b(modifyPasswordFragment.mContext, (int) R.string.mine_twopwds_not_same);
        } else {
            LoadDialog.m4686a(modifyPasswordFragment.mContext);
            modifyPasswordFragment.request(SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY);
        }
    }
}
