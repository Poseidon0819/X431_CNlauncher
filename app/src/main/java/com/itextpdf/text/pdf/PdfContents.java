package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PdfContents extends PdfStream {
    static final byte[] SAVESTATE = DocWriter.getISOBytes("q\n");
    static final byte[] RESTORESTATE = DocWriter.getISOBytes("Q\n");
    static final byte[] ROTATE90 = DocWriter.getISOBytes("0 1 -1 0 ");
    static final byte[] ROTATE180 = DocWriter.getISOBytes("-1 0 0 -1 ");
    static final byte[] ROTATE270 = DocWriter.getISOBytes("0 -1 1 0 ");
    static final byte[] ROTATEFINAL = DocWriter.getISOBytes(" cm\n");

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfContents(PdfContentByte pdfContentByte, PdfContentByte pdfContentByte2, PdfContentByte pdfContentByte3, PdfContentByte pdfContentByte4, Rectangle rectangle) throws BadPdfFormatException {
        OutputStream outputStream;
        Deflater deflater = null;
        try {
            this.streamBytes = new ByteArrayOutputStream();
            if (Document.compress) {
                this.compressed = true;
                this.compressionLevel = pdfContentByte3.getPdfWriter().getCompressionLevel();
                deflater = new Deflater(this.compressionLevel);
                outputStream = new DeflaterOutputStream(this.streamBytes, deflater);
            } else {
                outputStream = this.streamBytes;
            }
            int rotation = rectangle.getRotation();
            if (rotation == 90) {
                outputStream.write(ROTATE90);
                outputStream.write(DocWriter.getISOBytes(ByteBuffer.formatDouble(rectangle.getTop())));
                outputStream.write(32);
                outputStream.write(48);
                outputStream.write(ROTATEFINAL);
            } else if (rotation == 180) {
                outputStream.write(ROTATE180);
                outputStream.write(DocWriter.getISOBytes(ByteBuffer.formatDouble(rectangle.getRight())));
                outputStream.write(32);
                outputStream.write(DocWriter.getISOBytes(ByteBuffer.formatDouble(rectangle.getTop())));
                outputStream.write(ROTATEFINAL);
            } else if (rotation == 270) {
                outputStream.write(ROTATE270);
                outputStream.write(48);
                outputStream.write(32);
                outputStream.write(DocWriter.getISOBytes(ByteBuffer.formatDouble(rectangle.getRight())));
                outputStream.write(ROTATEFINAL);
            }
            if (pdfContentByte.size() > 0) {
                outputStream.write(SAVESTATE);
                pdfContentByte.getInternalBuffer().writeTo(outputStream);
                outputStream.write(RESTORESTATE);
            }
            if (pdfContentByte2.size() > 0) {
                outputStream.write(SAVESTATE);
                pdfContentByte2.getInternalBuffer().writeTo(outputStream);
                outputStream.write(RESTORESTATE);
            }
            if (pdfContentByte3 != null) {
                outputStream.write(SAVESTATE);
                pdfContentByte3.getInternalBuffer().writeTo(outputStream);
                outputStream.write(RESTORESTATE);
            }
            if (pdfContentByte4.size() > 0) {
                pdfContentByte4.getInternalBuffer().writeTo(outputStream);
            }
            outputStream.close();
            if (deflater != null) {
                deflater.end();
            }
            put(PdfName.LENGTH, new PdfNumber(this.streamBytes.size()));
            if (this.compressed) {
                put(PdfName.FILTER, PdfName.FLATEDECODE);
            }
        } catch (Exception e) {
            throw new BadPdfFormatException(e.getMessage());
        }
    }
}
