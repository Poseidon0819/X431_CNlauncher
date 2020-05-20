package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class TableWrapper implements Element {
    private float[] colWidths;
    private final Map<String, String> styles = new HashMap();
    private final List<List<PdfPCell>> rows = new ArrayList();

    @Override // com.itextpdf.text.Element
    public List<Chunk> getChunks() {
        return null;
    }

    @Override // com.itextpdf.text.Element
    public boolean isContent() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public boolean isNestable() {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        return false;
    }

    @Override // com.itextpdf.text.Element
    public int type() {
        return 0;
    }

    public TableWrapper(Map<String, String> map) {
        this.styles.putAll(map);
    }

    public void addRow(List<PdfPCell> list) {
        if (list != null) {
            Collections.reverse(list);
            this.rows.add(list);
        }
    }

    public void setColWidths(float[] fArr) {
        this.colWidths = fArr;
    }

    public PdfPTable createTable() {
        if (this.rows.isEmpty()) {
            return new PdfPTable(1);
        }
        int i = 0;
        for (PdfPCell pdfPCell : this.rows.get(0)) {
            i += pdfPCell.getColspan();
        }
        PdfPTable pdfPTable = new PdfPTable(i);
        String str = this.styles.get("width");
        if (str == null) {
            pdfPTable.setWidthPercentage(100.0f);
        } else if (str.endsWith("%")) {
            pdfPTable.setWidthPercentage(Float.parseFloat(str.substring(0, str.length() - 1)));
        } else {
            pdfPTable.setTotalWidth(Float.parseFloat(str));
            pdfPTable.setLockedWidth(true);
        }
        String str2 = this.styles.get(HtmlTags.ALIGN);
        pdfPTable.setHorizontalAlignment(str2 != null ? HtmlUtilities.alignmentValue(str2) : 0);
        try {
            if (this.colWidths != null) {
                pdfPTable.setWidths(this.colWidths);
            }
        } catch (Exception unused) {
        }
        for (List<PdfPCell> list : this.rows) {
            for (PdfPCell pdfPCell2 : list) {
                pdfPTable.addCell(pdfPCell2);
            }
        }
        return pdfPTable;
    }
}
