package com.cnlaunch.x431pro.activity.bluetooth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.physics.p205k.C1856n;

/* compiled from: DownloadBinActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.l */
/* loaded from: classes.dex */
final class C2002l extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DownloadBinActivity f10958a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2002l(DownloadBinActivity downloadBinActivity) {
        this.f10958a = downloadBinActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context context2;
        Handler handler;
        boolean z;
        String action = intent.getAction();
        if (action.equals("DPUDeviceConnectSuccess")) {
            if (C1856n.f10135a) {
                StringBuilder sb = new StringBuilder("isUpdateSuccess=");
                z = this.f10958a.f10927r;
                sb.append(z);
                sb.append(" IS_DOWNLOAD_BIN_FIX=");
                sb.append(intent.getBooleanExtra("isFix", false));
                sb.append(" FirmwareFixSubMode =");
                sb.append(DeviceFactoryManager.m8305a().f9907g);
                C1856n.m8130a("DownloadBinActivity", sb.toString());
            }
            if (intent.getBooleanExtra("isFix", false) && DeviceFactoryManager.m8305a().f9907g == 3) {
                DiagnoseConstants.driviceConnStatus = true;
                DeviceFactoryManager.m8305a().f9907g = 0;
                IPhysics iPhysics = DeviceFactoryManager.m8305a().f9901a;
                if (iPhysics != null) {
                    iPhysics.setIsFix(false);
                }
                this.f10958a.m7778b();
            }
        } else if (action.equals("DPUDeviceConnectFail") && intent.getBooleanExtra("isFix", false) && DeviceFactoryManager.m8305a().f9907g == 3) {
            context2 = this.f10958a.f10912c;
            NToast.m9449a(context2, intent.getStringExtra(MessageDao.TABLENAME));
            DeviceFactoryManager.m8305a().f9907g = 0;
            DeviceFactoryManager.m8305a().m8288c();
            DiagnoseConstants.driviceConnStatus = false;
            handler = this.f10958a.f10935z;
            handler.sendEmptyMessage(6);
        }
    }
}
