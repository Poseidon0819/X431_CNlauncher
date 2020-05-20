package com.cnlaunch.physics.p203i;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SimulatorManager.java */
/* renamed from: com.cnlaunch.physics.i.e */
/* loaded from: classes.dex */
public final class HandlerC1848e extends Handler {

    /* renamed from: a */
    final /* synthetic */ SimulatorManager f9961a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1848e(SimulatorManager simulatorManager, Looper looper) {
        super(looper);
        this.f9961a = simulatorManager;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        boolean z;
        Context context;
        boolean z2;
        Context context2;
        Context context3;
        Context context4;
        if (message2.what == 0) {
            Intent intent = new Intent("DPUDeviceConnectSuccess");
            z2 = this.f9961a.f9955n;
            intent.putExtra("isFix", z2);
            context2 = this.f9961a.f9952k;
            intent.putExtra(MessageDao.TABLENAME, context2.getString(C1411a.C1412a.msg_simulator_connect_state_success));
            context3 = this.f9961a.f9952k;
            context3.sendBroadcast(intent);
            context4 = this.f9961a.f9952k;
            context4.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_CONNECTED"));
        } else if (message2.what == 1) {
            Intent intent2 = new Intent("DPUDeviceConnectDisconnected");
            z = this.f9961a.f9955n;
            intent2.putExtra("isFix", z);
            context = this.f9961a.f9952k;
            context.sendBroadcast(intent2);
        }
    }
}
