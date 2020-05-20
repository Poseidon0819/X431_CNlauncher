package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import java.util.List;

/* loaded from: classes.dex */
public class RouteLine<T extends RouteStep> implements Parcelable {

    /* renamed from: a */
    TYPE f5450a;

    /* renamed from: b */
    private RouteNode f5451b;

    /* renamed from: c */
    private RouteNode f5452c;

    /* renamed from: d */
    private String f5453d;

    /* renamed from: e */
    private List<T> f5454e;

    /* renamed from: f */
    private int f5455f;

    /* renamed from: g */
    private int f5456g;

    /* loaded from: classes.dex */
    public enum TYPE {
        DRIVESTEP(0),
        TRANSITSTEP(1),
        WALKSTEP(2),
        BIKINGSTEP(3);
        

        /* renamed from: a */
        private int f5458a;

        TYPE(int i) {
            this.f5458a = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public int m11041a() {
            return this.f5458a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteLine() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RouteLine(Parcel parcel) {
        Object obj;
        int readInt = parcel.readInt();
        this.f5451b = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f5452c = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f5453d = parcel.readString();
        switch (readInt) {
            case 0:
                obj = DrivingRouteLine.DrivingStep.CREATOR;
                break;
            case 1:
                obj = TransitRouteLine.TransitStep.CREATOR;
                break;
            case 2:
                obj = WalkingRouteLine.WalkingStep.CREATOR;
                break;
            case 3:
                obj = BikingRouteLine.BikingStep.CREATOR;
                break;
            default:
                this.f5455f = parcel.readInt();
                this.f5456g = parcel.readInt();
        }
        this.f5454e = parcel.createTypedArrayList(obj);
        this.f5455f = parcel.readInt();
        this.f5456g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<T> getAllStep() {
        return this.f5454e;
    }

    public int getDistance() {
        return this.f5455f;
    }

    public int getDuration() {
        return this.f5456g;
    }

    public RouteNode getStarting() {
        return this.f5451b;
    }

    public RouteNode getTerminal() {
        return this.f5452c;
    }

    public String getTitle() {
        return this.f5453d;
    }

    protected TYPE getType() {
        return this.f5450a;
    }

    public void setDistance(int i) {
        this.f5455f = i;
    }

    public void setDuration(int i) {
        this.f5456g = i;
    }

    public void setStarting(RouteNode routeNode) {
        this.f5451b = routeNode;
    }

    public void setSteps(List<T> list) {
        this.f5454e = list;
    }

    public void setTerminal(RouteNode routeNode) {
        this.f5452c = routeNode;
    }

    public void setTitle(String str) {
        this.f5453d = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setType(TYPE type) {
        this.f5450a = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        TYPE type = this.f5450a;
        parcel.writeInt(type != null ? type.m11041a() : 10);
        parcel.writeValue(this.f5451b);
        parcel.writeValue(this.f5452c);
        parcel.writeString(this.f5453d);
        if (this.f5450a != null) {
            parcel.writeTypedList(this.f5454e);
        }
        parcel.writeInt(this.f5455f);
        parcel.writeInt(this.f5456g);
    }
}
