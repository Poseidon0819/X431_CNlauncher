package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.crypto.AESCipher;
import com.itextpdf.text.pdf.crypto.ARCFOUREncryption;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class OutputStreamEncryption extends OutputStream {
    private static final int AES_128 = 4;
    private static final int AES_256 = 5;
    private boolean aes;
    protected ARCFOUREncryption arcfour;
    protected AESCipher cipher;
    private boolean finished;
    protected OutputStream out;

    /* renamed from: sb */
    private byte[] f19672sb;

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:3:0x0008, B:10:0x0015, B:12:0x001b, B:14:0x002f), top: B:19:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[Catch: Exception -> 0x003c, TRY_LEAVE, TryCatch #0 {Exception -> 0x003c, blocks: (B:3:0x0008, B:10:0x0015, B:12:0x001b, B:14:0x002f), top: B:19:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public OutputStreamEncryption(java.io.OutputStream r3, byte[] r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 1
            byte[] r1 = new byte[r0]
            r2.f19672sb = r1
            r2.out = r3     // Catch: java.lang.Exception -> L3c
            r3 = 4
            r1 = 0
            if (r7 == r3) goto L14
            r3 = 5
            if (r7 != r3) goto L12
            goto L14
        L12:
            r3 = 0
            goto L15
        L14:
            r3 = 1
        L15:
            r2.aes = r3     // Catch: java.lang.Exception -> L3c
            boolean r3 = r2.aes     // Catch: java.lang.Exception -> L3c
            if (r3 == 0) goto L2f
            byte[] r3 = com.itextpdf.text.pdf.crypto.IVGenerator.getIV()     // Catch: java.lang.Exception -> L3c
            byte[] r7 = new byte[r6]     // Catch: java.lang.Exception -> L3c
            java.lang.System.arraycopy(r4, r5, r7, r1, r6)     // Catch: java.lang.Exception -> L3c
            com.itextpdf.text.pdf.crypto.AESCipher r4 = new com.itextpdf.text.pdf.crypto.AESCipher     // Catch: java.lang.Exception -> L3c
            r4.<init>(r0, r7, r3)     // Catch: java.lang.Exception -> L3c
            r2.cipher = r4     // Catch: java.lang.Exception -> L3c
            r2.write(r3)     // Catch: java.lang.Exception -> L3c
            return
        L2f:
            com.itextpdf.text.pdf.crypto.ARCFOUREncryption r3 = new com.itextpdf.text.pdf.crypto.ARCFOUREncryption     // Catch: java.lang.Exception -> L3c
            r3.<init>()     // Catch: java.lang.Exception -> L3c
            r2.arcfour = r3     // Catch: java.lang.Exception -> L3c
            com.itextpdf.text.pdf.crypto.ARCFOUREncryption r3 = r2.arcfour     // Catch: java.lang.Exception -> L3c
            r3.prepareARCFOURKey(r4, r5, r6)     // Catch: java.lang.Exception -> L3c
            return
        L3c:
            r3 = move-exception
            com.itextpdf.text.ExceptionConverter r4 = new com.itextpdf.text.ExceptionConverter
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.OutputStreamEncryption.<init>(java.io.OutputStream, byte[], int, int, int):void");
    }

    public OutputStreamEncryption(OutputStream outputStream, byte[] bArr, int i) {
        this(outputStream, bArr, 0, bArr.length, i);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f19672sb;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.aes) {
            byte[] update = this.cipher.update(bArr, i, i2);
            if (update == null || update.length == 0) {
                return;
            }
            this.out.write(update, 0, update.length);
            return;
        }
        byte[] bArr2 = new byte[Math.min(i2, 4192)];
        while (i2 > 0) {
            int min = Math.min(i2, bArr2.length);
            this.arcfour.encryptARCFOUR(bArr, i, min, bArr2, 0);
            this.out.write(bArr2, 0, min);
            i2 -= min;
            i += min;
        }
    }

    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        this.finished = true;
        if (this.aes) {
            try {
                byte[] doFinal = this.cipher.doFinal();
                this.out.write(doFinal, 0, doFinal.length);
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }
}
