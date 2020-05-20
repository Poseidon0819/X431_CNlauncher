package com.baidu.mapapi.search.route;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes.dex */
public class IndoorRouteLine extends RouteLine<IndoorRouteStep> {
    public static final Parcelable.Creator<IndoorRouteLine> CREATOR = new Parcelable.Creator<IndoorRouteLine>() { // from class: com.baidu.mapapi.search.route.IndoorRouteLine.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final IndoorRouteLine createFromParcel(Parcel parcel) {
            return new IndoorRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final IndoorRouteLine[] newArray(int i) {
            return new IndoorRouteLine[i];
        }
    };

    /* loaded from: classes.dex */
    public static class IndoorRouteStep extends RouteStep {

        /* renamed from: d */
        private RouteNode f5577d;

        /* renamed from: e */
        private RouteNode f5578e;

        /* renamed from: f */
        private String f5579f;

        /* renamed from: g */
        private String f5580g;

        /* renamed from: h */
        private String f5581h;

        /* renamed from: i */
        private List<IndoorStepNode> f5582i;

        /* renamed from: j */
        private List<Double> f5583j;

        /* loaded from: classes.dex */
        public static class IndoorStepNode {

            /* renamed from: a */
            private String f5584a;

            /* renamed from: b */
            private int f5585b;

            /* renamed from: c */
            private LatLng f5586c;

            /* renamed from: d */
            private String f5587d;

            public String getDetail() {
                return this.f5587d;
            }

            public LatLng getLocation() {
                return this.f5586c;
            }

            public String getName() {
                return this.f5584a;
            }

            public int getType() {
                return this.f5585b;
            }

            public void setDetail(String str) {
                this.f5587d = str;
            }

            public void setLocation(LatLng latLng) {
                this.f5586c = latLng;
            }

            public void setName(String str) {
                this.f5584a = str;
            }

            public void setType(int i) {
                this.f5585b = i;
            }
        }

        /* renamed from: a */
        private List<LatLng> m10985a(List<Double> list) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i += 2) {
                arrayList.add(new LatLng(list.get(i).doubleValue(), list.get(i + 1).doubleValue()));
            }
            return arrayList;
        }

        public String getBuildingId() {
            return this.f5581h;
        }

        public RouteNode getEntrace() {
            return this.f5577d;
        }

        public RouteNode getExit() {
            return this.f5578e;
        }

        public String getFloorId() {
            return this.f5580g;
        }

        public String getInstructions() {
            return this.f5579f;
        }

        public List<IndoorStepNode> getStepNodes() {
            return this.f5582i;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = m10985a(this.f5583j);
            }
            return this.mWayPoints;
        }

        public void setBuildingId(String str) {
            this.f5581h = str;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f5577d = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f5578e = routeNode;
        }

        public void setFloorId(String str) {
            this.f5580g = str;
        }

        public void setInstructions(String str) {
            this.f5579f = str;
        }

        public void setPath(List<Double> list) {
            this.f5583j = list;
        }

        public void setStepNodes(List<IndoorStepNode> list) {
            this.f5582i = list;
        }
    }

    public IndoorRouteLine() {
        setType(RouteLine.TYPE.WALKSTEP);
    }

    protected IndoorRouteLine(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<IndoorRouteStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
