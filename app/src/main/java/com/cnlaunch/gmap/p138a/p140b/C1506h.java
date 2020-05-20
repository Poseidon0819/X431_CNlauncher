package com.cnlaunch.gmap.p138a.p140b;

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
/* renamed from: com.cnlaunch.gmap.a.b.h */
/* loaded from: classes.dex */
public class C1506h implements Closeable {

    /* renamed from: h */
    private static final String f7413h = "h";

    /* renamed from: a */
    public int f7414a;

    /* renamed from: b */
    public int f7415b;

    /* renamed from: c */
    public int f7416c;

    /* renamed from: d */
    public int f7417d;

    /* renamed from: e */
    public int f7418e;

    /* renamed from: f */
    public int f7419f;

    /* renamed from: g */
    public byte[] f7420g;

    /* renamed from: i */
    private RandomAccessFile f7421i;

    /* renamed from: j */
    private RandomAccessFile f7422j;

    /* renamed from: k */
    private RandomAccessFile f7423k;

    /* renamed from: l */
    private FileChannel f7424l;

    /* renamed from: m */
    private MappedByteBuffer f7425m;

    /* renamed from: n */
    private int f7426n;

    /* renamed from: o */
    private RandomAccessFile f7427o;

    /* renamed from: p */
    private RandomAccessFile f7428p;

    /* renamed from: q */
    private int f7429q;

    /* renamed from: r */
    private byte[] f7430r;

    /* renamed from: s */
    private Adler32 f7431s;

    /* renamed from: t */
    private String f7432t;

    /* renamed from: u */
    private C1507a f7433u;

    /* renamed from: v */
    private int f7434v;

    /* renamed from: w */
    private int f7435w;

    /* compiled from: DiskCache.java */
    /* renamed from: com.cnlaunch.gmap.a.b.h$a */
    /* loaded from: classes.dex */
    public static class C1507a {

        /* renamed from: a */
        public long f7436a;

        /* renamed from: b */
        public byte[] f7437b;

        /* renamed from: c */
        public int f7438c;
    }

    public C1506h(String str, int i, int i2) throws IOException {
        this(str, i, i2, (byte) 0);
    }

    private C1506h(String str, int i, int i2, byte b) throws IOException {
        this.f7420g = new byte[32];
        this.f7430r = new byte[20];
        this.f7431s = new Adler32();
        this.f7433u = new C1507a();
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("unable to make dirs");
        }
        this.f7432t = str;
        this.f7421i = new RandomAccessFile(str + ".idx", "rw");
        this.f7422j = new RandomAccessFile(str + ".0", "rw");
        this.f7423k = new RandomAccessFile(str + ".1", "rw");
        this.f7426n = 0;
        if (m9366e()) {
            return;
        }
        this.f7421i.setLength(0L);
        this.f7421i.setLength((i * 12 * 2) + 32);
        this.f7421i.seek(0L);
        byte[] bArr = this.f7420g;
        m9372a(bArr, 0, -1289277392);
        m9372a(bArr, 4, i);
        m9372a(bArr, 8, i2);
        m9372a(bArr, 12, 0);
        m9372a(bArr, 16, 0);
        m9372a(bArr, 20, 4);
        m9372a(bArr, 24, this.f7426n);
        m9372a(bArr, 28, m9373a(bArr, 28));
        this.f7421i.write(bArr);
        this.f7422j.setLength(0L);
        this.f7423k.setLength(0L);
        this.f7422j.seek(0L);
        this.f7423k.seek(0L);
        m9372a(bArr, 0, -1121680112);
        this.f7422j.write(bArr, 0, 4);
        this.f7423k.write(bArr, 0, 4);
        if (m9366e()) {
            return;
        }
        m9367d();
        throw new IOException("unable to load index");
    }

    /* renamed from: d */
    private void m9367d() {
        m9376a(this.f7424l);
        m9376a(this.f7421i);
        m9376a(this.f7422j);
        m9376a(this.f7423k);
    }

    /* renamed from: e */
    private boolean m9366e() {
        try {
            this.f7421i.seek(0L);
            this.f7422j.seek(0L);
            this.f7423k.seek(0L);
            byte[] bArr = this.f7420g;
            if (this.f7421i.read(bArr) != 32) {
                Log.w(f7413h, "cannot read header");
                return false;
            } else if (m9369b(bArr, 0) != -1289277392) {
                Log.w(f7413h, "cannot read header magic");
                return false;
            } else if (m9369b(bArr, 24) != this.f7426n) {
                Log.w(f7413h, "version mismatch");
                return false;
            } else {
                this.f7414a = m9369b(bArr, 4);
                this.f7415b = m9369b(bArr, 8);
                this.f7416c = m9369b(bArr, 12);
                this.f7417d = m9369b(bArr, 16);
                this.f7418e = m9369b(bArr, 20);
                if (m9373a(bArr, 28) != m9369b(bArr, 28)) {
                    Log.w(f7413h, "header checksum does not match");
                    return false;
                } else if (this.f7414a <= 0) {
                    Log.w(f7413h, "invalid max entries");
                    return false;
                } else if (this.f7415b <= 0) {
                    Log.w(f7413h, "invalid max bytes");
                    return false;
                } else if (this.f7416c != 0 && this.f7416c != 1) {
                    Log.w(f7413h, "invalid active region");
                    return false;
                } else {
                    if (this.f7417d >= 0 && this.f7417d <= this.f7414a) {
                        if (this.f7418e >= 4 && this.f7418e <= this.f7415b) {
                            if (this.f7421i.length() != (this.f7414a * 12 * 2) + 32) {
                                Log.w(f7413h, "invalid index file length");
                                return false;
                            }
                            byte[] bArr2 = new byte[4];
                            if (this.f7422j.read(bArr2) != 4) {
                                Log.w(f7413h, "cannot read data file magic");
                                return false;
                            } else if (m9369b(bArr2, 0) != -1121680112) {
                                Log.w(f7413h, "invalid data file magic");
                                return false;
                            } else if (this.f7423k.read(bArr2) != 4) {
                                Log.w(f7413h, "cannot read data file magic");
                                return false;
                            } else if (m9369b(bArr2, 0) != -1121680112) {
                                Log.w(f7413h, "invalid data file magic");
                                return false;
                            } else {
                                this.f7424l = this.f7421i.getChannel();
                                this.f7425m = this.f7424l.map(FileChannel.MapMode.READ_WRITE, 0L, this.f7421i.length());
                                this.f7425m.order(ByteOrder.LITTLE_ENDIAN);
                                m9381a();
                                return true;
                            }
                        }
                        Log.w(f7413h, "invalid active bytes");
                        return false;
                    }
                    Log.w(f7413h, "invalid active entries");
                    return false;
                }
            }
        } catch (IOException e) {
            Log.e(f7413h, "loadIndex failed.", e);
            return false;
        }
    }

    /* renamed from: a */
    public final void m9381a() throws IOException {
        this.f7427o = this.f7416c == 0 ? this.f7422j : this.f7423k;
        this.f7428p = this.f7416c == 1 ? this.f7422j : this.f7423k;
        this.f7427o.setLength(this.f7418e);
        this.f7427o.seek(this.f7418e);
        this.f7419f = 32;
        this.f7429q = 32;
        if (this.f7416c == 0) {
            this.f7429q += this.f7414a * 12;
        } else {
            this.f7419f += this.f7414a * 12;
        }
    }

    /* renamed from: b */
    public final void m9370b() {
        byte[] bArr = this.f7420g;
        m9372a(bArr, 28, m9373a(bArr, 28));
        this.f7425m.position(0);
        this.f7425m.put(this.f7420g);
    }

    /* renamed from: a */
    public final void m9380a(int i) {
        byte[] bArr = new byte[1024];
        this.f7425m.position(i);
        int i2 = this.f7414a * 12;
        while (i2 > 0) {
            int min = Math.min(i2, 1024);
            this.f7425m.put(bArr, 0, min);
            i2 -= min;
        }
    }

    /* renamed from: a */
    public final void m9378a(long j, byte[] bArr, int i) throws IOException {
        byte[] bArr2 = this.f7430r;
        int m9374a = m9374a(bArr);
        m9371a(bArr2, j);
        m9372a(bArr2, 8, m9374a);
        m9372a(bArr2, 12, this.f7418e);
        m9372a(bArr2, 16, i);
        this.f7427o.write(bArr2);
        this.f7427o.write(bArr, 0, i);
        this.f7425m.putLong(this.f7434v, j);
        this.f7425m.putInt(this.f7434v + 8, this.f7418e);
        this.f7418e += i + 20;
        m9372a(this.f7420g, 20, this.f7418e);
    }

    /* renamed from: a */
    public final boolean m9377a(C1507a c1507a) throws IOException {
        if (m9379a(c1507a.f7436a, this.f7419f) && m9375a(this.f7427o, this.f7435w, c1507a)) {
            return true;
        }
        int i = this.f7434v;
        if (m9379a(c1507a.f7436a, this.f7429q) && m9375a(this.f7428p, this.f7435w, c1507a)) {
            if (this.f7418e + 20 + c1507a.f7438c > this.f7415b || this.f7417d * 2 >= this.f7414a) {
                return true;
            }
            this.f7434v = i;
            try {
                m9378a(c1507a.f7436a, c1507a.f7437b, c1507a.f7438c);
                this.f7417d++;
                m9372a(this.f7420g, 16, this.f7417d);
                m9370b();
            } catch (Throwable unused) {
                Log.e(f7413h, "cannot copy over");
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m9375a(RandomAccessFile randomAccessFile, int i, C1507a c1507a) throws IOException {
        byte[] bArr = this.f7430r;
        long filePointer = randomAccessFile.getFilePointer();
        try {
            randomAccessFile.seek(i);
            if (randomAccessFile.read(bArr) != 20) {
                Log.w(f7413h, "cannot read blob header");
                return false;
            }
            long j = bArr[7] & 255;
            for (int i2 = 6; i2 >= 0; i2--) {
                j = (j << 8) | (bArr[i2 + 0] & 255);
            }
            if (j != c1507a.f7436a) {
                Log.w(f7413h, "blob key does not match: ".concat(String.valueOf(j)));
                return false;
            }
            int m9369b = m9369b(bArr, 8);
            int m9369b2 = m9369b(bArr, 12);
            if (m9369b2 != i) {
                Log.w(f7413h, "blob offset does not match: ".concat(String.valueOf(m9369b2)));
                return false;
            }
            int m9369b3 = m9369b(bArr, 16);
            if (m9369b3 >= 0 && m9369b3 <= (this.f7415b - i) - 20) {
                if (c1507a.f7437b == null || c1507a.f7437b.length < m9369b3) {
                    c1507a.f7437b = new byte[m9369b3];
                }
                byte[] bArr2 = c1507a.f7437b;
                c1507a.f7438c = m9369b3;
                if (randomAccessFile.read(bArr2, 0, m9369b3) != m9369b3) {
                    Log.w(f7413h, "cannot read blob data");
                    return false;
                } else if (m9373a(bArr2, m9369b3) != m9369b) {
                    Log.w(f7413h, "blob checksum does not match: ".concat(String.valueOf(m9369b)));
                    return false;
                } else {
                    randomAccessFile.seek(filePointer);
                    return true;
                }
            }
            Log.w(f7413h, "invalid blob length: ".concat(String.valueOf(m9369b3)));
            return false;
        } catch (Throwable th) {
            try {
                Log.e(f7413h, "getBlob failed.", th);
                return false;
            } finally {
                randomAccessFile.seek(filePointer);
            }
        }
    }

    /* renamed from: a */
    public final boolean m9379a(long j, int i) {
        int i2 = this.f7414a;
        int i3 = (int) (j % i2);
        if (i3 < 0) {
            i3 += i2;
        }
        int i4 = i3;
        while (true) {
            int i5 = (i4 * 12) + i;
            long j2 = this.f7425m.getLong(i5);
            int i6 = this.f7425m.getInt(i5 + 8);
            if (i6 == 0) {
                this.f7434v = i5;
                return false;
            } else if (j2 == j) {
                this.f7434v = i5;
                this.f7435w = i6;
                return true;
            } else {
                i4++;
                if (i4 >= this.f7414a) {
                    i4 = 0;
                }
                if (i4 == i3) {
                    Log.w(f7413h, "corrupted index: clear the slot.");
                    this.f7425m.putInt((i4 * 12) + i + 8, 0);
                }
            }
        }
    }

    /* renamed from: c */
    public final void m9368c() {
        try {
            this.f7425m.force();
        } catch (Throwable th) {
            Log.w(f7413h, "sync index failed", th);
        }
    }

    /* renamed from: a */
    private int m9374a(byte[] bArr) {
        this.f7431s.reset();
        this.f7431s.update(bArr);
        return (int) this.f7431s.getValue();
    }

    /* renamed from: a */
    private int m9373a(byte[] bArr, int i) {
        this.f7431s.reset();
        this.f7431s.update(bArr, 0, i);
        return (int) this.f7431s.getValue();
    }

    /* renamed from: a */
    private static void m9376a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static int m9369b(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: a */
    public static void m9372a(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i + i3] = (byte) (i2 & 255);
            i2 >>= 8;
        }
    }

    /* renamed from: a */
    private static void m9371a(byte[] bArr, long j) {
        for (int i = 0; i < 8; i++) {
            bArr[i + 0] = (byte) (255 & j);
            j >>= 8;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m9368c();
        try {
            this.f7422j.getFD().sync();
        } catch (Throwable th) {
            Log.w(f7413h, "sync data file 0 failed", th);
        }
        try {
            this.f7423k.getFD().sync();
        } catch (Throwable th2) {
            Log.w(f7413h, "sync data file 1 failed", th2);
        }
        m9367d();
    }
}
