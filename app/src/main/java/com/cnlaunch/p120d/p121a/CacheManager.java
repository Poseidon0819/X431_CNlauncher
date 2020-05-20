package com.cnlaunch.p120d.p121a;

import android.os.Environment;
import android.text.TextUtils;
import com.cnlaunch.p120d.p130d.NLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

/* renamed from: com.cnlaunch.d.a.e */
/* loaded from: classes.dex */
public class CacheManager {

    /* renamed from: a */
    private static final String f6771a = "e";

    /* renamed from: b */
    private static String f6772b;

    /* renamed from: a */
    public static void m9604a(String str) {
        f6772b = str;
    }

    /* renamed from: a */
    public static <T> void m9603a(String str, String str2) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && NLog.m9458a()) {
                StringBuilder sb = new StringBuilder(Environment.getExternalStorageDirectory().getPath());
                sb.append(File.separator);
                sb.append("testData");
                File file = new File(sb.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                sb.append(File.separator);
                sb.append(str2);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(sb.toString())));
                bufferedOutputStream.write(str.getBytes());
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                NLog.m9451c(f6771a, "saveTestData success: ".concat(String.valueOf(sb)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static <T> boolean m9605a(Object obj, String str) {
        try {
            String m9600d = m9600d(str);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(m9600d));
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            objectOutputStream.close();
            File file = new File(m9600d);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
                NLog.m9451c(f6771a, "writeObject object success : ".concat(String.valueOf(m9600d)));
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    public static <T> T m9602b(String str) {
        T t = null;
        try {
            String m9600d = m9600d(str);
            if (new File(m9600d).exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(m9600d));
                t = (T) objectInputStream.readObject();
                objectInputStream.close();
                return t;
            }
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return t;
        } catch (OptionalDataException e2) {
            e2.printStackTrace();
            return t;
        } catch (StreamCorruptedException e3) {
            e3.printStackTrace();
            return t;
        } catch (IOException e4) {
            e4.printStackTrace();
            return t;
        } catch (ClassNotFoundException e5) {
            e5.printStackTrace();
            return t;
        }
    }

    /* renamed from: c */
    public static <T> boolean m9601c(String str) {
        String m9600d = m9600d(str);
        File file = new File(m9600d);
        if (file.exists() && System.currentTimeMillis() - file.lastModified() < 2592000000L) {
            NLog.m9451c(f6771a, "the cahce is effect : ".concat(String.valueOf(m9600d)));
            return true;
        }
        NLog.m9451c(f6771a, "the cahce is invalid : ".concat(String.valueOf(m9600d)));
        return false;
    }

    /* renamed from: d */
    private static <T> String m9600d(String str) {
        if (TextUtils.isEmpty(f6772b)) {
            throw new IllegalArgumentException("CacheManager sysCachePath is not null.");
        }
        return f6772b + File.separator + str;
    }

    /* renamed from: a */
    public static boolean m9606a() {
        if (!TextUtils.isEmpty(f6772b)) {
            File file = new File(f6772b);
            if (file.exists()) {
                return file.delete();
            }
        } else {
            NLog.m9451c(f6771a, "sysCachePath is null");
        }
        return false;
    }
}
