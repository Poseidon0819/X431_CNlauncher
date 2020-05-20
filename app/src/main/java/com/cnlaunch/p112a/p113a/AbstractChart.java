package com.cnlaunch.p112a.p113a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import com.cnlaunch.p112a.p114b.SeriesSelection;
import com.cnlaunch.p112a.p115c.DefaultRenderer;
import com.cnlaunch.p112a.p115c.SimpleSeriesRenderer;
import com.cnlaunch.p112a.p115c.XYMultipleSeriesRenderer;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentParser;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.a.a.a */
/* loaded from: classes.dex */
public abstract class AbstractChart implements Serializable {
    private final int TIMER_OUT_FOR_REFRESH_OVERRIDE_TEXT = PdfContentParser.COMMAND_TYPE;
    int mCurrentCount = 0;
    private int mTimerOut = PdfContentParser.COMMAND_TYPE;
    private TimerTask mTimerTask = null;
    private Timer mTimer = new Timer();

    public abstract void draw(Canvas canvas, int i, int i2, int i3, int i4, Paint paint);

    public abstract void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint);

    public abstract int getLegendShapeWidth(int i);

    public abstract DefaultRenderer getRenderer();

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point) {
        return null;
    }

    public void startTimer() {
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.mTimerTask = new C1405b(this);
        this.mTimer.schedule(this.mTimerTask, 0L, this.mTimerOut);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawBackground(DefaultRenderer defaultRenderer, Canvas canvas, int i, int i2, int i3, int i4, Paint paint, boolean z, int i5) {
        if (defaultRenderer.isApplyBackgroundColor() || z) {
            if (z) {
                paint.setColor(i5);
            } else {
                paint.setColor(defaultRenderer.getBackgroundColor());
            }
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(i, i2, i + i3, i2 + i4, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int drawLegend(Canvas canvas, DefaultRenderer defaultRenderer, String[] strArr, int i, int i2, int i3, int i4, int i5, int i6, Paint paint, boolean z) {
        int i7;
        float f;
        float f2;
        float f3;
        String str;
        float[] fArr;
        String[] strArr2 = strArr;
        float f4 = defaultRenderer.getmLegendMarginTop();
        if (defaultRenderer.isShowLegend()) {
            float f5 = i;
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(defaultRenderer.getLegendTextSize());
            int min = Math.min(strArr2.length, defaultRenderer.getSeriesRendererCount());
            float f6 = (((i3 + i5) - i6) + f4) - defaultRenderer.getMargins()[2];
            float f7 = f5;
            int i8 = 0;
            while (i8 < min) {
                SimpleSeriesRenderer seriesRendererAt = defaultRenderer.getSeriesRendererAt(i8);
                float legendShapeWidth = getLegendShapeWidth(i8);
                if (seriesRendererAt.isShowLegendItem()) {
                    String str2 = strArr2[i8];
                    if (strArr2.length == defaultRenderer.getSeriesRendererCount()) {
                        paint.setColor(seriesRendererAt.getColor());
                    } else {
                        paint.setColor(DefaultRenderer.TEXT_COLOR);
                    }
                    float measureText = legendShapeWidth + 10.0f + paint.measureText(str2);
                    float f8 = f7 + measureText;
                    if (i8 <= 0 || !getExceed(f8, defaultRenderer, i2, i4)) {
                        f = f4;
                        f2 = f7;
                        f3 = f6;
                    } else {
                        float legendTextSize = f6 + defaultRenderer.getLegendTextSize() + 5.0f;
                        f8 = f5 + measureText;
                        f = f4 + defaultRenderer.getLegendTextSize();
                        f3 = legendTextSize;
                        f2 = f5;
                    }
                    if (getExceed(f8, defaultRenderer, i2, i4)) {
                        paint.getTextWidths(str2, new float[str2.length()]);
                        float f9 = ((i2 - f2) - legendShapeWidth) - 10.0f;
                        if (isVertical(defaultRenderer)) {
                            f9 = ((i4 - f2) - legendShapeWidth) - 10.0f;
                        }
                        str = String.valueOf(str2.substring(0, paint.breakText(str2, true, f9, fArr))) + "...";
                    } else {
                        str = str2;
                    }
                    if (z) {
                        i7 = i8;
                    } else {
                        i7 = i8;
                        drawLegendShape(canvas, seriesRendererAt, f2, f3, i8, paint);
                        drawString(canvas, str, f2 + legendShapeWidth + 5.0f, f3 + 5.0f, paint);
                    }
                    f7 = f2 + measureText;
                    f4 = f;
                    f6 = f3;
                } else {
                    i7 = i8;
                }
                i8 = i7 + 1;
                strArr2 = strArr;
            }
        }
        return Math.round(f4 + defaultRenderer.getLegendTextSize());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawString(Canvas canvas, String str, float f, float f2, Paint paint) {
        if (str != null) {
            String[] split = str.split("\n");
            Rect rect = new Rect();
            int i = 0;
            for (int i2 = 0; i2 < split.length; i2++) {
                canvas.drawText(split[i2], f, i + f2, paint);
                paint.getTextBounds(split[i2], 0, split[i2].length(), rect);
                i = i + rect.height() + 5;
            }
        }
    }

    protected boolean getExceed(float f, DefaultRenderer defaultRenderer, int i, int i2) {
        return isVertical(defaultRenderer) ? f > ((float) i2) : f > ((float) i);
    }

    public boolean isVertical(DefaultRenderer defaultRenderer) {
        return (defaultRenderer instanceof XYMultipleSeriesRenderer) && ((XYMultipleSeriesRenderer) defaultRenderer).getOrientation() == DefaultRenderer.EnumC1407a.VERTICAL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLabel(NumberFormat numberFormat, double d) {
        if (numberFormat != null) {
            return numberFormat.format(d);
        }
        if (d == Math.round(d)) {
            return new StringBuilder(String.valueOf(Math.round(d))).toString();
        }
        return new StringBuilder(String.valueOf(d)).toString();
    }

    /* renamed from: a */
    private static float[] m9672a(float f, float f2, float f3, float f4, int i, int i2) {
        float f5;
        float f6;
        float f7 = i;
        if (f2 > f7) {
            float f8 = (f4 - f2) / (f3 - f);
            float f9 = f8 * f;
            f5 = ((f7 - f2) + f9) / f8;
            if (f5 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f6 = f2 - f9;
                f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            } else {
                float f10 = i2;
                if (f5 > f10) {
                    f6 = ((f8 * f10) + f2) - f9;
                    f5 = f10;
                } else {
                    f6 = f7;
                }
            }
        } else if (f2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            float f11 = (f4 - f2) / (f3 - f);
            float f12 = f11 * f;
            f5 = ((-f2) + f12) / f11;
            if (f5 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f6 = f2 - f12;
                f5 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            } else {
                float f13 = i2;
                if (f5 > f13) {
                    f6 = ((f11 * f13) + f2) - f12;
                    f5 = f13;
                } else {
                    f6 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                }
            }
        } else {
            f5 = f;
            f6 = f2;
        }
        if (f4 > f7) {
            float f14 = (f4 - f2) / (f3 - f);
            float f15 = f * f14;
            f3 = ((f7 - f2) + f15) / f14;
            if (f3 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f4 = f2 - f15;
                f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            } else {
                float f16 = i2;
                if (f3 > f16) {
                    f4 = ((f14 * f16) + f2) - f15;
                    f3 = f16;
                } else {
                    f4 = f7;
                }
            }
        } else if (f4 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            float f17 = (f4 - f2) / (f3 - f);
            float f18 = f * f17;
            f3 = ((-f2) + f18) / f17;
            if (f3 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                f4 = f2 - f18;
                f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            } else {
                float f19 = i2;
                if (f3 > f19) {
                    f4 = ((f17 * f19) + f2) - f18;
                    f3 = f19;
                } else {
                    f4 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                }
            }
        }
        return new float[]{f5, f6, f3, f4};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawPath(Canvas canvas, List<Float> list, Paint paint, boolean z) {
        Path path = new Path();
        if (list.size() < 4) {
            return;
        }
        path.moveTo(list.get(0).floatValue(), list.get(1).floatValue());
        path.lineTo(list.get(2).floatValue(), list.get(3).floatValue());
        int size = list.size();
        for (int i = 4; i < size; i += 2) {
            path.lineTo(list.get(i).floatValue(), list.get(i + 1).floatValue());
        }
        if (z) {
            path.lineTo(list.get(0).floatValue(), list.get(1).floatValue());
        }
        canvas.drawPath(path, paint);
    }

    protected void drawPath(Canvas canvas, float[] fArr, Paint paint, boolean z) {
        Canvas canvas2;
        Paint paint2;
        Path path = new Path();
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        if (fArr.length < 4) {
            return;
        }
        float[] m9672a = m9672a(fArr[0], fArr[1], fArr[2], fArr[3], height, width);
        path.moveTo(m9672a[0], m9672a[1]);
        path.lineTo(m9672a[2], m9672a[3]);
        int length = fArr.length;
        for (int i = 4; i < length; i += 2) {
            int i2 = i - 1;
            if (fArr[i2] >= ColumnText.GLOBAL_SPACE_CHAR_RATIO || fArr[i + 1] >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                float f = height;
                if (fArr[i2] <= f || fArr[i + 1] <= f) {
                    float[] m9672a2 = m9672a(fArr[i - 2], fArr[i2], fArr[i], fArr[i + 1], height, width);
                    if (!z) {
                        path.moveTo(m9672a2[0], m9672a2[1]);
                    }
                    path.lineTo(m9672a2[2], m9672a2[3]);
                }
            }
        }
        if (z) {
            path.lineTo(fArr[0], fArr[1]);
            canvas2 = canvas;
            paint2 = paint;
        } else {
            canvas2 = canvas;
            paint2 = paint;
        }
        canvas2.drawPath(path, paint2);
    }

    public String getFitText(String str, float f, Paint paint) {
        int length = str.length();
        if (length == 0) {
            return str;
        }
        String str2 = str;
        int i = 0;
        while (paint.measureText(str2) > f && i < length) {
            i++;
            str2 = String.valueOf(str.substring(0, length - i)) + "...";
        }
        return i == length ? "..." : str2;
    }

    public String getDynamicShowText(String str, float f, Paint paint, int i) {
        int length = str.length();
        if (length == 0) {
            return str;
        }
        String str2 = str;
        int i2 = 0;
        while (paint.measureText(str2) > f && i2 < length) {
            i2++;
            str2 = str.substring(0, length - i2);
        }
        if (i2 == 0) {
            return str2;
        }
        if (i2 == length) {
            int i3 = i % (i2 + 1);
            return str.substring(i3, i3 + 1);
        }
        int i4 = length - i2;
        int i5 = (i / 2) % (length + 2);
        if (i5 < i2 + 1) {
            return str.substring(i5, i4 + i5);
        }
        if (i5 > length - 1) {
            if (i5 == length) {
                return String.valueOf("  ") + str.substring(0, i4 - 2);
            } else if (i5 == length + 1) {
                return String.valueOf(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR) + str.substring(0, i4 - 1);
            } else {
                return str2;
            }
        }
        String substring = str.substring(i5, length);
        int i6 = 0;
        while (substring.length() < i4 && i6 < 2) {
            i6++;
            substring = String.valueOf(substring) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        }
        if (substring.length() < i4) {
            return String.valueOf(substring) + str.substring(0, i4 - substring.length());
        }
        return substring;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLegendSize(DefaultRenderer defaultRenderer, int i, float f) {
        int legendHeight = defaultRenderer.getLegendHeight();
        if (!defaultRenderer.isShowLegend() || legendHeight != 0) {
            i = legendHeight;
        }
        return (defaultRenderer.isShowLegend() || !defaultRenderer.isShowLabels()) ? i : (int) (((defaultRenderer.getLabelsTextSize() * 4.0f) / 3.0f) + f);
    }

    protected void drawLabel(Canvas canvas, String str, DefaultRenderer defaultRenderer, List<RectF> list, int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, int i5, Paint paint, boolean z, boolean z2) {
        AbstractChart abstractChart;
        float f5;
        String str2;
        Canvas canvas2;
        if (defaultRenderer.isShowLabels() || z2) {
            paint.setColor(i5);
            double radians = Math.toRadians(90.0f - (f3 + (f4 / 2.0f)));
            double sin = Math.sin(radians);
            double cos = Math.cos(radians);
            float f6 = i;
            double d = f;
            Double.isNaN(d);
            int round = Math.round(((float) (d * sin)) + f6);
            float f7 = i2;
            Double.isNaN(d);
            int round2 = Math.round(((float) (d * cos)) + f7);
            double d2 = f2;
            Double.isNaN(d2);
            int round3 = Math.round(f6 + ((float) (sin * d2)));
            Double.isNaN(d2);
            int round4 = Math.round(f7 + ((float) (d2 * cos)));
            float labelsTextSize = defaultRenderer.getLabelsTextSize();
            float f8 = labelsTextSize / 2.0f;
            float max = Math.max(f8, 10.0f);
            paint.setTextAlign(Paint.Align.LEFT);
            if (round > round3) {
                max = -max;
                paint.setTextAlign(Paint.Align.RIGHT);
            }
            float f9 = round3;
            float f10 = max + f9;
            float f11 = round4;
            float f12 = i4 - f10;
            if (round > round3) {
                abstractChart = this;
                f5 = f10 - i3;
                str2 = str;
            } else {
                abstractChart = this;
                f5 = f12;
                str2 = str;
            }
            String fitText = abstractChart.getFitText(str2, f5, paint);
            float measureText = paint.measureText(fitText);
            float f13 = f11;
            boolean z3 = false;
            while (!z3 && z) {
                int size = list.size();
                float f14 = f13;
                int i6 = 0;
                boolean z4 = false;
                while (i6 < size && !z4) {
                    RectF rectF = list.get(i6);
                    int i7 = size;
                    if (rectF.intersects(f10, f14, f10 + measureText, f14 + labelsTextSize)) {
                        f14 = Math.max(f14, rectF.bottom);
                        z4 = true;
                    }
                    i6++;
                    size = i7;
                }
                if (z4) {
                    f13 = f14;
                    z3 = false;
                } else {
                    f13 = f14;
                    z3 = true;
                }
            }
            if (z) {
                float f15 = (int) (f13 - f8);
                canvas.drawLine(round, round2, f9, f15, paint);
                canvas.drawLine(f9, f15, f10, f15, paint);
                canvas2 = canvas;
            } else {
                paint.setTextAlign(Paint.Align.CENTER);
                canvas2 = canvas;
            }
            canvas2.drawText(fitText, f10, f13, paint);
            if (z) {
                list.add(new RectF(f10, f13, measureText + f10, labelsTextSize + f13));
            }
        }
    }

    public void setRefreshTimeOut(int i) {
        this.mTimerOut = i;
    }

    public void stopRefreshTimer() {
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mTimerTask = null;
        }
    }
}
