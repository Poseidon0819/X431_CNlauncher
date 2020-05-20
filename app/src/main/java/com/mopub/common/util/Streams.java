package com.mopub.common.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class Streams {
    public static void copyContent(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            throw new IOException("Unable to copy from or to a null stream.");
        }
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void copyContent(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        if (inputStream == null || outputStream == null) {
            throw new IOException("Unable to copy from or to a null stream.");
        }
        byte[] bArr = new byte[16384];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            j2 += read;
            if (j2 >= j) {
                throw new IOException("Error copying content: attempted to copy " + j2 + " bytes, with " + j + " maximum.");
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void readStream(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        do {
            int read = inputStream.read(bArr, i, length);
            if (read == -1) {
                return;
            }
            i += read;
            length -= read;
        } while (length > 0);
    }

    public static void closeStream(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
