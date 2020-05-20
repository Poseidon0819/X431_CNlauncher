package com.itextpdf.text.pdf.draw;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VerticalPositionMark implements Element, DrawInterface {
    protected DrawInterface drawInterface;
    protected float offset;

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
        return 55;
    }

    public VerticalPositionMark() {
        this.drawInterface = null;
        this.offset = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public VerticalPositionMark(DrawInterface drawInterface, float f) {
        this.drawInterface = null;
        this.offset = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.drawInterface = drawInterface;
        this.offset = f;
    }

    public void draw(PdfContentByte pdfContentByte, float f, float f2, float f3, float f4, float f5) {
        DrawInterface drawInterface = this.drawInterface;
        if (drawInterface != null) {
            drawInterface.draw(pdfContentByte, f, f2, f3, f4, f5 + this.offset);
        }
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
    public List<Chunk> getChunks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Chunk((DrawInterface) this, true));
        return arrayList;
    }

    public DrawInterface getDrawInterface() {
        return this.drawInterface;
    }

    public void setDrawInterface(DrawInterface drawInterface) {
        this.drawInterface = drawInterface;
    }

    public float getOffset() {
        return this.offset;
    }

    public void setOffset(float f) {
        this.offset = f;
    }
}
