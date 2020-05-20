package com.artifex.mupdflib;

import android.graphics.RectF;

/* loaded from: classes.dex */
public class TextWord extends RectF {

    /* renamed from: w */
    public String f3564w = new String();

    public void Add(TextChar textChar) {
        super.union(textChar);
        this.f3564w = this.f3564w.concat(new String(new char[]{textChar.f3563c}));
    }
}
