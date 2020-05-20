package com.baidu.location.p078a;

import android.location.Location;
import com.baidu.location.Jni;
import com.baidu.location.p084g.C1006b;
import com.baidu.location.p084g.C1015f;
import com.baidu.location.p084g.C1016g;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.baidu.location.a.e */
/* loaded from: classes.dex */
public class C0904e {

    /* renamed from: a */
    private static C0904e f3950a = null;

    /* renamed from: b */
    private static String f3951b = "Temp_in.dat";

    /* renamed from: c */
    private static File f3952c = new File(C1015f.f4535a, f3951b);

    /* renamed from: d */
    private static StringBuffer f3953d = null;

    /* renamed from: e */
    private static boolean f3954e = true;

    /* renamed from: f */
    private static int f3955f = 0;

    /* renamed from: g */
    private static int f3956g = 0;

    /* renamed from: h */
    private static long f3957h = 0;

    /* renamed from: i */
    private static long f3958i = 0;

    /* renamed from: j */
    private static long f3959j = 0;

    /* renamed from: k */
    private static double f3960k = 0.0d;

    /* renamed from: l */
    private static double f3961l = 0.0d;

    /* renamed from: m */
    private static int f3962m = 0;

    /* renamed from: n */
    private static int f3963n = 0;

    /* renamed from: o */
    private static int f3964o = 0;

    /* renamed from: p */
    private String f3965p;

    /* renamed from: q */
    private boolean f3966q = true;

    private C0904e(String str) {
        this.f3965p = null;
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.f3965p = str;
    }

    /* renamed from: a */
    public static C0904e m12178a() {
        if (f3950a == null) {
            f3950a = new C0904e(C1006b.m11603a().m11596d());
        }
        return f3950a;
    }

    /* renamed from: a */
    private String m12177a(int i) {
        RandomAccessFile randomAccessFile;
        int readInt;
        if (f3952c.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(f3952c, "rw");
                randomAccessFile.seek(0L);
                readInt = randomAccessFile.readInt();
            } catch (IOException unused) {
            }
            if (!m12176a(readInt, randomAccessFile.readInt(), randomAccessFile.readInt())) {
                randomAccessFile.close();
                m12170d();
                return null;
            }
            if (i != 0 && i != readInt + 1) {
                long j = ((i - 1) * 1024) + 12;
                randomAccessFile.seek(j);
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.seek(j + 4);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    bArr[i2] = randomAccessFile.readByte();
                }
                randomAccessFile.close();
                return new String(bArr);
            }
            randomAccessFile.close();
            return null;
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m12176a(int i, int i2, int i3) {
        int i4;
        return i >= 0 && i <= C1016g.f4569ad && i2 >= 0 && i2 <= (i4 = i + 1) && i3 > 0 && i3 <= i4 && i3 <= C1016g.f4569ad;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (com.baidu.location.p084g.C1016g.f4568ac > 3600) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m12174a(android.location.Location r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0904e.m12174a(android.location.Location, int, int):boolean");
    }

    /* renamed from: a */
    private boolean m12173a(String str) {
        if (str != null && str.startsWith("&nr")) {
            if (!f3952c.exists() && !m12170d()) {
                return false;
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(f3952c, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                if (!m12176a(readInt, readInt2, readInt3)) {
                    randomAccessFile.close();
                    m12170d();
                    return false;
                }
                if (C1016g.f4566aa) {
                    if (readInt == C1016g.f4569ad) {
                        if (str.equals(m12177a(readInt3 == 1 ? C1016g.f4569ad : readInt3 - 1))) {
                            randomAccessFile.close();
                            return false;
                        }
                    } else if (readInt3 > 1 && str.equals(m12177a(readInt3 - 1))) {
                        randomAccessFile.close();
                        return false;
                    }
                }
                randomAccessFile.seek(((readInt3 - 1) * 1024) + 12 + 0);
                if (str.length() > 750) {
                    randomAccessFile.close();
                    return false;
                }
                String encode = Jni.encode(str);
                int length = encode.length();
                if (length > 1020) {
                    randomAccessFile.close();
                    return false;
                }
                randomAccessFile.writeInt(length);
                randomAccessFile.writeBytes(encode);
                int i = 2;
                if (readInt != 0) {
                    if (readInt < C1016g.f4569ad - 1) {
                        randomAccessFile.seek(0L);
                        randomAccessFile.writeInt(readInt + 1);
                        randomAccessFile.seek(8L);
                        randomAccessFile.writeInt(readInt + 2);
                    } else if (readInt == C1016g.f4569ad - 1) {
                        randomAccessFile.seek(0L);
                        randomAccessFile.writeInt(C1016g.f4569ad);
                        if (readInt2 == 0 || readInt2 == 1) {
                            randomAccessFile.writeInt(2);
                        }
                        randomAccessFile.seek(8L);
                        randomAccessFile.writeInt(1);
                    } else if (readInt3 == readInt2) {
                        i = readInt3 == C1016g.f4569ad ? 1 : readInt3 + 1;
                        int i2 = i == C1016g.f4569ad ? 1 : i + 1;
                        randomAccessFile.seek(4L);
                        randomAccessFile.writeInt(i2);
                    } else {
                        i = readInt3 == C1016g.f4569ad ? 1 : readInt3 + 1;
                        if (i == readInt2) {
                            int i3 = i == C1016g.f4569ad ? 1 : i + 1;
                            randomAccessFile.seek(4L);
                            randomAccessFile.writeInt(i3);
                        }
                        randomAccessFile.seek(8L);
                    }
                    randomAccessFile.close();
                    return true;
                }
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(1);
                randomAccessFile.writeInt(1);
                randomAccessFile.writeInt(i);
                randomAccessFile.close();
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m12172b() {
        RandomAccessFile randomAccessFile;
        int readInt;
        int readInt2;
        int readInt3;
        File file = f3952c;
        if (file != null && file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(f3952c, "rw");
                randomAccessFile.seek(0L);
                readInt = randomAccessFile.readInt();
                readInt2 = randomAccessFile.readInt();
                readInt3 = randomAccessFile.readInt();
            } catch (IOException unused) {
            }
            if (!m12176a(readInt, readInt2, readInt3)) {
                randomAccessFile.close();
                m12170d();
                return null;
            }
            if (readInt2 != 0 && readInt2 != readInt3) {
                long j = ((readInt2 - 1) * 1024) + 12 + 0;
                randomAccessFile.seek(j);
                int readInt4 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt4];
                randomAccessFile.seek(j + 4);
                for (int i = 0; i < readInt4; i++) {
                    bArr[i] = randomAccessFile.readByte();
                }
                String str = new String(bArr);
                int i2 = readInt < C1016g.f4569ad ? readInt2 + 1 : readInt2 == C1016g.f4569ad ? 1 : 1 + readInt2;
                randomAccessFile.seek(4L);
                randomAccessFile.writeInt(i2);
                randomAccessFile.close();
                return str;
            }
            randomAccessFile.close();
            return null;
        }
        return null;
    }

    /* renamed from: c */
    private static void m12171c() {
        f3954e = true;
        f3953d = null;
        f3955f = 0;
        f3956g = 0;
        f3957h = 0L;
        f3958i = 0L;
        f3959j = 0L;
        f3960k = 0.0d;
        f3961l = 0.0d;
        f3962m = 0;
        f3963n = 0;
        f3964o = 0;
    }

    /* renamed from: d */
    private static boolean m12170d() {
        if (f3952c.exists()) {
            f3952c.delete();
        }
        if (!f3952c.getParentFile().exists()) {
            f3952c.getParentFile().mkdirs();
        }
        try {
            f3952c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(f3952c, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            m12171c();
            return f3952c.exists();
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m12175a(Location location) {
        return m12174a(location, C1016g.f4567ab, C1016g.f4568ac);
    }
}
