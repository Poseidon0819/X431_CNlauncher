package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;

/* loaded from: classes.dex */
public class PdfPRow {
    public static final float BOTTOM_LIMIT = -1.0737418E9f;
    public static final float RIGHT_LIMIT = 20000.0f;
    protected boolean calculated;
    private int[] canvasesPos;
    protected PdfPCell[] cells;
    protected float[] extraHeights;
    protected float maxHeight;
    protected float[] widths;

    public PdfPRow(PdfPCell[] pdfPCellArr) {
        this.maxHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.calculated = false;
        this.cells = pdfPCellArr;
        this.widths = new float[pdfPCellArr.length];
        initExtraHeights();
    }

    public PdfPRow(PdfPRow pdfPRow) {
        this.maxHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.calculated = false;
        this.maxHeight = pdfPRow.maxHeight;
        this.calculated = pdfPRow.calculated;
        this.cells = new PdfPCell[pdfPRow.cells.length];
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (i < pdfPCellArr.length) {
                PdfPCell[] pdfPCellArr2 = pdfPRow.cells;
                if (pdfPCellArr2[i] != null) {
                    pdfPCellArr[i] = new PdfPCell(pdfPCellArr2[i]);
                }
                i++;
            } else {
                this.widths = new float[pdfPCellArr.length];
                System.arraycopy(pdfPRow.widths, 0, this.widths, 0, pdfPCellArr.length);
                initExtraHeights();
                return;
            }
        }
    }

    public boolean setWidths(float[] fArr) {
        int length = fArr.length;
        PdfPCell[] pdfPCellArr = this.cells;
        int i = 0;
        if (length != pdfPCellArr.length) {
            return false;
        }
        System.arraycopy(fArr, 0, this.widths, 0, pdfPCellArr.length);
        this.calculated = false;
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        while (i < fArr.length) {
            PdfPCell pdfPCell = this.cells[i];
            if (pdfPCell == null) {
                f += fArr[i];
            } else {
                pdfPCell.setLeft(f);
                int colspan = pdfPCell.getColspan() + i;
                while (i < colspan) {
                    f += fArr[i];
                    i++;
                }
                i--;
                pdfPCell.setRight(f);
                pdfPCell.setTop(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            }
            i++;
        }
        return true;
    }

    protected void initExtraHeights() {
        this.extraHeights = new float[this.cells.length];
        int i = 0;
        while (true) {
            float[] fArr = this.extraHeights;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = 0.0f;
            i++;
        }
    }

    public void setExtraHeight(int i, float f) {
        if (i < 0 || i >= this.cells.length) {
            return;
        }
        this.extraHeights[i] = f;
    }

    protected void calculateHeights() {
        this.maxHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (i < pdfPCellArr.length) {
                PdfPCell pdfPCell = pdfPCellArr[i];
                if (pdfPCell != null) {
                    float maxHeight = pdfPCell.getMaxHeight();
                    if (maxHeight > this.maxHeight && pdfPCell.getRowspan() == 1) {
                        this.maxHeight = maxHeight;
                    }
                }
                i++;
            } else {
                this.calculated = true;
                return;
            }
        }
    }

    public void writeBorderAndBackground(float f, float f2, float f3, PdfPCell pdfPCell, PdfContentByte[] pdfContentByteArr) {
        BaseColor backgroundColor = pdfPCell.getBackgroundColor();
        if (backgroundColor != null || pdfPCell.hasBorders()) {
            float right = pdfPCell.getRight() + f;
            float top = pdfPCell.getTop() + f2;
            float left = pdfPCell.getLeft() + f;
            float f4 = top - f3;
            if (backgroundColor != null) {
                PdfContentByte pdfContentByte = pdfContentByteArr[1];
                pdfContentByte.setColorFill(backgroundColor);
                pdfContentByte.rectangle(left, f4, right - left, top - f4);
                pdfContentByte.fill();
            }
            if (pdfPCell.hasBorders()) {
                Rectangle rectangle = new Rectangle(left, f4, right, top);
                rectangle.cloneNonPositionParameters(pdfPCell);
                rectangle.setBackgroundColor(null);
                pdfContentByteArr[2].rectangle(rectangle);
            }
        }
    }

    protected void saveAndRotateCanvases(PdfContentByte[] pdfContentByteArr, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.canvasesPos == null) {
            this.canvasesPos = new int[8];
        }
        for (int i = 0; i < 4; i++) {
            ByteBuffer internalBuffer = pdfContentByteArr[i].getInternalBuffer();
            int i2 = i * 2;
            this.canvasesPos[i2] = internalBuffer.size();
            pdfContentByteArr[i].saveState();
            pdfContentByteArr[i].concatCTM(f, f2, f3, f4, f5, f6);
            this.canvasesPos[i2 + 1] = internalBuffer.size();
        }
    }

    protected void restoreCanvases(PdfContentByte[] pdfContentByteArr) {
        for (int i = 0; i < 4; i++) {
            ByteBuffer internalBuffer = pdfContentByteArr[i].getInternalBuffer();
            int size = internalBuffer.size();
            pdfContentByteArr[i].restoreState();
            int[] iArr = this.canvasesPos;
            int i2 = i * 2;
            if (size == iArr[i2 + 1]) {
                internalBuffer.setSize(iArr[i2]);
            }
        }
    }

    public static float setColumn(ColumnText columnText, float f, float f2, float f3, float f4) {
        if (f > f3) {
            f3 = f;
        }
        if (f2 > f4) {
            f4 = f2;
        }
        columnText.setSimpleColumn(f, f2, f3, f4);
        return f4;
    }

    /* JADX WARN: Finally extract failed */
    public void writeCells(int i, int i2, float f, float f2, PdfContentByte[] pdfContentByteArr, boolean z) {
        int min;
        int i3;
        float f3;
        float left;
        float left2;
        ColumnText column;
        ColumnText columnText;
        int i4;
        if (!this.calculated) {
            calculateHeights();
        }
        if (i2 < 0) {
            min = this.cells.length;
        } else {
            min = Math.min(i2, this.cells.length);
        }
        int i5 = i < 0 ? 0 : i;
        if (i5 >= min) {
            return;
        }
        float f4 = f;
        while (i5 >= 0 && this.cells[i5] == null) {
            if (i5 > 0) {
                f4 -= this.widths[i5 - 1];
            }
            i5--;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        PdfPCell[] pdfPCellArr = this.cells;
        if (pdfPCellArr[i5] != null) {
            i3 = i5;
            f3 = f4 - pdfPCellArr[i5].getLeft();
        } else {
            i3 = i5;
            f3 = f4;
        }
        while (i3 < min) {
            PdfPCell pdfPCell = this.cells[i3];
            if (pdfPCell != null) {
                float f5 = this.maxHeight + this.extraHeights[i3];
                writeBorderAndBackground(f3, f2, f5, pdfPCell, pdfContentByteArr);
                Image image = pdfPCell.getImage();
                float top = (pdfPCell.getTop() + f2) - pdfPCell.getEffectivePaddingTop();
                if (pdfPCell.getHeight() <= f5) {
                    switch (pdfPCell.getVerticalAlignment()) {
                        case 5:
                            top = ((pdfPCell.getTop() + f2) + ((pdfPCell.getHeight() - f5) / 2.0f)) - pdfPCell.getEffectivePaddingTop();
                            break;
                        case 6:
                            top = (((pdfPCell.getTop() + f2) - f5) + pdfPCell.getHeight()) - pdfPCell.getEffectivePaddingTop();
                            break;
                    }
                }
                boolean z2 = true;
                if (image != null) {
                    if (pdfPCell.getRotation() != 0) {
                        image = Image.getInstance(image);
                        float imageRotation = image.getImageRotation();
                        double rotation = pdfPCell.getRotation();
                        Double.isNaN(rotation);
                        image.setRotation(imageRotation + ((float) ((rotation * 3.141592653589793d) / 180.0d)));
                    }
                    if (pdfPCell.getHeight() <= f5) {
                        z2 = false;
                    } else if (image.isScaleToFitLineWhenOverflow()) {
                        image.scalePercent(100.0f);
                        image.scalePercent((((f5 - pdfPCell.getEffectivePaddingTop()) - pdfPCell.getEffectivePaddingBottom()) / image.getScaledHeight()) * 100.0f);
                    } else {
                        continue;
                    }
                    float left3 = pdfPCell.getLeft() + f3 + pdfPCell.getEffectivePaddingLeft();
                    if (z2) {
                        switch (pdfPCell.getHorizontalAlignment()) {
                            case 1:
                                left3 = (((((pdfPCell.getLeft() + pdfPCell.getEffectivePaddingLeft()) + pdfPCell.getRight()) - pdfPCell.getEffectivePaddingRight()) - image.getScaledWidth()) / 2.0f) + f3;
                                break;
                            case 2:
                                left3 = ((pdfPCell.getRight() + f3) - pdfPCell.getEffectivePaddingRight()) - image.getScaledWidth();
                                break;
                        }
                        top = (pdfPCell.getTop() + f2) - pdfPCell.getEffectivePaddingTop();
                    }
                    image.setAbsolutePosition(left3, top - image.getScaledHeight());
                    try {
                        pdfContentByteArr[3].addImage(image);
                    } catch (DocumentException e) {
                        throw new ExceptionConverter(e);
                    }
                } else if (pdfPCell.getRotation() == 90 || pdfPCell.getRotation() == 270) {
                    float effectivePaddingTop = (f5 - pdfPCell.getEffectivePaddingTop()) - pdfPCell.getEffectivePaddingBottom();
                    float width = (pdfPCell.getWidth() - pdfPCell.getEffectivePaddingLeft()) - pdfPCell.getEffectivePaddingRight();
                    ColumnText duplicate = ColumnText.duplicate(pdfPCell.getColumn());
                    duplicate.setCanvases(pdfContentByteArr);
                    duplicate.setSimpleColumn(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 0.001f + effectivePaddingTop, -width);
                    try {
                        duplicate.m2715go(true);
                        float f6 = -duplicate.getYLine();
                        if (effectivePaddingTop <= ColumnText.GLOBAL_SPACE_CHAR_RATIO || width <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                            f6 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                        }
                        if (f6 > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                            if (pdfPCell.isUseDescender()) {
                                f6 -= duplicate.getDescender();
                            }
                            ColumnText duplicate2 = ColumnText.duplicate(pdfPCell.getColumn());
                            duplicate2.setCanvases(pdfContentByteArr);
                            duplicate2.setSimpleColumn(-0.003f, -0.001f, effectivePaddingTop + 0.003f, f6);
                            if (pdfPCell.getRotation() == 90) {
                                float top2 = ((pdfPCell.getTop() + f2) - f5) + pdfPCell.getEffectivePaddingBottom();
                                switch (pdfPCell.getVerticalAlignment()) {
                                    case 5:
                                        left2 = pdfPCell.getLeft() + f3 + ((((pdfPCell.getWidth() + pdfPCell.getEffectivePaddingLeft()) - pdfPCell.getEffectivePaddingRight()) + f6) / 2.0f);
                                        break;
                                    case 6:
                                        left2 = ((pdfPCell.getLeft() + f3) + pdfPCell.getWidth()) - pdfPCell.getEffectivePaddingRight();
                                        break;
                                    default:
                                        left2 = pdfPCell.getLeft() + f3 + pdfPCell.getEffectivePaddingLeft() + f6;
                                        break;
                                }
                                saveAndRotateCanvases(pdfContentByteArr, ColumnText.GLOBAL_SPACE_CHAR_RATIO, 1.0f, -1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, left2, top2);
                            } else {
                                float top3 = (pdfPCell.getTop() + f2) - pdfPCell.getEffectivePaddingTop();
                                switch (pdfPCell.getVerticalAlignment()) {
                                    case 5:
                                        left = pdfPCell.getLeft() + f3 + ((((pdfPCell.getWidth() + pdfPCell.getEffectivePaddingLeft()) - pdfPCell.getEffectivePaddingRight()) - f6) / 2.0f);
                                        break;
                                    case 6:
                                        left = pdfPCell.getLeft() + f3 + pdfPCell.getEffectivePaddingLeft();
                                        break;
                                    default:
                                        left = (((pdfPCell.getLeft() + f3) + pdfPCell.getWidth()) - pdfPCell.getEffectivePaddingRight()) - f6;
                                        break;
                                }
                                saveAndRotateCanvases(pdfContentByteArr, ColumnText.GLOBAL_SPACE_CHAR_RATIO, -1.0f, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, left, top3);
                            }
                            try {
                                try {
                                    duplicate2.m2716go();
                                } catch (DocumentException e2) {
                                    throw new ExceptionConverter(e2);
                                }
                            } finally {
                                restoreCanvases(pdfContentByteArr);
                            }
                        }
                    } catch (DocumentException e3) {
                        throw new ExceptionConverter(e3);
                    }
                } else {
                    float fixedHeight = pdfPCell.getFixedHeight();
                    float right = (pdfPCell.getRight() + f3) - pdfPCell.getEffectivePaddingRight();
                    float left4 = pdfPCell.getLeft() + f3 + pdfPCell.getEffectivePaddingLeft();
                    if (pdfPCell.isNoWrap()) {
                        switch (pdfPCell.getHorizontalAlignment()) {
                            case 1:
                                right += 10000.0f;
                                left4 -= 10000.0f;
                                break;
                            case 2:
                                if (pdfPCell.getRotation() != 180) {
                                    left4 -= 20000.0f;
                                    break;
                                }
                                right += 20000.0f;
                                break;
                            default:
                                if (pdfPCell.getRotation() == 180) {
                                    left4 -= 20000.0f;
                                    break;
                                }
                                right += 20000.0f;
                                break;
                        }
                    }
                    if (z) {
                        column = ColumnText.duplicate(pdfPCell.getColumn());
                    } else {
                        column = pdfPCell.getColumn();
                    }
                    column.setCanvases(pdfContentByteArr);
                    float effectivePaddingTop2 = top - ((f5 - pdfPCell.getEffectivePaddingTop()) - pdfPCell.getEffectivePaddingBottom());
                    if (fixedHeight > ColumnText.GLOBAL_SPACE_CHAR_RATIO && pdfPCell.getHeight() > f5) {
                        top = (pdfPCell.getTop() + f2) - pdfPCell.getEffectivePaddingTop();
                        effectivePaddingTop2 = ((pdfPCell.getTop() + f2) - f5) + pdfPCell.getEffectivePaddingBottom();
                    }
                    if ((top > effectivePaddingTop2 || column.zeroHeightElement()) && left4 < right) {
                        column.setSimpleColumn(left4, effectivePaddingTop2 - 0.001f, right, top);
                        if (pdfPCell.getRotation() == 180) {
                            columnText = column;
                            i4 = Opcodes.GETFIELD;
                            saveAndRotateCanvases(pdfContentByteArr, -1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, -1.0f, left4 + right, (((f2 + f2) - f5) + pdfPCell.getEffectivePaddingBottom()) - pdfPCell.getEffectivePaddingTop());
                        } else {
                            columnText = column;
                            i4 = Opcodes.GETFIELD;
                        }
                        try {
                            try {
                                columnText.m2716go();
                                if (pdfPCell.getRotation() == i4) {
                                }
                            } catch (DocumentException e4) {
                                throw new ExceptionConverter(e4);
                            }
                        } catch (Throwable th) {
                            if (pdfPCell.getRotation() == i4) {
                            }
                            throw th;
                        }
                    }
                }
                PdfPCellEvent cellEvent = pdfPCell.getCellEvent();
                if (cellEvent != null) {
                    cellEvent.cellLayout(pdfPCell, new Rectangle(pdfPCell.getLeft() + f3, (pdfPCell.getTop() + f2) - f5, pdfPCell.getRight() + f3, pdfPCell.getTop() + f2), pdfContentByteArr);
                }
            }
            i3++;
        }
    }

    public boolean isCalculated() {
        return this.calculated;
    }

    public float getMaxHeights() {
        if (!this.calculated) {
            calculateHeights();
        }
        return this.maxHeight;
    }

    public void setMaxHeights(float f) {
        this.maxHeight = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] getEventWidth(float f, float[] fArr) {
        int i = 1;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (i2 >= pdfPCellArr.length) {
                break;
            } else if (pdfPCellArr[i2] != null) {
                i3++;
                i2 += pdfPCellArr[i2].getColspan();
            } else {
                while (true) {
                    PdfPCell[] pdfPCellArr2 = this.cells;
                    if (i2 < pdfPCellArr2.length && pdfPCellArr2[i2] == null) {
                        i3++;
                        i2++;
                    }
                }
            }
        }
        float[] fArr2 = new float[i3];
        fArr2[0] = f;
        int i4 = 0;
        while (true) {
            PdfPCell[] pdfPCellArr3 = this.cells;
            if (i4 >= pdfPCellArr3.length || i >= fArr2.length) {
                break;
            } else if (pdfPCellArr3[i4] != null) {
                int colspan = pdfPCellArr3[i4].getColspan();
                fArr2[i] = fArr2[i - 1];
                int i5 = i4;
                int i6 = 0;
                while (i6 < colspan && i5 < fArr.length) {
                    fArr2[i] = fArr2[i] + fArr[i5];
                    i6++;
                    i5++;
                }
                i++;
                i4 = i5;
            } else {
                fArr2[i] = fArr2[i - 1];
                while (true) {
                    PdfPCell[] pdfPCellArr4 = this.cells;
                    if (i4 >= pdfPCellArr4.length || pdfPCellArr4[i4] != null) {
                        break;
                    }
                    fArr2[i] = fArr2[i] + fArr[i4];
                    i4++;
                }
                i++;
            }
        }
        return fArr2;
    }

    public void copyRowContent(PdfPTable pdfPTable, int i) {
        if (pdfPTable == null) {
            return;
        }
        for (int i2 = 0; i2 < this.cells.length; i2++) {
            PdfPCell pdfPCell = pdfPTable.getRow(i).getCells()[i2];
            int i3 = i;
            while (pdfPCell == null && i3 > 0) {
                i3--;
                pdfPCell = pdfPTable.getRow(i3).getCells()[i2];
            }
            PdfPCell[] pdfPCellArr = this.cells;
            if (pdfPCellArr[i2] != null && pdfPCell != null) {
                pdfPCellArr[i2].setColumn(pdfPCell.getColumn());
                this.calculated = false;
            }
        }
    }

    public PdfPRow splitRow(PdfPTable pdfPTable, int i, float f) {
        float column;
        boolean z;
        PdfPTable pdfPTable2 = pdfPTable;
        int i2 = i;
        PdfPCell[] pdfPCellArr = this.cells;
        PdfPCell[] pdfPCellArr2 = new PdfPCell[pdfPCellArr.length];
        float[] fArr = new float[pdfPCellArr.length];
        float[] fArr2 = new float[pdfPCellArr.length];
        int i3 = 0;
        boolean z2 = true;
        while (true) {
            PdfPCell[] pdfPCellArr3 = this.cells;
            if (i3 >= pdfPCellArr3.length) {
                break;
            }
            PdfPCell pdfPCell = pdfPCellArr3[i3];
            if (pdfPCell == null) {
                if (pdfPTable2.rowSpanAbove(i2, i3)) {
                    int i4 = i2;
                    while (true) {
                        i4--;
                        if (!pdfPTable2.rowSpanAbove(i4, i3)) {
                            break;
                        }
                        pdfPTable2.getRow(i4).getMaxHeights();
                    }
                    PdfPRow row = pdfPTable2.getRow(i4);
                    if (row != null && row.getCells()[i3] != null) {
                        pdfPCellArr2[i3] = new PdfPCell(row.getCells()[i3]);
                        pdfPCellArr2[i3].setColumn(null);
                        pdfPCellArr2[i3].setRowspan((row.getCells()[i3].getRowspan() - i2) + i4);
                        z2 = false;
                    }
                }
            } else {
                fArr[i3] = pdfPCell.getFixedHeight();
                fArr2[i3] = pdfPCell.getMinimumHeight();
                Image image = pdfPCell.getImage();
                PdfPCell pdfPCell2 = new PdfPCell(pdfPCell);
                if (image != null) {
                    float effectivePaddingBottom = pdfPCell.getEffectivePaddingBottom() + pdfPCell.getEffectivePaddingTop() + 2.0f;
                    if ((image.isScaleToFitLineWhenOverflow() || image.getScaledHeight() + effectivePaddingBottom < f) && f > effectivePaddingBottom) {
                        pdfPCell2.setPhrase(null);
                        z2 = false;
                    }
                } else {
                    ColumnText duplicate = ColumnText.duplicate(pdfPCell.getColumn());
                    float left = pdfPCell.getLeft() + pdfPCell.getEffectivePaddingLeft();
                    float top = (pdfPCell.getTop() + pdfPCell.getEffectivePaddingBottom()) - f;
                    float right = pdfPCell.getRight() - pdfPCell.getEffectivePaddingRight();
                    float top2 = pdfPCell.getTop() - pdfPCell.getEffectivePaddingTop();
                    int rotation = pdfPCell.getRotation();
                    if (rotation == 90 || rotation == 270) {
                        column = setColumn(duplicate, top, left, top2, right);
                        z = true;
                    } else {
                        float f2 = top + 1.0E-5f;
                        if (pdfPCell.isNoWrap()) {
                            right = 20000.0f;
                        }
                        column = setColumn(duplicate, left, f2, right, top2);
                        z = true;
                    }
                    try {
                        int m2715go = duplicate.m2715go(z);
                        boolean z3 = duplicate.getYLine() == column;
                        if (z3) {
                            pdfPCell2.setColumn(ColumnText.duplicate(pdfPCell.getColumn()));
                            duplicate.setFilledWidth(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                        } else if ((m2715go & 1) == 0) {
                            pdfPCell2.setColumn(duplicate);
                            duplicate.setFilledWidth(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                        } else {
                            pdfPCell2.setPhrase(null);
                        }
                        z2 = z2 && z3;
                    } catch (DocumentException e) {
                        throw new ExceptionConverter(e);
                    }
                }
                pdfPCellArr2[i3] = pdfPCell2;
                pdfPCell.setFixedHeight(f);
            }
            i3++;
            pdfPTable2 = pdfPTable;
            i2 = i;
        }
        if (!z2) {
            calculateHeights();
            PdfPRow pdfPRow = new PdfPRow(pdfPCellArr2);
            pdfPRow.widths = (float[]) this.widths.clone();
            return pdfPRow;
        }
        int i5 = 0;
        while (true) {
            PdfPCell[] pdfPCellArr4 = this.cells;
            if (i5 >= pdfPCellArr4.length) {
                return null;
            }
            PdfPCell pdfPCell3 = pdfPCellArr4[i5];
            if (pdfPCell3 != null) {
                if (fArr[i5] > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    pdfPCell3.setFixedHeight(fArr[i5]);
                } else {
                    pdfPCell3.setMinimumHeight(fArr2[i5]);
                }
            }
            i5++;
        }
    }

    public PdfPCell[] getCells() {
        return this.cells;
    }

    public boolean hasRowspan() {
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (i >= pdfPCellArr.length) {
                return false;
            }
            if (pdfPCellArr[i] != null && pdfPCellArr[i].getRowspan() > 1) {
                return true;
            }
            i++;
        }
    }
}
