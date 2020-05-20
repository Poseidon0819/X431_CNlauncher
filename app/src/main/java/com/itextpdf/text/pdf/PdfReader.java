package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.exceptions.InvalidPdfException;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.pdf.FilterHandlers;
import com.itextpdf.text.pdf.IntHashtable;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.Key;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.zip.InflaterInputStream;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.RecipientInformation;

/* loaded from: classes.dex */
public class PdfReader implements PdfViewerPreferences {
    public static boolean unethicalreading = false;
    protected PRAcroForm acroForm;
    protected boolean acroFormParsed;
    private boolean appendable;
    protected PdfDictionary catalog;
    protected Certificate certificate;
    protected Key certificateKey;
    protected String certificateKeyProvider;
    protected boolean consolidateNamedDestinations;
    private PRIndirectReference cryptoRef;
    protected PdfEncryption decrypt;
    protected boolean encrypted;
    private boolean encryptionError;
    protected long eofPos;
    private long fileLength;
    protected int freeXref;
    private boolean hybridXref;
    protected long lastXref;
    private int lastXrefPartial;
    protected boolean newXrefType;
    private int objGen;
    private int objNum;
    protected HashMap<Integer, IntHashtable> objStmMark;
    protected LongHashtable objStmToOffset;
    private boolean ownerPasswordUsed;
    protected int pValue;
    protected PageRefs pageRefs;
    private boolean partial;
    protected byte[] password;
    protected char pdfVersion;
    protected int rValue;
    private int readDepth;
    protected boolean rebuilt;
    protected boolean remoteToLocalNamedDestinations;
    PdfDictionary rootPages;
    protected boolean sharedStreams;
    protected ArrayList<PdfString> strings;
    protected boolean tampered;
    protected PRTokeniser tokens;
    protected PdfDictionary trailer;
    private final PdfViewerPreferencesImp viewerPreferences;
    protected long[] xref;
    protected ArrayList<PdfObject> xrefObj;
    static final PdfName[] pageInhCandidates = {PdfName.MEDIABOX, PdfName.ROTATE, PdfName.RESOURCES, PdfName.CROPBOX};
    static final byte[] endstream = PdfEncodings.convertToBytes("endstream", (String) null);
    static final byte[] endobj = PdfEncodings.convertToBytes("endobj", (String) null);

    protected PdfReader() {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
    }

    public PdfReader(String str) throws IOException {
        this(str, (byte[]) null);
    }

    public PdfReader(String str, byte[] bArr) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr;
        this.tokens = new PRTokeniser(str);
        readPdf();
    }

    public PdfReader(byte[] bArr) throws IOException {
        this(bArr, (byte[]) null);
    }

    public PdfReader(byte[] bArr, byte[] bArr2) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr2;
        this.tokens = new PRTokeniser(bArr);
        readPdf();
    }

    public PdfReader(String str, Certificate certificate, Key key, String str2) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.certificate = certificate;
        this.certificateKey = key;
        this.certificateKeyProvider = str2;
        this.tokens = new PRTokeniser(str);
        readPdf();
    }

    public PdfReader(URL url) throws IOException {
        this(url, (byte[]) null);
    }

    public PdfReader(URL url, byte[] bArr) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr;
        this.tokens = new PRTokeniser(new RandomAccessFileOrArray(url));
        readPdf();
    }

    public PdfReader(InputStream inputStream, byte[] bArr) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr;
        this.tokens = new PRTokeniser(new RandomAccessFileOrArray(inputStream));
        readPdf();
    }

    public PdfReader(InputStream inputStream) throws IOException {
        this(inputStream, (byte[]) null);
    }

    public PdfReader(RandomAccessFileOrArray randomAccessFileOrArray, byte[] bArr) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr;
        this.partial = true;
        this.tokens = new PRTokeniser(randomAccessFileOrArray);
        readPdfPartial();
    }

    public PdfReader(PdfReader pdfReader) {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList<>();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.remoteToLocalNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.appendable = pdfReader.appendable;
        this.consolidateNamedDestinations = pdfReader.consolidateNamedDestinations;
        this.encrypted = pdfReader.encrypted;
        this.rebuilt = pdfReader.rebuilt;
        this.sharedStreams = pdfReader.sharedStreams;
        this.tampered = pdfReader.tampered;
        this.password = pdfReader.password;
        this.pdfVersion = pdfReader.pdfVersion;
        this.eofPos = pdfReader.eofPos;
        this.freeXref = pdfReader.freeXref;
        this.lastXref = pdfReader.lastXref;
        this.tokens = new PRTokeniser(pdfReader.tokens.getSafeFile());
        PdfEncryption pdfEncryption = pdfReader.decrypt;
        if (pdfEncryption != null) {
            this.decrypt = new PdfEncryption(pdfEncryption);
        }
        this.pValue = pdfReader.pValue;
        this.rValue = pdfReader.rValue;
        this.xrefObj = new ArrayList<>(pdfReader.xrefObj);
        for (int i = 0; i < pdfReader.xrefObj.size(); i++) {
            this.xrefObj.set(i, duplicatePdfObject(pdfReader.xrefObj.get(i), this));
        }
        this.pageRefs = new PageRefs(pdfReader.pageRefs, this);
        this.trailer = (PdfDictionary) duplicatePdfObject(pdfReader.trailer, this);
        this.catalog = this.trailer.getAsDict(PdfName.ROOT);
        this.rootPages = this.catalog.getAsDict(PdfName.PAGES);
        this.fileLength = pdfReader.fileLength;
        this.partial = pdfReader.partial;
        this.hybridXref = pdfReader.hybridXref;
        this.objStmToOffset = pdfReader.objStmToOffset;
        this.xref = pdfReader.xref;
        this.cryptoRef = (PRIndirectReference) duplicatePdfObject(pdfReader.cryptoRef, this);
        this.ownerPasswordUsed = pdfReader.ownerPasswordUsed;
    }

    public RandomAccessFileOrArray getSafeFile() {
        return this.tokens.getSafeFile();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PdfReaderInstance getPdfReaderInstance(PdfWriter pdfWriter) {
        return new PdfReaderInstance(this, pdfWriter);
    }

    public int getNumberOfPages() {
        return this.pageRefs.size();
    }

    public PdfDictionary getCatalog() {
        return this.catalog;
    }

    public PRAcroForm getAcroForm() {
        if (!this.acroFormParsed) {
            this.acroFormParsed = true;
            PdfObject pdfObject = this.catalog.get(PdfName.ACROFORM);
            if (pdfObject != null) {
                try {
                    this.acroForm = new PRAcroForm(this);
                    this.acroForm.readAcroForm((PdfDictionary) getPdfObject(pdfObject));
                } catch (Exception unused) {
                    this.acroForm = null;
                }
            }
        }
        return this.acroForm;
    }

    public int getPageRotation(int i) {
        return getPageRotation(this.pageRefs.getPageNRelease(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPageRotation(PdfDictionary pdfDictionary) {
        PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.ROTATE);
        if (asNumber == null) {
            return 0;
        }
        int intValue = asNumber.intValue() % 360;
        return intValue < 0 ? intValue + 360 : intValue;
    }

    public Rectangle getPageSizeWithRotation(int i) {
        return getPageSizeWithRotation(this.pageRefs.getPageNRelease(i));
    }

    public Rectangle getPageSizeWithRotation(PdfDictionary pdfDictionary) {
        Rectangle pageSize = getPageSize(pdfDictionary);
        for (int pageRotation = getPageRotation(pdfDictionary); pageRotation > 0; pageRotation -= 90) {
            pageSize = pageSize.rotate();
        }
        return pageSize;
    }

    public Rectangle getPageSize(int i) {
        return getPageSize(this.pageRefs.getPageNRelease(i));
    }

    public Rectangle getPageSize(PdfDictionary pdfDictionary) {
        return getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.MEDIABOX));
    }

    public Rectangle getCropBox(int i) {
        PdfDictionary pageNRelease = this.pageRefs.getPageNRelease(i);
        PdfArray pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.CROPBOX));
        if (pdfArray == null) {
            return getPageSize(pageNRelease);
        }
        return getNormalizedRectangle(pdfArray);
    }

    public Rectangle getBoxSize(int i, String str) {
        PdfArray pdfArray;
        PdfDictionary pageNRelease = this.pageRefs.getPageNRelease(i);
        if (str.equals("trim")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.TRIMBOX));
        } else if (str.equals("art")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.ARTBOX));
        } else if (str.equals("bleed")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.BLEEDBOX));
        } else if (str.equals("crop")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.CROPBOX));
        } else {
            pdfArray = str.equals("media") ? (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.MEDIABOX)) : null;
        }
        if (pdfArray == null) {
            return null;
        }
        return getNormalizedRectangle(pdfArray);
    }

    public HashMap<String, String> getInfo() {
        HashMap<String, String> hashMap = new HashMap<>();
        PdfDictionary asDict = this.trailer.getAsDict(PdfName.INFO);
        if (asDict == null) {
            return hashMap;
        }
        for (PdfName pdfName : asDict.getKeys()) {
            PdfObject pdfObject = getPdfObject(asDict.get(pdfName));
            if (pdfObject != null) {
                String pdfObject2 = pdfObject.toString();
                switch (pdfObject.type()) {
                    case 3:
                        pdfObject2 = ((PdfString) pdfObject).toUnicodeString();
                        break;
                    case 4:
                        pdfObject2 = PdfName.decodeName(pdfObject2);
                        break;
                }
                hashMap.put(PdfName.decodeName(pdfName.toString()), pdfObject2);
            }
        }
        return hashMap;
    }

    public static Rectangle getNormalizedRectangle(PdfArray pdfArray) {
        float floatValue = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(0))).floatValue();
        float floatValue2 = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(1))).floatValue();
        float floatValue3 = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(2))).floatValue();
        float floatValue4 = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(3))).floatValue();
        return new Rectangle(Math.min(floatValue, floatValue3), Math.min(floatValue2, floatValue4), Math.max(floatValue, floatValue3), Math.max(floatValue2, floatValue4));
    }

    protected void readPdf() throws IOException {
        try {
            this.fileLength = this.tokens.getFile().length();
            this.pdfVersion = this.tokens.checkPdfHeader();
            try {
                readXref();
            } catch (Exception e) {
                try {
                    this.rebuilt = true;
                    rebuildXref();
                    this.lastXref = -1L;
                } catch (Exception e2) {
                    throw new InvalidPdfException(MessageLocalization.getComposedMessage("rebuild.failed.1.original.message.2", e2.getMessage(), e.getMessage()));
                }
            }
            try {
                readDocObj();
            } catch (Exception e3) {
                if (e3 instanceof BadPasswordException) {
                    throw new BadPasswordException(e3.getMessage());
                }
                if (this.rebuilt || this.encryptionError) {
                    throw new InvalidPdfException(e3.getMessage());
                }
                this.rebuilt = true;
                this.encrypted = false;
                try {
                    rebuildXref();
                    this.lastXref = -1L;
                    readDocObj();
                } catch (Exception e4) {
                    throw new InvalidPdfException(MessageLocalization.getComposedMessage("rebuild.failed.1.original.message.2", e4.getMessage(), e3.getMessage()));
                }
            }
            this.strings.clear();
            readPages();
            eliminateSharedStreams();
            removeUnusedObjects();
        } finally {
            try {
                this.tokens.close();
            } catch (Exception unused) {
            }
        }
    }

    protected void readPdfPartial() throws IOException {
        try {
            this.fileLength = this.tokens.getFile().length();
            this.pdfVersion = this.tokens.checkPdfHeader();
            try {
                readXref();
            } catch (Exception e) {
                try {
                    this.rebuilt = true;
                    rebuildXref();
                    this.lastXref = -1L;
                } catch (Exception e2) {
                    throw new InvalidPdfException(MessageLocalization.getComposedMessage("rebuild.failed.1.original.message.2", e2.getMessage(), e.getMessage()));
                }
            }
            readDocObjPartial();
            readPages();
        } catch (IOException e3) {
            try {
                this.tokens.close();
            } catch (Exception unused) {
            }
            throw e3;
        }
    }

    private boolean equalsArray(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private void readDecryptedDocObj() throws IOException {
        PdfObject pdfObject;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        int i;
        byte[] bArr4;
        int i2;
        PdfArray pdfArray;
        if (this.encrypted || (pdfObject = this.trailer.get(PdfName.ENCRYPT)) == null || pdfObject.toString().equals("null")) {
            return;
        }
        this.encryptionError = true;
        this.encrypted = true;
        PdfDictionary pdfDictionary = (PdfDictionary) getPdfObject(pdfObject);
        PdfArray asArray = this.trailer.getAsArray(PdfName.f19730ID);
        if (asArray != null) {
            PdfObject pdfObject2 = asArray.getPdfObject(0);
            this.strings.remove(pdfObject2);
            bArr = DocWriter.getISOBytes(pdfObject2.toString());
            if (asArray.size() > 1) {
                this.strings.remove(asArray.getPdfObject(1));
            }
        } else {
            bArr = null;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.FILTER));
        int i3 = 128;
        if (pdfObjectRelease.equals(PdfName.STANDARD)) {
            String pdfObject3 = pdfDictionary.get(PdfName.f19783U).toString();
            this.strings.remove(pdfDictionary.get(PdfName.f19783U));
            byte[] iSOBytes = DocWriter.getISOBytes(pdfObject3);
            String pdfObject4 = pdfDictionary.get(PdfName.f19746O).toString();
            this.strings.remove(pdfDictionary.get(PdfName.f19746O));
            byte[] iSOBytes2 = DocWriter.getISOBytes(pdfObject4);
            if (pdfDictionary.contains(PdfName.f19748OE)) {
                this.strings.remove(pdfDictionary.get(PdfName.f19748OE));
            }
            if (pdfDictionary.contains(PdfName.f19784UE)) {
                this.strings.remove(pdfDictionary.get(PdfName.f19784UE));
            }
            if (pdfDictionary.contains(PdfName.PERMS)) {
                this.strings.remove(pdfDictionary.get(PdfName.PERMS));
            }
            PdfObject pdfObject5 = pdfDictionary.get(PdfName.f19752P);
            if (!pdfObject5.isNumber()) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.p.value", new Object[0]));
            }
            this.pValue = ((PdfNumber) pdfObject5).intValue();
            PdfObject pdfObject6 = pdfDictionary.get(PdfName.f19760R);
            if (!pdfObject6.isNumber()) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.r.value", new Object[0]));
            }
            this.rValue = ((PdfNumber) pdfObject6).intValue();
            int i4 = this.rValue;
            switch (i4) {
                case 2:
                    bArr4 = iSOBytes2;
                    bArr2 = iSOBytes;
                    bArr3 = null;
                    i = 0;
                    i3 = 0;
                    break;
                case 3:
                    PdfObject pdfObject7 = pdfDictionary.get(PdfName.LENGTH);
                    if (!pdfObject7.isNumber()) {
                        throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.length.value", new Object[0]));
                    }
                    int intValue = ((PdfNumber) pdfObject7).intValue();
                    if (intValue > 128 || intValue < 40 || intValue % 8 != 0) {
                        throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.length.value", new Object[0]));
                    }
                    bArr4 = iSOBytes2;
                    bArr2 = iSOBytes;
                    i3 = intValue;
                    bArr3 = null;
                    i = 1;
                    break;
                case 4:
                    PdfDictionary pdfDictionary2 = (PdfDictionary) pdfDictionary.get(PdfName.f19694CF);
                    if (pdfDictionary2 == null) {
                        throw new InvalidPdfException(MessageLocalization.getComposedMessage("cf.not.found.encryption", new Object[0]));
                    }
                    PdfDictionary pdfDictionary3 = (PdfDictionary) pdfDictionary2.get(PdfName.STDCF);
                    if (pdfDictionary3 == null) {
                        throw new InvalidPdfException(MessageLocalization.getComposedMessage("stdcf.not.found.encryption", new Object[0]));
                    }
                    if (PdfName.f19788V2.equals(pdfDictionary3.get(PdfName.CFM))) {
                        i = 1;
                    } else if (!PdfName.AESV2.equals(pdfDictionary3.get(PdfName.CFM))) {
                        throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("no.compatible.encryption.found", new Object[0]));
                    } else {
                        i = 2;
                    }
                    PdfObject pdfObject8 = pdfDictionary.get(PdfName.ENCRYPTMETADATA);
                    if (pdfObject8 != null && pdfObject8.toString().equals(PdfBoolean.FALSE)) {
                        i |= 8;
                        bArr4 = iSOBytes2;
                        bArr2 = iSOBytes;
                        bArr3 = null;
                        i3 = 0;
                        break;
                    }
                    bArr4 = iSOBytes2;
                    bArr2 = iSOBytes;
                    bArr3 = null;
                    i3 = 0;
                    break;
                case 5:
                    PdfObject pdfObject9 = pdfDictionary.get(PdfName.ENCRYPTMETADATA);
                    if (pdfObject9 == null || !pdfObject9.toString().equals(PdfBoolean.FALSE)) {
                        i = 3;
                        bArr4 = iSOBytes2;
                        bArr2 = iSOBytes;
                        bArr3 = null;
                        i3 = 0;
                        break;
                    } else {
                        i = 11;
                        bArr4 = iSOBytes2;
                        bArr2 = iSOBytes;
                        bArr3 = null;
                        i3 = 0;
                        break;
                    }
                default:
                    throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("unknown.encryption.type.r.eq.1", i4));
            }
        } else if (pdfObjectRelease.equals(PdfName.PUBSEC)) {
            PdfObject pdfObject10 = pdfDictionary.get(PdfName.f19787V);
            if (!pdfObject10.isNumber()) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.v.value", new Object[0]));
            }
            int intValue2 = ((PdfNumber) pdfObject10).intValue();
            if (intValue2 != 4) {
                switch (intValue2) {
                    case 1:
                        pdfArray = (PdfArray) pdfDictionary.get(PdfName.RECIPIENTS);
                        i2 = 0;
                        i3 = 40;
                        break;
                    case 2:
                        PdfObject pdfObject11 = pdfDictionary.get(PdfName.LENGTH);
                        if (!pdfObject11.isNumber()) {
                            throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.length.value", new Object[0]));
                        }
                        int intValue3 = ((PdfNumber) pdfObject11).intValue();
                        if (intValue3 > 128 || intValue3 < 40 || intValue3 % 8 != 0) {
                            throw new InvalidPdfException(MessageLocalization.getComposedMessage("illegal.length.value", new Object[0]));
                        }
                        i3 = intValue3;
                        pdfArray = (PdfArray) pdfDictionary.get(PdfName.RECIPIENTS);
                        i2 = 1;
                        break;
                    default:
                        throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("unknown.encryption.type.v.eq.1", this.rValue));
                }
            } else {
                PdfDictionary pdfDictionary4 = (PdfDictionary) pdfDictionary.get(PdfName.f19694CF);
                if (pdfDictionary4 == null) {
                    throw new InvalidPdfException(MessageLocalization.getComposedMessage("cf.not.found.encryption", new Object[0]));
                }
                PdfDictionary pdfDictionary5 = (PdfDictionary) pdfDictionary4.get(PdfName.DEFAULTCRYPTFILTER);
                if (pdfDictionary5 == null) {
                    throw new InvalidPdfException(MessageLocalization.getComposedMessage("defaultcryptfilter.not.found.encryption", new Object[0]));
                }
                if (PdfName.f19788V2.equals(pdfDictionary5.get(PdfName.CFM))) {
                    i2 = 1;
                } else if (!PdfName.AESV2.equals(pdfDictionary5.get(PdfName.CFM))) {
                    throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("no.compatible.encryption.found", new Object[0]));
                } else {
                    i2 = 2;
                }
                PdfObject pdfObject12 = pdfDictionary5.get(PdfName.ENCRYPTMETADATA);
                if (pdfObject12 != null && pdfObject12.toString().equals(PdfBoolean.FALSE)) {
                    i2 |= 8;
                }
                pdfArray = (PdfArray) pdfDictionary5.get(PdfName.RECIPIENTS);
            }
            boolean z = false;
            byte[] bArr5 = null;
            for (int i5 = 0; i5 < pdfArray.size(); i5++) {
                PdfObject pdfObject13 = pdfArray.getPdfObject(i5);
                this.strings.remove(pdfObject13);
                try {
                    for (RecipientInformation recipientInformation : new CMSEnvelopedData(pdfObject13.getBytes()).getRecipientInfos().getRecipients()) {
                        if (recipientInformation.getRID().match(this.certificate) && !z) {
                            bArr5 = PdfEncryptor.getContent(recipientInformation, (PrivateKey) this.certificateKey, this.certificateKeyProvider);
                            z = true;
                        }
                    }
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            }
            if (!z || bArr5 == null) {
                throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("bad.certificate.and.key", new Object[0]));
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(bArr5, 0, 20);
                for (int i6 = 0; i6 < pdfArray.size(); i6++) {
                    messageDigest.update(pdfArray.getPdfObject(i6).getBytes());
                }
                if ((i2 & 8) != 0) {
                    messageDigest.update(new byte[]{-1, -1, -1, -1});
                }
                bArr3 = messageDigest.digest();
                i = i2;
                bArr2 = null;
                bArr4 = null;
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            bArr2 = null;
            bArr3 = null;
            i = 0;
            i3 = 0;
            bArr4 = null;
        }
        this.decrypt = new PdfEncryption();
        this.decrypt.setCryptoMode(i, i3);
        if (pdfObjectRelease.equals(PdfName.STANDARD)) {
            if (this.rValue == 5) {
                this.ownerPasswordUsed = this.decrypt.readKey(pdfDictionary, this.password);
                this.pValue = this.decrypt.getPermissions();
            } else {
                this.decrypt.setupByOwnerPassword(bArr, this.password, bArr2, bArr4, this.pValue);
                byte[] bArr6 = this.decrypt.userKey;
                int i7 = this.rValue;
                int i8 = 32;
                if (!equalsArray(bArr2, bArr6, (i7 == 3 || i7 == 4) ? 16 : 32)) {
                    this.decrypt.setupByUserPassword(bArr, this.password, bArr4, this.pValue);
                    byte[] bArr7 = this.decrypt.userKey;
                    int i9 = this.rValue;
                    if (!equalsArray(bArr2, bArr7, (i9 == 3 || i9 == 4) ? 16 : 16)) {
                        throw new BadPasswordException(MessageLocalization.getComposedMessage("bad.user.password", new Object[0]));
                    }
                } else {
                    this.ownerPasswordUsed = true;
                }
            }
        } else if (pdfObjectRelease.equals(PdfName.PUBSEC)) {
            this.decrypt.setupByEncryptionKey(bArr3, i3);
            this.ownerPasswordUsed = true;
        }
        for (int i10 = 0; i10 < this.strings.size(); i10++) {
            this.strings.get(i10).decrypt(this);
        }
        if (pdfObject.isIndirect()) {
            this.cryptoRef = (PRIndirectReference) pdfObject;
            this.xrefObj.set(this.cryptoRef.getNumber(), null);
        }
        this.encryptionError = false;
    }

    public static PdfObject getPdfObjectRelease(PdfObject pdfObject) {
        PdfObject pdfObject2 = getPdfObject(pdfObject);
        releaseLastXrefPartial(pdfObject);
        return pdfObject2;
    }

    public static PdfObject getPdfObject(PdfObject pdfObject) {
        if (pdfObject == null) {
            return null;
        }
        if (pdfObject.isIndirect()) {
            try {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                int number = pRIndirectReference.getNumber();
                boolean z = pRIndirectReference.getReader().appendable;
                PdfObject pdfObject2 = pRIndirectReference.getReader().getPdfObject(number);
                if (pdfObject2 == null) {
                    return null;
                }
                if (z) {
                    int type = pdfObject2.type();
                    if (type == 1) {
                        pdfObject2 = new PdfBoolean(((PdfBoolean) pdfObject2).booleanValue());
                    } else if (type == 4) {
                        pdfObject2 = new PdfName(pdfObject2.getBytes());
                    } else if (type == 8) {
                        pdfObject2 = new PdfNull();
                    }
                    pdfObject2.setIndRef(pRIndirectReference);
                }
                return pdfObject2;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
        return pdfObject;
    }

    public static PdfObject getPdfObjectRelease(PdfObject pdfObject, PdfObject pdfObject2) {
        PdfObject pdfObject3 = getPdfObject(pdfObject, pdfObject2);
        releaseLastXrefPartial(pdfObject);
        return pdfObject3;
    }

    public static PdfObject getPdfObject(PdfObject pdfObject, PdfObject pdfObject2) {
        PRIndirectReference indRef;
        if (pdfObject == null) {
            return null;
        }
        if (pdfObject.isIndirect()) {
            return getPdfObject(pdfObject);
        }
        if (pdfObject2 != null && (indRef = pdfObject2.getIndRef()) != null && indRef.getReader().isAppendable()) {
            int type = pdfObject.type();
            if (type == 1) {
                pdfObject = new PdfBoolean(((PdfBoolean) pdfObject).booleanValue());
            } else if (type == 4) {
                pdfObject = new PdfName(pdfObject.getBytes());
            } else if (type == 8) {
                pdfObject = new PdfNull();
            }
            pdfObject.setIndRef(indRef);
        }
        return pdfObject;
    }

    public PdfObject getPdfObjectRelease(int i) {
        PdfObject pdfObject = getPdfObject(i);
        releaseLastXrefPartial();
        return pdfObject;
    }

    public PdfObject getPdfObject(int i) {
        try {
            this.lastXrefPartial = -1;
            if (i >= 0 && i < this.xrefObj.size()) {
                PdfObject pdfObject = this.xrefObj.get(i);
                if (this.partial && pdfObject == null) {
                    if (i * 2 >= this.xref.length) {
                        return null;
                    }
                    PdfObject readSingleObject = readSingleObject(i);
                    this.lastXrefPartial = -1;
                    if (readSingleObject != null) {
                        this.lastXrefPartial = i;
                    }
                    return readSingleObject;
                }
                return pdfObject;
            }
            return null;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void resetLastXrefPartial() {
        this.lastXrefPartial = -1;
    }

    public void releaseLastXrefPartial() {
        int i;
        if (!this.partial || (i = this.lastXrefPartial) == -1) {
            return;
        }
        this.xrefObj.set(i, null);
        this.lastXrefPartial = -1;
    }

    public static void releaseLastXrefPartial(PdfObject pdfObject) {
        int i;
        if (pdfObject != null && pdfObject.isIndirect() && (pdfObject instanceof PRIndirectReference)) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            PdfReader reader = pRIndirectReference.getReader();
            if (reader.partial && (i = reader.lastXrefPartial) != -1 && i == pRIndirectReference.getNumber()) {
                reader.xrefObj.set(reader.lastXrefPartial, null);
            }
            reader.lastXrefPartial = -1;
        }
    }

    private void setXrefPartialObject(int i, PdfObject pdfObject) {
        if (!this.partial || i < 0) {
            return;
        }
        this.xrefObj.set(i, pdfObject);
    }

    public PRIndirectReference addPdfObject(PdfObject pdfObject) {
        this.xrefObj.add(pdfObject);
        return new PRIndirectReference(this, this.xrefObj.size() - 1);
    }

    protected void readPages() throws IOException {
        this.catalog = this.trailer.getAsDict(PdfName.ROOT);
        this.rootPages = this.catalog.getAsDict(PdfName.PAGES);
        this.pageRefs = new PageRefs();
    }

    protected void readDocObjPartial() throws IOException {
        long[] keys;
        this.xrefObj = new ArrayList<>(this.xref.length / 2);
        this.xrefObj.addAll(Collections.nCopies(this.xref.length / 2, null));
        readDecryptedDocObj();
        LongHashtable longHashtable = this.objStmToOffset;
        if (longHashtable != null) {
            for (long j : longHashtable.getKeys()) {
                int i = (int) (2 * j);
                this.objStmToOffset.put(j, this.xref[i]);
                this.xref[i] = -1;
            }
        }
    }

    protected PdfObject readSingleObject(int i) throws IOException {
        PdfObject pdfObject;
        this.strings.clear();
        int i2 = i * 2;
        long[] jArr = this.xref;
        long j = jArr[i2];
        if (j < 0) {
            return null;
        }
        int i3 = i2 + 1;
        if (jArr[i3] > 0) {
            j = this.objStmToOffset.get(jArr[i3]);
        }
        if (j == 0) {
            return null;
        }
        this.tokens.seek(j);
        this.tokens.nextValidToken();
        if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
            this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.object.number", new Object[0]));
        }
        this.objNum = this.tokens.intValue();
        this.tokens.nextValidToken();
        if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
            this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.generation.number", new Object[0]));
        }
        this.objGen = this.tokens.intValue();
        this.tokens.nextValidToken();
        if (!this.tokens.getStringValue().equals("obj")) {
            this.tokens.throwError(MessageLocalization.getComposedMessage("token.obj.expected", new Object[0]));
        }
        try {
            pdfObject = readPRObject();
            for (int i4 = 0; i4 < this.strings.size(); i4++) {
                this.strings.get(i4).decrypt(this);
            }
            if (pdfObject.isStream()) {
                checkPRStreamLength((PRStream) pdfObject);
            }
        } catch (Exception unused) {
            pdfObject = null;
        }
        long[] jArr2 = this.xref;
        if (jArr2[i3] > 0) {
            pdfObject = readOneObjStm((PRStream) pdfObject, (int) jArr2[i2]);
        }
        this.xrefObj.set(i, pdfObject);
        return pdfObject;
    }

    protected PdfObject readOneObjStm(PRStream pRStream, int i) throws IOException {
        PdfObject readPRObject;
        int intValue = pRStream.getAsNumber(PdfName.FIRST).intValue();
        byte[] streamBytes = getStreamBytes(pRStream, this.tokens.getFile());
        PRTokeniser pRTokeniser = this.tokens;
        this.tokens = new PRTokeniser(streamBytes);
        int i2 = i + 1;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            try {
                z = this.tokens.nextToken();
                if (!z) {
                    break;
                } else if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
                    z = false;
                    break;
                } else {
                    z = this.tokens.nextToken();
                    if (!z) {
                        break;
                    } else if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
                        z = false;
                        break;
                    } else {
                        i4 = this.tokens.intValue() + intValue;
                        i3++;
                    }
                }
            } catch (Throwable th) {
                this.tokens = pRTokeniser;
                throw th;
            }
        }
        if (!z) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("error.reading.objstm", new Object[0]));
        }
        long j = i4;
        this.tokens.seek(j);
        this.tokens.nextToken();
        if (this.tokens.getTokenType() == PRTokeniser.TokenType.NUMBER) {
            readPRObject = new PdfNumber(this.tokens.getStringValue());
        } else {
            this.tokens.seek(j);
            readPRObject = readPRObject();
        }
        this.tokens = pRTokeniser;
        return readPRObject;
    }

    public double dumpPerc() {
        int i = 0;
        for (int i2 = 0; i2 < this.xrefObj.size(); i2++) {
            if (this.xrefObj.get(i2) != null) {
                i++;
            }
        }
        double d = i;
        Double.isNaN(d);
        double size = this.xrefObj.size();
        Double.isNaN(size);
        return (d * 100.0d) / size;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void readDocObj() throws IOException {
        int i;
        PdfObject pdfObject;
        ArrayList arrayList = new ArrayList();
        int i2 = 2;
        this.xrefObj = new ArrayList<>(this.xref.length / 2);
        this.xrefObj.addAll(Collections.nCopies(this.xref.length / 2, null));
        while (true) {
            long[] jArr = this.xref;
            if (i2 >= jArr.length) {
                break;
            }
            long j = jArr[i2];
            if (j > 0 && jArr[i2 + 1] <= 0) {
                this.tokens.seek(j);
                this.tokens.nextValidToken();
                if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
                    this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.object.number", new Object[0]));
                }
                this.objNum = this.tokens.intValue();
                this.tokens.nextValidToken();
                if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
                    this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.generation.number", new Object[0]));
                }
                this.objGen = this.tokens.intValue();
                this.tokens.nextValidToken();
                if (!this.tokens.getStringValue().equals("obj")) {
                    this.tokens.throwError(MessageLocalization.getComposedMessage("token.obj.expected", new Object[0]));
                }
                try {
                    pdfObject = readPRObject();
                    if (pdfObject.isStream()) {
                        arrayList.add((PRStream) pdfObject);
                    }
                } catch (Exception unused) {
                    pdfObject = null;
                }
                this.xrefObj.set(i2 / 2, pdfObject);
            }
            i2 += 2;
        }
        for (i = 0; i < arrayList.size(); i++) {
            checkPRStreamLength((PRStream) arrayList.get(i));
        }
        readDecryptedDocObj();
        HashMap<Integer, IntHashtable> hashMap = this.objStmMark;
        if (hashMap != null) {
            for (Map.Entry<Integer, IntHashtable> entry : hashMap.entrySet()) {
                int intValue = entry.getKey().intValue();
                readObjStm((PRStream) this.xrefObj.get(intValue), entry.getValue());
                this.xrefObj.set(intValue, null);
            }
            this.objStmMark = null;
        }
        this.xref = null;
    }

    private void checkPRStreamLength(PRStream pRStream) throws IOException {
        long j;
        long length = this.tokens.length();
        long offset = pRStream.getOffset();
        PdfObject pdfObjectRelease = getPdfObjectRelease(pRStream.get(PdfName.LENGTH));
        boolean z = true;
        if (pdfObjectRelease == null || pdfObjectRelease.type() != 2) {
            j = 0;
        } else {
            j = ((PdfNumber) pdfObjectRelease).intValue();
            long j2 = j + offset;
            if (j2 <= length - 20) {
                this.tokens.seek(j2);
                String readString = this.tokens.readString(20);
                if (readString.startsWith("\nendstream") || readString.startsWith("\r\nendstream") || readString.startsWith("\rendstream") || readString.startsWith("endstream")) {
                    z = false;
                }
            }
        }
        if (z) {
            byte[] bArr = new byte[16];
            this.tokens.seek(offset);
            while (true) {
                long filePointer = this.tokens.getFilePointer();
                if (!this.tokens.readLineSegment(bArr)) {
                    break;
                } else if (equalsn(bArr, endstream)) {
                    j = filePointer - offset;
                    break;
                } else if (equalsn(bArr, endobj)) {
                    long j3 = filePointer - 16;
                    this.tokens.seek(j3);
                    int indexOf = this.tokens.readString(16).indexOf("endstream");
                    if (indexOf >= 0) {
                        filePointer = j3 + indexOf;
                    }
                    j = filePointer - offset;
                }
            }
        }
        pRStream.setLength((int) j);
    }

    protected void readObjStm(PRStream pRStream, IntHashtable intHashtable) throws IOException {
        PdfObject readPRObject;
        int intValue = pRStream.getAsNumber(PdfName.FIRST).intValue();
        int intValue2 = pRStream.getAsNumber(PdfName.f19739N).intValue();
        byte[] streamBytes = getStreamBytes(pRStream, this.tokens.getFile());
        PRTokeniser pRTokeniser = this.tokens;
        this.tokens = new PRTokeniser(streamBytes);
        try {
            int[] iArr = new int[intValue2];
            int[] iArr2 = new int[intValue2];
            int i = 0;
            boolean z = true;
            while (true) {
                if (i >= intValue2) {
                    break;
                }
                z = this.tokens.nextToken();
                if (!z) {
                    break;
                } else if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
                    z = false;
                    break;
                } else {
                    iArr2[i] = this.tokens.intValue();
                    z = this.tokens.nextToken();
                    if (!z) {
                        break;
                    } else if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
                        z = false;
                        break;
                    } else {
                        iArr[i] = this.tokens.intValue() + intValue;
                        i++;
                    }
                }
            }
            if (!z) {
                throw new InvalidPdfException(MessageLocalization.getComposedMessage("error.reading.objstm", new Object[0]));
            }
            for (int i2 = 0; i2 < intValue2; i2++) {
                if (intHashtable.containsKey(i2)) {
                    this.tokens.seek(iArr[i2]);
                    this.tokens.nextToken();
                    if (this.tokens.getTokenType() == PRTokeniser.TokenType.NUMBER) {
                        readPRObject = new PdfNumber(this.tokens.getStringValue());
                    } else {
                        this.tokens.seek(iArr[i2]);
                        readPRObject = readPRObject();
                    }
                    this.xrefObj.set(iArr2[i2], readPRObject);
                }
            }
        } finally {
            this.tokens = pRTokeniser;
        }
    }

    public static PdfObject killIndirect(PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.isNull()) {
            return null;
        }
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfObject);
        if (pdfObject.isIndirect()) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            PdfReader reader = pRIndirectReference.getReader();
            int number = pRIndirectReference.getNumber();
            reader.xrefObj.set(number, null);
            if (reader.partial) {
                reader.xref[number * 2] = -1;
            }
        }
        return pdfObjectRelease;
    }

    private void ensureXrefSize(int i) {
        if (i == 0) {
            return;
        }
        long[] jArr = this.xref;
        if (jArr == null) {
            this.xref = new long[i];
        } else if (jArr.length < i) {
            long[] jArr2 = new long[i];
            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
            this.xref = jArr2;
        }
    }

    protected void readXref() throws IOException {
        this.hybridXref = false;
        this.newXrefType = false;
        PRTokeniser pRTokeniser = this.tokens;
        pRTokeniser.seek(pRTokeniser.getStartxref());
        this.tokens.nextToken();
        if (!this.tokens.getStringValue().equals("startxref")) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("startxref.not.found", new Object[0]));
        }
        this.tokens.nextToken();
        if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("startxref.is.not.followed.by.a.number", new Object[0]));
        }
        long longValue = this.tokens.longValue();
        this.lastXref = longValue;
        this.eofPos = this.tokens.getFilePointer();
        try {
            if (readXRefStream(longValue)) {
                this.newXrefType = true;
                return;
            }
        } catch (Exception unused) {
        }
        this.xref = null;
        this.tokens.seek(longValue);
        this.trailer = readXrefSection();
        PdfDictionary pdfDictionary = this.trailer;
        while (true) {
            PdfNumber pdfNumber = (PdfNumber) pdfDictionary.get(PdfName.PREV);
            if (pdfNumber == null) {
                return;
            }
            this.tokens.seek(pdfNumber.longValue());
            pdfDictionary = readXrefSection();
        }
    }

    protected PdfDictionary readXrefSection() throws IOException {
        this.tokens.nextValidToken();
        if (!this.tokens.getStringValue().equals("xref")) {
            this.tokens.throwError(MessageLocalization.getComposedMessage("xref.subsection.not.found", new Object[0]));
        }
        while (true) {
            this.tokens.nextValidToken();
            if (this.tokens.getStringValue().equals("trailer")) {
                break;
            }
            if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("object.number.of.the.first.object.in.this.xref.subsection.not.found", new Object[0]));
            }
            int intValue = this.tokens.intValue();
            this.tokens.nextValidToken();
            if (this.tokens.getTokenType() != PRTokeniser.TokenType.NUMBER) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("number.of.entries.in.this.xref.subsection.not.found", new Object[0]));
            }
            int intValue2 = this.tokens.intValue() + intValue;
            if (intValue == 1) {
                long filePointer = this.tokens.getFilePointer();
                this.tokens.nextValidToken();
                long longValue = this.tokens.longValue();
                this.tokens.nextValidToken();
                int intValue3 = this.tokens.intValue();
                if (longValue == 0 && intValue3 == 65535) {
                    intValue--;
                    intValue2--;
                }
                this.tokens.seek(filePointer);
            }
            ensureXrefSize(intValue2 * 2);
            while (intValue < intValue2) {
                this.tokens.nextValidToken();
                long longValue2 = this.tokens.longValue();
                this.tokens.nextValidToken();
                this.tokens.intValue();
                this.tokens.nextValidToken();
                int i = intValue * 2;
                if (this.tokens.getStringValue().equals("n")) {
                    long[] jArr = this.xref;
                    if (jArr[i] == 0 && jArr[i + 1] == 0) {
                        jArr[i] = longValue2;
                    }
                } else if (this.tokens.getStringValue().equals("f")) {
                    long[] jArr2 = this.xref;
                    if (jArr2[i] == 0 && jArr2[i + 1] == 0) {
                        jArr2[i] = -1;
                    }
                } else {
                    this.tokens.throwError(MessageLocalization.getComposedMessage("invalid.cross.reference.entry.in.this.xref.subsection", new Object[0]));
                }
                intValue++;
            }
        }
        PdfDictionary pdfDictionary = (PdfDictionary) readPRObject();
        ensureXrefSize(((PdfNumber) pdfDictionary.get(PdfName.SIZE)).intValue() * 2);
        PdfObject pdfObject = pdfDictionary.get(PdfName.XREFSTM);
        if (pdfObject != null && pdfObject.isNumber()) {
            try {
                readXRefStream(((PdfNumber) pdfObject).intValue());
                this.newXrefType = true;
                this.hybridXref = true;
            } catch (IOException e) {
                this.xref = null;
                throw e;
            }
        }
        return pdfDictionary;
    }

    protected boolean readXRefStream(long j) throws IOException {
        PdfArray pdfArray;
        long j2;
        byte[] bArr;
        int i;
        this.tokens.seek(j);
        char c = 0;
        if (this.tokens.nextToken() && this.tokens.getTokenType() == PRTokeniser.TokenType.NUMBER) {
            int intValue = this.tokens.intValue();
            if (this.tokens.nextToken() && this.tokens.getTokenType() == PRTokeniser.TokenType.NUMBER && this.tokens.nextToken() && this.tokens.getStringValue().equals("obj")) {
                PdfObject readPRObject = readPRObject();
                if (readPRObject.isStream()) {
                    PRStream pRStream = (PRStream) readPRObject;
                    if (PdfName.XREF.equals(pRStream.get(PdfName.TYPE))) {
                        if (this.trailer == null) {
                            this.trailer = new PdfDictionary();
                            this.trailer.putAll(pRStream);
                        }
                        pRStream.setLength(((PdfNumber) pRStream.get(PdfName.LENGTH)).intValue());
                        int intValue2 = ((PdfNumber) pRStream.get(PdfName.SIZE)).intValue();
                        PdfObject pdfObject = pRStream.get(PdfName.INDEX);
                        char c2 = 1;
                        if (pdfObject == null) {
                            pdfArray = new PdfArray();
                            pdfArray.add(new int[]{0, intValue2});
                        } else {
                            pdfArray = (PdfArray) pdfObject;
                        }
                        PdfArray pdfArray2 = (PdfArray) pRStream.get(PdfName.f19791W);
                        PdfObject pdfObject2 = pRStream.get(PdfName.PREV);
                        long longValue = pdfObject2 != null ? ((PdfNumber) pdfObject2).longValue() : -1L;
                        ensureXrefSize(intValue2 * 2);
                        if (this.objStmMark == null && !this.partial) {
                            this.objStmMark = new HashMap<>();
                        }
                        if (this.objStmToOffset == null && this.partial) {
                            this.objStmToOffset = new LongHashtable();
                        }
                        byte[] streamBytes = getStreamBytes(pRStream, this.tokens.getFile());
                        int[] iArr = new int[3];
                        for (int i2 = 0; i2 < 3; i2++) {
                            iArr[i2] = pdfArray2.getAsNumber(i2).intValue();
                        }
                        int i3 = 0;
                        int i4 = 0;
                        while (i3 < pdfArray.size()) {
                            int intValue3 = pdfArray.getAsNumber(i3).intValue();
                            int intValue4 = pdfArray.getAsNumber(i3 + 1).intValue();
                            ensureXrefSize((intValue3 + intValue4) * 2);
                            while (true) {
                                int i5 = intValue4 - 1;
                                if (intValue4 > 0) {
                                    if (iArr[c] > 0) {
                                        int i6 = i4;
                                        int i7 = 0;
                                        i = 0;
                                        while (i7 < iArr[c]) {
                                            int i8 = (i << 8) + (streamBytes[i6] & 255);
                                            i7++;
                                            i6++;
                                            i = i8;
                                        }
                                        i4 = i6;
                                        bArr = streamBytes;
                                    } else {
                                        bArr = streamBytes;
                                        i = 1;
                                    }
                                    int i9 = i4;
                                    long j3 = 0;
                                    int i10 = 0;
                                    while (i10 < iArr[c2]) {
                                        j3 = (j3 << 8) + (bArr[i9] & 255);
                                        i10++;
                                        pdfArray = pdfArray;
                                        i9++;
                                        c2 = 1;
                                    }
                                    PdfArray pdfArray3 = pdfArray;
                                    int i11 = i9;
                                    int i12 = 0;
                                    int i13 = 0;
                                    for (char c3 = 2; i12 < iArr[c3]; c3 = 2) {
                                        i13 = (i13 << 8) + (bArr[i11] & 255);
                                        i12++;
                                        i11++;
                                    }
                                    int i14 = intValue3 * 2;
                                    long[] jArr = this.xref;
                                    int i15 = i11;
                                    int[] iArr2 = iArr;
                                    if (jArr[i14] == 0) {
                                        int i16 = i14 + 1;
                                        if (jArr[i16] == 0) {
                                            switch (i) {
                                                case 0:
                                                    jArr[i14] = -1;
                                                    break;
                                                case 1:
                                                    jArr[i14] = j3;
                                                    break;
                                                case 2:
                                                    jArr[i14] = i13;
                                                    jArr[i16] = j3;
                                                    if (this.partial) {
                                                        this.objStmToOffset.put(j3, 0L);
                                                        break;
                                                    } else {
                                                        Integer valueOf = Integer.valueOf((int) j3);
                                                        IntHashtable intHashtable = this.objStmMark.get(valueOf);
                                                        if (intHashtable == null) {
                                                            IntHashtable intHashtable2 = new IntHashtable();
                                                            intHashtable2.put(i13, 1);
                                                            this.objStmMark.put(valueOf, intHashtable2);
                                                            break;
                                                        } else {
                                                            intHashtable.put(i13, 1);
                                                            break;
                                                        }
                                                    }
                                            }
                                        }
                                    }
                                    intValue3++;
                                    iArr = iArr2;
                                    streamBytes = bArr;
                                    intValue4 = i5;
                                    pdfArray = pdfArray3;
                                    i4 = i15;
                                    c = 0;
                                    c2 = 1;
                                }
                            }
                            i3 += 2;
                            c = 0;
                            c2 = 1;
                        }
                        int i17 = intValue * 2;
                        long[] jArr2 = this.xref;
                        if (i17 < jArr2.length) {
                            j2 = -1;
                            jArr2[i17] = -1;
                        } else {
                            j2 = -1;
                        }
                        if (longValue == j2) {
                            return true;
                        }
                        return readXRefStream(longValue);
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rebuildXref() throws IOException {
        this.hybridXref = false;
        this.newXrefType = false;
        long j = 0;
        this.tokens.seek(0L);
        long[][] jArr = new long[1024];
        String str = null;
        this.trailer = null;
        byte[] bArr = new byte[64];
        while (true) {
            long filePointer = this.tokens.getFilePointer();
            if (!this.tokens.readLineSegment(bArr)) {
                break;
            }
            if (bArr[0] == 116) {
                if (PdfEncodings.convertToString(bArr, str).startsWith("trailer")) {
                    this.tokens.seek(filePointer);
                    this.tokens.nextToken();
                    long filePointer2 = this.tokens.getFilePointer();
                    try {
                        PdfDictionary pdfDictionary = (PdfDictionary) readPRObject();
                        if (pdfDictionary.get(PdfName.ROOT) != null) {
                            this.trailer = pdfDictionary;
                        } else {
                            this.tokens.seek(filePointer2);
                        }
                    } catch (Exception unused) {
                        this.tokens.seek(filePointer2);
                    }
                }
            } else {
                if (bArr[0] >= 48 && bArr[0] <= 57) {
                    long[] checkObjectStart = PRTokeniser.checkObjectStart(bArr);
                    if (checkObjectStart != null) {
                        long j2 = checkObjectStart[0];
                        long j3 = checkObjectStart[1];
                        if (j2 >= jArr.length) {
                            long[][] jArr2 = new long[(int) (2 * j2)];
                            System.arraycopy(jArr, 0, jArr2, 0, (int) j);
                            jArr = jArr2;
                        }
                        if (j2 >= j) {
                            j = 1 + j2;
                        }
                        int i = (int) j2;
                        if (jArr[i] == null || j3 >= jArr[i][1]) {
                            checkObjectStart[0] = filePointer;
                            jArr[i] = checkObjectStart;
                        }
                    }
                }
                str = null;
            }
            str = null;
        }
        if (this.trailer == null) {
            throw new InvalidPdfException(MessageLocalization.getComposedMessage("trailer.not.found", new Object[0]));
        }
        this.xref = new long[(int) (2 * j)];
        for (int i2 = 0; i2 < j; i2++) {
            long[] jArr3 = jArr[i2];
            if (jArr3 != null) {
                this.xref[i2 * 2] = jArr3[0];
            }
        }
    }

    protected PdfDictionary readDictionary() throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (true) {
            this.tokens.nextValidToken();
            if (this.tokens.getTokenType() == PRTokeniser.TokenType.END_DIC) {
                return pdfDictionary;
            }
            if (this.tokens.getTokenType() != PRTokeniser.TokenType.NAME) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("dictionary.key.is.not.a.name", new Object[0]));
            }
            PdfName pdfName = new PdfName(this.tokens.getStringValue(), false);
            PdfObject readPRObject = readPRObject();
            int i = -readPRObject.type();
            if (i == PRTokeniser.TokenType.END_DIC.ordinal()) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("unexpected.gt.gt", new Object[0]));
            }
            if (i == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("unexpected.close.bracket", new Object[0]));
            }
            pdfDictionary.put(pdfName, readPRObject);
        }
    }

    protected PdfArray readArray() throws IOException {
        PdfArray pdfArray = new PdfArray();
        while (true) {
            PdfObject readPRObject = readPRObject();
            int i = -readPRObject.type();
            if (i == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                return pdfArray;
            }
            if (i == PRTokeniser.TokenType.END_DIC.ordinal()) {
                this.tokens.throwError(MessageLocalization.getComposedMessage("unexpected.gt.gt", new Object[0]));
            }
            pdfArray.add(readPRObject);
        }
    }

    protected PdfObject readPRObject() throws IOException {
        boolean nextToken;
        this.tokens.nextValidToken();
        PRTokeniser.TokenType tokenType = this.tokens.getTokenType();
        switch (tokenType) {
            case START_DIC:
                this.readDepth++;
                PdfDictionary readDictionary = readDictionary();
                this.readDepth--;
                long filePointer = this.tokens.getFilePointer();
                do {
                    nextToken = this.tokens.nextToken();
                    if (nextToken) {
                    }
                    if (nextToken || !this.tokens.getStringValue().equals("stream")) {
                        this.tokens.seek(filePointer);
                        return readDictionary;
                    }
                    while (true) {
                        int read = this.tokens.read();
                        if (read != 32 && read != 9 && read != 0 && read != 12) {
                            if (read != 10) {
                                read = this.tokens.read();
                            }
                            if (read != 10) {
                                this.tokens.backOnePosition(read);
                            }
                            PRStream pRStream = new PRStream(this, this.tokens.getFilePointer());
                            pRStream.putAll(readDictionary);
                            pRStream.setObjNum(this.objNum, this.objGen);
                            return pRStream;
                        }
                    }
                } while (this.tokens.getTokenType() == PRTokeniser.TokenType.COMMENT);
                if (nextToken) {
                }
                this.tokens.seek(filePointer);
                return readDictionary;
            case START_ARRAY:
                this.readDepth++;
                PdfArray readArray = readArray();
                this.readDepth--;
                return readArray;
            case NUMBER:
                return new PdfNumber(this.tokens.getStringValue());
            case STRING:
                PdfString hexWriting = new PdfString(this.tokens.getStringValue(), null).setHexWriting(this.tokens.isHexString());
                hexWriting.setObjNum(this.objNum, this.objGen);
                ArrayList<PdfString> arrayList = this.strings;
                if (arrayList != null) {
                    arrayList.add(hexWriting);
                }
                return hexWriting;
            case NAME:
                PdfName pdfName = PdfName.staticNames.get(this.tokens.getStringValue());
                return (this.readDepth <= 0 || pdfName == null) ? new PdfName(this.tokens.getStringValue(), false) : pdfName;
            case REF:
                return new PRIndirectReference(this, this.tokens.getReference(), this.tokens.getGeneration());
            case ENDOFFILE:
                throw new IOException(MessageLocalization.getComposedMessage("unexpected.end.of.file", new Object[0]));
            default:
                String stringValue = this.tokens.getStringValue();
                if ("null".equals(stringValue)) {
                    if (this.readDepth == 0) {
                        return new PdfNull();
                    }
                    return PdfNull.PDFNULL;
                } else if (PdfBoolean.TRUE.equals(stringValue)) {
                    if (this.readDepth == 0) {
                        return new PdfBoolean(true);
                    }
                    return PdfBoolean.PDFTRUE;
                } else if (PdfBoolean.FALSE.equals(stringValue)) {
                    if (this.readDepth == 0) {
                        return new PdfBoolean(false);
                    }
                    return PdfBoolean.PDFFALSE;
                } else {
                    return new PdfLiteral(-tokenType.ordinal(), this.tokens.getStringValue());
                }
        }
    }

    public static byte[] FlateDecode(byte[] bArr) {
        byte[] FlateDecode = FlateDecode(bArr, true);
        return FlateDecode == null ? FlateDecode(bArr, false) : FlateDecode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static byte[] decodePredictor(byte[] bArr, PdfObject pdfObject) {
        if (pdfObject == null || !pdfObject.isDictionary()) {
            return bArr;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
        PdfObject pdfObject2 = getPdfObject(pdfDictionary.get(PdfName.PREDICTOR));
        if (pdfObject2 == null || !pdfObject2.isNumber() || ((PdfNumber) pdfObject2).intValue() < 10) {
            return bArr;
        }
        PdfObject pdfObject3 = getPdfObject(pdfDictionary.get(PdfName.COLUMNS));
        int i = 1;
        int intValue = (pdfObject3 == null || !pdfObject3.isNumber()) ? 1 : ((PdfNumber) pdfObject3).intValue();
        PdfObject pdfObject4 = getPdfObject(pdfDictionary.get(PdfName.COLORS));
        if (pdfObject4 != null && pdfObject4.isNumber()) {
            i = ((PdfNumber) pdfObject4).intValue();
        }
        PdfObject pdfObject5 = getPdfObject(pdfDictionary.get(PdfName.BITSPERCOMPONENT));
        int intValue2 = (pdfObject5 == null || !pdfObject5.isNumber()) ? 8 : ((PdfNumber) pdfObject5).intValue();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        int i2 = (i * intValue2) / 8;
        int i3 = (((i * intValue) * intValue2) + 7) / 8;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = new byte[i3];
        while (true) {
            try {
                int read = dataInputStream.read();
                if (read < 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                int i4 = 0;
                dataInputStream.readFully(bArr2, 0, i3);
                switch (read) {
                    case 0:
                        break;
                    case 1:
                        for (int i5 = i2; i5 < i3; i5++) {
                            bArr2[i5] = (byte) (bArr2[i5] + bArr2[i5 - i2]);
                        }
                        break;
                    case 2:
                        while (i4 < i3) {
                            bArr2[i4] = (byte) (bArr2[i4] + bArr3[i4]);
                            i4++;
                        }
                        break;
                    case 3:
                        while (i4 < i2) {
                            bArr2[i4] = (byte) (bArr2[i4] + (bArr3[i4] / 2));
                            i4++;
                        }
                        for (int i6 = i2; i6 < i3; i6++) {
                            bArr2[i6] = (byte) (bArr2[i6] + (((bArr2[i6 - i2] & 255) + (bArr3[i6] & 255)) / 2));
                        }
                        break;
                    case 4:
                        while (i4 < i2) {
                            bArr2[i4] = (byte) (bArr2[i4] + bArr3[i4]);
                            i4++;
                        }
                        for (int i7 = i2; i7 < i3; i7++) {
                            int i8 = i7 - i2;
                            int i9 = bArr2[i8] & 255;
                            int i10 = bArr3[i7] & 255;
                            int i11 = bArr3[i8] & 255;
                            int i12 = (i9 + i10) - i11;
                            int abs = Math.abs(i12 - i9);
                            int abs2 = Math.abs(i12 - i10);
                            int abs3 = Math.abs(i12 - i11);
                            if (abs <= abs2 && abs <= abs3) {
                                i11 = i9;
                            } else if (abs2 <= abs3) {
                                i11 = i10;
                            }
                            bArr2[i7] = (byte) (bArr2[i7] + ((byte) i11));
                        }
                        break;
                    default:
                        throw new RuntimeException(MessageLocalization.getComposedMessage("png.filter.unknown", new Object[0]));
                }
                try {
                    byteArrayOutputStream.write(bArr2);
                } catch (IOException unused) {
                }
                byte[] bArr4 = bArr3;
                bArr3 = bArr2;
                bArr2 = bArr4;
            } catch (Exception unused2) {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static byte[] FlateDecode(byte[] bArr, boolean z) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[z ? 4092 : 1];
        while (true) {
            try {
                int read = inflaterInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (Exception unused) {
                if (z) {
                    return null;
                }
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static byte[] ASCIIHexDecode(byte[] bArr) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = true;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length && (i = bArr[i3] & 255) != 62; i3++) {
            if (!PRTokeniser.isWhitespace(i)) {
                int hex = PRTokeniser.getHex(i);
                if (hex == -1) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("illegal.character.in.asciihexdecode", new Object[0]));
                }
                if (z) {
                    i2 = hex;
                } else {
                    byteArrayOutputStream.write((byte) ((i2 << 4) + hex));
                }
                z = !z;
            }
        }
        if (!z) {
            byteArrayOutputStream.write((byte) (i2 << 4));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] ASCII85Decode(byte[] bArr) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int[] iArr = new int[5];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length && (i = bArr[i3] & 255) != 126; i3++) {
            if (!PRTokeniser.isWhitespace(i)) {
                if (i == 122 && i2 == 0) {
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                } else if (i < 33 || i > 117) {
                    throw new RuntimeException(MessageLocalization.getComposedMessage("illegal.character.in.ascii85decode", new Object[0]));
                } else {
                    iArr[i2] = i - 33;
                    i2++;
                    if (i2 == 5) {
                        int i4 = 0;
                        for (int i5 = 0; i5 < 5; i5++) {
                            i4 = (i4 * 85) + iArr[i5];
                        }
                        byteArrayOutputStream.write((byte) (i4 >> 24));
                        byteArrayOutputStream.write((byte) (i4 >> 16));
                        byteArrayOutputStream.write((byte) (i4 >> 8));
                        byteArrayOutputStream.write((byte) i4);
                        i2 = 0;
                    }
                }
            }
        }
        if (i2 == 2) {
            byteArrayOutputStream.write((byte) (((((((((iArr[0] * 85) * 85) * 85) * 85) + (((iArr[1] * 85) * 85) * 85)) + 614125) + 7225) + 85) >> 24));
        } else if (i2 == 3) {
            int i6 = (iArr[0] * 85 * 85 * 85 * 85) + (iArr[1] * 85 * 85 * 85) + (iArr[2] * 85 * 85) + 7225 + 85;
            byteArrayOutputStream.write((byte) (i6 >> 24));
            byteArrayOutputStream.write((byte) (i6 >> 16));
        } else if (i2 == 4) {
            int i7 = (iArr[0] * 85 * 85 * 85 * 85) + (iArr[1] * 85 * 85 * 85) + (iArr[2] * 85 * 85) + (iArr[3] * 85) + 85;
            byteArrayOutputStream.write((byte) (i7 >> 24));
            byteArrayOutputStream.write((byte) (i7 >> 16));
            byteArrayOutputStream.write((byte) (i7 >> 8));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] LZWDecode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new LZWDecoder().decode(bArr, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public boolean isRebuilt() {
        return this.rebuilt;
    }

    public PdfDictionary getPageN(int i) {
        PdfDictionary pageN = this.pageRefs.getPageN(i);
        if (pageN == null) {
            return null;
        }
        if (this.appendable) {
            pageN.setIndRef(this.pageRefs.getPageOrigRef(i));
        }
        return pageN;
    }

    public PdfDictionary getPageNRelease(int i) {
        PdfDictionary pageN = getPageN(i);
        this.pageRefs.releasePage(i);
        return pageN;
    }

    public void releasePage(int i) {
        this.pageRefs.releasePage(i);
    }

    public void resetReleasePage() {
        this.pageRefs.resetReleasePage();
    }

    public PRIndirectReference getPageOrigRef(int i) {
        return this.pageRefs.getPageOrigRef(i);
    }

    public byte[] getPageContent(int i, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfDictionary pageNRelease = getPageNRelease(i);
        if (pageNRelease == null) {
            return null;
        }
        PdfObject pdfObjectRelease = getPdfObjectRelease(pageNRelease.get(PdfName.CONTENTS));
        if (pdfObjectRelease == null) {
            return new byte[0];
        }
        if (pdfObjectRelease.isStream()) {
            return getStreamBytes((PRStream) pdfObjectRelease, randomAccessFileOrArray);
        }
        if (pdfObjectRelease.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObjectRelease;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                PdfObject pdfObjectRelease2 = getPdfObjectRelease(pdfArray.getPdfObject(i2));
                if (pdfObjectRelease2 != null && pdfObjectRelease2.isStream()) {
                    byteArrayOutputStream.write(getStreamBytes((PRStream) pdfObjectRelease2, randomAccessFileOrArray));
                    if (i2 != pdfArray.size() - 1) {
                        byteArrayOutputStream.write(10);
                    }
                }
            }
            return byteArrayOutputStream.toByteArray();
        }
        return new byte[0];
    }

    public static byte[] getPageContent(PdfDictionary pdfDictionary) throws IOException {
        RandomAccessFileOrArray randomAccessFileOrArray = null;
        if (pdfDictionary == null) {
            return null;
        }
        try {
            PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.CONTENTS));
            if (pdfObjectRelease == null) {
                return new byte[0];
            }
            if (pdfObjectRelease.isStream()) {
                RandomAccessFileOrArray safeFile = ((PRStream) pdfObjectRelease).getReader().getSafeFile();
                safeFile.reOpen();
                byte[] streamBytes = getStreamBytes((PRStream) pdfObjectRelease, safeFile);
                if (safeFile != null) {
                    try {
                        safeFile.close();
                    } catch (Exception unused) {
                    }
                }
                return streamBytes;
            } else if (pdfObjectRelease.isArray()) {
                PdfArray pdfArray = (PdfArray) pdfObjectRelease;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (int i = 0; i < pdfArray.size(); i++) {
                    PdfObject pdfObjectRelease2 = getPdfObjectRelease(pdfArray.getPdfObject(i));
                    if (pdfObjectRelease2 != null && pdfObjectRelease2.isStream()) {
                        if (randomAccessFileOrArray == null) {
                            randomAccessFileOrArray = ((PRStream) pdfObjectRelease2).getReader().getSafeFile();
                            randomAccessFileOrArray.reOpen();
                        }
                        byteArrayOutputStream.write(getStreamBytes((PRStream) pdfObjectRelease2, randomAccessFileOrArray));
                        if (i != pdfArray.size() - 1) {
                            byteArrayOutputStream.write(10);
                        }
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (randomAccessFileOrArray != null) {
                    try {
                        randomAccessFileOrArray.close();
                    } catch (Exception unused2) {
                    }
                }
                return byteArray;
            } else {
                return new byte[0];
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFileOrArray.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    public PdfDictionary getPageResources(int i) {
        return getPageResources(getPageN(i));
    }

    public PdfDictionary getPageResources(PdfDictionary pdfDictionary) {
        return pdfDictionary.getAsDict(PdfName.RESOURCES);
    }

    public byte[] getPageContent(int i) throws IOException {
        RandomAccessFileOrArray safeFile = getSafeFile();
        try {
            safeFile.reOpen();
            return getPageContent(i, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void killXref(PdfObject pdfObject) {
        if (pdfObject == null) {
            return;
        }
        if (!(pdfObject instanceof PdfIndirectReference) || pdfObject.isIndirect()) {
            int type = pdfObject.type();
            if (type == 10) {
                int number = ((PRIndirectReference) pdfObject).getNumber();
                this.xrefObj.set(number, null);
                this.freeXref = number;
                killXref(this.xrefObj.get(number));
                return;
            }
            switch (type) {
                case 5:
                    PdfArray pdfArray = (PdfArray) pdfObject;
                    for (int i = 0; i < pdfArray.size(); i++) {
                        killXref(pdfArray.getPdfObject(i));
                    }
                    return;
                case 6:
                case 7:
                    PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                    for (PdfName pdfName : pdfDictionary.getKeys()) {
                        killXref(pdfDictionary.get(pdfName));
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setPageContent(int i, byte[] bArr) {
        setPageContent(i, bArr, -1);
    }

    public void setPageContent(int i, byte[] bArr, int i2) {
        PdfDictionary pageN = getPageN(i);
        if (pageN == null) {
            return;
        }
        PdfObject pdfObject = pageN.get(PdfName.CONTENTS);
        this.freeXref = -1;
        killXref(pdfObject);
        if (this.freeXref == -1) {
            this.xrefObj.add(null);
            this.freeXref = this.xrefObj.size() - 1;
        }
        pageN.put(PdfName.CONTENTS, new PRIndirectReference(this, this.freeXref));
        this.xrefObj.set(this.freeXref, new PRStream(this, bArr, i2));
    }

    public static byte[] decodeBytes(byte[] bArr, PdfDictionary pdfDictionary) throws IOException {
        return decodeBytes(bArr, pdfDictionary, FilterHandlers.getDefaultFilterHandlers());
    }

    public static byte[] decodeBytes(byte[] bArr, PdfDictionary pdfDictionary, Map<PdfName, FilterHandlers.FilterHandler> map) throws IOException {
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.FILTER));
        ArrayList<PdfObject> arrayList = new ArrayList<>();
        if (pdfObjectRelease != null) {
            if (pdfObjectRelease.isName()) {
                arrayList.add(pdfObjectRelease);
            } else if (pdfObjectRelease.isArray()) {
                arrayList = ((PdfArray) pdfObjectRelease).getArrayList();
            }
        }
        ArrayList<PdfObject> arrayList2 = new ArrayList<>();
        PdfObject pdfObjectRelease2 = getPdfObjectRelease(pdfDictionary.get(PdfName.DECODEPARMS));
        if (pdfObjectRelease2 == null || (!pdfObjectRelease2.isDictionary() && !pdfObjectRelease2.isArray())) {
            pdfObjectRelease2 = getPdfObjectRelease(pdfDictionary.get(PdfName.f19705DP));
        }
        if (pdfObjectRelease2 != null) {
            if (pdfObjectRelease2.isDictionary()) {
                arrayList2.add(pdfObjectRelease2);
            } else if (pdfObjectRelease2.isArray()) {
                arrayList2 = ((PdfArray) pdfObjectRelease2).getArrayList();
            }
        }
        byte[] bArr2 = bArr;
        for (int i = 0; i < arrayList.size(); i++) {
            PdfName pdfName = (PdfName) arrayList.get(i);
            FilterHandlers.FilterHandler filterHandler = map.get(pdfName);
            if (filterHandler == null) {
                throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("the.filter.1.is.not.supported", pdfName));
            }
            PdfDictionary pdfDictionary2 = null;
            if (i < arrayList2.size()) {
                PdfObject pdfObject = getPdfObject(arrayList2.get(i));
                if (pdfObject instanceof PdfDictionary) {
                    pdfDictionary2 = (PdfDictionary) pdfObject;
                } else if (pdfObject != null && !(pdfObject instanceof PdfNull)) {
                    throw new UnsupportedPdfException(MessageLocalization.getComposedMessage("the.decode.parameter.type.1.is.not.supported", pdfObject.getClass().toString()));
                }
            }
            bArr2 = filterHandler.decode(bArr2, pdfName, pdfDictionary2, pdfDictionary);
        }
        return bArr2;
    }

    public static byte[] getStreamBytes(PRStream pRStream, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        return decodeBytes(getStreamBytesRaw(pRStream, randomAccessFileOrArray), pRStream);
    }

    public static byte[] getStreamBytes(PRStream pRStream) throws IOException {
        RandomAccessFileOrArray safeFile = pRStream.getReader().getSafeFile();
        try {
            safeFile.reOpen();
            return getStreamBytes(pRStream, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] getStreamBytesRaw(PRStream pRStream, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfReader reader = pRStream.getReader();
        if (pRStream.getOffset() < 0) {
            return pRStream.getBytes();
        }
        byte[] bArr = new byte[pRStream.getLength()];
        randomAccessFileOrArray.seek(pRStream.getOffset());
        randomAccessFileOrArray.readFully(bArr);
        PdfEncryption decrypt = reader.getDecrypt();
        if (decrypt != null) {
            PdfObject pdfObjectRelease = getPdfObjectRelease(pRStream.get(PdfName.FILTER));
            ArrayList<PdfObject> arrayList = new ArrayList<>();
            if (pdfObjectRelease != null) {
                if (pdfObjectRelease.isName()) {
                    arrayList.add(pdfObjectRelease);
                } else if (pdfObjectRelease.isArray()) {
                    arrayList = ((PdfArray) pdfObjectRelease).getArrayList();
                }
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i < arrayList.size()) {
                    PdfObject pdfObjectRelease2 = getPdfObjectRelease(arrayList.get(i));
                    if (pdfObjectRelease2 != null && pdfObjectRelease2.toString().equals("/Crypt")) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            if (!z) {
                decrypt.setHashKey(pRStream.getObjNum(), pRStream.getObjGen());
                return decrypt.decryptByteArray(bArr);
            }
        }
        return bArr;
    }

    public static byte[] getStreamBytesRaw(PRStream pRStream) throws IOException {
        RandomAccessFileOrArray safeFile = pRStream.getReader().getSafeFile();
        try {
            safeFile.reOpen();
            return getStreamBytesRaw(pRStream, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void eliminateSharedStreams() {
        PdfObject pdfObject;
        if (this.sharedStreams) {
            this.sharedStreams = false;
            if (this.pageRefs.size() == 1) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            IntHashtable intHashtable = new IntHashtable();
            for (int i = 1; i <= this.pageRefs.size(); i++) {
                PdfDictionary pageN = this.pageRefs.getPageN(i);
                if (pageN != null && (pdfObject = getPdfObject(pageN.get(PdfName.CONTENTS))) != null) {
                    if (pdfObject.isStream()) {
                        PRIndirectReference pRIndirectReference = (PRIndirectReference) pageN.get(PdfName.CONTENTS);
                        if (intHashtable.containsKey(pRIndirectReference.getNumber())) {
                            arrayList.add(pRIndirectReference);
                            arrayList2.add(new PRStream((PRStream) pdfObject, (PdfDictionary) null));
                        } else {
                            intHashtable.put(pRIndirectReference.getNumber(), 1);
                        }
                    } else if (pdfObject.isArray()) {
                        PdfArray pdfArray = (PdfArray) pdfObject;
                        for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfArray.getPdfObject(i2);
                            if (intHashtable.containsKey(pRIndirectReference2.getNumber())) {
                                arrayList.add(pRIndirectReference2);
                                arrayList2.add(new PRStream((PRStream) getPdfObject(pRIndirectReference2), (PdfDictionary) null));
                            } else {
                                intHashtable.put(pRIndirectReference2.getNumber(), 1);
                            }
                        }
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                return;
            }
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                this.xrefObj.add(arrayList2.get(i3));
                ((PRIndirectReference) arrayList.get(i3)).setNumber(this.xrefObj.size() - 1, 0);
            }
        }
    }

    public boolean isTampered() {
        return this.tampered;
    }

    public void setTampered(boolean z) {
        this.tampered = z;
        this.pageRefs.keepPages();
    }

    public byte[] getMetadata() throws IOException {
        PdfObject pdfObject = getPdfObject(this.catalog.get(PdfName.METADATA));
        if (pdfObject instanceof PRStream) {
            RandomAccessFileOrArray safeFile = getSafeFile();
            try {
                safeFile.reOpen();
                return getStreamBytes((PRStream) pdfObject, safeFile);
            } finally {
                try {
                    safeFile.close();
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    public long getLastXref() {
        return this.lastXref;
    }

    public int getXrefSize() {
        return this.xrefObj.size();
    }

    public long getEofPos() {
        return this.eofPos;
    }

    public char getPdfVersion() {
        return this.pdfVersion;
    }

    public boolean isEncrypted() {
        return this.encrypted;
    }

    public int getPermissions() {
        return this.pValue;
    }

    public boolean is128Key() {
        return this.rValue == 3;
    }

    public PdfDictionary getTrailer() {
        return this.trailer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfEncryption getDecrypt() {
        return this.decrypt;
    }

    static boolean equalsn(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean existsName(PdfDictionary pdfDictionary, PdfName pdfName, PdfName pdfName2) {
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(pdfName));
        if (pdfObjectRelease == null || !pdfObjectRelease.isName()) {
            return false;
        }
        return ((PdfName) pdfObjectRelease).equals(pdfName2);
    }

    static String getFontName(PdfDictionary pdfDictionary) {
        PdfObject pdfObjectRelease;
        if (pdfDictionary == null || (pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.BASEFONT))) == null || !pdfObjectRelease.isName()) {
            return null;
        }
        return PdfName.decodeName(pdfObjectRelease.toString());
    }

    static String getSubsetPrefix(PdfDictionary pdfDictionary) {
        String fontName;
        if (pdfDictionary != null && (fontName = getFontName(pdfDictionary)) != null && fontName.length() >= 8 && fontName.charAt(6) == '+') {
            for (int i = 0; i < 6; i++) {
                char charAt = fontName.charAt(i);
                if (charAt < 'A' || charAt > 'Z') {
                    return null;
                }
            }
            return fontName;
        }
        return null;
    }

    public int shuffleSubsetNames() {
        PdfDictionary asDict;
        String subsetPrefix;
        int i = 0;
        for (int i2 = 1; i2 < this.xrefObj.size(); i2++) {
            PdfObject pdfObjectRelease = getPdfObjectRelease(i2);
            if (pdfObjectRelease != null && pdfObjectRelease.isDictionary()) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObjectRelease;
                if (existsName(pdfDictionary, PdfName.TYPE, PdfName.FONT)) {
                    if (existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.TYPE1) || existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.MMTYPE1) || existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.TRUETYPE)) {
                        String subsetPrefix2 = getSubsetPrefix(pdfDictionary);
                        if (subsetPrefix2 != null) {
                            PdfName pdfName = new PdfName(BaseFont.createSubsetPrefix() + subsetPrefix2.substring(7));
                            pdfDictionary.put(PdfName.BASEFONT, pdfName);
                            setXrefPartialObject(i2, pdfDictionary);
                            i++;
                            PdfDictionary asDict2 = pdfDictionary.getAsDict(PdfName.FONTDESCRIPTOR);
                            if (asDict2 != null) {
                                asDict2.put(PdfName.FONTNAME, pdfName);
                            }
                        }
                    } else if (existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.TYPE0)) {
                        String subsetPrefix3 = getSubsetPrefix(pdfDictionary);
                        PdfArray asArray = pdfDictionary.getAsArray(PdfName.DESCENDANTFONTS);
                        if (asArray != null && !asArray.isEmpty() && (subsetPrefix = getSubsetPrefix((asDict = asArray.getAsDict(0)))) != null) {
                            String createSubsetPrefix = BaseFont.createSubsetPrefix();
                            if (subsetPrefix3 != null) {
                                PdfName pdfName2 = PdfName.BASEFONT;
                                pdfDictionary.put(pdfName2, new PdfName(createSubsetPrefix + subsetPrefix3.substring(7)));
                            }
                            setXrefPartialObject(i2, pdfDictionary);
                            PdfName pdfName3 = new PdfName(createSubsetPrefix + subsetPrefix.substring(7));
                            asDict.put(PdfName.BASEFONT, pdfName3);
                            i++;
                            PdfDictionary asDict3 = asDict.getAsDict(PdfName.FONTDESCRIPTOR);
                            if (asDict3 != null) {
                                asDict3.put(PdfName.FONTNAME, pdfName3);
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    public int createFakeFontSubsets() {
        String fontName;
        int i = 0;
        for (int i2 = 1; i2 < this.xrefObj.size(); i2++) {
            PdfObject pdfObjectRelease = getPdfObjectRelease(i2);
            if (pdfObjectRelease != null && pdfObjectRelease.isDictionary()) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObjectRelease;
                if (existsName(pdfDictionary, PdfName.TYPE, PdfName.FONT) && ((existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.TYPE1) || existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.MMTYPE1) || existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.TRUETYPE)) && getSubsetPrefix(pdfDictionary) == null && (fontName = getFontName(pdfDictionary)) != null)) {
                    String str = BaseFont.createSubsetPrefix() + fontName;
                    PdfDictionary pdfDictionary2 = (PdfDictionary) getPdfObjectRelease(pdfDictionary.get(PdfName.FONTDESCRIPTOR));
                    if (pdfDictionary2 != null && (pdfDictionary2.get(PdfName.FONTFILE) != null || pdfDictionary2.get(PdfName.FONTFILE2) != null || pdfDictionary2.get(PdfName.FONTFILE3) != null)) {
                        PdfDictionary asDict = pdfDictionary.getAsDict(PdfName.FONTDESCRIPTOR);
                        PdfName pdfName = new PdfName(str);
                        pdfDictionary.put(PdfName.BASEFONT, pdfName);
                        asDict.put(PdfName.FONTNAME, pdfName);
                        setXrefPartialObject(i2, pdfDictionary);
                        i++;
                    }
                }
            }
        }
        return i;
    }

    private static PdfArray getNameArray(PdfObject pdfObject) {
        PdfObject pdfObjectRelease;
        PdfObject pdfObjectRelease2;
        if (pdfObject == null || (pdfObjectRelease = getPdfObjectRelease(pdfObject)) == null) {
            return null;
        }
        if (pdfObjectRelease.isArray()) {
            return (PdfArray) pdfObjectRelease;
        }
        if (pdfObjectRelease.isDictionary() && (pdfObjectRelease2 = getPdfObjectRelease(((PdfDictionary) pdfObjectRelease).get(PdfName.f19699D))) != null && pdfObjectRelease2.isArray()) {
            return (PdfArray) pdfObjectRelease2;
        }
        return null;
    }

    public HashMap<Object, PdfObject> getNamedDestination() {
        return getNamedDestination(false);
    }

    public HashMap<Object, PdfObject> getNamedDestination(boolean z) {
        HashMap<Object, PdfObject> namedDestinationFromNames = getNamedDestinationFromNames(z);
        namedDestinationFromNames.putAll(getNamedDestinationFromStrings());
        return namedDestinationFromNames;
    }

    public HashMap<String, PdfObject> getNamedDestinationFromNames() {
        return new HashMap<>(getNamedDestinationFromNames(false));
    }

    public HashMap<Object, PdfObject> getNamedDestinationFromNames(boolean z) {
        PdfDictionary pdfDictionary;
        HashMap<Object, PdfObject> hashMap = new HashMap<>();
        if (this.catalog.get(PdfName.DESTS) == null || (pdfDictionary = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.DESTS))) == null) {
            return hashMap;
        }
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            PdfArray nameArray = getNameArray(pdfDictionary.get(pdfName));
            if (nameArray != null) {
                if (z) {
                    hashMap.put(pdfName, nameArray);
                } else {
                    hashMap.put(PdfName.decodeName(pdfName.toString()), nameArray);
                }
            }
        }
        return hashMap;
    }

    public HashMap<String, PdfObject> getNamedDestinationFromStrings() {
        PdfDictionary pdfDictionary;
        PdfDictionary pdfDictionary2;
        if (this.catalog.get(PdfName.NAMES) != null && (pdfDictionary = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.NAMES))) != null && (pdfDictionary2 = (PdfDictionary) getPdfObjectRelease(pdfDictionary.get(PdfName.DESTS))) != null) {
            HashMap<String, PdfObject> readTree = PdfNameTree.readTree(pdfDictionary2);
            Iterator<Map.Entry<String, PdfObject>> it = readTree.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, PdfObject> next = it.next();
                PdfArray nameArray = getNameArray(next.getValue());
                if (nameArray != null) {
                    next.setValue(nameArray);
                } else {
                    it.remove();
                }
            }
            return readTree;
        }
        return new HashMap<>();
    }

    public void removeFields() {
        this.pageRefs.resetReleasePage();
        for (int i = 1; i <= this.pageRefs.size(); i++) {
            PdfDictionary pageN = this.pageRefs.getPageN(i);
            PdfArray asArray = pageN.getAsArray(PdfName.ANNOTS);
            if (asArray != null) {
                int i2 = 0;
                while (i2 < asArray.size()) {
                    PdfObject pdfObjectRelease = getPdfObjectRelease(asArray.getPdfObject(i2));
                    if (pdfObjectRelease != null && pdfObjectRelease.isDictionary() && PdfName.WIDGET.equals(((PdfDictionary) pdfObjectRelease).get(PdfName.SUBTYPE))) {
                        asArray.remove(i2);
                        i2--;
                    }
                    i2++;
                }
                if (asArray.isEmpty()) {
                    pageN.remove(PdfName.ANNOTS);
                }
            }
            this.pageRefs.releasePage(i);
        }
        this.catalog.remove(PdfName.ACROFORM);
        this.pageRefs.resetReleasePage();
    }

    public void removeAnnotations() {
        this.pageRefs.resetReleasePage();
        for (int i = 1; i <= this.pageRefs.size(); i++) {
            PdfDictionary pageN = this.pageRefs.getPageN(i);
            if (pageN.get(PdfName.ANNOTS) == null) {
                this.pageRefs.releasePage(i);
            } else {
                pageN.remove(PdfName.ANNOTS);
            }
        }
        this.catalog.remove(PdfName.ACROFORM);
        this.pageRefs.resetReleasePage();
    }

    public ArrayList<PdfAnnotation.PdfImportedLink> getLinks(int i) {
        this.pageRefs.resetReleasePage();
        ArrayList<PdfAnnotation.PdfImportedLink> arrayList = new ArrayList<>();
        PdfDictionary pageN = this.pageRefs.getPageN(i);
        if (pageN.get(PdfName.ANNOTS) != null) {
            PdfArray asArray = pageN.getAsArray(PdfName.ANNOTS);
            for (int i2 = 0; i2 < asArray.size(); i2++) {
                PdfDictionary pdfDictionary = (PdfDictionary) getPdfObjectRelease(asArray.getPdfObject(i2));
                if (PdfName.LINK.equals(pdfDictionary.get(PdfName.SUBTYPE))) {
                    arrayList.add(new PdfAnnotation.PdfImportedLink(pdfDictionary));
                }
            }
        }
        this.pageRefs.releasePage(i);
        this.pageRefs.resetReleasePage();
        return arrayList;
    }

    private void iterateBookmarks(PdfObject pdfObject, HashMap<Object, PdfObject> hashMap) {
        while (pdfObject != null) {
            replaceNamedDestination(pdfObject, hashMap);
            PdfDictionary pdfDictionary = (PdfDictionary) getPdfObjectRelease(pdfObject);
            PdfObject pdfObject2 = pdfDictionary.get(PdfName.FIRST);
            if (pdfObject2 != null) {
                iterateBookmarks(pdfObject2, hashMap);
            }
            pdfObject = pdfDictionary.get(PdfName.NEXT);
        }
    }

    public void makeRemoteNamedDestinationsLocal() {
        int i;
        if (this.remoteToLocalNamedDestinations) {
            return;
        }
        this.remoteToLocalNamedDestinations = true;
        HashMap<Object, PdfObject> namedDestination = getNamedDestination(true);
        if (namedDestination.isEmpty()) {
            return;
        }
        while (i <= this.pageRefs.size()) {
            PdfObject pdfObject = this.pageRefs.getPageN(i).get(PdfName.ANNOTS);
            PdfArray pdfArray = (PdfArray) getPdfObject(pdfObject);
            int i2 = this.lastXrefPartial;
            releaseLastXrefPartial();
            if (pdfArray != null) {
                boolean z = false;
                for (int i3 = 0; i3 < pdfArray.size(); i3++) {
                    PdfObject pdfObject2 = pdfArray.getPdfObject(i3);
                    if (convertNamedDestination(pdfObject2, namedDestination) && !pdfObject2.isIndirect()) {
                        z = true;
                    }
                }
                if (z) {
                    setXrefPartialObject(i2, pdfArray);
                }
                i = (z && !pdfObject.isIndirect()) ? i + 1 : 1;
            }
            this.pageRefs.releasePage(i);
        }
    }

    private boolean convertNamedDestination(PdfObject pdfObject, HashMap<Object, PdfObject> hashMap) {
        PdfObject pdfObject2;
        PdfObject pdfObjectRelease;
        PdfObject pdfObject3 = getPdfObject(pdfObject);
        int i = this.lastXrefPartial;
        releaseLastXrefPartial();
        if (pdfObject3 == null || !pdfObject3.isDictionary() || (pdfObject2 = getPdfObject(((PdfDictionary) pdfObject3).get(PdfName.f19679A))) == null) {
            return false;
        }
        int i2 = this.lastXrefPartial;
        releaseLastXrefPartial();
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject2;
        if (!PdfName.GOTOR.equals((PdfName) getPdfObjectRelease(pdfDictionary.get(PdfName.f19767S))) || (pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.f19699D))) == null) {
            return false;
        }
        boolean isName = pdfObjectRelease.isName();
        String str = pdfObjectRelease;
        if (!isName) {
            str = pdfObjectRelease.isString() ? pdfObjectRelease.toString() : null;
        }
        if (((PdfArray) hashMap.get(str)) != null) {
            pdfDictionary.remove(PdfName.f19712F);
            pdfDictionary.remove(PdfName.NEWWINDOW);
            pdfDictionary.put(PdfName.f19767S, PdfName.GOTO);
            setXrefPartialObject(i2, pdfObject2);
            setXrefPartialObject(i, pdfObject3);
            return true;
        }
        return false;
    }

    public void consolidateNamedDestinations() {
        int i;
        if (this.consolidateNamedDestinations) {
            return;
        }
        this.consolidateNamedDestinations = true;
        HashMap<Object, PdfObject> namedDestination = getNamedDestination(true);
        if (namedDestination.isEmpty()) {
            return;
        }
        while (i <= this.pageRefs.size()) {
            PdfObject pdfObject = this.pageRefs.getPageN(i).get(PdfName.ANNOTS);
            PdfArray pdfArray = (PdfArray) getPdfObject(pdfObject);
            int i2 = this.lastXrefPartial;
            releaseLastXrefPartial();
            if (pdfArray != null) {
                boolean z = false;
                for (int i3 = 0; i3 < pdfArray.size(); i3++) {
                    PdfObject pdfObject2 = pdfArray.getPdfObject(i3);
                    if (replaceNamedDestination(pdfObject2, namedDestination) && !pdfObject2.isIndirect()) {
                        z = true;
                    }
                }
                if (z) {
                    setXrefPartialObject(i2, pdfArray);
                }
                i = (z && !pdfObject.isIndirect()) ? i + 1 : 1;
            }
            this.pageRefs.releasePage(i);
        }
        PdfDictionary pdfDictionary = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.OUTLINES));
        if (pdfDictionary == null) {
            return;
        }
        iterateBookmarks(pdfDictionary.get(PdfName.FIRST), namedDestination);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean replaceNamedDestination(PdfObject pdfObject, HashMap<Object, PdfObject> hashMap) {
        PdfObject pdfObject2 = getPdfObject(pdfObject);
        int i = this.lastXrefPartial;
        releaseLastXrefPartial();
        if (pdfObject2 == null || !pdfObject2.isDictionary()) {
            return false;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject2;
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.DEST));
        String str = null;
        if (pdfObjectRelease != null) {
            boolean isName = pdfObjectRelease.isName();
            String str2 = pdfObjectRelease;
            if (!isName) {
                str2 = pdfObjectRelease.isString() ? pdfObjectRelease.toString() : null;
            }
            PdfArray pdfArray = (PdfArray) hashMap.get(str2);
            if (pdfArray != null) {
                pdfDictionary.put(PdfName.DEST, pdfArray);
                setXrefPartialObject(i, pdfObject2);
                return true;
            }
            return false;
        }
        PdfObject pdfObject3 = getPdfObject(pdfDictionary.get(PdfName.f19679A));
        if (pdfObject3 != null) {
            int i2 = this.lastXrefPartial;
            releaseLastXrefPartial();
            PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject3;
            if (PdfName.GOTO.equals((PdfName) getPdfObjectRelease(pdfDictionary2.get(PdfName.f19767S)))) {
                PdfObject pdfObjectRelease2 = getPdfObjectRelease(pdfDictionary2.get(PdfName.f19699D));
                if (pdfObjectRelease2 != 0) {
                    if (pdfObjectRelease2.isName()) {
                        str = pdfObjectRelease2;
                    } else if (pdfObjectRelease2.isString()) {
                        str = pdfObjectRelease2.toString();
                    }
                }
                PdfArray pdfArray2 = (PdfArray) hashMap.get(str);
                if (pdfArray2 != null) {
                    pdfDictionary2.put(PdfName.f19699D, pdfArray2);
                    setXrefPartialObject(i2, pdfObject3);
                    setXrefPartialObject(i, pdfObject2);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    protected static PdfDictionary duplicatePdfDictionary(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfReader pdfReader) {
        if (pdfDictionary2 == null) {
            pdfDictionary2 = new PdfDictionary();
        }
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            pdfDictionary2.put(pdfName, duplicatePdfObject(pdfDictionary.get(pdfName), pdfReader));
        }
        return pdfDictionary2;
    }

    protected static PdfObject duplicatePdfObject(PdfObject pdfObject, PdfReader pdfReader) {
        if (pdfObject == null) {
            return null;
        }
        int type = pdfObject.type();
        if (type != 10) {
            switch (type) {
                case 5:
                    PdfArray pdfArray = new PdfArray();
                    ListIterator<PdfObject> listIterator = ((PdfArray) pdfObject).listIterator();
                    while (listIterator.hasNext()) {
                        pdfArray.add(duplicatePdfObject(listIterator.next(), pdfReader));
                    }
                    return pdfArray;
                case 6:
                    return duplicatePdfDictionary((PdfDictionary) pdfObject, null, pdfReader);
                case 7:
                    PRStream pRStream = (PRStream) pdfObject;
                    PRStream pRStream2 = new PRStream(pRStream, (PdfDictionary) null, pdfReader);
                    duplicatePdfDictionary(pRStream, pRStream2, pdfReader);
                    return pRStream2;
                default:
                    return pdfObject;
            }
        }
        PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
        return new PRIndirectReference(pdfReader, pRIndirectReference.getNumber(), pRIndirectReference.getGeneration());
    }

    public void close() {
        if (this.partial) {
            try {
                this.tokens.close();
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
        r0.push(new java.lang.Object[]{r3, java.lang.Integer.valueOf(r6 + 1)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0116, code lost:
        r0.push(new java.lang.Object[]{r1, r13, java.lang.Integer.valueOf(r6 + 1)});
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void removeUnusedNode(com.itextpdf.text.pdf.PdfObject r13, boolean[] r14) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.removeUnusedNode(com.itextpdf.text.pdf.PdfObject, boolean[]):void");
    }

    public int removeUnusedObjects() {
        boolean[] zArr = new boolean[this.xrefObj.size()];
        removeUnusedNode(this.trailer, zArr);
        int i = 0;
        if (this.partial) {
            for (int i2 = 1; i2 < zArr.length; i2++) {
                if (!zArr[i2]) {
                    long[] jArr = this.xref;
                    int i3 = i2 * 2;
                    jArr[i3] = -1;
                    jArr[i3 + 1] = 0;
                    this.xrefObj.set(i2, null);
                    i++;
                }
            }
        } else {
            for (int i4 = 1; i4 < zArr.length; i4++) {
                if (!zArr[i4]) {
                    this.xrefObj.set(i4, null);
                    i++;
                }
            }
        }
        return i;
    }

    public AcroFields getAcroFields() {
        return new AcroFields(this, null);
    }

    public String getJavaScript(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfDictionary pdfDictionary;
        PdfObject pdfObjectRelease;
        PdfDictionary pdfDictionary2 = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.NAMES));
        if (pdfDictionary2 == null || (pdfDictionary = (PdfDictionary) getPdfObjectRelease(pdfDictionary2.get(PdfName.JAVASCRIPT))) == null) {
            return null;
        }
        HashMap<String, PdfObject> readTree = PdfNameTree.readTree(pdfDictionary);
        String[] strArr = (String[]) readTree.keySet().toArray(new String[readTree.size()]);
        Arrays.sort(strArr);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strArr) {
            PdfDictionary pdfDictionary3 = (PdfDictionary) getPdfObjectRelease(readTree.get(str));
            if (pdfDictionary3 != null && (pdfObjectRelease = getPdfObjectRelease(pdfDictionary3.get(PdfName.f19733JS))) != null) {
                if (pdfObjectRelease.isString()) {
                    stringBuffer.append(((PdfString) pdfObjectRelease).toUnicodeString());
                    stringBuffer.append('\n');
                } else if (pdfObjectRelease.isStream()) {
                    byte[] streamBytes = getStreamBytes((PRStream) pdfObjectRelease, randomAccessFileOrArray);
                    if (streamBytes.length >= 2 && streamBytes[0] == -2 && streamBytes[1] == -1) {
                        stringBuffer.append(PdfEncodings.convertToString(streamBytes, PdfObject.TEXT_UNICODE));
                    } else {
                        stringBuffer.append(PdfEncodings.convertToString(streamBytes, PdfObject.TEXT_PDFDOCENCODING));
                    }
                    stringBuffer.append('\n');
                }
            }
        }
        return stringBuffer.toString();
    }

    public String getJavaScript() throws IOException {
        RandomAccessFileOrArray safeFile = getSafeFile();
        try {
            safeFile.reOpen();
            return getJavaScript(safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public void selectPages(String str) {
        selectPages(SequenceList.expand(str, getNumberOfPages()));
    }

    public void selectPages(List<Integer> list) {
        this.pageRefs.selectPages(list);
        removeUnusedObjects();
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        this.viewerPreferences.setViewerPreferences(i);
        setViewerPreferences(this.viewerPreferences);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
        setViewerPreferences(this.viewerPreferences);
    }

    public void setViewerPreferences(PdfViewerPreferencesImp pdfViewerPreferencesImp) {
        pdfViewerPreferencesImp.addToCatalog(this.catalog);
    }

    public int getSimpleViewerPreferences() {
        return PdfViewerPreferencesImp.getViewerPreferences(this.catalog).getPageLayoutAndMode();
    }

    public boolean isAppendable() {
        return this.appendable;
    }

    public void setAppendable(boolean z) {
        this.appendable = z;
        if (z) {
            getPdfObject(this.trailer.get(PdfName.ROOT));
        }
    }

    public boolean isNewXrefType() {
        return this.newXrefType;
    }

    public long getFileLength() {
        return this.fileLength;
    }

    public boolean isHybridXref() {
        return this.hybridXref;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PageRefs {
        private boolean keepPages;
        private int lastPageRead;
        private ArrayList<PdfDictionary> pageInh;
        private final PdfReader reader;
        private ArrayList<PRIndirectReference> refsn;
        private IntHashtable refsp;
        private int sizep;

        private PageRefs(PdfReader pdfReader) throws IOException {
            this.lastPageRead = -1;
            this.reader = pdfReader;
            if (pdfReader.partial) {
                this.refsp = new IntHashtable();
                this.sizep = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfReader.rootPages.get(PdfName.COUNT))).intValue();
                return;
            }
            readPages();
        }

        PageRefs(PageRefs pageRefs, PdfReader pdfReader) {
            this.lastPageRead = -1;
            this.reader = pdfReader;
            this.sizep = pageRefs.sizep;
            ArrayList<PRIndirectReference> arrayList = pageRefs.refsn;
            if (arrayList != null) {
                this.refsn = new ArrayList<>(arrayList);
                for (int i = 0; i < this.refsn.size(); i++) {
                    ArrayList<PRIndirectReference> arrayList2 = this.refsn;
                    arrayList2.set(i, (PRIndirectReference) PdfReader.duplicatePdfObject(arrayList2.get(i), pdfReader));
                }
                return;
            }
            this.refsp = (IntHashtable) pageRefs.refsp.clone();
        }

        int size() {
            ArrayList<PRIndirectReference> arrayList = this.refsn;
            if (arrayList != null) {
                return arrayList.size();
            }
            return this.sizep;
        }

        void readPages() throws IOException {
            if (this.refsn != null) {
                return;
            }
            this.refsp = null;
            this.refsn = new ArrayList<>();
            this.pageInh = new ArrayList<>();
            iteratePages((PRIndirectReference) this.reader.catalog.get(PdfName.PAGES));
            this.pageInh = null;
            this.reader.rootPages.put(PdfName.COUNT, new PdfNumber(this.refsn.size()));
        }

        void reReadPages() throws IOException {
            this.refsn = null;
            readPages();
        }

        public PdfDictionary getPageN(int i) {
            return (PdfDictionary) PdfReader.getPdfObject(getPageOrigRef(i));
        }

        public PdfDictionary getPageNRelease(int i) {
            PdfDictionary pageN = getPageN(i);
            releasePage(i);
            return pageN;
        }

        public PRIndirectReference getPageOrigRefRelease(int i) {
            PRIndirectReference pageOrigRef = getPageOrigRef(i);
            releasePage(i);
            return pageOrigRef;
        }

        public PRIndirectReference getPageOrigRef(int i) {
            int i2 = i - 1;
            if (i2 >= 0) {
                try {
                    if (i2 >= size()) {
                        return null;
                    }
                    if (this.refsn != null) {
                        return this.refsn.get(i2);
                    }
                    int i3 = this.refsp.get(i2);
                    if (i3 == 0) {
                        PRIndirectReference singlePage = getSinglePage(i2);
                        if (this.reader.lastXrefPartial == -1) {
                            this.lastPageRead = -1;
                        } else {
                            this.lastPageRead = i2;
                        }
                        this.reader.lastXrefPartial = -1;
                        this.refsp.put(i2, singlePage.getNumber());
                        if (this.keepPages) {
                            this.lastPageRead = -1;
                        }
                        return singlePage;
                    }
                    if (this.lastPageRead != i2) {
                        this.lastPageRead = -1;
                    }
                    if (this.keepPages) {
                        this.lastPageRead = -1;
                    }
                    return new PRIndirectReference(this.reader, i3);
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            }
            return null;
        }

        void keepPages() {
            IntHashtable intHashtable = this.refsp;
            if (intHashtable == null || this.keepPages) {
                return;
            }
            this.keepPages = true;
            intHashtable.clear();
        }

        public void releasePage(int i) {
            int i2;
            if (this.refsp != null && i - 1 >= 0 && i2 < size() && i2 == this.lastPageRead) {
                this.lastPageRead = -1;
                this.reader.lastXrefPartial = this.refsp.get(i2);
                this.reader.releaseLastXrefPartial();
                this.refsp.remove(i2);
            }
        }

        public void resetReleasePage() {
            if (this.refsp == null) {
                return;
            }
            this.lastPageRead = -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void insertPage(int i, PRIndirectReference pRIndirectReference) {
            int i2 = i - 1;
            ArrayList<PRIndirectReference> arrayList = this.refsn;
            if (arrayList != null) {
                if (i2 >= arrayList.size()) {
                    this.refsn.add(pRIndirectReference);
                    return;
                } else {
                    this.refsn.add(i2, pRIndirectReference);
                    return;
                }
            }
            this.sizep++;
            this.lastPageRead = -1;
            if (i2 >= size()) {
                this.refsp.put(size(), pRIndirectReference.getNumber());
                return;
            }
            IntHashtable intHashtable = new IntHashtable((this.refsp.size() + 1) * 2);
            Iterator<IntHashtable.Entry> entryIterator = this.refsp.getEntryIterator();
            while (entryIterator.hasNext()) {
                IntHashtable.Entry next = entryIterator.next();
                int key = next.getKey();
                if (key >= i2) {
                    key++;
                }
                intHashtable.put(key, next.getValue());
            }
            intHashtable.put(i2, pRIndirectReference.getNumber());
            this.refsp = intHashtable;
        }

        private void pushPageAttributes(PdfDictionary pdfDictionary) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            if (!this.pageInh.isEmpty()) {
                ArrayList<PdfDictionary> arrayList = this.pageInh;
                pdfDictionary2.putAll(arrayList.get(arrayList.size() - 1));
            }
            for (int i = 0; i < PdfReader.pageInhCandidates.length; i++) {
                PdfObject pdfObject = pdfDictionary.get(PdfReader.pageInhCandidates[i]);
                if (pdfObject != null) {
                    pdfDictionary2.put(PdfReader.pageInhCandidates[i], pdfObject);
                }
            }
            this.pageInh.add(pdfDictionary2);
        }

        private void popPageAttributes() {
            ArrayList<PdfDictionary> arrayList = this.pageInh;
            arrayList.remove(arrayList.size() - 1);
        }

        private void iteratePages(PRIndirectReference pRIndirectReference) throws IOException {
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
            if (pdfDictionary == null) {
                return;
            }
            PdfArray asArray = pdfDictionary.getAsArray(PdfName.KIDS);
            int i = 0;
            if (asArray == null) {
                pdfDictionary.put(PdfName.TYPE, PdfName.PAGE);
                ArrayList<PdfDictionary> arrayList = this.pageInh;
                PdfDictionary pdfDictionary2 = arrayList.get(arrayList.size() - 1);
                for (PdfName pdfName : pdfDictionary2.getKeys()) {
                    if (pdfDictionary.get(pdfName) == null) {
                        pdfDictionary.put(pdfName, pdfDictionary2.get(pdfName));
                    }
                }
                if (pdfDictionary.get(PdfName.MEDIABOX) == null) {
                    pdfDictionary.put(PdfName.MEDIABOX, new PdfArray(new float[]{ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, PageSize.LETTER.getRight(), PageSize.LETTER.getTop()}));
                }
                this.refsn.add(pRIndirectReference);
                return;
            }
            pdfDictionary.put(PdfName.TYPE, PdfName.PAGES);
            pushPageAttributes(pdfDictionary);
            while (true) {
                if (i >= asArray.size()) {
                    break;
                }
                PdfObject pdfObject = asArray.getPdfObject(i);
                if (!pdfObject.isIndirect()) {
                    while (i < asArray.size()) {
                        asArray.remove(i);
                    }
                } else {
                    iteratePages((PRIndirectReference) pdfObject);
                    i++;
                }
            }
            popPageAttributes();
        }

        protected PRIndirectReference getSinglePage(int i) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            PdfDictionary pdfDictionary2 = this.reader.rootPages;
            int i2 = 0;
            while (true) {
                for (int i3 = 0; i3 < PdfReader.pageInhCandidates.length; i3++) {
                    PdfObject pdfObject = pdfDictionary2.get(PdfReader.pageInhCandidates[i3]);
                    if (pdfObject != null) {
                        pdfDictionary.put(PdfReader.pageInhCandidates[i3], pdfObject);
                    }
                }
                ListIterator<PdfObject> listIterator = ((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.KIDS))).listIterator();
                while (true) {
                    if (listIterator.hasNext()) {
                        PRIndirectReference pRIndirectReference = (PRIndirectReference) listIterator.next();
                        PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
                        int i4 = this.reader.lastXrefPartial;
                        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary3.get(PdfName.COUNT));
                        this.reader.lastXrefPartial = i4;
                        int intValue = ((pdfObjectRelease == null || pdfObjectRelease.type() != 2) ? 1 : ((PdfNumber) pdfObjectRelease).intValue()) + i2;
                        if (i >= intValue) {
                            this.reader.releaseLastXrefPartial();
                            i2 = intValue;
                        } else if (pdfObjectRelease == null) {
                            pdfDictionary3.mergeDifferent(pdfDictionary);
                            return pRIndirectReference;
                        } else {
                            this.reader.releaseLastXrefPartial();
                            pdfDictionary2 = pdfDictionary3;
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void selectPages(List<Integer> list) {
            IntHashtable intHashtable = new IntHashtable();
            ArrayList arrayList = new ArrayList();
            int size = size();
            for (Integer num : list) {
                int intValue = num.intValue();
                if (intValue > 0 && intValue <= size && intHashtable.put(intValue, 1) == 0) {
                    arrayList.add(num);
                }
            }
            if (this.reader.partial) {
                for (int i = 1; i <= size; i++) {
                    getPageOrigRef(i);
                    resetReleasePage();
                }
            }
            PRIndirectReference pRIndirectReference = (PRIndirectReference) this.reader.catalog.get(PdfName.PAGES);
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pRIndirectReference);
            ArrayList<PRIndirectReference> arrayList2 = new ArrayList<>(arrayList.size());
            PdfArray pdfArray = new PdfArray();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                int intValue2 = ((Integer) arrayList.get(i2)).intValue();
                PRIndirectReference pageOrigRef = getPageOrigRef(intValue2);
                resetReleasePage();
                pdfArray.add(pageOrigRef);
                arrayList2.add(pageOrigRef);
                getPageN(intValue2).put(PdfName.PARENT, pRIndirectReference);
            }
            AcroFields acroFields = this.reader.getAcroFields();
            boolean z = acroFields.getFields().size() > 0;
            for (int i3 = 1; i3 <= size; i3++) {
                if (!intHashtable.containsKey(i3)) {
                    if (z) {
                        acroFields.removeFieldsFromPage(i3);
                    }
                    int number = getPageOrigRef(i3).getNumber();
                    this.reader.xrefObj.set(number, null);
                    if (this.reader.partial) {
                        int i4 = number * 2;
                        this.reader.xref[i4] = -1;
                        this.reader.xref[i4 + 1] = 0;
                    }
                }
            }
            pdfDictionary.put(PdfName.COUNT, new PdfNumber(arrayList.size()));
            pdfDictionary.put(PdfName.KIDS, pdfArray);
            this.refsp = null;
            this.refsn = arrayList2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfIndirectReference getCryptoRef() {
        PRIndirectReference pRIndirectReference = this.cryptoRef;
        if (pRIndirectReference == null) {
            return null;
        }
        return new PdfIndirectReference(0, pRIndirectReference.getNumber(), this.cryptoRef.getGeneration());
    }

    public void removeUsageRights() {
        PdfDictionary asDict = this.catalog.getAsDict(PdfName.PERMS);
        if (asDict == null) {
            return;
        }
        asDict.remove(PdfName.f19786UR);
        asDict.remove(PdfName.UR3);
        if (asDict.size() == 0) {
            this.catalog.remove(PdfName.PERMS);
        }
    }

    public int getCertificationLevel() {
        PdfDictionary asDict;
        PdfArray asArray;
        PdfDictionary asDict2;
        PdfDictionary asDict3;
        PdfNumber asNumber;
        PdfDictionary asDict4 = this.catalog.getAsDict(PdfName.PERMS);
        if (asDict4 == null || (asDict = asDict4.getAsDict(PdfName.DOCMDP)) == null || (asArray = asDict.getAsArray(PdfName.REFERENCE)) == null || asArray.size() == 0 || (asDict2 = asArray.getAsDict(0)) == null || (asDict3 = asDict2.getAsDict(PdfName.TRANSFORMPARAMS)) == null || (asNumber = asDict3.getAsNumber(PdfName.f19752P)) == null) {
            return 0;
        }
        return asNumber.intValue();
    }

    public final boolean isOpenedWithFullPermissions() {
        return !this.encrypted || this.ownerPasswordUsed || unethicalreading;
    }

    public int getCryptoMode() {
        PdfEncryption pdfEncryption = this.decrypt;
        if (pdfEncryption == null) {
            return -1;
        }
        return pdfEncryption.getCryptoMode();
    }

    public boolean isMetadataEncrypted() {
        PdfEncryption pdfEncryption = this.decrypt;
        if (pdfEncryption == null) {
            return false;
        }
        return pdfEncryption.isMetadataEncrypted();
    }

    public byte[] computeUserPassword() {
        if (this.encrypted && this.ownerPasswordUsed) {
            return this.decrypt.computeUserPassword(this.password);
        }
        return null;
    }
}
