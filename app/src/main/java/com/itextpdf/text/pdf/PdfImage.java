package com.itextpdf.text.pdf;

import com.itextpdf.text.Image;
import com.itextpdf.text.html.HtmlTags;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class PdfImage extends PdfStream {
    static final int TRANSFERSIZE = 4096;
    protected PdfName name;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:144:0x0385
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public PdfImage(com.itextpdf.text.Image r9, java.lang.String r10, com.itextpdf.text.pdf.PdfIndirectReference r11) throws com.itextpdf.text.pdf.BadPdfFormatException {
        /*
            Method dump skipped, instructions count: 936
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfImage.<init>(com.itextpdf.text.Image, java.lang.String, com.itextpdf.text.pdf.PdfIndirectReference):void");
    }

    public PdfName name() {
        return this.name;
    }

    static void transferBytes(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[4096];
        if (i < 0) {
            i = 2147418112;
        }
        while (i != 0) {
            int read = inputStream.read(bArr, 0, Math.min(i, 4096));
            if (read < 0) {
                return;
            }
            outputStream.write(bArr, 0, read);
            i -= read;
        }
    }

    protected void importAll(PdfImage pdfImage) {
        this.name = pdfImage.name;
        this.compressed = pdfImage.compressed;
        this.compressionLevel = pdfImage.compressionLevel;
        this.streamBytes = pdfImage.streamBytes;
        this.bytes = pdfImage.bytes;
        this.hashMap = pdfImage.hashMap;
    }

    private void generateImgResName(Image image) {
        this.name = new PdfName(HtmlTags.IMG + Long.toHexString(image.getMySerialId().longValue()));
    }
}
