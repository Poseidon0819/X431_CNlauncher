package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.module.cloud.model.CloudDiagSystemInfo;
import com.cnlaunch.x431pro.module.cloud.model.CloudHistoryDetail;
import com.cnlaunch.x431pro.module.cloud.model.CloudHistoryDetailResponse;
import com.cnlaunch.x431pro.module.cloud.model.CloudReportListInfo;
import com.cnlaunch.x431pro.module.cloud.model.CloudReportListResponse;
import com.cnlaunch.x431pro.module.cloud.model.CloudSystemInfo;
import com.cnlaunch.x431pro.module.cloud.p247a.CloudAction;
import com.cnlaunch.x431pro.module.history.model.VehicleInfo;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;
import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshListView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.j */
/* loaded from: classes.dex */
public class CloudHistoryFragment extends BaseFragment implements FragmentKeyDownListener.InterfaceC1949a, OnActivityResultListenter, PullToRefreshBase.InterfaceC2936e<ListView> {

    /* renamed from: h */
    private String f10654h;

    /* renamed from: i */
    private String f10655i;

    /* renamed from: j */
    private String f10656j;

    /* renamed from: k */
    private String f10657k;

    /* renamed from: l */
    private PullToRefreshListView f10658l;

    /* renamed from: m */
    private CloudHistoryAdapter f10659m;

    /* renamed from: n */
    private LinearLayout f10660n;

    /* renamed from: o */
    private Button f10661o;

    /* renamed from: p */
    private TextView f10662p;

    /* renamed from: q */
    private TextView f10663q;

    /* renamed from: r */
    private TextView f10664r;

    /* renamed from: s */
    private TextView f10665s;

    /* renamed from: u */
    private LinearLayout f10667u;

    /* renamed from: d */
    private InfaceFragmentParent f10650d = null;

    /* renamed from: e */
    private final int f10651e = 772;

    /* renamed from: f */
    private final int f10652f = 773;

    /* renamed from: g */
    private final int f10653g = 774;

    /* renamed from: a */
    List<CloudReportListInfo> f10647a = new ArrayList();

    /* renamed from: t */
    private List<VehicleInfo> f10666t = new ArrayList();

    /* renamed from: b */
    String f10648b = "";

    /* renamed from: c */
    String f10649c = "";

    /* renamed from: v */
    private int f10668v = 1;

    /* renamed from: w */
    private final int f10669w = 10;

    /* renamed from: x */
    private String f10670x = "";

    /* renamed from: y */
    private final BroadcastReceiver f10671y = new C1959k(this);

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final long mo5997a() {
        return 0L;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final void mo5996a(int i, int i2, Intent intent) {
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final boolean mo5995a(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_history, viewGroup, false);
        this.f10658l = (PullToRefreshListView) inflate.findViewById(R.id.lv_diagnose_history);
        this.f10660n = (LinearLayout) inflate.findViewById(R.id.view_history_tip);
        this.f10661o = (Button) inflate.findViewById(R.id.btn_diagnose);
        this.f10662p = (TextView) inflate.findViewById(R.id.tv_plate_title);
        this.f10663q = (TextView) inflate.findViewById(R.id.tv_brand);
        this.f10664r = (TextView) inflate.findViewById(R.id.tv_year);
        this.f10665s = (TextView) inflate.findViewById(R.id.tv_vin);
        this.f10667u = (LinearLayout) inflate.findViewById(R.id.btn_scan_plate);
        this.f10659m = new CloudHistoryAdapter(getActivity());
        this.f10658l.setAdapter(this.f10659m);
        this.f10658l.setOnRefreshListener(this);
        this.f10658l.setMode(PullToRefreshBase.EnumC2933b.PULL_FROM_END);
        return inflate;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.cnlaunch.cloudreport.action.result");
        this.mContext.registerReceiver(this.f10671y, intentFilter);
        try {
            this.f10650d = (InfaceFragmentParent) getActivity();
            if (this.f10650d != null) {
                this.f10650d.mo6035a(this);
            }
        } catch (Exception e) {
            NLog.m9451c("XEE", "infaceFragmentParent Error:" + e.toString());
        }
        setTitle(R.string.text_cloud_diagnose);
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            this.f10654h = bundle2.getString("vin");
            this.f10655i = bundle2.getString("plate");
            this.f10656j = bundle2.getString("brand");
            this.f10657k = bundle2.getString("year");
            this.f10670x = bundle2.getString("package_id");
        }
        if (TextUtils.isEmpty(this.f10655i)) {
            this.f10662p.setText(getResources().getString(R.string.cloud_no_plate_number_tip));
            this.f10667u.setVisibility(0);
        } else {
            this.f10662p.setText(this.f10655i);
        }
        this.f10665s.setText(this.f10654h);
        this.f10663q.setText(this.f10656j);
        this.f10664r.setText(this.f10657k);
        CloudHistoryAdapter cloudHistoryAdapter = this.f10659m;
        cloudHistoryAdapter.f10621a = this;
        cloudHistoryAdapter.m7928a(this.f10647a);
        this.f10661o.setOnClickListener(new View$OnClickListenerC1961m(this));
        this.f10667u.setOnClickListener(new View$OnClickListenerC1962n(this));
        if (this.f10647a.size() == 0) {
            LoadDialog.m4680b(this.mContext, this.mContext.getString(R.string.refresh_txt));
            request(772, true);
        } else {
            this.f10660n.setVisibility(8);
        }
        new AutoCodePresenter(this.mContext).m7933a(this.f10654h, "", new C1963o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7925b() {
        Intent intent = new Intent("show_cloud_diag");
        Bundle bundle = new Bundle();
        bundle.putString("VIN", this.f10654h);
        bundle.putString("package_id", this.f10670x);
        intent.putExtras(bundle);
        this.mContext.sendBroadcast(intent);
    }

    @Override // com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase.InterfaceC2936e
    /* renamed from: f_ */
    public final void mo4423f_() {
        NLog.m9452b("XEE", "onRefresh:" + this.f10668v + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (this.f10647a.size() / 10));
        if (this.f10668v == this.f10647a.size() / 10) {
            new Thread(new RunnableC1964p(this));
        } else {
            request(772, true);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 772:
                return new CloudAction(this.mContext).m5420a(this.f10654h, "", "", this.f10668v, 10);
            case 773:
                return new CloudAction(this.mContext).m5421a(this.f10648b, this.f10649c);
            case 774:
                return new CloudAction(this.mContext).m5420a(this.f10654h, "", "", 1, 1);
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        CloudHistoryDetailResponse cloudHistoryDetailResponse;
        switch (i) {
            case 772:
                LoadDialog.m4681b(this.mContext);
                if (isAdded()) {
                    this.f10658l.m4428i();
                    CloudReportListResponse cloudReportListResponse = (CloudReportListResponse) obj;
                    if (cloudReportListResponse == null || cloudReportListResponse.getData() == null) {
                        return;
                    }
                    List<CloudReportListInfo> data = cloudReportListResponse.getData();
                    if (data != null) {
                        if (this.f10647a.size() == 0) {
                            this.f10647a = data;
                        } else {
                            List<CloudReportListInfo> list = this.f10647a;
                            int intValue = Integer.valueOf(list.get(list.size() - 1).getRec_date()).intValue();
                            boolean z = false;
                            for (int i2 = 0; i2 < data.size(); i2++) {
                                if (z) {
                                    this.f10647a.add(data.get(i2));
                                } else if (Integer.valueOf(data.get(i2).getRec_date()).intValue() < intValue) {
                                    this.f10647a.add(data.get(i2));
                                    z = true;
                                }
                            }
                        }
                    }
                    m7922c();
                    this.f10668v = (this.f10647a.size() / 10) + 1;
                    this.f10660n.setVisibility(8);
                    this.f10659m.m7928a(this.f10647a);
                    return;
                }
                return;
            case 773:
                if (!isAdded() || (cloudHistoryDetailResponse = (CloudHistoryDetailResponse) obj) == null || cloudHistoryDetailResponse.getData() == null) {
                    return;
                }
                CloudHistoryDetail data2 = cloudHistoryDetailResponse.getData();
                VehicleInfo vehicleInfo = new VehicleInfo();
                if (TextUtils.isEmpty(data2.getSoftpackageid())) {
                    NLog.m9452b("XEE", "获取的报告是之前服务器没有将softpackageid入库的的记录，导致APK无法快速测试! 改用VIN码进入的方式");
                    m7925b();
                    return;
                }
                vehicleInfo.setVehicleUID(data2.getSoftpackageid());
                vehicleInfo.setVIN(data2.getVin());
                vehicleInfo.setSN(PreferencesManager.m9595a(this.mContext).m9591a("serialNo"));
                vehicleInfo.setMark(data2.getCar_series());
                vehicleInfo.setYear(data2.getCar_producing_year());
                vehicleInfo.setLanguage(1);
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                List<CloudDiagSystemInfo> system_list = data2.getSystem_list();
                if (system_list != null) {
                    for (CloudDiagSystemInfo cloudDiagSystemInfo : system_list) {
                        CloudSystemInfo cloudSystemInfo = new CloudSystemInfo();
                        cloudSystemInfo.f15499c = cloudDiagSystemInfo.getName_id();
                        cloudSystemInfo.f15498b = cloudDiagSystemInfo.getSystem_uid();
                        cloudSystemInfo.f15497a = cloudDiagSystemInfo.getSystem();
                        arrayList.add(cloudSystemInfo);
                        if (TextUtils.isEmpty(cloudDiagSystemInfo.getSystem_uid())) {
                            NLog.m9452b("XEE", "获取的报告是之前服务器没有将system_uid入库的的记录，导致APK无法快速测试! 改用VIN码进入");
                            m7925b();
                            return;
                        }
                    }
                }
                Intent intent = new Intent("show_cloud_diag");
                Bundle bundle = new Bundle();
                bundle.putBoolean("HISTORY_FLAG", true);
                bundle.putParcelable("VehicleInfo", vehicleInfo);
                bundle.putParcelableArrayList("CloudSystemInfo", arrayList);
                intent.putExtras(bundle);
                this.mContext.sendBroadcast(intent);
                return;
            case 774:
                CloudReportListResponse cloudReportListResponse2 = (CloudReportListResponse) obj;
                if (cloudReportListResponse2 == null || cloudReportListResponse2.getData() == null) {
                    return;
                }
                if (this.f10647a.size() == 0) {
                    this.f10647a.add(cloudReportListResponse2.getData().get(0));
                } else if (this.f10647a.size() > 0 && Integer.valueOf(this.f10647a.get(0).getRec_date()).intValue() < Integer.valueOf(cloudReportListResponse2.getData().get(0).getRec_date()).intValue()) {
                    this.f10647a.add(0, cloudReportListResponse2.getData().get(0));
                }
                m7922c();
                this.f10660n.setVisibility(8);
                this.f10659m.m7928a(this.f10647a);
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 772) {
            LoadDialog.m4681b(this.mContext);
            this.f10658l.m4428i();
        }
        super.onFailure(i, i2, obj);
    }

    /* renamed from: c */
    private void m7922c() {
        if (this.f10647a.size() > 0) {
            CloudReportListInfo cloudReportListInfo = this.f10647a.get(0);
            NLog.m9452b("XEE", "m_Plate:" + this.f10655i + "  列表查询到的:" + cloudReportListInfo.getPlate_number());
            if (TextUtils.isEmpty(this.f10655i) && !TextUtils.isEmpty(cloudReportListInfo.getPlate_number())) {
                this.f10655i = cloudReportListInfo.getPlate_number();
                this.f10662p.setText(this.f10655i);
                this.f10667u.setVisibility(8);
            }
            NLog.m9452b("XEE", "m_Brand:" + this.f10656j + " 列表查询到的:" + cloudReportListInfo.getVehicle_series() + " m_Year:" + this.f10657k + " 列表查询到的:" + cloudReportListInfo.getModel_years());
            this.f10663q.setText(TextUtils.isEmpty(this.f10656j) ? cloudReportListInfo.getVehicle_series() : this.f10656j);
            this.f10664r.setText(TextUtils.isEmpty(this.f10657k) ? cloudReportListInfo.getModel_years() : this.f10657k);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            getActivity().unregisterReceiver(this.f10671y);
        } catch (Exception unused) {
        }
    }
}
