package com.cnlaunch.golo3.view.selectimg.clip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.cnlaunch.p132e.p133a.C1464a;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class ClipImageView extends ImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* renamed from: a */
    int f8643a;

    /* renamed from: b */
    int f8644b;

    /* renamed from: c */
    private final Paint f8645c;

    /* renamed from: d */
    private final int f8646d;

    /* renamed from: e */
    private String f8647e;

    /* renamed from: f */
    private int f8648f;

    /* renamed from: g */
    private float f8649g;

    /* renamed from: h */
    private float f8650h;

    /* renamed from: i */
    private float f8651i;

    /* renamed from: j */
    private final float[] f8652j;

    /* renamed from: k */
    private ScaleGestureDetector f8653k;

    /* renamed from: l */
    private final Matrix f8654l;

    /* renamed from: m */
    private GestureDetector f8655m;

    /* renamed from: n */
    private boolean f8656n;

    /* renamed from: o */
    private float f8657o;

    /* renamed from: p */
    private float f8658p;

    /* renamed from: q */
    private boolean f8659q;

    /* renamed from: r */
    private int f8660r;

    /* renamed from: s */
    private Rect f8661s;

    /* renamed from: t */
    private int f8662t;

    /* renamed from: u */
    private boolean f8663u;

    /* renamed from: v */
    private float f8664v;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8649g = 4.0f;
        this.f8650h = 2.0f;
        this.f8651i = 1.0f;
        this.f8652j = new float[9];
        this.f8653k = null;
        this.f8654l = new Matrix();
        this.f8661s = new Rect();
        this.f8662t = 0;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.f8655m = new GestureDetector(context, new C1642e(this));
        this.f8653k = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);
        this.f8645c = new Paint(1);
        this.f8645c.setColor(-1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1464a.C1472h.ClipImageView);
        this.f8643a = obtainStyledAttributes.getInteger(C1464a.C1472h.ClipImageView_civWidth, 1);
        this.f8644b = obtainStyledAttributes.getInteger(C1464a.C1472h.ClipImageView_civHeight, 1);
        this.f8648f = obtainStyledAttributes.getDimensionPixelSize(C1464a.C1472h.ClipImageView_civClipBorderWidth, 0);
        this.f8647e = obtainStyledAttributes.getString(C1464a.C1472h.ClipImageView_civTipText);
        this.f8646d = obtainStyledAttributes.getColor(C1464a.C1472h.ClipImageView_civMaskColor, -1308622848);
        this.f8663u = obtainStyledAttributes.getBoolean(C1464a.C1472h.ClipImageView_civClipCircle, false);
        this.f8664v = obtainStyledAttributes.getDimension(C1464a.C1472h.ClipImageView_civClipRoundCorner, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.f8645c.setTextSize(obtainStyledAttributes.getDimensionPixelSize(C1464a.C1472h.ClipImageView_civTipTextSize, 24));
        obtainStyledAttributes.recycle();
        this.f8645c.setDither(true);
    }

    /* renamed from: com.cnlaunch.golo3.view.selectimg.clip.ClipImageView$a */
    /* loaded from: classes.dex */
    class RunnableC1637a implements Runnable {

        /* renamed from: b */
        private float f8666b;

        /* renamed from: c */
        private float f8667c;

        /* renamed from: d */
        private float f8668d;

        /* renamed from: e */
        private float f8669e;

        public RunnableC1637a(float f, float f2, float f3) {
            this.f8666b = f;
            this.f8668d = f2;
            this.f8669e = f3;
            if (ClipImageView.this.getScale() < this.f8666b) {
                this.f8667c = 1.07f;
            } else {
                this.f8667c = 0.93f;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Matrix matrix = ClipImageView.this.f8654l;
            float f = this.f8667c;
            matrix.postScale(f, f, this.f8668d, this.f8669e);
            ClipImageView.this.m9034d();
            ClipImageView clipImageView = ClipImageView.this;
            clipImageView.setImageMatrix(clipImageView.f8654l);
            float scale = ClipImageView.this.getScale();
            if ((this.f8667c > 1.0f && scale < this.f8666b) || (this.f8667c < 1.0f && this.f8666b < scale)) {
                ClipImageView.this.postDelayed(this, 16L);
                return;
            }
            float f2 = this.f8666b / scale;
            ClipImageView.this.f8654l.postScale(f2, f2, this.f8668d, this.f8669e);
            ClipImageView.this.m9034d();
            ClipImageView clipImageView2 = ClipImageView.this;
            clipImageView2.setImageMatrix(clipImageView2.f8654l);
            ClipImageView.this.f8656n = false;
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() == null) {
            return true;
        }
        if ((scale < this.f8649g && scaleFactor > 1.0f) || (scale > this.f8651i && scaleFactor < 1.0f)) {
            float f = this.f8651i;
            if (scaleFactor * scale < f) {
                scaleFactor = f / scale;
            }
            float f2 = this.f8649g;
            if (scaleFactor * scale > f2) {
                scaleFactor = f2 / scale;
            }
            this.f8654l.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            m9034d();
            setImageMatrix(this.f8654l);
        }
        return true;
    }

    private RectF getMatrixRectF() {
        Matrix matrix = this.f8654l;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f8655m.onTouchEvent(motionEvent)) {
            return true;
        }
        this.f8653k.onTouchEvent(motionEvent);
        int pointerCount = motionEvent.getPointerCount();
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (int i = 0; i < pointerCount; i++) {
            f += motionEvent.getX(i);
            f2 += motionEvent.getY(i);
        }
        float f3 = pointerCount;
        float f4 = f / f3;
        float f5 = f2 / f3;
        if (pointerCount != this.f8660r) {
            this.f8659q = false;
            this.f8657o = f4;
            this.f8658p = f5;
        }
        this.f8660r = pointerCount;
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                this.f8660r = 0;
                break;
            case 2:
                float f6 = f4 - this.f8657o;
                float f7 = f5 - this.f8658p;
                if (!this.f8659q) {
                    this.f8659q = Math.sqrt((double) ((f6 * f6) + (f7 * f7))) >= 0.0d;
                }
                if (this.f8659q && getDrawable() != null) {
                    RectF matrixRectF = getMatrixRectF();
                    if (matrixRectF.width() <= this.f8661s.width()) {
                        f6 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    }
                    if (matrixRectF.height() <= this.f8661s.height()) {
                        f7 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    }
                    this.f8654l.postTranslate(f6, f7);
                    m9034d();
                    setImageMatrix(this.f8654l);
                }
                this.f8657o = f4;
                this.f8658p = f5;
                break;
        }
        return true;
    }

    public final float getScale() {
        this.f8654l.getValues(this.f8652j);
        return this.f8652j[0];
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        if (this.f8648f > width) {
            this.f8648f = width;
        }
        Rect rect = this.f8661s;
        rect.left = (width - this.f8648f) / 2;
        rect.right = rect.left + this.f8648f;
        int width2 = (this.f8661s.width() * this.f8644b) / this.f8643a;
        if (this.f8663u) {
            width2 = (this.f8661s.width() * 1) / 1;
        }
        Rect rect2 = this.f8661s;
        rect2.top = (height - width2) / 2;
        rect2.bottom = rect2.top + width2;
        m9041a();
    }

    public void setTip(String str) {
        this.f8647e = str;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m9036c();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        m9036c();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m9036c();
    }

    public void setmClipBorderWidth(int i) {
        this.f8648f = i;
    }

    public void setmDrawCircleFlag(boolean z) {
        this.f8663u = z;
    }

    /* renamed from: c */
    private void m9036c() {
        if (getWidth() != 0) {
            m9041a();
        } else {
            post(new RunnableC1643f(this));
        }
    }

    /* renamed from: a */
    public final void m9041a() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int width = this.f8661s.width();
        int height = this.f8661s.height();
        int width2 = getWidth();
        int height2 = getHeight();
        float f = intrinsicWidth * height > width * intrinsicHeight ? height / intrinsicHeight : width / intrinsicWidth;
        this.f8654l.setScale(f, f);
        this.f8654l.postTranslate((int) (((width2 - (intrinsicWidth * f)) * 0.5f) + 0.5f), (int) (((height2 - (intrinsicHeight * f)) * 0.5f) + 0.5f));
        setImageMatrix(this.f8654l);
        this.f8651i = f;
        float f2 = this.f8651i;
        this.f8650h = 2.0f * f2;
        this.f8649g = f2 * 4.0f;
    }

    /* renamed from: b */
    public final Bitmap m9038b() {
        Drawable drawable;
        Matrix matrix;
        Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        float[] fArr = new float[9];
        this.f8654l.getValues(fArr);
        float intrinsicWidth = (fArr[0] * drawable.getIntrinsicWidth()) / bitmap.getWidth();
        float f = fArr[2];
        float f2 = ((-f) + this.f8661s.left) / intrinsicWidth;
        float f3 = ((-fArr[5]) + this.f8661s.top) / intrinsicWidth;
        if (f2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (f3 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        float width = this.f8661s.width() / intrinsicWidth;
        float height = this.f8661s.height() / intrinsicWidth;
        int i = this.f8662t;
        if (i <= 0 || width <= i) {
            matrix = null;
        } else {
            float f4 = i / width;
            Matrix matrix2 = new Matrix();
            matrix2.setScale(f4, f4);
            matrix = matrix2;
        }
        return Bitmap.createBitmap(bitmap, (int) f2, (int) f3, (int) width, (int) height, matrix, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m9034d() {
        float f;
        RectF matrixRectF = getMatrixRectF();
        float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (matrixRectF.width() >= this.f8661s.width()) {
            f = matrixRectF.left > ((float) this.f8661s.left) ? (-matrixRectF.left) + this.f8661s.left : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            if (matrixRectF.right < this.f8661s.right) {
                f = this.f8661s.right - matrixRectF.right;
            }
        } else {
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (matrixRectF.height() >= this.f8661s.height()) {
            if (matrixRectF.top > this.f8661s.top) {
                f2 = this.f8661s.top + (-matrixRectF.top);
            }
            if (matrixRectF.bottom < this.f8661s.bottom) {
                f2 = this.f8661s.bottom - matrixRectF.bottom;
            }
        }
        this.f8654l.postTranslate(f, f2);
    }

    public Rect getClipBorder() {
        return this.f8661s;
    }

    public void setMaxOutputWidth(int i) {
        this.f8662t = i;
    }

    public float[] getClipMatrixValues() {
        float[] fArr = new float[9];
        this.f8654l.getValues(fArr);
        return fArr;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        getHeight();
        this.f8645c.setColor(this.f8646d);
        this.f8645c.setStyle(Paint.Style.FILL);
        this.f8645c.setStrokeWidth(1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        paint.setColor(0);
        canvas2.drawRect(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, canvas2.getWidth(), canvas2.getHeight(), this.f8645c);
        paint.setXfermode(porterDuffXfermode);
        this.f8645c.setColor(-1);
        if (this.f8663u) {
            float width2 = this.f8661s.left + (this.f8661s.width() / 2.0f);
            float height = this.f8661s.top + (this.f8661s.height() / 2.0f);
            float height2 = this.f8661s.height() / 2.0f;
            canvas2.drawCircle(width2, height, 1.0f + height2, this.f8645c);
            canvas2.drawCircle(width2, height, height2, paint);
        } else {
            RectF rectF = new RectF(this.f8661s.left - 1, this.f8661s.top - 1, this.f8661s.right + 1, this.f8661s.bottom + 1);
            float f = this.f8664v;
            canvas2.drawRoundRect(rectF, f, f, this.f8645c);
            RectF rectF2 = new RectF(this.f8661s.left, this.f8661s.top, this.f8661s.right, this.f8661s.bottom);
            float f2 = this.f8664v;
            canvas2.drawRoundRect(rectF2, f2, f2, paint);
        }
        canvas.drawBitmap(createBitmap, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, (Paint) null);
        String str = this.f8647e;
        if (str != null) {
            Paint.FontMetrics fontMetrics = this.f8645c.getFontMetrics();
            float f3 = (this.f8661s.bottom + (this.f8661s.top / 2)) - ((fontMetrics.descent - fontMetrics.ascent) / 2.0f);
            this.f8645c.setStyle(Paint.Style.FILL);
            String str2 = this.f8647e;
            canvas.drawText(str2, (width - this.f8645c.measureText(str)) / 2.0f, f3, this.f8645c);
        }
    }
}
