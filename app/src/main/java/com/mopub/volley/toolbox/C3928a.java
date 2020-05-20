package com.mopub.volley.toolbox;

import java.util.Comparator;

/* compiled from: ByteArrayPool.java */
/* renamed from: com.mopub.volley.toolbox.a */
/* loaded from: classes2.dex */
final class C3928a implements Comparator<byte[]> {
    @Override // java.util.Comparator
    public final int compare(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }
}
