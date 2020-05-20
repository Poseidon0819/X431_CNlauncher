package com.cnlaunch.x431pro.module.golo.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.newgolo.manager.GoloLightManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.p173d.NoticeMessageHandler;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.bluetooth.DownloadBinActivity;
import com.cnlaunch.x431pro.p210a.CommonTools;
import com.ifoer.expedition.pro.R;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class GoloKeyReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.android.action.golo_press")) {
            if (CommonTools.m7969a(context)) {
                if (DownloadBinActivity.f10909a) {
                    NToast.m9444c(context, (int) R.string.downloadbin_exit_hit);
                    return;
                }
                GoloLightManager.m8495c();
                if (!MainActivity.m7895b()) {
                    Intent intent2 = new Intent(context.getApplicationContext(), MainActivity.class);
                    intent2.putExtra("Setting", "startgolo");
                    intent2.putExtra("Customer_type", intent.getStringExtra("Customer_type"));
                    intent2.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
                    context.startActivity(intent2);
                    return;
                }
                NoticeMessageHandler.m8785a();
                return;
            }
            return;
        }
        intent.getAction().equals("com.android.action.golo_long_press");
    }
}
