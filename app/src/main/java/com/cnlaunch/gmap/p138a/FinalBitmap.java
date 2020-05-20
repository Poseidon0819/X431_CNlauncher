package com.cnlaunch.gmap.p138a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.cnlaunch.gmap.p138a.p139a.AsyncTask;
import com.cnlaunch.gmap.p138a.p140b.BitmapCache;
import com.cnlaunch.gmap.p138a.p140b.BitmapDisplayConfig;
import com.cnlaunch.gmap.p138a.p140b.BitmapProcess;
import com.cnlaunch.gmap.p138a.p140b.C1504d;
import com.cnlaunch.gmap.p138a.p140b.C1506h;
import com.cnlaunch.gmap.p138a.p141c.Displayer;
import com.cnlaunch.gmap.p138a.p141c.SimpleDisplayer;
import com.cnlaunch.gmap.p138a.p142d.Downloader;
import com.cnlaunch.gmap.p138a.p142d.SimpleDownloader;
import com.cnlaunch.gmap.p138a.p144f.Utils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* renamed from: com.cnlaunch.gmap.a.a */
/* loaded from: classes.dex */
public final class FinalBitmap {

    /* renamed from: a */
    C1486c f7323a;

    /* renamed from: b */
    BitmapCache f7324b;

    /* renamed from: c */
    BitmapProcess f7325c;

    /* renamed from: g */
    private Context f7329g;

    /* renamed from: i */
    private ExecutorService f7331i;

    /* renamed from: d */
    boolean f7326d = false;

    /* renamed from: e */
    boolean f7327e = false;

    /* renamed from: f */
    final Object f7328f = new Object();

    /* renamed from: h */
    private boolean f7330h = false;

    /* renamed from: j */
    private HashMap<String, BitmapDisplayConfig> f7332j = new HashMap<>();

    public FinalBitmap(Context context) {
        this.f7329g = context;
        this.f7323a = new C1486c(context);
        String absolutePath = Utils.m9348a(context, "afinalCache").getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            this.f7323a.f7339a = absolutePath;
        }
        this.f7323a.f7340b = new SimpleDisplayer();
        this.f7323a.f7341c = new SimpleDownloader();
    }

    /* renamed from: a */
    static C1485b m9410a(View view) {
        Drawable background;
        if (view != null) {
            if (view instanceof ImageView) {
                background = ((ImageView) view).getDrawable();
            } else {
                background = view.getBackground();
            }
            if (background instanceof C1484a) {
                return ((C1484a) background).m9408a();
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FinalBitmap.java */
    /* renamed from: com.cnlaunch.gmap.a.a$a */
    /* loaded from: classes.dex */
    public static class C1484a extends Drawable {

        /* renamed from: a */
        private final WeakReference<C1485b> f7333a;

        /* renamed from: b */
        private final Drawable f7334b;

        public C1484a(Drawable drawable, C1485b c1485b) {
            this.f7334b = drawable;
            this.f7333a = new WeakReference<>(c1485b);
        }

        /* renamed from: a */
        public final C1485b m9408a() {
            return this.f7333a.get();
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return 127;
            }
            return drawable.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(int i, int i2, int i3, int i4) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.setBounds(i, i2, i3, i4);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(Rect rect) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setChangingConfigurations(int i) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.setChangingConfigurations(i);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getChangingConfigurations() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setDither(boolean z) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setFilterBitmap(boolean z) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void invalidateSelf() {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void scheduleSelf(Runnable runnable, long j) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void unscheduleSelf(Runnable runnable) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.unscheduleSelf(runnable);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(int i, PorterDuff.Mode mode) {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.setColorFilter(i, mode);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void clearColorFilter() {
            Drawable drawable = this.f7334b;
            if (drawable != null) {
                drawable.clearColorFilter();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean isStateful() {
            Drawable drawable = this.f7334b;
            return drawable != null && drawable.isStateful();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean setState(int[] iArr) {
            Drawable drawable = this.f7334b;
            return drawable != null && drawable.setState(iArr);
        }

        @Override // android.graphics.drawable.Drawable
        public final int[] getState() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return null;
            }
            return drawable.getState();
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable getCurrent() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return null;
            }
            return drawable.getCurrent();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean setVisible(boolean z, boolean z2) {
            Drawable drawable = this.f7334b;
            return drawable != null && drawable.setVisible(z, z2);
        }

        @Override // android.graphics.drawable.Drawable
        public final Region getTransparentRegion() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return null;
            }
            return drawable.getTransparentRegion();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumWidth() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getMinimumWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumHeight() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getMinimumHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean getPadding(Rect rect) {
            Drawable drawable = this.f7334b;
            return drawable != null && drawable.getPadding(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable mutate() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return null;
            }
            return drawable.mutate();
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable.ConstantState getConstantState() {
            Drawable drawable = this.f7334b;
            if (drawable == null) {
                return null;
            }
            return drawable.getConstantState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FinalBitmap.java */
    /* renamed from: com.cnlaunch.gmap.a.a$b */
    /* loaded from: classes.dex */
    public class C1485b extends AsyncTask<Object, Void, Bitmap> {

        /* renamed from: i */
        private Object f7336i;

        /* renamed from: j */
        private final WeakReference<View> f7337j;

        /* renamed from: k */
        private final BitmapDisplayConfig f7338k;

        @Override // com.cnlaunch.gmap.p138a.p139a.AsyncTask
        /* renamed from: a */
        public final /* synthetic */ void mo9396a(Bitmap bitmap) {
            super.mo9396a((C1485b) bitmap);
            synchronized (FinalBitmap.this.f7328f) {
                FinalBitmap.this.f7328f.notifyAll();
            }
        }

        @Override // com.cnlaunch.gmap.p138a.p139a.AsyncTask
        /* renamed from: b */
        public final /* synthetic */ void mo9393b(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            bitmap2 = (this.f7371h.get() || FinalBitmap.this.f7326d) ? null : null;
            View m9407a = m9407a();
            if (bitmap2 != null && m9407a != null) {
                FinalBitmap.this.f7323a.f7340b.mo9358a(m9407a, bitmap2, this.f7338k);
            } else if (bitmap2 != null || m9407a == null) {
            } else {
                FinalBitmap.this.f7323a.f7340b.mo9357a(m9407a, this.f7338k.f7402e);
            }
        }

        public C1485b(View view, BitmapDisplayConfig bitmapDisplayConfig) {
            this.f7337j = new WeakReference<>(view);
            this.f7338k = bitmapDisplayConfig;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.cnlaunch.gmap.p138a.p139a.AsyncTask
        /* renamed from: b */
        public Bitmap mo9395a(Object... objArr) {
            BitmapProcess bitmapProcess;
            byte[] mo9355a;
            C1506h c1506h;
            byte[] array;
            this.f7336i = objArr[0];
            String valueOf = String.valueOf(this.f7336i);
            synchronized (FinalBitmap.this.f7328f) {
                while (FinalBitmap.this.f7327e && !this.f7371h.get()) {
                    try {
                        FinalBitmap.this.f7328f.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            Bitmap bitmap = null;
            if (!this.f7371h.get() && m9407a() != null && !FinalBitmap.this.f7326d) {
                FinalBitmap finalBitmap = FinalBitmap.this;
                BitmapDisplayConfig bitmapDisplayConfig = this.f7338k;
                if (finalBitmap.f7325c != null && (bitmap = (bitmapProcess = finalBitmap.f7325c).m9384a(valueOf, bitmapDisplayConfig)) == null && (mo9355a = bitmapProcess.f7405a.mo9355a(valueOf)) != null && mo9355a.length > 0) {
                    if (bitmapDisplayConfig != null) {
                        bitmap = C1504d.m9385a(mo9355a, 0, mo9355a.length, bitmapDisplayConfig.f7398a, bitmapDisplayConfig.f7399b);
                        BitmapCache bitmapCache = bitmapProcess.f7406b;
                        if (bitmapCache.f7388a != null && valueOf != null && mo9355a != null) {
                            byte[] m9346a = Utils.m9346a(valueOf);
                            long m9345a = Utils.m9345a(m9346a);
                            ByteBuffer allocate = ByteBuffer.allocate(m9346a.length + mo9355a.length);
                            allocate.put(m9346a);
                            allocate.put(mo9355a);
                            synchronized (bitmapCache.f7388a) {
                                try {
                                    c1506h = bitmapCache.f7388a;
                                    array = allocate.array();
                                } catch (IOException unused2) {
                                }
                                if (array.length + 24 > c1506h.f7415b) {
                                    throw new RuntimeException("blob is too large!");
                                }
                                if (c1506h.f7418e + 20 + array.length > c1506h.f7415b || c1506h.f7417d * 2 >= c1506h.f7414a) {
                                    c1506h.f7416c = 1 - c1506h.f7416c;
                                    c1506h.f7417d = 0;
                                    c1506h.f7418e = 4;
                                    C1506h.m9372a(c1506h.f7420g, 12, c1506h.f7416c);
                                    C1506h.m9372a(c1506h.f7420g, 16, c1506h.f7417d);
                                    C1506h.m9372a(c1506h.f7420g, 20, c1506h.f7418e);
                                    c1506h.m9370b();
                                    c1506h.m9381a();
                                    c1506h.m9380a(c1506h.f7419f);
                                    c1506h.m9368c();
                                }
                                if (!c1506h.m9379a(m9345a, c1506h.f7419f)) {
                                    c1506h.f7417d++;
                                    C1506h.m9372a(c1506h.f7420g, 16, c1506h.f7417d);
                                }
                                c1506h.m9378a(m9345a, array, array.length);
                                c1506h.m9370b();
                            }
                        }
                    } else {
                        bitmap = BitmapFactory.decodeByteArray(mo9355a, 0, mo9355a.length);
                    }
                }
            }
            if (bitmap != null && FinalBitmap.this.f7324b != null) {
                BitmapCache bitmapCache2 = FinalBitmap.this.f7324b;
                if (valueOf != null && bitmap != null) {
                    bitmapCache2.f7389b.mo9360a(valueOf, bitmap);
                }
            }
            return bitmap;
        }

        /* renamed from: a */
        private View m9407a() {
            View view = this.f7337j.get();
            if (this == FinalBitmap.m9410a(view)) {
                return view;
            }
            return null;
        }
    }

    /* compiled from: FinalBitmap.java */
    /* renamed from: com.cnlaunch.gmap.a.a$c */
    /* loaded from: classes.dex */
    class C1486c {

        /* renamed from: a */
        public String f7339a;

        /* renamed from: b */
        public Displayer f7340b;

        /* renamed from: c */
        public Downloader f7341c;

        /* renamed from: e */
        public float f7343e;

        /* renamed from: f */
        public int f7344f;

        /* renamed from: g */
        public int f7345g;

        /* renamed from: h */
        public int f7346h = 5;

        /* renamed from: i */
        public boolean f7347i = false;

        /* renamed from: d */
        public BitmapDisplayConfig f7342d = new BitmapDisplayConfig();

        public C1486c(Context context) {
            BitmapDisplayConfig bitmapDisplayConfig = this.f7342d;
            bitmapDisplayConfig.f7400c = null;
            bitmapDisplayConfig.f7401d = 1;
            int i = context.getResources().getDisplayMetrics().widthPixels / 2;
            BitmapDisplayConfig bitmapDisplayConfig2 = this.f7342d;
            bitmapDisplayConfig2.f7399b = i;
            bitmapDisplayConfig2.f7398a = i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v6, types: [Params[], java.lang.Object[]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m9409a(android.view.View r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.gmap.p138a.FinalBitmap.m9409a(android.view.View, java.lang.String):void");
    }
}
