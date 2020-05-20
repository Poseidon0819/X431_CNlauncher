package com.itextpdf.text.pdf.parser;

/* loaded from: classes.dex */
public abstract class RenderFilter {
    public boolean allowImage(ImageRenderInfo imageRenderInfo) {
        return true;
    }

    public boolean allowText(TextRenderInfo textRenderInfo) {
        return true;
    }
}
