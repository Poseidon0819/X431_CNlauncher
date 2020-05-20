package com.itextpdf.text.pdf.security;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.security.MakeSignature;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTCTime;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.tsp.MessageImprint;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cert.ocsp.BasicOCSPResp;
import org.bouncycastle.cert.ocsp.CertificateID;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.X509CertParser;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.tsp.TimeStampTokenInfo;

/* loaded from: classes.dex */
public class PdfPKCS7 {
    private byte[] RSAdata;
    private BasicOCSPResp basicResp;
    private Collection<Certificate> certs;
    private Collection<CRL> crls;
    private byte[] digest;
    private String digestAlgorithmOid;
    private byte[] digestAttr;
    private String digestEncryptionAlgorithmOid;
    private Set<String> digestalgos;
    private MessageDigest encContDigest;
    private byte[] externalDigest;
    private byte[] externalRSAdata;
    private ExternalDigest interfaceDigest;
    private boolean isTsp;
    private String location;
    private MessageDigest messageDigest;
    private String provider;
    private String reason;
    private Signature sig;
    private byte[] sigAttr;
    private X509Certificate signCert;
    private Collection<Certificate> signCerts;
    private Calendar signDate;
    private String signName;
    private int signerversion;
    private TimeStampToken timeStampToken;
    private boolean verified;
    private boolean verifyResult;
    private int version;

    public PdfPKCS7(PrivateKey privateKey, Certificate[] certificateArr, String str, String str2, ExternalDigest externalDigest, boolean z) throws InvalidKeyException, NoSuchProviderException, NoSuchAlgorithmException {
        this.version = 1;
        this.signerversion = 1;
        this.provider = str2;
        this.interfaceDigest = externalDigest;
        this.digestAlgorithmOid = DigestAlgorithms.getAllowedDigests(str);
        if (this.digestAlgorithmOid == null) {
            throw new NoSuchAlgorithmException(MessageLocalization.getComposedMessage("unknown.hash.algorithm.1", str));
        }
        this.signCert = (X509Certificate) certificateArr[0];
        this.certs = new ArrayList();
        for (Certificate certificate : certificateArr) {
            this.certs.add(certificate);
        }
        this.digestalgos = new HashSet();
        this.digestalgos.add(this.digestAlgorithmOid);
        if (privateKey != null) {
            this.digestEncryptionAlgorithmOid = privateKey.getAlgorithm();
            if (this.digestEncryptionAlgorithmOid.equals("RSA")) {
                this.digestEncryptionAlgorithmOid = SecurityIDs.ID_RSA;
            } else if (this.digestEncryptionAlgorithmOid.equals("DSA")) {
                this.digestEncryptionAlgorithmOid = SecurityIDs.ID_DSA;
            } else {
                throw new NoSuchAlgorithmException(MessageLocalization.getComposedMessage("unknown.key.algorithm.1", this.digestEncryptionAlgorithmOid));
            }
        }
        if (z) {
            this.RSAdata = new byte[0];
            this.messageDigest = DigestAlgorithms.getMessageDigest(getHashAlgorithm(), str2);
        }
        if (privateKey != null) {
            if (str2 == null) {
                this.sig = Signature.getInstance(getDigestAlgorithm());
            } else {
                this.sig = Signature.getInstance(getDigestAlgorithm(), str2);
            }
            this.sig.initSign(privateKey);
        }
    }

    public PdfPKCS7(byte[] bArr, byte[] bArr2, String str) {
        this.version = 1;
        this.signerversion = 1;
        try {
            this.provider = str;
            X509CertParser x509CertParser = new X509CertParser();
            x509CertParser.engineInit(new ByteArrayInputStream(bArr2));
            this.certs = x509CertParser.engineReadAll();
            this.signCerts = this.certs;
            this.signCert = (X509Certificate) this.certs.iterator().next();
            this.crls = new ArrayList();
            this.digest = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject().getOctets();
            if (str == null) {
                this.sig = Signature.getInstance("SHA1withRSA");
            } else {
                this.sig = Signature.getInstance("SHA1withRSA", str);
            }
            this.sig.initVerify(this.signCert.getPublicKey());
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfPKCS7(byte[] bArr, String str) {
        this(bArr, false, str);
    }

    public PdfPKCS7(byte[] bArr, boolean z, String str) {
        Attribute attribute;
        this.version = 1;
        this.signerversion = 1;
        this.isTsp = z;
        try {
            this.provider = str;
            try {
                ASN1Sequence readObject = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject();
                if (!(readObject instanceof ASN1Sequence)) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("not.a.valid.pkcs.7.object.not.a.sequence", new Object[0]));
                }
                ASN1Sequence aSN1Sequence = readObject;
                if (!aSN1Sequence.getObjectAt(0).getId().equals(SecurityIDs.ID_PKCS7_SIGNED_DATA)) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("not.a.valid.pkcs.7.object.not.signed.data", new Object[0]));
                }
                ASN1Sequence object = aSN1Sequence.getObjectAt(1).getObject();
                this.version = object.getObjectAt(0).getValue().intValue();
                this.digestalgos = new HashSet();
                Enumeration objects = object.getObjectAt(1).getObjects();
                while (objects.hasMoreElements()) {
                    this.digestalgos.add(((ASN1Sequence) objects.nextElement()).getObjectAt(0).getId());
                }
                X509CertParser x509CertParser = new X509CertParser();
                x509CertParser.engineInit(new ByteArrayInputStream(bArr));
                this.certs = x509CertParser.engineReadAll();
                ASN1Sequence objectAt = object.getObjectAt(2);
                if (objectAt.size() > 1) {
                    this.RSAdata = objectAt.getObjectAt(1).getObject().getOctets();
                }
                int i = 3;
                int i2 = 3;
                while (object.getObjectAt(i2) instanceof ASN1TaggedObject) {
                    i2++;
                }
                ASN1Set objectAt2 = object.getObjectAt(i2);
                if (objectAt2.size() != 1) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("this.pkcs.7.object.has.multiple.signerinfos.only.one.is.supported.at.this.time", new Object[0]));
                }
                ASN1Sequence objectAt3 = objectAt2.getObjectAt(0);
                this.signerversion = objectAt3.getObjectAt(0).getValue().intValue();
                ASN1Sequence objectAt4 = objectAt3.getObjectAt(1);
                X509Principal x509Principal = new X509Principal(objectAt4.getObjectAt(0).toASN1Primitive().getEncoded());
                BigInteger value = objectAt4.getObjectAt(1).getValue();
                Iterator<Certificate> it = this.certs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    X509Certificate x509Certificate = (X509Certificate) it.next();
                    if (x509Certificate.getIssuerDN().equals(x509Principal) && value.equals(x509Certificate.getSerialNumber())) {
                        this.signCert = x509Certificate;
                        break;
                    }
                }
                if (this.signCert == null) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("can.t.find.signing.certificate.with.serial.1", x509Principal.getName() + " / " + value.toString(16)));
                }
                signCertificateChain();
                this.digestAlgorithmOid = objectAt3.getObjectAt(2).getObjectAt(0).getId();
                if (objectAt3.getObjectAt(3) instanceof ASN1TaggedObject) {
                    ASN1Set aSN1Set = ASN1Set.getInstance(objectAt3.getObjectAt(3), false);
                    this.sigAttr = aSN1Set.getEncoded("DER");
                    for (int i3 = 0; i3 < aSN1Set.size(); i3++) {
                        ASN1Sequence objectAt5 = aSN1Set.getObjectAt(i3);
                        if (objectAt5.getObjectAt(0).getId().equals(SecurityIDs.ID_MESSAGE_DIGEST)) {
                            this.digestAttr = objectAt5.getObjectAt(1).getObjectAt(0).getOctets();
                        } else if (objectAt5.getObjectAt(0).getId().equals(SecurityIDs.ID_ADBE_REVOCATION)) {
                            ASN1Sequence objectAt6 = objectAt5.getObjectAt(1).getObjectAt(0);
                            for (int i4 = 0; i4 < objectAt6.size(); i4++) {
                                ASN1TaggedObject objectAt7 = objectAt6.getObjectAt(i4);
                                if (objectAt7.getTagNo() == 0) {
                                    findCRL((ASN1Sequence) objectAt7.getObject());
                                }
                                if (objectAt7.getTagNo() == 1) {
                                    findOcsp((ASN1Sequence) objectAt7.getObject());
                                }
                            }
                        }
                    }
                    if (this.digestAttr == null) {
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("authenticated.attribute.is.missing.the.digest", new Object[0]));
                    }
                    i = 4;
                }
                int i5 = i + 1;
                this.digestEncryptionAlgorithmOid = objectAt3.getObjectAt(i).getObjectAt(0).getId();
                int i6 = i5 + 1;
                this.digest = objectAt3.getObjectAt(i5).getOctets();
                if (i6 < objectAt3.size() && (objectAt3.getObjectAt(i6) instanceof ASN1TaggedObject) && (attribute = new AttributeTable(ASN1Set.getInstance(objectAt3.getObjectAt(i6), false)).get(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken)) != null && attribute.getAttrValues().size() > 0) {
                    this.timeStampToken = new TimeStampToken(new ContentInfo(ASN1Sequence.getInstance(attribute.getAttrValues().getObjectAt(0))));
                }
                if (this.isTsp) {
                    this.timeStampToken = new TimeStampToken(new ContentInfo(aSN1Sequence));
                    this.messageDigest = DigestAlgorithms.getMessageDigestFromOid(this.timeStampToken.getTimeStampInfo().getMessageImprintAlgOID().getId(), null);
                    return;
                }
                if (this.RSAdata != null || this.digestAttr != null) {
                    this.messageDigest = DigestAlgorithms.getMessageDigest(getHashAlgorithm(), str);
                    this.encContDigest = DigestAlgorithms.getMessageDigest(getHashAlgorithm(), str);
                }
                if (str == null) {
                    this.sig = Signature.getInstance(getDigestAlgorithm());
                } else {
                    this.sig = Signature.getInstance(getDigestAlgorithm(), str);
                }
                this.sig.initVerify(this.signCert.getPublicKey());
            } catch (IOException unused) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("can.t.decode.pkcs7signeddata.object", new Object[0]));
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public String getSignName() {
        return this.signName;
    }

    public void setSignName(String str) {
        this.signName = str;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public Calendar getSignDate() {
        return this.signDate;
    }

    public void setSignDate(Calendar calendar) {
        this.signDate = calendar;
    }

    public int getVersion() {
        return this.version;
    }

    public int getSigningInfoVersion() {
        return this.signerversion;
    }

    public String getDigestAlgorithmOid() {
        return this.digestAlgorithmOid;
    }

    public String getHashAlgorithm() {
        return DigestAlgorithms.getDigest(this.digestAlgorithmOid);
    }

    public String getDigestEncryptionAlgorithmOid() {
        return this.digestEncryptionAlgorithmOid;
    }

    public String getDigestAlgorithm() {
        String algorithm = EncryptionAlgorithms.getAlgorithm(this.digestEncryptionAlgorithmOid);
        if (algorithm == null) {
            algorithm = this.digestEncryptionAlgorithmOid;
        }
        return getHashAlgorithm() + "with" + algorithm;
    }

    public void setExternalDigest(byte[] bArr, byte[] bArr2, String str) {
        this.externalDigest = bArr;
        this.externalRSAdata = bArr2;
        if (str != null) {
            if (str.equals("RSA")) {
                this.digestEncryptionAlgorithmOid = SecurityIDs.ID_RSA;
            } else if (str.equals("DSA")) {
                this.digestEncryptionAlgorithmOid = SecurityIDs.ID_DSA;
            } else {
                throw new ExceptionConverter(new NoSuchAlgorithmException(MessageLocalization.getComposedMessage("unknown.key.algorithm.1", str)));
            }
        }
    }

    public void update(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.RSAdata != null || this.digestAttr != null || this.isTsp) {
            this.messageDigest.update(bArr, i, i2);
        } else {
            this.sig.update(bArr, i, i2);
        }
    }

    public byte[] getEncodedPKCS1() {
        try {
            if (this.externalDigest != null) {
                this.digest = this.externalDigest;
            } else {
                this.digest = this.sig.sign();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DEROctetString(this.digest));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public byte[] getEncodedPKCS7() {
        return getEncodedPKCS7(null, null, null, null, null, MakeSignature.CryptoStandard.CMS);
    }

    public byte[] getEncodedPKCS7(byte[] bArr, Calendar calendar) {
        return getEncodedPKCS7(bArr, calendar, null, null, null, MakeSignature.CryptoStandard.CMS);
    }

    public byte[] getEncodedPKCS7(byte[] bArr, Calendar calendar, TSAClient tSAClient, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        byte[] timeStampToken;
        ASN1EncodableVector buildUnauthenticatedAttributes;
        try {
            if (this.externalDigest != null) {
                this.digest = this.externalDigest;
                if (this.RSAdata != null) {
                    this.RSAdata = this.externalRSAdata;
                }
            } else {
                if (this.externalRSAdata != null && this.RSAdata != null) {
                    this.RSAdata = this.externalRSAdata;
                    this.sig.update(this.RSAdata);
                } else if (this.RSAdata != null) {
                    this.RSAdata = this.messageDigest.digest();
                    this.sig.update(this.RSAdata);
                }
                this.digest = this.sig.sign();
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (String str : this.digestalgos) {
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                aSN1EncodableVector2.add(new ASN1ObjectIdentifier(str));
                aSN1EncodableVector2.add(DERNull.INSTANCE);
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            }
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new ASN1ObjectIdentifier(SecurityIDs.ID_PKCS7_DATA));
            if (this.RSAdata != null) {
                aSN1EncodableVector3.add(new DERTaggedObject(0, new DEROctetString(this.RSAdata)));
            }
            DERSequence dERSequence = new DERSequence(aSN1EncodableVector3);
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            Iterator<Certificate> it = this.certs.iterator();
            while (it.hasNext()) {
                aSN1EncodableVector4.add(new ASN1InputStream(new ByteArrayInputStream(((X509Certificate) it.next()).getEncoded())).readObject());
            }
            DERSet dERSet = new DERSet(aSN1EncodableVector4);
            ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
            aSN1EncodableVector5.add(new ASN1Integer(this.signerversion));
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            aSN1EncodableVector6.add(CertificateInfo.getIssuer(this.signCert.getTBSCertificate()));
            aSN1EncodableVector6.add(new ASN1Integer(this.signCert.getSerialNumber()));
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector6));
            ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
            aSN1EncodableVector7.add(new ASN1ObjectIdentifier(this.digestAlgorithmOid));
            aSN1EncodableVector7.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector7));
            if (bArr != null && calendar != null) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 0, getAuthenticatedAttributeSet(bArr, calendar, bArr2, collection, cryptoStandard)));
            }
            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
            aSN1EncodableVector8.add(new ASN1ObjectIdentifier(this.digestEncryptionAlgorithmOid));
            aSN1EncodableVector8.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector8));
            aSN1EncodableVector5.add(new DEROctetString(this.digest));
            if (tSAClient != null && (timeStampToken = tSAClient.getTimeStampToken(tSAClient.getMessageDigest().digest(this.digest))) != null && (buildUnauthenticatedAttributes = buildUnauthenticatedAttributes(timeStampToken)) != null) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 1, new DERSet(buildUnauthenticatedAttributes)));
            }
            ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
            aSN1EncodableVector9.add(new ASN1Integer(this.version));
            aSN1EncodableVector9.add(new DERSet(aSN1EncodableVector));
            aSN1EncodableVector9.add(dERSequence);
            aSN1EncodableVector9.add(new DERTaggedObject(false, 0, dERSet));
            aSN1EncodableVector9.add(new DERSet(new DERSequence(aSN1EncodableVector5)));
            ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
            aSN1EncodableVector10.add(new ASN1ObjectIdentifier(SecurityIDs.ID_PKCS7_SIGNED_DATA));
            aSN1EncodableVector10.add(new DERTaggedObject(0, new DERSequence(aSN1EncodableVector9)));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DERSequence(aSN1EncodableVector10));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private ASN1EncodableVector buildUnauthenticatedAttributes(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        ASN1InputStream aSN1InputStream = new ASN1InputStream(new ByteArrayInputStream(bArr));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.2.14"));
        aSN1EncodableVector2.add(new DERSet(aSN1InputStream.readObject()));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        return aSN1EncodableVector;
    }

    public byte[] getAuthenticatedAttributeBytes(byte[] bArr, Calendar calendar, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        try {
            return getAuthenticatedAttributeSet(bArr, calendar, bArr2, collection, cryptoStandard).getEncoded("DER");
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private DERSet getAuthenticatedAttributeSet(byte[] bArr, Calendar calendar, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        boolean z;
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(new ASN1ObjectIdentifier(SecurityIDs.ID_CONTENT_TYPE));
            aSN1EncodableVector2.add(new DERSet(new ASN1ObjectIdentifier(SecurityIDs.ID_PKCS7_DATA)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new ASN1ObjectIdentifier(SecurityIDs.ID_SIGNING_TIME));
            aSN1EncodableVector3.add(new DERSet(new DERUTCTime(calendar.getTime())));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            aSN1EncodableVector4.add(new ASN1ObjectIdentifier(SecurityIDs.ID_MESSAGE_DIGEST));
            aSN1EncodableVector4.add(new DERSet(new DEROctetString(bArr)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
            if (collection != null) {
                for (byte[] bArr3 : collection) {
                    if (bArr3 != null) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (bArr2 != null || z) {
                ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                aSN1EncodableVector5.add(new ASN1ObjectIdentifier(SecurityIDs.ID_ADBE_REVOCATION));
                ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
                if (z) {
                    ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                    for (byte[] bArr4 : collection) {
                        if (bArr4 != null) {
                            aSN1EncodableVector7.add(new ASN1InputStream(new ByteArrayInputStream(bArr4)).readObject());
                        }
                    }
                    aSN1EncodableVector6.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector7)));
                }
                if (bArr2 != null) {
                    DEROctetString dEROctetString = new DEROctetString(bArr2);
                    ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                    aSN1EncodableVector9.add(OCSPObjectIdentifiers.id_pkix_ocsp_basic);
                    aSN1EncodableVector9.add(dEROctetString);
                    ASN1Enumerated aSN1Enumerated = new ASN1Enumerated(0);
                    ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                    aSN1EncodableVector10.add(aSN1Enumerated);
                    aSN1EncodableVector10.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector9)));
                    aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector10));
                    aSN1EncodableVector6.add(new DERTaggedObject(true, 1, new DERSequence(aSN1EncodableVector8)));
                }
                aSN1EncodableVector5.add(new DERSet(new DERSequence(aSN1EncodableVector6)));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector5));
            }
            if (cryptoStandard == MakeSignature.CryptoStandard.CADES) {
                ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                aSN1EncodableVector11.add(new ASN1ObjectIdentifier(SecurityIDs.ID_AA_SIGNING_CERTIFICATE_V2));
                ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
                aSN1EncodableVector12.add(new AlgorithmIdentifier(new ASN1ObjectIdentifier(this.digestAlgorithmOid), (ASN1Encodable) null));
                aSN1EncodableVector12.add(new DEROctetString(this.interfaceDigest.getMessageDigest(getHashAlgorithm()).digest(this.signCert.getEncoded())));
                aSN1EncodableVector11.add(new DERSet(new DERSequence(new DERSequence(new DERSequence(aSN1EncodableVector12)))));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector11));
            }
            return new DERSet(aSN1EncodableVector);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean verify() throws SignatureException {
        boolean z;
        boolean z2;
        if (this.verified) {
            return this.verifyResult;
        }
        if (this.isTsp) {
            this.verifyResult = Arrays.equals(this.messageDigest.digest(), this.timeStampToken.getTimeStampInfo().toASN1Structure().getMessageImprint().getHashedMessage());
        } else if (this.sigAttr != null) {
            byte[] digest = this.messageDigest.digest();
            this.sig.update(this.sigAttr);
            byte[] bArr = this.RSAdata;
            boolean z3 = false;
            if (bArr != null) {
                z = Arrays.equals(digest, bArr);
                this.encContDigest.update(this.RSAdata);
                z2 = Arrays.equals(this.encContDigest.digest(), this.digestAttr);
            } else {
                z = true;
                z2 = false;
            }
            boolean z4 = Arrays.equals(digest, this.digestAttr) || z2;
            boolean verify = this.sig.verify(this.digest);
            if (z4 && verify && z) {
                z3 = true;
            }
            this.verifyResult = z3;
        } else {
            if (this.RSAdata != null) {
                this.sig.update(this.messageDigest.digest());
            }
            this.verifyResult = this.sig.verify(this.digest);
        }
        this.verified = true;
        return this.verifyResult;
    }

    public boolean verifyTimestampImprint() throws GeneralSecurityException {
        TimeStampToken timeStampToken = this.timeStampToken;
        if (timeStampToken == null) {
            return false;
        }
        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
        MessageImprint messageImprint = timeStampInfo.toASN1Structure().getMessageImprint();
        return Arrays.equals(new BouncyCastleDigest().getMessageDigest(DigestAlgorithms.getDigest(timeStampInfo.getMessageImprintAlgOID().getId())).digest(this.digest), messageImprint.getHashedMessage());
    }

    public Certificate[] getCertificates() {
        Collection<Certificate> collection = this.certs;
        return (Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    public Certificate[] getSignCertificateChain() {
        Collection<Certificate> collection = this.signCerts;
        return (Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    public X509Certificate getSigningCertificate() {
        return this.signCert;
    }

    private void signCertificateChain() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.signCert);
        ArrayList arrayList2 = new ArrayList(this.certs);
        int i = 0;
        while (i < arrayList2.size()) {
            if (this.signCert.equals(arrayList2.get(i))) {
                arrayList2.remove(i);
                i--;
            }
            i++;
        }
        boolean z = true;
        while (z) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                if (i2 >= arrayList2.size()) {
                    z = z2;
                    break;
                }
                try {
                    if (this.provider == null) {
                        x509Certificate.verify(((X509Certificate) arrayList2.get(i2)).getPublicKey());
                    } else {
                        x509Certificate.verify(((X509Certificate) arrayList2.get(i2)).getPublicKey(), this.provider);
                    }
                    try {
                        arrayList.add(arrayList2.get(i2));
                        arrayList2.remove(i2);
                        z = true;
                        break;
                    } catch (Exception unused) {
                        z2 = true;
                    }
                } catch (Exception unused2) {
                }
                i2++;
            }
        }
        this.signCerts = arrayList;
    }

    public Collection<CRL> getCRLs() {
        return this.crls;
    }

    private void findCRL(ASN1Sequence aSN1Sequence) {
        try {
            this.crls = new ArrayList();
            for (int i = 0; i < aSN1Sequence.size(); i++) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(aSN1Sequence.getObjectAt(i).toASN1Primitive().getEncoded("DER"));
                this.crls.add((X509CRL) CertificateFactory.getInstance("X.509").generateCRL(byteArrayInputStream));
            }
        } catch (Exception unused) {
        }
    }

    public BasicOCSPResp getOcsp() {
        return this.basicResp;
    }

    public boolean isRevocationValid() {
        if (this.basicResp != null && this.signCerts.size() >= 2) {
            try {
                CertificateID certID = this.basicResp.getResponses()[0].getCertID();
                X509Certificate signingCertificate = getSigningCertificate();
                return new CertificateID(new JcaDigestCalculatorProviderBuilder().build().get(CertificateID.HASH_SHA1), new JcaX509CertificateHolder(((X509Certificate[]) getSignCertificateChain())[1]), signingCertificate.getSerialNumber()).equals(certID);
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    private void findOcsp(ASN1Sequence aSN1Sequence) throws IOException {
        boolean z;
        this.basicResp = null;
        do {
            z = false;
            if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).getId().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic.getId())) {
                int i = 0;
                while (true) {
                    if (i >= aSN1Sequence.size()) {
                        z = true;
                        continue;
                        break;
                    } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1Sequence) {
                        aSN1Sequence = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
                        continue;
                        break;
                    } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
                        ASN1TaggedObject objectAt = aSN1Sequence.getObjectAt(i);
                        if (objectAt.getObject() instanceof ASN1Sequence) {
                            aSN1Sequence = (ASN1Sequence) objectAt.getObject();
                            continue;
                        } else {
                            return;
                        }
                    } else {
                        i++;
                    }
                }
            } else {
                this.basicResp = new BasicOCSPResp(BasicOCSPResponse.getInstance(new ASN1InputStream(aSN1Sequence.getObjectAt(1).getOctets()).readObject()));
                return;
            }
        } while (!z);
    }

    public boolean isTsp() {
        return this.isTsp;
    }

    public TimeStampToken getTimeStampToken() {
        return this.timeStampToken;
    }

    public Calendar getTimeStampDate() {
        if (this.timeStampToken == null) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.timeStampToken.getTimeStampInfo().getGenTime());
        return gregorianCalendar;
    }
}
