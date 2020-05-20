package com.cnlaunch.p112a.p114b;

import com.cnlaunch.p112a.p116d.IndexXYMap;
import com.cnlaunch.p112a.p116d.XYEntry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cnlaunch.a.b.d */
/* loaded from: classes.dex */
public final class XYSeries implements Serializable {
    private List<String> mAnnotations;
    private String mCurrentValue;
    private double mMaxX;
    private double mMaxY;
    private double mMinX;
    private double mMinY;
    private final int mScaleNumber;
    private final IndexXYMap<Double, Double> mStringXY;
    private String mTitle;
    private final IndexXYMap<Double, Double> mXY;

    protected final double getPadding() {
        return 1.0E-12d;
    }

    public XYSeries(String str) {
        this(str, 0);
    }

    public XYSeries(String str, int i) {
        this.mXY = new IndexXYMap<>();
        this.mMinX = Double.MAX_VALUE;
        this.mMaxX = -1.7976931348623157E308d;
        this.mMinY = Double.MAX_VALUE;
        this.mMaxY = -1.7976931348623157E308d;
        this.mAnnotations = new ArrayList();
        this.mStringXY = new IndexXYMap<>();
        this.mCurrentValue = "";
        this.mTitle = str;
        this.mScaleNumber = i;
        m9655a();
    }

    public final int getScaleNumber() {
        return this.mScaleNumber;
    }

    /* renamed from: a */
    private void m9655a() {
        this.mMinX = Double.MAX_VALUE;
        this.mMaxX = -1.7976931348623157E308d;
        this.mMinY = Double.MAX_VALUE;
        this.mMaxY = -1.7976931348623157E308d;
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            getX(i);
            m9654a(getY(i));
        }
    }

    /* renamed from: a */
    private void m9654a(double d) {
        this.mMinY = Math.min(this.mMinY, d);
        this.mMaxY = Math.max(this.mMaxY, d);
    }

    public final String getTitle() {
        return this.mTitle;
    }

    public final void setTitle(String str) {
        this.mTitle = str;
    }

    public final synchronized void add(double d, double d2) {
        this.mXY.m9651a(Double.valueOf(d), Double.valueOf(d2));
        m9654a(d2);
    }

    public final synchronized void add(int i, double d, double d2) {
        IndexXYMap<Double, Double> indexXYMap = this.mXY;
        Double valueOf = Double.valueOf(d);
        Double valueOf2 = Double.valueOf(d2);
        indexXYMap.f6726a.add(i, valueOf);
        indexXYMap.f6727b.add(i, valueOf2);
        m9654a(d2);
    }

    public final synchronized void remove(int i) {
        XYEntry<Double, Double> m9648c = this.mXY.m9648c(i);
        double doubleValue = m9648c.getKey().doubleValue();
        double doubleValue2 = m9648c.getValue().doubleValue();
        if (doubleValue == this.mMinX || doubleValue == this.mMaxX || doubleValue2 == this.mMinY || doubleValue2 == this.mMaxY) {
            m9655a();
        }
    }

    public final synchronized void clear() {
        this.mXY.m9650b();
        this.mStringXY.m9650b();
        m9655a();
    }

    public final synchronized double getX(int i) {
        return this.mXY.m9652a(i).doubleValue();
    }

    public final synchronized double getY(int i) {
        return this.mXY.m9649b(i).doubleValue();
    }

    public final void addAnnotation(String str, double d, double d2) {
        this.mAnnotations.add(str);
        this.mStringXY.m9651a(Double.valueOf(d), Double.valueOf(d2));
    }

    public final void removeAnnotation(int i) {
        this.mAnnotations.remove(i);
        this.mStringXY.m9648c(i);
    }

    public final double getAnnotationX(int i) {
        return this.mStringXY.m9652a(i).doubleValue();
    }

    public final double getAnnotationY(int i) {
        return this.mStringXY.m9649b(i).doubleValue();
    }

    public final int getAnnotationCount() {
        return this.mAnnotations.size();
    }

    public final String getAnnotationAt(int i) {
        return this.mAnnotations.get(i);
    }

    public final synchronized IndexXYMap<Double, Double> getRange(double d, double d2, boolean z) {
        return this.mXY;
    }

    public final int getIndexForKey(double d) {
        IndexXYMap<Double, Double> indexXYMap = this.mXY;
        return Collections.binarySearch(indexXYMap.f6726a, Double.valueOf(d), null);
    }

    public final synchronized int getItemCount() {
        return this.mXY.m9653a();
    }

    public final double getMinX() {
        return this.mMinX;
    }

    public final double getMinY() {
        return this.mMinY;
    }

    public final double getMaxX() {
        return this.mMaxX;
    }

    public final double getMaxY() {
        return this.mMaxY;
    }

    public final String getCurrentValue() {
        return this.mCurrentValue;
    }

    public final void setCurrentValue(String str) {
        this.mCurrentValue = str;
    }
}
