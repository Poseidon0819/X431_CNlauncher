package com.itextpdf.text.pdf.parser;

/* loaded from: classes.dex */
public interface RenderListener {
    void beginTextBlock();

    void endTextBlock();

    void renderImage(ImageRenderInfo imageRenderInfo);

    void renderText(TextRenderInfo textRenderInfo);
}
