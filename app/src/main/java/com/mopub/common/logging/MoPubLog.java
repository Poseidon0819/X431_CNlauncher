package com.mopub.common.logging;

import android.annotation.SuppressLint;
import android.util.Log;
import com.mopub.common.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class MoPubLog {
    public static final String LOGGER_NAMESPACE = "com.mopub";

    /* renamed from: a */
    private static final Logger f20218a = Logger.getLogger(LOGGER_NAMESPACE);

    /* renamed from: b */
    private static final C3699a f20219b = new C3699a((byte) 0);

    static {
        f20218a.setUseParentHandlers(false);
        f20218a.setLevel(Level.ALL);
        f20219b.setLevel(Level.FINE);
        LogManager.getLogManager().addLogger(f20218a);
        Logger logger = f20218a;
        C3699a c3699a = f20219b;
        for (Handler handler : logger.getHandlers()) {
            if (handler.equals(c3699a)) {
                return;
            }
        }
        logger.addHandler(c3699a);
    }

    private MoPubLog() {
    }

    /* renamed from: c */
    public static void m2500c(String str) {
        m2499c(str, null);
    }

    /* renamed from: v */
    public static void m2492v(String str) {
        m2491v(str, null);
    }

    /* renamed from: d */
    public static void m2498d(String str) {
        m2497d(str, null);
    }

    /* renamed from: i */
    public static void m2494i(String str) {
        m2493i(str, null);
    }

    /* renamed from: w */
    public static void m2490w(String str) {
        m2489w(str, null);
    }

    /* renamed from: e */
    public static void m2496e(String str) {
        m2495e(str, null);
    }

    /* renamed from: c */
    public static void m2499c(String str, Throwable th) {
        f20218a.log(Level.FINEST, str, th);
    }

    /* renamed from: v */
    public static void m2491v(String str, Throwable th) {
        f20218a.log(Level.FINE, str, th);
    }

    /* renamed from: d */
    public static void m2497d(String str, Throwable th) {
        f20218a.log(Level.CONFIG, str, th);
    }

    /* renamed from: i */
    public static void m2493i(String str, Throwable th) {
        f20218a.log(Level.INFO, str, th);
    }

    /* renamed from: w */
    public static void m2489w(String str, Throwable th) {
        f20218a.log(Level.WARNING, str, th);
    }

    /* renamed from: e */
    public static void m2495e(String str, Throwable th) {
        f20218a.log(Level.SEVERE, str, th);
    }

    @VisibleForTesting
    public static void setSdkHandlerLevel(Level level) {
        f20219b.setLevel(level);
    }

    /* renamed from: com.mopub.common.logging.MoPubLog$a */
    /* loaded from: classes.dex */
    static final class C3699a extends Handler {

        /* renamed from: a */
        private static final Map<Level, Integer> f20220a;

        @Override // java.util.logging.Handler
        public final void close() {
        }

        @Override // java.util.logging.Handler
        public final void flush() {
        }

        private C3699a() {
        }

        /* synthetic */ C3699a(byte b) {
            this();
        }

        static {
            HashMap hashMap = new HashMap(7);
            f20220a = hashMap;
            hashMap.put(Level.FINEST, 2);
            f20220a.put(Level.FINER, 2);
            f20220a.put(Level.FINE, 2);
            f20220a.put(Level.CONFIG, 3);
            f20220a.put(Level.INFO, 4);
            f20220a.put(Level.WARNING, 5);
            f20220a.put(Level.SEVERE, 6);
        }

        @Override // java.util.logging.Handler
        @SuppressLint({"LogTagMismatch"})
        public final void publish(LogRecord logRecord) {
            Throwable thrown;
            if (isLoggable(logRecord)) {
                int intValue = f20220a.containsKey(logRecord.getLevel()) ? f20220a.get(logRecord.getLevel()).intValue() : 2;
                String str = logRecord.getMessage() + "\n";
                if (logRecord.getThrown() != null) {
                    str = str + Log.getStackTraceString(thrown);
                }
                Log.println(intValue, "MoPub", str);
            }
        }
    }
}
