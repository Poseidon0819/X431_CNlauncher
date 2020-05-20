package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.location.Address;
import com.baidu.location.p084g.C1016g;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Parcelable.Creator<BDLocation> CREATOR = new Parcelable.Creator<BDLocation>() { // from class: com.baidu.location.BDLocation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BDLocation createFromParcel(Parcel parcel) {
            return new BDLocation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BDLocation[] newArray(int i) {
            return new BDLocation[i];
        }
    };
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = -1;

    /* renamed from: A */
    private int f3761A;

    /* renamed from: B */
    private String f3762B;

    /* renamed from: C */
    private int f3763C;

    /* renamed from: D */
    private String f3764D;

    /* renamed from: E */
    private int f3765E;

    /* renamed from: F */
    private int f3766F;

    /* renamed from: G */
    private int f3767G;

    /* renamed from: H */
    private int f3768H;

    /* renamed from: I */
    private String f3769I;

    /* renamed from: J */
    private String f3770J;

    /* renamed from: K */
    private String f3771K;

    /* renamed from: L */
    private List<Poi> f3772L;

    /* renamed from: M */
    private String f3773M;

    /* renamed from: N */
    private String f3774N;

    /* renamed from: O */
    private HashMap<String, String> f3775O;

    /* renamed from: P */
    private int f3776P;

    /* renamed from: Q */
    private int f3777Q;

    /* renamed from: a */
    private int f3778a;

    /* renamed from: b */
    private String f3779b;

    /* renamed from: c */
    private double f3780c;

    /* renamed from: d */
    private double f3781d;

    /* renamed from: e */
    private boolean f3782e;

    /* renamed from: f */
    private double f3783f;

    /* renamed from: g */
    private boolean f3784g;

    /* renamed from: h */
    private float f3785h;

    /* renamed from: i */
    private boolean f3786i;

    /* renamed from: j */
    private float f3787j;

    /* renamed from: k */
    private boolean f3788k;

    /* renamed from: l */
    private int f3789l;

    /* renamed from: m */
    private float f3790m;

    /* renamed from: n */
    private String f3791n;

    /* renamed from: o */
    private boolean f3792o;

    /* renamed from: p */
    private String f3793p;

    /* renamed from: q */
    private String f3794q;

    /* renamed from: r */
    private String f3795r;

    /* renamed from: s */
    private String f3796s;

    /* renamed from: t */
    private boolean f3797t;

    /* renamed from: u */
    private Address f3798u;

    /* renamed from: v */
    private String f3799v;

    /* renamed from: w */
    private String f3800w;

    /* renamed from: x */
    private String f3801x;

    /* renamed from: y */
    private boolean f3802y;

    /* renamed from: z */
    private int f3803z;

    public BDLocation() {
        this.f3778a = 0;
        this.f3779b = null;
        this.f3780c = Double.MIN_VALUE;
        this.f3781d = Double.MIN_VALUE;
        this.f3782e = false;
        this.f3783f = Double.MIN_VALUE;
        this.f3784g = false;
        this.f3785h = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f3786i = false;
        this.f3787j = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f3788k = false;
        this.f3789l = -1;
        this.f3790m = -1.0f;
        this.f3791n = null;
        this.f3792o = false;
        this.f3793p = null;
        this.f3794q = null;
        this.f3795r = null;
        this.f3796s = null;
        this.f3797t = false;
        this.f3798u = new Address.Builder().build();
        this.f3799v = null;
        this.f3800w = null;
        this.f3801x = null;
        this.f3802y = false;
        this.f3803z = 0;
        this.f3761A = 1;
        this.f3762B = null;
        this.f3764D = "";
        this.f3765E = -1;
        this.f3766F = 0;
        this.f3767G = 2;
        this.f3768H = 0;
        this.f3769I = null;
        this.f3770J = null;
        this.f3771K = null;
        this.f3772L = null;
        this.f3773M = null;
        this.f3774N = null;
        this.f3775O = new HashMap<>();
        this.f3776P = 0;
        this.f3777Q = 0;
    }

    private BDLocation(Parcel parcel) {
        this.f3778a = 0;
        this.f3779b = null;
        this.f3780c = Double.MIN_VALUE;
        this.f3781d = Double.MIN_VALUE;
        this.f3782e = false;
        this.f3783f = Double.MIN_VALUE;
        this.f3784g = false;
        this.f3785h = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f3786i = false;
        this.f3787j = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f3788k = false;
        this.f3789l = -1;
        this.f3790m = -1.0f;
        this.f3791n = null;
        this.f3792o = false;
        this.f3793p = null;
        this.f3794q = null;
        this.f3795r = null;
        this.f3796s = null;
        this.f3797t = false;
        this.f3798u = new Address.Builder().build();
        this.f3799v = null;
        this.f3800w = null;
        this.f3801x = null;
        this.f3802y = false;
        this.f3803z = 0;
        this.f3761A = 1;
        this.f3762B = null;
        this.f3764D = "";
        this.f3765E = -1;
        this.f3766F = 0;
        this.f3767G = 2;
        this.f3768H = 0;
        this.f3769I = null;
        this.f3770J = null;
        this.f3771K = null;
        this.f3772L = null;
        this.f3773M = null;
        this.f3774N = null;
        this.f3775O = new HashMap<>();
        this.f3776P = 0;
        this.f3777Q = 0;
        this.f3778a = parcel.readInt();
        this.f3779b = parcel.readString();
        this.f3780c = parcel.readDouble();
        this.f3781d = parcel.readDouble();
        this.f3783f = parcel.readDouble();
        this.f3785h = parcel.readFloat();
        this.f3787j = parcel.readFloat();
        this.f3789l = parcel.readInt();
        this.f3790m = parcel.readFloat();
        this.f3799v = parcel.readString();
        this.f3803z = parcel.readInt();
        this.f3800w = parcel.readString();
        this.f3801x = parcel.readString();
        this.f3762B = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        String readString8 = parcel.readString();
        this.f3798u = new Address.Builder().country(readString7).countryCode(readString8).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).adcode(parcel.readString()).build();
        boolean[] zArr = new boolean[7];
        this.f3763C = parcel.readInt();
        this.f3764D = parcel.readString();
        this.f3794q = parcel.readString();
        this.f3795r = parcel.readString();
        this.f3796s = parcel.readString();
        this.f3761A = parcel.readInt();
        this.f3773M = parcel.readString();
        this.f3765E = parcel.readInt();
        this.f3766F = parcel.readInt();
        this.f3767G = parcel.readInt();
        this.f3768H = parcel.readInt();
        this.f3769I = parcel.readString();
        this.f3770J = parcel.readString();
        this.f3771K = parcel.readString();
        this.f3776P = parcel.readInt();
        this.f3774N = parcel.readString();
        this.f3777Q = parcel.readInt();
        try {
            parcel.readBooleanArray(zArr);
            this.f3782e = zArr[0];
            this.f3784g = zArr[1];
            this.f3786i = zArr[2];
            this.f3788k = zArr[3];
            this.f3792o = zArr[4];
            this.f3797t = zArr[5];
            this.f3802y = zArr[6];
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.f3772L = null;
        } else {
            this.f3772L = arrayList;
        }
    }

    public BDLocation(BDLocation bDLocation) {
        this.f3778a = 0;
        ArrayList arrayList = null;
        this.f3779b = null;
        this.f3780c = Double.MIN_VALUE;
        this.f3781d = Double.MIN_VALUE;
        this.f3782e = false;
        this.f3783f = Double.MIN_VALUE;
        this.f3784g = false;
        this.f3785h = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f3786i = false;
        this.f3787j = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f3788k = false;
        this.f3789l = -1;
        this.f3790m = -1.0f;
        this.f3791n = null;
        this.f3792o = false;
        this.f3793p = null;
        this.f3794q = null;
        this.f3795r = null;
        this.f3796s = null;
        this.f3797t = false;
        this.f3798u = new Address.Builder().build();
        this.f3799v = null;
        this.f3800w = null;
        this.f3801x = null;
        this.f3802y = false;
        this.f3803z = 0;
        this.f3761A = 1;
        this.f3762B = null;
        this.f3764D = "";
        this.f3765E = -1;
        this.f3766F = 0;
        this.f3767G = 2;
        this.f3768H = 0;
        this.f3769I = null;
        this.f3770J = null;
        this.f3771K = null;
        this.f3772L = null;
        this.f3773M = null;
        this.f3774N = null;
        this.f3775O = new HashMap<>();
        this.f3776P = 0;
        this.f3777Q = 0;
        this.f3778a = bDLocation.f3778a;
        this.f3779b = bDLocation.f3779b;
        this.f3780c = bDLocation.f3780c;
        this.f3781d = bDLocation.f3781d;
        this.f3782e = bDLocation.f3782e;
        this.f3783f = bDLocation.f3783f;
        this.f3784g = bDLocation.f3784g;
        this.f3785h = bDLocation.f3785h;
        this.f3786i = bDLocation.f3786i;
        this.f3787j = bDLocation.f3787j;
        this.f3788k = bDLocation.f3788k;
        this.f3789l = bDLocation.f3789l;
        this.f3790m = bDLocation.f3790m;
        this.f3791n = bDLocation.f3791n;
        this.f3792o = bDLocation.f3792o;
        this.f3793p = bDLocation.f3793p;
        this.f3797t = bDLocation.f3797t;
        this.f3798u = new Address.Builder().country(bDLocation.f3798u.country).countryCode(bDLocation.f3798u.countryCode).province(bDLocation.f3798u.province).city(bDLocation.f3798u.city).cityCode(bDLocation.f3798u.cityCode).district(bDLocation.f3798u.district).street(bDLocation.f3798u.street).streetNumber(bDLocation.f3798u.streetNumber).adcode(bDLocation.f3798u.adcode).build();
        this.f3799v = bDLocation.f3799v;
        this.f3800w = bDLocation.f3800w;
        this.f3801x = bDLocation.f3801x;
        this.f3761A = bDLocation.f3761A;
        this.f3803z = bDLocation.f3803z;
        this.f3802y = bDLocation.f3802y;
        this.f3762B = bDLocation.f3762B;
        this.f3763C = bDLocation.f3763C;
        this.f3764D = bDLocation.f3764D;
        this.f3794q = bDLocation.f3794q;
        this.f3795r = bDLocation.f3795r;
        this.f3796s = bDLocation.f3796s;
        this.f3765E = bDLocation.f3765E;
        this.f3766F = bDLocation.f3766F;
        this.f3767G = bDLocation.f3766F;
        this.f3768H = bDLocation.f3768H;
        this.f3769I = bDLocation.f3769I;
        this.f3770J = bDLocation.f3770J;
        this.f3771K = bDLocation.f3771K;
        this.f3776P = bDLocation.f3776P;
        this.f3774N = bDLocation.f3774N;
        if (bDLocation.f3772L != null) {
            arrayList = new ArrayList();
            for (int i = 0; i < bDLocation.f3772L.size(); i++) {
                Poi poi = bDLocation.f3772L.get(i);
                arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
            }
        }
        this.f3772L = arrayList;
        this.f3773M = bDLocation.f3773M;
        this.f3775O = bDLocation.f3775O;
        this.f3777Q = bDLocation.f3777Q;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0368 A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03a8 A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03c3 A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03e2 A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03fd A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0418 A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0433 A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x050e A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0518 A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TRY_LEAVE, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0523 A[Catch: Exception -> 0x0534, Error -> 0x05a0, TryCatch #6 {Exception -> 0x0534, blocks: (B:227:0x051b, B:229:0x0523, B:230:0x0531), top: B:268:0x051b }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0531 A[Catch: Exception -> 0x0534, Error -> 0x05a0, TRY_LEAVE, TryCatch #6 {Exception -> 0x0534, blocks: (B:227:0x051b, B:229:0x0523, B:230:0x0531), top: B:268:0x051b }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0538 A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x053e A[Catch: Error -> 0x05a0, Exception -> 0x05aa, TryCatch #3 {Exception -> 0x05aa, blocks: (B:7:0x0081, B:9:0x00a6, B:16:0x012a, B:18:0x012e, B:20:0x0134, B:24:0x013e, B:26:0x0179, B:28:0x0187, B:30:0x0193, B:32:0x0199, B:34:0x01a1, B:35:0x01b3, B:37:0x01b9, B:38:0x01da, B:39:0x01dc, B:41:0x01e4, B:43:0x01f0, B:44:0x01f2, B:46:0x01fa, B:48:0x0206, B:49:0x0208, B:55:0x021c, B:57:0x0236, B:58:0x023c, B:60:0x0244, B:61:0x024a, B:63:0x0252, B:64:0x0258, B:66:0x0260, B:67:0x0266, B:69:0x026e, B:70:0x0274, B:72:0x027c, B:73:0x0282, B:75:0x028a, B:76:0x0290, B:78:0x0298, B:79:0x029e, B:81:0x02a6, B:153:0x0368, B:155:0x03a0, B:157:0x03a8, B:159:0x03b8, B:160:0x03bb, B:162:0x03c3, B:164:0x03cf, B:165:0x03da, B:167:0x03e2, B:169:0x03f2, B:170:0x03f5, B:172:0x03fd, B:174:0x040d, B:175:0x0410, B:177:0x0418, B:179:0x0428, B:180:0x042b, B:182:0x0433, B:184:0x043f, B:185:0x0442, B:188:0x044b, B:189:0x0455, B:223:0x0506, B:225:0x050e, B:231:0x0534, B:233:0x0538, B:235:0x053e, B:226:0x0518, B:222:0x0503, B:151:0x0361, B:154:0x039a, B:244:0x0551, B:246:0x0556), top: B:263:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x045d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BDLocation(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 1457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.BDLocation.<init>(java.lang.String):void");
    }

    /* renamed from: a */
    private void m12331a(Boolean bool) {
        this.f3797t = bool.booleanValue();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAdCode() {
        return this.f3798u.adcode;
    }

    public final String getAddrStr() {
        return this.f3798u.address;
    }

    public final Address getAddress() {
        return this.f3798u;
    }

    public final double getAltitude() {
        return this.f3783f;
    }

    public final String getBuildingID() {
        return this.f3800w;
    }

    public final String getBuildingName() {
        return this.f3801x;
    }

    public final String getCity() {
        return this.f3798u.city;
    }

    public final String getCityCode() {
        return this.f3798u.cityCode;
    }

    public final String getCoorType() {
        return this.f3791n;
    }

    public final String getCountry() {
        return this.f3798u.country;
    }

    public final String getCountryCode() {
        return this.f3798u.countryCode;
    }

    @Deprecated
    public final float getDerect() {
        return this.f3790m;
    }

    public final float getDirection() {
        return this.f3790m;
    }

    public final String getDistrict() {
        return this.f3798u.district;
    }

    public final String getFloor() {
        return this.f3799v;
    }

    public final int getGpsAccuracyStatus() {
        return this.f3776P;
    }

    public final int getGpsCheckStatus() {
        return this.f3777Q;
    }

    public final int getIndoorLocationSource() {
        return this.f3768H;
    }

    public final int getIndoorLocationSurpport() {
        return this.f3766F;
    }

    public final String getIndoorLocationSurpportBuidlingID() {
        return this.f3770J;
    }

    public final String getIndoorLocationSurpportBuidlingName() {
        return this.f3769I;
    }

    public final int getIndoorNetworkState() {
        return this.f3767G;
    }

    public final String getIndoorSurpportPolygon() {
        return this.f3771K;
    }

    public final double getLatitude() {
        return this.f3780c;
    }

    public final int getLocType() {
        return this.f3778a;
    }

    public final String getLocTypeDescription() {
        return this.f3773M;
    }

    public final String getLocationDescribe() {
        return this.f3794q;
    }

    public final String getLocationID() {
        return this.f3774N;
    }

    public final int getLocationWhere() {
        return this.f3761A;
    }

    public final double getLongitude() {
        return this.f3781d;
    }

    public final String getNetworkLocationType() {
        return this.f3762B;
    }

    public final int getOperators() {
        return this.f3763C;
    }

    public final List<Poi> getPoiList() {
        return this.f3772L;
    }

    public final String getProvince() {
        return this.f3798u.province;
    }

    public final float getRadius() {
        return this.f3787j;
    }

    public final String getRetFields(String str) {
        return this.f3775O.get(str);
    }

    public final int getSatelliteNumber() {
        this.f3788k = true;
        return this.f3789l;
    }

    @Deprecated
    public final String getSemaAptag() {
        return this.f3794q;
    }

    public final float getSpeed() {
        return this.f3785h;
    }

    public final String getStreet() {
        return this.f3798u.street;
    }

    public final String getStreetNumber() {
        return this.f3798u.streetNumber;
    }

    public final String getTime() {
        return this.f3779b;
    }

    public final int getUserIndoorState() {
        return this.f3765E;
    }

    public final boolean hasAddr() {
        return this.f3792o;
    }

    public final boolean hasAltitude() {
        return this.f3782e;
    }

    public final boolean hasRadius() {
        return this.f3786i;
    }

    public final boolean hasSateNumber() {
        return this.f3788k;
    }

    public final boolean hasSpeed() {
        return this.f3784g;
    }

    public final boolean isCellChangeFlag() {
        return this.f3797t;
    }

    public final boolean isIndoorLocMode() {
        return this.f3802y;
    }

    public final int isParkAvailable() {
        return this.f3803z;
    }

    public final void setAddr(Address address) {
        if (address != null) {
            this.f3798u = address;
            this.f3792o = true;
        }
    }

    public final void setAddrStr(String str) {
        this.f3793p = str;
        this.f3792o = str != null;
    }

    public final void setAltitude(double d) {
        this.f3783f = d;
        this.f3782e = true;
    }

    public final void setBuildingID(String str) {
        this.f3800w = str;
    }

    public final void setBuildingName(String str) {
        this.f3801x = str;
    }

    public final void setCoorType(String str) {
        this.f3791n = str;
    }

    public final void setDirection(float f) {
        this.f3790m = f;
    }

    public final void setFloor(String str) {
        this.f3799v = str;
    }

    public final void setGpsAccuracyStatus(int i) {
        this.f3776P = i;
    }

    public final void setGpsCheckStatus(int i) {
        this.f3777Q = i;
    }

    public final void setIndoorLocMode(boolean z) {
        this.f3802y = z;
    }

    public final void setIndoorLocationSource(int i) {
        this.f3768H = i;
    }

    public final void setIndoorLocationSurpport(int i) {
        this.f3766F = i;
    }

    public final void setIndoorNetworkState(int i) {
        this.f3767G = i;
    }

    public final void setIndoorSurpportPolygon(String str) {
        this.f3771K = str;
    }

    public final void setLatitude(double d) {
        this.f3780c = d;
    }

    public final void setLocType(int i) {
        this.f3778a = i;
        switch (i) {
            case 61:
                setLocTypeDescription("GPS location successful!");
                setUserIndoorState(0);
                return;
            case 62:
                setLocTypeDescription("Location failed beacuse we can not get any loc information!");
                return;
            case 63:
            case 67:
                setLocTypeDescription("Offline location failed, please check the net (wifi/cell)!");
                return;
            case 66:
                setLocTypeDescription("Offline location successful!");
                return;
            case 161:
                setLocTypeDescription("NetWork location successful!");
                return;
            case 162:
                setLocTypeDescription("NetWork location failed because baidu location service can not decrypt the request query, please check the so file !");
                return;
            case 167:
                setLocTypeDescription("NetWork location failed because baidu location service can not caculate the location!");
                return;
            case 505:
                setLocTypeDescription("NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !");
                return;
            default:
                setLocTypeDescription("UnKnown!");
                return;
        }
    }

    public final void setLocTypeDescription(String str) {
        this.f3773M = str;
    }

    public final void setLocationDescribe(String str) {
        this.f3794q = str;
    }

    public final void setLocationID(String str) {
        this.f3774N = str;
    }

    public final void setLocationWhere(int i) {
        this.f3761A = i;
    }

    public final void setLongitude(double d) {
        this.f3781d = d;
    }

    public final void setNetworkLocationType(String str) {
        this.f3762B = str;
    }

    public final void setOperators(int i) {
        this.f3763C = i;
    }

    public final void setParkAvailable(int i) {
        this.f3803z = i;
    }

    public final void setPoiList(List<Poi> list) {
        this.f3772L = list;
    }

    public final void setRadius(float f) {
        this.f3787j = f;
        this.f3786i = true;
    }

    public final void setSatelliteNumber(int i) {
        this.f3789l = i;
    }

    public final void setSpeed(float f) {
        this.f3785h = f;
        this.f3784g = true;
    }

    public final void setTime(String str) {
        this.f3779b = str;
        setLocationID(C1016g.m11564a(str));
    }

    public final void setUserIndoorState(int i) {
        this.f3765E = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3778a);
        parcel.writeString(this.f3779b);
        parcel.writeDouble(this.f3780c);
        parcel.writeDouble(this.f3781d);
        parcel.writeDouble(this.f3783f);
        parcel.writeFloat(this.f3785h);
        parcel.writeFloat(this.f3787j);
        parcel.writeInt(this.f3789l);
        parcel.writeFloat(this.f3790m);
        parcel.writeString(this.f3799v);
        parcel.writeInt(this.f3803z);
        parcel.writeString(this.f3800w);
        parcel.writeString(this.f3801x);
        parcel.writeString(this.f3762B);
        parcel.writeString(this.f3798u.province);
        parcel.writeString(this.f3798u.city);
        parcel.writeString(this.f3798u.district);
        parcel.writeString(this.f3798u.street);
        parcel.writeString(this.f3798u.streetNumber);
        parcel.writeString(this.f3798u.cityCode);
        parcel.writeString(this.f3798u.address);
        parcel.writeString(this.f3798u.country);
        parcel.writeString(this.f3798u.countryCode);
        parcel.writeString(this.f3798u.adcode);
        parcel.writeInt(this.f3763C);
        parcel.writeString(this.f3764D);
        parcel.writeString(this.f3794q);
        parcel.writeString(this.f3795r);
        parcel.writeString(this.f3796s);
        parcel.writeInt(this.f3761A);
        parcel.writeString(this.f3773M);
        parcel.writeInt(this.f3765E);
        parcel.writeInt(this.f3766F);
        parcel.writeInt(this.f3767G);
        parcel.writeInt(this.f3768H);
        parcel.writeString(this.f3769I);
        parcel.writeString(this.f3770J);
        parcel.writeString(this.f3771K);
        parcel.writeInt(this.f3776P);
        parcel.writeString(this.f3774N);
        parcel.writeInt(this.f3777Q);
        parcel.writeBooleanArray(new boolean[]{this.f3782e, this.f3784g, this.f3786i, this.f3788k, this.f3792o, this.f3797t, this.f3802y});
        parcel.writeList(this.f3772L);
    }
}
