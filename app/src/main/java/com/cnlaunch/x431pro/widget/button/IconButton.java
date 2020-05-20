package com.cnlaunch.x431pro.widget.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ifoer.expedition.p348a.C3592a;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class IconButton extends LinearLayout {

    /* renamed from: a */
    TypedArray f16524a;

    /* renamed from: b */
    TypedArray f16525b;

    /* renamed from: c */
    final String f16526c;

    /* renamed from: d */
    private TextView f16527d;

    /* renamed from: e */
    private ImageView f16528e;

    /* renamed from: f */
    private C2891a f16529f;

    /* renamed from: g */
    private String f16530g;

    /* renamed from: h */
    private String f16531h;

    /* renamed from: com.cnlaunch.x431pro.widget.button.IconButton$a */
    /* loaded from: classes.dex */
    class C2891a {

        /* renamed from: a */
        Drawable f16532a = null;

        /* renamed from: b */
        int f16533b;

        C2891a() {
        }

        /* renamed from: a */
        final boolean m4499a() {
            return this.f16532a == null;
        }
    }

    /* renamed from: com.cnlaunch.x431pro.widget.button.IconButton$b */
    /* loaded from: classes.dex */
    class C2892b {

        /* renamed from: a */
        int f16535a = 0;

        /* renamed from: b */
        int f16536b = 0;

        /* renamed from: c */
        int f16537c = 0;

        /* renamed from: d */
        int f16538d = 0;

        C2892b() {
        }
    }

    public IconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16527d = null;
        this.f16528e = null;
        this.f16524a = null;
        this.f16525b = null;
        this.f16526c = "http://schemas.android.com/apk/res/com.cnlaunch.padII";
        this.f16530g = null;
        this.f16531h = null;
        this.f16524a = context.obtainStyledAttributes(attributeSet, C3592a.C3593a.IconButton);
        this.f16529f = new C2891a();
        setMinimumHeight(this.f16524a.getDimensionPixelOffset(0, -2));
        this.f16529f.f16532a = this.f16524a.getDrawable(2);
        if (this.f16529f.f16532a != null) {
            this.f16529f.f16533b = 0;
        } else {
            this.f16529f.f16532a = this.f16524a.getDrawable(9);
            if (this.f16529f.f16532a != null) {
                this.f16529f.f16533b = 1;
            } else {
                this.f16529f.f16532a = this.f16524a.getDrawable(8);
                if (this.f16529f.f16532a != null) {
                    this.f16529f.f16533b = 2;
                } else {
                    this.f16529f.f16532a = this.f16524a.getDrawable(1);
                    if (this.f16529f.f16532a != null) {
                        this.f16529f.f16533b = 3;
                    }
                }
            }
        }
        if (this.f16529f.f16533b == 0 || this.f16529f.f16533b == 2) {
            setOrientation(0);
        } else {
            setOrientation(1);
        }
        if (this.f16529f.f16533b == 0 || this.f16529f.f16533b == 1) {
            if (!this.f16529f.m4499a()) {
                this.f16528e = new ImageView(context);
                this.f16528e.setImageDrawable(this.f16529f.f16532a);
                addView(this.f16528e, new LinearLayout.LayoutParams(this.f16524a.getDimensionPixelOffset(11, -2), this.f16524a.getDimensionPixelOffset(10, -2)));
            }
            this.f16527d = new TextView(context, attributeSet);
            C2892b c2892b = new C2892b();
            if (this.f16524a.getDimensionPixelOffset(3, -1) == -1) {
                c2892b.f16535a = this.f16524a.getDimensionPixelOffset(5, 0);
                c2892b.f16537c = this.f16524a.getDimensionPixelOffset(7, 0);
                c2892b.f16536b = this.f16524a.getDimensionPixelOffset(6, 0);
                c2892b.f16538d = this.f16524a.getDimensionPixelOffset(4, 0);
            }
            if (c2892b.f16535a + c2892b.f16537c + c2892b.f16536b + c2892b.f16538d > 0) {
                this.f16527d.setPadding(c2892b.f16535a, c2892b.f16537c, c2892b.f16536b, c2892b.f16538d);
            }
            this.f16527d.setBackgroundResource(R.color.transparent);
            this.f16530g = this.f16524a.getString(13);
            this.f16531h = this.f16524a.getString(12);
            addView(this.f16527d, new LinearLayout.LayoutParams(-2, -2));
        } else {
            this.f16527d = new TextView(context, attributeSet);
            C2892b c2892b2 = new C2892b();
            if (this.f16524a.getDimensionPixelOffset(3, -1) == -1) {
                c2892b2.f16535a = this.f16524a.getDimensionPixelOffset(5, 0);
                c2892b2.f16537c = this.f16524a.getDimensionPixelOffset(7, 0);
                c2892b2.f16536b = this.f16524a.getDimensionPixelOffset(6, 0);
                c2892b2.f16538d = this.f16524a.getDimensionPixelOffset(4, 0);
            }
            if (c2892b2.f16535a + c2892b2.f16537c + c2892b2.f16536b + c2892b2.f16538d > 0) {
                this.f16527d.setPadding(c2892b2.f16535a, c2892b2.f16537c, c2892b2.f16536b, c2892b2.f16538d);
            }
            this.f16527d.setBackgroundResource(R.color.transparent);
            this.f16530g = this.f16524a.getString(13);
            this.f16531h = this.f16524a.getString(12);
            addView(this.f16527d, new LinearLayout.LayoutParams(-2, -2));
            if (!this.f16529f.m4499a()) {
                this.f16528e = new ImageView(context);
                this.f16528e.setImageDrawable(this.f16529f.f16532a);
                addView(this.f16528e, new LinearLayout.LayoutParams(this.f16524a.getDimensionPixelOffset(11, -2), this.f16524a.getDimensionPixelOffset(10, -2)));
            }
        }
        this.f16524a.recycle();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        TextView textView = this.f16527d;
        if (textView != null) {
            textView.setEnabled(z);
        }
        ImageView imageView = this.f16528e;
        if (imageView != null) {
            imageView.setEnabled(z);
        }
        super.setEnabled(z);
    }

    public void setChecked(boolean z) {
        if (this.f16527d != null) {
            if (!TextUtils.isEmpty(this.f16530g) && !TextUtils.isEmpty(this.f16531h)) {
                this.f16527d.setText(z ? this.f16530g : this.f16531h);
            }
            this.f16527d.setActivated(z);
        }
        ImageView imageView = this.f16528e;
        if (imageView != null) {
            imageView.setActivated(z);
        }
        setActivated(z);
    }

    public CharSequence getText() {
        TextView textView = this.f16527d;
        if (textView != null) {
            return textView.getText();
        }
        return null;
    }

    public void setText(CharSequence charSequence) {
        TextView textView = this.f16527d;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setText(int i) {
        TextView textView = this.f16527d;
        if (textView != null) {
            textView.setText(i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        TextView textView = this.f16527d;
        if (textView != null) {
            textView.setVisibility(i);
        }
        ImageView imageView = this.f16528e;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setImage(Drawable drawable) {
        ImageView imageView = this.f16528e;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }
}
