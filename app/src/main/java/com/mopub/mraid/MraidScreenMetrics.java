package com.mopub.mraid;

import android.content.Context;
import android.graphics.Rect;
import com.mopub.common.util.Dips;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.mraid.z */
/* loaded from: classes.dex */
public final class MraidScreenMetrics {

    /* renamed from: a */
    final Rect f20737a = new Rect();

    /* renamed from: b */
    final Rect f20738b = new Rect();

    /* renamed from: c */
    final Rect f20739c = new Rect();

    /* renamed from: d */
    final Rect f20740d = new Rect();

    /* renamed from: e */
    final Rect f20741e = new Rect();

    /* renamed from: f */
    final Rect f20742f = new Rect();

    /* renamed from: g */
    final Rect f20743g = new Rect();

    /* renamed from: h */
    final Rect f20744h = new Rect();

    /* renamed from: i */
    private final Context f20745i;

    /* renamed from: j */
    private final float f20746j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MraidScreenMetrics(Context context, float f) {
        this.f20745i = context.getApplicationContext();
        this.f20746j = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2206a(Rect rect, Rect rect2) {
        rect2.set(Dips.pixelsToIntDips(rect.left, this.f20745i), Dips.pixelsToIntDips(rect.top, this.f20745i), Dips.pixelsToIntDips(rect.right, this.f20745i), Dips.pixelsToIntDips(rect.bottom, this.f20745i));
    }

    public final float getDensity() {
        return this.f20746j;
    }
}
