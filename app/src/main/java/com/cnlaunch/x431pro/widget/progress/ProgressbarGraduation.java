package com.cnlaunch.x431pro.widget.progress;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import com.ifoer.expedition.p348a.C3592a;
import com.itextpdf.text.pdf.ColumnText;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ProgressbarGraduation extends View {

    /* renamed from: a */
    private Context f16601a;

    /* renamed from: b */
    private float f16602b;

    /* renamed from: c */
    private float f16603c;

    /* renamed from: d */
    private float f16604d;

    /* renamed from: e */
    private int f16605e;

    /* renamed from: f */
    private int f16606f;

    /* renamed from: g */
    private float f16607g;

    /* renamed from: h */
    private int f16608h;

    /* renamed from: i */
    private float f16609i;

    /* renamed from: j */
    private float f16610j;

    /* renamed from: k */
    private Paint f16611k;

    /* renamed from: l */
    private float f16612l;

    /* renamed from: m */
    private float f16613m;

    /* renamed from: n */
    private NumberFormat f16614n;

    public ProgressbarGraduation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16601a = null;
        this.f16602b = 10.0f;
        this.f16603c = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16604d = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16605e = Color.argb(255, 246, 139, 0);
        this.f16606f = 0;
        this.f16607g = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16608h = 0;
        this.f16609i = 11.0f;
        this.f16610j = -1.6777216E7f;
        this.f16612l = 2.0f;
        this.f16613m = 2.0f;
        this.f16614n = null;
        this.f16601a = context;
        this.f16611k = new Paint();
        this.f16611k.setAntiAlias(true);
        setAttributes(attributeSet);
        this.f16614n = NumberFormat.getInstance();
        this.f16614n.setGroupingUsed(false);
    }

    private void setAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f16601a.obtainStyledAttributes(attributeSet, C3592a.C3593a.ProgressbarGraduationAttributes);
        this.f16602b = obtainStyledAttributes.getFloat(5, 10.0f);
        this.f16603c = obtainStyledAttributes.getFloat(6, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.f16604d = obtainStyledAttributes.getFloat(7, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.f16605e = obtainStyledAttributes.getColor(1, Color.argb(255, 246, 139, 0));
        this.f16606f = obtainStyledAttributes.getResourceId(0, 0);
        this.f16607g = obtainStyledAttributes.getDimension(8, 5.0f);
        this.f16608h = obtainStyledAttributes.getInt(2, 0);
        this.f16609i = obtainStyledAttributes.getFloat(4, 11.0f);
        this.f16610j = obtainStyledAttributes.getFloat(3, -1.6777216E7f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    @ViewDebug.ExportedProperty(deepExport = true, prefix = "layout_")
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        if (layoutParams.height == -2) {
            layoutParams.height = 45;
        }
        if (layoutParams.width == -2) {
            layoutParams.width = 150;
        }
        return layoutParams;
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        float height = getHeight();
        Paint paint = this.f16611k;
        int color = paint.getColor();
        Paint.Style style = paint.getStyle();
        float strokeWidth = paint.getStrokeWidth();
        float f = this.f16612l;
        float f2 = f + ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO + f;
        float f4 = width - (f * 2.0f);
        float labelTextSize = ((height - (f * 2.0f)) - getLabelTextSize()) - this.f16613m;
        if (getLabelCount() <= 0) {
            labelTextSize = height - (this.f16612l * 2.0f);
        }
        paint.setColor(this.f16605e);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        float f5 = f4 + f2;
        RectF rectF = new RectF(f2, f3, f5, f3 + labelTextSize);
        float f6 = this.f16607g;
        canvas.drawRoundRect(rectF, f6, f6, this.f16611k);
        float progress = getProgress();
        paint.setColor(this.f16605e);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1.0f);
        float f7 = f2 + 2.0f;
        float f8 = f3 + 2.0f;
        float progressMin = (((progress - getProgressMin()) / (getProgressMax() - getProgressMin())) * f5) + f7;
        float f9 = (labelTextSize + f8) - 4.0f;
        if (progressMin < getProgressMin()) {
            progressMin = getProgressMin();
        } else if (progressMin > f5) {
            progressMin = f5 - 2.0f;
        }
        RectF rectF2 = new RectF(f7, f8, progressMin, f9);
        float f10 = this.f16607g;
        canvas.drawRoundRect(rectF2, f10 - 1.0f, f10, paint);
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(strokeWidth);
        if (getLabelCount() > 0) {
            m4478a(rectF, canvas, this.f16611k);
        }
    }

    /* renamed from: a */
    private void m4478a(RectF rectF, Canvas canvas, Paint paint) {
        RectF rectF2 = rectF;
        List<String> progressbarLabels = getProgressbarLabels();
        int size = progressbarLabels.size();
        float width = rectF.width() / getLabelCount();
        int i = 0;
        while (i < size) {
            String str = progressbarLabels.get(i);
            float measureText = paint.measureText(str);
            float f = rectF2.left + (i * width);
            if (i != 0) {
                f = size + (-1) == i ? f - measureText : f - (measureText / 2.0f);
            }
            float labelTextSize = getLabelTextSize();
            float labelTextColor = getLabelTextColor();
            float f2 = rectF2.bottom + this.f16613m;
            Paint.Style style = paint.getStyle();
            Paint.Align textAlign = paint.getTextAlign();
            int flags = paint.getFlags();
            int color = paint.getColor();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor((int) labelTextColor);
            paint.setTextSize(labelTextSize);
            RectF rectF3 = new RectF(f, f2, paint.measureText(str) + f, labelTextSize + f2);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.drawText(str, rectF3.centerX(), (rectF3.top + ((((rectF3.bottom - rectF3.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2.0f)) - fontMetricsInt.top, paint);
            paint.setStyle(style);
            paint.setTextAlign(textAlign);
            paint.setFlags(flags);
            paint.setColor(color);
            i++;
            rectF2 = rectF;
        }
    }

    private List<String> getProgressbarLabels() {
        String valueOf;
        ArrayList arrayList = new ArrayList();
        float progressMax = (getProgressMax() - getProgressMin()) / getLabelCount();
        int labelCount = getLabelCount() + 1;
        for (int i = 0; i < labelCount; i++) {
            NumberFormat numberFormat = this.f16614n;
            float progressMin = (i * progressMax) + getProgressMin();
            if (numberFormat != null) {
                valueOf = numberFormat.format(progressMin);
            } else if (progressMin == Math.round(progressMin)) {
                StringBuilder sb = new StringBuilder();
                sb.append(Math.round(progressMin));
                valueOf = sb.toString();
            } else {
                valueOf = String.valueOf(progressMin);
            }
            arrayList.add(valueOf);
        }
        return arrayList;
    }

    public float getProgressMax() {
        return this.f16602b;
    }

    public void setProgressMax(float f) {
        this.f16602b = f;
    }

    public float getProgressMin() {
        return this.f16603c;
    }

    public void setProgressMin(float f) {
        this.f16603c = f;
    }

    public float getProgress() {
        return this.f16604d;
    }

    public void setProgress(float f) {
        this.f16604d = f;
        invalidate();
    }

    public int getColor() {
        return this.f16605e;
    }

    public void setColor(int i) {
        this.f16605e = i;
    }

    public int getLabelCount() {
        return this.f16608h;
    }

    public void setLabelCount(int i) {
        this.f16608h = i;
    }

    public float getLabelTextSize() {
        return this.f16609i;
    }

    public void setLabelTextSize(float f) {
        this.f16609i = f;
    }

    public float getLabelTextColor() {
        return this.f16610j;
    }

    public void setLabelTextColor(float f) {
        this.f16610j = f;
    }
}
