package com.cnlaunch.physics.p195b.p196a;

import com.cnlaunch.physics.p205k.ByteHexHelper;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.File;

/* renamed from: com.cnlaunch.physics.b.a.h */
/* loaded from: classes.dex */
public final class OrderMontageForHD extends OrderMontage {

    /* renamed from: a */
    private static String f9830a = "";

    /* renamed from: b */
    private static String f9831b = "";

    /* renamed from: c */
    private static String f9832c = "";

    /* renamed from: d */
    private static String f9833d = "";

    /* renamed from: e */
    private static String f9834e = "";

    /* renamed from: f */
    private static OrderMontageForHD f9835f;

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8334a(byte[] bArr) {
        return null;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8331b(File file) {
        return null;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8329b(byte[] bArr) {
        return null;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: c */
    public final byte[] mo8326c(String str) {
        return null;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: j */
    public final byte[] mo8318j() {
        return null;
    }

    private OrderMontageForHD() {
    }

    /* renamed from: k */
    public static OrderMontageForHD m8317k() {
        if (f9835f == null) {
            f9835f = new OrderMontageForHD();
        }
        return f9835f;
    }

    /* renamed from: a */
    private static String m8338a(int i, String str) {
        int i2 = i & 255;
        int i3 = (i >> 8) & 255;
        f9831b = m8324d(Integer.toHexString(i3)) + m8324d(Integer.toHexString(i2)) + m8324d(Integer.toHexString((i3 ^ (-1)) & 255)) + m8324d(Integer.toHexString((i2 ^ (-1)) & 255));
        f9834e = ByteHexHelper.m8174b(f9831b + str);
        String str2 = "55aa" + f9831b + str + f9834e;
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "generateCommonCommandOrder： ".concat(String.valueOf(str2)));
        }
        return str2;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8339a() {
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "DPUVerInfo2103： ".concat(String.valueOf("55AA0007FFF8AC76DA")));
        }
        return ByteHexHelper.m8183a("55AA0007FFF8AC76DA");
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8332b() {
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "DPUVer2105： ".concat(String.valueOf("55AA0006FFF96F6F")));
        }
        return ByteHexHelper.m8183a("55AA0006FFF96F6F");
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: c */
    public final byte[] mo8327c() {
        String m8338a = m8338a(f9833d.getBytes().length, f9833d);
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "currentStatus2114： ".concat(String.valueOf(m8338a)));
        }
        return ByteHexHelper.m8183a(m8338a);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: d */
    public final byte[] mo8325d() {
        String m8338a = m8338a(f9833d.getBytes().length, f9833d);
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "updateFirmware2407： ".concat(String.valueOf(m8338a)));
        }
        return ByteHexHelper.m8183a(m8338a);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: e */
    public final byte[] mo8323e() {
        String m8338a = m8338a(f9833d.getBytes().length, f9833d);
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "requestConnect2502： ".concat(String.valueOf(m8338a)));
        }
        return ByteHexHelper.m8183a(m8338a);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8336a(String str) {
        String m8338a = m8338a(f9833d.getBytes().length, f9833d);
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "securityCheck2503： ".concat(String.valueOf(m8338a)));
        }
        return ByteHexHelper.m8183a(m8338a);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: f */
    public final byte[] mo8322f() {
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "resetConnector2505： ".concat(String.valueOf("55aa00000000c005687f4f5d")));
        }
        return ByteHexHelper.m8183a("55aa00000000c005687f4f5d");
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8337a(File file) {
        DpuOrderUtils.m8345a(file.getName(), file);
        String m8338a = m8338a(f9833d.getBytes().length, f9833d);
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "sendFileNameAndLength2402： ".concat(String.valueOf(m8338a)));
        }
        return ByteHexHelper.m8183a(m8338a);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8330b(String str) {
        String m8338a = m8338a(f9833d.getBytes().length, f9833d);
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "sendUpdateFileMd52404： ".concat(String.valueOf(m8338a)));
        }
        return ByteHexHelper.m8183a(m8338a);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8335a(String str, String str2) {
        String str3 = "040EFBF161" + str + "00000400";
        f9833d = str2;
        f9834e = ByteHexHelper.m8182a(str3, f9833d);
        byte[] m8183a = ByteHexHelper.m8183a("55AA" + str3 + f9833d + f9834e);
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "sendUpdateFilesContent2403： ".concat(String.valueOf(m8183a)));
        }
        return m8183a;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: g */
    public final byte[] mo8321g() {
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "sendUpdate2505： ".concat(String.valueOf("55504441544521")));
        }
        return ByteHexHelper.m8183a("55504441544521");
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: h */
    public final byte[] mo8320h() {
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "setBautrate2505： ".concat(String.valueOf("55AA000EFFF1630001C20000000000A0")));
        }
        return ByteHexHelper.m8183a("55AA000EFFF1630001C20000000000A0");
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: i */
    public final byte[] mo8319i() {
        if (C1856n.f10135a) {
            C1856n.m8130a("OrderMontageForHD", "setAddressAndSize2505： ".concat(String.valueOf("55AA000EFFF1620001000000068000E5")));
        }
        return ByteHexHelper.m8183a("55AA000EFFF1620001000000068000E5");
    }

    /* renamed from: d */
    private static String m8324d(String str) {
        while (str.length() < 2) {
            str = "0".concat(String.valueOf(str));
        }
        return str;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8333a(byte[] bArr, byte[] bArr2) {
        ByteHexHelper.m8173b(bArr);
        ByteHexHelper.m8173b(bArr2);
        return new byte[0];
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8328b(byte[] bArr, byte[] bArr2) {
        ByteHexHelper.m8173b(bArr);
        ByteHexHelper.m8173b(bArr2);
        return new byte[0];
    }
}
