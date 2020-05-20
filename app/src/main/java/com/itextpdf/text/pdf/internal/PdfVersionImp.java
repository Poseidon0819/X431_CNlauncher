package com.itextpdf.text.pdf.internal;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.OutputStreamCounter;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.interfaces.PdfVersion;
import java.io.IOException;

/* loaded from: classes.dex */
public class PdfVersionImp implements PdfVersion {
    public static final byte[][] HEADER = {DocWriter.getISOBytes("\n"), DocWriter.getISOBytes("%PDF-"), DocWriter.getISOBytes("\n%âãÏÓ\n")};
    protected boolean headerWasWritten = false;
    protected boolean appendmode = false;
    protected char header_version = PdfWriter.VERSION_1_4;
    protected PdfName catalog_version = null;
    protected PdfDictionary extensions = null;

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void setPdfVersion(char c) {
        if (this.headerWasWritten || this.appendmode) {
            setPdfVersion(getVersionAsName(c));
        } else {
            this.header_version = c;
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void setAtLeastPdfVersion(char c) {
        if (c > this.header_version) {
            setPdfVersion(c);
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void setPdfVersion(PdfName pdfName) {
        PdfName pdfName2 = this.catalog_version;
        if (pdfName2 == null || pdfName2.compareTo(pdfName) < 0) {
            this.catalog_version = pdfName;
        }
    }

    public void setAppendmode(boolean z) {
        this.appendmode = z;
    }

    public void writeHeader(OutputStreamCounter outputStreamCounter) throws IOException {
        if (this.appendmode) {
            outputStreamCounter.write(HEADER[0]);
            return;
        }
        outputStreamCounter.write(HEADER[1]);
        outputStreamCounter.write(getVersionAsByteArray(this.header_version));
        outputStreamCounter.write(HEADER[2]);
        this.headerWasWritten = true;
    }

    public PdfName getVersionAsName(char c) {
        switch (c) {
            case '2':
                return PdfWriter.PDF_VERSION_1_2;
            case '3':
                return PdfWriter.PDF_VERSION_1_3;
            case '4':
                return PdfWriter.PDF_VERSION_1_4;
            case '5':
                return PdfWriter.PDF_VERSION_1_5;
            case '6':
                return PdfWriter.PDF_VERSION_1_6;
            case '7':
                return PdfWriter.PDF_VERSION_1_7;
            default:
                return PdfWriter.PDF_VERSION_1_4;
        }
    }

    public byte[] getVersionAsByteArray(char c) {
        return DocWriter.getISOBytes(getVersionAsName(c).toString().substring(1));
    }

    public void addToCatalog(PdfDictionary pdfDictionary) {
        if (this.catalog_version != null) {
            pdfDictionary.put(PdfName.VERSION, this.catalog_version);
        }
        if (this.extensions != null) {
            pdfDictionary.put(PdfName.EXTENSIONS, this.extensions);
        }
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfVersion
    public void addDeveloperExtension(PdfDeveloperExtension pdfDeveloperExtension) {
        PdfDictionary pdfDictionary = this.extensions;
        if (pdfDictionary == null) {
            this.extensions = new PdfDictionary();
        } else {
            PdfDictionary asDict = pdfDictionary.getAsDict(pdfDeveloperExtension.getPrefix());
            if (asDict != null && (pdfDeveloperExtension.getBaseversion().compareTo(asDict.getAsName(PdfName.BASEVERSION)) < 0 || pdfDeveloperExtension.getExtensionLevel() - asDict.getAsNumber(PdfName.EXTENSIONLEVEL).intValue() <= 0)) {
                return;
            }
        }
        this.extensions.put(pdfDeveloperExtension.getPrefix(), pdfDeveloperExtension.getDeveloperExtensions());
    }
}
