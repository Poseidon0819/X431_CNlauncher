package com.cnlaunch.p112a.p115c;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.itextpdf.text.pdf.ColumnText;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* renamed from: com.cnlaunch.a.c.c */
/* loaded from: classes.dex */
public class DefaultRenderer implements Serializable {
    public static final int BACKGROUND_COLOR = -16777216;
    public static final int NO_COLOR = 0;
    public static final int TEXT_COLOR = -3355444;

    /* renamed from: a */
    private static final Typeface f6723a = Typeface.create(Typeface.SERIF, 0);
    private boolean mApplyBackgroundColor;
    private int mBackgroundColor;
    private boolean mDisplayValues;
    private boolean mInScroll;
    private int mParentBackgroundColor;
    private Typeface mTextTypeface;
    private String mChartTitle = "";
    private float mChartTitleTextSize = 15.0f;
    private String mTextTypefaceName = f6723a.toString();
    private int mTextTypefaceStyle = 0;
    private boolean mShowAxes = true;
    private int mYAxisColor = TEXT_COLOR;
    private int mXAxisColor = TEXT_COLOR;
    private boolean mShowLabels = true;
    private boolean mShowTickMarks = true;
    private int mLabelsColor = TEXT_COLOR;
    private float mLabelsTextSize = 10.0f;
    private boolean mShowLegend = true;
    private float mLegendTextSize = 12.0f;
    private boolean mFitLegend = false;
    private boolean mShowGridX = false;
    private boolean mShowGridY = false;
    private boolean mShowCustomTextGridX = false;
    private boolean mShowCustomTextGridY = false;
    private List<SimpleSeriesRenderer> mRenderers = new ArrayList();
    private boolean mAntialiasing = true;
    private int mLegendHeight = 0;
    private int[] mMargins = {20, 30, 10, 20};
    private float mScale = 1.0f;
    private boolean mPanEnabled = true;
    private boolean mZoomEnabled = true;
    private boolean mZoomButtonsVisible = false;
    private float mZoomRate = 1.5f;
    private boolean mExternalZoomEnabled = false;
    private float mOriginalScale = this.mScale;
    private boolean mClickEnabled = false;
    private int selectableBuffer = 15;
    private boolean mbDynamicShowOverrideText = false;
    private boolean mShowCurrentCoordinateValue = false;
    private Bitmap mParentBitmap = null;
    private boolean mIsSpecialDataStreamChart = false;
    private float mStartAngle = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private boolean mshowUnit = true;
    private int mXGridRange = Opcodes.GETFIELD;
    private float mLegendMarginTop = 30.0f;

    /* compiled from: DefaultRenderer.java */
    /* renamed from: com.cnlaunch.a.c.c$a */
    /* loaded from: classes.dex */
    public enum EnumC1407a {
        HORIZONTAL(0),
        VERTICAL(90);
        
        private int mAngle;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static EnumC1407a[] valuesCustom() {
            EnumC1407a[] valuesCustom = values();
            int length = valuesCustom.length;
            EnumC1407a[] enumC1407aArr = new EnumC1407a[length];
            System.arraycopy(valuesCustom, 0, enumC1407aArr, 0, length);
            return enumC1407aArr;
        }

        EnumC1407a(int i) {
            this.mAngle = 0;
            this.mAngle = i;
        }

        public final int getAngle() {
            return this.mAngle;
        }
    }

    public int getXGridRange() {
        return this.mXGridRange;
    }

    public void setXGridRange(int i) {
        this.mXGridRange = i;
    }

    public String getChartTitle() {
        return this.mChartTitle;
    }

    public void setChartTitle(String str) {
        this.mChartTitle = str;
    }

    public float getChartTitleTextSize() {
        return this.mChartTitleTextSize;
    }

    public void setChartTitleTextSize(float f) {
        this.mChartTitleTextSize = f;
    }

    public boolean isShowUnit() {
        return this.mshowUnit;
    }

    public void setShowUnit(boolean z) {
        this.mshowUnit = z;
    }

    public boolean isDynamicShowOverrideText() {
        return this.mbDynamicShowOverrideText;
    }

    public void setDynamicShowOverrideText(boolean z) {
        this.mbDynamicShowOverrideText = z;
    }

    public void addSeriesRenderer(SimpleSeriesRenderer simpleSeriesRenderer) {
        this.mRenderers.add(simpleSeriesRenderer);
    }

    public void addSeriesRenderer(int i, SimpleSeriesRenderer simpleSeriesRenderer) {
        this.mRenderers.add(i, simpleSeriesRenderer);
    }

    public void removeSeriesRenderer(SimpleSeriesRenderer simpleSeriesRenderer) {
        this.mRenderers.remove(simpleSeriesRenderer);
    }

    public void removeAllRenderers() {
        this.mRenderers.clear();
    }

    public SimpleSeriesRenderer getSeriesRendererAt(int i) {
        return this.mRenderers.get(i);
    }

    public int getSeriesRendererCount() {
        return this.mRenderers.size();
    }

    public SimpleSeriesRenderer[] getSeriesRenderers() {
        return (SimpleSeriesRenderer[]) this.mRenderers.toArray(new SimpleSeriesRenderer[0]);
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public int getParentBackgroundColor() {
        return this.mParentBackgroundColor;
    }

    public void setParentBackgroundColor(int i) {
        this.mParentBackgroundColor = i;
    }

    public boolean isApplyBackgroundColor() {
        return this.mApplyBackgroundColor;
    }

    public void setApplyBackgroundColor(boolean z) {
        this.mApplyBackgroundColor = z;
    }

    public int getAxesColor() {
        int i = this.mXAxisColor;
        return i != -3355444 ? i : this.mYAxisColor;
    }

    public void setAxesColor(int i) {
        setXAxisColor(i);
        setYAxisColor(i);
    }

    public int getYAxisColor() {
        return this.mYAxisColor;
    }

    public void setYAxisColor(int i) {
        this.mYAxisColor = i;
    }

    public int getXAxisColor() {
        return this.mXAxisColor;
    }

    public void setXAxisColor(int i) {
        this.mXAxisColor = i;
    }

    public int getLabelsColor() {
        return this.mLabelsColor;
    }

    public void setLabelsColor(int i) {
        this.mLabelsColor = i;
    }

    public float getLabelsTextSize() {
        return this.mLabelsTextSize;
    }

    public void setLabelsTextSize(float f) {
        this.mLabelsTextSize = f;
    }

    public boolean isShowAxes() {
        return this.mShowAxes;
    }

    public void setShowAxes(boolean z) {
        this.mShowAxes = z;
    }

    public boolean isShowLabels() {
        return this.mShowLabels;
    }

    public void setShowLabels(boolean z) {
        this.mShowLabels = z;
    }

    public boolean isShowTickMarks() {
        return this.mShowTickMarks;
    }

    public void setShowTickMarks(boolean z) {
        this.mShowTickMarks = z;
    }

    public boolean isShowGridX() {
        return this.mShowGridX;
    }

    public boolean isShowGridY() {
        return this.mShowGridY;
    }

    public void setShowGridX(boolean z) {
        this.mShowGridX = z;
    }

    public void setShowGridY(boolean z) {
        this.mShowGridY = z;
    }

    public void setShowGrid(boolean z) {
        setShowGridX(z);
        setShowGridY(z);
    }

    public boolean isShowCustomTextGridX() {
        return this.mShowCustomTextGridX;
    }

    public boolean isShowCustomTextGridY() {
        return this.mShowCustomTextGridY;
    }

    public void setShowCustomTextGridX(boolean z) {
        this.mShowCustomTextGridX = z;
    }

    public void setShowCustomTextGridY(boolean z) {
        this.mShowCustomTextGridY = z;
    }

    public void setShowCustomTextGrid(boolean z) {
        setShowCustomTextGridX(z);
        setShowCustomTextGridY(z);
    }

    public boolean isShowLegend() {
        return this.mShowLegend;
    }

    public void setShowLegend(boolean z) {
        this.mShowLegend = z;
    }

    public boolean isFitLegend() {
        return this.mFitLegend;
    }

    public void setFitLegend(boolean z) {
        this.mFitLegend = z;
    }

    public String getTextTypefaceName() {
        return this.mTextTypefaceName;
    }

    public int getTextTypefaceStyle() {
        return this.mTextTypefaceStyle;
    }

    public Typeface getTextTypeface() {
        return this.mTextTypeface;
    }

    public float getLegendTextSize() {
        return this.mLegendTextSize;
    }

    public void setLegendTextSize(float f) {
        this.mLegendTextSize = f;
    }

    public void setTextTypeface(String str, int i) {
        this.mTextTypefaceName = str;
        this.mTextTypefaceStyle = i;
    }

    public void setTextTypeface(Typeface typeface) {
        this.mTextTypeface = typeface;
    }

    public boolean isAntialiasing() {
        return this.mAntialiasing;
    }

    public void setAntialiasing(boolean z) {
        this.mAntialiasing = z;
    }

    public float getScale() {
        return this.mScale;
    }

    public float getOriginalScale() {
        return this.mOriginalScale;
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    public boolean isZoomEnabled() {
        return this.mZoomEnabled;
    }

    public void setZoomEnabled(boolean z) {
        this.mZoomEnabled = z;
    }

    public boolean isZoomButtonsVisible() {
        return this.mZoomButtonsVisible;
    }

    public void setZoomButtonsVisible(boolean z) {
        this.mZoomButtonsVisible = z;
    }

    public boolean isExternalZoomEnabled() {
        return this.mExternalZoomEnabled;
    }

    public void setExternalZoomEnabled(boolean z) {
        this.mExternalZoomEnabled = z;
    }

    public float getZoomRate() {
        return this.mZoomRate;
    }

    public boolean isPanEnabled() {
        return this.mPanEnabled;
    }

    public void setPanEnabled(boolean z) {
        this.mPanEnabled = z;
    }

    public void setZoomRate(float f) {
        this.mZoomRate = f;
    }

    public boolean isClickEnabled() {
        return this.mClickEnabled;
    }

    public void setClickEnabled(boolean z) {
        this.mClickEnabled = z;
    }

    public int getSelectableBuffer() {
        return this.selectableBuffer;
    }

    public void setSelectableBuffer(int i) {
        this.selectableBuffer = i;
    }

    public int getLegendHeight() {
        return this.mLegendHeight;
    }

    public void setLegendHeight(int i) {
        this.mLegendHeight = i;
    }

    public int[] getMargins() {
        return this.mMargins;
    }

    public void setMargins(int[] iArr) {
        this.mMargins = iArr;
    }

    public boolean isInScroll() {
        return this.mInScroll;
    }

    public void setInScroll(boolean z) {
        this.mInScroll = z;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    public void setStartAngle(float f) {
        this.mStartAngle = f;
    }

    public boolean isDisplayValues() {
        return this.mDisplayValues;
    }

    public void setDisplayValues(boolean z) {
        this.mDisplayValues = z;
    }

    public boolean isShowCurrentCoordinateValue() {
        return this.mShowCurrentCoordinateValue;
    }

    public boolean setShowCurrentValueCoordinate(boolean z) {
        this.mShowCurrentCoordinateValue = z;
        return z;
    }

    public void setParentViewBitmap(Bitmap bitmap) {
        this.mParentBitmap = bitmap;
    }

    public Bitmap getParentViewBitmap() {
        return this.mParentBitmap;
    }

    public void setIsSpecialDataStreamChart(boolean z) {
        this.mIsSpecialDataStreamChart = z;
    }

    public boolean getIsSpecialDataStreamChart() {
        return this.mIsSpecialDataStreamChart;
    }

    public float getmLegendMarginTop() {
        return this.mLegendMarginTop;
    }

    public void setmLegendMarginTop(float f) {
        this.mLegendMarginTop = f;
    }
}
