package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p012v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p112a.DataStreamGraphicalView;
import com.cnlaunch.p112a.p113a.CombineDataStreamChart;
import com.cnlaunch.p112a.p114b.XYMultipleSeriesDataset;
import com.cnlaunch.p112a.p115c.XYMultipleSeriesRenderer;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.diagnose.p218a.GraphPagerAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.GraphViewAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p220c.C2094g;
import com.cnlaunch.x431pro.activity.diagnose.p220c.CustomCombinedGrapPage;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DiagnoseGraphTouchUtil;
import com.cnlaunch.x431pro.activity.diagnose.p220c.GridGraphPage;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.SingleLargeGraph;
import com.cnlaunch.x431pro.module.p252d.GraphConfiguration;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.widget.CustomViewPager;
import com.cnlaunch.x431pro.widget.p290a.SetMaxMinValue;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.at */
/* loaded from: classes.dex */
public class GraphGridFragment extends BaseDataStreamShowingFragment implements ViewPager.InterfaceC0176e, AdapterView.OnItemClickListener, ICallKeyDownFragment, SingleLargeGraph.InterfaceC2099a {

    /* renamed from: i */
    private static int f12021i = 15;

    /* renamed from: n */
    private static boolean f12022n = false;

    /* renamed from: o */
    private static Boolean f12023o = Boolean.FALSE;

    /* renamed from: A */
    private ImageView f12024A;

    /* renamed from: D */
    private long f12027D;

    /* renamed from: E */
    private List<BasicDataStreamBean> f12028E;

    /* renamed from: G */
    private List<ArrayList<BasicDataStreamBean>> f12030G;

    /* renamed from: e */
    public SingleLargeGraph f12035e;

    /* renamed from: k */
    private TextView f12040k;

    /* renamed from: l */
    private TextView f12041l;

    /* renamed from: m */
    private CustomCombinedGrapPage f12042m;

    /* renamed from: p */
    private CustomViewPager f12043p;

    /* renamed from: r */
    private int f12045r;

    /* renamed from: s */
    private int f12046s;

    /* renamed from: t */
    private ICallKeyDownFragment f12047t;

    /* renamed from: u */
    private int f12048u;

    /* renamed from: v */
    private String f12049v;

    /* renamed from: w */
    private int f12050w;

    /* renamed from: z */
    private ImageView f12053z;

    /* renamed from: j */
    private List<Integer> f12039j = new ArrayList();

    /* renamed from: q */
    private Map<Integer, GridGraphPage> f12044q = new LinkedHashMap();

    /* renamed from: x */
    private boolean f12051x = false;

    /* renamed from: y */
    private SerializableMap f12052y = null;

    /* renamed from: B */
    private int f12025B = -1;

    /* renamed from: C */
    private GridGraphPage.InterfaceC2097a f12026C = new C2131au(this);

    /* renamed from: F */
    private boolean f12029F = false;

    /* renamed from: f */
    int f12036f = 0;

    /* renamed from: H */
    private int f12031H = 0;

    /* renamed from: I */
    private int f12032I = 0;

    /* renamed from: g */
    boolean f12037g = false;

    /* renamed from: h */
    ArrayList<Integer> f12038h = new ArrayList<>();

    /* renamed from: J */
    private RemotePerformClick.InterfaceC1789d f12033J = new C2134ax(this);

    /* renamed from: K */
    private int f12034K = -1;

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ boolean m7232c() {
        f12022n = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ boolean m7231c(GraphGridFragment graphGridFragment) {
        graphGridFragment.f12051x = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static /* synthetic */ boolean m7214j(GraphGridFragment graphGridFragment) {
        graphGridFragment.f12029F = true;
        return true;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f12353d != null) {
            this.f12353d.mo7080l().f9483b = null;
        }
        CustomViewPager customViewPager = this.f12043p;
        if (customViewPager != null) {
            customViewPager.m14754a();
        }
        SingleLargeGraph singleLargeGraph = this.f12035e;
        if (singleLargeGraph != null && singleLargeGraph.m7332d()) {
            this.f12035e.m7333c();
        }
        CustomCombinedGrapPage customCombinedGrapPage = this.f12042m;
        if (customCombinedGrapPage != null && customCombinedGrapPage.m7398a()) {
            this.f12042m.m7391c();
        }
        List<Integer> list = this.f12039j;
        if (list != null) {
            list.clear();
        }
        if (this.f12037g) {
            this.f12037g = false;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Map<Integer, GridGraphPage> map = this.f12044q;
        if (map != null) {
            for (Integer num : map.keySet()) {
                GridGraphPage gridGraphPage = this.f12044q.get(num);
                if (gridGraphPage != null) {
                    gridGraphPage.mo7366f();
                }
            }
            this.f12044q.clear();
            this.f12044q = null;
        }
        ICallKeyDownFragment iCallKeyDownFragment = this.f12047t;
        if (iCallKeyDownFragment != null) {
            iCallKeyDownFragment.mo6302a(null);
            this.f12047t = null;
        }
        SingleLargeGraph singleLargeGraph = this.f12035e;
        if (singleLargeGraph != null) {
            singleLargeGraph.f11802e = null;
            this.f12035e = null;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    /* renamed from: e */
    private void m7226e() {
        this.f12043p.setAdapter(new GraphPagerAdapter(this.f12044q));
        this.f12031H = this.f12032I * (DiagnoseConstants.DATASTREAM_PAGE % f12021i == 0 ? DiagnoseConstants.DATASTREAM_PAGE / f12021i : (DiagnoseConstants.DATASTREAM_PAGE / f12021i) + 1);
        this.f12025B = this.f12031H;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m7224e(false);
    }

    /* renamed from: f */
    private void m7223f() {
        int i;
        if (!this.f12049v.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            i = this.f12039j.size();
        } else {
            i = this.f12050w;
        }
        m7229d(i);
    }

    /* renamed from: d */
    private void m7229d(int i) {
        int i2;
        this.f12044q.clear();
        int i3 = f12021i;
        this.f12045r = i % i3 > 0 ? (i / i3) + 1 : i / i3;
        String m9584b = PreferencesManager.m9595a((Context) getActivity()).m9584b("productType", "");
        int i4 = 0;
        if (!this.f12049v.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            int i5 = this.f12045r;
            int i6 = 0;
            while (i4 < i5) {
                int i7 = f12021i;
                int i8 = i4 + 1;
                if (i5 == i8) {
                    i7 = i - (i7 * i4);
                }
                int i9 = i7;
                GridGraphPage gridGraphPage = new GridGraphPage(getActivity(), (f12021i * i4) / DiagnoseConstants.DATASTREAM_PAGE, i6, i9, this.f12026C, m9584b);
                gridGraphPage.m7365g();
                gridGraphPage.m7374a();
                this.f12044q.put(Integer.valueOf(i4), gridGraphPage);
                i6 += i9;
                i4 = i8;
            }
            return;
        }
        int i10 = i % DiagnoseConstants.DATASTREAM_PAGE;
        int i11 = (DiagnoseConstants.DATASTREAM_PAGE / f12021i) + (DiagnoseConstants.DATASTREAM_PAGE % f12021i > 0 ? 1 : 0);
        int i12 = f12021i;
        int i13 = i10 % i12 > 0 ? (i10 / i12) + 1 : i10 / i12;
        this.f12046s = i / DiagnoseConstants.DATASTREAM_PAGE;
        this.f12046s += i % DiagnoseConstants.DATASTREAM_PAGE > 0 ? 1 : 0;
        if (i13 > 0) {
            this.f12045r = ((this.f12046s - 1) * i11) + i13;
        } else {
            this.f12045r = this.f12046s * i11;
        }
        if (i13 <= 0 && i10 <= 0) {
            if (i10 == 0 && i13 == 0) {
                int i14 = 0;
                int i15 = 0;
                while (i14 < this.f12046s) {
                    int i16 = i15;
                    int i17 = 0;
                    int i18 = 0;
                    while (i17 < i11) {
                        int i19 = f12021i;
                        i17++;
                        if (i11 == i17) {
                            int i20 = DiagnoseConstants.DATASTREAM_PAGE;
                            int i21 = f12021i;
                            if (i20 % i21 > 0) {
                                i21 = DiagnoseConstants.DATASTREAM_PAGE % f12021i;
                            }
                            i2 = i21;
                        } else {
                            i2 = i19;
                        }
                        GridGraphPage gridGraphPage2 = new GridGraphPage(getActivity(), i14, i18, i2, this.f12026C, m9584b);
                        gridGraphPage2.m7365g();
                        gridGraphPage2.m7374a();
                        this.f12044q.put(Integer.valueOf(i16), gridGraphPage2);
                        i18 += i2;
                        i16++;
                    }
                    i14++;
                    i15 = i16;
                }
                return;
            }
            return;
        }
        int i22 = 0;
        int i23 = 0;
        while (i23 < this.f12046s - 1) {
            int i24 = i22;
            int i25 = 0;
            int i26 = 0;
            while (i25 < i11) {
                int i27 = f12021i;
                int i28 = i25 + 1;
                if (i11 == i28) {
                    int i29 = DiagnoseConstants.DATASTREAM_PAGE;
                    i27 = f12021i;
                    if (i29 % i27 > 0) {
                        i27 = DiagnoseConstants.DATASTREAM_PAGE % f12021i;
                    }
                }
                int i30 = i27;
                GridGraphPage gridGraphPage3 = new GridGraphPage(getActivity(), i23, i26, i30, this.f12026C, m9584b);
                gridGraphPage3.m7365g();
                gridGraphPage3.m7374a();
                this.f12044q.put(Integer.valueOf(i24), gridGraphPage3);
                i26 += i30;
                i24++;
                i25 = i28;
            }
            i23++;
            i22 = i24;
        }
        int i31 = i22;
        int i32 = 0;
        while (i4 < i13) {
            int i33 = f12021i;
            int i34 = i4 + 1;
            int i35 = i13 == i34 ? i10 - (i4 * i33) : i33;
            GridGraphPage gridGraphPage4 = new GridGraphPage(getActivity(), this.f12046s - 1, i32, i35, this.f12026C, m9584b);
            gridGraphPage4.m7365g();
            gridGraphPage4.m7374a();
            this.f12044q.put(Integer.valueOf(i31), gridGraphPage4);
            i32 += i35;
            i31++;
            i4 = i34;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_gridview_graph, viewGroup, false);
    }

    /* renamed from: g */
    private void m7221g() {
        RelativeLayout relativeLayout = (RelativeLayout) getActivity().findViewById(R.id.rl_customCombine);
        CustomCombinedGrapPage customCombinedGrapPage = this.f12042m;
        if (customCombinedGrapPage != null) {
            if (customCombinedGrapPage.m7398a()) {
                this.f12042m.m7391c();
            }
            this.f12042m = null;
        }
        this.f12042m = new CustomCombinedGrapPage(getActivity(), relativeLayout);
    }

    /* renamed from: h */
    private void m7219h() {
        this.f12353d.mo7083i().setDataStreamJumpType(1);
        this.f12043p = (CustomViewPager) getActivity().findViewById(R.id.gridGraphContainer);
        RelativeLayout relativeLayout = (RelativeLayout) getActivity().findViewById(R.id.rl_large_graph);
        SingleLargeGraph singleLargeGraph = this.f12035e;
        if (singleLargeGraph != null) {
            if (singleLargeGraph.m7332d()) {
                this.f12035e.m7333c();
            }
            this.f12035e.f11802e = null;
            this.f12035e = null;
            this.f12051x = false;
        }
        this.f12035e = new SingleLargeGraph(getActivity(), relativeLayout);
        this.f12035e.m7345a();
        this.f12035e.f11802e = this;
        m7221g();
        this.f12040k = (TextView) getActivity().findViewById(R.id.tv_page_number_current);
        this.f12041l = (TextView) getActivity().findViewById(R.id.tv_page_number_total);
        this.f12041l.setText(String.valueOf(this.f12045r));
        this.f12040k.setText("1");
        this.f12053z = (ImageView) getActivity().findViewById(R.id.ds_right_arrow);
        this.f12024A = (ImageView) getActivity().findViewById(R.id.ds_left_arrow);
        this.f12053z.setOnClickListener(new View$OnClickListenerC2132av(this));
        this.f12024A.setOnClickListener(new View$OnClickListenerC2133aw(this));
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.SingleLargeGraph.InterfaceC2099a
    /* renamed from: a */
    public final void mo6316a(boolean z) {
        ICallKeyDownFragment iCallKeyDownFragment;
        if (z || (iCallKeyDownFragment = this.f12047t) == null) {
            return;
        }
        iCallKeyDownFragment.mo6304a(DataStreamShowFragment.f11881b, null);
    }

    /* renamed from: b */
    private List<ArrayList<BasicDataStreamBean>> m7234b(List<ArrayList<BasicDataStreamBean>> list) {
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList<Integer> m7368b = this.f12044q.get(Integer.valueOf(this.f12031H)).m7368b();
            for (int i = 0; i < m7368b.size(); i++) {
                arrayList.add(list.get(this.f12044q.get(Integer.valueOf(this.f12031H)).m7375e() + m7368b.get(i).intValue()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m7236a(List<ArrayList<BasicDataStreamBean>> list, long j, SerializableMap serializableMap) {
        this.f12042m.m7394a(m7234b(list), j, serializableMap);
    }

    /* renamed from: b */
    private void m7233b(List<ArrayList<BasicDataStreamBean>> list, long j, SerializableMap serializableMap) {
        int i = this.f12031H;
        int i2 = this.f12031H;
        int i3 = i2 + 1;
        int i4 = this.f12045r;
        if (i3 < i4) {
            i4 = i2 + 1;
        }
        for (int i5 = i + (-2) > 0 ? i - 2 : 0; i5 < i4; i5++) {
            this.f12044q.get(Integer.valueOf(i5)).m7370a(list, j, serializableMap);
        }
        GridGraphPage gridGraphPage = this.f12044q.get(Integer.valueOf(this.f12031H));
        if (gridGraphPage != null) {
            m7130a(gridGraphPage.m7375e(), gridGraphPage.m7376d());
        }
    }

    /* renamed from: a */
    private void m7238a(long j, List<ArrayList<BasicDataStreamBean>> list, SerializableMap serializableMap) {
        int i;
        this.f12027D = j;
        this.f12030G = list;
        if (!this.f12049v.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            ArrayList arrayList = new ArrayList(this.f12039j.size());
            int size = this.f12039j.size();
            if (this.f12049v.equals("ActiveTest") || this.f12049v.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                list.size();
                arrayList.addAll(list);
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(list.get(this.f12039j.get(i2).intValue()));
                }
            }
            if (this.f12035e.m7332d()) {
                if (!this.f12051x) {
                    String unit = list.get(0).get(0).getUnit();
                    this.f12035e.m7341a(0, GraphConfiguration.m5384a(0), !unit.isEmpty());
                    this.f12035e.f11798a = true;
                    int i3 = !unit.isEmpty() ? DataStreamShowFragment.f11880a : DataStreamShowFragment.f11885m;
                    ICallKeyDownFragment iCallKeyDownFragment = this.f12047t;
                    if (iCallKeyDownFragment != null) {
                        iCallKeyDownFragment.mo6304a(i3, null);
                    }
                    this.f12051x = true;
                }
                f12022n = true;
                int i4 = this.f12035e.f11803f;
                if (list.size() > i4) {
                    this.f12035e.m7338a(arrayList.get(i4), j, serializableMap);
                }
            } else if (this.f12042m.m7398a()) {
                m7236a(arrayList, j, serializableMap);
            } else {
                f12022n = false;
                m7233b(arrayList, j, serializableMap);
            }
        } else if (this.f12035e.m7332d()) {
            if (!this.f12051x) {
                String unit2 = list.get(0).get(0).getUnit();
                this.f12035e.m7341a(0, GraphConfiguration.m5384a(0), !unit2.isEmpty());
                this.f12035e.f11798a = true;
                int i5 = !unit2.isEmpty() ? DataStreamShowFragment.f11880a : DataStreamShowFragment.f11885m;
                ICallKeyDownFragment iCallKeyDownFragment2 = this.f12047t;
                if (iCallKeyDownFragment2 != null) {
                    iCallKeyDownFragment2.mo6304a(i5, null);
                }
                this.f12051x = true;
            }
            f12022n = true;
            int i6 = this.f12035e.f11803f;
            int e = this.f12044q.get(Integer.valueOf(this.f12031H)).m7375e();
            int size2 = list.size();
            int i7 = DiagnoseConstants.DATASTREAM_PAGE;
            int i8 = this.f12050w;
            if (i8 == size2) {
                i = (this.f12032I * i7) + e + i6;
            } else {
                int i9 = this.f12032I;
                int i10 = this.f12046s;
                if (i9 < i10 - 1) {
                    if (size2 == i7) {
                        i = e + i6;
                    } else {
                        NLog.m9456a("GraphGridFragment", "getSingleGraphDataStreamPosition - The data source error-1!");
                        i = -1;
                    }
                } else if (i9 != i10 - 1) {
                    NLog.m9456a("GraphGridFragment", "getSingleGraphDataStreamPosition - The data source error-3!");
                    i = -1;
                } else if (size2 == i8 - ((i10 - 1) * i7)) {
                    i = e + i6;
                } else {
                    NLog.m9456a("GraphGridFragment", "getSingleGraphDataStreamPosition - The data source error-2!");
                    i = -1;
                }
            }
            if (-1 == i) {
                return;
            }
            if (i >= list.size()) {
                this.f12035e.m7333c();
            } else {
                this.f12035e.m7338a(list.get(i), j, serializableMap);
            }
        } else if (this.f12042m.m7398a()) {
            m7236a(list, j, serializableMap);
        } else {
            f12022n = false;
            boolean m7217i = m7217i();
            GridGraphPage gridGraphPage = this.f12044q.get(Integer.valueOf(this.f12031H));
            if (gridGraphPage != null) {
                gridGraphPage.m7371a(list, j, this.f12050w, DiagnoseConstants.DATASTREAM_PAGE, m7217i, serializableMap);
                m7130a(gridGraphPage.f11764d, gridGraphPage.m7376d());
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6296a(long j, List<ArrayList<BasicDataStreamBean>> list, List<BasicDataStreamBean> list2, SerializableMap serializableMap) {
        List<BasicDataStreamBean> list3;
        if (list == null || list.size() <= 0 || list2 == null || list2.size() <= 0) {
            return;
        }
        if (this.f12049v.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM) && ((list3 = this.f12028E) == null || (list3 != null && list3.size() != list2.size()))) {
            this.f12050w = list.size();
            int i = this.f12050w;
            this.f12048u = i;
            this.f12045r = (i % f12021i == 0 ? 0 : 1) + (this.f12050w / f12021i);
            this.f12041l.setText(String.valueOf(this.f12045r));
            this.f12040k.setText("1");
            this.f12043p.removeAllViews();
            m7229d(this.f12050w);
            this.f12031H = 0;
            m7226e();
        }
        GraphViewAdapter.m7493a(this.f12049v);
        if (this.f12029F && this.f12028E != null) {
            if (list2.size() != this.f12028E.size()) {
                this.f12028E = list2;
                m7238a(j, list, serializableMap);
                this.f12029F = false;
                return;
            }
            if (!this.f12353d.mo7083i().isDatastreamRecord()) {
                this.f12029F = false;
                int i2 = 0;
                while (true) {
                    if (i2 < list2.size()) {
                        if (list2.get(i2).getTitle().equals(this.f12028E.get(i2).getTitle()) && list2.get(i2).getUnit().equals(this.f12028E.get(i2).getUnit()) && list2.get(i2).getHelp().equals(this.f12028E.get(i2).getHelp())) {
                            this.f12029F = true;
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
                if (this.f12029F) {
                    if (this.f12036f < 4) {
                        m7129a(getString(R.string.custom_diaglog_title), getString(R.string.custom_diaglog_message));
                        this.f12036f++;
                    } else {
                        this.f12036f = 0;
                    }
                } else {
                    this.f12036f = 0;
                }
            }
            this.f12029F = false;
        }
        if (this.f12029F) {
            return;
        }
        this.f12028E = list2;
        this.f12052y = serializableMap;
        m7238a(j, list, serializableMap);
    }

    /* renamed from: c */
    public static void m7230c(boolean z) {
        synchronized (f12023o) {
            f12023o = Boolean.valueOf(z);
        }
    }

    /* renamed from: i */
    private boolean m7217i() {
        if (this.f12353d == null) {
            return false;
        }
        return this.f12353d.mo7083i().isDatastreamRecord();
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f12035e.m7332d() && this.f12050w != 1) {
            this.f12035e.m7333c();
            f12022n = false;
            return true;
        } else if (m7217i()) {
            NToast.m9444c(getActivity(), (int) R.string.toast_mustbe_stop_record);
            return true;
        } else if (this.f12042m.m7398a()) {
            this.f12042m.m7391c();
            ICallKeyDownFragment iCallKeyDownFragment = this.f12047t;
            if (iCallKeyDownFragment != null) {
                iCallKeyDownFragment.mo6304a(DataStreamShowFragment.f11884l, null);
            }
            m7213k();
            return true;
        } else if (this.f12037g) {
            this.f12044q.get(Integer.valueOf(this.f12031H)).m7369a(false);
            this.f12037g = false;
            m7227d(false);
            ICallKeyDownFragment iCallKeyDownFragment2 = this.f12047t;
            if (iCallKeyDownFragment2 != null) {
                iCallKeyDownFragment2.mo6304a(DataStreamShowFragment.f11883k, null);
            }
            m7213k();
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5  */
    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo1774a(int r8) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.p221d.GraphGridFragment.mo1774a(int):void");
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (Math.abs(i - this.f12031H) < 2) {
            this.f12043p.setCurrentItem(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6302a(ICallKeyDownFragment iCallKeyDownFragment) {
        this.f12047t = iCallKeyDownFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final boolean mo6304a(int i, KeyEvent keyEvent) {
        return onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6305a() {
        SetMaxMinValue setMaxMinValue = new SetMaxMinValue(getActivity());
        setMaxMinValue.f16364a = this;
        if (this.f12035e.m7332d() && this.f12035e.f11799b) {
            setMaxMinValue.m4600a((float) this.f12035e.f11800c);
            setMaxMinValue.m4596b((float) this.f12035e.f11801d);
        }
        setMaxMinValue.show();
    }

    /* renamed from: j */
    private void m7215j() {
        this.f12038h = this.f12044q.get(Integer.valueOf(this.f12031H)).m7368b();
        ArrayList<Integer> arrayList = this.f12038h;
        if (arrayList == null || arrayList.size() == 0) {
            NToast.m9446b(this.mContext, getString(R.string.toast_need_one_item));
            return;
        }
        CustomCombinedGrapPage customCombinedGrapPage = this.f12042m;
        int size = this.f12038h.size();
        customCombinedGrapPage.f11736j.removeAllViews();
        customCombinedGrapPage.f11727a = size;
        customCombinedGrapPage.f11728b = new XYMultipleSeriesRenderer(customCombinedGrapPage.f11727a);
        customCombinedGrapPage.f11729c = new XYMultipleSeriesDataset();
        customCombinedGrapPage.f11730d = new CombineDataStreamChart(customCombinedGrapPage.f11728b, customCombinedGrapPage.f11729c);
        customCombinedGrapPage.f11734h = new DataStreamGraphicalView(customCombinedGrapPage.f11733g, customCombinedGrapPage.f11730d);
        customCombinedGrapPage.f11731e = new Timer();
        customCombinedGrapPage.f11732f = new C2094g(customCombinedGrapPage);
        customCombinedGrapPage.m7396a(customCombinedGrapPage.f11728b);
        customCombinedGrapPage.m7392b();
        customCombinedGrapPage.f11736j.addView(customCombinedGrapPage.f11734h, new RelativeLayout.LayoutParams(-1, -1));
        customCombinedGrapPage.f11735i = true;
        if (customCombinedGrapPage.f11735i) {
            DiagnoseGraphTouchUtil diagnoseGraphTouchUtil = new DiagnoseGraphTouchUtil();
            diagnoseGraphTouchUtil.f11755c = customCombinedGrapPage.f11728b;
            diagnoseGraphTouchUtil.f11753a = 10.0f;
            customCombinedGrapPage.f11734h.setOnTouchListener(diagnoseGraphTouchUtil);
        }
        ICallKeyDownFragment iCallKeyDownFragment = this.f12047t;
        if (iCallKeyDownFragment != null) {
            iCallKeyDownFragment.mo6304a(DataStreamShowFragment.f11882j, null);
        }
        this.f12042m.f11736j.setVisibility(0);
    }

    /* renamed from: d */
    private void m7227d(boolean z) {
        CustomViewPager customViewPager = this.f12043p;
        if (customViewPager != null) {
            customViewPager.f15961g = !z;
        }
        this.f12024A.setEnabled(!z);
        this.f12053z.setEnabled(!z);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: d */
    public final void mo6298d() {
        if (!this.f12037g) {
            GridGraphPage gridGraphPage = this.f12044q.get(Integer.valueOf(this.f12031H));
            if (gridGraphPage == null) {
                return;
            }
            gridGraphPage.m7369a(true);
            this.f12037g = true;
            m7227d(true);
            ICallKeyDownFragment iCallKeyDownFragment = this.f12047t;
            if (iCallKeyDownFragment != null) {
                iCallKeyDownFragment.mo6304a(DataStreamShowFragment.f11884l, null);
            }
        } else {
            m7215j();
        }
        m7213k();
    }

    /* renamed from: k */
    private void m7213k() {
        mo6296a(this.f12027D, this.f12030G, this.f12028E, this.f12052y);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getActivity().findViewById(R.id.gridGraphContainer) == null || this.f12044q.get(Integer.valueOf(this.f12031H)) == null) {
            return;
        }
        ArrayList<Integer> m7368b = this.f12044q.get(Integer.valueOf(this.f12031H)).m7368b();
        boolean m7398a = this.f12042m.m7398a();
        if (!MainActivity.m7895b()) {
            DataStreamConfiguration.m7959a(this.mContext);
        }
        if (this.f12049v.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
            this.f12045r = (this.f12048u % f12021i == 0 ? 0 : 1) + (this.f12048u / f12021i);
            this.f12041l.setText(String.valueOf(this.f12045r));
            m7229d(this.f12048u);
            m7226e();
        } else {
            if (this.f12037g) {
                this.f12043p.f15961g = true;
            }
            m7223f();
            m7219h();
            m7226e();
        }
        if (this.f12037g) {
            GridGraphPage gridGraphPage = this.f12044q.get(Integer.valueOf(this.f12031H));
            gridGraphPage.m7369a(true);
            if (m7368b != null && m7368b.size() > 0 && gridGraphPage.f11765e != null && gridGraphPage.f11765e.f11361f != null) {
                GraphViewAdapter graphViewAdapter = gridGraphPage.f11765e;
                if (graphViewAdapter.f11361f != null) {
                    graphViewAdapter.f11361f.clear();
                }
                graphViewAdapter.f11361f.addAll(m7368b);
                gridGraphPage.f11765e.notifyDataSetChanged();
            }
            if (m7398a) {
                m7215j();
            }
            m7213k();
        }
        m7224e(true);
        if (this.f12037g) {
            this.f12043p.f15961g = false;
        }
    }

    /* renamed from: e */
    private void m7224e(boolean z) {
        int i = this.f12034K;
        CustomViewPager customViewPager = this.f12043p;
        if (customViewPager != null) {
            customViewPager.m14754a();
            this.f12043p.m14742a(this);
            int currentItem = this.f12043p.getCurrentItem();
            if (!z) {
                int i2 = this.f12025B;
                if (i2 != -1 && i2 != currentItem) {
                    this.f12043p.setCurrentItem(i2);
                }
            } else if (i != -1 && i != currentItem) {
                this.f12043p.setCurrentItem(i);
            }
            TextView textView = this.f12040k;
            if (textView != null) {
                textView.setText(String.valueOf(this.f12043p.getCurrentItem() + 1));
            }
            this.f12025B = -1;
            if (this.f12043p.getCurrentItem() == 0) {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(1);
            } else {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(2);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        SingleLargeGraph singleLargeGraph;
        Bundle arguments = getArguments();
        List<Integer> list = this.f12039j;
        if (list != null) {
            list.clear();
        }
        if (arguments != null) {
            String string = arguments.getString("DataStreamMask");
            for (int i = 0; i < string.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(string.charAt(i));
                if (sb.toString().equals("1")) {
                    this.f12039j.add(Integer.valueOf(i));
                }
            }
            this.f12049v = arguments.getString("DataStreamShow_Type");
            this.f12032I = arguments.getInt("DataStreamCurPage");
            this.f12050w = arguments.getInt("DataStreamCount");
        }
        f12021i = DataStreamConfiguration.m7955d();
        m7223f();
        m7219h();
        m7226e();
        if (this.f12050w == 1 && (singleLargeGraph = this.f12035e) != null) {
            singleLargeGraph.m7336b();
        }
        if (this.f12353d != null && this.f12353d.mo7083i().getDiagnoseStatue() < 2) {
            this.f12353d.mo7080l().f9483b = this.f12033J;
        }
        super.onActivityCreated(bundle);
    }
}
