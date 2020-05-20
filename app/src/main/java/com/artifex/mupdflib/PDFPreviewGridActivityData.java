package com.artifex.mupdflib;

/* loaded from: classes.dex */
public class PDFPreviewGridActivityData {
    private static PDFPreviewGridActivityData singleton;
    public MuPDFCore core;
    public int position;

    public static void set(PDFPreviewGridActivityData pDFPreviewGridActivityData) {
        singleton = pDFPreviewGridActivityData;
    }

    public static PDFPreviewGridActivityData get() {
        if (singleton == null) {
            singleton = new PDFPreviewGridActivityData();
        }
        return singleton;
    }
}
