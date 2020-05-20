package com.artifex.mupdflib;

/* loaded from: classes.dex */
public class OutlineItem {
    public final int level;
    public final int page;
    public final String title;

    OutlineItem(int i, String str, int i2) {
        this.level = i;
        this.title = str;
        this.page = i2;
    }
}
