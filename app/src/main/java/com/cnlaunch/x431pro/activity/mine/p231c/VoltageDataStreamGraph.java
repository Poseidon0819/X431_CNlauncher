package com.cnlaunch.x431pro.activity.mine.p231c;

import android.content.Context;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.p112a.DataStreamGraphicalView;
import com.cnlaunch.p112a.p113a.AbstractChart;
import com.cnlaunch.p112a.p113a.DataStreamChart;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.DataStreamSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYSeriesRenderer;
import com.itextpdf.text.pdf.ColumnText;
import java.text.NumberFormat;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.mine.c.a */
/* loaded from: classes.dex */
public final class VoltageDataStreamGraph {

    /* renamed from: f */
    public static int f14018f = 200;

    /* renamed from: a */
    public RelativeLayout f14019a;

    /* renamed from: b */
    public DataStreamSeriesRenderer f14020b;

    /* renamed from: c */
    public XYSeries f14021c;

    /* renamed from: d */
    public DataStreamGraphicalView f14022d;

    /* renamed from: e */
    public int f14023e;

    /* renamed from: g */
    private Context f14024g;

    /* renamed from: h */
    private int[] f14025h = {20, 100, 20, 100};

    /* renamed from: i */
    private AbstractChart f14026i;

    public VoltageDataStreamGraph(Context context, RelativeLayout relativeLayout) {
        this.f14024g = context;
        this.f14019a = relativeLayout;
        this.f14020b = new DataStreamSeriesRenderer();
        this.f14021c = new XYSeries("");
        this.f14020b = new DataStreamSeriesRenderer();
        this.f14020b.setBackgroundColor(-1);
        this.f14020b.setApplyBackgroundColor(true);
        this.f14020b.setAxisTitleTextSize(16.0f);
        this.f14020b.setChartTitleTextSize(16.0f);
        this.f14020b.setLabelsTextSize(15.0f);
        this.f14020b.setLegendTextSize(15.0f);
        this.f14020b.setPointSize(5.0f);
        this.f14020b.setMargins(this.f14025h);
        this.f14020b.setDynamicShowOverrideText(true);
        this.f14020b.setAxesColor(-16777216);
        this.f14020b.setLabelsColor(-16777216);
        this.f14020b.setGridColor(-16777216);
        this.f14020b.setYLabelsColor(-16777216);
        this.f14020b.setXLabelsColor(-16777216);
        this.f14020b.setShowGrid(true);
        this.f14020b.setYLabelsAlign(Paint.Align.RIGHT);
        this.f14020b.setYLabels(8);
        this.f14020b.setYInnerLabels(2);
        this.f14020b.setYLabelsAngle(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        this.f14020b.setYLabelFormat(numberFormat);
        this.f14020b.setShowColorRect(true);
        this.f14020b.setColorTop(1867270644);
        this.f14020b.setColorBottom(1325492958);
        this.f14020b.setTopRange(new double[]{14.8d, 13.2d});
        this.f14020b.setBottomRange(new double[]{12.8d, 11.8d});
        NumberFormat numberFormat2 = NumberFormat.getInstance();
        numberFormat2.setMaximumFractionDigits(0);
        this.f14020b.setXLabelFormat(numberFormat2);
        this.f14020b.setXLabelsAngle(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.f14020b.setXAxisMin(0.0d);
        this.f14020b.setXAxisMax(10.0d);
        this.f14020b.setXLabels(8);
        this.f14020b.setYAxisMin(8.0d);
        this.f14020b.setYAxisMax(16.0d);
        this.f14020b.setShowLegend(false);
        XYSeriesRenderer xYSeriesRenderer = new XYSeriesRenderer();
        xYSeriesRenderer.setShowLegendItem(false);
        xYSeriesRenderer.setLineWidth(3.0f);
        this.f14020b.addSeriesRenderer(xYSeriesRenderer);
        this.f14021c = new XYSeries("电压");
        this.f14026i = new DataStreamChart(this.f14020b, this.f14021c);
        this.f14022d = new DataStreamGraphicalView(this.f14024g, this.f14026i);
        this.f14019a.addView(this.f14022d, new ViewGroup.LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public final void m6256a(long j, ArrayList<BasicDataStreamBean> arrayList) {
        if (f14018f != arrayList.size()) {
            f14018f = arrayList.size();
        }
        int i = 0;
        if (j <= f14018f) {
            this.f14021c.clear();
            while (i < j) {
                this.f14021c.add(i, arrayList.get(i).getDbValue().doubleValue());
                i++;
            }
        } else {
            this.f14021c.clear();
            while (true) {
                int i2 = f14018f;
                if (i >= i2) {
                    break;
                }
                this.f14021c.add((i + j) - i2, arrayList.get(i).getDbValue().doubleValue());
                i++;
            }
        }
        this.f14023e = (int) j;
        m6255a(this.f14020b);
        this.f14022d.m9673a();
    }

    /* renamed from: a */
    public final void m6255a(DataStreamSeriesRenderer dataStreamSeriesRenderer) {
        int i;
        double d = this.f14023e + 1 > 30 ? i + 1 : 30.0d;
        dataStreamSeriesRenderer.setXAxisMax(d);
        int i2 = this.f14023e;
        int i3 = f14018f;
        if (i2 > i3) {
            double d2 = i3;
            Double.isNaN(d2);
            dataStreamSeriesRenderer.setXAxisMin((d - d2) - 1.0d);
        } else {
            dataStreamSeriesRenderer.setXAxisMin(0.0d);
        }
        dataStreamSeriesRenderer.setXGridRange(10);
        dataStreamSeriesRenderer.setXLabels(10);
    }
}
