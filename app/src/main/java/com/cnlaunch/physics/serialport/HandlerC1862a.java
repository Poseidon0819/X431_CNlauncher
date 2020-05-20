package com.cnlaunch.physics.serialport;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cnlaunch.p117b.C1411a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.p199e.IAssitsPhysicsMatcher;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SerialPortManager.java */
/* renamed from: com.cnlaunch.physics.serialport.a */
/* loaded from: classes.dex */
public final class HandlerC1862a extends Handler {

    /* renamed from: a */
    final /* synthetic */ SerialPortManager f10159a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1862a(SerialPortManager serialPortManager, Looper looper) {
        super(looper);
        this.f10159a = serialPortManager;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        IAssitsPhysicsMatcher iAssitsPhysicsMatcher;
        boolean z;
        Context context;
        IAssitsPhysicsMatcher iAssitsPhysicsMatcher2;
        boolean z2;
        Context context2;
        Context context3;
        Context context4;
        if (message2.what == 0) {
            iAssitsPhysicsMatcher2 = this.f10159a.mAssitsPhysicsMatcher;
            if (iAssitsPhysicsMatcher2 == null) {
                Intent intent = new Intent("DPUDeviceConnectSuccess");
                z2 = this.f10159a.isFix;
                intent.putExtra("isFix", z2);
                context2 = this.f10159a.mContext;
                intent.putExtra(MessageDao.TABLENAME, context2.getString(C1411a.C1412a.msg_serialport_connect_state_success));
                context3 = this.f10159a.mContext;
                context3.sendBroadcast(intent);
                context4 = this.f10159a.mContext;
                context4.sendBroadcast(new Intent("com.cnlaunch.intent.action.DIAG_CONNECTED"));
            }
        } else if (message2.what == 1) {
            iAssitsPhysicsMatcher = this.f10159a.mAssitsPhysicsMatcher;
            if (iAssitsPhysicsMatcher == null) {
                Intent intent2 = new Intent("DPUDeviceConnectDisconnected");
                z = this.f10159a.isFix;
                intent2.putExtra("isFix", z);
                context = this.f10159a.mContext;
                context.sendBroadcast(intent2);
            }
        }
    }
}
