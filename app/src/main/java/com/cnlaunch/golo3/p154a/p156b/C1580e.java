package com.cnlaunch.golo3.p154a.p156b;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.itextpdf.text.pdf.ColumnText;

/* compiled from: BitmapDisplayConfig.java */
/* renamed from: com.cnlaunch.golo3.a.b.e */
/* loaded from: classes.dex */
public final class C1580e {

    /* renamed from: a */
    public int f7740a;

    /* renamed from: b */
    public int f7741b;

    /* renamed from: c */
    public Animation f7742c;

    /* renamed from: d */
    public int f7743d;

    /* renamed from: e */
    public Drawable f7744e;

    /* renamed from: f */
    public Drawable f7745f;

    public C1580e() {
        if (this.f7742c == null) {
            this.f7742c = new AlphaAnimation((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f);
        }
    }
}
