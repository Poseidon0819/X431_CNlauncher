package com.cnlaunch.p188n.p190b;

import android.content.Context;
import com.cnlaunch.p188n.p191c.MLog;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.cnlaunch.n.b.i */
/* loaded from: classes.dex */
public final class RemoteBusinessPackage extends BaseRemoteBusinessPackage {

    /* renamed from: p */
    private Context f9583p;

    public RemoteBusinessPackage() {
    }

    public RemoteBusinessPackage(Context context, String str, String str2) {
        this.f9583p = context;
        this.f9560j = str;
        this.f9561k = str2;
        MLog.m8522a("XRR", "RemoteBusinessPackage sn:" + this.f9560j + " key:" + str2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    /* renamed from: g */
    public final PackageData m8569g() {
        m8590a(0);
        PackageData packageData = new PackageData();
        m8583e();
        packageData.setSendCounter(this.f9562l);
        packageData.setBusinessID(0);
        this.f9564n = (byte) 1;
        this.f9551a = 1;
        this.f9555e = new byte[this.f9551a];
        this.f9555e[0] = 1;
        packageData.setData(m8582f());
        return packageData;
    }

    /* renamed from: a */
    public final PackageData m8573a(int i, int i2) {
        m8590a(i);
        PackageData packageData = new PackageData();
        packageData.setSendCounter(i2);
        packageData.setBusinessID(i);
        this.f9564n = (byte) 1;
        this.f9551a = 1;
        this.f9555e = new byte[this.f9551a];
        this.f9555e[0] = 1;
        packageData.setData(m8586b(i2));
        packageData.setResponsPackage(true);
        return packageData;
    }

    /* renamed from: a */
    public final PackageData m8574a(int i, byte b) {
        m8590a(135);
        PackageData packageData = new PackageData();
        packageData.setSendCounter(i);
        packageData.setBusinessID(135);
        this.f9564n = (byte) 1;
        this.f9551a = 2;
        this.f9555e = new byte[this.f9551a];
        this.f9555e[0] = b;
        this.f9555e[1] = 1;
        packageData.setData(m8586b(i));
        packageData.setResponsPackage(true);
        return packageData;
    }

    /* renamed from: a */
    public final PackageData m8572a(String str) {
        this.f9554d = 1;
        MLog.m8522a("XRR", "****获取技师登录***token:" + this.f9559i + " techID:" + str + " sn:" + this.f9560j + " key:" + this.f9561k + " ver:" + this.f9554d);
        PackageData packageData = new PackageData();
        packageData.setBusinessID(1);
        m8583e();
        packageData.setSendCounter(this.f9562l);
        m8590a(1);
        this.f9564n = (byte) 2;
        this.f9551a = this.f9559i.length() + 1 + 1 + this.f9560j.length() + 1 + str.length() + 1 + this.f9561k.length();
        this.f9555e = new byte[this.f9551a];
        this.f9555e[0] = (byte) (this.f9559i.length() & 255);
        int a = m8588a(this.f9559i.getBytes(), this.f9555e, 1) + 1;
        int i = a + 1;
        this.f9555e[a] = (byte) (str.length() & 255);
        int a2 = i + m8588a(str.getBytes(), this.f9555e, i);
        int i2 = a2 + 1;
        this.f9555e[a2] = (byte) (this.f9560j.length() & 255);
        int a3 = i2 + m8588a(this.f9560j.getBytes(), this.f9555e, i2);
        this.f9555e[a3] = (byte) (this.f9561k.length() & 255);
        m8588a(this.f9561k.getBytes(), this.f9555e, a3 + 1);
        packageData.setData(m8582f());
        return packageData;
    }

    /* renamed from: h */
    public final PackageData m8568h() {
        PackageData packageData = new PackageData();
        packageData.setBusinessID(2);
        m8590a(2);
        m8583e();
        packageData.setSendCounter(this.f9562l);
        this.f9564n = (byte) 1;
        this.f9551a = this.f9560j.length() + 1 + 1 + this.f9561k.length();
        this.f9555e = new byte[this.f9551a];
        this.f9555e[0] = (byte) (this.f9560j.length() & 255);
        int a = m8588a(this.f9560j.getBytes(), this.f9555e, 1) + 1;
        this.f9555e[a] = (byte) (this.f9561k.length() & 255);
        m8588a(this.f9561k.getBytes(), this.f9555e, a + 1);
        packageData.setData(m8582f());
        return packageData;
    }

    /* renamed from: a */
    public final PackageData m8570a(byte[] bArr, boolean z, int i, int i2) {
        PackageData packageData = new PackageData();
        packageData.setBusinessID(4);
        m8590a(4);
        m8583e();
        packageData.setSendCounter(this.f9562l);
        this.f9564n = (byte) 1;
        this.f9555e = bArr;
        packageData.setData(m8582f());
        packageData.setCutPackage(z);
        packageData.setCutPackage_Total_number(i);
        packageData.setCurPackage_Current_number(i2);
        return packageData;
    }

    /* renamed from: i */
    public final PackageData m8567i() {
        m8590a(5);
        PackageData packageData = new PackageData();
        m8583e();
        packageData.setSendCounter(this.f9562l);
        packageData.setBusinessID(5);
        this.f9564n = (byte) 1;
        this.f9551a = 1;
        this.f9555e = new byte[this.f9551a];
        this.f9555e[0] = 21;
        packageData.setData(m8582f());
        return packageData;
    }

    /* renamed from: a */
    public final PackageData m8571a(boolean z) {
        m8590a(7);
        PackageData packageData = new PackageData();
        m8583e();
        packageData.setSendCounter(this.f9562l);
        packageData.setBusinessID(7);
        this.f9564n = (byte) 1;
        this.f9551a = 2;
        this.f9555e = new byte[this.f9551a];
        this.f9555e[0] = 15;
        if (z) {
            this.f9555e[1] = 1;
        } else {
            this.f9555e[1] = 0;
        }
        packageData.setData(m8582f());
        return packageData;
    }
}
