package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.events.PdfPCellEventForwarder;
import java.util.List;

/* loaded from: classes.dex */
public class PdfPCell extends Rectangle {
    private PdfPCellEvent cellEvent;
    private int colspan;
    private ColumnText column;
    private float fixedHeight;
    private Image image;
    private float minimumHeight;
    private boolean noWrap;
    private float paddingBottom;
    private float paddingLeft;
    private float paddingRight;
    private float paddingTop;
    protected Phrase phrase;
    private int rotation;
    private int rowspan;
    private PdfPTable table;
    private boolean useBorderPadding;
    private boolean useDescender;
    private int verticalAlignment;

    public PdfPCell() {
        super(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        this.borderWidth = 0.5f;
        this.border = 15;
        this.column.setLeading(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f);
    }

    public PdfPCell(Phrase phrase) {
        super(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        this.borderWidth = 0.5f;
        this.border = 15;
        ColumnText columnText = this.column;
        this.phrase = phrase;
        columnText.addText(phrase);
        this.column.setLeading(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f);
    }

    public PdfPCell(Image image) {
        this(image, false);
    }

    public PdfPCell(Image image, boolean z) {
        super(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        this.borderWidth = 0.5f;
        this.border = 15;
        this.column.setLeading(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f);
        if (z) {
            this.image = image;
            setPadding(this.borderWidth / 2.0f);
            return;
        }
        ColumnText columnText = this.column;
        Phrase phrase = new Phrase(new Chunk(image, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, true));
        this.phrase = phrase;
        columnText.addText(phrase);
        setPadding(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public PdfPCell(PdfPTable pdfPTable) {
        this(pdfPTable, (PdfPCell) null);
    }

    public PdfPCell(PdfPTable pdfPTable, PdfPCell pdfPCell) {
        super(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        this.borderWidth = 0.5f;
        this.border = 15;
        this.column.setLeading(ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f);
        this.table = pdfPTable;
        pdfPTable.setWidthPercentage(100.0f);
        pdfPTable.setExtendLastRow(true);
        this.column.addElement(pdfPTable);
        if (pdfPCell != null) {
            cloneNonPositionParameters(pdfPCell);
            this.verticalAlignment = pdfPCell.verticalAlignment;
            this.paddingLeft = pdfPCell.paddingLeft;
            this.paddingRight = pdfPCell.paddingRight;
            this.paddingTop = pdfPCell.paddingTop;
            this.paddingBottom = pdfPCell.paddingBottom;
            this.colspan = pdfPCell.colspan;
            this.rowspan = pdfPCell.rowspan;
            this.cellEvent = pdfPCell.cellEvent;
            this.useDescender = pdfPCell.useDescender;
            this.useBorderPadding = pdfPCell.useBorderPadding;
            this.rotation = pdfPCell.rotation;
            return;
        }
        setPadding(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    public PdfPCell(PdfPCell pdfPCell) {
        super(pdfPCell.llx, pdfPCell.lly, pdfPCell.urx, pdfPCell.ury);
        this.column = new ColumnText(null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useDescender = false;
        this.useBorderPadding = false;
        cloneNonPositionParameters(pdfPCell);
        this.verticalAlignment = pdfPCell.verticalAlignment;
        this.paddingLeft = pdfPCell.paddingLeft;
        this.paddingRight = pdfPCell.paddingRight;
        this.paddingTop = pdfPCell.paddingTop;
        this.paddingBottom = pdfPCell.paddingBottom;
        this.phrase = pdfPCell.phrase;
        this.fixedHeight = pdfPCell.fixedHeight;
        this.minimumHeight = pdfPCell.minimumHeight;
        this.noWrap = pdfPCell.noWrap;
        this.colspan = pdfPCell.colspan;
        this.rowspan = pdfPCell.rowspan;
        PdfPTable pdfPTable = pdfPCell.table;
        if (pdfPTable != null) {
            this.table = new PdfPTable(pdfPTable);
        }
        this.image = Image.getInstance(pdfPCell.image);
        this.cellEvent = pdfPCell.cellEvent;
        this.useDescender = pdfPCell.useDescender;
        this.column = ColumnText.duplicate(pdfPCell.column);
        this.useBorderPadding = pdfPCell.useBorderPadding;
        this.rotation = pdfPCell.rotation;
    }

    public void addElement(Element element) {
        if (this.table != null) {
            this.table = null;
            this.column.setText(null);
        }
        this.column.addElement(element);
    }

    public Phrase getPhrase() {
        return this.phrase;
    }

    public void setPhrase(Phrase phrase) {
        this.table = null;
        this.image = null;
        ColumnText columnText = this.column;
        this.phrase = phrase;
        columnText.setText(phrase);
    }

    public int getHorizontalAlignment() {
        return this.column.getAlignment();
    }

    public void setHorizontalAlignment(int i) {
        this.column.setAlignment(i);
    }

    public int getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public void setVerticalAlignment(int i) {
        PdfPTable pdfPTable = this.table;
        if (pdfPTable != null) {
            pdfPTable.setExtendLastRow(i == 4);
        }
        this.verticalAlignment = i;
    }

    public float getEffectivePaddingLeft() {
        if (isUseBorderPadding()) {
            return this.paddingLeft + (getBorderWidthLeft() / (isUseVariableBorders() ? 1.0f : 2.0f));
        }
        return this.paddingLeft;
    }

    public float getPaddingLeft() {
        return this.paddingLeft;
    }

    public void setPaddingLeft(float f) {
        this.paddingLeft = f;
    }

    public float getEffectivePaddingRight() {
        if (isUseBorderPadding()) {
            return this.paddingRight + (getBorderWidthRight() / (isUseVariableBorders() ? 1.0f : 2.0f));
        }
        return this.paddingRight;
    }

    public float getPaddingRight() {
        return this.paddingRight;
    }

    public void setPaddingRight(float f) {
        this.paddingRight = f;
    }

    public float getEffectivePaddingTop() {
        if (isUseBorderPadding()) {
            return this.paddingTop + (getBorderWidthTop() / (isUseVariableBorders() ? 1.0f : 2.0f));
        }
        return this.paddingTop;
    }

    public float getPaddingTop() {
        return this.paddingTop;
    }

    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }

    public float getEffectivePaddingBottom() {
        if (isUseBorderPadding()) {
            return this.paddingBottom + (getBorderWidthBottom() / (isUseVariableBorders() ? 1.0f : 2.0f));
        }
        return this.paddingBottom;
    }

    public float getPaddingBottom() {
        return this.paddingBottom;
    }

    public void setPaddingBottom(float f) {
        this.paddingBottom = f;
    }

    public void setPadding(float f) {
        this.paddingBottom = f;
        this.paddingTop = f;
        this.paddingLeft = f;
        this.paddingRight = f;
    }

    public boolean isUseBorderPadding() {
        return this.useBorderPadding;
    }

    public void setUseBorderPadding(boolean z) {
        this.useBorderPadding = z;
    }

    public void setLeading(float f, float f2) {
        this.column.setLeading(f, f2);
    }

    public float getLeading() {
        return this.column.getLeading();
    }

    public float getMultipliedLeading() {
        return this.column.getMultipliedLeading();
    }

    public void setIndent(float f) {
        this.column.setIndent(f);
    }

    public float getIndent() {
        return this.column.getIndent();
    }

    public float getExtraParagraphSpace() {
        return this.column.getExtraParagraphSpace();
    }

    public void setExtraParagraphSpace(float f) {
        this.column.setExtraParagraphSpace(f);
    }

    public void setFixedHeight(float f) {
        this.fixedHeight = f;
        this.minimumHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public float getFixedHeight() {
        return this.fixedHeight;
    }

    public boolean hasFixedHeight() {
        return getFixedHeight() > ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public void setMinimumHeight(float f) {
        this.minimumHeight = f;
        this.fixedHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public float getMinimumHeight() {
        return this.minimumHeight;
    }

    public boolean hasMinimumHeight() {
        return getMinimumHeight() > ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public boolean isNoWrap() {
        return this.noWrap;
    }

    public void setNoWrap(boolean z) {
        this.noWrap = z;
    }

    public PdfPTable getTable() {
        return this.table;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTable(PdfPTable pdfPTable) {
        this.table = pdfPTable;
        this.column.setText(null);
        this.image = null;
        if (pdfPTable != null) {
            pdfPTable.setExtendLastRow(this.verticalAlignment == 4);
            this.column.addElement(pdfPTable);
            pdfPTable.setWidthPercentage(100.0f);
        }
    }

    public int getColspan() {
        return this.colspan;
    }

    public void setColspan(int i) {
        this.colspan = i;
    }

    public int getRowspan() {
        return this.rowspan;
    }

    public void setRowspan(int i) {
        this.rowspan = i;
    }

    public void setFollowingIndent(float f) {
        this.column.setFollowingIndent(f);
    }

    public float getFollowingIndent() {
        return this.column.getFollowingIndent();
    }

    public void setRightIndent(float f) {
        this.column.setRightIndent(f);
    }

    public float getRightIndent() {
        return this.column.getRightIndent();
    }

    public float getSpaceCharRatio() {
        return this.column.getSpaceCharRatio();
    }

    public void setSpaceCharRatio(float f) {
        this.column.setSpaceCharRatio(f);
    }

    public void setRunDirection(int i) {
        this.column.setRunDirection(i);
    }

    public int getRunDirection() {
        return this.column.getRunDirection();
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.column.setText(null);
        this.table = null;
        this.image = image;
    }

    public PdfPCellEvent getCellEvent() {
        return this.cellEvent;
    }

    public void setCellEvent(PdfPCellEvent pdfPCellEvent) {
        if (pdfPCellEvent == null) {
            this.cellEvent = null;
            return;
        }
        PdfPCellEvent pdfPCellEvent2 = this.cellEvent;
        if (pdfPCellEvent2 == null) {
            this.cellEvent = pdfPCellEvent;
        } else if (pdfPCellEvent2 instanceof PdfPCellEventForwarder) {
            ((PdfPCellEventForwarder) pdfPCellEvent2).addCellEvent(pdfPCellEvent);
        } else {
            PdfPCellEventForwarder pdfPCellEventForwarder = new PdfPCellEventForwarder();
            pdfPCellEventForwarder.addCellEvent(this.cellEvent);
            pdfPCellEventForwarder.addCellEvent(pdfPCellEvent);
            this.cellEvent = pdfPCellEventForwarder;
        }
    }

    public int getArabicOptions() {
        return this.column.getArabicOptions();
    }

    public void setArabicOptions(int i) {
        this.column.setArabicOptions(i);
    }

    public boolean isUseAscender() {
        return this.column.isUseAscender();
    }

    public void setUseAscender(boolean z) {
        this.column.setUseAscender(z);
    }

    public boolean isUseDescender() {
        return this.useDescender;
    }

    public void setUseDescender(boolean z) {
        this.useDescender = z;
    }

    public ColumnText getColumn() {
        return this.column;
    }

    public List<Element> getCompositeElements() {
        return getColumn().compositeElements;
    }

    public void setColumn(ColumnText columnText) {
        this.column = columnText;
    }

    @Override // com.itextpdf.text.Rectangle
    public int getRotation() {
        return this.rotation;
    }

    @Override // com.itextpdf.text.Rectangle
    public void setRotation(int i) {
        int i2 = i % 360;
        if (i2 < 0) {
            i2 += 360;
        }
        if (i2 % 90 != 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("rotation.must.be.a.multiple.of.90", new Object[0]));
        }
        this.rotation = i2;
    }

    public float getMaxHeight() {
        float top;
        float left;
        float top2;
        boolean z = getRotation() == 90 || getRotation() == 270;
        Image image = getImage();
        if (image != null) {
            image.scalePercent(100.0f);
            image.scalePercent(((((getRight() - getEffectivePaddingRight()) - getEffectivePaddingLeft()) - getLeft()) / (z ? image.getScaledHeight() : image.getScaledWidth())) * 100.0f);
            setBottom(((getTop() - getEffectivePaddingTop()) - getEffectivePaddingBottom()) - (z ? image.getScaledWidth() : image.getScaledHeight()));
        } else if (z && hasFixedHeight()) {
            setBottom(getTop() - getFixedHeight());
        } else {
            ColumnText duplicate = ColumnText.duplicate(getColumn());
            if (z) {
                top = getRight() - getEffectivePaddingRight();
                left = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                top2 = getLeft() + getEffectivePaddingLeft();
            } else {
                r3 = isNoWrap() ? 20000.0f : getRight() - getEffectivePaddingRight();
                top = getTop() - getEffectivePaddingTop();
                left = getLeft() + getEffectivePaddingLeft();
                top2 = hasFixedHeight() ? (getTop() + getEffectivePaddingBottom()) - getFixedHeight() : -1.0737418E9f;
            }
            PdfPRow.setColumn(duplicate, left, top2, r3, top);
            try {
                duplicate.m2715go(true);
                if (z) {
                    setBottom(((getTop() - getEffectivePaddingTop()) - getEffectivePaddingBottom()) - duplicate.getFilledWidth());
                } else {
                    float yLine = duplicate.getYLine();
                    if (isUseDescender()) {
                        yLine += duplicate.getDescender();
                    }
                    setBottom(yLine - getEffectivePaddingBottom());
                }
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            }
        }
        float height = getHeight();
        if (hasFixedHeight()) {
            return getFixedHeight();
        }
        return (!hasMinimumHeight() || height >= getMinimumHeight()) ? height : getMinimumHeight();
    }
}
