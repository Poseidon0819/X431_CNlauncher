package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public class RandomAccessFileOrArray implements DataInput {
    byte[] arrayIn;
    long arrayInPtr;
    byte back;
    String filename;
    boolean isBack;
    boolean plainRandomAccess;

    /* renamed from: rf */
    MappedRandomAccessFile f19807rf;
    private long startOffset;
    RandomAccessFile trf;

    public RandomAccessFileOrArray(String str) throws IOException {
        this(str, false, Document.plainRandomAccess);
    }

    public RandomAccessFileOrArray(String str, boolean z, boolean z2) throws IOException {
        FileInputStream fileInputStream;
        Throwable th;
        this.isBack = false;
        this.startOffset = 0L;
        this.plainRandomAccess = z2;
        File file = new File(str);
        if (file.canRead()) {
            if (z) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th2) {
                    fileInputStream = null;
                    th = th2;
                }
                try {
                    this.arrayIn = InputStreamToArray(fileInputStream);
                    try {
                        fileInputStream.close();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            this.filename = str;
            openFile(str);
        } else if (str.startsWith("file:/") || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("jar:") || str.startsWith("wsjar:") || str.startsWith("wsjar:") || str.startsWith("vfszip:")) {
            InputStream openStream = new URL(str).openStream();
            try {
                this.arrayIn = InputStreamToArray(openStream);
            } finally {
                try {
                    openStream.close();
                } catch (IOException unused3) {
                }
            }
        } else {
            InputStream resourceStream = BaseFont.getResourceStream(str);
            if (resourceStream == null) {
                throw new IOException(MessageLocalization.getComposedMessage("1.not.found.as.file.or.resource", str));
            }
            try {
                this.arrayIn = InputStreamToArray(resourceStream);
            } finally {
                try {
                    resourceStream.close();
                } catch (IOException unused4) {
                }
            }
        }
    }

    private void openFile(String str) throws IOException {
        if (this.plainRandomAccess) {
            openForPlainRandomAccess(str);
            return;
        }
        try {
            this.f19807rf = new MappedRandomAccessFile(str, "r");
            this.trf = null;
        } catch (IOException e) {
            if (exceptionIsMapFailureException(e)) {
                openForPlainRandomAccess(str);
                return;
            }
            throw e;
        }
    }

    private void openForPlainRandomAccess(String str) throws FileNotFoundException {
        this.plainRandomAccess = true;
        this.trf = new RandomAccessFile(str, "r");
        this.f19807rf = null;
    }

    private static boolean exceptionIsMapFailureException(IOException iOException) {
        return iOException.getMessage() != null && iOException.getMessage().indexOf("Map failed") >= 0;
    }

    public RandomAccessFileOrArray(URL url) throws IOException {
        this.isBack = false;
        this.startOffset = 0L;
        InputStream openStream = url.openStream();
        try {
            this.arrayIn = InputStreamToArray(openStream);
        } finally {
            try {
                openStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public RandomAccessFileOrArray(InputStream inputStream) throws IOException {
        this.isBack = false;
        this.startOffset = 0L;
        this.arrayIn = InputStreamToArray(inputStream);
    }

    public static byte[] InputStreamToArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public RandomAccessFileOrArray(byte[] bArr) {
        this.isBack = false;
        this.startOffset = 0L;
        this.arrayIn = bArr;
    }

    public RandomAccessFileOrArray(RandomAccessFileOrArray randomAccessFileOrArray) {
        this.isBack = false;
        this.startOffset = 0L;
        this.filename = randomAccessFileOrArray.filename;
        this.arrayIn = randomAccessFileOrArray.arrayIn;
        this.startOffset = randomAccessFileOrArray.startOffset;
        this.plainRandomAccess = randomAccessFileOrArray.plainRandomAccess;
    }

    public void pushBack(byte b) {
        this.back = b;
        this.isBack = true;
    }

    public int read() throws IOException {
        if (this.isBack) {
            this.isBack = false;
            return this.back & 255;
        }
        byte[] bArr = this.arrayIn;
        if (bArr == null) {
            return this.plainRandomAccess ? this.trf.read() : this.f19807rf.read();
        }
        long j = this.arrayInPtr;
        if (j >= bArr.length) {
            return -1;
        }
        this.arrayInPtr = 1 + j;
        return bArr[(int) j] & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2;
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (this.isBack) {
            this.isBack = false;
            if (i2 == 1) {
                bArr[i] = this.back;
                return 1;
            }
            bArr[i] = this.back;
            i2--;
            i++;
            i3 = 1;
        }
        if (this.arrayIn == null) {
            return (this.plainRandomAccess ? this.trf.read(bArr, i, i2) : this.f19807rf.read(bArr, i, i2)) + i3;
        }
        long j = this.arrayInPtr;
        if (j >= bArr2.length) {
            return -1;
        }
        if (i2 + j > bArr2.length) {
            i2 = (int) (bArr2.length - j);
        }
        System.arraycopy(this.arrayIn, (int) this.arrayInPtr, bArr, i, i2);
        this.arrayInPtr += i2;
        return i2 + i3;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int read = read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                throw new EOFException();
            }
            i3 += read;
        } while (i3 < i2);
    }

    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        int i = 0;
        if (this.isBack) {
            this.isBack = false;
            if (j == 1) {
                return 1L;
            }
            j--;
            i = 1;
        }
        long filePointer = getFilePointer();
        long length = length();
        long j2 = j + filePointer;
        if (j2 > length) {
            j2 = length;
        }
        seek(j2);
        return (j2 - filePointer) + i;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return (int) skip(i);
    }

    public void reOpen() throws IOException {
        String str = this.filename;
        if (str != null && this.f19807rf == null && this.trf == null) {
            openFile(str);
        }
        seek(0L);
    }

    protected void insureOpen() throws IOException {
        if (this.filename != null && this.f19807rf == null && this.trf == null) {
            reOpen();
        }
    }

    public boolean isOpen() {
        return (this.filename != null && this.f19807rf == null && this.trf == null) ? false : true;
    }

    public void close() throws IOException {
        this.isBack = false;
        MappedRandomAccessFile mappedRandomAccessFile = this.f19807rf;
        if (mappedRandomAccessFile != null) {
            mappedRandomAccessFile.close();
            this.f19807rf = null;
            this.plainRandomAccess = true;
            return;
        }
        RandomAccessFile randomAccessFile = this.trf;
        if (randomAccessFile != null) {
            randomAccessFile.close();
            this.trf = null;
        }
    }

    public long length() throws IOException {
        byte[] bArr = this.arrayIn;
        if (bArr == null) {
            insureOpen();
            return (this.plainRandomAccess ? this.trf.length() : this.f19807rf.length()) - this.startOffset;
        }
        return bArr.length - this.startOffset;
    }

    public void seek(long j) throws IOException {
        long j2 = j + this.startOffset;
        this.isBack = false;
        if (this.arrayIn == null) {
            insureOpen();
            if (this.plainRandomAccess) {
                this.trf.seek(j2);
                return;
            } else {
                this.f19807rf.seek(j2);
                return;
            }
        }
        this.arrayInPtr = j2;
    }

    public long getFilePointer() throws IOException {
        insureOpen();
        boolean z = this.isBack;
        if (this.arrayIn == null) {
            return ((this.plainRandomAccess ? this.trf.getFilePointer() : this.f19807rf.getFilePointer()) - (z ? 1L : 0L)) - this.startOffset;
        }
        return (this.arrayInPtr - (z ? 1L : 0L)) - this.startOffset;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        int read = read();
        if (read >= 0) {
            return read != 0;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        int read = read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int read = read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (short) ((read << 8) + read2);
        }
        throw new EOFException();
    }

    public final short readShortLE() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (short) ((read2 << 8) + (read << 0));
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (read << 8) + read2;
        }
        throw new EOFException();
    }

    public final int readUnsignedShortLE() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (read2 << 8) + (read << 0);
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (char) ((read << 8) + read2);
        }
        throw new EOFException();
    }

    public final char readCharLE() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (char) ((read2 << 8) + (read << 0));
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        int read = read();
        int read2 = read();
        int read3 = read();
        int read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new EOFException();
    }

    public final int readIntLE() throws IOException {
        int read = read();
        int read2 = read();
        int read3 = read();
        int read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + (read << 0);
        }
        throw new EOFException();
    }

    public final long readUnsignedInt() throws IOException {
        long read = read();
        long read2 = read();
        long read3 = read();
        long read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + (read4 << 0);
        }
        throw new EOFException();
    }

    public final long readUnsignedIntLE() throws IOException {
        long read = read();
        long read2 = read();
        long read3 = read();
        long read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + (read << 0);
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return (readInt() << 32) + (readInt() & 4294967295L);
    }

    public final long readLongLE() throws IOException {
        return (readIntLE() << 32) + (readIntLE() & 4294967295L);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public final float readFloatLE() throws IOException {
        return Float.intBitsToFloat(readIntLE());
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    public final double readDoubleLE() throws IOException {
        return Double.longBitsToDouble(readLongLE());
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = -1;
        while (!z) {
            i = read();
            if (i == -1 || i == 10) {
                z = true;
            } else if (i == 13) {
                long filePointer = getFilePointer();
                if (read() != 10) {
                    seek(filePointer);
                    z = true;
                } else {
                    z = true;
                }
            } else {
                sb.append((char) i);
            }
        }
        if (i == -1 && sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public void setStartOffset(long j) {
        this.startOffset = j;
    }

    public java.nio.ByteBuffer getNioByteBuffer() throws IOException {
        FileChannel channel;
        if (this.filename != null) {
            if (this.plainRandomAccess) {
                channel = this.trf.getChannel();
            } else {
                channel = this.f19807rf.getChannel();
            }
            return channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
        }
        return java.nio.ByteBuffer.wrap(this.arrayIn);
    }
}
