package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class RectangleReadOnly extends Rectangle {
    public RectangleReadOnly(float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
    }

    public RectangleReadOnly(float f, float f2, float f3, float f4, int i) {
        super(f, f2, f3, f4);
        super.setRotation(i);
    }

    public RectangleReadOnly(float f, float f2) {
        super(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2);
    }

    public RectangleReadOnly(float f, float f2, int i) {
        super(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2);
        super.setRotation(i);
    }

    public RectangleReadOnly(Rectangle rectangle) {
        super(rectangle.llx, rectangle.lly, rectangle.urx, rectangle.ury);
        super.cloneNonPositionParameters(rectangle);
    }

    private void throwReadOnlyError() {
        throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("rectanglereadonly.this.rectangle.is.read.only", new Object[0]));
    }

    @Override // com.itextpdf.text.Rectangle
    public void setRotation(int i) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setLeft(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setRight(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setTop(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBottom(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void normalize() {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBackgroundColor(BaseColor baseColor) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setGrayFill(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorder(int i) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setUseVariableBorders(boolean z) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void enableBorderSide(int i) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void disableBorderSide(int i) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderWidth(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderWidthLeft(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderWidthRight(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderWidthTop(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderWidthBottom(float f) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderColor(BaseColor baseColor) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderColorLeft(BaseColor baseColor) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderColorRight(BaseColor baseColor) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderColorTop(BaseColor baseColor) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void setBorderColorBottom(BaseColor baseColor) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void cloneNonPositionParameters(Rectangle rectangle) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle
    public void softCloneNonPositionParameters(Rectangle rectangle) {
        throwReadOnlyError();
    }

    @Override // com.itextpdf.text.Rectangle, com.itextpdf.text.Element
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RectangleReadOnly: ");
        stringBuffer.append(getWidth());
        stringBuffer.append('x');
        stringBuffer.append(getHeight());
        stringBuffer.append(" (rot: ");
        stringBuffer.append(this.rotation);
        stringBuffer.append(" degrees)");
        return stringBuffer.toString();
    }
}
