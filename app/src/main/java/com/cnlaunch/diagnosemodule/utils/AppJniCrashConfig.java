package com.cnlaunch.diagnosemodule.utils;

import android.os.Environment;
import com.cnlaunch.physics.p205k.C1856n;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

/* loaded from: classes.dex */
public class AppJniCrashConfig {
    private static AppJniCrashConfig mAppJniCrashConfig;
    private boolean mDebugSwitch;
    private final String ROOT = "cnlaunch";
    private final String CONFIG_DIR = "app_jni_crash";
    private final String CONFIG_FILE = "app_jni_crash_config.properties";
    private final String CONFIG_DEBUG_KEY = "debug";
    private final String DEBUG_DIR = "app_jni_crash_debug";

    public static AppJniCrashConfig getInstance() {
        if (mAppJniCrashConfig == null) {
            mAppJniCrashConfig = new AppJniCrashConfig();
        }
        return mAppJniCrashConfig;
    }

    private AppJniCrashConfig() {
        this.mDebugSwitch = false;
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "cnlaunch" + File.separator + "app_jni_crash" + File.separator + "app_jni_crash_config.properties");
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                this.mDebugSwitch = Boolean.parseBoolean(properties.getProperty("debug"));
                C1856n.m8130a("AppJniCrashConfig", "DebugSwitch = " + this.mDebugSwitch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean isDebug() {
        return this.mDebugSwitch;
    }

    public String getDebugAbsolutePath() {
        try {
            String str = Environment.getExternalStorageDirectory().getPath() + File.separator + "cnlaunch" + File.separator + "app_jni_crash" + File.separator + "app_jni_crash_debug";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
            File file2 = new File(str + File.separator + simpleDateFormat.format(new Date()) + ".txt");
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                    return file2.getAbsolutePath();
                } catch (Exception unused) {
                    return "";
                }
            }
            return file2.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
