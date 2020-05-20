package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PdfReaderInstance {
    static final PdfLiteral IDENTITYMATRIX = new PdfLiteral("[1 0 0 1 0 0]");
    static final PdfNumber ONE = new PdfNumber(1);
    RandomAccessFileOrArray file;
    int[] myXref;
    PdfReader reader;
    PdfWriter writer;
    HashMap<Integer, PdfImportedPage> importedPages = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    ArrayList<Integer> nextRound = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfReaderInstance(PdfReader pdfReader, PdfWriter pdfWriter) {
        this.reader = pdfReader;
        this.writer = pdfWriter;
        this.file = pdfReader.getSafeFile();
        this.myXref = new int[pdfReader.getXrefSize()];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfReader getReader() {
        return this.reader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfImportedPage getImportedPage(int i) {
        if (!this.reader.isOpenedWithFullPermissions()) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
        }
        if (i <= 0 || i > this.reader.getNumberOfPages()) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.page.number.1", i));
        }
        Integer valueOf = Integer.valueOf(i);
        PdfImportedPage pdfImportedPage = this.importedPages.get(valueOf);
        if (pdfImportedPage == null) {
            PdfImportedPage pdfImportedPage2 = new PdfImportedPage(this, this.writer, i);
            this.importedPages.put(valueOf, pdfImportedPage2);
            return pdfImportedPage2;
        }
        return pdfImportedPage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNewObjectNumber(int i, int i2) {
        int[] iArr = this.myXref;
        if (iArr[i] == 0) {
            iArr[i] = this.writer.getIndirectReferenceNumber();
            this.nextRound.add(Integer.valueOf(i));
        }
        return this.myXref[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RandomAccessFileOrArray getReaderFile() {
        return this.file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfObject getResources(int i) {
        return PdfReader.getPdfObjectRelease(this.reader.getPageNRelease(i).get(PdfName.RESOURCES));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfStream getFormXObject(int i, int i2) throws IOException {
        byte[] bArr;
        PdfDictionary pageNRelease = this.reader.getPageNRelease(i);
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pageNRelease.get(PdfName.CONTENTS));
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (pdfObjectRelease != null) {
            if (pdfObjectRelease.isStream()) {
                pdfDictionary.putAll((PRStream) pdfObjectRelease);
                bArr = null;
            } else {
                bArr = this.reader.getPageContent(i, this.file);
            }
        } else {
            bArr = new byte[0];
        }
        pdfDictionary.put(PdfName.RESOURCES, PdfReader.getPdfObjectRelease(pageNRelease.get(PdfName.RESOURCES)));
        pdfDictionary.put(PdfName.TYPE, PdfName.XOBJECT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.FORM);
        PdfImportedPage pdfImportedPage = this.importedPages.get(Integer.valueOf(i));
        pdfDictionary.put(PdfName.BBOX, new PdfRectangle(pdfImportedPage.getBoundingBox()));
        PdfArray matrix = pdfImportedPage.getMatrix();
        if (matrix == null) {
            pdfDictionary.put(PdfName.MATRIX, IDENTITYMATRIX);
        } else {
            pdfDictionary.put(PdfName.MATRIX, matrix);
        }
        pdfDictionary.put(PdfName.FORMTYPE, ONE);
        if (bArr == null) {
            return new PRStream((PRStream) pdfObjectRelease, pdfDictionary);
        }
        PRStream pRStream = new PRStream(this.reader, bArr, i2);
        pRStream.putAll(pdfDictionary);
        return pRStream;
    }

    void writeAllVisited() throws IOException {
        while (!this.nextRound.isEmpty()) {
            ArrayList<Integer> arrayList = this.nextRound;
            this.nextRound = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                Integer num = arrayList.get(i);
                if (!this.visited.contains(num)) {
                    this.visited.add(num);
                    int intValue = num.intValue();
                    this.writer.addToBody(this.reader.getPdfObjectRelease(intValue), this.myXref[intValue]);
                }
            }
        }
    }

    public void writeAllPages() throws IOException {
        try {
            this.file.reOpen();
            for (PdfImportedPage pdfImportedPage : this.importedPages.values()) {
                if (pdfImportedPage.isToCopy()) {
                    this.writer.addToBody(pdfImportedPage.getFormXObject(this.writer.getCompressionLevel()), pdfImportedPage.getIndirectReference());
                    pdfImportedPage.setCopied();
                }
            }
            writeAllVisited();
        } finally {
            try {
                this.reader.close();
                this.file.close();
            } catch (Exception unused) {
            }
        }
    }
}
