package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import java.io.IOException;

/* loaded from: classes.dex */
public class MetaPen extends MetaObject {
    public static final int PS_DASH = 1;
    public static final int PS_DASHDOT = 3;
    public static final int PS_DASHDOTDOT = 4;
    public static final int PS_DOT = 2;
    public static final int PS_INSIDEFRAME = 6;
    public static final int PS_NULL = 5;
    public static final int PS_SOLID = 0;
    int style = 0;
    int penWidth = 1;
    BaseColor color = BaseColor.BLACK;

    public MetaPen() {
        this.type = 1;
    }

    public void init(InputMeta inputMeta) throws IOException {
        this.style = inputMeta.readWord();
        this.penWidth = inputMeta.readShort();
        inputMeta.readWord();
        this.color = inputMeta.readColor();
    }

    public int getStyle() {
        return this.style;
    }

    public int getPenWidth() {
        return this.penWidth;
    }

    public BaseColor getColor() {
        return this.color;
    }
}
