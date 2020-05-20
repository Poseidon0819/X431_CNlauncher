package com.thoughtworks.xstream.persistence;

import com.thoughtworks.xstream.XStream;
import java.io.File;

/* loaded from: classes2.dex */
public class FileStreamStrategy extends AbstractFilePersistenceStrategy implements StreamStrategy {
    public FileStreamStrategy(File file) {
        this(file, new XStream());
    }

    public FileStreamStrategy(File file, XStream xStream) {
        super(file, xStream, null);
    }

    @Override // com.thoughtworks.xstream.persistence.AbstractFilePersistenceStrategy
    protected Object extractKey(String str) {
        String unescape = unescape(str.substring(0, str.length() - 4));
        if (unescape.equals("\u0000")) {
            return null;
        }
        return unescape;
    }

    protected String unescape(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = -1;
        char c = 65535;
        while (i < charArray.length) {
            char c2 = charArray[i];
            if (c2 == '_' && i2 != -1) {
                if (c == '_') {
                    stringBuffer.append('_');
                } else {
                    stringBuffer.append((char) i2);
                }
                i2 = -1;
            } else if (c2 == '_') {
                i2 = 0;
            } else if (i2 != -1) {
                i2 = (i2 * 16) + Integer.parseInt(String.valueOf(c2), 16);
            } else {
                stringBuffer.append(c2);
            }
            i++;
            c = c2;
        }
        return stringBuffer.toString();
    }

    @Override // com.thoughtworks.xstream.persistence.AbstractFilePersistenceStrategy
    protected String getName(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(escape(obj == null ? "\u0000" : obj.toString()));
        sb.append(".xml");
        return sb.toString();
    }

    protected String escape(String str) {
        char[] charArray;
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) || ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                stringBuffer.append(c);
            } else if (c == '_') {
                stringBuffer.append("__");
            } else {
                stringBuffer.append("_" + Integer.toHexString(c) + "_");
            }
        }
        return stringBuffer.toString();
    }
}
