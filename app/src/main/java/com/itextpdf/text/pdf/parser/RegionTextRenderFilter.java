package com.itextpdf.text.pdf.parser;

import com.itextpdf.p349a.p350a.Rectangle2D;
import com.itextpdf.text.Rectangle;

/* loaded from: classes.dex */
public class RegionTextRenderFilter extends RenderFilter {
    private final Rectangle2D filterRect;

    public RegionTextRenderFilter(Rectangle2D rectangle2D) {
        this.filterRect = rectangle2D;
    }

    public RegionTextRenderFilter(Rectangle rectangle) {
        this.filterRect = new com.itextpdf.p349a.p350a.Rectangle(rectangle);
    }

    @Override // com.itextpdf.text.pdf.parser.RenderFilter
    public boolean allowText(TextRenderInfo textRenderInfo) {
        LineSegment baseline = textRenderInfo.getBaseline();
        Vector startPoint = baseline.getStartPoint();
        Vector endPoint = baseline.getEndPoint();
        return this.filterRect.intersectsLine(startPoint.get(0), startPoint.get(1), endPoint.get(0), endPoint.get(1));
    }
}
