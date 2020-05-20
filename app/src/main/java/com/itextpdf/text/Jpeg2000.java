package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes.dex */
public class Jpeg2000 extends Image {
    public static final int JP2_BPCC = 1651532643;
    public static final int JP2_COLR = 1668246642;
    public static final int JP2_DBTL = 1685348972;
    public static final int JP2_FTYP = 1718909296;
    public static final int JP2_IHDR = 1768449138;
    public static final int JP2_JP = 1783636000;
    public static final int JP2_JP2 = 1785737760;
    public static final int JP2_JP2C = 1785737827;
    public static final int JP2_JP2H = 1785737832;
    public static final int JP2_URL = 1970433056;
    public static final int JPIP_JPIP = 1785751920;
    int boxLength;
    int boxType;
    InputStream inp;

    Jpeg2000(Image image) {
        super(image);
    }

    public Jpeg2000(URL url) throws BadElementException, IOException {
        super(url);
        processParameters();
    }

    public Jpeg2000(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }

    public Jpeg2000(byte[] bArr, float f, float f2) throws BadElementException, IOException {
        this(bArr);
        this.scaledWidth = f;
        this.scaledHeight = f2;
    }

    private int cio_read(int i) throws IOException {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            i2 += this.inp.read() << (i3 << 3);
        }
        return i2;
    }

    public void jp2_read_boxhdr() throws IOException {
        this.boxLength = cio_read(4);
        this.boxType = cio_read(4);
        int i = this.boxLength;
        if (i != 1) {
            if (i == 0) {
                throw new IOException(MessageLocalization.getComposedMessage("unsupported.box.size.eq.eq.0", new Object[0]));
            }
        } else if (cio_read(4) != 0) {
            throw new IOException(MessageLocalization.getComposedMessage("cannot.handle.box.sizes.higher.than.2.32", new Object[0]));
        } else {
            this.boxLength = cio_read(4);
            if (this.boxLength == 0) {
                throw new IOException(MessageLocalization.getComposedMessage("unsupported.box.size.eq.eq.0", new Object[0]));
            }
        }
    }

    private void processParameters() throws IOException {
        this.type = 33;
        this.originalType = 8;
        this.inp = null;
        try {
            if (this.rawData == null) {
                this.inp = this.url.openStream();
            } else {
                this.inp = new ByteArrayInputStream(this.rawData);
            }
            this.boxLength = cio_read(4);
            if (this.boxLength == 12) {
                this.boxType = cio_read(4);
                if (1783636000 != this.boxType) {
                    throw new IOException(MessageLocalization.getComposedMessage("expected.jp.marker", new Object[0]));
                }
                if (218793738 != cio_read(4)) {
                    throw new IOException(MessageLocalization.getComposedMessage("error.with.jp.marker", new Object[0]));
                }
                jp2_read_boxhdr();
                if (1718909296 != this.boxType) {
                    throw new IOException(MessageLocalization.getComposedMessage("expected.ftyp.marker", new Object[0]));
                }
                Utilities.skip(this.inp, this.boxLength - 8);
                jp2_read_boxhdr();
                do {
                    if (1785737832 != this.boxType) {
                        if (this.boxType == 1785737827) {
                            throw new IOException(MessageLocalization.getComposedMessage("expected.jp2h.marker", new Object[0]));
                        }
                        Utilities.skip(this.inp, this.boxLength - 8);
                        jp2_read_boxhdr();
                    }
                } while (1785737832 != this.boxType);
                jp2_read_boxhdr();
                if (1768449138 != this.boxType) {
                    throw new IOException(MessageLocalization.getComposedMessage("expected.ihdr.marker", new Object[0]));
                }
                this.scaledHeight = cio_read(4);
                setTop(this.scaledHeight);
                this.scaledWidth = cio_read(4);
                setRight(this.scaledWidth);
                this.bpc = -1;
            } else if (this.boxLength == -11534511) {
                Utilities.skip(this.inp, 4);
                int cio_read = cio_read(4);
                int cio_read2 = cio_read(4);
                int cio_read3 = cio_read(4);
                int cio_read4 = cio_read(4);
                Utilities.skip(this.inp, 16);
                this.colorspace = cio_read(2);
                this.bpc = 8;
                this.scaledHeight = cio_read2 - cio_read4;
                setTop(this.scaledHeight);
                this.scaledWidth = cio_read - cio_read3;
                setRight(this.scaledWidth);
            } else {
                throw new IOException(MessageLocalization.getComposedMessage("not.a.valid.jpeg2000.file", new Object[0]));
            }
            this.plainWidth = getWidth();
            this.plainHeight = getHeight();
        } finally {
            InputStream inputStream = this.inp;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
                this.inp = null;
            }
        }
    }
}
