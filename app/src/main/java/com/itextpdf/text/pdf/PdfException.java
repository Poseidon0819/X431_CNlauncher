package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;

/* loaded from: classes.dex */
public class PdfException extends DocumentException {
    private static final long serialVersionUID = 6767433960955483999L;

    public PdfException(Exception exc) {
        super(exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfException() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfException(String str) {
        super(str);
    }
}
