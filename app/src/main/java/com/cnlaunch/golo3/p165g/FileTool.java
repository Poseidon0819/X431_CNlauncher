package com.cnlaunch.golo3.p165g;

import android.os.Environment;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.itextpdf.text.Annotation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.cnlaunch.golo3.g.j */
/* loaded from: classes.dex */
public final class FileTool {

    /* renamed from: a */
    private static FileTool f8471a;

    private FileTool() {
    }

    /* renamed from: a */
    public static FileTool m9143a() {
        if (f8471a == null) {
            f8471a = new FileTool();
        }
        return f8471a;
    }

    /* renamed from: a */
    public static File m9141a(String str, String str2) throws FileNotFoundException {
        File file = new File(Environment.getExternalStorageDirectory(), m9139c("thumb", str2));
        if (file.mkdirs() || file.isDirectory()) {
            return new File(file, str);
        }
        throw new FileNotFoundException("SDCard not found!");
    }

    /* renamed from: b */
    public static File m9140b(String str, String str2) throws FileNotFoundException {
        File file = new File(Environment.getExternalStorageDirectory(), m9139c(Annotation.FILE, str2));
        if (file.mkdirs() || file.isDirectory()) {
            return new File(file, str);
        }
        throw new FileNotFoundException("SDCard not found!");
    }

    /* renamed from: c */
    public static String m9139c(String str, String str2) {
        return !"".equals(ApplicationConfig.m9181a()) ? String.format("/cnlaunch/golo3/%s/%s/%s", ApplicationConfig.m9181a(), str, str2) : String.format("/cnlaunch/golo3/%s/%s", str, str2);
    }

    /* renamed from: a */
    public static void m9142a(File file, File file2) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            bufferedOutputStream2.write(bArr, 0, read);
                        } else {
                            bufferedOutputStream2.flush();
                            bufferedInputStream.close();
                            bufferedOutputStream2.close();
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }
}
