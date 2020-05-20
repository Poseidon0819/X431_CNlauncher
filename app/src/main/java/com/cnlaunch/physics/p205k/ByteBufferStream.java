package com.cnlaunch.physics.p205k;

/* renamed from: com.cnlaunch.physics.k.c */
/* loaded from: classes.dex */
public class ByteBufferStream {

    /* renamed from: e */
    protected int f10093e = 0;

    /* renamed from: f */
    protected int f10094f = 0;

    /* renamed from: g */
    protected int f10095g = 5120;

    /* renamed from: d */
    protected byte[] f10092d = new byte[this.f10095g];

    protected void finalize() {
        try {
            this.f10092d = null;
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final int m8191b() {
        int i = this.f10093e;
        if (i >= this.f10094f) {
            return -1;
        }
        byte[] bArr = this.f10092d;
        this.f10093e = i + 1;
        return bArr[i] & 255;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final byte[] m8193a(int i) {
        int i2 = this.f10094f - this.f10093e;
        if (i2 <= i) {
            i = i2;
        }
        if (i <= 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f10092d, this.f10093e, bArr, 0, i);
        this.f10093e += i;
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final int m8189b(byte[] bArr) {
        return m8188c(bArr, 0, bArr != null ? bArr.length : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final int m8188c(byte[] bArr, int i, int i2) {
        if (i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("invalid offset or length");
        }
        this.f10093e = 0;
        int i3 = this.f10094f;
        if (i3 <= i2) {
            i2 = i3;
        }
        if (i2 <= 0) {
            return 0;
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("ByteBufferStream", String.format("readBytes this.position=%d", Integer.valueOf(this.f10093e)));
        }
        System.arraycopy(this.f10092d, this.f10093e, bArr, i, i2);
        m8190b(i2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8192a(byte[] bArr, int i, int i2) {
        if (i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("invalid offset or length");
        }
        if (bArr.length - i < i2) {
            i2 = bArr.length - i;
        }
        int length = bArr.length + i2;
        if (length > this.f10095g - this.f10094f) {
            if (length < 256) {
                length = 256;
            }
            int i3 = this.f10095g;
            if (length < i3 * 2) {
                length = i3 * 2;
            }
            byte[] bArr2 = new byte[length];
            int i4 = this.f10094f;
            if (i4 > 0) {
                System.arraycopy(this.f10092d, 0, bArr2, 0, i4);
            }
            this.f10092d = bArr2;
            this.f10095g = length;
        }
        System.arraycopy(bArr, i, this.f10092d, this.f10094f, i2);
        this.f10094f += i2;
        if (C1856n.f10135a) {
            C1856n.m8130a("ByteBufferStream", "write this.length =" + this.f10094f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m8190b(int i) {
        if (i > 0) {
            int i2 = this.f10094f;
            if (i2 >= i) {
                byte[] bArr = this.f10092d;
                System.arraycopy(bArr, i, bArr, 0, i2 - i);
                this.f10094f -= i;
                return;
            }
            this.f10094f = 0;
        }
    }
}
