package com.mopub.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class VolleyLog {
    public static boolean DEBUG = Log.isLoggable("Volley", 2);
    public static String TAG = "Volley";

    public static void setTag(String str) {
        m2013d("Changing log tag to %s", str);
        TAG = str;
        DEBUG = Log.isLoggable(str, 2);
    }

    /* renamed from: v */
    public static void m2010v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, m2014a(str, objArr));
        }
    }

    /* renamed from: d */
    public static void m2013d(String str, Object... objArr) {
        Log.d(TAG, m2014a(str, objArr));
    }

    /* renamed from: e */
    public static void m2012e(String str, Object... objArr) {
        Log.e(TAG, m2014a(str, objArr));
    }

    /* renamed from: e */
    public static void m2011e(Throwable th, String str, Object... objArr) {
        Log.e(TAG, m2014a(str, objArr), th);
    }

    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, m2014a(str, objArr));
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        Log.wtf(TAG, m2014a(str, objArr), th);
    }

    /* renamed from: a */
    private static String m2014a(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            } else if (!stackTrace[i].getClass().equals(VolleyLog.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.volley.VolleyLog$a */
    /* loaded from: classes2.dex */
    public static class C3919a {
        public static final boolean ENABLED = VolleyLog.DEBUG;

        /* renamed from: a */
        private final List<C3920a> f21288a = new ArrayList();

        /* renamed from: b */
        private boolean f21289b = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mopub.volley.VolleyLog$a$a */
        /* loaded from: classes2.dex */
        public static class C3920a {
            public final String name;
            public final long thread;
            public final long time;

            public C3920a(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        public final synchronized void add(String str, long j) {
            if (this.f21289b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f21288a.add(new C3920a(str, j, SystemClock.elapsedRealtime()));
        }

        public final synchronized void finish(String str) {
            this.f21289b = true;
            long j = this.f21288a.size() == 0 ? 0L : this.f21288a.get(this.f21288a.size() - 1).time - this.f21288a.get(0).time;
            if (j <= 0) {
                return;
            }
            long j2 = this.f21288a.get(0).time;
            VolleyLog.m2013d("(%-4d ms) %s", Long.valueOf(j), str);
            for (C3920a c3920a : this.f21288a) {
                long j3 = c3920a.time;
                VolleyLog.m2013d("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(c3920a.thread), c3920a.name);
                j2 = j3;
            }
        }

        protected final void finalize() throws Throwable {
            if (this.f21289b) {
                return;
            }
            finish("Request on the loose");
            VolleyLog.m2012e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }
}
