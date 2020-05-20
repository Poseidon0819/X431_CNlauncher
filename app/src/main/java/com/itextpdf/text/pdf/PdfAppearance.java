package com.itextpdf.text.pdf;

import com.itextpdf.text.Rectangle;
import java.util.HashMap;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public class PdfAppearance extends PdfTemplate {
    public static final HashMap<String, PdfName> stdFieldFontNames;

    static {
        HashMap<String, PdfName> hashMap = new HashMap<>();
        stdFieldFontNames = hashMap;
        hashMap.put("Courier-BoldOblique", new PdfName("CoBO"));
        stdFieldFontNames.put("Courier-Bold", new PdfName("CoBo"));
        stdFieldFontNames.put("Courier-Oblique", new PdfName("CoOb"));
        stdFieldFontNames.put("Courier", new PdfName("Cour"));
        stdFieldFontNames.put("Helvetica-BoldOblique", new PdfName("HeBO"));
        stdFieldFontNames.put("Helvetica-Bold", new PdfName("HeBo"));
        stdFieldFontNames.put("Helvetica-Oblique", new PdfName("HeOb"));
        stdFieldFontNames.put("Helvetica", PdfName.HELV);
        stdFieldFontNames.put("Symbol", new PdfName("Symb"));
        stdFieldFontNames.put("Times-BoldItalic", new PdfName("TiBI"));
        stdFieldFontNames.put("Times-Bold", new PdfName("TiBo"));
        stdFieldFontNames.put("Times-Italic", new PdfName("TiIt"));
        stdFieldFontNames.put("Times-Roman", new PdfName("TiRo"));
        stdFieldFontNames.put("ZapfDingbats", PdfName.ZADB);
        stdFieldFontNames.put("HYSMyeongJo-Medium", new PdfName("HySm"));
        stdFieldFontNames.put("HYGoThic-Medium", new PdfName("HyGo"));
        stdFieldFontNames.put("HeiseiKakuGo-W5", new PdfName("KaGo"));
        stdFieldFontNames.put("HeiseiMin-W3", new PdfName("KaMi"));
        stdFieldFontNames.put("MHei-Medium", new PdfName("MHei"));
        stdFieldFontNames.put("MSung-Light", new PdfName("MSun"));
        stdFieldFontNames.put("STSong-Light", new PdfName("STSo"));
        stdFieldFontNames.put("MSungStd-Light", new PdfName("MSun"));
        stdFieldFontNames.put("STSongStd-Light", new PdfName("STSo"));
        stdFieldFontNames.put("HYSMyeongJoStd-Medium", new PdfName("HySm"));
        stdFieldFontNames.put("KozMinPro-Regular", new PdfName("KaMi"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfAppearance() {
        this.separator = 32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfAppearance(PdfIndirectReference pdfIndirectReference) {
        this.thisReference = pdfIndirectReference;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfAppearance(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.separator = 32;
    }

    public static PdfAppearance createAppearance(PdfWriter pdfWriter, float f, float f2) {
        return createAppearance(pdfWriter, f, f2, null);
    }

    static PdfAppearance createAppearance(PdfWriter pdfWriter, float f, float f2, PdfName pdfName) {
        PdfAppearance pdfAppearance = new PdfAppearance(pdfWriter);
        pdfAppearance.setWidth(f);
        pdfAppearance.setHeight(f2);
        pdfWriter.addDirectTemplateSimple(pdfAppearance, pdfName);
        return pdfAppearance;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public void setFontAndSize(BaseFont baseFont, float f) {
        checkWriter();
        this.state.size = f;
        if (baseFont.getFontType() == 4) {
            this.state.fontDetails = new FontDetails(null, ((DocumentFont) baseFont).getIndirectReference(), baseFont);
        } else {
            this.state.fontDetails = this.writer.addSimple(baseFont);
        }
        PdfName pdfName = stdFieldFontNames.get(baseFont.getPostscriptFontName());
        if (pdfName == null) {
            if (baseFont.isSubset() && baseFont.getFontType() == 3) {
                pdfName = this.state.fontDetails.getFontName();
            } else {
                pdfName = new PdfName(baseFont.getPostscriptFontName());
                this.state.fontDetails.setSubset(false);
            }
        }
        getPageResources().addFont(pdfName, this.state.fontDetails.getIndirectReference());
        this.content.append(pdfName.getBytes()).append(TokenParser.f24154SP).append(f).append(" Tf").append_i(this.separator);
    }

    @Override // com.itextpdf.text.pdf.PdfTemplate, com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        PdfAppearance pdfAppearance = new PdfAppearance();
        pdfAppearance.writer = this.writer;
        pdfAppearance.pdf = this.pdf;
        pdfAppearance.thisReference = this.thisReference;
        pdfAppearance.pageResources = this.pageResources;
        pdfAppearance.bBox = new Rectangle(this.bBox);
        pdfAppearance.group = this.group;
        pdfAppearance.layer = this.layer;
        if (this.matrix != null) {
            pdfAppearance.matrix = new PdfArray(this.matrix);
        }
        pdfAppearance.separator = this.separator;
        return pdfAppearance;
    }
}
