package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.p112a.DataStreamGraphicalView;
import com.cnlaunch.p112a.p113a.AbstractChart;
import com.cnlaunch.p112a.p114b.XYMultipleSeriesDataset;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.XYMultipleSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYSeriesRenderer;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment;
import com.cnlaunch.x431pro.module.p252d.GraphConfiguration;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.DataStreamUpdatingUtils;
import com.cnlaunch.x431pro.utils.p280b.MeasureConversion;
import com.itextpdf.text.pdf.ColumnText;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.f */
/* loaded from: classes.dex */
public final class CustomCombinedGrapPage {

    /* renamed from: k */
    private static Paint.Align[] f11725k = {Paint.Align.LEFT, Paint.Align.LEFT, Paint.Align.RIGHT, Paint.Align.RIGHT};

    /* renamed from: l */
    private static Paint.Align[] f11726l = {Paint.Align.RIGHT, Paint.Align.LEFT, Paint.Align.RIGHT, Paint.Align.LEFT};

    /* renamed from: a */
    public int f11727a;

    /* renamed from: b */
    public XYMultipleSeriesRenderer f11728b;

    /* renamed from: c */
    public XYMultipleSeriesDataset f11729c;

    /* renamed from: d */
    public AbstractChart f11730d;

    /* renamed from: e */
    public Timer f11731e;

    /* renamed from: f */
    public TimerTask f11732f;

    /* renamed from: g */
    public Context f11733g;

    /* renamed from: h */
    public DataStreamGraphicalView f11734h;

    /* renamed from: i */
    public boolean f11735i = false;

    /* renamed from: j */
    public RelativeLayout f11736j;

    public CustomCombinedGrapPage(Context context, RelativeLayout relativeLayout) {
        this.f11733g = context;
        this.f11736j = relativeLayout;
    }

    /* renamed from: a */
    public final boolean m7398a() {
        return this.f11736j.getVisibility() == 0;
    }

    /* renamed from: a */
    public final void m7396a(XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        xYMultipleSeriesRenderer.setAntialiasing(true);
        xYMultipleSeriesRenderer.setBackgroundColor(0);
        xYMultipleSeriesRenderer.setApplyBackgroundColor(true);
        xYMultipleSeriesRenderer.setLegendTextSize(15.0f);
        xYMultipleSeriesRenderer.setAxisTitleTextSize(12.0f);
        xYMultipleSeriesRenderer.setChartTitleTextSize(12.0f);
        xYMultipleSeriesRenderer.setLabelsTextSize(12.0f);
        xYMultipleSeriesRenderer.setMargins(new int[]{50, 100, 50, 100});
        xYMultipleSeriesRenderer.setDynamicShowOverrideText(false);
        xYMultipleSeriesRenderer.setAxesColor(-16777216);
        xYMultipleSeriesRenderer.setXAxisColor(-16777216);
        xYMultipleSeriesRenderer.setYAxisColor(-16777216);
        xYMultipleSeriesRenderer.setLabelsColor(-16777216);
        xYMultipleSeriesRenderer.setXLabelsColor(-16777216);
        xYMultipleSeriesRenderer.setGridColor(-16777216);
        xYMultipleSeriesRenderer.setXLabels(18);
        xYMultipleSeriesRenderer.setInnerXLabels(10);
        xYMultipleSeriesRenderer.setYLabels(6);
        xYMultipleSeriesRenderer.setYInnerLabels(5);
        xYMultipleSeriesRenderer.setYLabelsPadding(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        xYMultipleSeriesRenderer.setXLabelsAngle(30.0f);
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
        for (int i = 0; i < this.f11727a; i++) {
            int m5384a = GraphConfiguration.m5384a(i);
            XYSeriesRenderer xYSeriesRenderer = new XYSeriesRenderer();
            xYSeriesRenderer.setColor(m5384a);
            xYSeriesRenderer.setLineWidth(3.0f);
            xYMultipleSeriesRenderer.setYLabelFormat(numberFormat, i);
            xYMultipleSeriesRenderer.setYLabelsColor(i, m5384a);
            xYMultipleSeriesRenderer.setYAxisAlign(f11725k[i], i);
            xYMultipleSeriesRenderer.setYLabelsAlign(f11726l[i], i);
            xYMultipleSeriesRenderer.addSeriesRenderer(xYSeriesRenderer);
        }
    }

    /* renamed from: b */
    public final void m7392b() {
        for (int i = 0; i < this.f11727a; i++) {
            this.f11729c.addSeries(new XYSeries(""));
        }
        new C2095h(this).start();
    }

    /* renamed from: a */
    public final synchronized void m7394a(List<ArrayList<BasicDataStreamBean>> list, long j, SerializableMap serializableMap) {
        String title;
        if (list != null) {
            if (list.size() >= this.f11727a) {
                MeasureConversion.m5099a(C2744aa.m5158d(this.f11733g), list.get(0));
                for (int i = 0; i < this.f11727a; i++) {
                    XYSeries seriesAt = this.f11729c.getSeriesAt(i);
                    ArrayList<BasicDataStreamBean> arrayList = list.get(i + 0);
                    if (arrayList == null || arrayList.isEmpty()) {
                        break;
                    }
                    BasicDataStreamBean basicDataStreamBean = arrayList.get(arrayList.size() - 1);
                    XYMultipleSeriesRenderer xYMultipleSeriesRenderer = this.f11728b;
                    basicDataStreamBean.getTitle();
                    if (serializableMap != null && serializableMap.getMap() != null) {
                        title = !TextUtils.isEmpty(serializableMap.getMap().get(basicDataStreamBean.getTitle())) ? serializableMap.getMap().get(basicDataStreamBean.getTitle()) : basicDataStreamBean.getTitle();
                    } else {
                        title = basicDataStreamBean.getTitle();
                    }
                    String value = basicDataStreamBean.getValue();
                    String unit = basicDataStreamBean.getUnit();
                    seriesAt.setTitle(title.trim() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + value + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + unit);
                    xYMultipleSeriesRenderer.setYTitle(unit, i);
                    if (basicDataStreamBean.getUnit().isEmpty()) {
                        Map<String, Integer> yLabelMap = this.f11728b.getYLabelMap(i);
                        if (BaseDataStreamShowingFragment.m7128b()) {
                            yLabelMap.clear();
                        }
                        m7393a(yLabelMap, seriesAt, j, list.get(i));
                        DataStreamUpdatingUtils.m4878a(this.f11728b, seriesAt, j, i);
                    } else {
                        double d = j;
                        m7397a(seriesAt, d, list.get(i));
                        DataStreamUpdatingUtils.m4879a(this.f11728b, seriesAt, d, i);
                    }
                }
                this.f11734h.m9673a();
            }
        }
    }

    /* renamed from: a */
    private void m7397a(XYSeries xYSeries, double d, List<BasicDataStreamBean> list) {
        double d2;
        int i;
        xYSeries.clear();
        int xGridRange = this.f11728b.getXGridRange();
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
    private void m7393a(Map<String, Integer> map, XYSeries xYSeries, double d, List<BasicDataStreamBean> list) {
        double d2;
        int i;
        int xGridRange = this.f11728b.getXGridRange();
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

    /* renamed from: d */
    private synchronized void m7390d() {
        for (int i = 0; i < this.f11729c.getSeriesCount(); i++) {
            this.f11729c.getSeriesAt(i).clear();
        }
        this.f11734h.m9673a();
        this.f11732f.cancel();
        this.f11730d.stopRefreshTimer();
    }

    /* renamed from: c */
    public final void m7391c() {
        this.f11736j.setVisibility(8);
        m7390d();
    }
}
