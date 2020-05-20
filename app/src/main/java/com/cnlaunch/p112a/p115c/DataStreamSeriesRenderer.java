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

/* renamed from: com.cnlaunch.a.c.b */
/* loaded from: classes.dex */
public final class DataStreamSeriesRenderer extends DefaultRenderer {
    private double[] initialRange;
    private double[] mBottomRange;
    private double mMaxX;
    private double mMaxY;
    private double mMinX;
    private double mMinY;
    private double[] mStandRange;
    private double[] mTopRange;
    private NumberFormat mXLabelFormat;
    private float mXLabelsAngle;
    private NumberFormat mYLabelFormat;
    private float mYLabelsAngle;
    private Map<String, Integer> mYLabelMap = new LinkedHashMap();
    private String mXTitle = "";
    private String mYTitle = "";
    private float mAxisTitleTextSize = 12.0f;
    private int mXLabels = 5;
    private int mYLabels = 5;
    private int mYInnerLabels = 5;
    private DefaultRenderer.EnumC1407a mOrientation = DefaultRenderer.EnumC1407a.HORIZONTAL;
    private Map<Double, String> mXTextLabels = new HashMap();
    private Map<Double, String> mYTextLabels = new HashMap();
    private float mPointSize = 3.0f;
    private int mGridColor = Color.argb(75, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE);
    private Paint.Align xLabelsAlign = Paint.Align.CENTER;
    private Paint.Align mYLabelsAlign = Paint.Align.CENTER;
    private float mXLabelsPadding = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private float mYLabelsPadding = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private float mYLabelsVerticalPadding = 2.0f;
    private Paint.Align yAxisAlign = Paint.Align.LEFT;
    private int mXLabelsColor = DefaultRenderer.TEXT_COLOR;
    private int mYLabelsColor = DefaultRenderer.TEXT_COLOR;
    private boolean mXRoundedLabels = true;
    private boolean mShowGridXBaseline = false;
    private boolean mShowColorRect = false;
    private int mColorTop = Color.argb(75, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE);
    private int mColorBottom = Color.argb(75, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE);
    private boolean mShowStandRect = false;
    private int mColorStand = Color.argb(75, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE, (int) PdfContentParser.COMMAND_TYPE);

    public final boolean ismShowStandRect() {
        return this.mShowStandRect;
    }

    public final void setmShowStandRect(boolean z) {
        this.mShowStandRect = z;
    }

    public final double[] getmStandRange() {
        return this.mStandRange;
    }

    public final void setmStandRange(double[] dArr) {
        this.mStandRange = dArr;
    }

    public final int getmColorStand() {
        return this.mColorStand;
    }

    public final void setmColorStand(int i) {
        this.mColorStand = i;
    }

    public final void setShowColorRect(boolean z) {
        this.mShowColorRect = z;
    }

    public final boolean getShowColorRect() {
        return this.mShowColorRect;
    }

    public final void setColorTop(int i) {
        this.mColorTop = i;
    }

    public final int getColorTop() {
        return this.mColorTop;
    }

    public final void setColorBottom(int i) {
        this.mColorBottom = i;
    }

    public final int getColorBottom() {
        return this.mColorBottom;
    }

    public final void setTopRange(double[] dArr) {
        this.mTopRange = dArr;
    }

    public final double[] getTopRange() {
        return this.mTopRange;
    }

    public final void setBottomRange(double[] dArr) {
        this.mBottomRange = dArr;
    }

    public final double[] getBottomRange() {
        return this.mBottomRange;
    }

    public DataStreamSeriesRenderer() {
        initAxesRange();
    }

    public final void initAxesRange() {
        this.mYTitle = "";
        this.mYLabelsAlign = Paint.Align.CENTER;
        this.yAxisAlign = Paint.Align.LEFT;
        this.mMinX = Double.MAX_VALUE;
        this.mMaxX = -1.7976931348623157E308d;
        this.mMinY = Double.MAX_VALUE;
        this.mMaxY = -1.7976931348623157E308d;
        this.initialRange = new double[]{this.mMinX, this.mMaxX, this.mMinY, this.mMaxY};
        this.mYTextLabels = new HashMap();
        this.mYLabelsColor = DefaultRenderer.TEXT_COLOR;
        this.mYLabelFormat = NumberFormat.getNumberInstance();
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
        return this.mYTitle;
    }

    public final void setYTitle(String str) {
        this.mYTitle = str;
    }

    public final float getAxisTitleTextSize() {
        return this.mAxisTitleTextSize;
    }

    public final void setAxisTitleTextSize(float f) {
        this.mAxisTitleTextSize = f;
    }

    public final double getXAxisMin() {
        return this.mMinX;
    }

    public final void setXAxisMin(double d) {
        this.mMinX = d;
    }

    public final double getXAxisMax() {
        return this.mMaxX;
    }

    public final boolean isMinXSet() {
        return this.mMinX != Double.MAX_VALUE;
    }

    public final void setXAxisMax(double d) {
        if (!isMaxXSet()) {
            this.initialRange[1] = d;
        }
        this.mMaxX = d;
    }

    public final boolean isMaxXSet() {
        return this.mMaxX != -1.7976931348623157E308d;
    }

    public final double getYAxisMin() {
        return this.mMinY;
    }

    public final void setYAxisMin(double d) {
        if (!isMinYSet()) {
            this.initialRange[2] = d;
        }
        this.mMinY = d;
    }

    public final boolean isMinYSet() {
        return this.mMinY != Double.MAX_VALUE;
    }

    public final double getYAxisMax() {
        return this.mMaxY;
    }

    public final void setYAxisMax(double d) {
        if (!isMaxYSet()) {
            this.initialRange[3] = d;
        }
        this.mMaxY = d;
    }

    public final boolean isMaxYSet() {
        return this.mMaxY != -1.7976931348623157E308d;
    }

    public final int getXLabels() {
        return this.mXLabels;
    }

    public final void setXLabels(int i) {
        this.mXLabels = i;
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

    public final synchronized void addYTextLabel(double d, String str) {
        this.mYTextLabels.put(Double.valueOf(d), str);
    }

    public final synchronized void removeYTextLabel(double d) {
        this.mYTextLabels.remove(Double.valueOf(d));
    }

    public final synchronized String getYTextLabel(Double d) {
        return this.mYTextLabels.get(d);
    }

    public final synchronized Double[] getYTextLabelLocations() {
        return (Double[]) this.mYTextLabels.keySet().toArray(new Double[0]);
    }

    public final synchronized void clearYTextLabels() {
        this.mYTextLabels.clear();
    }

    public final int getYLabels() {
        return this.mYLabels;
    }

    public final void setYLabels(int i) {
        this.mYLabels = i;
    }

    public final int getYInnerLabels() {
        return this.mYInnerLabels;
    }

    public final void setYInnerLabels(int i) {
        this.mYInnerLabels = i;
    }

    public final int getGridColor() {
        return this.mGridColor;
    }

    public final void setGridColor(int i) {
        this.mGridColor = i;
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
        setXAxisMin(dArr[0]);
        setXAxisMax(dArr[1]);
        setYAxisMin(dArr[2]);
        setYAxisMax(dArr[3]);
    }

    public final boolean isInitialRangeSet() {
        return this.initialRange != null;
    }

    public final double[] getInitialRange() {
        return this.initialRange;
    }

    public final void setInitialRange(double[] dArr) {
        this.initialRange = dArr;
    }

    public final int getXLabelsColor() {
        return this.mXLabelsColor;
    }

    public final int getYLabelsColor() {
        return this.mYLabelsColor;
    }

    public final void setXLabelsColor(int i) {
        this.mXLabelsColor = i;
    }

    public final void setYLabelsColor(int i) {
        this.mYLabelsColor = i;
    }

    public final Paint.Align getXLabelsAlign() {
        return this.xLabelsAlign;
    }

    public final void setXLabelsAlign(Paint.Align align) {
        this.xLabelsAlign = align;
    }

    public final void setYAxisAlign(Paint.Align align) {
        this.yAxisAlign = align;
    }

    public final Paint.Align getYAxisAlign() {
        return this.yAxisAlign;
    }

    public final void setYLabelsAlign(Paint.Align align) {
        this.mYLabelsAlign = align;
    }

    public final Paint.Align getYLabelsAlign() {
        return this.mYLabelsAlign;
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

    public final NumberFormat getYLabelFormat() {
        return this.mYLabelFormat;
    }

    public final void setYLabelFormat(NumberFormat numberFormat) {
        this.mYLabelFormat = numberFormat;
    }

    public final Map<String, Integer> getYLabelMap() {
        return this.mYLabelMap;
    }

    public final void setShowGridXBaseline(boolean z) {
        this.mShowGridXBaseline = z;
    }

    public final boolean getShowGridXBaseline() {
        return this.mShowGridXBaseline;
    }
}
