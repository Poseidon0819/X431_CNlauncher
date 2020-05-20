package com.itextpdf.text;

/* loaded from: classes.dex */
public class DocumentException extends Exception {
    private static final long serialVersionUID = -2191131489390840739L;

    public DocumentException(Exception exc) {
        super(exc);
    }

    public DocumentException() {
    }

    public DocumentException(String str) {
        super(str);
    }
}
