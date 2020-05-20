package com.baidu.location.p079b;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.location.p082e.C0998f;
import com.baidu.location.p084g.C1005a;
import com.baidu.location.p084g.C1016g;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPostHC4;

/* renamed from: com.baidu.location.b.e */
/* loaded from: classes.dex */
public class C0943e implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static C0943e f4172a;

    /* renamed from: b */
    private int f4173b = 0;

    private C0943e() {
    }

    /* renamed from: a */
    public static C0943e m11976a() {
        if (f4172a == null) {
            f4172a = new C0943e();
        }
        return f4172a;
    }

    /* renamed from: a */
    private String m11973a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    /* renamed from: a */
    private void m11975a(File file, String str, String str2) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(280L);
            randomAccessFile.writeInt(12346);
            randomAccessFile.seek(300L);
            randomAccessFile.writeLong(System.currentTimeMillis());
            byte[] bytes = str.getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.seek(600L);
            byte[] bytes2 = str2.getBytes();
            randomAccessFile.writeInt(bytes2.length);
            randomAccessFile.write(bytes2, 0, bytes2.length);
            if (!m11974a(str, str2)) {
                randomAccessFile.seek(280L);
                randomAccessFile.writeInt(1326);
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private boolean m11974a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !C0998f.m11626j()) {
            return false;
        }
        try {
            URL url = new URL(C1016g.f4595e);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("e0");
            stringBuffer.append("=");
            stringBuffer.append(str);
            stringBuffer.append("&");
            stringBuffer.append("e1");
            stringBuffer.append("=");
            stringBuffer.append(str2);
            stringBuffer.append("&");
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(HttpPostHC4.METHOD_NAME);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(C1005a.f4482b);
            httpURLConnection.setReadTimeout(C1005a.f4482b);
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception unused) {
        }
        return httpURLConnection.getResponseCode() == 200;
    }

    /* renamed from: b */
    public void m11972b() {
        String str;
        try {
            File file = new File((Environment.getExternalStorageDirectory().getPath() + "/traces") + "/error_fs2.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(280L);
                if (1326 == randomAccessFile.readInt()) {
                    randomAccessFile.seek(308L);
                    int readInt = randomAccessFile.readInt();
                    String str2 = null;
                    if (readInt <= 0 || readInt >= 2048) {
                        str = null;
                    } else {
                        byte[] bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        str = new String(bArr, 0, readInt);
                    }
                    randomAccessFile.seek(600L);
                    int readInt2 = randomAccessFile.readInt();
                    if (readInt2 > 0 && readInt2 < 2048) {
                        byte[] bArr2 = new byte[readInt2];
                        randomAccessFile.read(bArr2, 0, readInt2);
                        str2 = new String(bArr2, 0, readInt2);
                    }
                    if (m11974a(str, str2)) {
                        randomAccessFile.seek(280L);
                        randomAccessFile.writeInt(12346);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00aa A[Catch: Exception -> 0x00b6, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b6, blocks: (B:19:0x007f, B:23:0x0089, B:25:0x00aa), top: B:50:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uncaughtException(java.lang.Thread r9, java.lang.Throwable r10) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p079b.C0943e.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
