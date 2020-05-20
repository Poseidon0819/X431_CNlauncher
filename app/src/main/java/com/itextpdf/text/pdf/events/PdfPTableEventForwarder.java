package com.itextpdf.text.pdf.events;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.PdfPTableEventSplit;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class PdfPTableEventForwarder implements PdfPTableEventSplit {
    protected ArrayList<PdfPTableEvent> events = new ArrayList<>();

    public void addTableEvent(PdfPTableEvent pdfPTableEvent) {
        this.events.add(pdfPTableEvent);
    }

    @Override // com.itextpdf.text.pdf.PdfPTableEvent
    public void tableLayout(PdfPTable pdfPTable, float[][] fArr, float[] fArr2, int i, int i2, PdfContentByte[] pdfContentByteArr) {
        Iterator<PdfPTableEvent> it = this.events.iterator();
        while (it.hasNext()) {
            it.next().tableLayout(pdfPTable, fArr, fArr2, i, i2, pdfContentByteArr);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfPTableEventSplit
    public void splitTable(PdfPTable pdfPTable) {
        Iterator<PdfPTableEvent> it = this.events.iterator();
        while (it.hasNext()) {
            PdfPTableEvent next = it.next();
            if (next instanceof PdfPTableEventSplit) {
                ((PdfPTableEventSplit) next).splitTable(pdfPTable);
            }
        }
    }
}
