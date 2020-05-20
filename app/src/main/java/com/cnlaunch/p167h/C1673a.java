package com.cnlaunch.p167h;

import android.util.Log;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: DevRecordLog.java */
/* renamed from: com.cnlaunch.h.a */
/* loaded from: classes.dex */
public final class C1673a {

    /* renamed from: a */
    private static C1673a f8854a;

    /* renamed from: b */
    private StringBuilder f8855b;

    /* renamed from: c */
    private String f8856c;

    /* renamed from: d */
    private final boolean f8857d = true;

    /* renamed from: e */
    private SimpleDateFormat f8858e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /* renamed from: f */
    private final long f8859f = 604800000;

    /* renamed from: g */
    private PrintWriter f8860g = null;

    /* renamed from: h */
    private StringWriter f8861h = null;

    public C1673a() {
        this.f8855b = null;
        this.f8856c = "";
        this.f8856c = "";
        this.f8855b = new StringBuilder();
    }

    /* renamed from: a */
    public static C1673a m8965a() {
        if (f8854a == null) {
            f8854a = new C1673a();
        }
        return f8854a;
    }

    /* renamed from: b */
    public final String m8962b() {
        try {
            synchronized (this.f8855b) {
                if (this.f8855b == null) {
                    return "";
                }
                this.f8856c = this.f8855b.toString();
                this.f8855b.delete(0, this.f8855b.length());
                return this.f8856c;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("RecordLog", e.toString());
            return "";
        }
    }

    /* renamed from: a */
    public final void m8964a(String str) {
        try {
            synchronized (this.f8855b) {
                if (this.f8855b == null) {
                    this.f8855b = new StringBuilder();
                }
                StringBuilder sb = this.f8855b;
                sb.append("<" + this.f8858e.format(new Date()) + ">");
                StringBuilder sb2 = this.f8855b;
                sb2.append(str + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("RecordLog", e.toString());
        }
    }

    /* renamed from: b */
    public static void m8961b(String str) {
        File[] listFiles;
        try {
            File file = new File(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (!file2.isDirectory() && currentTimeMillis - file2.lastModified() > 604800000) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0056 -> B:29:0x0059). Please submit an issue!!! */
    /* renamed from: a */
    public final void m8963a(String str, Exception exc) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            try {
                this.f8861h = new StringWriter();
                this.f8860g = new PrintWriter(this.f8861h);
                exc.printStackTrace(this.f8860g);
                this.f8860g.flush();
                this.f8861h.flush();
                try {
                    if (this.f8861h != null) {
                        this.f8861h.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.f8860g != null) {
                    this.f8860g.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                try {
                    if (this.f8861h != null) {
                        this.f8861h.close();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (this.f8860g != null) {
                    this.f8860g.close();
                }
            }
            str = str + this.f8861h.toString();
            m8964a(str);
        } catch (Throwable th) {
            try {
                if (this.f8861h != null) {
                    this.f8861h.close();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                if (this.f8860g != null) {
                    this.f8860g.close();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            throw th;
        }
    }
}
