package com.cnlaunch.p112a.p113a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import com.cnlaunch.p112a.p114b.Point;
import com.cnlaunch.p112a.p114b.XYSeries;
import com.cnlaunch.p112a.p115c.BasicStroke;
import com.cnlaunch.p112a.p115c.DataStreamSeriesRenderer;
import com.cnlaunch.p112a.p115c.DefaultRenderer;
import com.cnlaunch.p112a.p115c.SimpleSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYSeriesRenderer;
import com.cnlaunch.p112a.p116d.MathHelper;
import com.itextpdf.text.pdf.ColumnText;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.cnlaunch.a.a.e */
/* loaded from: classes.dex */
public class SpecialDataStreamChart extends AbstractChart {
    private static final long serialVersionUID = 1;
    private Point mCenter;
    List<XYSeries> mDataset;
    protected DataStreamSeriesRenderer mRenderer;
    private float mScale;
    private Rect mScreenR;
    private float mTranslate;
    String TAG = SpecialDataStreamChart.class.getSimpleName();
    private Bitmap mBitmap = null;
    private boolean mIsUseTopChart = true;
    private boolean mIsTopChart = false;
    private int mOldWidth = 0;

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
    }

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public int getLegendShapeWidth(int i) {
        return 0;
    }

    public SpecialDataStreamChart(DataStreamSeriesRenderer dataStreamSeriesRenderer, List<XYSeries> list) {
        this.mDataset = null;
        this.mRenderer = dataStreamSeriesRenderer;
        this.mDataset = list;
    }

    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    public DataStreamSeriesRenderer getRenderer() {
        return this.mRenderer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0418, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0630, code lost:
        r28 = r9;
        r25 = r11;
        r27 = r14;
        r26 = r15;
        r14 = r21;
        r5 = r22;
        r22 = r23;
        r21 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0169, code lost:
        r19 = r8;
        r8 = r61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x016d, code lost:
        r8.setStyle(r6);
        r8.setColor(r1);
        r6 = r61.getColor();
        r5 = r61.getStyle();
        r8.setStyle(android.graphics.Paint.Style.FILL);
        r8.setColor(r14.mRenderer.getParentBackgroundColor());
        r4 = r11;
        r2 = r12;
        r42 = r21;
        r43 = r38;
        r45 = r26;
        r21 = r9;
        r56.drawRect(r4, r2, (r9 - r11) - 1, r12 + r16, r61);
        r6 = r10;
        r9 = r23;
        r56.drawRect(r6, r2, r9, r11 - 1, r61);
        r56.drawRect(r4, r2, r9, r7 - 1, r61);
        r56.drawRect(r4, r15, r9, r25, r61);
        r8.setColor(r6);
        r8.setStyle(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01f2, code lost:
        if (r14.mIsUseTopChart == false) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01f4, code lost:
        if (r0 == 0) goto L215;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01f7, code lost:
        if (1 == r0) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01fa, code lost:
        if (2 >= r0) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x020a, code lost:
        m9659a(r57, r58, r59, r60, r56, r61);
        r14.mRenderer.setParentViewBitmap(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0217, code lost:
        if (r14.mOldWidth == r59) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0219, code lost:
        m9659a(r57, r58, r59, r60, r56, r61);
        r14.mRenderer.setParentViewBitmap(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0230, code lost:
        if (r14.mOldWidth == r59) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0232, code lost:
        r14.mOldWidth = r59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0236, code lost:
        r0 = r14.mRenderer.isShowLabels();
        r9 = r14.mRenderer.isShowGridX();
        r12 = r61.getStyle();
        r8.setStyle(android.graphics.Paint.Style.STROKE);
        r13 = r61.getColor();
        r8.setColor(r14.mRenderer.getXLabelsColor());
        r5 = r21;
        r4 = r7;
        r22 = r21;
        r56.drawRect(r5, r4, r6, r15, r61);
        r8.setColor(r13);
        r8.setStyle(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0274, code lost:
        if (r0 != false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0276, code lost:
        if (r9 == false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0279, code lost:
        r0 = r8;
        r10 = r14;
        r38 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x027f, code lost:
        r1 = r14.mRenderer.getXLabels();
        r2 = new java.util.ArrayList();
        r3 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x028f, code lost:
        java.lang.Double.parseDouble(r14.mRenderer.getXTextLabel(java.lang.Double.valueOf(0.0d)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x029e, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02a0, code lost:
        r4 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05e1 A[Catch: all -> 0x0841, TryCatch #1 {all -> 0x0841, blocks: (B:11:0x004c, B:13:0x0054, B:15:0x0077, B:16:0x007e, B:18:0x008d, B:20:0x0096, B:25:0x00a3, B:27:0x00a5, B:29:0x00bf, B:30:0x00c7, B:32:0x00d8, B:33:0x00f9, B:35:0x011a, B:37:0x011c, B:39:0x012f, B:41:0x0146, B:57:0x0213, B:59:0x0219, B:61:0x0232, B:86:0x034d, B:88:0x0355, B:92:0x0385, B:94:0x038b, B:96:0x039c, B:97:0x03ac, B:99:0x03b0, B:100:0x03bf, B:70:0x028f, B:76:0x02a6, B:80:0x02c9, B:204:0x083f, B:81:0x02f4, B:106:0x03da, B:108:0x03ff, B:107:0x03f1, B:56:0x020a, B:111:0x041c, B:113:0x0445, B:201:0x0812, B:140:0x05d5, B:142:0x05e1, B:143:0x05ea, B:168:0x06a3, B:117:0x0489, B:138:0x0585, B:124:0x04a1, B:126:0x04a5, B:127:0x04e5, B:129:0x04f8, B:133:0x0507, B:135:0x0550, B:134:0x052f, B:145:0x05ef, B:147:0x05fd, B:150:0x0605, B:151:0x060d, B:153:0x0613, B:155:0x061b, B:156:0x062f, B:160:0x064e, B:162:0x0677, B:163:0x067e, B:165:0x068a, B:167:0x06a2, B:171:0x06a6, B:173:0x06b2, B:175:0x06cb, B:177:0x06ff, B:179:0x0710, B:181:0x0714, B:187:0x075d, B:189:0x076f, B:193:0x07a4, B:195:0x07fa), top: B:208:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x07ff  */
    @Override // com.cnlaunch.p112a.p113a.AbstractChart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r56, int r57, int r58, int r59, int r60, android.graphics.Paint r61) {
        /*
            Method dump skipped, instructions count: 2115
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p112a.p113a.SpecialDataStreamChart.draw(android.graphics.Canvas, int, int, int, int, android.graphics.Paint):void");
    }

    /* renamed from: a */
    private static void m9659a(int i, int i2, int i3, int i4, Canvas canvas, Paint paint) {
        int color = paint.getColor();
        Paint.Style style = paint.getStyle();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0);
        canvas.drawRect(i, i2, i + i3, i2 + i4, paint);
        paint.setColor(color);
        paint.setStyle(style);
    }

    /* renamed from: a */
    private static List<Double> m9660a(double d, double d2) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (d < 0.0d) {
            double d3 = 0.0d - d;
            if (0.0d == d3 % 35.0d) {
                i = (int) (d3 / 35.0d);
            } else if (0.0d == d3 % 25.0d) {
                i = (int) (d3 / 25.0d);
            } else if (0.0d == d3 % 20.0d) {
                i = (int) (d3 / 20.0d);
            } else if (0.0d == d3 % 10.0d) {
                i = (int) (d3 / 15.0d);
            } else if (0.0d == d3 % 15.0d) {
                i = (int) (d3 / 10.0d);
            } else if (0.0d != d3 % 1.0d) {
                i = 0;
            } else if (Math.abs(d) > 80.0d) {
                i = 4;
            } else if (Math.abs(d) > 60.0d) {
                i = 3;
            } else {
                i = Math.abs(d) > 40.0d ? 2 : 1;
            }
            double d4 = i;
            Double.isNaN(d4);
            float f = (float) (d3 / d4);
            for (int i2 = 0; i2 < i; i2++) {
                double d5 = i2 * f;
                Double.isNaN(d5);
                arrayList.add(Double.valueOf(d5 + d));
            }
        } else {
            i = 0;
        }
        if (d2 > 0.0d) {
            double d6 = d2 - 0.0d;
            if (0.0d == d6 % 35.0d) {
                i = (int) (d6 / 35.0d);
            } else if (0.0d == d6 % 25.0d) {
                i = (int) (d6 / 25.0d);
            } else if (0.0d == d6 % 20.0d) {
                i = (int) (d6 / 20.0d);
            } else if (0.0d == d6 % 15.0d) {
                i = (int) (d6 / 15.0d);
            } else if (0.0d == d6 % 10.0d) {
                i = (int) (d6 / 10.0d);
            } else if (0.0d == d6 % 1.0d) {
                i = d2 > 80.0d ? 4 : d2 > 60.0d ? 3 : d2 > 40.0d ? 2 : 1;
            }
            double d7 = i;
            Double.isNaN(d7);
            float f2 = (float) (d6 / d7);
            for (int i3 = 0; i3 < i + 1; i3++) {
                double d8 = i3 * f2;
                Double.isNaN(d8);
                arrayList.add(Double.valueOf(d8 + 0.0d));
            }
        }
        return arrayList;
    }

    protected void drawSeries(XYSeries xYSeries, Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, DefaultRenderer.EnumC1407a enumC1407a, int i) {
        BasicStroke stroke = xYSeriesRenderer.getStroke();
        Paint.Cap strokeCap = paint.getStrokeCap();
        Paint.Join strokeJoin = paint.getStrokeJoin();
        float strokeMiter = paint.getStrokeMiter();
        PathEffect pathEffect = paint.getPathEffect();
        Paint.Style style = paint.getStyle();
        if (stroke != null) {
            m9658a(stroke.getCap(), stroke.getJoin(), stroke.getMiter(), Paint.Style.FILL_AND_STROKE, stroke.getIntervals() != null ? new DashPathEffect(stroke.getIntervals(), stroke.getPhase()) : null, paint);
        }
        float strokeWidth = paint.getStrokeWidth();
        if (getIsTopChart()) {
            paint.setStrokeWidth(xYSeriesRenderer.getLineWidth() + 1.0f);
        } else {
            paint.setStrokeWidth(xYSeriesRenderer.getLineWidth());
        }
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
            m9658a(strokeCap, strokeJoin, strokeMiter, style, pathEffect, paint);
        }
    }

    /* renamed from: a */
    private static void m9658a(Paint.Cap cap, Paint.Join join, float f, Paint.Style style, PathEffect pathEffect, Paint paint) {
        paint.setStrokeCap(cap);
        paint.setStrokeJoin(join);
        paint.setStrokeMiter(f);
        paint.setPathEffect(pathEffect);
        paint.setStyle(style);
    }

    protected void drawChartValuesText(Canvas canvas, XYSeries xYSeries, XYSeriesRenderer xYSeriesRenderer, Paint paint, List<Float> list, int i) {
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

    protected void drawText(Canvas canvas, String str, float f, float f2, Paint paint, float f3) {
        float f4 = (-this.mRenderer.getOrientation().getAngle()) + f3;
        if (f4 != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            canvas.rotate(f4, f, f2);
        }
        drawString(canvas, str, f, f2, paint);
        if (f4 != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            canvas.rotate(-f4, f, f2);
        }
    }

    protected List<Double> getXLabels(double d, double d2, int i) {
        return MathHelper.m9645b(d, d2, i);
    }

    protected List<Double> getYLabels(double d, double d2, int i) {
        return MathHelper.m9647a(d, d2, i);
    }

    protected void drawXLabels(List<Double> list, Double[] dArr, Canvas canvas, Paint paint, int i, int i2, int i3, int i4, double d, double d2, double d3) {
        float f;
        boolean z;
        int i5;
        int i6;
        double d4;
        int size = list.size();
        boolean isShowLabels = this.mRenderer.isShowLabels();
        boolean isShowGridY = this.mRenderer.isShowGridY();
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        int i7 = 0;
        while (i7 < size) {
            double doubleValue = list.get(i7).doubleValue();
            double d5 = i;
            double d6 = i7;
            Double.isNaN(d6);
            Double.isNaN(d5);
            float f2 = (float) (d5 + (d6 * d));
            if (isShowLabels) {
                paint.setColor(this.mRenderer.getXLabelsColor());
                if (isShowTickMarks) {
                    float f3 = i4;
                    f = f2;
                    i6 = i7;
                    d4 = doubleValue;
                    canvas.drawLine(f2, f3, f2, f3 + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                } else {
                    f = f2;
                    i6 = i7;
                    d4 = doubleValue;
                }
                z = isShowLabels;
                i5 = i6;
                m9656a(getLabel(this.mRenderer.getXLabelFormat(), d4), this.mRenderer.getLabelsTextSize(), this.mRenderer.getLabelsColor(), f, i2, canvas, paint, d);
            } else {
                f = f2;
                z = isShowLabels;
                i5 = i7;
            }
            if (isShowGridY) {
                paint.setColor(this.mRenderer.getGridColor());
                float f4 = i4;
                float f5 = i2;
                canvas.drawLine(f, f4, f, f5, paint);
                if (i5 == size - 1) {
                    float f6 = i3;
                    canvas.drawLine(f6, f4, f6, f5, paint);
                }
            }
            i7 = i5 + 1;
            isShowLabels = z;
        }
    }

    protected void drawXLabelsWithText(List<String> list, Double[] dArr, Canvas canvas, Paint paint, int i, int i2, int i3, int i4, double d, double d2, double d3) {
        float f;
        int i5;
        double d4 = d;
        int size = list.size();
        boolean isShowLabels = this.mRenderer.isShowLabels();
        boolean isShowGridY = this.mRenderer.isShowGridY();
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        int i6 = 0;
        while (i6 < size) {
            String str = list.get(i6);
            double d5 = i;
            double d6 = i6;
            Double.isNaN(d6);
            Double.isNaN(d5);
            float f2 = (float) (d5 + (d6 * d4));
            if (isShowLabels) {
                paint.setColor(this.mRenderer.getLabelsColor());
                if (isShowTickMarks) {
                    float f3 = i4;
                    f = f2;
                    canvas.drawLine(f2, f3, f2, f3 + (this.mRenderer.getLabelsTextSize() / 3.0f), paint);
                } else {
                    f = f2;
                }
                i5 = i6;
                m9656a(getDynamicShowText(str, ((float) d4) - 10.0f, paint, this.mCurrentCount), this.mRenderer.getLabelsTextSize(), this.mRenderer.getLabelsColor(), f, i2, canvas, paint, d);
            } else {
                f = f2;
                i5 = i6;
            }
            if (isShowGridY) {
                paint.setColor(this.mRenderer.getGridColor());
                float f4 = i4;
                float f5 = i2;
                canvas.drawLine(f, f4, f, f5, paint);
                if (i5 == size - 1) {
                    float f6 = i3;
                    canvas.drawLine(f6, f4, f6, f5, paint);
                }
            }
            i6 = i5 + 1;
            d4 = d;
        }
    }

    protected void drawXTextLabels(Double[] dArr, Canvas canvas, Paint paint, boolean z, int i, int i2, int i3, double d, double d2, double d3) {
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

    protected void drawYLabels(List<Double> list, Canvas canvas, Paint paint, int i, int i2, int i3, int i4, double d, double d2, double d3) {
        float f;
        float f2;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        double d4;
        int i7 = i4;
        boolean isShowGridX = this.mRenderer.isShowGridX();
        boolean isShowLabels = this.mRenderer.isShowLabels();
        boolean isShowTickMarks = this.mRenderer.isShowTickMarks();
        paint.setTextAlign(this.mRenderer.getYLabelsAlign());
        int size = list.size() - 1;
        int i8 = 0;
        while (i8 < size) {
            double doubleValue = list.get(i8).doubleValue();
            float f3 = i;
            float f4 = i3;
            float f5 = i7;
            float f6 = f5 - (((float) ((doubleValue - d2) / (d3 - d2))) * (i7 - i2));
            if (isShowLabels) {
                paint.setColor(this.mRenderer.getYLabelsColor());
                if (isShowTickMarks) {
                    if (i8 == 0) {
                        f = f4;
                        f2 = f3;
                        z = isShowLabels;
                        z2 = isShowTickMarks;
                        d4 = doubleValue;
                        canvas.drawLine(f3 - (this.mRenderer.getLabelsTextSize() / 3.0f), f5, f2, f5, paint);
                    } else {
                        f = f4;
                        f2 = f3;
                        z = isShowLabels;
                        z2 = isShowTickMarks;
                        d4 = doubleValue;
                    }
                    canvas.drawLine(f2 - (this.mRenderer.getLabelsTextSize() / 3.0f), f6, f2, f6, paint);
                } else {
                    f = f4;
                    f2 = f3;
                    z = isShowLabels;
                    z2 = isShowTickMarks;
                    d4 = doubleValue;
                }
                if (i8 == 0) {
                    i5 = i8;
                    i6 = size;
                    m9657a(getLabel(this.mRenderer.getYLabelFormat(), d4), this.mRenderer.getLabelsTextSize(), this.mRenderer.getLabelsColor(), f2 - (this.mRenderer.getLabelsTextSize() / 3.0f), f6 - (this.mRenderer.getLabelsTextSize() / 2.0f), canvas, paint);
                } else {
                    i5 = i8;
                    i6 = size;
                    if (i6 - 1 == i5) {
                        m9657a(getLabel(this.mRenderer.getYLabelFormat(), list.get(i5 + 1).doubleValue()), this.mRenderer.getLabelsTextSize(), this.mRenderer.getLabelsColor(), f2 - (this.mRenderer.getLabelsTextSize() / 3.0f), i2 + (this.mRenderer.getLabelsTextSize() / 2.0f), canvas, paint);
                    }
                    m9657a(getLabel(this.mRenderer.getYLabelFormat(), d4), this.mRenderer.getLabelsTextSize(), this.mRenderer.getLabelsColor(), f2 - (this.mRenderer.getLabelsTextSize() / 3.0f), f6, canvas, paint);
                }
            } else {
                f = f4;
                f2 = f3;
                i5 = i8;
                i6 = size;
                z = isShowLabels;
                z2 = isShowTickMarks;
                d4 = doubleValue;
            }
            if (!isShowGridX && this.mRenderer.getShowGridXBaseline() && 0.0d == d4) {
                int color = paint.getColor();
                paint.setColor(-16711936);
                canvas.drawLine(f2, f6, f, f6, paint);
                paint.setColor(color);
            } else if (isShowGridX) {
                if (i6 - 1 == i5) {
                    canvas.drawLine(f2, f6, f, f6, paint);
                }
                canvas.drawLine(f2, f6, f, f6, paint);
            }
            i8 = i5 + 1;
            isShowLabels = z;
            isShowTickMarks = z2;
            size = i6;
            i7 = i4;
        }
    }

    public void drawTextAlignCneter(String str, float f, int i, boolean z, Canvas canvas, RectF rectF, Paint paint) {
        Paint.Style style = paint.getStyle();
        Paint.Align textAlign = paint.getTextAlign();
        int flags = paint.getFlags();
        int color = paint.getColor();
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        if (z) {
            paint.setFlags(8);
        }
        paint.setColor(i);
        paint.setTextSize(f);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.drawText(str, rectF.centerX(), (rectF.top + ((((rectF.bottom - rectF.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, paint);
        paint.setStyle(style);
        paint.setTextAlign(textAlign);
        paint.setFlags(flags);
        paint.setColor(color);
    }

    /* renamed from: a */
    private void m9657a(String str, float f, int i, float f2, float f3, Canvas canvas, Paint paint) {
        Paint.Style style = paint.getStyle();
        Paint.Align textAlign = paint.getTextAlign();
        int flags = paint.getFlags();
        int color = paint.getColor();
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(i);
        paint.setTextSize(f);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
        numberFormat.setMaximumFractionDigits(0);
        String format = numberFormat.format(stringToDouble(numberFormat, str));
        float measureText = paint.measureText(format);
        float f4 = f2 - measureText;
        float f5 = f3 - (f / 2.0f);
        RectF rectF = new RectF(f4, f5, measureText + f4, f + f5);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.drawText(format, rectF.centerX(), (rectF.top + ((((rectF.bottom - rectF.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, paint);
        paint.setStyle(style);
        paint.setTextAlign(textAlign);
        paint.setFlags(flags);
        paint.setColor(color);
    }

    /* renamed from: a */
    private static void m9656a(String str, float f, int i, float f2, float f3, Canvas canvas, Paint paint, double d) {
        Paint.Style style = paint.getStyle();
        Paint.Align textAlign = paint.getTextAlign();
        int flags = paint.getFlags();
        int color = paint.getColor();
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(i);
        paint.setTextSize(f);
        float measureText = paint.measureText(str);
        float f4 = f3 - 5.0f;
        RectF rectF = new RectF(f2, f4 - f, f2 + measureText, f4);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        canvas.drawText(str, rectF.centerX() + ((((float) d) - measureText) / 2.0f), (rectF.top + ((((rectF.bottom - rectF.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, paint);
        paint.setStyle(style);
        paint.setTextAlign(textAlign);
        paint.setFlags(flags);
        paint.setColor(color);
    }

    public void drawRoundRect(int i, float f, Paint.Style style, Canvas canvas, RectF rectF, Paint paint) {
        int color = paint.getColor();
        Paint.Style style2 = paint.getStyle();
        float strokeWidth = paint.getStrokeWidth();
        paint.setColor(i);
        paint.setStyle(style);
        paint.setStrokeWidth(f);
        canvas.drawRoundRect(rectF, 5.0f, 5.0f, paint);
        paint.setColor(color);
        paint.setStyle(style2);
        paint.setStrokeWidth(strokeWidth);
    }

    public void setIsUseTopChart(boolean z) {
        this.mIsUseTopChart = z;
    }

    public boolean getIsUseTopChart() {
        return this.mIsUseTopChart;
    }

    public void setIsTopChart(boolean z) {
        this.mIsTopChart = z;
    }

    public boolean getIsTopChart() {
        return this.mIsTopChart;
    }

    public double stringToDouble(NumberFormat numberFormat, String str) {
        if (numberFormat == null) {
            numberFormat = NumberFormat.getInstance(Locale.getDefault());
        }
        try {
            return numberFormat.parse(str).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0.0d;
        }
    }
}
