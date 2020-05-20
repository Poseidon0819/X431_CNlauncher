package com.launch.p353a.p364k;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileUtils.java */
/* renamed from: com.launch.a.k.c */
/* loaded from: classes.dex */
public final class C3666c {
    /* renamed from: a */
    public static String m2643a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            return absolutePath + "/ADS";
        }
        return "Do not share the external storage medium";
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0042: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:24:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.InputStream m2641b() {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r2.<init>()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            java.lang.String r3 = m2643a()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r2.append(r3)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            java.lang.String r3 = "/certificate.cer"
            r2.append(r3)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            com.launch.p353a.p354a.ADSLibAplication.m2705a(r2)     // Catch: java.io.IOException -> L2c java.lang.Throwable -> L40
            r2.close()     // Catch: java.io.IOException -> L27
            goto L2b
        L27:
            r0 = move-exception
            r0.printStackTrace()
        L2b:
            return r2
        L2c:
            r1 = move-exception
            goto L32
        L2e:
            r1 = move-exception
            goto L43
        L30:
            r1 = move-exception
            r2 = r0
        L32:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L3b
            goto L3f
        L3b:
            r1 = move-exception
            r1.printStackTrace()
        L3f:
            return r0
        L40:
            r0 = move-exception
            r1 = r0
            r0 = r2
        L43:
            if (r0 == 0) goto L4d
            r0.close()     // Catch: java.io.IOException -> L49
            goto L4d
        L49:
            r0 = move-exception
            r0.printStackTrace()
        L4d:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launch.p353a.p364k.C3666c.m2641b():java.io.InputStream");
    }

    /* renamed from: a */
    public static Bitmap m2642a(File file) {
        FileInputStream fileInputStream;
        InputStream inputStream = null;
        try {
            try {
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                    if (decodeFile != null) {
                        return decodeFile;
                    }
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[51200];
                        fileInputStream.read(bArr);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 1;
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeByteArray(bArr, 0, 51200, options);
                        if (options.outHeight * options.outWidth * 4 > 1200000) {
                            options.inSampleSize = 2;
                        }
                        options.inJustDecodeBounds = false;
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, 51200, options);
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return decodeByteArray;
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (IOException e5) {
                    e = e5;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e7.printStackTrace();
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
