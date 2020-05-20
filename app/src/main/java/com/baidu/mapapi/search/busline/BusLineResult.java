package com.baidu.mapapi.search.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class BusLineResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<BusLineResult> CREATOR = new Parcelable.Creator<BusLineResult>() { // from class: com.baidu.mapapi.search.busline.BusLineResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BusLineResult createFromParcel(Parcel parcel) {
            return new BusLineResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BusLineResult[] newArray(int i) {
            return new BusLineResult[i];
        }
    };

    /* renamed from: a */
    private String f5424a;

    /* renamed from: b */
    private String f5425b;

    /* renamed from: c */
    private boolean f5426c;

    /* renamed from: d */
    private Date f5427d;

    /* renamed from: e */
    private Date f5428e;

    /* renamed from: f */
    private String f5429f;

    /* renamed from: g */
    private List<BusStation> f5430g;

    /* renamed from: h */
    private List<BusStep> f5431h;

    /* renamed from: i */
    private float f5432i;

    /* renamed from: j */
    private float f5433j;

    /* renamed from: k */
    private String f5434k;

    /* loaded from: classes.dex */
    public static class BusStation extends RouteNode {
    }

    /* loaded from: classes.dex */
    public static class BusStep extends RouteStep {
    }

    public BusLineResult() {
        this.f5424a = null;
        this.f5425b = null;
        this.f5430g = null;
        this.f5431h = null;
        this.f5434k = null;
    }

    BusLineResult(Parcel parcel) {
        this.f5424a = null;
        this.f5425b = null;
        this.f5430g = null;
        this.f5431h = null;
        this.f5434k = null;
        this.f5424a = parcel.readString();
        this.f5425b = parcel.readString();
        this.f5426c = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.f5427d = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f5428e = (Date) parcel.readValue(Date.class.getClassLoader());
        this.f5429f = parcel.readString();
        this.f5430g = parcel.readArrayList(BusStation.class.getClassLoader());
        this.f5431h = parcel.readArrayList(RouteStep.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBasePrice() {
        return this.f5432i;
    }

    public String getBusCompany() {
        return this.f5424a;
    }

    public String getBusLineName() {
        return this.f5425b;
    }

    public Date getEndTime() {
        return this.f5428e;
    }

    public String getLineDirection() {
        return this.f5434k;
    }

    public float getMaxPrice() {
        return this.f5433j;
    }

    public Date getStartTime() {
        return this.f5427d;
    }

    public List<BusStation> getStations() {
        return this.f5430g;
    }

    public List<BusStep> getSteps() {
        return this.f5431h;
    }

    public String getUid() {
        return this.f5429f;
    }

    public boolean isMonthTicket() {
        return this.f5426c;
    }

    public void setBasePrice(float f) {
        this.f5432i = f;
    }

    public void setBusLineName(String str) {
        this.f5425b = str;
    }

    public void setEndTime(Date date) {
        this.f5428e = date;
    }

    public void setLineDirection(String str) {
        this.f5434k = str;
    }

    public void setMaxPrice(float f) {
        this.f5433j = f;
    }

    public void setMonthTicket(boolean z) {
        this.f5426c = z;
    }

    public void setStartTime(Date date) {
        this.f5427d = date;
    }

    public void setStations(List<BusStation> list) {
        this.f5430g = list;
    }

    public void setSteps(List<BusStep> list) {
        this.f5431h = list;
    }

    public void setUid(String str) {
        this.f5429f = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5424a);
        parcel.writeString(this.f5425b);
        parcel.writeValue(Boolean.valueOf(this.f5426c));
        parcel.writeValue(this.f5427d);
        parcel.writeValue(this.f5428e);
        parcel.writeString(this.f5429f);
        parcel.writeList(this.f5430g);
        parcel.writeList(this.f5431h);
    }
}
