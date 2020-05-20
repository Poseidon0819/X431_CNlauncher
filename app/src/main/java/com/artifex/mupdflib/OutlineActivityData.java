package com.artifex.mupdflib;

/* loaded from: classes.dex */
public class OutlineActivityData {
    private static OutlineActivityData singleton;
    public OutlineItem[] items;
    public int position;

    public static void set(OutlineActivityData outlineActivityData) {
        singleton = outlineActivityData;
    }

    public static OutlineActivityData get() {
        if (singleton == null) {
            singleton = new OutlineActivityData();
        }
        return singleton;
    }
}
