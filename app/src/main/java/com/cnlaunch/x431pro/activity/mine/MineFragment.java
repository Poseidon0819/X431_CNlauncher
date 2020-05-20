package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.gmap.map.p151c.LanguageUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.IMActivity;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p175e.OnIMDataListener;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.help.HelpFragment;
import com.cnlaunch.x431pro.activity.login.LoginActivity;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.p290a.LogoutDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.mine.ak */
/* loaded from: classes.dex */
public class MineFragment extends BaseFragment implements View.OnClickListener, OnIMDataListener {

    /* renamed from: n */
    private static boolean f13651n = false;

    /* renamed from: b */
    private PreferencesManager f13653b;

    /* renamed from: c */
    private TextView f13654c;

    /* renamed from: d */
    private TextView f13655d;

    /* renamed from: e */
    private TextView f13656e;

    /* renamed from: f */
    private TextView f13657f;

    /* renamed from: g */
    private TextView f13658g;

    /* renamed from: h */
    private TextView f13659h;

    /* renamed from: i */
    private TextView f13660i;

    /* renamed from: j */
    private TextView f13661j;

    /* renamed from: k */
    private TextView f13662k;

    /* renamed from: l */
    private TextView f13663l;

    /* renamed from: m */
    private Button f13664m;

    /* renamed from: q */
    private TextView f13667q;

    /* renamed from: r */
    private TextView f13668r;

    /* renamed from: s */
    private View f13669s;

    /* renamed from: t */
    private View f13670t;

    /* renamed from: o */
    private View f13665o = null;

    /* renamed from: p */
    private boolean f13666p = false;

    /* renamed from: a */
    BroadcastReceiver f13652a = new C2401al(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f13653b = PreferencesManager.m9595a(this.mContext);
        setTitle(R.string.tab_menu_mine);
        this.f13656e = (TextView) getActivity().findViewById(R.id.btn_myconnector);
        this.f13656e.setOnClickListener(this);
        this.f13657f = (TextView) getActivity().findViewById(R.id.btn_dpu_link_manager);
        this.f13657f.setOnClickListener(this);
        this.f13654c = (TextView) getActivity().findViewById(R.id.btn_myreport);
        this.f13654c.setOnClickListener(this);
        this.f13658g = (TextView) getActivity().findViewById(R.id.btn_connector_activate);
        this.f13658g.setOnClickListener(this);
        this.f13655d = (TextView) getActivity().findViewById(R.id.btn_mineinfo);
        this.f13655d.setOnClickListener(this);
        this.f13659h = (TextView) getActivity().findViewById(R.id.btn_modify_password);
        this.f13659h.setOnClickListener(this);
        this.f13660i = (TextView) getActivity().findViewById(R.id.btn_help);
        this.f13660i.setOnClickListener(this);
        this.f13662k = (TextView) getActivity().findViewById(R.id.btn_firmware_fix);
        this.f13662k.setOnClickListener(this);
        this.f13665o = getActivity().findViewById(R.id.online_service);
        this.f13661j = (TextView) getActivity().findViewById(R.id.btn_customer_service);
        this.f13661j.setOnClickListener(this);
        this.f13664m = (Button) getActivity().findViewById(R.id.btn_logout);
        this.f13664m.setOnClickListener(this);
        this.f13667q = (TextView) getActivity().findViewById(R.id.btn_my_friends);
        this.f13667q.setOnClickListener(this);
        this.f13663l = (TextView) getActivity().findViewById(R.id.btn_vehicle_voltage);
        this.f13663l.setOnClickListener(this);
        boolean z = false;
        if (LanguageUtils.m9283b().equalsIgnoreCase("es")) {
            getActivity().findViewById(R.id.voltage_container).setVisibility(0);
            getActivity().findViewById(R.id.voltage_container_divider).setVisibility(0);
        } else {
            getActivity().findViewById(R.id.voltage_container).setVisibility(8);
            getActivity().findViewById(R.id.voltage_container_divider).setVisibility(8);
        }
        this.f13668r = (TextView) getActivity().findViewById(R.id.mine_no_read);
        int m8794c = !TextUtils.isEmpty(PreferencesManager.m9595a(this.mContext).m9584b("user_id", "")) ? IMPresenter.m8804a(getActivity()).m8794c() : 0;
        if (m8794c > 0) {
            this.f13668r.setVisibility(0);
            this.f13668r.setText(String.valueOf(m8794c));
        } else {
            this.f13668r.setVisibility(8);
        }
        IntentFilter intentFilter = new IntentFilter("login");
        intentFilter.addAction("logout");
        intentFilter.addAction("refreshtip");
        getActivity().registerReceiver(this.f13652a, intentFilter);
        this.f13666p = this.f13653b.m9583b("enable_online_service", false);
        if (!this.f13666p) {
            this.f13665o.setVisibility(8);
        }
        if (C2744aa.m5166c()) {
            getActivity().findViewById(R.id.container_friends).setVisibility(8);
            getActivity().findViewById(R.id.below_container_friends).setVisibility(8);
        }
        if (C2744aa.m5122s(getActivity()) && !LanguageUtils.m9284a()) {
            z = true;
        }
        this.f13669s = getActivity().findViewById(R.id.ll_my_order);
        this.f13669s.setOnClickListener(this);
        this.f13670t = getActivity().findViewById(R.id.ll_card_status);
        this.f13670t.setOnClickListener(this);
        if (!z) {
            getActivity().findViewById(R.id.pincard_container).setVisibility(8);
        }
        IMPresenter.m8804a(getActivity()).m8803a(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_fragment, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        String m9584b = this.f13653b.m9584b("login_state", "0");
        if (m9584b != null && m9584b.equals("1")) {
            this.f13664m.setText(R.string.logout_button);
        } else {
            this.f13664m.setText(R.string.login_button);
        }
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu));
        if (PreferencesManager.m9595a(this.mContext).m9585b("unupdateSoftwareNum", 0) + PreferencesManager.m9595a(this.mContext).m9585b("unupdateSoftwareNumForHeavyduty", 0) > 0) {
            setMenuUpdateVisibility(0);
        } else {
            setMenuUpdateVisibility(8);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_connector_activate /* 2131296426 */:
                replaceFragment(ConnectorActivateFragment.class.getName(), 1);
                return;
            case R.id.btn_customer_service /* 2131296430 */:
                if (f13651n || this.f13653b.m9584b("login_state", "0").equals("1")) {
                    return;
                }
                NToast.m9450a(getActivity(), (int) R.string.login_tip);
                return;
            case R.id.btn_dpu_link_manager /* 2131296441 */:
                replaceFragment(DPULinkManagerFragment.class.getName(), 1);
                return;
            case R.id.btn_firmware_fix /* 2131296454 */:
                replaceFragment(FirmwareFixFragment.class.getName(), 1);
                return;
            case R.id.btn_help /* 2131296473 */:
                if (isResumed()) {
                    replaceFragment(HelpFragment.class.getName(), 1);
                    return;
                }
                return;
            case R.id.btn_logout /* 2131296491 */:
                String m9584b = this.f13653b.m9584b("login_state", "0");
                if (m9584b != null && m9584b.equals("1")) {
                    new LogoutDialog(this.mContext).m4609a(getActivity(), getActivity().getString(R.string.logout), getActivity().getString(R.string.iflogout));
                    return;
                }
                Intent intent = new Intent(this.mContext, LoginActivity.class);
                intent.setFlags(67108864);
                startActivity(intent);
                return;
            case R.id.btn_mineinfo /* 2131296497 */:
                if (PreferencesManager.m9595a((Context) getActivity()).m9584b("login_state", "0").equals("1")) {
                    replaceFragment(PersonInformationFragment.class.getName(), 1);
                    return;
                } else {
                    NToast.m9450a(getActivity(), (int) R.string.login_tip);
                    return;
                }
            case R.id.btn_modify_password /* 2131296498 */:
                if (PreferencesManager.m9595a((Context) getActivity()).m9584b("login_state", "0").equals("1")) {
                    replaceFragment(ModifyPasswordFragment.class.getName(), 1);
                    return;
                } else {
                    NToast.m9450a(getActivity(), (int) R.string.login_tip);
                    return;
                }
            case R.id.btn_my_friends /* 2131296500 */:
                if (CommonTools.m7969a(getActivity())) {
                    IMPresenter.m8804a(getActivity()).m8791d(IMActivity.class.getName());
                    return;
                }
                return;
            case R.id.btn_myconnector /* 2131296501 */:
                replaceFragment(SerialNumberFragment.class.getName(), 1);
                return;
            case R.id.btn_myreport /* 2131296502 */:
                replaceFragment(ReportPagersFragment.class.getName(), 1);
                return;
            case R.id.btn_vehicle_voltage /* 2131296592 */:
                replaceFragment(VehicleVoltageFragment.class.getName(), 1);
                return;
            case R.id.ll_card_status /* 2131297386 */:
                replaceFragment(CardStatusFragment.class.getName(), 1);
                return;
            case R.id.ll_my_order /* 2131297396 */:
                Bundle bundle = new Bundle();
                String m9591a = PreferencesManager.m9595a((Context) getActivity()).m9591a("serialNo");
                if (TextUtils.isEmpty(m9591a)) {
                    m9591a = PreferencesManager.m9595a((Context) getActivity()).m9591a("carSerialNo");
                    if (TextUtils.isEmpty(m9591a)) {
                        m9591a = PreferencesManager.m9595a((Context) getActivity()).m9591a("heavydutySerialNo");
                    }
                }
                if (LoginTools.m7945a(this.mContext, 1)) {
                    if (TextUtils.isEmpty(m9591a)) {
                        new DialogC2402am(this, this.mContext, bundle).m4670a(R.string.tab_menu_mine, R.string.txt_no_connector);
                        return;
                    }
                    bundle.putString("serialNo", m9591a);
                    replaceFragment(MyOrderFragment.class.getName(), bundle, true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(this.f13652a);
        IMPresenter.m8804a(getActivity()).m8796b(this);
    }

    @Override // com.cnlaunch.p169im.p175e.OnIMDataListener
    /* renamed from: a */
    public final void mo6461a(int i) {
        if (i == 40028 || i == 40031) {
            int m8794c = IMPresenter.m8804a(getActivity()).m8794c();
            if (m8794c > 0) {
                this.f13668r.setVisibility(0);
                this.f13668r.setText(String.valueOf(m8794c));
            } else {
                this.f13668r.setVisibility(8);
            }
            getActivity().sendBroadcast(new Intent("mineMessageNumChanged"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m6458c(MineFragment mineFragment) {
        if (TextUtils.isEmpty(PreferencesManager.m9595a(mineFragment.mContext).m9584b("user_id", ""))) {
            return;
        }
        int m8794c = IMPresenter.m8804a(mineFragment.getActivity()).m8794c();
        if (m8794c > 0) {
            mineFragment.f13668r.setVisibility(0);
            mineFragment.f13668r.setText(String.valueOf(m8794c));
            return;
        }
        mineFragment.f13668r.setVisibility(8);
    }
}
