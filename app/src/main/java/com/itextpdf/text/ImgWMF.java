package com.itextpdf.text;

import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class ImgWMF extends Image {
    ImgWMF(Image image) {
        super(image);
    }

    public ImgWMF(URL url) throws BadElementException, IOException {
        super(url);
        processParameters();
    }

    public ImgWMF(String str) throws BadElementException, MalformedURLException, IOException {
        this(Utilities.toURL(str));
    }

    public ImgWMF(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x008f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private void processParameters() throws com.itextpdf.text.BadElementException, java.io.IOException {
        /*
            r8 = this;
            r0 = 35
            r8.type = r0
            r0 = 6
            r8.originalType = r0
            r0 = 0
            byte[] r1 = r8.rawData     // Catch: java.lang.Throwable -> L94
            if (r1 != 0) goto L19
            java.net.URL r1 = r8.url     // Catch: java.lang.Throwable -> L94
            java.io.InputStream r0 = r1.openStream()     // Catch: java.lang.Throwable -> L94
            java.net.URL r1 = r8.url     // Catch: java.lang.Throwable -> L94
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L94
            goto L25
        L19:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L94
            byte[] r2 = r8.rawData     // Catch: java.lang.Throwable -> L94
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L94
            java.lang.String r0 = "Byte array"
            r7 = r1
            r1 = r0
            r0 = r7
        L25:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = new com.itextpdf.text.pdf.codec.wmf.InputMeta     // Catch: java.lang.Throwable -> L94
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L94
            int r3 = r2.readInt()     // Catch: java.lang.Throwable -> L94
            r4 = -1698247209(0xffffffff9ac6cdd7, float:-8.222343E-23)
            if (r3 != r4) goto L7d
            r2.readWord()     // Catch: java.lang.Throwable -> L94
            int r1 = r2.readShort()     // Catch: java.lang.Throwable -> L94
            int r3 = r2.readShort()     // Catch: java.lang.Throwable -> L94
            int r4 = r2.readShort()     // Catch: java.lang.Throwable -> L94
            int r5 = r2.readShort()     // Catch: java.lang.Throwable -> L94
            int r2 = r2.readWord()     // Catch: java.lang.Throwable -> L94
            r6 = 72
            r8.dpiX = r6     // Catch: java.lang.Throwable -> L94
            r8.dpiY = r6     // Catch: java.lang.Throwable -> L94
            int r5 = r5 - r3
            float r3 = (float) r5     // Catch: java.lang.Throwable -> L94
            float r2 = (float) r2     // Catch: java.lang.Throwable -> L94
            float r3 = r3 / r2
            r5 = 1116733440(0x42900000, float:72.0)
            float r3 = r3 * r5
            r8.scaledHeight = r3     // Catch: java.lang.Throwable -> L94
            float r3 = r8.scaledHeight     // Catch: java.lang.Throwable -> L94
            r8.setTop(r3)     // Catch: java.lang.Throwable -> L94
            int r4 = r4 - r1
            float r1 = (float) r4     // Catch: java.lang.Throwable -> L94
            float r1 = r1 / r2
            float r1 = r1 * r5
            r8.scaledWidth = r1     // Catch: java.lang.Throwable -> L94
            float r1 = r8.scaledWidth     // Catch: java.lang.Throwable -> L94
            r8.setRight(r1)     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto L70
            r0.close()
        L70:
            float r0 = r8.getWidth()
            r8.plainWidth = r0
            float r0 = r8.getHeight()
            r8.plainHeight = r0
            return
        L7d:
            com.itextpdf.text.BadElementException r2 = new com.itextpdf.text.BadElementException     // Catch: java.lang.Throwable -> L94
            java.lang.String r3 = "1.is.not.a.valid.placeable.windows.metafile"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L94
            r5 = 0
            r4[r5] = r1     // Catch: java.lang.Throwable -> L94
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage(r3, r4)     // Catch: java.lang.Throwable -> L94
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L94
            throw r2     // Catch: java.lang.Throwable -> L94
        L8f:
            r0 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L95
        L94:
            r1 = move-exception
        L95:
            if (r0 == 0) goto L9a
            r0.close()
        L9a:
            float r0 = r8.getWidth()
            r8.plainWidth = r0
            float r0 = r8.getHeight()
            r8.plainHeight = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.ImgWMF.processParameters():void");
    }

    public void readWMF(PdfTemplate pdfTemplate) throws IOException, DocumentException {
        setTemplateData(pdfTemplate);
        pdfTemplate.setWidth(getWidth());
        pdfTemplate.setHeight(getHeight());
        InputStream inputStream = null;
        try {
            if (this.rawData == null) {
                inputStream = this.url.openStream();
            } else {
                inputStream = new ByteArrayInputStream(this.rawData);
            }
            new MetaDo(inputStream, pdfTemplate).readAll();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
