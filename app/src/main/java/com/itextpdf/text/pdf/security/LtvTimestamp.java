package com.itextpdf.text.pdf.security;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfSignature;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfString;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;

/* loaded from: classes.dex */
public class LtvTimestamp {
    public static void timestamp(PdfSignatureAppearance pdfSignatureAppearance, TSAClient tSAClient, String str) throws Exception {
        int tokenSizeEstimate = tSAClient.getTokenSizeEstimate();
        pdfSignatureAppearance.setVisibleSignature(new Rectangle(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO), 1, str);
        PdfSignature pdfSignature = new PdfSignature(PdfName.ADOBE_PPKLITE, PdfName.ETSI_RFC3161);
        pdfSignature.put(PdfName.TYPE, PdfName.DOCTIMESTAMP);
        pdfSignatureAppearance.setCryptoDictionary(pdfSignature);
        HashMap<PdfName, Integer> hashMap = new HashMap<>();
        hashMap.put(PdfName.CONTENTS, new Integer((tokenSizeEstimate * 2) + 2));
        pdfSignatureAppearance.preClose(hashMap);
        InputStream rangeStream = pdfSignatureAppearance.getRangeStream();
        MessageDigest messageDigest = tSAClient.getMessageDigest();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = rangeStream.read(bArr);
            if (read <= 0) {
                break;
            }
            messageDigest.update(bArr, 0, read);
        }
        byte[] timeStampToken = tSAClient.getTimeStampToken(messageDigest.digest());
        if (tokenSizeEstimate + 2 < timeStampToken.length) {
            throw new Exception("Not enough space");
        }
        byte[] bArr2 = new byte[tokenSizeEstimate];
        System.arraycopy(timeStampToken, 0, bArr2, 0, timeStampToken.length);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.CONTENTS, new PdfString(bArr2).setHexWriting(true));
        pdfSignatureAppearance.close(pdfDictionary);
    }
}
