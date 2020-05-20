package com.cnlaunch.physics.p195b.p196a;

import com.cnlaunch.physics.p205k.ByteHexHelper;
import java.io.File;

/* renamed from: com.cnlaunch.physics.b.a.g */
/* loaded from: classes.dex */
public final class OrderMontageForCar extends OrderMontage {

    /* renamed from: a */
    private static String f9824a = "";

    /* renamed from: b */
    private static String f9825b = "";

    /* renamed from: c */
    private static String f9826c = "";

    /* renamed from: d */
    private static String f9827d = "";

    /* renamed from: e */
    private static String f9828e = "";

    /* renamed from: f */
    private static OrderMontageForCar f9829f;

    private OrderMontageForCar() {
    }

    /* renamed from: k */
    public static OrderMontageForCar m8340k() {
        if (f9829f == null) {
            f9829f = new OrderMontageForCar();
        }
        return f9829f;
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8339a() {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2103";
        f9827d = "";
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8332b() {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2105";
        f9827d = "";
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: c */
    public final byte[] mo8327c() {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2114";
        f9827d = "";
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: d */
    public final byte[] mo8325d() {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2407";
        f9827d = "";
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: e */
    public final byte[] mo8323e() {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2502";
        f9827d = "02";
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8336a(String str) {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2503";
        f9827d = str;
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: f */
    public final byte[] mo8322f() {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2505";
        f9827d = "";
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8337a(File file) {
        byte[] m8345a = DpuOrderUtils.m8345a(file.getName(), file);
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2402";
        f9827d = ByteHexHelper.m8180a(m8345a);
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8331b(File file) {
        byte[] m8345a = DpuOrderUtils.m8345a(file.getName(), file);
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2412";
        f9827d = ByteHexHelper.m8180a(m8345a);
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8330b(String str) {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2404";
        f9827d = ByteHexHelper.m8180a(str.getBytes());
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: c */
    public final byte[] mo8326c(String str) {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2414";
        f9827d = ByteHexHelper.m8180a(str.getBytes());
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8334a(byte[] bArr) {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2403";
        f9827d = ByteHexHelper.m8180a(bArr);
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8329b(byte[] bArr) {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2413";
        f9827d = ByteHexHelper.m8180a(bArr);
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8335a(String str, String str2) {
        String str3 = "040EFBF161" + str + "00000400";
        f9827d = str2;
        f9828e = ByteHexHelper.m8182a(str3, f9827d);
        return ByteHexHelper.m8183a("55AA" + str3 + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: g */
    public final byte[] mo8321g() {
        return ByteHexHelper.m8183a("55504441544521");
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: h */
    public final byte[] mo8320h() {
        return ByteHexHelper.m8183a("55AA000EFFF1630001C20000000000A0");
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: i */
    public final byte[] mo8319i() {
        return ByteHexHelper.m8183a("55AA000EFFF1620001000000068000E5");
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: j */
    public final byte[] mo8318j() {
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = "2120";
        f9827d = "";
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: a */
    public final byte[] mo8333a(byte[] bArr, byte[] bArr2) {
        String m8173b = ByteHexHelper.m8173b(bArr);
        String m8173b2 = ByteHexHelper.m8173b(bArr2);
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = m8173b;
        f9827d = m8173b2;
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F0", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF0F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }

    @Override // com.cnlaunch.physics.p195b.p196a.OrderMontage
    /* renamed from: b */
    public final byte[] mo8328b(byte[] bArr, byte[] bArr2) {
        String m8173b = ByteHexHelper.m8173b(bArr);
        String m8173b2 = ByteHexHelper.m8173b(bArr2);
        String m8187a = ByteHexHelper.m8187a();
        while (m8187a.equalsIgnoreCase(f9824a)) {
            m8187a = ByteHexHelper.m8187a();
        }
        f9824a = m8187a;
        f9826c = m8173b;
        f9827d = m8173b2;
        f9825b = ByteHexHelper.m8171c(f9824a + f9826c + f9827d);
        f9828e = ByteHexHelper.m8181a("F1", "F8", f9825b, f9824a, f9826c, f9827d);
        return ByteHexHelper.m8183a("55aaF1F8" + f9825b + f9824a + f9826c + f9827d + f9828e);
    }
}
