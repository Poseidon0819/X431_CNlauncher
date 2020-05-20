package com.cnlaunch.x431pro.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.ifoer.pro.expeditionphone.WelcomeActivity;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class BootUpReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        ComponentName resolveActivity = new Intent(context, MainActivity.class).resolveActivity(context.getPackageManager());
        if (resolveActivity != null) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10)) {
                if (runningTaskInfo.baseActivity.equals(resolveActivity)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return;
        }
        Log.d("pengzhe", "start app.");
        Intent intent2 = new Intent(context, WelcomeActivity.class);
        intent2.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        context.startActivity(intent2);
    }
}
