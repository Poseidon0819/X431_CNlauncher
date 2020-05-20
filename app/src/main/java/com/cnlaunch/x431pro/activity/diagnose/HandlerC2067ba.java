package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.physics.DPUDownloadbinVersionManager;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p197c.DPUHardwareInfo;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.diagnose.p223f.DiagnoseWaitDialog;
import com.cnlaunch.x431pro.module.p252d.p254b.C2725h;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.module.report.UpLoadReportTask;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.SerialNoUtils;
import com.cnlaunch.x431pro.utils.p289i.FixedThreadPool;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;
import com.mopub.common.AdType;
import java.util.ArrayList;
import java.util.Timer;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ba */
/* loaded from: classes.dex */
final class HandlerC2067ba extends Handler {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2067ba(DiagnoseActivity diagnoseActivity) {
        this.f11529a = diagnoseActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        C2725h c2725h;
        Timer timer;
        String str;
        DiagnoseActivity.C2011c c2011c;
        DiagnoseActivity.C2011c c2011c2;
        MessageDialog messageDialog;
        MessageDialog messageDialog2;
        Context context;
        DiagnoseWaitDialog diagnoseWaitDialog;
        Context context2;
        Context context3;
        Context context4;
        DiagnoseWaitDialog diagnoseWaitDialog2;
        DiagnoseWaitDialog diagnoseWaitDialog3;
        Context context5;
        Context context6;
        Context context7;
        DiagnoseWaitDialog diagnoseWaitDialog4;
        Context context8;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        int i = message2.what;
        if (i == 12309) {
            NLog.m9452b("XEE", "WEB端远程传输:" + message2.obj.toString());
            DiagnoseActivity diagnoseActivity = this.f11529a;
            String obj = message2.obj.toString();
            if (obj == null) {
                Message obtain = Message.obtain((Handler) null, 99);
                obtain.replyTo = diagnoseActivity.f11026P;
                diagnoseActivity.m7692a(obtain);
                return;
            }
            Message obtain2 = Message.obtain((Handler) null, 99);
            obtain2.replyTo = diagnoseActivity.f11026P;
            Bundle bundle = new Bundle();
            bundle.putString(AdType.STATIC_NATIVE, obj);
            obtain2.setData(bundle);
            diagnoseActivity.m7692a(obtain2);
        } else if (i != 20512) {
            switch (i) {
                case 0:
                    FixedThreadPool m4928a = FixedThreadPool.m4928a();
                    Context applicationContext = this.f11529a.getApplicationContext();
                    DiagnoseRunningInfo mo7083i = this.f11529a.mo7083i();
                    ArrayList<DiagnoseInfo.FuncItem> funcRecord = DiagnoseInfo.getInstance().getFuncRecord();
                    c2725h = this.f11529a.f11105bb;
                    m4928a.m4927a(new UpLoadReportTask(applicationContext, mo7083i, funcRecord, c2725h));
                    return;
                case 1:
                    timer = this.f11529a.f11087ay;
                    if (timer != null) {
                        c2011c = this.f11529a.f11088az;
                        if (c2011c != null) {
                            c2011c2 = this.f11529a.f11088az;
                            c2011c2.cancel();
                        }
                    }
                    if (message2.getData().getBoolean("OUTTIME")) {
                        DiagnoseActivity diagnoseActivity2 = this.f11529a;
                        String string = diagnoseActivity2.getString(R.string.failed_get_diagnose_log_with_timeout);
                        str = this.f11529a.f11038aB;
                        NToast.m9449a(diagnoseActivity2, String.format(string, str));
                    }
                    LoadDialog.m4681b(this.f11529a);
                    return;
                case 2:
                    messageDialog = this.f11529a.f11081as;
                    messageDialog.cancel();
                    messageDialog2 = this.f11529a.f11081as;
                    messageDialog2.dismiss();
                    DiagnoseActivity.m7597y(this.f11529a);
                    this.f11529a.m7598y();
                    this.f11529a.m7632f(true);
                    return;
                case 3:
                    NLog.m9452b("wzx", "DiagnoseActivity.setAutoConnBluetooth();延时结束");
                    this.f11529a.m7622m();
                    return;
                case 4:
                    NLog.m9452b("wzx", "DiagnoseActivity.mBluetoothConnectWaitDialog.getDownloadBinVersion();延时结束");
                    context = this.f11529a.f11019H;
                    PreferencesManager.m9595a(context).m9587a("is_pairing_heavyduty_device", false);
                    diagnoseWaitDialog = this.f11529a.f11078ap;
                    diagnoseWaitDialog.m7064a();
                    return;
                default:
                    switch (i) {
                        case 20501:
                            DiagnoseActivity.m7661ae(this.f11529a);
                            return;
                        case 20502:
                            if (message2.arg1 <= 0) {
                                DiagnoseActivity.m7722B();
                                this.f11529a.mo7088b(DiagnoseConstants.DIAGNOSE_LIB_PATH, DiagnoseConstants.DIAGNOSE_LANGUAGE);
                                return;
                            }
                            DiagnoseConstants.driviceConnStatus = true;
                            context2 = this.f11529a.f11019H;
                            String m9591a = PreferencesManager.m9595a(context2).m9591a("serialNo");
                            String m8382b = DPUDownloadbinVersionManager.m8384a(PathUtils.m4858c()).m8382b(m9591a);
                            context3 = this.f11529a.f11019H;
                            String m7058b = DiagnoseWaitDialog.m7058b(context3, m9591a);
                            DeviceUtils.m8149a();
                            DPUHardwareInfo m8147a = DeviceUtils.m8147a(m9591a, PathUtils.m4858c());
                            if (m8147a != null && m8147a.f9856g != null && m8147a.f9856g.equalsIgnoreCase("123456789abc")) {
                                context7 = this.f11529a.f11019H;
                                if (SerialNoUtils.m4826a(context7, m9591a)) {
                                    diagnoseWaitDialog4 = this.f11529a.f11078ap;
                                    diagnoseWaitDialog4.dismiss();
                                    this.f11529a.mo7085f(2);
                                    return;
                                }
                            }
                            context4 = this.f11529a.f11019H;
                            if (DiagnoseWaitDialog.m7057b(context4, m9591a, m7058b, m8382b)) {
                                diagnoseWaitDialog3 = this.f11529a.f11078ap;
                                diagnoseWaitDialog3.dismiss();
                                context5 = this.f11529a.f11019H;
                                String m7063a = DiagnoseWaitDialog.m7063a(context5, m9591a);
                                context6 = this.f11529a.f11019H;
                                DiagnoseWaitDialog.m7062a(context6, m7058b, m8382b, m7063a);
                                return;
                            }
                            this.f11529a.mo7094a(DiagnoseConstants.DIAGNOSE_LIB_PATH, DiagnoseConstants.DIAGNOSE_LANGUAGE);
                            diagnoseWaitDialog2 = this.f11529a.f11078ap;
                            diagnoseWaitDialog2.dismiss();
                            return;
                        case 20503:
                            DiagnoseActivity.m7714H(this.f11529a);
                            return;
                        case 20504:
                            if (DiagnoseConstants.driviceConnStatus) {
                                DeviceFactoryManager.m8305a();
                                context8 = this.f11529a.f11019H;
                                DeviceFactoryManager.m8279e(context8);
                                return;
                            }
                            return;
                        case 20505:
                            if (message2.arg1 == 1) {
                                if (DiagnoseActivity.m7694a(this.f11529a.getApplicationContext(), "com.cnlaunch.diagnosemodule.service.DiagnoseService")) {
                                    DiagnoseActivity diagnoseActivity3 = this.f11529a;
                                    diagnoseActivity3.f11063aa = 0;
                                    handler3 = diagnoseActivity3.f11103bO;
                                    Message obtainMessage = handler3.obtainMessage(20505, 1, 0);
                                    handler4 = this.f11529a.f11103bO;
                                    handler4.sendMessageDelayed(obtainMessage, 1000L);
                                    return;
                                } else if (this.f11529a.mo7083i().isBinding()) {
                                    this.f11529a.f11063aa++;
                                    if (this.f11529a.f11063aa < 10) {
                                        handler = this.f11529a.f11103bO;
                                        Message obtainMessage2 = handler.obtainMessage(20505, 1, 0);
                                        handler2 = this.f11529a.f11103bO;
                                        handler2.sendMessageDelayed(obtainMessage2, 500L);
                                        return;
                                    }
                                    Intent intent = new Intent(DiagnoseConstants.DIAG_ERROR_BROADCAST);
                                    intent.putExtra("errFromDiagnoseService", "1");
                                    this.f11529a.sendBroadcast(intent);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.f11529a.mo7088b(DiagnoseConstants.DIAGNOSE_LIB_PATH, DiagnoseConstants.DIAGNOSE_LANGUAGE);
        }
    }
}
