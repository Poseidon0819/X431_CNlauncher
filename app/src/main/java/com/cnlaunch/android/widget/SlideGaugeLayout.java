package com.cnlaunch.android.widget;

import android.content.Context;
import android.graphics.Point;
import android.support.p012v4.view.MotionEventCompat;
import android.support.p012v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SlideGaugeLayout extends RelativeLayout {

    /* renamed from: a */
    Map<View, Integer> f6732a;

    /* renamed from: b */
    Map<View, Integer> f6733b;

    /* renamed from: c */
    MeasureSubject f6734c;

    /* renamed from: d */
    private Map<View, Point> f6735d;

    /* renamed from: e */
    private MeasureResultObserver f6736e;

    /* renamed from: f */
    private ViewDragHelper f6737f;

    /* renamed from: g */
    private int f6738g;

    public SlideGaugeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private SlideGaugeLayout(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 0);
        this.f6735d = new HashMap();
        this.f6732a = new HashMap();
        this.f6733b = new HashMap();
        this.f6738g = 1;
        this.f6737f = ViewDragHelper.m14296a(this, 1.0f, new C1410a(this, (byte) 0));
    }

    public void setMeasureSubject(MeasureSubject measureSubject) {
        this.f6734c = measureSubject;
    }

    public void setMeasureResultObserver(MeasureResultObserver measureResultObserver) {
        this.f6736e = measureResultObserver;
    }

    /* renamed from: a */
    public final void m9642a(View view, int i, int i2) {
        this.f6735d.put(view, new Point(i, i2));
    }

    /* renamed from: com.cnlaunch.android.widget.SlideGaugeLayout$a */
    /* loaded from: classes.dex */
    class C1410a extends ViewDragHelper.AbstractC0321a {
        private C1410a() {
        }

        /* synthetic */ C1410a(SlideGaugeLayout slideGaugeLayout, byte b) {
            this();
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: a */
        public final boolean mo4740a(View view) {
            if (view.isShown()) {
                view.setPressed(true);
                view.bringToFront();
                SlideGaugeLayout.this.invalidate();
                return true;
            }
            return false;
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: a */
        public final int mo9637a(View view, int i) {
            if (!SlideGaugeLayout.this.m9644a()) {
                return view.getLeft();
            }
            SlideGaugeLayout slideGaugeLayout = SlideGaugeLayout.this;
            return Math.min(Math.max(i, Math.min((slideGaugeLayout.getPaddingLeft() + slideGaugeLayout.f6734c.mo7414c()) - (view.getWidth() / 2), !slideGaugeLayout.f6732a.containsKey(view) ? 1048575 : slideGaugeLayout.f6732a.get(view).intValue())), Math.max(slideGaugeLayout.f6734c.mo7413d() - (view.getWidth() / 2), !slideGaugeLayout.f6733b.containsKey(view) ? 0 : slideGaugeLayout.f6733b.get(view).intValue()));
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: b */
        public final int mo4736b(View view, int i) {
            if (SlideGaugeLayout.this.m9644a()) {
                return view.getTop();
            }
            SlideGaugeLayout slideGaugeLayout = SlideGaugeLayout.this;
            return Math.min(Math.max(i, Math.max((slideGaugeLayout.getPaddingTop() + slideGaugeLayout.f6734c.mo7419a()) - (view.getHeight() / 2), !slideGaugeLayout.f6732a.containsKey(view) ? 1048575 : slideGaugeLayout.f6732a.get(view).intValue())), Math.min(slideGaugeLayout.f6734c.mo7415b() - (view.getHeight() / 2), !slideGaugeLayout.f6733b.containsKey(view) ? 0 : slideGaugeLayout.f6733b.get(view).intValue()));
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: a */
        public final void mo4738a(View view, int i, int i2, int i3, int i4) {
            super.mo4738a(view, i, i2, i3, i4);
            if (SlideGaugeLayout.this.f6734c != null) {
                SlideGaugeLayout.this.m9643a(view, i2);
            }
        }

        @Override // android.support.p012v4.widget.ViewDragHelper.AbstractC0321a
        /* renamed from: a */
        public final void mo4739a(View view, float f, float f2) {
            SlideGaugeLayout.this.f6737f.m14304a(view.getLeft(), view.getTop());
            SlideGaugeLayout slideGaugeLayout = SlideGaugeLayout.this;
            int left = view.getLeft();
            int top = view.getTop();
            slideGaugeLayout.m9642a(view, left, top);
            slideGaugeLayout.m9643a(view, top);
            view.setPressed(false);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int m14414a = MotionEventCompat.m14414a(motionEvent);
        if (m14414a == 3 || m14414a == 1) {
            this.f6737f.m14295b();
            return false;
        }
        return this.f6737f.m14301a(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f6737f.m14289b(motionEvent);
        return this.f6737f.m14311a() != 0;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f6735d.isEmpty()) {
            return;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            Point point = this.f6735d.get(childAt);
            if (point != null) {
                childAt.layout(point.x, point.y, point.x + childAt.getMeasuredWidth(), point.y + childAt.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        MeasureResultObserver measureResultObserver = this.f6736e;
        if (measureResultObserver != null) {
            measureResultObserver.mo7364a();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        this.f6735d.remove(view);
        this.f6732a.remove(view);
        this.f6733b.remove(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        this.f6735d.clear();
        this.f6732a.clear();
        this.f6733b.clear();
        super.removeAllViews();
    }

    public void setDragOrient(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("orientation must be DRAG_HORIZONTAL or DRAG_VERTICAL!");
        }
        this.f6738g = i;
    }

    /* renamed from: a */
    public final boolean m9644a() {
        return this.f6738g == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m9643a(View view, int i) {
        if (this.f6736e == null || m9644a()) {
            return;
        }
        this.f6736e.mo7360a(this.f6734c, view, i);
    }

    /* renamed from: b */
    public final void m9639b(View view, int i, int i2) {
        this.f6732a.put(view, Integer.valueOf(i));
        this.f6733b.put(view, Integer.valueOf(i2));
    }
}
