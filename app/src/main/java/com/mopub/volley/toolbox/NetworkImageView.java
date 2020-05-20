package com.mopub.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mopub.volley.toolbox.ImageLoader;

/* loaded from: classes2.dex */
public class NetworkImageView extends ImageView {

    /* renamed from: a */
    private String f21348a;

    /* renamed from: b */
    private int f21349b;

    /* renamed from: c */
    private int f21350c;

    /* renamed from: d */
    private ImageLoader f21351d;

    /* renamed from: e */
    private ImageLoader.ImageContainer f21352e;

    public NetworkImageView(Context context) {
        this(context, null);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageUrl(String str, ImageLoader imageLoader) {
        this.f21348a = str;
        this.f21351d = imageLoader;
        m1976a(false);
    }

    public void setDefaultImageResId(int i) {
        this.f21349b = i;
    }

    public void setErrorImageResId(int i) {
        this.f21350c = i;
    }

    /* renamed from: a */
    private void m1976a(boolean z) {
        boolean z2;
        boolean z3;
        int width = getWidth();
        int height = getHeight();
        boolean z4 = true;
        if (getLayoutParams() != null) {
            z2 = getLayoutParams().width == -2;
            z3 = getLayoutParams().height == -2;
        } else {
            z2 = false;
            z3 = false;
        }
        z4 = (z2 && z3) ? false : false;
        if (width == 0 && height == 0 && !z4) {
            return;
        }
        if (TextUtils.isEmpty(this.f21348a)) {
            ImageLoader.ImageContainer imageContainer = this.f21352e;
            if (imageContainer != null) {
                imageContainer.cancelRequest();
                this.f21352e = null;
            }
            m1978a();
            return;
        }
        ImageLoader.ImageContainer imageContainer2 = this.f21352e;
        if (imageContainer2 != null && imageContainer2.getRequestUrl() != null) {
            if (this.f21352e.getRequestUrl().equals(this.f21348a)) {
                return;
            }
            this.f21352e.cancelRequest();
            m1978a();
        }
        if (z2) {
            width = 0;
        }
        if (z3) {
            height = 0;
        }
        this.f21352e = this.f21351d.get(this.f21348a, new C3933f(this, z), width, height);
    }

    /* renamed from: a */
    private void m1978a() {
        int i = this.f21349b;
        if (i != 0) {
            setImageResource(i);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m1976a(true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        ImageLoader.ImageContainer imageContainer = this.f21352e;
        if (imageContainer != null) {
            imageContainer.cancelRequest();
            setImageBitmap(null);
            this.f21352e = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }
}
