package com.baidu.location.p084g;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.baidu.location.g.c */
/* loaded from: classes.dex */
public class C1007c {

    /* renamed from: c */
    static C1007c f4499c;

    /* renamed from: a */
    String f4500a = "firll.dat";

    /* renamed from: b */
    int f4501b = 3164;

    /* renamed from: d */
    int f4502d = 0;

    /* renamed from: e */
    int f4503e = 20;

    /* renamed from: f */
    int f4504f = 40;

    /* renamed from: g */
    int f4505g = 60;

    /* renamed from: h */
    int f4506h = 80;

    /* renamed from: i */
    int f4507i = 100;

    /* renamed from: a */
    private long m11593a(int i) {
        RandomAccessFile randomAccessFile;
        int readInt;
        long readLong;
        String m11549h = C1016g.m11549h();
        if (m11549h == null) {
            return -1L;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(m11549h + File.separator + this.f4500a, "rw");
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
            }
            try {
                randomAccessFile.seek(i);
                readInt = randomAccessFile.readInt();
                readLong = randomAccessFile.readLong();
            } catch (Exception unused2) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                return -1L;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        if (readInt == randomAccessFile.readInt()) {
            try {
                randomAccessFile.close();
            } catch (IOException unused5) {
            }
            return readLong;
        }
        randomAccessFile.close();
        return -1L;
    }

    /* renamed from: a */
    public static C1007c m11594a() {
        if (f4499c == null) {
            f4499c = new C1007c();
        }
        return f4499c;
    }

    /* renamed from: a */
    private void m11592a(int i, long j) {
        String m11549h = C1016g.m11549h();
        if (m11549h == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(m11549h + File.separator + this.f4500a, "rw");
            randomAccessFile.seek(i);
            randomAccessFile.writeInt(this.f4501b);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.f4501b);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void m11591a(long j) {
        m11592a(this.f4502d, j);
    }

    /* renamed from: b */
    public long m11590b() {
        return m11593a(this.f4502d);
    }

    /* renamed from: b */
    public void m11589b(long j) {
        m11592a(this.f4503e, j);
    }

    /* renamed from: c */
    public long m11588c() {
        return m11593a(this.f4503e);
    }

    /* renamed from: c */
    public void m11587c(long j) {
        m11592a(this.f4505g, j);
    }

    /* renamed from: d */
    public long m11586d() {
        return m11593a(this.f4505g);
    }
}
