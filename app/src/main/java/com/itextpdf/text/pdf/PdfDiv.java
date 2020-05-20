package com.itextpdf.text.pdf;

import com.itextpdf.p349a.p350a.AffineTransform;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.api.Spaceable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PdfDiv implements Element, Spaceable {
    protected float spacingAfter;
    protected float spacingBefore;
    private Float left = null;
    private Float top = null;
    private Float right = null;
    private Float bottom = null;
    private Float width = null;
    private Float height = null;
    private Float percentageHeight = null;
    private Float percentageWidth = null;
    private float contentWidth = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private float contentHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private int textAlignment = -1;
    private float paddingLeft = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private float paddingRight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private float paddingTop = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private float paddingBottom = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    private FloatType floatType = FloatType.NONE;
    private PositionType position = PositionType.STATIC;
    private FloatLayout floatLayout = null;
    private BaseColor backgroundColor = null;
    private ArrayList<Element> content = new ArrayList<>();

    /* loaded from: classes.dex */
    public enum FloatType {
        NONE,
        LEFT,
        RIGHT
    }

    /* loaded from: classes.dex */
    public enum PositionType {
        STATIC,
        ABSOLUTE,
        FIXED,
        RELATIVE
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return true;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 37;
    }

    public float getContentWidth() {
        return this.contentWidth;
    }

    public void setContentWidth(float f) {
        this.contentWidth = f;
    }

    public float getContentHeight() {
        return this.contentHeight;
    }

    public void setContentHeight(float f) {
        this.contentHeight = f;
    }

    public float getActualHeight() {
        Float f = this.height;
        return (f == null || f.floatValue() < this.contentHeight) ? this.contentHeight : this.height.floatValue();
    }

    public float getActualWidth() {
        Float f = this.width;
        return (f == null || f.floatValue() < this.contentWidth) ? this.contentWidth : this.width.floatValue();
    }

    public Float getPercentageHeight() {
        return this.percentageHeight;
    }

    public void setPercentageHeight(Float f) {
        this.percentageHeight = f;
    }

    public Float getPercentageWidth() {
        return this.percentageWidth;
    }

    public void setPercentageWidth(Float f) {
        this.percentageWidth = f;
    }

    public BaseColor getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(BaseColor baseColor) {
        this.backgroundColor = baseColor;
    }

    @Override // com.itextpdf.text.Element
    public List<Chunk> getChunks() {
        return new ArrayList();
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    public int getTextAlignment() {
        return this.textAlignment;
    }

    public void setTextAlignment(int i) {
        this.textAlignment = i;
    }

    public void addElement(Element element) {
        this.content.add(element);
    }

    public Float getLeft() {
        return this.left;
    }

    public void setLeft(Float f) {
        this.left = f;
    }

    public Float getRight() {
        return this.right;
    }

    public void setRight(Float f) {
        this.right = f;
    }

    public Float getTop() {
        return this.top;
    }

    public void setTop(Float f) {
        this.top = f;
    }

    public Float getBottom() {
        return this.bottom;
    }

    public void setBottom(Float f) {
        this.bottom = f;
    }

    public Float getWidth() {
        return this.width;
    }

    public void setWidth(Float f) {
        this.width = f;
    }

    public Float getHeight() {
        return this.height;
    }

    public void setHeight(Float f) {
        this.height = f;
    }

    public float getPaddingLeft() {
        return this.paddingLeft;
    }

    public void setPaddingLeft(float f) {
        this.paddingLeft = f;
    }

    public float getPaddingRight() {
        return this.paddingRight;
    }

    public void setPaddingRight(float f) {
        this.paddingRight = f;
    }

    public float getPaddingTop() {
        return this.paddingTop;
    }

    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }

    public float getPaddingBottom() {
        return this.paddingBottom;
    }

    public void setPaddingBottom(float f) {
        this.paddingBottom = f;
    }

    public FloatType getFloatType() {
        return this.floatType;
    }

    public void setFloatType(FloatType floatType) {
        this.floatType = floatType;
    }

    public PositionType getPosition() {
        return this.position;
    }

    public void setPosition(PositionType positionType) {
        this.position = positionType;
    }

    public ArrayList<Element> getContent() {
        return this.content;
    }

    public void setContent(ArrayList<Element> arrayList) {
        this.content = arrayList;
    }

    public int layout(ColumnText columnText, boolean z, float f, float f2, float f3, float f4) throws DocumentException {
        int i;
        FloatLayout floatLayout;
        Float f5;
        float min = Math.min(f, f3);
        float max = Math.max(f2, f4);
        float min2 = Math.min(f2, f4);
        float max2 = Math.max(f, f3);
        Float f6 = this.width;
        if (f6 != null && f6.floatValue() > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            float f7 = max2 - min;
            if (this.width.floatValue() < f7) {
                max2 = this.width.floatValue() + min;
            } else if (this.width.floatValue() > f7) {
                return 2;
            }
        } else {
            Float f8 = this.percentageWidth;
            if (f8 != null) {
                this.contentWidth = (max2 - min) * f8.floatValue();
                max2 = this.contentWidth + min;
            }
        }
        Float f9 = this.height;
        if (f9 != null && f9.floatValue() > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            float f10 = max - min2;
            if (this.height.floatValue() < f10) {
                min2 = max - this.height.floatValue();
                r11 = true;
            } else if (this.height.floatValue() > f10) {
                return 2;
            }
        } else {
            Float f11 = this.percentageHeight;
            if (f11 != null) {
                r11 = ((double) f11.floatValue()) < 1.0d;
                this.contentHeight = (max - min2) * this.percentageHeight.floatValue();
                min2 = max - this.contentHeight;
            }
        }
        if (!z && this.position == PositionType.RELATIVE) {
            Float f12 = this.left;
            if (f12 == null) {
                Float f13 = this.right;
                if (f13 != null) {
                    f12 = Float.valueOf(-f13.floatValue());
                } else {
                    f12 = Float.valueOf((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                }
            }
            Float f14 = this.top;
            if (f14 != null) {
                f5 = Float.valueOf(-f14.floatValue());
            } else {
                f5 = this.bottom;
                if (f5 == null) {
                    f5 = Float.valueOf((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                }
            }
            columnText.getCanvas().saveState();
            columnText.getCanvas().transform(new AffineTransform(1.0f, (float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, (float) ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, f12.floatValue(), f5.floatValue()));
        }
        if (!z && this.backgroundColor != null && getActualWidth() > ColumnText.GLOBAL_SPACE_CHAR_RATIO && getActualHeight() > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            float actualWidth = getActualWidth();
            float actualHeight = getActualHeight();
            Float f15 = this.width;
            if (f15 != null) {
                actualWidth = f15.floatValue() > ColumnText.GLOBAL_SPACE_CHAR_RATIO ? this.width.floatValue() : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
            Float f16 = this.height;
            if (f16 != null) {
                actualHeight = f16.floatValue() > ColumnText.GLOBAL_SPACE_CHAR_RATIO ? this.height.floatValue() : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
            if (actualWidth > ColumnText.GLOBAL_SPACE_CHAR_RATIO && actualHeight > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                Rectangle rectangle = new Rectangle(min, max - actualHeight, actualWidth + min, max);
                rectangle.setBackgroundColor(this.backgroundColor);
                columnText.getCanvas().rectangle(rectangle);
            }
        }
        if (this.percentageWidth == null) {
            this.contentWidth = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (this.percentageHeight == null) {
            this.contentHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        float f17 = min2 + this.paddingBottom;
        float f18 = min + this.paddingLeft;
        float f19 = max2 - this.paddingRight;
        float f20 = max - this.paddingTop;
        if (this.content.isEmpty()) {
            i = 1;
        } else {
            FloatLayout floatLayout2 = this.floatLayout;
            if (floatLayout2 == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.content);
                if (z) {
                    floatLayout = new FloatLayout(columnText, arrayList);
                } else {
                    floatLayout = new FloatLayout(columnText, arrayList);
                    this.floatLayout = floatLayout;
                }
            } else if (z) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.floatLayout.content);
                floatLayout = new FloatLayout(this.floatLayout.compositeColumn, arrayList2);
            } else {
                floatLayout = floatLayout2;
            }
            floatLayout.setSimpleColumn(f18, f17, f19, f20);
            i = floatLayout.layout(z);
            f20 = floatLayout.getYLine();
            if (this.percentageWidth == null && this.contentWidth < floatLayout.getFilledWidth()) {
                this.contentWidth = floatLayout.getFilledWidth();
            }
        }
        if (!z && this.position == PositionType.RELATIVE) {
            columnText.getCanvas().restoreState();
        }
        float f21 = f20 - this.paddingBottom;
        if (this.percentageHeight == null) {
            this.contentHeight = max - f21;
        }
        if (this.percentageWidth == null) {
            this.contentWidth += this.paddingLeft + this.paddingRight;
        }
        if (r11) {
            return 1;
        }
        return i;
    }
}
