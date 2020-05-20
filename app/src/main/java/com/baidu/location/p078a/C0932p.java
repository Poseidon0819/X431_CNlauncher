package com.baidu.location.p078a;

import android.location.Location;
import com.baidu.location.p082e.C0991d;
import com.baidu.location.p082e.C0997e;
import com.baidu.location.p082e.C0998f;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1005a;
import com.baidu.location.p084g.C1015f;
import com.baidu.location.p084g.C1016g;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.p */
/* loaded from: classes.dex */
public class C0932p {

    /* renamed from: B */
    private int f4115B;

    /* renamed from: a */
    long f4116a = 0;

    /* renamed from: z */
    private C0933a f4117z;

    /* renamed from: b */
    private static ArrayList<String> f4091b = new ArrayList<>();

    /* renamed from: c */
    private static ArrayList<String> f4092c = new ArrayList<>();

    /* renamed from: d */
    private static ArrayList<String> f4093d = new ArrayList<>();

    /* renamed from: e */
    private static String f4094e = C1015f.f4535a + "/yo.dat";

    /* renamed from: f */
    private static final String f4095f = C1015f.f4535a + "/yoh.dat";

    /* renamed from: g */
    private static final String f4096g = C1015f.f4535a + "/yom.dat";

    /* renamed from: h */
    private static final String f4097h = C1015f.f4535a + "/yol.dat";

    /* renamed from: i */
    private static final String f4098i = C1015f.f4535a + "/yor.dat";

    /* renamed from: j */
    private static File f4099j = null;

    /* renamed from: k */
    private static int f4100k = 8;

    /* renamed from: l */
    private static int f4101l = 8;

    /* renamed from: m */
    private static int f4102m = 16;

    /* renamed from: n */
    private static int f4103n = 1024;

    /* renamed from: o */
    private static double f4104o = 0.0d;

    /* renamed from: p */
    private static double f4105p = 0.1d;

    /* renamed from: q */
    private static double f4106q = 30.0d;

    /* renamed from: r */
    private static double f4107r = 100.0d;

    /* renamed from: s */
    private static int f4108s = 0;

    /* renamed from: t */
    private static int f4109t = 64;

    /* renamed from: u */
    private static int f4110u = 128;

    /* renamed from: v */
    private static Location f4111v = null;

    /* renamed from: w */
    private static Location f4112w = null;

    /* renamed from: x */
    private static Location f4113x = null;

    /* renamed from: y */
    private static C0997e f4114y = null;

    /* renamed from: A */
    private static C0932p f4090A = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.p$a */
    /* loaded from: classes.dex */
    public class C0933a extends AbstractC1011e {

        /* renamed from: a */
        boolean f4118a = false;

        /* renamed from: b */
        int f4119b = 0;

        /* renamed from: c */
        int f4120c = 0;

        /* renamed from: e */
        private ArrayList<String> f4122e = new ArrayList<>();

        /* renamed from: f */
        private boolean f4123f = true;

        public C0933a() {
            this.f4525k = new HashMap();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            Map<String, Object> map;
            StringBuilder sb;
            this.f4522h = C1016g.m11557c();
            if (this.f4119b != 1) {
                this.f4522h = C1016g.m11553e();
            }
            this.f4523i = 2;
            if (this.f4122e != null) {
                for (int i = 0; i < this.f4122e.size(); i++) {
                    if (this.f4119b == 1) {
                        map = this.f4525k;
                        sb = new StringBuilder("cldc[");
                    } else {
                        map = this.f4525k;
                        sb = new StringBuilder("cltr[");
                    }
                    sb.append(i);
                    sb.append("]");
                    map.put(sb.toString(), this.f4122e.get(i));
                }
                this.f4525k.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
                if (this.f4119b != 1) {
                    this.f4525k.put("qt", "cltrg");
                }
            }
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11388a(boolean z) {
            if (z && this.f4524j != null) {
                ArrayList<String> arrayList = this.f4122e;
                if (arrayList != null) {
                    arrayList.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.f4524j);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.f4123f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.f4525k != null) {
                this.f4525k.clear();
            }
            this.f4118a = false;
        }

        /* renamed from: b */
        public synchronized void m12028b() {
            if (this.f4118a) {
                return;
            }
            if (f4521o > 4 && this.f4120c < f4521o) {
                this.f4120c++;
                return;
            }
            this.f4120c = 0;
            this.f4118a = true;
            this.f4119b = 0;
            try {
                if (this.f4122e == null || this.f4122e.size() <= 0) {
                    if (this.f4122e == null) {
                        this.f4122e = new ArrayList<>();
                    }
                    this.f4119b = 0;
                    int i = 0;
                    while (true) {
                        String str = null;
                        String m12037b = this.f4119b < 2 ? C0932p.m12037b() : null;
                        if (m12037b == null && this.f4119b != 1 && this.f4123f) {
                            this.f4119b = 2;
                            try {
                                str = C0904e.m12172b();
                            } catch (Exception unused) {
                            }
                        } else {
                            this.f4119b = 1;
                            str = m12037b;
                        }
                        if (str == null) {
                            break;
                        } else if (!str.contains("err!")) {
                            this.f4122e.add(str);
                            i += str.length();
                            if (i >= C1005a.f4489i) {
                                break;
                            }
                        }
                    }
                }
                if (this.f4122e == null || this.f4122e.size() <= 0) {
                    this.f4122e.clear();
                    this.f4118a = false;
                } else if (this.f4119b != 1) {
                    m11575c(C1016g.m11553e());
                } else {
                    m11575c(C1016g.f4596f);
                }
            } catch (Exception unused2) {
                if (this.f4122e != null) {
                    this.f4122e.clear();
                }
            }
        }
    }

    private C0932p() {
        this.f4117z = null;
        this.f4115B = 0;
        this.f4117z = new C0933a();
        this.f4115B = 0;
    }

    /* renamed from: a */
    private static synchronized int m12038a(List<String> list, int i) {
        synchronized (C0932p.class) {
            if (list != null && i <= 256) {
                if (i >= 0) {
                    try {
                        if (f4099j == null) {
                            File file = new File(f4094e);
                            f4099j = file;
                            if (!file.exists()) {
                                f4099j = null;
                                return -2;
                            }
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(f4099j, "rw");
                        if (randomAccessFile.length() < 1) {
                            randomAccessFile.close();
                            return -3;
                        }
                        long j = i;
                        randomAccessFile.seek(j);
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        long readLong = randomAccessFile.readLong();
                        long j2 = readLong;
                        if (m12046a(readInt, readInt2, readInt3, readInt4, readLong) && readInt2 > 0) {
                            byte[] bArr = new byte[f4103n];
                            int i2 = f4100k;
                            while (i2 > 0 && readInt2 > 0) {
                                long j3 = j2;
                                randomAccessFile.seek(((((readInt + readInt2) - 1) % readInt3) * readInt4) + j3);
                                int readInt5 = randomAccessFile.readInt();
                                if (readInt5 > 0 && readInt5 < readInt4) {
                                    randomAccessFile.read(bArr, 0, readInt5);
                                    int i3 = readInt5 - 1;
                                    if (bArr[i3] == 0) {
                                        list.add(new String(bArr, 0, i3));
                                    }
                                }
                                i2--;
                                readInt2--;
                                j2 = j3;
                            }
                            randomAccessFile.seek(j);
                            randomAccessFile.writeInt(readInt);
                            randomAccessFile.writeInt(readInt2);
                            randomAccessFile.writeInt(readInt3);
                            randomAccessFile.writeInt(readInt4);
                            randomAccessFile.writeLong(j2);
                            randomAccessFile.close();
                            return f4100k - i2;
                        }
                        randomAccessFile.close();
                        return -4;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return -5;
                    }
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    public static synchronized C0932p m12048a() {
        C0932p c0932p;
        synchronized (C0932p.class) {
            if (f4090A == null) {
                f4090A = new C0932p();
            }
            c0932p = f4090A;
        }
        return c0932p;
    }

    /* renamed from: a */
    public static String m12047a(int i) {
        String str;
        ArrayList<String> arrayList;
        String str2 = null;
        if (i == 1) {
            str = f4095f;
            arrayList = f4091b;
        } else if (i == 2) {
            str = f4096g;
            arrayList = f4092c;
        } else {
            if (i == 3) {
                str = f4097h;
            } else if (i != 4) {
                return null;
            } else {
                str = f4098i;
            }
            arrayList = f4093d;
        }
        if (arrayList == null) {
            return null;
        }
        if (arrayList.size() <= 0) {
            m12039a(str, arrayList);
        }
        synchronized (C0932p.class) {
            int size = arrayList.size();
            if (size > 0) {
                int i2 = size - 1;
                try {
                    String str3 = arrayList.get(i2);
                    try {
                        arrayList.remove(i2);
                    } catch (Exception unused) {
                    }
                    str2 = str3;
                } catch (Exception unused2) {
                }
            }
        }
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0011, code lost:
        if (r15 != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001c, code lost:
        if (r15 != false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc A[EDGE_INSN: B:49:0x00cc->B:40:0x00cc ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m12045a(int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0932p.m12045a(int, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01a3  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m12041a(com.baidu.location.p082e.C0986a r12, com.baidu.location.p082e.C0997e r13, android.location.Location r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0932p.m12041a(com.baidu.location.e.a, com.baidu.location.e.e, android.location.Location, java.lang.String):void");
    }

    /* renamed from: a */
    public static void m12040a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(C1015f.f4535a);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(32);
            randomAccessFile.writeInt(2048);
            randomAccessFile.writeInt(MetaDo.META_SCALEWINDOWEXT);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private static boolean m12046a(int i, int i2, int i3, int i4, long j) {
        return i >= 0 && i < i3 && i2 >= 0 && i2 <= i3 && i3 >= 0 && i3 <= 1024 && i4 >= 128 && i4 <= 1024;
    }

    /* renamed from: a */
    private static boolean m12044a(Location location) {
        if (location == null) {
            return false;
        }
        Location location2 = f4112w;
        if (location2 == null || f4111v == null) {
            f4112w = location;
            return true;
        }
        double distanceTo = location.distanceTo(location2);
        double d = C1016g.f4554R;
        Double.isNaN(d);
        Double.isNaN(distanceTo);
        Double.isNaN(distanceTo);
        double d2 = C1016g.f4555S;
        Double.isNaN(d2);
        Double.isNaN(distanceTo);
        double d3 = C1016g.f4556T;
        Double.isNaN(d3);
        return ((double) location.distanceTo(f4111v)) > (((d * distanceTo) * distanceTo) + (d2 * distanceTo)) + d3;
    }

    /* renamed from: a */
    private static boolean m12043a(Location location, C0997e c0997e) {
        boolean z = false;
        if (location != null && c0997e != null && c0997e.f4450a != null && !c0997e.f4450a.isEmpty()) {
            if (c0997e.m11656b(f4114y)) {
                return false;
            }
            z = true;
            if (f4113x == null) {
                f4113x = location;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m12042a(Location location, boolean z) {
        return C0991d.m11699a(f4111v, location, z);
    }

    /* renamed from: a */
    public static boolean m12039a(String str, List<String> list) {
        File file = new File(str);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(8L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                byte[] bArr = new byte[f4103n];
                int i = f4101l + 1;
                boolean z = false;
                while (i > 0 && readInt2 > 0) {
                    if (readInt2 < readInt3) {
                        readInt3 = 0;
                    }
                    try {
                        randomAccessFile.seek(((readInt2 - 1) * readInt) + 128);
                        int readInt4 = randomAccessFile.readInt();
                        if (readInt4 > 0 && readInt4 < readInt) {
                            randomAccessFile.read(bArr, 0, readInt4);
                            int i2 = readInt4 - 1;
                            if (bArr[i2] == 0) {
                                list.add(0, new String(bArr, 0, i2));
                                z = true;
                            }
                        }
                        i--;
                        readInt2--;
                    } catch (Exception unused) {
                        return z;
                    }
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeInt(readInt2);
                randomAccessFile.writeInt(readInt3);
                randomAccessFile.close();
                return z;
            } catch (Exception unused2) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m12037b() {
        return m12033d();
    }

    /* renamed from: b */
    public static synchronized void m12036b(String str) {
        ArrayList<String> arrayList;
        synchronized (C0932p.class) {
            if (str.contains("err!")) {
                return;
            }
            int i = C1016g.f4606p;
            if (i == 1) {
                arrayList = f4091b;
            } else if (i == 2) {
                arrayList = f4092c;
            } else if (i != 3) {
                return;
            } else {
                arrayList = f4093d;
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() <= f4102m) {
                arrayList.add(str);
            }
            if (arrayList.size() >= f4102m) {
                m12045a(i, false);
            }
            while (arrayList.size() > f4102m) {
                arrayList.remove(0);
            }
        }
    }

    /* renamed from: c */
    private static void m12034c(String str) {
        m12036b(str);
    }

    /* renamed from: d */
    public static String m12033d() {
        String str = null;
        for (int i = 1; i < 5; i++) {
            str = m12047a(i);
            if (str != null) {
                return str;
            }
        }
        m12038a(f4093d, f4109t);
        if (f4093d.size() > 0) {
            str = f4093d.get(0);
            f4093d.remove(0);
        }
        if (str != null) {
            return str;
        }
        m12038a(f4093d, f4108s);
        if (f4093d.size() > 0) {
            str = f4093d.get(0);
            f4093d.remove(0);
        }
        if (str != null) {
            return str;
        }
        m12038a(f4093d, f4110u);
        if (f4093d.size() > 0) {
            String str2 = f4093d.get(0);
            f4093d.remove(0);
            return str2;
        }
        return str;
    }

    /* renamed from: d */
    private static void m12032d(String str) {
        m12036b(str);
    }

    /* renamed from: e */
    public static void m12031e() {
        f4101l = 0;
        m12045a(1, false);
        m12045a(2, false);
        m12045a(3, false);
        f4101l = 8;
    }

    /* renamed from: e */
    private static void m12030e(String str) {
        m12036b(str);
    }

    /* renamed from: f */
    public static String m12029f() {
        File file = new File(f4096g);
        String str = null;
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20L);
                int readInt = randomAccessFile.readInt();
                if (readInt > 128) {
                    String concat = "&p1=".concat(String.valueOf(readInt));
                    try {
                        randomAccessFile.seek(20L);
                        randomAccessFile.writeInt(0);
                        randomAccessFile.close();
                        return concat;
                    } catch (Exception unused) {
                        str = concat;
                    }
                } else {
                    randomAccessFile.close();
                }
            } catch (Exception unused2) {
            }
        }
        File file2 = new File(f4097h);
        if (file2.exists()) {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                randomAccessFile2.seek(20L);
                int readInt2 = randomAccessFile2.readInt();
                if (readInt2 > 256) {
                    String concat2 = "&p2=".concat(String.valueOf(readInt2));
                    try {
                        randomAccessFile2.seek(20L);
                        randomAccessFile2.writeInt(0);
                        randomAccessFile2.close();
                        return concat2;
                    } catch (Exception unused3) {
                        str = concat2;
                    }
                } else {
                    randomAccessFile2.close();
                }
            } catch (Exception unused4) {
            }
        }
        File file3 = new File(f4098i);
        if (file3.exists()) {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, "rw");
                randomAccessFile3.seek(20L);
                int readInt3 = randomAccessFile3.readInt();
                if (readInt3 > 512) {
                    String concat3 = "&p3=".concat(String.valueOf(readInt3));
                    try {
                        randomAccessFile3.seek(20L);
                        randomAccessFile3.writeInt(0);
                        randomAccessFile3.close();
                        return concat3;
                    } catch (Exception unused5) {
                        str = concat3;
                    }
                } else {
                    randomAccessFile3.close();
                }
            } catch (Exception unused6) {
            }
        }
        return str;
    }

    /* renamed from: c */
    public void m12035c() {
        if (C0998f.m11626j()) {
            this.f4117z.m12028b();
        }
    }
}
