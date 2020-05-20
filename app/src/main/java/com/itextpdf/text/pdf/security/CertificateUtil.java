package com.itextpdf.text.pdf.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;

/* loaded from: classes.dex */
public class CertificateUtil {
    public static CRL getCRL(X509Certificate x509Certificate) throws CertificateException, CRLException, IOException {
        return getCRL(getCRLURL(x509Certificate));
    }

    public static String getCRLURL(X509Certificate x509Certificate) throws CertificateParsingException {
        ASN1Primitive aSN1Primitive;
        GeneralName[] names;
        try {
            aSN1Primitive = getExtensionValue(x509Certificate, Extension.cRLDistributionPoints.getId());
        } catch (IOException unused) {
            aSN1Primitive = null;
        }
        if (aSN1Primitive == null) {
            return null;
        }
        for (DistributionPoint distributionPoint : CRLDistPoint.getInstance(aSN1Primitive).getDistributionPoints()) {
            DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
            if (distributionPoint2.getType() == 0) {
                for (GeneralName generalName : distributionPoint2.getName().getNames()) {
                    if (generalName.getTagNo() == 6) {
                        return DERIA5String.getInstance(generalName.toASN1Primitive(), false).getString();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static CRL getCRL(String str) throws IOException, CertificateException, CRLException {
        if (str == null) {
            return null;
        }
        return CertificateFactory.getInstance("X.509").generateCRL(new URL(str).openStream());
    }

    public static String getOCSPURL(X509Certificate x509Certificate) {
        try {
            ASN1Sequence extensionValue = getExtensionValue(x509Certificate, Extension.authorityInfoAccess.getId());
            if (extensionValue == null) {
                return null;
            }
            ASN1Sequence aSN1Sequence = extensionValue;
            for (int i = 0; i < aSN1Sequence.size(); i++) {
                ASN1Sequence objectAt = aSN1Sequence.getObjectAt(i);
                if (objectAt.size() == 2 && (objectAt.getObjectAt(0) instanceof ASN1ObjectIdentifier) && SecurityIDs.ID_OCSP.equals(objectAt.getObjectAt(0).getId())) {
                    String stringFromGeneralName = getStringFromGeneralName(objectAt.getObjectAt(1));
                    return stringFromGeneralName == null ? "" : stringFromGeneralName;
                }
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public static String getTSAURL(X509Certificate x509Certificate) {
        byte[] extensionValue = x509Certificate.getExtensionValue(SecurityIDs.ID_TSA);
        if (extensionValue == null) {
            return null;
        }
        try {
            return getStringFromGeneralName(ASN1Sequence.getInstance(ASN1Primitive.fromByteArray(ASN1Primitive.fromByteArray(extensionValue).getOctets())).getObjectAt(1).toASN1Primitive());
        } catch (IOException unused) {
            return null;
        }
    }

    private static ASN1Primitive getExtensionValue(X509Certificate x509Certificate, String str) throws IOException {
        byte[] extensionValue = x509Certificate.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return new ASN1InputStream(new ByteArrayInputStream(new ASN1InputStream(new ByteArrayInputStream(extensionValue)).readObject().getOctets())).readObject();
    }

    private static String getStringFromGeneralName(ASN1Primitive aSN1Primitive) throws IOException {
        return new String(ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Primitive, false).getOctets(), "ISO-8859-1");
    }
}
