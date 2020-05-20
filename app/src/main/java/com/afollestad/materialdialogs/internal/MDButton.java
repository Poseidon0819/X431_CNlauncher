package com.afollestad.materialdialogs.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import com.afollestad.materialdialogs.C0710c;
import com.afollestad.materialdialogs.GravityEnum;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class MDButton extends TextView {

    /* renamed from: a */
    private boolean f3441a;

    /* renamed from: b */
    private GravityEnum f3442b;

    /* renamed from: c */
    private int f3443c;

    /* renamed from: d */
    private Drawable f3444d;

    /* renamed from: e */
    private Drawable f3445e;

    public MDButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3441a = false;
        this.f3443c = context.getResources().getDimensionPixelSize(C0710c.C0712b.md_dialog_frame_margin);
        this.f3442b = GravityEnum.END;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m12574a(boolean z, boolean z2) {
        if (this.f3441a != z || z2) {
            setGravity(z ? this.f3442b.getGravityInt() | 16 : 17);
            if (Build.VERSION.SDK_INT >= 17) {
                setTextAlignment(z ? this.f3442b.getTextAlignment() : 4);
            }
            Drawable drawable = z ? this.f3444d : this.f3445e;
            if (Build.VERSION.SDK_INT < 16) {
                setBackgroundDrawable(drawable);
            } else {
                setBackground(drawable);
            }
            if (z) {
                setPadding(this.f3443c, getPaddingTop(), this.f3443c, getPaddingBottom());
            }
            this.f3441a = z;
        }
    }

    public void setStackedGravity(GravityEnum gravityEnum) {
        this.f3442b = gravityEnum;
    }

    public void setStackedSelector(Drawable drawable) {
        this.f3444d = drawable;
        if (this.f3441a) {
            m12574a(true, true);
        }
    }

    public void setDefaultSelector(Drawable drawable) {
        this.f3445e = drawable;
        if (this.f3441a) {
            return;
        }
        m12574a(false, true);
    }

    public void setAllCapsCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 14) {
            setAllCaps(z);
        } else if (z) {
            setTransformationMethod(new C0715a(getContext()));
        } else {
            setTransformationMethod(null);
        }
    }
}
