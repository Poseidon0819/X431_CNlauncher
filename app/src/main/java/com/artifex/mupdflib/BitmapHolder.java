package com.artifex.mupdflib;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class BitmapHolder {

    /* renamed from: bm */
    private Bitmap f3555bm = null;

    public synchronized void setBm(Bitmap bitmap) {
        if (this.f3555bm != null && this.f3555bm != bitmap) {
            this.f3555bm.recycle();
        }
        this.f3555bm = bitmap;
    }

    public synchronized void drop() {
        this.f3555bm = null;
    }

    public synchronized Bitmap getBm() {
        return this.f3555bm;
    }
}
