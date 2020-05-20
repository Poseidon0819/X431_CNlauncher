package com.artifex.mupdflib;

import android.content.Context;
import android.widget.ImageView;

/* compiled from: PageView.java */
/* loaded from: classes.dex */
class OpaqueImageView extends ImageView {
    @Override // android.widget.ImageView, android.view.View
    public boolean isOpaque() {
        return true;
    }

    public OpaqueImageView(Context context) {
        super(context);
    }
}
