package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p012v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.diagnose.p218a.GraphPagerAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p220c.CombinedGraphPage;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.u */
/* loaded from: classes.dex */
public class CombinedGraphFragment extends BaseDataStreamShowingFragment implements ViewPager.InterfaceC0176e {

    /* renamed from: g */
    private static int f12385g = 15;

    /* renamed from: r */
    private static Boolean f12386r = Boolean.FALSE;

    /* renamed from: f */
    List<ArrayList<BasicDataStreamBean>> f12389f;

    /* renamed from: l */
    private ViewPager f12394l;

    /* renamed from: n */
    private TextView f12396n;

    /* renamed from: o */
    private TextView f12397o;

    /* renamed from: p */
    private String f12398p;

    /* renamed from: q */
    private int f12399q;

    /* renamed from: s */
    private int f12400s;

    /* renamed from: u */
    private List<BasicDataStreamBean> f12402u;

    /* renamed from: w */
    private ImageView f12404w;

    /* renamed from: x */
    private ImageView f12405x;

    /* renamed from: h */
    private int f12390h = 0;

    /* renamed from: i */
    private int f12391i = 0;

    /* renamed from: j */
    private ArrayList<Integer> f12392j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<ArrayList<BasicDataStreamBean>> f12393k = new ArrayList<>();

    /* renamed from: m */
    private Map<Integer, CombinedGraphPage> f12395m = new LinkedHashMap();

    /* renamed from: t */
    private int f12401t = 0;

    /* renamed from: v */
    private SerializableMap f12403v = null;

    /* renamed from: y */
    private int f12406y = -1;

    /* renamed from: z */
    private int f12407z = -1;

    /* renamed from: e */
    long f12388e = 0;

    /* renamed from: A */
    private RemotePerformClick.InterfaceC1789d f12387A = new C2183x(this);

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f12395m.clear();
        this.f12393k.clear();
        ArrayList<Integer> arrayList = this.f12392j;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (this.f12353d != null) {
            this.f12353d.mo7080l().f9483b = null;
        }
        ViewPager viewPager = this.f12394l;
        if (viewPager != null) {
            viewPager.m14754a();
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

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ViewPager viewPager = this.f12394l;
        if (viewPager != null) {
            viewPager.m14754a();
            this.f12394l.m14742a(this);
            int currentItem = this.f12394l.getCurrentItem();
            int i = this.f12406y;
            if (i != -1 && i != currentItem) {
                this.f12394l.setCurrentItem(i);
            }
            TextView textView = this.f12396n;
            if (textView != null) {
                textView.setText(String.valueOf(this.f12394l.getCurrentItem() + 1));
            }
            this.f12406y = -1;
            if (this.f12394l.getCurrentItem() == 0) {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(1);
            } else {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(2);
            }
        }
    }

    /* renamed from: a */
    public static void m7110a(boolean z) {
        synchronized (f12386r) {
            f12386r = Boolean.valueOf(z);
        }
    }

    /* renamed from: a */
    private static boolean m7113a() {
        boolean booleanValue;
        synchronized (f12386r) {
            booleanValue = f12386r.booleanValue();
        }
        return booleanValue;
    }

    /* renamed from: c */
    private void m7108c() {
        this.f12394l.setAdapter(new GraphPagerAdapter(this.f12395m));
        int i = f12385g;
        this.f12406y = this.f12400s * (i % 4 == 0 ? i / 4 : (i / 4) + 1);
    }

    /* renamed from: d */
    private void m7106d() {
        int i;
        int i2;
        int i3 = 0;
        if (!this.f12398p.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            int size = this.f12392j.size();
            this.f12391i = size % 4 > 0 ? (size / 4) + 1 : size / 4;
            int i4 = this.f12391i;
            int i5 = 0;
            while (i3 < i4) {
                int i6 = i3 + 1;
                int i7 = i4 == i6 ? size - (i3 * 4) : 4;
                CombinedGraphPage combinedGraphPage = new CombinedGraphPage(getActivity(), (i3 * 4) / f12385g, i5, i7);
                combinedGraphPage.m7410a();
                this.f12395m.put(Integer.valueOf(i3), combinedGraphPage);
                i5 += i7;
                i3 = i6;
            }
            return;
        }
        int i8 = this.f12399q;
        int i9 = f12385g;
        int i10 = i8 % i9;
        int i11 = (i9 / 4) + (i9 % 4 > 0 ? 1 : 0);
        int i12 = i10 % 4 > 0 ? (i10 / 4) + 1 : i10 / 4;
        int i13 = f12385g;
        this.f12390h = i8 / i13;
        this.f12390h += i8 % i13 > 0 ? 1 : 0;
        if (i12 > 0) {
            this.f12391i = ((this.f12390h - 1) * i11) + i12;
        } else {
            this.f12391i = this.f12390h * i11;
        }
        if (i12 <= 0 && i10 <= 0) {
            if (i10 == 0 && i12 == 0) {
                int i14 = 0;
                int i15 = 0;
                while (i14 < this.f12390h) {
                    int i16 = i15;
                    int i17 = 0;
                    int i18 = 0;
                    while (i17 < i11) {
                        i17++;
                        if (i11 == i17) {
                            int i19 = f12385g;
                            i2 = i19 % 4 > 0 ? i19 % 4 : 4;
                        } else {
                            i2 = 4;
                        }
                        CombinedGraphPage combinedGraphPage2 = new CombinedGraphPage(getActivity(), i14, i18, i2);
                        combinedGraphPage2.m7410a();
                        this.f12395m.put(Integer.valueOf(i16), combinedGraphPage2);
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
        int i20 = 0;
        int i21 = 0;
        while (i20 < this.f12390h - 1) {
            int i22 = i21;
            int i23 = 0;
            int i24 = 0;
            while (i23 < i11) {
                i23++;
                if (i11 == i23) {
                    int i25 = f12385g;
                    i = i25 % 4 > 0 ? i25 % 4 : 4;
                } else {
                    i = 4;
                }
                CombinedGraphPage combinedGraphPage3 = new CombinedGraphPage(getActivity(), i20, i24, i);
                combinedGraphPage3.m7410a();
                this.f12395m.put(Integer.valueOf(i22), combinedGraphPage3);
                i24 += i;
                i22++;
            }
            i20++;
            i21 = i22;
        }
        int i26 = 0;
        while (i3 < i12) {
            int i27 = i3 + 1;
            int i28 = i12 == i27 ? i10 - (i3 * 4) : 4;
            CombinedGraphPage combinedGraphPage4 = new CombinedGraphPage(getActivity(), this.f12390h - 1, i26, i28);
            combinedGraphPage4.m7410a();
            this.f12395m.put(Integer.valueOf(i21), combinedGraphPage4);
            i26 += i28;
            i3 = i27;
            i21++;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_combined_graph, viewGroup, false);
    }

    /* renamed from: e */
    private void m7105e() {
        this.f12353d.mo7083i().setDataStreamJumpType(2);
        this.f12394l = (ViewPager) getActivity().findViewById(R.id.combinedGraphContainer);
        this.f12396n = (TextView) getActivity().findViewById(R.id.tv_page_number_current);
        this.f12397o = (TextView) getActivity().findViewById(R.id.tv_page_number_total);
        if (this.f12394l == null || this.f12396n == null || this.f12397o == null) {
            return;
        }
        this.f12404w = (ImageView) getActivity().findViewById(R.id.ds_right_arrow);
        this.f12405x = (ImageView) getActivity().findViewById(R.id.ds_left_arrow);
        this.f12404w.setOnClickListener(new View$OnClickListenerC2181v(this));
        this.f12405x.setOnClickListener(new View$OnClickListenerC2182w(this));
        this.f12397o.setText(String.valueOf(this.f12391i));
    }

    /* renamed from: a */
    private void m7111a(List<ArrayList<BasicDataStreamBean>> list, long j, boolean z) {
        for (CombinedGraphPage combinedGraphPage : this.f12395m.values()) {
            if (combinedGraphPage.f11761a == this.f12400s) {
                combinedGraphPage.m7403a(list, j, this.f12399q, f12385g, z, this.f12403v);
            }
        }
        CombinedGraphPage combinedGraphPage2 = this.f12395m.get(Integer.valueOf(this.f12401t));
        if (combinedGraphPage2 != null) {
            m7130a(combinedGraphPage2.f11764d, combinedGraphPage2.m7376d());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6296a(long j, List<ArrayList<BasicDataStreamBean>> list, List<BasicDataStreamBean> list2, SerializableMap serializableMap) {
        List<BasicDataStreamBean> list3;
        if (list == null || list.size() <= 0 || list2 == null || list2.size() <= 0) {
            return;
        }
        if (this.f12398p.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM) && ((list3 = this.f12402u) == null || (list3 != null && list3.size() != list2.size()))) {
            this.f12399q = list.size();
            this.f12391i = (this.f12399q % 4 == 0 ? 0 : 1) + (this.f12399q / 4);
            this.f12395m.clear();
            int i = this.f12391i;
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i2 + 1;
                int i5 = i == i4 ? this.f12399q - (i2 * 4) : 4;
                CombinedGraphPage combinedGraphPage = new CombinedGraphPage(getActivity(), (i2 * 4) / f12385g, i3, i5);
                combinedGraphPage.m7410a();
                this.f12395m.put(Integer.valueOf(i2), combinedGraphPage);
                i3 += i5;
                i2 = i4;
            }
            this.f12397o.setText(String.valueOf(this.f12391i));
            this.f12396n.setText("1");
            this.f12401t = 0;
            m7108c();
        }
        if (this.f12402u == null) {
            this.f12402u = list2;
        }
        if (!this.f12398p.equals(DiagnoseConstants.UI_TYPE_PAGE_DATASTREAM)) {
            ArrayList arrayList = new ArrayList(this.f12392j.size());
            int size = this.f12392j.size();
            if (this.f12398p.equals("ActiveTest") || this.f12398p.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
                list.size();
                arrayList.addAll(list);
            } else {
                for (int i6 = 0; i6 < size; i6++) {
                    arrayList.add(list.get(this.f12392j.get(i6).intValue()));
                }
            }
            this.f12388e = j;
            this.f12389f = arrayList;
            int i7 = this.f12401t;
            int i8 = this.f12401t;
            int i9 = i8 + 1;
            int i10 = this.f12391i;
            if (i9 <= i10) {
                i10 = i8 + 1;
            }
            for (int i11 = i7 + (-2) > 0 ? i7 - 2 : 0; i11 < i10; i11++) {
                this.f12395m.get(Integer.valueOf(i11)).m7402a(arrayList, j, serializableMap);
            }
            CombinedGraphPage combinedGraphPage2 = this.f12395m.get(Integer.valueOf(this.f12401t));
            if (combinedGraphPage2 != null) {
                m7130a(combinedGraphPage2.m7375e(), combinedGraphPage2.m7376d());
            }
        } else {
            m7111a(list, j, m7113a());
        }
        this.f12402u = list2;
        this.f12403v = serializableMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x014e  */
    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo1774a(int r9) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.p221d.CombinedGraphFragment.mo1774a(int):void");
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getActivity().findViewById(R.id.combinedGraphContainer) == null) {
            return;
        }
        if (this.f12398p.equals(DiagnoseConstants.UI_TYPE_VW_DATASTREAM)) {
            int i = 0;
            this.f12391i = (this.f12399q % 4 == 0 ? 0 : 1) + (this.f12399q / 4);
            this.f12395m.clear();
            int i2 = this.f12391i;
            int i3 = 0;
            while (i < i2) {
                int i4 = i + 1;
                int i5 = i2 == i4 ? this.f12399q - (i * 4) : 4;
                this.f12395m.put(Integer.valueOf(i), new CombinedGraphPage(getActivity(), (i * 4) / f12385g, i3, i5));
                i3 += i5;
                i = i4;
            }
            this.f12397o.setText(String.valueOf(this.f12391i));
            this.f12396n.setText("1");
            m7108c();
        } else {
            m7106d();
            m7105e();
            m7108c();
        }
        int i6 = this.f12407z;
        ViewPager viewPager = this.f12394l;
        if (viewPager != null) {
            viewPager.m14754a();
            this.f12394l.m14742a(this);
            int currentItem = this.f12394l.getCurrentItem();
            if (i6 != -1 && i6 != currentItem) {
                this.f12394l.setCurrentItem(i6);
            }
            TextView textView = this.f12396n;
            if (textView != null) {
                textView.setText(String.valueOf(this.f12394l.getCurrentItem() + 1));
            }
            this.f12406y = -1;
            if (this.f12394l.getCurrentItem() == 0) {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(1);
            } else {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(2);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle arguments = getArguments();
        Log.d("Sanda", "CombineGraph initBundle" + arguments.toString());
        ArrayList<Integer> arrayList = this.f12392j;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (arguments != null) {
            String string = arguments.getString("DataStreamMask");
            for (int i = 0; i < string.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(string.charAt(i));
                if (sb.toString().equals("1")) {
                    this.f12392j.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < this.f12392j.size(); i2++) {
                this.f12393k.add(new ArrayList<>());
            }
            this.f12398p = arguments.getString("DataStreamShow_Type");
            this.f12400s = arguments.getInt("DataStreamCurPage");
            this.f12399q = arguments.getInt("DataStreamCount");
        }
        f12385g = DiagnoseConstants.DATASTREAM_PAGE;
        m7106d();
        m7105e();
        m7108c();
        if (this.f12353d != null) {
            this.f12353d.mo7080l().f9483b = this.f12387A;
        }
        super.onActivityCreated(bundle);
    }
}
