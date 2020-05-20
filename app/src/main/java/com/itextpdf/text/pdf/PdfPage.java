package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.HashMap;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* loaded from: classes.dex */
public class PdfPage extends PdfDictionary {
    PdfRectangle mediaBox;
    private static final String[] boxStrings = {"crop", "trim", "art", "bleed"};
    private static final PdfName[] boxNames = {PdfName.CROPBOX, PdfName.TRIMBOX, PdfName.ARTBOX, PdfName.BLEEDBOX};
    public static final PdfNumber PORTRAIT = new PdfNumber(0);
    public static final PdfNumber LANDSCAPE = new PdfNumber(90);
    public static final PdfNumber INVERTEDPORTRAIT = new PdfNumber((int) Opcodes.GETFIELD);
    public static final PdfNumber SEASCAPE = new PdfNumber((int) TIFFConstants.TIFFTAG_IMAGEDESCRIPTION);

    public boolean isParent() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfPage(PdfRectangle pdfRectangle, HashMap<String, PdfRectangle> hashMap, PdfDictionary pdfDictionary, int i) throws DocumentException {
        super(PAGE);
        this.mediaBox = pdfRectangle;
        int i2 = 0;
        if (pdfRectangle != null && (pdfRectangle.width() > 14400.0f || pdfRectangle.height() > 14400.0f)) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.page.size.must.be.smaller.than.14400.by.14400.its.1.by.2", Float.valueOf(pdfRectangle.width()), Float.valueOf(pdfRectangle.height())));
        }
        put(PdfName.MEDIABOX, pdfRectangle);
        put(PdfName.RESOURCES, pdfDictionary);
        if (i != 0) {
            put(PdfName.ROTATE, new PdfNumber(i));
        }
        while (true) {
            String[] strArr = boxStrings;
            if (i2 >= strArr.length) {
                return;
            }
            PdfRectangle pdfRectangle2 = hashMap.get(strArr[i2]);
            if (pdfRectangle2 != null) {
                put(boxNames[i2], pdfRectangle2);
            }
            i2++;
        }
    }

    PdfPage(PdfRectangle pdfRectangle, HashMap<String, PdfRectangle> hashMap, PdfDictionary pdfDictionary) throws DocumentException {
        this(pdfRectangle, hashMap, pdfDictionary, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(PdfIndirectReference pdfIndirectReference) {
        put(PdfName.CONTENTS, pdfIndirectReference);
    }

    PdfRectangle rotateMediaBox() {
        this.mediaBox = this.mediaBox.rotate();
        put(PdfName.MEDIABOX, this.mediaBox);
        return this.mediaBox;
    }

    PdfRectangle getMediaBox() {
        return this.mediaBox;
    }
}
