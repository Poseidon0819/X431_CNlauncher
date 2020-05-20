package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class Paragraph extends Phrase implements Indentable, Spaceable {
    private static final long serialVersionUID = 7852314969733375514L;
    protected int alignment;
    private float extraParagraphSpace;
    private float firstLineIndent;
    protected float indentationLeft;
    protected float indentationRight;
    protected boolean keeptogether;
    protected float multipliedLeading;
    protected float spacingAfter;
    protected float spacingBefore;

    @Override // com.itextpdf.text.Phrase, com.itextpdf.text.Element
    public int type() {
        return 12;
    }

    public Paragraph() {
        this.alignment = -1;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.firstLineIndent = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.extraParagraphSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.keeptogether = false;
    }

    public Paragraph(float f) {
        super(f);
        this.alignment = -1;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.firstLineIndent = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.extraParagraphSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.keeptogether = false;
    }

    public Paragraph(Chunk chunk) {
        super(chunk);
        this.alignment = -1;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.firstLineIndent = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.extraParagraphSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.keeptogether = false;
    }

    public Paragraph(float f, Chunk chunk) {
        super(f, chunk);
        this.alignment = -1;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.firstLineIndent = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.extraParagraphSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.keeptogether = false;
    }

    public Paragraph(String str) {
        super(str);
        this.alignment = -1;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.firstLineIndent = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.extraParagraphSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.keeptogether = false;
    }

    public Paragraph(String str, Font font) {
        super(str, font);
        this.alignment = -1;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.firstLineIndent = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.extraParagraphSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.keeptogether = false;
    }

    public Paragraph(float f, String str) {
        super(f, str);
        this.alignment = -1;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.firstLineIndent = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.extraParagraphSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.keeptogether = false;
    }

    public Paragraph(float f, String str, Font font) {
        super(f, str, font);
        this.alignment = -1;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.firstLineIndent = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.extraParagraphSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.keeptogether = false;
    }

    public Paragraph(Phrase phrase) {
        super(phrase);
        this.alignment = -1;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.firstLineIndent = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.extraParagraphSpace = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.keeptogether = false;
        if (phrase instanceof Paragraph) {
            Paragraph paragraph = (Paragraph) phrase;
            setAlignment(paragraph.alignment);
            setLeading(phrase.getLeading(), paragraph.multipliedLeading);
            setIndentationLeft(paragraph.getIndentationLeft());
            setIndentationRight(paragraph.getIndentationRight());
            setFirstLineIndent(paragraph.getFirstLineIndent());
            setSpacingAfter(paragraph.getSpacingAfter());
            setSpacingBefore(paragraph.getSpacingBefore());
            setExtraParagraphSpace(paragraph.getExtraParagraphSpace());
        }
    }

    public Paragraph cloneShallow(boolean z) {
        Paragraph paragraph = new Paragraph();
        paragraph.setFont(getFont());
        paragraph.setAlignment(getAlignment());
        paragraph.setLeading(getLeading(), this.multipliedLeading);
        paragraph.setIndentationLeft(getIndentationLeft());
        paragraph.setIndentationRight(getIndentationRight());
        paragraph.setFirstLineIndent(getFirstLineIndent());
        paragraph.setSpacingAfter(getSpacingAfter());
        if (z) {
            paragraph.setSpacingBefore(getSpacingBefore());
        }
        paragraph.setExtraParagraphSpace(getExtraParagraphSpace());
        return paragraph;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r2.size() <= 0) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        r2.setSpacingAfter(com.itextpdf.text.pdf.ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        r0.add(r2);
        r2 = cloneShallow(false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.itextpdf.text.Element> breakUp() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r10.iterator()
            r2 = 0
        La:
            boolean r3 = r1.hasNext()
            r4 = 1
            r5 = 12
            r6 = 23
            r7 = 14
            if (r3 == 0) goto L92
            java.lang.Object r3 = r1.next()
            com.itextpdf.text.Element r3 = (com.itextpdf.text.Element) r3
            int r8 = r3.type()
            r9 = 0
            if (r8 == r7) goto L43
            int r8 = r3.type()
            if (r8 == r6) goto L43
            int r8 = r3.type()
            if (r8 != r5) goto L31
            goto L43
        L31:
            if (r2 != 0) goto L3f
            int r2 = r0.size()
            if (r2 != 0) goto L3a
            goto L3b
        L3a:
            r4 = 0
        L3b:
            com.itextpdf.text.Paragraph r2 = r10.cloneShallow(r4)
        L3f:
            r2.add(r3)
            goto La
        L43:
            if (r2 == 0) goto L56
            int r4 = r2.size()
            if (r4 <= 0) goto L56
            r4 = 0
            r2.setSpacingAfter(r4)
            r0.add(r2)
            com.itextpdf.text.Paragraph r2 = r10.cloneShallow(r9)
        L56:
            int r4 = r0.size()
            if (r4 != 0) goto L8d
            int r4 = r3.type()
            if (r4 == r5) goto L83
            if (r4 == r7) goto L72
            if (r4 == r6) goto L67
            goto L8d
        L67:
            r4 = r3
            com.itextpdf.text.pdf.PdfPTable r4 = (com.itextpdf.text.pdf.PdfPTable) r4
            float r5 = r10.getSpacingBefore()
            r4.setSpacingBefore(r5)
            goto L8d
        L72:
            r4 = r3
            com.itextpdf.text.List r4 = (com.itextpdf.text.List) r4
            com.itextpdf.text.ListItem r4 = r4.getFirstItem()
            if (r4 == 0) goto L8d
            float r5 = r10.getSpacingBefore()
            r4.setSpacingBefore(r5)
            goto L8d
        L83:
            r4 = r3
            com.itextpdf.text.Paragraph r4 = (com.itextpdf.text.Paragraph) r4
            float r5 = r10.getSpacingBefore()
            r4.setSpacingBefore(r5)
        L8d:
            r0.add(r3)
            goto La
        L92:
            if (r2 == 0) goto L9d
            int r1 = r2.size()
            if (r1 <= 0) goto L9d
            r0.add(r2)
        L9d:
            int r1 = r0.size()
            if (r1 == 0) goto Ldc
            int r1 = r0.size()
            int r1 = r1 - r4
            java.lang.Object r1 = r0.get(r1)
            com.itextpdf.text.Element r1 = (com.itextpdf.text.Element) r1
            int r2 = r1.type()
            if (r2 == r5) goto Ld3
            if (r2 == r7) goto Lc3
            if (r2 == r6) goto Lb9
            goto Ldc
        Lb9:
            com.itextpdf.text.pdf.PdfPTable r1 = (com.itextpdf.text.pdf.PdfPTable) r1
            float r2 = r10.getSpacingAfter()
            r1.setSpacingAfter(r2)
            goto Ldc
        Lc3:
            com.itextpdf.text.List r1 = (com.itextpdf.text.List) r1
            com.itextpdf.text.ListItem r1 = r1.getLastItem()
            if (r1 == 0) goto Ldc
            float r2 = r10.getSpacingAfter()
            r1.setSpacingAfter(r2)
            goto Ldc
        Ld3:
            com.itextpdf.text.Paragraph r1 = (com.itextpdf.text.Paragraph) r1
            float r2 = r10.getSpacingAfter()
            r1.setSpacingAfter(r2)
        Ldc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Paragraph.breakUp():java.util.List");
    }

    @Override // com.itextpdf.text.Phrase, java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Element element) {
        if (element instanceof List) {
            List list = (List) element;
            list.setIndentationLeft(list.getIndentationLeft() + this.indentationLeft);
            list.setIndentationRight(this.indentationRight);
            return super.add((Element) list);
        } else if (element instanceof Image) {
            super.addSpecial(element);
            return true;
        } else if (element instanceof Paragraph) {
            super.addSpecial(element);
            return true;
        } else {
            return super.add(element);
        }
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    @Override // com.itextpdf.text.Phrase
    public void setLeading(float f) {
        this.leading = f;
        this.multipliedLeading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public void setMultipliedLeading(float f) {
        this.leading = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.multipliedLeading = f;
    }

    public void setLeading(float f, float f2) {
        this.leading = f;
        this.multipliedLeading = f2;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setFirstLineIndent(float f) {
        this.firstLineIndent = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    public void setKeepTogether(boolean z) {
        this.keeptogether = z;
    }

    public boolean getKeepTogether() {
        return this.keeptogether;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public float getMultipliedLeading() {
        return this.multipliedLeading;
    }

    @Override // com.itextpdf.text.Phrase
    public float getTotalLeading() {
        float calculatedLeading = this.font == null ? this.multipliedLeading * 12.0f : this.font.getCalculatedLeading(this.multipliedLeading);
        return (calculatedLeading <= ColumnText.GLOBAL_SPACE_CHAR_RATIO || hasLeading()) ? getLeading() + calculatedLeading : calculatedLeading;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationRight() {
        return this.indentationRight;
    }

    public float getFirstLineIndent() {
        return this.firstLineIndent;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    @Deprecated
    public float spacingBefore() {
        return getSpacingBefore();
    }

    @Deprecated
    public float spacingAfter() {
        return this.spacingAfter;
    }
}
