package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.util.List;

/* loaded from: classes.dex */
public class SystemAppTools {
    public static boolean getAppsIsExist(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            PackageInfo packageInfo = installedPackages.get(i);
            int i2 = packageInfo.applicationInfo.flags;
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (((i2 & 1) <= 0 || "com.android.gallery3d".equals(packageInfo.packageName)) && packageInfo.packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
