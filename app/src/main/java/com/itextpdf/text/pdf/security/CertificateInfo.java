package com.itextpdf.text.pdf.security;

import com.cnlaunch.p135g.p136a.LocationInfo;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;

/* loaded from: classes.dex */
public class CertificateInfo {

    /* loaded from: classes.dex */
    public static class X500Name {

        /* renamed from: DC */
        public static final ASN1ObjectIdentifier f19864DC;
        public static final Map<ASN1ObjectIdentifier, String> DefaultSymbols;

        /* renamed from: E */
        public static final ASN1ObjectIdentifier f19865E;
        public static final ASN1ObjectIdentifier EmailAddress;
        public static final ASN1ObjectIdentifier UID;
        public Map<String, ArrayList<String>> values = new HashMap();

        /* renamed from: C */
        public static final ASN1ObjectIdentifier f19862C = new ASN1ObjectIdentifier("2.5.4.6");

        /* renamed from: O */
        public static final ASN1ObjectIdentifier f19867O = new ASN1ObjectIdentifier("2.5.4.10");

        /* renamed from: OU */
        public static final ASN1ObjectIdentifier f19868OU = new ASN1ObjectIdentifier("2.5.4.11");

        /* renamed from: T */
        public static final ASN1ObjectIdentifier f19871T = new ASN1ObjectIdentifier("2.5.4.12");

        /* renamed from: CN */
        public static final ASN1ObjectIdentifier f19863CN = new ASN1ObjectIdentifier("2.5.4.3");

        /* renamed from: SN */
        public static final ASN1ObjectIdentifier f19869SN = new ASN1ObjectIdentifier("2.5.4.5");

        /* renamed from: L */
        public static final ASN1ObjectIdentifier f19866L = new ASN1ObjectIdentifier("2.5.4.7");

        /* renamed from: ST */
        public static final ASN1ObjectIdentifier f19870ST = new ASN1ObjectIdentifier("2.5.4.8");
        public static final ASN1ObjectIdentifier SURNAME = new ASN1ObjectIdentifier("2.5.4.4");
        public static final ASN1ObjectIdentifier GIVENNAME = new ASN1ObjectIdentifier("2.5.4.42");
        public static final ASN1ObjectIdentifier INITIALS = new ASN1ObjectIdentifier("2.5.4.43");
        public static final ASN1ObjectIdentifier GENERATION = new ASN1ObjectIdentifier("2.5.4.44");
        public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER = new ASN1ObjectIdentifier("2.5.4.45");

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.840.113549.1.9.1");
            EmailAddress = aSN1ObjectIdentifier;
            f19865E = aSN1ObjectIdentifier;
            f19864DC = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
            UID = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
            HashMap hashMap = new HashMap();
            DefaultSymbols = hashMap;
            hashMap.put(f19862C, "C");
            DefaultSymbols.put(f19867O, "O");
            DefaultSymbols.put(f19871T, "T");
            DefaultSymbols.put(f19868OU, "OU");
            DefaultSymbols.put(f19863CN, "CN");
            DefaultSymbols.put(f19866L, "L");
            DefaultSymbols.put(f19870ST, LocationInfo.LOCATION_TYPE_ST);
            DefaultSymbols.put(f19869SN, "SN");
            DefaultSymbols.put(EmailAddress, "E");
            DefaultSymbols.put(f19864DC, "DC");
            DefaultSymbols.put(UID, "UID");
            DefaultSymbols.put(SURNAME, "SURNAME");
            DefaultSymbols.put(GIVENNAME, "GIVENNAME");
            DefaultSymbols.put(INITIALS, "INITIALS");
            DefaultSymbols.put(GENERATION, "GENERATION");
        }

        public X500Name(ASN1Sequence aSN1Sequence) {
            Enumeration objects = aSN1Sequence.getObjects();
            while (objects.hasMoreElements()) {
                ASN1Set aSN1Set = (ASN1Set) objects.nextElement();
                for (int i = 0; i < aSN1Set.size(); i++) {
                    ASN1Sequence objectAt = aSN1Set.getObjectAt(i);
                    String str = DefaultSymbols.get(objectAt.getObjectAt(0));
                    if (str != null) {
                        ArrayList<String> arrayList = this.values.get(str);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            this.values.put(str, arrayList);
                        }
                        arrayList.add(objectAt.getObjectAt(1).getString());
                    }
                }
            }
        }

        public X500Name(String str) {
            X509NameTokenizer x509NameTokenizer = new X509NameTokenizer(str);
            while (x509NameTokenizer.hasMoreTokens()) {
                String nextToken = x509NameTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf == -1) {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("badly.formated.directory.string", new Object[0]));
                }
                String upperCase = nextToken.substring(0, indexOf).toUpperCase();
                String substring = nextToken.substring(indexOf + 1);
                ArrayList<String> arrayList = this.values.get(upperCase);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.values.put(upperCase, arrayList);
                }
                arrayList.add(substring);
            }
        }

        public String getField(String str) {
            ArrayList<String> arrayList = this.values.get(str);
            if (arrayList == null) {
                return null;
            }
            return arrayList.get(0);
        }

        public List<String> getFieldArray(String str) {
            return this.values.get(str);
        }

        public Map<String, ArrayList<String>> getFields() {
            return this.values;
        }

        public String toString() {
            return this.values.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class X509NameTokenizer {
        private StringBuffer buf = new StringBuffer();
        private int index = -1;
        private String oid;

        public X509NameTokenizer(String str) {
            this.oid = str;
        }

        public boolean hasMoreTokens() {
            return this.index != this.oid.length();
        }

        public String nextToken() {
            if (this.index == this.oid.length()) {
                return null;
            }
            int i = this.index + 1;
            this.buf.setLength(0);
            boolean z = false;
            boolean z2 = false;
            while (i != this.oid.length()) {
                char charAt = this.oid.charAt(i);
                if (charAt != '\"') {
                    if (!z && !z2) {
                        if (charAt != '\\') {
                            if (charAt == ',') {
                                break;
                            }
                            this.buf.append(charAt);
                        } else {
                            z = true;
                        }
                    } else {
                        this.buf.append(charAt);
                        z = false;
                    }
                } else {
                    if (z) {
                        this.buf.append(charAt);
                    } else {
                        z2 = !z2;
                    }
                    z = false;
                }
                i++;
            }
            this.index = i;
            return this.buf.toString().trim();
        }
    }

    public static X500Name getIssuerFields(X509Certificate x509Certificate) {
        try {
            return new X500Name(getIssuer(x509Certificate.getTBSCertificate()));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static ASN1Primitive getIssuer(byte[] bArr) {
        try {
            ASN1Sequence readObject = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject();
            return readObject.getObjectAt(readObject.getObjectAt(0) instanceof ASN1TaggedObject ? 3 : 2);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static X500Name getSubjectFields(X509Certificate x509Certificate) {
        try {
            return new X500Name(getSubject(x509Certificate.getTBSCertificate()));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static ASN1Primitive getSubject(byte[] bArr) {
        try {
            ASN1Sequence readObject = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject();
            return readObject.getObjectAt(readObject.getObjectAt(0) instanceof ASN1TaggedObject ? 5 : 4);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }
}
