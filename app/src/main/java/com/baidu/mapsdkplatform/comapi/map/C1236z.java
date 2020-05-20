package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.inner.Point;
import com.itextpdf.text.html.HtmlTags;

/* renamed from: com.baidu.mapsdkplatform.comapi.map.z */
/* loaded from: classes.dex */
public class C1236z {

    /* renamed from: t */
    private static final String f6113t = "z";

    /* renamed from: m */
    public double f6126m;

    /* renamed from: n */
    public double f6127n;

    /* renamed from: o */
    public int f6128o;

    /* renamed from: p */
    public String f6129p;

    /* renamed from: q */
    public float f6130q;

    /* renamed from: r */
    public boolean f6131r;

    /* renamed from: s */
    public int f6132s;

    /* renamed from: a */
    public float f6114a = 12.0f;

    /* renamed from: b */
    public int f6115b = 0;

    /* renamed from: c */
    public int f6116c = 0;

    /* renamed from: d */
    public double f6117d = 1.2958162E7d;

    /* renamed from: e */
    public double f6118e = 4825907.0d;

    /* renamed from: h */
    public long f6121h = 0;

    /* renamed from: i */
    public long f6122i = 0;

    /* renamed from: f */
    public int f6119f = -1;

    /* renamed from: g */
    public int f6120g = -1;

    /* renamed from: j */
    public WinRound f6123j = new WinRound();

    /* renamed from: k */
    public C1237a f6124k = new C1237a();

    /* renamed from: l */
    public boolean f6125l = false;

    /* renamed from: com.baidu.mapsdkplatform.comapi.map.z$a */
    /* loaded from: classes.dex */
    public class C1237a {

        /* renamed from: a */
        public long f6133a = 0;

        /* renamed from: b */
        public long f6134b = 0;

        /* renamed from: c */
        public long f6135c = 0;

        /* renamed from: d */
        public long f6136d = 0;

        /* renamed from: e */
        public Point f6137e = new Point(0, 0);

        /* renamed from: f */
        public Point f6138f = new Point(0, 0);

        /* renamed from: g */
        public Point f6139g = new Point(0, 0);

        /* renamed from: h */
        public Point f6140h = new Point(0, 0);

        public C1237a() {
        }
    }

    /* renamed from: a */
    public Bundle m10557a(C1210e c1210e) {
        int i;
        if (this.f6114a < c1210e.f6004b) {
            this.f6114a = c1210e.f6004b;
        }
        if (this.f6114a > c1210e.f5983a) {
            if (this.f6114a == 1096.0f || C1210e.f5956d == 26.0f) {
                this.f6114a = 26.0f;
                C1210e.f5956d = 26.0f;
            } else {
                this.f6114a = c1210e.f5983a;
            }
        }
        while (true) {
            i = this.f6115b;
            if (i >= 0) {
                break;
            }
            this.f6115b = i + 360;
        }
        this.f6115b = i % 360;
        if (this.f6116c > 0) {
            this.f6116c = 0;
        }
        if (this.f6116c < -45) {
            this.f6116c = -45;
        }
        Bundle bundle = new Bundle();
        bundle.putDouble("level", this.f6114a);
        bundle.putDouble("rotation", this.f6115b);
        bundle.putDouble("overlooking", this.f6116c);
        bundle.putDouble("centerptx", this.f6117d);
        bundle.putDouble("centerpty", this.f6118e);
        bundle.putInt(HtmlTags.ALIGN_LEFT, this.f6123j.left);
        bundle.putInt(HtmlTags.ALIGN_RIGHT, this.f6123j.right);
        bundle.putInt(HtmlTags.ALIGN_TOP, this.f6123j.top);
        bundle.putInt(HtmlTags.ALIGN_BOTTOM, this.f6123j.bottom);
        int i2 = this.f6119f;
        if (i2 >= 0 && this.f6120g >= 0 && i2 <= this.f6123j.right && this.f6120g <= this.f6123j.bottom && this.f6123j.right > 0 && this.f6123j.bottom > 0) {
            int i3 = this.f6119f - ((this.f6123j.right - this.f6123j.left) / 2);
            int i4 = this.f6120g - ((this.f6123j.bottom - this.f6123j.top) / 2);
            this.f6121h = i3;
            this.f6122i = -i4;
            bundle.putLong("xoffset", this.f6121h);
            bundle.putLong("yoffset", this.f6122i);
        }
        bundle.putInt("lbx", this.f6124k.f6137e.f5413x);
        bundle.putInt("lby", this.f6124k.f6137e.f5414y);
        bundle.putInt("ltx", this.f6124k.f6138f.f5413x);
        bundle.putInt("lty", this.f6124k.f6138f.f5414y);
        bundle.putInt("rtx", this.f6124k.f6139g.f5413x);
        bundle.putInt("rty", this.f6124k.f6139g.f5414y);
        bundle.putInt("rbx", this.f6124k.f6140h.f5413x);
        bundle.putInt("rby", this.f6124k.f6140h.f5414y);
        bundle.putInt("bfpp", this.f6125l ? 1 : 0);
        bundle.putInt("animation", 1);
        bundle.putInt("animatime", this.f6128o);
        bundle.putString("panoid", this.f6129p);
        bundle.putInt("autolink", 0);
        bundle.putFloat("siangle", this.f6130q);
        bundle.putInt("isbirdeye", this.f6131r ? 1 : 0);
        bundle.putInt("ssext", this.f6132s);
        return bundle;
    }

    /* renamed from: a */
    public void m10558a(Bundle bundle) {
        this.f6114a = (float) bundle.getDouble("level");
        this.f6115b = (int) bundle.getDouble("rotation");
        this.f6116c = (int) bundle.getDouble("overlooking");
        this.f6117d = bundle.getDouble("centerptx");
        this.f6118e = bundle.getDouble("centerpty");
        this.f6123j.left = bundle.getInt(HtmlTags.ALIGN_LEFT);
        this.f6123j.right = bundle.getInt(HtmlTags.ALIGN_RIGHT);
        this.f6123j.top = bundle.getInt(HtmlTags.ALIGN_TOP);
        this.f6123j.bottom = bundle.getInt(HtmlTags.ALIGN_BOTTOM);
        this.f6121h = bundle.getLong("xoffset");
        this.f6122i = bundle.getLong("yoffset");
        if (this.f6123j.right != 0 && this.f6123j.bottom != 0) {
            int i = (int) this.f6121h;
            int i2 = (int) (-this.f6122i);
            this.f6119f = i + ((this.f6123j.right - this.f6123j.left) / 2);
            this.f6120g = i2 + ((this.f6123j.bottom - this.f6123j.top) / 2);
        }
        this.f6124k.f6133a = bundle.getLong("gleft");
        this.f6124k.f6134b = bundle.getLong("gright");
        this.f6124k.f6135c = bundle.getLong("gtop");
        this.f6124k.f6136d = bundle.getLong("gbottom");
        if (this.f6124k.f6133a <= -20037508) {
            this.f6124k.f6133a = -20037508L;
        }
        if (this.f6124k.f6134b >= 20037508) {
            this.f6124k.f6134b = 20037508L;
        }
        if (this.f6124k.f6135c >= 20037508) {
            this.f6124k.f6135c = 20037508L;
        }
        if (this.f6124k.f6136d <= -20037508) {
            this.f6124k.f6136d = -20037508L;
        }
        this.f6124k.f6137e.f5413x = bundle.getInt("lbx");
        this.f6124k.f6137e.f5414y = bundle.getInt("lby");
        this.f6124k.f6138f.f5413x = bundle.getInt("ltx");
        this.f6124k.f6138f.f5414y = bundle.getInt("lty");
        this.f6124k.f6139g.f5413x = bundle.getInt("rtx");
        this.f6124k.f6139g.f5414y = bundle.getInt("rty");
        this.f6124k.f6140h.f5413x = bundle.getInt("rbx");
        this.f6124k.f6140h.f5414y = bundle.getInt("rby");
        this.f6125l = bundle.getInt("bfpp") == 1;
        this.f6126m = bundle.getDouble("adapterzoomunit");
        this.f6127n = bundle.getDouble("zoomunit");
        this.f6129p = bundle.getString("panoid");
        this.f6130q = bundle.getFloat("siangle");
        this.f6131r = bundle.getInt("isbirdeye") != 0;
        this.f6132s = bundle.getInt("ssext");
    }
}
