package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.CarIconAdapterForClear;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.CarVersion;
import com.cnlaunch.x431pro.utils.p283db.SerialNumber;
import com.cnlaunch.x431pro.utils.p283db.SerialNumberDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OneKeyClearFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.z */
/* loaded from: classes.dex */
public class View$OnClickListenerC2594z extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: d */
    private String f14930d;

    /* renamed from: e */
    private String f14931e;

    /* renamed from: f */
    private GridView f14932f;

    /* renamed from: g */
    private IconButton f14933g;

    /* renamed from: h */
    private TextView f14934h;

    /* renamed from: i */
    private TextView f14935i;

    /* renamed from: j */
    private CarIconAdapterForClear f14936j;

    /* renamed from: k */
    private List<CarIcon> f14937k;

    /* renamed from: m */
    private List<SerialNumber> f14939m;

    /* renamed from: o */
    private PreferencesManager f14941o;

    /* renamed from: p */
    private SerialNumberDao f14942p;

    /* renamed from: q */
    private PathUtils f14943q;

    /* renamed from: r */
    private CarIconUtils f14944r;

    /* renamed from: a */
    private final int f14927a = 10010;

    /* renamed from: b */
    private final int f14928b = 10011;

    /* renamed from: c */
    private final int f14929c = 10012;

    /* renamed from: l */
    private List<Boolean> f14938l = new ArrayList();

    /* renamed from: n */
    private List<String> f14940n = new ArrayList();

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f14940n.clear();
        this.f14940n.add("1");
        this.f14940n.add("2");
        this.f14940n.add("3");
        this.f14940n.add("4");
        this.f14940n.add(DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_SUBMODEL);
        this.f14931e = PreferencesManager.m9595a(this.mContext).m9584b(C1947h.f10556h, "2");
        this.f14930d = m5835a();
        setTitle(R.string.setting_onekey_clear_txt);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
        this.f14933g = (IconButton) getActivity().findViewById(R.id.radio_clear);
        this.f14933g.setOnClickListener(this);
        this.f14932f = (GridView) getActivity().findViewById(R.id.clear_gridview);
        this.f14934h = (TextView) getActivity().findViewById(R.id.tv_clear_serialNo);
        this.f14934h.setText(this.f14930d);
        this.f14935i = (TextView) getActivity().findViewById(R.id.tv_select_lastest_number);
        this.f14935i.setOnClickListener(this);
        this.f14935i.setText(this.f14931e);
        if (this.f14936j == null) {
            this.f14936j = new CarIconAdapterForClear(this.mContext, this);
        }
        this.f14932f.setAdapter((ListAdapter) this.f14936j);
        this.f14932f.setOnItemClickListener(this);
        if (this.f14942p == null) {
            this.f14942p = DBManager.m5036a(this.mContext).f15794a.f15798a;
        }
        if (this.f14941o == null) {
            this.f14941o = PreferencesManager.m9595a(this.mContext);
        }
        List<SerialNumber> loadAll = this.f14942p.loadAll();
        List<SerialNumber> list = this.f14939m;
        if (list == null) {
            this.f14939m = new ArrayList();
        } else {
            list.clear();
        }
        for (SerialNumber serialNumber : loadAll) {
            if (C2744aa.m5168b(serialNumber.f15834d, this.mContext) || C2744aa.m5177a(serialNumber.f15834d, this.mContext) || C2744aa.m5161c(serialNumber.f15834d, this.mContext)) {
                this.f14939m.add(serialNumber);
            }
        }
        if (this.f14939m.size() > 1) {
            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.down_red_arrow);
            drawable.setBounds(0, 0, 19, 11);
            this.f14934h.setCompoundDrawables(null, null, drawable, null);
            this.f14934h.setOnClickListener(this);
            return;
        }
        this.f14934h.setCompoundDrawables(null, null, null, null);
        this.f14934h.setOnClickListener(null);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.oneclear_fragment, viewGroup, false);
    }

    /* renamed from: a */
    private String m5835a() {
        String m9591a = PreferencesManager.m9595a((Context) getActivity()).m9591a("serialNo");
        if (TextUtils.isEmpty(m9591a)) {
            m9591a = PreferencesManager.m9595a((Context) getActivity()).m9591a("carSerialNo");
            String m9591a2 = PreferencesManager.m9595a((Context) getActivity()).m9591a("heavydutySerialNo");
            if (TextUtils.isEmpty(m9591a)) {
                m9591a = m9591a2;
            }
            PreferencesManager.m9595a((Context) getActivity()).m9588a("serialNo", m9591a);
        }
        return m9591a;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14943q = new PathUtils(this.mContext);
        this.f14944r = new CarIconUtils(this.mContext);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (C2744aa.m5176a(this.f14937k.get(i).f15778b, this.f14937k.get(i).f15789m)) {
            this.f14937k.get(i);
            CarIcon m4951e = new CarIconUtils(this.mContext).m4951e(this.f14937k.get(i).f15790n, C2744aa.m5152e(this.f14937k.get(i).f15789m));
            String m5038a = LangManager.m9469a().equalsIgnoreCase("zh") ? m4951e.m5038a(this.mContext) : m4951e.f15779c;
            NToast.m9449a(this.mContext, String.format(getString(R.string.onekey_clear_child_tip), m5038a, m5038a));
            return;
        }
        List<Boolean> list = this.f14938l;
        list.set(i, Boolean.valueOf(true ^ list.get(i).booleanValue()));
        CarIconAdapterForClear carIconAdapterForClear = this.f14936j;
        carIconAdapterForClear.f11276b = this.f14938l;
        carIconAdapterForClear.notifyDataSetChanged();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        boolean z;
        switch (i) {
            case 10010:
                try {
                    CarIconUtils carIconUtils = new CarIconUtils(this.mContext);
                    this.f14937k = carIconUtils.m4965b(this.f14930d);
                    this.f14937k.addAll(carIconUtils.m4957c(CarIconUtils.f15866f, this.f14930d));
                    return Boolean.TRUE;
                } catch (Exception e) {
                    e.printStackTrace();
                    return Boolean.FALSE;
                }
            case 10011:
                try {
                    CarIconUtils carIconUtils2 = new CarIconUtils(this.mContext);
                    if (carIconUtils2.m4978a()) {
                        carIconUtils2.m4967b();
                    }
                    carIconUtils2.m4973a(this.f14930d);
                    this.f14937k = carIconUtils2.m4965b(this.f14930d);
                    this.f14937k.addAll(carIconUtils2.m4957c(CarIconUtils.f15866f, this.f14930d));
                    return Boolean.TRUE;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return Boolean.FALSE;
                }
            case 10012:
                try {
                    FileUtils.m4995g(PathUtils.m4852e());
                    if (this.f14937k != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= this.f14938l.size()) {
                                z = false;
                            } else if (this.f14938l.get(i2).booleanValue()) {
                                z = true;
                            } else {
                                i2++;
                            }
                        }
                        if (z) {
                            int i3 = 0;
                            boolean z2 = false;
                            while (true) {
                                if (i3 < this.f14938l.size()) {
                                    if (this.f14938l.get(i3).booleanValue()) {
                                        String str = this.f14937k.get(i3).f15778b;
                                        List<CarVersion> m4954d = this.f14944r.m4954d(this.f14930d, str);
                                        if (m4954d != null) {
                                            boolean z3 = z2;
                                            int i4 = 0;
                                            while (i4 < m4954d.size()) {
                                                FileUtils.m4995g(this.f14943q.m4859b(this.f14930d, str, m4954d.get(i4).f15828d));
                                                this.f14944r.m4956c(this.f14930d, str, m4954d.get(i4).f15828d);
                                                i4++;
                                                z3 = true;
                                            }
                                            z2 = z3;
                                        }
                                    }
                                    i3++;
                                } else {
                                    if (z2) {
                                        PreferencesManager.m9595a(this.mContext).m9587a("need_refresh", true);
                                    }
                                    NToast.m9450a(this.mContext, (int) R.string.check_server_finish_txt);
                                }
                            }
                        } else {
                            NToast.m9450a(this.mContext, (int) R.string.common_unselect_any);
                        }
                    }
                    return Boolean.TRUE;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return Boolean.FALSE;
                }
            default:
                return super.doInBackground(i);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case 10010:
                break;
            case 10011:
                LoadDialog.m4681b(getActivity());
                break;
            case 10012:
                LoadDialog.m4681b(getActivity());
                LoadDialog.m4684a(getActivity(), getString(R.string.caricon_loading));
                request(10011, false);
                return;
            default:
                return;
        }
        this.f14936j.f11275a = this.f14937k;
        this.f14938l = new ArrayList();
        for (int i2 = 0; i2 < this.f14937k.size(); i2++) {
            this.f14938l.add(Boolean.FALSE);
        }
        CarIconAdapterForClear carIconAdapterForClear = this.f14936j;
        carIconAdapterForClear.f11276b = this.f14938l;
        carIconAdapterForClear.notifyDataSetChanged();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = !this.f14930d.equalsIgnoreCase(m5835a());
        boolean m9583b = PreferencesManager.m9595a(this.mContext).m9583b("need_refresh", true);
        if (z || m9583b) {
            this.f14934h.setText(this.f14930d);
            request(10011, false);
            if (z) {
                PreferencesManager.m9595a(this.mContext).m9587a("need_refresh", true);
            } else {
                PreferencesManager.m9595a(this.mContext).m9587a("need_refresh", false);
            }
            LoadDialog.m4684a(getActivity(), getString(R.string.caricon_loading));
            return;
        }
        request(10010, false);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14932f.setNumColumns(getResources().getInteger(R.integer.carlogoItemColumnNum));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int id = view.getId();
        if (id == R.id.radio_clear) {
            if (this.f14937k == null) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= this.f14938l.size()) {
                    z = false;
                    break;
                } else if (this.f14938l.get(i).booleanValue()) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                NToast.m9450a(this.mContext, (int) R.string.common_unselect_any);
                return;
            }
            request(10012, false);
            LoadDialog.m4684a(getActivity(), getString(R.string.custom_diaglog_message));
        } else if (id != R.id.tv_clear_serialNo) {
            if (id != R.id.tv_select_lastest_number) {
                return;
            }
            SpinnerPopupWindow spinnerPopupWindow = new SpinnerPopupWindow(this.mContext);
            spinnerPopupWindow.f16383b = new OneKeyClearFragment(this);
            spinnerPopupWindow.m4582a(this.f14935i, this.f14940n);
        } else if (this.f14939m.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (SerialNumber serialNumber : this.f14939m) {
                arrayList.add(serialNumber.f15834d);
            }
            SpinnerPopupWindow spinnerPopupWindow2 = new SpinnerPopupWindow(this.mContext);
            spinnerPopupWindow2.f16383b = new C2519ab(this, arrayList);
            spinnerPopupWindow2.m4582a(this.f14934h, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m5831b(View$OnClickListenerC2594z view$OnClickListenerC2594z, String str) {
        view$OnClickListenerC2594z.f14930d = str;
        view$OnClickListenerC2594z.f14934h.setText(view$OnClickListenerC2594z.f14930d);
    }
}
