package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.diagnose.p218a.GraphViewAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p221d.GraphGridFragment;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.p210a.DataStreamConfiguration;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p280b.MeasureConversion;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.n */
/* loaded from: classes.dex */
public final class GridGraphPage extends GraphPage implements AdapterView.OnItemClickListener {

    /* renamed from: e */
    public GraphViewAdapter f11765e;

    /* renamed from: f */
    private String f11766f;

    /* renamed from: g */
    private GridView f11767g;

    /* renamed from: h */
    private Context f11768h;

    /* renamed from: i */
    private InterfaceC2097a f11769i;

    /* compiled from: GridGraphPage.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.n$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2097a {
        /* renamed from: a */
        void mo6319a(int i, int i2, List<BasicDataStreamBean> list);
    }

    public GridGraphPage(Context context, int i, int i2, int i3, InterfaceC2097a interfaceC2097a, String str) {
        super(i, i2, i3);
        int i4;
        this.f11766f = "";
        this.f11767g = new GridView(context);
        this.f11767g.setOnItemClickListener(this);
        this.f11769i = interfaceC2097a;
        this.f11768h = context;
        this.f11766f = str;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int i5 = displayMetrics.widthPixels;
        int i6 = displayMetrics.heightPixels - 200;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.graph_item_layout_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.graph_item_layout_height) - 20;
        int m7954e = DataStreamConfiguration.m7954e();
        if (this.f11763c >= DataStreamConfiguration.m7954e()) {
            i5 = dimensionPixelSize;
            i4 = m7954e;
        } else if (this.f11763c < 4) {
            i4 = 1;
            int i7 = 0;
            if (this.f11766f.equalsIgnoreCase("MaxGo")) {
                i7 = 10;
            } else if (this.f11766f.equalsIgnoreCase("ScanPad071") || this.f11766f.equalsIgnoreCase("X431Pro")) {
                i7 = 110;
            }
            dimensionPixelSize2 = ((i6 / this.f11763c) - (resources.getDimensionPixelSize(R.dimen.textsize_normal_M) / 2)) - i7;
        } else {
            i5 /= 2;
            dimensionPixelSize2 = (i6 / 2) - (resources.getDimensionPixelSize(R.dimen.textsize_normal_M) / 2);
            i4 = 2;
        }
        this.f11767g.setNumColumns(i4);
        this.f11767g.setColumnWidth(i5);
        this.f11767g.setPadding(resources.getInteger(R.integer.graph_padding_left), resources.getInteger(R.integer.graph_padding_top), resources.getInteger(R.integer.graph_padding_right), resources.getInteger(R.integer.graph_padding_bottom));
        this.f11767g.setHorizontalSpacing(resources.getInteger(R.integer.graph_HorizontalSpacing));
        this.f11767g.setVerticalSpacing(resources.getInteger(R.integer.graph_VerticalSpacing));
        this.f11765e = new GraphViewAdapter(context, i5, dimensionPixelSize2);
        this.f11767g.setAdapter((ListAdapter) this.f11765e);
        this.f11765e.f11358c = this;
    }

    /* renamed from: a */
    public final void m7374a() {
        GraphViewAdapter graphViewAdapter = this.f11765e;
        if (graphViewAdapter != null) {
            graphViewAdapter.f11360e = true;
        }
    }

    /* renamed from: a */
    public final void m7369a(boolean z) {
        GraphViewAdapter graphViewAdapter = this.f11765e;
        if (graphViewAdapter != null) {
            graphViewAdapter.f11362g = z;
            if (z) {
                return;
            }
            graphViewAdapter.f11361f.clear();
        }
    }

    /* renamed from: b */
    public final ArrayList<Integer> m7368b() {
        GraphViewAdapter graphViewAdapter = this.f11765e;
        if (graphViewAdapter != null) {
            return graphViewAdapter.f11361f;
        }
        return null;
    }

    /* renamed from: g */
    public final void m7365g() {
        GraphViewAdapter graphViewAdapter = this.f11765e;
        if (graphViewAdapter != null) {
            graphViewAdapter.f11359d = true;
            this.f11767g.setOnItemClickListener(null);
        }
    }

    /* renamed from: a */
    public final void m7370a(List<ArrayList<BasicDataStreamBean>> list, long j, SerializableMap serializableMap) {
        if (list == null) {
            return;
        }
        if (list.size() >= this.f11762b + this.f11763c) {
            list = list.subList(this.f11762b, this.f11762b + this.f11763c);
            this.f11764d = this.f11762b;
        }
        MeasureConversion.m5099a(C2744aa.m5158d(this.f11768h), list.get(0));
        this.f11765e.f11357b = GraphGridFragment.m7128b();
        GraphViewAdapter graphViewAdapter = this.f11765e;
        graphViewAdapter.f11363h = serializableMap;
        graphViewAdapter.m7491a(list, j);
    }

    /* renamed from: a */
    public final void m7371a(List<ArrayList<BasicDataStreamBean>> list, long j, int i, int i2, boolean z, SerializableMap serializableMap) {
        List<ArrayList<BasicDataStreamBean>> m7372a;
        if (list == null) {
            NLog.m9456a("GridGraphPage", "updatePageDataStream - No data come.................");
            return;
        }
        new ArrayList();
        try {
            m7372a = m7372a(list, i, i2, i / i2 > this.f11761a ? i2 : i - (this.f11761a * i2), z);
        } catch (IndexOutOfBoundsException unused) {
            try {
                m7372a = m7372a(list, i, i2, list.size(), z);
            } catch (Exception unused2) {
                NLog.m9456a("GridGraphPage", "updatePageDataStream - Get Current page data error.................");
                return;
            }
        }
        if (m7372a == null) {
            return;
        }
        new ArrayList();
        if (this.f11762b + this.f11763c > m7372a.size()) {
            return;
        }
        List<ArrayList<BasicDataStreamBean>> subList = m7372a.subList(this.f11762b, this.f11762b + this.f11763c);
        MeasureConversion.m5099a(C2744aa.m5158d(this.f11768h), subList.get(0));
        this.f11765e.f11357b = GraphGridFragment.m7128b();
        GraphViewAdapter graphViewAdapter = this.f11765e;
        graphViewAdapter.f11363h = serializableMap;
        graphViewAdapter.m7491a(subList, j);
    }

    /* renamed from: a */
    public final void m7373a(int i) {
        List<BasicDataStreamBean> item = this.f11765e.getItem(i);
        InterfaceC2097a interfaceC2097a = this.f11769i;
        if (interfaceC2097a == null || item == null) {
            return;
        }
        interfaceC2097a.mo6319a(this.f11762b, i, item);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        InterfaceC2097a interfaceC2097a;
        List<BasicDataStreamBean> item = this.f11765e.getItem(i);
        if (item == null || item.isEmpty() || (interfaceC2097a = this.f11769i) == null) {
            return;
        }
        interfaceC2097a.mo6319a(this.f11762b, i, item);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.GraphPage
    /* renamed from: f */
    public final void mo7366f() {
        GridView gridView = this.f11767g;
        if (gridView != null) {
            gridView.setOnItemClickListener(null);
        }
        if (this.f11769i != null) {
            this.f11769i = null;
        }
        GraphViewAdapter graphViewAdapter = this.f11765e;
        if (graphViewAdapter != null) {
            if (graphViewAdapter.f11356a != null) {
                graphViewAdapter.f11356a.clear();
                graphViewAdapter.f11356a = null;
            }
            this.f11765e = null;
        }
    }

    /* renamed from: a */
    private List<ArrayList<BasicDataStreamBean>> m7372a(List<ArrayList<BasicDataStreamBean>> list, int i, int i2, int i3, boolean z) {
        int i4 = this.f11761a;
        int size = list.size();
        if (z) {
            if (size == i3) {
                this.f11764d = m7375e();
                return list.subList(0, i3);
            } else if (i == size) {
                int i5 = i4 * i2;
                this.f11764d = i5;
                return list.subList(i5, i3 + i5);
            } else {
                return null;
            }
        } else if (size == i) {
            int i6 = i4 * i2;
            this.f11764d = i6;
            return list.subList(i6, i3 + i6);
        } else if (size == i3) {
            this.f11764d = m7375e();
            return list.subList(0, i3);
        } else {
            return null;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.GraphPage
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ View mo7367c() {
        return this.f11767g;
    }
}
