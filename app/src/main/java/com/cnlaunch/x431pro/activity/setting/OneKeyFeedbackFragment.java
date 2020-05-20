package com.cnlaunch.x431pro.activity.setting;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.setting.p234a.OneKeyFeedbackAdapter;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.ifoer.expedition.pro.R;
import java.io.Serializable;
import java.util.Vector;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.cnlaunch.x431pro.activity.setting.ac */
/* loaded from: classes.dex */
public class OneKeyFeedbackFragment extends BaseFragment implements View.OnClickListener, Serializable {
    private static final long serialVersionUID = -8345700710596926540L;
    private OneKeyFeedbackAdapter adapter;
    private IconButton btn_onekey_feedback_cancel;
    private IconButton btn_onekey_feedback_history;
    private IconButton btn_onekey_feedback_next;
    private IconRadioButton btn_onekey_feedback_select_all;
    private Vector<DiagnoseLogInfoSearchUtil.C2749a> diagnosis_log;
    private Vector<DiagnoseLogInfoSearchUtil.C2749a> items_diagnosis_log;
    private ListView lv_setting_onekey;
    private String mSerialNo = "";
    private String vehiclename = "";
    private String softPackageId = "";
    private final int REFLESHLIST = 1;
    private Handler refleshHandle = new HandlerC2520ad(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle bundle2 = getBundle();
        if (bundle2 == null) {
            getFragmentManager().popBackStack();
        }
        this.vehiclename = bundle2.getString("VehicleName");
        this.softPackageId = bundle2.getString("SoftPackageId");
        this.mSerialNo = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        this.diagnosis_log = DiagnoseLogInfoSearchUtil.m5090a();
        this.items_diagnosis_log = new Vector<>();
        if (!TextUtils.isEmpty(this.mSerialNo)) {
            for (int i = 0; i < this.diagnosis_log.size(); i++) {
                if (this.mSerialNo.equals(this.diagnosis_log.get(i).getDeviceSN()) && this.softPackageId.equals(this.diagnosis_log.get(i).getVehicleSoftname())) {
                    this.diagnosis_log.get(i).setChecked(false);
                    this.diagnosis_log.get(i).setVehicleName(this.vehiclename);
                    this.items_diagnosis_log.add(this.diagnosis_log.get(i));
                }
            }
        } else {
            NToast.m9446b(this.mContext, getResources().getString(R.string.txt_no_connector));
        }
        this.adapter = new OneKeyFeedbackAdapter(getActivity(), this);
        OneKeyFeedbackAdapter oneKeyFeedbackAdapter = this.adapter;
        oneKeyFeedbackAdapter.f14526a = this.items_diagnosis_log;
        oneKeyFeedbackAdapter.notifyDataSetChanged();
        setTitle(R.string.setting_onekey_feedback_txt);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu));
        this.btn_onekey_feedback_select_all = (IconRadioButton) getActivity().findViewById(R.id.btn_onekey_feedback_select_all);
        this.btn_onekey_feedback_next = (IconButton) getActivity().findViewById(R.id.btn_onekey_feedback_next);
        this.btn_onekey_feedback_cancel = (IconButton) getActivity().findViewById(R.id.btn_onekey_feedback_cancel);
        this.btn_onekey_feedback_history = (IconButton) getActivity().findViewById(R.id.btn_onekey_feedback_history);
        this.btn_onekey_feedback_select_all.setOnClickListener(this);
        this.btn_onekey_feedback_next.setOnClickListener(this);
        this.btn_onekey_feedback_cancel.setOnClickListener(this);
        this.btn_onekey_feedback_history.setOnClickListener(this);
        this.lv_setting_onekey = (ListView) getActivity().findViewById(R.id.lv_setting_onekey);
        this.lv_setting_onekey.setAdapter((ListAdapter) this.adapter);
        this.lv_setting_onekey.setOnItemClickListener(new C2521ae(this));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.setting_onekey_feedback, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mSerialNo = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        this.diagnosis_log = DiagnoseLogInfoSearchUtil.m5090a();
        if (this.items_diagnosis_log != null) {
            this.items_diagnosis_log = this.adapter.f14526a;
        } else {
            this.items_diagnosis_log = new Vector<>();
        }
        for (int i = 0; i < this.diagnosis_log.size(); i++) {
            this.diagnosis_log.get(i).setChecked(false);
            String filename = this.diagnosis_log.get(i).getFilename();
            for (int i2 = 0; i2 < this.items_diagnosis_log.size(); i2++) {
                if (filename.equals(this.items_diagnosis_log.get(i2).getFilename())) {
                    this.diagnosis_log.get(i).setChecked(this.items_diagnosis_log.get(i2).isChecked());
                }
            }
        }
        this.items_diagnosis_log.clear();
        if (!TextUtils.isEmpty(this.mSerialNo)) {
            for (int i3 = 0; i3 < this.diagnosis_log.size(); i3++) {
                if (this.mSerialNo.equals(this.diagnosis_log.get(i3).getDeviceSN()) && this.softPackageId.equals(this.diagnosis_log.get(i3).getVehicleSoftname())) {
                    this.diagnosis_log.get(i3).setVehicleName(this.vehiclename);
                    this.items_diagnosis_log.add(this.diagnosis_log.get(i3));
                }
            }
        }
        Message message2 = new Message();
        message2.what = 1;
        this.refleshHandle.sendMessage(message2);
        selectAllChanged();
        DealDiagMessageHandler.m8673a().f9427c = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = true;
        switch (view.getId()) {
            case R.id.btn_onekey_feedback_cancel /* 2131296507 */:
                this.mainActivity.m7894b(R.id.btn_diagnose);
                return;
            case R.id.btn_onekey_feedback_history /* 2131296508 */:
                replaceFragment(OneKeyFeedbackHistoryFragment.class.getName(), 1);
                return;
            case R.id.btn_onekey_feedback_next /* 2131296509 */:
                if (!C2778n.m4917a(this.mContext)) {
                    NToast.m9450a(this.mContext, (int) R.string.common_network_unavailable);
                    return;
                }
                Vector vector = new Vector();
                if (this.adapter != null) {
                    boolean z2 = true;
                    for (int i = 0; i < this.adapter.f14526a.size(); i++) {
                        if (this.adapter.f14526a.get(i).isChecked()) {
                            vector.add(this.adapter.f14526a.get(i));
                            z2 = false;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    NToast.m9450a(this.mContext, (int) R.string.common_unselect_any);
                    return;
                } else {
                    DiagnoseLogInfoSearchUtil.m5088a(this.mContext, vector, false);
                    return;
                }
            case R.id.btn_onekey_feedback_select_all /* 2131296510 */:
                if (getString(R.string.common_unselect).equals(this.btn_onekey_feedback_select_all.getText().toString())) {
                    this.btn_onekey_feedback_select_all.setText(R.string.common_select);
                    z = false;
                } else {
                    this.btn_onekey_feedback_select_all.setText(R.string.common_unselect);
                }
                if (this.adapter != null) {
                    for (int i2 = 0; i2 < this.adapter.f14526a.size(); i2++) {
                        this.adapter.f14526a.get(i2).setChecked(z);
                    }
                }
                this.btn_onekey_feedback_next.setEnabled(z);
                this.adapter.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    public void selectAllChanged() {
        boolean z;
        int i;
        if (this.adapter.f14526a != null && this.adapter.f14526a.size() > 0) {
            int size = this.adapter.f14526a.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = size;
                    z = false;
                    break;
                } else if (this.adapter.f14526a.get(i2).isChecked()) {
                    i = size;
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            z = false;
            i = 0;
        }
        if (z) {
            this.btn_onekey_feedback_select_all.setEnabled(true);
            this.btn_onekey_feedback_select_all.setChecked(true);
            this.btn_onekey_feedback_select_all.setText(R.string.common_unselect);
            this.btn_onekey_feedback_next.setEnabled(true);
        } else if (i > 0) {
            this.btn_onekey_feedback_select_all.setEnabled(true);
            this.btn_onekey_feedback_select_all.setChecked(false);
            this.btn_onekey_feedback_select_all.setText(R.string.common_select);
            this.btn_onekey_feedback_next.setEnabled(false);
        } else {
            this.btn_onekey_feedback_select_all.setChecked(false);
            this.btn_onekey_feedback_select_all.setText(R.string.common_select);
            this.btn_onekey_feedback_select_all.setEnabled(false);
            this.btn_onekey_feedback_next.setEnabled(false);
        }
    }
}
