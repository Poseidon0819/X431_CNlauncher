package com.itextpdf.text;

import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Rectangle implements Element {
    public static final int BOTTOM = 2;
    public static final int BOX = 15;
    public static final int LEFT = 4;
    public static final int NO_BORDER = 0;
    public static final int RIGHT = 8;
    public static final int TOP = 1;
    public static final int UNDEFINED = -1;
    protected BaseColor backgroundColor;
    protected int border;
    protected BaseColor borderColor;
    protected BaseColor borderColorBottom;
    protected BaseColor borderColorLeft;
    protected BaseColor borderColorRight;
    protected BaseColor borderColorTop;
    protected float borderWidth;
    protected float borderWidthBottom;
    protected float borderWidthLeft;
    protected float borderWidthRight;
    protected float borderWidthTop;
    protected float llx;
    protected float lly;
    protected int rotation;
    protected float urx;
    protected float ury;
    protected boolean useVariableBorders;

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 30;
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this.rotation = 0;
        this.backgroundColor = null;
        this.border = -1;
        this.useVariableBorders = false;
        this.borderWidth = -1.0f;
        this.borderWidthLeft = -1.0f;
        this.borderWidthRight = -1.0f;
        this.borderWidthTop = -1.0f;
        this.borderWidthBottom = -1.0f;
        this.borderColor = null;
        this.borderColorLeft = null;
        this.borderColorRight = null;
        this.borderColorTop = null;
        this.borderColorBottom = null;
        this.llx = f;
        this.lly = f2;
        this.urx = f3;
        this.ury = f4;
    }

    public Rectangle(float f, float f2, float f3, float f4, int i) {
        this(f, f2, f3, f4);
        setRotation(i);
    }

    public Rectangle(float f, float f2) {
        this(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2);
    }

    public Rectangle(float f, float f2, int i) {
        this(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2, i);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.llx, rectangle.lly, rectangle.urx, rectangle.ury);
        cloneNonPositionParameters(rectangle);
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.text.Element
    public java.util.List<Chunk> getChunks() {
        return new ArrayList();
    }

    public void setLeft(float f) {
        this.llx = f;
    }

    public float getLeft() {
        return this.llx;
    }

    public float getLeft(float f) {
        return this.llx + f;
    }

    public void setRight(float f) {
        this.urx = f;
    }

    public float getRight() {
        return this.urx;
    }

    public float getRight(float f) {
        return this.urx - f;
    }

    public float getWidth() {
        return this.urx - this.llx;
    }

    public void setTop(float f) {
        this.ury = f;
    }

    public float getTop() {
        return this.ury;
    }

    public float getTop(float f) {
        return this.ury - f;
    }

    public void setBottom(float f) {
        this.lly = f;
    }

    public float getBottom() {
        return this.lly;
    }

    public float getBottom(float f) {
        return this.lly + f;
    }

    public float getHeight() {
        return this.ury - this.lly;
    }

    public void normalize() {
        float f = this.llx;
        float f2 = this.urx;
        if (f > f2) {
            this.llx = f2;
            this.urx = f;
        }
        float f3 = this.lly;
        float f4 = this.ury;
        if (f3 > f4) {
            this.lly = f4;
            this.ury = f3;
        }
    }

    public int getRotation() {
        return this.rotation;
    }

    public void setRotation(int i) {
        this.rotation = i % 360;
        int i2 = this.rotation;
        if (i2 == 90 || i2 == 180 || i2 == 270) {
            return;
        }
        this.rotation = 0;
    }

    public Rectangle rotate() {
        Rectangle rectangle = new Rectangle(this.lly, this.llx, this.ury, this.urx);
        rectangle.setRotation(this.rotation + 90);
        return rectangle;
    }

    public BaseColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(BaseColor baseColor) {
        this.backgroundColor = baseColor;
    }

    public float getGrayFill() {
        BaseColor baseColor = this.backgroundColor;
        return baseColor instanceof GrayColor ? ((GrayColor) baseColor).getGray() : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public void setGrayFill(float f) {
        this.backgroundColor = new GrayColor(f);
    }

    public int getBorder() {
        return this.border;
    }

    public boolean hasBorders() {
        switch (this.border) {
            case -1:
            case 0:
                return false;
            default:
                return this.borderWidth > ColumnText.GLOBAL_SPACE_CHAR_RATIO || this.borderWidthLeft > ColumnText.GLOBAL_SPACE_CHAR_RATIO || this.borderWidthRight > ColumnText.GLOBAL_SPACE_CHAR_RATIO || this.borderWidthTop > ColumnText.GLOBAL_SPACE_CHAR_RATIO || this.borderWidthBottom > ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
    }

    public boolean hasBorder(int i) {
        int i2 = this.border;
        return i2 != -1 && (i2 & i) == i;
    }

    public void setBorder(int i) {
        this.border = i;
    }

    public boolean isUseVariableBorders() {
        return this.useVariableBorders;
    }

    public void setUseVariableBorders(boolean z) {
        this.useVariableBorders = z;
    }

    public void enableBorderSide(int i) {
        if (this.border == -1) {
            this.border = 0;
        }
        this.border = i | this.border;
    }

    public void disableBorderSide(int i) {
        if (this.border == -1) {
            this.border = 0;
        }
        this.border = (i ^ (-1)) & this.border;
    }

    public float getBorderWidth() {
        return this.borderWidth;
    }

    public void setBorderWidth(float f) {
        this.borderWidth = f;
    }

    private float getVariableBorderWidth(float f, int i) {
        return (i & this.border) != 0 ? f != -1.0f ? f : this.borderWidth : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    private void updateBorderBasedOnWidth(float f, int i) {
        this.useVariableBorders = true;
        if (f > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            enableBorderSide(i);
        } else {
            disableBorderSide(i);
        }
    }

    public float getBorderWidthLeft() {
        return getVariableBorderWidth(this.borderWidthLeft, 4);
    }

    public void setBorderWidthLeft(float f) {
        this.borderWidthLeft = f;
        updateBorderBasedOnWidth(f, 4);
    }

    public float getBorderWidthRight() {
        return getVariableBorderWidth(this.borderWidthRight, 8);
    }

    public void setBorderWidthRight(float f) {
        this.borderWidthRight = f;
        updateBorderBasedOnWidth(f, 8);
    }

    public float getBorderWidthTop() {
        return getVariableBorderWidth(this.borderWidthTop, 1);
    }

    public void setBorderWidthTop(float f) {
        this.borderWidthTop = f;
        updateBorderBasedOnWidth(f, 1);
    }

    public float getBorderWidthBottom() {
        return getVariableBorderWidth(this.borderWidthBottom, 2);
    }

    public void setBorderWidthBottom(float f) {
        this.borderWidthBottom = f;
        updateBorderBasedOnWidth(f, 2);
    }

    public BaseColor getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(BaseColor baseColor) {
        this.borderColor = baseColor;
    }

    public BaseColor getBorderColorLeft() {
        BaseColor baseColor = this.borderColorLeft;
        return baseColor == null ? this.borderColor : baseColor;
    }

    public void setBorderColorLeft(BaseColor baseColor) {
        this.borderColorLeft = baseColor;
    }

    public BaseColor getBorderColorRight() {
        BaseColor baseColor = this.borderColorRight;
        return baseColor == null ? this.borderColor : baseColor;
    }

    public void setBorderColorRight(BaseColor baseColor) {
        this.borderColorRight = baseColor;
    }

    public BaseColor getBorderColorTop() {
        BaseColor baseColor = this.borderColorTop;
        return baseColor == null ? this.borderColor : baseColor;
    }

    public void setBorderColorTop(BaseColor baseColor) {
        this.borderColorTop = baseColor;
    }

    public BaseColor getBorderColorBottom() {
        BaseColor baseColor = this.borderColorBottom;
        return baseColor == null ? this.borderColor : baseColor;
    }

    public void setBorderColorBottom(BaseColor baseColor) {
        this.borderColorBottom = baseColor;
    }

    public Rectangle rectangle(float f, float f2) {
        Rectangle rectangle = new Rectangle(this);
        if (getTop() > f) {
            rectangle.setTop(f);
            rectangle.disableBorderSide(1);
        }
        if (getBottom() < f2) {
            rectangle.setBottom(f2);
            rectangle.disableBorderSide(2);
        }
        return rectangle;
    }

    public void cloneNonPositionParameters(Rectangle rectangle) {
        this.rotation = rectangle.rotation;
        this.backgroundColor = rectangle.backgroundColor;
        this.border = rectangle.border;
        this.useVariableBorders = rectangle.useVariableBorders;
        this.borderWidth = rectangle.borderWidth;
        this.borderWidthLeft = rectangle.borderWidthLeft;
        this.borderWidthRight = rectangle.borderWidthRight;
        this.borderWidthTop = rectangle.borderWidthTop;
        this.borderWidthBottom = rectangle.borderWidthBottom;
        this.borderColor = rectangle.borderColor;
        this.borderColorLeft = rectangle.borderColorLeft;
        this.borderColorRight = rectangle.borderColorRight;
        this.borderColorTop = rectangle.borderColorTop;
        this.borderColorBottom = rectangle.borderColorBottom;
    }

    public void softCloneNonPositionParameters(Rectangle rectangle) {
        int i = rectangle.rotation;
        if (i != 0) {
            this.rotation = i;
        }
        BaseColor baseColor = rectangle.backgroundColor;
        if (baseColor != null) {
            this.backgroundColor = baseColor;
        }
        int i2 = rectangle.border;
        if (i2 != -1) {
            this.border = i2;
        }
        if (this.useVariableBorders) {
            this.useVariableBorders = rectangle.useVariableBorders;
        }
        float f = rectangle.borderWidth;
        if (f != -1.0f) {
            this.borderWidth = f;
        }
        float f2 = rectangle.borderWidthLeft;
        if (f2 != -1.0f) {
            this.borderWidthLeft = f2;
        }
        float f3 = rectangle.borderWidthRight;
        if (f3 != -1.0f) {
            this.borderWidthRight = f3;
        }
        float f4 = rectangle.borderWidthTop;
        if (f4 != -1.0f) {
            this.borderWidthTop = f4;
        }
        float f5 = rectangle.borderWidthBottom;
        if (f5 != -1.0f) {
            this.borderWidthBottom = f5;
        }
        BaseColor baseColor2 = rectangle.borderColor;
        if (baseColor2 != null) {
            this.borderColor = baseColor2;
        }
        BaseColor baseColor3 = rectangle.borderColorLeft;
        if (baseColor3 != null) {
            this.borderColorLeft = baseColor3;
        }
        BaseColor baseColor4 = rectangle.borderColorRight;
        if (baseColor4 != null) {
            this.borderColorRight = baseColor4;
        }
        BaseColor baseColor5 = rectangle.borderColorTop;
        if (baseColor5 != null) {
            this.borderColorTop = baseColor5;
        }
        BaseColor baseColor6 = rectangle.borderColorBottom;
        if (baseColor6 != null) {
            this.borderColorBottom = baseColor6;
        }
    }

    @Override // com.itextpdf.text.Element
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Rectangle: ");
        stringBuffer.append(getWidth());
        stringBuffer.append('x');
        stringBuffer.append(getHeight());
        stringBuffer.append(" (rot: ");
        stringBuffer.append(this.rotation);
        stringBuffer.append(" degrees)");
        return stringBuffer.toString();
    }
}
