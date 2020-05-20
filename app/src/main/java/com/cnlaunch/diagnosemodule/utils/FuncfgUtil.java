package com.cnlaunch.diagnosemodule.utils;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: classes.dex */
public class FuncfgUtil {
    public static boolean getVersionSupSomeFunBoolean(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str + "Funcfg.so"));
            String property = getProperty(fileInputStream, str2);
            fileInputStream.close();
            if (!TextUtils.isEmpty(property)) {
                if (!property.equals("0;")) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getProperty(InputStream inputStream, String str) {
        try {
            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(inputStream);
                return properties.getProperty(str);
            }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getSDCardPath() {
        return Environment.getExternalStorageDirectory().getPath();
    }
}
