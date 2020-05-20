package com.artifex.mupdflib;

/* loaded from: classes.dex */
public class ChoosePDFItem {
    public final String name;
    public final Type type;

    /* loaded from: classes.dex */
    enum Type {
        PARENT,
        DIR,
        DOC
    }

    public ChoosePDFItem(Type type, String str) {
        this.type = type;
        this.name = str;
    }
}
