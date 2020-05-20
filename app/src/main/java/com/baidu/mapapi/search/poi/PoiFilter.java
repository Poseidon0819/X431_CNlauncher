package com.baidu.mapapi.search.poi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PoiFilter implements Parcelable {

    /* renamed from: a */
    private String f5515a;

    /* renamed from: b */
    private String f5516b;

    /* renamed from: c */
    private String f5517c;

    /* renamed from: d */
    private String f5518d;

    /* renamed from: e */
    private String f5519e;

    /* renamed from: f */
    private static Map<SortName, String> f5514f = new HashMap();
    public static final Parcelable.Creator<PoiFilter> CREATOR = new Parcelable.Creator<PoiFilter>() { // from class: com.baidu.mapapi.search.poi.PoiFilter.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiFilter createFromParcel(Parcel parcel) {
            return new PoiFilter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final PoiFilter[] newArray(int i) {
            return new PoiFilter[i];
        }
    };

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private String f5521a;

        /* renamed from: b */
        private String f5522b;

        /* renamed from: c */
        private String f5523c;

        /* renamed from: d */
        private String f5524d;

        /* renamed from: e */
        private String f5525e;

        public Builder() {
            PoiFilter.f5514f.put(SortName.HotelSortName.DEFAULT, "default");
            PoiFilter.f5514f.put(SortName.HotelSortName.HOTEL_LEVEL, "level");
            PoiFilter.f5514f.put(SortName.HotelSortName.HOTEL_PRICE, "price");
            PoiFilter.f5514f.put(SortName.HotelSortName.HOTEL_DISTANCE, "distance");
            PoiFilter.f5514f.put(SortName.HotelSortName.HOTEL_HEALTH_SCORE, "health_score");
            PoiFilter.f5514f.put(SortName.HotelSortName.HOTEL_TOTAL_SCORE, "total_score");
            PoiFilter.f5514f.put(SortName.CaterSortName.DEFAULT, "default");
            PoiFilter.f5514f.put(SortName.CaterSortName.CATER_DISTANCE, "distance");
            PoiFilter.f5514f.put(SortName.CaterSortName.CATER_PRICE, "price");
            PoiFilter.f5514f.put(SortName.CaterSortName.CATER_OVERALL_RATING, "overall_rating");
            PoiFilter.f5514f.put(SortName.CaterSortName.CATER_SERVICE_RATING, "service_rating");
            PoiFilter.f5514f.put(SortName.CaterSortName.CATER_TASTE_RATING, "taste_rating");
            PoiFilter.f5514f.put(SortName.LifeSortName.DEFAULT, "default");
            PoiFilter.f5514f.put(SortName.LifeSortName.PRICE, "price");
            PoiFilter.f5514f.put(SortName.LifeSortName.LIFE_COMMENT_RATING, "comment_num");
            PoiFilter.f5514f.put(SortName.LifeSortName.LIFE_OVERALL_RATING, "overall_rating");
            PoiFilter.f5514f.put(SortName.LifeSortName.DISTANCE, "distance");
        }

        public final PoiFilter build() {
            return new PoiFilter(this.f5521a, this.f5522b, this.f5523c, this.f5525e, this.f5524d);
        }

        public final Builder industryType(IndustryType industryType) {
            String str;
            switch (industryType) {
                case HOTEL:
                    str = "hotel";
                    break;
                case CATER:
                    str = "cater";
                    break;
                case LIFE:
                    str = "life";
                    break;
                default:
                    str = "";
                    break;
            }
            this.f5521a = str;
            return this;
        }

        public final Builder isDiscount(boolean z) {
            this.f5525e = z ? "1" : "0";
            return this;
        }

        public final Builder isGroupon(boolean z) {
            this.f5524d = z ? "1" : "0";
            return this;
        }

        public final Builder sortName(SortName sortName) {
            if (!TextUtils.isEmpty(this.f5521a) && sortName != null) {
                this.f5522b = (String) PoiFilter.f5514f.get(sortName);
            }
            return this;
        }

        public final Builder sortRule(int i) {
            this.f5523c = String.valueOf(i);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum IndustryType {
        HOTEL,
        CATER,
        LIFE
    }

    /* loaded from: classes.dex */
    public interface SortName {

        /* loaded from: classes.dex */
        public enum CaterSortName implements SortName {
            DEFAULT,
            CATER_PRICE,
            CATER_DISTANCE,
            CATER_TASTE_RATING,
            CATER_OVERALL_RATING,
            CATER_SERVICE_RATING
        }

        /* loaded from: classes.dex */
        public enum HotelSortName implements SortName {
            DEFAULT,
            HOTEL_PRICE,
            HOTEL_DISTANCE,
            HOTEL_TOTAL_SCORE,
            HOTEL_LEVEL,
            HOTEL_HEALTH_SCORE
        }

        /* loaded from: classes.dex */
        public enum LifeSortName implements SortName {
            DEFAULT,
            PRICE,
            DISTANCE,
            LIFE_OVERALL_RATING,
            LIFE_COMMENT_RATING
        }
    }

    protected PoiFilter(Parcel parcel) {
        this.f5515a = "";
        this.f5516b = "";
        this.f5517c = "";
        this.f5518d = "";
        this.f5519e = "";
        this.f5515a = parcel.readString();
        this.f5516b = parcel.readString();
        this.f5517c = parcel.readString();
        this.f5519e = parcel.readString();
        this.f5518d = parcel.readString();
    }

    PoiFilter(String str, String str2, String str3, String str4, String str5) {
        this.f5515a = "";
        this.f5516b = "";
        this.f5517c = "";
        this.f5518d = "";
        this.f5519e = "";
        this.f5515a = str;
        this.f5516b = str2;
        this.f5517c = str3;
        this.f5519e = str4;
        this.f5518d = str5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.f5515a)) {
            sb.append("industry_type:");
            sb.append(this.f5515a);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.f5516b)) {
            sb.append("sort_name:");
            sb.append(this.f5516b);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.f5517c)) {
            sb.append("sort_rule:");
            sb.append(this.f5517c);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.f5519e)) {
            sb.append("discount:");
            sb.append(this.f5519e);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(this.f5518d)) {
            sb.append("groupon:");
            sb.append(this.f5518d);
            sb.append("|");
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5515a);
        parcel.writeString(this.f5516b);
        parcel.writeString(this.f5517c);
        parcel.writeString(this.f5519e);
        parcel.writeString(this.f5518d);
    }
}
