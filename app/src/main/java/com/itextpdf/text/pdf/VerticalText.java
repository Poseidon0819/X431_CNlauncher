package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class VerticalText {
    public static final int NO_MORE_COLUMN = 2;
    public static final int NO_MORE_TEXT = 1;
    protected PdfChunk currentStandbyChunk;
    protected float height;
    protected float leading;
    protected int maxLines;
    protected String splittedChunkText;
    protected float startX;
    protected float startY;
    protected PdfContentByte text;
    protected ArrayList<PdfChunk> chunks = new ArrayList<>();
    protected int alignment = 0;
    protected int currentChunkMarker = -1;
    private Float curCharSpace = Float.valueOf((float) ColumnText.GLOBAL_SPACE_CHAR_RATIO);

    public VerticalText(PdfContentByte pdfContentByte) {
        this.text = pdfContentByte;
    }

    public void addText(Phrase phrase) {
        for (Chunk chunk : phrase.getChunks()) {
            this.chunks.add(new PdfChunk(chunk, (PdfAction) null));
        }
    }

    public void addText(Chunk chunk) {
        this.chunks.add(new PdfChunk(chunk, (PdfAction) null));
    }

    public void setVerticalLayout(float f, float f2, float f3, int i, float f4) {
        this.startX = f;
        this.startY = f2;
        this.height = f3;
        this.maxLines = i;
        setLeading(f4);
    }

    public void setLeading(float f) {
        this.leading = f;
    }

    public float getLeading() {
        return this.leading;
    }

    protected PdfLine createLine(float f) {
        if (this.chunks.isEmpty()) {
            return null;
        }
        this.splittedChunkText = null;
        this.currentStandbyChunk = null;
        PdfLine pdfLine = new PdfLine(ColumnText.GLOBAL_SPACE_CHAR_RATIO, f, this.alignment, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
        int i = 0;
        while (true) {
            this.currentChunkMarker = i;
            if (this.currentChunkMarker >= this.chunks.size()) {
                return pdfLine;
            }
            PdfChunk pdfChunk = this.chunks.get(this.currentChunkMarker);
            String pdfChunk2 = pdfChunk.toString();
            this.currentStandbyChunk = pdfLine.add(pdfChunk);
            if (this.currentStandbyChunk == null) {
                i = this.currentChunkMarker + 1;
            } else {
                this.splittedChunkText = pdfChunk.toString();
                pdfChunk.setValue(pdfChunk2);
                return pdfLine;
            }
        }
    }

    protected void shortenChunkArray() {
        int i = this.currentChunkMarker;
        if (i < 0) {
            return;
        }
        if (i >= this.chunks.size()) {
            this.chunks.clear();
            return;
        }
        this.chunks.get(this.currentChunkMarker).setValue(this.splittedChunkText);
        this.chunks.set(this.currentChunkMarker, this.currentStandbyChunk);
        for (int i2 = this.currentChunkMarker - 1; i2 >= 0; i2--) {
            this.chunks.remove(i2);
        }
    }

    /* renamed from: go */
    public int m2714go() {
        return m2713go(false);
    }

    /* renamed from: go */
    public int m2713go(boolean z) {
        PdfContentByte pdfContentByte;
        int i;
        PdfContentByte pdfContentByte2 = this.text;
        boolean z2 = false;
        if (pdfContentByte2 != null) {
            pdfContentByte = pdfContentByte2.getDuplicate();
        } else if (!z) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("verticaltext.go.with.simulate.eq.eq.false.and.text.eq.eq.null", new Object[0]));
        } else {
            pdfContentByte = null;
        }
        while (true) {
            i = 1;
            if (this.maxLines <= 0) {
                i = 2;
                if (this.chunks.isEmpty()) {
                    i = 3;
                }
            } else if (this.chunks.isEmpty()) {
                break;
            } else {
                PdfLine createLine = createLine(this.height);
                if (!z && !z2) {
                    this.text.beginText();
                    z2 = true;
                }
                shortenChunkArray();
                if (!z) {
                    this.text.setTextMatrix(this.startX, this.startY - createLine.indentLeft());
                    writeLine(createLine, this.text, pdfContentByte);
                }
                this.maxLines--;
                this.startX -= this.leading;
            }
        }
        if (z2) {
            this.text.endText();
            this.text.add(pdfContentByte);
        }
        return i;
    }

    void writeLine(PdfLine pdfLine, PdfContentByte pdfContentByte, PdfContentByte pdfContentByte2) {
        Iterator<PdfChunk> it = pdfLine.iterator();
        PdfFont pdfFont = null;
        while (it.hasNext()) {
            PdfChunk next = it.next();
            if (next.font().compareTo(pdfFont) != 0) {
                pdfFont = next.font();
                pdfContentByte.setFontAndSize(pdfFont.getFont(), pdfFont.size());
            }
            BaseColor color = next.color();
            Float f = (Float) next.getAttribute(Chunk.CHAR_SPACING);
            if (f != null && !this.curCharSpace.equals(f)) {
                this.curCharSpace = Float.valueOf(f.floatValue());
                pdfContentByte.setCharacterSpacing(this.curCharSpace.floatValue());
            }
            if (color != null) {
                pdfContentByte.setColorFill(color);
            }
            pdfContentByte.showText(next.toString());
            if (color != null) {
                pdfContentByte.resetRGBColorFill();
            }
        }
    }

    public void setOrigin(float f, float f2) {
        this.startX = f;
        this.startY = f2;
    }

    public float getOriginX() {
        return this.startX;
    }

    public float getOriginY() {
        return this.startY;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setMaxLines(int i) {
        this.maxLines = i;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public int getAlignment() {
        return this.alignment;
    }
}
