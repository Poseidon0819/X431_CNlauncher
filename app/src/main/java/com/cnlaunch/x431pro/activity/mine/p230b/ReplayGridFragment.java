package com.cnlaunch.x431pro.activity.mine.p230b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p012v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.diagnose.p218a.GraphPagerAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.GraphViewAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.GridGraphPage;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ReplayDataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.SingleLargeGraph;
import com.cnlaunch.x431pro.module.p252d.GraphConfiguration;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.widget.p290a.SetMaxMinValue;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.mine.b.s */
/* loaded from: classes.dex */
public class ReplayGridFragment extends BaseDataStreamReplayFragment implements ViewPager.InterfaceC0176e, AdapterView.OnItemClickListener, GridGraphPage.InterfaceC2097a, ICallKeyDownFragment, SingleLargeGraph.InterfaceC2099a {

    /* renamed from: c */
    private static int f13839c = 15;

    /* renamed from: f */
    private static boolean f13840f = false;

    /* renamed from: g */
    private static Boolean f13841g = Boolean.FALSE;

    /* renamed from: h */
    private static Boolean f13842h = Boolean.FALSE;

    /* renamed from: e */
    private SingleLargeGraph f13844e;

    /* renamed from: i */
    private ViewPager f13845i;

    /* renamed from: k */
    private int f13847k;

    /* renamed from: l */
    private ICallKeyDownFragment f13848l;

    /* renamed from: m */
    private String f13849m;

    /* renamed from: n */
    private int f13850n;

    /* renamed from: o */
    private TextView f13851o;

    /* renamed from: p */
    private TextView f13852p;

    /* renamed from: r */
    private long f13854r;

    /* renamed from: s */
    private List<BasicDataStreamBean> f13855s;

    /* renamed from: d */
    private List<Integer> f13843d = new ArrayList();

    /* renamed from: j */
    private Map<Integer, GridGraphPage> f13846j = new LinkedHashMap();

    /* renamed from: q */
    private SerializableMap f13853q = null;

    /* renamed from: t */
    private boolean f13856t = false;

    /* renamed from: u */
    private int f13857u = 0;

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: d */
    public final void mo6298d() {
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("DataStreamMask");
            for (int i = 0; i < string.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(string.charAt(i));
                if (sb.toString().equals("1")) {
                    this.f13843d.add(Integer.valueOf(i));
                }
            }
            this.f13849m = arguments.getString("DataStreamShow_Type");
            this.f13857u = arguments.getInt("DataStreamCurPage");
            this.f13850n = arguments.getInt("DataStreamCount");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (getActivity().findViewById(R.id.rl_large_graph) == null) {
            return;
        }
        f13839c = DataStreamConfiguration.m7955d();
        m6314c();
        m6313e();
        m6315b();
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
    }

    /* renamed from: b */
    private void m6315b() {
        this.f13845i.setAdapter(new GraphPagerAdapter(this.f13846j));
        this.f13845i.setOnPageChangeListener(this);
        this.f13845i.setCurrentItem(this.f13857u);
    }

    /* renamed from: c */
    private void m6314c() {
        int i;
        if (!this.f13849m.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            i = this.f13843d.size();
        } else {
            i = this.f13850n;
        }
        int i2 = f13839c;
        this.f13847k = i % i2 > 0 ? (i / i2) + 1 : i / i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = this.f13847k;
            if (i3 >= i5) {
                return;
            }
            int i6 = f13839c;
            int i7 = i3 + 1;
            int i8 = i5 == i7 ? i - (i6 * i3) : i6;
            GridGraphPage gridGraphPage = new GridGraphPage(getActivity(), i3, i4, i8, this, PreferencesManager.m9595a((Context) getActivity()).m9584b("productType", ""));
            gridGraphPage.m7374a();
            this.f13846j.put(Integer.valueOf(i3), gridGraphPage);
            i4 = !this.f13849m.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM) ? i4 + i8 : 0;
            i3 = i7;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_gridview_graph, viewGroup, false);
    }

    /* renamed from: e */
    private void m6313e() {
        this.f13845i = (ViewPager) getActivity().findViewById(R.id.gridGraphContainer);
        RelativeLayout relativeLayout = (RelativeLayout) getActivity().findViewById(R.id.rl_large_graph);
        SingleLargeGraph singleLargeGraph = this.f13844e;
        if (singleLargeGraph != null) {
            if (singleLargeGraph.m7332d()) {
                this.f13844e.m7333c();
            }
            this.f13844e.f11802e = null;
            this.f13844e = null;
        }
        this.f13844e = new SingleLargeGraph(getActivity(), relativeLayout);
        this.f13844e.f11802e = this;
        this.f13851o = (TextView) getActivity().findViewById(R.id.tv_page_number_current);
        this.f13852p = (TextView) getActivity().findViewById(R.id.tv_page_number_total);
        this.f13852p.setText(String.valueOf(this.f13847k));
        this.f13851o.setText("1");
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.SingleLargeGraph.InterfaceC2099a
    /* renamed from: a */
    public final void mo6316a(boolean z) {
        ICallKeyDownFragment iCallKeyDownFragment;
        if (z || (iCallKeyDownFragment = this.f13848l) == null) {
            return;
        }
        iCallKeyDownFragment.mo6304a(1, null);
    }

    /* renamed from: a */
    private void m6317a(List<ArrayList<BasicDataStreamBean>> list, long j, SerializableMap serializableMap) {
        for (GridGraphPage gridGraphPage : this.f13846j.values()) {
            gridGraphPage.m7370a(list, j, serializableMap);
        }
    }

    /* renamed from: a */
    private void m6318a(long j, List<ArrayList<BasicDataStreamBean>> list, SerializableMap serializableMap) {
        this.f13854r = j;
        if (!this.f13849m.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            ArrayList arrayList = new ArrayList(this.f13843d.size());
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(this.f13843d.get(i).intValue()));
            }
            if (this.f13844e.m7332d()) {
                f13840f = true;
                int i2 = this.f13844e.f11803f;
                if (list.size() > i2) {
                    this.f13844e.m7338a(arrayList.get(i2), j, serializableMap);
                    return;
                }
                return;
            }
            f13840f = false;
            m6317a(arrayList, j, serializableMap);
        } else if (this.f13844e.m7332d()) {
            f13840f = true;
            int i3 = this.f13844e.f11803f;
            m6312f();
            int size = list.size();
            int i4 = f13839c;
            int i5 = this.f13850n;
            if (i5 == size) {
                i3 += this.f13857u * i4;
            } else {
                int i6 = this.f13857u;
                int i7 = this.f13847k;
                if (i6 < i7 - 1) {
                    if (size != i4) {
                        NLog.m9456a("GraphGridFragment", "getSingleGraphDataStreamPosition - The data source error-1!");
                        i3 = -1;
                    }
                } else if (i6 != i7 - 1) {
                    NLog.m9456a("GraphGridFragment", "getSingleGraphDataStreamPosition - The data source error-3!");
                    i3 = -1;
                } else if (size != i5 - ((i7 - 1) * i4)) {
                    NLog.m9456a("GraphGridFragment", "getSingleGraphDataStreamPosition - The data source error-2!");
                    i3 = -1;
                }
            }
            if (-1 == i3) {
                return;
            }
            this.f13844e.m7338a(list.get(i3), j, serializableMap);
        } else {
            f13840f = false;
            boolean m6312f = m6312f();
            GridGraphPage gridGraphPage = this.f13846j.get(Integer.valueOf(this.f13857u));
            if (gridGraphPage != null) {
                gridGraphPage.m7371a(list, j, this.f13850n, f13839c, m6312f, serializableMap);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6296a(long j, List<ArrayList<BasicDataStreamBean>> list, List<BasicDataStreamBean> list2, SerializableMap serializableMap) {
        if (list == null || list.size() <= 0 || list2 == null || list2.size() <= 0) {
            return;
        }
        GraphViewAdapter.m7493a(this.f13849m);
        if (this.f13856t && this.f13855s != null) {
            if (list2.size() != this.f13855s.size()) {
                this.f13855s = list2;
                m6318a(j, list, serializableMap);
                this.f13856t = false;
                return;
            }
            if (!this.f13728b.mo7083i().isDatastreamRecord()) {
                int i = 0;
                while (true) {
                    if (i < list2.size()) {
                        if (list2.get(i).getTitle().equals(this.f13855s.get(i).getTitle()) && list2.get(i).getUnit().equals(this.f13855s.get(i).getUnit()) && list2.get(i).getHelp().equals(this.f13855s.get(i).getHelp())) {
                            this.f13856t = true;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (this.f13856t) {
                    m6409a(getString(R.string.custom_diaglog_title), getString(R.string.custom_diaglog_message));
                }
            }
            this.f13856t = false;
        }
        this.f13855s = list2;
        this.f13853q = serializableMap;
        m6318a(j, list, serializableMap);
    }

    /* renamed from: f */
    private static boolean m6312f() {
        boolean booleanValue;
        synchronized (f13841g) {
            booleanValue = f13841g.booleanValue();
        }
        return booleanValue;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f13844e.m7332d()) {
            this.f13844e.m7333c();
            f13840f = false;
            return true;
        }
        return false;
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        NLog.m9456a("GraphGridFragment", "onPageSelected position:".concat(String.valueOf(i)));
        this.f13851o.setText(String.valueOf(i + 1));
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        if (this.f13849m.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            if (this.f13857u != i) {
                for (GridGraphPage gridGraphPage : this.f13846j.values()) {
                    gridGraphPage.f11765e.m7497a();
                }
                DataStreamManager.f11739b.m7380d();
            }
            int i2 = this.f13857u;
            if (i2 - 1 == i) {
                m6409a(getString(R.string.custom_diaglog_title), getString(R.string.custom_diaglog_message));
                this.f13728b.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, "9", 4);
            } else if (i2 + 1 == i) {
                m6409a(getString(R.string.custom_diaglog_title), getString(R.string.custom_diaglog_message));
                this.f13728b.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, "8", 4);
            }
        }
        this.f13857u = i;
        m6408c(this.f13857u);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.GridGraphPage.InterfaceC2097a
    /* renamed from: a */
    public final void mo6319a(int i, int i2, List<BasicDataStreamBean> list) {
        ICallKeyDownFragment iCallKeyDownFragment;
        NLog.m9456a("GraphGridFragment", "onGridGraphItemClick startIndex:" + i + ", offset:" + i2);
        int i3 = !this.f13849m.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM) ? i + i2 : i2;
        String unit = list.get(0).getUnit();
        Log.i("pengzhe", "unit: ".concat(String.valueOf(unit)));
        this.f13844e.m7341a(i3, GraphConfiguration.m5384a(i2), !unit.isEmpty());
        if (!unit.isEmpty() && (iCallKeyDownFragment = this.f13848l) != null) {
            iCallKeyDownFragment.mo6304a(0, null);
        }
        this.f13844e.m7338a(list, this.f13854r, this.f13853q);
        this.f13844e.m7336b();
        f13840f = true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (Math.abs(i - this.f13857u) < 2) {
            this.f13845i.setCurrentItem(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.ICallKeyDownFragment
    /* renamed from: a */
    public final void mo6302a(ICallKeyDownFragment iCallKeyDownFragment) {
        this.f13848l = iCallKeyDownFragment;
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
        if (this.f13844e.m7332d() && this.f13844e.f11799b) {
            setMaxMinValue.m4600a((float) this.f13844e.f11800c);
            setMaxMinValue.m4596b((float) this.f13844e.f11801d);
        }
        setMaxMinValue.show();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getActivity().findViewById(R.id.gridGraphContainer) == null) {
            return;
        }
        f13839c = DataStreamConfiguration.m7955d();
        m6314c();
        m6313e();
        m6315b();
        if (this.f13727a != null) {
            ReplayDataStreamManager.f11779b.m7351b(this);
            ReplayDataStreamManager.f11779b.m7356a(this);
        }
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
    }
}
