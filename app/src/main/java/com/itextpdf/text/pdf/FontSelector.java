package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class FontSelector {
    protected ArrayList<Font> fonts = new ArrayList<>();

    public void addFont(Font font) {
        if (font.getBaseFont() != null) {
            this.fonts.add(font);
            return;
        }
        this.fonts.add(new Font(font.getCalculatedBaseFont(true), font.getSize(), font.getCalculatedStyle(), font.getColor()));
    }

    public Phrase process(String str) {
        int size = this.fonts.size();
        if (size == 0) {
            throw new IndexOutOfBoundsException(MessageLocalization.getComposedMessage("no.font.is.defined", new Object[0]));
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        Phrase phrase = new Phrase();
        int i = 0;
        int i2 = -1;
        while (i < length) {
            char c = charArray[i];
            if (c == '\n' || c == '\r') {
                stringBuffer.append(c);
            } else if (Utilities.isSurrogatePair(charArray, i)) {
                int convertToUtf32 = Utilities.convertToUtf32(charArray, i);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (this.fonts.get(i3).getBaseFont().charExists(convertToUtf32)) {
                        if (i2 != i3) {
                            if (stringBuffer.length() > 0 && i2 != -1) {
                                phrase.add((Element) new Chunk(stringBuffer.toString(), this.fonts.get(i2)));
                                stringBuffer.setLength(0);
                            }
                            i2 = i3;
                        }
                        stringBuffer.append(c);
                        i++;
                        stringBuffer.append(charArray[i]);
                    } else {
                        i3++;
                    }
                }
            } else {
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    } else if (this.fonts.get(i4).getBaseFont().charExists(c)) {
                        if (i2 != i4) {
                            if (stringBuffer.length() > 0 && i2 != -1) {
                                phrase.add((Element) new Chunk(stringBuffer.toString(), this.fonts.get(i2)));
                                stringBuffer.setLength(0);
                            }
                            i2 = i4;
                        }
                        stringBuffer.append(c);
                    } else {
                        i4++;
                    }
                }
            }
            i++;
        }
        if (stringBuffer.length() > 0) {
            phrase.add((Element) new Chunk(stringBuffer.toString(), this.fonts.get(i2 != -1 ? i2 : 0)));
        }
        return phrase;
    }
}
