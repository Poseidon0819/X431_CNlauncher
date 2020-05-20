package com.cnlaunch.physics.p205k;

/* renamed from: com.cnlaunch.physics.k.f */
/* loaded from: classes.dex */
public final class DPU_Long {

    /* renamed from: a */
    long f10100a;

    public DPU_Long(long j) {
        this.f10100a = j;
    }

    /* renamed from: a */
    public final byte[] m8163a() {
        long j = this.f10100a;
        return new byte[]{(byte) (j >> 24), (byte) (j >> 16), (byte) (j >> 8), (byte) j};
    }
}
