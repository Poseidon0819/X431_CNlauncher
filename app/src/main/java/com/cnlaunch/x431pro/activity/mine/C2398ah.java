package com.cnlaunch.x431pro.activity.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;

/* compiled from: FirmwareFixFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ah */
/* loaded from: classes.dex */
final class C2398ah extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ FirmwareFixFragment f13648a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2398ah(FirmwareFixFragment firmwareFixFragment) {
        this.f13648a = firmwareFixFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        WaitDialog waitDialog;
        Context context2;
        WaitDialog waitDialog2;
        WaitDialog waitDialog3;
        boolean z;
        Button button;
        TextView textView;
        boolean z2;
        WaitDialog waitDialog4;
        String action = intent.getAction();
        if (action.equals("DPUDeviceConnectSuccess")) {
            waitDialog3 = this.f13648a.f13642p;
            if (waitDialog3 != null) {
                waitDialog4 = this.f13648a.f13642p;
                waitDialog4.dismiss();
                FirmwareFixFragment.m6467v(this.f13648a);
            }
            if (C1856n.f10135a) {
                StringBuilder sb = new StringBuilder("isUpdateSuccess=");
                z2 = this.f13648a.f13638l;
                sb.append(z2);
                sb.append(" IS_DOWNLOAD_BIN_FIX=");
                sb.append(intent.getBooleanExtra("isFix", false));
                sb.append(" FirmwareFixSubMode =");
                sb.append(DeviceFactoryManager.m8305a().f9907g);
                C1856n.m8130a("FirmwareFixFragment", sb.toString());
            }
            z = this.f13648a.f13638l;
            if (!z && intent.getBooleanExtra("isFix", false) && DeviceFactoryManager.m8305a().f9907g == 1) {
                ((ActivityC2004c) this.f13648a.getActivity()).m7732g().setTouchModeAbove(2);
                this.f13648a.f13643q = DeviceFactoryManager.m8305a().f9903c;
                FirmwareFixFragment.m6465x(this.f13648a);
                button = this.f13648a.f13629c;
                button.setEnabled(false);
                textView = this.f13648a.btn_left;
                textView.setEnabled(false);
            }
        } else if (action.equals("DPUDeviceConnectFail")) {
            waitDialog = this.f13648a.f13642p;
            if (waitDialog != null) {
                waitDialog2 = this.f13648a.f13642p;
                waitDialog2.dismiss();
                FirmwareFixFragment.m6467v(this.f13648a);
            }
            if (intent.getBooleanExtra("isFix", false) && DeviceFactoryManager.m8305a().f9907g == 1) {
                context2 = this.f13648a.mContext;
                NToast.m9449a(context2, intent.getStringExtra(MessageDao.TABLENAME));
                DeviceFactoryManager.m8305a().m8288c();
            }
        }
    }
}
