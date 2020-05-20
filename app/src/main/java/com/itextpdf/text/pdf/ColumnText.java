package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.draw.DrawInterface;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/* loaded from: classes.dex */
public class ColumnText {
    public static final int AR_COMPOSEDTASHKEEL = 4;
    public static final int AR_LIG = 8;
    public static final int AR_NOVOWEL = 1;
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final float GLOBAL_SPACE_CHAR_RATIO = 0.0f;
    protected static final int LINE_STATUS_NOLINE = 2;
    protected static final int LINE_STATUS_OFFLIMITS = 1;
    protected static final int LINE_STATUS_OK = 0;
    public static final int NO_MORE_COLUMN = 2;
    public static final int NO_MORE_TEXT = 1;
    public static final int START_COLUMN = 0;
    protected BidiLine bidiLine;
    protected PdfContentByte canvas;
    protected PdfContentByte[] canvases;
    protected ColumnText compositeColumn;
    protected LinkedList<Element> compositeElements;
    protected float descender;
    private float filledWidth;
    private float firstLineY;
    protected float lastX;
    protected ArrayList<float[]> leftWall;
    protected float leftX;
    protected int lineStatus;
    private int linesWritten;
    protected float maxY;
    protected float minY;
    protected ArrayList<float[]> rightWall;
    protected float rightX;
    protected Phrase waitPhrase;
    protected float yLine;
    protected int runDirection = 0;
    protected int alignment = 0;
    protected float currentLeading = 16.0f;
    protected float fixedLeading = 16.0f;
    protected float multipliedLeading = GLOBAL_SPACE_CHAR_RATIO;
    protected float indent = GLOBAL_SPACE_CHAR_RATIO;
    protected float followingIndent = GLOBAL_SPACE_CHAR_RATIO;
    protected float rightIndent = GLOBAL_SPACE_CHAR_RATIO;
    protected float extraParagraphSpace = GLOBAL_SPACE_CHAR_RATIO;
    protected float rectangularWidth = -1.0f;
    protected boolean rectangularMode = false;
    private float spaceCharRatio = GLOBAL_SPACE_CHAR_RATIO;
    private boolean lastWasNewline = true;
    private boolean repeatFirstLineIndent = true;
    private boolean firstLineYDone = false;
    private int arabicOptions = 0;
    protected boolean composite = false;
    protected int listIdx = 0;
    protected int rowIdx = 0;
    private int splittedRow = -1;
    private boolean useAscender = false;
    private boolean adjustFirstLine = true;

    public static boolean hasMoreText(int i) {
        return (i & 1) == 0;
    }

    public ColumnText(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
    }

    public static ColumnText duplicate(ColumnText columnText) {
        ColumnText columnText2 = new ColumnText(null);
        columnText2.setACopy(columnText);
        return columnText2;
    }

    public ColumnText setACopy(ColumnText columnText) {
        setSimpleVars(columnText);
        BidiLine bidiLine = columnText.bidiLine;
        if (bidiLine != null) {
            this.bidiLine = new BidiLine(bidiLine);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSimpleVars(ColumnText columnText) {
        this.maxY = columnText.maxY;
        this.minY = columnText.minY;
        this.alignment = columnText.alignment;
        this.leftWall = null;
        ArrayList<float[]> arrayList = columnText.leftWall;
        if (arrayList != null) {
            this.leftWall = new ArrayList<>(arrayList);
        }
        this.rightWall = null;
        ArrayList<float[]> arrayList2 = columnText.rightWall;
        if (arrayList2 != null) {
            this.rightWall = new ArrayList<>(arrayList2);
        }
        this.yLine = columnText.yLine;
        this.currentLeading = columnText.currentLeading;
        this.fixedLeading = columnText.fixedLeading;
        this.multipliedLeading = columnText.multipliedLeading;
        this.canvas = columnText.canvas;
        this.canvases = columnText.canvases;
        this.lineStatus = columnText.lineStatus;
        this.indent = columnText.indent;
        this.followingIndent = columnText.followingIndent;
        this.rightIndent = columnText.rightIndent;
        this.extraParagraphSpace = columnText.extraParagraphSpace;
        this.rectangularWidth = columnText.rectangularWidth;
        this.rectangularMode = columnText.rectangularMode;
        this.spaceCharRatio = columnText.spaceCharRatio;
        this.lastWasNewline = columnText.lastWasNewline;
        this.repeatFirstLineIndent = columnText.repeatFirstLineIndent;
        this.linesWritten = columnText.linesWritten;
        this.arabicOptions = columnText.arabicOptions;
        this.runDirection = columnText.runDirection;
        this.descender = columnText.descender;
        this.composite = columnText.composite;
        this.splittedRow = columnText.splittedRow;
        if (columnText.composite) {
            this.compositeElements = new LinkedList<>(columnText.compositeElements);
            if (this.splittedRow != -1) {
                this.compositeElements.set(0, new PdfPTable((PdfPTable) this.compositeElements.getFirst()));
            }
            ColumnText columnText2 = columnText.compositeColumn;
            if (columnText2 != null) {
                this.compositeColumn = duplicate(columnText2);
            }
        }
        this.listIdx = columnText.listIdx;
        this.rowIdx = columnText.rowIdx;
        this.firstLineY = columnText.firstLineY;
        this.leftX = columnText.leftX;
        this.rightX = columnText.rightX;
        this.firstLineYDone = columnText.firstLineYDone;
        this.waitPhrase = columnText.waitPhrase;
        this.useAscender = columnText.useAscender;
        this.filledWidth = columnText.filledWidth;
        this.adjustFirstLine = columnText.adjustFirstLine;
    }

    private void addWaitingPhrase() {
        if (this.bidiLine != null || this.waitPhrase == null) {
            return;
        }
        this.bidiLine = new BidiLine();
        for (Chunk chunk : this.waitPhrase.getChunks()) {
            this.bidiLine.addChunk(new PdfChunk(chunk, (PdfAction) null));
        }
        this.waitPhrase = null;
    }

    public void addText(Phrase phrase) {
        if (phrase == null || this.composite) {
            return;
        }
        addWaitingPhrase();
        if (this.bidiLine == null) {
            this.waitPhrase = phrase;
            return;
        }
        for (Chunk chunk : phrase.getChunks()) {
            this.bidiLine.addChunk(new PdfChunk(chunk, (PdfAction) null));
        }
    }

    public void setText(Phrase phrase) {
        this.bidiLine = null;
        this.composite = false;
        this.compositeColumn = null;
        this.compositeElements = null;
        this.listIdx = 0;
        this.rowIdx = 0;
        this.splittedRow = -1;
        this.waitPhrase = phrase;
    }

    public void addText(Chunk chunk) {
        if (chunk == null || this.composite) {
            return;
        }
        addText(new Phrase(chunk));
    }

    public void addElement(Element element) {
        Element paragraph;
        if (element == null) {
            return;
        }
        if (element instanceof Image) {
            Image image = (Image) element;
            PdfPTable pdfPTable = new PdfPTable(1);
            float widthPercentage = image.getWidthPercentage();
            if (widthPercentage == GLOBAL_SPACE_CHAR_RATIO) {
                pdfPTable.setTotalWidth(image.getScaledWidth());
                pdfPTable.setLockedWidth(true);
            } else {
                pdfPTable.setWidthPercentage(widthPercentage);
            }
            pdfPTable.setSpacingAfter(image.getSpacingAfter());
            pdfPTable.setSpacingBefore(image.getSpacingBefore());
            int alignment = image.getAlignment();
            if (alignment == 0) {
                pdfPTable.setHorizontalAlignment(0);
            } else if (alignment == 2) {
                pdfPTable.setHorizontalAlignment(2);
            } else {
                pdfPTable.setHorizontalAlignment(1);
            }
            PdfPCell pdfPCell = new PdfPCell(image, true);
            pdfPCell.setPadding(GLOBAL_SPACE_CHAR_RATIO);
            pdfPCell.setBorder(image.getBorder());
            pdfPCell.setBorderColor(image.getBorderColor());
            pdfPCell.setBorderWidth(image.getBorderWidth());
            pdfPCell.setBackgroundColor(image.getBackgroundColor());
            pdfPTable.addCell(pdfPCell);
            element = pdfPTable;
        }
        if (element.type() == 10) {
            paragraph = new Paragraph((Chunk) element);
        } else {
            paragraph = element.type() == 11 ? new Paragraph((Phrase) element) : element;
        }
        if (paragraph.type() != 12 && paragraph.type() != 14 && paragraph.type() != 23 && paragraph.type() != 55 && paragraph.type() != 37) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("element.not.allowed", new Object[0]));
        }
        if (!this.composite) {
            this.composite = true;
            this.compositeElements = new LinkedList<>();
            this.bidiLine = null;
            this.waitPhrase = null;
        }
        if (paragraph.type() == 12) {
            this.compositeElements.addAll(((Paragraph) paragraph).breakUp());
        } else {
            this.compositeElements.add(paragraph);
        }
    }

    public static boolean isAllowedElement(Element element) {
        int type = element.type();
        return type == 10 || type == 11 || type == 37 || type == 12 || type == 14 || type == 55 || type == 23 || (element instanceof Image);
    }

    protected ArrayList<float[]> convertColumn(float[] fArr) {
        if (fArr.length < 4) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("no.valid.column.line.found", new Object[0]));
        }
        ArrayList<float[]> arrayList = new ArrayList<>();
        int i = 0;
        while (i < fArr.length - 2) {
            float f = fArr[i];
            float f2 = fArr[i + 1];
            int i2 = i + 2;
            float f3 = fArr[i2];
            float f4 = fArr[i + 3];
            if (f2 != f4) {
                float f5 = (f - f3) / (f2 - f4);
                float[] fArr2 = {Math.min(f2, f4), Math.max(f2, f4), f5, f - (f5 * f2)};
                arrayList.add(fArr2);
                this.maxY = Math.max(this.maxY, fArr2[1]);
                this.minY = Math.min(this.minY, fArr2[0]);
            }
            i = i2;
        }
        if (arrayList.isEmpty()) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("no.valid.column.line.found", new Object[0]));
        }
        return arrayList;
    }

    protected float findLimitsPoint(ArrayList<float[]> arrayList) {
        this.lineStatus = 0;
        float f = this.yLine;
        if (f < this.minY || f > this.maxY) {
            this.lineStatus = 1;
            return GLOBAL_SPACE_CHAR_RATIO;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            float[] fArr = arrayList.get(i);
            float f2 = this.yLine;
            if (f2 >= fArr[0] && f2 <= fArr[1]) {
                return (fArr[2] * f2) + fArr[3];
            }
        }
        this.lineStatus = 2;
        return GLOBAL_SPACE_CHAR_RATIO;
    }

    protected float[] findLimitsOneLine() {
        float findLimitsPoint = findLimitsPoint(this.leftWall);
        int i = this.lineStatus;
        if (i == 1 || i == 2) {
            return null;
        }
        float findLimitsPoint2 = findLimitsPoint(this.rightWall);
        if (this.lineStatus == 2) {
            return null;
        }
        return new float[]{findLimitsPoint, findLimitsPoint2};
    }

    protected float[] findLimitsTwoLines() {
        boolean z = false;
        while (true) {
            if (z && this.currentLeading == GLOBAL_SPACE_CHAR_RATIO) {
                return null;
            }
            float[] findLimitsOneLine = findLimitsOneLine();
            int i = this.lineStatus;
            if (i == 1) {
                return null;
            }
            this.yLine -= this.currentLeading;
            if (i != 2) {
                float[] findLimitsOneLine2 = findLimitsOneLine();
                int i2 = this.lineStatus;
                if (i2 == 1) {
                    return null;
                }
                if (i2 == 2) {
                    this.yLine -= this.currentLeading;
                } else if (findLimitsOneLine[0] < findLimitsOneLine2[1] && findLimitsOneLine2[0] < findLimitsOneLine[1]) {
                    return new float[]{findLimitsOneLine[0], findLimitsOneLine[1], findLimitsOneLine2[0], findLimitsOneLine2[1]};
                }
            }
            z = true;
        }
    }

    public void setColumns(float[] fArr, float[] fArr2) {
        this.maxY = -1.0E21f;
        this.minY = 1.0E21f;
        setYLine(Math.max(fArr[1], fArr[fArr.length - 1]));
        this.rightWall = convertColumn(fArr2);
        this.leftWall = convertColumn(fArr);
        this.rectangularWidth = -1.0f;
        this.rectangularMode = false;
    }

    public void setSimpleColumn(Phrase phrase, float f, float f2, float f3, float f4, float f5, int i) {
        addText(phrase);
        setSimpleColumn(f, f2, f3, f4, f5, i);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4, float f5, int i) {
        setLeading(f5);
        this.alignment = i;
        setSimpleColumn(f, f2, f3, f4);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4) {
        this.leftX = Math.min(f, f3);
        this.maxY = Math.max(f2, f4);
        this.minY = Math.min(f2, f4);
        this.rightX = Math.max(f, f3);
        this.yLine = this.maxY;
        this.rectangularWidth = this.rightX - this.leftX;
        if (this.rectangularWidth < GLOBAL_SPACE_CHAR_RATIO) {
            this.rectangularWidth = GLOBAL_SPACE_CHAR_RATIO;
        }
        this.rectangularMode = true;
    }

    public void setSimpleColumn(Rectangle rectangle) {
        setSimpleColumn(rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop());
    }

    public void setLeading(float f) {
        this.fixedLeading = f;
        this.multipliedLeading = GLOBAL_SPACE_CHAR_RATIO;
    }

    public void setLeading(float f, float f2) {
        this.fixedLeading = f;
        this.multipliedLeading = f2;
    }

    public float getLeading() {
        return this.fixedLeading;
    }

    public float getMultipliedLeading() {
        return this.multipliedLeading;
    }

    public void setYLine(float f) {
        this.yLine = f;
    }

    public float getYLine() {
        return this.yLine;
    }

    public int getRowsDrawn() {
        return this.rowIdx;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setIndent(float f) {
        setIndent(f, true);
    }

    public void setIndent(float f, boolean z) {
        this.indent = f;
        this.lastWasNewline = true;
        this.repeatFirstLineIndent = z;
    }

    public float getIndent() {
        return this.indent;
    }

    public void setFollowingIndent(float f) {
        this.followingIndent = f;
        this.lastWasNewline = true;
    }

    public float getFollowingIndent() {
        return this.followingIndent;
    }

    public void setRightIndent(float f) {
        this.rightIndent = f;
        this.lastWasNewline = true;
    }

    public float getRightIndent() {
        return this.rightIndent;
    }

    public float getCurrentLeading() {
        return this.currentLeading;
    }

    /* renamed from: go */
    public int m2716go() throws DocumentException {
        return m2715go(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x015b, code lost:
        r27.bidiLine.restore();
        r26 = 2;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0213  */
    /* renamed from: go */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m2715go(boolean r28) throws com.itextpdf.text.DocumentException {
        /*
            Method dump skipped, instructions count: 603
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.m2715go(boolean):int");
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    public void clearChunks() {
        BidiLine bidiLine = this.bidiLine;
        if (bidiLine != null) {
            bidiLine.clearChunks();
        }
    }

    public float getSpaceCharRatio() {
        return this.spaceCharRatio;
    }

    public void setSpaceCharRatio(float f) {
        this.spaceCharRatio = f;
    }

    public void setRunDirection(int i) {
        if (i < 0 || i > 3) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.run.direction.1", i));
        }
        this.runDirection = i;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public int getLinesWritten() {
        return this.linesWritten;
    }

    public float getLastX() {
        return this.lastX;
    }

    public int getArabicOptions() {
        return this.arabicOptions;
    }

    public void setArabicOptions(int i) {
        this.arabicOptions = i;
    }

    public float getDescender() {
        return this.descender;
    }

    public static float getWidth(Phrase phrase, int i, int i2) {
        ColumnText columnText = new ColumnText(null);
        columnText.addText(phrase);
        columnText.addWaitingPhrase();
        PdfLine processLine = columnText.bidiLine.processLine(GLOBAL_SPACE_CHAR_RATIO, 20000.0f, 0, i, i2, GLOBAL_SPACE_CHAR_RATIO, GLOBAL_SPACE_CHAR_RATIO, GLOBAL_SPACE_CHAR_RATIO);
        return processLine == null ? GLOBAL_SPACE_CHAR_RATIO : 20000.0f - processLine.widthLeft();
    }

    public static float getWidth(Phrase phrase) {
        return getWidth(phrase, 1, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
        if (r0 == 2) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void showTextAligned(com.itextpdf.text.pdf.PdfContentByte r18, int r19, com.itextpdf.text.Phrase r20, float r21, float r22, float r23, int r24, int r25) {
        /*
            r0 = r19
            r1 = r23
            r7 = r24
            r8 = 0
            r9 = 2
            if (r0 == 0) goto L11
            r2 = 1
            if (r0 == r2) goto L11
            if (r0 == r9) goto L11
            r15 = 0
            goto L12
        L11:
            r15 = r0
        L12:
            r18.saveState()
            com.itextpdf.text.pdf.ColumnText r14 = new com.itextpdf.text.pdf.ColumnText
            r13 = r18
            r14.<init>(r13)
            r0 = 1184645120(0x469c4000, float:20000.0)
            r2 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r3 = 0
            if (r15 == 0) goto L33
            if (r15 == r9) goto L2e
            r10 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r11 = 1184645120(0x469c4000, float:20000.0)
            goto L37
        L2e:
            r10 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r11 = 0
            goto L37
        L33:
            r10 = 0
            r11 = 1184645120(0x469c4000, float:20000.0)
        L37:
            r12 = 1073741824(0x40000000, float:2.0)
            r16 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto L4c
            float r10 = r10 + r21
            float r0 = r22 + r16
            float r11 = r11 + r21
            float r1 = r22 + r12
            r16 = r0
            r12 = r10
            r0 = r11
            goto L76
        L4c:
            double r0 = (double) r1
            r2 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r2
            r2 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r0 = r0 / r2
            double r2 = java.lang.Math.cos(r0)
            float r4 = (float) r2
            double r0 = java.lang.Math.sin(r0)
            float r2 = (float) r0
            float r3 = -r2
            r0 = r18
            r1 = r4
            r5 = r21
            r6 = r22
            r0.concatCTM(r1, r2, r3, r4, r5, r6)
            r12 = r10
            r0 = r11
            r1 = 1073741824(0x40000000, float:2.0)
        L76:
            r2 = 1073741824(0x40000000, float:2.0)
            r10 = r14
            r11 = r20
            r13 = r16
            r3 = r14
            r14 = r0
            r0 = r15
            r15 = r1
            r16 = r2
            r17 = r0
            r10.setSimpleColumn(r11, r12, r13, r14, r15, r16, r17)
            r1 = 3
            if (r7 != r1) goto L92
            if (r0 != 0) goto L8f
            r8 = 2
            goto L93
        L8f:
            if (r0 != r9) goto L92
            goto L93
        L92:
            r8 = r0
        L93:
            r3.setAlignment(r8)
            r0 = r25
            r3.setArabicOptions(r0)
            r3.setRunDirection(r7)
            r3.m2716go()     // Catch: com.itextpdf.text.DocumentException -> La5
            r18.restoreState()
            return
        La5:
            r0 = move-exception
            r1 = r0
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.showTextAligned(com.itextpdf.text.pdf.PdfContentByte, int, com.itextpdf.text.Phrase, float, float, float, int, int):void");
    }

    public static void showTextAligned(PdfContentByte pdfContentByte, int i, Phrase phrase, float f, float f2, float f3) {
        showTextAligned(pdfContentByte, i, phrase, f, f2, f3, 1, 0);
    }

    public static float fitText(Font font, String str, Rectangle rectangle, float f, int i) {
        float abs;
        if (f <= GLOBAL_SPACE_CHAR_RATIO) {
            try {
                char[] charArray = str.toCharArray();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < charArray.length; i4++) {
                    if (charArray[i4] == '\n') {
                        i3++;
                    } else if (charArray[i4] == '\r') {
                        i2++;
                    }
                }
                abs = (Math.abs(rectangle.getHeight()) / (Math.max(i2, i3) + 1)) - 0.001f;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            abs = f;
        }
        font.setSize(abs);
        Phrase phrase = new Phrase(str, font);
        ColumnText columnText = new ColumnText(null);
        columnText.setSimpleColumn(phrase, rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), abs, 0);
        columnText.setRunDirection(i);
        if ((columnText.m2715go(true) & 1) != 0) {
            return abs;
        }
        float f2 = abs;
        float f3 = GLOBAL_SPACE_CHAR_RATIO;
        for (int i5 = 0; i5 < 50; i5++) {
            abs = (f3 + f2) / 2.0f;
            ColumnText columnText2 = new ColumnText(null);
            font.setSize(abs);
            columnText2.setSimpleColumn(new Phrase(str, font), rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), abs, 0);
            columnText2.setRunDirection(i);
            if ((columnText2.m2715go(true) & 1) == 0) {
                f2 = abs;
            } else if (f2 - f3 < 0.1f * abs) {
                return abs;
            } else {
                f3 = abs;
            }
        }
        return abs;
    }

    protected int goComposite(boolean z) throws DocumentException {
        boolean z2;
        ListItem listItem;
        boolean z3;
        float widthPercentage;
        float f;
        float f2;
        boolean z4;
        float f3;
        boolean z5 = false;
        if (!this.rectangularMode) {
            throw new DocumentException(MessageLocalization.getComposedMessage("irregular.columns.are.not.supported.in.composite.mode", new Object[0]));
        }
        this.linesWritten = 0;
        float f4 = GLOBAL_SPACE_CHAR_RATIO;
        this.descender = GLOBAL_SPACE_CHAR_RATIO;
        boolean z6 = true;
        boolean z7 = true;
        while (!this.compositeElements.isEmpty()) {
            Element first = this.compositeElements.getFirst();
            if (first.type() == 12) {
                Paragraph paragraph = (Paragraph) first;
                int i = 0;
                int i2 = 0;
                while (i < 2) {
                    float f5 = this.yLine;
                    if (this.compositeColumn == null) {
                        this.compositeColumn = new ColumnText(this.canvas);
                        this.compositeColumn.setAlignment(paragraph.getAlignment());
                        this.compositeColumn.setIndent(paragraph.getIndentationLeft() + paragraph.getFirstLineIndent(), z5);
                        this.compositeColumn.setExtraParagraphSpace(paragraph.getExtraParagraphSpace());
                        this.compositeColumn.setFollowingIndent(paragraph.getIndentationLeft());
                        this.compositeColumn.setRightIndent(paragraph.getIndentationRight());
                        this.compositeColumn.setLeading(paragraph.getLeading(), paragraph.getMultipliedLeading());
                        this.compositeColumn.setRunDirection(this.runDirection);
                        this.compositeColumn.setArabicOptions(this.arabicOptions);
                        this.compositeColumn.setSpaceCharRatio(this.spaceCharRatio);
                        this.compositeColumn.addText(paragraph);
                        if (!z7 || !this.adjustFirstLine) {
                            this.yLine -= paragraph.getSpacingBefore();
                        }
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.compositeColumn.setUseAscender(((z7 || this.descender == f4) && this.adjustFirstLine) ? this.useAscender : false);
                    ColumnText columnText = this.compositeColumn;
                    columnText.leftX = this.leftX;
                    columnText.rightX = this.rightX;
                    columnText.yLine = this.yLine;
                    columnText.rectangularWidth = this.rectangularWidth;
                    columnText.rectangularMode = this.rectangularMode;
                    columnText.minY = this.minY;
                    columnText.maxY = this.maxY;
                    boolean z8 = paragraph.getKeepTogether() && z2 && !(z7 && this.adjustFirstLine);
                    int m2715go = this.compositeColumn.m2715go(z || (z8 && i == 0));
                    this.lastX = this.compositeColumn.getLastX();
                    updateFilledWidth(this.compositeColumn.filledWidth);
                    if ((m2715go & 1) == 0 && z8) {
                        this.compositeColumn = null;
                        this.yLine = f5;
                        return 2;
                    } else if (z || !z8) {
                        i2 = m2715go;
                        break;
                    } else {
                        if (i == 0) {
                            this.compositeColumn = null;
                            this.yLine = f5;
                        }
                        i++;
                        i2 = m2715go;
                    }
                }
                if (this.compositeColumn.getLinesWritten() > 0) {
                    ColumnText columnText2 = this.compositeColumn;
                    this.yLine = columnText2.yLine;
                    this.linesWritten += columnText2.linesWritten;
                    this.descender = columnText2.descender;
                }
                this.currentLeading = this.compositeColumn.currentLeading;
                if ((i2 & 1) != 0) {
                    this.compositeColumn = null;
                    this.compositeElements.removeFirst();
                    this.yLine -= paragraph.getSpacingAfter();
                }
                if ((i2 & 2) != 0) {
                    return 2;
                }
                z7 = false;
            } else if (first.type() == 14) {
                List list = (List) first;
                ArrayList<Element> items = list.getItems();
                float indentationLeft = list.getIndentationLeft();
                Stack stack = new Stack();
                List list2 = list;
                float f6 = indentationLeft;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= items.size()) {
                        listItem = null;
                        break;
                    }
                    Element element = items.get(i3);
                    if (element instanceof ListItem) {
                        if (i4 == this.listIdx) {
                            listItem = (ListItem) element;
                            break;
                        }
                        i4++;
                    } else if (element instanceof List) {
                        Object[] objArr = new Object[3];
                        objArr[z5 ? 1 : 0] = list2;
                        objArr[z6 ? 1 : 0] = Integer.valueOf(i3);
                        objArr[2] = Float.valueOf(f6);
                        stack.push(objArr);
                        List list3 = (List) element;
                        ArrayList<Element> items2 = list3.getItems();
                        f6 += list3.getIndentationLeft();
                        items = items2;
                        list2 = list3;
                        i3 = -1;
                        i3 += z6 ? 1 : 0;
                    }
                    if (i3 == items.size() - (z6 ? 1 : 0) && !stack.isEmpty()) {
                        Object[] objArr2 = (Object[]) stack.pop();
                        List list4 = (List) objArr2[z5 ? 1 : 0];
                        ArrayList<Element> items3 = list4.getItems();
                        int intValue = ((Integer) objArr2[z6 ? 1 : 0]).intValue();
                        f6 = ((Float) objArr2[2]).floatValue();
                        i3 = intValue;
                        list2 = list4;
                        items = items3;
                    }
                    i3 += z6 ? 1 : 0;
                }
                int i5 = 0;
                int i6 = 0;
                while (i5 < 2) {
                    float f7 = this.yLine;
                    if (this.compositeColumn != null) {
                        z3 = false;
                    } else if (listItem == null) {
                        this.listIdx = z5 ? 1 : 0;
                        this.compositeElements.removeFirst();
                        f4 = GLOBAL_SPACE_CHAR_RATIO;
                        z5 = false;
                        z6 = true;
                        break;
                    } else {
                        this.compositeColumn = new ColumnText(this.canvas);
                        this.compositeColumn.setUseAscender(((z7 || this.descender == f4) && this.adjustFirstLine) ? this.useAscender : false);
                        this.compositeColumn.setAlignment(listItem.getAlignment());
                        this.compositeColumn.setIndent(listItem.getIndentationLeft() + f6 + listItem.getFirstLineIndent(), z5);
                        this.compositeColumn.setExtraParagraphSpace(listItem.getExtraParagraphSpace());
                        ColumnText columnText3 = this.compositeColumn;
                        columnText3.setFollowingIndent(columnText3.getIndent());
                        this.compositeColumn.setRightIndent(listItem.getIndentationRight() + list2.getIndentationRight());
                        this.compositeColumn.setLeading(listItem.getLeading(), listItem.getMultipliedLeading());
                        this.compositeColumn.setRunDirection(this.runDirection);
                        this.compositeColumn.setArabicOptions(this.arabicOptions);
                        this.compositeColumn.setSpaceCharRatio(this.spaceCharRatio);
                        this.compositeColumn.addText(listItem);
                        if (!z7 || !this.adjustFirstLine) {
                            this.yLine -= listItem.getSpacingBefore();
                        }
                        z3 = true;
                    }
                    ColumnText columnText4 = this.compositeColumn;
                    columnText4.leftX = this.leftX;
                    columnText4.rightX = this.rightX;
                    columnText4.yLine = this.yLine;
                    columnText4.rectangularWidth = this.rectangularWidth;
                    columnText4.rectangularMode = this.rectangularMode;
                    columnText4.minY = this.minY;
                    columnText4.maxY = this.maxY;
                    boolean z9 = listItem.getKeepTogether() && z3 && !(z7 && this.adjustFirstLine);
                    int m2715go2 = this.compositeColumn.m2715go(z || (z9 && i5 == 0));
                    this.lastX = this.compositeColumn.getLastX();
                    updateFilledWidth(this.compositeColumn.filledWidth);
                    if ((m2715go2 & 1) == 0 && z9) {
                        this.compositeColumn = null;
                        this.yLine = f7;
                        return 2;
                    } else if (z || !z9) {
                        i6 = m2715go2;
                        break;
                    } else {
                        if (i5 == 0) {
                            this.compositeColumn = null;
                            this.yLine = f7;
                        }
                        i5++;
                        i6 = m2715go2;
                    }
                }
                ColumnText columnText5 = this.compositeColumn;
                this.yLine = columnText5.yLine;
                this.linesWritten += columnText5.linesWritten;
                this.descender = columnText5.descender;
                this.currentLeading = columnText5.currentLeading;
                if (!Float.isNaN(columnText5.firstLineY) && !this.compositeColumn.firstLineYDone) {
                    if (!z) {
                        PdfContentByte pdfContentByte = this.canvas;
                        Phrase phrase = new Phrase(listItem.getListSymbol());
                        ColumnText columnText6 = this.compositeColumn;
                        showTextAligned(pdfContentByte, 0, phrase, columnText6.leftX + f6, columnText6.firstLineY, GLOBAL_SPACE_CHAR_RATIO);
                    }
                    this.compositeColumn.firstLineYDone = z6;
                }
                if ((i6 & 1) != 0) {
                    this.compositeColumn = null;
                    this.listIdx += z6 ? 1 : 0;
                    this.yLine -= listItem.getSpacingAfter();
                }
                if ((i6 & 2) != 0) {
                    return 2;
                }
                z7 = false;
            } else {
                if (first.type() == 23) {
                    PdfPTable pdfPTable = (PdfPTable) first;
                    if (pdfPTable.size() <= pdfPTable.getHeaderRows()) {
                        this.compositeElements.removeFirst();
                    } else {
                        float f8 = this.yLine + this.descender;
                        float spacingBefore = (this.rowIdx == 0 && this.adjustFirstLine) ? f8 - pdfPTable.spacingBefore() : f8;
                        if (spacingBefore < this.minY || spacingBefore > this.maxY) {
                            return 2;
                        }
                        float f9 = this.leftX;
                        this.currentLeading = f4;
                        if (pdfPTable.isLockedWidth()) {
                            widthPercentage = pdfPTable.getTotalWidth();
                            updateFilledWidth(widthPercentage);
                        } else {
                            widthPercentage = (this.rectangularWidth * pdfPTable.getWidthPercentage()) / 100.0f;
                            pdfPTable.setTotalWidth(widthPercentage);
                        }
                        pdfPTable.normalizeHeadersFooters();
                        int headerRows = pdfPTable.getHeaderRows();
                        int footerRows = pdfPTable.getFooterRows();
                        int i7 = headerRows - footerRows;
                        float headerHeight = pdfPTable.getHeaderHeight();
                        float footerHeight = pdfPTable.getFooterHeight();
                        boolean z10 = pdfPTable.isSkipFirstHeader() && this.rowIdx <= i7;
                        if (z10) {
                            f = spacingBefore;
                        } else {
                            f = spacingBefore - headerHeight;
                            if (f < this.minY || f > this.maxY) {
                                return 2;
                            }
                        }
                        if (this.rowIdx < headerRows) {
                            this.rowIdx = headerRows;
                        }
                        if (!pdfPTable.isComplete()) {
                            f -= footerHeight;
                        }
                        int i8 = this.rowIdx;
                        while (i8 < pdfPTable.size()) {
                            float rowHeight = f - pdfPTable.getRowHeight(i8);
                            if (rowHeight < this.minY) {
                                break;
                            }
                            i8++;
                            f = rowHeight;
                        }
                        if (!pdfPTable.isComplete()) {
                            f += footerHeight;
                        }
                        if (!pdfPTable.isSplitRows()) {
                            this.splittedRow = -1;
                            if (i8 == this.rowIdx) {
                                if (i8 == pdfPTable.size()) {
                                    this.compositeElements.removeFirst();
                                } else {
                                    pdfPTable.getRows().remove(i8);
                                    return 2;
                                }
                            }
                        } else if (pdfPTable.isSplitLate() && !pdfPTable.hasRowspan(i8) && this.rowIdx < i8) {
                            this.splittedRow = -1;
                        } else if (i8 < pdfPTable.size()) {
                            if (i8 != this.splittedRow) {
                                this.splittedRow = i8 + 1;
                                PdfPTable pdfPTable2 = new PdfPTable(pdfPTable);
                                this.compositeElements.set(0, pdfPTable2);
                                ArrayList<PdfPRow> rows = pdfPTable2.getRows();
                                while (headerRows < this.rowIdx) {
                                    rows.set(headerRows, null);
                                    headerRows++;
                                }
                                pdfPTable = pdfPTable2;
                            }
                            PdfPRow splitRow = pdfPTable.getRow(i8).splitRow(pdfPTable, i8, f - this.minY);
                            if (splitRow == null) {
                                this.splittedRow = -1;
                                if (this.rowIdx == i8) {
                                    return 2;
                                }
                            } else {
                                f = this.minY;
                                i8++;
                                pdfPTable.getRows().add(i8, splitRow);
                            }
                        }
                        if (!z) {
                            int horizontalAlignment = pdfPTable.getHorizontalAlignment();
                            if (horizontalAlignment == 0) {
                                f2 = f9;
                            } else if (horizontalAlignment == 2) {
                                f2 = f9 + (this.rectangularWidth - widthPercentage);
                            } else {
                                f2 = f9 + ((this.rectangularWidth - widthPercentage) / 2.0f);
                            }
                            PdfPTable shallowCopy = PdfPTable.shallowCopy(pdfPTable);
                            ArrayList<PdfPRow> rows2 = shallowCopy.getRows();
                            if (!z10 && i7 > 0) {
                                rows2.addAll(pdfPTable.getRows(0, i7));
                            } else {
                                shallowCopy.setHeaderRows(footerRows);
                            }
                            rows2.addAll(pdfPTable.getRows(this.rowIdx, i8));
                            boolean z11 = !pdfPTable.isSkipLastFooter();
                            if (i8 < pdfPTable.size()) {
                                shallowCopy.setComplete(true);
                                z11 = true;
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (footerRows > 0 && shallowCopy.isComplete() && z11) {
                                rows2.addAll(pdfPTable.getRows(i7, i7 + footerRows));
                            } else {
                                footerRows = 0;
                            }
                            int size = (rows2.size() - 1) - footerRows;
                            PdfPRow pdfPRow = rows2.get(size);
                            if (pdfPTable.isExtendLastRow(z4)) {
                                f3 = pdfPRow.getMaxHeights();
                                pdfPRow.setMaxHeights((f - this.minY) + f3);
                                f = this.minY;
                            } else {
                                f3 = GLOBAL_SPACE_CHAR_RATIO;
                            }
                            if (z4) {
                                PdfPTableEvent tableEvent = pdfPTable.getTableEvent();
                                if (tableEvent instanceof PdfPTableEventSplit) {
                                    ((PdfPTableEventSplit) tableEvent).splitTable(pdfPTable);
                                }
                            }
                            PdfContentByte[] pdfContentByteArr = this.canvases;
                            if (pdfContentByteArr != null) {
                                shallowCopy.writeSelectedRows(0, -1, 0, -1, f2, spacingBefore, pdfContentByteArr, false);
                            } else {
                                shallowCopy.writeSelectedRows(0, -1, 0, -1, f2, spacingBefore, this.canvas, false);
                            }
                            if (this.splittedRow == i8 && i8 < pdfPTable.size()) {
                                pdfPTable.getRows().get(i8).copyRowContent(shallowCopy, size);
                            }
                            if (pdfPTable.isExtendLastRow(z4)) {
                                pdfPRow.setMaxHeights(f3);
                            }
                        } else if (pdfPTable.isExtendLastRow()) {
                            float f10 = this.minY;
                            if (f10 > -1.0737418E9f) {
                                f = f10;
                            }
                        }
                        this.yLine = f;
                        this.descender = GLOBAL_SPACE_CHAR_RATIO;
                        this.currentLeading = GLOBAL_SPACE_CHAR_RATIO;
                        if (!z10 && !pdfPTable.isComplete()) {
                            this.yLine += footerHeight;
                        }
                        if (i8 >= pdfPTable.size()) {
                            float spacingAfter = this.yLine - pdfPTable.spacingAfter();
                            float f11 = this.minY;
                            if (spacingAfter < f11) {
                                this.yLine = f11;
                            } else {
                                this.yLine -= pdfPTable.spacingAfter();
                            }
                            this.compositeElements.removeFirst();
                            this.splittedRow = -1;
                            this.rowIdx = 0;
                            f4 = GLOBAL_SPACE_CHAR_RATIO;
                            z5 = false;
                            z6 = true;
                            z7 = false;
                        } else {
                            if (this.splittedRow != -1) {
                                ArrayList<PdfPRow> rows3 = pdfPTable.getRows();
                                for (int i9 = this.rowIdx; i9 < i8; i9++) {
                                    rows3.set(i9, null);
                                }
                            }
                            this.rowIdx = i8;
                            return 2;
                        }
                    }
                } else if (first.type() == 55) {
                    if (!z) {
                        ((DrawInterface) first).draw(this.canvas, this.leftX, this.minY, this.rightX, this.maxY, this.yLine);
                    }
                    this.compositeElements.removeFirst();
                } else if (first.type() == 37) {
                    ArrayList arrayList = new ArrayList();
                    do {
                        arrayList.add(first);
                        this.compositeElements.removeFirst();
                        first = !this.compositeElements.isEmpty() ? this.compositeElements.getFirst() : null;
                        if (first == null) {
                            break;
                        }
                    } while (first.type() == 37);
                    this.compositeColumn = new ColumnText(this.canvas);
                    this.compositeColumn.setUseAscender(((z7 || this.descender == GLOBAL_SPACE_CHAR_RATIO) && this.adjustFirstLine) ? this.useAscender : false);
                    this.compositeColumn.setRunDirection(this.runDirection);
                    this.compositeColumn.setArabicOptions(this.arabicOptions);
                    this.compositeColumn.setSpaceCharRatio(this.spaceCharRatio);
                    FloatLayout floatLayout = new FloatLayout(this.compositeColumn, arrayList);
                    floatLayout.setSimpleColumn(this.leftX, this.minY, this.rightX, this.yLine);
                    int layout = floatLayout.layout(z);
                    this.yLine = floatLayout.getYLine();
                    this.descender = GLOBAL_SPACE_CHAR_RATIO;
                    this.compositeColumn = null;
                    if ((layout & 1) == 0) {
                        this.compositeElements.addAll(arrayList);
                        return layout;
                    }
                } else {
                    this.compositeElements.removeFirst();
                }
                f4 = GLOBAL_SPACE_CHAR_RATIO;
                z5 = false;
                z6 = true;
                break;
                break;
            }
        }
        return z6 ? 1 : 0;
    }

    public PdfContentByte getCanvas() {
        return this.canvas;
    }

    public void setCanvas(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
        this.canvases = null;
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvas(pdfContentByte);
        }
    }

    public void setCanvases(PdfContentByte[] pdfContentByteArr) {
        this.canvases = pdfContentByteArr;
        this.canvas = pdfContentByteArr[3];
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvases(pdfContentByteArr);
        }
    }

    public PdfContentByte[] getCanvases() {
        return this.canvases;
    }

    public boolean zeroHeightElement() {
        return this.composite && !this.compositeElements.isEmpty() && this.compositeElements.getFirst().type() == 55;
    }

    public java.util.List<Element> getCompositeElements() {
        return this.compositeElements;
    }

    public boolean isUseAscender() {
        return this.useAscender;
    }

    public void setUseAscender(boolean z) {
        this.useAscender = z;
    }

    public float getFilledWidth() {
        return this.filledWidth;
    }

    public void setFilledWidth(float f) {
        this.filledWidth = f;
    }

    public void updateFilledWidth(float f) {
        if (f > this.filledWidth) {
            this.filledWidth = f;
        }
    }

    public boolean isAdjustFirstLine() {
        return this.adjustFirstLine;
    }

    public void setAdjustFirstLine(boolean z) {
        this.adjustFirstLine = z;
    }
}
