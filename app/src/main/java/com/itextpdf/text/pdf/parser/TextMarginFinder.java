package com.itextpdf.text.pdf.parser;

import com.itextpdf.p349a.p350a.Rectangle2D;

/* loaded from: classes.dex */
public class TextMarginFinder implements RenderListener {
    private Rectangle2D.C3609b textRectangle = null;

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderText(TextRenderInfo textRenderInfo) {
        Rectangle2D.C3609b c3609b = this.textRectangle;
        if (c3609b == null) {
            this.textRectangle = textRenderInfo.getDescentLine().getBoundingRectange();
        } else {
            c3609b.add(textRenderInfo.getDescentLine().getBoundingRectange());
        }
        this.textRectangle.add(textRenderInfo.getAscentLine().getBoundingRectange());
    }

    public float getLlx() {
        return this.textRectangle.f19537a;
    }

    public float getLly() {
        return this.textRectangle.f19538b;
    }

    public float getUrx() {
        return this.textRectangle.f19537a + this.textRectangle.f19539c;
    }

    public float getUry() {
        return this.textRectangle.f19538b + this.textRectangle.f19540d;
    }

    public float getWidth() {
        return this.textRectangle.f19539c;
    }

    public float getHeight() {
        return this.textRectangle.f19540d;
    }
}
