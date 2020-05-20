package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.List;

/* loaded from: classes.dex */
public class WalkingRouteLine extends RouteLine<WalkingStep> implements Parcelable {
    public static final Parcelable.Creator<WalkingRouteLine> CREATOR = new Parcelable.Creator<WalkingRouteLine>() { // from class: com.baidu.mapapi.search.route.WalkingRouteLine.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final WalkingRouteLine createFromParcel(Parcel parcel) {
            return new WalkingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final WalkingRouteLine[] newArray(int i) {
            return new WalkingRouteLine[i];
        }
    };

    /* loaded from: classes.dex */
    public static class WalkingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<WalkingStep> CREATOR = new Parcelable.Creator<WalkingStep>() { // from class: com.baidu.mapapi.search.route.WalkingRouteLine.WalkingStep.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final WalkingStep createFromParcel(Parcel parcel) {
                return new WalkingStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final WalkingStep[] newArray(int i) {
                return new WalkingStep[i];
            }
        };

        /* renamed from: d */
        private int f5641d;

        /* renamed from: e */
        private RouteNode f5642e;

        /* renamed from: f */
        private RouteNode f5643f;

        /* renamed from: g */
        private String f5644g;

        /* renamed from: h */
        private String f5645h;

        /* renamed from: i */
        private String f5646i;

        /* renamed from: j */
        private String f5647j;

        public WalkingStep() {
        }

        protected WalkingStep(Parcel parcel) {
            super(parcel);
            this.f5641d = parcel.readInt();
            this.f5642e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f5643f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f5644g = parcel.readString();
            this.f5645h = parcel.readString();
            this.f5646i = parcel.readString();
            this.f5647j = parcel.readString();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f5641d;
        }

        public RouteNode getEntrance() {
            return this.f5642e;
        }

        public String getEntranceInstructions() {
            return this.f5645h;
        }

        public RouteNode getExit() {
            return this.f5643f;
        }

        public String getExitInstructions() {
            return this.f5646i;
        }

        public String getInstructions() {
            return this.f5647j;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f5644g);
            }
            return this.mWayPoints;
        }

        public void setDirection(int i) {
            this.f5641d = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f5642e = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.f5645h = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f5643f = routeNode;
        }

        public void setExitInstructions(String str) {
            this.f5646i = str;
        }

        public void setInstructions(String str) {
            this.f5647j = str;
        }

        public void setPathString(String str) {
            this.f5644g = str;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, 1);
            parcel.writeInt(this.f5641d);
            parcel.writeParcelable(this.f5642e, 1);
            parcel.writeParcelable(this.f5643f, 1);
            parcel.writeString(this.f5644g);
            parcel.writeString(this.f5645h);
            parcel.writeString(this.f5646i);
            parcel.writeString(this.f5647j);
        }
    }

    public WalkingRouteLine() {
    }

    protected WalkingRouteLine(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<WalkingStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.WALKSTEP);
        super.writeToParcel(parcel, 1);
    }
}
