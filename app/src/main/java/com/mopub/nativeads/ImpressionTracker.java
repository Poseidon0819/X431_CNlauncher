package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.VisibilityTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class ImpressionTracker {

    /* renamed from: a */
    private final VisibilityTracker f20769a;

    /* renamed from: b */
    private final Map<View, ImpressionInterface> f20770b;

    /* renamed from: c */
    private final Map<View, TimestampWrapper<ImpressionInterface>> f20771c;

    /* renamed from: d */
    private final Handler f20772d;

    /* renamed from: e */
    private final RunnableC3838a f20773e;

    /* renamed from: f */
    private final VisibilityTracker.C3882b f20774f;

    /* renamed from: g */
    private VisibilityTracker.InterfaceC3884d f20775g;

    public ImpressionTracker(Context context) {
        this(new WeakHashMap(), new WeakHashMap(), new VisibilityTracker.C3882b(), new VisibilityTracker(context), new Handler(Looper.getMainLooper()));
    }

    @VisibleForTesting
    private ImpressionTracker(Map<View, ImpressionInterface> map, Map<View, TimestampWrapper<ImpressionInterface>> map2, VisibilityTracker.C3882b c3882b, VisibilityTracker visibilityTracker, Handler handler) {
        this.f20770b = map;
        this.f20771c = map2;
        this.f20774f = c3882b;
        this.f20769a = visibilityTracker;
        this.f20775g = new C3886d(this);
        this.f20769a.f21125e = this.f20775g;
        this.f20772d = handler;
        this.f20773e = new RunnableC3838a();
    }

    public void addView(View view, ImpressionInterface impressionInterface) {
        if (this.f20770b.get(view) == impressionInterface) {
            return;
        }
        removeView(view);
        if (impressionInterface.isImpressionRecorded()) {
            return;
        }
        this.f20770b.put(view, impressionInterface);
        this.f20769a.m2060a(view, view, impressionInterface.getImpressionMinPercentageViewed());
    }

    public void removeView(View view) {
        this.f20770b.remove(view);
        this.f20771c.remove(view);
        this.f20769a.m2061a(view);
    }

    public void clear() {
        this.f20770b.clear();
        this.f20771c.clear();
        this.f20769a.m2064a();
        this.f20772d.removeMessages(0);
    }

    public void destroy() {
        clear();
        this.f20769a.m2058b();
        this.f20775g = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public final void m2195a() {
        if (this.f20772d.hasMessages(0)) {
            return;
        }
        this.f20772d.postDelayed(this.f20773e, 250L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.nativeads.ImpressionTracker$a */
    /* loaded from: classes2.dex */
    public class RunnableC3838a implements Runnable {

        /* renamed from: b */
        private final ArrayList<View> f20777b = new ArrayList<>();

        RunnableC3838a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (Map.Entry entry : ImpressionTracker.this.f20771c.entrySet()) {
                View view = (View) entry.getKey();
                TimestampWrapper timestampWrapper = (TimestampWrapper) entry.getValue();
                VisibilityTracker.C3882b unused = ImpressionTracker.this.f20774f;
                if (SystemClock.uptimeMillis() - timestampWrapper.f21120b >= ((long) ((ImpressionInterface) timestampWrapper.f21119a).getImpressionMinTimeViewed())) {
                    ((ImpressionInterface) timestampWrapper.f21119a).recordImpression(view);
                    ((ImpressionInterface) timestampWrapper.f21119a).setImpressionRecorded();
                    this.f20777b.add(view);
                }
            }
            Iterator<View> it = this.f20777b.iterator();
            while (it.hasNext()) {
                ImpressionTracker.this.removeView(it.next());
            }
            this.f20777b.clear();
            if (ImpressionTracker.this.f20771c.isEmpty()) {
                return;
            }
            ImpressionTracker.this.m2195a();
        }
    }
}
