package com.unionpay.utils;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.unionpay.utils.j */
/* loaded from: classes2.dex */
public final class C4652j {

    /* renamed from: a */
    private static boolean f23759a = false;

    /* renamed from: b */
    private static int f23760b = Integer.MAX_VALUE;

    /* renamed from: a */
    private static int m434a(int i, String str, String str2) {
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
            if (f23759a) {
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
    public static int m433a(String str, String str2) {
        if (f23760b <= 3) {
            m434a(3, str, str2);
            return 0;
        }
        return 0;
    }

    /* renamed from: b */
    public static int m432b(String str, String str2) {
        if (f23760b <= 6) {
            return m434a(6, str, str2);
        }
        return 0;
    }
}
