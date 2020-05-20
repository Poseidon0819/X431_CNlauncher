package com.ifoer.expedition.cto;

import com.cnlaunch.physics.p205k.C1856n;

/* loaded from: classes.dex */
public class CToJavaImplementsExtendsForDefaultLogic implements CToJavaImplementsExtends {
    private static final String TAG = "CToJavaImplementsExtendsForDefaultLogic";

    @Override // com.ifoer.expedition.cto.CToJavaImplementsExtends
    public boolean isNeedInterceptFor2505(byte[] bArr) {
        return false;
    }

    @Override // com.ifoer.expedition.cto.CToJavaImplementsExtends
    public byte[] writeAndReadSendBufferWrapper(byte[] bArr) {
        if (C1856n.f10135a) {
            C1856n.m8130a(TAG, "default sendBuffer");
        }
        return bArr;
    }
}
