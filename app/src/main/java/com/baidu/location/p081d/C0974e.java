package com.baidu.location.p081d;

import android.database.Cursor;
import android.database.MatrixCursor;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.p082e.C0986a;
import com.baidu.location.p082e.C0987b;
import com.baidu.location.p082e.C0997e;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1016g;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.itextpdf.text.pdf.PdfBoolean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.location.d.e */
/* loaded from: classes.dex */
public final class C0974e {

    /* renamed from: a */
    private static final String[] f4332a = {"CoorType", "Time", "LocType", "Longitude", "Latitude", "Radius", "NetworkLocationType", "Country", "CountryCode", "Province", "City", "CityCode", "District", "Street", "StreetNumber", "PoiList", "LocationDescription"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.d.e$a */
    /* loaded from: classes.dex */
    public static final class C0975a {

        /* renamed from: a */
        final String f4333a;

        /* renamed from: b */
        final String f4334b;

        /* renamed from: c */
        final boolean f4335c;

        /* renamed from: d */
        final boolean f4336d;

        /* renamed from: e */
        final boolean f4337e;

        /* renamed from: f */
        final int f4338f;

        /* renamed from: g */
        final BDLocation f4339g;

        /* renamed from: h */
        final boolean f4340h;

        /* renamed from: i */
        final LinkedHashMap<String, Integer> f4341i;

        public C0975a(String[] strArr) {
            String str;
            boolean z;
            String str2;
            BDLocation bDLocation;
            String[] strArr2;
            if (strArr == null) {
                this.f4333a = null;
                this.f4334b = null;
                this.f4341i = null;
                this.f4335c = false;
                this.f4336d = false;
                this.f4337e = false;
                this.f4339g = null;
                this.f4340h = false;
                this.f4338f = 8;
                return;
            }
            LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
            String str3 = null;
            String str4 = null;
            BDLocation bDLocation2 = null;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            int i = 8;
            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                try {
                    int i3 = 3;
                    if (strArr[i2].equals("-loc")) {
                        str3 = strArr[i2 + 1];
                        String[] split = str3.split("&");
                        String str5 = str4;
                        int i4 = 0;
                        while (i4 < split.length) {
                            try {
                                if (split[i4].startsWith("cl=")) {
                                    strArr2 = split;
                                    str5 = split[i4].substring(i3);
                                } else {
                                    if (split[i4].startsWith("wf=")) {
                                        String[] split2 = split[i4].substring(i3).split("\\|");
                                        int i5 = 0;
                                        while (i5 < split2.length) {
                                            String[] strArr3 = split;
                                            String[] split3 = split2[i5].split(";");
                                            String[] strArr4 = split2;
                                            if (split3.length >= 2) {
                                                linkedHashMap.put(split3[0], Integer.valueOf(split3[1]));
                                            }
                                            i5++;
                                            split = strArr3;
                                            split2 = strArr4;
                                        }
                                    }
                                    strArr2 = split;
                                }
                                i4++;
                                split = strArr2;
                                i3 = 3;
                            } catch (Exception unused) {
                                str = str3;
                                str4 = str5;
                                str2 = str;
                                z = false;
                                this.f4333a = str2;
                                this.f4334b = str4;
                                this.f4341i = linkedHashMap;
                                this.f4335c = z;
                                this.f4336d = z3;
                                this.f4337e = z4;
                                this.f4338f = i;
                                this.f4339g = bDLocation2;
                                this.f4340h = z5;
                            }
                        }
                        str4 = str5;
                    } else if (strArr[i2].equals("-com")) {
                        String[] split4 = strArr[i2 + 1].split(";");
                        if (split4.length > 0) {
                            bDLocation = new BDLocation();
                            try {
                                bDLocation.setLatitude(Double.valueOf(split4[0]).doubleValue());
                                bDLocation.setLongitude(Double.valueOf(split4[1]).doubleValue());
                                bDLocation.setLocType(Integer.valueOf(split4[2]).intValue());
                                bDLocation.setNetworkLocationType(split4[3]);
                            } catch (Exception unused2) {
                                bDLocation2 = bDLocation;
                                str = str3;
                                str2 = str;
                                z = false;
                                this.f4333a = str2;
                                this.f4334b = str4;
                                this.f4341i = linkedHashMap;
                                this.f4335c = z;
                                this.f4336d = z3;
                                this.f4337e = z4;
                                this.f4338f = i;
                                this.f4339g = bDLocation2;
                                this.f4340h = z5;
                            }
                        } else {
                            bDLocation = bDLocation2;
                        }
                        bDLocation2 = bDLocation;
                    } else if (strArr[i2].equals("-log")) {
                        if (strArr[i2 + 1].equals(PdfBoolean.TRUE)) {
                            z2 = true;
                        }
                    } else if (strArr[i2].equals("-rgc")) {
                        if (strArr[i2 + 1].equals(PdfBoolean.TRUE)) {
                            z4 = true;
                        }
                    } else if (strArr[i2].equals("-poi")) {
                        if (strArr[i2 + 1].equals(PdfBoolean.TRUE)) {
                            z3 = true;
                        }
                    } else if (strArr[i2].equals("-minap")) {
                        try {
                            i = Integer.valueOf(strArr[i2 + 1]).intValue();
                        } catch (Exception unused3) {
                        }
                    } else if (strArr[i2].equals("-des") && strArr[i2 + 1].equals(PdfBoolean.TRUE)) {
                        z5 = true;
                    }
                } catch (Exception unused4) {
                }
            }
            z = true;
            str2 = !z2 ? null : str3;
            this.f4333a = str2;
            this.f4334b = str4;
            this.f4341i = linkedHashMap;
            this.f4335c = z;
            this.f4336d = z3;
            this.f4337e = z4;
            this.f4338f = i;
            this.f4339g = bDLocation2;
            this.f4340h = z5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static Cursor m11782a(BDLocation bDLocation) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
        MatrixCursor matrixCursor = new MatrixCursor(f4332a);
        Object[] objArr = new Object[f4332a.length];
        objArr[matrixCursor.getColumnIndex("CoorType")] = CoordinateType.GCJ02;
        objArr[matrixCursor.getColumnIndex("Time")] = format;
        objArr[matrixCursor.getColumnIndex("LocType")] = Integer.valueOf(bDLocation.getLocType());
        objArr[matrixCursor.getColumnIndex("Longitude")] = Double.valueOf(bDLocation.getLongitude());
        objArr[matrixCursor.getColumnIndex("Latitude")] = Double.valueOf(bDLocation.getLatitude());
        objArr[matrixCursor.getColumnIndex("Radius")] = Float.valueOf(bDLocation.getRadius());
        objArr[matrixCursor.getColumnIndex("NetworkLocationType")] = bDLocation.getNetworkLocationType();
        Address address = bDLocation.getAddress();
        if (address != null) {
            str2 = address.country;
            str3 = address.countryCode;
            str4 = address.province;
            str5 = address.city;
            str6 = address.cityCode;
            str7 = address.district;
            str8 = address.street;
            str = address.streetNumber;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
        }
        objArr[matrixCursor.getColumnIndex("Country")] = str2;
        objArr[matrixCursor.getColumnIndex("CountryCode")] = str3;
        objArr[matrixCursor.getColumnIndex("Province")] = str4;
        objArr[matrixCursor.getColumnIndex("City")] = str5;
        objArr[matrixCursor.getColumnIndex("CityCode")] = str6;
        objArr[matrixCursor.getColumnIndex("District")] = str7;
        objArr[matrixCursor.getColumnIndex("Street")] = str8;
        objArr[matrixCursor.getColumnIndex("StreetNumber")] = str;
        List<Poi> poiList = bDLocation.getPoiList();
        if (poiList == null) {
            objArr[matrixCursor.getColumnIndex("PoiList")] = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < poiList.size(); i++) {
                Poi poi = poiList.get(i);
                stringBuffer.append(poi.getId());
                stringBuffer.append(";");
                stringBuffer.append(poi.getName());
                stringBuffer.append(";");
                stringBuffer.append(poi.getRank());
                stringBuffer.append(";|");
            }
            objArr[matrixCursor.getColumnIndex("PoiList")] = stringBuffer.toString();
        }
        objArr[matrixCursor.getColumnIndex("LocationDescription")] = bDLocation.getLocationDescribe();
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01d6, code lost:
        if (r11.size() != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01df, code lost:
        if (r11.size() == 0) goto L65;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.location.BDLocation m11783a(android.database.Cursor r22) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p081d.C0974e.m11783a(android.database.Cursor):com.baidu.location.BDLocation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m11781a(BDLocation bDLocation, int i) {
        if (bDLocation == null || bDLocation.getLocType() == 67) {
            return String.format(Locale.CHINA, "&ofl=%s|%d", "1", Integer.valueOf(i));
        }
        String format = String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", "1", Integer.valueOf(i), Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius()));
        if (bDLocation.getAddress() != null) {
            format = format + "&ofaddr=" + bDLocation.getAddress().address;
        }
        if (bDLocation.getPoiList() != null && bDLocation.getPoiList().size() > 0) {
            Poi poi = bDLocation.getPoiList().get(0);
            format = format + String.format(Locale.US, "&ofpoi=%s|%s", poi.getId(), poi.getName());
        }
        if (C1006b.f4490d != null) {
            return format + String.format(Locale.US, "&pack=%s&sdk=%.3f", C1006b.f4490d, Float.valueOf(7.51f));
        }
        return format;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m11780a(BDLocation bDLocation, BDLocation bDLocation2, C0975a c0975a) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bDLocation2 == null ? "&ofcl=0" : String.format(Locale.US, "&ofcl=1|%f|%f|%d", Double.valueOf(bDLocation2.getLongitude()), Double.valueOf(bDLocation2.getLatitude()), Integer.valueOf((int) bDLocation2.getRadius())));
        stringBuffer.append(bDLocation == null ? "&ofwf=0" : String.format(Locale.US, "&ofwf=1|%f|%f|%d", Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius())));
        stringBuffer.append((c0975a == null || !c0975a.f4337e) ? "&rgcn=0" : "&rgcn=1");
        stringBuffer.append((c0975a == null || !c0975a.f4336d) ? "&poin=0" : "&poin=1");
        stringBuffer.append((c0975a == null || !c0975a.f4340h) ? "&desc=0" : "&desc=1");
        if (c0975a != null) {
            stringBuffer.append(String.format(Locale.US, "&aps=%d", Integer.valueOf(c0975a.f4338f)));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String[] m11779a(C0986a c0986a, C0997e c0997e, BDLocation bDLocation, String str, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (c0986a != null) {
            stringBuffer.append(C0987b.m11732a().m11723b(c0986a));
        }
        if (c0997e != null) {
            stringBuffer.append(c0997e.m11663a(30));
        }
        if (stringBuffer.length() > 0) {
            if (str != null) {
                stringBuffer.append(str);
            }
            arrayList.add("-loc");
            arrayList.add(stringBuffer.toString());
        }
        if (bDLocation != null) {
            String format = String.format(Locale.US, "%f;%f;%d;%s", Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Integer.valueOf(bDLocation.getLocType()), bDLocation.getNetworkLocationType());
            arrayList.add("-com");
            arrayList.add(format);
        }
        if (z) {
            arrayList.add("-log");
            arrayList.add(PdfBoolean.TRUE);
        }
        if (C1016g.f4597g.equals("all")) {
            arrayList.add("-rgc");
            arrayList.add(PdfBoolean.TRUE);
        }
        if (C1016g.f4599i) {
            arrayList.add("-poi");
            arrayList.add(PdfBoolean.TRUE);
        }
        if (C1016g.f4598h) {
            arrayList.add("-des");
            arrayList.add(PdfBoolean.TRUE);
        }
        arrayList.add("-minap");
        arrayList.add(Integer.toString(i));
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }
}
