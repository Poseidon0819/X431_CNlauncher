package com.cnlaunch.x431pro.activity.golo.function;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p012v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p181j.DealDiagMessageHandler;
import com.cnlaunch.p181j.ExplainResult;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.CarIconAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ViewPagerAdapter;
import com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.cnlaunch.x431pro.p210a.ApplicationTheme;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.CarVersion;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.PagerSlidingTabStrip;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;
import message.model.ChatRoom;

/* renamed from: com.cnlaunch.x431pro.activity.golo.function.f */
/* loaded from: classes.dex */
public final class SelectRemoteDiagSoftFragmentHD extends BaseFragment implements AdapterView.OnItemClickListener, OnGoloKeyDownListener {

    /* renamed from: H */
    private static int f12624H;

    /* renamed from: A */
    private List<CarIcon> f12625A;

    /* renamed from: B */
    private List<CarIcon> f12626B;

    /* renamed from: C */
    private String f12627C;

    /* renamed from: D */
    private String f12628D;

    /* renamed from: E */
    private String f12629E;

    /* renamed from: F */
    private PagerSlidingTabStrip f12630F;

    /* renamed from: e */
    private ViewPager f12636e;

    /* renamed from: f */
    private ViewPagerAdapter f12637f;

    /* renamed from: g */
    private ArrayList<View> f12638g;

    /* renamed from: h */
    private CarIconAdapter f12639h;

    /* renamed from: i */
    private CarIconAdapter f12640i;

    /* renamed from: j */
    private CarIconAdapter f12641j;

    /* renamed from: k */
    private CarIconAdapter f12642k;

    /* renamed from: l */
    private CarIconAdapter f12643l;

    /* renamed from: m */
    private CarIconAdapter f12644m;

    /* renamed from: n */
    private CarIconAdapter f12645n;

    /* renamed from: o */
    private GridView f12646o;

    /* renamed from: p */
    private GridView f12647p;

    /* renamed from: q */
    private GridView f12648q;

    /* renamed from: r */
    private GridView f12649r;

    /* renamed from: s */
    private GridView f12650s;

    /* renamed from: t */
    private GridView f12651t;

    /* renamed from: u */
    private GridView f12652u;

    /* renamed from: v */
    private List<CarIcon> f12653v;

    /* renamed from: w */
    private List<CarIcon> f12654w;

    /* renamed from: x */
    private List<CarIcon> f12655x;

    /* renamed from: y */
    private List<CarIcon> f12656y;

    /* renamed from: z */
    private List<CarIcon> f12657z;

    /* renamed from: c */
    private final int f12634c = 10010;

    /* renamed from: d */
    private final int f12635d = 10011;

    /* renamed from: G */
    private boolean f12631G = true;

    /* renamed from: a */
    boolean f12632a = false;

    /* renamed from: b */
    ChatRoom f12633b = null;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12627C = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        this.f12629E = PreferencesManager.m9595a(this.mContext).m9591a("carSerialNo");
        this.f12628D = PreferencesManager.m9595a(this.mContext).m9591a("heavydutySerialNo");
        this.f12631G = PreferencesManager.m9595a(this.mContext.getApplicationContext()).m9583b("is_heavyduty", true);
        m6989a();
        new MessageDialog(this.mContext).m4670a(R.string.dialog_remotediag_handler_title, R.string.please_select_remotediag_soft);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.golo_fragment_caricon, viewGroup, false);
    }

    @Override // android.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    /* renamed from: a */
    private void m6989a() {
        setTitle(R.string.please_select_remotediag_soft);
        this.f12636e = (ViewPager) getActivity().findViewById(R.id.viewPager);
        this.f12638g = new ArrayList<>();
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        if (C2744aa.m5148g() || (C2744aa.m5166c() && !C2744aa.m5145h())) {
            this.f12638g.add(layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null));
        } else {
            this.f12638g.add(layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null));
            this.f12638g.add(layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null));
            this.f12638g.add(layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null));
            this.f12638g.add(layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null));
            this.f12638g.add(layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null));
            if (this.f12631G) {
                this.f12638g.add(layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null));
            }
        }
        if (C2744aa.m5148g() || (C2744aa.m5166c() && !C2744aa.m5145h())) {
            this.f12639h = new CarIconAdapter(this.mContext);
            this.f12646o = (GridView) this.f12638g.get(0);
            this.f12646o.setAdapter((ListAdapter) this.f12639h);
            this.f12646o.setOnItemClickListener(this);
            ArrayList<View> arrayList = this.f12638g;
            String[] strArr = new String[1];
            strArr[0] = getString(C2744aa.m5148g() ? R.string.app_name : R.string.diagnose_all_title);
            this.f12637f = new C2239a(arrayList, strArr);
        } else {
            this.f12641j = new CarIconAdapter(this.mContext);
            this.f12650s = (GridView) this.f12638g.get(3);
            this.f12650s.setAdapter((ListAdapter) this.f12641j);
            this.f12650s.setOnItemClickListener(this);
            this.f12640i = new CarIconAdapter(this.mContext);
            this.f12649r = (GridView) this.f12638g.get(2);
            this.f12649r.setAdapter((ListAdapter) this.f12640i);
            this.f12649r.setOnItemClickListener(this);
            this.f12642k = new CarIconAdapter(this.mContext);
            this.f12648q = (GridView) this.f12638g.get(1);
            this.f12648q.setAdapter((ListAdapter) this.f12642k);
            this.f12648q.setOnItemClickListener(this);
            this.f12643l = new CarIconAdapter(this.mContext);
            this.f12647p = (GridView) this.f12638g.get(0);
            this.f12647p.setAdapter((ListAdapter) this.f12643l);
            this.f12647p.setOnItemClickListener(this);
            if (this.f12631G) {
                this.f12644m = new CarIconAdapter(this.mContext);
                this.f12651t = (GridView) this.f12638g.get(4);
                this.f12651t.setAdapter((ListAdapter) this.f12644m);
                this.f12651t.setOnItemClickListener(this);
                this.f12645n = new CarIconAdapter(this.mContext);
                this.f12652u = (GridView) this.f12638g.get(5);
                this.f12652u.setAdapter((ListAdapter) this.f12645n);
                this.f12652u.setOnItemClickListener(this);
                this.f12637f = new C2239a(this.f12638g, getString(R.string.diagnose_america_title), getString(R.string.diagnose_europe_title), getString(R.string.diagnose_asia_title), getString(R.string.diagnose_china_title), getString(R.string.diagnose_heavyduty_title), getString(R.string.diagnose_reset_title));
            } else {
                this.f12645n = new CarIconAdapter(this.mContext);
                this.f12652u = (GridView) this.f12638g.get(4);
                this.f12652u.setAdapter((ListAdapter) this.f12645n);
                this.f12652u.setOnItemClickListener(this);
                this.f12637f = new C2239a(this.f12638g, getString(R.string.diagnose_america_title), getString(R.string.diagnose_europe_title), getString(R.string.diagnose_asia_title), getString(R.string.diagnose_china_title), getString(R.string.diagnose_reset_title));
            }
        }
        this.f12636e.setAdapter(this.f12637f);
        this.f12636e.setCurrentItem(f12624H);
        this.f12630F = (PagerSlidingTabStrip) getActivity().findViewById(R.id.tabs);
        this.f12630F.setShouldExpand(true);
        this.f12630F.setViewPager(this.f12636e);
        this.f12630F.setOnPageChangeListener(new C2240b());
        this.f12630F.setTextColorResource(ApplicationTheme.m7972d(getActivity()));
        this.f12630F.setIndicatorColorResource(ApplicationTheme.m7972d(getActivity()));
        this.f12630F.setTextSize(getResources().getInteger(R.integer.report_tip_title_textsize));
        request(10010, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        switch (i) {
            case 10010:
                try {
                    CarIconUtils carIconUtils = new CarIconUtils(this.mContext);
                    if (carIconUtils.m4978a()) {
                        carIconUtils.m4967b();
                    }
                    if (!C2744aa.m5148g() && (!C2744aa.m5166c() || C2744aa.m5145h())) {
                        this.f12657z = carIconUtils.m4957c(CarIconUtils.f15863c, this.f12629E);
                        this.f12656y = carIconUtils.m4957c(CarIconUtils.f15862b, this.f12629E);
                        this.f12655x = carIconUtils.m4957c(CarIconUtils.f15864d, this.f12629E);
                        this.f12654w = carIconUtils.m4957c(CarIconUtils.f15865e, this.f12629E);
                        this.f12625A = carIconUtils.m4957c(CarIconUtils.f15868h, this.f12628D);
                        this.f12626B = carIconUtils.m4957c(CarIconUtils.f15866f, this.f12629E);
                        return Boolean.TRUE;
                    }
                    this.f12653v = carIconUtils.m4965b(this.f12629E);
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
                    this.f12629E = PreferencesManager.m9595a(this.mContext).m9591a("carSerialNo");
                    this.f12628D = PreferencesManager.m9595a(this.mContext).m9591a("heavydutySerialNo");
                    this.f12632a = PreferencesManager.m9595a(this.mContext).m9583b("is_select_heavyduty_area", false);
                    if (this.f12632a) {
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f12628D);
                    }
                    carIconUtils2.m4972a(this.f12629E, this.f12628D);
                    if (!C2744aa.m5148g() && (!C2744aa.m5166c() || C2744aa.m5145h())) {
                        this.f12657z = carIconUtils2.m4957c(CarIconUtils.f15863c, this.f12629E);
                        this.f12656y = carIconUtils2.m4957c(CarIconUtils.f15862b, this.f12629E);
                        this.f12655x = carIconUtils2.m4957c(CarIconUtils.f15864d, this.f12629E);
                        this.f12654w = carIconUtils2.m4957c(CarIconUtils.f15865e, this.f12629E);
                        this.f12625A = carIconUtils2.m4957c(CarIconUtils.f15868h, this.f12628D);
                        this.f12626B = carIconUtils2.m4957c(CarIconUtils.f15866f, this.f12629E);
                        return Boolean.TRUE;
                    }
                    this.f12653v = carIconUtils2.m4965b(this.f12629E);
                    return Boolean.TRUE;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return Boolean.FALSE;
                }
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        switch (i) {
            case 10010:
            case 10011:
                LoadDialog.m4681b(getActivity());
                if (C2744aa.m5148g() || (C2744aa.m5166c() && !C2744aa.m5145h())) {
                    this.f12639h.m7522a(this.f12653v);
                    return;
                }
                this.f12640i.m7522a(this.f12656y);
                this.f12641j.m7522a(this.f12657z);
                this.f12642k.m7522a(this.f12655x);
                this.f12643l.m7522a(this.f12654w);
                if (this.f12631G) {
                    this.f12644m.m7522a(this.f12625A);
                }
                this.f12645n.m7522a(this.f12626B);
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayList arrayList;
        CarIcon carIcon = (CarIcon) adapterView.getItemAtPosition(i);
        if (!carIcon.f15787k.booleanValue()) {
            Activity activity = getActivity();
            NToast.m9449a(activity, carIcon.f15779c + this.mContext.getString(R.string.software_not_download));
            return;
        }
        List<CarVersion> m4954d = new CarIconUtils(this.mContext).m4954d(carIcon.f15790n, carIcon.f15778b);
        if (m4954d == null || m4954d.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (CarVersion carVersion : m4954d) {
                if (!C2787z.m4821a(carVersion.f15827c)) {
                    CarVersionInfo carVersionInfo = new CarVersionInfo();
                    carVersionInfo.setVersion(carVersion.f15828d);
                    carVersionInfo.setLanguage(carVersion.f15830f);
                    arrayList.add(carVersionInfo);
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("versionlist", carIcon.f15786j);
        bundle.putString("carname", carIcon.f15779c);
        bundle.putString("carname_zh", carIcon.m5038a(this.mContext));
        bundle.putString("softpackageid", carIcon.f15778b);
        bundle.putString("areaId", carIcon.f15782f);
        bundle.putString("serialNum", carIcon.f15790n);
        bundle.putSerializable("verList", arrayList);
        DealDiagMessageHandler.m8673a().f9427c = bundle;
        DealDiagMessageHandler.m8673a().m8661d();
        getActivity().finish();
    }

    /* compiled from: SelectRemoteDiagSoftFragmentHD.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.function.f$a */
    /* loaded from: classes.dex */
    public class C2239a extends ViewPagerAdapter {

        /* renamed from: c */
        private String[] f12659c;

        public C2239a(ArrayList<View> arrayList, String... strArr) {
            super(arrayList);
            this.f12659c = new String[0];
            this.f12659c = strArr;
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final CharSequence mo5638a(int i) {
            String[] strArr = this.f12659c;
            return i >= strArr.length ? "NULL TITLE" : strArr[i];
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        DealDiagMessageHandler m8673a = DealDiagMessageHandler.m8673a();
        if (!m8673a.f9430f.m8683b()) {
            ExplainResult explainResult = new ExplainResult(m8673a.f9430f.m8685a(), 0);
            explainResult.f9478id = m8673a.f9430f.f9419c;
            m8673a.m8669a(explainResult.f9478id, R.string.tip_other_deny_your_request, explainResult.toJsonString(ExplainResult.REFUSE));
            m8673a.f9430f.m8681c();
        }
        return false;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m6989a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SelectRemoteDiagSoftFragmentHD.java */
    /* renamed from: com.cnlaunch.x431pro.activity.golo.function.f$b */
    /* loaded from: classes.dex */
    public class C2240b implements ViewPager.InterfaceC0176e {
        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a */
        public final void mo1773a(int i, float f, int i2) {
        }

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a_ */
        public final void mo1772a_(int i) {
        }

        C2240b() {
        }

        @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
        /* renamed from: a */
        public final void mo1774a(int i) {
            int unused = SelectRemoteDiagSoftFragmentHD.f12624H = i;
            if (C2744aa.m5148g() || (C2744aa.m5166c() && !C2744aa.m5145h())) {
                SelectRemoteDiagSoftFragmentHD selectRemoteDiagSoftFragmentHD = SelectRemoteDiagSoftFragmentHD.this;
                selectRemoteDiagSoftFragmentHD.f12627C = selectRemoteDiagSoftFragmentHD.f12629E;
                PreferencesManager.m9595a(SelectRemoteDiagSoftFragmentHD.this.mContext).m9587a("is_select_heavyduty_area", false);
                PreferencesManager.m9595a(SelectRemoteDiagSoftFragmentHD.this.mContext).m9588a("serialNo", SelectRemoteDiagSoftFragmentHD.this.f12629E);
            } else if (i == 4) {
                SelectRemoteDiagSoftFragmentHD selectRemoteDiagSoftFragmentHD2 = SelectRemoteDiagSoftFragmentHD.this;
                selectRemoteDiagSoftFragmentHD2.f12627C = selectRemoteDiagSoftFragmentHD2.f12628D;
                PreferencesManager.m9595a(SelectRemoteDiagSoftFragmentHD.this.mContext).m9587a("is_select_heavyduty_area", true);
                PreferencesManager.m9595a(SelectRemoteDiagSoftFragmentHD.this.mContext).m9588a("serialNo", SelectRemoteDiagSoftFragmentHD.this.f12628D);
            } else {
                SelectRemoteDiagSoftFragmentHD selectRemoteDiagSoftFragmentHD3 = SelectRemoteDiagSoftFragmentHD.this;
                selectRemoteDiagSoftFragmentHD3.f12627C = selectRemoteDiagSoftFragmentHD3.f12629E;
                PreferencesManager.m9595a(SelectRemoteDiagSoftFragmentHD.this.mContext).m9587a("is_select_heavyduty_area", false);
                PreferencesManager.m9595a(SelectRemoteDiagSoftFragmentHD.this.mContext).m9588a("serialNo", SelectRemoteDiagSoftFragmentHD.this.f12629E);
            }
        }
    }
}
