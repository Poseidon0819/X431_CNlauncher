package com.thoughtworks.xstream.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class XmlHeaderAwareReader extends Reader {
    private static final String KEY_ENCODING = "encoding";
    private static final String KEY_VERSION = "version";
    private static final int STATE_ATTR_NAME = 3;
    private static final int STATE_ATTR_VALUE = 4;
    private static final int STATE_AWAIT_XML_HEADER = 2;
    private static final int STATE_BOM = 0;
    private static final int STATE_START = 1;
    private static final String XML_TOKEN = "?xml";
    private final InputStreamReader reader;
    private final double version;

    public XmlHeaderAwareReader(InputStream inputStream) throws UnsupportedEncodingException, IOException {
        PushbackInputStream[] pushbackInputStreamArr = new PushbackInputStream[1];
        pushbackInputStreamArr[0] = inputStream instanceof PushbackInputStream ? (PushbackInputStream) inputStream : new PushbackInputStream(inputStream, 64);
        Map header = getHeader(pushbackInputStreamArr);
        this.version = Double.parseDouble((String) header.get(KEY_VERSION));
        this.reader = new InputStreamReader(pushbackInputStreamArr[0], (String) header.get("encoding"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ed, code lost:
        r1.reset();
        r10 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x002d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x012c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map getHeader(java.io.PushbackInputStream[] r17) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.core.util.XmlHeaderAwareReader.getHeader(java.io.PushbackInputStream[]):java.util.Map");
    }

    public final String getEncoding() {
        return this.reader.getEncoding();
    }

    public final double getVersion() {
        return this.version;
    }

    @Override // java.io.Reader
    public final void mark(int i) throws IOException {
        this.reader.mark(i);
    }

    @Override // java.io.Reader
    public final boolean markSupported() {
        return this.reader.markSupported();
    }

    @Override // java.io.Reader
    public final int read() throws IOException {
        return this.reader.read();
    }

    @Override // java.io.Reader
    public final int read(char[] cArr, int i, int i2) throws IOException {
        return this.reader.read(cArr, i, i2);
    }

    @Override // java.io.Reader
    public final int read(char[] cArr) throws IOException {
        return this.reader.read(cArr);
    }

    @Override // java.io.Reader
    public final boolean ready() throws IOException {
        return this.reader.ready();
    }

    @Override // java.io.Reader
    public final void reset() throws IOException {
        this.reader.reset();
    }

    @Override // java.io.Reader
    public final long skip(long j) throws IOException {
        return this.reader.skip(j);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.reader.close();
    }

    public final boolean equals(Object obj) {
        return this.reader.equals(obj);
    }

    public final int hashCode() {
        return this.reader.hashCode();
    }

    public final String toString() {
        return this.reader.toString();
    }
}
