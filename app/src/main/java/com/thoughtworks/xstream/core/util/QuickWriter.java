package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.p366io.StreamException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes2.dex */
public class QuickWriter {
    private char[] buffer;
    private int pointer;
    private final Writer writer;

    public QuickWriter(Writer writer) {
        this(writer, 1024);
    }

    public QuickWriter(Writer writer, int i) {
        this.writer = writer;
        this.buffer = new char[i];
    }

    public void write(String str) {
        int length = str.length();
        if (this.pointer + length >= this.buffer.length) {
            flush();
            if (length > this.buffer.length) {
                raw(str.toCharArray());
                return;
            }
        }
        str.getChars(0, length, this.buffer, this.pointer);
        this.pointer += length;
    }

    public void write(char c) {
        if (this.pointer + 1 >= this.buffer.length) {
            flush();
            if (this.buffer.length == 0) {
                raw(c);
                return;
            }
        }
        char[] cArr = this.buffer;
        int i = this.pointer;
        this.pointer = i + 1;
        cArr[i] = c;
    }

    public void write(char[] cArr) {
        int length = cArr.length;
        if (this.pointer + length >= this.buffer.length) {
            flush();
            if (length > this.buffer.length) {
                raw(cArr);
                return;
            }
        }
        System.arraycopy(cArr, 0, this.buffer, this.pointer, length);
        this.pointer += length;
    }

    public void flush() {
        try {
            this.writer.write(this.buffer, 0, this.pointer);
            this.pointer = 0;
            this.writer.flush();
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }

    public void close() {
        try {
            this.writer.write(this.buffer, 0, this.pointer);
            this.pointer = 0;
            this.writer.close();
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }

    private void raw(char[] cArr) {
        try {
            this.writer.write(cArr);
            this.writer.flush();
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }

    private void raw(char c) {
        try {
            this.writer.write(c);
            this.writer.flush();
        } catch (IOException e) {
            throw new StreamException(e);
        }
    }
}
