package com.itextpdf.text.pdf.security;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfSignature;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MakeSignature {
    private static final Logger LOGGER = LoggerFactory.getLogger(MakeSignature.class);

    /* loaded from: classes.dex */
    public enum CryptoStandard {
        CMS,
        CADES
    }

    public static void signDetached(PdfSignatureAppearance pdfSignatureAppearance, ExternalDigest externalDigest, ExternalSignature externalSignature, Certificate[] certificateArr, Collection<CrlClient> collection, OcspClient ocspClient, TSAClient tSAClient, int i, CryptoStandard cryptoStandard) throws IOException, DocumentException, GeneralSecurityException {
        int i2;
        Collection<byte[]> collection2 = null;
        for (int i3 = 0; collection2 == null && i3 < certificateArr.length; i3++) {
            collection2 = processCrl(certificateArr[i3], collection);
        }
        if (i == 0) {
            int i4 = 8192;
            if (collection2 != null) {
                for (byte[] bArr : collection2) {
                    i4 += bArr.length + 10;
                }
            }
            if (ocspClient != null) {
                i4 += 4192;
            }
            i2 = tSAClient != null ? i4 + 4192 : i4;
        } else {
            i2 = i;
        }
        pdfSignatureAppearance.setCertificate(certificateArr[0]);
        PdfSignature pdfSignature = new PdfSignature(PdfName.ADOBE_PPKLITE, cryptoStandard == CryptoStandard.CADES ? PdfName.ETSI_CADES_DETACHED : PdfName.ADBE_PKCS7_DETACHED);
        pdfSignature.setReason(pdfSignatureAppearance.getReason());
        pdfSignature.setLocation(pdfSignatureAppearance.getLocation());
        pdfSignature.setContact(pdfSignatureAppearance.getContact());
        pdfSignature.setDate(new PdfDate(pdfSignatureAppearance.getSignDate()));
        pdfSignatureAppearance.setCryptoDictionary(pdfSignature);
        HashMap<PdfName, Integer> hashMap = new HashMap<>();
        hashMap.put(PdfName.CONTENTS, new Integer((i2 * 2) + 2));
        pdfSignatureAppearance.preClose(hashMap);
        String hashAlgorithm = externalSignature.getHashAlgorithm();
        PdfPKCS7 pdfPKCS7 = new PdfPKCS7(null, certificateArr, hashAlgorithm, null, externalDigest, false);
        byte[] digest = DigestAlgorithms.digest(pdfSignatureAppearance.getRangeStream(), externalDigest.getMessageDigest(hashAlgorithm));
        Calendar calendar = Calendar.getInstance();
        byte[] encoded = (certificateArr.length < 2 || ocspClient == null) ? null : ocspClient.getEncoded((X509Certificate) certificateArr[0], (X509Certificate) certificateArr[1], null);
        pdfPKCS7.setExternalDigest(externalSignature.sign(pdfPKCS7.getAuthenticatedAttributeBytes(digest, calendar, encoded, collection2, cryptoStandard)), null, externalSignature.getEncryptionAlgorithm());
        byte[] encodedPKCS7 = pdfPKCS7.getEncodedPKCS7(digest, calendar, tSAClient, encoded, collection2, cryptoStandard);
        if (i2 + 2 < encodedPKCS7.length) {
            throw new IOException("Not enough space");
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(encodedPKCS7, 0, bArr2, 0, encodedPKCS7.length);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.CONTENTS, new PdfString(bArr2).setHexWriting(true));
        pdfSignatureAppearance.close(pdfDictionary);
    }

    public static Collection<byte[]> processCrl(Certificate certificate, Collection<CrlClient> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CrlClient crlClient : collection) {
            if (crlClient != null) {
                Logger logger = LOGGER;
                logger.info("Processing " + crlClient.getClass().getName());
                Collection<byte[]> encoded = crlClient.getEncoded((X509Certificate) certificate, null);
                if (encoded != null) {
                    arrayList.addAll(encoded);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }
}
