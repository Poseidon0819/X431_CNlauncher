package com.unionpay.mobile.android.pboctransaction.sdapdu;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.unionpay.mobile.android.pboctransaction.sdapdu.b */
/* loaded from: classes2.dex */
public final class C4288b {

    /* renamed from: a */
    public static String[] f22823a;

    /* renamed from: b */
    public static int f22824b;

    /* renamed from: c */
    private static ArrayList<String> f22825c = new ArrayList<>();

    /* renamed from: a */
    public static void m1243a() {
        HashSet<String> m1242b = m1242b();
        f22823a = new String[m1242b.size()];
        m1242b.toArray(f22823a);
    }

    /* renamed from: b */
    private static HashSet<String> m1242b() {
        String[] split;
        String[] split2;
        byte[] bArr;
        HashSet<String> hashSet = new HashSet<>();
        String str = "";
        try {
            Process start = new ProcessBuilder(new String[0]).command("mount").redirectErrorStream(true).start();
            start.waitFor();
            InputStream inputStream = start.getInputStream();
            while (inputStream.read(new byte[1024]) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String str2 : str.split("\n")) {
            if (!str2.toLowerCase(Locale.US).contains("asec") && str2.matches("(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*")) {
                for (String str3 : str2.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                    if (str3.startsWith("/") && !str3.toLowerCase(Locale.US).contains("vold")) {
                        hashSet.add(str3);
                    }
                }
            }
        }
        return hashSet;
    }
}
