package com.cnlaunch.x431pro.activity.diagnose;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment;
import com.cnlaunch.x431pro.module.golo.model.MineCarInfoResponse;
import com.cnlaunch.x431pro.module.golo.p262a.GoloAction;
import com.cnlaunch.x431pro.module.p252d.p254b.C2725h;
import com.cnlaunch.x431pro.module.report.ReportProduceTool;
import com.cnlaunch.x431pro.module.report.p276a.ReportAction;
import com.cnlaunch.x431pro.module.report.p277b.ReportBackInfo;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportInfo;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportResponse;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.LocationUtils;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.ifoer.expedition.pro.R;
import java.util.Iterator;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.br */
/* loaded from: classes.dex */
public class RemoteReportFragment extends BaseDiagnoseFragment {

    /* renamed from: a */
    private TextView f11574a;

    /* renamed from: b */
    private TextView f11575b;

    /* renamed from: j */
    private TextView f11576j;

    /* renamed from: k */
    private TextView f11577k;

    /* renamed from: l */
    private TextView f11578l;

    /* renamed from: m */
    private TextView f11579m;

    /* renamed from: n */
    private Button f11580n;

    /* renamed from: o */
    private EditText f11581o;

    /* renamed from: p */
    private boolean f11582p = false;

    /* renamed from: q */
    private C2725h f11583q = null;

    /* renamed from: r */
    private ReportBackInfo f11584r = null;

    /* renamed from: s */
    private Handler f11585s = new HandlerC2082bs(this);

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        this.f11574a = (TextView) getActivity().findViewById(R.id.tv_report_title);
        this.f11575b = (TextView) getActivity().findViewById(R.id.tv_fault_code);
        this.f11574a.setText(getString(R.string.report_theme_tail));
        this.f11576j = (TextView) getActivity().findViewById(R.id.tv_car_name);
        this.f11576j.setVisibility(8);
        this.f11577k = (TextView) getActivity().findViewById(R.id.tv_car_vin);
        this.f11577k.setVisibility(8);
        this.f11578l = (TextView) getActivity().findViewById(R.id.tv_diagnose_time);
        this.f11579m = (TextView) getActivity().findViewById(R.id.tv_master_name);
        TextView textView = this.f11575b;
        ReportProduceTool m5233a = ReportProduceTool.m5233a();
        if (m5233a.f15638a == null || m5233a.f15638a.size() <= 0) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator<BasicFaultCodeBean> it = m5233a.f15638a.iterator();
            while (it.hasNext()) {
                BasicFaultCodeBean next = it.next();
                sb.append(next.getTitle());
                sb.append("-");
                sb.append(next.getContext());
                sb.append("-");
                sb.append(next.getStatus());
                sb.append("\n");
            }
            str = sb.toString();
        }
        textView.setText(str);
        TextView textView2 = this.f11578l;
        textView2.setText(getString(R.string.report_diagnose_time) + DateUtils.m5094a(DateStyle.f15729g));
        TextView textView3 = this.f11579m;
        textView3.setText(getString(R.string.report_master_name) + DealDiagMessageHandler.m8673a().m8657f());
        this.f11580n = (Button) getActivity().findViewById(R.id.btn_send);
        this.f11580n.setOnClickListener(this);
        this.f11581o = (EditText) getActivity().findViewById(R.id.et_result);
        getActivity().findViewById(R.id.menu_update_tip).setVisibility(8);
        request(20015, true);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_report_remote, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_reprot_remote);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i != 20011) {
            if (i == 20015) {
                GoloAction goloAction = new GoloAction(getActivity());
                String remoteSerialNum = this.f12357d.mo7081k().getRemoteSerialNum();
                this.f12357d.mo7081k().getOtherUseID();
                return goloAction.m5318a(remoteSerialNum);
            }
            return super.doInBackground(i);
        }
        ReportAction reportAction = new ReportAction(this.mContext);
        String m9584b = PreferencesManager.m9595a((Context) getActivity()).m9584b("serialNo", "");
        if (TextUtils.isEmpty(ReportProduceTool.m5233a().f15643f)) {
            String carName = this.f12357d.mo7081k().getCarName();
            if (!TextUtils.isEmpty(carName)) {
                ReportProduceTool m5233a = ReportProduceTool.m5233a();
                m5233a.f15643f = carName + "_";
            }
        }
        ReportProduceTool m5233a2 = ReportProduceTool.m5233a();
        Context context = this.mContext;
        String remoteSerialNum2 = this.f12357d.mo7081k().getRemoteSerialNum();
        C2725h c2725h = this.f11583q;
        String goloLon = this.f12357d.mo7081k().getGoloLon();
        String goloLat = this.f12357d.mo7081k().getGoloLat();
        UpLoadReportInfo upLoadReportInfo = new UpLoadReportInfo();
        upLoadReportInfo.setTheme(m5233a2.f15643f + context.getString(R.string.report_theme_tail));
        upLoadReportInfo.setFault_codes(m5233a2.m5222e());
        upLoadReportInfo.setData_flow(m5233a2.m5223d());
        String m9466b = LangManager.m9466b();
        upLoadReportInfo.setLanguage((m9466b.equalsIgnoreCase("zh") || m9466b.equalsIgnoreCase("cn")) ? "zh" : "en");
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        upLoadReportInfo.setDiagnosis_time(sb.toString());
        upLoadReportInfo.setType("1");
        upLoadReportInfo.setSerial_no(remoteSerialNum2);
        upLoadReportInfo.setPro_serial_no(m9584b);
        if (c2725h != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c2725h.getLat());
            upLoadReportInfo.setTechnician_lat(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(c2725h.getLon());
            upLoadReportInfo.setTechnician_lon(sb3.toString());
        }
        upLoadReportInfo.setCar_lat(goloLat);
        upLoadReportInfo.setCar_lon(goloLon);
        upLoadReportInfo.setConclusion(m5233a2.f15644g);
        upLoadReportInfo.setGoloId(this.f12357d.mo7081k().getOtherUseID());
        upLoadReportInfo.setDiagnosis_start_time(this.f12357d.mo7081k().getRomote_diag_start_time());
        return reportAction.m5221a(upLoadReportInfo);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 20011) {
            UpLoadReportResponse upLoadReportResponse = (UpLoadReportResponse) obj;
            if (upLoadReportResponse.getCode() != 0) {
                this.f11585s.obtainMessage(2).sendToTarget();
                return;
            }
            this.f11582p = true;
            this.f11584r = upLoadReportResponse.getData();
            this.f11585s.obtainMessage(3).sendToTarget();
        } else if (i == 20015) {
            MineCarInfoResponse mineCarInfoResponse = (MineCarInfoResponse) obj;
            if (mineCarInfoResponse.getCode() == 0 && mineCarInfoResponse.getData().size() > 0) {
                this.f11585s.obtainMessage(0, mineCarInfoResponse.getData().get(0)).sendToTarget();
                return;
            }
            this.f11585s.obtainMessage(1).sendToTarget();
        } else {
            super.onSuccess(i, obj);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 20011) {
            this.f11585s.obtainMessage(2).sendToTarget();
        } else if (i == 20015) {
            this.f11585s.obtainMessage(1).sendToTarget();
        } else {
            super.onFailure(i, i2, obj);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_send && CommonTools.m7969a(this.mContext)) {
            if (!CommonTools.m7966b(this.mContext)) {
                NToast.m9450a(this.mContext, (int) R.string.common_network_unavailable);
                return;
            }
            try {
                C2778n.m4918a(getActivity());
            } catch (Exception e) {
                Log.i("XEE", "hidekeyboard error:" + e.toString());
                e.printStackTrace();
            }
            String obj = this.f11581o.getText().toString();
            ReportProduceTool m5233a = ReportProduceTool.m5233a();
            if (TextUtils.isEmpty(obj)) {
                obj = getString(R.string.report_null_conclusion);
            }
            m5233a.f15644g = obj;
            this.f11583q = LocationUtils.m4873a(getActivity());
            request(20011, true);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f11582p) {
                this.f12357d.mo7085f(1);
            } else {
                new C2083bt(this).m4610a(getActivity(), R.string.dialog_remotediag_handler_title, R.string.report_exit_without_upload, false);
            }
            return true;
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        MainActivity.m7887b(false);
        getActivity().findViewById(R.id.menu_update_tip).setVisibility(0);
        ReportProduceTool.m5233a().m5224c();
    }
}
