package com.cnlaunch.x431pro.widget.progress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.codec.TIFFConstants;

/* loaded from: classes.dex */
public class ProgressBarCircularIndeterminate extends CustomView {

    /* renamed from: e */
    int f16592e;

    /* renamed from: f */
    float f16593f;

    /* renamed from: g */
    float f16594g;

    /* renamed from: h */
    int f16595h;

    /* renamed from: i */
    boolean f16596i;

    /* renamed from: j */
    int f16597j;

    /* renamed from: k */
    int f16598k;

    /* renamed from: l */
    float f16599l;

    /* renamed from: m */
    int f16600m;

    public ProgressBarCircularIndeterminate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16592e = Color.parseColor("#DA251D");
        this.f16593f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16594g = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16595h = 0;
        this.f16596i = false;
        this.f16597j = 1;
        this.f16598k = 0;
        this.f16599l = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f16600m = 0;
        setThemeColor(context);
        setAttributes(attributeSet);
    }

    protected void setAttributes(AttributeSet attributeSet) {
        setMinimumHeight(C2923c.m4475a(32.0f, getResources()));
        setMinimumWidth(C2923c.m4475a(32.0f, getResources()));
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
        if (attributeResourceValue != -1) {
            setBackgroundColor(getResources().getColor(attributeResourceValue));
        } else {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "background", -1);
            if (attributeIntValue != -1) {
                setBackgroundColor(attributeIntValue);
            } else {
                setBackgroundColor(this.f16592e);
            }
        }
        setMinimumHeight(C2923c.m4475a(3.0f, getResources()));
    }

    /* renamed from: a */
    private int m4479a() {
        int i = this.f16592e;
        return Color.argb(128, (i >> 16) & 255, (i >> 8) & 255, (i >> 0) & 255);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cnlaunch.x431pro.widget.progress.CustomView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f16596i) {
            if (this.f16593f < getWidth() / 2) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setColor(m4479a());
                this.f16593f = this.f16593f >= ((float) (getWidth() / 2)) ? getWidth() / 2.0f : this.f16593f + 1.0f;
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f16593f, paint);
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                paint2.setColor(m4479a());
                canvas2.drawCircle(getWidth() / 2, getHeight() / 2, getHeight() / 2, paint2);
                Paint paint3 = new Paint();
                paint3.setAntiAlias(true);
                paint3.setColor(getResources().getColor(17170445));
                paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                if (this.f16595h >= 50) {
                    this.f16594g = this.f16594g >= ((float) (getWidth() / 2)) ? getWidth() / 2.0f : 1.0f + this.f16594g;
                } else {
                    this.f16594g = this.f16594g >= ((float) ((getWidth() / 2) - C2923c.m4475a(4.0f, getResources()))) ? (getWidth() / 2.0f) - C2923c.m4475a(4.0f, getResources()) : 1.0f + this.f16594g;
                }
                canvas2.drawCircle(getWidth() / 2, getHeight() / 2, this.f16594g, paint3);
                canvas.drawBitmap(createBitmap, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, new Paint());
                if (this.f16594g >= (getWidth() / 2) - C2923c.m4475a(4.0f, getResources())) {
                    this.f16595h++;
                }
                if (this.f16594g >= getWidth() / 2) {
                    this.f16596i = true;
                }
            }
        }
        if (this.f16595h > 0) {
            if (this.f16598k == this.f16600m) {
                this.f16597j += 6;
            }
            if (this.f16597j >= 290 || this.f16598k > this.f16600m) {
                this.f16598k += 6;
                this.f16597j -= 6;
            }
            int i = this.f16598k;
            if (i > this.f16600m + TIFFConstants.TIFFTAG_GRAYRESPONSEUNIT) {
                this.f16600m = i;
                this.f16598k = this.f16600m;
                this.f16597j = 1;
            }
            this.f16599l += 4.0f;
            canvas.rotate(this.f16599l, getWidth() / 2, getHeight() / 2);
            Bitmap createBitmap2 = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas3 = new Canvas(createBitmap2);
            Paint paint4 = new Paint();
            paint4.setAntiAlias(true);
            paint4.setColor(this.f16592e);
            canvas3.drawArc(new RectF(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, getWidth(), getHeight()), this.f16598k, this.f16597j, true, paint4);
            Paint paint5 = new Paint();
            paint5.setAntiAlias(true);
            paint5.setColor(getResources().getColor(17170445));
            paint5.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas3.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - C2923c.m4475a(4.0f, getResources()), paint5);
            canvas.drawBitmap(createBitmap2, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, new Paint());
        }
        invalidate();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(getResources().getColor(17170445));
        if (isEnabled()) {
            this.f16641b = this.f16592e;
        }
        this.f16592e = i;
    }

    private void setThemeColor(Context context) {
        int m9585b = PreferencesManager.m9595a(context).m9585b("theme_type", 0);
        if (m9585b == 3) {
            this.f16592e = Color.parseColor("#45B106");
        } else if (m9585b == 2) {
            this.f16592e = Color.parseColor("#394165");
        }
    }
}
