package com.itextpdf.text.pdf.qrcode;

/* loaded from: classes.dex */
final class BlockPair {
    private final ByteArray dataBytes;
    private final ByteArray errorCorrectionBytes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockPair(ByteArray byteArray, ByteArray byteArray2) {
        this.dataBytes = byteArray;
        this.errorCorrectionBytes = byteArray2;
    }

    public final ByteArray getDataBytes() {
        return this.dataBytes;
    }

    public final ByteArray getErrorCorrectionBytes() {
        return this.errorCorrectionBytes;
    }
}
