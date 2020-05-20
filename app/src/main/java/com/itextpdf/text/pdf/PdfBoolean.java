package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;

/* loaded from: classes.dex */
public class PdfBoolean extends PdfObject {
    public static final String FALSE = "false";
    public static final String TRUE = "true";
    private boolean value;
    public static final PdfBoolean PDFTRUE = new PdfBoolean(true);
    public static final PdfBoolean PDFFALSE = new PdfBoolean(false);

    public PdfBoolean(boolean z) {
        super(1);
        if (z) {
            setContent(TRUE);
        } else {
            setContent(FALSE);
        }
        this.value = z;
    }

    public PdfBoolean(String str) throws BadPdfFormatException {
        super(1, str);
        if (str.equals(TRUE)) {
            this.value = true;
        } else if (str.equals(FALSE)) {
            this.value = false;
        } else {
            throw new BadPdfFormatException(MessageLocalization.getComposedMessage("the.value.has.to.be.true.of.false.instead.of.1", str));
        }
    }

    public boolean booleanValue() {
        return this.value;
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        return this.value ? TRUE : FALSE;
    }
}
