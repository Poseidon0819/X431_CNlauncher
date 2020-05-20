package com.cnlaunch.p112a.p114b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.a.b.c */
/* loaded from: classes.dex */
public final class XYMultipleSeriesDataset implements Serializable {
    private List<XYSeries> mSeries = new ArrayList();

    public final synchronized void addSeries(XYSeries xYSeries) {
        this.mSeries.add(xYSeries);
    }

    public final synchronized void addSeries(int i, XYSeries xYSeries) {
        this.mSeries.add(i, xYSeries);
    }

    public final synchronized void addAllSeries(List<XYSeries> list) {
        this.mSeries.addAll(list);
    }

    public final synchronized void removeSeries(int i) {
        this.mSeries.remove(i);
    }

    public final synchronized void removeSeries(XYSeries xYSeries) {
        this.mSeries.remove(xYSeries);
    }

    public final synchronized void clear() {
        this.mSeries.clear();
    }

    public final synchronized XYSeries getSeriesAt(int i) {
        return this.mSeries.get(i);
    }

    public final synchronized int getSeriesCount() {
        return this.mSeries.size();
    }

    public final synchronized XYSeries[] getSeries() {
        return (XYSeries[]) this.mSeries.toArray(new XYSeries[0]);
    }
}
