package com.cnlaunch.x431pro.activity.p211a;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.CarIconFragmentForAll;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment;
import com.cnlaunch.x431pro.activity.p211a.p212a.HistoryDiagDesItemAdapter;
import com.cnlaunch.x431pro.activity.p211a.p212a.HistoryListViewAdapter;
import com.cnlaunch.x431pro.module.history.model.VehicleInfo;
import com.cnlaunch.x431pro.module.history.p266a.HistoryDao;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* renamed from: com.cnlaunch.x431pro.activity.a.d */
/* loaded from: classes.dex */
public class HistoryFragment extends BaseDiagnoseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: A */
    private IconButton f10840A;

    /* renamed from: B */
    private IconButton f10841B;

    /* renamed from: E */
    private HistoryDao f10844E;

    /* renamed from: F */
    private String f10845F;

    /* renamed from: H */
    private PreferencesManager f10847H;

    /* renamed from: I */
    private SerialNumberDao f10848I;

    /* renamed from: J */
    private List<SerialNumber> f10849J;

    /* renamed from: l */
    private TextView f10857l;

    /* renamed from: m */
    private TextView f10858m;

    /* renamed from: n */
    private ListView f10859n;

    /* renamed from: o */
    private GridView f10860o;

    /* renamed from: p */
    private HistoryListViewAdapter f10861p;

    /* renamed from: q */
    private HistoryDiagDesItemAdapter f10862q;

    /* renamed from: x */
    private IconButton f10869x;

    /* renamed from: y */
    private IconButton f10870y;

    /* renamed from: z */
    private IconButton f10871z;

    /* renamed from: a */
    private final int f10853a = 10010;

    /* renamed from: b */
    private final int f10854b = 10011;

    /* renamed from: j */
    private final int f10855j = 10012;

    /* renamed from: k */
    private final int f10856k = 10013;

    /* renamed from: r */
    private List<String> f10863r = new ArrayList();

    /* renamed from: s */
    private List<VehicleInfo> f10864s = new ArrayList();

    /* renamed from: t */
    private View f10865t = null;

    /* renamed from: u */
    private int f10866u = 0;

    /* renamed from: v */
    private int f10867v = -1;

    /* renamed from: w */
    private boolean f10868w = false;

    /* renamed from: C */
    private boolean f10842C = false;

    /* renamed from: D */
    private HashMap<String, Integer> f10843D = new HashMap<>();

    /* renamed from: G */
    private DialogInterface$OnCancelListenerC1978a f10846G = new DialogInterface$OnCancelListenerC1978a();

    /* renamed from: K */
    private boolean f10850K = false;

    /* renamed from: L */
    private int f10851L = 3;

    /* renamed from: M */
    private final BroadcastReceiver f10852M = new C1984j(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static /* synthetic */ int m7815o(HistoryFragment historyFragment) {
        historyFragment.f10867v = -1;
        return -1;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f10844E = HistoryDao.m5300a(this.mContext);
        setTitle(R.string.History_title_txt);
        this.f10857l = (TextView) this.mContentView.findViewById(R.id.tv_device_num);
        this.f10857l.setText(m7834b("0"));
        this.f10858m = (TextView) this.mContentView.findViewById(R.id.tv_spinner_serialNo);
        m7826h();
        this.textVinScan.setVisibility(8);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu));
        this.f10869x = (IconButton) getActivity().findViewById(R.id.btn_history_del);
        this.f10869x.setOnClickListener(this);
        this.f10870y = (IconButton) getActivity().findViewById(R.id.btn_history_del_mode);
        this.f10870y.setOnClickListener(this);
        this.f10871z = (IconButton) getActivity().findViewById(R.id.btn_history_cancledelMode);
        this.f10871z.setOnClickListener(this);
        this.f10841B = (IconButton) getActivity().findViewById(R.id.btn_history_pageunselectall);
        this.f10841B.setOnClickListener(this);
        this.f10840A = (IconButton) getActivity().findViewById(R.id.btn_history_selectall);
        this.f10840A.setOnClickListener(this);
        this.f10859n = (ListView) getActivity().findViewById(R.id.history_date_list);
        this.f10859n.setOnItemClickListener(new C1982h(this));
        this.f10861p = new HistoryListViewAdapter(this.mContext);
        this.f10859n.setAdapter((ListAdapter) this.f10861p);
        this.f10860o = (GridView) getActivity().findViewById(R.id.history_gridview);
        this.f10860o.setOnItemClickListener(this);
        this.f10862q = new HistoryDiagDesItemAdapter(this.mContext);
        this.f10862q.f10808c = this;
        m7820k();
        this.f10860o.setAdapter((ListAdapter) this.f10862q);
        HistoryListViewAdapter historyListViewAdapter = this.f10861p;
        historyListViewAdapter.f10828a = this.f10863r;
        historyListViewAdapter.f10831d = this.f10843D;
        historyListViewAdapter.notifyDataSetChanged();
        int i = this.f10866u;
        if (i != -1) {
            this.f10861p.f10830c = i;
        }
        HistoryDiagDesItemAdapter historyDiagDesItemAdapter = this.f10862q;
        historyDiagDesItemAdapter.f10806a = this.f10864s;
        historyDiagDesItemAdapter.notifyDataSetChanged();
        m7824i();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("softs_updated");
        intentFilter.addAction("login_change_serialno");
        this.mContext.registerReceiver(this.f10852M, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HistoryFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.a.d$a */
    /* loaded from: classes.dex */
    public class DialogInterface$OnCancelListenerC1978a implements DialogInterface.OnCancelListener {
        DialogInterface$OnCancelListenerC1978a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            HistoryFragment.this.f10842C = true;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        boolean z = true;
        if (id == R.id.btn_history_del_mode) {
            this.f10868w = true;
            this.f10862q.m7844a(this.f10868w);
            this.f10870y.setVisibility(8);
            this.f10869x.setVisibility(0);
            this.f10871z.setVisibility(0);
            this.f10841B.setVisibility(0);
            this.f10840A.setVisibility(0);
        } else if (id == R.id.btn_history_cancledelMode) {
            this.f10868w = false;
            this.f10862q.m7844a(this.f10868w);
            this.f10869x.setVisibility(8);
            this.f10870y.setVisibility(0);
            this.f10871z.setVisibility(8);
            this.f10841B.setVisibility(8);
            this.f10840A.setVisibility(8);
        } else if (id == R.id.btn_history_del) {
            if (this.f10868w) {
                int i = 0;
                while (true) {
                    if (i >= this.f10864s.size()) {
                        z = false;
                        break;
                    } else if (this.f10864s.get(i).getSelectState() == 1) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (!z) {
                    NToast.m9447b(getActivity(), (int) R.string.common_unselect_any);
                    return;
                }
                new C1979e(this).m4609a(getActivity(), getString(R.string.dialog_title_default), String.format(getString(R.string.history_clear_history_record), new Object[0]));
            }
        } else if (id == R.id.btn_history_selectall) {
            HistoryDiagDesItemAdapter historyDiagDesItemAdapter = this.f10862q;
            if (historyDiagDesItemAdapter.f10806a == null || historyDiagDesItemAdapter.f10806a.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < historyDiagDesItemAdapter.f10806a.size(); i2++) {
                historyDiagDesItemAdapter.f10806a.get(i2).setSelectState(1);
            }
            historyDiagDesItemAdapter.notifyDataSetChanged();
        } else if (id == R.id.btn_history_pageunselectall) {
            this.f10862q.m7847a();
        } else if (id == R.id.tv_spinner_serialNo) {
            m7826h();
            if (this.f10849J.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (SerialNumber serialNumber : this.f10849J) {
                arrayList.add(serialNumber.f15834d);
            }
            SpinnerPopupWindow spinnerPopupWindow = new SpinnerPopupWindow(this.mContext);
            spinnerPopupWindow.f16384c = this.f10858m.getWidth();
            spinnerPopupWindow.f16383b = new C1980f(this, arrayList);
            spinnerPopupWindow.m4581b(this.f10858m, arrayList);
        }
    }

    /* renamed from: d */
    private void m7831d() {
        getActivity().runOnUiThread(new RunnableC1981g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7826h() {
        if (this.f10848I == null) {
            this.f10848I = DBManager.m5036a(this.mContext).f15794a.f15798a;
        }
        if (this.f10847H == null) {
            this.f10847H = PreferencesManager.m9595a(this.mContext);
        }
        String m9591a = this.f10847H.m9591a("serialNo");
        String m9591a2 = this.f10847H.m9591a("carSerialNo");
        String m9591a3 = this.f10847H.m9591a("heavydutySerialNo");
        String m9591a4 = this.f10847H.m9591a("carAndHeavydutySerialNo");
        if (TextUtils.isEmpty(m9591a)) {
            if (!TextUtils.isEmpty(m9591a2)) {
                m9591a = m9591a2;
            } else if (!TextUtils.isEmpty(m9591a3)) {
                m9591a = m9591a3;
            } else if (!TextUtils.isEmpty(m9591a4)) {
                m9591a = m9591a4;
            }
            this.f10847H.m9588a("serialNo", m9591a);
        }
        if (TextUtils.isEmpty(m9591a) || !m9591a.equalsIgnoreCase(this.f10845F)) {
            this.f10850K = true;
        }
        this.f10845F = m9591a;
        List<SerialNumber> loadAll = this.f10848I.loadAll();
        this.f10849J = new ArrayList();
        for (SerialNumber serialNumber : loadAll) {
            if (C2744aa.m5168b(serialNumber.f15834d, this.mContext) || C2744aa.m5177a(serialNumber.f15834d, this.mContext) || C2744aa.m5161c(serialNumber.f15834d, this.mContext)) {
                if (serialNumber.f15834d.equals(m9591a2) || serialNumber.f15834d.equals(m9591a3) || serialNumber.f15834d.equals(m9591a4)) {
                    this.f10849J.add(serialNumber);
                }
            }
        }
        if (this.f10849J.size() == 0) {
            this.f10845F = "";
        }
        m7831d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public SpannableStringBuilder m7834b(String str) {
        return new SpannableStringBuilder(getString(R.string.Historical_device_num_txt, new Object[]{str}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m7824i() {
        if (C2778n.m4905b()) {
            return;
        }
        this.f10850K = false;
        new C1983i(this).start();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_history_main, viewGroup, false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m7837b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7822j() {
        request(10011, false);
    }

    /* renamed from: b */
    public final void m7837b(int i) {
        if (i >= this.f10864s.size()) {
            return;
        }
        this.f10867v = i;
        VehicleInfo vehicleInfo = this.f10864s.get(i);
        if (vehicleInfo == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("VehicleInfo", vehicleInfo);
        replaceFragment(HistoricalRecordsFragment.class.getName(), bundle, 0, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m7826h();
        if (this.f10850K) {
            this.f10858m.setText(this.f10845F);
            m7824i();
        }
        if (this.f10859n.hasFocus()) {
            return;
        }
        this.f10859n.requestFocus();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 10010:
                try {
                    this.f10863r.clear();
                    this.f10843D.clear();
                    this.f10843D = this.f10844E.m5295a(this.f10845F);
                    Set<String> keySet = this.f10843D.keySet();
                    if (keySet != null) {
                        for (String str : keySet) {
                            this.f10863r.add(str);
                        }
                    }
                    return Boolean.TRUE;
                } catch (Exception e) {
                    e.printStackTrace();
                    return Boolean.FALSE;
                }
            case 10011:
                try {
                    this.f10864s.clear();
                    if (this.f10863r.size() <= this.f10866u) {
                        this.f10866u = this.f10863r.size() - 1;
                        if (-1 != this.f10866u) {
                            this.f10861p.f10830c = this.f10866u;
                        }
                    }
                    if (this.f10844E != null && this.f10866u != -1) {
                        this.f10864s = this.f10844E.m5294a(this.f10863r.get(this.f10866u), this.f10845F);
                    }
                    return Boolean.TRUE;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return Boolean.FALSE;
                }
            case 10012:
                for (int i2 = 0; i2 < this.f10864s.size() && !this.f10842C; i2++) {
                    try {
                        if (this.f10864s.get(i2).getSelectState() == 1) {
                            if (this.f10844E.m5301a(this.f10864s.get(i2).getVehicleId(), true)) {
                                int intValue = this.f10843D.get(this.f10863r.get(this.f10866u)).intValue() - 1;
                                if (intValue == 0) {
                                    this.f10843D.remove(this.f10863r.get(this.f10866u));
                                    this.f10863r.remove(this.f10866u);
                                } else {
                                    this.f10843D.put(this.f10863r.get(this.f10866u), Integer.valueOf(intValue));
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            case 10013:
                try {
                    new CarIconUtils(this.mContext).m4972a(PreferencesManager.m9595a(this.mContext).m9591a("carSerialNo"), PreferencesManager.m9595a(this.mContext).m9591a("heavydutySerialNo"));
                    return Boolean.TRUE;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return Boolean.FALSE;
                }
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case 10010:
                HistoryListViewAdapter historyListViewAdapter = this.f10861p;
                historyListViewAdapter.f10828a = this.f10863r;
                historyListViewAdapter.f10831d = this.f10843D;
                historyListViewAdapter.notifyDataSetChanged();
                if (this.f10863r.size() == 0) {
                    this.f10870y.setEnabled(false);
                    if (this.f10864s.size() != 0) {
                        this.f10864s.clear();
                        HistoryDiagDesItemAdapter historyDiagDesItemAdapter = this.f10862q;
                        historyDiagDesItemAdapter.f10806a = this.f10864s;
                        historyDiagDesItemAdapter.notifyDataSetChanged();
                    }
                    LoadDialog.m4681b(this.mContext);
                    return;
                }
                this.f10870y.setEnabled(true);
                int i2 = this.f10866u;
                if (i2 != -1) {
                    this.f10861p.f10830c = i2;
                    m7822j();
                    return;
                }
                return;
            case 10011:
                LoadDialog.m4681b(this.mContext);
                HistoryDiagDesItemAdapter historyDiagDesItemAdapter2 = this.f10862q;
                historyDiagDesItemAdapter2.f10806a = this.f10864s;
                historyDiagDesItemAdapter2.notifyDataSetChanged();
                return;
            case 10012:
                HistoryListViewAdapter historyListViewAdapter2 = this.f10861p;
                historyListViewAdapter2.f10828a = this.f10863r;
                historyListViewAdapter2.f10831d = this.f10843D;
                historyListViewAdapter2.notifyDataSetChanged();
                request(10011, false);
                if (this.f10863r.size() == 0) {
                    this.f10870y.setEnabled(false);
                    this.f10868w = false;
                    this.f10869x.setVisibility(8);
                    this.f10870y.setVisibility(0);
                    this.f10871z.setVisibility(8);
                    this.f10841B.setVisibility(8);
                    this.f10840A.setVisibility(8);
                    return;
                }
                return;
            case 10013:
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mContext.unregisterReceiver(this.f10852M);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NLog.m9456a("yhx", "History onKeyDown enter.");
        if (i == 4 && keyEvent.getAction() == 0) {
            replaceFragment(CarIconFragmentForAll.class.getName(), new Bundle(), 1, false);
            return true;
        }
        return false;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m7820k();
    }

    /* renamed from: k */
    private void m7820k() {
        int i = getResources().getConfiguration().orientation;
        if (i == 1) {
            this.f10860o.setNumColumns(2);
        } else if (i == 2) {
            this.f10860o.setNumColumns(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7839a(HistoryFragment historyFragment, String str) {
        historyFragment.f10845F = str;
        historyFragment.f10847H.m9588a("serialNo", historyFragment.f10845F);
        if (C2744aa.m5168b(str, historyFragment.mContext)) {
            String m9591a = historyFragment.f10847H.m9591a("carSerialNo");
            if (!str.equals(m9591a)) {
                historyFragment.f10847H.m9588a("carSerialNo", str);
                if (C2744aa.m5161c(m9591a, historyFragment.mContext)) {
                    historyFragment.f10847H.m9588a("heavydutySerialNo", "");
                }
                historyFragment.f10847H.m9588a("carAndHeavydutySerialNo", "");
                historyFragment.f10847H.m9587a("need_refresh", true);
            }
        } else if (C2744aa.m5177a(str, historyFragment.mContext)) {
            String m9591a2 = historyFragment.f10847H.m9591a("heavydutySerialNo");
            if (!str.equals(m9591a2)) {
                historyFragment.f10847H.m9588a("heavydutySerialNo", str);
                if (C2744aa.m5161c(m9591a2, historyFragment.mContext)) {
                    historyFragment.f10847H.m9588a("carSerialNo", "");
                }
                historyFragment.f10847H.m9588a("carAndHeavydutySerialNo", "");
                historyFragment.f10847H.m9587a("need_refresh", true);
            }
        } else if (C2744aa.m5161c(str, historyFragment.mContext) && !str.equals(historyFragment.f10847H.m9591a("carAndHeavydutySerialNo"))) {
            historyFragment.f10847H.m9588a("carAndHeavydutySerialNo", str);
            historyFragment.f10847H.m9588a("carSerialNo", str);
            historyFragment.f10847H.m9588a("heavydutySerialNo", str);
            historyFragment.f10847H.m9587a("need_refresh", true);
        }
        historyFragment.m7831d();
    }
}
