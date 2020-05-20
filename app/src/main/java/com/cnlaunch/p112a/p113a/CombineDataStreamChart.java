package com.cnlaunch.p112a.p113a;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.cnlaunch.p112a.p114b.Point;
import com.cnlaunch.p112a.p114b.XYMultipleSeriesDataset;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.BasicStroke;
import com.cnlaunch.p112a.p115c.DefaultRenderer;
import com.cnlaunch.p112a.p115c.SimpleSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYMultipleSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYSeriesRenderer;
import com.cnlaunch.p112a.p116d.MathHelper;
import com.itextpdf.text.pdf.ColumnText;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cnlaunch.a.a.c */
/* loaded from: classes.dex */
public final class CombineDataStreamChart extends AbstractChart {
    private static final long serialVersionUID = 1;
    private Point mCenter;
    private XYMultipleSeriesDataset mDataset;
    private XYMultipleSeriesRenderer mRenderer;
    private float mScale;
    private float mTranslate;

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public final int getLegendShapeWidth(int i) {
        return 30;
    }

    public final boolean isRenderPoints(SimpleSeriesRenderer simpleSeriesRenderer) {
        return false;
    }

    public CombineDataStreamChart(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, XYMultipleSeriesDataset xYMultipleSeriesDataset) {
        this.mRenderer = xYMultipleSeriesRenderer;
        this.mDataset = xYMultipleSeriesDataset;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0470  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:169:? -> B:155:0x06a7). Please submit an issue!!! */
    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(android.graphics.Canvas r54, int r55, int r56, int r57, int r58, android.graphics.Paint r59) {
        /*
            Method dump skipped, instructions count: 1933
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p112a.p113a.CombineDataStreamChart.draw(android.graphics.Canvas, int, int, int, int, android.graphics.Paint):void");
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

    protected final void drawYLabels(Map<Integer, List<Double>> map, Canvas canvas, Paint paint, int i, int i2, int i3, int i4, double[] dArr, double[] dArr2) {
        int i5;
        boolean z;
        int i6;
        boolean z2;
        boolean z3;
        boolean z4;
        int i7;
        int i8;
        Paint.Align align;
        Map<String, Integer> map2;
        int i9;
        int i10;
        DefaultRenderer.EnumC1407a enumC1407a;
        int i11;
        DefaultRenderer.EnumC1407a enumC1407a2;
        Map<String, Integer> map3;
        int i12;
        int i13;
        int i14;
        Map<String, Integer> map4;
        String fitText;
        int i15;
        int i16;
        int i17;
        Map<String, Integer> map5;
        int i18;
        double d;
        String fitText2;
        int i19;
        int i20 = i;
        DefaultRenderer.EnumC1407a orientation = this.mRenderer.getOrientation();
        boolean isShowGridX = this.mRenderer.isShowGridX();
        boolean isShowLabels = this.mRenderer.isShowLabels();
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        int i21 = i2 - this.mRenderer.getMargins()[1];
        int i22 = this.mRenderer.getMargins()[1] + i3;
        this.mRenderer.getMargins();
        int i23 = 0;
        while (i23 < i20) {
            Paint.Align yLabelsAlign = this.mRenderer.getYLabelsAlign(i23);
            paint.setTextAlign(yLabelsAlign);
            List<Double> list = map.get(Integer.valueOf(i23));
            int size = list.size();
            int i24 = i21;
            Map<String, Integer> yLabelMap = this.mRenderer.getYLabelMap(i23);
            int i25 = i22;
            int i26 = i24;
            int i27 = 0;
            while (i27 < size) {
                Map<String, Integer> map6 = yLabelMap;
                boolean m9671a = m9671a(i27, this.mRenderer.getYInnerLabels(i23));
                List<Double> list2 = list;
                double doubleValue = list.get(i27).doubleValue();
                Paint.Align yAxisAlign = this.mRenderer.getYAxisAlign(i23);
                int i28 = i27;
                int i29 = size;
                if (this.mRenderer.getYTextLabel(Double.valueOf(doubleValue), i23) != null) {
                    i5 = i4;
                    z = true;
                } else {
                    i5 = i4;
                    z = false;
                }
                double d2 = i5;
                Double.isNaN(d2);
                float f = (float) (d2 - (dArr[i23] * (doubleValue - dArr2[i23])));
                if (orientation == DefaultRenderer.EnumC1407a.HORIZONTAL) {
                    if (!isShowLabels || z) {
                        z2 = isShowGridX;
                        z3 = isShowLabels;
                        z4 = isShowTickMarks;
                        i8 = i2;
                        align = yLabelsAlign;
                        i11 = i23;
                        enumC1407a2 = orientation;
                        map3 = map6;
                        i7 = i29;
                    } else {
                        paint.setColor(this.mRenderer.getYLabelsColor(i23));
                        if (yAxisAlign == Paint.Align.LEFT) {
                            int i30 = this.mRenderer.getMargins()[1];
                            if (i20 > 4) {
                                if (i23 < 2) {
                                    i19 = i2 - this.mRenderer.getMargins()[1];
                                } else {
                                    i19 = i2 - (this.mRenderer.getMargins()[1] / 3);
                                }
                                i30 = this.mRenderer.getMargins()[1] / 3;
                                i16 = i19;
                            } else {
                                i16 = i26;
                            }
                            if (isShowTickMarks) {
                                i17 = i30;
                                z3 = isShowLabels;
                                i18 = i16;
                                i7 = i29;
                                enumC1407a2 = orientation;
                                z2 = isShowGridX;
                                d = doubleValue;
                                map5 = map6;
                                z4 = isShowTickMarks;
                                align = yLabelsAlign;
                                canvas.drawLine(i16 + m9669a(yLabelsAlign), f, i16, f, paint);
                            } else {
                                i17 = i30;
                                z2 = isShowGridX;
                                z3 = isShowLabels;
                                z4 = isShowTickMarks;
                                map5 = map6;
                                i7 = i29;
                                i18 = i16;
                                align = yLabelsAlign;
                                enumC1407a2 = orientation;
                                d = doubleValue;
                            }
                            if (m9671a || !map5.isEmpty()) {
                                float yLabelsPadding = align == Paint.Align.LEFT ? -this.mRenderer.getYLabelsPadding() : this.mRenderer.getYLabelsPadding();
                                Map<String, Integer> map7 = map5;
                                String m9666a = m9666a(map7, this.mRenderer.getYLabelFormat(i23), d);
                                if (this.mRenderer.isDynamicShowOverrideText()) {
                                    fitText2 = getDynamicShowText(m9666a, i17, paint, this.mCurrentCount);
                                } else {
                                    fitText2 = getFitText(m9666a, i17, paint);
                                }
                                map3 = map7;
                                i11 = i23;
                                drawText(canvas, fitText2, i18 - yLabelsPadding, f - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                            } else {
                                i11 = i23;
                                map3 = map5;
                            }
                            i26 = i18;
                            i8 = i2;
                        } else {
                            z2 = isShowGridX;
                            z3 = isShowLabels;
                            z4 = isShowTickMarks;
                            i8 = i2;
                            align = yLabelsAlign;
                            i7 = i29;
                            enumC1407a2 = orientation;
                            int i31 = this.mRenderer.getMargins()[3];
                            if (i20 > 6) {
                                if (i23 > 5) {
                                    i15 = this.mRenderer.getMargins()[3] + i3;
                                } else {
                                    i15 = (this.mRenderer.getMargins()[3] / 3) + i3;
                                }
                                i12 = this.mRenderer.getMargins()[3] / 3;
                                i13 = i15;
                            } else if (i20 > 4) {
                                int i32 = i3 + this.mRenderer.getMargins()[3];
                                i12 = this.mRenderer.getMargins()[3];
                                i13 = i32;
                            } else {
                                i12 = i31;
                                i13 = i25;
                            }
                            if (z4) {
                                i14 = i12;
                                map4 = map6;
                                canvas.drawLine(i13, f, m9669a(align) + i13, f, paint);
                            } else {
                                i14 = i12;
                                map4 = map6;
                            }
                            if (m9671a || !map4.isEmpty()) {
                                float yLabelsPadding2 = align == Paint.Align.LEFT ? this.mRenderer.getYLabelsPadding() : -this.mRenderer.getYLabelsPadding();
                                Map<String, Integer> map8 = map4;
                                String m9666a2 = m9666a(map8, this.mRenderer.getYLabelFormat(i23), doubleValue);
                                if (this.mRenderer.isDynamicShowOverrideText()) {
                                    fitText = getDynamicShowText(m9666a2, i14, paint, this.mCurrentCount);
                                } else {
                                    fitText = getFitText(m9666a2, i14, paint);
                                }
                                map3 = map8;
                                i11 = i23;
                                drawText(canvas, fitText, i13 + yLabelsPadding2, f - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                            } else {
                                i11 = i23;
                                map3 = map4;
                            }
                            i25 = i13;
                        }
                    }
                    if (z2 && m9671a) {
                        paint.setColor(this.mRenderer.getGridColor(i11));
                        canvas.drawLine(i8, f, i3, f, paint);
                    }
                    i6 = i11;
                    i9 = i25;
                    enumC1407a = enumC1407a2;
                    map2 = map3;
                } else {
                    i6 = i23;
                    z2 = isShowGridX;
                    z3 = isShowLabels;
                    z4 = isShowTickMarks;
                    i7 = i29;
                    i8 = i2;
                    align = yLabelsAlign;
                    DefaultRenderer.EnumC1407a enumC1407a3 = orientation;
                    if (enumC1407a3 == DefaultRenderer.EnumC1407a.VERTICAL) {
                        if (!z3 || z) {
                            map2 = map6;
                            i9 = i25;
                            enumC1407a = enumC1407a3;
                        } else {
                            paint.setColor(this.mRenderer.getYLabelsColor(i6));
                            if (z4) {
                                int i33 = i25;
                                i9 = i33;
                                enumC1407a = enumC1407a3;
                                canvas.drawLine(i33 - m9669a(yAxisAlign), f, i33, f, paint);
                            } else {
                                i9 = i25;
                                enumC1407a = enumC1407a3;
                            }
                            if (m9671a || !map6.isEmpty()) {
                                String m9666a3 = m9666a(map6, this.mRenderer.getYLabelFormat(i6), doubleValue);
                                map2 = map6;
                                drawText(canvas, this.mRenderer.isDynamicShowOverrideText() ? getDynamicShowText(m9666a3, this.mRenderer.getMargins()[3], paint, this.mCurrentCount) : m9666a3, i9 + 10 + this.mRenderer.getYLabelsPadding(), f - this.mRenderer.getYLabelsVerticalPadding(), paint, this.mRenderer.getYLabelsAngle());
                            } else {
                                map2 = map6;
                            }
                        }
                        if (z2 && m9671a) {
                            paint.setColor(this.mRenderer.getGridColor(i6));
                            if (z4) {
                                i10 = i26;
                                canvas.drawLine(i9, f, i10, f, paint);
                            } else {
                                i10 = i26;
                            }
                        } else {
                            i10 = i26;
                        }
                    } else {
                        map2 = map6;
                        i9 = i25;
                        i10 = i26;
                        enumC1407a = enumC1407a3;
                    }
                    i26 = i10;
                }
                i27 = i28 + 1;
                i23 = i6;
                yLabelMap = map2;
                yLabelsAlign = align;
                size = i7;
                orientation = enumC1407a;
                list = list2;
                isShowGridX = z2;
                isShowLabels = z3;
                isShowTickMarks = z4;
                i25 = i9;
                i20 = i;
            }
            i23++;
            i22 = i25;
            i21 = i26;
        }
    }

    /* renamed from: a */
    private String m9666a(Map<String, Integer> map, NumberFormat numberFormat, double d) {
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
    private static int m9669a(Paint.Align align) {
        return align == Paint.Align.RIGHT ? -6 : 6;
    }

    /* renamed from: a */
    private static boolean m9671a(int i, int i2) {
        return i % i2 == 0;
    }

    protected final void drawXLabels(List<Double> list, Double[] dArr, Canvas canvas, Paint paint, int i, int i2, int i3, double d, double d2, double d3) {
        int i4;
        int i5;
        boolean z;
        float f;
        double d4;
        float labelsTextSize;
        int size = list.size();
        boolean isShowLabels = this.mRenderer.isShowLabels();
        boolean isShowGridY = this.mRenderer.isShowGridY();
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        int innerXLabels = this.mRenderer.getInnerXLabels();
        int i6 = 0;
        while (i6 < size) {
            double doubleValue = list.get(i6).doubleValue();
            double d5 = i;
            Double.isNaN(d5);
            float f2 = (float) (d5 + ((doubleValue - d2) * d));
            if (isShowLabels) {
                paint.setColor(this.mRenderer.getXLabelsColor());
                boolean m9671a = m9671a((int) doubleValue, innerXLabels);
                if (isShowTickMarks) {
                    if (m9671a) {
                        labelsTextSize = this.mRenderer.getLabelsTextSize() / 3.0f;
                    } else {
                        labelsTextSize = this.mRenderer.getLabelsTextSize() / 4.0f;
                    }
                    float f3 = i3;
                    float f4 = f3 + labelsTextSize;
                    f = f2;
                    i5 = size;
                    z = isShowLabels;
                    d4 = doubleValue;
                    canvas.drawLine(f2, f3, f, f4, paint);
                } else {
                    f = f2;
                    i5 = size;
                    z = isShowLabels;
                    d4 = doubleValue;
                }
                if (m9671a) {
                    String label = getLabel(this.mRenderer.getXLabelFormat(), d4);
                    float f5 = i3;
                    i4 = i6;
                    drawText(canvas, label, f, ((this.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + f5 + this.mRenderer.getXLabelsPadding(), paint, this.mRenderer.getXLabelsAngle());
                    if (isShowGridY) {
                        paint.setColor(this.mRenderer.getGridColor(0));
                        canvas.drawLine(f, f5, f, i2, paint);
                    }
                } else {
                    i4 = i6;
                }
            } else {
                i4 = i6;
                i5 = size;
                z = isShowLabels;
            }
            i6 = i4 + 1;
            size = i5;
            isShowLabels = z;
        }
        drawXTextLabels(dArr, canvas, paint, isShowLabels, i, i2, i3, d, d2, d3);
    }

    protected final void drawXTextLabels(Double[] dArr, Canvas canvas, Paint paint, boolean z, int i, int i2, int i3, double d, double d2, double d3) {
        float f;
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
                        float f2 = i3;
                        f = doubleValue;
                        canvas.drawLine(doubleValue, f2, doubleValue, f2 + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                    } else {
                        f = doubleValue;
                    }
                    String xTextLabel = this.mRenderer.getXTextLabel(d4);
                    float f3 = i3;
                    drawText(canvas, xTextLabel, f, ((this.mRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + f3 + this.mRenderer.getXLabelsPadding(), paint, this.mRenderer.getXLabelsAngle());
                    if (isShowCustomTextGridX) {
                        paint.setColor(this.mRenderer.getGridColor(0));
                        canvas.drawLine(f, f3, f, i2, paint);
                    }
                }
            }
        }
    }

    protected final List<Double> getXLabels(double d, double d2, int i) {
        return MathHelper.m9645b(d, d2, i);
    }

    @SuppressLint({"UseSparseArrays"})
    protected final Map<Integer, List<Double>> getYLabels(double[] dArr, double[] dArr2, int i) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            hashMap.put(Integer.valueOf(i2), m9667a(MathHelper.m9645b(dArr[i2], dArr2[i2], this.mRenderer.getYLabels() * this.mRenderer.getYInnerLabels(i2))));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static List<Double> m9667a(List<Double> list) {
        ArrayList arrayList = new ArrayList(list);
        for (Double d : list) {
            if (d.isNaN()) {
                arrayList.remove(d);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m9668a(Paint.Cap cap, Paint.Join join, float f, Paint.Style style, PathEffect pathEffect, Paint paint) {
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f);
        paint.setPathEffect(pathEffect);
        paint.setStyle(style);
    }

    protected final void drawChartValuesText(Canvas canvas, XYSeries xYSeries, XYSeriesRenderer xYSeriesRenderer, Paint paint, List<Float> list, int i, int i2) {
        if (list.size() > 2) {
            float floatValue = list.get(0).floatValue();
            float floatValue2 = list.get(1).floatValue();
            for (int i3 = 0; i3 < list.size(); i3 += 2) {
                if (i3 == 2) {
                    if (Math.abs(list.get(2).floatValue() - list.get(0).floatValue()) > xYSeriesRenderer.getDisplayChartValuesDistance() || Math.abs(list.get(3).floatValue() - list.get(1).floatValue()) > xYSeriesRenderer.getDisplayChartValuesDistance()) {
                        drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i2)), list.get(0).floatValue(), list.get(1).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                        drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY(i2 + 1)), list.get(2).floatValue(), list.get(3).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                        floatValue = list.get(2).floatValue();
                        floatValue2 = list.get(3).floatValue();
                    }
                } else if (i3 > 2 && (Math.abs(list.get(i3).floatValue() - floatValue) > xYSeriesRenderer.getDisplayChartValuesDistance() || Math.abs(list.get(i3 + 1).floatValue() - floatValue2) > xYSeriesRenderer.getDisplayChartValuesDistance())) {
                    int i4 = i3 + 1;
                    drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY((i3 / 2) + i2)), list.get(i3).floatValue(), list.get(i4).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                    floatValue = list.get(i3).floatValue();
                    floatValue2 = list.get(i4).floatValue();
                }
            }
            return;
        }
        for (int i5 = 0; i5 < list.size(); i5 += 2) {
            drawText(canvas, getLabel(xYSeriesRenderer.getChartValuesFormat(), xYSeries.getY((i5 / 2) + i2)), list.get(i5).floatValue(), list.get(i5 + 1).floatValue() - xYSeriesRenderer.getChartValuesSpacing(), paint, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        }
    }

    protected final void drawSeries(XYSeries xYSeries, Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, DefaultRenderer.EnumC1407a enumC1407a, int i2) {
        BasicStroke stroke = xYSeriesRenderer.getStroke();
        Paint.Cap strokeCap = paint.getStrokeCap();
        Paint.Join strokeJoin = paint.getStrokeJoin();
        float strokeMiter = paint.getStrokeMiter();
        PathEffect pathEffect = paint.getPathEffect();
        Paint.Style style = paint.getStyle();
        if (stroke != null) {
            m9668a(stroke.getCap(), stroke.getJoin(), stroke.getMiter(), Paint.Style.FILL_AND_STROKE, stroke.getIntervals() != null ? new DashPathEffect(stroke.getIntervals(), stroke.getPhase()) : null, paint);
        }
        drawSeries(canvas, paint, list, xYSeriesRenderer, f, i, i2);
        paint.setTextSize(xYSeriesRenderer.getChartValuesTextSize());
        if (enumC1407a == DefaultRenderer.EnumC1407a.HORIZONTAL) {
            paint.setTextAlign(Paint.Align.CENTER);
        } else {
            paint.setTextAlign(Paint.Align.LEFT);
        }
        if (xYSeriesRenderer.isDisplayChartValues()) {
            paint.setTextAlign(xYSeriesRenderer.getChartValuesTextAlign());
            drawChartValuesText(canvas, xYSeries, xYSeriesRenderer, paint, list, i, i2);
        }
        if (stroke != null) {
            m9668a(strokeCap, strokeJoin, strokeMiter, style, pathEffect, paint);
        }
    }

    public final void drawSeries(Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        float strokeWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(xYSeriesRenderer.getLineWidth());
        paint.setColor(xYSeriesRenderer.getColor());
        paint.setStyle(Paint.Style.STROKE);
        drawPath(canvas, list, paint, false);
        paint.setStrokeWidth(strokeWidth);
    }

    protected final void drawPoints(Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        isRenderPoints(xYSeriesRenderer);
    }

    /* renamed from: a */
    private void m9670a(Canvas canvas, float f, boolean z) {
        if (z) {
            float f2 = this.mScale;
            canvas.scale(1.0f / f2, f2);
            float f3 = this.mTranslate;
            canvas.translate(f3, -f3);
            canvas.rotate(-f, this.mCenter.getX(), this.mCenter.getY());
            return;
        }
        canvas.rotate(f, this.mCenter.getX(), this.mCenter.getY());
        float f4 = this.mTranslate;
        canvas.translate(-f4, f4);
        float f5 = this.mScale;
        canvas.scale(f5, 1.0f / f5);
    }

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public final void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        paint.setStyle(Paint.Style.FILL);
        RectF rectF = new RectF();
        rectF.top = f2;
        rectF.left = f;
        rectF.right = f + 30.0f;
        rectF.bottom = rectF.top + 10.0f;
        canvas.drawRect(rectF, paint);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public final DefaultRenderer getRenderer() {
        return this.mRenderer;
    }
}
