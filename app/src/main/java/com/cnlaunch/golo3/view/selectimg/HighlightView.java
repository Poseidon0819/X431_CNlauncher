package com.cnlaunch.golo3.view.selectimg;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.cnlaunch.p132e.p133a.C1464a;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.golo3.view.selectimg.k */
/* loaded from: classes.dex */
public final class HighlightView {

    /* renamed from: a */
    View f8697a;

    /* renamed from: b */
    public boolean f8698b;

    /* renamed from: c */
    boolean f8699c;

    /* renamed from: e */
    public Rect f8701e;

    /* renamed from: f */
    public RectF f8702f;

    /* renamed from: g */
    public RectF f8703g;

    /* renamed from: h */
    public Matrix f8704h;

    /* renamed from: j */
    float f8706j;

    /* renamed from: l */
    Drawable f8708l;

    /* renamed from: m */
    Drawable f8709m;

    /* renamed from: d */
    int f8700d = EnumC1651a.None$20488b3f;

    /* renamed from: i */
    boolean f8705i = false;

    /* renamed from: k */
    boolean f8707k = false;

    /* renamed from: n */
    final Paint f8710n = new Paint();

    /* renamed from: o */
    final Paint f8711o = new Paint();

    /* renamed from: p */
    final Paint f8712p = new Paint();

    public HighlightView(View view) {
        this.f8697a = view;
    }

    /* renamed from: c */
    private void m9024c() {
        Resources resources = this.f8697a.getResources();
        this.f8708l = resources.getDrawable(C1464a.C1467c.gl_indicator_autocrop);
        this.f8709m = resources.getDrawable(C1464a.C1467c.gl_indicator_autocrop2);
    }

    /* renamed from: a */
    public final void m9027a(int i) {
        if (i != this.f8700d) {
            this.f8700d = i;
            this.f8697a.invalidate();
        }
    }

    /* renamed from: a */
    public final int m9028a(float f, float f2) {
        Rect m9029a = m9029a();
        if (this.f8707k) {
            float centerX = f - m9029a.centerX();
            float centerY = f2 - m9029a.centerY();
            int sqrt = (int) Math.sqrt((centerX * centerX) + (centerY * centerY));
            int width = this.f8701e.width() / 2;
            return ((float) Math.abs(sqrt - width)) <= 20.0f ? Math.abs(centerY) > Math.abs(centerX) ? centerY < ColumnText.GLOBAL_SPACE_CHAR_RATIO ? 8 : 16 : centerX < ColumnText.GLOBAL_SPACE_CHAR_RATIO ? 2 : 4 : sqrt < width ? 32 : 1;
        }
        boolean z = false;
        boolean z2 = f2 >= ((float) m9029a.top) - 20.0f && f2 < ((float) m9029a.bottom) + 20.0f;
        if (f >= m9029a.left - 20.0f && f < m9029a.right + 20.0f) {
            z = true;
        }
        int i = (Math.abs(((float) m9029a.left) - f) >= 20.0f || !z2) ? 1 : 3;
        if (Math.abs(m9029a.right - f) < 20.0f && z2) {
            i |= 4;
        }
        if (Math.abs(m9029a.top - f2) < 20.0f && z) {
            i |= 8;
        }
        int i2 = (Math.abs(((float) m9029a.bottom) - f2) >= 20.0f || !z) ? i : i | 16;
        if (i2 == 1 && m9029a.contains((int) f, (int) f2)) {
            return 32;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final Rect m9029a() {
        RectF rectF = new RectF(this.f8703g.left, this.f8703g.top, this.f8703g.right, this.f8703g.bottom);
        this.f8704h.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    /* renamed from: b */
    public final void m9025b() {
        this.f8701e = m9029a();
    }

    /* renamed from: a */
    public final void m9026a(Matrix matrix, Rect rect, RectF rectF) {
        this.f8704h = new Matrix(matrix);
        this.f8703g = rectF;
        this.f8702f = new RectF(rect);
        this.f8705i = true;
        this.f8707k = false;
        this.f8706j = this.f8703g.width() / this.f8703g.height();
        this.f8701e = m9029a();
        this.f8710n.setARGB(125, 50, 50, 50);
        this.f8711o.setARGB(125, 50, 50, 50);
        this.f8712p.setStrokeWidth(3.0f);
        this.f8712p.setStyle(Paint.Style.STROKE);
        this.f8712p.setAntiAlias(true);
        this.f8700d = EnumC1651a.None$20488b3f;
        m9024c();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: HighlightView.java */
    /* renamed from: com.cnlaunch.golo3.view.selectimg.k$a */
    /* loaded from: classes.dex */
    public static final class EnumC1651a {
        public static final int None$20488b3f = 1;
        public static final int Move$20488b3f = 2;
        public static final int Grow$20488b3f = 3;

        /* renamed from: a */
        private static final /* synthetic */ int[] f8713a = {None$20488b3f, Move$20488b3f, Grow$20488b3f};

        public static int[] values$348523b9() {
            return (int[]) f8713a.clone();
        }
    }
}
