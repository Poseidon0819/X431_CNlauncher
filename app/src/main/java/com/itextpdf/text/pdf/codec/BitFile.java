package com.itextpdf.text.pdf.codec;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class BitFile {
    boolean blocks_;
    OutputStream output_;
    byte[] buffer_ = new byte[256];
    int index_ = 0;
    int bitsLeft_ = 8;

    public BitFile(OutputStream outputStream, boolean z) {
        this.blocks_ = false;
        this.output_ = outputStream;
        this.blocks_ = z;
    }

    public void flush() throws IOException {
        int i = this.index_ + (this.bitsLeft_ == 8 ? 0 : 1);
        if (i > 0) {
            if (this.blocks_) {
                this.output_.write(i);
            }
            this.output_.write(this.buffer_, 0, i);
            this.buffer_[0] = 0;
            this.index_ = 0;
            this.bitsLeft_ = 8;
        }
    }

    public void writeBits(int i, int i2) throws IOException {
        do {
            if ((this.index_ == 254 && this.bitsLeft_ == 0) || this.index_ > 254) {
                if (this.blocks_) {
                    this.output_.write(255);
                }
                this.output_.write(this.buffer_, 0, 255);
                this.buffer_[0] = 0;
                this.index_ = 0;
                this.bitsLeft_ = 8;
            }
            int i3 = this.bitsLeft_;
            if (i2 <= i3) {
                if (this.blocks_) {
                    byte[] bArr = this.buffer_;
                    int i4 = this.index_;
                    bArr[i4] = (byte) (((i & ((1 << i2) - 1)) << (8 - i3)) | bArr[i4]);
                    this.bitsLeft_ = i3 - i2;
                    i2 = 0;
                    continue;
                } else {
                    byte[] bArr2 = this.buffer_;
                    int i5 = this.index_;
                    bArr2[i5] = (byte) (((i & ((1 << i2) - 1)) << (i3 - i2)) | bArr2[i5]);
                    this.bitsLeft_ = i3 - i2;
                    i2 = 0;
                    continue;
                }
            } else if (this.blocks_) {
                byte[] bArr3 = this.buffer_;
                int i6 = this.index_;
                bArr3[i6] = (byte) (bArr3[i6] | ((((1 << i3) - 1) & i) << (8 - i3)));
                i >>= i3;
                i2 -= i3;
                int i7 = i6 + 1;
                this.index_ = i7;
                bArr3[i7] = 0;
                this.bitsLeft_ = 8;
                continue;
            } else {
                byte[] bArr4 = this.buffer_;
                int i8 = this.index_;
                bArr4[i8] = (byte) (((i >>> (i2 - i3)) & ((1 << i3) - 1)) | bArr4[i8]);
                i2 -= i3;
                int i9 = i8 + 1;
                this.index_ = i9;
                bArr4[i9] = 0;
                this.bitsLeft_ = 8;
                continue;
            }
        } while (i2 != 0);
    }
}
