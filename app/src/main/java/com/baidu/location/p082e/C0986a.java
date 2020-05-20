package com.baidu.location.p082e;

import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.Locale;

/* renamed from: com.baidu.location.e.a */
/* loaded from: classes.dex */
public class C0986a {

    /* renamed from: a */
    public int f4372a;

    /* renamed from: b */
    public int f4373b;

    /* renamed from: c */
    public int f4374c;

    /* renamed from: d */
    public int f4375d;

    /* renamed from: e */
    public int f4376e;

    /* renamed from: f */
    public int f4377f;

    /* renamed from: g */
    public long f4378g;

    /* renamed from: h */
    public int f4379h;

    /* renamed from: i */
    public char f4380i;

    /* renamed from: j */
    public String f4381j;

    /* renamed from: k */
    private boolean f4382k;

    public C0986a() {
        this.f4372a = -1;
        this.f4373b = -1;
        this.f4374c = -1;
        this.f4375d = -1;
        this.f4376e = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        this.f4377f = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        this.f4378g = 0L;
        this.f4379h = -1;
        this.f4380i = '0';
        this.f4381j = null;
        this.f4382k = false;
        this.f4378g = System.currentTimeMillis();
    }

    public C0986a(int i, int i2, int i3, int i4, int i5, char c) {
        this.f4372a = -1;
        this.f4373b = -1;
        this.f4374c = -1;
        this.f4375d = -1;
        this.f4376e = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        this.f4377f = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        this.f4378g = 0L;
        this.f4379h = -1;
        this.f4380i = '0';
        this.f4381j = null;
        this.f4382k = false;
        this.f4372a = i;
        this.f4373b = i2;
        this.f4374c = i3;
        this.f4375d = i4;
        this.f4379h = i5;
        this.f4380i = c;
        this.f4378g = System.currentTimeMillis();
    }

    public C0986a(C0986a c0986a) {
        this(c0986a.f4372a, c0986a.f4373b, c0986a.f4374c, c0986a.f4375d, c0986a.f4379h, c0986a.f4380i);
        this.f4378g = c0986a.f4378g;
    }

    /* renamed from: a */
    public boolean m11742a() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f4378g;
        return currentTimeMillis - j > 0 && currentTimeMillis - j < 3000;
    }

    /* renamed from: a */
    public boolean m11741a(C0986a c0986a) {
        return this.f4372a == c0986a.f4372a && this.f4373b == c0986a.f4373b && this.f4375d == c0986a.f4375d && this.f4374c == c0986a.f4374c;
    }

    /* renamed from: b */
    public boolean m11740b() {
        return this.f4372a >= 0 && this.f4373b > 0;
    }

    /* renamed from: c */
    public boolean m11739c() {
        return this.f4372a == -1 && this.f4373b == -1 && this.f4375d == -1 && this.f4374c == -1;
    }

    /* renamed from: d */
    public boolean m11738d() {
        return this.f4372a >= 0 && this.f4373b >= 0 && this.f4375d == -1 && this.f4374c == -1;
    }

    /* renamed from: e */
    public boolean m11737e() {
        return this.f4372a >= 0 && this.f4373b >= 0 && this.f4375d >= 0 && this.f4374c >= 0;
    }

    /* renamed from: f */
    public void m11736f() {
        this.f4382k = true;
    }

    /* renamed from: g */
    public String m11735g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.f4373b + 23);
        stringBuffer.append("H");
        stringBuffer.append(this.f4372a + 45);
        stringBuffer.append("K");
        stringBuffer.append(this.f4375d + 54);
        stringBuffer.append("Q");
        stringBuffer.append(this.f4374c + 203);
        return stringBuffer.toString();
    }

    /* renamed from: h */
    public String m11734h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.f4380i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(this.f4374c), Integer.valueOf(this.f4375d), Integer.valueOf(this.f4372a), Integer.valueOf(this.f4373b), Integer.valueOf(this.f4379h)));
        if (this.f4382k) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }

    /* renamed from: i */
    public String m11733i() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.f4380i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", Integer.valueOf(this.f4374c), Integer.valueOf(this.f4375d), Integer.valueOf(this.f4372a), Integer.valueOf(this.f4373b), Integer.valueOf(this.f4379h)));
        return stringBuffer.toString();
    }
}
