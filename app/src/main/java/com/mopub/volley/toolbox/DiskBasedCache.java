package com.mopub.volley.toolbox;

import android.os.SystemClock;
import com.mopub.volley.Cache;
import com.mopub.volley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DiskBasedCache implements Cache {

    /* renamed from: a */
    private final Map<String, C3925a> f21315a;

    /* renamed from: b */
    private long f21316b;

    /* renamed from: c */
    private final File f21317c;

    /* renamed from: d */
    private final int f21318d;

    public DiskBasedCache(File file, int i) {
        this.f21315a = new LinkedHashMap(16, 0.75f, true);
        this.f21316b = 0L;
        this.f21317c = file;
        this.f21318d = i;
    }

    public DiskBasedCache(File file) {
        this(file, 5242880);
    }

    @Override // com.mopub.volley.Cache
    public synchronized void clear() {
        File[] listFiles = this.f21317c.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        this.f21315a.clear();
        this.f21316b = 0L;
        VolleyLog.m2013d("Cache cleared.", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.mopub.volley.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.mopub.volley.Cache.Entry get(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.Map<java.lang.String, com.mopub.volley.toolbox.DiskBasedCache$a> r0 = r9.f21315a     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r0 = r0.get(r10)     // Catch: java.lang.Throwable -> L6d
            com.mopub.volley.toolbox.DiskBasedCache$a r0 = (com.mopub.volley.toolbox.DiskBasedCache.C3925a) r0     // Catch: java.lang.Throwable -> L6d
            r1 = 0
            if (r0 != 0) goto Le
            monitor-exit(r9)
            return r1
        Le:
            java.io.File r2 = r9.getFileForKey(r10)     // Catch: java.lang.Throwable -> L6d
            r3 = 0
            com.mopub.volley.toolbox.DiskBasedCache$b r4 = new com.mopub.volley.toolbox.DiskBasedCache$b     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f
            com.mopub.volley.toolbox.DiskBasedCache.C3925a.readHeader(r4)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L63
            long r5 = r2.length()     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L63
            int r7 = com.mopub.volley.toolbox.DiskBasedCache.C3926b.m1993a(r4)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L63
            long r7 = (long) r7     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L63
            long r5 = r5 - r7
            int r6 = (int) r5     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L63
            byte[] r5 = m2004a(r4, r6)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L63
            com.mopub.volley.Cache$Entry r10 = r0.toCacheEntry(r5)     // Catch: java.io.IOException -> L3a java.lang.Throwable -> L63
            r4.close()     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L6d
            monitor-exit(r9)
            return r10
        L38:
            monitor-exit(r9)
            return r1
        L3a:
            r0 = move-exception
            goto L41
        L3c:
            r10 = move-exception
            r4 = r1
            goto L64
        L3f:
            r0 = move-exception
            r4 = r1
        L41:
            java.lang.String r5 = "%s: %s"
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L63
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L63
            r6[r3] = r2     // Catch: java.lang.Throwable -> L63
            r2 = 1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L63
            r6[r2] = r0     // Catch: java.lang.Throwable -> L63
            com.mopub.volley.VolleyLog.m2013d(r5, r6)     // Catch: java.lang.Throwable -> L63
            r9.remove(r10)     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L61
            r4.close()     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L6d
            goto L61
        L5f:
            monitor-exit(r9)
            return r1
        L61:
            monitor-exit(r9)
            return r1
        L63:
            r10 = move-exception
        L64:
            if (r4 == 0) goto L6c
            r4.close()     // Catch: java.io.IOException -> L6a java.lang.Throwable -> L6d
            goto L6c
        L6a:
            monitor-exit(r9)
            return r1
        L6c:
            throw r10     // Catch: java.lang.Throwable -> L6d
        L6d:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.volley.toolbox.DiskBasedCache.get(java.lang.String):com.mopub.volley.Cache$Entry");
    }

    @Override // com.mopub.volley.Cache
    public synchronized void initialize() {
        if (!this.f21317c.exists()) {
            if (!this.f21317c.mkdirs()) {
                VolleyLog.m2012e("Unable to create cache dir %s", this.f21317c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f21317c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        C3925a readHeader = C3925a.readHeader(bufferedInputStream2);
                        readHeader.size = file.length();
                        m1999a(readHeader.key, readHeader);
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException unused) {
                        }
                    } catch (IOException unused2) {
                        bufferedInputStream = bufferedInputStream2;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused4) {
            }
        }
    }

    @Override // com.mopub.volley.Cache
    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0L;
            if (z) {
                entry.ttl = 0L;
            }
            put(str, entry);
        }
    }

    @Override // com.mopub.volley.Cache
    public synchronized void put(String str, Cache.Entry entry) {
        long j;
        Iterator<Map.Entry<String, C3925a>> it;
        long length = entry.data.length;
        if (this.f21316b + length >= this.f21318d) {
            if (VolleyLog.DEBUG) {
                VolleyLog.m2010v("Pruning old cache entries.", new Object[0]);
            }
            long j2 = this.f21316b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, C3925a>> it2 = this.f21315a.entrySet().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    j = j2;
                    break;
                }
                C3925a value = it2.next().getValue();
                if (getFileForKey(value.key).delete()) {
                    j = j2;
                    it = it2;
                    this.f21316b -= value.size;
                } else {
                    j = j2;
                    it = it2;
                    VolleyLog.m2013d("Could not delete cache entry for key=%s, filename=%s", value.key, m2000a(value.key));
                }
                it.remove();
                i++;
                if (((float) (this.f21316b + length)) < this.f21318d * 0.9f) {
                    break;
                }
                j2 = j;
                it2 = it;
            }
            if (VolleyLog.DEBUG) {
                VolleyLog.m2010v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.f21316b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
        File fileForKey = getFileForKey(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileForKey);
            C3925a c3925a = new C3925a(str, entry);
            if (!c3925a.writeHeader(fileOutputStream)) {
                fileOutputStream.close();
                VolleyLog.m2013d("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(entry.data);
            fileOutputStream.close();
            m1999a(str, c3925a);
        } catch (IOException unused) {
            if (fileForKey.delete()) {
                return;
            }
            VolleyLog.m2013d("Could not clean up file %s", fileForKey.getAbsolutePath());
        }
    }

    @Override // com.mopub.volley.Cache
    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        C3925a c3925a = this.f21315a.get(str);
        if (c3925a != null) {
            this.f21316b -= c3925a.size;
            this.f21315a.remove(str);
        }
        if (!delete) {
            VolleyLog.m2013d("Could not delete cache entry for key=%s, filename=%s", str, m2000a(str));
        }
    }

    /* renamed from: a */
    private static String m2000a(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    public File getFileForKey(String str) {
        return new File(this.f21317c, m2000a(str));
    }

    /* renamed from: a */
    private void m1999a(String str, C3925a c3925a) {
        if (!this.f21315a.containsKey(str)) {
            this.f21316b += c3925a.size;
        } else {
            this.f21316b += c3925a.size - this.f21315a.get(str).size;
        }
        this.f21315a.put(str, c3925a);
    }

    /* renamed from: a */
    private static byte[] m2004a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.volley.toolbox.DiskBasedCache$a */
    /* loaded from: classes2.dex */
    public static class C3925a {
        public String etag;
        public String key;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        private C3925a() {
        }

        public C3925a(String str, Cache.Entry entry) {
            this.key = str;
            this.size = entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
        }

        public static C3925a readHeader(InputStream inputStream) throws IOException {
            C3925a c3925a = new C3925a();
            if (DiskBasedCache.m2005a(inputStream) != 538183203) {
                throw new IOException();
            }
            c3925a.key = DiskBasedCache.m1996c(inputStream);
            c3925a.etag = DiskBasedCache.m1996c(inputStream);
            if (c3925a.etag.equals("")) {
                c3925a.etag = null;
            }
            c3925a.serverDate = DiskBasedCache.m1997b(inputStream);
            c3925a.ttl = DiskBasedCache.m1997b(inputStream);
            c3925a.softTtl = DiskBasedCache.m1997b(inputStream);
            c3925a.responseHeaders = DiskBasedCache.m1995d(inputStream);
            return c3925a;
        }

        public final Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            return entry;
        }

        public final boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.m2003a(outputStream, 538183203);
                DiskBasedCache.m2001a(outputStream, this.key);
                DiskBasedCache.m2001a(outputStream, this.etag == null ? "" : this.etag);
                DiskBasedCache.m2002a(outputStream, this.serverDate);
                DiskBasedCache.m2002a(outputStream, this.ttl);
                DiskBasedCache.m2002a(outputStream, this.softTtl);
                DiskBasedCache.m1998a(this.responseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.m2013d("%s", e.toString());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.volley.toolbox.DiskBasedCache$b */
    /* loaded from: classes2.dex */
    public static class C3926b extends FilterInputStream {

        /* renamed from: a */
        private int f21319a;

        /* synthetic */ C3926b(InputStream inputStream, byte b) {
            this(inputStream);
        }

        private C3926b(InputStream inputStream) {
            super(inputStream);
            this.f21319a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f21319a++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f21319a += read;
            }
            return read;
        }
    }

    /* renamed from: e */
    private static int m1994e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    static void m2003a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: a */
    static int m2005a(InputStream inputStream) throws IOException {
        return (m1994e(inputStream) << 24) | (m1994e(inputStream) << 0) | 0 | (m1994e(inputStream) << 8) | (m1994e(inputStream) << 16);
    }

    /* renamed from: a */
    static void m2002a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    /* renamed from: b */
    static long m1997b(InputStream inputStream) throws IOException {
        return ((m1994e(inputStream) & 255) << 0) | 0 | ((m1994e(inputStream) & 255) << 8) | ((m1994e(inputStream) & 255) << 16) | ((m1994e(inputStream) & 255) << 24) | ((m1994e(inputStream) & 255) << 32) | ((m1994e(inputStream) & 255) << 40) | ((m1994e(inputStream) & 255) << 48) | ((255 & m1994e(inputStream)) << 56);
    }

    /* renamed from: a */
    static void m2001a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m2002a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: c */
    static String m1996c(InputStream inputStream) throws IOException {
        return new String(m2004a(inputStream, (int) m1997b(inputStream)), "UTF-8");
    }

    /* renamed from: a */
    static void m1998a(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            m2003a(outputStream, map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                m2001a(outputStream, entry.getKey());
                m2001a(outputStream, entry.getValue());
            }
            return;
        }
        m2003a(outputStream, 0);
    }

    /* renamed from: d */
    static Map<String, String> m1995d(InputStream inputStream) throws IOException {
        int m2005a = m2005a(inputStream);
        Map<String, String> emptyMap = m2005a == 0 ? Collections.emptyMap() : new HashMap<>(m2005a);
        for (int i = 0; i < m2005a; i++) {
            emptyMap.put(m1996c(inputStream).intern(), m1996c(inputStream).intern());
        }
        return emptyMap;
    }
}
