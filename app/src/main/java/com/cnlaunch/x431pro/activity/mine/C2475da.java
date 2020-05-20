package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.physics.p199e.IPhysics;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VehicleVoltageFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.da */
/* loaded from: classes.dex */
public final class C2475da extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ VehicleVoltageFragment f14197a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2475da(VehicleVoltageFragment vehicleVoltageFragment) {
        this.f14197a = vehicleVoltageFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        Timer timer;
        TimerTask timerTask;
        String action = intent.getAction();
        if (action.equals("DPUDeviceConnectSuccess")) {
            if (intent.getBooleanExtra("isFix", false)) {
                ((ActivityC2004c) this.f14197a.getActivity()).m7732g().setTouchModeAbove(2);
                textView = this.f14197a.f14178i;
                textView.setEnabled(false);
                textView2 = this.f14197a.f14175f;
                textView2.setEnabled(true);
                textView3 = this.f14197a.f14177h;
                textView3.setEnabled(true);
                textView4 = this.f14197a.f14176g;
                textView4.setEnabled(true);
                VehicleVoltageFragment.m6155e(this.f14197a);
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                IPhysics iPhysics = DeviceFactoryManager.m8305a().f9901a;
                VehicleVoltageFragment vehicleVoltageFragment = this.f14197a;
                vehicleVoltageFragment.f14180k = new DownloadBinUpdate(vehicleVoltageFragment.f14170a, iPhysics);
                this.f14197a.f14184o = new C2476db(this);
                this.f14197a.f14183n = new Timer();
                timer = this.f14197a.f14183n;
                timerTask = this.f14197a.f14184o;
                timer.schedule(timerTask, 500L, 1000L);
            }
        } else if (action.equals("DPUDeviceConnectFail")) {
            DeviceFactoryManager.m8305a().m8288c();
        }
    }
}
