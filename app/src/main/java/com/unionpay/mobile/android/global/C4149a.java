package com.unionpay.mobile.android.global;

import android.content.Context;
import com.unionpay.mobile.android.utils.C4386g;

/* renamed from: com.unionpay.mobile.android.global.a */
/* loaded from: classes2.dex */
public final class C4149a {

    /* renamed from: a */
    public static int f22112a = 48;

    /* renamed from: b */
    public static int f22113b = 8;

    /* renamed from: c */
    public static int f22114c = 4;

    /* renamed from: d */
    public static int f22115d = 12;

    /* renamed from: e */
    public static int f22116e = 8;

    /* renamed from: f */
    public static int f22117f = 8;

    /* renamed from: g */
    public static int f22118g = 4;

    /* renamed from: h */
    public static int f22119h = 8;

    /* renamed from: i */
    public static int f22120i = 2;

    /* renamed from: j */
    public static int f22121j = 16;

    /* renamed from: k */
    public static int f22122k = 52;

    /* renamed from: l */
    public static int f22123l = 320;

    /* renamed from: m */
    public static int f22124m = 32;

    /* renamed from: o */
    public static int f22126o = 45;

    /* renamed from: p */
    public static int f22127p = 35;

    /* renamed from: q */
    public static int f22128q = 40;

    /* renamed from: r */
    public static int f22129r = 54;

    /* renamed from: s */
    public static int f22130s = 10;

    /* renamed from: t */
    public static int f22131t = 0;

    /* renamed from: u */
    public static int f22132u = 28;

    /* renamed from: v */
    public static int f22133v = 30;

    /* renamed from: w */
    public static int f22134w = 22;

    /* renamed from: x */
    public static int f22135x = 40;

    /* renamed from: n */
    public static int f22125n = 54;

    /* renamed from: y */
    public static int f22136y = f22125n;

    /* renamed from: z */
    public static int f22137z = 46;

    /* renamed from: A */
    public static int f22097A = 45;

    /* renamed from: B */
    public static int f22098B = 32;

    /* renamed from: C */
    public static int f22099C = 6;

    /* renamed from: D */
    public static int f22100D = 25;

    /* renamed from: E */
    public static int f22101E = 95;

    /* renamed from: F */
    public static int f22102F = 25;

    /* renamed from: G */
    public static int f22103G = 25;

    /* renamed from: H */
    public static int f22104H = 1;

    /* renamed from: I */
    public static int f22105I = 0;

    /* renamed from: J */
    public static int f22106J = 5;

    /* renamed from: K */
    public static int f22107K = 1;

    /* renamed from: O */
    private static boolean f22111O = false;

    /* renamed from: L */
    public static boolean f22108L = true;

    /* renamed from: M */
    public static int f22109M = 0;

    /* renamed from: N */
    public static int f22110N = 0;

    /* renamed from: a */
    public static void m1610a(Context context) {
        C4150b.m1608a(context);
        if (f22111O) {
            return;
        }
        f22112a = C4386g.m858a(context, f22112a);
        f22113b = C4386g.m858a(context, f22113b);
        f22114c = C4386g.m858a(context, f22114c);
        f22115d = C4386g.m858a(context, f22115d);
        f22116e = C4386g.m858a(context, f22116e);
        f22117f = C4386g.m858a(context, f22117f);
        f22118g = C4386g.m858a(context, f22118g);
        f22119h = C4386g.m858a(context, f22119h);
        f22120i = C4386g.m858a(context, f22120i);
        f22121j = C4386g.m858a(context, f22121j);
        f22122k = C4386g.m858a(context, f22122k);
        f22124m = C4386g.m858a(context, f22124m);
        f22125n = C4386g.m858a(context, f22125n);
        f22126o = C4386g.m858a(context, f22126o);
        f22127p = C4386g.m858a(context, f22127p);
        f22128q = C4386g.m858a(context, f22128q);
        f22129r = C4386g.m858a(context, f22129r);
        f22130s = C4386g.m858a(context, f22130s);
        f22132u = C4386g.m858a(context, f22132u);
        f22133v = C4386g.m858a(context, f22133v);
        f22134w = C4386g.m858a(context, f22134w);
        f22137z = C4386g.m858a(context, f22137z);
        f22135x = C4386g.m858a(context, f22135x);
        f22097A = C4386g.m858a(context, f22097A);
        f22098B = C4386g.m858a(context, f22098B);
        f22099C = C4386g.m858a(context, f22099C);
        f22136y = C4386g.m858a(context, f22136y);
        f22100D = C4386g.m858a(context, f22100D);
        f22101E = C4386g.m858a(context, f22101E);
        f22102F = C4386g.m858a(context, f22102F);
        f22103G = C4386g.m858a(context, f22103G);
        f22104H = C4386g.m858a(context, f22104H);
        double d = context.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        f22107K = (int) (d + 0.5d);
        f22105I = context.getResources().getDisplayMetrics().widthPixels;
        f22131t = context.getResources().getDisplayMetrics().heightPixels;
        int i = f22105I;
        int i2 = f22131t;
        if (i > i2) {
            int i3 = i + i2;
            f22105I = i3;
            f22131t = i3 - i2;
            f22105I -= f22131t;
        }
        f22106J = C4386g.m858a(context, f22106J);
        f22111O = true;
    }

    /* renamed from: b */
    public static int m1609b(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("mz_action_button_min_height").get(cls.newInstance()).toString()));
        } catch (Exception unused) {
            return 0;
        }
    }
}
