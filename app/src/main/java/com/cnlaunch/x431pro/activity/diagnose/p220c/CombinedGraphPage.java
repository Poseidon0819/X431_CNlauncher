package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.p112a.DataStreamGraphicalView;
import com.cnlaunch.p112a.p113a.AbstractChart;
import com.cnlaunch.p112a.p113a.CombineDataStreamChart;
import com.cnlaunch.p112a.p114b.XYMultipleSeriesDataset;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.XYMultipleSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYSeriesRenderer;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment;
import com.cnlaunch.x431pro.module.p252d.GraphConfiguration;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.DataStreamUpdatingUtils;
import com.cnlaunch.x431pro.utils.p280b.MeasureConversion;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.c */
/* loaded from: classes.dex */
public final class CombinedGraphPage extends GraphPage {

    /* renamed from: e */
    private static Paint.Align[] f11713e = {Paint.Align.LEFT, Paint.Align.LEFT, Paint.Align.RIGHT, Paint.Align.RIGHT};

    /* renamed from: f */
    private static Paint.Align[] f11714f = {Paint.Align.RIGHT, Paint.Align.LEFT, Paint.Align.RIGHT, Paint.Align.LEFT};

    /* renamed from: g */
    private XYMultipleSeriesRenderer f11715g;

    /* renamed from: h */
    private XYMultipleSeriesDataset f11716h;

    /* renamed from: i */
    private AbstractChart f11717i;

    /* renamed from: j */
    private Timer f11718j;

    /* renamed from: k */
    private TimerTask f11719k;

    /* renamed from: l */
    private Context f11720l;

    /* renamed from: m */
    private DataStreamGraphicalView f11721m;

    /* renamed from: n */
    private boolean f11722n;

    /* renamed from: a */
    public final void m7410a() {
        this.f11722n = true;
        if (this.f11722n) {
            DiagnoseGraphTouchUtil diagnoseGraphTouchUtil = new DiagnoseGraphTouchUtil();
            diagnoseGraphTouchUtil.f11755c = this.f11715g;
            diagnoseGraphTouchUtil.f11753a = 10.0f;
            this.f11721m.setOnTouchListener(diagnoseGraphTouchUtil);
        }
    }

    public CombinedGraphPage(Context context, int i, int i2, int i3) {
        super(i, i2, i3);
        this.f11722n = false;
        this.f11764d = i2;
        this.f11715g = new XYMultipleSeriesRenderer(this.f11763c);
        this.f11716h = new XYMultipleSeriesDataset();
        this.f11717i = new CombineDataStreamChart(this.f11715g, this.f11716h);
        this.f11720l = context;
        this.f11721m = new DataStreamGraphicalView(context, this.f11717i);
        this.f11718j = new Timer();
        this.f11719k = new C2092d(this);
        m7408a(this.f11715g);
        m7399g();
    }

    /* renamed from: a */
    private void m7408a(XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        xYMultipleSeriesRenderer.setAntialiasing(true);
        xYMultipleSeriesRenderer.setBackgroundColor(0);
        xYMultipleSeriesRenderer.setApplyBackgroundColor(true);
        xYMultipleSeriesRenderer.setLegendTextSize(this.f11720l.getResources().getInteger(R.integer.combined_grap_LegendTextSize));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(this.f11720l.getResources().getInteger(R.integer.combined_grap_AxisTitleTextSize));
        xYMultipleSeriesRenderer.setChartTitleTextSize(this.f11720l.getResources().getInteger(R.integer.combined_grap_ChartTitleTextSize));
        xYMultipleSeriesRenderer.setLabelsTextSize(this.f11720l.getResources().getInteger(R.integer.combined_grap_LabelsTextSize));
        xYMultipleSeriesRenderer.setMargins(new int[]{this.f11720l.getResources().getInteger(R.integer.combined_grap_Margins_top), this.f11720l.getResources().getInteger(R.integer.combined_grap_Margins_left), this.f11720l.getResources().getInteger(R.integer.combined_grap_Margins_bottom), this.f11720l.getResources().getInteger(R.integer.combined_grap_Margins_right)});
        xYMultipleSeriesRenderer.setDynamicShowOverrideText(false);
        xYMultipleSeriesRenderer.setXAxisColor(Color.argb(this.f11720l.getResources().getInteger(R.integer.combined_graph_Xaxes_alpha), this.f11720l.getResources().getInteger(R.integer.combined_graph_Xaxes_red), this.f11720l.getResources().getInteger(R.integer.combined_graph_Xaxes_green), this.f11720l.getResources().getInteger(R.integer.combined_graph_Xaxes_blue)));
        xYMultipleSeriesRenderer.setAxesColor(-16777216);
        xYMultipleSeriesRenderer.setYAxisColor(-16777216);
        xYMultipleSeriesRenderer.setLabelsColor(-16777216);
        xYMultipleSeriesRenderer.setXLabelsColor(Color.argb(this.f11720l.getResources().getInteger(R.integer.combined_graph_XLables_alpha), this.f11720l.getResources().getInteger(R.integer.combined_graph_XLables_red), this.f11720l.getResources().getInteger(R.integer.combined_graph_XLables_green), this.f11720l.getResources().getInteger(R.integer.combined_graph_XLables_blue)));
        xYMultipleSeriesRenderer.setGridColor(Color.argb(this.f11720l.getResources().getInteger(R.integer.combined_graph_grid_alpha), this.f11720l.getResources().getInteger(R.integer.combined_graph_grid_red), this.f11720l.getResources().getInteger(R.integer.combined_graph_grid_green), this.f11720l.getResources().getInteger(R.integer.combined_graph_grid_blue)));
        xYMultipleSeriesRenderer.setXLabels(18);
        xYMultipleSeriesRenderer.setInnerXLabels(10);
        xYMultipleSeriesRenderer.setYLabels(6);
        xYMultipleSeriesRenderer.setYInnerLabels(5);
        xYMultipleSeriesRenderer.setYLabelsPadding(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        xYMultipleSeriesRenderer.setXLabelsAngle(this.f11720l.getResources().getInteger(R.integer.combined_grap_XLabelsAngle));
        xYMultipleSeriesRenderer.setShowGrid(true);
        xYMultipleSeriesRenderer.setYAxisMin(0.0d);
        xYMultipleSeriesRenderer.setYAxisMax(6.0d);
        xYMultipleSeriesRenderer.setXAxisMin(0.0d);
        GraphConfiguration.m5385a();
        xYMultipleSeriesRenderer.setXAxisMax(180.0d);
        xYMultipleSeriesRenderer.setXGridRange(GraphConfiguration.m5385a());
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        NumberFormat numberFormat2 = NumberFormat.getInstance();
        numberFormat2.setMaximumFractionDigits(0);
        xYMultipleSeriesRenderer.setXLabelFormat(numberFormat2);
        xYMultipleSeriesRenderer.setShowUnit(false);
        for (int i = 0; i < this.f11763c; i++) {
            int m5384a = GraphConfiguration.m5384a(i);
            XYSeriesRenderer xYSeriesRenderer = new XYSeriesRenderer();
            xYSeriesRenderer.setColor(m5384a);
            xYSeriesRenderer.setLineWidth(3.0f);
            xYMultipleSeriesRenderer.setYLabelFormat(numberFormat, i);
            xYMultipleSeriesRenderer.setYLabelsColor(i, m5384a);
            xYMultipleSeriesRenderer.setYAxisAlign(f11713e[i], i);
            xYMultipleSeriesRenderer.setYLabelsAlign(f11714f[i], i);
            xYMultipleSeriesRenderer.addSeriesRenderer(xYSeriesRenderer);
        }
    }

    /* renamed from: g */
    private void m7399g() {
        for (int i = 0; i < this.f11763c; i++) {
            this.f11716h.addSeries(new XYSeries(""));
        }
        new C2093e(this).start();
    }

    /* renamed from: a */
    private List<ArrayList<BasicDataStreamBean>> m7404a(List<ArrayList<BasicDataStreamBean>> list, int i, int i2, boolean z) {
        if (list == null) {
            NLog.m9456a("CombinedGraphPage", "updatePageDataStream - No data come.................");
            return null;
        }
        new ArrayList();
        try {
            return m7405a(list, i, i2, i / i2 > this.f11761a ? i2 : i - (this.f11761a * i2), z);
        } catch (IndexOutOfBoundsException unused) {
            try {
                return m7405a(list, i, i2, list.size(), z);
            } catch (Exception unused2) {
                NLog.m9456a("CombinedGraphPage", "updatePageDataStream - Get Current page data error.................");
                return null;
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m7402a(List<ArrayList<BasicDataStreamBean>> list, long j, SerializableMap serializableMap) {
        if (list != null) {
            if (list.size() >= this.f11762b + this.f11763c) {
                MeasureConversion.m5099a(C2744aa.m5158d(this.f11720l), list.get(0));
                for (int i = 0; i < this.f11763c; i++) {
                    XYSeries seriesAt = this.f11716h.getSeriesAt(i);
                    ArrayList<BasicDataStreamBean> arrayList = list.get(this.f11762b + i);
                    if (arrayList == null || arrayList.isEmpty()) {
                        break;
                    }
                    BasicDataStreamBean basicDataStreamBean = arrayList.get(arrayList.size() - 1);
                    m7407a(this.f11715g, seriesAt, i, basicDataStreamBean, serializableMap);
                    if (basicDataStreamBean.getUnit().isEmpty()) {
                        Map<String, Integer> yLabelMap = this.f11715g.getYLabelMap(i);
                        if (BaseDataStreamShowingFragment.m7128b()) {
                            yLabelMap.clear();
                        }
                        m7401a(yLabelMap, seriesAt, j, list.get(this.f11762b + i));
                        DataStreamUpdatingUtils.m4878a(this.f11715g, seriesAt, j, i);
                    } else {
                        double d = j;
                        m7409a(seriesAt, d, list.get(this.f11762b + i));
                        DataStreamUpdatingUtils.m4879a(this.f11715g, seriesAt, d, i);
                    }
                }
                this.f11721m.m9673a();
                return;
            }
        }
        NLog.m9451c("CombinedGraphPage", "The data size is not matched, size:" + list.size() + ", start index:" + this.f11762b + ", stream count:" + this.f11763c);
    }

    /* renamed from: a */
    public final synchronized void m7403a(List<ArrayList<BasicDataStreamBean>> list, long j, int i, int i2, boolean z, SerializableMap serializableMap) {
        new ArrayList();
        List<ArrayList<BasicDataStreamBean>> m7404a = m7404a(list, i, i2, z);
        if (m7404a != null && m7404a.size() >= this.f11762b + this.f11763c) {
            MeasureConversion.m5099a(C2744aa.m5158d(this.f11720l), m7404a.get(0));
            for (int i3 = 0; i3 < this.f11763c; i3++) {
                XYSeries seriesAt = this.f11716h.getSeriesAt(i3);
                ArrayList<BasicDataStreamBean> arrayList = m7404a.get(this.f11762b + i3);
                if (arrayList == null || arrayList.isEmpty()) {
                    break;
                }
                BasicDataStreamBean basicDataStreamBean = arrayList.get(arrayList.size() - 1);
                m7407a(this.f11715g, seriesAt, i3, basicDataStreamBean, serializableMap);
                if (basicDataStreamBean.getUnit().isEmpty()) {
                    Map<String, Integer> yLabelMap = this.f11715g.getYLabelMap(i3);
                    if (BaseDataStreamShowingFragment.m7128b()) {
                        yLabelMap.clear();
                    }
                    m7401a(yLabelMap, seriesAt, j, m7404a.get(this.f11762b + i3));
                    DataStreamUpdatingUtils.m4878a(this.f11715g, seriesAt, j, i3);
                } else {
                    double d = j;
                    m7409a(seriesAt, d, m7404a.get(this.f11762b + i3));
                    DataStreamUpdatingUtils.m4879a(this.f11715g, seriesAt, d, i3);
                }
            }
            this.f11721m.m9673a();
            return;
        }
        NLog.m9451c("CombinedGraphPage", "The data size is not matched, size:, start index:" + this.f11762b + ", stream count:" + this.f11763c);
    }

    /* renamed from: a */
    private void m7409a(XYSeries xYSeries, double d, List<BasicDataStreamBean> list) {
        double d2;
        int i;
        xYSeries.clear();
        int xGridRange = this.f11715g.getXGridRange();
        double d3 = xGridRange;
        if (d > d3) {
            Double.isNaN(d3);
            d2 = d - d3;
        } else {
            d2 = 0.0d;
        }
        int i2 = (int) d2;
        int size = list.size();
        for (int i3 = size > xGridRange ? size - xGridRange : 0; i3 < size; i3++) {
            if (list.get(i3).getDbValue().isNaN()) {
                xYSeries.add((i2 + i3) - i, 0.0d);
            } else {
                xYSeries.add((i2 + i3) - i, list.get(i3).getDbValue().doubleValue());
            }
        }
    }

    /* renamed from: a */
    private void m7401a(Map<String, Integer> map, XYSeries xYSeries, double d, List<BasicDataStreamBean> list) {
        double d2;
        int i;
        int xGridRange = this.f11715g.getXGridRange();
        xYSeries.clear();
        double d3 = xGridRange;
        boolean z = d > d3;
        int size = list.size();
        if (z) {
            Double.isNaN(d3);
            d2 = d - d3;
        } else {
            d2 = 0.0d;
        }
        int i2 = (int) d2;
        for (int i3 = size > xGridRange ? size - xGridRange : 0; i3 < size; i3++) {
            DataStreamUpdatingUtils.m4881a(xYSeries, map, (i2 + i3) - i, list.get(i3).getValue());
        }
    }

    /* renamed from: a */
    private static void m7407a(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, XYSeries xYSeries, int i, BasicDataStreamBean basicDataStreamBean, SerializableMap serializableMap) {
        String title;
        basicDataStreamBean.getTitle();
        if (serializableMap != null && serializableMap.getMap() != null) {
            title = !TextUtils.isEmpty(serializableMap.getMap().get(basicDataStreamBean.getTitle())) ? serializableMap.getMap().get(basicDataStreamBean.getTitle()) : basicDataStreamBean.getTitle();
        } else {
            title = basicDataStreamBean.getTitle();
        }
        String value = basicDataStreamBean.getValue();
        String unit = basicDataStreamBean.getUnit();
        xYSeries.setTitle(title.trim() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + value + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + unit);
        xYMultipleSeriesRenderer.setYTitle(unit, i);
    }

    /* renamed from: b */
    public final synchronized void m7400b() {
        for (int i = 0; i < this.f11716h.getSeriesCount(); i++) {
            this.f11716h.getSeriesAt(i).clear();
        }
        this.f11721m.m9673a();
        this.f11719k.cancel();
        this.f11717i.stopRefreshTimer();
    }

    /* renamed from: a */
    private List<ArrayList<BasicDataStreamBean>> m7405a(List<ArrayList<BasicDataStreamBean>> list, int i, int i2, int i3, boolean z) {
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
        return this.f11721m;
    }
}
