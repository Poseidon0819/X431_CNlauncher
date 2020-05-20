package com.mopub.nativeads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Views;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.mopub.nativeads.be */
/* loaded from: classes2.dex */
public final class VisibilityTracker {
    @VisibleForTesting

    /* renamed from: a */
    final ViewTreeObserver.OnPreDrawListener f21121a;
    @VisibleForTesting

    /* renamed from: b */
    WeakReference<ViewTreeObserver> f21122b;

    /* renamed from: c */
    final Map<View, C3881a> f21123c;

    /* renamed from: d */
    final C3882b f21124d;

    /* renamed from: e */
    InterfaceC3884d f21125e;

    /* renamed from: f */
    boolean f21126f;

    /* renamed from: g */
    private final ArrayList<View> f21127g;

    /* renamed from: h */
    private long f21128h;

    /* renamed from: i */
    private final RunnableC3883c f21129i;

    /* renamed from: j */
    private final Handler f21130j;

    /* compiled from: VisibilityTracker.java */
    /* renamed from: com.mopub.nativeads.be$d */
    /* loaded from: classes2.dex */
    interface InterfaceC3884d {
        void onVisibilityChanged(List<View> list, List<View> list2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VisibilityTracker.java */
    /* renamed from: com.mopub.nativeads.be$a */
    /* loaded from: classes2.dex */
    public static class C3881a {

        /* renamed from: a */
        int f21131a;

        /* renamed from: b */
        int f21132b;

        /* renamed from: c */
        long f21133c;

        /* renamed from: d */
        View f21134d;

        C3881a() {
        }
    }

    public VisibilityTracker(Context context) {
        this(context, new WeakHashMap(10), new C3882b(), new Handler());
    }

    @VisibleForTesting
    private VisibilityTracker(Context context, Map<View, C3881a> map, C3882b c3882b, Handler handler) {
        this.f21128h = 0L;
        this.f21123c = map;
        this.f21124d = c3882b;
        this.f21130j = handler;
        this.f21129i = new RunnableC3883c();
        this.f21127g = new ArrayList<>(50);
        this.f21121a = new ViewTreeObserver$OnPreDrawListenerC3885bf(this);
        this.f21122b = new WeakReference<>(null);
        m2062a(context, null);
    }

    /* renamed from: a */
    private void m2062a(Context context, View view) {
        ViewTreeObserver viewTreeObserver = this.f21122b.get();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            View topmostView = Views.getTopmostView(context, view);
            if (topmostView == null) {
                MoPubLog.m2498d("Unable to set Visibility Tracker due to no available root view.");
                return;
            }
            ViewTreeObserver viewTreeObserver2 = topmostView.getViewTreeObserver();
            if (!viewTreeObserver2.isAlive()) {
                MoPubLog.m2490w("Visibility Tracker was unable to track views because the root view tree observer was not alive");
                return;
            }
            this.f21122b = new WeakReference<>(viewTreeObserver2);
            viewTreeObserver2.addOnPreDrawListener(this.f21121a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2060a(View view, View view2, int i) {
        m2059a(view, view2, i, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2059a(View view, View view2, int i, int i2) {
        m2062a(view2.getContext(), view2);
        C3881a c3881a = this.f21123c.get(view2);
        if (c3881a == null) {
            c3881a = new C3881a();
            this.f21123c.put(view2, c3881a);
            m2057c();
        }
        int min = Math.min(i2, i);
        c3881a.f21134d = view;
        c3881a.f21131a = i;
        c3881a.f21132b = min;
        long j = this.f21128h;
        c3881a.f21133c = j;
        this.f21128h = j + 1;
        long j2 = this.f21128h;
        if (j2 % 50 == 0) {
            m2063a(j2 - 50);
        }
    }

    /* renamed from: a */
    private void m2063a(long j) {
        for (Map.Entry<View, C3881a> entry : this.f21123c.entrySet()) {
            if (entry.getValue().f21133c < j) {
                this.f21127g.add(entry.getKey());
            }
        }
        Iterator<View> it = this.f21127g.iterator();
        while (it.hasNext()) {
            m2061a(it.next());
        }
        this.f21127g.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2061a(View view) {
        this.f21123c.remove(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2064a() {
        this.f21123c.clear();
        this.f21130j.removeMessages(0);
        this.f21126f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m2058b() {
        m2064a();
        ViewTreeObserver viewTreeObserver = this.f21122b.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f21121a);
        }
        this.f21122b.clear();
        this.f21125e = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m2057c() {
        if (this.f21126f) {
            return;
        }
        this.f21126f = true;
        this.f21130j.postDelayed(this.f21129i, 100L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VisibilityTracker.java */
    /* renamed from: com.mopub.nativeads.be$c */
    /* loaded from: classes2.dex */
    public class RunnableC3883c implements Runnable {

        /* renamed from: c */
        private final ArrayList<View> f21138c = new ArrayList<>();

        /* renamed from: b */
        private final ArrayList<View> f21137b = new ArrayList<>();

        RunnableC3883c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            VisibilityTracker visibilityTracker = VisibilityTracker.this;
            visibilityTracker.f21126f = false;
            for (Map.Entry<View, C3881a> entry : visibilityTracker.f21123c.entrySet()) {
                View key = entry.getKey();
                int i = entry.getValue().f21131a;
                int i2 = entry.getValue().f21132b;
                View view = entry.getValue().f21134d;
                if (VisibilityTracker.this.f21124d.m2056a(view, key, i)) {
                    this.f21137b.add(key);
                } else if (!VisibilityTracker.this.f21124d.m2056a(view, key, i2)) {
                    this.f21138c.add(key);
                }
            }
            if (VisibilityTracker.this.f21125e != null) {
                VisibilityTracker.this.f21125e.onVisibilityChanged(this.f21137b, this.f21138c);
            }
            this.f21137b.clear();
            this.f21138c.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VisibilityTracker.java */
    /* renamed from: com.mopub.nativeads.be$b */
    /* loaded from: classes2.dex */
    public static class C3882b {

        /* renamed from: a */
        private final Rect f21135a = new Rect();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public final boolean m2056a(View view, View view2, int i) {
            if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || !view2.getGlobalVisibleRect(this.f21135a)) {
                return false;
            }
            long height = this.f21135a.height() * this.f21135a.width();
            long height2 = view2.getHeight() * view2.getWidth();
            return height2 > 0 && height * 100 >= ((long) i) * height2;
        }
    }
}
