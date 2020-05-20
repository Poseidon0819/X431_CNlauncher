package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BikingRouteLine extends RouteLine<BikingStep> implements Parcelable {
    public static final Parcelable.Creator<BikingRouteLine> CREATOR = new Parcelable.Creator<BikingRouteLine>() { // from class: com.baidu.mapapi.search.route.BikingRouteLine.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BikingRouteLine createFromParcel(Parcel parcel) {
            return new BikingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final BikingRouteLine[] newArray(int i) {
            return new BikingRouteLine[i];
        }
    };

    /* loaded from: classes.dex */
    public static class BikingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<BikingStep> CREATOR = new Parcelable.Creator<BikingStep>() { // from class: com.baidu.mapapi.search.route.BikingRouteLine.BikingStep.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final BikingStep createFromParcel(Parcel parcel) {
                return new BikingStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final BikingStep[] newArray(int i) {
                return new BikingStep[i];
            }
        };

        /* renamed from: d */
        private int f5543d;

        /* renamed from: e */
        private RouteNode f5544e;

        /* renamed from: f */
        private RouteNode f5545f;

        /* renamed from: g */
        private String f5546g;

        /* renamed from: h */
        private String f5547h;

        /* renamed from: i */
        private String f5548i;

        /* renamed from: j */
        private String f5549j;

        /* renamed from: k */
        private String f5550k;

        public BikingStep() {
        }

        protected BikingStep(Parcel parcel) {
            super(parcel);
            this.f5543d = parcel.readInt();
            this.f5544e = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f5545f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f5546g = parcel.readString();
            this.f5547h = parcel.readString();
            this.f5548i = parcel.readString();
            this.f5549j = parcel.readString();
            this.f5550k = parcel.readString();
        }

        /* renamed from: a */
        private List<LatLng> m11000a(String str) {
            if (str != null && str.length() != 0) {
                ArrayList arrayList = new ArrayList();
                String[] split = str.split(";");
                if (split != null && split.length != 0) {
                    for (String str2 : split) {
                        String[] split2 = str2.split(",");
                        if (split2 != null && split2.length >= 2) {
                            LatLng latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
                            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                                latLng = CoordTrans.baiduToGcj(latLng);
                            }
                            arrayList.add(latLng);
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f5543d;
        }

        public RouteNode getEntrance() {
            return this.f5544e;
        }

        public String getEntranceInstructions() {
            return this.f5547h;
        }

        public RouteNode getExit() {
            return this.f5545f;
        }

        public String getExitInstructions() {
            return this.f5548i;
        }

        public String getInstructions() {
            return this.f5549j;
        }

        public String getTurnType() {
            return this.f5550k;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = m11000a(this.f5546g);
            }
            return this.mWayPoints;
        }

        public void setDirection(int i) {
            this.f5543d = i;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f5544e = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.f5547h = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f5545f = routeNode;
        }

        public void setExitInstructions(String str) {
            this.f5548i = str;
        }

        public void setInstructions(String str) {
            this.f5549j = str;
        }

        public void setPathString(String str) {
            this.f5546g = str;
        }

        public void setTurnType(String str) {
            this.f5550k = str;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, 1);
            parcel.writeInt(this.f5543d);
            parcel.writeParcelable(this.f5544e, 1);
            parcel.writeParcelable(this.f5545f, 1);
            parcel.writeString(this.f5546g);
            parcel.writeString(this.f5547h);
            parcel.writeString(this.f5548i);
            parcel.writeString(this.f5549j);
            parcel.writeString(this.f5550k);
        }
    }

    public BikingRouteLine() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BikingRouteLine(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<BikingStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.setType(RouteLine.TYPE.BIKINGSTEP);
        super.writeToParcel(parcel, 1);
    }
}
