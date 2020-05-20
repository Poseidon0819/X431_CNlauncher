package com.cnlaunch.golo3.p154a;

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
import com.cnlaunch.golo3.p154a.p155a.AbstractC1561d;
import com.cnlaunch.golo3.p154a.p156b.C1577c;
import com.cnlaunch.golo3.p154a.p156b.C1579d;
import com.cnlaunch.golo3.p154a.p156b.C1580e;
import com.cnlaunch.golo3.p154a.p156b.C1581f;
import com.cnlaunch.golo3.p154a.p157c.C1591b;
import com.cnlaunch.golo3.p154a.p157c.InterfaceC1590a;
import com.cnlaunch.golo3.p154a.p158d.C1593b;
import com.cnlaunch.golo3.p154a.p158d.InterfaceC1592a;
import com.cnlaunch.golo3.p154a.p159e.C1595b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: FinalBitmap.java */
/* renamed from: com.cnlaunch.golo3.a.a */
/* loaded from: classes.dex */
public final class C1551a {

    /* renamed from: a */
    public C1555d f7664a;

    /* renamed from: b */
    C1577c f7665b;

    /* renamed from: c */
    C1581f f7666c;

    /* renamed from: g */
    public Context f7670g;

    /* renamed from: i */
    private ExecutorService f7672i;

    /* renamed from: d */
    boolean f7667d = false;

    /* renamed from: e */
    boolean f7668e = false;

    /* renamed from: f */
    final Object f7669f = new Object();

    /* renamed from: h */
    private boolean f7671h = false;

    /* renamed from: j */
    private HashMap<String, C1580e> f7673j = new HashMap<>();

    public C1551a(Context context) {
        this.f7670g = context;
        this.f7664a = new C1555d(context);
        String absolutePath = C1595b.m9186a(context, "afinalCache").getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            this.f7664a.f7681a = absolutePath;
        }
        this.f7664a.f7682b = new C1591b();
        this.f7664a.f7683c = new C1593b();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m9255a(android.view.View r8, java.lang.String r9, com.cnlaunch.golo3.p154a.p156b.C1580e r10) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.golo3.p154a.C1551a.m9255a(android.view.View, java.lang.String, com.cnlaunch.golo3.a.b.e):void");
    }

    /* renamed from: a */
    public final void m9257a() {
        C1577c c1577c = this.f7665b;
        if (c1577c != null) {
            c1577c.m9228b();
        }
    }

    /* renamed from: b */
    public final void m9253b() {
        this.f7667d = true;
        m9254a(false);
    }

    /* renamed from: a */
    public final void m9254a(boolean z) {
        synchronized (this.f7669f) {
            this.f7668e = z;
            if (!this.f7668e) {
                this.f7669f.notifyAll();
            }
        }
    }

    /* renamed from: a */
    static C1553b m9256a(View view) {
        Drawable background;
        if (view != null) {
            if (view instanceof ImageView) {
                background = ((ImageView) view).getDrawable();
            } else {
                background = view.getBackground();
            }
            if (background instanceof C1552a) {
                return ((C1552a) background).f7674a.get();
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FinalBitmap.java */
    /* renamed from: com.cnlaunch.golo3.a.a$a */
    /* loaded from: classes.dex */
    public static class C1552a extends Drawable {

        /* renamed from: a */
        final WeakReference<C1553b> f7674a;

        /* renamed from: b */
        private final Drawable f7675b;

        public C1552a(Drawable drawable, C1553b c1553b) {
            this.f7675b = drawable;
            this.f7674a = new WeakReference<>(c1553b);
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.setAlpha(i);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return 127;
            }
            return drawable.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(int i, int i2, int i3, int i4) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.setBounds(i, i2, i3, i4);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(Rect rect) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.setBounds(rect);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setChangingConfigurations(int i) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.setChangingConfigurations(i);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getChangingConfigurations() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setDither(boolean z) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setFilterBitmap(boolean z) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void invalidateSelf() {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.invalidateSelf();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void scheduleSelf(Runnable runnable, long j) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.scheduleSelf(runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void unscheduleSelf(Runnable runnable) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.unscheduleSelf(runnable);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(int i, PorterDuff.Mode mode) {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.setColorFilter(i, mode);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final void clearColorFilter() {
            Drawable drawable = this.f7675b;
            if (drawable != null) {
                drawable.clearColorFilter();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean isStateful() {
            Drawable drawable = this.f7675b;
            return drawable != null && drawable.isStateful();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean setState(int[] iArr) {
            Drawable drawable = this.f7675b;
            return drawable != null && drawable.setState(iArr);
        }

        @Override // android.graphics.drawable.Drawable
        public final int[] getState() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return null;
            }
            return drawable.getState();
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable getCurrent() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return null;
            }
            return drawable.getCurrent();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean setVisible(boolean z, boolean z2) {
            Drawable drawable = this.f7675b;
            return drawable != null && drawable.setVisible(z, z2);
        }

        @Override // android.graphics.drawable.Drawable
        public final Region getTransparentRegion() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return null;
            }
            return drawable.getTransparentRegion();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumWidth() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getMinimumWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumHeight() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return 0;
            }
            return drawable.getMinimumHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean getPadding(Rect rect) {
            Drawable drawable = this.f7675b;
            return drawable != null && drawable.getPadding(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable mutate() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return null;
            }
            return drawable.mutate();
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable.ConstantState getConstantState() {
            Drawable drawable = this.f7675b;
            if (drawable == null) {
                return null;
            }
            return drawable.getConstantState();
        }
    }

    /* compiled from: FinalBitmap.java */
    /* renamed from: com.cnlaunch.golo3.a.a$c */
    /* loaded from: classes.dex */
    public class C1554c extends AbstractC1561d<Object, Void, Void> {
        private C1554c() {
        }

        public /* synthetic */ C1554c(C1551a c1551a, byte b) {
            this();
        }

        @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1561d
        /* renamed from: a */
        public final /* synthetic */ Void mo9238a(Object[] objArr) {
            switch (((Integer) objArr[0]).intValue()) {
                case 1:
                    C1551a c1551a = C1551a.this;
                    if (c1551a.f7665b != null) {
                        C1577c c1577c = c1551a.f7665b;
                        c1577c.m9228b();
                        c1577c.m9232a();
                        break;
                    }
                    break;
                case 2:
                    C1551a c1551a2 = C1551a.this;
                    if (c1551a2.f7665b != null) {
                        C1577c c1577c2 = c1551a2.f7665b;
                        if (c1577c2.f7730a != null) {
                            c1577c2.f7730a.close();
                        }
                        c1551a2.f7665b = null;
                        break;
                    }
                    break;
                case 3:
                    C1551a c1551a3 = C1551a.this;
                    if (c1551a3.f7665b != null) {
                        c1551a3.f7665b.m9232a();
                        break;
                    }
                    break;
                case 4:
                    C1551a c1551a4 = C1551a.this;
                    String valueOf = String.valueOf(objArr[1]);
                    if (c1551a4.f7665b != null) {
                        C1577c c1577c3 = c1551a4.f7665b;
                        if (c1577c3.f7731b != null) {
                            c1577c3.f7731b.mo9193b(valueOf);
                        }
                        c1577c3.m9231a(valueOf);
                        break;
                    }
                    break;
                case 5:
                    C1551a c1551a5 = C1551a.this;
                    String valueOf2 = String.valueOf(objArr[1]);
                    if (c1551a5.f7665b != null) {
                        c1551a5.f7665b.m9231a(valueOf2);
                        break;
                    }
                    break;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FinalBitmap.java */
    /* renamed from: com.cnlaunch.golo3.a.a$b */
    /* loaded from: classes.dex */
    public class C1553b extends AbstractC1561d<Object, Void, Bitmap> {

        /* renamed from: g */
        private Object f7677g;

        /* renamed from: h */
        private final WeakReference<View> f7678h;

        /* renamed from: i */
        private final C1580e f7679i;

        @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1561d
        /* renamed from: a */
        public final /* synthetic */ void mo9240a(Bitmap bitmap) {
            super.mo9240a((C1553b) bitmap);
            synchronized (C1551a.this.f7669f) {
                C1551a.this.f7669f.notifyAll();
            }
        }

        @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1561d
        /* renamed from: b */
        public final /* synthetic */ void mo9236b(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            bitmap2 = (this.f7710f.get() || C1551a.this.f7667d) ? null : null;
            View m9248b = m9248b();
            if (bitmap2 != null && m9248b != null) {
                C1551a.this.f7664a.f7682b.mo9191a(m9248b, bitmap2, this.f7679i);
            } else if (bitmap2 != null || m9248b == null) {
            } else {
                C1551a.this.f7664a.f7682b.mo9190a(m9248b, this.f7679i.f7744e);
            }
        }

        public C1553b(View view, C1580e c1580e) {
            this.f7678h = new WeakReference<>(view);
            this.f7679i = c1580e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.cnlaunch.golo3.p154a.p155a.AbstractC1561d
        /* renamed from: b */
        public Bitmap mo9238a(Object... objArr) {
            C1581f c1581f;
            byte[] mo9188a;
            this.f7677g = objArr[0];
            String valueOf = String.valueOf(this.f7677g);
            synchronized (C1551a.this.f7669f) {
                while (C1551a.this.f7668e && !this.f7710f.get()) {
                    try {
                        C1551a.this.f7669f.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            Bitmap bitmap = null;
            if (!this.f7710f.get() && m9248b() != null && !C1551a.this.f7667d) {
                C1551a c1551a = C1551a.this;
                C1580e c1580e = this.f7679i;
                if (c1551a.f7666c != null && (bitmap = (c1581f = c1551a.f7666c).m9223a(valueOf, c1580e)) == null && (mo9188a = c1581f.f7747a.mo9188a(valueOf)) != null && mo9188a.length > 0) {
                    if (c1580e != null) {
                        bitmap = C1579d.m9224a(mo9188a, 0, mo9188a.length, c1580e.f7740a, c1580e.f7741b);
                        c1581f.f7748b.m9229a(valueOf, mo9188a);
                    } else {
                        bitmap = BitmapFactory.decodeByteArray(mo9188a, 0, mo9188a.length);
                    }
                }
            }
            if (bitmap != null && C1551a.this.f7665b != null) {
                C1577c c1577c = C1551a.this.f7665b;
                if (valueOf != null && bitmap != null) {
                    c1577c.f7731b.mo9194a(valueOf, bitmap);
                }
            }
            return bitmap;
        }

        /* renamed from: b */
        private View m9248b() {
            View view = this.f7678h.get();
            if (this == C1551a.m9256a(view)) {
                return view;
            }
            return null;
        }
    }

    /* compiled from: FinalBitmap.java */
    /* renamed from: com.cnlaunch.golo3.a.a$d */
    /* loaded from: classes.dex */
    public class C1555d {

        /* renamed from: a */
        public String f7681a;

        /* renamed from: b */
        public InterfaceC1590a f7682b;

        /* renamed from: c */
        public InterfaceC1592a f7683c;

        /* renamed from: e */
        public float f7685e;

        /* renamed from: f */
        public int f7686f;

        /* renamed from: g */
        public int f7687g;

        /* renamed from: h */
        public int f7688h = 5;

        /* renamed from: i */
        public boolean f7689i = false;

        /* renamed from: d */
        public C1580e f7684d = new C1580e();

        public C1555d(Context context) {
            C1580e c1580e = this.f7684d;
            c1580e.f7742c = null;
            c1580e.f7743d = 1;
            int i = context.getResources().getDisplayMetrics().widthPixels / 2;
            C1580e c1580e2 = this.f7684d;
            c1580e2.f7741b = i;
            c1580e2.f7740a = i;
        }
    }
}
