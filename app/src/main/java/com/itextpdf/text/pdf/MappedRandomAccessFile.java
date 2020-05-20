package com.itextpdf.text.pdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes.dex */
public class MappedRandomAccessFile {
    private static final int BUFSIZE = 1073741824;
    private FileChannel channel = null;
    private MappedByteBuffer[] mappedBuffers;
    private long pos;
    private long size;

    public MappedRandomAccessFile(String str, String str2) throws FileNotFoundException, IOException {
        if (str2.equals("rw")) {
            init(new RandomAccessFile(str, str2).getChannel(), FileChannel.MapMode.READ_WRITE);
        } else {
            init(new FileInputStream(str).getChannel(), FileChannel.MapMode.READ_ONLY);
        }
    }

    private void init(FileChannel fileChannel, FileChannel.MapMode mapMode) throws IOException {
        this.channel = fileChannel;
        this.size = fileChannel.size();
        this.pos = 0L;
        long j = this.size;
        int i = ((int) (j / 1073741824)) + (j % 1073741824 == 0 ? 0 : 1);
        this.mappedBuffers = new MappedByteBuffer[i];
        int i2 = 0;
        for (long j2 = 0; j2 < this.size; j2 += 1073741824) {
            try {
                this.mappedBuffers[i2] = fileChannel.map(mapMode, j2, Math.min(this.size - j2, 1073741824L));
                this.mappedBuffers[i2].load();
                i2++;
            } catch (IOException e) {
                close();
                throw e;
            } catch (RuntimeException e2) {
                close();
                throw e2;
            }
        }
        if (i2 == i) {
            return;
        }
        throw new Error("Should never happen - " + i2 + " != " + i);
    }

    public FileChannel getChannel() {
        return this.channel;
    }

    public int read() {
        try {
            int i = (int) (this.pos / 1073741824);
            int i2 = (int) (this.pos % 1073741824);
            if (i < this.mappedBuffers.length && i2 < this.mappedBuffers[i].limit()) {
                byte b = this.mappedBuffers[i].get(i2);
                this.pos++;
                return b & 255;
            }
            return -1;
        } catch (BufferUnderflowException unused) {
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        long j = this.pos;
        int i3 = (int) (j / 1073741824);
        int i4 = (int) (j % 1073741824);
        int i5 = i;
        int i6 = 0;
        while (i6 < i2) {
            MappedByteBuffer[] mappedByteBufferArr = this.mappedBuffers;
            if (i3 >= mappedByteBufferArr.length) {
                break;
            }
            MappedByteBuffer mappedByteBuffer = mappedByteBufferArr[i3];
            if (i4 > mappedByteBuffer.limit()) {
                break;
            }
            mappedByteBuffer.position(i4);
            int min = Math.min(i2, mappedByteBuffer.remaining());
            mappedByteBuffer.get(bArr, i5, min);
            i5 += min;
            this.pos += min;
            i6 += min;
            i3++;
            i4 = 0;
        }
        if (i6 == 0) {
            return -1;
        }
        return i6;
    }

    public long getFilePointer() {
        return this.pos;
    }

    public void seek(long j) {
        this.pos = j;
    }

    public long length() {
        return this.size;
    }

    public void close() throws IOException {
        int i = 0;
        while (true) {
            MappedByteBuffer[] mappedByteBufferArr = this.mappedBuffers;
            if (i >= mappedByteBufferArr.length) {
                break;
            }
            if (mappedByteBufferArr[i] != null) {
                clean(mappedByteBufferArr[i]);
                this.mappedBuffers[i] = null;
            }
            i++;
        }
        FileChannel fileChannel = this.channel;
        if (fileChannel != null) {
            fileChannel.close();
        }
        this.channel = null;
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public static boolean clean(final java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer == null || !byteBuffer.isDirect()) {
            return false;
        }
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: com.itextpdf.text.pdf.MappedRandomAccessFile.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                Boolean bool = Boolean.FALSE;
                try {
                    Method method = byteBuffer.getClass().getMethod("cleaner", null);
                    method.setAccessible(true);
                    Object invoke = method.invoke(byteBuffer, null);
                    invoke.getClass().getMethod("clean", null).invoke(invoke, null);
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return bool;
                }
            }
        })).booleanValue();
    }
}
