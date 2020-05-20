package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MultiColumnText implements Element {
    public static final float AUTOMATIC = -1.0f;
    private ArrayList<ColumnDef> columnDefs;
    private ColumnText columnText;
    private boolean columnsRightToLeft;
    private int currentColumn;
    private float desiredHeight;
    private PdfDocument document;
    private float nextY;
    private boolean overflow;
    private boolean simple;
    private float top;
    private float totalHeight;

    @Override // com.itextpdf.text.Element
    public ArrayList<Chunk> getChunks() {
        return null;
    }

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
        return 40;
    }

    public MultiColumnText() {
        this(-1.0f);
    }

    public MultiColumnText(float f) {
        this.simple = true;
        this.currentColumn = 0;
        this.nextY = -1.0f;
        this.columnsRightToLeft = false;
        this.columnDefs = new ArrayList<>();
        this.desiredHeight = f;
        this.top = -1.0f;
        this.columnText = new ColumnText(null);
        this.totalHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public MultiColumnText(float f, float f2) {
        this.simple = true;
        this.currentColumn = 0;
        this.nextY = -1.0f;
        this.columnsRightToLeft = false;
        this.columnDefs = new ArrayList<>();
        this.desiredHeight = f2;
        this.top = f;
        this.nextY = f;
        this.columnText = new ColumnText(null);
        this.totalHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
    }

    public boolean isOverflow() {
        return this.overflow;
    }

    public void useColumnParams(ColumnText columnText) {
        this.columnText.setSimpleVars(columnText);
    }

    public void addColumn(float[] fArr, float[] fArr2) {
        ColumnDef columnDef = new ColumnDef(fArr, fArr2);
        if (!columnDef.isSimple()) {
            this.simple = false;
        }
        this.columnDefs.add(columnDef);
    }

    public void addSimpleColumn(float f, float f2) {
        this.columnDefs.add(new ColumnDef(f, f2));
    }

    public void addRegularColumns(float f, float f2, float f3, int i) {
        float f4 = ((f2 - f) - ((i - 1) * f3)) / i;
        for (int i2 = 0; i2 < i; i2++) {
            addSimpleColumn(f, f + f4);
            f += f4 + f3;
        }
    }

    public void addText(Phrase phrase) {
        this.columnText.addText(phrase);
    }

    public void addText(Chunk chunk) {
        this.columnText.addText(chunk);
    }

    public void addElement(Element element) throws DocumentException {
        if (this.simple) {
            this.columnText.addElement(element);
        } else if (element instanceof Phrase) {
            this.columnText.addText((Phrase) element);
        } else if (element instanceof Chunk) {
            this.columnText.addText((Chunk) element);
        } else {
            throw new DocumentException(MessageLocalization.getComposedMessage("can.t.add.1.to.multicolumntext.with.complex.columns", element.getClass()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e2, code lost:
        r12.overflow = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float write(com.itextpdf.text.pdf.PdfContentByte r13, com.itextpdf.text.pdf.PdfDocument r14, float r15) throws com.itextpdf.text.DocumentException {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.MultiColumnText.write(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.pdf.PdfDocument, float):float");
    }

    private void newPage() throws DocumentException {
        resetCurrentColumn();
        if (this.desiredHeight == -1.0f) {
            this.nextY = -1.0f;
            this.top = -1.0f;
        } else {
            this.top = this.nextY;
        }
        this.totalHeight = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        PdfDocument pdfDocument = this.document;
        if (pdfDocument != null) {
            pdfDocument.newPage();
        }
    }

    private float getHeight(float[] fArr, float[] fArr2) {
        float f = Float.MAX_VALUE;
        float f2 = Float.MIN_VALUE;
        for (int i = 0; i < fArr.length; i += 2) {
            int i2 = i + 1;
            f = Math.min(f, fArr[i2]);
            f2 = Math.max(f2, fArr[i2]);
        }
        for (int i3 = 0; i3 < fArr2.length; i3 += 2) {
            int i4 = i3 + 1;
            f = Math.min(f, fArr2[i4]);
            f2 = Math.max(f2, fArr2[i4]);
        }
        return f2 - f;
    }

    @Override // com.itextpdf.text.Element
    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getColumnBottom() {
        float f = this.desiredHeight;
        if (f == -1.0f) {
            return this.document.bottom();
        }
        return Math.max(this.top - (f - this.totalHeight), this.document.bottom());
    }

    public void nextColumn() throws DocumentException {
        this.currentColumn = (this.currentColumn + 1) % this.columnDefs.size();
        this.top = this.nextY;
        if (this.currentColumn == 0) {
            newPage();
        }
    }

    public int getCurrentColumn() {
        if (this.columnsRightToLeft) {
            return (this.columnDefs.size() - this.currentColumn) - 1;
        }
        return this.currentColumn;
    }

    public void resetCurrentColumn() {
        this.currentColumn = 0;
    }

    public boolean shiftCurrentColumn() {
        if (this.currentColumn + 1 < this.columnDefs.size()) {
            this.currentColumn++;
            return true;
        }
        return false;
    }

    public void setColumnsRightToLeft(boolean z) {
        this.columnsRightToLeft = z;
    }

    public void setSpaceCharRatio(float f) {
        this.columnText.setSpaceCharRatio(f);
    }

    public void setRunDirection(int i) {
        this.columnText.setRunDirection(i);
    }

    public void setArabicOptions(int i) {
        this.columnText.setArabicOptions(i);
    }

    public void setAlignment(int i) {
        this.columnText.setAlignment(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ColumnDef {
        private float[] left;
        private float[] right;

        ColumnDef(float[] fArr, float[] fArr2) {
            this.left = fArr;
            this.right = fArr2;
        }

        ColumnDef(float f, float f2) {
            this.left = new float[4];
            float[] fArr = this.left;
            fArr[0] = f;
            fArr[1] = MultiColumnText.this.top;
            this.left[2] = f;
            if (MultiColumnText.this.desiredHeight != -1.0f && MultiColumnText.this.top != -1.0f) {
                this.left[3] = MultiColumnText.this.top - MultiColumnText.this.desiredHeight;
            } else {
                this.left[3] = -1.0f;
            }
            this.right = new float[4];
            float[] fArr2 = this.right;
            fArr2[0] = f2;
            fArr2[1] = MultiColumnText.this.top;
            this.right[2] = f2;
            if (MultiColumnText.this.desiredHeight != -1.0f && MultiColumnText.this.top != -1.0f) {
                this.right[3] = MultiColumnText.this.top - MultiColumnText.this.desiredHeight;
            } else {
                this.right[3] = -1.0f;
            }
        }

        float[] resolvePositions(int i) {
            if (i == 4) {
                return resolvePositions(this.left);
            }
            return resolvePositions(this.right);
        }

        private float[] resolvePositions(float[] fArr) {
            if (!isSimple()) {
                fArr[1] = MultiColumnText.this.top;
                return fArr;
            } else if (MultiColumnText.this.top != -1.0f) {
                fArr[1] = MultiColumnText.this.top;
                fArr[3] = MultiColumnText.this.getColumnBottom();
                return fArr;
            } else {
                throw new RuntimeException("resolvePositions called with top=AUTOMATIC (-1).  Top position must be set befure lines can be resolved");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isSimple() {
            float[] fArr = this.left;
            if (fArr.length == 4) {
                float[] fArr2 = this.right;
                if (fArr2.length == 4 && fArr[0] == fArr[2] && fArr2[0] == fArr2[2]) {
                    return true;
                }
            }
            return false;
        }
    }
}
