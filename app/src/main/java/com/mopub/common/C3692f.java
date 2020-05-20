package com.mopub.common;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: DiskLruCacheStrictLineReader.java */
/* renamed from: com.mopub.common.f */
/* loaded from: classes.dex */
final class C3692f extends ByteArrayOutputStream {

    /* renamed from: a */
    final /* synthetic */ DiskLruCacheStrictLineReader f20211a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3692f(DiskLruCacheStrictLineReader diskLruCacheStrictLineReader, int i) {
        super(i);
        this.f20211a = diskLruCacheStrictLineReader;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        try {
            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, this.f20211a.f20116a.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
