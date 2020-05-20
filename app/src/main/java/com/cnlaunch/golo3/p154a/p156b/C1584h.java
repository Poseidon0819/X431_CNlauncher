package com.cnlaunch.golo3.p154a.p156b;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.Adler32;

/* compiled from: DiskCache.java */
/* renamed from: com.cnlaunch.golo3.a.b.h */
/* loaded from: classes.dex */
public class C1584h implements Closeable {

    /* renamed from: h */
    private static final String f7755h = "h";

    /* renamed from: a */
    int f7756a;

    /* renamed from: b */
    int f7757b;

    /* renamed from: c */
    int f7758c;

    /* renamed from: d */
    int f7759d;

    /* renamed from: e */
    int f7760e;

    /* renamed from: f */
    int f7761f;

    /* renamed from: g */
    byte[] f7762g;

    /* renamed from: i */
    private RandomAccessFile f7763i;

    /* renamed from: j */
    private RandomAccessFile f7764j;

    /* renamed from: k */
    private RandomAccessFile f7765k;

    /* renamed from: l */
    private FileChannel f7766l;

    /* renamed from: m */
    private MappedByteBuffer f7767m;

    /* renamed from: n */
    private int f7768n;

    /* renamed from: o */
    private RandomAccessFile f7769o;

    /* renamed from: p */
    private RandomAccessFile f7770p;

    /* renamed from: q */
    private int f7771q;

    /* renamed from: r */
    private byte[] f7772r;

    /* renamed from: s */
    private Adler32 f7773s;

    /* renamed from: t */
    private String f7774t;

    /* renamed from: u */
    private C1585a f7775u;

    /* renamed from: v */
    private int f7776v;

    /* renamed from: w */
    private int f7777w;

    /* compiled from: DiskCache.java */
    /* renamed from: com.cnlaunch.golo3.a.b.h$a */
    /* loaded from: classes.dex */
    public static class C1585a {

        /* renamed from: a */
        public long f7778a;

        /* renamed from: b */
        public byte[] f7779b;

        /* renamed from: c */
        public int f7780c;
    }

    public C1584h(String str, int i, int i2) throws IOException {
        this(str, i, i2, (byte) 0);
    }

    private C1584h(String str, int i, int i2, byte b) throws IOException {
        this.f7762g = new byte[32];
        this.f7772r = new byte[20];
        this.f7773s = new Adler32();
        this.f7775u = new C1585a();
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("unable to make dirs");
        }
        this.f7774t = str;
        this.f7763i = new RandomAccessFile(str + ".idx", "rw");
        this.f7764j = new RandomAccessFile(str + ".0", "rw");
        this.f7765k = new RandomAccessFile(str + ".1", "rw");
        this.f7768n = 0;
        if (m9203f()) {
            return;
        }
        this.f7763i.setLength(0L);
        this.f7763i.setLength((i * 12 * 2) + 32);
        this.f7763i.seek(0L);
        byte[] bArr = this.f7762g;
        m9210a(bArr, 0, -1289277392);
        m9210a(bArr, 4, i);
        m9210a(bArr, 8, i2);
        m9210a(bArr, 12, 0);
        m9210a(bArr, 16, 0);
        m9210a(bArr, 20, 4);
        m9210a(bArr, 24, this.f7768n);
        m9210a(bArr, 28, m9211a(bArr, 28));
        this.f7763i.write(bArr);
        this.f7764j.setLength(0L);
        this.f7765k.setLength(0L);
        this.f7764j.seek(0L);
        this.f7765k.seek(0L);
        m9210a(bArr, 0, -1121680112);
        this.f7764j.write(bArr, 0, 4);
        this.f7765k.write(bArr, 0, 4);
        if (m9203f()) {
            return;
        }
        m9204e();
        throw new IOException("unable to load index");
    }

    /* renamed from: a */
    public final void m9220a() {
        m9213a(this.f7774t + ".idx");
        m9213a(this.f7774t + ".0");
        m9213a(this.f7774t + ".1");
    }

    /* renamed from: a */
    private static void m9213a(String str) {
        try {
            new File(str).delete();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private void m9204e() {
        m9215a(this.f7766l);
        m9215a(this.f7763i);
        m9215a(this.f7764j);
        m9215a(this.f7765k);
    }

    /* renamed from: f */
    private boolean m9203f() {
        try {
            this.f7763i.seek(0L);
            this.f7764j.seek(0L);
            this.f7765k.seek(0L);
            byte[] bArr = this.f7762g;
            if (this.f7763i.read(bArr) != 32) {
                Log.w(f7755h, "cannot read header");
                return false;
            } else if (m9207b(bArr, 0) != -1289277392) {
                Log.w(f7755h, "cannot read header magic");
                return false;
            } else if (m9207b(bArr, 24) != this.f7768n) {
                Log.w(f7755h, "version mismatch");
                return false;
            } else {
                this.f7756a = m9207b(bArr, 4);
                this.f7757b = m9207b(bArr, 8);
                this.f7758c = m9207b(bArr, 12);
                this.f7759d = m9207b(bArr, 16);
                this.f7760e = m9207b(bArr, 20);
                if (m9211a(bArr, 28) != m9207b(bArr, 28)) {
                    Log.w(f7755h, "header checksum does not match");
                    return false;
                } else if (this.f7756a <= 0) {
                    Log.w(f7755h, "invalid max entries");
                    return false;
                } else if (this.f7757b <= 0) {
                    Log.w(f7755h, "invalid max bytes");
                    return false;
                } else if (this.f7758c != 0 && this.f7758c != 1) {
                    Log.w(f7755h, "invalid active region");
                    return false;
                } else {
                    if (this.f7759d >= 0 && this.f7759d <= this.f7756a) {
                        if (this.f7760e >= 4 && this.f7760e <= this.f7757b) {
                            if (this.f7763i.length() != (this.f7756a * 12 * 2) + 32) {
                                Log.w(f7755h, "invalid index file length");
                                return false;
                            }
                            byte[] bArr2 = new byte[4];
                            if (this.f7764j.read(bArr2) != 4) {
                                Log.w(f7755h, "cannot read data file magic");
                                return false;
                            } else if (m9207b(bArr2, 0) != -1121680112) {
                                Log.w(f7755h, "invalid data file magic");
                                return false;
                            } else if (this.f7765k.read(bArr2) != 4) {
                                Log.w(f7755h, "cannot read data file magic");
                                return false;
                            } else if (m9207b(bArr2, 0) != -1121680112) {
                                Log.w(f7755h, "invalid data file magic");
                                return false;
                            } else {
                                this.f7766l = this.f7763i.getChannel();
                                this.f7767m = this.f7766l.map(FileChannel.MapMode.READ_WRITE, 0L, this.f7763i.length());
                                this.f7767m.order(ByteOrder.LITTLE_ENDIAN);
                                m9208b();
                                return true;
                            }
                        }
                        Log.w(f7755h, "invalid active bytes");
                        return false;
                    }
                    Log.w(f7755h, "invalid active entries");
                    return false;
                }
            }
        } catch (IOException e) {
            Log.e(f7755h, "loadIndex failed.", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m9208b() throws IOException {
        this.f7769o = this.f7758c == 0 ? this.f7764j : this.f7765k;
        this.f7770p = this.f7758c == 1 ? this.f7764j : this.f7765k;
        this.f7769o.setLength(this.f7760e);
        this.f7769o.seek(this.f7760e);
        this.f7761f = 32;
        this.f7771q = 32;
        if (this.f7758c == 0) {
            this.f7771q += this.f7756a * 12;
        } else {
            this.f7761f += this.f7756a * 12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m9206c() {
        byte[] bArr = this.f7762g;
        m9210a(bArr, 28, m9211a(bArr, 28));
        this.f7767m.position(0);
        this.f7767m.put(this.f7762g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m9219a(int i) {
        byte[] bArr = new byte[1024];
        this.f7767m.position(i);
        int i2 = this.f7756a * 12;
        while (i2 > 0) {
            int min = Math.min(i2, 1024);
            this.f7767m.put(bArr, 0, min);
            i2 -= min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m9217a(long j, byte[] bArr, int i) throws IOException {
        byte[] bArr2 = this.f7772r;
        int m9212a = m9212a(bArr);
        m9209a(bArr2, j);
        m9210a(bArr2, 8, m9212a);
        m9210a(bArr2, 12, this.f7760e);
        m9210a(bArr2, 16, i);
        this.f7769o.write(bArr2);
        this.f7769o.write(bArr, 0, i);
        this.f7767m.putLong(this.f7776v, j);
        this.f7767m.putInt(this.f7776v + 8, this.f7760e);
        this.f7760e += i + 20;
        m9210a(this.f7762g, 20, this.f7760e);
    }

    /* renamed from: a */
    public final boolean m9216a(C1585a c1585a) throws IOException {
        if (m9218a(c1585a.f7778a, this.f7761f) && m9214a(this.f7769o, this.f7777w, c1585a)) {
            return true;
        }
        int i = this.f7776v;
        if (m9218a(c1585a.f7778a, this.f7771q) && m9214a(this.f7770p, this.f7777w, c1585a)) {
            if (this.f7760e + 20 + c1585a.f7780c > this.f7757b || this.f7759d * 2 >= this.f7756a) {
                return true;
            }
            this.f7776v = i;
            try {
                m9217a(c1585a.f7778a, c1585a.f7779b, c1585a.f7780c);
                this.f7759d++;
                m9210a(this.f7762g, 16, this.f7759d);
                m9206c();
            } catch (Throwable unused) {
                Log.e(f7755h, "cannot copy over");
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m9214a(RandomAccessFile randomAccessFile, int i, C1585a c1585a) throws IOException {
        byte[] bArr = this.f7772r;
        long filePointer = randomAccessFile.getFilePointer();
        try {
            randomAccessFile.seek(i);
            if (randomAccessFile.read(bArr) != 20) {
                Log.w(f7755h, "cannot read blob header");
                return false;
            }
            long j = bArr[7] & 255;
            for (int i2 = 6; i2 >= 0; i2--) {
                j = (j << 8) | (bArr[i2 + 0] & 255);
            }
            if (j != c1585a.f7778a) {
                Log.w(f7755h, "blob key does not match: ".concat(String.valueOf(j)));
                return false;
            }
            int m9207b = m9207b(bArr, 8);
            int m9207b2 = m9207b(bArr, 12);
            if (m9207b2 != i) {
                Log.w(f7755h, "blob offset does not match: ".concat(String.valueOf(m9207b2)));
                return false;
            }
            int m9207b3 = m9207b(bArr, 16);
            if (m9207b3 >= 0 && m9207b3 <= (this.f7757b - i) - 20) {
                if (c1585a.f7779b == null || c1585a.f7779b.length < m9207b3) {
                    c1585a.f7779b = new byte[m9207b3];
                }
                byte[] bArr2 = c1585a.f7779b;
                c1585a.f7780c = m9207b3;
                if (randomAccessFile.read(bArr2, 0, m9207b3) != m9207b3) {
                    Log.w(f7755h, "cannot read blob data");
                    return false;
                } else if (m9211a(bArr2, m9207b3) != m9207b) {
                    Log.w(f7755h, "blob checksum does not match: ".concat(String.valueOf(m9207b)));
                    return false;
                } else {
                    randomAccessFile.seek(filePointer);
                    return true;
                }
            }
            Log.w(f7755h, "invalid blob length: ".concat(String.valueOf(m9207b3)));
            return false;
        } catch (Throwable th) {
            try {
                Log.e(f7755h, "getBlob failed.", th);
                return false;
            } finally {
                randomAccessFile.seek(filePointer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean m9218a(long j, int i) {
        int i2 = this.f7756a;
        int i3 = (int) (j % i2);
        if (i3 < 0) {
            i3 += i2;
        }
        int i4 = i3;
        while (true) {
            int i5 = (i4 * 12) + i;
            long j2 = this.f7767m.getLong(i5);
            int i6 = this.f7767m.getInt(i5 + 8);
            if (i6 == 0) {
                this.f7776v = i5;
                return false;
            } else if (j2 == j) {
                this.f7776v = i5;
                this.f7777w = i6;
                return true;
            } else {
                i4++;
                if (i4 >= this.f7756a) {
                    i4 = 0;
                }
                if (i4 == i3) {
                    Log.w(f7755h, "corrupted index: clear the slot.");
                    this.f7767m.putInt((i4 * 12) + i + 8, 0);
                }
            }
        }
    }

    /* renamed from: d */
    public final void m9205d() {
        try {
            this.f7767m.force();
        } catch (Throwable th) {
            Log.w(f7755h, "sync index failed", th);
        }
    }

    /* renamed from: a */
    private int m9212a(byte[] bArr) {
        this.f7773s.reset();
        this.f7773s.update(bArr);
        return (int) this.f7773s.getValue();
    }

    /* renamed from: a */
    private int m9211a(byte[] bArr, int i) {
        this.f7773s.reset();
        this.f7773s.update(bArr, 0, i);
        return (int) this.f7773s.getValue();
    }

    /* renamed from: a */
    private static void m9215a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static int m9207b(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m9210a(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i + i3] = (byte) (i2 & 255);
            i2 >>= 8;
        }
    }

    /* renamed from: a */
    private static void m9209a(byte[] bArr, long j) {
        for (int i = 0; i < 8; i++) {
            bArr[i + 0] = (byte) (255 & j);
            j >>= 8;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m9205d();
        try {
            this.f7764j.getFD().sync();
        } catch (Throwable th) {
            Log.w(f7755h, "sync data file 0 failed", th);
        }
        try {
            this.f7765k.getFD().sync();
        } catch (Throwable th2) {
            Log.w(f7755h, "sync data file 1 failed", th2);
        }
        m9204e();
    }
}
