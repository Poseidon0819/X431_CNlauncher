package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.p012v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.diagnose.p218a.DataStreamShowListAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ViewPagerAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.widget.CustomViewPager;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ValidFragment"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.cj */
/* loaded from: classes.dex */
public class TextListFragment extends BaseDataStreamShowingFragment implements ViewPager.InterfaceC0176e, AdapterView.OnItemClickListener, IDataStreamSelector {

    /* renamed from: D */
    private ImageView f12296D;

    /* renamed from: E */
    private ImageView f12297E;

    /* renamed from: f */
    private TextView f12301f;

    /* renamed from: g */
    private TextView f12302g;

    /* renamed from: h */
    private TextView f12303h;

    /* renamed from: i */
    private DataStreamShowListAdapter f12304i;

    /* renamed from: j */
    private IDataStreamSelectionRecorder f12305j;

    /* renamed from: k */
    private RelativeLayout f12306k;

    /* renamed from: l */
    private CustomViewPager f12307l;

    /* renamed from: w */
    private String f12318w;

    /* renamed from: e */
    private final String f12300e = "TextListFragment";

    /* renamed from: m */
    private ViewPagerAdapter f12308m = null;

    /* renamed from: n */
    private int f12309n = 0;

    /* renamed from: o */
    private int f12310o = 0;

    /* renamed from: p */
    private int f12311p = 1;

    /* renamed from: q */
    private int f12312q = 0;

    /* renamed from: r */
    private int f12313r = 3;

    /* renamed from: s */
    private int f12314s = 5;

    /* renamed from: t */
    private int f12315t = 35;

    /* renamed from: u */
    private int f12316u = -1;

    /* renamed from: v */
    private String f12317v = "";

    /* renamed from: x */
    private ArrayList<DataStreamShowListAdapter> f12319x = new ArrayList<>();

    /* renamed from: y */
    private List<BasicDataStreamBean> f12320y = new ArrayList();

    /* renamed from: z */
    private List<BasicDataStreamBean> f12321z = new ArrayList();

    /* renamed from: A */
    private boolean f12293A = false;

    /* renamed from: B */
    private SerializableMap f12294B = null;

    /* renamed from: C */
    private String f12295C = "";

    /* renamed from: F */
    private int f12298F = -1;

    /* renamed from: G */
    private RemotePerformClick.InterfaceC1789d f12299G = new C2169cm(this);

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

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder = this.f12305j;
        if (iDataStreamSelectionRecorder != null) {
            iDataStreamSelectionRecorder.mo6404a((IDataStreamSelector) null);
        }
        if (this.f12353d != null) {
            this.f12353d.mo7080l().f9483b = null;
        }
        CustomViewPager customViewPager = this.f12307l;
        if (customViewPager != null) {
            customViewPager.m14754a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    /* renamed from: a */
    private void m7137a() {
        View findViewById = getActivity().findViewById(R.id.btn_selectall);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.f12311p = (this.f12309n % this.f12314s == 0 ? 0 : 1) + (this.f12309n / this.f12314s);
        if (this.f12311p == 0) {
            this.f12311p = 1;
        }
        this.f12306k = (RelativeLayout) getActivity().findViewById(R.id.viewPager_layout);
        this.f12307l = (CustomViewPager) getActivity().findViewById(R.id.customviewPager);
        this.f12303h = (TextView) getActivity().findViewById(R.id.stand_value);
        this.f12296D = (ImageView) getActivity().findViewById(R.id.ds_right_arrow);
        this.f12297E = (ImageView) getActivity().findViewById(R.id.ds_left_arrow);
        this.f12296D.setOnClickListener(new View$OnClickListenerC2167ck(this));
        this.f12297E.setOnClickListener(new View$OnClickListenerC2168cl(this));
        if (this.f12303h != null) {
            if (this.f12295C.compareToIgnoreCase("1") == 0) {
                this.f12303h.setVisibility(0);
            } else {
                this.f12303h.setVisibility(8);
            }
        }
        m7135a(this.f12317v);
        this.f12306k.setVisibility(0);
        this.f12301f = (TextView) getActivity().findViewById(R.id.tv_page_number_current);
        this.f12302g = (TextView) getActivity().findViewById(R.id.tv_page_number_total);
        this.f12302g.setText(String.valueOf(this.f12311p));
        this.f12310o = this.f12312q * this.f12313r;
        if (this.f12318w.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM) || this.f12309n < DiagnoseConstants.DATASTREAM_PAGE) {
            this.f12310o = 0;
        }
        this.f12298F = this.f12310o;
        this.f12301f.setText(String.valueOf(this.f12298F + 1));
    }

    /* renamed from: a */
    private void m7135a(String str) {
        this.f12353d.mo7083i().setDataStreamJumpType(0);
        this.f12319x.clear();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f12311p; i++) {
            ListView listView = new ListView(getActivity());
            listView.setOnItemClickListener(this);
            DataStreamShowListAdapter dataStreamShowListAdapter = new DataStreamShowListAdapter(str, getActivity());
            dataStreamShowListAdapter.f11295b = this.f12295C;
            listView.setAdapter((ListAdapter) dataStreamShowListAdapter);
            this.f12319x.add(dataStreamShowListAdapter);
            arrayList.add(listView);
        }
        this.f12308m = new ViewPagerAdapter(arrayList);
        CustomViewPager customViewPager = this.f12307l;
        if (customViewPager != null) {
            customViewPager.setAdapter(this.f12308m);
        }
    }

    /* renamed from: a */
    private void m7134a(List<BasicDataStreamBean> list, SerializableMap serializableMap) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (this.f12318w.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM) && this.f12353d.mo7083i().isDatastreamRecord() && list.size() != this.f12353d.mo7083i().getDataStreamCount()) {
            return;
        }
        if (!this.f12318w.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM) || this.f12353d.mo7083i().isDatastreamRecord() || this.f12353d.mo7083i().getDataStreamCount() <= DiagnoseConstants.DATASTREAM_PAGE || list.size() != this.f12353d.mo7083i().getDataStreamCount()) {
            int i = this.f12310o;
            if (!this.f12353d.mo7083i().isDatastreamRecord() && this.f12318w.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
                i = this.f12310o % this.f12313r;
            }
            ArrayList<BasicDataStreamBean> arrayList = new ArrayList<>();
            int i2 = this.f12314s;
            int i3 = i * i2;
            int i4 = (i * i2) + i2;
            int size = list.size();
            int i5 = this.f12314s;
            if (size < i5) {
                i4 = (i * i5) + list.size();
            }
            try {
                arrayList.addAll(list.subList(i3, i4));
            } catch (IndexOutOfBoundsException unused) {
                i4 = list.size();
                try {
                    arrayList.addAll(list.subList(i3, i4));
                } catch (Exception unused2) {
                    arrayList.addAll(list.subList(0, i4));
                }
            }
            m7130a(i3, i4 - i3);
            this.f12319x.get(this.f12310o).f11296c = serializableMap;
            if (this.f12319x.size() < this.f12310o || arrayList.size() <= 0) {
                return;
            }
            this.f12319x.get(this.f12310o).m7517a(arrayList);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        if (this.f12318w.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            if (!this.f12353d.mo7083i().isDatastreamRecord()) {
                i2 = (this.f12310o % this.f12313r) * this.f12314s;
            } else {
                i2 = this.f12310o * this.f12314s;
            }
        } else {
            i2 = this.f12310o * this.f12314s;
        }
        this.f12319x.get(this.f12310o).m7520a(i);
        this.f12316u = this.f12319x.get(this.f12310o).f11294a;
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder = this.f12305j;
        if (iDataStreamSelectionRecorder != null) {
            iDataStreamSelectionRecorder.mo6399a(this.f12304i.m7521a());
            this.f12305j.mo6396b(i2 + this.f12316u);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6296a(long j, List<ArrayList<BasicDataStreamBean>> list, List<BasicDataStreamBean> list2, SerializableMap serializableMap) {
        List<BasicDataStreamBean> list3;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        if (this.f12318w.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM) && (list3 = this.f12321z) != null && list3.size() != list2.size()) {
            this.f12321z.clear();
            this.f12309n = list2.size();
            m7137a();
            this.f12321z.addAll(list2);
            return;
        }
        if (this.f12293A && this.f12320y != null) {
            if (list2.size() != this.f12320y.size()) {
                this.f12320y = list2;
                m7134a(list2, serializableMap);
                this.f12293A = false;
                return;
            }
            if (!this.f12353d.mo7083i().isDatastreamRecord()) {
                int i = 0;
                while (true) {
                    if (i < list2.size()) {
                        if (list2.get(i).getTitle().equals(this.f12320y.get(i).getTitle()) && list2.get(i).getUnit().equals(this.f12320y.get(i).getUnit()) && list2.get(i).getHelp().equals(this.f12320y.get(i).getHelp())) {
                            this.f12293A = true;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (this.f12293A) {
                    m7129a(getString(R.string.custom_diaglog_title), getString(R.string.custom_diaglog_message));
                }
            }
            this.f12293A = false;
        }
        this.f12320y = list2;
        this.f12294B = serializableMap;
        m7134a(list2, serializableMap);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector
    /* renamed from: a */
    public final void mo6310a(IDataStreamSelectionRecorder iDataStreamSelectionRecorder) {
        this.f12305j = iDataStreamSelectionRecorder;
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder2 = this.f12305j;
        if (iDataStreamSelectionRecorder2 != null) {
            iDataStreamSelectionRecorder2.mo6404a(this);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector
    /* renamed from: a */
    public final void mo6308a(boolean z) {
        this.f12304i.m7516a(z);
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder = this.f12305j;
        if (iDataStreamSelectionRecorder != null) {
            iDataStreamSelectionRecorder.mo6399a(this.f12304i.m7521a());
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        CustomViewPager customViewPager = this.f12307l;
        if (customViewPager != null) {
            customViewPager.m14754a();
            this.f12307l.m14742a(this);
            int currentItem = this.f12307l.getCurrentItem();
            int i = this.f12298F;
            if (i != -1 && currentItem != i) {
                this.f12307l.setCurrentItem(i);
            }
            this.f12298F = -1;
            if (this.f12307l.getCurrentItem() == 0) {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(1);
            } else {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(2);
            }
        }
        ArrayList<DataStreamShowListAdapter> arrayList = this.f12319x;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<DataStreamShowListAdapter> it = this.f12319x.iterator();
        while (it.hasNext()) {
            it.next().m7515b();
        }
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        this.f12301f.setText(String.valueOf(i + 1));
        this.f12310o = i;
        this.f12316u = -1;
        DataStreamShowListAdapter dataStreamShowListAdapter = this.f12319x.get(this.f12310o);
        dataStreamShowListAdapter.f11294a = this.f12316u;
        dataStreamShowListAdapter.notifyDataSetChanged();
        this.f12305j.mo6396b(this.f12316u);
        if (i == 0) {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        }
        if (this.f12318w.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            int i2 = this.f12312q;
            int i3 = this.f12313r;
            if (i2 < i / i3) {
                if (!this.f12353d.mo7083i().isDatastreamRecord()) {
                    m7129a(getString(R.string.custom_diaglog_title), getString(R.string.custom_diaglog_message));
                    this.f12293A = true;
                }
            } else if (i2 > i / i3 && !this.f12353d.mo7083i().isDatastreamRecord()) {
                m7129a(getString(R.string.custom_diaglog_title), getString(R.string.custom_diaglog_message));
                this.f12293A = true;
            }
            if (this.f12353d != null) {
                int i4 = this.f12313r;
                int i5 = i / i4;
                int i6 = this.f12312q;
                if (i5 != i6) {
                    String str = i6 < i / i4 ? "8" : "9";
                    this.f12312q = i / this.f12313r;
                    this.f12353d.mo7092a(DiagnoseConstants.FEEDBACK_DATASTREAM_PAGE, str, this.f12312q, 4);
                }
            }
        } else {
            this.f12312q = i / this.f12313r;
        }
        m7134a(this.f12320y, this.f12294B);
        m7126c(this.f12312q);
        if (this.f12353d == null || this.f12353d.mo7083i().getDiagnoseStatue() != 1) {
            return;
        }
        this.f12353d.mo7092a("special_cmd", "scroll_page", i, 22);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12317v = arguments.getString("DataStreamMask");
            this.f12318w = arguments.getString("DataStreamShow_Type");
            this.f12312q = arguments.getInt("DataStreamCurPage");
            this.f12309n = arguments.getInt("DataStreamCount");
            this.f12295C = arguments.getString("DataStreamShow_HaveValueStatus");
            if (this.f12295C == null) {
                this.f12295C = "";
            }
            this.f12304i = new DataStreamShowListAdapter(this.f12317v, getActivity());
            this.f12304i.f11295b = this.f12295C;
        }
        this.f12313r = DataStreamConfiguration.m7956c();
        this.f12314s = DataStreamConfiguration.m7960a();
        this.f12315t = DataStreamConfiguration.m7957b();
        m7137a();
        if (this.f12310o == 0) {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
        }
        if (this.f12353d != null) {
            this.f12353d.mo7080l().f9483b = this.f12299G;
        }
        super.onActivityCreated(bundle);
    }
}
