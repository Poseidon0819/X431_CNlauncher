package com.cnlaunch.golo3.view.selectimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.golo3.view.selectimg.l */
/* loaded from: classes.dex */
public abstract class ImageViewTouchBase extends ImageView {

    /* renamed from: a */
    private final Matrix f8714a;

    /* renamed from: b */
    private final float[] f8715b;

    /* renamed from: c */
    private InterfaceC1652a f8716c;

    /* renamed from: d */
    private Runnable f8717d;

    /* renamed from: f */
    protected Matrix f8718f;

    /* renamed from: g */
    protected Matrix f8719g;

    /* renamed from: h */
    public final RotateBitmap f8720h;

    /* renamed from: i */
    int f8721i;

    /* renamed from: j */
    int f8722j;

    /* renamed from: k */
    float f8723k;

    /* renamed from: l */
    protected int f8724l;

    /* renamed from: m */
    protected Handler f8725m;

    /* compiled from: ImageViewTouchBase.java */
    /* renamed from: com.cnlaunch.golo3.view.selectimg.l$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1652a {
    }

    public void setRecycler(InterfaceC1652a interfaceC1652a) {
        this.f8716c = interfaceC1652a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f8721i = i3 - i;
        this.f8722j = i4 - i2;
        Runnable runnable = this.f8717d;
        if (runnable != null) {
            this.f8717d = null;
            runnable.run();
        }
        if (this.f8720h.f8736a != null) {
            m9019a(this.f8720h, this.f8718f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || getScale() <= 1.0f) {
            return super.onKeyDown(i, keyEvent);
        }
        mo9021a(1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m9020a(bitmap, 0);
    }

    /* renamed from: a */
    private void m9020a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        RotateBitmap rotateBitmap = this.f8720h;
        rotateBitmap.f8736a = bitmap;
        rotateBitmap.f8737b = i;
    }

    public final void setImageBitmapResetBase$1fdc9e65(Bitmap bitmap) {
        m9018a(new RotateBitmap(bitmap), true);
    }

    /* renamed from: a */
    public final void m9018a(RotateBitmap rotateBitmap, boolean z) {
        if (getWidth() <= 0) {
            this.f8717d = new RunnableC1653m(this, rotateBitmap, z);
            return;
        }
        if (rotateBitmap.f8736a != null) {
            m9019a(rotateBitmap, this.f8718f);
            m9020a(rotateBitmap.f8736a, rotateBitmap.f8737b);
        } else {
            this.f8718f.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f8719g.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.f8723k = m9017b();
    }

    /* renamed from: a */
    public final void m9023a() {
        float height;
        if (this.f8720h.f8736a == null) {
            return;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        RectF rectF = new RectF(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f8720h.f8736a.getWidth(), this.f8720h.f8736a.getHeight());
        imageViewMatrix.mapRect(rectF);
        float height2 = rectF.height();
        float width = rectF.width();
        float height3 = getHeight();
        if (height2 < height3) {
            height = ((height3 - height2) / 2.0f) - rectF.top;
        } else if (rectF.top > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            height = -rectF.top;
        } else {
            height = rectF.bottom < height3 ? getHeight() - rectF.bottom : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        float width2 = getWidth();
        if (width < width2) {
            f = ((width2 - width) / 2.0f) - rectF.left;
        } else if (rectF.left > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f = -rectF.left;
        } else if (rectF.right < width2) {
            f = width2 - rectF.right;
        }
        mo9022a(f, height);
        setImageMatrix(getImageViewMatrix());
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8718f = new Matrix();
        this.f8719g = new Matrix();
        this.f8714a = new Matrix();
        this.f8715b = new float[9];
        this.f8720h = new RotateBitmap(null);
        this.f8721i = -1;
        this.f8722j = -1;
        this.f8724l = 0;
        this.f8725m = new Handler();
        this.f8717d = null;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public float getScale() {
        this.f8719g.getValues(this.f8715b);
        return this.f8715b[0];
    }

    /* renamed from: a */
    private void m9019a(RotateBitmap rotateBitmap, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float m9012c = rotateBitmap.m9012c();
        float m9013b = rotateBitmap.m9013b();
        matrix.reset();
        float min = Math.min(Math.min(width / m9012c, 2.0f), Math.min(height / m9013b, 2.0f));
        matrix.postConcat(rotateBitmap.m9014a());
        matrix.postScale(min, min);
        matrix.postTranslate((width - (m9012c * min)) / 2.0f, (height - (m9013b * min)) / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Matrix getImageViewMatrix() {
        this.f8714a.set(this.f8718f);
        this.f8714a.postConcat(this.f8719g);
        return this.f8714a;
    }

    /* renamed from: b */
    private float m9017b() {
        if (this.f8720h.f8736a == null) {
            return 1.0f;
        }
        float max = Math.max(this.f8720h.m9012c() / this.f8721i, this.f8720h.m9013b() / this.f8722j) * 4.0f;
        if (max < 1.0f) {
            return 1.0f;
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9021a(float f, float f2, float f3) {
        float f4 = this.f8723k;
        if (f > f4) {
            f = f4;
        }
        float scale = f / getScale();
        this.f8719g.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        m9023a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m9015b(float f, float f2, float f3) {
        float scale = (f - getScale()) / 300.0f;
        float scale2 = getScale();
        this.f8725m.post(new RunnableC1654n(this, System.currentTimeMillis(), scale2, scale, f2, f3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9022a(float f, float f2) {
        this.f8719g.postTranslate(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m9016b(float f, float f2) {
        mo9022a(f, f2);
        setImageMatrix(getImageViewMatrix());
    }
}
