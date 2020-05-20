package com.cnlaunch.p120d.p125c.p128c;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.message.BasicHeader;
import org.apache.mina.proxy.handlers.http.HttpProxyConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.cnlaunch.d.c.c.l */
/* loaded from: classes.dex */
public final class SimpleMultipartEntity implements HttpEntity {

    /* renamed from: a */
    static final byte[] f7149a = HttpProxyConstants.CRLF.getBytes();

    /* renamed from: b */
    static final byte[] f7150b = "Content-Transfer-Encoding: binary\r\n".getBytes();

    /* renamed from: g */
    private static final char[] f7151g = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: c */
    byte[] f7152c;

    /* renamed from: d */
    boolean f7153d = false;

    /* renamed from: e */
    List<C1429a> f7154e = new ArrayList();

    /* renamed from: f */
    ByteArrayOutputStream f7155f = new ByteArrayOutputStream();

    /* renamed from: h */
    private String f7156h;

    /* renamed from: i */
    private byte[] f7157i;

    /* renamed from: j */
    private ResponseHandlerInterface f7158j;

    /* renamed from: k */
    private int f7159k;

    /* renamed from: l */
    private int f7160l;

    public final Header getContentEncoding() {
        return null;
    }

    public final boolean isChunked() {
        return false;
    }

    public final boolean isStreaming() {
        return false;
    }

    public SimpleMultipartEntity() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = f7151g;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f7156h = sb.toString();
        this.f7152c = ("--" + this.f7156h + HttpProxyConstants.CRLF).getBytes();
        this.f7157i = ("--" + this.f7156h + "--\r\n").getBytes();
        this.f7158j = null;
    }

    /* renamed from: a */
    private void m9487a(String str, String str2, String str3) {
        try {
            this.f7155f.write(this.f7152c);
            ByteArrayOutputStream byteArrayOutputStream = this.f7155f;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n").getBytes());
            this.f7155f.write(m9489a(str3));
            this.f7155f.write(f7149a);
            this.f7155f.write(str2.getBytes());
            this.f7155f.write(f7149a);
        } catch (IOException e) {
            Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", e);
        }
    }

    /* renamed from: a */
    public final void m9488a(String str, String str2) {
        m9487a(str, str2, "text/plain; charset=UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m9489a(String str) {
        return ("Content-Type: " + str + HttpProxyConstants.CRLF).getBytes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static byte[] m9484b(String str, String str2) {
        return ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes();
    }

    /* renamed from: a */
    private void m9491a(int i) {
        this.f7159k += i;
        ResponseHandlerInterface responseHandlerInterface = this.f7158j;
        if (responseHandlerInterface != null) {
            responseHandlerInterface.mo9495b(this.f7159k, this.f7160l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SimpleMultipartEntity.java */
    /* renamed from: com.cnlaunch.d.c.c.l$a */
    /* loaded from: classes.dex */
    public class C1429a {

        /* renamed from: a */
        public File f7161a;

        /* renamed from: b */
        public byte[] f7162b;

        public C1429a(String str, File file, String str2) {
            this.f7162b = m9482a(str, file.getName(), str2);
            this.f7161a = file;
        }

        /* renamed from: a */
        private byte[] m9482a(String str, String str2, String str3) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(SimpleMultipartEntity.this.f7152c);
                byteArrayOutputStream.write(SimpleMultipartEntity.m9484b(str, str2));
                byteArrayOutputStream.write(SimpleMultipartEntity.m9489a(str3));
                byteArrayOutputStream.write(SimpleMultipartEntity.f7150b);
                byteArrayOutputStream.write(SimpleMultipartEntity.f7149a);
            } catch (IOException e) {
                Log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", e);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    public final long getContentLength() {
        long size = this.f7155f.size();
        for (C1429a c1429a : this.f7154e) {
            long length = c1429a.f7162b.length + c1429a.f7161a.length();
            if (length < 0) {
                return -1L;
            }
            size += length;
        }
        return size + this.f7157i.length;
    }

    public final Header getContentType() {
        return new BasicHeader(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + this.f7156h);
    }

    public final boolean isRepeatable() {
        return this.f7153d;
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        this.f7159k = 0;
        this.f7160l = (int) getContentLength();
        this.f7155f.writeTo(outputStream);
        m9491a(this.f7155f.size());
        for (C1429a c1429a : this.f7154e) {
            outputStream.write(c1429a.f7162b);
            SimpleMultipartEntity.this.m9491a(c1429a.f7162b.length);
            FileInputStream fileInputStream = new FileInputStream(c1429a.f7161a);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                SimpleMultipartEntity.this.m9491a(read);
            }
            outputStream.write(f7149a);
            SimpleMultipartEntity.this.m9491a(f7149a.length);
            outputStream.flush();
            try {
                fileInputStream.close();
            } catch (IOException e) {
                Log.w("SimpleMultipartEntity", "Cannot close input stream", e);
            }
        }
        outputStream.write(this.f7157i);
        m9491a(this.f7157i.length);
    }

    public final void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public final InputStream getContent() throws IOException, UnsupportedOperationException {
        throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
    }
}
