package com.cnlaunch.x431pro.activity.mine.p230b;

import android.app.Activity;
import android.os.Bundle;
import android.support.p012v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.diagnose.p218a.GraphPagerAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p220c.CombinedGraphPage;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamManager;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.widget.NoScrollGridView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.mine.b.r */
/* loaded from: classes.dex */
public class ReplayCombinedFragment extends BaseDataStreamReplayFragment implements ViewPager.InterfaceC0176e {

    /* renamed from: g */
    private ViewPager f13830g;

    /* renamed from: j */
    private TextView f13833j;

    /* renamed from: k */
    private TextView f13834k;

    /* renamed from: l */
    private String f13835l;

    /* renamed from: m */
    private int f13836m;

    /* renamed from: n */
    private int f13837n;

    /* renamed from: c */
    private int f13826c = 0;

    /* renamed from: d */
    private int f13827d = 0;

    /* renamed from: e */
    private ArrayList<Integer> f13828e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<ArrayList<BasicDataStreamBean>> f13829f = new ArrayList<>();

    /* renamed from: h */
    private Map<Integer, CombinedGraphPage> f13831h = new LinkedHashMap();

    /* renamed from: i */
    private NoScrollGridView f13832i = null;

    /* renamed from: o */
    private SerializableMap f13838o = null;

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f13831h.clear();
        this.f13829f.clear();
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
                    this.f13828e.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < this.f13828e.size(); i2++) {
                this.f13829f.add(new ArrayList<>());
            }
            this.f13835l = arguments.getString("DataStreamShow_Type");
            this.f13837n = arguments.getInt("DataStreamCurPage");
            this.f13836m = arguments.getInt("DataStreamCount");
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_combined_graph, viewGroup, false);
    }

    /* renamed from: a */
    private void m6320a(List<ArrayList<BasicDataStreamBean>> list, long j) {
        for (CombinedGraphPage combinedGraphPage : this.f13831h.values()) {
            if (combinedGraphPage.f11761a == this.f13837n) {
                combinedGraphPage.m7402a(list, j, this.f13838o);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6296a(long j, List<ArrayList<BasicDataStreamBean>> list, List<BasicDataStreamBean> list2, SerializableMap serializableMap) {
        if (list == null || list.size() <= 0 || list2 == null || list2.size() <= 0) {
            return;
        }
        if (!this.f13835l.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            ArrayList arrayList = new ArrayList(this.f13828e.size());
            for (int i = 0; i < this.f13828e.size(); i++) {
                arrayList.add(list.get(this.f13828e.get(i).intValue()));
            }
            for (CombinedGraphPage combinedGraphPage : this.f13831h.values()) {
                combinedGraphPage.m7402a(arrayList, j, serializableMap);
            }
        } else {
            m6320a(list, j);
        }
        this.f13838o = serializableMap;
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        this.f13833j.setText(String.valueOf(i + 1));
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        int i2 = this.f13831h.get(Integer.valueOf(i)).f11761a;
        if (this.f13835l.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            if (this.f13837n != i2) {
                DataStreamManager.f11739b.m7380d();
                for (CombinedGraphPage combinedGraphPage : this.f13831h.values()) {
                    combinedGraphPage.m7400b();
                }
            }
            int i3 = this.f13837n;
            if (i3 - 1 == i2) {
                m6409a(getString(R.string.custom_diaglog_title), getString(R.string.custom_diaglog_message));
                this.f13728b.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, "9", 4);
                NLog.m9456a("CombineGraphFragment", "onPageSelected go previous page, old:" + this.f13837n + ", new:" + i);
            } else if (i3 + 1 == i2) {
                m6409a(getString(R.string.custom_diaglog_title), getString(R.string.custom_diaglog_message));
                this.f13728b.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, "8", 4);
                NLog.m9456a("CombineGraphFragment", "onPageSelected go next page, old:" + this.f13837n + ", new" + i);
            }
        }
        this.f13837n = i2;
        m6408c(this.f13837n);
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        int i = 0;
        if (!this.f13835l.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            int size = this.f13828e.size();
            this.f13827d = size % 4 > 0 ? (size / 4) + 1 : size / 4;
            int i2 = 0;
            while (true) {
                int i3 = this.f13827d;
                if (i >= i3) {
                    break;
                }
                int i4 = i + 1;
                int i5 = i3 == i4 ? size - (i * 4) : 4;
                this.f13831h.put(Integer.valueOf(i), new CombinedGraphPage(getActivity(), i, i2, i5));
                i2 += i5;
                i = i4;
            }
        } else {
            int i6 = this.f13836m;
            int i7 = i6 % 15;
            if (i7 > 0) {
                int i8 = i7 % 4 > 0 ? (i7 / 4) + 1 : i7 / 4;
                this.f13826c = (i6 / 15) + 1;
                this.f13827d = ((this.f13826c - 1) * 4) + i8;
                int i9 = 0;
                int i10 = 0;
                while (i9 < this.f13826c - 1) {
                    int i11 = i10;
                    int i12 = 0;
                    int i13 = 0;
                    while (i12 < 4) {
                        i12++;
                        int i14 = 4 == i12 ? 3 : 4;
                        this.f13831h.put(Integer.valueOf(i11), new CombinedGraphPage(getActivity(), i9, i13, i14));
                        i13 += i14;
                        i11++;
                    }
                    i9++;
                    i10 = i11;
                }
                int i15 = 0;
                while (i < i8) {
                    int i16 = i + 1;
                    int i17 = i8 == i16 ? i7 - (i * 4) : 4;
                    this.f13831h.put(Integer.valueOf(i10), new CombinedGraphPage(getActivity(), this.f13826c - 1, i15, i17));
                    i15 += i17;
                    i = i16;
                    i10++;
                }
            } else {
                this.f13826c = i6 / 15;
                this.f13827d = this.f13826c * 4;
                int i18 = 0;
                int i19 = 0;
                while (i18 < this.f13826c) {
                    int i20 = i19;
                    int i21 = 0;
                    int i22 = 0;
                    while (i21 < 4) {
                        int i23 = i21 == 4 ? 3 : 4;
                        this.f13831h.put(Integer.valueOf(i20), new CombinedGraphPage(getActivity(), i18, i22, i23));
                        i22 += i23;
                        i21++;
                        i20++;
                    }
                    i18++;
                    i19 = i20;
                }
            }
        }
        this.f13830g = (ViewPager) getActivity().findViewById(R.id.combinedGraphContainer);
        this.f13833j = (TextView) getActivity().findViewById(R.id.tv_page_number_current);
        this.f13834k = (TextView) getActivity().findViewById(R.id.tv_page_number_total);
        this.f13834k.setText(String.valueOf(this.f13827d));
        this.f13833j.setText("1");
        this.f13830g.setAdapter(new GraphPagerAdapter(this.f13831h));
        this.f13830g.setOnPageChangeListener(this);
        this.f13830g.setCurrentItem(this.f13837n * 4);
        super.onActivityCreated(bundle);
    }
}
