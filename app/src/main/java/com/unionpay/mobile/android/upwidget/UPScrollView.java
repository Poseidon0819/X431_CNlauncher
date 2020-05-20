package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class UPScrollView extends ScrollView {

    /* renamed from: a */
    private WeakReference<InterfaceC4353a> f23049a;

    /* renamed from: b */
    private int f23050b;

    /* renamed from: c */
    private ViewTreeObserver.OnGlobalLayoutListener f23051c;

    /* renamed from: d */
    private Handler f23052d;

    /* renamed from: com.unionpay.mobile.android.upwidget.UPScrollView$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4353a {
        /* renamed from: e */
        void mo990e(int i);
    }

    public UPScrollView(Context context) {
        this(context, null);
    }

    public UPScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UPScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23052d = new HandlerC4377v(this);
        this.f23051c = new ViewTreeObserver$OnGlobalLayoutListenerC4376u(this);
    }

    /* renamed from: a */
    public final void m995a(InterfaceC4353a interfaceC4353a) {
        this.f23049a = new WeakReference<>(interfaceC4353a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f23051c);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this.f23051c);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        WeakReference<InterfaceC4353a> weakReference = this.f23049a;
        if (weakReference != null && weakReference.get() != null) {
            int scrollY = getScrollY();
            this.f23050b = scrollY;
            this.f23049a.get().mo990e(scrollY);
        }
        if (motionEvent.getAction() == 1) {
            Handler handler = this.f23052d;
            handler.sendMessageDelayed(handler.obtainMessage(), 5L);
        }
        return super.onTouchEvent(motionEvent);
    }
}
