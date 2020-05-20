package com.cnlaunch.x431pro.activity.diagnose.p220c;

import com.cnlaunch.android.widget.MeasureSubject;
import com.cnlaunch.p112a.DataStreamGraphicalView;
import com.cnlaunch.p112a.p115c.DataStreamSeriesRenderer;
import com.cnlaunch.p112a.p115c.DefaultRenderer;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.b */
/* loaded from: classes.dex */
public final class ChartWrapper implements MeasureSubject {

    /* renamed from: a */
    private DataStreamGraphicalView f11711a;

    /* renamed from: b */
    private DataStreamSeriesRenderer f11712b;

    public ChartWrapper(DataStreamGraphicalView dataStreamGraphicalView, DataStreamSeriesRenderer dataStreamSeriesRenderer) {
        this.f11711a = dataStreamGraphicalView;
        this.f11712b = dataStreamSeriesRenderer;
    }

    @Override // com.cnlaunch.android.widget.MeasureSubject
    /* renamed from: a */
    public final int mo7419a() {
        return this.f11712b.getMargins()[0];
    }

    @Override // com.cnlaunch.android.widget.MeasureSubject
    /* renamed from: b */
    public final int mo7415b() {
        return (this.f11711a.getHeight() - this.f11712b.getMargins()[2]) - m7416a(this.f11712b, this.f11711a.getHeight() / 5, this.f11712b.getAxisTitleTextSize());
    }

    @Override // com.cnlaunch.android.widget.MeasureSubject
    /* renamed from: c */
    public final int mo7414c() {
        return this.f11712b.getMargins()[1];
    }

    @Override // com.cnlaunch.android.widget.MeasureSubject
    /* renamed from: d */
    public final int mo7413d() {
        return (this.f11711a.getWidth() - this.f11712b.getMargins()[3]) - m7416a(this.f11712b, this.f11711a.getHeight() / 5, this.f11712b.getAxisTitleTextSize());
    }

    /* renamed from: a */
    private static int m7416a(DefaultRenderer defaultRenderer, int i, float f) {
        int legendHeight = defaultRenderer.getLegendHeight();
        if (!defaultRenderer.isShowLegend() || legendHeight != 0) {
            i = legendHeight;
        }
        return (defaultRenderer.isShowLegend() || !defaultRenderer.isShowLabels()) ? i : (int) (((defaultRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + f);
    }

    @Override // com.cnlaunch.android.widget.MeasureSubject
    /* renamed from: a */
    public final double mo7418a(double d) {
        double mo7415b = mo7415b() - mo7419a();
        double abs = Math.abs(this.f11712b.getYAxisMax() - this.f11712b.getYAxisMin());
        Double.isNaN(mo7415b);
        double yAxisMin = d - this.f11712b.getYAxisMin();
        Double.isNaN(mo7415b);
        return mo7415b - (yAxisMin * (mo7415b / abs));
    }

    @Override // com.cnlaunch.android.widget.MeasureSubject
    /* renamed from: e */
    public final double mo7412e() {
        return this.f11712b.getYAxisMin();
    }

    @Override // com.cnlaunch.android.widget.MeasureSubject
    /* renamed from: f */
    public final double mo7411f() {
        return this.f11712b.getYAxisMax();
    }

    @Override // com.cnlaunch.android.widget.MeasureSubject
    /* renamed from: a */
    public final double mo7417a(int i) {
        int mo7415b = mo7415b() - mo7419a();
        double abs = Math.abs(this.f11712b.getYAxisMax() - this.f11712b.getYAxisMin());
        double d = mo7415b;
        Double.isNaN(d);
        double d2 = abs / d;
        double yAxisMin = this.f11712b.getYAxisMin();
        double d3 = mo7415b - i;
        Double.isNaN(d3);
        return yAxisMin + (d3 * d2);
    }
}
