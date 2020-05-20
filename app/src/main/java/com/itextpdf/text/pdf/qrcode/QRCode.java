package com.itextpdf.text.pdf.qrcode;

import com.itextpdf.text.pdf.PdfContentParser;

/* loaded from: classes.dex */
public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;
    private Mode mode = null;
    private ErrorCorrectionLevel ecLevel = null;
    private int version = -1;
    private int matrixWidth = -1;
    private int maskPattern = -1;
    private int numTotalBytes = -1;
    private int numDataBytes = -1;
    private int numECBytes = -1;
    private int numRSBlocks = -1;
    private ByteMatrix matrix = null;

    public static boolean isValidMaskPattern(int i) {
        return i >= 0 && i < 8;
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final ErrorCorrectionLevel getECLevel() {
        return this.ecLevel;
    }

    public final int getVersion() {
        return this.version;
    }

    public final int getMatrixWidth() {
        return this.matrixWidth;
    }

    public final int getMaskPattern() {
        return this.maskPattern;
    }

    public final int getNumTotalBytes() {
        return this.numTotalBytes;
    }

    public final int getNumDataBytes() {
        return this.numDataBytes;
    }

    public final int getNumECBytes() {
        return this.numECBytes;
    }

    public final int getNumRSBlocks() {
        return this.numRSBlocks;
    }

    public final ByteMatrix getMatrix() {
        return this.matrix;
    }

    /* renamed from: at */
    public final int m2708at(int i, int i2) {
        byte b = this.matrix.get(i, i2);
        if (b == 0 || b == 1) {
            return b;
        }
        throw new RuntimeException("Bad value");
    }

    public final boolean isValid() {
        int i;
        ByteMatrix byteMatrix;
        return (this.mode == null || this.ecLevel == null || this.version == -1 || this.matrixWidth == -1 || (i = this.maskPattern) == -1 || this.numTotalBytes == -1 || this.numDataBytes == -1 || this.numECBytes == -1 || this.numRSBlocks == -1 || !isValidMaskPattern(i) || this.numTotalBytes != this.numDataBytes + this.numECBytes || (byteMatrix = this.matrix) == null || this.matrixWidth != byteMatrix.getWidth() || this.matrix.getWidth() != this.matrix.getHeight()) ? false : true;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer((int) PdfContentParser.COMMAND_TYPE);
        stringBuffer.append("<<\n");
        stringBuffer.append(" mode: ");
        stringBuffer.append(this.mode);
        stringBuffer.append("\n ecLevel: ");
        stringBuffer.append(this.ecLevel);
        stringBuffer.append("\n version: ");
        stringBuffer.append(this.version);
        stringBuffer.append("\n matrixWidth: ");
        stringBuffer.append(this.matrixWidth);
        stringBuffer.append("\n maskPattern: ");
        stringBuffer.append(this.maskPattern);
        stringBuffer.append("\n numTotalBytes: ");
        stringBuffer.append(this.numTotalBytes);
        stringBuffer.append("\n numDataBytes: ");
        stringBuffer.append(this.numDataBytes);
        stringBuffer.append("\n numECBytes: ");
        stringBuffer.append(this.numECBytes);
        stringBuffer.append("\n numRSBlocks: ");
        stringBuffer.append(this.numRSBlocks);
        if (this.matrix == null) {
            stringBuffer.append("\n matrix: null\n");
        } else {
            stringBuffer.append("\n matrix:\n");
            stringBuffer.append(this.matrix.toString());
        }
        stringBuffer.append(">>\n");
        return stringBuffer.toString();
    }

    public final void setMode(Mode mode) {
        this.mode = mode;
    }

    public final void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.ecLevel = errorCorrectionLevel;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    public final void setMatrixWidth(int i) {
        this.matrixWidth = i;
    }

    public final void setMaskPattern(int i) {
        this.maskPattern = i;
    }

    public final void setNumTotalBytes(int i) {
        this.numTotalBytes = i;
    }

    public final void setNumDataBytes(int i) {
        this.numDataBytes = i;
    }

    public final void setNumECBytes(int i) {
        this.numECBytes = i;
    }

    public final void setNumRSBlocks(int i) {
        this.numRSBlocks = i;
    }

    public final void setMatrix(ByteMatrix byteMatrix) {
        this.matrix = byteMatrix;
    }
}
