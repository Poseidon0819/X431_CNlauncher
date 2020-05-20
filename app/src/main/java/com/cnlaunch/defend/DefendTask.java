package com.cnlaunch.defend;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p120d.p130d.DevRecordLog;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

/* renamed from: com.cnlaunch.defend.b */
/* loaded from: classes.dex */
public final class DefendTask extends TimerTask {

    /* renamed from: a */
    private Context f7257a;

    /* renamed from: b */
    private String f7258b;

    /* renamed from: c */
    private String f7259c;

    /* renamed from: d */
    private String f7260d;

    /* renamed from: e */
    private int f7261e;

    /* renamed from: f */
    private int f7262f;

    private DefendTask(Context context, String str, String str2) {
        this.f7258b = "";
        this.f7259c = "";
        this.f7260d = "";
        this.f7261e = 0;
        this.f7262f = 0;
        this.f7257a = context;
        this.f7258b = str;
        this.f7259c = str2;
        this.f7260d = PathUtils.m4841o() + "Golo_" + DateUtils.m5094a("YYYYMMDD_hh") + ".txt";
    }

    public DefendTask(Context context, String str, String str2, int i) {
        this(context, str, str2);
        this.f7262f = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z2 = true;
        this.f7261e++;
        int i = this.f7261e;
        if (i == 1000) {
            i = 0;
        }
        this.f7261e = i;
        ActivityManager activityManager = (ActivityManager) this.f7257a.getSystemService("activity");
        if (this.f7261e % 2 == 0) {
            Iterator<ActivityManager.RunningServiceInfo> it = activityManager.getRunningServices(MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (this.f7259c.equals(it.next().service.getClassName())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.f7257a.sendBroadcast(new Intent(this.f7258b));
            }
        } else {
            z = false;
        }
        if ((this.f7262f & 1) == 1) {
            if (this.f7261e % 2 == 0 && !z) {
                DevRecordLog.m9472a().m9471a("(" + this.f7259c + ") isRuning=false");
            }
            if (this.f7261e % 6 == 0) {
                String str = DevRecordLog.m9472a().m9470b();
                if (!TextUtils.isEmpty(str)) {
                    CommonTools.m7968a(this.f7260d, str);
                }
            }
        }
        if ((this.f7262f & 2) == 2) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    GoloLightManager.m8495c();
                    return;
                }
                String packageName = this.f7257a.getPackageName();
                Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    } else if (it2.next().processName.equalsIgnoreCase(packageName)) {
                        break;
                    }
                }
                if (z2) {
                    return;
                }
                GoloLightManager.m8495c();
            } catch (Exception e) {
                Log.e("Sanda", "DefendTask e:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
