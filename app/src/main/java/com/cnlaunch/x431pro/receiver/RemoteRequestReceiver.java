package com.cnlaunch.x431pro.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cnlaunch.x431pro.activity.MainActivity;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class RemoteRequestReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i("anqi", "receive remoterequest");
        String action = intent.getAction();
        if (action.equals("sellerRequest_remotediag")) {
            Intent intent2 = new Intent(context, MainActivity.class);
            intent2.putExtras(intent.getExtras());
            intent2.putExtra("seller_request_remote", true);
            intent2.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
            context.startActivity(intent2);
        } else if (action.equals("com.cnlaunch.x431pro.action.goloseller.exit")) {
            Intent intent3 = new Intent(context, MainActivity.class);
            intent3.putExtra("seller_click_menu", true);
            intent3.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
            context.startActivity(intent3);
        }
    }
}
