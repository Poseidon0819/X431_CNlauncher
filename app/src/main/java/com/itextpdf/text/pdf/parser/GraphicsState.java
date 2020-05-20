package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.CMapAwareDocumentFont;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class GraphicsState {
    float characterSpacing;
    Matrix ctm;
    CMapAwareDocumentFont font;
    float fontSize;
    float horizontalScaling;
    boolean knockout;
    float leading;
    int renderMode;
    float rise;
    float wordSpacing;

    public GraphicsState() {
        this.ctm = new Matrix();
        this.characterSpacing = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.wordSpacing = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.horizontalScaling = 1.0f;
        this.leading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.font = null;
        this.fontSize = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.renderMode = 0;
        this.rise = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.knockout = true;
    }

    public GraphicsState(GraphicsState graphicsState) {
        this.ctm = graphicsState.ctm;
        this.characterSpacing = graphicsState.characterSpacing;
        this.wordSpacing = graphicsState.wordSpacing;
        this.horizontalScaling = graphicsState.horizontalScaling;
        this.leading = graphicsState.leading;
        this.font = graphicsState.font;
        this.fontSize = graphicsState.fontSize;
        this.renderMode = graphicsState.renderMode;
        this.rise = graphicsState.rise;
        this.knockout = graphicsState.knockout;
    }

    public Matrix getCtm() {
        return this.ctm;
    }

    public float getCharacterSpacing() {
        return this.characterSpacing;
    }

    public float getWordSpacing() {
        return this.wordSpacing;
    }

    public float getHorizontalScaling() {
        return this.horizontalScaling;
    }

    public float getLeading() {
        return this.leading;
    }

    public CMapAwareDocumentFont getFont() {
        return this.font;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public int getRenderMode() {
        return this.renderMode;
    }

    public float getRise() {
        return this.rise;
    }

    public boolean isKnockout() {
        return this.knockout;
    }
}
