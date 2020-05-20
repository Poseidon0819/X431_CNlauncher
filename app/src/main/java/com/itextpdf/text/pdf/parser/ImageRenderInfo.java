package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;

/* loaded from: classes.dex */
public class ImageRenderInfo {
    private final PdfDictionary colorSpaceDictionary;
    private final Matrix ctm;
    private PdfImageObject imageObject;
    private final InlineImageInfo inlineImageInfo;
    private final PdfIndirectReference ref;

    private ImageRenderInfo(Matrix matrix, PdfIndirectReference pdfIndirectReference, PdfDictionary pdfDictionary) {
        this.imageObject = null;
        this.ctm = matrix;
        this.ref = pdfIndirectReference;
        this.inlineImageInfo = null;
        this.colorSpaceDictionary = pdfDictionary;
    }

    private ImageRenderInfo(Matrix matrix, InlineImageInfo inlineImageInfo, PdfDictionary pdfDictionary) {
        this.imageObject = null;
        this.ctm = matrix;
        this.ref = null;
        this.inlineImageInfo = inlineImageInfo;
        this.colorSpaceDictionary = pdfDictionary;
    }

    public static ImageRenderInfo createForXObject(Matrix matrix, PdfIndirectReference pdfIndirectReference, PdfDictionary pdfDictionary) {
        return new ImageRenderInfo(matrix, pdfIndirectReference, pdfDictionary);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ImageRenderInfo createForEmbeddedImage(Matrix matrix, InlineImageInfo inlineImageInfo, PdfDictionary pdfDictionary) {
        return new ImageRenderInfo(matrix, inlineImageInfo, pdfDictionary);
    }

    public PdfImageObject getImage() throws IOException {
        prepareImageObject();
        return this.imageObject;
    }

    private void prepareImageObject() throws IOException {
        if (this.imageObject != null) {
            return;
        }
        PdfIndirectReference pdfIndirectReference = this.ref;
        if (pdfIndirectReference != null) {
            this.imageObject = new PdfImageObject((PRStream) PdfReader.getPdfObject(pdfIndirectReference), this.colorSpaceDictionary);
            return;
        }
        InlineImageInfo inlineImageInfo = this.inlineImageInfo;
        if (inlineImageInfo != null) {
            this.imageObject = new PdfImageObject(inlineImageInfo.getImageDictionary(), this.inlineImageInfo.getSamples(), this.colorSpaceDictionary);
        }
    }

    public Vector getStartPoint() {
        return new Vector(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f).cross(this.ctm);
    }

    public Matrix getImageCTM() {
        return this.ctm;
    }

    public float getArea() {
        return this.ctm.getDeterminant();
    }

    public PdfIndirectReference getRef() {
        return this.ref;
    }
}
