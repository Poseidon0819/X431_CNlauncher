package com.thoughtworks.xstream.mapper;

import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes2.dex */
public class AbstractXmlFriendlyMapper extends MapperWrapper {
    private char dollarReplacementInClass;
    private String dollarReplacementInField;
    private String noPackagePrefix;
    private String underscoreReplacementInField;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractXmlFriendlyMapper(Mapper mapper) {
        super(mapper);
        this.dollarReplacementInClass = SignatureVisitor.SUPER;
        this.dollarReplacementInField = "_DOLLAR_";
        this.underscoreReplacementInField = "__";
        this.noPackagePrefix = "default";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String escapeClassName(String str) {
        String replace = str.replace('$', this.dollarReplacementInClass);
        if (replace.charAt(0) == this.dollarReplacementInClass) {
            return this.noPackagePrefix + replace;
        }
        return replace;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String unescapeClassName(String str) {
        if (str.startsWith(this.noPackagePrefix + this.dollarReplacementInClass)) {
            str = str.substring(this.noPackagePrefix.length());
        }
        return str.replace(this.dollarReplacementInClass, '$');
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String escapeFieldName(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '$') {
                stringBuffer.append(this.dollarReplacementInField);
            } else if (charAt == '_') {
                stringBuffer.append(this.underscoreReplacementInField);
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String unescapeFieldName(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (stringFoundAt(str, i, this.underscoreReplacementInField)) {
                i += this.underscoreReplacementInField.length() - 1;
                stringBuffer.append('_');
            } else if (stringFoundAt(str, i, this.dollarReplacementInField)) {
                i += this.dollarReplacementInField.length() - 1;
                stringBuffer.append('$');
            } else {
                stringBuffer.append(charAt);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private boolean stringFoundAt(String str, int i, String str2) {
        return str.length() >= str2.length() + i && str.substring(i, str2.length() + i).equals(str2);
    }
}
