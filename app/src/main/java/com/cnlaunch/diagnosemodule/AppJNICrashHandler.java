package com.cnlaunch.diagnosemodule;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.cnlaunch.diagnosemodule.service.DiagnoseService;
import com.cnlaunch.diagnosemodule.utils.AppJniCrashConfig;
import com.cnlaunch.physics.p205k.C1856n;

/* loaded from: classes.dex */
public class AppJNICrashHandler {
    public static Context mContext;

    public static native void registerJNICrashHandler(boolean z);

    public static native void testJNICrashHandler();

    static {
        System.loadLibrary("JNICrashHandler");
    }

    public static void notifyNativeCrash() {
        try {
            C1856n.m8130a("AppJNICrashHandler", "notifyNativeCrash() start");
            if (mContext != null) {
                if (AppJniCrashConfig.getInstance().isDebug()) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(mContext, "com.cnlaunch.diagnosemodule.service.AppJniCrashHandlerService"));
                    intent.putExtra("app_jni_crash_debug_path", AppJniCrashConfig.getInstance().getDebugAbsolutePath());
                    mContext.startService(intent);
                    return;
                }
                DiagnoseService diagnoseService = mContext instanceof DiagnoseService ? (DiagnoseService) mContext : null;
                if (diagnoseService != null) {
                    C1856n.m8130a("AppJNICrashHandler", "diagnoseService.sendCrashInfoBroadcast()");
                    diagnoseService.sendCrashInfoBroadcast();
                }
            }
            C1856n.m8130a("AppJNICrashHandler", "notifyNativeCrash() end");
            Process.killProcess(Process.myPid());
        } catch (Exception e) {
            C1856n.m8130a("AppJNICrashHandler", "notifyNativeCrash() start" + e.getMessage());
            e.printStackTrace();
            Process.killProcess(Process.myPid());
        }
    }

    public static void setContext(Context context) {
        mContext = context;
    }
}
