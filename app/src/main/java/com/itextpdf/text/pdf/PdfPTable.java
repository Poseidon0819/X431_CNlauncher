package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Image;
import com.itextpdf.text.LargeElement;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.events.PdfPTableEventForwarder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PdfPTable implements LargeElement, Spaceable {
    public static final int BACKGROUNDCANVAS = 1;
    public static final int BASECANVAS = 0;
    public static final int LINECANVAS = 2;
    public static final int TEXTCANVAS = 3;
    protected float[] absoluteWidths;
    protected PdfPCell[] currentRow;
    private int footerRows;
    protected int headerRows;
    private boolean headersInEvent;
    private boolean keepTogether;
    protected float[] relativeWidths;
    protected float spacingAfter;
    protected float spacingBefore;
    protected PdfPTableEvent tableEvent;
    protected ArrayList<PdfPRow> rows = new ArrayList<>();
    protected float totalHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    protected int currentColIdx = 0;
    protected PdfPCell defaultCell = new PdfPCell((Phrase) null);
    protected float totalWidth = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    protected float widthPercentage = 80.0f;
    private int horizontalAlignment = 1;
    private boolean skipFirstHeader = false;
    private boolean skipLastFooter = false;
    protected boolean isColspan = false;
    protected int runDirection = 0;
    private boolean lockedWidth = false;
    private boolean splitRows = true;
    private boolean[] extendLastRow = {false, false};
    private boolean splitLate = true;
    protected boolean complete = true;
    protected boolean rowCompleted = true;

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
        return 23;
    }

    protected PdfPTable() {
    }

    public PdfPTable(float[] fArr) {
        if (fArr == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("the.widths.array.in.pdfptable.constructor.can.not.be.null", new Object[0]));
        }
        if (fArr.length == 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.widths.array.in.pdfptable.constructor.can.not.have.zero.length", new Object[0]));
        }
        this.relativeWidths = new float[fArr.length];
        System.arraycopy(fArr, 0, this.relativeWidths, 0, fArr.length);
        this.absoluteWidths = new float[fArr.length];
        calculateWidths();
        this.currentRow = new PdfPCell[this.absoluteWidths.length];
        this.keepTogether = false;
    }

    public PdfPTable(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.number.of.columns.in.pdfptable.constructor.must.be.greater.than.zero", new Object[0]));
        }
        this.relativeWidths = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.relativeWidths[i2] = 1.0f;
        }
        this.absoluteWidths = new float[this.relativeWidths.length];
        calculateWidths();
        this.currentRow = new PdfPCell[this.absoluteWidths.length];
        this.keepTogether = false;
    }

    public PdfPTable(PdfPTable pdfPTable) {
        copyFormat(pdfPTable);
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.currentRow;
            if (i >= pdfPCellArr.length) {
                break;
            }
            PdfPCell[] pdfPCellArr2 = pdfPTable.currentRow;
            if (pdfPCellArr2[i] == null) {
                break;
            }
            pdfPCellArr[i] = new PdfPCell(pdfPCellArr2[i]);
            i++;
        }
        for (int i2 = 0; i2 < pdfPTable.rows.size(); i2++) {
            PdfPRow pdfPRow = pdfPTable.rows.get(i2);
            if (pdfPRow != null) {
                pdfPRow = new PdfPRow(pdfPRow);
            }
            this.rows.add(pdfPRow);
        }
    }

    public static PdfPTable shallowCopy(PdfPTable pdfPTable) {
        PdfPTable pdfPTable2 = new PdfPTable();
        pdfPTable2.copyFormat(pdfPTable);
        return pdfPTable2;
    }

    protected void copyFormat(PdfPTable pdfPTable) {
        this.relativeWidths = new float[pdfPTable.getNumberOfColumns()];
        this.absoluteWidths = new float[pdfPTable.getNumberOfColumns()];
        System.arraycopy(pdfPTable.relativeWidths, 0, this.relativeWidths, 0, getNumberOfColumns());
        System.arraycopy(pdfPTable.absoluteWidths, 0, this.absoluteWidths, 0, getNumberOfColumns());
        this.totalWidth = pdfPTable.totalWidth;
        this.totalHeight = pdfPTable.totalHeight;
        this.currentColIdx = 0;
        this.tableEvent = pdfPTable.tableEvent;
        this.runDirection = pdfPTable.runDirection;
        this.defaultCell = new PdfPCell(pdfPTable.defaultCell);
        this.currentRow = new PdfPCell[pdfPTable.currentRow.length];
        this.isColspan = pdfPTable.isColspan;
        this.splitRows = pdfPTable.splitRows;
        this.spacingAfter = pdfPTable.spacingAfter;
        this.spacingBefore = pdfPTable.spacingBefore;
        this.headerRows = pdfPTable.headerRows;
        this.footerRows = pdfPTable.footerRows;
        this.lockedWidth = pdfPTable.lockedWidth;
        this.extendLastRow = pdfPTable.extendLastRow;
        this.headersInEvent = pdfPTable.headersInEvent;
        this.widthPercentage = pdfPTable.widthPercentage;
        this.splitLate = pdfPTable.splitLate;
        this.skipFirstHeader = pdfPTable.skipFirstHeader;
        this.skipLastFooter = pdfPTable.skipLastFooter;
        this.horizontalAlignment = pdfPTable.horizontalAlignment;
        this.keepTogether = pdfPTable.keepTogether;
        this.complete = pdfPTable.complete;
    }

    public void setWidths(float[] fArr) throws DocumentException {
        if (fArr.length != getNumberOfColumns()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("wrong.number.of.columns", new Object[0]));
        }
        this.relativeWidths = new float[fArr.length];
        System.arraycopy(fArr, 0, this.relativeWidths, 0, fArr.length);
        this.absoluteWidths = new float[fArr.length];
        this.totalHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        calculateWidths();
        calculateHeights();
    }

    public void setWidths(int[] iArr) throws DocumentException {
        float[] fArr = new float[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            fArr[i] = iArr[i];
        }
        setWidths(fArr);
    }

    protected void calculateWidths() {
        if (this.totalWidth <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            return;
        }
        int numberOfColumns = getNumberOfColumns();
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (int i = 0; i < numberOfColumns; i++) {
            f += this.relativeWidths[i];
        }
        for (int i2 = 0; i2 < numberOfColumns; i2++) {
            this.absoluteWidths[i2] = (this.totalWidth * this.relativeWidths[i2]) / f;
        }
    }

    public void setTotalWidth(float f) {
        if (this.totalWidth == f) {
            return;
        }
        this.totalWidth = f;
        this.totalHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        calculateWidths();
        calculateHeights();
    }

    public void setTotalWidth(float[] fArr) throws DocumentException {
        if (fArr.length != getNumberOfColumns()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("wrong.number.of.columns", new Object[0]));
        }
        this.totalWidth = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (float f : fArr) {
            this.totalWidth += f;
        }
        setWidths(fArr);
    }

    public void setWidthPercentage(float[] fArr, Rectangle rectangle) throws DocumentException {
        if (fArr.length != getNumberOfColumns()) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("wrong.number.of.columns", new Object[0]));
        }
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (float f2 : fArr) {
            f += f2;
        }
        this.widthPercentage = (f / (rectangle.getRight() - rectangle.getLeft())) * 100.0f;
        setWidths(fArr);
    }

    public float getTotalWidth() {
        return this.totalWidth;
    }

    public float calculateHeights() {
        if (this.totalWidth <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        this.totalHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (int i = 0; i < this.rows.size(); i++) {
            this.totalHeight += getRowHeight(i, true);
        }
        return this.totalHeight;
    }

    public void resetColumnCount(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.number.of.columns.in.pdfptable.constructor.must.be.greater.than.zero", new Object[0]));
        }
        this.relativeWidths = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.relativeWidths[i2] = 1.0f;
        }
        this.absoluteWidths = new float[this.relativeWidths.length];
        calculateWidths();
        this.currentRow = new PdfPCell[this.absoluteWidths.length];
        this.totalHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public PdfPCell getDefaultCell() {
        return this.defaultCell;
    }

    public void addCell(PdfPCell pdfPCell) {
        boolean z;
        int i;
        PdfPCell[] pdfPCellArr;
        this.rowCompleted = false;
        PdfPCell pdfPCell2 = new PdfPCell(pdfPCell);
        int min = Math.min(Math.max(pdfPCell2.getColspan(), 1), this.currentRow.length - this.currentColIdx);
        pdfPCell2.setColspan(min);
        if (min != 1) {
            this.isColspan = true;
        }
        if (pdfPCell2.getRunDirection() == 0) {
            pdfPCell2.setRunDirection(this.runDirection);
        }
        skipColsWithRowspanAbove();
        int i2 = this.currentColIdx;
        PdfPCell[] pdfPCellArr2 = this.currentRow;
        if (i2 < pdfPCellArr2.length) {
            pdfPCellArr2[i2] = pdfPCell2;
            this.currentColIdx = i2 + min;
            z = true;
        } else {
            z = false;
        }
        skipColsWithRowspanAbove();
        while (true) {
            i = this.currentColIdx;
            pdfPCellArr = this.currentRow;
            if (i < pdfPCellArr.length) {
                break;
            }
            int numberOfColumns = getNumberOfColumns();
            if (this.runDirection == 3) {
                PdfPCell[] pdfPCellArr3 = new PdfPCell[numberOfColumns];
                int length = this.currentRow.length;
                int i3 = 0;
                while (true) {
                    PdfPCell[] pdfPCellArr4 = this.currentRow;
                    if (i3 >= pdfPCellArr4.length) {
                        break;
                    }
                    PdfPCell pdfPCell3 = pdfPCellArr4[i3];
                    int colspan = pdfPCell3.getColspan();
                    length -= colspan;
                    pdfPCellArr3[length] = pdfPCell3;
                    i3 = i3 + (colspan - 1) + 1;
                }
                this.currentRow = pdfPCellArr3;
            }
            PdfPRow pdfPRow = new PdfPRow(this.currentRow);
            if (this.totalWidth > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                pdfPRow.setWidths(this.absoluteWidths);
                this.totalHeight += pdfPRow.getMaxHeights();
            }
            this.rows.add(pdfPRow);
            this.currentRow = new PdfPCell[numberOfColumns];
            this.currentColIdx = 0;
            skipColsWithRowspanAbove();
            this.rowCompleted = true;
        }
        if (z) {
            return;
        }
        pdfPCellArr[i] = pdfPCell2;
        this.currentColIdx = i + min;
    }

    private void skipColsWithRowspanAbove() {
        int i = this.runDirection == 3 ? -1 : 1;
        while (rowSpanAbove(this.rows.size(), this.currentColIdx)) {
            this.currentColIdx += i;
        }
    }

    PdfPCell cellAt(int i, int i2) {
        PdfPCell[] cells = this.rows.get(i).getCells();
        for (int i3 = 0; i3 < cells.length; i3++) {
            if (cells[i3] != null && i2 >= i3 && i2 < cells[i3].getColspan() + i3) {
                return cells[i3];
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean rowSpanAbove(int i, int i2) {
        if (i2 >= getNumberOfColumns() || i2 < 0 || i <= 0) {
            return false;
        }
        int i3 = i - 1;
        if (this.rows.get(i3) == null) {
            return false;
        }
        PdfPCell cellAt = cellAt(i3, i2);
        while (cellAt == null && i3 > 0) {
            i3--;
            if (this.rows.get(i3) == null) {
                return false;
            }
            cellAt = cellAt(i3, i2);
        }
        int i4 = i - i3;
        if (cellAt.getRowspan() == 1 && i4 > 1) {
            int i5 = i2 - 1;
            PdfPRow pdfPRow = this.rows.get(i3 + 1);
            i4--;
            cellAt = pdfPRow.getCells()[i5];
            while (cellAt == null && i5 > 0) {
                i5--;
                cellAt = pdfPRow.getCells()[i5];
            }
        }
        return cellAt != null && cellAt.getRowspan() > i4;
    }

    public void addCell(String str) {
        addCell(new Phrase(str));
    }

    public void addCell(PdfPTable pdfPTable) {
        this.defaultCell.setTable(pdfPTable);
        addCell(this.defaultCell);
        this.defaultCell.setTable(null);
    }

    public void addCell(Image image) {
        this.defaultCell.setImage(image);
        addCell(this.defaultCell);
        this.defaultCell.setImage(null);
    }

    public void addCell(Phrase phrase) {
        this.defaultCell.setPhrase(phrase);
        addCell(this.defaultCell);
        this.defaultCell.setPhrase(null);
    }

    public float writeSelectedRows(int i, int i2, float f, float f2, PdfContentByte[] pdfContentByteArr) {
        return writeSelectedRows(0, -1, i, i2, f, f2, pdfContentByteArr);
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte[] pdfContentByteArr) {
        return writeSelectedRows(i, i2, i3, i4, f, f2, pdfContentByteArr, true);
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte[] pdfContentByteArr, boolean z) {
        if (this.totalWidth <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("the.table.width.must.be.greater.than.zero", new Object[0]));
        }
        int size = this.rows.size();
        int i5 = i3 < 0 ? 0 : i3;
        if (i4 >= 0) {
            size = Math.min(i4, size);
        }
        if (i5 >= size) {
            return f2;
        }
        int numberOfColumns = getNumberOfColumns();
        int min = i < 0 ? 0 : Math.min(i, numberOfColumns);
        int min2 = i2 < 0 ? numberOfColumns : Math.min(i2, numberOfColumns);
        float f3 = f2;
        for (int i6 = i5; i6 < size; i6++) {
            PdfPRow pdfPRow = this.rows.get(i6);
            if (pdfPRow != null) {
                pdfPRow.writeCells(min, min2, f, f3, pdfContentByteArr, z);
                f3 -= pdfPRow.getMaxHeights();
            }
        }
        if (this.tableEvent != null && min == 0 && min2 == numberOfColumns) {
            float[] fArr = new float[(size - i5) + 1];
            fArr[0] = f2;
            for (int i7 = i5; i7 < size; i7++) {
                PdfPRow pdfPRow2 = this.rows.get(i7);
                int i8 = i7 - i5;
                fArr[i8 + 1] = fArr[i8] - (pdfPRow2 != null ? pdfPRow2.getMaxHeights() : ColumnText.GLOBAL_SPACE_CHAR_RATIO);
            }
            this.tableEvent.tableLayout(this, getEventWidths(f, i5, size, this.headersInEvent), fArr, this.headersInEvent ? this.headerRows : 0, i5, pdfContentByteArr);
        }
        return f3;
    }

    public float writeSelectedRows(int i, int i2, float f, float f2, PdfContentByte pdfContentByte) {
        return writeSelectedRows(0, -1, i, i2, f, f2, pdfContentByte);
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte pdfContentByte) {
        return writeSelectedRows(i, i2, i3, i4, f, f2, pdfContentByte, true);
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte pdfContentByte, boolean z) {
        int numberOfColumns = getNumberOfColumns();
        boolean z2 = false;
        int min = i < 0 ? 0 : Math.min(i, numberOfColumns);
        int min2 = i2 < 0 ? numberOfColumns : Math.min(i2, numberOfColumns);
        z2 = (min == 0 && min2 == numberOfColumns) ? true : true;
        if (z2) {
            float f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            float f4 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            for (int i5 = min; i5 < min2; i5++) {
                f4 += this.absoluteWidths[i5];
            }
            pdfContentByte.saveState();
            float f5 = min == 0 ? 10000.0f : ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            if (min2 == numberOfColumns) {
                f3 = 10000.0f;
            }
            pdfContentByte.rectangle(f - f5, -10000.0f, f4 + f5 + f3, 20000.0f);
            pdfContentByte.clip();
            pdfContentByte.newPath();
        }
        PdfContentByte[] beginWritingRows = beginWritingRows(pdfContentByte);
        float writeSelectedRows = writeSelectedRows(min, min2, i3, i4, f, f2, beginWritingRows, z);
        endWritingRows(beginWritingRows);
        if (z2) {
            pdfContentByte.restoreState();
        }
        return writeSelectedRows;
    }

    public static PdfContentByte[] beginWritingRows(PdfContentByte pdfContentByte) {
        return new PdfContentByte[]{pdfContentByte, pdfContentByte.getDuplicate(), pdfContentByte.getDuplicate(), pdfContentByte.getDuplicate()};
    }

    public static void endWritingRows(PdfContentByte[] pdfContentByteArr) {
        PdfContentByte pdfContentByte = pdfContentByteArr[0];
        pdfContentByte.saveState();
        pdfContentByte.add(pdfContentByteArr[1]);
        pdfContentByte.restoreState();
        pdfContentByte.saveState();
        pdfContentByte.setLineCap(2);
        pdfContentByte.resetRGBColorStroke();
        pdfContentByte.add(pdfContentByteArr[2]);
        pdfContentByte.restoreState();
        pdfContentByte.add(pdfContentByteArr[3]);
    }

    public int size() {
        return this.rows.size();
    }

    public float getTotalHeight() {
        return this.totalHeight;
    }

    public float getRowHeight(int i) {
        return getRowHeight(i, false);
    }

    protected float getRowHeight(int i, boolean z) {
        PdfPRow pdfPRow;
        int i2;
        float f;
        if (this.totalWidth <= ColumnText.GLOBAL_SPACE_CHAR_RATIO || i < 0 || i >= this.rows.size() || (pdfPRow = this.rows.get(i)) == null) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        if (z) {
            pdfPRow.setWidths(this.absoluteWidths);
        }
        float maxHeights = pdfPRow.getMaxHeights();
        for (int i3 = 0; i3 < this.relativeWidths.length; i3++) {
            if (rowSpanAbove(i, i3)) {
                int i4 = 1;
                while (true) {
                    i2 = i - i4;
                    if (!rowSpanAbove(i2, i3)) {
                        break;
                    }
                    i4++;
                }
                PdfPCell pdfPCell = this.rows.get(i2).getCells()[i3];
                if (pdfPCell == null || pdfPCell.getRowspan() != i4 + 1) {
                    f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                } else {
                    f = pdfPCell.getMaxHeight();
                    while (i4 > 0) {
                        f -= getRowHeight(i - i4);
                        i4--;
                    }
                }
                if (f > maxHeights) {
                    maxHeights = f;
                }
            }
        }
        pdfPRow.setMaxHeights(maxHeights);
        return maxHeights;
    }

    public float getRowspanHeight(int i, int i2) {
        PdfPRow pdfPRow;
        PdfPCell pdfPCell;
        float f = this.totalWidth;
        float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (f <= ColumnText.GLOBAL_SPACE_CHAR_RATIO || i < 0 || i >= this.rows.size() || (pdfPRow = this.rows.get(i)) == null || i2 >= pdfPRow.getCells().length || (pdfPCell = pdfPRow.getCells()[i2]) == null) {
            return ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        }
        for (int i3 = 0; i3 < pdfPCell.getRowspan(); i3++) {
            f2 += getRowHeight(i + i3);
        }
        return f2;
    }

    public boolean hasRowspan(int i) {
        if (i >= this.rows.size() || !getRow(i).hasRowspan()) {
            for (int i2 = 0; i2 < getNumberOfColumns(); i2++) {
                if (rowSpanAbove(i - 1, i2)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public void normalizeHeadersFooters() {
        int i = this.footerRows;
        int i2 = this.headerRows;
        if (i > i2) {
            this.footerRows = i2;
        }
    }

    public float getHeaderHeight() {
        int min = Math.min(this.rows.size(), this.headerRows);
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (int i = 0; i < min; i++) {
            PdfPRow pdfPRow = this.rows.get(i);
            if (pdfPRow != null) {
                f += pdfPRow.getMaxHeights();
            }
        }
        return f;
    }

    public float getFooterHeight() {
        int min = Math.min(this.rows.size(), this.headerRows);
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (int max = Math.max(0, this.headerRows - this.footerRows); max < min; max++) {
            PdfPRow pdfPRow = this.rows.get(max);
            if (pdfPRow != null) {
                f += pdfPRow.getMaxHeights();
            }
        }
        return f;
    }

    public boolean deleteRow(int i) {
        PdfPRow pdfPRow;
        if (i < 0 || i >= this.rows.size()) {
            return false;
        }
        if (this.totalWidth > ColumnText.GLOBAL_SPACE_CHAR_RATIO && (pdfPRow = this.rows.get(i)) != null) {
            this.totalHeight -= pdfPRow.getMaxHeights();
        }
        this.rows.remove(i);
        int i2 = this.headerRows;
        if (i < i2) {
            this.headerRows = i2 - 1;
            int i3 = this.headerRows;
            int i4 = this.footerRows;
            if (i >= i3 - i4) {
                this.footerRows = i4 - 1;
            }
        }
        return true;
    }

    public boolean deleteLastRow() {
        return deleteRow(this.rows.size() - 1);
    }

    public void deleteBodyRows() {
        ArrayList<PdfPRow> arrayList = new ArrayList<>();
        for (int i = 0; i < this.headerRows; i++) {
            arrayList.add(this.rows.get(i));
        }
        this.rows = arrayList;
        this.totalHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (this.totalWidth > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            this.totalHeight = getHeaderHeight();
        }
    }

    public int getNumberOfColumns() {
        return this.relativeWidths.length;
    }

    public int getHeaderRows() {
        return this.headerRows;
    }

    public void setHeaderRows(int i) {
        if (i < 0) {
            i = 0;
        }
        this.headerRows = i;
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

    public float getWidthPercentage() {
        return this.widthPercentage;
    }

    public void setWidthPercentage(float f) {
        this.widthPercentage = f;
    }

    public int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public void setHorizontalAlignment(int i) {
        this.horizontalAlignment = i;
    }

    public PdfPRow getRow(int i) {
        return this.rows.get(i);
    }

    public ArrayList<PdfPRow> getRows() {
        return this.rows;
    }

    public ArrayList<PdfPRow> getRows(int i, int i2) {
        ArrayList<PdfPRow> arrayList = new ArrayList<>();
        if (i < 0 || i2 > size()) {
            return arrayList;
        }
        while (i < i2) {
            arrayList.add(adjustCellsInRow(i, i2));
            i++;
        }
        return arrayList;
    }

    protected PdfPRow adjustCellsInRow(int i, int i2) {
        PdfPRow pdfPRow = new PdfPRow(getRow(i));
        PdfPCell[] cells = pdfPRow.getCells();
        for (int i3 = 0; i3 < cells.length; i3++) {
            PdfPCell pdfPCell = cells[i3];
            if (pdfPCell != null && pdfPCell.getRowspan() != 1) {
                int min = Math.min(i2, pdfPCell.getRowspan() + i);
                float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                for (int i4 = 1 + i; i4 < min; i4++) {
                    f += getRow(i4).getMaxHeights();
                }
                pdfPRow.setExtraHeight(i3, f);
            }
        }
        return pdfPRow;
    }

    public void setTableEvent(PdfPTableEvent pdfPTableEvent) {
        if (pdfPTableEvent == null) {
            this.tableEvent = null;
            return;
        }
        PdfPTableEvent pdfPTableEvent2 = this.tableEvent;
        if (pdfPTableEvent2 == null) {
            this.tableEvent = pdfPTableEvent;
        } else if (pdfPTableEvent2 instanceof PdfPTableEventForwarder) {
            ((PdfPTableEventForwarder) pdfPTableEvent2).addTableEvent(pdfPTableEvent);
        } else {
            PdfPTableEventForwarder pdfPTableEventForwarder = new PdfPTableEventForwarder();
            pdfPTableEventForwarder.addTableEvent(this.tableEvent);
            pdfPTableEventForwarder.addTableEvent(pdfPTableEvent);
            this.tableEvent = pdfPTableEventForwarder;
        }
    }

    public PdfPTableEvent getTableEvent() {
        return this.tableEvent;
    }

    public float[] getAbsoluteWidths() {
        return this.absoluteWidths;
    }

    float[][] getEventWidths(float f, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i = Math.max(i, this.headerRows);
            i2 = Math.max(i2, this.headerRows);
        }
        int i4 = 0;
        float[][] fArr = new float[((z ? this.headerRows : 0) + i2) - i];
        if (this.isColspan) {
            if (z) {
                i3 = 0;
                while (i4 < this.headerRows) {
                    PdfPRow pdfPRow = this.rows.get(i4);
                    if (pdfPRow == null) {
                        i3++;
                    } else {
                        fArr[i3] = pdfPRow.getEventWidth(f, this.absoluteWidths);
                        i3++;
                    }
                    i4++;
                }
            } else {
                i3 = 0;
            }
            while (i < i2) {
                PdfPRow pdfPRow2 = this.rows.get(i);
                if (pdfPRow2 == null) {
                    i3++;
                } else {
                    fArr[i3] = pdfPRow2.getEventWidth(f, this.absoluteWidths);
                    i3++;
                }
                i++;
            }
        } else {
            int numberOfColumns = getNumberOfColumns();
            float[] fArr2 = new float[numberOfColumns + 1];
            fArr2[0] = f;
            int i5 = 0;
            while (i5 < numberOfColumns) {
                int i6 = i5 + 1;
                fArr2[i6] = fArr2[i5] + this.absoluteWidths[i5];
                i5 = i6;
            }
            while (i4 < fArr.length) {
                fArr[i4] = fArr2;
                i4++;
            }
        }
        return fArr;
    }

    public boolean isSkipFirstHeader() {
        return this.skipFirstHeader;
    }

    public boolean isSkipLastFooter() {
        return this.skipLastFooter;
    }

    public void setSkipFirstHeader(boolean z) {
        this.skipFirstHeader = z;
    }

    public void setSkipLastFooter(boolean z) {
        this.skipLastFooter = z;
    }

    public void setRunDirection(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.runDirection = i;
                return;
            default:
                throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public boolean isLockedWidth() {
        return this.lockedWidth;
    }

    public void setLockedWidth(boolean z) {
        this.lockedWidth = z;
    }

    public boolean isSplitRows() {
        return this.splitRows;
    }

    public void setSplitRows(boolean z) {
        this.splitRows = z;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    public float spacingBefore() {
        return this.spacingBefore;
    }

    public float spacingAfter() {
        return this.spacingAfter;
    }

    public boolean isExtendLastRow() {
        return this.extendLastRow[0];
    }

    public void setExtendLastRow(boolean z) {
        boolean[] zArr = this.extendLastRow;
        zArr[0] = z;
        zArr[1] = z;
    }

    public void setExtendLastRow(boolean z, boolean z2) {
        boolean[] zArr = this.extendLastRow;
        zArr[0] = z;
        zArr[1] = z2;
    }

    public boolean isExtendLastRow(boolean z) {
        if (z) {
            return this.extendLastRow[0];
        }
        return this.extendLastRow[1];
    }

    public boolean isHeadersInEvent() {
        return this.headersInEvent;
    }

    public void setHeadersInEvent(boolean z) {
        this.headersInEvent = z;
    }

    public boolean isSplitLate() {
        return this.splitLate;
    }

    public void setSplitLate(boolean z) {
        this.splitLate = z;
    }

    public void setKeepTogether(boolean z) {
        this.keepTogether = z;
    }

    public boolean getKeepTogether() {
        return this.keepTogether;
    }

    public int getFooterRows() {
        return this.footerRows;
    }

    public void setFooterRows(int i) {
        if (i < 0) {
            i = 0;
        }
        this.footerRows = i;
    }

    public void completeRow() {
        while (!this.rowCompleted) {
            addCell(this.defaultCell);
        }
    }

    @Override // com.itextpdf.text.LargeElement
    public void flushContent() {
        deleteBodyRows();
        setSkipFirstHeader(true);
    }

    @Override // com.itextpdf.text.LargeElement
    public boolean isComplete() {
        return this.complete;
    }

    @Override // com.itextpdf.text.LargeElement
    public void setComplete(boolean z) {
        this.complete = z;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingAfter() {
        return this.spacingAfter;
    }
}
