package com.cnlaunch.golo3.view.selectimg;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* renamed from: com.cnlaunch.golo3.view.selectimg.p */
/* loaded from: classes.dex */
public final class RotateBitmap {

    /* renamed from: a */
    Bitmap f8736a;

    /* renamed from: b */
    int f8737b = 0;

    public RotateBitmap(Bitmap bitmap) {
        this.f8736a = bitmap;
    }

    /* renamed from: a */
    public final Matrix m9014a() {
        Matrix matrix = new Matrix();
        if (this.f8737b != 0) {
            matrix.preTranslate(-(this.f8736a.getWidth() / 2), -(this.f8736a.getHeight() / 2));
            matrix.postRotate(this.f8737b);
            matrix.postTranslate(m9012c() / 2, m9013b() / 2);
        }
        return matrix;
    }

    /* renamed from: d */
    private boolean m9011d() {
        return (this.f8737b / 90) % 2 != 0;
    }

    /* renamed from: b */
    public final int m9013b() {
        if (m9011d()) {
            return this.f8736a.getWidth();
        }
        return this.f8736a.getHeight();
    }

    /* renamed from: c */
    public final int m9012c() {
        if (m9011d()) {
            return this.f8736a.getHeight();
        }
        return this.f8736a.getWidth();
    }
}
