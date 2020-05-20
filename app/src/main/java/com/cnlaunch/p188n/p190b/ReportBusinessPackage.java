package com.cnlaunch.p188n.p190b;

/* renamed from: com.cnlaunch.n.b.l */
/* loaded from: classes.dex */
public final class ReportBusinessPackage extends BaseReportBusinessPackage {

    /* renamed from: n */
    private String f9595n;

    /* renamed from: o */
    private String f9596o;

    /* renamed from: p */
    private String f9597p;

    /* renamed from: d */
    public final PackageData m8552d() {
        m8580a(1);
        PackageData packageData = new PackageData();
        packageData.setBusinessID(1);
        this.f9571f = 1;
        this.f9574i = new byte[this.f9571f];
        this.f9574i[0] = 8;
        packageData.setData(m8577c());
        return packageData;
    }

    /* renamed from: a */
    public final PackageData m8554a(byte[] bArr, boolean z) {
        m8580a(11);
        PackageData packageData = new PackageData();
        packageData.setBusinessID(11);
        this.f9571f = bArr.length + 1;
        this.f9574i = new byte[this.f9571f];
        int m8553a = m8553a(bArr, this.f9574i, 0) + 0;
        if (z) {
            this.f9574i[m8553a] = 1;
        } else {
            this.f9574i[m8553a] = 2;
        }
        packageData.setData(m8577c());
        return packageData;
    }

    /* renamed from: a */
    private static int m8553a(byte[] bArr, byte[] bArr2, int i) {
        int length = bArr.length;
        System.arraycopy(bArr, 0, bArr2, i, length);
        return length;
    }

    /* renamed from: e */
    public final PackageData m8551e() {
        PackageData packageData = new PackageData();
        packageData.setBusinessID(2);
        m8580a(2);
        this.f9571f = this.f9595n.length() + this.f9596o.length() + this.f9597p.length();
        this.f9574i = new byte[this.f9571f];
        int m8553a = m8553a(this.f9595n.getBytes(), this.f9574i, 0) + 0;
        m8553a(this.f9597p.getBytes(), this.f9574i, m8553a + m8553a(this.f9596o.getBytes(), this.f9574i, m8553a));
        packageData.setData(m8577c());
        return packageData;
    }
}
