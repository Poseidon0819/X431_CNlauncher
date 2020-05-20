package com.itextpdf.text.pdf.hyphenation;

import org.codehaus.jackson.org.objectweb.asm.signature.SignatureVisitor;

/* loaded from: classes.dex */
public class Hyphenation {
    private int[] hyphenPoints;
    private int len;
    private String word;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hyphenation(String str, int[] iArr) {
        this.word = str;
        this.hyphenPoints = iArr;
        this.len = iArr.length;
    }

    public int length() {
        return this.len;
    }

    public String getPreHyphenText(int i) {
        return this.word.substring(0, this.hyphenPoints[i]);
    }

    public String getPostHyphenText(int i) {
        return this.word.substring(this.hyphenPoints[i]);
    }

    public int[] getHyphenationPoints() {
        return this.hyphenPoints;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (int i2 = 0; i2 < this.len; i2++) {
            stringBuffer.append(this.word.substring(i, this.hyphenPoints[i2]));
            stringBuffer.append(SignatureVisitor.SUPER);
            i = this.hyphenPoints[i2];
        }
        stringBuffer.append(this.word.substring(i));
        return stringBuffer.toString();
    }
}
