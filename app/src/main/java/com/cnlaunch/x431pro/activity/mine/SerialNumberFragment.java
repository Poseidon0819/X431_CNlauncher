package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p219b.CarIconManager;
import com.cnlaunch.x431pro.activity.mine.p229a.SerialNoAdapter;
import com.cnlaunch.x431pro.module.p255e.p256a.ConnectorAction;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductsRegDateResponse;
import com.cnlaunch.x431pro.module.rtu.HomeStartActivity;
import com.cnlaunch.x431pro.module.rtu.ProductInformation;
import com.cnlaunch.x431pro.module.rtu.RegisterAndLoadInfomation;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.widget.ListViewForScrollView;
import com.cnlaunch.x431pro.widget.p290a.ConnectorInfoPopupWindow;
import com.cnlaunch.x431pro.widget.p290a.LogoutDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.mine.cx */
/* loaded from: classes.dex */
public class SerialNumberFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public static final String f14115a = "cx";

    /* renamed from: A */
    private SerialNoAdapter f14116A;

    /* renamed from: B */
    private SerialNoAdapter f14117B;

    /* renamed from: C */
    private List<SerialNumber> f14118C;

    /* renamed from: D */
    private List<SerialNumber> f14119D;

    /* renamed from: E */
    private List<SerialNumber> f14120E;

    /* renamed from: F */
    private List<SerialNumber> f14121F;

    /* renamed from: G */
    private List<SerialNumber> f14122G;

    /* renamed from: H */
    private List<SerialNumber> f14123H;

    /* renamed from: I */
    private List<SerialNumber> f14124I;

    /* renamed from: J */
    private List<SerialNumber> f14125J;

    /* renamed from: K */
    private String f14126K;

    /* renamed from: L */
    private String f14127L;

    /* renamed from: M */
    private String f14128M;

    /* renamed from: N */
    private String f14129N;

    /* renamed from: O */
    private ScrollView f14130O;

    /* renamed from: P */
    private String f14131P;

    /* renamed from: b */
    public PreferencesManager f14134b;

    /* renamed from: c */
    public View f14135c;

    /* renamed from: d */
    public ConnectorInfoPopupWindow f14136d;

    /* renamed from: e */
    public String f14137e;

    /* renamed from: f */
    public SerialNumber f14138f;

    /* renamed from: g */
    public String f14139g;

    /* renamed from: i */
    private SerialNumberDao f14141i;

    /* renamed from: j */
    private ConnectorAction f14142j;

    /* renamed from: k */
    private ListViewForScrollView f14143k;

    /* renamed from: l */
    private ListViewForScrollView f14144l;

    /* renamed from: m */
    private ListViewForScrollView f14145m;

    /* renamed from: n */
    private ListViewForScrollView f14146n;

    /* renamed from: o */
    private ListViewForScrollView f14147o;

    /* renamed from: p */
    private ListViewForScrollView f14148p;

    /* renamed from: q */
    private TextView f14149q;

    /* renamed from: r */
    private TextView f14150r;

    /* renamed from: s */
    private TextView f14151s;

    /* renamed from: t */
    private TextView f14152t;

    /* renamed from: u */
    private TextView f14153u;

    /* renamed from: v */
    private TextView f14154v;

    /* renamed from: w */
    private SerialNoAdapter f14155w;

    /* renamed from: x */
    private SerialNoAdapter f14156x;

    /* renamed from: y */
    private SerialNoAdapter f14157y;

    /* renamed from: z */
    private SerialNoAdapter f14158z;

    /* renamed from: h */
    private final int f14140h = 2203;

    /* renamed from: Q */
    private boolean f14132Q = false;

    /* renamed from: R */
    private BroadcastReceiver f14133R = new C2473cy(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m6191a();
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_myserialno, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6191a() {
        setTitle(R.string.mine_connector_title);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        m6180d();
        this.f14130O = (ScrollView) getActivity().findViewById(R.id.mySerialNo);
        this.f14143k = (ListViewForScrollView) getActivity().findViewById(R.id.lv_user_serial_number);
        this.f14143k.setOnItemClickListener(this);
        this.f14144l = (ListViewForScrollView) getActivity().findViewById(R.id.lv_local_serial_number);
        this.f14144l.setOnItemClickListener(this);
        this.f14149q = (TextView) getActivity().findViewById(R.id.tv_user_serial_number);
        this.f14150r = (TextView) getActivity().findViewById(R.id.tv_local_serial_number);
        this.f14145m = (ListViewForScrollView) getActivity().findViewById(R.id.lv_user_heavy_serial_number);
        this.f14145m.setOnItemClickListener(this);
        this.f14146n = (ListViewForScrollView) getActivity().findViewById(R.id.lv_local_heavy_serial_number);
        this.f14146n.setOnItemClickListener(this);
        this.f14151s = (TextView) getActivity().findViewById(R.id.tv_user_heavy_serial_number);
        this.f14152t = (TextView) getActivity().findViewById(R.id.tv_local_heavy_serial_number);
        this.f14147o = (ListViewForScrollView) getActivity().findViewById(R.id.lv_user_car_and_heavy_serial_number);
        this.f14147o.setOnItemClickListener(this);
        this.f14148p = (ListViewForScrollView) getActivity().findViewById(R.id.lv_local_car_and_heavy_serial_number);
        this.f14148p.setOnItemClickListener(this);
        this.f14153u = (TextView) getActivity().findViewById(R.id.tv_user_car_and_heavy_serial_number);
        this.f14154v = (TextView) getActivity().findViewById(R.id.tv_local_car_and_heavy_serial_number);
        m6183c();
        m6186b();
    }

    /* renamed from: b */
    private void m6186b() {
        if (this.f14132Q) {
            return;
        }
        this.f14151s.setVisibility(8);
        this.f14145m.setVisibility(8);
        this.f14152t.setVisibility(8);
        this.f14146n.setVisibility(8);
        this.f14153u.setVisibility(8);
        this.f14147o.setVisibility(8);
        this.f14154v.setVisibility(8);
        this.f14148p.setVisibility(8);
    }

    /* renamed from: c */
    private void m6183c() {
        this.f14130O.smoothScrollBy(0, 0);
        this.f14134b = PreferencesManager.m9595a(this.mContext);
        this.f14132Q = this.f14134b.m9583b("is_heavyduty", false);
        this.f14127L = this.f14134b.m9591a("serialNo");
        this.f14128M = this.f14134b.m9591a("carSerialNo");
        this.f14129N = this.f14134b.m9591a("heavydutySerialNo");
        this.f14139g = this.f14134b.m9591a("new_car_prefix");
        String str = f14115a;
        NLog.m9456a(str, "beforeChangedSerialNo=" + this.f14127L + ",currentCarSerialNo=" + this.f14128M + ",currentHeavySerialNo=" + this.f14129N + ",newCarPrefix = " + this.f14139g);
        this.f14137e = this.f14134b.m9584b("login_state", "0");
        this.f14142j = new ConnectorAction(this.mContext);
        this.f14141i = DBManager.m5036a(this.mContext).f15794a.f15798a;
        this.f14119D = this.f14141i.loadAll();
        this.f14118C = new ArrayList();
        for (SerialNumber serialNumber : this.f14119D) {
            if (C2744aa.m5168b(serialNumber.f15834d, this.mContext)) {
                this.f14118C.add(serialNumber);
            } else if (C2744aa.m5177a(serialNumber.f15834d, this.mContext)) {
                this.f14118C.add(serialNumber);
            } else if (C2744aa.m5161c(serialNumber.f15834d, this.mContext)) {
                this.f14118C.add(serialNumber);
            }
        }
        String str2 = f14115a;
        NLog.m9456a(str2, "allSerialNumberList=" + this.f14118C);
        this.f14120E = new ArrayList();
        this.f14121F = new ArrayList();
        this.f14122G = new ArrayList();
        this.f14123H = new ArrayList();
        this.f14124I = new ArrayList();
        this.f14125J = new ArrayList();
        if (!LoginTools.m7946a(this.mContext)) {
            for (SerialNumber serialNumber2 : this.f14118C) {
                serialNumber2.f15832b = Boolean.FALSE;
            }
            this.f14141i.updateInTx(this.f14118C);
        }
        for (SerialNumber serialNumber3 : this.f14118C) {
            if (serialNumber3.f15832b.booleanValue()) {
                if (C2744aa.m5168b(serialNumber3.f15834d, this.mContext)) {
                    this.f14120E.add(serialNumber3);
                } else if (C2744aa.m5177a(serialNumber3.f15834d, this.mContext)) {
                    this.f14122G.add(serialNumber3);
                } else if (C2744aa.m5161c(serialNumber3.f15834d, this.mContext)) {
                    this.f14124I.add(serialNumber3);
                }
            } else if (C2744aa.m5168b(serialNumber3.f15834d, this.mContext)) {
                this.f14121F.add(serialNumber3);
            } else if (C2744aa.m5177a(serialNumber3.f15834d, this.mContext)) {
                this.f14123H.add(serialNumber3);
            } else if (C2744aa.m5161c(serialNumber3.f15834d, this.mContext)) {
                this.f14125J.add(serialNumber3);
            }
        }
        this.f14155w = new SerialNoAdapter(this.f14120E, this.mContext, this);
        this.f14143k.setAdapter((ListAdapter) this.f14155w);
        this.f14157y = new SerialNoAdapter(this.f14122G, this.mContext, this);
        this.f14145m.setAdapter((ListAdapter) this.f14157y);
        this.f14116A = new SerialNoAdapter(this.f14124I, this.mContext, this);
        this.f14147o.setAdapter((ListAdapter) this.f14116A);
        this.f14156x = new SerialNoAdapter(this.f14121F, this.mContext, this);
        this.f14144l.setAdapter((ListAdapter) this.f14156x);
        this.f14158z = new SerialNoAdapter(this.f14123H, this.mContext, this);
        this.f14146n.setAdapter((ListAdapter) this.f14158z);
        this.f14117B = new SerialNoAdapter(this.f14125J, this.mContext, this);
        this.f14148p.setAdapter((ListAdapter) this.f14117B);
        if (this.f14118C.isEmpty()) {
            this.f14150r.setText(R.string.connector_need_activate);
        }
        String str3 = this.f14137e;
        if (str3 == null || !str3.equals("1")) {
            this.f14149q.setVisibility(8);
            this.f14151s.setVisibility(8);
            this.f14153u.setVisibility(8);
            this.f14150r.setVisibility(0);
            this.f14150r.setText(R.string.mine_tv_select_serialno);
            if (this.f14123H.isEmpty()) {
                this.f14152t.setVisibility(8);
            } else {
                this.f14152t.setVisibility(0);
            }
            if (this.f14125J.isEmpty()) {
                this.f14154v.setVisibility(8);
                return;
            } else {
                this.f14154v.setVisibility(0);
                return;
            }
        }
        String str4 = this.f14137e;
        if (str4 == null || !str4.equals("1")) {
            return;
        }
        this.f14149q.setVisibility(0);
        this.f14149q.setText(R.string.mine_tv_user_device);
        if (this.f14122G.isEmpty()) {
            this.f14151s.setVisibility(8);
        } else {
            this.f14151s.setVisibility(0);
            this.f14151s.setText(R.string.mine_tv_user_heavy_device);
        }
        if (this.f14124I.isEmpty()) {
            this.f14153u.setVisibility(8);
        } else {
            this.f14153u.setVisibility(0);
            this.f14153u.setText(R.string.mine_tv_user_car_and_heavy_device);
        }
        this.f14150r.setVisibility(0);
        this.f14150r.setText(R.string.mine_tv_other_device);
        if (this.f14123H.isEmpty()) {
            this.f14152t.setVisibility(8);
        } else {
            this.f14152t.setVisibility(0);
            this.f14152t.setText(R.string.mine_tv_user_heavy_device);
        }
        if (this.f14125J.isEmpty()) {
            this.f14154v.setVisibility(8);
            return;
        }
        this.f14154v.setVisibility(0);
        this.f14154v.setText(R.string.mine_tv_user_car_and_heavy_device);
    }

    /* renamed from: a */
    private void m6187a(List<SerialNumber> list, int i) {
        String str;
        String str2 = list.get(i).f15834d;
        this.f14128M = this.f14134b.m9591a("carSerialNo");
        this.f14129N = this.f14134b.m9591a("heavydutySerialNo");
        this.f14131P = this.f14134b.m9591a("carAndHeavydutySerialNo");
        C1856n.m8130a("yhx", "original currentSerialNo=".concat(String.valueOf(str2)));
        if (C2744aa.m5168b(str2, this.mContext)) {
            if (!str2.equals(this.f14128M)) {
                this.f14128M = str2;
                this.f14134b.m9588a("carSerialNo", str2);
                if (this.f14134b.m9591a("heavydutySerialNo").equals(this.f14134b.m9591a("carAndHeavydutySerialNo"))) {
                    this.f14134b.m9588a("heavydutySerialNo", "");
                }
                if (!C2744aa.m5161c(str2, this.mContext)) {
                    this.f14134b.m9588a("carAndHeavydutySerialNo", "");
                } else {
                    this.f14134b.m9588a("carAndHeavydutySerialNo", str2);
                }
                this.f14134b.m9587a("need_refresh", true);
            }
        } else if (C2744aa.m5177a(str2, this.mContext)) {
            if (!str2.equals(this.f14129N)) {
                this.f14129N = str2;
                this.f14134b.m9588a("heavydutySerialNo", str2);
                if (this.f14134b.m9591a("carSerialNo").equals(this.f14134b.m9591a("carAndHeavydutySerialNo"))) {
                    this.f14134b.m9588a("carSerialNo", "");
                }
                this.f14134b.m9588a("carAndHeavydutySerialNo", "");
                this.f14134b.m9587a("need_refresh", true);
            }
        } else if (C2744aa.m5161c(str2, this.mContext) && !str2.equals(this.f14131P)) {
            this.f14131P = str2;
            this.f14134b.m9588a("carAndHeavydutySerialNo", str2);
            this.f14134b.m9588a("carSerialNo", str2);
            this.f14134b.m9588a("heavydutySerialNo", str2);
            this.f14134b.m9587a("need_refresh", true);
        }
        this.f14128M = this.f14134b.m9591a("carSerialNo");
        this.f14129N = this.f14134b.m9591a("heavydutySerialNo");
        this.f14131P = this.f14134b.m9591a("carAndHeavydutySerialNo");
        if (C2744aa.m5161c(str2, this.mContext)) {
            str = this.f14131P;
        } else if (!TextUtils.isEmpty(this.f14128M)) {
            str = this.f14128M;
        } else {
            str = this.f14129N;
        }
        C1856n.m8130a("yhx", "currentSerialNo=".concat(String.valueOf(str)));
        this.f14134b.m9588a("serialNo", str);
        if (this.f14134b.m9583b("need_refresh", false)) {
            CarIconManager.m7471a(this.mContext).m7474a();
        }
        List<SerialNumber> loadAll = this.f14141i.loadAll();
        for (SerialNumber serialNumber : loadAll) {
            if (serialNumber.f15834d.equals(str)) {
                serialNumber.f15833c = Boolean.TRUE;
            } else {
                serialNumber.f15833c = Boolean.FALSE;
            }
        }
        this.f14141i.updateInTx(loadAll);
        if (this.f14134b.m9583b("need_refresh", false)) {
            m6188a(str2);
        }
        DealDiagMessageHandler.m8673a().f9427c = null;
        this.f14155w.notifyDataSetChanged();
        this.f14157y.notifyDataSetChanged();
        this.f14156x.notifyDataSetChanged();
        this.f14158z.notifyDataSetChanged();
        this.f14116A.notifyDataSetChanged();
        this.f14117B.notifyDataSetChanged();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int id = adapterView.getId();
        switch (id) {
            case R.id.lv_local_car_and_heavy_serial_number /* 2131297440 */:
                String str = this.f14137e;
                if (str != null && str.equals("1")) {
                    this.f14126K = this.f14125J.get(i).f15834d;
                    new LogoutDialog(this.mContext).m4609a(getActivity(), getActivity().getString(R.string.logout), getActivity().getString(R.string.mine_change_serialno_tips));
                    return;
                }
                m6187a(this.f14125J, i);
                return;
            case R.id.lv_local_heavy_serial_number /* 2131297441 */:
                String str2 = this.f14137e;
                if (str2 != null && str2.equals("1")) {
                    this.f14126K = this.f14123H.get(i).f15834d;
                    new LogoutDialog(this.mContext).m4609a(getActivity(), getActivity().getString(R.string.logout), getActivity().getString(R.string.mine_change_serialno_tips));
                    return;
                }
                m6187a(this.f14123H, i);
                return;
            case R.id.lv_local_serial_number /* 2131297442 */:
                String str3 = this.f14137e;
                if (str3 != null && str3.equals("1")) {
                    this.f14126K = this.f14121F.get(i).f15834d;
                    new LogoutDialog(this.mContext).m4609a(getActivity(), getActivity().getString(R.string.logout), getActivity().getString(R.string.mine_change_serialno_tips));
                    return;
                }
                m6187a(this.f14121F, i);
                return;
            default:
                switch (id) {
                    case R.id.lv_user_car_and_heavy_serial_number /* 2131297451 */:
                        m6187a(this.f14124I, i);
                        return;
                    case R.id.lv_user_heavy_serial_number /* 2131297452 */:
                        m6187a(this.f14122G, i);
                        return;
                    case R.id.lv_user_serial_number /* 2131297453 */:
                        m6187a(this.f14120E, i);
                        return;
                    default:
                        return;
                }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 2203) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f14138f.f15834d);
            return this.f14142j.m5359a((List<String>) arrayList);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        if (i == 2203 && isVisible() && this.mContext != null && obj != null) {
            ProductsRegDateResponse productsRegDateResponse = (ProductsRegDateResponse) obj;
            if (!isSuccess(productsRegDateResponse.getCode()) || productsRegDateResponse.getProductsRegDateDTOs().size() <= 0) {
                return;
            }
            DeviceUtils.m8149a();
            DeviceUtils.m8141c(this.f14138f.f15834d, productsRegDateResponse.getProductsRegDateDTOs().get(0).getRegDate());
            DeviceUtils.m8149a();
            this.f14136d.m4672a(this.f14135c, DeviceUtils.m8148a(this.f14138f.f15834d));
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
    }

    @Override // android.app.Fragment
    public void onResume() {
        NLog.m9456a(f14115a, "onResume enter.");
        super.onResume();
        this.f14143k.requestFocus();
        this.f14145m.requestFocus();
        this.f14146n.requestFocus();
        this.f14144l.requestFocus();
        this.f14147o.requestFocus();
        this.f14148p.requestFocus();
        this.f14143k.setAdapter((ListAdapter) this.f14155w);
        this.f14145m.setAdapter((ListAdapter) this.f14157y);
        this.f14146n.setAdapter((ListAdapter) this.f14158z);
        this.f14144l.setAdapter((ListAdapter) this.f14156x);
        this.f14147o.setAdapter((ListAdapter) this.f14116A);
        this.f14148p.setAdapter((ListAdapter) this.f14117B);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mContext.unregisterReceiver(this.f14133R);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ConnectorInfoPopupWindow connectorInfoPopupWindow = this.f14136d;
        if (connectorInfoPopupWindow == null || !connectorInfoPopupWindow.f16269d.isShowing()) {
            return;
        }
        this.f14136d.f16269d.dismiss();
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        ConnectorInfoPopupWindow connectorInfoPopupWindow = this.f14136d;
        if (connectorInfoPopupWindow == null || !connectorInfoPopupWindow.f16269d.isShowing()) {
            return;
        }
        this.f14136d.f16269d.dismiss();
    }

    /* renamed from: d */
    private void m6180d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("logout");
        intentFilter.addAction("login_change_serialno");
        getActivity().registerReceiver(this.f14133R, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6188a(String str) {
        boolean z = false;
        if (C2744aa.m5166c()) {
            ProductInformation productInformation = new ProductInformation(this.mContext, str);
            RegisterAndLoadInfomation registerAndLoadInfomation = new RegisterAndLoadInfomation(this.mContext, str);
            if (!registerAndLoadInfomation.f15706c && registerAndLoadInfomation.f15704a.isEmpty()) {
                z = productInformation.f15697b;
            }
            PreferencesManager.m9595a(this.mContext).m9587a("isFirstRun", z);
            if (z) {
                Intent intent = new Intent(this.mContext, HomeStartActivity.class);
                intent.setFlags(67108864);
                startActivity(intent);
                return;
            }
            return;
        }
        PreferencesManager.m9595a(this.mContext).m9587a("isFirstRun", false);
    }
}
