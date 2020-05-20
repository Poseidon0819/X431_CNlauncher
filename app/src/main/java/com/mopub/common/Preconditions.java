package com.mopub.common;

import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import java.util.IllegalFormatException;

/* loaded from: classes.dex */
public final class Preconditions {
    public static final String EMPTY_ARGUMENTS = "";

    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
        m2547c(z, true, "Illegal argument.", "");
    }

    public static void checkArgument(boolean z, String str) {
        m2547c(z, true, str, "");
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        m2547c(z, true, str, objArr);
    }

    public static void checkState(boolean z) {
        m2546d(z, true, "Illegal state.", "");
    }

    public static void checkState(boolean z, String str) {
        m2546d(z, true, str, "");
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        m2546d(z, true, str, objArr);
    }

    public static void checkNotNull(Object obj) {
        m2550b(obj, true, "Object can not be null.", "");
    }

    public static void checkNotNull(Object obj, String str) {
        m2550b(obj, true, str, "");
    }

    public static void checkNotNull(Object obj, String str, Object... objArr) {
        m2550b(obj, true, str, objArr);
    }

    public static void checkUiThread() {
        m2549b(true, "This method must be called from the UI thread.", "");
    }

    public static void checkUiThread(String str) {
        m2549b(true, str, "");
    }

    public static void checkUiThread(String str, Object... objArr) {
        m2549b(true, str, objArr);
    }

    /* loaded from: classes.dex */
    public static final class NoThrow {

        /* renamed from: a */
        private static volatile boolean f20095a = false;

        public static void setStrictMode(boolean z) {
            f20095a = z;
        }

        public static boolean checkArgument(boolean z) {
            return Preconditions.m2547c(z, f20095a, "Illegal argument", "");
        }

        public static boolean checkArgument(boolean z, String str) {
            return Preconditions.m2547c(z, f20095a, str, "");
        }

        public static boolean checkArgument(boolean z, String str, Object... objArr) {
            return Preconditions.m2547c(z, f20095a, str, objArr);
        }

        public static boolean checkState(boolean z) {
            return Preconditions.m2546d(z, f20095a, "Illegal state.", "");
        }

        public static boolean checkState(boolean z, String str) {
            return Preconditions.m2546d(z, f20095a, str, "");
        }

        public static boolean checkState(boolean z, String str, Object... objArr) {
            return Preconditions.m2546d(z, f20095a, str, objArr);
        }

        public static boolean checkNotNull(Object obj) {
            return Preconditions.m2550b(obj, f20095a, "Object can not be null.", "");
        }

        public static boolean checkNotNull(Object obj, String str) {
            return Preconditions.m2550b(obj, f20095a, str, "");
        }

        public static boolean checkNotNull(Object obj, String str, Object... objArr) {
            return Preconditions.m2550b(obj, f20095a, str, objArr);
        }

        public static boolean checkUiThread() {
            return Preconditions.m2549b(f20095a, "This method must be called from the UI thread.", "");
        }

        public static boolean checkUiThread(String str) {
            return Preconditions.m2549b(f20095a, str, "");
        }

        public static boolean checkUiThread(String str, Object... objArr) {
            return Preconditions.m2549b(false, str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m2547c(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String m2553a = m2553a(str, objArr);
        if (z2) {
            throw new IllegalArgumentException(m2553a);
        }
        MoPubLog.m2496e(m2553a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static boolean m2546d(boolean z, boolean z2, String str, Object... objArr) {
        if (z) {
            return true;
        }
        String m2553a = m2553a(str, objArr);
        if (z2) {
            throw new IllegalStateException(m2553a);
        }
        MoPubLog.m2496e(m2553a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m2550b(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String m2553a = m2553a(str, objArr);
        if (z) {
            throw new NullPointerException(m2553a);
        }
        MoPubLog.m2496e(m2553a);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m2549b(boolean z, String str, Object... objArr) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            return true;
        }
        String m2553a = m2553a(str, objArr);
        if (z) {
            throw new IllegalStateException(m2553a);
        }
        MoPubLog.m2496e(m2553a);
        return false;
    }

    /* renamed from: a */
    private static String m2553a(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e) {
            MoPubLog.m2496e("MoPub preconditions had a format exception: " + e.getMessage());
            return valueOf;
        }
    }
}
