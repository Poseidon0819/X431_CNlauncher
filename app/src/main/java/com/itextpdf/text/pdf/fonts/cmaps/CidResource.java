package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CJKFont;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class CidResource implements CidLocation {
    @Override // com.itextpdf.text.pdf.fonts.cmaps.CidLocation
    public PRTokeniser getLocation(String str) throws IOException {
        String concat = CJKFont.RESOURCE_PATH_CMAP.concat(String.valueOf(str));
        InputStream resourceStream = BaseFont.getResourceStream(concat);
        if (resourceStream == null) {
            throw new IOException(MessageLocalization.getComposedMessage("the.cmap.1.was.not.found", concat));
        }
        return new PRTokeniser(new RandomAccessFileOrArray(resourceStream));
    }
}
