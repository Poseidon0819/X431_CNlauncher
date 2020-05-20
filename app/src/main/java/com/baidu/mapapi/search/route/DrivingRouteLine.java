package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrivingRouteLine extends RouteLine<DrivingStep> implements Parcelable {
    public static final Parcelable.Creator<DrivingRouteLine> CREATOR = new Parcelable.Creator<DrivingRouteLine>() { // from class: com.baidu.mapapi.search.route.DrivingRouteLine.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DrivingRouteLine createFromParcel(Parcel parcel) {
            return new DrivingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DrivingRouteLine[] newArray(int i) {
            return new DrivingRouteLine[i];
        }
    };

    /* renamed from: b */
    private boolean f5553b;

    /* renamed from: c */
    private List<RouteNode> f5554c;

    /* renamed from: d */
    private int f5555d;

    /* renamed from: e */
    private int f5556e;

    /* loaded from: classes.dex */
    public static class DrivingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<DrivingStep> CREATOR = new Parcelable.Creator<DrivingStep>() { // from class: com.baidu.mapapi.search.route.DrivingRouteLine.DrivingStep.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DrivingStep createFromParcel(Parcel parcel) {
                return new DrivingStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final DrivingStep[] newArray(int i) {
                return new DrivingStep[i];
            }
        };

        /* renamed from: d */
        List<LatLng> f5557d;

        /* renamed from: e */
        int[] f5558e;

        /* renamed from: f */
        private int f5559f;

        /* renamed from: g */
        private RouteNode f5560g;

        /* renamed from: h */
        private RouteNode f5561h;

        /* renamed from: i */
        private String f5562i;

        /* renamed from: j */
        private String f5563j;

        /* renamed from: k */
        private String f5564k;

        /* renamed from: l */
        private String f5565l;

        /* renamed from: m */
        private int f5566m;

        public DrivingStep() {
        }

        protected DrivingStep(Parcel parcel) {
            super(parcel);
            this.f5559f = parcel.readInt();
            this.f5560g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f5561h = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f5562i = parcel.readString();
            this.f5563j = parcel.readString();
            this.f5564k = parcel.readString();
            this.f5565l = parcel.readString();
            this.f5566m = parcel.readInt();
            this.f5557d = parcel.createTypedArrayList(LatLng.CREATOR);
            this.f5558e = parcel.createIntArray();
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f5559f;
        }

        public RouteNode getEntrance() {
            return this.f5560g;
        }

        public String getEntranceInstructions() {
            return this.f5563j;
        }

        public RouteNode getExit() {
            return this.f5561h;
        }

        public String getExitInstructions() {
            return this.f5564k;
        }

        public String getInstructions() {
            return this.f5565l;
        }

        public int getNumTurns() {
            return this.f5566m;
        }

        public int[] getTrafficList() {
            return this.f5558e;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f5562i);
            }
            return this.f5557d;
        }

        public void setDirection(int i) {
            this.f5559f = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f5560g = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.f5563j = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f5561h = routeNode;
        }

        public void setExitInstructions(String str) {
            this.f5564k = str;
        }

        public void setInstructions(String str) {
            this.f5565l = str;
        }

        public void setNumTurns(int i) {
            this.f5566m = i;
        }

        public void setPathList(List<LatLng> list) {
            this.f5557d = list;
        }

        public void setPathString(String str) {
            this.f5562i = str;
        }

        public void setTrafficList(int[] iArr) {
            this.f5558e = iArr;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5559f);
            parcel.writeParcelable(this.f5560g, 1);
            parcel.writeParcelable(this.f5561h, 1);
            parcel.writeString(this.f5562i);
            parcel.writeString(this.f5563j);
            parcel.writeString(this.f5564k);
            parcel.writeString(this.f5565l);
            parcel.writeInt(this.f5566m);
            parcel.writeTypedList(this.f5557d);
            parcel.writeIntArray(this.f5558e);
        }
    }

    public DrivingRouteLine() {
    }

    protected DrivingRouteLine(Parcel parcel) {
        super(parcel);
        this.f5553b = parcel.readByte() != 0;
        this.f5554c = new ArrayList();
        parcel.readList(this.f5554c, RouteNode.class.getClassLoader());
        this.f5555d = parcel.readInt();
        this.f5556e = parcel.readInt();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCongestionDistance() {
        return this.f5555d;
    }

    public int getLightNum() {
        return this.f5556e;
    }

    public List<RouteNode> getWayPoints() {
        return this.f5554c;
    }

    @Deprecated
    public boolean isSupportTraffic() {
        return this.f5553b;
    }

    public void setCongestionDistance(int i) {
        this.f5555d = i;
    }

    public void setLightNum(int i) {
        this.f5556e = i;
    }

    public void setSupportTraffic(boolean z) {
        this.f5553b = z;
    }

    public void setWayPoints(List<RouteNode> list) {
        this.f5554c = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.DRIVESTEP);
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f5553b ? (byte) 1 : (byte) 0);
        parcel.writeList(this.f5554c);
        parcel.writeInt(this.f5555d);
        parcel.writeInt(this.f5556e);
    }
}
