package com.cnlaunch.x431pro.activity.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.setting.p235b.DiagLogHistoryInfoManager;
import com.cnlaunch.x431pro.activity.setting.p235b.OnQueryHistoryInfoListener;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.p290a.TipDialog;
import com.cnlaunch.x431pro.widget.switchbutton.SwitchButton;
import com.ifoer.expedition.pro.R;
import java.util.List;
import java.util.Locale;

/* renamed from: com.cnlaunch.x431pro.activity.setting.ba */
/* loaded from: classes.dex */
public class SettingFragment extends BaseFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, OnQueryHistoryInfoListener {

    /* renamed from: A */
    private TextView f14650A;

    /* renamed from: a */
    private RadioButton f14652a;

    /* renamed from: b */
    private RadioButton f14653b;

    /* renamed from: c */
    private RadioButton f14654c;

    /* renamed from: d */
    private RadioButton f14655d;

    /* renamed from: e */
    private RadioButton f14656e;

    /* renamed from: f */
    private RadioButton f14657f;

    /* renamed from: g */
    private RadioButton f14658g;

    /* renamed from: h */
    private RadioGroup f14659h;

    /* renamed from: i */
    private RadioButton f14660i;

    /* renamed from: j */
    private RadioButton f14661j;

    /* renamed from: k */
    private RadioGroup f14662k;

    /* renamed from: l */
    private RadioButton f14663l;

    /* renamed from: m */
    private RadioButton f14664m;

    /* renamed from: n */
    private LinearLayout f14665n;

    /* renamed from: o */
    private LinearLayout f14666o;

    /* renamed from: p */
    private SwitchButton f14667p;

    /* renamed from: q */
    private SwitchButton f14668q;

    /* renamed from: r */
    private SwitchButton f14669r;

    /* renamed from: s */
    private View f14670s;

    /* renamed from: t */
    private View f14671t;

    /* renamed from: u */
    private View f14672u;

    /* renamed from: v */
    private View f14673v;

    /* renamed from: w */
    private View f14674w;

    /* renamed from: z */
    private TipDialog f14677z;

    /* renamed from: x */
    private int f14675x = 0;

    /* renamed from: y */
    private int f14676y = 0;

    /* renamed from: B */
    private BroadcastReceiver f14651B = new C2551bh(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ TipDialog m5962c(SettingFragment settingFragment) {
        settingFragment.f14677z = null;
        return null;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        DiagLogHistoryInfoManager.m5973a(this.mContext).m5971a(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.setting_fragment, viewGroup, false);
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
            case R.id.btn_about /* 2131296397 */:
                replaceFragment(AboutFragment.class.getName(), 1);
                return;
            case R.id.btn_checkserve /* 2131296418 */:
                replaceFragment(CheckServerFragment.class.getName(), 1);
                return;
            case R.id.btn_onekey_clear /* 2131296505 */:
                replaceFragment(View$OnClickListenerC2594z.class.getName(), 1);
                return;
            case R.id.btn_onekey_feedback /* 2131296506 */:
                if (PreferencesManager.m9595a((Context) getActivity()).m9584b("login_state", "0").equals("1")) {
                    if (PreferencesManager.m9595a((Context) getActivity()).m9583b("is_show_diaglog_tip", true)) {
                        if (this.f14677z == null) {
                            this.f14677z = new DialogC2548be(this, getActivity());
                        }
                        this.f14677z.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2549bf(this));
                        this.f14677z.m4717b(R.string.btn_canlce, true, null);
                        this.f14677z.setOnCancelListener(new DialogInterface$OnCancelListenerC2550bg(this));
                        this.f14677z.show();
                        return;
                    }
                    replaceFragment(DiagnosticLogVehicleListFragment.class.getName(), 1);
                    return;
                }
                NToast.m9450a(getActivity(), (int) R.string.login_tip);
                return;
            case R.id.btn_printinfo_setting /* 2131296521 */:
                replaceFragment(PrintEditInfoFragment.class.getName(), 1);
                return;
            case R.id.btn_theme_setting /* 2131296581 */:
                replaceFragment(ThemeSettingFragment.class.getName(), 1);
                return;
            case R.id.btn_wifiprint_setting /* 2131296596 */:
                replaceFragment(WifiPrintSettingFragment.class.getName(), 1);
                return;
            case R.id.item_diagunit /* 2131297173 */:
                int i = this.f14675x;
                if (i == 0) {
                    this.f14661j.setChecked(true);
                    return;
                } else if (i == 1) {
                    this.f14660i.setChecked(true);
                    return;
                } else {
                    return;
                }
            case R.id.item_identifix_setting /* 2131297175 */:
                this.f14668q.toggle();
                return;
            case R.id.item_navigatorpro_setting /* 2131297179 */:
                this.f14669r.toggle();
                return;
            case R.id.item_orientationsetting /* 2131297180 */:
                replaceFragment(OrientationSetting.class.getName(), 1);
                return;
            case R.id.item_timeout_remind /* 2131297185 */:
                this.f14667p.toggle();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu));
        setTitle(R.string.tab_menu_setting);
        this.f14673v = getActivity().findViewById(R.id.item_diagunit);
        this.f14673v.setOnClickListener(this);
        this.f14659h = (RadioGroup) getActivity().findViewById(R.id.radiogroup_diagunit_setting);
        this.f14659h.setOnCheckedChangeListener(this);
        this.f14675x = C2744aa.m5158d(getActivity());
        this.f14660i = (RadioButton) getActivity().findViewById(R.id.radio_metric);
        this.f14661j = (RadioButton) getActivity().findViewById(R.id.radio_imperial);
        int i = this.f14675x;
        if (i == 0) {
            this.f14660i.setChecked(true);
        } else if (i == 1) {
            this.f14661j.setChecked(true);
        }
        this.f14672u = getActivity().findViewById(R.id.item_orientationsetting);
        if (!PreferencesManager.m9595a((Context) getActivity()).m9583b("is_screen_switch", false)) {
            this.f14672u.setVisibility(8);
            getActivity().findViewById(R.id.linear_line_3).setVisibility(8);
        } else {
            this.f14672u.setOnClickListener(this);
            this.f14662k = (RadioGroup) getActivity().findViewById(R.id.radiogroup_orientation_setting);
            this.f14663l = (RadioButton) getActivity().findViewById(R.id.radio_horizontal);
            this.f14664m = (RadioButton) getActivity().findViewById(R.id.radio_vertical);
            this.f14662k.setOnClickListener(this);
            this.f14663l.setOnClickListener(this);
            this.f14664m.setOnClickListener(this);
            this.f14676y = PreferencesManager.m9595a((Context) getActivity()).m9585b("Orientation", 2);
            int i2 = this.f14676y;
            if (i2 == 0) {
                this.f14663l.setChecked(true);
            } else if (i2 == 1) {
                this.f14664m.setChecked(true);
            }
        }
        this.f14671t = getActivity().findViewById(R.id.item_timeout_remind);
        this.f14671t.setOnClickListener(this);
        if (Locale.getDefault().getCountry().equalsIgnoreCase("CN")) {
            this.f14671t.setVisibility(8);
            this.f14665n = (LinearLayout) getActivity().findViewById(R.id.linear_line_2);
            this.f14665n.setVisibility(8);
        }
        this.f14667p = (SwitchButton) getActivity().findViewById(R.id.switch_timeoutremind);
        this.f14667p.setChecked(PreferencesManager.m9595a(this.mContext).m9583b("expired_remind", true));
        this.f14667p.setOnCheckedChangeListener(new C2545bb(this));
        this.f14670s = getActivity().findViewById(R.id.item_identifix_setting);
        this.f14670s.setOnClickListener(this);
        this.f14668q = (SwitchButton) getActivity().findViewById(R.id.switch_identifix);
        this.f14668q.setChecked(PreferencesManager.m9595a(this.mContext).m9584b("show_identifix_tips", "1").equals("1"));
        this.f14668q.setOnCheckedChangeListener(new C2546bc(this));
        this.f14674w = getActivity().findViewById(R.id.item_navigatorpro_setting);
        this.f14674w.setOnClickListener(this);
        this.f14669r = (SwitchButton) getActivity().findViewById(R.id.switch_navigatorpro);
        this.f14669r.setChecked(PreferencesManager.m9595a(this.mContext).m9584b("show_navigatorpro_tips", "1").equals("1"));
        this.f14669r.setOnCheckedChangeListener(new C2547bd(this));
        if (C2744aa.m5145h()) {
            this.f14670s.setVisibility(8);
            this.f14674w.setVisibility(0);
        } else {
            this.f14674w.setVisibility(8);
            if (C2744aa.m5166c()) {
                this.f14670s.setVisibility(0);
            }
        }
        this.f14653b = (RadioButton) getActivity().findViewById(R.id.btn_printinfo_setting);
        this.f14653b.setOnClickListener(this);
        if (PreferencesManager.m9595a(getActivity().getApplicationContext()).m9583b(C1947h.f10555g, false)) {
            this.f14658g = (RadioButton) getActivity().findViewById(R.id.btn_wifiprint_setting);
            this.f14658g.setOnClickListener(this);
        } else {
            View findViewById = getActivity().findViewById(R.id.layout_wifiprint_setting_line);
            View findViewById2 = getActivity().findViewById(R.id.layout_wifiprint_setting);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
        }
        if (PreferencesManager.m9595a((Context) getActivity()).m9583b("is_themes_colorful", false)) {
            this.f14657f = (RadioButton) getActivity().findViewById(R.id.btn_theme_setting);
            this.f14657f.setOnClickListener(this);
        } else {
            View findViewById3 = getActivity().findViewById(R.id.linear_themesetting_line);
            View findViewById4 = getActivity().findViewById(R.id.linear_themesetting);
            findViewById3.setVisibility(8);
            findViewById4.setVisibility(8);
        }
        this.f14654c = (RadioButton) getActivity().findViewById(R.id.btn_onekey_feedback);
        this.f14654c.setOnClickListener(this);
        this.f14650A = (TextView) getActivity().findViewById(R.id.tv_tips);
        this.f14666o = (LinearLayout) getActivity().findViewById(R.id.linear_fredback);
        if (C2744aa.m5166c()) {
            this.f14666o.setVisibility(8);
            getActivity().findViewById(R.id.linear_fredback).setVisibility(8);
        }
        this.f14655d = (RadioButton) getActivity().findViewById(R.id.btn_checkserve);
        this.f14655d.setOnClickListener(this);
        this.f14656e = (RadioButton) getActivity().findViewById(R.id.btn_about);
        this.f14656e.setOnClickListener(this);
        this.f14652a = (RadioButton) getActivity().findViewById(R.id.btn_onekey_clear);
        this.f14652a.setOnClickListener(this);
        DiagLogHistoryInfoManager.m5973a(this.mContext).m5974a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("replace_printSetFragmet");
        getActivity().registerReceiver(this.f14651B, intentFilter);
        this.f14669r.setChecked(PreferencesManager.m9595a(this.mContext).m9584b("show_navigatorpro_tips", "1").equals("1"));
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.radio_imperial) {
            this.f14675x = 1;
            PreferencesManager.m9595a((Context) getActivity()).m9590a("Measuresion", 1);
        } else if (i != R.id.radio_metric) {
        } else {
            this.f14675x = 0;
            PreferencesManager.m9595a((Context) getActivity()).m9590a("Measuresion", 0);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        getActivity().unregisterReceiver(this.f14651B);
        DiagLogHistoryInfoManager.m5973a(this.mContext).m5968b(this);
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        TipDialog tipDialog = this.f14677z;
        if (tipDialog != null) {
            tipDialog.dismiss();
            this.f14677z = null;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.setting.p235b.OnQueryHistoryInfoListener
    /* renamed from: a */
    public final void mo5964a(List<DiagLogHistoryInfo> list) {
        int i = 0;
        for (DiagLogHistoryInfo diagLogHistoryInfo : list) {
            if (diagLogHistoryInfo.getReaded() < diagLogHistoryInfo.getCurrentState()) {
                i++;
            }
        }
        if (i > 0) {
            this.f14650A.setVisibility(0);
            this.f14650A.setText(String.valueOf(i));
            return;
        }
        this.f14650A.setVisibility(8);
    }

    @Override // com.cnlaunch.x431pro.activity.setting.p235b.OnQueryHistoryInfoListener
    /* renamed from: a */
    public final void mo5966a(int i, int i2, String str) {
        this.f14650A.setVisibility(8);
    }
}
