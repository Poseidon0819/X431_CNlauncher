package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfString;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GifImage {
    protected static final int MaxStackSize = 4096;
    protected int bgColor;
    protected int bgIndex;
    protected byte[] block;
    protected int blockSize;
    protected int delay;
    protected int dispose;
    protected ArrayList<GifFrame> frames;
    protected byte[] fromData;
    protected URL fromUrl;
    protected boolean gctFlag;
    protected int height;

    /* renamed from: ih */
    protected int f19813ih;

    /* renamed from: in */
    protected DataInputStream f19814in;
    protected boolean interlace;

    /* renamed from: iw */
    protected int f19815iw;

    /* renamed from: ix */
    protected int f19816ix;

    /* renamed from: iy */
    protected int f19817iy;
    protected boolean lctFlag;
    protected int lctSize;
    protected int m_bpc;
    protected byte[] m_curr_table;
    protected int m_gbpc;
    protected byte[] m_global_table;
    protected int m_line_stride;
    protected byte[] m_local_table;
    protected byte[] m_out;
    protected int pixelAspect;
    protected byte[] pixelStack;
    protected byte[] pixels;
    protected short[] prefix;
    protected byte[] suffix;
    protected int transIndex;
    protected boolean transparency;
    protected int width;

    protected static int newBpc(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
                return i;
            case 3:
                return 4;
            default:
                return 8;
        }
    }

    protected void resetFrame() {
    }

    public GifImage(URL url) throws IOException {
        InputStream inputStream;
        this.block = new byte[256];
        this.blockSize = 0;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.frames = new ArrayList<>();
        this.fromUrl = url;
        try {
            inputStream = url.openStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            process(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public GifImage(String str) throws IOException {
        this(Utilities.toURL(str));
    }

    public GifImage(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream;
        this.block = new byte[256];
        this.blockSize = 0;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.frames = new ArrayList<>();
        this.fromData = bArr;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
        } catch (Throwable th) {
            th = th;
        }
        try {
            process(byteArrayInputStream);
            byteArrayInputStream.close();
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream2 = byteArrayInputStream;
            if (byteArrayInputStream2 != null) {
                byteArrayInputStream2.close();
            }
            throw th;
        }
    }

    public GifImage(InputStream inputStream) throws IOException {
        this.block = new byte[256];
        this.blockSize = 0;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.frames = new ArrayList<>();
        process(inputStream);
    }

    public int getFrameCount() {
        return this.frames.size();
    }

    public Image getImage(int i) {
        return this.frames.get(i - 1).image;
    }

    public int[] getFramePosition(int i) {
        GifFrame gifFrame = this.frames.get(i - 1);
        return new int[]{gifFrame.f19818ix, gifFrame.f19819iy};
    }

    public int[] getLogicalScreen() {
        return new int[]{this.width, this.height};
    }

    void process(InputStream inputStream) throws IOException {
        this.f19814in = new DataInputStream(new BufferedInputStream(inputStream));
        readHeader();
        readContents();
        if (this.frames.isEmpty()) {
            throw new IOException(MessageLocalization.getComposedMessage("the.file.does.not.contain.any.valid.image", new Object[0]));
        }
    }

    protected void readHeader() throws IOException {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 6; i++) {
            sb.append((char) this.f19814in.read());
        }
        if (!sb.toString().startsWith("GIF8")) {
            throw new IOException(MessageLocalization.getComposedMessage("gif.signature.nor.found", new Object[0]));
        }
        readLSD();
        if (this.gctFlag) {
            this.m_global_table = readColorTable(this.m_gbpc);
        }
    }

    protected void readLSD() throws IOException {
        this.width = readShort();
        this.height = readShort();
        int read = this.f19814in.read();
        this.gctFlag = (read & 128) != 0;
        this.m_gbpc = (read & 7) + 1;
        this.bgIndex = this.f19814in.read();
        this.pixelAspect = this.f19814in.read();
    }

    protected int readShort() throws IOException {
        return this.f19814in.read() | (this.f19814in.read() << 8);
    }

    protected int readBlock() throws IOException {
        this.blockSize = this.f19814in.read();
        int i = this.blockSize;
        if (i <= 0) {
            this.blockSize = 0;
            return 0;
        }
        this.blockSize = this.f19814in.read(this.block, 0, i);
        return this.blockSize;
    }

    protected byte[] readColorTable(int i) throws IOException {
        byte[] bArr = new byte[(1 << newBpc(i)) * 3];
        this.f19814in.readFully(bArr, 0, (1 << i) * 3);
        return bArr;
    }

    protected void readContents() throws IOException {
        boolean z = false;
        while (!z) {
            int read = this.f19814in.read();
            if (read == 33) {
                int read2 = this.f19814in.read();
                if (read2 == 249) {
                    readGraphicControlExt();
                } else if (read2 == 255) {
                    readBlock();
                    skip();
                } else {
                    skip();
                }
            } else if (read != 44) {
                z = true;
            } else {
                readImage();
            }
        }
    }

    protected void readImage() throws IOException {
        this.f19816ix = readShort();
        this.f19817iy = readShort();
        this.f19815iw = readShort();
        this.f19813ih = readShort();
        int read = this.f19814in.read();
        this.lctFlag = (read & 128) != 0;
        this.interlace = (read & 64) != 0;
        int i = read & 7;
        this.lctSize = 2 << i;
        this.m_bpc = newBpc(this.m_gbpc);
        if (this.lctFlag) {
            int i2 = i + 1;
            this.m_curr_table = readColorTable(i2);
            this.m_bpc = newBpc(i2);
        } else {
            this.m_curr_table = this.m_global_table;
        }
        if (this.transparency && this.transIndex >= this.m_curr_table.length / 3) {
            this.transparency = false;
        }
        if (this.transparency && this.m_bpc == 1) {
            byte[] bArr = new byte[12];
            System.arraycopy(this.m_curr_table, 0, bArr, 0, 6);
            this.m_curr_table = bArr;
            this.m_bpc = 2;
        }
        if (!decodeImageData()) {
            skip();
        }
        try {
            ImgRaw imgRaw = new ImgRaw(this.f19815iw, this.f19813ih, 1, this.m_bpc, this.m_out);
            PdfArray pdfArray = new PdfArray();
            pdfArray.add(PdfName.INDEXED);
            pdfArray.add(PdfName.DEVICERGB);
            pdfArray.add(new PdfNumber((this.m_curr_table.length / 3) - 1));
            pdfArray.add(new PdfString(this.m_curr_table));
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.COLORSPACE, pdfArray);
            imgRaw.setAdditional(pdfDictionary);
            if (this.transparency) {
                imgRaw.setTransparency(new int[]{this.transIndex, this.transIndex});
            }
            imgRaw.setOriginalType(3);
            imgRaw.setOriginalData(this.fromData);
            imgRaw.setUrl(this.fromUrl);
            GifFrame gifFrame = new GifFrame();
            gifFrame.image = imgRaw;
            gifFrame.f19818ix = this.f19816ix;
            gifFrame.f19819iy = this.f19817iy;
            this.frames.add(gifFrame);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v18 */
    protected boolean decodeImageData() throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        short s;
        int i6;
        int i7 = this.f19815iw * this.f19813ih;
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        this.m_line_stride = ((this.f19815iw * this.m_bpc) + 7) / 8;
        this.m_out = new byte[this.m_line_stride * this.f19813ih];
        int i8 = this.interlace ? 8 : 1;
        int read = this.f19814in.read();
        int i9 = 1 << read;
        int i10 = i9 + 1;
        int i11 = i9 + 2;
        int i12 = read + 1;
        int i13 = (1 << i12) - 1;
        for (int i14 = 0; i14 < i9; i14++) {
            this.prefix[i14] = 0;
            this.suffix[i14] = (byte) i14;
        }
        int i15 = i12;
        int i16 = i8;
        int i17 = i11;
        int i18 = i13;
        short s2 = -1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        short s3 = 0;
        int i25 = 1;
        int i26 = 0;
        int i27 = 0;
        while (i19 < i7) {
            if (i20 != 0) {
                i = i7;
                i2 = i12;
                i3 = i9;
                i4 = -1;
            } else if (i21 >= i15) {
                int i28 = i22 & i18;
                i22 >>= i15;
                i21 -= i15;
                if (i28 <= i17 && i28 != i10) {
                    if (i28 == i9) {
                        i15 = i12;
                        i17 = i11;
                        i18 = i13;
                        s2 = -1;
                    } else if (s2 == -1) {
                        this.pixelStack[i20] = this.suffix[i28];
                        s2 = i28;
                        s3 = s2;
                        i20++;
                        i7 = i7;
                    } else {
                        i = i7;
                        if (i28 == i17) {
                            i6 = i20 + 1;
                            i2 = i12;
                            this.pixelStack[i20] = (byte) s3;
                            s = s2;
                        } else {
                            i2 = i12;
                            s = i28;
                            i6 = i20;
                        }
                        while (s > i9) {
                            this.pixelStack[i6] = this.suffix[s];
                            s = this.prefix[s];
                            i6++;
                            i28 = i28;
                        }
                        short s4 = i28;
                        byte[] bArr = this.suffix;
                        ?? r1 = bArr[s] & 255;
                        if (i17 < 4096) {
                            byte[] bArr2 = this.pixelStack;
                            i20 = i6 + 1;
                            i3 = i9;
                            byte b = r1 == true ? (byte) 1 : (byte) 0;
                            bArr2[i6] = b;
                            this.prefix[i17] = s2;
                            bArr[i17] = b;
                            i17++;
                            if ((i17 & i18) == 0 && i17 < 4096) {
                                i15++;
                                i18 += i17;
                            }
                            s2 = s4;
                            s3 = r1 == true ? 1 : 0;
                            i4 = -1;
                        }
                    }
                }
                return false;
            } else {
                if (i23 == 0) {
                    i23 = readBlock();
                    if (i23 <= 0) {
                        return true;
                    }
                    i24 = 0;
                }
                i22 += (this.block[i24] & 255) << i21;
                i21 += 8;
                i24++;
                i23--;
            }
            i20 += i4;
            i19++;
            int i29 = i26;
            int i30 = i27;
            setPixel(i30, i29, this.pixelStack[i20]);
            int i31 = i30 + 1;
            if (i31 >= this.f19815iw) {
                int i32 = i29 + i16;
                int i33 = this.f19813ih;
                if (i32 < i33) {
                    i26 = i32;
                    i7 = i;
                    i12 = i2;
                    i9 = i3;
                    i27 = 0;
                } else if (this.interlace) {
                    do {
                        i25++;
                        i5 = 4;
                        switch (i25) {
                            case 2:
                                break;
                            case 3:
                                i5 = 2;
                                i16 = 4;
                                break;
                            case 4:
                                i5 = 1;
                                i16 = 2;
                                break;
                            default:
                                i5 = this.f19813ih - 1;
                                i16 = 0;
                                break;
                        }
                    } while (i5 >= this.f19813ih);
                    i26 = i5;
                    i7 = i;
                    i12 = i2;
                    i9 = i3;
                    i27 = 0;
                } else {
                    i26 = i33 - 1;
                    i7 = i;
                    i12 = i2;
                    i9 = i3;
                    i16 = 0;
                    i27 = 0;
                }
            } else {
                i27 = i31;
                i26 = i29;
                i7 = i;
                i12 = i2;
                i9 = i3;
            }
        }
        return false;
    }

    protected void setPixel(int i, int i2, int i3) {
        int i4 = this.m_bpc;
        if (i4 == 8) {
            this.m_out[i + (this.f19815iw * i2)] = (byte) i3;
            return;
        }
        int i5 = (this.m_line_stride * i2) + (i / (8 / i4));
        byte[] bArr = this.m_out;
        bArr[i5] = (byte) ((i3 << ((8 - ((i % (8 / i4)) * i4)) - i4)) | bArr[i5]);
    }

    protected void readGraphicControlExt() throws IOException {
        this.f19814in.read();
        int read = this.f19814in.read();
        this.dispose = (read & 28) >> 2;
        if (this.dispose == 0) {
            this.dispose = 1;
        }
        this.transparency = (read & 1) != 0;
        this.delay = readShort() * 10;
        this.transIndex = this.f19814in.read();
        this.f19814in.read();
    }

    protected void skip() throws IOException {
        do {
            readBlock();
        } while (this.blockSize > 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GifFrame {
        Image image;

        /* renamed from: ix */
        int f19818ix;

        /* renamed from: iy */
        int f19819iy;

        GifFrame() {
        }
    }
}
