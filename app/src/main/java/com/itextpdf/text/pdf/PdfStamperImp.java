package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Version;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import com.itextpdf.text.xml.xmp.PdfSchema;
import com.itextpdf.text.xml.xmp.XmpBasicSchema;
import com.itextpdf.text.xml.xmp.XmpReader;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import org.apache.http.conn.ssl.TokenParser;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.xml.sax.SAXException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PdfStamperImp extends PdfWriter {
    protected AcroFields acroFields;
    protected boolean append;
    protected boolean closed;
    protected HashSet<PdfTemplate> fieldTemplates;
    protected boolean fieldsAdded;
    protected RandomAccessFileOrArray file;
    protected boolean flat;
    protected boolean flatFreeText;
    protected int initialXrefSize;
    protected IntHashtable marked;
    IntHashtable myXref;
    protected int[] namePtr;
    protected PdfAction openAction;
    HashMap<PdfDictionary, PageStamp> pagesToContent;
    protected HashSet<String> partialFlattening;
    PdfReader reader;
    HashMap<PdfReader, RandomAccessFileOrArray> readers2file;
    HashMap<PdfReader, IntHashtable> readers2intrefs;
    private boolean rotateContents;
    protected int sigFlags;
    protected boolean useVp;
    protected PdfViewerPreferencesImp viewerPreferences;

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfStamperImp(PdfReader pdfReader, OutputStream outputStream, char c, boolean z) throws DocumentException, IOException {
        super(new PdfDocument(), outputStream);
        this.readers2intrefs = new HashMap<>();
        this.readers2file = new HashMap<>();
        this.myXref = new IntHashtable();
        this.pagesToContent = new HashMap<>();
        this.closed = false;
        this.rotateContents = true;
        this.flat = false;
        this.flatFreeText = false;
        this.namePtr = new int[]{0};
        this.partialFlattening = new HashSet<>();
        this.useVp = false;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.fieldTemplates = new HashSet<>();
        this.fieldsAdded = false;
        this.sigFlags = 0;
        if (!pdfReader.isOpenedWithFullPermissions()) {
            throw new BadPasswordException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
        }
        if (pdfReader.isTampered()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.original.document.was.reused.read.it.again.from.file", new Object[0]));
        }
        pdfReader.setTampered(true);
        this.reader = pdfReader;
        this.file = pdfReader.getSafeFile();
        this.append = z;
        if (z) {
            if (pdfReader.isRebuilt()) {
                throw new DocumentException(MessageLocalization.getComposedMessage("append.mode.requires.a.document.without.errors.even.if.recovery.was.possible", new Object[0]));
            }
            if (pdfReader.isEncrypted()) {
                this.crypto = new PdfEncryption(pdfReader.getDecrypt());
            }
            this.pdf_version.setAppendmode(true);
            this.file.reOpen();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.file.read(bArr);
                if (read <= 0) {
                    break;
                }
                this.f19587os.write(bArr, 0, read);
            }
            this.file.close();
            this.prevxref = pdfReader.getLastXref();
            pdfReader.setAppendable(true);
        } else if (c == 0) {
            super.setPdfVersion(pdfReader.getPdfVersion());
        } else {
            super.setPdfVersion(c);
        }
        super.open();
        this.pdf.addWriter(this);
        if (z) {
            this.body.setRefnum(pdfReader.getXrefSize());
            this.marked = new IntHashtable();
            if (pdfReader.isNewXrefType()) {
                this.fullCompression = true;
            }
            if (pdfReader.isHybridXref()) {
                this.fullCompression = false;
            }
        }
        this.initialXrefSize = pdfReader.getXrefSize();
    }

    protected void setViewerPreferences() {
        this.reader.setViewerPreferences(this.viewerPreferences);
        markUsed(this.reader.getTrailer().get(PdfName.ROOT));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void close(Map<String, String> map) throws IOException {
        PdfDictionary pdfDictionary;
        PdfIndirectReference indirectReference;
        XmpReader xmpReader;
        PdfStream pdfStream;
        if (this.closed) {
            return;
        }
        if (this.useVp) {
            setViewerPreferences();
        }
        if (this.flat) {
            flatFields();
        }
        if (this.flatFreeText) {
            flatFreeTextFields();
        }
        addFieldResources();
        PdfDictionary catalog = this.reader.getCatalog();
        PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), this.reader.getCatalog());
        AcroFields acroFields = this.acroFields;
        if (acroFields != null && acroFields.getXfa().isChanged()) {
            markUsed(pdfDictionary2);
            if (!this.flat) {
                this.acroFields.getXfa().setXfa(this);
            }
        }
        if (this.sigFlags != 0 && pdfDictionary2 != null) {
            pdfDictionary2.put(PdfName.SIGFLAGS, new PdfNumber(this.sigFlags));
            markUsed(pdfDictionary2);
            markUsed(catalog);
        }
        this.closed = true;
        addSharedObjectsToBody();
        setOutlines();
        setJavaScript();
        addFileAttachments();
        if (this.openAction != null) {
            catalog.put(PdfName.OPENACTION, this.openAction);
        }
        if (this.pdf.pageLabels != null) {
            catalog.put(PdfName.PAGELABELS, this.pdf.pageLabels.getDictionary(this));
        }
        if (!this.documentOCG.isEmpty()) {
            fillOCProperties(false);
            PdfDictionary asDict = catalog.getAsDict(PdfName.OCPROPERTIES);
            if (asDict == null) {
                this.reader.getCatalog().put(PdfName.OCPROPERTIES, this.OCProperties);
            } else {
                asDict.put(PdfName.OCGS, this.OCProperties.get(PdfName.OCGS));
                PdfDictionary asDict2 = asDict.getAsDict(PdfName.f19699D);
                if (asDict2 == null) {
                    asDict2 = new PdfDictionary();
                    asDict.put(PdfName.f19699D, asDict2);
                }
                asDict2.put(PdfName.ORDER, this.OCProperties.getAsDict(PdfName.f19699D).get(PdfName.ORDER));
                asDict2.put(PdfName.RBGROUPS, this.OCProperties.getAsDict(PdfName.f19699D).get(PdfName.RBGROUPS));
                asDict2.put(PdfName.OFF, this.OCProperties.getAsDict(PdfName.f19699D).get(PdfName.OFF));
                asDict2.put(PdfName.f19683AS, this.OCProperties.getAsDict(PdfName.f19699D).get(PdfName.f19683AS));
            }
        }
        PdfObject pdfObject = this.reader.getTrailer().get(PdfName.INFO);
        byte[] bArr = null;
        PRIndirectReference pRIndirectReference = pdfObject instanceof PRIndirectReference ? (PRIndirectReference) pdfObject : null;
        if (pRIndirectReference != null) {
            pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
        } else {
            pdfDictionary = pdfObject instanceof PdfDictionary ? (PdfDictionary) pdfObject : null;
        }
        int number = pRIndirectReference != null ? pRIndirectReference.getNumber() : -1;
        String unicodeString = (pdfDictionary == null || pdfDictionary.get(PdfName.PRODUCER) == null) ? null : pdfDictionary.getAsString(PdfName.PRODUCER).toUnicodeString();
        Version version = Version.getInstance();
        if (unicodeString == null) {
            unicodeString = version.getVersion();
        } else if (unicodeString.indexOf(version.getProduct()) == -1) {
            StringBuffer stringBuffer = new StringBuffer(unicodeString);
            stringBuffer.append("; modified using ");
            stringBuffer.append(version.getVersion());
            unicodeString = stringBuffer.toString();
        }
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        if (pdfDictionary != null) {
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                pdfDictionary3.put(pdfName, PdfReader.getPdfObject(pdfDictionary.get(pdfName)));
            }
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                PdfName pdfName2 = new PdfName(entry.getKey());
                String value = entry.getValue();
                if (value == null) {
                    pdfDictionary3.remove(pdfName2);
                } else {
                    pdfDictionary3.put(pdfName2, new PdfString(value, PdfObject.TEXT_UNICODE));
                }
            }
        }
        PdfDate pdfDate = new PdfDate();
        pdfDictionary3.put(PdfName.MODDATE, pdfDate);
        pdfDictionary3.put(PdfName.PRODUCER, new PdfString(unicodeString, PdfObject.TEXT_UNICODE));
        if (this.append && pRIndirectReference != null) {
            indirectReference = addToBody((PdfObject) pdfDictionary3, pRIndirectReference.getNumber(), false).getIndirectReference();
        } else {
            indirectReference = addToBody((PdfObject) pdfDictionary3, false).getIndirectReference();
        }
        PdfObject pdfObject2 = PdfReader.getPdfObject(catalog.get(PdfName.METADATA));
        if (pdfObject2 != null && pdfObject2.isStream()) {
            bArr = PdfReader.getStreamBytesRaw((PRStream) pdfObject2);
            PdfReader.killIndirect(catalog.get(PdfName.METADATA));
        }
        if (this.xmpMetadata != null) {
            bArr = this.xmpMetadata;
        }
        if (bArr != null) {
            if (map != null) {
                try {
                    try {
                    } catch (SAXException unused) {
                        pdfStream = new PdfStream(bArr);
                    }
                } catch (IOException unused2) {
                    pdfStream = new PdfStream(bArr);
                }
                if (this.xmpMetadata == null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        new XmpWriter(byteArrayOutputStream, pdfDictionary3, getPDFXConformance()).close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    xmpReader = new XmpReader(byteArrayOutputStream.toByteArray());
                    pdfStream = new PdfStream(xmpReader.serializeDoc());
                    pdfStream.put(PdfName.TYPE, PdfName.METADATA);
                    pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
                    if (this.crypto != null && !this.crypto.isMetadataEncrypted()) {
                        PdfArray pdfArray = new PdfArray();
                        pdfArray.add(PdfName.CRYPT);
                        pdfStream.put(PdfName.FILTER, pdfArray);
                    }
                    if (!this.append && pdfObject2 != null) {
                        this.body.add(pdfStream, pdfObject2.getIndRef());
                    } else {
                        catalog.put(PdfName.METADATA, this.body.add(pdfStream).getIndirectReference());
                        markUsed(catalog);
                    }
                }
            }
            xmpReader = new XmpReader(bArr);
            if (!xmpReader.replaceNode(PdfSchema.DEFAULT_XPATH_URI, "Producer", unicodeString) && !xmpReader.replaceDescriptionAttribute(PdfSchema.DEFAULT_XPATH_URI, "Producer", unicodeString)) {
                xmpReader.add("rdf:Description", PdfSchema.DEFAULT_XPATH_URI, "Producer", unicodeString);
            }
            if (!xmpReader.replaceNode(XmpBasicSchema.DEFAULT_XPATH_URI, "ModifyDate", pdfDate.getW3CDate()) && !xmpReader.replaceDescriptionAttribute(XmpBasicSchema.DEFAULT_XPATH_URI, "ModifyDate", pdfDate.getW3CDate())) {
                xmpReader.add("rdf:Description", XmpBasicSchema.DEFAULT_XPATH_URI, "ModifyDate", pdfDate.getW3CDate());
            }
            if (!xmpReader.replaceNode(XmpBasicSchema.DEFAULT_XPATH_URI, "MetadataDate", pdfDate.getW3CDate())) {
                xmpReader.replaceDescriptionAttribute(XmpBasicSchema.DEFAULT_XPATH_URI, "MetadataDate", pdfDate.getW3CDate());
            }
            pdfStream = new PdfStream(xmpReader.serializeDoc());
            pdfStream.put(PdfName.TYPE, PdfName.METADATA);
            pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
            if (this.crypto != null) {
                PdfArray pdfArray2 = new PdfArray();
                pdfArray2.add(PdfName.CRYPT);
                pdfStream.put(PdfName.FILTER, pdfArray2);
            }
            if (!this.append) {
            }
            catalog.put(PdfName.METADATA, this.body.add(pdfStream).getIndirectReference());
            markUsed(catalog);
        }
        close(indirectReference, number);
    }

    protected void close(PdfIndirectReference pdfIndirectReference, int i) throws IOException {
        PdfObject createInfoId;
        try {
            this.file.reOpen();
            alterContents();
            int number = ((PRIndirectReference) this.reader.trailer.get(PdfName.ROOT)).getNumber();
            if (this.append) {
                int[] keys = this.marked.getKeys();
                for (int i2 = 0; i2 < keys.length; i2++) {
                    int i3 = keys[i2];
                    PdfObject pdfObjectRelease = this.reader.getPdfObjectRelease(i3);
                    if (pdfObjectRelease != null && i != i3 && i3 < this.initialXrefSize) {
                        addToBody(pdfObjectRelease, i3, i3 != number);
                    }
                }
                for (int i4 = this.initialXrefSize; i4 < this.reader.getXrefSize(); i4++) {
                    PdfObject pdfObject = this.reader.getPdfObject(i4);
                    if (pdfObject != null) {
                        addToBody(pdfObject, getNewObjectNumber(this.reader, i4, 0));
                    }
                }
            } else {
                int i5 = 1;
                while (i5 < this.reader.getXrefSize()) {
                    PdfObject pdfObjectRelease2 = this.reader.getPdfObjectRelease(i5);
                    if (pdfObjectRelease2 != null && i != i5) {
                        addToBody(pdfObjectRelease2, getNewObjectNumber(this.reader, i5, 0), i5 != number);
                    }
                    i5++;
                }
            }
            PdfIndirectReference pdfIndirectReference2 = null;
            if (this.crypto != null) {
                if (this.append) {
                    pdfIndirectReference2 = this.reader.getCryptoRef();
                } else {
                    pdfIndirectReference2 = addToBody((PdfObject) this.crypto.getEncryptionDictionary(), false).getIndirectReference();
                }
                createInfoId = this.crypto.getFileID();
            } else {
                createInfoId = PdfEncryption.createInfoId(PdfEncryption.createDocumentId());
            }
            PdfIndirectReference pdfIndirectReference3 = new PdfIndirectReference(0, getNewObjectNumber(this.reader, ((PRIndirectReference) this.reader.trailer.get(PdfName.ROOT)).getNumber(), 0));
            this.body.writeCrossReferenceTable(this.f19587os, pdfIndirectReference3, pdfIndirectReference, pdfIndirectReference2, createInfoId, this.prevxref);
            if (this.fullCompression) {
                writeKeyInfo(this.f19587os);
                this.f19587os.write(getISOBytes("startxref\n"));
                this.f19587os.write(getISOBytes(String.valueOf(this.body.offset())));
                this.f19587os.write(getISOBytes("\n%%EOF\n"));
            } else {
                new PdfWriter.PdfTrailer(this.body.size(), this.body.offset(), pdfIndirectReference3, pdfIndirectReference, pdfIndirectReference2, createInfoId, this.prevxref).toPdf(this, this.f19587os);
            }
            this.f19587os.flush();
            if (isCloseStream()) {
                this.f19587os.close();
            }
            this.reader.close();
        } finally {
            try {
                this.file.close();
            } catch (Exception unused) {
            }
        }
    }

    void applyRotation(PdfDictionary pdfDictionary, ByteBuffer byteBuffer) {
        if (this.rotateContents) {
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

    protected void alterContents() throws IOException {
        PdfArray pdfArray;
        for (PageStamp pageStamp : this.pagesToContent.values()) {
            PdfDictionary pdfDictionary = pageStamp.pageN;
            markUsed(pdfDictionary);
            PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(PdfName.CONTENTS), pdfDictionary);
            if (pdfObject == null) {
                pdfArray = new PdfArray();
                pdfDictionary.put(PdfName.CONTENTS, pdfArray);
            } else if (pdfObject.isArray()) {
                pdfArray = (PdfArray) pdfObject;
                markUsed(pdfArray);
            } else if (pdfObject.isStream()) {
                pdfArray = new PdfArray();
                pdfArray.add(pdfDictionary.get(PdfName.CONTENTS));
                pdfDictionary.put(PdfName.CONTENTS, pdfArray);
            } else {
                pdfArray = new PdfArray();
                pdfDictionary.put(PdfName.CONTENTS, pdfArray);
            }
            ByteBuffer byteBuffer = new ByteBuffer();
            if (pageStamp.under != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(pdfDictionary, byteBuffer);
                byteBuffer.append(pageStamp.under.getInternalBuffer());
                byteBuffer.append(PdfContents.RESTORESTATE);
            }
            if (pageStamp.over != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
            }
            PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
            pdfStream.flateCompress(this.compressionLevel);
            pdfArray.addFirst(addToBody(pdfStream).getIndirectReference());
            byteBuffer.reset();
            if (pageStamp.over != null) {
                byteBuffer.append(TokenParser.f24154SP);
                byteBuffer.append(PdfContents.RESTORESTATE);
                ByteBuffer internalBuffer = pageStamp.over.getInternalBuffer();
                byteBuffer.append(internalBuffer.getBuffer(), 0, pageStamp.replacePoint);
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(pdfDictionary, byteBuffer);
                byteBuffer.append(internalBuffer.getBuffer(), pageStamp.replacePoint, internalBuffer.size() - pageStamp.replacePoint);
                byteBuffer.append(PdfContents.RESTORESTATE);
                PdfStream pdfStream2 = new PdfStream(byteBuffer.toByteArray());
                pdfStream2.flateCompress(this.compressionLevel);
                pdfArray.add(addToBody(pdfStream2).getIndirectReference());
            }
            alterResources(pageStamp);
        }
    }

    void alterResources(PageStamp pageStamp) {
        pageStamp.pageN.put(PdfName.RESOURCES, pageStamp.pageResources.getResources());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        IntHashtable intHashtable = this.readers2intrefs.get(pdfReader);
        if (intHashtable != null) {
            int i3 = intHashtable.get(i);
            if (i3 == 0) {
                int indirectReferenceNumber = getIndirectReferenceNumber();
                intHashtable.put(i, indirectReferenceNumber);
                return indirectReferenceNumber;
            }
            return i3;
        } else if (this.currentPdfReaderInstance == null) {
            if (!this.append || i >= this.initialXrefSize) {
                int i4 = this.myXref.get(i);
                if (i4 == 0) {
                    int indirectReferenceNumber2 = getIndirectReferenceNumber();
                    this.myXref.put(i, indirectReferenceNumber2);
                    return indirectReferenceNumber2;
                }
                return i4;
            }
            return i;
        } else {
            return this.currentPdfReaderInstance.getNewObjectNumber(i, i2);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        if (this.readers2intrefs.containsKey(pdfReader)) {
            RandomAccessFileOrArray randomAccessFileOrArray = this.readers2file.get(pdfReader);
            return randomAccessFileOrArray != null ? randomAccessFileOrArray : pdfReader.getSafeFile();
        } else if (this.currentPdfReaderInstance == null) {
            return this.file;
        } else {
            return this.currentPdfReaderInstance.getReaderFile();
        }
    }

    public void registerReader(PdfReader pdfReader, boolean z) throws IOException {
        if (this.readers2intrefs.containsKey(pdfReader)) {
            return;
        }
        this.readers2intrefs.put(pdfReader, new IntHashtable());
        if (z) {
            RandomAccessFileOrArray safeFile = pdfReader.getSafeFile();
            this.readers2file.put(pdfReader, safeFile);
            safeFile.reOpen();
        }
    }

    public void unRegisterReader(PdfReader pdfReader) {
        if (this.readers2intrefs.containsKey(pdfReader)) {
            this.readers2intrefs.remove(pdfReader);
            RandomAccessFileOrArray randomAccessFileOrArray = this.readers2file.get(pdfReader);
            if (randomAccessFileOrArray == null) {
                return;
            }
            this.readers2file.remove(pdfReader);
            try {
                randomAccessFileOrArray.close();
            } catch (Exception unused) {
            }
        }
    }

    static void findAllObjects(PdfReader pdfReader, PdfObject pdfObject, IntHashtable intHashtable) {
        while (pdfObject != null) {
            int type = pdfObject.type();
            if (type == 10) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                if (pdfReader != pRIndirectReference.getReader() || intHashtable.containsKey(pRIndirectReference.getNumber())) {
                    return;
                }
                intHashtable.put(pRIndirectReference.getNumber(), 1);
                pdfObject = PdfReader.getPdfObject(pdfObject);
            } else {
                switch (type) {
                    case 5:
                        PdfArray pdfArray = (PdfArray) pdfObject;
                        for (int i = 0; i < pdfArray.size(); i++) {
                            findAllObjects(pdfReader, pdfArray.getPdfObject(i), intHashtable);
                        }
                        return;
                    case 6:
                    case 7:
                        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                        for (PdfName pdfName : pdfDictionary.getKeys()) {
                            findAllObjects(pdfReader, pdfDictionary.get(pdfName), intHashtable);
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.itextpdf.text.pdf.PdfStamperImp] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.itextpdf.text.pdf.PdfObject] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.itextpdf.text.pdf.PdfObject] */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.itextpdf.text.pdf.PdfDictionary] */
    public void addComments(FdfReader fdfReader) throws IOException {
        PdfDictionary asDict;
        PdfArray asArray;
        PdfObject pdfObject;
        PdfObject pdfObject2;
        if (this.readers2intrefs.containsKey(fdfReader) || (asDict = fdfReader.getCatalog().getAsDict(PdfName.FDF)) == null || (asArray = asDict.getAsArray(PdfName.ANNOTS)) == null || asArray.size() == 0) {
            return;
        }
        registerReader(fdfReader, false);
        IntHashtable intHashtable = new IntHashtable();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < asArray.size(); i++) {
            PdfObject pdfObject3 = asArray.getPdfObject(i);
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pdfObject3);
            PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.PAGE);
            if (asNumber != null && asNumber.intValue() < this.reader.getNumberOfPages()) {
                findAllObjects(fdfReader, pdfObject3, intHashtable);
                arrayList.add(pdfObject3);
                if (pdfObject3.type() == 10 && (pdfObject2 = PdfReader.getPdfObject(pdfDictionary.get(PdfName.f19745NM))) != null && pdfObject2.type() == 3) {
                    hashMap.put(pdfObject2.toString(), pdfObject3);
                }
            }
        }
        int[] keys = intHashtable.getKeys();
        for (int i2 : keys) {
            ?? pdfObject4 = fdfReader.getPdfObject(i2);
            if (pdfObject4.type() == 6) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject4;
                PdfObject pdfObject5 = PdfReader.getPdfObject(pdfDictionary2.get(PdfName.IRT));
                if (pdfObject5 != null && pdfObject5.type() == 3 && (pdfObject = (PdfObject) hashMap.get(pdfObject5.toString())) != null) {
                    pdfObject4 = new PdfDictionary();
                    pdfObject4.merge(pdfDictionary2);
                    pdfObject4.put(PdfName.IRT, pdfObject);
                }
            }
            addToBody(pdfObject4, getNewObjectNumber(fdfReader, i2, 0));
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PdfObject pdfObject6 = (PdfObject) arrayList.get(i3);
            PdfDictionary pageN = this.reader.getPageN(((PdfDictionary) PdfReader.getPdfObject(pdfObject6)).getAsNumber(PdfName.PAGE).intValue() + 1);
            PdfArray pdfArray = (PdfArray) PdfReader.getPdfObject(pageN.get(PdfName.ANNOTS), pageN);
            if (pdfArray == null) {
                pdfArray = new PdfArray();
                pageN.put(PdfName.ANNOTS, pdfArray);
                markUsed(pageN);
            }
            markUsed(pdfArray);
            pdfArray.add(pdfObject6);
        }
    }

    PageStamp getPageStamp(int i) {
        PdfDictionary pageN = this.reader.getPageN(i);
        PageStamp pageStamp = this.pagesToContent.get(pageN);
        if (pageStamp == null) {
            PageStamp pageStamp2 = new PageStamp(this, this.reader, pageN);
            this.pagesToContent.put(pageN, pageStamp2);
            return pageStamp2;
        }
        return pageStamp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfContentByte getUnderContent(int i) {
        if (i <= 0 || i > this.reader.getNumberOfPages()) {
            return null;
        }
        PageStamp pageStamp = getPageStamp(i);
        if (pageStamp.under == null) {
            pageStamp.under = new StampContent(this, pageStamp);
        }
        return pageStamp.under;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfContentByte getOverContent(int i) {
        if (i <= 0 || i > this.reader.getNumberOfPages()) {
            return null;
        }
        PageStamp pageStamp = getPageStamp(i);
        if (pageStamp.over == null) {
            pageStamp.over = new StampContent(this, pageStamp);
        }
        return pageStamp.over;
    }

    void correctAcroFieldPages(int i) {
        if (this.acroFields != null && i <= this.reader.getNumberOfPages()) {
            for (AcroFields.Item item : this.acroFields.getFields().values()) {
                for (int i2 = 0; i2 < item.size(); i2++) {
                    int intValue = item.getPage(i2).intValue();
                    if (intValue >= i) {
                        item.forcePage(i2, intValue + 1);
                    }
                }
            }
        }
    }

    private static void moveRectangle(PdfDictionary pdfDictionary, PdfReader pdfReader, int i, PdfName pdfName, String str) {
        Rectangle boxSize = pdfReader.getBoxSize(i, str);
        if (boxSize == null) {
            pdfDictionary.remove(pdfName);
        } else {
            pdfDictionary.put(pdfName, new PdfRectangle(boxSize));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replacePage(PdfReader pdfReader, int i, int i2) {
        PdfDictionary pageN = this.reader.getPageN(i2);
        if (this.pagesToContent.containsKey(pageN)) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("this.page.cannot.be.replaced.new.content.was.already.added", new Object[0]));
        }
        PdfImportedPage importedPage = getImportedPage(pdfReader, i);
        PdfDictionary pageNRelease = this.reader.getPageNRelease(i2);
        pageNRelease.remove(PdfName.RESOURCES);
        pageNRelease.remove(PdfName.CONTENTS);
        moveRectangle(pageNRelease, pdfReader, i, PdfName.MEDIABOX, "media");
        moveRectangle(pageNRelease, pdfReader, i, PdfName.CROPBOX, "crop");
        moveRectangle(pageNRelease, pdfReader, i, PdfName.TRIMBOX, "trim");
        moveRectangle(pageNRelease, pdfReader, i, PdfName.ARTBOX, "art");
        moveRectangle(pageNRelease, pdfReader, i, PdfName.BLEEDBOX, "bleed");
        pageNRelease.put(PdfName.ROTATE, new PdfNumber(pdfReader.getPageRotation(i)));
        getOverContent(i2).addTemplate(importedPage, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        PageStamp pageStamp = this.pagesToContent.get(pageN);
        pageStamp.replacePoint = pageStamp.over.getInternalBuffer().size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertPage(int i, Rectangle rectangle) {
        PdfDictionary pdfDictionary;
        PdfObject pdfObject;
        Rectangle rectangle2 = new Rectangle(rectangle);
        int rotation = rectangle2.getRotation() % 360;
        PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.PAGE);
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        PdfArray pdfArray = new PdfArray();
        pdfArray.add(PdfName.PDF);
        pdfArray.add(PdfName.TEXT);
        pdfArray.add(PdfName.IMAGEB);
        pdfArray.add(PdfName.IMAGEC);
        pdfArray.add(PdfName.IMAGEI);
        pdfDictionary3.put(PdfName.PROCSET, pdfArray);
        pdfDictionary2.put(PdfName.RESOURCES, pdfDictionary3);
        pdfDictionary2.put(PdfName.ROTATE, new PdfNumber(rotation));
        pdfDictionary2.put(PdfName.MEDIABOX, new PdfRectangle(rectangle2, rotation));
        PRIndirectReference addPdfObject = this.reader.addPdfObject(pdfDictionary2);
        if (i > this.reader.getNumberOfPages()) {
            PdfReader pdfReader = this.reader;
            pdfObject = new PRIndirectReference(this.reader, ((PRIndirectReference) pdfReader.getPageNRelease(pdfReader.getNumberOfPages()).get(PdfName.PARENT)).getNumber());
            pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pdfObject);
            PdfArray pdfArray2 = (PdfArray) PdfReader.getPdfObject(pdfDictionary.get(PdfName.KIDS), pdfDictionary);
            pdfArray2.add(addPdfObject);
            markUsed(pdfArray2);
            this.reader.pageRefs.insertPage(i, addPdfObject);
        } else {
            if (i <= 0) {
                i = 1;
            }
            PdfDictionary pageN = this.reader.getPageN(i);
            PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(i);
            this.reader.releasePage(i);
            PdfObject pRIndirectReference = new PRIndirectReference(this.reader, ((PRIndirectReference) pageN.get(PdfName.PARENT)).getNumber());
            pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
            PdfArray pdfArray3 = (PdfArray) PdfReader.getPdfObject(pdfDictionary.get(PdfName.KIDS), pdfDictionary);
            int size = pdfArray3.size();
            int number = pageOrigRef.getNumber();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (number == ((PRIndirectReference) pdfArray3.getPdfObject(i2)).getNumber()) {
                    pdfArray3.add(i2, addPdfObject);
                    break;
                } else {
                    i2++;
                }
            }
            if (size == pdfArray3.size()) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("internal.inconsistence", new Object[0]));
            }
            markUsed(pdfArray3);
            this.reader.pageRefs.insertPage(i, addPdfObject);
            correctAcroFieldPages(i);
            pdfObject = pRIndirectReference;
        }
        pdfDictionary2.put(PdfName.PARENT, pdfObject);
        while (pdfDictionary != null) {
            markUsed(pdfDictionary);
            pdfDictionary.put(PdfName.COUNT, new PdfNumber(((PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.COUNT))).intValue() + 1));
            pdfDictionary = pdfDictionary.getAsDict(PdfName.PARENT);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isRotateContents() {
        return this.rotateContents;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRotateContents(boolean z) {
        this.rotateContents = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isContentWritten() {
        return this.body.size() > 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AcroFields getAcroFields() {
        if (this.acroFields == null) {
            this.acroFields = new AcroFields(this.reader, this);
        }
        return this.acroFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFormFlattening(boolean z) {
        this.flat = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFreeTextFlattening(boolean z) {
        this.flatFreeText = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean partialFormFlattening(String str) {
        getAcroFields();
        if (this.acroFields.getXfa().isXfaPresent()) {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("partial.form.flattening.is.not.supported.with.xfa.forms", new Object[0]));
        }
        if (this.acroFields.getFields().containsKey(str)) {
            this.partialFlattening.add(str);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void flatFields() {
        /*
            Method dump skipped, instructions count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStamperImp.flatFields():void");
    }

    void eliminateAcroformObjects() {
        PdfObject pdfObject = this.reader.getCatalog().get(PdfName.ACROFORM);
        if (pdfObject == null) {
            return;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pdfObject);
        this.reader.killXref(pdfDictionary.get(PdfName.XFA));
        pdfDictionary.remove(PdfName.XFA);
        PdfObject pdfObject2 = pdfDictionary.get(PdfName.FIELDS);
        if (pdfObject2 != null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.put(PdfName.KIDS, pdfObject2);
            sweepKids(pdfDictionary2);
            PdfReader.killIndirect(pdfObject2);
            pdfDictionary.put(PdfName.FIELDS, new PdfArray());
        }
        pdfDictionary.remove(PdfName.SIGFLAGS);
        pdfDictionary.remove(PdfName.NEEDAPPEARANCES);
        pdfDictionary.remove(PdfName.f19706DR);
    }

    void sweepKids(PdfObject pdfObject) {
        PdfArray pdfArray;
        PdfObject killIndirect = PdfReader.killIndirect(pdfObject);
        if (killIndirect == null || !killIndirect.isDictionary() || (pdfArray = (PdfArray) PdfReader.killIndirect(((PdfDictionary) killIndirect).get(PdfName.KIDS))) == null) {
            return;
        }
        for (int i = 0; i < pdfArray.size(); i++) {
            sweepKids(pdfArray.getPdfObject(i));
        }
    }

    protected void flatFreeTextFields() {
        PdfObject pdfObject;
        PdfName asName;
        PdfIndirectReference pdfIndirectReference;
        if (this.append) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("freetext.flattening.is.not.supported.in.append.mode", new Object[0]));
        }
        for (int i = 1; i <= this.reader.getNumberOfPages(); i++) {
            PdfDictionary pageN = this.reader.getPageN(i);
            PdfArray asArray = pageN.getAsArray(PdfName.ANNOTS);
            if (asArray != null) {
                for (int i2 = 0; i2 < asArray.size(); i2++) {
                    PdfObject directObject = asArray.getDirectObject(i2);
                    if (!(directObject instanceof PdfIndirectReference) || directObject.isIndirect()) {
                        PdfDictionary pdfDictionary = (PdfDictionary) directObject;
                        if (((PdfName) pdfDictionary.get(PdfName.SUBTYPE)).equals(PdfName.FREETEXT)) {
                            PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.f19712F);
                            int intValue = asNumber != null ? asNumber.intValue() : 0;
                            if ((intValue & 4) != 0 && (intValue & 2) == 0 && (pdfObject = pdfDictionary.get(PdfName.f19682AP)) != null) {
                                if (pdfObject instanceof PdfIndirectReference) {
                                    pdfObject = PdfReader.getPdfObject(pdfObject);
                                }
                                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject;
                                PdfObject pdfObject2 = pdfDictionary2.get(PdfName.f19739N);
                                PdfAppearance pdfAppearance = null;
                                PdfObject pdfObject3 = PdfReader.getPdfObject(pdfObject2);
                                if ((pdfObject2 instanceof PdfIndirectReference) && !pdfObject2.isIndirect()) {
                                    pdfAppearance = new PdfAppearance((PdfIndirectReference) pdfObject2);
                                } else if (pdfObject3 instanceof PdfStream) {
                                    ((PdfDictionary) pdfObject3).put(PdfName.SUBTYPE, PdfName.FORM);
                                    pdfAppearance = new PdfAppearance((PdfIndirectReference) pdfObject2);
                                } else if (pdfObject3.isDictionary() && (asName = pdfDictionary2.getAsName(PdfName.f19683AS)) != null && (pdfIndirectReference = (PdfIndirectReference) ((PdfDictionary) pdfObject3).get(asName)) != null) {
                                    pdfAppearance = new PdfAppearance(pdfIndirectReference);
                                    if (pdfIndirectReference.isIndirect()) {
                                        ((PdfDictionary) PdfReader.getPdfObject(pdfIndirectReference)).put(PdfName.SUBTYPE, PdfName.FORM);
                                    }
                                }
                                if (pdfAppearance != null) {
                                    Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.RECT));
                                    PdfContentByte overContent = getOverContent(i);
                                    overContent.setLiteral("Q ");
                                    overContent.addTemplate(pdfAppearance, normalizedRectangle.getLeft(), normalizedRectangle.getBottom());
                                    overContent.setLiteral("q ");
                                }
                            }
                        }
                    }
                }
                int i3 = 0;
                while (i3 < asArray.size()) {
                    PdfDictionary asDict = asArray.getAsDict(i3);
                    if (asDict != null && PdfName.FREETEXT.equals(asDict.get(PdfName.SUBTYPE))) {
                        asArray.remove(i3);
                        i3--;
                    }
                    i3++;
                }
                if (asArray.isEmpty()) {
                    PdfReader.killIndirect(pageN.get(PdfName.ANNOTS));
                    pageN.remove(PdfName.ANNOTS);
                }
            }
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectReference getPageReference(int i) {
        PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(i);
        if (pageOrigRef != null) {
            return pageOrigRef;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("invalid.page.number.1", i));
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        throw new RuntimeException(MessageLocalization.getComposedMessage("unsupported.in.this.context.use.pdfstamper.addannotation", new Object[0]));
    }

    void addDocumentField(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary catalog = this.reader.getCatalog();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), catalog);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            catalog.put(PdfName.ACROFORM, pdfDictionary);
            markUsed(catalog);
        }
        PdfArray pdfArray = (PdfArray) PdfReader.getPdfObject(pdfDictionary.get(PdfName.FIELDS), pdfDictionary);
        if (pdfArray == null) {
            pdfArray = new PdfArray();
            pdfDictionary.put(PdfName.FIELDS, pdfArray);
            markUsed(pdfDictionary);
        }
        if (!pdfDictionary.contains(PdfName.f19700DA)) {
            pdfDictionary.put(PdfName.f19700DA, new PdfString("/Helv 0 Tf 0 g "));
            markUsed(pdfDictionary);
        }
        pdfArray.add(pdfIndirectReference);
        markUsed(pdfArray);
    }

    protected void addFieldResources() throws IOException {
        if (this.fieldTemplates.isEmpty()) {
            return;
        }
        PdfDictionary catalog = this.reader.getCatalog();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), catalog);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            catalog.put(PdfName.ACROFORM, pdfDictionary);
            markUsed(catalog);
        }
        PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObject(pdfDictionary.get(PdfName.f19706DR), pdfDictionary);
        if (pdfDictionary2 == null) {
            pdfDictionary2 = new PdfDictionary();
            pdfDictionary.put(PdfName.f19706DR, pdfDictionary2);
            markUsed(pdfDictionary);
        }
        markUsed(pdfDictionary2);
        Iterator<PdfTemplate> it = this.fieldTemplates.iterator();
        while (it.hasNext()) {
            PdfFormField.mergeResources(pdfDictionary2, (PdfDictionary) it.next().getResources(), this);
        }
        PdfDictionary asDict = pdfDictionary2.getAsDict(PdfName.FONT);
        if (asDict == null) {
            asDict = new PdfDictionary();
            pdfDictionary2.put(PdfName.FONT, asDict);
        }
        if (!asDict.contains(PdfName.HELV)) {
            PdfDictionary pdfDictionary3 = new PdfDictionary(PdfName.FONT);
            pdfDictionary3.put(PdfName.BASEFONT, PdfName.HELVETICA);
            pdfDictionary3.put(PdfName.ENCODING, PdfName.WIN_ANSI_ENCODING);
            pdfDictionary3.put(PdfName.NAME, PdfName.HELV);
            pdfDictionary3.put(PdfName.SUBTYPE, PdfName.TYPE1);
            asDict.put(PdfName.HELV, addToBody(pdfDictionary3).getIndirectReference());
        }
        if (!asDict.contains(PdfName.ZADB)) {
            PdfDictionary pdfDictionary4 = new PdfDictionary(PdfName.FONT);
            pdfDictionary4.put(PdfName.BASEFONT, PdfName.ZAPFDINGBATS);
            pdfDictionary4.put(PdfName.NAME, PdfName.ZADB);
            pdfDictionary4.put(PdfName.SUBTYPE, PdfName.TYPE1);
            asDict.put(PdfName.ZADB, addToBody(pdfDictionary4).getIndirectReference());
        }
        if (pdfDictionary.get(PdfName.f19700DA) == null) {
            pdfDictionary.put(PdfName.f19700DA, new PdfString("/Helv 0 Tf 0 g "));
            markUsed(pdfDictionary);
        }
    }

    void expandFields(PdfFormField pdfFormField, ArrayList<PdfAnnotation> arrayList) {
        arrayList.add(pdfFormField);
        ArrayList<PdfFormField> kids = pdfFormField.getKids();
        if (kids != null) {
            for (int i = 0; i < kids.size(); i++) {
                expandFields(kids.get(i), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0136 A[Catch: IOException -> 0x016f, TryCatch #0 {IOException -> 0x016f, blocks: (B:2:0x0000, B:4:0x000b, B:7:0x001a, B:10:0x0022, B:12:0x0028, B:14:0x0034, B:15:0x003e, B:17:0x0044, B:19:0x004a, B:21:0x0050, B:22:0x0055, B:24:0x005e, B:25:0x0065, B:27:0x006b, B:29:0x0077, B:32:0x007e, B:34:0x008e, B:36:0x009e, B:38:0x00a8, B:40:0x00b1, B:42:0x00b9, B:44:0x00c1, B:46:0x00c9, B:53:0x00e2, B:54:0x0107, B:55:0x0136, B:33:0x0081, B:56:0x015a, B:58:0x0160, B:8:0x001e), top: B:65:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addAnnotation(com.itextpdf.text.pdf.PdfAnnotation r11, com.itextpdf.text.pdf.PdfDictionary r12) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStamperImp.addAnnotation(com.itextpdf.text.pdf.PdfAnnotation, com.itextpdf.text.pdf.PdfDictionary):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.itextpdf.text.pdf.PdfWriter
    public void addAnnotation(PdfAnnotation pdfAnnotation, int i) {
        pdfAnnotation.setPage(i);
        addAnnotation(pdfAnnotation, this.reader.getPageN(i));
    }

    private void outlineTravel(PRIndirectReference pRIndirectReference) {
        while (pRIndirectReference != null) {
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pRIndirectReference);
            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfDictionary.get(PdfName.FIRST);
            if (pRIndirectReference2 != null) {
                outlineTravel(pRIndirectReference2);
            }
            PdfReader.killIndirect(pdfDictionary.get(PdfName.DEST));
            PdfReader.killIndirect(pdfDictionary.get(PdfName.f19679A));
            PdfReader.killIndirect(pRIndirectReference);
            pRIndirectReference = (PRIndirectReference) pdfDictionary.get(PdfName.NEXT);
        }
    }

    void deleteOutlines() {
        PdfDictionary catalog = this.reader.getCatalog();
        PdfObject pdfObject = catalog.get(PdfName.OUTLINES);
        if (pdfObject == null) {
            return;
        }
        if (pdfObject instanceof PRIndirectReference) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            outlineTravel(pRIndirectReference);
            PdfReader.killIndirect(pRIndirectReference);
        }
        catalog.remove(PdfName.OUTLINES);
        markUsed(catalog);
    }

    protected void setJavaScript() throws IOException {
        HashMap<String, PdfObject> documentLevelJS = this.pdf.getDocumentLevelJS();
        if (documentLevelJS.isEmpty()) {
            return;
        }
        PdfDictionary catalog = this.reader.getCatalog();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.NAMES), catalog);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            catalog.put(PdfName.NAMES, pdfDictionary);
            markUsed(catalog);
        }
        markUsed(pdfDictionary);
        pdfDictionary.put(PdfName.JAVASCRIPT, addToBody(PdfNameTree.writeTree(documentLevelJS, this)).getIndirectReference());
    }

    protected void addFileAttachments() throws IOException {
        HashMap<String, PdfObject> documentFileAttachment = this.pdf.getDocumentFileAttachment();
        if (documentFileAttachment.isEmpty()) {
            return;
        }
        PdfDictionary catalog = this.reader.getCatalog();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.NAMES), catalog);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            catalog.put(PdfName.NAMES, pdfDictionary);
            markUsed(catalog);
        }
        markUsed(pdfDictionary);
        HashMap<String, PdfObject> readTree = PdfNameTree.readTree((PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.EMBEDDEDFILES)));
        for (Map.Entry<String, PdfObject> entry : documentFileAttachment.entrySet()) {
            int i = 0;
            StringBuilder sb = new StringBuilder(entry.getKey());
            while (readTree.containsKey(sb.toString())) {
                i++;
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb.append(i);
            }
            readTree.put(sb.toString(), entry.getValue());
        }
        PdfObject writeTree = PdfNameTree.writeTree(readTree, this);
        PdfObject pdfObject = pdfDictionary.get(PdfName.EMBEDDEDFILES);
        if (pdfObject != null) {
            PdfReader.killIndirect(pdfObject);
        }
        pdfDictionary.put(PdfName.EMBEDDEDFILES, addToBody(writeTree).getIndirectReference());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void makePackage(PdfCollection pdfCollection) {
        this.reader.getCatalog().put(PdfName.COLLECTION, pdfCollection);
    }

    protected void setOutlines() throws IOException {
        if (this.newBookmarks == null) {
            return;
        }
        deleteOutlines();
        if (this.newBookmarks.isEmpty()) {
            return;
        }
        PdfDictionary catalog = this.reader.getCatalog();
        writeOutlines(catalog, catalog.get(PdfName.DESTS) != null);
        markUsed(catalog);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        this.useVp = true;
        this.viewerPreferences.setViewerPreferences(i);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.useVp = true;
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void setSigFlags(int i) {
        this.sigFlags = i | this.sigFlags;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfPageActions
    public void setPageAction(PdfName pdfName, PdfAction pdfAction) throws PdfException {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.setpageaction.pdfname.actiontype.pdfaction.action.int.page", new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPageAction(PdfName pdfName, PdfAction pdfAction, int i) throws PdfException {
        if (!pdfName.equals(PAGE_OPEN) && !pdfName.equals(PAGE_CLOSE)) {
            throw new PdfException(MessageLocalization.getComposedMessage("invalid.page.additional.action.type.1", pdfName.toString()));
        }
        PdfDictionary pageN = this.reader.getPageN(i);
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pageN.get(PdfName.f19680AA), pageN);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            pageN.put(PdfName.f19680AA, pdfDictionary);
            markUsed(pageN);
        }
        pdfDictionary.put(pdfName, pdfAction);
        markUsed(pdfDictionary);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfPageActions
    public void setDuration(int i) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.setpageaction.pdfname.actiontype.pdfaction.action.int.page", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfPageActions
    public void setTransition(PdfTransition pdfTransition) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.setpageaction.pdfname.actiontype.pdfaction.action.int.page", new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDuration(int i, int i2) {
        PdfDictionary pageN = this.reader.getPageN(i2);
        if (i < 0) {
            pageN.remove(PdfName.DUR);
        } else {
            pageN.put(PdfName.DUR, new PdfNumber(i));
        }
        markUsed(pageN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTransition(PdfTransition pdfTransition, int i) {
        PdfDictionary pageN = this.reader.getPageN(i);
        if (pdfTransition == null) {
            pageN.remove(PdfName.TRANS);
        } else {
            pageN.put(PdfName.TRANS, pdfTransition.getTransitionDictionary());
        }
        markUsed(pageN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void markUsed(PdfObject pdfObject) {
        PRIndirectReference indRef;
        if (!this.append || pdfObject == null) {
            return;
        }
        if (pdfObject.type() == 10) {
            indRef = (PRIndirectReference) pdfObject;
        } else {
            indRef = pdfObject.getIndRef();
        }
        if (indRef != null) {
            this.marked.put(indRef.getNumber(), 1);
        }
    }

    protected void markUsed(int i) {
        if (this.append) {
            this.marked.put(i, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAppend() {
        return this.append;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfDocumentActions
    public void setAdditionalAction(PdfName pdfName, PdfAction pdfAction) throws PdfException {
        if (!pdfName.equals(DOCUMENT_CLOSE) && !pdfName.equals(WILL_SAVE) && !pdfName.equals(DID_SAVE) && !pdfName.equals(WILL_PRINT) && !pdfName.equals(DID_PRINT)) {
            throw new PdfException(MessageLocalization.getComposedMessage("invalid.additional.action.type.1", pdfName.toString()));
        }
        PdfDictionary asDict = this.reader.getCatalog().getAsDict(PdfName.f19680AA);
        if (asDict == null) {
            if (pdfAction == null) {
                return;
            }
            asDict = new PdfDictionary();
            this.reader.getCatalog().put(PdfName.f19680AA, asDict);
        }
        markUsed(asDict);
        if (pdfAction == null) {
            asDict.remove(pdfName);
        } else {
            asDict.put(pdfName, pdfAction);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfDocumentActions
    public void setOpenAction(PdfAction pdfAction) {
        this.openAction = pdfAction;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfDocumentActions
    public void setOpenAction(String str) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("open.actions.by.name.are.not.supported", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void setThumbnail(Image image) {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.pdfstamper.setthumbnail", new Object[0]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setThumbnail(Image image, int i) throws PdfException, DocumentException {
        PdfIndirectReference imageReference = getImageReference(addDirectImageSimple(image));
        this.reader.resetReleasePage();
        this.reader.getPageN(i).put(PdfName.THUMB, imageReference);
        this.reader.resetReleasePage();
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfContentByte getDirectContentUnder() {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.pdfstamper.getundercontent.or.pdfstamper.getovercontent", new Object[0]));
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfContentByte getDirectContent() {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("use.pdfstamper.getundercontent.or.pdfstamper.getovercontent", new Object[0]));
    }

    protected void readOCProperties() {
        PdfDictionary asDict;
        if (this.documentOCG.isEmpty() && (asDict = this.reader.getCatalog().getAsDict(PdfName.OCPROPERTIES)) != null) {
            PdfArray asArray = asDict.getAsArray(PdfName.OCGS);
            HashMap hashMap = new HashMap();
            ListIterator<PdfObject> listIterator = asArray.listIterator();
            while (listIterator.hasNext()) {
                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) listIterator.next();
                PdfLayer pdfLayer = new PdfLayer(null);
                pdfLayer.setRef(pdfIndirectReference);
                pdfLayer.setOnPanel(false);
                pdfLayer.merge((PdfDictionary) PdfReader.getPdfObject(pdfIndirectReference));
                hashMap.put(pdfIndirectReference.toString(), pdfLayer);
            }
            PdfDictionary asDict2 = asDict.getAsDict(PdfName.f19699D);
            PdfArray asArray2 = asDict2.getAsArray(PdfName.OFF);
            if (asArray2 != null) {
                ListIterator<PdfObject> listIterator2 = asArray2.listIterator();
                while (listIterator2.hasNext()) {
                    ((PdfLayer) hashMap.get(((PdfIndirectReference) listIterator2.next()).toString())).setOn(false);
                }
            }
            PdfArray asArray3 = asDict2.getAsArray(PdfName.ORDER);
            if (asArray3 != null) {
                addOrder(null, asArray3, hashMap);
            }
            this.documentOCG.addAll(hashMap.values());
            this.OCGRadioGroup = asDict2.getAsArray(PdfName.RBGROUPS);
            if (this.OCGRadioGroup == null) {
                this.OCGRadioGroup = new PdfArray();
            }
            this.OCGLocked = asDict2.getAsArray(PdfName.LOCKED);
            if (this.OCGLocked == null) {
                this.OCGLocked = new PdfArray();
            }
        }
    }

    private void addOrder(PdfLayer pdfLayer, PdfArray pdfArray, Map<String, PdfLayer> map) {
        int i = 0;
        while (i < pdfArray.size()) {
            PdfObject pdfObject = pdfArray.getPdfObject(i);
            if (pdfObject.isIndirect()) {
                PdfLayer pdfLayer2 = map.get(pdfObject.toString());
                if (pdfLayer2 != null) {
                    pdfLayer2.setOnPanel(true);
                    registerLayer(pdfLayer2);
                    if (pdfLayer != null) {
                        pdfLayer.addChild(pdfLayer2);
                    }
                    int i2 = i + 1;
                    if (pdfArray.size() > i2 && pdfArray.getPdfObject(i2).isArray()) {
                        addOrder(pdfLayer2, (PdfArray) pdfArray.getPdfObject(i2), map);
                        i = i2;
                    }
                }
            } else if (pdfObject.isArray()) {
                PdfArray pdfArray2 = (PdfArray) pdfObject;
                if (pdfArray2.isEmpty()) {
                    return;
                }
                PdfObject pdfObject2 = pdfArray2.getPdfObject(0);
                if (pdfObject2.isString()) {
                    PdfLayer pdfLayer3 = new PdfLayer(pdfObject2.toString());
                    pdfLayer3.setOnPanel(true);
                    registerLayer(pdfLayer3);
                    if (pdfLayer != null) {
                        pdfLayer.addChild(pdfLayer3);
                    }
                    PdfArray pdfArray3 = new PdfArray();
                    ListIterator<PdfObject> listIterator = pdfArray2.listIterator();
                    while (listIterator.hasNext()) {
                        pdfArray3.add(listIterator.next());
                    }
                    addOrder(pdfLayer3, pdfArray3, map);
                } else {
                    addOrder(pdfLayer, (PdfArray) pdfObject2, map);
                }
            } else {
                continue;
            }
            i++;
        }
    }

    public Map<String, PdfLayer> getPdfLayers() {
        String title;
        if (this.documentOCG.isEmpty()) {
            readOCProperties();
        }
        HashMap hashMap = new HashMap();
        Iterator<PdfOCG> it = this.documentOCG.iterator();
        while (it.hasNext()) {
            PdfLayer pdfLayer = (PdfLayer) it.next();
            if (pdfLayer.getTitle() == null) {
                title = pdfLayer.getAsString(PdfName.NAME).toString();
            } else {
                title = pdfLayer.getTitle();
            }
            if (hashMap.containsKey(title)) {
                int i = 2;
                String str = title + "(2)";
                while (hashMap.containsKey(str)) {
                    i++;
                    str = title + "(" + i + ")";
                }
                title = str;
            }
            hashMap.put(title, pdfLayer);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PageStamp {
        StampContent over;
        PdfDictionary pageN;
        StampContent under;
        int replacePoint = 0;
        PageResources pageResources = new PageResources();

        PageStamp(PdfStamperImp pdfStamperImp, PdfReader pdfReader, PdfDictionary pdfDictionary) {
            this.pageN = pdfDictionary;
            this.pageResources.setOriginalResources(pdfDictionary.getAsDict(PdfName.RESOURCES), pdfStamperImp.namePtr);
        }
    }
}
