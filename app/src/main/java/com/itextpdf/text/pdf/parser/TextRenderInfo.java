package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.CMapAwareDocumentFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.DocumentFont;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class TextRenderInfo {

    /* renamed from: gs */
    private final GraphicsState f19854gs;
    private final Collection<MarkedContentInfo> markedContentInfos;
    private final String text;
    private final Matrix textToUserSpaceTransformMatrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextRenderInfo(String str, GraphicsState graphicsState, Matrix matrix, Collection<MarkedContentInfo> collection) {
        this.text = str;
        this.textToUserSpaceTransformMatrix = matrix.multiply(graphicsState.ctm);
        this.f19854gs = graphicsState;
        this.markedContentInfos = new ArrayList(collection);
    }

    public String getText() {
        return this.text;
    }

    public boolean hasMcid(int i) {
        for (MarkedContentInfo markedContentInfo : this.markedContentInfos) {
            if (markedContentInfo.hasMcid() && markedContentInfo.getMcid() == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getUnscaledWidth() {
        return getStringWidth(this.text);
    }

    public LineSegment getBaseline() {
        return getUnscaledBaselineWithOffset(ColumnText.GLOBAL_SPACE_CHAR_RATIO).transformBy(this.textToUserSpaceTransformMatrix);
    }

    public LineSegment getAscentLine() {
        return getUnscaledBaselineWithOffset(this.f19854gs.getFont().getFontDescriptor(1, this.f19854gs.getFontSize())).transformBy(this.textToUserSpaceTransformMatrix);
    }

    public LineSegment getDescentLine() {
        return getUnscaledBaselineWithOffset(this.f19854gs.getFont().getFontDescriptor(3, this.f19854gs.getFontSize())).transformBy(this.textToUserSpaceTransformMatrix);
    }

    private LineSegment getUnscaledBaselineWithOffset(float f) {
        return new LineSegment(new Vector(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, 1.0f), new Vector(getUnscaledWidth(), f, 1.0f));
    }

    public DocumentFont getFont() {
        return this.f19854gs.getFont();
    }

    public float getSingleSpaceWidth() {
        return new LineSegment(new Vector(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f), new Vector(getUnscaledFontSpaceWidth(), ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f)).transformBy(this.textToUserSpaceTransformMatrix).getLength();
    }

    public int getTextRenderMode() {
        return this.f19854gs.renderMode;
    }

    private float getUnscaledFontSpaceWidth() {
        CMapAwareDocumentFont cMapAwareDocumentFont = this.f19854gs.font;
        char c = TokenParser.f24154SP;
        if (cMapAwareDocumentFont.getWidth(32) == 0) {
            c = 160;
        }
        return getStringWidth(String.valueOf(c));
    }

    private float getStringWidth(String str) {
        CMapAwareDocumentFont cMapAwareDocumentFont = this.f19854gs.font;
        char[] charArray = str.toCharArray();
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (int i = 0; i < charArray.length; i++) {
            f += (((cMapAwareDocumentFont.getWidth(charArray[i]) / 1000.0f) * this.f19854gs.fontSize) + this.f19854gs.characterSpacing + (charArray[i] == ' ' ? this.f19854gs.wordSpacing : ColumnText.GLOBAL_SPACE_CHAR_RATIO)) * this.f19854gs.horizontalScaling;
        }
        return f;
    }
}
