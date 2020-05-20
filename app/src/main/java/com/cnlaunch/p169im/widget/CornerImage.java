package com.cnlaunch.p169im.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.cnlaunch.im.widget.CornerImage */
/* loaded from: classes.dex */
public class CornerImage extends ImageView {

    /* renamed from: a */
    private Paint f9338a;

    /* renamed from: b */
    private Paint f9339b;

    /* renamed from: c */
    private Bitmap f9340c;

    /* renamed from: d */
    private Path f9341d;

    /* renamed from: e */
    private Matrix f9342e;

    /* renamed from: f */
    private DisplayMetrics f9343f;

    /* renamed from: g */
    private int f9344g;

    /* renamed from: h */
    private int f9345h;

    /* renamed from: i */
    private boolean f9346i;

    public CornerImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9346i = false;
        this.f9338a = new Paint(1);
        this.f9338a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f9338a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f9339b = new Paint(1);
        this.f9341d = new Path();
        this.f9342e = new Matrix();
        this.f9343f = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.f9343f);
    }

    /* renamed from: a */
    public final void m8700a() {
        this.f9346i = true;
        this.f9344g = (int) (this.f9343f.widthPixels * 0.3f);
        this.f9345h = (int) (this.f9343f.widthPixels * 0.3f);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        Bitmap bitmap;
        float f;
        int i;
        int i2;
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            this.f9340c = ((BitmapDrawable) drawable).getBitmap();
            if (this.f9346i && (bitmap = this.f9340c) != null) {
                int width = bitmap.getWidth();
                int height = this.f9340c.getHeight();
                int i3 = this.f9344g;
                if (width >= i3 || height >= (i2 = this.f9345h)) {
                    int i4 = this.f9344g;
                    if (width > i4 && height < this.f9345h) {
                        f = i4 / width;
                    } else if (width >= this.f9344g || height <= (i = this.f9345h)) {
                        f = this.f9344g / width;
                        float f2 = this.f9345h / height;
                        if (f > f2) {
                            f = f2;
                        }
                    } else {
                        f = i / height;
                    }
                } else {
                    f = i3 / width;
                    float f3 = i2 / height;
                    if (f > f3) {
                        f = f3;
                    }
                }
                int i5 = (int) (width * f);
                int i6 = (int) (height * f);
                if (i5 > 0 && i6 > 0) {
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(i5, i6);
                    } else {
                        layoutParams.width = i5;
                        layoutParams.height = i6;
                    }
                    setLayoutParams(layoutParams);
                }
            }
        }
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                int width = getWidth();
                int height = getHeight();
                this.f9341d.reset();
                this.f9341d.setFillType(Path.FillType.EVEN_ODD);
                float f = width;
                float f2 = height;
                this.f9341d.addRoundRect(new RectF(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2), 10.0f, 10.0f, Path.Direction.CCW);
                this.f9341d.addRect(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2, Path.Direction.CCW);
                this.f9341d.close();
                if (drawable instanceof BitmapDrawable) {
                    canvas.saveLayerAlpha(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2, 255, 31);
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    if (bitmap != null) {
                        this.f9342e.reset();
                        this.f9342e.setScale(getWidth() / bitmap.getWidth(), getHeight() / bitmap.getHeight());
                        canvas.drawBitmap(bitmap, this.f9342e, this.f9339b);
                        canvas.drawPath(this.f9341d, this.f9338a);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                canvas.saveLayerAlpha(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2, 255, 31);
                super.onDraw(canvas);
                canvas.drawPath(this.f9341d, this.f9338a);
                canvas.restore();
            }
        } catch (Exception unused) {
            System.out.println("trying to use a recycled bitmap");
        }
    }
}
