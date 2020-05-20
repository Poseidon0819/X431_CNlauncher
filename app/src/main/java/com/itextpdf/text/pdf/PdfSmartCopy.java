package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.PdfCopy;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PdfSmartCopy extends PdfCopy {
    private HashMap<ByteStore, PdfIndirectReference> streamMap;

    public PdfSmartCopy(Document document, OutputStream outputStream) throws DocumentException {
        super(document, outputStream);
        this.streamMap = null;
        this.streamMap = new HashMap<>();
    }

    @Override // com.itextpdf.text.pdf.PdfCopy
    protected PdfIndirectReference copyIndirect(PRIndirectReference pRIndirectReference) throws IOException, BadPdfFormatException {
        ByteStore byteStore;
        PdfIndirectReference pdfIndirectReference;
        PdfCopy.IndirectReferences indirectReferences;
        PdfObject pdfObjectRelease;
        PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(pRIndirectReference);
        boolean z = true;
        if (pdfObjectRelease2.isStream()) {
            byteStore = new ByteStore((PRStream) pdfObjectRelease2);
            PdfIndirectReference pdfIndirectReference2 = this.streamMap.get(byteStore);
            if (pdfIndirectReference2 != null) {
                return pdfIndirectReference2;
            }
        } else if (pdfObjectRelease2.isDictionary()) {
            byteStore = new ByteStore((PdfDictionary) pdfObjectRelease2);
            PdfIndirectReference pdfIndirectReference3 = this.streamMap.get(byteStore);
            if (pdfIndirectReference3 != null) {
                return pdfIndirectReference3;
            }
        } else {
            byteStore = null;
            z = false;
        }
        PdfCopy.RefKey refKey = new PdfCopy.RefKey(pRIndirectReference);
        PdfCopy.IndirectReferences indirectReferences2 = this.indirects.get(refKey);
        if (indirectReferences2 != null) {
            PdfIndirectReference ref = indirectReferences2.getRef();
            if (indirectReferences2.getCopied()) {
                return ref;
            }
            indirectReferences = indirectReferences2;
            pdfIndirectReference = ref;
        } else {
            pdfIndirectReference = this.body.getPdfIndirectReference();
            indirectReferences = new PdfCopy.IndirectReferences(pdfIndirectReference);
            this.indirects.put(refKey, indirectReferences);
        }
        if (pdfObjectRelease2.isDictionary() && (pdfObjectRelease = PdfReader.getPdfObjectRelease(((PdfDictionary) pdfObjectRelease2).get(PdfName.TYPE))) != null && PdfName.PAGE.equals(pdfObjectRelease)) {
            return pdfIndirectReference;
        }
        indirectReferences.setCopied();
        if (z) {
            this.streamMap.put(byteStore, pdfIndirectReference);
        }
        addToBody(copyObject(pdfObjectRelease2), pdfIndirectReference);
        return pdfIndirectReference;
    }

    /* loaded from: classes.dex */
    static class ByteStore {

        /* renamed from: b */
        private byte[] f19803b;
        private int hash;
        private MessageDigest md5;

        private void serObject(PdfObject pdfObject, int i, ByteBuffer byteBuffer) throws IOException {
            if (i <= 0) {
                return;
            }
            if (pdfObject == null) {
                byteBuffer.append("$Lnull");
                return;
            }
            PdfObject pdfObject2 = PdfReader.getPdfObject(pdfObject);
            if (pdfObject2.isStream()) {
                byteBuffer.append("$B");
                serDic((PdfDictionary) pdfObject2, i - 1, byteBuffer);
                if (i > 0) {
                    this.md5.reset();
                    byteBuffer.append(this.md5.digest(PdfReader.getStreamBytesRaw((PRStream) pdfObject2)));
                }
            } else if (pdfObject2.isDictionary()) {
                serDic((PdfDictionary) pdfObject2, i - 1, byteBuffer);
            } else if (pdfObject2.isArray()) {
                serArray((PdfArray) pdfObject2, i - 1, byteBuffer);
            } else if (pdfObject2.isString()) {
                byteBuffer.append("$S").append(pdfObject2.toString());
            } else if (pdfObject2.isName()) {
                byteBuffer.append("$N").append(pdfObject2.toString());
            } else {
                byteBuffer.append("$L").append(pdfObject2.toString());
            }
        }

        private void serDic(PdfDictionary pdfDictionary, int i, ByteBuffer byteBuffer) throws IOException {
            byteBuffer.append("$D");
            if (i <= 0) {
                return;
            }
            Object[] array = pdfDictionary.getKeys().toArray();
            Arrays.sort(array);
            for (int i2 = 0; i2 < array.length; i2++) {
                serObject((PdfObject) array[i2], i, byteBuffer);
                serObject(pdfDictionary.get((PdfName) array[i2]), i, byteBuffer);
            }
        }

        private void serArray(PdfArray pdfArray, int i, ByteBuffer byteBuffer) throws IOException {
            byteBuffer.append("$A");
            if (i <= 0) {
                return;
            }
            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                serObject(pdfArray.getPdfObject(i2), i, byteBuffer);
            }
        }

        ByteStore(PRStream pRStream) throws IOException {
            try {
                this.md5 = MessageDigest.getInstance("MD5");
                ByteBuffer byteBuffer = new ByteBuffer();
                serObject(pRStream, 100, byteBuffer);
                this.f19803b = byteBuffer.toByteArray();
                this.md5 = null;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }

        ByteStore(PdfDictionary pdfDictionary) throws IOException {
            try {
                this.md5 = MessageDigest.getInstance("MD5");
                ByteBuffer byteBuffer = new ByteBuffer();
                serObject(pdfDictionary, 100, byteBuffer);
                this.f19803b = byteBuffer.toByteArray();
                this.md5 = null;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ByteStore) && hashCode() == obj.hashCode()) {
                return Arrays.equals(this.f19803b, ((ByteStore) obj).f19803b);
            }
            return false;
        }

        public int hashCode() {
            if (this.hash == 0) {
                int length = this.f19803b.length;
                for (int i = 0; i < length; i++) {
                    this.hash = (this.hash * 31) + (this.f19803b[i] & 255);
                }
            }
            return this.hash;
        }
    }
}
