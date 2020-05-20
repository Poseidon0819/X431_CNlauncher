package com.cnlaunch.x431pro.activity.bluetooth;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.DPUDownloadbinVersionManager;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.physics.p205k.C1856n;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.SerialNoUtils;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DownloadBinActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.i */
/* loaded from: classes.dex */
public final class HandlerC1999i extends Handler {

    /* renamed from: a */
    final /* synthetic */ DownloadBinActivity f10955a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1999i(DownloadBinActivity downloadBinActivity) {
        this.f10955a = downloadBinActivity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        boolean z;
        Context context;
        DownloadBinUpdate downloadBinUpdate;
        DownloadBinUpdate downloadBinUpdate2;
        Context context2;
        TextView textView;
        ProgressDialog progressDialog;
        TextView textView2;
        Button button;
        Button button2;
        TextView textView3;
        DownloadBinUpdate downloadBinUpdate3;
        DownloadBinUpdate downloadBinUpdate4;
        TextView textView4;
        TextView textView5;
        int i;
        Context context3;
        int i2;
        boolean z2;
        TextView textView6;
        TextView textView7;
        int i3;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        String str;
        String str2;
        TextView textView11;
        TextView textView12;
        Button button3;
        Button button4;
        TextView textView13;
        String str3;
        String str4;
        Context context4;
        String str5;
        Context context5;
        String str6;
        String str7;
        TextView textView14;
        float f;
        ProgressBar progressBar;
        float f2;
        Context context6;
        TextView textView15;
        ProgressDialog progressDialog2;
        Context context7;
        TextView textView16;
        ProgressDialog progressDialog3;
        Context context8;
        TextView textView17;
        ProgressDialog progressDialog4;
        int i4 = message2.what;
        if (i4 == -99) {
            z = this.f10955a.f10926q;
            if (z) {
                DownloadBinActivity.m7765k(this.f10955a);
                context = this.f10955a.f10912c;
                NToast.m9444c(context, (int) R.string.download_upgrade_fail);
                downloadBinUpdate = this.f10955a.f10921l;
                if (downloadBinUpdate != null) {
                    downloadBinUpdate2 = this.f10955a.f10921l;
                    downloadBinUpdate2.f9809e = true;
                }
                new C2000j(this).start();
                return;
            }
        } else {
            if (i4 != 1 && i4 != 4) {
                if (i4 == 20) {
                    z2 = this.f10955a.f10932w;
                    if (z2) {
                        textView6 = this.f10955a.f10918i;
                        if (textView6.getVisibility() == 0) {
                            textView9 = this.f10955a.f10918i;
                            textView9.setVisibility(8);
                        } else {
                            textView7 = this.f10955a.f10918i;
                            textView7.setVisibility(0);
                        }
                        DownloadBinActivity.m7752x(this.f10955a);
                        i3 = this.f10955a.f10933x;
                        if (i3 == 3) {
                            textView8 = this.f10955a.f10918i;
                            textView8.setVisibility(8);
                            DownloadBinActivity.m7750z(this.f10955a);
                            DownloadBinActivity.m7786A(this.f10955a);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i4 != 4096) {
                    switch (i4) {
                        case 6:
                            break;
                        case 7:
                            textView11 = this.f10955a.f10914e;
                            textView11.setText(R.string.downloadbin_upgrade_success_hit);
                            textView12 = this.f10955a.f10915f;
                            textView12.setVisibility(8);
                            button3 = this.f10955a.f10920k;
                            button3.setText(R.string.confirm);
                            button4 = this.f10955a.f10920k;
                            button4.setEnabled(true);
                            this.f10955a.f10927r = true;
                            DownloadBinActivity.m7765k(this.f10955a);
                            textView13 = this.f10955a.f10917h;
                            textView13.setVisibility(8);
                            DPUDownloadbinVersionManager m8384a = DPUDownloadbinVersionManager.m8384a(PathUtils.m4858c());
                            str3 = this.f10955a.f10931v;
                            str4 = this.f10955a.f10923n;
                            m8384a.m8383a(str3, str4);
                            context4 = this.f10955a.f10912c;
                            str5 = this.f10955a.f10931v;
                            boolean m4826a = SerialNoUtils.m4826a(context4, str5);
                            if (m4826a) {
                                if (C1856n.f10135a) {
                                    StringBuilder sb = new StringBuilder("SerialNoUtils.isInBlackList updateSerialNoForbidden currentSerialNo=");
                                    str7 = this.f10955a.f10931v;
                                    sb.append(str7);
                                    sb.append(" state=");
                                    sb.append(m4826a);
                                    C1856n.m8130a("DownloadBinActivity", sb.toString());
                                }
                                context5 = this.f10955a.f10912c;
                                str6 = this.f10955a.f10931v;
                                SerialNoUtils.m4823c(context5, str6);
                                return;
                            }
                            return;
                        case 8:
                            textView14 = this.f10955a.f10916g;
                            StringBuilder sb2 = new StringBuilder();
                            f = this.f10955a.f10922m;
                            sb2.append(f);
                            sb2.append("%");
                            textView14.setText(sb2.toString());
                            progressBar = this.f10955a.f10919j;
                            f2 = this.f10955a.f10922m;
                            progressBar.setProgress((int) f2);
                            return;
                        default:
                            switch (i4) {
                                case 11:
                                    break;
                                case 12:
                                    context6 = this.f10955a.f10912c;
                                    NToast.m9450a(context6, (int) R.string.download_upgrade_send_update_fail);
                                    DownloadBinActivity.m7765k(this.f10955a);
                                    textView15 = this.f10955a.f10917h;
                                    textView15.setVisibility(8);
                                    this.f10955a.m7783a();
                                    progressDialog2 = this.f10955a.f10930u;
                                    progressDialog2.dismiss();
                                    this.f10955a.m7772e();
                                    return;
                                case 13:
                                    context7 = this.f10955a.f10912c;
                                    NToast.m9450a(context7, (int) R.string.download_upgrade_set_baudrate_fail);
                                    DownloadBinActivity.m7765k(this.f10955a);
                                    textView16 = this.f10955a.f10917h;
                                    textView16.setVisibility(8);
                                    this.f10955a.m7783a();
                                    progressDialog3 = this.f10955a.f10930u;
                                    progressDialog3.dismiss();
                                    this.f10955a.m7772e();
                                    return;
                                case 14:
                                    context8 = this.f10955a.f10912c;
                                    NToast.m9450a(context8, (int) R.string.download_upgrade_set_address_and_size_fail);
                                    DownloadBinActivity.m7765k(this.f10955a);
                                    textView17 = this.f10955a.f10917h;
                                    textView17.setVisibility(8);
                                    this.f10955a.m7783a();
                                    progressDialog4 = this.f10955a.f10930u;
                                    progressDialog4.dismiss();
                                    this.f10955a.m7772e();
                                    return;
                                case 15:
                                case 16:
                                    break;
                                default:
                                    return;
                            }
                    }
                } else {
                    textView10 = this.f10955a.f10917h;
                    StringBuilder sb3 = new StringBuilder();
                    str = this.f10955a.f10929t;
                    sb3.append(str);
                    sb3.append(this.f10955a.getString(R.string.downloadbin_exit_hit));
                    str2 = this.f10955a.f10929t;
                    sb3.append(str2);
                    textView10.setText(sb3.toString());
                    return;
                }
            }
            if (C1856n.f10135a) {
                StringBuilder sb4 = new StringBuilder("msg.what=");
                sb4.append(message2.what);
                sb4.append(" mLinkMode =");
                i2 = this.f10955a.f10934y;
                sb4.append(i2);
                C1856n.m8130a("DownloadBinActivity", sb4.toString());
            }
            if (message2.what == 1) {
                i = this.f10955a.f10934y;
                if (i == 3) {
                    DownloadBinActivity.m7765k(this.f10955a);
                    DeviceFactoryManager.m8305a().m8288c();
                    DeviceFactoryManager.m8305a().f9907g = 3;
                    DeviceFactoryManager m8305a = DeviceFactoryManager.m8305a();
                    context3 = this.f10955a.f10912c;
                    m8305a.m8301a(context3, true, (String) null);
                    return;
                }
            }
            if (message2.what == 6 || message2.what == 1 || message2.what == 4) {
                textView2 = this.f10955a.f10914e;
                textView2.setText(R.string.download_upgrade_fail);
            } else if (message2.what == 15) {
                textView5 = this.f10955a.f10914e;
                textView5.setText(R.string.mine_file_not_exist);
            } else if (message2.what == 16) {
                textView4 = this.f10955a.f10914e;
                textView4.setText(R.string.downloadbin_file_not_support_truck_with_usb_mode_message);
            }
            DownloadBinActivity.m7765k(this.f10955a);
            this.f10955a.f10927r = false;
            button = this.f10955a.f10920k;
            button.setText(R.string.confirm);
            button2 = this.f10955a.f10920k;
            button2.setEnabled(true);
            textView3 = this.f10955a.f10917h;
            textView3.setVisibility(8);
            downloadBinUpdate3 = this.f10955a.f10921l;
            if (downloadBinUpdate3 != null) {
                downloadBinUpdate4 = this.f10955a.f10921l;
                downloadBinUpdate4.f9809e = true;
                return;
            }
            return;
        }
        context2 = this.f10955a.f10912c;
        NToast.m9447b(context2, (int) R.string.download_upgrade_reset_dpu_fail);
        DownloadBinActivity.m7765k(this.f10955a);
        textView = this.f10955a.f10917h;
        textView.setVisibility(8);
        this.f10955a.m7783a();
        progressDialog = this.f10955a.f10930u;
        progressDialog.dismiss();
        this.f10955a.m7772e();
    }
}
