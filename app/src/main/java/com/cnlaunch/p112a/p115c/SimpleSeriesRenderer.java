package com.cnlaunch.p112a.p115c;

import java.io.Serializable;
import java.text.NumberFormat;

/* renamed from: com.cnlaunch.a.c.d */
/* loaded from: classes.dex */
public class SimpleSeriesRenderer implements Serializable {
    private NumberFormat mChartValuesFormat;
    private int mGradientStartColor;
    private double mGradientStartValue;
    private int mGradientStopColor;
    private double mGradientStopValue;
    private boolean mHighlighted;
    private BasicStroke mStroke;
    private int mColor = -16776961;
    private int mHistoryColor = -7829368;
    private boolean mGradientEnabled = false;
    private boolean mShowLegendItem = true;
    private boolean mDisplayBoundingPoints = true;

    public int getColor() {
        return this.mColor;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public int getHistoryColor() {
        return this.mHistoryColor;
    }

    public void setHistoryColor(int i) {
        this.mHistoryColor = i;
    }

    public BasicStroke getStroke() {
        return this.mStroke;
    }

    public void setStroke(BasicStroke basicStroke) {
        this.mStroke = basicStroke;
    }

    public boolean isGradientEnabled() {
        return this.mGradientEnabled;
    }

    public void setGradientEnabled(boolean z) {
        this.mGradientEnabled = z;
    }

    public double getGradientStartValue() {
        return this.mGradientStartValue;
    }

    public int getGradientStartColor() {
        return this.mGradientStartColor;
    }

    public void setGradientStart(double d, int i) {
        this.mGradientStartValue = d;
        this.mGradientStartColor = i;
    }

    public double getGradientStopValue() {
        return this.mGradientStopValue;
    }

    public int getGradientStopColor() {
        return this.mGradientStopColor;
    }

    public void setGradientStop(double d, int i) {
        this.mGradientStopValue = d;
        this.mGradientStopColor = i;
    }

    public boolean isShowLegendItem() {
        return this.mShowLegendItem;
    }

    public void setShowLegendItem(boolean z) {
        this.mShowLegendItem = z;
    }

    public boolean isHighlighted() {
        return this.mHighlighted;
    }

    public void setHighlighted(boolean z) {
        this.mHighlighted = z;
    }

    public boolean isDisplayBoundingPoints() {
        return this.mDisplayBoundingPoints;
    }

    public void setDisplayBoundingPoints(boolean z) {
        this.mDisplayBoundingPoints = z;
    }

    public NumberFormat getChartValuesFormat() {
        return this.mChartValuesFormat;
    }

    public void setChartValuesFormat(NumberFormat numberFormat) {
        this.mChartValuesFormat = numberFormat;
    }
}
