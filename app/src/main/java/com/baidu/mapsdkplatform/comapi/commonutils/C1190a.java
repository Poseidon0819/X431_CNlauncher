package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.baidu.mapsdkplatform.comapi.commonutils.a */
/* loaded from: classes.dex */
public class C1190a {

    /* renamed from: a */
    private static final boolean f5885a;

    static {
        f5885a = Build.VERSION.SDK_INT >= 8;
    }

    /* renamed from: a */
    public static Bitmap m10820a(String str, Context context) {
        try {
            InputStream open = context.getAssets().open(str);
            if (open != null) {
                return BitmapFactory.decodeStream(open);
            }
            return null;
        } catch (Exception unused) {
            return BitmapFactory.decodeFile(m10818b("assets/".concat(String.valueOf(str)), str, context));
        }
    }

    /* renamed from: a */
    private static void m10821a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    try {
                        inputStream.close();
                        fileOutputStream.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
                fileOutputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    fileOutputStream.close();
                    throw th;
                } catch (IOException unused2) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0097 A[Catch: IOException -> 0x0093, TRY_LEAVE, TryCatch #1 {IOException -> 0x0093, blocks: (B:43:0x008f, B:47:0x0097), top: B:52:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m10819a(java.lang.String r6, java.lang.String r7, android.content.Context r8) {
        /*
            r0 = 0
            android.content.res.AssetManager r1 = r8.getAssets()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.io.InputStream r1 = r1.open(r6)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            if (r1 == 0) goto L55
            int r2 = r1.available()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r1.read(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r4.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.io.File r5 = r8.getFilesDir()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r4.append(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.String r5 = "/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r4.append(r7)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            boolean r4 = r3.exists()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            if (r4 == 0) goto L3e
            r3.delete()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
        L3e:
            r3.createNewFile()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L52
            r4.write(r2)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
            r4.close()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L53
            r0 = r4
            goto L55
        L4e:
            r6 = move-exception
            goto L8c
        L50:
            r6 = move-exception
            goto L8d
        L52:
            r4 = r0
        L53:
            r0 = r1
            goto L6b
        L55:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.io.IOException -> L5b
            goto L5d
        L5b:
            r6 = move-exception
            goto L63
        L5d:
            if (r0 == 0) goto L66
            r0.close()     // Catch: java.io.IOException -> L5b
            goto L66
        L63:
            r6.printStackTrace()
        L66:
            return
        L67:
            r6 = move-exception
            r1 = r0
            goto L8d
        L6a:
            r4 = r0
        L6b:
            java.lang.String r1 = "assets/"
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r6 = r1.concat(r6)     // Catch: java.lang.Throwable -> L8a
            m10818b(r6, r7, r8)     // Catch: java.lang.Throwable -> L8a
            if (r0 == 0) goto L80
            r0.close()     // Catch: java.io.IOException -> L7e
            goto L80
        L7e:
            r6 = move-exception
            goto L86
        L80:
            if (r4 == 0) goto L89
            r4.close()     // Catch: java.io.IOException -> L7e
            goto L89
        L86:
            r6.printStackTrace()
        L89:
            return
        L8a:
            r6 = move-exception
            r1 = r0
        L8c:
            r0 = r4
        L8d:
            if (r1 == 0) goto L95
            r1.close()     // Catch: java.io.IOException -> L93
            goto L95
        L93:
            r7 = move-exception
            goto L9b
        L95:
            if (r0 == 0) goto L9e
            r0.close()     // Catch: java.io.IOException -> L93
            goto L9e
        L9b:
            r7.printStackTrace()
        L9e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.commonutils.C1190a.m10819a(java.lang.String, java.lang.String, android.content.Context):void");
    }

    /* renamed from: b */
    private static String m10818b(String str, String str2, Context context) {
        ZipFile zipFile;
        File file;
        File file2;
        ZipEntry entry;
        StringBuilder sb = new StringBuilder(context.getFilesDir().getAbsolutePath());
        ZipFile zipFile2 = null;
        try {
            try {
                try {
                    zipFile = new ZipFile(f5885a ? context.getPackageCodePath() : "");
                    try {
                        int lastIndexOf = str2.lastIndexOf("/");
                        if (lastIndexOf > 0) {
                            file = new File(context.getFilesDir().getAbsolutePath());
                            String substring = str2.substring(0, lastIndexOf);
                            String substring2 = str2.substring(lastIndexOf + 1, str2.length());
                            file2 = new File(file.getAbsolutePath() + "/" + substring, substring2);
                        } else {
                            file = new File(context.getFilesDir(), "assets");
                            file2 = new File(file.getAbsolutePath(), str2);
                        }
                        file.mkdirs();
                        entry = zipFile.getEntry(str);
                    } catch (Exception e) {
                        e = e;
                        zipFile2 = zipFile;
                        Log.e(C1190a.class.getSimpleName(), "copyAssetsError", e);
                        if (zipFile2 != null) {
                            zipFile2.close();
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zipFile = zipFile2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (IOException unused2) {
        }
        if (entry == null) {
            try {
                zipFile.close();
            } catch (IOException unused3) {
            }
            return null;
        }
        m10821a(zipFile.getInputStream(entry), new FileOutputStream(file2));
        sb.append("/");
        sb.append(str);
        zipFile.close();
        return sb.toString();
    }
}
