package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.security.LtvVerification;
import com.itextpdf.text.xml.xmp.PdfSchema;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PdfStamper implements PdfEncryptionSettings, PdfViewerPreferences {
    private boolean hasSignature;
    private Map<String, String> moreInfo;
    private PdfSignatureAppearance sigApp;
    protected PdfStamperImp stamper;
    private LtvVerification verification;

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream) throws DocumentException, IOException {
        this.stamper = new PdfStamperImp(pdfReader, outputStream, (char) 0, false);
    }

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream, char c) throws DocumentException, IOException {
        this.stamper = new PdfStamperImp(pdfReader, outputStream, c, false);
    }

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream, char c, boolean z) throws DocumentException, IOException {
        this.stamper = new PdfStamperImp(pdfReader, outputStream, c, z);
    }

    public Map<String, String> getMoreInfo() {
        return this.moreInfo;
    }

    public void setMoreInfo(Map<String, String> map) {
        this.moreInfo = map;
    }

    public void replacePage(PdfReader pdfReader, int i, int i2) {
        this.stamper.replacePage(pdfReader, i, i2);
    }

    public void insertPage(int i, Rectangle rectangle) {
        this.stamper.insertPage(i, rectangle);
    }

    public PdfSignatureAppearance getSignatureAppearance() {
        return this.sigApp;
    }

    public void close() throws DocumentException, IOException {
        if (!this.hasSignature) {
            mergeVerification();
            this.stamper.close(this.moreInfo);
            return;
        }
        throw new DocumentException("Signature defined. Must be closed in PdfSignatureAppearance.");
    }

    public PdfContentByte getUnderContent(int i) {
        return this.stamper.getUnderContent(i);
    }

    public PdfContentByte getOverContent(int i) {
        return this.stamper.getOverContent(i);
    }

    public boolean isRotateContents() {
        return this.stamper.isRotateContents();
    }

    public void setRotateContents(boolean z) {
        this.stamper.setRotateContents(z);
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        if (this.stamper.isAppend()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("append.mode.does.not.support.changing.the.encryption.status", new Object[0]));
        }
        if (this.stamper.isContentWritten()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("content.was.already.written.to.the.output", new Object[0]));
        }
        this.stamper.setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        if (this.stamper.isAppend()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("append.mode.does.not.support.changing.the.encryption.status", new Object[0]));
        }
        if (this.stamper.isContentWritten()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("content.was.already.written.to.the.output", new Object[0]));
        }
        this.stamper.setEncryption(bArr, bArr2, i, i2);
    }

    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i, z);
    }

    public void setEncryption(int i, String str, String str2, int i2) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i2, i);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        if (this.stamper.isAppend()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("append.mode.does.not.support.changing.the.encryption.status", new Object[0]));
        }
        if (this.stamper.isContentWritten()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("content.was.already.written.to.the.output", new Object[0]));
        }
        this.stamper.setEncryption(certificateArr, iArr, i);
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        return this.stamper.getImportedPage(pdfReader, i);
    }

    public PdfWriter getWriter() {
        return this.stamper;
    }

    public PdfReader getReader() {
        return this.stamper.reader;
    }

    public AcroFields getAcroFields() {
        return this.stamper.getAcroFields();
    }

    public void setFormFlattening(boolean z) {
        this.stamper.setFormFlattening(z);
    }

    public void setFreeTextFlattening(boolean z) {
        this.stamper.setFreeTextFlattening(z);
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation, int i) {
        this.stamper.addAnnotation(pdfAnnotation, i);
    }

    public PdfFormField addSignature(String str, int i, float f, float f2, float f3, float f4) {
        PdfAcroForm acroForm = this.stamper.getAcroForm();
        PdfFormField createSignature = PdfFormField.createSignature(this.stamper);
        acroForm.setSignatureParams(createSignature, str, f, f2, f3, f4);
        acroForm.drawSignatureAppearences(createSignature, f, f2, f3, f4);
        addAnnotation(createSignature, i);
        return createSignature;
    }

    public void addComments(FdfReader fdfReader) throws IOException {
        this.stamper.addComments(fdfReader);
    }

    public void setOutlines(List<HashMap<String, Object>> list) {
        this.stamper.setOutlines(list);
    }

    public void setThumbnail(Image image, int i) throws PdfException, DocumentException {
        this.stamper.setThumbnail(image, i);
    }

    public boolean partialFormFlattening(String str) {
        return this.stamper.partialFormFlattening(str);
    }

    public void addJavaScript(String str) {
        this.stamper.addJavaScript(str, !PdfEncodings.isPdfDocEncoding(str));
    }

    public void addFileAttachment(String str, byte[] bArr, String str2, String str3) throws IOException {
        addFileAttachment(str, PdfFileSpecification.fileEmbedded(this.stamper, str2, str3, bArr));
    }

    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        this.stamper.addFileAttachment(str, pdfFileSpecification);
    }

    public void makePackage(PdfName pdfName) {
        PdfCollection pdfCollection = new PdfCollection(0);
        pdfCollection.put(PdfName.VIEW, pdfName);
        this.stamper.makePackage(pdfCollection);
    }

    public void makePackage(PdfCollection pdfCollection) {
        this.stamper.makePackage(pdfCollection);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        this.stamper.setViewerPreferences(i);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.stamper.addViewerPreference(pdfName, pdfObject);
    }

    public void setXmpMetadata(byte[] bArr) {
        this.stamper.setXmpMetadata(bArr);
    }

    public boolean isFullCompression() {
        return this.stamper.isFullCompression();
    }

    public void setFullCompression() {
        if (this.stamper.isAppend()) {
            return;
        }
        this.stamper.setFullCompression();
    }

    public void setPageAction(PdfName pdfName, PdfAction pdfAction, int i) throws PdfException {
        this.stamper.setPageAction(pdfName, pdfAction, i);
    }

    public void setDuration(int i, int i2) {
        this.stamper.setDuration(i, i2);
    }

    public void setTransition(PdfTransition pdfTransition, int i) {
        this.stamper.setTransition(pdfTransition, i);
    }

    public static PdfStamper createSignature(PdfReader pdfReader, OutputStream outputStream, char c, File file, boolean z) throws DocumentException, IOException {
        PdfStamper pdfStamper;
        if (file == null) {
            ByteBuffer byteBuffer = new ByteBuffer();
            pdfStamper = new PdfStamper(pdfReader, byteBuffer, c, z);
            pdfStamper.sigApp = new PdfSignatureAppearance(pdfStamper.stamper);
            pdfStamper.sigApp.setSigout(byteBuffer);
        } else {
            if (file.isDirectory()) {
                file = File.createTempFile(PdfSchema.DEFAULT_XPATH_ID, null, file);
            }
            PdfStamper pdfStamper2 = new PdfStamper(pdfReader, new FileOutputStream(file), c, z);
            pdfStamper2.sigApp = new PdfSignatureAppearance(pdfStamper2.stamper);
            pdfStamper2.sigApp.setTempFile(file);
            pdfStamper = pdfStamper2;
        }
        pdfStamper.sigApp.setOriginalout(outputStream);
        pdfStamper.sigApp.setStamper(pdfStamper);
        pdfStamper.hasSignature = true;
        PdfDictionary catalog = pdfReader.getCatalog();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), catalog);
        if (pdfDictionary != null) {
            pdfDictionary.remove(PdfName.NEEDAPPEARANCES);
            pdfStamper.stamper.markUsed(pdfDictionary);
        }
        return pdfStamper;
    }

    public static PdfStamper createSignature(PdfReader pdfReader, OutputStream outputStream, char c) throws DocumentException, IOException {
        return createSignature(pdfReader, outputStream, c, null, false);
    }

    public static PdfStamper createSignature(PdfReader pdfReader, OutputStream outputStream, char c, File file) throws DocumentException, IOException {
        return createSignature(pdfReader, outputStream, c, file, false);
    }

    public Map<String, PdfLayer> getPdfLayers() {
        return this.stamper.getPdfLayers();
    }

    public void markUsed(PdfObject pdfObject) {
        this.stamper.markUsed(pdfObject);
    }

    public LtvVerification getLtvVerification() {
        if (this.verification == null) {
            this.verification = new LtvVerification(this);
        }
        return this.verification;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mergeVerification() throws IOException {
        LtvVerification ltvVerification = this.verification;
        if (ltvVerification == null) {
            return;
        }
        ltvVerification.merge();
    }

    protected PdfStamper() {
    }
}
