package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.p112a.DataStreamGraphicalView;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.DataStreamSeriesRenderer;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DiagnoseGraphTouchUtil;
import com.cnlaunch.x431pro.activity.diagnose.p220c.GridGraphPage;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.DataStreamUpdatingUtils;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.m */
/* loaded from: classes.dex */
public final class GraphViewAdapter extends BaseAdapter implements DiagnoseGraphTouchUtil.InterfaceC2096a {

    /* renamed from: p */
    private static String f11355p = new String();

    /* renamed from: c */
    public GridGraphPage f11358c;

    /* renamed from: h */
    public SerializableMap f11363h;

    /* renamed from: i */
    private LayoutInflater f11364i;

    /* renamed from: j */
    private Context f11365j;

    /* renamed from: k */
    private ViewGroup.LayoutParams f11366k;

    /* renamed from: l */
    private int f11367l;

    /* renamed from: m */
    private int f11368m;

    /* renamed from: q */
    private long f11371q;

    /* renamed from: b */
    public boolean f11357b = false;

    /* renamed from: d */
    public boolean f11359d = false;

    /* renamed from: e */
    public boolean f11360e = false;

    /* renamed from: f */
    public ArrayList<Integer> f11361f = new ArrayList<>();

    /* renamed from: g */
    public boolean f11362g = false;

    /* renamed from: n */
    private boolean f11369n = true;

    /* renamed from: o */
    private long f11370o = 0;

    /* renamed from: a */
    public List<ArrayList<BasicDataStreamBean>> f11356a = new ArrayList();

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    public GraphViewAdapter(Context context, int i, int i2) {
        this.f11365j = context;
        this.f11367l = i;
        this.f11364i = LayoutInflater.from(this.f11365j);
        this.f11366k = new ViewGroup.LayoutParams(-1, i2);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f11356a.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public final List<BasicDataStreamBean> getItem(int i) {
        if (this.f11356a.size() < i || this.f11356a.size() == 0) {
            return null;
        }
        return this.f11356a.get(i);
    }

    /* renamed from: b */
    private boolean m7490b(int i) {
        return this.f11361f.contains(Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0298 A[Catch: Exception -> 0x03f9, TryCatch #0 {Exception -> 0x03f9, blocks: (B:3:0x0006, B:5:0x000c, B:8:0x0014, B:10:0x0028, B:12:0x0030, B:14:0x003e, B:23:0x005b, B:25:0x0286, B:26:0x0294, B:28:0x0298, B:30:0x02a3, B:38:0x02d1, B:40:0x02e9, B:43:0x02f1, B:45:0x02f7, B:46:0x030a, B:48:0x030e, B:50:0x0316, B:52:0x0332, B:54:0x0367, B:56:0x03a5, B:59:0x03ad, B:60:0x03b1, B:61:0x03cf, B:53:0x0353, B:31:0x02ac, B:33:0x02b4, B:34:0x02bd, B:35:0x02c6, B:37:0x02ca, B:17:0x004a, B:19:0x004e, B:22:0x0053, B:63:0x03d4), top: B:67:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02c6 A[Catch: Exception -> 0x03f9, TryCatch #0 {Exception -> 0x03f9, blocks: (B:3:0x0006, B:5:0x000c, B:8:0x0014, B:10:0x0028, B:12:0x0030, B:14:0x003e, B:23:0x005b, B:25:0x0286, B:26:0x0294, B:28:0x0298, B:30:0x02a3, B:38:0x02d1, B:40:0x02e9, B:43:0x02f1, B:45:0x02f7, B:46:0x030a, B:48:0x030e, B:50:0x0316, B:52:0x0332, B:54:0x0367, B:56:0x03a5, B:59:0x03ad, B:60:0x03b1, B:61:0x03cf, B:53:0x0353, B:31:0x02ac, B:33:0x02b4, B:34:0x02bd, B:35:0x02c6, B:37:0x02ca, B:17:0x004a, B:19:0x004e, B:22:0x0053, B:63:0x03d4), top: B:67:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02e9 A[Catch: Exception -> 0x03f9, TryCatch #0 {Exception -> 0x03f9, blocks: (B:3:0x0006, B:5:0x000c, B:8:0x0014, B:10:0x0028, B:12:0x0030, B:14:0x003e, B:23:0x005b, B:25:0x0286, B:26:0x0294, B:28:0x0298, B:30:0x02a3, B:38:0x02d1, B:40:0x02e9, B:43:0x02f1, B:45:0x02f7, B:46:0x030a, B:48:0x030e, B:50:0x0316, B:52:0x0332, B:54:0x0367, B:56:0x03a5, B:59:0x03ad, B:60:0x03b1, B:61:0x03cf, B:53:0x0353, B:31:0x02ac, B:33:0x02b4, B:34:0x02bd, B:35:0x02c6, B:37:0x02ca, B:17:0x004a, B:19:0x004e, B:22:0x0053, B:63:0x03d4), top: B:67:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x03a5 A[Catch: Exception -> 0x03f9, TryCatch #0 {Exception -> 0x03f9, blocks: (B:3:0x0006, B:5:0x000c, B:8:0x0014, B:10:0x0028, B:12:0x0030, B:14:0x003e, B:23:0x005b, B:25:0x0286, B:26:0x0294, B:28:0x0298, B:30:0x02a3, B:38:0x02d1, B:40:0x02e9, B:43:0x02f1, B:45:0x02f7, B:46:0x030a, B:48:0x030e, B:50:0x0316, B:52:0x0332, B:54:0x0367, B:56:0x03a5, B:59:0x03ad, B:60:0x03b1, B:61:0x03cf, B:53:0x0353, B:31:0x02ac, B:33:0x02b4, B:34:0x02bd, B:35:0x02c6, B:37:0x02ca, B:17:0x004a, B:19:0x004e, B:22:0x0053, B:63:0x03d4), top: B:67:0x0006 }] */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r17, android.view.View r18, android.view.ViewGroup r19) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.p218a.GraphViewAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: a */
    private static String m7492a(String str, String str2, float f, Paint paint) {
        int length = str.length();
        int i = 0;
        String str3 = str;
        while (true) {
            if (paint.measureText(str3 + str2) <= f || i >= length) {
                break;
            }
            i++;
            str3 = str.substring(0, length - i) + "...";
        }
        if (i == length) {
            str3 = "...";
        }
        return str3 + str2;
    }

    /* renamed from: a */
    private void m7495a(XYSeries xYSeries, List<BasicDataStreamBean> list, int i) {
        int i2;
        long j = i;
        int i3 = (int) ((this.f11370o > j ? 1 : (this.f11370o == j ? 0 : -1)) > 0 ? this.f11370o - j : 0L);
        int size = list.size();
        for (int i4 = size > i ? size - i : 0; i4 < size; i4++) {
            Double dbValue = list.get(i4).getDbValue();
            if (dbValue.isNaN()) {
                xYSeries.add((i3 + i4) - i2, 0.0d);
            } else {
                xYSeries.add((i3 + i4) - i2, dbValue.doubleValue());
            }
        }
    }

    /* renamed from: a */
    private void m7494a(C2024a c2024a, List<BasicDataStreamBean> list) {
        int i;
        int xGridRange = c2024a.f11374c.getXGridRange();
        long j = xGridRange;
        boolean z = this.f11370o > j;
        c2024a.f11375d.clear();
        Map<String, Integer> yLabelMap = c2024a.f11374c.getYLabelMap();
        if (this.f11357b) {
            yLabelMap.clear();
        }
        int i2 = (int) (z ? this.f11370o - j : 0L);
        int size = list.size();
        for (int i3 = size > xGridRange ? size - xGridRange : 0; i3 < list.size(); i3++) {
            DataStreamUpdatingUtils.m4881a(c2024a.f11375d, yLabelMap, (i2 + i3) - i, list.get(i3).getValue());
        }
        DataStreamUpdatingUtils.m4877b(c2024a.f11374c, c2024a.f11375d, this.f11370o);
        c2024a.f11373b.m9673a();
    }

    /* renamed from: a */
    public final void m7491a(List<ArrayList<BasicDataStreamBean>> list, long j) {
        if (!this.f11360e) {
            int m5158d = C2744aa.m5158d(this.f11365j);
            if (this.f11371q != 0 && this.f11368m == m5158d && System.currentTimeMillis() - this.f11371q < 1000) {
                return;
            }
            if (this.f11368m != m5158d) {
                this.f11368m = m5158d;
            }
            this.f11371q = System.currentTimeMillis();
        }
        this.f11370o = j;
        this.f11356a.clear();
        BasicDataStreamBean.currconversionType = C2744aa.m5158d(this.f11365j);
        this.f11356a.addAll(list);
        if (this.f11369n) {
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GraphViewAdapter.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.m$a */
    /* loaded from: classes.dex */
    public class C2024a {

        /* renamed from: a */
        LinearLayout f11372a;

        /* renamed from: b */
        DataStreamGraphicalView f11373b;

        /* renamed from: c */
        DataStreamSeriesRenderer f11374c;

        /* renamed from: d */
        XYSeries f11375d;

        /* renamed from: e */
        TextView f11376e;

        /* renamed from: f */
        TextView f11377f;

        /* renamed from: g */
        String f11378g;

        /* renamed from: h */
        TextView f11379h;

        /* renamed from: i */
        int f11380i = -1;

        /* renamed from: j */
        long f11381j = -1;

        C2024a() {
        }
    }

    /* renamed from: a */
    public final synchronized void m7497a() {
        this.f11356a.clear();
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public static void m7493a(String str) {
        synchronized (f11355p) {
            f11355p = str;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DiagnoseGraphTouchUtil.InterfaceC2096a
    /* renamed from: a */
    public final void mo7340a(View view) {
        this.f11369n = true;
        int i = ((C2024a) view.getTag()).f11380i;
        if (!this.f11362g) {
            GridGraphPage gridGraphPage = this.f11358c;
            if (gridGraphPage != null) {
                gridGraphPage.m7373a(i);
            }
        } else if (m7490b(i)) {
            this.f11361f.remove(Integer.valueOf(i));
            notifyDataSetChanged();
        } else if (this.f11361f.size() == 4) {
            NToast.m9450a(this.f11365j, (int) R.string.graph_over_limit);
        } else {
            this.f11361f.add(Integer.valueOf(i));
            notifyDataSetChanged();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DiagnoseGraphTouchUtil.InterfaceC2096a
    /* renamed from: a */
    public final void mo7337a(boolean z) {
        this.f11369n = !z;
    }
}
