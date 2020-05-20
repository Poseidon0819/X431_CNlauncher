package com.cnlaunch.x431pro.module.p258f.p260b;

import java.io.Serializable;

/* renamed from: com.cnlaunch.x431pro.module.f.b.a */
/* loaded from: classes.dex */
public class AlipayQrCodeCyResponse extends CyResultBase {
    private C2727a resultData;

    public C2727a getResultData() {
        return this.resultData;
    }

    public void setResultData(C2727a c2727a) {
        this.resultData = c2727a;
    }

    /* compiled from: AlipayQrCodeCyResponse.java */
    /* renamed from: com.cnlaunch.x431pro.module.f.b.a$a */
    /* loaded from: classes.dex */
    public static class C2727a implements Serializable {
        private String qrCode;
        private double totalPrice;

        public final String getQrCode() {
            return this.qrCode;
        }

        public final void setQrCode(String str) {
            this.qrCode = str;
        }

        public final double getTotalPrice() {
            return this.totalPrice;
        }

        public final void setTotalPrice(double d) {
            this.totalPrice = d;
        }
    }
}
