package com.thoughtworks.xstream.p366io.xml;

import com.baidu.mapapi.UIMsg;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.p366io.naming.NameCoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* renamed from: com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder */
/* loaded from: classes2.dex */
public class XmlFriendlyNameCoder implements NameCoder, Cloneable {
    private static final IntPair[] XML_NAME_CHAR_EXTRA_BOUNDS;
    private static final IntPair[] XML_NAME_START_CHAR_BOUNDS;
    private final String dollarReplacement;
    private transient Map escapeCache;
    private final String escapeCharReplacement;
    private final String hexPrefix;
    private transient Map unescapeCache;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder$1IntPairList] */
    static {
        ?? r0 = new ArrayList() { // from class: com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder.1IntPairList
            void add(int i, int i2) {
                super.add((C1IntPairList) new IntPair(i, i2));
            }

            void add(char c) {
                super.add((C1IntPairList) new IntPair(c, c));
            }
        };
        r0.add(':');
        r0.add(65, 90);
        r0.add(97, Opcodes.ISHR);
        r0.add('_');
        r0.add(192, 214);
        r0.add(216, 246);
        r0.add(248, 767);
        r0.add(880, 893);
        r0.add(895, 8191);
        r0.add(8204, 8205);
        r0.add(8304, 8591);
        r0.add(11264, 12271);
        r0.add(UIMsg.k_event.MV_MAP_CACHEMANAGE, 55295);
        r0.add(63744, 64975);
        r0.add(65008, 65533);
        r0.add(65536, 983039);
        XML_NAME_START_CHAR_BOUNDS = (IntPair[]) r0.toArray(new IntPair[r0.size()]);
        r0.clear();
        r0.add(SignatureVisitor.SUPER);
        r0.add('.');
        r0.add(48, 57);
        r0.add((char) 183);
        r0.add(768, 879);
        r0.add(8255, 8256);
        XML_NAME_CHAR_EXTRA_BOUNDS = (IntPair[]) r0.toArray(new IntPair[r0.size()]);
    }

    public XmlFriendlyNameCoder() {
        this("_-", "__");
    }

    public XmlFriendlyNameCoder(String str, String str2) {
        this(str, str2, "_.");
    }

    public XmlFriendlyNameCoder(String str, String str2, String str3) {
        this.dollarReplacement = str;
        this.escapeCharReplacement = str2;
        this.hexPrefix = str3;
        readResolve();
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeAttribute(String str) {
        return decodeName(str);
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String decodeNode(String str) {
        return decodeName(str);
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String encodeAttribute(String str) {
        return encodeName(str);
    }

    @Override // com.thoughtworks.xstream.p366io.naming.NameCoder
    public String encodeNode(String str) {
        return encodeName(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String encodeName(java.lang.String r8) {
        /*
            r7 = this;
            java.util.Map r0 = r7.escapeCache
            java.lang.Object r0 = r0.get(r8)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L9b
            int r0 = r8.length()
            r1 = 0
            r2 = 0
        L10:
            r3 = 95
            r4 = 36
            if (r2 >= r0) goto L29
            char r5 = r8.charAt(r2)
            if (r5 == r4) goto L29
            if (r5 == r3) goto L29
            r6 = 27
            if (r5 <= r6) goto L29
            r6 = 127(0x7f, float:1.78E-43)
            if (r5 >= r6) goto L29
            int r2 = r2 + 1
            goto L10
        L29:
            if (r2 != r0) goto L2c
            return r8
        L2c:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            int r6 = r0 + 8
            r5.<init>(r6)
            if (r2 <= 0) goto L3c
            java.lang.String r1 = r8.substring(r1, r2)
            r5.append(r1)
        L3c:
            if (r2 >= r0) goto L92
            char r1 = r8.charAt(r2)
            if (r1 != r4) goto L4a
            java.lang.String r1 = r7.dollarReplacement
            r5.append(r1)
            goto L8f
        L4a:
            if (r1 != r3) goto L52
            java.lang.String r1 = r7.escapeCharReplacement
            r5.append(r1)
            goto L8f
        L52:
            if (r2 != 0) goto L5a
            boolean r6 = isXmlNameStartChar(r1)
            if (r6 == 0) goto L62
        L5a:
            if (r2 <= 0) goto L8c
            boolean r6 = isXmlNameChar(r1)
            if (r6 != 0) goto L8c
        L62:
            java.lang.String r6 = r7.hexPrefix
            r5.append(r6)
            r6 = 16
            if (r1 >= r6) goto L71
            java.lang.String r6 = "000"
            r5.append(r6)
            goto L84
        L71:
            r6 = 256(0x100, float:3.59E-43)
            if (r1 >= r6) goto L7b
            java.lang.String r6 = "00"
            r5.append(r6)
            goto L84
        L7b:
            r6 = 4096(0x1000, float:5.74E-42)
            if (r1 >= r6) goto L84
            java.lang.String r6 = "0"
            r5.append(r6)
        L84:
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r5.append(r1)
            goto L8f
        L8c:
            r5.append(r1)
        L8f:
            int r2 = r2 + 1
            goto L3c
        L92:
            java.lang.String r0 = r5.toString()
            java.util.Map r1 = r7.escapeCache
            r1.put(r8, r0)
        L9b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.p366io.xml.XmlFriendlyNameCoder.encodeName(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String decodeName(java.lang.String r9) {
        /*
            r8 = this;
            java.util.Map r0 = r8.unescapeCache
            java.lang.Object r0 = r0.get(r9)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto Laf
            java.lang.String r0 = r8.dollarReplacement
            r1 = 0
            char r0 = r0.charAt(r1)
            java.lang.String r2 = r8.escapeCharReplacement
            char r2 = r2.charAt(r1)
            java.lang.String r3 = r8.hexPrefix
            char r3 = r3.charAt(r1)
            int r4 = r9.length()
            r5 = 0
        L22:
            if (r5 >= r4) goto L31
            char r6 = r9.charAt(r5)
            if (r6 == r0) goto L31
            if (r6 == r2) goto L31
            if (r6 == r3) goto L31
            int r5 = r5 + 1
            goto L22
        L31:
            if (r5 != r4) goto L34
            return r9
        L34:
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            int r7 = r4 + 8
            r6.<init>(r7)
            if (r5 <= 0) goto L44
            java.lang.String r1 = r9.substring(r1, r5)
            r6.append(r1)
        L44:
            if (r5 >= r4) goto La6
            char r1 = r9.charAt(r5)
            if (r1 != r0) goto L63
            java.lang.String r7 = r8.dollarReplacement
            boolean r7 = r9.startsWith(r7, r5)
            if (r7 == 0) goto L63
            java.lang.String r1 = r8.dollarReplacement
            int r1 = r1.length()
            int r1 = r1 + (-1)
            int r5 = r5 + r1
            r1 = 36
            r6.append(r1)
            goto La3
        L63:
            if (r1 != r3) goto L87
            java.lang.String r7 = r8.hexPrefix
            boolean r7 = r9.startsWith(r7, r5)
            if (r7 == 0) goto L87
            java.lang.String r1 = r8.hexPrefix
            int r1 = r1.length()
            int r5 = r5 + r1
            int r1 = r5 + 4
            java.lang.String r1 = r9.substring(r5, r1)
            r7 = 16
            int r1 = java.lang.Integer.parseInt(r1, r7)
            char r1 = (char) r1
            int r5 = r5 + 3
            r6.append(r1)
            goto La3
        L87:
            if (r1 != r2) goto La0
            java.lang.String r7 = r8.escapeCharReplacement
            boolean r7 = r9.startsWith(r7, r5)
            if (r7 == 0) goto La0
            java.lang.String r1 = r8.escapeCharReplacement
            int r1 = r1.length()
            int r1 = r1 + (-1)
            int r5 = r5 + r1
            r1 = 95
            r6.append(r1)
            goto La3
        La0:
            r6.append(r1)
        La3:
            int r5 = r5 + 1
            goto L44
        La6:
            java.lang.String r0 = r6.toString()
            java.util.Map r1 = r8.unescapeCache
            r1.put(r9, r0)
        Laf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.p366io.xml.XmlFriendlyNameCoder.decodeName(java.lang.String):java.lang.String");
    }

    public Object clone() {
        try {
            XmlFriendlyNameCoder xmlFriendlyNameCoder = (XmlFriendlyNameCoder) super.clone();
            xmlFriendlyNameCoder.readResolve();
            return xmlFriendlyNameCoder;
        } catch (CloneNotSupportedException e) {
            throw new ObjectAccessException("Cannot clone XmlFriendlyNameCoder", e);
        }
    }

    private Object readResolve() {
        this.escapeCache = createCacheMap();
        this.unescapeCache = createCacheMap();
        return this;
    }

    protected Map createCacheMap() {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder$IntPair */
    /* loaded from: classes2.dex */
    public static class IntPair {
        int max;
        int min;

        public IntPair(int i, int i2) {
            this.min = i;
            this.max = i2;
        }
    }

    private static boolean isXmlNameStartChar(int i) {
        return isInNameCharBounds(i, XML_NAME_START_CHAR_BOUNDS);
    }

    private static boolean isXmlNameChar(int i) {
        if (isXmlNameStartChar(i)) {
            return true;
        }
        return isInNameCharBounds(i, XML_NAME_CHAR_EXTRA_BOUNDS);
    }

    private static boolean isInNameCharBounds(int i, IntPair[] intPairArr) {
        for (IntPair intPair : intPairArr) {
            if (i >= intPair.min && i <= intPair.max) {
                return true;
            }
        }
        return false;
    }
}
