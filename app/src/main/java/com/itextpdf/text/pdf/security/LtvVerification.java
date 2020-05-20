package com.itextpdf.text.pdf.security;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfEncodings;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;

/* loaded from: classes.dex */
public class LtvVerification {
    private AcroFields acroFields;
    private PdfReader reader;
    private PdfStamper stp;
    private PdfWriter writer;
    private Map<PdfName, ValidationData> validated = new HashMap();
    private boolean used = false;

    /* renamed from: com.itextpdf.text.pdf.security.LtvVerification$1 */
    /* loaded from: classes.dex */
    class C36401 {
    }

    /* loaded from: classes.dex */
    public enum CertificateInclusion {
        YES,
        NO
    }

    /* loaded from: classes.dex */
    public enum CertificateOption {
        SIGNING_CERTIFICATE,
        WHOLE_CHAIN
    }

    /* loaded from: classes.dex */
    public enum Level {
        OCSP,
        CRL,
        OCSP_CRL,
        OCSP_OPTIONAL_CRL
    }

    public LtvVerification(PdfStamper pdfStamper) {
        this.stp = pdfStamper;
        this.writer = pdfStamper.getWriter();
        this.reader = pdfStamper.getReader();
        this.acroFields = pdfStamper.getAcroFields();
    }

    public boolean addVerification(String str, OcspClient ocspClient, CrlClient crlClient, CertificateOption certificateOption, Level level, CertificateInclusion certificateInclusion) throws IOException, GeneralSecurityException {
        byte[] bArr;
        Collection<byte[]> encoded;
        boolean z;
        if (this.used) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("verification.already.output", new Object[0]));
        }
        Certificate[] signCertificateChain = this.acroFields.verifySignature(str).getSignCertificateChain();
        ValidationData validationData = new ValidationData(null);
        for (int i = 0; i < signCertificateChain.length; i++) {
            if (ocspClient == null || level == Level.CRL || i >= signCertificateChain.length - 1) {
                bArr = null;
            } else {
                bArr = ocspClient.getEncoded((X509Certificate) signCertificateChain[i], (X509Certificate) signCertificateChain[i + 1], null);
                if (bArr != null) {
                    validationData.ocsps.add(buildOCSPResponse(bArr));
                }
            }
            if (crlClient != null && ((level == Level.CRL || level == Level.OCSP_CRL || (level == Level.OCSP_OPTIONAL_CRL && bArr == null)) && (encoded = crlClient.getEncoded((X509Certificate) signCertificateChain[i], null)) != null)) {
                for (byte[] bArr2 : encoded) {
                    Iterator<byte[]> it = validationData.crls.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (Arrays.equals(it.next(), bArr2)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        validationData.crls.add(bArr2);
                    }
                }
            }
            if (certificateOption == CertificateOption.SIGNING_CERTIFICATE) {
                break;
            }
        }
        if (validationData.crls.isEmpty() && validationData.ocsps.isEmpty()) {
            return false;
        }
        if (certificateInclusion == CertificateInclusion.YES) {
            for (Certificate certificate : signCertificateChain) {
                validationData.certs.add(certificate.getEncoded());
            }
        }
        this.validated.put(getSignatureHashKey(str), validationData);
        return true;
    }

    public boolean addVerification(String str, Collection<byte[]> collection, Collection<byte[]> collection2, Collection<byte[]> collection3) throws IOException, GeneralSecurityException {
        if (this.used) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("verification.already.output", new Object[0]));
        }
        ValidationData validationData = new ValidationData(null);
        if (collection != null) {
            for (byte[] bArr : collection) {
                validationData.ocsps.add(buildOCSPResponse(bArr));
            }
        }
        if (collection2 != null) {
            for (byte[] bArr2 : collection2) {
                validationData.crls.add(bArr2);
            }
        }
        if (collection3 != null) {
            for (byte[] bArr3 : collection3) {
                validationData.certs.add(bArr3);
            }
        }
        this.validated.put(getSignatureHashKey(str), validationData);
        return true;
    }

    private static byte[] buildOCSPResponse(byte[] bArr) throws IOException {
        DEROctetString dEROctetString = new DEROctetString(bArr);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(OCSPObjectIdentifiers.id_pkix_ocsp_basic);
        aSN1EncodableVector.add(dEROctetString);
        ASN1Enumerated aSN1Enumerated = new ASN1Enumerated(0);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(aSN1Enumerated);
        aSN1EncodableVector2.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector)));
        return new DERSequence(aSN1EncodableVector2).getEncoded();
    }

    private PdfName getSignatureHashKey(String str) throws NoSuchAlgorithmException, IOException {
        PdfDictionary signatureDictionary = this.acroFields.getSignatureDictionary(str);
        byte[] originalBytes = signatureDictionary.getAsString(PdfName.CONTENTS).getOriginalBytes();
        if (PdfName.ETSI_RFC3161.equals(PdfReader.getPdfObject(signatureDictionary.get(PdfName.SUBFILTER)))) {
            originalBytes = new ASN1InputStream(new ByteArrayInputStream(originalBytes)).readObject().getEncoded();
        }
        return new PdfName(convertToHex(hashBytesSha1(originalBytes)));
    }

    private static String convertToHex(byte[] bArr) {
        ByteBuffer byteBuffer = new ByteBuffer();
        for (byte b : bArr) {
            byteBuffer.appendHex(b);
        }
        return PdfEncodings.convertToString(byteBuffer.toByteArray(), null).toUpperCase();
    }

    private static byte[] hashBytesSha1(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA1").digest(bArr);
    }

    public void merge() throws IOException {
        if (this.used || this.validated.isEmpty()) {
            return;
        }
        this.used = true;
        if (this.reader.getCatalog().get(PdfName.DSS) == null) {
            createDss();
        } else {
            updateDss();
        }
    }

    private void updateDss() throws IOException {
        PdfDictionary asDict;
        PdfDictionary catalog = this.reader.getCatalog();
        this.stp.markUsed(catalog);
        PdfDictionary asDict2 = catalog.getAsDict(PdfName.DSS);
        PdfArray asArray = asDict2.getAsArray(PdfName.OCSPS);
        PdfArray asArray2 = asDict2.getAsArray(PdfName.CRLS);
        PdfArray asArray3 = asDict2.getAsArray(PdfName.CERTS);
        asDict2.remove(PdfName.OCSPS);
        asDict2.remove(PdfName.CRLS);
        asDict2.remove(PdfName.CERTS);
        PdfDictionary asDict3 = asDict2.getAsDict(PdfName.VRI);
        if (asDict3 != null) {
            for (PdfName pdfName : asDict3.getKeys()) {
                if (this.validated.containsKey(pdfName) && (asDict = asDict3.getAsDict(pdfName)) != null) {
                    deleteOldReferences(asArray, asDict.getAsArray(PdfName.OCSP));
                    deleteOldReferences(asArray2, asDict.getAsArray(PdfName.CRL));
                    deleteOldReferences(asArray3, asDict.getAsArray(PdfName.CERT));
                }
            }
        }
        outputDss(asDict2, asDict3, asArray == null ? new PdfArray() : asArray, asArray2 == null ? new PdfArray() : asArray2, asArray3 == null ? new PdfArray() : asArray3);
    }

    private static void deleteOldReferences(PdfArray pdfArray, PdfArray pdfArray2) {
        if (pdfArray == null || pdfArray2 == null) {
            return;
        }
        Iterator<PdfObject> it = pdfArray2.iterator();
        while (it.hasNext()) {
            PdfObject next = it.next();
            if (next.isIndirect()) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) next;
                int i = 0;
                while (i < pdfArray.size()) {
                    PdfObject pdfObject = pdfArray.getPdfObject(i);
                    if (pdfObject.isIndirect() && pRIndirectReference.getNumber() == ((PRIndirectReference) pdfObject).getNumber()) {
                        pdfArray.remove(i);
                        i--;
                    }
                    i++;
                }
            }
        }
    }

    private void createDss() throws IOException {
        outputDss(new PdfDictionary(), new PdfDictionary(), new PdfArray(), new PdfArray(), new PdfArray());
    }

    private void outputDss(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfArray pdfArray, PdfArray pdfArray2, PdfArray pdfArray3) throws IOException {
        PdfDictionary catalog = this.reader.getCatalog();
        this.stp.markUsed(catalog);
        Iterator<PdfName> it = this.validated.keySet().iterator();
        while (it.hasNext()) {
            PdfName next = it.next();
            PdfArray pdfArray4 = new PdfArray();
            PdfArray pdfArray5 = new PdfArray();
            PdfArray pdfArray6 = new PdfArray();
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            for (byte[] bArr : this.validated.get(next).crls) {
                PdfStream pdfStream = new PdfStream(bArr);
                pdfStream.flateCompress();
                Iterator<PdfName> it2 = it;
                PdfIndirectReference indirectReference = this.writer.addToBody((PdfObject) pdfStream, false).getIndirectReference();
                pdfArray5.add(indirectReference);
                pdfArray2.add(indirectReference);
                it = it2;
            }
            Iterator<PdfName> it3 = it;
            for (byte[] bArr2 : this.validated.get(next).ocsps) {
                PdfStream pdfStream2 = new PdfStream(bArr2);
                pdfStream2.flateCompress();
                PdfIndirectReference indirectReference2 = this.writer.addToBody((PdfObject) pdfStream2, false).getIndirectReference();
                pdfArray4.add(indirectReference2);
                pdfArray.add(indirectReference2);
            }
            for (byte[] bArr3 : this.validated.get(next).certs) {
                PdfStream pdfStream3 = new PdfStream(bArr3);
                pdfStream3.flateCompress();
                PdfIndirectReference indirectReference3 = this.writer.addToBody((PdfObject) pdfStream3, false).getIndirectReference();
                pdfArray6.add(indirectReference3);
                pdfArray3.add(indirectReference3);
            }
            if (pdfArray4.size() > 0) {
                pdfDictionary3.put(PdfName.OCSP, this.writer.addToBody((PdfObject) pdfArray4, false).getIndirectReference());
            }
            if (pdfArray5.size() > 0) {
                pdfDictionary3.put(PdfName.CRL, this.writer.addToBody((PdfObject) pdfArray5, false).getIndirectReference());
            }
            if (pdfArray6.size() > 0) {
                pdfDictionary3.put(PdfName.CERT, this.writer.addToBody((PdfObject) pdfArray6, false).getIndirectReference());
            }
            pdfDictionary2.put(next, this.writer.addToBody((PdfObject) pdfDictionary3, false).getIndirectReference());
            it = it3;
        }
        pdfDictionary.put(PdfName.VRI, this.writer.addToBody((PdfObject) pdfDictionary2, false).getIndirectReference());
        if (pdfArray.size() > 0) {
            pdfDictionary.put(PdfName.OCSPS, this.writer.addToBody((PdfObject) pdfArray, false).getIndirectReference());
        }
        if (pdfArray2.size() > 0) {
            pdfDictionary.put(PdfName.CRLS, this.writer.addToBody((PdfObject) pdfArray2, false).getIndirectReference());
        }
        if (pdfArray3.size() > 0) {
            pdfDictionary.put(PdfName.CERTS, this.writer.addToBody((PdfObject) pdfArray3, false).getIndirectReference());
        }
        catalog.put(PdfName.DSS, this.writer.addToBody((PdfObject) pdfDictionary, false).getIndirectReference());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ValidationData {
        public List<byte[]> certs;
        public List<byte[]> crls;
        public List<byte[]> ocsps;

        private ValidationData() {
            this.crls = new ArrayList();
            this.ocsps = new ArrayList();
            this.certs = new ArrayList();
        }

        /* synthetic */ ValidationData(C36401 c36401) {
            this();
        }
    }
}
