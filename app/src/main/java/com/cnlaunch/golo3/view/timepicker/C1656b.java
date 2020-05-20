package com.cnlaunch.golo3.view.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.mopub.nativeads.MoPubNativeAdPositioning;

/* compiled from: WheelView.java */
/* renamed from: com.cnlaunch.golo3.view.timepicker.b */
/* loaded from: classes.dex */
final class C1656b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    final /* synthetic */ WheelView f8776a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1656b(WheelView wheelView) {
        this.f8776a = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        boolean z;
        Scroller scroller;
        z = this.f8776a.f8742A;
        if (z) {
            scroller = this.f8776a.f8745D;
            scroller.forceFinished(true);
            this.f8776a.m8999d();
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        WheelView.m8998d(this.f8776a);
        WheelView.m9007a(this.f8776a, (int) (-f2));
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        int itemHeight;
        int i2;
        WheelAdapter wheelAdapter;
        int itemHeight2;
        int i3;
        Scroller scroller;
        int i4;
        WheelView wheelView = this.f8776a;
        i = wheelView.f8761l;
        itemHeight = this.f8776a.getItemHeight();
        int i5 = i * itemHeight;
        i2 = this.f8776a.f8743B;
        wheelView.f8746E = i5 + i2;
        if (this.f8776a.f8754b) {
            i3 = MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT;
        } else {
            wheelAdapter = this.f8776a.f8760k;
            int m8988a = wheelAdapter.m8988a();
            itemHeight2 = this.f8776a.getItemHeight();
            i3 = m8988a * itemHeight2;
        }
        int i6 = this.f8776a.f8754b ? -i3 : 0;
        scroller = this.f8776a.f8745D;
        i4 = this.f8776a.f8746E;
        scroller.fling(0, i4, 0, ((int) (-f2)) / 2, 0, 0, i6, i3);
        this.f8776a.setNextMessage(0);
        return true;
    }
}
