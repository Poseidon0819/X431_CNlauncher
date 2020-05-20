package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.setting.am */
/* loaded from: classes.dex */
public class OrientationSetting extends BaseFragment implements View.OnClickListener {

    /* renamed from: a */
    private RadioButton f14578a;

    /* renamed from: b */
    private RadioButton f14579b;

    /* renamed from: c */
    private RadioButton f14580c;

    /* renamed from: d */
    private Button f14581d;

    /* renamed from: e */
    private int f14582e = 2;

    /* renamed from: f */
    private int f14583f = 2;

    /* renamed from: g */
    private Handler f14584g = new HandlerC2529ao(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.setting_orientation_txt);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14578a = (RadioButton) getActivity().findViewById(R.id.btn_setting_horizontal);
        this.f14578a.setOnClickListener(this);
        this.f14579b = (RadioButton) getActivity().findViewById(R.id.btn_setting_vertical);
        this.f14579b.setOnClickListener(this);
        this.f14580c = (RadioButton) getActivity().findViewById(R.id.btn_setting_freedom);
        this.f14580c.setOnClickListener(this);
        this.f14581d = (Button) getActivity().findViewById(R.id.btn_apply);
        this.f14581d.setOnClickListener(this);
        this.f14582e = PreferencesManager.m9595a((Context) getActivity()).m9585b("Orientation", 2);
        int i = this.f14582e;
        this.f14583f = i;
        if (i == 0) {
            this.f14580c.setChecked(false);
            this.f14578a.setChecked(true);
            this.f14579b.setChecked(false);
        } else if (i == 1) {
            this.f14578a.setChecked(false);
            this.f14579b.setChecked(true);
            this.f14580c.setChecked(false);
        } else {
            this.f14578a.setChecked(false);
            this.f14579b.setChecked(false);
            this.f14580c.setChecked(true);
        }
        this.f14584g.obtainMessage(0).sendToTarget();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.setting_orientation_set, viewGroup, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_apply /* 2131296404 */:
                new C2528an(this).m4610a(getActivity(), R.string.dialog_title_default, R.string.setting_restart_orientation, false);
                return;
            case R.id.btn_setting_freedom /* 2131296560 */:
                this.f14578a.setChecked(false);
                this.f14579b.setChecked(false);
                this.f14580c.setChecked(true);
                this.f14582e = 2;
                this.f14584g.obtainMessage(0).sendToTarget();
                return;
            case R.id.btn_setting_horizontal /* 2131296561 */:
                this.f14578a.setChecked(true);
                this.f14579b.setChecked(false);
                this.f14580c.setChecked(false);
                this.f14582e = 0;
                this.f14584g.obtainMessage(0).sendToTarget();
                return;
            case R.id.btn_setting_vertical /* 2131296564 */:
                this.f14578a.setChecked(false);
                this.f14579b.setChecked(true);
                this.f14580c.setChecked(false);
                this.f14582e = 1;
                this.f14584g.obtainMessage(0).sendToTarget();
                return;
            default:
                return;
        }
    }
}
