package com.cnlaunch.x431pro.activity.upgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.ifoer.expedition.pro.R;
import com.thoughtworks.xstream.XStream;
import com.unionpay.tsmservice.data.Constant;

/* compiled from: DownloadFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.t */
/* loaded from: classes.dex */
final class C2698t extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DownloadFragment f15425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2698t(DownloadFragment downloadFragment) {
        this.f15425a = downloadFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f15425a.f15384e = intent.getIntExtra("returnCode", -1);
        this.f15425a.f15381b = intent.getStringExtra("packageName");
        DownloadFragment downloadFragment = this.f15425a;
        downloadFragment.f15382c = downloadFragment.f15383d.get(this.f15425a.f15381b);
        NLog.m9452b("wzx", "DownlaodFragment.BroadcastReceiver.onReceive().returnCode =" + this.f15425a.f15384e);
        NLog.m9452b("wzx", "DownlaodFragment.BroadcastReceiver.onReceive().packageName =" + this.f15425a.f15381b);
        if (this.f15425a.f15382c == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26 && this.f15425a.f15384e == 0) {
            this.f15425a.f15384e = 1;
        }
        for (DownloadSoftDto downloadSoftDto : this.f15425a.f15352D) {
            if (downloadSoftDto.f15577c == 1 && this.f15425a.f15382c.equals(downloadSoftDto.f15575a)) {
                NLog.m9452b("wzx", "DownlaodFragment.BroadcastReceiver.onReceive().softName =" + this.f15425a.f15382c);
                if (this.f15425a.f15384e == 1) {
                    this.f15425a.m5548a(downloadSoftDto);
                } else {
                    downloadSoftDto.f15579e = 5;
                    this.f15425a.m5485f();
                }
                this.f15425a.f15403x.sendMessage(this.f15425a.f15403x.obtainMessage(9, 0, 0));
                int i = this.f15425a.f15384e;
                if (i == 1) {
                    DownloadFragment.m5554a(this.f15425a, R.string.install_succeeded, 0);
                } else {
                    switch (i) {
                        case -115:
                        case -114:
                        case -113:
                        case -112:
                        case -111:
                        case -110:
                        case -109:
                        case -108:
                        case -107:
                        case -106:
                        case -105:
                        case -104:
                        case -103:
                        case -102:
                        case -101:
                        case -100:
                            DownloadFragment.m5554a(this.f15425a, R.string.install_failed, 2);
                            break;
                        default:
                            switch (i) {
                                case -26:
                                case -25:
                                case -24:
                                case -23:
                                case -22:
                                case -21:
                                case XStream.PRIORITY_VERY_LOW /* -20 */:
                                case -19:
                                case -18:
                                case -17:
                                case -16:
                                case -15:
                                case -14:
                                case -13:
                                case -12:
                                case LBSAuthManager.CODE_NETWORK_FAILED /* -11 */:
                                case -10:
                                case Constant.ERROR_JAR_TOO_LOW /* -9 */:
                                case -8:
                                    DownloadFragment.m5554a(this.f15425a, R.string.install_failed, 2);
                                    break;
                                case -7:
                                    DownloadFragment.m5554a(this.f15425a, R.string.install_failed_update_incompatible, 1);
                                    break;
                                case -6:
                                    DownloadFragment.m5554a(this.f15425a, R.string.install_failed_no_shared_user, 1);
                                    break;
                                case -5:
                                    DownloadFragment.m5554a(this.f15425a, R.string.install_failed_duplicate_package, 1);
                                    break;
                                case -4:
                                    DownloadFragment.m5554a(this.f15425a, R.string.install_failed_insufficient_storage, 1);
                                    break;
                                case -3:
                                    DownloadFragment.m5554a(this.f15425a, R.string.install_failed_invalid_uri, 1);
                                    break;
                                case -2:
                                    DownloadFragment.m5554a(this.f15425a, R.string.install_failed_invalid_apk, 1);
                                    break;
                                case -1:
                                    DownloadFragment.m5554a(this.f15425a, R.string.install_failed_already_exists, 1);
                                    break;
                                default:
                                    DownloadFragment.m5554a(this.f15425a, R.string.install_failed, 2);
                                    break;
                            }
                    }
                }
            }
        }
    }
}
