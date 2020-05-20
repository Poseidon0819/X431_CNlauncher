package com.cnlaunch.p112a.p113a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import com.cnlaunch.p112a.p114b.Point;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.BasicStroke;
import com.cnlaunch.p112a.p115c.DataStreamSeriesRenderer;
import com.cnlaunch.p112a.p115c.DefaultRenderer;
import com.cnlaunch.p112a.p115c.SimpleSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYSeriesRenderer;
import com.cnlaunch.p112a.p116d.IndexXYMap;
import com.cnlaunch.p112a.p116d.MathHelper;
import com.itextpdf.text.pdf.ColumnText;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.cnlaunch.a.a.d */
/* loaded from: classes.dex */
public final class DataStreamChart extends AbstractChart {
    private static final long serialVersionUID = 1;
    private Point mCenter;
    protected XYSeries mDataset;
    protected DataStreamSeriesRenderer mRenderer;
    private float mScale;
    private Rect mScreenR;
    private float mTranslate;

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public final void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
    }

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public final int getLegendShapeWidth(int i) {
        return 0;
    }

    protected DataStreamChart() {
    }

    public DataStreamChart(DataStreamSeriesRenderer dataStreamSeriesRenderer, XYSeries xYSeries) {
        this.mRenderer = dataStreamSeriesRenderer;
        this.mDataset = xYSeries;
    }

    /* renamed from: a */
    private static void m9665a(int i, int i2, int i3, int i4, double d, double d2, double d3, double d4, Paint paint, Canvas canvas) {
        int color = paint.getColor();
        Paint.Style style = paint.getStyle();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        double d5 = i4;
        Double.isNaN(d5);
        Double.isNaN(d5);
        canvas.drawRect(i2, (float) (d5 - ((d3 - d2) * d)), i3, (float) (d5 - ((d4 - d2) * d)), paint);
        paint.setColor(color);
        paint.setStyle(style);
    }

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public final void draw(Canvas canvas, int i, int i2, int i3, int i4, Paint paint) {
        int i5;
        int i6;
        int i7;
        XYSeries xYSeries;
        int i8;
        int i9;
        DefaultRenderer.EnumC1407a enumC1407a;
        int i10;
        float f;
        Canvas canvas2;
        int i11;
        int i12;
        int i13;
        char c;
        paint.setAntiAlias(this.mRenderer.isAntialiasing());
        drawBackground(this.mRenderer, canvas, i, i2, i3, i4, paint, false, 0);
        DataStreamSeriesRenderer dataStreamSeriesRenderer = this.mRenderer;
        int legendSize = getLegendSize(dataStreamSeriesRenderer, i4 / 5, dataStreamSeriesRenderer.getAxisTitleTextSize());
        int[] margins = this.mRenderer.getMargins();
        int i14 = i + margins[1];
        int i15 = i2 + margins[0];
        int i16 = (i + i3) - margins[3];
        int i17 = ((i2 + i4) - margins[2]) - legendSize;
        if (this.mScreenR == null) {
            this.mScreenR = new Rect();
        }
        this.mScreenR.set(i14, i15, i16, i17);
        DefaultRenderer.EnumC1407a orientation = this.mRenderer.getOrientation();
        if (orientation == DefaultRenderer.EnumC1407a.VERTICAL) {
            i16 -= legendSize;
            i7 = i17 + (legendSize - 20);
        } else {
            i7 = i17;
        }
        int angle = orientation.getAngle();
        boolean z = angle == 90;
        this.mScale = i4 / i3;
        this.mTranslate = Math.abs(i3 - i4) / 2;
        if (this.mScale < 1.0f) {
            this.mTranslate *= -1.0f;
        }
        this.mCenter = new Point(i5 / 2, i6 / 2);
        if (z) {
            canvas.rotate(angle, this.mCenter.getX(), this.mCenter.getY());
            float f2 = this.mTranslate;
            canvas.translate(-f2, f2);
            float f3 = this.mScale;
            canvas.scale(f3, 1.0f / f3);
        }
        XYSeries xYSeries2 = this.mDataset;
        double xAxisMin = this.mRenderer.getXAxisMin();
        double xAxisMax = this.mRenderer.getXAxisMax();
        double yAxisMin = this.mRenderer.getYAxisMin();
        double yAxisMax = this.mRenderer.getYAxisMax();
        double d = i16 - i14;
        Double.isNaN(d);
        double d2 = d / (xAxisMax - xAxisMin);
        double d3 = i7 - i15;
        Double.isNaN(d3);
        double d4 = d3 / (yAxisMax - yAxisMin);
        if (xYSeries2.getItemCount() == 0) {
            return;
        }
        boolean isShowLabels = this.mRenderer.isShowLabels();
        boolean isShowGridX = this.mRenderer.isShowGridX();
        if (isShowLabels || isShowGridX) {
            int xLabels = this.mRenderer.getXLabels();
            int yLabels = this.mRenderer.getYLabels() * this.mRenderer.getYInnerLabels();
            int i18 = i16;
            List<Double> m9662a = m9662a(getXLabels(xAxisMin, xAxisMax, xLabels));
            List<Double> m9662a2 = m9662a(getYLabels(yAxisMin, yAxisMax, yLabels));
            if (isShowLabels) {
                paint.setColor(this.mRenderer.getXLabelsColor());
                paint.setTextSize(this.mRenderer.getLabelsTextSize());
                paint.setTextAlign(this.mRenderer.getXLabelsAlign());
            }
            int i19 = i7;
            xYSeries = xYSeries2;
            drawXLabels(m9662a, this.mRenderer.getXTextLabelLocations(), canvas, paint, i14, i15, i19, d2, xAxisMin, xAxisMax);
            drawYLabels(m9662a2, canvas, paint, i14, i18, i19, d4, yAxisMin);
            if (this.mRenderer.isShowAxes()) {
                paint.setColor(this.mRenderer.getXAxisColor());
                i14 = i14;
                float f4 = i14;
                i9 = i19;
                float f5 = i9;
                i8 = i18;
                float f6 = i8;
                canvas.drawLine(f4, f5, f6, f5, paint);
                paint.setColor(this.mRenderer.getYAxisColor());
                boolean z2 = this.mRenderer.getYAxisAlign() == Paint.Align.RIGHT;
                enumC1407a = orientation;
                if (enumC1407a == DefaultRenderer.EnumC1407a.HORIZONTAL) {
                    float f7 = i15;
                    i10 = i15;
                    canvas.drawLine(f4, f7, f4, f5, paint);
                    if (z2) {
                        canvas.drawLine(f6, f7, f6, f5, paint);
                    }
                } else {
                    i10 = i15;
                    if (enumC1407a == DefaultRenderer.EnumC1407a.VERTICAL) {
                        canvas.drawLine(f6, i10, f6, f5, paint);
                    }
                }
            } else {
                i8 = i18;
                i9 = i19;
                enumC1407a = orientation;
                i14 = i14;
                i10 = i15;
            }
        } else {
            i9 = i7;
            enumC1407a = orientation;
            i10 = i15;
            xYSeries = xYSeries2;
            i8 = i16;
        }
        XYSeriesRenderer xYSeriesRenderer = (XYSeriesRenderer) this.mRenderer.getSeriesRendererAt(0);
        List<Float> arrayList = new ArrayList<>(xYSeries.getItemCount());
        double d5 = i9;
        Double.isNaN(d5);
        float min = Math.min(i9, (float) ((d4 * yAxisMin) + d5));
        synchronized (xYSeries) {
            IndexXYMap<Double, Double> range = xYSeries.getRange(xAxisMin, xAxisMax, xYSeriesRenderer.isDisplayBoundingPoints());
            List<Double> list = range.f6726a;
            int i20 = i10;
            int i21 = 0;
            float f8 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            float f9 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            while (i21 < list.size()) {
                int i22 = i9;
                int i23 = i14;
                int i24 = i20;
                int i25 = i8;
                double doubleValue = range.m9652a(i21).doubleValue();
                double doubleValue2 = range.m9649b(i21).doubleValue();
                XYSeriesRenderer xYSeriesRenderer2 = xYSeriesRenderer;
                float f10 = min;
                double d6 = i23;
                Double.isNaN(d6);
                f9 = (float) (d6 + ((doubleValue - xAxisMin) * d2));
                Double.isNaN(d5);
                float f11 = (float) (d5 - ((doubleValue2 - yAxisMin) * d4));
                arrayList.add(Float.valueOf(f9));
                arrayList.add(Float.valueOf(f11));
                i21++;
                min = f10;
                i14 = i23;
                i8 = i25;
                i9 = i22;
                i20 = i24;
                f8 = f11;
                xYSeriesRenderer = xYSeriesRenderer2;
            }
            if (arrayList.size() > 0) {
                canvas.save();
                canvas2 = canvas;
                canvas2.clipRect(i14, i20, i8, i9);
                DefaultRenderer.EnumC1407a enumC1407a2 = enumC1407a;
                f = f8;
                drawSeries(xYSeries, canvas, paint, arrayList, xYSeriesRenderer, min, enumC1407a2, 0);
                canvas.restore();
            } else {
                f = f8;
                canvas2 = canvas;
            }
            if (this.mRenderer.isShowCurrentCoordinateValue()) {
                canvas2.drawText(xYSeries.getCurrentValue(), f9, f, paint);
            }
        }
        if (this.mRenderer.getShowColorRect()) {
            c = 0;
            i11 = i8;
            i12 = i9;
            i13 = i14;
            m9665a(this.mRenderer.getColorTop(), i14, i8, i9, d4, yAxisMin, this.mRenderer.getTopRange()[0], this.mRenderer.getTopRange()[1], paint, canvas);
            m9665a(this.mRenderer.getColorBottom(), i13, i11, i12, d4, yAxisMin, this.mRenderer.getBottomRange()[0], this.mRenderer.getBottomRange()[1], paint, canvas);
        } else {
            i11 = i8;
            i12 = i9;
            i13 = i14;
            c = 0;
        }
        if (this.mRenderer.ismShowStandRect()) {
            m9665a(this.mRenderer.getmColorStand(), i13, i11, i12, d4, yAxisMin, this.mRenderer.getmStandRange()[c], this.mRenderer.getmStandRange()[1], paint, canvas);
        }
    }

    protected final void drawXLabels(List<Double> list, Double[] dArr, Canvas canvas, Paint paint, int i, int i2, int i3, double d, double d2, double d3) {
        float f;
        int i4;
        boolean z;
        double d4;
        int size = list.size();
        boolean isShowLabels = this.mRenderer.isShowLabels();
        boolean isShowGridY = this.mRenderer.isShowGridY();
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        int i5 = 0;
        while (i5 < size) {
            double doubleValue = list.get(i5).doubleValue();
            double d5 = i;
            Double.isNaN(d5);
            float f2 = (float) (d5 + ((doubleValue - d2) * d));
            if (isShowLabels) {
                paint.setColor(this.mRenderer.getXLabelsColor());
                if (isShowTickMarks) {
                    float f3 = i3;
                    f = f2;
                    i4 = size;
                    z = isShowLabels;
                    d4 = doubleValue;
                    canvas.drawLine(f2, f3, f2, f3 + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                } else {
                    f = f2;
                    i4 = size;
                    z = isShowLabels;
                    d4 = doubleValue;
                }
                drawText(canvas, getLabel(this.mRenderer.getXLabelFormat(), d4), f, i3 + ((this.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + this.mRenderer.getXLabelsPadding(), paint, this.mRenderer.getXLabelsAngle());
            } else {
                f = f2;
                i4 = size;
                z = isShowLabels;
            }
            if (isShowGridY) {
                paint.setColor(this.mRenderer.getGridColor());
                canvas.drawLine(f, i3, f, i2, paint);
            }
            i5++;
            size = i4;
            isShowLabels = z;
        }
        drawXTextLabels(dArr, canvas, paint, isShowLabels, i, i2, i3, d, d2, d3);
    }

    protected final void drawXTextLabels(Double[] dArr, Canvas canvas, Paint paint, boolean z, int i, int i2, int i3, double d, double d2, double d3) {
        boolean isShowCustomTextGridX = this.mRenderer.isShowCustomTextGridX();
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        if (z) {
            paint.setColor(this.mRenderer.getXLabelsColor());
            for (Double d4 : dArr) {
                if (d2 <= d4.doubleValue() && d4.doubleValue() <= d3) {
                    double d5 = i;
                    Double.isNaN(d5);
                    float doubleValue = (float) (d5 + ((d4.doubleValue() - d2) * d));
                    paint.setColor(this.mRenderer.getXLabelsColor());
                    if (isShowTickMarks) {
                        float f = i3;
                        canvas.drawLine(doubleValue, f, doubleValue, f + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                    }
                    if (isShowCustomTextGridX) {
                        paint.setColor(this.mRenderer.getGridColor());
                        canvas.drawLine(doubleValue, i3, doubleValue, i2, paint);
                    }
                }
            }
        }
    }

    protected final void drawYLabels(List<Double> list, Canvas canvas, Paint paint, int i, int i2, int i3, double d, double d2) {
        List<Double> list2;
        boolean z;
        int i4;
        int i5;
        Map<String, Integer> map;
        boolean z2;
        boolean z3;
        DefaultRenderer.EnumC1407a enumC1407a;
        Map<String, Integer> map2;
        String fitText;
        DefaultRenderer.EnumC1407a enumC1407a2;
        float f;
        double d3;
        String fitText2;
        DefaultRenderer.EnumC1407a orientation = this.mRenderer.getOrientation();
        boolean isShowGridX = this.mRenderer.isShowGridX();
        boolean isShowLabels = this.mRenderer.isShowLabels();
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        paint.setTextAlign(this.mRenderer.getYLabelsAlign());
        int size = list.size();
        Map<String, Integer> yLabelMap = this.mRenderer.getYLabelMap();
        int i6 = 0;
        while (i6 < size) {
            if (i6 % this.mRenderer.getYInnerLabels() == 0) {
                list2 = list;
                z = true;
            } else {
                list2 = list;
                z = false;
            }
            double doubleValue = list2.get(i6).doubleValue();
            Paint.Align yAxisAlign = this.mRenderer.getYAxisAlign();
            if (this.mRenderer.getYTextLabel(Double.valueOf(doubleValue)) != null) {
                i4 = i3;
                i5 = i6;
                map = yLabelMap;
                z2 = true;
            } else {
                i4 = i3;
                i5 = i6;
                map = yLabelMap;
                z2 = false;
            }
            double d4 = i4;
            Double.isNaN(d4);
            float f2 = (float) (d4 - ((doubleValue - d2) * d));
            if (orientation == DefaultRenderer.EnumC1407a.HORIZONTAL) {
                if (!isShowLabels || z2) {
                    enumC1407a2 = orientation;
                    z3 = isShowGridX;
                    map2 = map;
                    f = f2;
                } else {
                    paint.setColor(this.mRenderer.getYLabelsColor());
                    if (yAxisAlign == Paint.Align.LEFT) {
                        if (isShowTickMarks) {
                            enumC1407a2 = orientation;
                            z3 = isShowGridX;
                            d3 = doubleValue;
                            canvas.drawLine(m9664a(yAxisAlign) + i, f2, i, f2, paint);
                        } else {
                            enumC1407a2 = orientation;
                            z3 = isShowGridX;
                            d3 = doubleValue;
                        }
                        if (z || !this.mRenderer.getYLabelMap().isEmpty()) {
                            Map<String, Integer> map3 = map;
                            String m9661a = m9661a(map3, this.mRenderer.getYLabelFormat(), d3);
                            if (m9661a.isEmpty()) {
                                f = f2;
                                map2 = map3;
                            } else {
                                if (this.mRenderer.isDynamicShowOverrideText()) {
                                    fitText2 = getDynamicShowText(m9661a, i - this.mRenderer.getYLabelsPadding(), paint, this.mCurrentCount);
                                } else {
                                    fitText2 = getFitText(m9661a, i - this.mRenderer.getYLabelsPadding(), paint);
                                }
                                map2 = map3;
                                f = f2;
                                drawText(canvas, fitText2, i - this.mRenderer.getYLabelsPadding(), f2 - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                            }
                        } else {
                            map2 = map;
                            f = f2;
                        }
                    } else {
                        enumC1407a2 = orientation;
                        z3 = isShowGridX;
                        Map<String, Integer> map4 = map;
                        f = f2;
                        if (isShowTickMarks) {
                            canvas.drawLine(i2, f, m9664a(yAxisAlign) + i2, f, paint);
                        }
                        if (z || !this.mRenderer.getYLabelMap().isEmpty()) {
                            map2 = map4;
                            drawText(canvas, m9661a(map4, this.mRenderer.getYLabelFormat(), doubleValue), i2 + this.mRenderer.getYLabelsPadding(), f - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                        } else {
                            map2 = map4;
                        }
                    }
                }
                if (z3 && z) {
                    paint.setColor(this.mRenderer.getGridColor());
                    canvas.drawLine(i, f, i2, f, paint);
                    enumC1407a = enumC1407a2;
                } else {
                    enumC1407a = enumC1407a2;
                }
            } else {
                DefaultRenderer.EnumC1407a enumC1407a3 = orientation;
                z3 = isShowGridX;
                Map<String, Integer> map5 = map;
                if (enumC1407a3 == DefaultRenderer.EnumC1407a.VERTICAL) {
                    if (!isShowLabels || z2) {
                        enumC1407a = enumC1407a3;
                        map2 = map5;
                    } else {
                        paint.setColor(this.mRenderer.getYLabelsColor());
                        if (isShowTickMarks) {
                            enumC1407a = enumC1407a3;
                            canvas.drawLine(i2 - m9664a(yAxisAlign), f2, i2, f2, paint);
                        } else {
                            enumC1407a = enumC1407a3;
                        }
                        if (z || !this.mRenderer.getYLabelMap().isEmpty()) {
                            String m9661a2 = m9661a(map5, this.mRenderer.getYLabelFormat(), doubleValue);
                            if (this.mRenderer.isDynamicShowOverrideText()) {
                                fitText = getDynamicShowText(m9661a2, i2 + 10 + this.mRenderer.getYLabelsPadding(), paint, this.mCurrentCount);
                            } else {
                                fitText = getFitText(m9661a2, i2 + 10 + this.mRenderer.getYLabelsPadding(), paint);
                            }
                            map2 = map5;
                            drawText(canvas, fitText, i2 + 10 + this.mRenderer.getYLabelsPadding(), f2 - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                        } else {
                            map2 = map5;
                        }
                    }
                    if (z3 && z) {
                        paint.setColor(this.mRenderer.getGridColor());
                        if (isShowTickMarks) {
                            canvas.drawLine(i2, f2, i, f2, paint);
                        }
                    }
                } else {
                    enumC1407a = enumC1407a3;
                    map2 = map5;
                }
            }
            i6 = i5 + 1;
            yLabelMap = map2;
            orientation = enumC1407a;
            isShowGridX = z3;
        }
    }

    /* renamed from: a */
    private String m9661a(Map<String, Integer> map, NumberFormat numberFormat, double d) {
        if (map.isEmpty()) {
            return super.getLabel(numberFormat, d);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() == d) {
                return entry.getKey();
            }
        }
        return "";
    }

    /* renamed from: a */
    private static int m9664a(Paint.Align align) {
        return align == Paint.Align.LEFT ? -4 : 4;
    }

    protected final List<Double> getXLabels(double d, double d2, int i) {
        return MathHelper.m9645b(d, d2, i);
    }

    protected final List<Double> getYLabels(double d, double d2, int i) {
        return MathHelper.m9647a(d, d2, i);
    }

    /* renamed from: a */
    private static List<Double> m9662a(List<Double> list) {
        ArrayList arrayList = new ArrayList(list);
        for (Double d : list) {
            if (d.isNaN()) {
                arrayList.remove(d);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public final void drawBackground(DefaultRenderer defaultRenderer, Canvas canvas, int i, int i2, int i3, int i4, Paint paint, boolean z, int i5) {
        canvas.drawColor(defaultRenderer.getBackgroundColor());
    }

    protected final void drawSeries(XYSeries xYSeries, Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, DefaultRenderer.EnumC1407a enumC1407a, int i) {
        BasicStroke stroke = xYSeriesRenderer.getStroke();
        Paint.Cap strokeCap = paint.getStrokeCap();
        Paint.Join strokeJoin = paint.getStrokeJoin();
        float strokeMiter = paint.getStrokeMiter();
        PathEffect pathEffect = paint.getPathEffect();
        Paint.Style style = paint.getStyle();
        if (stroke != null) {
            m9663a(stroke.getCap(), stroke.getJoin(), stroke.getMiter(), Paint.Style.FILL_AND_STROKE, stroke.getIntervals() != null ? new DashPathEffect(stroke.getIntervals(), stroke.getPhase()) : null, paint);
        }
        float strokeWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(xYSeriesRenderer.getLineWidth());
        paint.setColor(xYSeriesRenderer.getColor());
        paint.setStyle(Paint.Style.STROKE);
        drawPath(canvas, list, paint, false);
        paint.setStrokeWidth(strokeWidth);
        paint.setTextSize(xYSeriesRenderer.getChartValuesTextSize());
        if (enumC1407a == DefaultRenderer.EnumC1407a.HORIZONTAL) {
            paint.setTextAlign(Paint.Align.CENTER);
        } else {
            paint.setTextAlign(Paint.Align.LEFT);
        }
        if (xYSeriesRenderer.isDisplayChartValues()) {
            paint.setTextAlign(xYSeriesRenderer.getChartValuesTextAlign());
            drawChartValuesText(canvas, xYSeries, xYSeriesRenderer, paint, list, i);
        }
        if (stroke != null) {
            m9663a(strokeCap, strokeJoin, strokeMiter, style, pathEffect, paint);
        }
    }

    /* renamed from: a */
    private static void m9663a(Paint.Cap cap, Paint.Join join, float f, Paint.Style style, PathEffect pathEffect, Paint paint) {
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f);
        paint.setPathEffect(pathEffect);
        paint.setStyle(style);
    }

    protected final void drawChartValuesText(Canvas canvas, XYSeries xYSeries, XYSeriesRenderer xYSeriesRenderer, Paint paint, List<Float> list, int i) {
        if (list.size() > 2) {
            float floatValue = list.get(0).floatValue();
            float floatValue2 = list.get(1).floatValue();
            for (int i2 = 0; i2 < list.size(); i2 += 2) {
                if (i2 == 2) {
                    if (Math.abs(list.get(2).floatValue() - list.get(0).floatValue()) > xYSeriesRenderer.getDisplayChartValuesDistance() || Math.abs(list.get(3).floatValue() - list.get(1).floatValue()) > xYSeriesRenderer.getDisplayChartValuesDistance()) {
                        drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i)), list.get(0).floatValue(), list.get(1).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                        drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i + 1)), list.get(2).floatValue(), list.get(3).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                        floatValue = list.get(2).floatValue();
                        floatValue2 = list.get(3).floatValue();
                    }
                } else if (i2 > 2 && (Math.abs(list.get(i2).floatValue() - floatValue) > xYSeriesRenderer.getDisplayChartValuesDistance() || Math.abs(list.get(i2 + 1).floatValue() - floatValue2) > xYSeriesRenderer.getDisplayChartValuesDistance())) {
                    int i3 = i2 + 1;
                    drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY((i2 / 2) + i)), list.get(i2).floatValue(), list.get(i3).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                    floatValue = list.get(i2).floatValue();
                    floatValue2 = list.get(i3).floatValue();
                }
            }
            return;
        }
        for (int i4 = 0; i4 < list.size(); i4 += 2) {
            drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY((i4 / 2) + i)), list.get(i4).floatValue(), list.get(i4 + 1).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        }
    }

    protected final void drawText(Canvas canvas, String str, float f, float f2, Paint paint, float f3) {
        float f4 = (-this.mRenderer.getOrientation().getAngle()) + f3;
        if (f4 != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            canvas.rotate(f4, f, f2);
        }
        drawString(canvas, str, f, f2, paint);
        if (f4 != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            canvas.rotate(-f4, f, f2);
        }
    }

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public final DataStreamSeriesRenderer getRenderer() {
        return this.mRenderer;
    }
}
