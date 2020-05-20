package com.cnlaunch.p120d.p130d;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.cnlaunch.d.d.a */
/* loaded from: classes.dex */
public final class DevRecordLog {

    /* renamed from: a */
    private static DevRecordLog f7184a;

    /* renamed from: b */
    private StringBuilder f7185b;

    /* renamed from: c */
    private String f7186c;

    /* renamed from: d */
    private final boolean f7187d = true;

    /* renamed from: e */
    private SimpleDateFormat f7188e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /* renamed from: f */
    private final long f7189f = 604800000;

    /* renamed from: g */
    private PrintWriter f7190g = null;

    /* renamed from: h */
    private StringWriter f7191h = null;

    public DevRecordLog() {
        this.f7185b = null;
        this.f7186c = "";
        this.f7186c = "";
        this.f7185b = new StringBuilder();
    }

    /* renamed from: a */
    public static DevRecordLog m9472a() {
        if (f7184a == null) {
            f7184a = new DevRecordLog();
        }
        return f7184a;
    }

    /* renamed from: b */
    public final String m9470b() {
        try {
            synchronized (this.f7185b) {
                if (this.f7185b == null) {
                    return "";
                }
                this.f7186c = this.f7185b.toString();
                this.f7185b.delete(0, this.f7185b.length());
                return this.f7186c;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("RecordLog", e.toString());
            return "";
        }
    }

    /* renamed from: a */
    public final void m9471a(String str) {
        try {
            synchronized (this.f7185b) {
                if (this.f7185b == null) {
                    this.f7185b = new StringBuilder();
                }
                StringBuilder sb = this.f7185b;
                sb.append("<" + this.f7188e.format(new Date()) + ">");
                StringBuilder sb2 = this.f7185b;
                sb2.append(str + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("RecordLog", e.toString());
        }
    }
}
