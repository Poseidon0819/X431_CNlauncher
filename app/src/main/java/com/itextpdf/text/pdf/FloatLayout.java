package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.PdfDiv;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FloatLayout {
    protected final ColumnText compositeColumn;
    protected final List<Element> content;
    protected float filledWidth;
    protected float floatLeftX;
    protected float floatRightX;
    protected float leftX;
    protected float maxY;
    protected float minY;
    protected float rightX;
    protected float yLine;

    public float getYLine() {
        return this.yLine;
    }

    public void setYLine(float f) {
        this.yLine = f;
    }

    public float getFilledWidth() {
        return this.filledWidth;
    }

    public void setFilledWidth(float f) {
        this.filledWidth = f;
    }

    public FloatLayout(ColumnText columnText, List<Element> list) {
        this.compositeColumn = ColumnText.duplicate(columnText);
        this.content = list;
    }

    public FloatLayout(PdfContentByte pdfContentByte, List<Element> list) {
        this.compositeColumn = new ColumnText(pdfContentByte);
        this.compositeColumn.setUseAscender(false);
        this.content = list;
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4) {
        this.leftX = Math.min(f, f3);
        this.maxY = Math.max(f2, f4);
        this.minY = Math.min(f2, f4);
        this.rightX = Math.max(f, f3);
        this.floatLeftX = this.leftX;
        this.floatRightX = this.rightX;
        this.yLine = this.maxY;
        this.filledWidth = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public int layout(boolean z) throws DocumentException {
        this.filledWidth = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        ArrayList arrayList = new ArrayList();
        List arrayList2 = z ? new ArrayList(this.content) : this.content;
        ColumnText duplicate = z ? ColumnText.duplicate(this.compositeColumn) : this.compositeColumn;
        int i = 1;
        while (true) {
            if (arrayList2.isEmpty()) {
                break;
            } else if (arrayList2.get(0) instanceof PdfDiv) {
                PdfDiv pdfDiv = (PdfDiv) arrayList2.get(0);
                if (pdfDiv.getFloatType() == PdfDiv.FloatType.LEFT || pdfDiv.getFloatType() == PdfDiv.FloatType.RIGHT) {
                    arrayList.add(pdfDiv);
                    arrayList2.remove(0);
                } else {
                    if (!arrayList.isEmpty()) {
                        i = floatingLayout(duplicate, arrayList, z);
                        if ((i & 1) == 0) {
                            break;
                        }
                    }
                    arrayList2.remove(0);
                    i = pdfDiv.layout(duplicate, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    if (!z) {
                        i = pdfDiv.layout(duplicate, z, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    }
                    this.yLine -= pdfDiv.getActualHeight();
                    if (pdfDiv.getActualWidth() > this.filledWidth) {
                        this.filledWidth = pdfDiv.getActualWidth();
                    }
                    if ((i & 1) == 0) {
                        arrayList2.add(0, pdfDiv);
                        break;
                    }
                }
            } else {
                arrayList.add(arrayList2.get(0));
                arrayList2.remove(0);
            }
        }
        if ((i & 1) != 0 && !arrayList.isEmpty()) {
            i = floatingLayout(duplicate, arrayList, z);
        }
        arrayList2.addAll(0, arrayList);
        return i;
    }

    private int floatingLayout(ColumnText columnText, List<Element> list, boolean z) throws DocumentException {
        PdfDiv pdfDiv;
        PdfDiv pdfDiv2;
        int i = 1;
        float f = this.yLine;
        float f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        float f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        while (true) {
            if (list.isEmpty()) {
                break;
            } else if (list.get(0) instanceof PdfDiv) {
                PdfDiv pdfDiv3 = (PdfDiv) list.get(0);
                list.remove(0);
                int layout = pdfDiv3.layout(columnText, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                if ((layout & 1) == 0) {
                    this.yLine = f;
                    this.floatLeftX = this.leftX;
                    this.floatRightX = this.rightX;
                    i = pdfDiv3.layout(columnText, true, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    if ((i & 1) == 0) {
                        list.add(0, pdfDiv3);
                        break;
                    }
                    pdfDiv = pdfDiv3;
                    layout = i;
                } else {
                    pdfDiv = pdfDiv3;
                }
                if (pdfDiv.getFloatType() == PdfDiv.FloatType.LEFT) {
                    pdfDiv2 = pdfDiv;
                    layout = pdfDiv.layout(columnText, z, this.floatLeftX, this.minY, this.floatRightX, this.yLine);
                    this.floatLeftX += pdfDiv2.getActualWidth();
                    f2 += pdfDiv2.getActualWidth();
                } else {
                    pdfDiv2 = pdfDiv;
                    if (pdfDiv2.getFloatType() == PdfDiv.FloatType.RIGHT) {
                        layout = pdfDiv2.layout(columnText, z, (this.floatRightX - pdfDiv2.getActualWidth()) - 0.01f, this.minY, this.floatRightX, this.yLine);
                        this.floatRightX -= pdfDiv2.getActualWidth();
                        f3 += pdfDiv2.getActualWidth();
                    }
                }
                i = layout;
                f = Math.min(f, this.yLine - pdfDiv2.getActualHeight());
            } else {
                Element element = list.get(0);
                if (element instanceof Spaceable) {
                    this.yLine -= ((Spaceable) element).getSpacingBefore();
                }
                columnText.addElement(element);
                list.remove(0);
                float f4 = this.yLine;
                if (f4 > f) {
                    columnText.setSimpleColumn(this.floatLeftX, f4, this.floatRightX, f);
                } else {
                    columnText.setSimpleColumn(this.floatLeftX, f4, this.floatRightX, this.minY);
                }
                columnText.setFilledWidth(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                int m2715go = columnText.m2715go(z);
                if (this.yLine > f && ((this.floatLeftX > this.leftX || this.floatRightX < this.rightX) && (m2715go & 1) == 0)) {
                    this.yLine = f;
                    float f5 = this.leftX;
                    this.floatLeftX = f5;
                    float f6 = this.rightX;
                    this.floatRightX = f6;
                    if (f2 != ColumnText.GLOBAL_SPACE_CHAR_RATIO && f3 != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                        this.filledWidth = f6 - f5;
                    } else {
                        if (f2 > this.filledWidth) {
                            this.filledWidth = f2;
                        }
                        if (f3 > this.filledWidth) {
                            this.filledWidth = f3;
                        }
                    }
                    columnText.setSimpleColumn(this.floatLeftX, this.yLine, this.floatRightX, this.minY);
                    int m2715go2 = columnText.m2715go(z);
                    float yLine = columnText.getYLine() + columnText.getDescender();
                    this.yLine = yLine;
                    if (columnText.getFilledWidth() > this.filledWidth) {
                        this.filledWidth = columnText.getFilledWidth();
                    }
                    f = yLine;
                    f2 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    f3 = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                    i = m2715go2;
                } else {
                    if (f3 > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                        f3 += columnText.getFilledWidth();
                    } else if (f2 > ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
                        f2 += columnText.getFilledWidth();
                    } else if (columnText.getFilledWidth() > this.filledWidth) {
                        this.filledWidth = columnText.getFilledWidth();
                    }
                    float min = Math.min(columnText.getYLine() + columnText.getDescender(), f);
                    this.yLine = columnText.getYLine() + columnText.getDescender();
                    f = min;
                    i = m2715go;
                }
                if ((i & 1) == 0) {
                    list.addAll(0, columnText.getCompositeElements());
                    columnText.getCompositeElements().clear();
                    break;
                }
                columnText.getCompositeElements().clear();
            }
        }
        if (f2 != ColumnText.GLOBAL_SPACE_CHAR_RATIO && f3 != ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            this.filledWidth = this.rightX - this.leftX;
        } else {
            if (f2 > this.filledWidth) {
                this.filledWidth = f2;
            }
            if (f3 > this.filledWidth) {
                this.filledWidth = f3;
            }
        }
        this.yLine = f;
        this.floatLeftX = this.leftX;
        this.floatRightX = this.rightX;
        return i;
    }
}
