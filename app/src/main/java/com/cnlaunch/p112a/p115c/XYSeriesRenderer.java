package com.cnlaunch.p112a.p115c;

import android.graphics.Color;
import android.graphics.Paint;
import com.itextpdf.text.pdf.PdfContentParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.a.c.f */
/* loaded from: classes.dex */
public final class XYSeriesRenderer extends SimpleSeriesRenderer {
    private boolean mDisplayChartValues;
    private boolean mFillPoints = false;
    private List<C1408a> mFillBelowLine = new ArrayList();
    private float mPointStrokeWidth = 1.0f;
    private float mLineWidth = 1.0f;
    private int mDisplayChartValuesDistance = 100;
    private float mChartValuesTextSize = 10.0f;
    private Paint.Align mChartValuesTextAlign = Paint.Align.CENTER;
    private float mChartValuesSpacing = 5.0f;
    private float mAnnotationsTextSize = 10.0f;
    private Paint.Align mAnnotationsTextAlign = Paint.Align.CENTER;
    private int mAnnotationsColor = DefaultRenderer.TEXT_COLOR;

    /* compiled from: XYSeriesRenderer.java */
    /* renamed from: com.cnlaunch.a.c.f$a */
    /* loaded from: classes.dex */
    public static class C1408a implements Serializable {
        private int mColor = Color.argb(125, 0, 0, (int) PdfContentParser.COMMAND_TYPE);
        private int[] mFillRange;
        private final EnumC1409a mType;

        /* compiled from: XYSeriesRenderer.java */
        /* renamed from: com.cnlaunch.a.c.f$a$a */
        /* loaded from: classes.dex */
        public enum EnumC1409a {
            NONE,
            BOUNDS_ALL,
            BOUNDS_BELOW,
            BOUNDS_ABOVE,
            BELOW,
            ABOVE;

            /* renamed from: values  reason: to resolve conflict with enum method */
            public static EnumC1409a[] valuesCustom() {
                EnumC1409a[] valuesCustom = values();
                int length = valuesCustom.length;
                EnumC1409a[] enumC1409aArr = new EnumC1409a[length];
                System.arraycopy(valuesCustom, 0, enumC1409aArr, 0, length);
                return enumC1409aArr;
            }
        }

        public C1408a(EnumC1409a enumC1409a) {
            this.mType = enumC1409a;
        }

        public final int getColor() {
            return this.mColor;
        }

        public final void setColor(int i) {
            this.mColor = i;
        }

        public final EnumC1409a getType() {
            return this.mType;
        }

        public final int[] getFillRange() {
            return this.mFillRange;
        }

        public final void setFillRange(int[] iArr) {
            this.mFillRange = iArr;
        }
    }

    @Deprecated
    public final boolean isFillBelowLine() {
        return this.mFillBelowLine.size() > 0;
    }

    @Deprecated
    public final void setFillBelowLine(boolean z) {
        this.mFillBelowLine.clear();
        if (z) {
            this.mFillBelowLine.add(new C1408a(C1408a.EnumC1409a.BOUNDS_ALL));
        } else {
            this.mFillBelowLine.add(new C1408a(C1408a.EnumC1409a.NONE));
        }
    }

    public final C1408a[] getFillOutsideLine() {
        return (C1408a[]) this.mFillBelowLine.toArray(new C1408a[0]);
    }

    public final void addFillOutsideLine(C1408a c1408a) {
        this.mFillBelowLine.add(c1408a);
    }

    public final boolean isFillPoints() {
        return this.mFillPoints;
    }

    public final void setFillPoints(boolean z) {
        this.mFillPoints = z;
    }

    @Deprecated
    public final void setFillBelowLineColor(int i) {
        if (this.mFillBelowLine.size() > 0) {
            this.mFillBelowLine.get(0).setColor(i);
        }
    }

    public final float getPointStrokeWidth() {
        return this.mPointStrokeWidth;
    }

    public final void setPointStrokeWidth(float f) {
        this.mPointStrokeWidth = f;
    }

    public final float getLineWidth() {
        return this.mLineWidth;
    }

    public final void setLineWidth(float f) {
        this.mLineWidth = f;
    }

    public final boolean isDisplayChartValues() {
        return this.mDisplayChartValues;
    }

    public final void setDisplayChartValues(boolean z) {
        this.mDisplayChartValues = z;
    }

    public final int getDisplayChartValuesDistance() {
        return this.mDisplayChartValuesDistance;
    }

    public final void setDisplayChartValuesDistance(int i) {
        this.mDisplayChartValuesDistance = i;
    }

    public final float getChartValuesTextSize() {
        return this.mChartValuesTextSize;
    }

    public final void setChartValuesTextSize(float f) {
        this.mChartValuesTextSize = f;
    }

    public final Paint.Align getChartValuesTextAlign() {
        return this.mChartValuesTextAlign;
    }

    public final void setChartValuesTextAlign(Paint.Align align) {
        this.mChartValuesTextAlign = align;
    }

    public final float getChartValuesSpacing() {
        return this.mChartValuesSpacing;
    }

    public final void setChartValuesSpacing(float f) {
        this.mChartValuesSpacing = f;
    }

    public final float getAnnotationsTextSize() {
        return this.mAnnotationsTextSize;
    }

    public final void setAnnotationsTextSize(float f) {
        this.mAnnotationsTextSize = f;
    }

    public final Paint.Align getAnnotationsTextAlign() {
        return this.mAnnotationsTextAlign;
    }

    public final void setAnnotationsTextAlign(Paint.Align align) {
        this.mAnnotationsTextAlign = align;
    }

    public final int getAnnotationsColor() {
        return this.mAnnotationsColor;
    }

    public final void setAnnotationsColor(int i) {
        this.mAnnotationsColor = i;
    }
}
