package com.cnlaunch.x431pro.activity.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.p210a.C1947h;

/* loaded from: classes.dex */
public class SettingLaunchReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String cls = getClass().toString();
        long currentTimeMillis = System.currentTimeMillis();
        if (intent.getAction().equals("com.cnlaunch.intent.action.SETTINGS")) {
            if (C1947h.f10553e) {
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.setClass(context, MainActivity.class);
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setFlags(335544320);
                intent2.putExtra("Setting", "SettingLaunchReceiver");
                context.startActivity(intent2);
                C1947h.f10553e = false;
            } else {
                context.sendBroadcast(new Intent("show_Setting"));
            }
        }
        Log.e(cls, Long.toString(System.currentTimeMillis() - currentTimeMillis));
    }
}
