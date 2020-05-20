package com.cnlaunch.physics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.p205k.C1856n;
import com.unionpay.tsmservice.data.Constant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PAD3DHCPForDoIP.java */
/* renamed from: com.cnlaunch.physics.m */
/* loaded from: classes.dex */
public final class C1858m extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ PAD3DHCPForDoIP f10145a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1858m(PAD3DHCPForDoIP pAD3DHCPForDoIP) {
        this.f10145a = pAD3DHCPForDoIP;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context unused;
        Context unused2;
        Context unused3;
        String action = intent.getAction();
        if (C1856n.f10135a) {
            C1856n.m8130a(PAD3DHCPForDoIP.f10141a, "mBroadcastReceiver action=".concat(String.valueOf(action)));
        }
        if (action.equals("com.bsk.broadcast.eth.start.service.status")) {
            String stringExtra = intent.getStringExtra("startEthStatus");
            if (C1856n.f10135a) {
                C1856n.m8130a(PAD3DHCPForDoIP.f10141a, String.format("pad3DHCPBroadcastReceiver action=%s,parameter=%s ,vlaue=%s", action, "startEthStatus", stringExtra));
            }
            if (stringExtra == null) {
                return;
            }
            if (stringExtra.equalsIgnoreCase(Constant.CASH_LOAD_SUCCESS)) {
                context9 = this.f10145a.f10142b;
                if (context9 != null) {
                }
            } else if (stringExtra.equalsIgnoreCase("fail")) {
                unused = this.f10145a.f10142b;
            }
        } else if (action.equals("com.bsk.broadcast.eth.stop.service.status")) {
            String stringExtra2 = intent.getStringExtra("stopEthStatus");
            if (C1856n.f10135a) {
                C1856n.m8130a(PAD3DHCPForDoIP.f10141a, String.format("pad3DHCPBroadcastReceiver action=%s,parameter=%s ,vlaue=%s", action, "stopEthStatus", stringExtra2));
            }
            if (stringExtra2 == null) {
                return;
            }
            if (stringExtra2.equalsIgnoreCase(Constant.CASH_LOAD_SUCCESS)) {
                context8 = this.f10145a.f10142b;
                if (context8 != null) {
                }
            } else if (stringExtra2.equalsIgnoreCase("fail")) {
                unused2 = this.f10145a.f10142b;
            }
        } else if (action.equals("com.bsk.broadcast.eth.cable.status")) {
            String stringExtra3 = intent.getStringExtra("cableStatus");
            if (C1856n.f10135a) {
                C1856n.m8130a(PAD3DHCPForDoIP.f10141a, String.format("pad3DHCPBroadcastReceiver action=%s,parameter=%s ,vlaue=%s", action, "com.bsk.broadcast.eth.cable.status", stringExtra3));
            }
            if (stringExtra3 == null) {
                return;
            }
            if (stringExtra3.equalsIgnoreCase("linkup")) {
                context7 = this.f10145a.f10142b;
                if (context7 != null) {
                }
            } else if (stringExtra3.equalsIgnoreCase("down")) {
                unused3 = this.f10145a.f10142b;
            }
        } else if (action.equals("com.bsk.broadcast.eth.service.ip")) {
            String stringExtra4 = intent.getStringExtra("ethServiceIP");
            if (C1856n.f10135a) {
                C1856n.m8130a(PAD3DHCPForDoIP.f10141a, String.format("pad3DHCPBroadcastReceiver action=%s,parameter=%s ,vlaue=%s", action, "ethServiceIP", stringExtra4));
            }
            if (stringExtra4 == null) {
                return;
            }
            context2 = this.f10145a.f10142b;
            if (context2 != null) {
                if (TextUtils.isEmpty(stringExtra4)) {
                    context5 = this.f10145a.f10142b;
                    context6 = this.f10145a.f10142b;
                    NToast.m9449a(context5, context6.getString(C1411a.C1412a.msg_dhcp_service_ip_allocation_status_fail));
                    return;
                }
                context3 = this.f10145a.f10142b;
                context4 = this.f10145a.f10142b;
                NToast.m9449a(context3, String.format(context4.getString(C1411a.C1412a.msg_dhcp_service_ip_allocation_status_success), stringExtra4));
            }
        }
    }
}
