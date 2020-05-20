package com.itextpdf.text.pdf;

import com.itextpdf.text.Rectangle;

/* loaded from: classes.dex */
public class PdfRectangle extends NumberArray {
    private float llx;
    private float lly;
    private float urx;
    private float ury;

    @Override // com.itextpdf.text.pdf.PdfArray
    public boolean add(PdfObject pdfObject) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.PdfArray
    public boolean add(float[] fArr) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.PdfArray
    public boolean add(int[] iArr) {
        return false;
    }

    @Override // com.itextpdf.text.pdf.PdfArray
    public void addFirst(PdfObject pdfObject) {
    }

    public PdfRectangle(float f, float f2, float f3, float f4, int i) {
        super(new float[0]);
        this.llx = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.lly = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.urx = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.ury = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        if (i == 90 || i == 270) {
            this.llx = f2;
            this.lly = f;
            this.urx = f4;
            this.ury = f3;
        } else {
            this.llx = f;
            this.lly = f2;
            this.urx = f3;
            this.ury = f4;
        }
        super.add(new PdfNumber(this.llx));
        super.add(new PdfNumber(this.lly));
        super.add(new PdfNumber(this.urx));
        super.add(new PdfNumber(this.ury));
    }

    public PdfRectangle(float f, float f2, float f3, float f4) {
        this(f, f2, f3, f4, 0);
    }

    public PdfRectangle(float f, float f2, int i) {
        this(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2, i);
    }

    public PdfRectangle(float f, float f2) {
        this(ColumnText.GLOBAL_SPACE_CHAR_RATIO, ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, f2, 0);
    }

    public PdfRectangle(Rectangle rectangle, int i) {
        this(rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), i);
    }

    public PdfRectangle(Rectangle rectangle) {
        this(rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), 0);
    }

    public Rectangle getRectangle() {
        return new Rectangle(left(), bottom(), right(), top());
    }

    public float left() {
        return this.llx;
    }

    public float right() {
        return this.urx;
    }

    public float top() {
        return this.ury;
    }

    public float bottom() {
        return this.lly;
    }

    public float left(int i) {
        return this.llx + i;
    }

    public float right(int i) {
        return this.urx - i;
    }

    public float top(int i) {
        return this.ury - i;
    }

    public float bottom(int i) {
        return this.lly + i;
    }

    public float width() {
        return this.urx - this.llx;
    }

    public float height() {
        return this.ury - this.lly;
    }

    public PdfRectangle rotate() {
        return new PdfRectangle(this.lly, this.llx, this.ury, this.urx, 0);
    }
}
