package com.itextpdf.text.pdf.parser;

/* loaded from: classes.dex */
public class SimpleTextExtractionStrategy implements TextExtractionStrategy {
    private Vector lastEnd;
    private Vector lastStart;
    private final StringBuffer result = new StringBuffer();

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void beginTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void endTextBlock() {
    }

    @Override // com.itextpdf.text.pdf.parser.RenderListener
    public void renderImage(ImageRenderInfo imageRenderInfo) {
    }

    @Override // com.itextpdf.text.pdf.parser.TextExtractionStrategy
    public String getResultantText() {
        return this.result.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    @Override // com.itextpdf.text.pdf.parser.RenderListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void renderText(com.itextpdf.text.pdf.parser.TextRenderInfo r10) {
        /*
            r9 = this;
            java.lang.StringBuffer r0 = r9.result
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            com.itextpdf.text.pdf.parser.LineSegment r3 = r10.getBaseline()
            com.itextpdf.text.pdf.parser.Vector r4 = r3.getStartPoint()
            com.itextpdf.text.pdf.parser.Vector r3 = r3.getEndPoint()
            if (r0 != 0) goto L40
            com.itextpdf.text.pdf.parser.Vector r5 = r9.lastStart
            com.itextpdf.text.pdf.parser.Vector r6 = r9.lastEnd
            com.itextpdf.text.pdf.parser.Vector r7 = r6.subtract(r5)
            com.itextpdf.text.pdf.parser.Vector r8 = r5.subtract(r4)
            com.itextpdf.text.pdf.parser.Vector r7 = r7.cross(r8)
            float r7 = r7.lengthSquared()
            com.itextpdf.text.pdf.parser.Vector r5 = r6.subtract(r5)
            float r5 = r5.lengthSquared()
            float r7 = r7 / r5
            r5 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 <= 0) goto L40
            r5 = 1
            goto L41
        L40:
            r5 = 0
        L41:
            if (r5 == 0) goto L4b
            java.lang.StringBuffer r0 = r9.result
            r1 = 10
            r0.append(r1)
            goto L8a
        L4b:
            if (r0 != 0) goto L8a
            java.lang.StringBuffer r0 = r9.result
            int r5 = r0.length()
            int r5 = r5 - r1
            char r0 = r0.charAt(r5)
            r1 = 32
            if (r0 == r1) goto L8a
            java.lang.String r0 = r10.getText()
            int r0 = r0.length()
            if (r0 <= 0) goto L8a
            java.lang.String r0 = r10.getText()
            char r0 = r0.charAt(r2)
            if (r0 == r1) goto L8a
            com.itextpdf.text.pdf.parser.Vector r0 = r9.lastEnd
            com.itextpdf.text.pdf.parser.Vector r0 = r0.subtract(r4)
            float r0 = r0.length()
            float r2 = r10.getSingleSpaceWidth()
            r5 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r5
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L8a
            java.lang.StringBuffer r0 = r9.result
            r0.append(r1)
        L8a:
            java.lang.StringBuffer r0 = r9.result
            java.lang.String r10 = r10.getText()
            r0.append(r10)
            r9.lastStart = r4
            r9.lastEnd = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy.renderText(com.itextpdf.text.pdf.parser.TextRenderInfo):void");
    }
}
