package com.baidu.mapapi.synchronization.histroytrace;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.SyncCoordinateConverter;
import java.util.List;

/* loaded from: classes.dex */
public class HistoryTraceData implements Parcelable {
    public static final Parcelable.Creator<HistoryTraceData> CREATOR = new Parcelable.Creator<HistoryTraceData>() { // from class: com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final HistoryTraceData createFromParcel(Parcel parcel) {
            return new HistoryTraceData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final HistoryTraceData[] newArray(int i) {
            return new HistoryTraceData[i];
        }
    };

    /* renamed from: a */
    private int f5723a;

    /* renamed from: b */
    private double f5724b;

    /* renamed from: c */
    private double f5725c;

    /* renamed from: d */
    private int f5726d;

    /* renamed from: e */
    private LatLng f5727e;

    /* renamed from: f */
    private LatLng f5728f;

    /* renamed from: g */
    private SyncCoordinateConverter.CoordType f5729g = SyncCoordinateConverter.CoordType.BD09LL;

    /* renamed from: h */
    private List<HistoryTracePoint> f5730h;

    /* renamed from: i */
    private int f5731i;

    /* loaded from: classes.dex */
    public static class HistoryTracePoint implements Parcelable {
        public static final Parcelable.Creator<HistoryTracePoint> CREATOR = new Parcelable.Creator<HistoryTracePoint>() { // from class: com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData.HistoryTracePoint.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final HistoryTracePoint createFromParcel(Parcel parcel) {
                return new HistoryTracePoint(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final HistoryTracePoint[] newArray(int i) {
                return new HistoryTracePoint[i];
            }
        };

        /* renamed from: a */
        private LatLng f5732a;

        /* renamed from: b */
        private long f5733b;

        /* renamed from: c */
        private String f5734c;

        public HistoryTracePoint() {
        }

        protected HistoryTracePoint(Parcel parcel) {
            this.f5732a = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            this.f5733b = parcel.readLong();
            this.f5734c = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCreateTime() {
            return this.f5734c;
        }

        public long getLocationTime() {
            return this.f5733b;
        }

        public LatLng getPoint() {
            return this.f5732a;
        }

        public void setCreateTime(String str) {
            this.f5734c = str;
        }

        public void setLocationTime(long j) {
            this.f5733b = j;
        }

        public void setPoint(LatLng latLng) {
            this.f5732a = latLng;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f5732a, i);
            parcel.writeLong(this.f5733b);
            parcel.writeString(this.f5734c);
        }
    }

    public HistoryTraceData() {
    }

    protected HistoryTraceData(Parcel parcel) {
        this.f5723a = parcel.readInt();
        this.f5724b = parcel.readDouble();
        this.f5725c = parcel.readDouble();
        this.f5726d = parcel.readInt();
        this.f5727e = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f5728f = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.f5730h = parcel.createTypedArrayList(HistoryTracePoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SyncCoordinateConverter.CoordType getCoordType() {
        return this.f5729g;
    }

    public int getCurrentOrderState() {
        return this.f5726d;
    }

    public int getCurrentPageIndex() {
        return this.f5731i;
    }

    public double getDistance() {
        return this.f5724b;
    }

    public LatLng getOrderEndPosition() {
        return this.f5728f;
    }

    public LatLng getOrderStartPosition() {
        return this.f5727e;
    }

    public List<HistoryTracePoint> getPointsList() {
        return this.f5730h;
    }

    public double getTollDiatance() {
        return this.f5725c;
    }

    public int getTotalPoints() {
        return this.f5723a;
    }

    public void setCoordType(SyncCoordinateConverter.CoordType coordType) {
        this.f5729g = coordType;
    }

    public void setCurrentOrderState(int i) {
        this.f5726d = i;
    }

    public void setCurrentPageIndex(int i) {
        this.f5731i = i;
    }

    public void setDistance(double d) {
        this.f5724b = d;
    }

    public void setOrderEndPosition(LatLng latLng) {
        this.f5728f = latLng;
    }

    public void setOrderStartPosition(LatLng latLng) {
        this.f5727e = latLng;
    }

    public void setPointsList(List<HistoryTracePoint> list) {
        this.f5730h = list;
    }

    public void setTollDiatance(double d) {
        this.f5725c = d;
    }

    public void setTotalPoints(int i) {
        this.f5723a = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HistoryTraceData: \n");
        stringBuffer.append("TotalPoints = ");
        stringBuffer.append(this.f5723a);
        stringBuffer.append("; Distance = ");
        stringBuffer.append(this.f5724b);
        stringBuffer.append("; TollDistance = ");
        stringBuffer.append(this.f5725c);
        stringBuffer.append("; CurrentOrderState = ");
        stringBuffer.append(this.f5726d);
        stringBuffer.append("; OrderStartPosition = ");
        stringBuffer.append(this.f5727e);
        stringBuffer.append("; OrderEndPosition = ");
        stringBuffer.append(this.f5728f);
        List<HistoryTracePoint> list = this.f5730h;
        if (list != null && !list.isEmpty()) {
            stringBuffer.append("\n#History Trace Points Info BEGIN# \n");
            for (int i = 0; i < this.f5730h.size(); i++) {
                HistoryTracePoint historyTracePoint = this.f5730h.get(i);
                if (historyTracePoint != null) {
                    stringBuffer.append("The ");
                    stringBuffer.append(i);
                    stringBuffer.append(" Point Info: ");
                    stringBuffer.append("Point = ");
                    stringBuffer.append(historyTracePoint.getPoint().toString());
                    stringBuffer.append("; LocationTime = ");
                    stringBuffer.append(historyTracePoint.getLocationTime());
                    stringBuffer.append("; CreateTime = ");
                    stringBuffer.append(historyTracePoint.getCreateTime());
                    stringBuffer.append("\n");
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5723a);
        parcel.writeDouble(this.f5724b);
        parcel.writeDouble(this.f5725c);
        parcel.writeInt(this.f5726d);
        parcel.writeParcelable(this.f5727e, i);
        parcel.writeParcelable(this.f5728f, i);
        parcel.writeTypedList(this.f5730h);
    }
}
