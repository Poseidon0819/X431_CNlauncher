package com.artifex.mupdflib;

/* loaded from: classes.dex */
public class Separation {
    int cmyk;
    String name;
    int rgba;

    public Separation(String str, int i, int i2) {
        this.name = str;
        this.rgba = i;
        this.cmyk = i2;
    }
}
