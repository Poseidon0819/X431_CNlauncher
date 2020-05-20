package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.Lang;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.CarIconAdapter;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.activity.upgrade.p239b.SimpleOnDownloadListener;
import com.cnlaunch.x431pro.activity.upgrade.p240c.DownloadLogic;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p269j.SoftMaxVersionResponse;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.CarVersion;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.C2773j;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.cnlaunch.x431pro.widget.p290a.ProgressDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/* renamed from: com.cnlaunch.x431pro.activity.setting.j */
/* loaded from: classes.dex */
public class DiagnosticLogVehicleListFragment extends BaseFragment {

    /* renamed from: b */
    private GridView f14819b;

    /* renamed from: c */
    private CarIconAdapter f14820c;

    /* renamed from: d */
    private String f14821d;

    /* renamed from: e */
    private Vector<DiagnoseLogInfoSearchUtil.C2749a> f14822e;

    /* renamed from: f */
    private Vector<DiagnoseLogInfoSearchUtil.C2749a> f14823f;

    /* renamed from: g */
    private List<CarIcon> f14824g;

    /* renamed from: h */
    private IconButton f14825h;

    /* renamed from: j */
    private String f14827j;

    /* renamed from: k */
    private String f14828k;

    /* renamed from: o */
    private ProgressDialog f14832o;

    /* renamed from: a */
    private final int f14818a = 1213;

    /* renamed from: i */
    private boolean f14826i = false;

    /* renamed from: l */
    private String f14829l = "";

    /* renamed from: m */
    private String f14830m = "";

    /* renamed from: n */
    private String f14831n = "";

    /* renamed from: p */
    private SimpleOnDownloadListener f14833p = new C2565k(this);

    /* renamed from: a */
    public static /* synthetic */ String m5913a(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        return diagnosticLogVehicleListFragment.f14828k;
    }

    /* renamed from: b */
    public static /* synthetic */ ProgressDialog m5909b(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        return diagnosticLogVehicleListFragment.f14832o;
    }

    /* renamed from: c */
    public static /* synthetic */ String m5907c(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        return diagnosticLogVehicleListFragment.f14829l;
    }

    /* renamed from: e */
    public static /* synthetic */ Context m5905e(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        return diagnosticLogVehicleListFragment.mContext;
    }

    /* renamed from: g */
    public static /* synthetic */ Context m5903g(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        return diagnosticLogVehicleListFragment.mContext;
    }

    /* renamed from: h */
    public static /* synthetic */ Context m5902h(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        return diagnosticLogVehicleListFragment.mContext;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_diagnostic_log_vehicle_list, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m5914a();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m5914a();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 1213) {
            String m9467a = LangManager.m9467a(LangManager.m9468a(this.mContext));
            String m9467a2 = LangManager.m9467a(Lang.f7203a);
            if (LangManager.m9468a(this.mContext).equalsIgnoreCase("zh")) {
                if (LangManager.m9465b(this.mContext).equalsIgnoreCase("TW")) {
                    m9467a = LangManager.m9467a(Lang.f7198G);
                    m9467a2 = LangManager.m9467a(Lang.f7203a);
                } else if (LangManager.m9465b(this.mContext).equalsIgnoreCase("HK")) {
                    m9467a = LangManager.m9467a(Lang.f7197F);
                    m9467a2 = LangManager.m9467a(Lang.f7203a);
                } else {
                    m9467a = LangManager.m9467a(Lang.f7199H);
                    m9467a2 = m9467a;
                }
            }
            UpgradeAction upgradeAction = new UpgradeAction(this.mContext);
            String str = this.f14828k;
            if (str != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("MAYBACH", "BENZ");
                hashMap.put("MINI", "BMW");
                hashMap.put("HCBMW", "BMW");
                hashMap.put("ROLLSROYCE", "BMW");
                hashMap.put("BENTLEY", "VW");
                hashMap.put("BUGATTI", "VW");
                hashMap.put("LAMBORGHINI", "VW");
                hashMap.put("FUKANG", "CITROEN");
                hashMap.put("DFPEUGEOT", "PEUGEOT");
                hashMap.put("ABARTH", "FIAT");
                hashMap.put("LANCIA", "FIAT");
                hashMap.put("ROMEO", "FIAT");
                hashMap.put("NJFIAT", "FIAT");
                hashMap.put("GMSA", "OPEL");
                hashMap.put("VAUXHALL", "OPEL");
                hashMap.put("DACIA", "RENAULT");
                hashMap.put("RENAULTSAMSUNG", "RENAULT");
                hashMap.put("CHANGANFORD", "USAFORD");
                hashMap.put("LINCOLN", "USAFORD");
                hashMap.put("EUROFORD", "USAFORD");
                hashMap.put("BUICK", "GM");
                hashMap.put("CADILLAC", "GM");
                hashMap.put("CHEVROLET", "GM");
                hashMap.put("DODGE", "CHRYSLER");
                hashMap.put("JEEP", "CHRYSLER");
                hashMap.put("CHCHEVROLET", "SGM");
                hashMap.put("CHBUICK", "SGM");
                hashMap.put("CHCADILLAC", "SGM");
                hashMap.put("YQMAZDA", "MAZDA");
                hashMap.put("LEXUS", "TOYOTA");
                hashMap.put("TJTOYOTA", "TOYOTA");
                hashMap.put("INFINITI", "NISSAN");
                hashMap.put("DFNISSAN", "NISSAN");
                hashMap.put("VENUCIA", "NISSAN");
                hashMap.put("NISSANGRT", "NISSAN");
                hashMap.put("ACURA", "HONDA");
                hashMap.put("DFHONDA", "HONDA");
                hashMap.put("GZHONDA", "HONDA");
                hashMap.put("TLISUZU", "JPISUZU");
                hashMap.put("JAGUAR", "LANDROVER");
                hashMap.put("JIANGHUAI", "JAC_TY");
                hashMap.put("CHSUZUKI", "CHANGHE");
                hashMap.put("LYNKCO", "VOLVO");
                hashMap.put("BAICSEN", "BAIC");
                hashMap.put("BAICXIN", "BAIC");
                hashMap.put("BAICWW", "BAIC");
                hashMap.put("DFFG", "DFXK");
                hashMap.put("LIUWEI_TY_PAKISTAN", "LIUWEI_TY");
                hashMap.put("EV_DODGE", "EV_CHRYSLER");
                hashMap.put("EV_JEEP", "EV_CHRYSLER");
                hashMap.put("EV_CHEVROLET", "EV_GM");
                hashMap.put("EV_CADILLAC", "EV_GM");
                hashMap.put("EV_BUICK", "EV_GM");
                hashMap.put("EV_GMSA", "EV_OPEL");
                hashMap.put("EV_SAICMG", "EV_OPEL");
                hashMap.put("EV_CHBUICK", "EV_SGM");
                hashMap.put("EV_CHCADILLAC", "EV_SGM");
                hashMap.put("EV_CHCHEVROLET", "EV_SGM");
                hashMap.put("EV_LINCOLN", "EV_USAFORD");
                hashMap.put("EV_EUROFORD", "EV_USAFORD");
                hashMap.put("EV_CHANGANFORD", "EV_USAFORD");
                hashMap.put("EV_MAYBACH", "EV_BENZ");
                hashMap.put("EV_ROLLSROYCE", "EV_BMW");
                hashMap.put("EV_MINI", "EV_BMW");
                hashMap.put("EV_HCBMW", "EV_BMW");
                hashMap.put("EV_DFCITROENZY", "EV_CITROEN");
                hashMap.put("EV_FUKANG", "EV_CITROEN");
                hashMap.put("EV_DACIA", "EV_RENAULT");
                hashMap.put("EV_RENAULTSAMSUNG", "EV_RENAULT");
                hashMap.put("EV_LYNKCO", "EV_VOLVO");
                hashMap.put("EV_BENTLEY", "EV_VW");
                hashMap.put("EV_BUGATTI", "EV_VW");
                hashMap.put("EV_LAMBORGHINI", "EV_VW");
                hashMap.put("EV_BAICSEN", "EV_BAIC");
                hashMap.put("EV_BAICXIN", "EV_BAIC");
                hashMap.put("EV_BAICWW", "EV_BAIC");
                hashMap.put("EV_ACURA", "EV_HONDA");
                hashMap.put("EV_DFHONDA", "EV_HONDA");
                hashMap.put("EV_GZHONDA", "EV_HONDA");
                hashMap.put("EV_LIUWEI_TY_PAKISTAN", "EV_LIUWEI_TY");
                hashMap.put("EV_GQMITSUBISHI", "EV_MITSUBISHI");
                hashMap.put("EV_INFINITI", "EV_NISSAN");
                hashMap.put("EV_NISSANGTR", "EV_NISSAN");
                hashMap.put("EV_DFNISSAN", "EV_NISSAN");
                hashMap.put("EV_VENUCIA", "EV_NISSAN");
                hashMap.put("EV_LEXUS", "EV_TOYOTA");
                hashMap.put("EV_TJTOYOTA", "EV_TOYOTA");
                if (hashMap.containsKey(str)) {
                    str = (String) hashMap.get(str);
                }
                this.f14829l = str;
            }
            return upgradeAction.m5274e(this.f14821d, this.f14829l, m9467a, m9467a2);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (this.mContentView != null && i == 1213) {
            if (obj != null) {
                SoftMaxVersionResponse softMaxVersionResponse = (SoftMaxVersionResponse) obj;
                if (-1 != softMaxVersionResponse.getCode()) {
                    if (softMaxVersionResponse.getCode() == 0 && softMaxVersionResponse.getSoftMaxVersionByName() != null) {
                        this.f14831n = softMaxVersionResponse.getSoftMaxVersionByName().getVersionNo();
                        if (!this.f14831n.startsWith("V")) {
                            this.f14831n = "V" + this.f14831n;
                        }
                    }
                } else {
                    new LoginFunction(this.mContext).m6572d();
                    return;
                }
            }
            m5910b();
            if (obj != null && (obj instanceof BaseResponse) && ((BaseResponse) obj).getCode() == 405) {
                NToast.m9450a(this.mContext, (int) R.string.get_division_info_not_matched);
            } else if (C2787z.m4821a(this.f14831n)) {
                NToast.m9450a(this.mContext, (int) R.string.check_soft_version_failure);
            }
            LoadDialog.m4681b(this.mContext);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (this.mContentView == null) {
            return;
        }
        LoadDialog.m4681b(this.mContext);
        FileUtils.m4995g(PathUtils.m4849g());
        if (i == 1213) {
            m5910b();
        } else if (this.mContext != null) {
            NToast.m9450a(this.mContext, (int) R.string.setting_upload_log_failure);
        }
    }

    /* renamed from: b */
    private void m5910b() {
        boolean z = false;
        if ((C2787z.m4821a(this.f14830m) && !C2787z.m4821a(this.f14831n) && CommonTools.m7966b(this.mContext)) || (!C2787z.m4821a(this.f14830m) && !C2787z.m4821a(this.f14831n) && m5911a(this.f14830m, this.f14831n) < 0)) {
            z = true;
        }
        if (DownloadLogic.m5609a(this.mContext).m5605a(this.f14829l) && CommonTools.m7966b(this.mContext)) {
            DownloadLogic.m5609a(this.mContext).f15310b = this.f14833p;
            this.f14832o.show();
        }
        if (z) {
            MessageDialog messageDialog = new MessageDialog(this.mContext, (int) R.string.common_title_tips, (int) R.string.upgrade_tips, true, (byte) 0);
            messageDialog.m4719a(R.string.upgrade_at_once, true, new View$OnClickListenerC2575u(this));
            messageDialog.show();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("SoftPackageId", this.f14828k);
        bundle.putString("VehicleName", this.f14827j);
        replaceFragment(OneKeyFeedbackFragment.class.getName(), bundle, 1);
    }

    /* renamed from: a */
    private static int m5911a(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        if (split[0].length() > split2[0].length()) {
            return 1;
        }
        if (split[0].length() < split2[0].length()) {
            return -1;
        }
        return str.compareTo(str2);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f14832o == null || !this.f14832o.isShowing()) {
                return;
            }
            this.f14832o.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m5914a() {
        setTitle(R.string.setting_onekey_feedback_txt);
        this.f14820c = new CarIconAdapter(this.mContext);
        this.f14820c.f11258c = true;
        this.f14819b = (GridView) getActivity().findViewById(R.id.gridview_vehicle_log);
        this.f14819b.setNumColumns(getResources().getInteger(R.integer.carlogoItemColumnNum));
        this.f14819b.setAdapter((ListAdapter) this.f14820c);
        this.f14819b.setOnItemClickListener(new C2572r(this));
        this.f14825h = (IconButton) getActivity().findViewById(R.id.btn_onekey_feedback_history);
        this.f14825h.setOnClickListener(new View$OnClickListenerC2573s(this));
        this.f14832o = new DialogC2574t(this, this.mContext);
        ProgressDialog progressDialog = this.f14832o;
        progressDialog.f16324b = false;
        progressDialog.setCanceledOnTouchOutside(false);
        this.f14832o.m4716b(getString(R.string.soft_download));
        this.f14821d = PreferencesManager.m9595a(this.mContext).m9584b("serialNo", "");
        this.f14822e = DiagnoseLogInfoSearchUtil.m5090a();
        this.f14823f = new Vector<>();
        this.f14824g = new ArrayList();
        CarIconUtils m4977a = CarIconUtils.m4977a(this.mContext);
        if (!TextUtils.isEmpty(this.f14821d)) {
            for (int i = 0; i < this.f14822e.size(); i++) {
                if (this.f14821d.equals(this.f14822e.get(i).getDeviceSN())) {
                    this.f14822e.get(i).setChecked(false);
                    this.f14823f.add(this.f14822e.get(i));
                    String vehicleSoftname = this.f14822e.get(i).getVehicleSoftname();
                    CarIcon m4951e = m4977a.m4951e(this.f14821d, vehicleSoftname);
                    if (m4951e != null) {
                        if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                            m4951e.f15792p = m4951e.m5038a(this.mContext);
                        }
                        if (!this.f14824g.contains(m4951e)) {
                            this.f14824g.add(m4951e);
                        }
                    } else {
                        CarIcon carIcon = new CarIcon();
                        carIcon.f15778b = vehicleSoftname;
                        carIcon.f15790n = this.f14821d;
                        carIcon.f15779c = vehicleSoftname;
                        carIcon.f15780d = vehicleSoftname;
                        carIcon.f15783g = vehicleSoftname;
                        carIcon.f15784h = vehicleSoftname;
                        carIcon.f15792p = vehicleSoftname;
                        carIcon.f15787k = Boolean.FALSE;
                        if (!this.f14824g.contains(carIcon)) {
                            this.f14824g.add(carIcon);
                        }
                    }
                }
            }
        } else {
            NToast.m9446b(this.mContext, getResources().getString(R.string.txt_no_connector));
        }
        CarIconAdapter carIconAdapter = this.f14820c;
        carIconAdapter.f11256a = this.f14824g;
        carIconAdapter.notifyDataSetChanged();
    }

    /* renamed from: d */
    public static /* synthetic */ void m5906d(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        MessageDialog messageDialog = new MessageDialog(diagnosticLogVehicleListFragment.mContext, (int) R.string.common_title_tips, (int) R.string.onkey_download_tip_other_serial, false, (byte) 0);
        messageDialog.m4719a(R.string.btn_confirm, true, new View$OnClickListenerC2576v(diagnosticLogVehicleListFragment));
        messageDialog.m4717b(R.string.btn_canlce, true, new View$OnClickListenerC2577w(diagnosticLogVehicleListFragment));
        if (diagnosticLogVehicleListFragment.getActivity().isFinishing()) {
            return;
        }
        messageDialog.show();
    }

    /* renamed from: i */
    public static /* synthetic */ void m5901i(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        CarIconUtils m4977a = CarIconUtils.m4977a(diagnosticLogVehicleListFragment.mContext);
        List<CarVersion> m4954d = m4977a.m4954d(diagnosticLogVehicleListFragment.f14821d, diagnosticLogVehicleListFragment.f14828k);
        String str = "";
        if (m4954d != null && !m4954d.isEmpty()) {
            Collections.sort(m4954d, new C2773j(m4977a));
            str = m4954d.get(0).f15828d;
        }
        diagnosticLogVehicleListFragment.f14830m = str;
    }

    /* renamed from: p */
    public static /* synthetic */ void m5894p(DiagnosticLogVehicleListFragment diagnosticLogVehicleListFragment) {
        LoadDialog.m4682a(diagnosticLogVehicleListFragment.mContext, diagnosticLogVehicleListFragment.getString(R.string.check_soft_version), false);
        diagnosticLogVehicleListFragment.request(1213);
    }
}
