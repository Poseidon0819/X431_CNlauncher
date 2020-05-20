package com.cnlaunch.x431pro.activity.p211a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.NetPOSPrinterUtil;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment;
import com.cnlaunch.x431pro.activity.p211a.p212a.HistoryDiagActionTestShowListViewAdapter;
import com.cnlaunch.x431pro.activity.p211a.p212a.HistoryDiagDTCShowListViewAdapter;
import com.cnlaunch.x431pro.module.history.model.HistoryActionModel;
import com.cnlaunch.x431pro.module.history.model.HistoryDTCModel;
import com.cnlaunch.x431pro.module.history.model.VehicleInfo;
import com.cnlaunch.x431pro.module.history.p266a.HistoryDao;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p288h.NetPOSPrinterUtilPro;
import com.cnlaunch.x431pro.widget.NoScrollerListView;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.PrinterFailrueDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.a.a */
/* loaded from: classes.dex */
public class HistoricalRecordsFragment extends BaseDiagnoseFragment implements View.OnClickListener {

    /* renamed from: A */
    private String f10763A;

    /* renamed from: B */
    private IconRadioButton f10764B;

    /* renamed from: C */
    private IconButton f10765C;

    /* renamed from: D */
    private VehicleInfo f10766D;

    /* renamed from: E */
    private HistoryDao f10767E;

    /* renamed from: j */
    private TextView f10772j;

    /* renamed from: k */
    private TextView f10773k;

    /* renamed from: l */
    private TextView f10774l;

    /* renamed from: m */
    private TextView f10775m;

    /* renamed from: n */
    private TextView f10776n;

    /* renamed from: o */
    private TextView f10777o;

    /* renamed from: p */
    private TextView f10778p;

    /* renamed from: q */
    private TextView f10779q;

    /* renamed from: r */
    private TextView f10780r;

    /* renamed from: s */
    private TextView f10781s;

    /* renamed from: t */
    private TextView f10782t;

    /* renamed from: u */
    private NoScrollerListView f10783u;

    /* renamed from: v */
    private NoScrollerListView f10784v;

    /* renamed from: y */
    private HistoryDiagDTCShowListViewAdapter f10787y;

    /* renamed from: z */
    private HistoryDiagActionTestShowListViewAdapter f10788z;

    /* renamed from: a */
    private final int f10770a = 10010;

    /* renamed from: b */
    private final int f10771b = 10011;

    /* renamed from: w */
    private List<HistoryDTCModel> f10785w = new ArrayList();

    /* renamed from: x */
    private List<HistoryActionModel> f10786x = new ArrayList();

    /* renamed from: F */
    private boolean f10768F = false;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: G */
    private Handler f10769G = new HandlerC1977c(this);

    /* renamed from: d */
    private void m7848d() {
        this.f10785w.clear();
        VehicleInfo vehicleInfo = this.f10766D;
        if (vehicleInfo != null) {
            this.f10785w = this.f10767E.m5302a(vehicleInfo.getVehicleId(), this.f10766D.getCharSet());
        }
        List<HistoryDTCModel> list = this.f10785w;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                z = true;
                break;
            } else if (list.get(i).getIsShowSystem() == 0) {
                break;
            } else {
                i++;
            }
        }
        this.f10768F = z;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10767E = HistoryDao.m5300a(this.mContext);
        return layoutInflater.inflate(R.layout.fragment_history_show_all, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public void setBundle(Bundle bundle) {
        super.setBundle(bundle);
        if (bundle != null) {
            this.f10766D = (VehicleInfo) bundle.getParcelable("VehicleInfo");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.Historical_records_txt);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f10772j = (TextView) getActivity().findViewById(R.id.tv_make_value);
        this.f10773k = (TextView) getActivity().findViewById(R.id.tv_model_value);
        this.f10774l = (TextView) getActivity().findViewById(R.id.tv_year_value);
        this.f10777o = (TextView) getActivity().findViewById(R.id.tv_color_value);
        this.f10776n = (TextView) getActivity().findViewById(R.id.tv_mileage_value);
        this.f10778p = (TextView) getActivity().findViewById(R.id.tv_engine_value);
        this.f10779q = (TextView) getActivity().findViewById(R.id.tv_testtime_value);
        this.f10775m = (TextView) getActivity().findViewById(R.id.tv_vin_value);
        this.f10780r = (TextView) getActivity().findViewById(R.id.tv_car_model_software_version_value);
        this.f10781s = (TextView) getActivity().findViewById(R.id.tv_diagnostic_software_version_value);
        this.f10782t = (TextView) getActivity().findViewById(R.id.tv_diagnostic_path_value);
        this.f10783u = (NoScrollerListView) getActivity().findViewById(R.id.listview_history_dtc);
        getActivity().findViewById(R.id.history_dtc_sys_name).setVisibility(8);
        this.f10787y = new HistoryDiagDTCShowListViewAdapter(this.mContext);
        this.f10783u.setAdapter((ListAdapter) this.f10787y);
        this.f10783u.setDivider(null);
        getActivity().findViewById(R.id.layout_history_actuation_test).setVisibility(8);
        this.f10784v = (NoScrollerListView) getActivity().findViewById(R.id.listview_history_actuation_test);
        this.f10788z = new HistoryDiagActionTestShowListViewAdapter(this.mContext);
        this.f10784v.setAdapter((ListAdapter) this.f10788z);
        this.f10784v.setDivider(null);
        this.f10764B = (IconRadioButton) getActivity().findViewById(R.id.btn_history_diag_print);
        this.f10764B.setOnClickListener(this);
        this.f10765C = (IconButton) getActivity().findViewById(R.id.btn_gotoDiag);
        this.f10765C.setOnClickListener(this);
        VehicleInfo vehicleInfo = this.f10766D;
        if (vehicleInfo != null) {
            this.f10772j.setText(vehicleInfo.getMark());
            this.f10773k.setText(this.f10766D.getModel());
            this.f10774l.setText(this.f10766D.getYear());
            this.f10777o.setText(this.f10766D.getColor());
            TextView textView = this.f10776n;
            Context context = this.mContext;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10766D.getMileage());
            textView.setText(C2744aa.m5184a(context, sb.toString(), Boolean.FALSE));
            this.f10778p.setText(this.f10766D.getEngine());
            this.f10779q.setText(this.f10766D.getTimeStamp());
            this.f10775m.setText(this.f10766D.getVIN());
            this.f10780r.setText(this.f10766D.getVehicleSoftVersion());
            this.f10781s.setText(this.f10766D.getDiagSoftVersion());
            this.f10782t.setText(this.f10766D.getMenuPath());
        }
        getActivity().findViewById(R.id.tv_vehicle_title).setFocusable(true);
        getActivity().findViewById(R.id.tv_vehicle_title).setFocusableInTouchMode(true);
        getActivity().findViewById(R.id.tv_vehicle_title).requestFocus();
        new C1976b(this).start();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        int a;
        if (i != 20013) {
            switch (i) {
                case 10010:
                    try {
                        m7848d();
                        return Boolean.TRUE;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return Boolean.FALSE;
                    }
                case 10011:
                    try {
                        this.f10786x.clear();
                        return Boolean.TRUE;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return Boolean.FALSE;
                    }
                default:
                    return super.doInBackground(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.Historical_records_title_txt) + "\n");
        sb.append(getString(R.string.Historical_records_make_txt) + ((Object) this.f10772j.getText()) + "\t");
        sb.append(getString(R.string.Historical_records_vin_txt) + ((Object) this.f10775m.getText()) + "\n");
        sb.append(getString(R.string.Historical_records_model_txt) + ((Object) this.f10773k.getText()) + "\t");
        sb.append(getString(R.string.Historical_records_mileage_txt) + ((Object) this.f10776n.getText()) + "\n");
        sb.append(getString(R.string.Historical_records_year_txt) + ((Object) this.f10774l.getText()) + "\t");
        sb.append(getString(R.string.Historical_records_color_txt) + ((Object) this.f10777o.getText()) + "\n");
        sb.append(getString(R.string.Historical_records_engine_txt) + ((Object) this.f10778p.getText()) + "\n");
        sb.append(getString(R.string.report_diagnose_time) + ((Object) this.f10779q.getText()) + "\n");
        sb.append(getString(R.string.Historical_records_car_model_software_version_txt) + ((Object) this.f10780r.getText()) + "\n");
        sb.append(getString(R.string.Historical_records_diagnostic_software_version_txt) + ((Object) this.f10781s.getText()) + "\n");
        sb.append(getString(R.string.diagloghistorydetail_userOperatePath) + ((Object) this.f10782t.getText()) + "\n");
        sb.append(getString(R.string.tv_fault_title) + "\t" + getString(R.string.tv_fault_value) + "\t" + getString(R.string.tv_fault_statue) + (this.f10768F ? "\t" + getString(R.string.report_null_diangnose_name) : "") + "\n");
        if (this.f10785w.isEmpty()) {
            sb.append(getString(R.string.tip_null_info) + "\n\n");
        } else {
            for (int i2 = 0; i2 < this.f10785w.size(); i2++) {
                sb.append(this.f10785w.get(i2).getDTC() + "\t" + this.f10785w.get(i2).getDescription() + "\t" + this.f10785w.get(i2).getStatus() + (this.f10768F ? "\t" + this.f10785w.get(i2).getSystemName() : "") + "\n");
                if (this.f10768F) {
                    sb.append("\t" + this.f10785w.get(i2).getSystemName());
                }
            }
        }
        this.f10763A = sb.toString();
        Context context = this.mContext;
        Bitmap a2 = NetPOSPrinterUtilPro.m9436a(NetPOSPrinterUtilPro.m9440a(context), NetPOSPrinterUtilPro.m4936a(context, this.f10763A, null));
        if (PreferencesManager.m9595a(context).m9583b(C1947h.f10555g, false)) {
            a = NetPOSPrinterUtilPro.m9435a(a2, PreferencesManager.m9595a(context).m9591a(C1947h.f10554f));
        } else {
            a = NetPOSPrinterUtilPro.m9438a(context, a2);
        }
        return Integer.valueOf(a);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i == 20013) {
            this.f10769G.obtainMessage(0).sendToTarget();
            LoadDialog.m4681b(this.mContext);
            Integer num = (Integer) obj;
            NetPOSPrinterUtil.m9439a(getActivity(), num.intValue());
            if (num.intValue() == 4095) {
                if (PreferencesManager.m9595a(this.mContext).m9583b(C1947h.f10555g, false)) {
                    new PrinterFailrueDialog(this.mContext).show();
                    return;
                } else {
                    NToast.m9447b(this.mContext, (int) R.string.print_connect_printer);
                    return;
                }
            }
            return;
        }
        switch (i) {
            case 10010:
                HistoryDiagDTCShowListViewAdapter historyDiagDTCShowListViewAdapter = this.f10787y;
                historyDiagDTCShowListViewAdapter.f10796a = this.f10785w;
                historyDiagDTCShowListViewAdapter.f10797b = this.f10768F;
                historyDiagDTCShowListViewAdapter.notifyDataSetChanged();
                if (this.f10768F) {
                    getActivity().findViewById(R.id.history_dtc_sys_name).setVisibility(0);
                } else {
                    getActivity().findViewById(R.id.history_dtc_sys_name).setVisibility(8);
                }
                LoadDialog.m4681b(this.mContext);
                return;
            case 10011:
                HistoryDiagActionTestShowListViewAdapter historyDiagActionTestShowListViewAdapter = this.f10788z;
                historyDiagActionTestShowListViewAdapter.f10789a = this.f10786x;
                historyDiagActionTestShowListViewAdapter.notifyDataSetChanged();
                LoadDialog.m4681b(this.mContext);
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i == 10010) {
            LoadDialog.m4681b(this.mContext);
        } else if (i != 20013) {
        } else {
            this.f10769G.obtainMessage(0).sendToTarget();
            LoadDialog.m4681b(this.mContext);
            NToast.m9450a(getActivity(), (int) R.string.print_error_fail);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_gotoDiag) {
            if (id != R.id.btn_history_diag_print) {
                return;
            }
            LoadDialog.m4685a(this.mContext, (int) R.string.printing_progress);
            request(20013);
            return;
        }
        VehicleInfo vehicleInfo = this.f10766D;
        if (vehicleInfo != null) {
            C2744aa.m5188a(getActivity(), vehicleInfo, false);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NLog.m9456a("yhx", "HistoryRecords onKeyDown enter.");
        if (i == 4 && keyEvent.getAction() == 0) {
            replaceFragment(HistoryFragment.class.getName(), new Bundle(), 0, false);
            return true;
        }
        return false;
    }
}
