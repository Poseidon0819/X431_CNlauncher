package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CopyFile {
    public static ArrayList<String> list = new ArrayList<>();

    public static void findAllSoFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    findAllSoFile(str + "/" + listFiles[i].getName() + "/");
                } else {
                    String path = listFiles[i].getPath();
                    String name = listFiles[i].getName();
                    if (name.contains("lib") && name.contains(".so")) {
                        list.add(path);
                    }
                }
            }
        }
    }

    public static int copySo(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            int i = 0;
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                String name = listFiles[i2].getName();
                if (listFiles[i2].isDirectory()) {
                    int copySo = copySo(listFiles[i2].getPath() + "/", str2 + "/" + listFiles[i2].getName() + "/");
                    if (copySo != -1) {
                        i += copySo;
                    }
                } else if (name.contains("lib") && name.contains(".so")) {
                    if (CopySdcardFile(listFiles[i2].getPath(), str2 + "/" + listFiles[i2].getName()) != 0) {
                        i++;
                    }
                }
            }
            return i;
        }
        return -1;
    }

    public static int copySpecNameSo(String str, String str2, ArrayList<String> arrayList) {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            int i = 0;
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                String name = listFiles[i2].getName();
                if (listFiles[i2].isDirectory()) {
                    int copySpecNameSo = copySpecNameSo(listFiles[i2].getPath() + "/", str2 + "/" + listFiles[i2].getName() + "/", arrayList);
                    if (copySpecNameSo != -1) {
                        i += copySpecNameSo;
                    }
                } else if (arrayList.contains(name)) {
                    if (CopySdcardFile(listFiles[i2].getPath(), str2 + "/" + listFiles[i2].getName()) != 0) {
                        i++;
                    }
                }
            }
            return i;
        }
        return -1;
    }

    public static int copy(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (listFiles == null) {
                return 0;
            }
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    copy(listFiles[i].getPath() + "/", str2 + "/" + listFiles[i].getName() + "/");
                } else {
                    CopySdcardFile(listFiles[i].getPath(), str2 + "/" + listFiles[i].getName());
                }
            }
            return 0;
        }
        return -1;
    }

    public static int CopySdcardFile(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return 0;
                }
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int CopyAssetsToSDcard(Context context, String str, String str2) {
        try {
            InputStream open = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.close();
                    return 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static synchronized int delectFile(String str) {
        synchronized (CopyFile.class) {
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        delectFile(listFiles[i].getPath() + "/");
                    } else {
                        File file2 = new File(listFiles[i].getPath());
                        if (file2.exists()) {
                            file2.delete();
                        }
                    }
                }
                return 0;
            }
            return -1;
        }
    }
}
