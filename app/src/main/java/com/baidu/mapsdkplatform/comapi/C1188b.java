package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.EnvironmentUtilities;
import java.io.File;
import java.io.IOException;

/* renamed from: com.baidu.mapsdkplatform.comapi.b */
/* loaded from: classes.dex */
public class C1188b {

    /* renamed from: a */
    private static boolean f5879a;

    /* renamed from: a */
    public static void m10824a(Context context, boolean z, String str, String str2) {
        if (f5879a) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context can not be null");
        }
        if (!(context instanceof Application)) {
            throw new RuntimeException("context must be an ApplicationContext");
        }
        NativeLoader.setContext(context);
        NativeLoader.m10872a(z, str);
        C1171a.m10862a().m10861a(context);
        C1171a.m10862a().m10857c();
        JNIInitializer.setContext((Application) context);
        if (m10823a(str2)) {
            EnvironmentUtilities.setSDCardPath(str2);
        }
        f5879a = true;
    }

    /* renamed from: a */
    private static boolean m10823a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            File file = new File(str + "/check.0");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            if (file.exists()) {
                file.delete();
                return true;
            }
            return true;
        } catch (IOException e) {
            Log.e("SDKInitializer", "SDCard cache path invalid", e);
            throw new IllegalArgumentException("Provided sdcard cache path invalid can not used.");
        }
    }
}
