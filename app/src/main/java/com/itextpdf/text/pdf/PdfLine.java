package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PdfLine {
    protected int alignment;
    protected float height;
    protected boolean isRTL;
    protected float left;
    protected ArrayList<PdfChunk> line;
    protected Chunk listSymbol;
    protected boolean newlineSplit;
    protected float originalWidth;
    protected float symbolIndent;
    protected float width;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfLine(float f, float f2, int i, float f3) {
        this.listSymbol = null;
        this.newlineSplit = false;
        this.isRTL = false;
        this.left = f;
        this.width = f2 - f;
        this.originalWidth = this.width;
        this.alignment = i;
        this.height = f3;
        this.line = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfLine(float f, float f2, float f3, int i, boolean z, ArrayList<PdfChunk> arrayList, boolean z2) {
        this.listSymbol = null;
        this.newlineSplit = false;
        this.isRTL = false;
        this.left = f;
        this.originalWidth = f2;
        this.width = f3;
        this.alignment = i;
        this.line = arrayList;
        this.newlineSplit = z;
        this.isRTL = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfChunk add(PdfChunk pdfChunk) {
        if (pdfChunk == null || pdfChunk.toString().equals("")) {
            return null;
        }
        PdfChunk split = pdfChunk.split(this.width);
        this.newlineSplit = pdfChunk.isNewlineSplit() || split == null;
        if (pdfChunk.isTab()) {
            Object[] objArr = (Object[]) pdfChunk.getAttribute(Chunk.TAB);
            float floatValue = ((Float) objArr[1]).floatValue();
            if (((Boolean) objArr[2]).booleanValue() && floatValue < this.originalWidth - this.width) {
                return pdfChunk;
            }
            this.width = this.originalWidth - floatValue;
            pdfChunk.adjustLeft(this.left);
            addToLine(pdfChunk);
        } else if (pdfChunk.length() > 0 || pdfChunk.isImage()) {
            if (split != null) {
                pdfChunk.trimLastSpace();
            }
            this.width -= pdfChunk.width();
            addToLine(pdfChunk);
        } else if (this.line.size() <= 0) {
            PdfChunk truncate = split.truncate(this.width);
            this.width -= split.width();
            if (split.length() > 0) {
                addToLine(split);
                return truncate;
            }
            if (truncate != null) {
                addToLine(truncate);
            }
            return null;
        } else {
            float f = this.width;
            ArrayList<PdfChunk> arrayList = this.line;
            this.width = f + arrayList.get(arrayList.size() - 1).trimLastSpace();
        }
        return split;
    }

    private void addToLine(PdfChunk pdfChunk) {
        float leading;
        if (pdfChunk.changeLeading) {
            if (pdfChunk.isImage()) {
                Image image = pdfChunk.getImage();
                leading = image.getScaledHeight() + pdfChunk.getImageOffsetY() + image.getBorderWidthTop() + image.getSpacingBefore();
            } else {
                leading = pdfChunk.getLeading();
            }
            if (leading > this.height) {
                this.height = leading;
            }
        }
        this.line.add(pdfChunk);
    }

    public int size() {
        return this.line.size();
    }

    public Iterator<PdfChunk> iterator() {
        return this.line.iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float height() {
        return this.height;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float indentLeft() {
        if (this.isRTL) {
            switch (this.alignment) {
                case 0:
                    return this.left + this.width;
                case 1:
                    return this.left + (this.width / 2.0f);
                default:
                    return this.left;
            }
        }
        if (getSeparatorCount() <= 0) {
            switch (this.alignment) {
                case 1:
                    return this.left + (this.width / 2.0f);
                case 2:
                    return this.left + this.width;
            }
        }
        return this.left;
    }

    public boolean hasToBeJustified() {
        int i = this.alignment;
        return (i == 3 || i == 8) && this.width != ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public void resetAlignment() {
        if (this.alignment == 3) {
            this.alignment = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExtraIndent(float f) {
        this.left += f;
        this.width -= f;
        this.originalWidth -= f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float widthLeft() {
        return this.width;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int numberOfSpaces() {
        String pdfLine = toString();
        int length = pdfLine.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (pdfLine.charAt(i2) == ' ') {
                i++;
            }
        }
        return i;
    }

    public void setListItem(ListItem listItem) {
        this.listSymbol = listItem.getListSymbol();
        this.symbolIndent = listItem.getIndentationLeft();
    }

    public Chunk listSymbol() {
        return this.listSymbol;
    }

    public float listIndent() {
        return this.symbolIndent;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<PdfChunk> it = this.line.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        return stringBuffer.toString();
    }

    public int getLineLengthUtf32() {
        Iterator<PdfChunk> it = this.line.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().lengthUtf32();
        }
        return i;
    }

    public boolean isNewlineSplit() {
        return this.newlineSplit && this.alignment != 8;
    }

    public int getLastStrokeChunk() {
        int size = this.line.size() - 1;
        while (size >= 0 && !this.line.get(size).isStroked()) {
            size--;
        }
        return size;
    }

    public PdfChunk getChunk(int i) {
        if (i < 0 || i >= this.line.size()) {
            return null;
        }
        return this.line.get(i);
    }

    public float getOriginalWidth() {
        return this.originalWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] getMaxSize(float f, float f2) {
        float f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float f4 = -10000.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = this.line.get(i);
            if (!pdfChunk.isImage()) {
                if (pdfChunk.changeLeading()) {
                    f3 = Math.max(pdfChunk.getLeading(), f3);
                } else {
                    f3 = Math.max((pdfChunk.font().size() * f2) + f, f3);
                }
            } else {
                Image image = pdfChunk.getImage();
                if (pdfChunk.changeLeading()) {
                    f4 = Math.max(image.getScaledHeight() + pdfChunk.getImageOffsetY() + image.getSpacingBefore(), f4);
                }
            }
        }
        float[] fArr = new float[2];
        if (f3 > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            f = f3;
        }
        fArr[0] = f;
        fArr[1] = f4;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isRTL() {
        return this.isRTL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSeparatorCount() {
        Iterator<PdfChunk> it = this.line.iterator();
        int i = 0;
        while (it.hasNext()) {
            PdfChunk next = it.next();
            if (next.isTab()) {
                return -1;
            }
            if (next.isHorizontalSeparator()) {
                i++;
            }
        }
        return i;
    }

    public float getWidthCorrected(float f, float f2) {
        float f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (int i = 0; i < this.line.size(); i++) {
            f3 += this.line.get(i).getWidthCorrected(f, f2);
        }
        return f3;
    }

    public float getAscender() {
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = this.line.get(i);
            if (pdfChunk.isImage()) {
                f = Math.max(f, pdfChunk.getImage().getScaledHeight() + pdfChunk.getImageOffsetY());
            } else {
                PdfFont font = pdfChunk.font();
                float textRise = pdfChunk.getTextRise();
                if (textRise <= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    textRise = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                }
                f = Math.max(f, textRise + font.getFont().getFontDescriptor(1, font.size()));
            }
        }
        return f;
    }

    public float getDescender() {
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = this.line.get(i);
            if (pdfChunk.isImage()) {
                f = Math.min(f, pdfChunk.getImageOffsetY());
            } else {
                PdfFont font = pdfChunk.font();
                float textRise = pdfChunk.getTextRise();
                if (textRise >= ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                    textRise = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                }
                f = Math.min(f, textRise + font.getFont().getFontDescriptor(3, font.size()));
            }
        }
        return f;
    }
}
