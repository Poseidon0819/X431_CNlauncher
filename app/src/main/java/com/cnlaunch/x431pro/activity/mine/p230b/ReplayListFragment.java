package com.cnlaunch.x431pro.activity.mine.p230b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p012v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.diagnose.p218a.DataStreamShowListAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ImagePageAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ViewPagerAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.widget.NoScrollGridView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ValidFragment"})
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.t */
/* loaded from: classes.dex */
public class ReplayListFragment extends BaseDataStreamReplayFragment implements ViewPager.InterfaceC0176e, AdapterView.OnItemClickListener, IDataStreamSelector {

    /* renamed from: e */
    private TextView f13860e;

    /* renamed from: f */
    private TextView f13861f;

    /* renamed from: g */
    private DataStreamShowListAdapter f13862g;

    /* renamed from: h */
    private IDataStreamSelectionRecorder f13863h;

    /* renamed from: i */
    private RelativeLayout f13864i;

    /* renamed from: j */
    private ViewPager f13865j;

    /* renamed from: s */
    private String f13874s;

    /* renamed from: w */
    private List<BasicDataStreamBean> f13878w;

    /* renamed from: d */
    private final String f13859d = "TextListFragment";

    /* renamed from: k */
    private ViewPagerAdapter f13866k = null;

    /* renamed from: l */
    private int f13867l = 0;

    /* renamed from: m */
    private int f13868m = 0;

    /* renamed from: n */
    private int f13869n = 1;

    /* renamed from: o */
    private int f13870o = 0;

    /* renamed from: p */
    private int f13871p = 3;

    /* renamed from: q */
    private int f13872q = 5;

    /* renamed from: r */
    private String f13873r = "";

    /* renamed from: t */
    private ArrayList<DataStreamShowListAdapter> f13875t = new ArrayList<>();

    /* renamed from: u */
    private NoScrollGridView f13876u = null;

    /* renamed from: v */
    private ImagePageAdapter f13877v = null;

    /* renamed from: x */
    private int f13879x = -1;

    /* renamed from: c */
    boolean f13858c = false;

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_text_list, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder = this.f13863h;
        if (iDataStreamSelectionRecorder != null) {
            iDataStreamSelectionRecorder.mo6404a((IDataStreamSelector) null);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (getActivity().findViewById(R.id.viewPager_layout) == null) {
            return;
        }
        m6311a();
        if (this.f13868m == 0) {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        }
        m6306b(this.f13878w);
        m6408c(this.f13870o);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13873r = arguments.getString("DataStreamMask");
            this.f13874s = arguments.getString("DataStreamShow_Type");
            this.f13870o = arguments.getInt("DataStreamCurPage");
            this.f13867l = arguments.getInt("DataStreamCount");
            this.f13862g = new DataStreamShowListAdapter(this.f13873r, getActivity());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        m6311a();
        if (this.f13868m == 0) {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        }
        super.onActivityCreated(bundle);
    }

    /* renamed from: a */
    private void m6311a() {
        View findViewById = getActivity().findViewById(R.id.btn_selectall);
        if (findViewById == null) {
            return;
        }
        findViewById.setVisibility(8);
        this.f13869n = (this.f13867l % this.f13872q == 0 ? 0 : 1) + (this.f13867l / this.f13872q);
        this.f13864i = (RelativeLayout) getActivity().findViewById(R.id.viewPager_layout);
        this.f13865j = (ViewPager) getActivity().findViewById(R.id.customviewPager);
        if (this.f13865j == null) {
            return;
        }
        this.f13860e = (TextView) getActivity().findViewById(R.id.tv_page_number_current);
        this.f13861f = (TextView) getActivity().findViewById(R.id.tv_page_number_total);
        this.f13861f.setText(String.valueOf(this.f13869n));
        this.f13860e.setText("1");
        m6309a(this.f13873r);
        this.f13865j.setOnPageChangeListener(this);
        this.f13864i.setVisibility(0);
        this.f13876u = (NoScrollGridView) getActivity().findViewById(R.id.horizontal_gridview);
        this.f13877v = new ImagePageAdapter(getActivity(), this.f13869n);
        this.f13876u.setAdapter((ListAdapter) this.f13877v);
        m6307b();
        this.f13868m = this.f13870o * this.f13871p;
        this.f13865j.setCurrentItem(this.f13868m);
    }

    /* renamed from: a */
    private void m6309a(String str) {
        this.f13875t.clear();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f13869n; i++) {
            ListView listView = new ListView(getActivity());
            listView.setOnItemClickListener(this);
            DataStreamShowListAdapter dataStreamShowListAdapter = new DataStreamShowListAdapter(str, getActivity());
            listView.setAdapter((ListAdapter) dataStreamShowListAdapter);
            this.f13875t.add(dataStreamShowListAdapter);
            arrayList.add(listView);
        }
        this.f13866k = new ViewPagerAdapter(arrayList);
        this.f13865j.setAdapter(this.f13866k);
    }

    /* renamed from: b */
    private void m6306b(List<BasicDataStreamBean> list) {
        int i = this.f13868m;
        if (this.f13874s.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            i = this.f13868m % this.f13871p;
        }
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<BasicDataStreamBean> arrayList2 = new ArrayList<>();
        arrayList.addAll(list);
        int i2 = this.f13872q;
        int i3 = i * i2;
        int i4 = (i * i2) + i2;
        int size = list.size();
        int i5 = this.f13872q;
        if (size < i5) {
            i4 = (i * i5) + list.size();
        }
        try {
            arrayList2.addAll(arrayList.subList(i3, i4));
        } catch (IndexOutOfBoundsException unused) {
            int size2 = list.size();
            try {
                arrayList2.addAll(arrayList.subList(i3, size2));
            } catch (Exception unused2) {
                arrayList2.addAll(arrayList.subList(0, size2));
            }
        }
        if (this.f13875t.size() < this.f13868m || arrayList2.size() <= 0) {
            return;
        }
        this.f13875t.get(this.f13868m).m7517a(arrayList2);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f13875t.get(this.f13868m).m7520a(i);
        this.f13879x = this.f13875t.get(this.f13868m).f11294a;
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder = this.f13863h;
        if (iDataStreamSelectionRecorder != null) {
            iDataStreamSelectionRecorder.mo6399a(this.f13862g.m7521a());
            this.f13863h.mo6396b((this.f13868m * this.f13872q) + this.f13879x);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6296a(long j, List<ArrayList<BasicDataStreamBean>> list, List<BasicDataStreamBean> list2, SerializableMap serializableMap) {
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        if (this.f13858c && this.f13878w != null) {
            if (list2.size() != this.f13878w.size()) {
                this.f13878w = list2;
                m6306b(list2);
                this.f13858c = false;
                return;
            }
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).getTitle().equals(this.f13878w.get(i).getTitle()) && list2.get(i).getUnit().equals(this.f13878w.get(i).getUnit()) && list2.get(i).getHelp().equals(this.f13878w.get(i).getHelp())) {
                    return;
                }
            }
            this.f13858c = false;
        }
        this.f13878w = list2;
        m6306b(list2);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector
    /* renamed from: a */
    public final void mo6310a(IDataStreamSelectionRecorder iDataStreamSelectionRecorder) {
        this.f13863h = iDataStreamSelectionRecorder;
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder2 = this.f13863h;
        if (iDataStreamSelectionRecorder2 != null) {
            iDataStreamSelectionRecorder2.mo6404a(this);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector
    /* renamed from: a */
    public final void mo6308a(boolean z) {
        this.f13862g.m7516a(z);
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder = this.f13863h;
        if (iDataStreamSelectionRecorder != null) {
            iDataStreamSelectionRecorder.mo6399a(this.f13862g.m7521a());
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        ArrayList<DataStreamShowListAdapter> arrayList = this.f13875t;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<DataStreamShowListAdapter> it = this.f13875t.iterator();
        while (it.hasNext()) {
            it.next().m7515b();
        }
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        this.f13860e.setText(String.valueOf(i + 1));
        this.f13868m = i;
        this.f13877v.m7489a(i);
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        if (this.f13874s.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            int i2 = this.f13870o;
            int i3 = this.f13871p;
            if (i2 < i / i3) {
                this.f13858c = true;
                if (this.f13728b != null) {
                    this.f13728b.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, "8", 4);
                }
            } else if (i2 > i / i3) {
                this.f13858c = true;
                if (this.f13728b != null) {
                    this.f13728b.mo7093a(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, "9", 4);
                }
            }
            this.f13870o = i / this.f13871p;
        }
        m6306b(this.f13878w);
        m6408c(this.f13870o);
    }

    /* renamed from: b */
    private void m6307b() {
        this.f13876u.setNumColumns(this.f13869n);
        int integer = getActivity().getResources().getInteger(R.integer.datastream_imagepage_button_widthsize);
        this.f13876u.setLayoutParams(new LinearLayout.LayoutParams(this.f13869n * integer, -1));
        this.f13876u.setColumnWidth(integer);
        this.f13876u.setStretchMode(0);
    }
}
