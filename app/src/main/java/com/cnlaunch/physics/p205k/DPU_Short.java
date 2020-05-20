package com.cnlaunch.physics.p205k;

/* renamed from: com.cnlaunch.physics.k.g */
/* loaded from: classes.dex */
public final class DPU_Short {

    /* renamed from: a */
    short f10101a;

    public DPU_Short(short s) {
        this.f10101a = s;
    }

    /* renamed from: a */
    public final byte[] m8162a() {
        short s = this.f10101a;
        return new byte[]{(byte) (s >> 8), (byte) s};
    }
}
