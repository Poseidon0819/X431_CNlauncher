package com.baidu.location.p079b;

import android.content.SharedPreferences;
import com.baidu.location.Jni;
import com.baidu.location.ServiceC1002f;
import com.baidu.location.p084g.AbstractC1011e;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1007c;
import com.baidu.location.p084g.C1015f;
import com.baidu.location.p084g.C1016g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.location.b.d */
/* loaded from: classes.dex */
public class C0941d {

    /* renamed from: i */
    private static C0941d f4154i;

    /* renamed from: k */
    private static final String f4155k = C1015f.f4535a + "/conlts.dat";

    /* renamed from: l */
    private static int f4156l = -1;

    /* renamed from: m */
    private static int f4157m = -1;

    /* renamed from: n */
    private static int f4158n = 0;

    /* renamed from: j */
    private C0942a f4167j = null;

    /* renamed from: a */
    public boolean f4159a = true;

    /* renamed from: b */
    public boolean f4160b = true;

    /* renamed from: c */
    public boolean f4161c = false;

    /* renamed from: d */
    public boolean f4162d = true;

    /* renamed from: e */
    public boolean f4163e = true;

    /* renamed from: f */
    public boolean f4164f = true;

    /* renamed from: g */
    public boolean f4165g = true;

    /* renamed from: h */
    public boolean f4166h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b.d$a */
    /* loaded from: classes.dex */
    public class C0942a extends AbstractC1011e {

        /* renamed from: a */
        String f4168a = null;

        /* renamed from: b */
        boolean f4169b = false;

        /* renamed from: c */
        boolean f4170c = false;

        public C0942a() {
            this.f4525k = new HashMap();
        }

        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        public void mo11391a() {
            Map<String, Object> map;
            String str;
            String str2;
            this.f4522h = C1016g.m11557c();
            this.f4523i = 2;
            String encode = Jni.encode(this.f4168a);
            this.f4168a = null;
            if (this.f4169b) {
                map = this.f4525k;
                str = "qt";
                str2 = "grid";
            } else {
                map = this.f4525k;
                str = "qt";
                str2 = "conf";
            }
            map.put(str, str2);
            this.f4525k.put("req", encode);
        }

        /* renamed from: a */
        public void m11977a(String str, boolean z) {
            if (this.f4170c) {
                return;
            }
            this.f4170c = true;
            this.f4168a = str;
            this.f4169b = z;
            if (z) {
                m11578a(true, "loc.map.baidu.com");
            } else {
                m11575c(C1016g.f4596f);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
        @Override // com.baidu.location.p084g.AbstractC1011e
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void mo11388a(boolean r2) {
            /*
                r1 = this;
                if (r2 == 0) goto L17
                java.lang.String r2 = r1.f4524j
                if (r2 == 0) goto L17
                boolean r2 = r1.f4169b
                if (r2 == 0) goto L12
                com.baidu.location.b.d r2 = com.baidu.location.p079b.C0941d.this
                byte[] r0 = r1.f4527m
                com.baidu.location.p079b.C0941d.m11993a(r2, r0)
                goto L1d
            L12:
                com.baidu.location.b.d r2 = com.baidu.location.p079b.C0941d.this
                java.lang.String r0 = r1.f4524j
                goto L1a
            L17:
                com.baidu.location.b.d r2 = com.baidu.location.p079b.C0941d.this
                r0 = 0
            L1a:
                com.baidu.location.p079b.C0941d.m11994a(r2, r0)
            L1d:
                java.util.Map<java.lang.String, java.lang.Object> r2 = r1.f4525k
                if (r2 == 0) goto L26
                java.util.Map<java.lang.String, java.lang.Object> r2 = r1.f4525k
                r2.clear()
            L26:
                r2 = 0
                r1.f4170c = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p079b.C0941d.C0942a.mo11388a(boolean):void");
        }
    }

    private C0941d() {
    }

    /* renamed from: a */
    public static C0941d m11996a() {
        if (f4154i == null) {
            f4154i = new C0941d();
        }
        return f4154i;
    }

    /* renamed from: a */
    private void m11995a(int i) {
        this.f4159a = (i & 1) == 1;
        this.f4160b = (i & 2) == 2;
        this.f4161c = (i & 4) == 4;
        this.f4162d = (i & 8) == 8;
        this.f4164f = (i & 65536) == 65536;
        this.f4165g = (i & 131072) == 131072;
        if ((i & 16) == 16) {
            this.f4163e = false;
        }
    }

    /* renamed from: a */
    private void m11991a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        boolean z = true;
        try {
            if (jSONObject.has("ipen") && jSONObject.getInt("ipen") == 0) {
                z = false;
            }
            int i = jSONObject.has("ipvt") ? jSONObject.getInt("ipvt") : 14400000;
            int i2 = jSONObject.has("ipvn") ? jSONObject.getInt("ipvn") : 10;
            SharedPreferences.Editor edit = ServiceC1002f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0).edit();
            edit.putBoolean("ipLocInfoUpload", z);
            edit.putInt("ipValidTime", i);
            edit.putInt("ipLocInfoUploadTimesPerDay", i2);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11990a(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            try {
                if (bArr.length < 640) {
                    C1016g.f4613w = false;
                    C1016g.f4610t = C1016g.f4608r + 0.025d;
                    C1016g.f4609s = C1016g.f4607q - 0.025d;
                } else {
                    C1016g.f4613w = true;
                    C1016g.f4609s = Double.longBitsToDouble(((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[0] & 255));
                    C1016g.f4610t = Double.longBitsToDouble(((bArr[15] & 255) << 56) | ((bArr[14] & 255) << 48) | ((bArr[13] & 255) << 40) | ((bArr[12] & 255) << 32) | ((bArr[11] & 255) << 24) | ((bArr[10] & 255) << 16) | ((bArr[9] & 255) << 8) | (255 & bArr[8]));
                    C1016g.f4612v = new byte[625];
                    while (i < 625) {
                        C1016g.f4612v[i] = bArr[i + 16];
                        i++;
                    }
                }
                i = 1;
            } catch (Exception unused) {
                return;
            }
        }
        if (i != 0) {
            m11981g();
        }
    }

    /* renamed from: b */
    private void m11988b(int i) {
        File file = new File(f4155k);
        if (!file.exists()) {
            m11979i();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4L);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.seek((readInt * f4158n) + 128);
            byte[] bytes = (C1006b.f4490d + (char) 0).getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(i);
            if (readInt2 == f4158n) {
                randomAccessFile.seek(8L);
                randomAccessFile.writeInt(readInt2 + 1);
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private boolean m11987b(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ipconf")) {
                    try {
                        m11991a(jSONObject.getJSONObject("ipconf"));
                    } catch (Exception unused) {
                    }
                }
                int parseInt = Integer.parseInt(jSONObject.getString("ver"));
                if (parseInt > C1016g.f4614x) {
                    C1016g.f4614x = parseInt;
                    if (jSONObject.has("gps")) {
                        String[] split = jSONObject.getString("gps").split("\\|");
                        if (split.length > 10) {
                            if (split[0] != null && !split[0].equals("")) {
                                C1016g.f4615y = Float.parseFloat(split[0]);
                            }
                            if (split[1] != null && !split[1].equals("")) {
                                C1016g.f4616z = Float.parseFloat(split[1]);
                            }
                            if (split[2] != null && !split[2].equals("")) {
                                C1016g.f4537A = Float.parseFloat(split[2]);
                            }
                            if (split[3] != null && !split[3].equals("")) {
                                C1016g.f4538B = Float.parseFloat(split[3]);
                            }
                            if (split[4] != null && !split[4].equals("")) {
                                C1016g.f4539C = Integer.parseInt(split[4]);
                            }
                            if (split[5] != null && !split[5].equals("")) {
                                C1016g.f4540D = Integer.parseInt(split[5]);
                            }
                            if (split[6] != null && !split[6].equals("")) {
                                C1016g.f4541E = Integer.parseInt(split[6]);
                            }
                            if (split[7] != null && !split[7].equals("")) {
                                C1016g.f4542F = Integer.parseInt(split[7]);
                            }
                            if (split[8] != null && !split[8].equals("")) {
                                C1016g.f4543G = Integer.parseInt(split[8]);
                            }
                            if (split[9] != null && !split[9].equals("")) {
                                C1016g.f4544H = Integer.parseInt(split[9]);
                            }
                            if (split[10] != null && !split[10].equals("")) {
                                C1016g.f4545I = Integer.parseInt(split[10]);
                            }
                        }
                    }
                    if (jSONObject.has("up")) {
                        String[] split2 = jSONObject.getString("up").split("\\|");
                        if (split2.length > 3) {
                            if (split2[0] != null && !split2[0].equals("")) {
                                C1016g.f4546J = Float.parseFloat(split2[0]);
                            }
                            if (split2[1] != null && !split2[1].equals("")) {
                                C1016g.f4547K = Float.parseFloat(split2[1]);
                            }
                            if (split2[2] != null && !split2[2].equals("")) {
                                C1016g.f4548L = Float.parseFloat(split2[2]);
                            }
                            if (split2[3] != null && !split2[3].equals("")) {
                                C1016g.f4549M = Float.parseFloat(split2[3]);
                            }
                        }
                    }
                    if (jSONObject.has("wf")) {
                        String[] split3 = jSONObject.getString("wf").split("\\|");
                        if (split3.length > 3) {
                            if (split3[0] != null && !split3[0].equals("")) {
                                C1016g.f4550N = Integer.parseInt(split3[0]);
                            }
                            if (split3[1] != null && !split3[1].equals("")) {
                                C1016g.f4551O = Float.parseFloat(split3[1]);
                            }
                            if (split3[2] != null && !split3[2].equals("")) {
                                C1016g.f4552P = Integer.parseInt(split3[2]);
                            }
                            if (split3[3] != null && !split3[3].equals("")) {
                                C1016g.f4553Q = Float.parseFloat(split3[3]);
                            }
                        }
                    }
                    if (jSONObject.has("ab")) {
                        String[] split4 = jSONObject.getString("ab").split("\\|");
                        if (split4.length > 3) {
                            if (split4[0] != null && !split4[0].equals("")) {
                                C1016g.f4554R = Float.parseFloat(split4[0]);
                            }
                            if (split4[1] != null && !split4[1].equals("")) {
                                C1016g.f4555S = Float.parseFloat(split4[1]);
                            }
                            if (split4[2] != null && !split4[2].equals("")) {
                                C1016g.f4556T = Integer.parseInt(split4[2]);
                            }
                            if (split4[3] != null && !split4[3].equals("")) {
                                C1016g.f4557U = Integer.parseInt(split4[3]);
                            }
                        }
                    }
                    if (jSONObject.has("zxd")) {
                        String[] split5 = jSONObject.getString("zxd").split("\\|");
                        if (split5.length > 4) {
                            if (split5[0] != null && !split5[0].equals("")) {
                                C1016g.f4582aq = Float.parseFloat(split5[0]);
                            }
                            if (split5[1] != null && !split5[1].equals("")) {
                                C1016g.f4583ar = Float.parseFloat(split5[1]);
                            }
                            if (split5[2] != null && !split5[2].equals("")) {
                                C1016g.f4584as = Integer.parseInt(split5[2]);
                            }
                            if (split5[3] != null && !split5[3].equals("")) {
                                C1016g.f4585at = Integer.parseInt(split5[3]);
                            }
                            if (split5[4] != null && !split5[4].equals("")) {
                                C1016g.f4586au = Integer.parseInt(split5[4]);
                            }
                        }
                    }
                    if (jSONObject.has("gpc")) {
                        String[] split6 = jSONObject.getString("gpc").split("\\|");
                        if (split6.length > 5) {
                            if (split6[0] != null && !split6[0].equals("")) {
                                if (Integer.parseInt(split6[0]) > 0) {
                                    C1016g.f4562Z = true;
                                } else {
                                    C1016g.f4562Z = false;
                                }
                            }
                            if (split6[1] != null && !split6[1].equals("")) {
                                if (Integer.parseInt(split6[1]) > 0) {
                                    C1016g.f4566aa = true;
                                } else {
                                    C1016g.f4566aa = false;
                                }
                            }
                            if (split6[2] != null && !split6[2].equals("")) {
                                C1016g.f4567ab = Integer.parseInt(split6[2]);
                            }
                            if (split6[3] != null && !split6[3].equals("")) {
                                C1016g.f4569ad = Integer.parseInt(split6[3]);
                            }
                            if (split6[4] != null && !split6[4].equals("")) {
                                int parseInt2 = Integer.parseInt(split6[4]);
                                if (parseInt2 > 0) {
                                    long j = parseInt2;
                                    C1016g.f4575aj = j;
                                    long j2 = j * 1000 * 60;
                                    C1016g.f4571af = j2;
                                    C1016g.f4576ak = j2 >> 2;
                                } else {
                                    C1016g.f4605o = false;
                                }
                            }
                            if (split6[5] != null && !split6[5].equals("")) {
                                C1016g.f4578am = Integer.parseInt(split6[5]);
                            }
                        }
                    }
                    if (jSONObject.has("shak")) {
                        String[] split7 = jSONObject.getString("shak").split("\\|");
                        if (split7.length > 2) {
                            if (split7[0] != null && !split7[0].equals("")) {
                                C1016g.f4579an = Integer.parseInt(split7[0]);
                            }
                            if (split7[1] != null && !split7[1].equals("")) {
                                C1016g.f4580ao = Integer.parseInt(split7[1]);
                            }
                            if (split7[2] != null && !split7[2].equals("")) {
                                C1016g.f4581ap = Float.parseFloat(split7[2]);
                            }
                        }
                    }
                    if (jSONObject.has("dmx")) {
                        C1016g.f4577al = jSONObject.getInt("dmx");
                    }
                    return true;
                }
                return false;
            } catch (Exception unused2) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m11985c(String str) {
        int i;
        f4157m = -1;
        if (str != null) {
            try {
                if (m11987b(str)) {
                    m11982f();
                }
            } catch (Exception unused) {
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ctr")) {
                    f4157m = Integer.parseInt(jSONObject.getString("ctr"));
                }
            } catch (Exception unused2) {
            }
            try {
                m11978j();
                if (f4157m != -1) {
                    i = f4157m;
                    m11988b(f4157m);
                } else {
                    i = f4156l != -1 ? f4156l : -1;
                }
                if (i != -1) {
                    m11995a(i);
                }
            } catch (Exception unused3) {
            }
        }
    }

    /* renamed from: e */
    private void m11983e() {
        String str = "&ver=" + C1016g.f4614x + "&usr=" + C1006b.m11603a().m11598b() + "&app=" + C1006b.f4490d + "&prod=" + C1006b.f4491e;
        if (this.f4167j == null) {
            this.f4167j = new C0942a();
        }
        this.f4167j.m11977a(str, false);
    }

    /* renamed from: f */
    private void m11982f() {
        String str = C1015f.f4535a + "/config.dat";
        byte[] bytes = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", Integer.valueOf(C1016g.f4614x), Float.valueOf(C1016g.f4615y), Float.valueOf(C1016g.f4616z), Float.valueOf(C1016g.f4537A), Float.valueOf(C1016g.f4538B), Integer.valueOf(C1016g.f4539C), Integer.valueOf(C1016g.f4540D), Integer.valueOf(C1016g.f4541E), Integer.valueOf(C1016g.f4542F), Integer.valueOf(C1016g.f4543G), Integer.valueOf(C1016g.f4544H), Integer.valueOf(C1016g.f4545I), Float.valueOf(C1016g.f4546J), Float.valueOf(C1016g.f4547K), Float.valueOf(C1016g.f4548L), Float.valueOf(C1016g.f4549M), Integer.valueOf(C1016g.f4550N), Float.valueOf(C1016g.f4551O), Integer.valueOf(C1016g.f4552P), Float.valueOf(C1016g.f4553Q), Float.valueOf(C1016g.f4554R), Float.valueOf(C1016g.f4555S), Integer.valueOf(C1016g.f4556T), Integer.valueOf(C1016g.f4557U), Integer.valueOf(C1016g.f4562Z ? 1 : 0), Integer.valueOf(C1016g.f4566aa ? 1 : 0), Integer.valueOf(C1016g.f4567ab), Integer.valueOf(C1016g.f4569ad), Long.valueOf(C1016g.f4575aj), Integer.valueOf(C1016g.f4578am), Float.valueOf(C1016g.f4582aq), Float.valueOf(C1016g.f4583ar), Integer.valueOf(C1016g.f4584as), Integer.valueOf(C1016g.f4585at), Integer.valueOf(C1016g.f4586au), Integer.valueOf(C1016g.f4579an), Integer.valueOf(C1016g.f4580ao), Float.valueOf(C1016g.f4581ap), Integer.valueOf(C1016g.f4577al)).getBytes();
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(C1015f.f4535a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(0L);
            randomAccessFile2.writeBoolean(true);
            randomAccessFile2.seek(2L);
            randomAccessFile2.writeInt(bytes.length);
            randomAccessFile2.write(bytes);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: g */
    private void m11981g() {
        try {
            File file = new File(C1015f.f4535a + "/config.dat");
            if (!file.exists()) {
                File file2 = new File(C1015f.f4535a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(1L);
            randomAccessFile2.writeBoolean(true);
            randomAccessFile2.seek(1024L);
            randomAccessFile2.writeDouble(C1016g.f4609s);
            randomAccessFile2.writeDouble(C1016g.f4610t);
            randomAccessFile2.writeBoolean(C1016g.f4613w);
            if (C1016g.f4613w && C1016g.f4612v != null) {
                randomAccessFile2.write(C1016g.f4612v);
            }
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: h */
    private void m11980h() {
        try {
            File file = new File(C1015f.f4535a + "/config.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2L);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    m11987b(new String(bArr));
                }
                randomAccessFile.seek(1L);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(1024L);
                    C1016g.f4609s = randomAccessFile.readDouble();
                    C1016g.f4610t = randomAccessFile.readDouble();
                    boolean readBoolean = randomAccessFile.readBoolean();
                    C1016g.f4613w = readBoolean;
                    if (readBoolean) {
                        C1016g.f4612v = new byte[625];
                        randomAccessFile.read(C1016g.f4612v, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
        if (C1016g.f4605o) {
            boolean z = ServiceC1002f.isServing;
        }
    }

    /* renamed from: i */
    private void m11979i() {
        try {
            File file = new File(f4155k);
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
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(128);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: j */
    private void m11978j() {
        try {
            File file = new File(f4155k);
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4L);
                int readInt = randomAccessFile.readInt();
                if (readInt > 3000) {
                    randomAccessFile.close();
                    f4158n = 0;
                    m11979i();
                    return;
                }
                int readInt2 = randomAccessFile.readInt();
                randomAccessFile.seek(128L);
                byte[] bArr = new byte[readInt];
                int i = 0;
                while (true) {
                    if (i >= readInt2) {
                        break;
                    }
                    randomAccessFile.seek((readInt * i) + 128);
                    int readInt3 = randomAccessFile.readInt();
                    if (readInt3 > 0 && readInt3 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt3);
                        int i2 = readInt3 - 1;
                        if (bArr[i2] == 0) {
                            String str = new String(bArr, 0, i2);
                            C1006b.m11603a();
                            if (str.equals(C1006b.f4490d)) {
                                f4156l = randomAccessFile.readInt();
                                f4158n = i;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (i == readInt2) {
                    f4158n = readInt2;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void m11992a(String str) {
        if (this.f4167j == null) {
            this.f4167j = new C0942a();
        }
        this.f4167j.m11977a(str, true);
    }

    /* renamed from: b */
    public void m11989b() {
        m11980h();
    }

    /* renamed from: c */
    public void m11986c() {
    }

    /* renamed from: d */
    public void m11984d() {
        if (System.currentTimeMillis() - C1007c.m11594a().m11586d() > 86400000) {
            C1007c.m11594a().m11587c(System.currentTimeMillis());
            m11983e();
        }
    }
}
