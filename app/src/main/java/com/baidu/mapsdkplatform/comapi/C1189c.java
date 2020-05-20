package com.baidu.mapsdkplatform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.C1304e;

/* renamed from: com.baidu.mapsdkplatform.comapi.c */
/* loaded from: classes.dex */
public class C1189c extends BroadcastReceiver {

    /* renamed from: a */
    public static final String f5880a = "c";

    /* renamed from: a */
    public void m10822a(Context context) {
        String currentNetMode = NetworkUtil.getCurrentNetMode(context);
        String m10065e = C1304e.m10065e();
        if (m10065e == null || m10065e.equals(currentNetMode)) {
            return;
        }
        C1304e.m10073a(currentNetMode);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m10822a(context);
        NetworkUtil.updateNetworkProxy(context);
    }
}
