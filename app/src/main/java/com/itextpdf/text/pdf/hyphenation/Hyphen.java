package com.itextpdf.text.pdf.hyphenation;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Hyphen implements Serializable {
    private static final long serialVersionUID = -7666138517324763063L;
    public String noBreak;
    public String postBreak;
    public String preBreak;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hyphen(String str, String str2, String str3) {
        this.preBreak = str;
        this.noBreak = str2;
        this.postBreak = str3;
    }

    Hyphen(String str) {
        this.preBreak = str;
        this.noBreak = null;
        this.postBreak = null;
    }

    public String toString() {
        String str;
        if (this.noBreak == null && this.postBreak == null && (str = this.preBreak) != null && str.equals("-")) {
            return "-";
        }
        StringBuffer stringBuffer = new StringBuffer("{");
        stringBuffer.append(this.preBreak);
        stringBuffer.append("}{");
        stringBuffer.append(this.postBreak);
        stringBuffer.append("}{");
        stringBuffer.append(this.noBreak);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
