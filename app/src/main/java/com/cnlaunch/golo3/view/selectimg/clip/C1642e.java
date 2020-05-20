package com.cnlaunch.golo3.view.selectimg.clip;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.cnlaunch.golo3.view.selectimg.clip.ClipImageView;

/* compiled from: ClipImageView.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.clip.e */
/* loaded from: classes.dex */
final class C1642e extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ ClipImageView f8674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1642e(ClipImageView clipImageView) {
        this.f8674a = clipImageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        boolean z;
        float f;
        float f2;
        float f3;
        z = this.f8674a.f8656n;
        if (z) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float scale = this.f8674a.getScale();
        f = this.f8674a.f8650h;
        if (scale < f) {
            ClipImageView clipImageView = this.f8674a;
            f3 = clipImageView.f8650h;
            clipImageView.postDelayed(new ClipImageView.RunnableC1637a(f3, x, y), 16L);
        } else {
            ClipImageView clipImageView2 = this.f8674a;
            f2 = clipImageView2.f8651i;
            clipImageView2.postDelayed(new ClipImageView.RunnableC1637a(f2, x, y), 16L);
        }
        this.f8674a.f8656n = true;
        return true;
    }
}
