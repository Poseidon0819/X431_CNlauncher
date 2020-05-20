package com.mopub.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class ByteArrayPool {

    /* renamed from: a */
    protected static final Comparator<byte[]> f21308a = new C3928a();

    /* renamed from: b */
    private List<byte[]> f21309b = new LinkedList();

    /* renamed from: c */
    private List<byte[]> f21310c = new ArrayList(64);

    /* renamed from: d */
    private int f21311d = 0;

    /* renamed from: e */
    private final int f21312e;

    public ByteArrayPool(int i) {
        this.f21312e = i;
    }

    public synchronized byte[] getBuf(int i) {
        for (int i2 = 0; i2 < this.f21310c.size(); i2++) {
            byte[] bArr = this.f21310c.get(i2);
            if (bArr.length >= i) {
                this.f21311d -= bArr.length;
                this.f21310c.remove(i2);
                this.f21309b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void returnBuf(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f21312e) {
                this.f21309b.add(bArr);
                int binarySearch = Collections.binarySearch(this.f21310c, bArr, f21308a);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f21310c.add(binarySearch, bArr);
                this.f21311d += bArr.length;
                m2006a();
            }
        }
    }

    /* renamed from: a */
    private synchronized void m2006a() {
        while (this.f21311d > this.f21312e) {
            byte[] remove = this.f21309b.remove(0);
            this.f21310c.remove(remove);
            this.f21311d -= remove.length;
        }
    }
}
