package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfDocument;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class PdfCopy extends PdfWriter {
    protected PdfIndirectReference acroForm;
    protected int currentObjectNum;
    protected PdfArray fieldArray;
    protected HashSet<PdfTemplate> fieldTemplates;
    protected HashMap<PdfReader, HashMap<RefKey, IndirectReferences>> indirectMap;
    protected HashMap<RefKey, IndirectReferences> indirects;
    protected int[] namePtr;
    protected PdfReader reader;
    private boolean rotateContents;

    public PdfIndirectReference add(PdfOutline pdfOutline) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectReference add(PdfPage pdfPage, PdfContents pdfContents) throws PdfException {
        return null;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class IndirectReferences {
        boolean hasCopied = false;
        PdfIndirectReference theRef;

        /* JADX INFO: Access modifiers changed from: package-private */
        public IndirectReferences(PdfIndirectReference pdfIndirectReference) {
            this.theRef = pdfIndirectReference;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setCopied() {
            this.hasCopied = true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean getCopied() {
            return this.hasCopied;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PdfIndirectReference getRef() {
            return this.theRef;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class RefKey {
        int gen;
        int num;

        RefKey(int i, int i2) {
            this.num = i;
            this.gen = i2;
        }

        RefKey(PdfIndirectReference pdfIndirectReference) {
            this.num = pdfIndirectReference.getNumber();
            this.gen = pdfIndirectReference.getGeneration();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RefKey(PRIndirectReference pRIndirectReference) {
            this.num = pRIndirectReference.getNumber();
            this.gen = pRIndirectReference.getGeneration();
        }

        public int hashCode() {
            return (this.gen << 16) + this.num;
        }

        public boolean equals(Object obj) {
            if (obj instanceof RefKey) {
                RefKey refKey = (RefKey) obj;
                return this.gen == refKey.gen && this.num == refKey.num;
            }
            return false;
        }

        public String toString() {
            return Integer.toString(this.num) + TokenParser.f24154SP + this.gen;
        }
    }

    public PdfCopy(Document document, OutputStream outputStream) throws DocumentException {
        super(new PdfDocument(), outputStream);
        this.currentObjectNum = 1;
        this.namePtr = new int[]{0};
        this.rotateContents = true;
        document.addDocListener(this.pdf);
        this.pdf.addWriter(this);
        this.indirectMap = new HashMap<>();
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void setPageEvent(PdfPageEvent pdfPageEvent) {
        throw new UnsupportedOperationException();
    }

    public boolean isRotateContents() {
        return this.rotateContents;
    }

    public void setRotateContents(boolean z) {
        this.rotateContents = z;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        if (this.currentPdfReaderInstance != null) {
            if (this.currentPdfReaderInstance.getReader() != pdfReader) {
                try {
                    this.currentPdfReaderInstance.getReader().close();
                    this.currentPdfReaderInstance.getReaderFile().close();
                } catch (IOException unused) {
                }
                this.currentPdfReaderInstance = super.getPdfReaderInstance(pdfReader);
            }
        } else {
            this.currentPdfReaderInstance = super.getPdfReaderInstance(pdfReader);
        }
        return this.currentPdfReaderInstance.getImportedPage(i);
    }

    protected PdfIndirectReference copyIndirect(PRIndirectReference pRIndirectReference) throws IOException, BadPdfFormatException {
        PdfIndirectReference pdfIndirectReference;
        PdfObject pdfObjectRelease;
        RefKey refKey = new RefKey(pRIndirectReference);
        IndirectReferences indirectReferences = this.indirects.get(refKey);
        if (indirectReferences != null) {
            pdfIndirectReference = indirectReferences.getRef();
            if (indirectReferences.getCopied()) {
                return pdfIndirectReference;
            }
        } else {
            PdfIndirectReference pdfIndirectReference2 = this.body.getPdfIndirectReference();
            IndirectReferences indirectReferences2 = new IndirectReferences(pdfIndirectReference2);
            this.indirects.put(refKey, indirectReferences2);
            pdfIndirectReference = pdfIndirectReference2;
            indirectReferences = indirectReferences2;
        }
        PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(pRIndirectReference);
        if (pdfObjectRelease2 == null || !pdfObjectRelease2.isDictionary() || (pdfObjectRelease = PdfReader.getPdfObjectRelease(((PdfDictionary) pdfObjectRelease2).get(PdfName.TYPE))) == null || !PdfName.PAGE.equals(pdfObjectRelease)) {
            indirectReferences.setCopied();
            addToBody(copyObject(pdfObjectRelease2), pdfIndirectReference);
            return pdfIndirectReference;
        }
        return pdfIndirectReference;
    }

    protected PdfDictionary copyDictionary(PdfDictionary pdfDictionary) throws IOException, BadPdfFormatException {
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.TYPE));
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            PdfObject pdfObject = pdfDictionary.get(pdfName);
            if (pdfObjectRelease == null || !PdfName.PAGE.equals(pdfObjectRelease) || (!pdfName.equals(PdfName.f19684B) && !pdfName.equals(PdfName.PARENT))) {
                pdfDictionary2.put(pdfName, copyObject(pdfObject));
            }
        }
        return pdfDictionary2;
    }

    protected PdfStream copyStream(PRStream pRStream) throws IOException, BadPdfFormatException {
        PRStream pRStream2 = new PRStream(pRStream, (PdfDictionary) null);
        for (PdfName pdfName : pRStream.getKeys()) {
            pRStream2.put(pdfName, copyObject(pRStream.get(pdfName)));
        }
        return pRStream2;
    }

    protected PdfArray copyArray(PdfArray pdfArray) throws IOException, BadPdfFormatException {
        PdfArray pdfArray2 = new PdfArray();
        ListIterator<PdfObject> listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            pdfArray2.add(copyObject(listIterator.next()));
        }
        return pdfArray2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfObject copyObject(PdfObject pdfObject) throws IOException, BadPdfFormatException {
        if (pdfObject == null) {
            return PdfNull.PDFNULL;
        }
        switch (pdfObject.type) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 8:
                return pdfObject;
            case 5:
                return copyArray((PdfArray) pdfObject);
            case 6:
                return copyDictionary((PdfDictionary) pdfObject);
            case 7:
                return copyStream((PRStream) pdfObject);
            case 9:
            default:
                if (pdfObject.type < 0) {
                    String pdfLiteral = ((PdfLiteral) pdfObject).toString();
                    if (pdfLiteral.equals(PdfBoolean.TRUE) || pdfLiteral.equals(PdfBoolean.FALSE)) {
                        return new PdfBoolean(pdfLiteral);
                    }
                    return new PdfLiteral(pdfLiteral);
                }
                PrintStream printStream = System.out;
                printStream.println("CANNOT COPY type " + pdfObject.type);
                return null;
            case 10:
                return copyIndirect((PRIndirectReference) pdfObject);
        }
    }

    protected int setFromIPage(PdfImportedPage pdfImportedPage) {
        int pageNumber = pdfImportedPage.getPageNumber();
        PdfReaderInstance pdfReaderInstance = pdfImportedPage.getPdfReaderInstance();
        this.currentPdfReaderInstance = pdfReaderInstance;
        this.reader = pdfReaderInstance.getReader();
        setFromReader(this.reader);
        return pageNumber;
    }

    protected void setFromReader(PdfReader pdfReader) {
        this.reader = pdfReader;
        this.indirects = this.indirectMap.get(pdfReader);
        if (this.indirects == null) {
            this.indirects = new HashMap<>();
            this.indirectMap.put(pdfReader, this.indirects);
            PdfObject pdfObject = pdfReader.getCatalog().get(PdfName.ACROFORM);
            if (pdfObject == null || pdfObject.type() != 10) {
                return;
            }
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            if (this.acroForm == null) {
                this.acroForm = this.body.getPdfIndirectReference();
            }
            this.indirects.put(new RefKey(pRIndirectReference), new IndirectReferences(this.acroForm));
        }
    }

    public void addPage(PdfImportedPage pdfImportedPage) throws IOException, BadPdfFormatException {
        int fromIPage = setFromIPage(pdfImportedPage);
        PdfDictionary pageN = this.reader.getPageN(fromIPage);
        PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(fromIPage);
        this.reader.releasePage(fromIPage);
        RefKey refKey = new RefKey(pageOrigRef);
        IndirectReferences indirectReferences = this.indirects.get(refKey);
        if (indirectReferences != null && !indirectReferences.getCopied()) {
            this.pageReferences.add(indirectReferences.getRef());
            indirectReferences.setCopied();
        }
        PdfIndirectReference currentPage = getCurrentPage();
        if (indirectReferences == null) {
            indirectReferences = new IndirectReferences(currentPage);
            this.indirects.put(refKey, indirectReferences);
        }
        indirectReferences.setCopied();
        this.root.addPage(copyDictionary(pageN));
        pdfImportedPage.setCopied();
        this.currentPageNumber++;
    }

    public void addPage(Rectangle rectangle, int i) throws DocumentException {
        PdfPage pdfPage = new PdfPage(new PdfRectangle(rectangle, i), new HashMap(), new PageResources().getResources(), 0);
        pdfPage.put(PdfName.TABS, getTabs());
        this.root.addPage(pdfPage);
        this.currentPageNumber++;
    }

    public void copyAcroForm(PdfReader pdfReader) throws IOException, BadPdfFormatException {
        PdfIndirectReference pdfIndirectReference;
        setFromReader(pdfReader);
        PdfObject pdfObject = pdfReader.getCatalog().get(PdfName.ACROFORM);
        PRIndirectReference pRIndirectReference = (pdfObject == null || pdfObject.type() != 10) ? null : (PRIndirectReference) pdfObject;
        if (pRIndirectReference == null) {
            return;
        }
        RefKey refKey = new RefKey(pRIndirectReference);
        IndirectReferences indirectReferences = this.indirects.get(refKey);
        if (indirectReferences != null) {
            pdfIndirectReference = indirectReferences.getRef();
            this.acroForm = pdfIndirectReference;
        } else {
            PdfIndirectReference pdfIndirectReference2 = this.body.getPdfIndirectReference();
            this.acroForm = pdfIndirectReference2;
            IndirectReferences indirectReferences2 = new IndirectReferences(pdfIndirectReference2);
            this.indirects.put(refKey, indirectReferences2);
            pdfIndirectReference = pdfIndirectReference2;
            indirectReferences = indirectReferences2;
        }
        if (indirectReferences.getCopied()) {
            return;
        }
        indirectReferences.setCopied();
        addToBody(copyDictionary((PdfDictionary) PdfReader.getPdfObject(pRIndirectReference)), pdfIndirectReference);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    protected PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        try {
            PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
            if (this.fieldArray == null) {
                if (this.acroForm != null) {
                    catalog.put(PdfName.ACROFORM, this.acroForm);
                }
            } else {
                addFieldResources(catalog);
            }
            return catalog;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    private void addFieldResources(PdfDictionary pdfDictionary) throws IOException {
        if (this.fieldArray == null) {
            return;
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary.put(PdfName.ACROFORM, pdfDictionary2);
        pdfDictionary2.put(PdfName.FIELDS, this.fieldArray);
        pdfDictionary2.put(PdfName.f19700DA, new PdfString("/Helv 0 Tf 0 g "));
        if (this.fieldTemplates.isEmpty()) {
            return;
        }
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        pdfDictionary2.put(PdfName.f19706DR, pdfDictionary3);
        Iterator<PdfTemplate> it = this.fieldTemplates.iterator();
        while (it.hasNext()) {
            PdfFormField.mergeResources(pdfDictionary3, (PdfDictionary) it.next().getResources());
        }
        PdfDictionary asDict = pdfDictionary3.getAsDict(PdfName.FONT);
        if (asDict == null) {
            asDict = new PdfDictionary();
            pdfDictionary3.put(PdfName.FONT, asDict);
        }
        if (!asDict.contains(PdfName.HELV)) {
            PdfDictionary pdfDictionary4 = new PdfDictionary(PdfName.FONT);
            pdfDictionary4.put(PdfName.BASEFONT, PdfName.HELVETICA);
            pdfDictionary4.put(PdfName.ENCODING, PdfName.WIN_ANSI_ENCODING);
            pdfDictionary4.put(PdfName.NAME, PdfName.HELV);
            pdfDictionary4.put(PdfName.SUBTYPE, PdfName.TYPE1);
            asDict.put(PdfName.HELV, addToBody(pdfDictionary4).getIndirectReference());
        }
        if (asDict.contains(PdfName.ZADB)) {
            return;
        }
        PdfDictionary pdfDictionary5 = new PdfDictionary(PdfName.FONT);
        pdfDictionary5.put(PdfName.BASEFONT, PdfName.ZAPFDINGBATS);
        pdfDictionary5.put(PdfName.NAME, PdfName.ZADB);
        pdfDictionary5.put(PdfName.SUBTYPE, PdfName.TYPE1);
        asDict.put(PdfName.ZADB, addToBody(pdfDictionary5).getIndirectReference());
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.DocWriter, com.itextpdf.text.DocListener
    public void close() {
        if (this.open) {
            PdfReaderInstance pdfReaderInstance = this.currentPdfReaderInstance;
            this.pdf.close();
            super.close();
            if (pdfReaderInstance != null) {
                try {
                    pdfReaderInstance.getReader().close();
                    pdfReaderInstance.getReaderFile().close();
                } catch (IOException unused) {
                }
            }
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void freeReader(PdfReader pdfReader) throws IOException {
        this.indirectMap.remove(pdfReader);
        if (this.currentPdfReaderInstance != null && this.currentPdfReaderInstance.getReader() == pdfReader) {
            try {
                this.currentPdfReaderInstance.getReader().close();
                this.currentPdfReaderInstance.getReaderFile().close();
            } catch (IOException unused) {
            }
            this.currentPdfReaderInstance = null;
        }
        super.freeReader(pdfReader);
    }

    public PageStamp createPageStamp(PdfImportedPage pdfImportedPage) {
        int pageNumber = pdfImportedPage.getPageNumber();
        PdfReader reader = pdfImportedPage.getPdfReaderInstance().getReader();
        return new PageStamp(reader, reader.getPageN(pageNumber), this);
    }

    /* loaded from: classes.dex */
    public static class PageStamp {
        PdfCopy cstp;
        StampContent over;
        PdfDictionary pageN;
        PageResources pageResources;
        PdfReader reader;
        StampContent under;

        PageStamp(PdfReader pdfReader, PdfDictionary pdfDictionary, PdfCopy pdfCopy) {
            this.pageN = pdfDictionary;
            this.reader = pdfReader;
            this.cstp = pdfCopy;
        }

        public PdfContentByte getUnderContent() {
            if (this.under == null) {
                if (this.pageResources == null) {
                    this.pageResources = new PageResources();
                    this.pageResources.setOriginalResources(this.pageN.getAsDict(PdfName.RESOURCES), this.cstp.namePtr);
                }
                this.under = new StampContent(this.cstp, this.pageResources);
            }
            return this.under;
        }

        public PdfContentByte getOverContent() {
            if (this.over == null) {
                if (this.pageResources == null) {
                    this.pageResources = new PageResources();
                    this.pageResources.setOriginalResources(this.pageN.getAsDict(PdfName.RESOURCES), this.cstp.namePtr);
                }
                this.over = new StampContent(this.cstp, this.pageResources);
            }
            return this.over;
        }

        public void alterContents() throws IOException {
            PdfArray pdfArray;
            if (this.over == null && this.under == null) {
                return;
            }
            PdfObject pdfObject = PdfReader.getPdfObject(this.pageN.get(PdfName.CONTENTS), this.pageN);
            if (pdfObject == null) {
                pdfArray = new PdfArray();
                this.pageN.put(PdfName.CONTENTS, pdfArray);
            } else if (pdfObject.isArray()) {
                pdfArray = (PdfArray) pdfObject;
            } else if (pdfObject.isStream()) {
                pdfArray = new PdfArray();
                pdfArray.add(this.pageN.get(PdfName.CONTENTS));
                this.pageN.put(PdfName.CONTENTS, pdfArray);
            } else {
                pdfArray = new PdfArray();
                this.pageN.put(PdfName.CONTENTS, pdfArray);
            }
            ByteBuffer byteBuffer = new ByteBuffer();
            if (this.under != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(this.pageN, byteBuffer);
                byteBuffer.append(this.under.getInternalBuffer());
                byteBuffer.append(PdfContents.RESTORESTATE);
            }
            if (this.over != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
            }
            PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
            pdfStream.flateCompress(this.cstp.getCompressionLevel());
            pdfArray.addFirst(this.cstp.addToBody(pdfStream).getIndirectReference());
            byteBuffer.reset();
            if (this.over != null) {
                byteBuffer.append(TokenParser.f24154SP);
                byteBuffer.append(PdfContents.RESTORESTATE);
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(this.pageN, byteBuffer);
                byteBuffer.append(this.over.getInternalBuffer());
                byteBuffer.append(PdfContents.RESTORESTATE);
                PdfStream pdfStream2 = new PdfStream(byteBuffer.toByteArray());
                pdfStream2.flateCompress(this.cstp.getCompressionLevel());
                pdfArray.add(this.cstp.addToBody(pdfStream2).getIndirectReference());
            }
            this.pageN.put(PdfName.RESOURCES, this.pageResources.getResources());
        }

        void applyRotation(PdfDictionary pdfDictionary, ByteBuffer byteBuffer) {
            if (this.cstp.rotateContents) {
                Rectangle pageSizeWithRotation = this.reader.getPageSizeWithRotation(pdfDictionary);
                int rotation = pageSizeWithRotation.getRotation();
                if (rotation == 90) {
                    byteBuffer.append(PdfContents.ROTATE90);
                    byteBuffer.append(pageSizeWithRotation.getTop());
                    byteBuffer.append(TokenParser.f24154SP).append('0').append(PdfContents.ROTATEFINAL);
                } else if (rotation == 180) {
                    byteBuffer.append(PdfContents.ROTATE180);
                    byteBuffer.append(pageSizeWithRotation.getRight());
                    byteBuffer.append(TokenParser.f24154SP);
                    byteBuffer.append(pageSizeWithRotation.getTop());
                    byteBuffer.append(PdfContents.ROTATEFINAL);
                } else if (rotation != 270) {
                } else {
                    byteBuffer.append(PdfContents.ROTATE270);
                    byteBuffer.append('0').append(TokenParser.f24154SP);
                    byteBuffer.append(pageSizeWithRotation.getRight());
                    byteBuffer.append(PdfContents.ROTATEFINAL);
                }
            }
        }

        private void addDocumentField(PdfIndirectReference pdfIndirectReference) {
            if (this.cstp.fieldArray == null) {
                this.cstp.fieldArray = new PdfArray();
            }
            this.cstp.fieldArray.add(pdfIndirectReference);
        }

        private void expandFields(PdfFormField pdfFormField, ArrayList<PdfAnnotation> arrayList) {
            arrayList.add(pdfFormField);
            ArrayList<PdfFormField> kids = pdfFormField.getKids();
            if (kids != null) {
                Iterator<PdfFormField> it = kids.iterator();
                while (it.hasNext()) {
                    expandFields(it.next(), arrayList);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0135 A[Catch: IOException -> 0x0170, TryCatch #0 {IOException -> 0x0170, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x0014, B:9:0x001d, B:12:0x002b, B:14:0x0031, B:16:0x003d, B:18:0x0043, B:20:0x0049, B:21:0x0050, B:23:0x0059, B:24:0x0060, B:26:0x0066, B:28:0x0076, B:31:0x007d, B:33:0x008c, B:35:0x0099, B:37:0x00a3, B:39:0x00ac, B:41:0x00b4, B:43:0x00bc, B:45:0x00c4, B:52:0x00e1, B:53:0x0106, B:54:0x0135, B:32:0x0080, B:55:0x0159, B:57:0x015f, B:10:0x0027), top: B:64:0x0000 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void addAnnotation(com.itextpdf.text.pdf.PdfAnnotation r11) {
            /*
                Method dump skipped, instructions count: 376
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfCopy.PageStamp.addAnnotation(com.itextpdf.text.pdf.PdfAnnotation):void");
        }
    }

    /* loaded from: classes.dex */
    public static class StampContent extends PdfContentByte {
        PageResources pageResources;

        StampContent(PdfWriter pdfWriter, PageResources pageResources) {
            super(pdfWriter);
            this.pageResources = pageResources;
        }

        @Override // com.itextpdf.text.pdf.PdfContentByte
        public PdfContentByte getDuplicate() {
            return new StampContent(this.writer, this.pageResources);
        }

        @Override // com.itextpdf.text.pdf.PdfContentByte
        PageResources getPageResources() {
            return this.pageResources;
        }
    }
}
