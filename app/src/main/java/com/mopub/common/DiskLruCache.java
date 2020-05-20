package com.mopub.common;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.http.conn.ssl.TokenParser;

/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable {

    /* renamed from: a */
    static final Pattern f20026a = Pattern.compile("[a-z0-9_-]{1,64}");

    /* renamed from: p */
    private static final OutputStream f20027p = new C3687d();

    /* renamed from: c */
    private final File f20029c;

    /* renamed from: d */
    private final File f20030d;

    /* renamed from: e */
    private final File f20031e;

    /* renamed from: f */
    private final File f20032f;

    /* renamed from: g */
    private final int f20033g;

    /* renamed from: h */
    private long f20034h;

    /* renamed from: i */
    private final int f20035i;

    /* renamed from: k */
    private Writer f20037k;

    /* renamed from: m */
    private int f20039m;

    /* renamed from: j */
    private long f20036j = 0;

    /* renamed from: l */
    private final LinkedHashMap<String, C3679a> f20038l = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: n */
    private long f20040n = 0;

    /* renamed from: b */
    final ThreadPoolExecutor f20028b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: o */
    private final Callable<Void> f20041o = new CallableC3686c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ int m2581e(DiskLruCache diskLruCache) {
        diskLruCache.f20039m = 0;
        return 0;
    }

    private DiskLruCache(File file, int i, int i2, long j) {
        this.f20029c = file;
        this.f20033g = i;
        this.f20030d = new File(file, "journal");
        this.f20031e = new File(file, "journal.tmp");
        this.f20032f = new File(file, "journal.bkp");
        this.f20035i = i2;
        this.f20034h = j;
    }

    public static DiskLruCache open(File file, int i, int i2, long j) throws IOException {
        if (j > 0) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("valueCount <= 0");
            }
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m2592a(file2, file3, false);
                }
            }
            DiskLruCache diskLruCache = new DiskLruCache(file, i, i2, j);
            if (diskLruCache.f20030d.exists()) {
                try {
                    diskLruCache.m2588b();
                    diskLruCache.m2586c();
                    diskLruCache.f20037k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.f20030d, true), DiskLruCacheUtil.f20059a));
                    return diskLruCache;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    diskLruCache.delete();
                }
            }
            file.mkdirs();
            DiskLruCache diskLruCache2 = new DiskLruCache(file, i, i2, j);
            diskLruCache2.m2584d();
            return diskLruCache2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ed, code lost:
        throw new java.io.IOException("unexpected journal line: ".concat(java.lang.String.valueOf(r3)));
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m2588b() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.common.DiskLruCache.m2588b():void");
    }

    /* renamed from: c */
    private void m2586c() throws IOException {
        m2593a(this.f20031e);
        Iterator<C3679a> it = this.f20038l.values().iterator();
        while (it.hasNext()) {
            C3679a next = it.next();
            int i = 0;
            if (next.f20056d == null) {
                while (i < this.f20035i) {
                    this.f20036j += next.f20054b[i];
                    i++;
                }
            } else {
                next.f20056d = null;
                while (i < this.f20035i) {
                    m2593a(next.getCleanFile(i));
                    m2593a(next.getDirtyFile(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public synchronized void m2584d() throws IOException {
        if (this.f20037k != null) {
            this.f20037k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f20031e), DiskLruCacheUtil.f20059a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f20033g));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f20035i));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C3679a c3679a : this.f20038l.values()) {
            if (c3679a.f20056d != null) {
                bufferedWriter.write("DIRTY " + c3679a.f20053a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c3679a.f20053a + c3679a.getLengths() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f20030d.exists()) {
            m2592a(this.f20030d, this.f20032f, true);
        }
        m2592a(this.f20031e, this.f20030d, false);
        this.f20032f.delete();
        this.f20037k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f20030d, true), DiskLruCacheUtil.f20059a));
    }

    /* renamed from: a */
    private static void m2593a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m2592a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m2593a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized Snapshot get(String str) throws IOException {
        m2580f();
        m2590a(str);
        C3679a c3679a = this.f20038l.get(str);
        if (c3679a == null) {
            return null;
        }
        if (c3679a.f20055c) {
            InputStream[] inputStreamArr = new InputStream[this.f20035i];
            for (int i = 0; i < this.f20035i; i++) {
                try {
                    inputStreamArr[i] = new FileInputStream(c3679a.getCleanFile(i));
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < this.f20035i && inputStreamArr[i2] != null; i2++) {
                        DiskLruCacheUtil.m2571a(inputStreamArr[i2]);
                    }
                    return null;
                }
            }
            this.f20039m++;
            this.f20037k.append((CharSequence) ("READ " + str + '\n'));
            if (m2582e()) {
                this.f20028b.submit(this.f20041o);
            }
            return new Snapshot(this, str, c3679a.f20057e, inputStreamArr, c3679a.f20054b, (byte) 0);
        }
        return null;
    }

    public final Editor edit(String str) throws IOException {
        return m2589a(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized Editor m2589a(String str, long j) throws IOException {
        m2580f();
        m2590a(str);
        C3679a c3679a = this.f20038l.get(str);
        if (j == -1 || (c3679a != null && c3679a.f20057e == j)) {
            if (c3679a == null) {
                c3679a = new C3679a(this, str, (byte) 0);
                this.f20038l.put(str, c3679a);
            } else if (c3679a.f20056d != null) {
                return null;
            }
            Editor editor = new Editor(this, c3679a, (byte) 0);
            c3679a.f20056d = editor;
            Writer writer = this.f20037k;
            writer.write("DIRTY " + str + '\n');
            this.f20037k.flush();
            return editor;
        }
        return null;
    }

    public final File getDirectory() {
        return this.f20029c;
    }

    public final synchronized long getMaxSize() {
        return this.f20034h;
    }

    public final synchronized void setMaxSize(long j) {
        this.f20034h = j;
        this.f20028b.submit(this.f20041o);
    }

    public final synchronized long size() {
        return this.f20036j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m2597a(Editor editor, boolean z) throws IOException {
        C3679a c3679a = editor.f20043b;
        if (c3679a.f20056d != editor) {
            throw new IllegalStateException();
        }
        if (z && !c3679a.f20055c) {
            for (int i = 0; i < this.f20035i; i++) {
                if (!editor.f20044c[i]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                } else if (!c3679a.getDirtyFile(i).exists()) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.f20035i; i2++) {
            File dirtyFile = c3679a.getDirtyFile(i2);
            if (z) {
                if (dirtyFile.exists()) {
                    File cleanFile = c3679a.getCleanFile(i2);
                    dirtyFile.renameTo(cleanFile);
                    long j = c3679a.f20054b[i2];
                    long length = cleanFile.length();
                    c3679a.f20054b[i2] = length;
                    this.f20036j = (this.f20036j - j) + length;
                }
            } else {
                m2593a(dirtyFile);
            }
        }
        this.f20039m++;
        c3679a.f20056d = null;
        if (!(c3679a.f20055c | z)) {
            this.f20038l.remove(c3679a.f20053a);
            this.f20037k.write("REMOVE " + c3679a.f20053a + '\n');
        } else {
            c3679a.f20055c = true;
            this.f20037k.write("CLEAN " + c3679a.f20053a + c3679a.getLengths() + '\n');
            if (z) {
                long j2 = this.f20040n;
                this.f20040n = 1 + j2;
                c3679a.f20057e = j2;
            }
        }
        this.f20037k.flush();
        if (this.f20036j > this.f20034h || m2582e()) {
            this.f20028b.submit(this.f20041o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m2582e() {
        int i = this.f20039m;
        return i >= 2000 && i >= this.f20038l.size();
    }

    public final synchronized boolean remove(String str) throws IOException {
        m2580f();
        m2590a(str);
        C3679a c3679a = this.f20038l.get(str);
        if (c3679a != null && c3679a.f20056d == null) {
            for (int i = 0; i < this.f20035i; i++) {
                File cleanFile = c3679a.getCleanFile(i);
                if (cleanFile.exists() && !cleanFile.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(cleanFile)));
                }
                this.f20036j -= c3679a.f20054b[i];
                c3679a.f20054b[i] = 0;
            }
            this.f20039m++;
            this.f20037k.append((CharSequence) ("REMOVE " + str + '\n'));
            this.f20038l.remove(str);
            if (m2582e()) {
                this.f20028b.submit(this.f20041o);
            }
            return true;
        }
        return false;
    }

    public final synchronized boolean isClosed() {
        return this.f20037k == null;
    }

    /* renamed from: f */
    private void m2580f() {
        if (this.f20037k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() throws IOException {
        m2580f();
        m2578g();
        this.f20037k.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.f20037k == null) {
            return;
        }
        Iterator it = new ArrayList(this.f20038l.values()).iterator();
        while (it.hasNext()) {
            C3679a c3679a = (C3679a) it.next();
            if (c3679a.f20056d != null) {
                c3679a.f20056d.abort();
            }
        }
        m2578g();
        this.f20037k.close();
        this.f20037k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m2578g() throws IOException {
        while (this.f20036j > this.f20034h) {
            remove(this.f20038l.entrySet().iterator().next().getKey());
        }
    }

    public final void delete() throws IOException {
        close();
        DiskLruCacheUtil.m2570a(this.f20029c);
    }

    /* renamed from: a */
    private static void m2590a(String str) {
        if (f20026a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    /* loaded from: classes.dex */
    public final class Snapshot implements Closeable {

        /* renamed from: b */
        private final String f20049b;

        /* renamed from: c */
        private final long f20050c;

        /* renamed from: d */
        private final InputStream[] f20051d;

        /* renamed from: e */
        private final long[] f20052e;

        /* synthetic */ Snapshot(DiskLruCache diskLruCache, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, inputStreamArr, jArr);
        }

        private Snapshot(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f20049b = str;
            this.f20050c = j;
            this.f20051d = inputStreamArr;
            this.f20052e = jArr;
        }

        public final Editor edit() throws IOException {
            return DiskLruCache.this.m2589a(this.f20049b, this.f20050c);
        }

        public final InputStream getInputStream(int i) {
            return this.f20051d[i];
        }

        public final String getString(int i) throws IOException {
            return DiskLruCache.m2591a(getInputStream(i));
        }

        public final long getLength(int i) {
            return this.f20052e[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.f20051d) {
                DiskLruCacheUtil.m2571a(inputStream);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Editor {

        /* renamed from: b */
        private final C3679a f20043b;

        /* renamed from: c */
        private final boolean[] f20044c;

        /* renamed from: d */
        private boolean f20045d;

        /* renamed from: e */
        private boolean f20046e;

        /* synthetic */ Editor(DiskLruCache diskLruCache, C3679a c3679a, byte b) {
            this(c3679a);
        }

        /* renamed from: c */
        static /* synthetic */ boolean m2574c(Editor editor) {
            editor.f20045d = true;
            return true;
        }

        private Editor(C3679a c3679a) {
            this.f20043b = c3679a;
            this.f20044c = c3679a.f20055c ? null : new boolean[DiskLruCache.this.f20035i];
        }

        public final InputStream newInputStream(int i) throws IOException {
            synchronized (DiskLruCache.this) {
                if (this.f20043b.f20056d != this) {
                    throw new IllegalStateException();
                }
                if (this.f20043b.f20055c) {
                    try {
                        return new FileInputStream(this.f20043b.getCleanFile(i));
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
                return null;
            }
        }

        public final String getString(int i) throws IOException {
            InputStream newInputStream = newInputStream(i);
            if (newInputStream != null) {
                return DiskLruCache.m2591a(newInputStream);
            }
            return null;
        }

        public final OutputStream newOutputStream(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C3678a c3678a;
            synchronized (DiskLruCache.this) {
                if (this.f20043b.f20056d != this) {
                    throw new IllegalStateException();
                }
                if (!this.f20043b.f20055c) {
                    this.f20044c[i] = true;
                }
                File dirtyFile = this.f20043b.getDirtyFile(i);
                try {
                    fileOutputStream = new FileOutputStream(dirtyFile);
                } catch (FileNotFoundException unused) {
                    DiskLruCache.this.f20029c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException unused2) {
                        return DiskLruCache.f20027p;
                    }
                }
                c3678a = new C3678a(this, fileOutputStream, (byte) 0);
            }
            return c3678a;
        }

        public final void set(int i, String str) throws IOException {
            OutputStreamWriter outputStreamWriter;
            OutputStreamWriter outputStreamWriter2 = null;
            try {
                outputStreamWriter = new OutputStreamWriter(newOutputStream(i), DiskLruCacheUtil.f20060b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStreamWriter.write(str);
                DiskLruCacheUtil.m2571a(outputStreamWriter);
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter2 = outputStreamWriter;
                DiskLruCacheUtil.m2571a(outputStreamWriter2);
                throw th;
            }
        }

        public final void commit() throws IOException {
            if (this.f20045d) {
                DiskLruCache.this.m2597a(this, false);
                DiskLruCache.this.remove(this.f20043b.f20053a);
            } else {
                DiskLruCache.this.m2597a(this, true);
            }
            this.f20046e = true;
        }

        public final void abort() throws IOException {
            DiskLruCache.this.m2597a(this, false);
        }

        public final void abortUnlessCommitted() {
            if (this.f20046e) {
                return;
            }
            try {
                abort();
            } catch (IOException unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.common.DiskLruCache$Editor$a */
        /* loaded from: classes.dex */
        public class C3678a extends FilterOutputStream {
            /* synthetic */ C3678a(Editor editor, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            private C3678a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    Editor.m2574c(Editor.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    Editor.m2574c(Editor.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    Editor.m2574c(Editor.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    Editor.m2574c(Editor.this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.DiskLruCache$a */
    /* loaded from: classes.dex */
    public final class C3679a {

        /* renamed from: a */
        final String f20053a;

        /* renamed from: b */
        final long[] f20054b;

        /* renamed from: c */
        boolean f20055c;

        /* renamed from: d */
        Editor f20056d;

        /* renamed from: e */
        long f20057e;

        /* synthetic */ C3679a(DiskLruCache diskLruCache, String str, byte b) {
            this(str);
        }

        private C3679a(String str) {
            this.f20053a = str;
            this.f20054b = new long[DiskLruCache.this.f20035i];
        }

        public final String getLengths() throws IOException {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f20054b) {
                sb.append(TokenParser.f24154SP);
                sb.append(j);
            }
            return sb.toString();
        }

        /* renamed from: a */
        final void m2573a(String[] strArr) throws IOException {
            if (strArr.length != DiskLruCache.this.f20035i) {
                throw m2572b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f20054b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw m2572b(strArr);
                }
            }
        }

        /* renamed from: b */
        private static IOException m2572b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File getCleanFile(int i) {
            File file = DiskLruCache.this.f20029c;
            return new File(file, this.f20053a + "." + i);
        }

        public final File getDirtyFile(int i) {
            File file = DiskLruCache.this.f20029c;
            return new File(file, this.f20053a + "." + i + ".tmp");
        }
    }

    /* renamed from: a */
    static /* synthetic */ String m2591a(InputStream inputStream) throws IOException {
        return DiskLruCacheUtil.m2569a((Reader) new InputStreamReader(inputStream, DiskLruCacheUtil.f20060b));
    }
}
