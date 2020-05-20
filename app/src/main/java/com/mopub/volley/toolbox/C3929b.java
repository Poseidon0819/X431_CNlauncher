package com.mopub.volley.toolbox;

import android.widget.ImageView;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;

/* compiled from: ImageLoader.java */
/* renamed from: com.mopub.volley.toolbox.b */
/* loaded from: classes2.dex */
final class C3929b implements ImageLoader.ImageListener {

    /* renamed from: a */
    final /* synthetic */ int f21359a;

    /* renamed from: b */
    final /* synthetic */ ImageView f21360b;

    /* renamed from: c */
    final /* synthetic */ int f21361c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3929b(int i, ImageView imageView, int i2) {
        this.f21359a = i;
        this.f21360b = imageView;
        this.f21361c = i2;
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        int i = this.f21359a;
        if (i != 0) {
            this.f21360b.setImageResource(i);
        }
    }

    @Override // com.mopub.volley.toolbox.ImageLoader.ImageListener
    public final void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
        if (imageContainer.getBitmap() != null) {
            this.f21360b.setImageBitmap(imageContainer.getBitmap());
            return;
        }
        int i = this.f21361c;
        if (i != 0) {
            this.f21360b.setImageResource(i);
        }
    }
}
