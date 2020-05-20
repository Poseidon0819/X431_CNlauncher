package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FirmwareFixFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.af */
/* loaded from: classes.dex */
public final class HandlerC2396af extends Handler {

    /* renamed from: a */
    final /* synthetic */ FirmwareFixFragment f13646a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2396af(FirmwareFixFragment firmwareFixFragment) {
        this.f13646a = firmwareFixFragment;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Context context;
        ProgressBar progressBar;
        boolean z;
        DownloadBinUpdate downloadBinUpdate;
        TextView textView;
        TextView textView2;
        Button button;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        Button button2;
        TextView textView6;
        TextView textView7;
        TextView textView8;
        Button button3;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        int i;
        boolean z2;
        boolean z3;
        TextView textView12;
        String str;
        String str2;
        TextView textView13;
        TextView textView14;
        TextView textView15;
        TextView textView16;
        TextView textView17;
        TextView textView18;
        TextView textView19;
        TextView textView20;
        TextView textView21;
        float f;
        ProgressBar progressBar2;
        float f2;
        try {
            int i2 = message2.what;
            if (i2 == -99) {
                context = this.f13646a.mContext;
                NToast.m9444c(context, (int) R.string.download_upgrade_fail);
                ((ActivityC2004c) this.f13646a.getActivity()).m7732g().setTouchModeAbove(1);
                progressBar = this.f13646a.f13631e;
                progressBar.setProgress(0);
                z = this.f13646a.f13637k;
                if (z) {
                    FirmwareFixFragment.m6487b(this.f13646a);
                    downloadBinUpdate = this.f13646a.f13635i;
                    downloadBinUpdate.f9809e = true;
                    new C2397ag(this).start();
                    textView = this.f13646a.f13632f;
                    textView.setVisibility(0);
                    textView2 = this.f13646a.f13632f;
                    textView2.setText(R.string.download_upgrade_fail);
                    button = this.f13646a.f13629c;
                    button.setEnabled(true);
                    textView3 = this.f13646a.btn_left;
                    textView3.setEnabled(true);
                    MineActivity.f13541n = false;
                    DiagnoseConstants.driviceConnStatus = false;
                    DeviceFactoryManager.m8305a().m8293b();
                    DeviceFactoryManager.m8305a().m8288c();
                    this.f13646a.f13639m = true;
                    return;
                }
            } else {
                if (i2 != 1 && i2 != 4) {
                    if (i2 != 11) {
                        if (i2 == 4096) {
                            z2 = this.f13646a.f13639m;
                            if (z2) {
                                textView16 = this.f13646a.f13632f;
                                textView16.setVisibility(0);
                                textView17 = this.f13646a.f13632f;
                                textView17.setText(R.string.download_upgrade_fail);
                                return;
                            }
                            z3 = this.f13646a.f13640n;
                            if (z3) {
                                textView14 = this.f13646a.f13632f;
                                textView14.setText(R.string.downloadbin_upgrade_success_hit);
                                textView15 = this.f13646a.f13632f;
                                textView15.setVisibility(0);
                                return;
                            }
                            textView12 = this.f13646a.f13632f;
                            StringBuilder sb = new StringBuilder();
                            str = this.f13646a.f13634h;
                            sb.append(str);
                            sb.append(this.f13646a.getString(R.string.downloadbin_exit_hit));
                            str2 = this.f13646a.f13634h;
                            sb.append(str2);
                            textView12.setText(sb.toString());
                            textView13 = this.f13646a.f13632f;
                            textView13.setVisibility(0);
                            return;
                        }
                        switch (i2) {
                            case 6:
                                break;
                            case 7:
                                ((ActivityC2004c) this.f13646a.getActivity()).m7732g().setTouchModeAbove(1);
                                textView18 = this.f13646a.f13632f;
                                textView18.setVisibility(0);
                                textView19 = this.f13646a.f13632f;
                                textView19.setText(R.string.downloadbin_upgrade_success_hit);
                                FirmwareFixFragment.m6487b(this.f13646a);
                                FirmwareFixFragment.m6486c(this.f13646a);
                                textView20 = this.f13646a.btn_left;
                                textView20.setEnabled(true);
                                MineActivity.f13541n = false;
                                DiagnoseConstants.driviceConnStatus = false;
                                DeviceFactoryManager.m8305a().m8293b();
                                DeviceFactoryManager.m8305a().m8288c();
                                this.f13646a.f13639m = false;
                                FirmwareFixFragment.m6484e(this.f13646a);
                                return;
                            case 8:
                                textView21 = this.f13646a.f13630d;
                                StringBuilder sb2 = new StringBuilder();
                                f = this.f13646a.f13633g;
                                sb2.append(f);
                                sb2.append("%");
                                textView21.setText(sb2.toString());
                                progressBar2 = this.f13646a.f13631e;
                                f2 = this.f13646a.f13633g;
                                progressBar2.setProgress((int) f2);
                                return;
                            default:
                                switch (i2) {
                                    case 15:
                                    case 16:
                                        break;
                                    default:
                                        return;
                                }
                        }
                    }
                }
                if (message2.what == 1) {
                    i = this.f13646a.f13643q;
                    if (i == 3) {
                        this.f13646a.m6493a();
                        return;
                    }
                }
                ((ActivityC2004c) this.f13646a.getActivity()).m7732g().setTouchModeAbove(1);
                textView7 = this.f13646a.f13632f;
                textView7.setVisibility(0);
                if (message2.what != 6 && message2.what != 1 && message2.what != 4) {
                    if (message2.what == 15) {
                        textView11 = this.f13646a.f13632f;
                        textView11.setText(R.string.mine_file_not_exist);
                    } else if (message2.what == 16) {
                        textView10 = this.f13646a.f13632f;
                        textView10.setText(R.string.downloadbin_file_not_support_truck_with_usb_mode_message);
                    }
                    FirmwareFixFragment.m6487b(this.f13646a);
                    button3 = this.f13646a.f13629c;
                    button3.setEnabled(true);
                    textView9 = this.f13646a.btn_left;
                    textView9.setEnabled(true);
                    MineActivity.f13541n = false;
                    DiagnoseConstants.driviceConnStatus = false;
                    DeviceFactoryManager.m8305a().m8293b();
                    DeviceFactoryManager.m8305a().m8288c();
                    this.f13646a.f13639m = true;
                    return;
                }
                textView8 = this.f13646a.f13632f;
                textView8.setText(R.string.download_upgrade_fail);
                FirmwareFixFragment.m6487b(this.f13646a);
                button3 = this.f13646a.f13629c;
                button3.setEnabled(true);
                textView9 = this.f13646a.btn_left;
                textView9.setEnabled(true);
                MineActivity.f13541n = false;
                DiagnoseConstants.driviceConnStatus = false;
                DeviceFactoryManager.m8305a().m8293b();
                DeviceFactoryManager.m8305a().m8288c();
                this.f13646a.f13639m = true;
                return;
            }
            ((ActivityC2004c) this.f13646a.getActivity()).m7732g().setTouchModeAbove(1);
            textView4 = this.f13646a.f13632f;
            textView4.setVisibility(0);
            textView5 = this.f13646a.f13632f;
            textView5.setText(R.string.download_upgrade_reset_connector_fail);
            FirmwareFixFragment.m6487b(this.f13646a);
            button2 = this.f13646a.f13629c;
            button2.setEnabled(true);
            textView6 = this.f13646a.btn_left;
            textView6.setEnabled(true);
            MineActivity.f13541n = false;
            DiagnoseConstants.driviceConnStatus = false;
            DeviceFactoryManager.m8305a().m8293b();
            DeviceFactoryManager.m8305a().m8288c();
            this.f13646a.f13639m = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
