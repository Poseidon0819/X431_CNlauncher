package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import java.io.IOException;

/* loaded from: classes.dex */
public class MetaBrush extends MetaObject {
    public static final int BS_DIBPATTERN = 5;
    public static final int BS_HATCHED = 2;
    public static final int BS_NULL = 1;
    public static final int BS_PATTERN = 3;
    public static final int BS_SOLID = 0;
    public static final int HS_BDIAGONAL = 3;
    public static final int HS_CROSS = 4;
    public static final int HS_DIAGCROSS = 5;
    public static final int HS_FDIAGONAL = 2;
    public static final int HS_HORIZONTAL = 0;
    public static final int HS_VERTICAL = 1;
    int hatch;
    int style = 0;
    BaseColor color = BaseColor.WHITE;

    public MetaBrush() {
        this.type = 2;
    }

    public void init(InputMeta inputMeta) throws IOException {
        this.style = inputMeta.readWord();
        this.color = inputMeta.readColor();
        this.hatch = inputMeta.readWord();
    }

    public int getStyle() {
        return this.style;
    }

    public int getHatch() {
        return this.hatch;
    }

    public BaseColor getColor() {
        return this.color;
    }
}
