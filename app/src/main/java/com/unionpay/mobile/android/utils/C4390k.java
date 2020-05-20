package com.unionpay.mobile.android.utils;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.unionpay.mobile.android.utils.k */
/* loaded from: classes2.dex */
public final class C4390k {

    /* renamed from: a */
    private static boolean f23190a = false;

    /* renamed from: b */
    private static int f23191b = Integer.MAX_VALUE;

    /* renamed from: a */
    private static int m839a(int i, String str, String str2) {
        int i2 = 0;
        if (str != null && str2 != null) {
            switch (i) {
                case 2:
                    i2 = Log.v(str, str2);
                    break;
                case 3:
                    i2 = Log.d(str, str2);
                    break;
                case 4:
                    i2 = Log.i(str, str2);
                    break;
                case 5:
                    i2 = Log.w(str, str2);
                    break;
                case 6:
                    i2 = Log.e(str, str2);
                    break;
            }
            if (f23190a) {
                String str3 = "[ ERROR ] " + str + ":" + str2;
                try {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    File file = new File(externalStorageDirectory.getAbsolutePath() + File.separator + "upmp_log.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                    fileOutputStream.write((str3 + "\n").getBytes());
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return i2;
    }

    /* renamed from: a */
    public static int m838a(String str, String str2) {
        if (f23191b <= 3) {
            m839a(3, str, str2);
            return 0;
        }
        return 0;
    }

    /* renamed from: b */
    public static int m837b(String str, String str2) {
        if (f23191b <= 4) {
            m839a(4, str, str2);
            return 0;
        }
        return 0;
    }

    /* renamed from: c */
    public static int m836c(String str, String str2) {
        if (f23191b <= 6) {
            return m839a(6, str, str2);
        }
        return 0;
    }
}
