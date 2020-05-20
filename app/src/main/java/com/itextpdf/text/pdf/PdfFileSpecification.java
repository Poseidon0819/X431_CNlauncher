package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.collection.PdfCollectionItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes.dex */
public class PdfFileSpecification extends PdfDictionary {
    protected PdfIndirectReference ref;
    protected PdfWriter writer;

    public PdfFileSpecification() {
        super(PdfName.FILESPEC);
    }

    public static PdfFileSpecification url(PdfWriter pdfWriter, String str) {
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.writer = pdfWriter;
        pdfFileSpecification.put(PdfName.f19719FS, PdfName.URL);
        pdfFileSpecification.put(PdfName.f19712F, new PdfString(str));
        return pdfFileSpecification;
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr) throws IOException {
        return fileEmbedded(pdfWriter, str, str2, bArr, 9);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, int i) throws IOException {
        return fileEmbedded(pdfWriter, str, str2, bArr, (String) null, (PdfDictionary) null, i);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, boolean z) throws IOException {
        return fileEmbedded(pdfWriter, str, str2, bArr, (String) null, (PdfDictionary) null, z ? 9 : 0);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, boolean z, String str3, PdfDictionary pdfDictionary) throws IOException {
        return fileEmbedded(pdfWriter, str, str2, bArr, str3, pdfDictionary, z ? 9 : 0);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, String str3, PdfDictionary pdfDictionary, int i) throws IOException {
        PdfEFStream pdfEFStream;
        InputStream inputStream;
        InputStream openStream;
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.writer = pdfWriter;
        pdfFileSpecification.put(PdfName.f19712F, new PdfString(str2));
        pdfFileSpecification.setUnicodeFileName(str2, false);
        InputStream inputStream2 = null;
        PdfIndirectReference pdfIndirectReference = null;
        try {
            if (bArr == null) {
                PdfIndirectReference pdfIndirectReference2 = pdfWriter.getPdfIndirectReference();
                if (new File(str).canRead()) {
                    openStream = new FileInputStream(str);
                } else {
                    if (!str.startsWith("file:/") && !str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("jar:")) {
                        openStream = BaseFont.getResourceStream(str);
                        if (openStream == null) {
                            throw new IOException(MessageLocalization.getComposedMessage("1.not.found.as.file.or.resource", str));
                        }
                    }
                    openStream = new URL(str).openStream();
                }
                pdfEFStream = new PdfEFStream(openStream, pdfWriter);
                inputStream = openStream;
                pdfIndirectReference = pdfIndirectReference2;
            } else {
                pdfEFStream = new PdfEFStream(bArr);
                inputStream = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            pdfEFStream.put(PdfName.TYPE, PdfName.EMBEDDEDFILE);
            pdfEFStream.flateCompress(i);
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            if (pdfDictionary != null) {
                pdfDictionary2.merge(pdfDictionary);
            }
            if (bArr != null) {
                pdfDictionary2.put(PdfName.SIZE, new PdfNumber(pdfEFStream.getRawLength()));
                pdfEFStream.put(PdfName.PARAMS, pdfDictionary2);
            } else {
                pdfEFStream.put(PdfName.PARAMS, pdfIndirectReference);
            }
            if (str3 != null) {
                pdfEFStream.put(PdfName.SUBTYPE, new PdfName(str3));
            }
            PdfIndirectReference indirectReference = pdfWriter.addToBody(pdfEFStream).getIndirectReference();
            if (bArr == null) {
                pdfEFStream.writeLength();
                pdfDictionary2.put(PdfName.SIZE, new PdfNumber(pdfEFStream.getRawLength()));
                pdfWriter.addToBody(pdfDictionary2, pdfIndirectReference);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            pdfDictionary3.put(PdfName.f19712F, indirectReference);
            pdfDictionary3.put(PdfName.f19785UF, indirectReference);
            pdfFileSpecification.put(PdfName.f19711EF, pdfDictionary3);
            return pdfFileSpecification;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public static PdfFileSpecification fileExtern(PdfWriter pdfWriter, String str) {
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.writer = pdfWriter;
        pdfFileSpecification.put(PdfName.f19712F, new PdfString(str));
        pdfFileSpecification.setUnicodeFileName(str, false);
        return pdfFileSpecification;
    }

    public PdfIndirectReference getReference() throws IOException {
        PdfIndirectReference pdfIndirectReference = this.ref;
        if (pdfIndirectReference != null) {
            return pdfIndirectReference;
        }
        this.ref = this.writer.addToBody(this).getIndirectReference();
        return this.ref;
    }

    public void setMultiByteFileName(byte[] bArr) {
        put(PdfName.f19712F, new PdfString(bArr).setHexWriting(true));
    }

    public void setUnicodeFileName(String str, boolean z) {
        put(PdfName.f19785UF, new PdfString(str, z ? PdfObject.TEXT_UNICODE : PdfObject.TEXT_PDFDOCENCODING));
    }

    public void setVolatile(boolean z) {
        put(PdfName.f19787V, new PdfBoolean(z));
    }

    public void addDescription(String str, boolean z) {
        put(PdfName.DESC, new PdfString(str, z ? PdfObject.TEXT_UNICODE : PdfObject.TEXT_PDFDOCENCODING));
    }

    public void addCollectionItem(PdfCollectionItem pdfCollectionItem) {
        put(PdfName.f19696CI, pdfCollectionItem);
    }
}
