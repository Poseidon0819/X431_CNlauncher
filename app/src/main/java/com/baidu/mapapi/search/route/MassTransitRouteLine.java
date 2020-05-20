package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BusInfo;
import com.baidu.mapapi.search.core.CoachInfo;
import com.baidu.mapapi.search.core.PlaneInfo;
import com.baidu.mapapi.search.core.PriceInfo;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TrainInfo;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class MassTransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static final Parcelable.Creator<MassTransitRouteLine> CREATOR = new Parcelable.Creator<MassTransitRouteLine>() { // from class: com.baidu.mapapi.search.route.MassTransitRouteLine.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final MassTransitRouteLine createFromParcel(Parcel parcel) {
            return new MassTransitRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final MassTransitRouteLine[] newArray(int i) {
            return new MassTransitRouteLine[i];
        }
    };

    /* renamed from: b */
    private String f5589b;

    /* renamed from: c */
    private double f5590c;

    /* renamed from: d */
    private List<PriceInfo> f5591d;

    /* renamed from: e */
    private List<List<TransitStep>> f5592e;

    /* loaded from: classes.dex */
    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new Parcelable.Creator<TransitStep>() { // from class: com.baidu.mapapi.search.route.MassTransitRouteLine.TransitStep.1
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
        private List<TrafficCondition> f5593d;

        /* renamed from: e */
        private LatLng f5594e;

        /* renamed from: f */
        private LatLng f5595f;

        /* renamed from: g */
        private TrainInfo f5596g;

        /* renamed from: h */
        private PlaneInfo f5597h;

        /* renamed from: i */
        private CoachInfo f5598i;

        /* renamed from: j */
        private BusInfo f5599j;

        /* renamed from: k */
        private StepVehicleInfoType f5600k;

        /* renamed from: l */
        private String f5601l;

        /* renamed from: m */
        private String f5602m;

        /* loaded from: classes.dex */
        public enum StepVehicleInfoType {
            ESTEP_TRAIN(1),
            ESTEP_PLANE(2),
            ESTEP_BUS(3),
            ESTEP_DRIVING(4),
            ESTEP_WALK(5),
            ESTEP_COACH(6);
            

            /* renamed from: a */
            private int f5603a;

            StepVehicleInfoType(int i) {
                this.f5603a = 0;
                this.f5603a = i;
            }

            public final int getInt() {
                return this.f5603a;
            }
        }

        /* loaded from: classes.dex */
        public static class TrafficCondition implements Parcelable {
            public static final Parcelable.Creator<TrafficCondition> CREATOR = new Parcelable.Creator<TrafficCondition>() { // from class: com.baidu.mapapi.search.route.MassTransitRouteLine.TransitStep.TrafficCondition.1
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public final TrafficCondition createFromParcel(Parcel parcel) {
                    return new TrafficCondition(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public final TrafficCondition[] newArray(int i) {
                    return new TrafficCondition[i];
                }
            };

            /* renamed from: a */
            private int f5604a;

            /* renamed from: b */
            private int f5605b;

            public TrafficCondition() {
            }

            protected TrafficCondition(Parcel parcel) {
                this.f5604a = parcel.readInt();
                this.f5605b = parcel.readInt();
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int getTrafficGeoCnt() {
                return this.f5605b;
            }

            public int getTrafficStatus() {
                return this.f5604a;
            }

            public void setTrafficGeoCnt(int i) {
                this.f5605b = i;
            }

            public void setTrafficStatus(int i) {
                this.f5604a = i;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f5604a);
                parcel.writeInt(this.f5605b);
            }
        }

        public TransitStep() {
        }

        protected TransitStep(Parcel parcel) {
            super(parcel);
            StepVehicleInfoType stepVehicleInfoType;
            this.f5593d = parcel.createTypedArrayList(TrafficCondition.CREATOR);
            this.f5594e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f5595f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f5596g = (TrainInfo) parcel.readParcelable(TrainInfo.class.getClassLoader());
            this.f5597h = (PlaneInfo) parcel.readParcelable(PlaneInfo.class.getClassLoader());
            this.f5598i = (CoachInfo) parcel.readParcelable(CoachInfo.class.getClassLoader());
            this.f5599j = (BusInfo) parcel.readParcelable(BusInfo.class.getClassLoader());
            switch (parcel.readInt()) {
                case 1:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_TRAIN;
                    break;
                case 2:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_PLANE;
                    break;
                case 3:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_BUS;
                    break;
                case 4:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_DRIVING;
                    break;
                case 5:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_WALK;
                    break;
                case 6:
                    stepVehicleInfoType = StepVehicleInfoType.ESTEP_COACH;
                    break;
                default:
                    this.f5601l = parcel.readString();
                    this.f5602m = parcel.readString();
            }
            this.f5600k = stepVehicleInfoType;
            this.f5601l = parcel.readString();
            this.f5602m = parcel.readString();
        }

        /* renamed from: a */
        private List<LatLng> m10979a(String str) {
            String[] split;
            ArrayList arrayList = new ArrayList();
            String[] split2 = str.split(";");
            if (split2 != null) {
                for (int i = 0; i < split2.length; i++) {
                    if (split2[i] != null && split2[i] != "" && (split = split2[i].split(",")) != null && split[1] != "" && split[0] != "") {
                        LatLng latLng = new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
                        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                            latLng = CoordTrans.baiduToGcj(latLng);
                        }
                        arrayList.add(latLng);
                    }
                }
            }
            return arrayList;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public BusInfo getBusInfo() {
            return this.f5599j;
        }

        public CoachInfo getCoachInfo() {
            return this.f5598i;
        }

        public LatLng getEndLocation() {
            return this.f5595f;
        }

        public String getInstructions() {
            return this.f5601l;
        }

        public PlaneInfo getPlaneInfo() {
            return this.f5597h;
        }

        public LatLng getStartLocation() {
            return this.f5594e;
        }

        public List<TrafficCondition> getTrafficConditions() {
            return this.f5593d;
        }

        public TrainInfo getTrainInfo() {
            return this.f5596g;
        }

        public StepVehicleInfoType getVehileType() {
            return this.f5600k;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = m10979a(this.f5602m);
            }
            return this.mWayPoints;
        }

        public void setBusInfo(BusInfo busInfo) {
            this.f5599j = busInfo;
        }

        public void setCoachInfo(CoachInfo coachInfo) {
            this.f5598i = coachInfo;
        }

        public void setEndLocation(LatLng latLng) {
            this.f5595f = latLng;
        }

        public void setInstructions(String str) {
            this.f5601l = str;
        }

        public void setPathString(String str) {
            this.f5602m = str;
        }

        public void setPlaneInfo(PlaneInfo planeInfo) {
            this.f5597h = planeInfo;
        }

        public void setStartLocation(LatLng latLng) {
            this.f5594e = latLng;
        }

        public void setTrafficConditions(List<TrafficCondition> list) {
            this.f5593d = list;
        }

        public void setTrainInfo(TrainInfo trainInfo) {
            this.f5596g = trainInfo;
        }

        public void setVehileType(StepVehicleInfoType stepVehicleInfoType) {
            this.f5600k = stepVehicleInfoType;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeTypedList(this.f5593d);
            parcel.writeParcelable(this.f5594e, i);
            parcel.writeParcelable(this.f5595f, i);
            parcel.writeParcelable(this.f5596g, i);
            parcel.writeParcelable(this.f5597h, i);
            parcel.writeParcelable(this.f5598i, i);
            parcel.writeParcelable(this.f5599j, i);
            parcel.writeInt(this.f5600k.getInt());
            parcel.writeString(this.f5601l);
            parcel.writeString(this.f5602m);
        }
    }

    public MassTransitRouteLine() {
        this.f5592e = null;
    }

    protected MassTransitRouteLine(Parcel parcel) {
        super(parcel);
        this.f5592e = null;
        int readInt = parcel.readInt();
        this.f5589b = parcel.readString();
        this.f5590c = parcel.readDouble();
        this.f5591d = parcel.createTypedArrayList(PriceInfo.CREATOR);
        if (readInt > 0) {
            this.f5592e = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                this.f5592e.add(parcel.createTypedArrayList(TransitStep.CREATOR));
            }
        }
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getArriveTime() {
        return this.f5589b;
    }

    public final List<List<TransitStep>> getNewSteps() {
        return this.f5592e;
    }

    public final double getPrice() {
        return this.f5590c;
    }

    public final List<PriceInfo> getPriceInfo() {
        return this.f5591d;
    }

    public final void setArriveTime(String str) {
        this.f5589b = str;
    }

    public final void setNewSteps(List<List<TransitStep>> list) {
        this.f5592e = list;
    }

    public final void setPrice(double d) {
        this.f5590c = d;
    }

    public final void setPriceInfo(List<PriceInfo> list) {
        this.f5591d = list;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        List<List<TransitStep>> list = this.f5592e;
        parcel.writeInt(list == null ? 0 : list.size());
        parcel.writeString(this.f5589b);
        parcel.writeDouble(this.f5590c);
        parcel.writeTypedList(this.f5591d);
        for (List<TransitStep> list2 : this.f5592e) {
            parcel.writeTypedList(list2);
        }
    }
}
