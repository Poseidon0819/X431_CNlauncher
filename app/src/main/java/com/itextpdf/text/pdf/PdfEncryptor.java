package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.PrivateKey;
import java.util.HashMap;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.RecipientInformation;
import org.bouncycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;

/* loaded from: classes.dex */
public final class PdfEncryptor {
    public static boolean isAssemblyAllowed(int i) {
        return (i & 1024) == 1024;
    }

    public static boolean isCopyAllowed(int i) {
        return (i & 16) == 16;
    }

    public static boolean isDegradedPrintingAllowed(int i) {
        return (i & 4) == 4;
    }

    public static boolean isFillInAllowed(int i) {
        return (i & 256) == 256;
    }

    public static boolean isModifyAnnotationsAllowed(int i) {
        return (i & 32) == 32;
    }

    public static boolean isModifyContentsAllowed(int i) {
        return (i & 8) == 8;
    }

    public static boolean isPrintingAllowed(int i) {
        return (i & 2052) == 2052;
    }

    public static boolean isScreenReadersAllowed(int i) {
        return (i & 512) == 512;
    }

    private PdfEncryptor() {
    }

    public static void encrypt(PdfReader pdfReader, OutputStream outputStream, byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.setEncryption(bArr, bArr2, i, z);
        pdfStamper.close();
    }

    public static void encrypt(PdfReader pdfReader, OutputStream outputStream, byte[] bArr, byte[] bArr2, int i, boolean z, HashMap<String, String> hashMap) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.setEncryption(bArr, bArr2, i, z);
        pdfStamper.setMoreInfo(hashMap);
        pdfStamper.close();
    }

    public static void encrypt(PdfReader pdfReader, OutputStream outputStream, boolean z, String str, String str2, int i) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.setEncryption(z, str, str2, i);
        pdfStamper.close();
    }

    public static void encrypt(PdfReader pdfReader, OutputStream outputStream, boolean z, String str, String str2, int i, HashMap<String, String> hashMap) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.setEncryption(z, str, str2, i);
        pdfStamper.setMoreInfo(hashMap);
        pdfStamper.close();
    }

    public static void encrypt(PdfReader pdfReader, OutputStream outputStream, int i, String str, String str2, int i2, HashMap<String, String> hashMap) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.setEncryption(i, str, str2, i2);
        pdfStamper.setMoreInfo(hashMap);
        pdfStamper.close();
    }

    public static void encrypt(PdfReader pdfReader, OutputStream outputStream, int i, String str, String str2, int i2) throws DocumentException, IOException {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        pdfStamper.setEncryption(i, str, str2, i2);
        pdfStamper.close();
    }

    public static String getPermissionsVerbose(int i) {
        StringBuffer stringBuffer = new StringBuffer("Allowed:");
        if ((i & 2052) == 2052) {
            stringBuffer.append(" Printing");
        }
        if ((i & 8) == 8) {
            stringBuffer.append(" Modify contents");
        }
        if ((i & 16) == 16) {
            stringBuffer.append(" Copy");
        }
        if ((i & 32) == 32) {
            stringBuffer.append(" Modify annotations");
        }
        if ((i & 256) == 256) {
            stringBuffer.append(" Fill in");
        }
        if ((i & 512) == 512) {
            stringBuffer.append(" Screen readers");
        }
        if ((i & 1024) == 1024) {
            stringBuffer.append(" Assembly");
        }
        if ((i & 4) == 4) {
            stringBuffer.append(" Degraded printing");
        }
        return stringBuffer.toString();
    }

    public static byte[] getContent(RecipientInformation recipientInformation, PrivateKey privateKey, String str) throws CMSException {
        return recipientInformation.getContent(new JceKeyTransEnvelopedRecipient(privateKey).setProvider(str));
    }
}
