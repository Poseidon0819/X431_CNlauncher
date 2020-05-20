package com.itextpdf.text.pdf;

import com.itextpdf.text.SplitCharacter;

/* loaded from: classes.dex */
public class DefaultSplitCharacter implements SplitCharacter {
    public static final SplitCharacter DEFAULT = new DefaultSplitCharacter();

    @Override // com.itextpdf.text.SplitCharacter
    public boolean isSplitCharacter(int i, int i2, int i3, char[] cArr, PdfChunk[] pdfChunkArr) {
        char currentCharacter = getCurrentCharacter(i2, cArr, pdfChunkArr);
        if (currentCharacter <= ' ' || currentCharacter == '-' || currentCharacter == 8208) {
            return true;
        }
        if (currentCharacter < 8194) {
            return false;
        }
        return (currentCharacter >= 8194 && currentCharacter <= 8203) || (currentCharacter >= 11904 && currentCharacter < 55200) || ((currentCharacter >= 63744 && currentCharacter < 64256) || ((currentCharacter >= 65072 && currentCharacter < 65104) || (currentCharacter >= 65377 && currentCharacter < 65440)));
    }

    protected char getCurrentCharacter(int i, char[] cArr, PdfChunk[] pdfChunkArr) {
        if (pdfChunkArr == null) {
            return cArr[i];
        }
        return (char) pdfChunkArr[Math.min(i, pdfChunkArr.length - 1)].getUnicodeEquivalent(cArr[i]);
    }
}
