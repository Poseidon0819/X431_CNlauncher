package com.cnlaunch.p112a.p115c;

import android.graphics.Color;
import android.graphics.Paint;
import com.cnlaunch.p112a.p115c.DefaultRenderer;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentParser;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.a.c.e */
/* loaded from: classes.dex */
public final class XYMultipleSeriesRenderer extends DefaultRenderer {
    private Map<Integer, double[]> initialRange;
    private float mAxisTitleTextSize;
    private double mBarSpacing;
    private float mBarWidth;
    private int[] mGridColors;
    private int mMarginsColor;
    private double[] mMaxX;
    private double[] mMaxY;
    private double[] mMinX;
    private double[] mMinY;
    private DefaultRenderer.EnumC1407a mOrientation;
    private double[] mPanLimits;
    private boolean mPanXEnabled;
    private boolean mPanYEnabled;
    private float mPointSize;
    private int mXInnerLabels;
    private NumberFormat mXLabelFormat;
    private int mXLabels;
    private float mXLabelsAngle;
    private int mXLabelsColor;
    private float mXLabelsPadding;
    private boolean mXRoundedLabels;
    private Map<Double, String> mXTextLabels;
    private String mXTitle;
    private int[] mYInnerLabels;
    private NumberFormat[] mYLabelFormat;
    private Map<Integer, Map<String, Integer>> mYLabelMaps;
    private int mYLabels;
    private float mYLabelsAngle;
    private int[] mYLabelsColor;
    private float mYLabelsPadding;
    private float mYLabelsVerticalPadding;
    private boolean mYLableVertical;
    private Map<Integer, Map<Double, String>> mYTextLabels;
    private String[] mYTitle;
    private double mZoomInLimitX;
    private double mZoomInLimitY;
    private double[] mZoomLimits;
    private boolean mZoomXEnabled;
    private boolean mZoomYEnabled;
    private int scalesCount;
    private Paint.Align xLabelsAlign;
    private Paint.Align[] yAxisAlign;
    private Paint.Align[] yLabelsAlign;

    public XYMultipleSeriesRenderer() {
        this(1);
    }

    public XYMultipleSeriesRenderer(int i) {
        this.mYLabelMaps = new LinkedHashMap();
        this.mXTitle = "";
        this.mAxisTitleTextSize = 12.0f;
        this.mXLabels = 5;
        this.mXInnerLabels = 1;
        this.mYLabels = 5;
        this.mOrientation = DefaultRenderer.EnumC1407a.HORIZONTAL;
        this.mXTextLabels = new HashMap();
        this.mYTextLabels = new LinkedHashMap();
        this.mPanXEnabled = true;
        this.mPanYEnabled = true;
        this.mZoomXEnabled = true;
        this.mZoomYEnabled = true;
        this.mBarSpacing = 0.0d;
        this.mMarginsColor = 0;
        this.initialRange = new LinkedHashMap();
        this.mPointSize = 3.0f;
        this.xLabelsAlign = Paint.Align.CENTER;
        this.mXLabelsPadding = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.mYLabelsPadding = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.mYLabelsVerticalPadding = 2.0f;
        this.mXLabelsColor = DefaultRenderer.TEXT_COLOR;
        this.mYLabelsColor = new int[]{DefaultRenderer.TEXT_COLOR};
        this.mXRoundedLabels = true;
        this.mBarWidth = -1.0f;
        this.mZoomInLimitX = 0.0d;
        this.mZoomInLimitY = 0.0d;
        this.mYLableVertical = false;
        this.scalesCount = i;
        initAxesRange(i);
    }

    public final void initAxesRange(int i) {
        this.mYTitle = new String[i];
        this.yLabelsAlign = new Paint.Align[i];
        this.yAxisAlign = new Paint.Align[i];
        this.mYLabelsColor = new int[i];
        this.mYLabelFormat = new NumberFormat[i];
        this.mMinX = new double[i];
        this.mMaxX = new double[i];
        this.mMinY = new double[i];
        this.mMaxY = new double[i];
        this.mGridColors = new int[i];
        this.mYInnerLabels = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.mYLabelsColor[i2] = -3355444;
            this.mYLabelFormat[i2] = NumberFormat.getNumberInstance();
            this.mGridColors[i2] = Color.argb(75, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE);
            this.mYInnerLabels[i2] = 5;
            initAxesRangeForScale(i2);
        }
    }

    public final void initAxesRangeForScale(int i) {
        double[] dArr = this.mMinX;
        dArr[i] = Double.MAX_VALUE;
        double[] dArr2 = this.mMaxX;
        dArr2[i] = -1.7976931348623157E308d;
        double[] dArr3 = this.mMinY;
        dArr3[i] = Double.MAX_VALUE;
        double[] dArr4 = this.mMaxY;
        dArr4[i] = -1.7976931348623157E308d;
        this.initialRange.put(Integer.valueOf(i), new double[]{dArr[i], dArr2[i], dArr3[i], dArr4[i]});
        this.mYTitle[i] = "";
        this.mYTextLabels.put(Integer.valueOf(i), new HashMap());
        this.mYLabelMaps.put(Integer.valueOf(i), new LinkedHashMap());
        this.yLabelsAlign[i] = Paint.Align.CENTER;
        this.yAxisAlign[i] = Paint.Align.LEFT;
    }

    public final DefaultRenderer.EnumC1407a getOrientation() {
        return this.mOrientation;
    }

    public final void setOrientation(DefaultRenderer.EnumC1407a enumC1407a) {
        this.mOrientation = enumC1407a;
    }

    public final String getXTitle() {
        return this.mXTitle;
    }

    public final void setXTitle(String str) {
        this.mXTitle = str;
    }

    public final String getYTitle() {
        return getYTitle(0);
    }

    public final String getYTitle(int i) {
        return this.mYTitle[i];
    }

    public final void setYTitle(String str) {
        setYTitle(str, 0);
    }

    public final void setYTitle(String str, int i) {
        this.mYTitle[i] = str;
    }

    public final float getAxisTitleTextSize() {
        return this.mAxisTitleTextSize;
    }

    public final void setAxisTitleTextSize(float f) {
        this.mAxisTitleTextSize = f;
    }

    public final double getXAxisMin() {
        return getXAxisMin(0);
    }

    public final void setXAxisMin(double d) {
        setXAxisMin(d, 0);
    }

    public final boolean isMinXSet() {
        return isMinXSet(0);
    }

    public final double getXAxisMax() {
        return getXAxisMax(0);
    }

    public final void setXAxisMax(double d) {
        setXAxisMax(d, 0);
    }

    public final boolean isMaxXSet() {
        return isMaxXSet(0);
    }

    public final double getYAxisMin() {
        return getYAxisMin(0);
    }

    public final void setYAxisMin(double d) {
        setYAxisMin(d, 0);
    }

    public final boolean isMinYSet() {
        return isMinYSet(0);
    }

    public final double getYAxisMax() {
        return getYAxisMax(0);
    }

    public final void setYAxisMax(double d) {
        setYAxisMax(d, 0);
    }

    public final boolean isMaxYSet() {
        return isMaxYSet(0);
    }

    public final double getXAxisMin(int i) {
        return this.mMinX[i];
    }

    public final void setXAxisMin(double d, int i) {
        if (!isMinXSet(i)) {
            this.initialRange.get(Integer.valueOf(i))[0] = d;
        }
        this.mMinX[i] = d;
    }

    public final boolean isMinXSet(int i) {
        return this.mMinX[i] != Double.MAX_VALUE;
    }

    public final double getXAxisMax(int i) {
        return this.mMaxX[i];
    }

    public final void setXAxisMax(double d, int i) {
        if (!isMaxXSet(i)) {
            this.initialRange.get(Integer.valueOf(i))[1] = d;
        }
        this.mMaxX[i] = d;
    }

    public final boolean isMaxXSet(int i) {
        return this.mMaxX[i] != -1.7976931348623157E308d;
    }

    public final double getYAxisMin(int i) {
        return this.mMinY[i];
    }

    public final void setYAxisMin(double d, int i) {
        if (!isMinYSet(i)) {
            this.initialRange.get(Integer.valueOf(i))[2] = d;
        }
        this.mMinY[i] = d;
    }

    public final boolean isMinYSet(int i) {
        return this.mMinY[i] != Double.MAX_VALUE;
    }

    public final double getYAxisMax(int i) {
        return this.mMaxY[i];
    }

    public final void setYAxisMax(double d, int i) {
        if (!isMaxYSet(i)) {
            this.initialRange.get(Integer.valueOf(i))[3] = d;
        }
        this.mMaxY[i] = d;
    }

    public final boolean isMaxYSet(int i) {
        return this.mMaxY[i] != -1.7976931348623157E308d;
    }

    public final int getXLabels() {
        return this.mXLabels;
    }

    public final void setXLabels(int i) {
        this.mXLabels = i;
    }

    public final int getInnerXLabels() {
        return this.mXInnerLabels;
    }

    public final void setInnerXLabels(int i) {
        this.mXInnerLabels = i;
    }

    public final void addTextLabel(double d, String str) {
        addXTextLabel(d, str);
    }

    public final synchronized void addXTextLabel(double d, String str) {
        this.mXTextLabels.put(Double.valueOf(d), str);
    }

    public final synchronized void removeXTextLabel(double d) {
        this.mXTextLabels.remove(Double.valueOf(d));
    }

    public final synchronized String getXTextLabel(Double d) {
        return this.mXTextLabels.get(d);
    }

    public final synchronized Double[] getXTextLabelLocations() {
        return (Double[]) this.mXTextLabels.keySet().toArray(new Double[0]);
    }

    public final void clearTextLabels() {
        clearXTextLabels();
    }

    public final synchronized void clearXTextLabels() {
        this.mXTextLabels.clear();
    }

    public final boolean isXRoundedLabels() {
        return this.mXRoundedLabels;
    }

    public final void setXRoundedLabels(boolean z) {
        this.mXRoundedLabels = z;
    }

    public final void addYTextLabel(double d, String str) {
        addYTextLabel(d, str, 0);
    }

    public final void removeYTextLabel(double d) {
        removeYTextLabel(d, 0);
    }

    public final synchronized void addYTextLabel(double d, String str, int i) {
        this.mYTextLabels.get(Integer.valueOf(i)).put(Double.valueOf(d), str);
    }

    public final synchronized void removeYTextLabel(double d, int i) {
        this.mYTextLabels.get(Integer.valueOf(i)).remove(Double.valueOf(d));
    }

    public final String getYTextLabel(Double d) {
        return getYTextLabel(d, 0);
    }

    public final synchronized String getYTextLabel(Double d, int i) {
        return this.mYTextLabels.get(Integer.valueOf(i)).get(d);
    }

    public final Double[] getYTextLabelLocations() {
        return getYTextLabelLocations(0);
    }

    public final synchronized Double[] getYTextLabelLocations(int i) {
        return (Double[]) this.mYTextLabels.get(Integer.valueOf(i)).keySet().toArray(new Double[0]);
    }

    public final void clearYTextLabels() {
        clearYTextLabels(0);
    }

    public final synchronized void clearYTextLabels(int i) {
        this.mYTextLabels.get(Integer.valueOf(i)).clear();
    }

    public final Map<String, Integer> getYLabelMap(int i) {
        return this.mYLabelMaps.get(Integer.valueOf(i));
    }

    public final int getYLabels() {
        return this.mYLabels;
    }

    public final void setYLabels(int i) {
        this.mYLabels = i;
    }

    public final int getYInnerLabels() {
        return getYInnerLabels(0);
    }

    public final int getYInnerLabels(int i) {
        return this.mYInnerLabels[i];
    }

    public final void setYInnerLabels(int i) {
        this.mYInnerLabels[0] = i;
    }

    public final void setYInnerLabels(int i, int i2) {
        this.mYInnerLabels[i2] = i;
    }

    public final float getBarWidth() {
        return this.mBarWidth;
    }

    public final void setBarWidth(float f) {
        this.mBarWidth = f;
    }

    @Override // com.cnlaunch.p112a.p115c.DefaultRenderer
    public final boolean isPanEnabled() {
        return isPanXEnabled() || isPanYEnabled();
    }

    public final boolean isPanXEnabled() {
        return this.mPanXEnabled;
    }

    public final boolean isPanYEnabled() {
        return this.mPanYEnabled;
    }

    public final void setPanEnabled(boolean z, boolean z2) {
        this.mPanXEnabled = z;
        this.mPanYEnabled = z2;
    }

    @Override // com.cnlaunch.p112a.p115c.DefaultRenderer
    public final void setPanEnabled(boolean z) {
        setPanEnabled(z, z);
    }

    @Override // com.cnlaunch.p112a.p115c.DefaultRenderer
    public final boolean isZoomEnabled() {
        return isZoomXEnabled() || isZoomYEnabled();
    }

    public final boolean isZoomXEnabled() {
        return this.mZoomXEnabled;
    }

    public final boolean isZoomYEnabled() {
        return this.mZoomYEnabled;
    }

    public final void setZoomEnabled(boolean z, boolean z2) {
        this.mZoomXEnabled = z;
        this.mZoomYEnabled = z2;
    }

    public final double getBarsSpacing() {
        return getBarSpacing();
    }

    public final double getBarSpacing() {
        return this.mBarSpacing;
    }

    public final void setBarSpacing(double d) {
        this.mBarSpacing = d;
    }

    public final int getMarginsColor() {
        return this.mMarginsColor;
    }

    public final void setMarginsColor(int i) {
        this.mMarginsColor = i;
    }

    public final int getGridColor(int i) {
        return this.mGridColors[i];
    }

    public final void setGridColor(int i) {
        setGridColor(i, 0);
    }

    public final void setGridColor(int i, int i2) {
        this.mGridColors[i2] = i;
    }

    public final double[] getPanLimits() {
        return this.mPanLimits;
    }

    public final void setPanLimits(double[] dArr) {
        this.mPanLimits = dArr;
    }

    public final double[] getZoomLimits() {
        return this.mZoomLimits;
    }

    public final void setZoomLimits(double[] dArr) {
        this.mZoomLimits = dArr;
    }

    public final float getXLabelsAngle() {
        return this.mXLabelsAngle;
    }

    public final void setXLabelsAngle(float f) {
        this.mXLabelsAngle = f;
    }

    public final float getYLabelsAngle() {
        return this.mYLabelsAngle;
    }

    public final void setYLabelsAngle(float f) {
        this.mYLabelsAngle = f;
    }

    public final float getPointSize() {
        return this.mPointSize;
    }

    public final void setPointSize(float f) {
        this.mPointSize = f;
    }

    public final void setRange(double[] dArr) {
        setRange(dArr, 0);
    }

    public final void setRange(double[] dArr, int i) {
        setXAxisMin(dArr[0], i);
        setXAxisMax(dArr[1], i);
        setYAxisMin(dArr[2], i);
        setYAxisMax(dArr[3], i);
    }

    public final boolean isInitialRangeSet() {
        return isInitialRangeSet(0);
    }

    public final boolean isInitialRangeSet(int i) {
        return this.initialRange.get(Integer.valueOf(i)) != null;
    }

    public final double[] getInitialRange() {
        return getInitialRange(0);
    }

    public final double[] getInitialRange(int i) {
        return this.initialRange.get(Integer.valueOf(i));
    }

    public final void setInitialRange(double[] dArr) {
        setInitialRange(dArr, 0);
    }

    public final void setInitialRange(double[] dArr, int i) {
        this.initialRange.put(Integer.valueOf(i), dArr);
    }

    public final int getXLabelsColor() {
        return this.mXLabelsColor;
    }

    public final int getYLabelsColor(int i) {
        return this.mYLabelsColor[i];
    }

    public final void setXLabelsColor(int i) {
        this.mXLabelsColor = i;
    }

    public final void setYLabelsColor(int i, int i2) {
        this.mYLabelsColor[i] = i2;
    }

    public final Paint.Align getXLabelsAlign() {
        return this.xLabelsAlign;
    }

    public final void setXLabelsAlign(Paint.Align align) {
        this.xLabelsAlign = align;
    }

    public final Paint.Align getYLabelsAlign(int i) {
        return this.yLabelsAlign[i];
    }

    public final void setYLabelsAlign(Paint.Align align) {
        setYLabelsAlign(align, 0);
    }

    public final Paint.Align getYAxisAlign(int i) {
        return this.yAxisAlign[i];
    }

    public final void setYAxisAlign(Paint.Align align, int i) {
        this.yAxisAlign[i] = align;
    }

    public final void setYLabelsAlign(Paint.Align align, int i) {
        this.yLabelsAlign[i] = align;
    }

    public final float getXLabelsPadding() {
        return this.mXLabelsPadding;
    }

    public final void setXLabelsPadding(float f) {
        this.mXLabelsPadding = f;
    }

    public final float getYLabelsPadding() {
        return this.mYLabelsPadding;
    }

    public final void setYLabelsVerticalPadding(float f) {
        this.mYLabelsVerticalPadding = f;
    }

    public final float getYLabelsVerticalPadding() {
        return this.mYLabelsVerticalPadding;
    }

    public final void setYLabelsPadding(float f) {
        this.mYLabelsPadding = f;
    }

    public final NumberFormat getLabelFormat() {
        return getXLabelFormat();
    }

    public final void setLabelFormat(NumberFormat numberFormat) {
        setXLabelFormat(numberFormat);
    }

    public final NumberFormat getXLabelFormat() {
        return this.mXLabelFormat;
    }

    public final void setXLabelFormat(NumberFormat numberFormat) {
        this.mXLabelFormat = numberFormat;
    }

    public final NumberFormat getYLabelFormat(int i) {
        return this.mYLabelFormat[i];
    }

    public final void setYLabelFormat(NumberFormat numberFormat, int i) {
        this.mYLabelFormat[i] = numberFormat;
    }

    public final double getZoomInLimitX() {
        return this.mZoomInLimitX;
    }

    public final void setZoomInLimitX(double d) {
        this.mZoomInLimitX = d;
    }

    public final double getZoomInLimitY() {
        return this.mZoomInLimitY;
    }

    public final void setZoomInLimitY(double d) {
        this.mZoomInLimitY = d;
    }

    public final int getScalesCount() {
        return this.scalesCount;
    }

    public final boolean isYLableVertical() {
        return this.mYLableVertical;
    }

    public final void setYLableVertical(boolean z) {
        this.mYLableVertical = z;
    }
}
