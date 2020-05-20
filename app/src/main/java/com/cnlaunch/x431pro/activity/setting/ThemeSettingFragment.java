package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.setting.bi */
/* loaded from: classes.dex */
public class ThemeSettingFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a */
    private RadioButton f14685a;

    /* renamed from: b */
    private RadioButton f14686b;

    /* renamed from: c */
    private RadioButton f14687c;

    /* renamed from: d */
    private int f14688d = 0;

    /* renamed from: e */
    private int f14689e = 0;

    /* renamed from: f */
    private Button f14690f;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.settings_theme);
        this.f14685a = (RadioButton) getActivity().findViewById(R.id.btn_redrose);
        this.f14685a.setOnClickListener(this);
        this.f14686b = (RadioButton) getActivity().findViewById(R.id.btn_bluevoilet);
        this.f14686b.setOnClickListener(this);
        this.f14687c = (RadioButton) getActivity().findViewById(R.id.btn_green);
        this.f14687c.setOnClickListener(this);
        this.f14690f = (Button) getActivity().findViewById(R.id.btn_apply);
        this.f14690f.setOnClickListener(this);
        this.f14688d = PreferencesManager.m9595a((Context) getActivity()).m9585b("theme_type", 0);
        int i = this.f14688d;
        this.f14689e = i;
        if (i == 0) {
            this.f14685a.setChecked(true);
            this.f14686b.setChecked(false);
            this.f14687c.setChecked(false);
        } else if (i == 2) {
            this.f14685a.setChecked(false);
            this.f14686b.setChecked(true);
            this.f14687c.setChecked(false);
        } else if (i == 3) {
            this.f14685a.setChecked(false);
            this.f14686b.setChecked(false);
            this.f14687c.setChecked(true);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.setting_themes, viewGroup, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_apply) {
            new C2552bj(this).m4610a(getActivity(), R.string.dialog_title_default, R.string.settings_restart_app, false);
        } else if (id == R.id.btn_bluevoilet) {
            this.f14685a.setChecked(false);
            this.f14686b.setChecked(true);
            this.f14687c.setChecked(false);
            this.f14688d = 2;
        } else if (id == R.id.btn_green) {
            this.f14685a.setChecked(false);
            this.f14686b.setChecked(false);
            this.f14687c.setChecked(true);
            this.f14688d = 3;
        } else if (id != R.id.btn_redrose) {
        } else {
            this.f14685a.setChecked(true);
            this.f14686b.setChecked(false);
            this.f14687c.setChecked(false);
            this.f14688d = 0;
        }
    }
}
