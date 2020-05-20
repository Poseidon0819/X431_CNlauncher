package com.mopub.common.util;

import java.security.MessageDigest;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class Utils {

    /* renamed from: a */
    private static final AtomicLong f20243a = new AtomicLong(1);

    public static boolean bitMaskContainsFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static String sha1(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02X", Byte.valueOf(digest[i])));
            }
            return sb.toString().toLowerCase(Locale.US);
        } catch (Exception unused) {
            return "";
        }
    }

    public static long generateUniqueId() {
        long j;
        long j2;
        do {
            j = f20243a.get();
            j2 = j + 1;
        } while (!f20243a.compareAndSet(j, j2 <= 9223372036854775806L ? j2 : 1L));
        return j;
    }
}
