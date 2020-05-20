package com.cnlaunch.gmap.p138a.p140b;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.gmap.a.b.e */
/* loaded from: classes.dex */
public final class BitmapDisplayConfig {

    /* renamed from: a */
    public int f7398a;

    /* renamed from: b */
    public int f7399b;

    /* renamed from: c */
    public Animation f7400c;

    /* renamed from: d */
    public int f7401d;

    /* renamed from: e */
    public Drawable f7402e;

    /* renamed from: f */
    public Drawable f7403f;

    public BitmapDisplayConfig() {
        if (this.f7400c == null) {
            this.f7400c = new AlphaAnimation((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f);
        }
    }
}
