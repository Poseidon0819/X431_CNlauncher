package com.cnlaunch.p169im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.im.widget.DiversifyImageView */
/* loaded from: classes.dex */
public class DiversifyImageView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f9348a;

    /* renamed from: b */
    private ImageView f9349b;

    public DiversifyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.diversify_imageview, this);
        this.f9348a = (ImageView) findViewById(R.id.item_head_image);
        this.f9349b = (ImageView) findViewById(R.id.iv_chat_status);
    }

    public void setHeadImageResource(int i) {
        ImageView imageView = this.f9348a;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public ImageView getHead() {
        return this.f9348a;
    }

    public void setStatusImageResource(int i) {
        ImageView imageView = this.f9349b;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f9349b.setImageResource(i);
        }
    }

    /* renamed from: a */
    public final void m8699a() {
        ImageView imageView = this.f9349b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
