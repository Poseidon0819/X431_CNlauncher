package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.List;

/* loaded from: classes.dex */
public final class TransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static final Parcelable.Creator<TransitRouteLine> CREATOR = new Parcelable.Creator<TransitRouteLine>() { // from class: com.baidu.mapapi.search.route.TransitRouteLine.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TransitRouteLine createFromParcel(Parcel parcel) {
            return new TransitRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final TransitRouteLine[] newArray(int i) {
            return new TransitRouteLine[i];
        }
    };

    /* renamed from: b */
    private TaxiInfo f5629b;

    /* loaded from: classes.dex */
    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new Parcelable.Creator<TransitStep>() { // from class: com.baidu.mapapi.search.route.TransitRouteLine.TransitStep.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final TransitStep createFromParcel(Parcel parcel) {
                return new TransitStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final TransitStep[] newArray(int i) {
                return new TransitStep[i];
            }
        };

        /* renamed from: d */
        private VehicleInfo f5630d;

        /* renamed from: e */
        private RouteNode f5631e;

        /* renamed from: f */
        private RouteNode f5632f;

        /* renamed from: g */
        private TransitRouteStepType f5633g;

        /* renamed from: h */
        private String f5634h;

        /* renamed from: i */
        private String f5635i;

        /* loaded from: classes.dex */
        public enum TransitRouteStepType {
            BUSLINE,
            SUBWAY,
            WAKLING
        }

        public TransitStep() {
        }

        protected TransitStep(Parcel parcel) {
            super(parcel);
            this.f5630d = (VehicleInfo) parcel.readParcelable(VehicleInfo.class.getClassLoader());
            this.f5631e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f5632f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            int readInt = parcel.readInt();
            this.f5633g = readInt == -1 ? null : TransitRouteStepType.values()[readInt];
            this.f5634h = parcel.readString();
            this.f5635i = parcel.readString();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public RouteNode getEntrance() {
            return this.f5631e;
        }

        public RouteNode getExit() {
            return this.f5632f;
        }

        public String getInstructions() {
            return this.f5634h;
        }

        public TransitRouteStepType getStepType() {
            return this.f5633g;
        }

        public VehicleInfo getVehicleInfo() {
            return this.f5630d;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f5635i);
            }
            return this.mWayPoints;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f5631e = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f5632f = routeNode;
        }

        public void setInstructions(String str) {
            this.f5634h = str;
        }

        public void setPathString(String str) {
            this.f5635i = str;
        }

        public void setStepType(TransitRouteStepType transitRouteStepType) {
            this.f5633g = transitRouteStepType;
        }

        public void setVehicleInfo(VehicleInfo vehicleInfo) {
            this.f5630d = vehicleInfo;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f5630d, 1);
            parcel.writeParcelable(this.f5631e, 1);
            parcel.writeParcelable(this.f5632f, 1);
            TransitRouteStepType transitRouteStepType = this.f5633g;
            parcel.writeInt(transitRouteStepType == null ? -1 : transitRouteStepType.ordinal());
            parcel.writeString(this.f5634h);
            parcel.writeString(this.f5635i);
        }
    }

    public TransitRouteLine() {
    }

    protected TransitRouteLine(Parcel parcel) {
        super(parcel);
        this.f5629b = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Deprecated
    public final TaxiInfo getTaxitInfo() {
        return this.f5629b;
    }

    public final void setTaxitInfo(TaxiInfo taxiInfo) {
        this.f5629b = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.TRANSITSTEP);
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f5629b, 1);
    }
}
