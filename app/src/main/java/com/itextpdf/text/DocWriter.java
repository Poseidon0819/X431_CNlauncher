package com.itextpdf.text;

import com.itextpdf.text.pdf.OutputStreamCounter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/* loaded from: classes.dex */
public abstract class DocWriter implements DocListener {
    public static final byte EQUALS = 61;
    public static final byte FORWARD = 47;

    /* renamed from: GT */
    public static final byte f19585GT = 62;

    /* renamed from: LT */
    public static final byte f19586LT = 60;
    public static final byte NEWLINE = 10;
    public static final byte QUOTE = 34;
    public static final byte SPACE = 32;
    public static final byte TAB = 9;
    protected Document document;

    /* renamed from: os */
    protected OutputStreamCounter f19587os;
    protected Rectangle pageSize;
    protected boolean open = false;
    protected boolean pause = false;
    protected boolean closeStream = true;

    @Override // com.itextpdf.text.ElementListener
    public boolean add(Element element) throws DocumentException {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public void resetPageCount() {
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroring(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMarginMirroringTopBottom(boolean z) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setMargins(float f, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.itextpdf.text.DocListener
    public void setPageCount(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DocWriter() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DocWriter(Document document, OutputStream outputStream) {
        this.document = document;
        this.f19587os = new OutputStreamCounter(new BufferedOutputStream(outputStream));
    }

    @Override // com.itextpdf.text.DocListener
    public void open() {
        this.open = true;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean setPageSize(Rectangle rectangle) {
        this.pageSize = rectangle;
        return true;
    }

    @Override // com.itextpdf.text.DocListener
    public boolean newPage() {
        return this.open;
    }

    @Override // com.itextpdf.text.DocListener
    public void close() {
        this.open = false;
        try {
            this.f19587os.flush();
            if (this.closeStream) {
                this.f19587os.close();
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static final byte[] getISOBytes(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public void pause() {
        this.pause = true;
    }

    public boolean isPaused() {
        return this.pause;
    }

    public void resume() {
        this.pause = false;
    }

    public void flush() {
        try {
            this.f19587os.flush();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    protected void write(String str) throws IOException {
        this.f19587os.write(getISOBytes(str));
    }

    protected void addTabs(int i) throws IOException {
        this.f19587os.write(10);
        for (int i2 = 0; i2 < i; i2++) {
            this.f19587os.write(9);
        }
    }

    protected void write(String str, String str2) throws IOException {
        this.f19587os.write(32);
        write(str);
        this.f19587os.write(61);
        this.f19587os.write(34);
        write(str2);
        this.f19587os.write(34);
    }

    protected void writeStart(String str) throws IOException {
        this.f19587os.write(60);
        write(str);
    }

    protected void writeEnd(String str) throws IOException {
        this.f19587os.write(60);
        this.f19587os.write(47);
        write(str);
        this.f19587os.write(62);
    }

    protected void writeEnd() throws IOException {
        this.f19587os.write(32);
        this.f19587os.write(47);
        this.f19587os.write(62);
    }

    protected boolean writeMarkupAttributes(Properties properties) throws IOException {
        if (properties == null) {
            return false;
        }
        for (Object obj : properties.keySet()) {
            String valueOf = String.valueOf(obj);
            write(valueOf, properties.getProperty(valueOf));
        }
        properties.clear();
        return true;
    }

    public boolean isCloseStream() {
        return this.closeStream;
    }

    public void setCloseStream(boolean z) {
        this.closeStream = z;
    }
}
