package com.cnlaunch.golo3.p154a.p158d;

import android.util.Log;
import com.mopub.common.Constants;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: SimpleDownloader.java */
/* renamed from: com.cnlaunch.golo3.a.d.b */
/* loaded from: classes.dex */
public class C1593b implements InterfaceC1592a {

    /* renamed from: a */
    private static final String f7790a = "b";

    @Override // com.cnlaunch.golo3.p154a.p158d.InterfaceC1592a
    /* renamed from: a */
    public final byte[] mo9188a(String str) {
        if (str == null) {
            return null;
        }
        if (str.trim().toLowerCase().startsWith(Constants.HTTP)) {
            return m9187b(str);
        }
        if (str.trim().toLowerCase().startsWith("file:")) {
            try {
                File file = new File(new URI(str));
                if (file.exists() && file.canRead()) {
                    return m9189a(file);
                }
            } catch (URISyntaxException e) {
                String str2 = f7790a;
                Log.e(str2, "Error in read from file - " + str + " : " + e);
            }
        } else {
            File file2 = new File(str);
            if (file2.exists() && file2.canRead()) {
                return m9189a(file2);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] m9189a(java.io.File r6) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L25 java.lang.Exception -> L28
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L4b
            r2.<init>()     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L4b
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L4b
        Lf:
            int r4 = r1.read(r3)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L4b
            r5 = -1
            if (r4 == r5) goto L1b
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L4b
            goto Lf
        L1b:
            byte[] r6 = r2.toByteArray()     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L4b
            r1.close()     // Catch: java.io.IOException -> L22
        L22:
            return r6
        L23:
            r2 = move-exception
            goto L2a
        L25:
            r6 = move-exception
            r1 = r0
            goto L4c
        L28:
            r2 = move-exception
            r1 = r0
        L2a:
            java.lang.String r3 = com.cnlaunch.golo3.p154a.p158d.C1593b.f7790a     // Catch: java.lang.Throwable -> L4b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = "Error in read from file - "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L4b
            r4.append(r6)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r6 = " : "
            r4.append(r6)     // Catch: java.lang.Throwable -> L4b
            r4.append(r2)     // Catch: java.lang.Throwable -> L4b
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L4b
            android.util.Log.e(r3, r6)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L4a
            r1.close()     // Catch: java.io.IOException -> L4a
        L4a:
            return r0
        L4b:
            r6 = move-exception
        L4c:
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.io.IOException -> L51
        L51:
            throw r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.golo3.p154a.p158d.C1593b.m9189a(java.io.File):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] m9187b(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L41 java.io.IOException -> L45
            com.cnlaunch.golo3.a.d.b$a r2 = new com.cnlaunch.golo3.a.d.b$a     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r5 = 8192(0x2000, float:1.148E-41)
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3e
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6e
            r3.<init>()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6e
        L21:
            int r4 = r2.read()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6e
            r5 = -1
            if (r4 == r5) goto L2c
            r3.write(r4)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6e
            goto L21
        L2c:
            byte[] r8 = r3.toByteArray()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L6e
            if (r1 == 0) goto L35
            r1.disconnect()
        L35:
            r2.close()     // Catch: java.io.IOException -> L38
        L38:
            return r8
        L39:
            r3 = move-exception
            goto L48
        L3b:
            r8 = move-exception
            r2 = r0
            goto L6f
        L3e:
            r3 = move-exception
            r2 = r0
            goto L48
        L41:
            r8 = move-exception
            r1 = r0
            r2 = r1
            goto L6f
        L45:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L48:
            java.lang.String r4 = com.cnlaunch.golo3.p154a.p158d.C1593b.f7790a     // Catch: java.lang.Throwable -> L6e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            java.lang.String r6 = "Error in downloadBitmap - "
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L6e
            r5.append(r8)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r8 = " : "
            r5.append(r8)     // Catch: java.lang.Throwable -> L6e
            r5.append(r3)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L6e
            android.util.Log.e(r4, r8)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L68
            r1.disconnect()
        L68:
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.io.IOException -> L6d
        L6d:
            return r0
        L6e:
            r8 = move-exception
        L6f:
            if (r1 == 0) goto L74
            r1.disconnect()
        L74:
            if (r2 == 0) goto L79
            r2.close()     // Catch: java.io.IOException -> L79
        L79:
            throw r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.golo3.p154a.p158d.C1593b.m9187b(java.lang.String):byte[]");
    }

    /* compiled from: SimpleDownloader.java */
    /* renamed from: com.cnlaunch.golo3.a.d.b$a */
    /* loaded from: classes.dex */
    public class C1594a extends FilterInputStream {
        public C1594a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                long skip = this.in.skip(j - j2);
                if (skip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    skip = 1;
                }
                j2 += skip;
            }
            return j2;
        }
    }
}
