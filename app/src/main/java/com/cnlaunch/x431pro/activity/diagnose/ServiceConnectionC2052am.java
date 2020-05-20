package com.cnlaunch.x431pro.activity.diagnose;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.cnlaunch.diagnosemodule.DiagnoseUIDataBusiness;
import com.cnlaunch.diagnosemodule.listener.OnDiagnoseDataListener;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteDiagRunningInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.am */
/* loaded from: classes.dex */
public final class ServiceConnectionC2052am implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ int f11504a;

    /* renamed from: b */
    final /* synthetic */ DiagnoseActivity f11505b;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC2052am(DiagnoseActivity diagnoseActivity, int i) {
        this.f11505b = diagnoseActivity;
        this.f11504a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Messenger messenger;
        Messenger messenger2;
        DiagnoseUIDataBusiness diagnoseUIDataBusiness;
        OnDiagnoseDataListener onDiagnoseDataListener;
        Context context;
        RemoteDiagRunningInfo remoteDiagRunningInfo;
        RemoteDiagRunningInfo remoteDiagRunningInfo2;
        RemoteDiagRunningInfo remoteDiagRunningInfo3;
        RemoteDiagRunningInfo remoteDiagRunningInfo4;
        this.f11505b.f11067ae = new Messenger(iBinder);
        Message obtain = Message.obtain((Handler) null, 0);
        messenger = this.f11505b.f11026P;
        obtain.replyTo = messenger;
        this.f11505b.m7692a(obtain);
        DiagnoseActivity diagnoseActivity = this.f11505b;
        messenger2 = diagnoseActivity.f11067ae;
        diagnoseActivity.f11070ah = new DiagnoseUIDataBusiness(diagnoseActivity, messenger2);
        diagnoseUIDataBusiness = this.f11505b.f11070ah;
        onDiagnoseDataListener = this.f11505b.f11113bj;
        diagnoseUIDataBusiness.setCallbackListener(onDiagnoseDataListener);
        this.f11505b.mo7083i().setBinding(true);
        MainActivity.m7896a(true);
        if (this.f11504a == 0) {
            DiagnoseActivity.m7678a(this.f11505b, DiagnoseConstants.DIAGNOSE_LIB_PATH, DiagnoseConstants.DIAGNOSE_LANGUAGE);
            return;
        }
        try {
            Message obtain2 = Message.obtain((Handler) null, 8);
            int diagnoseStatue = this.f11505b.mo7083i().getDiagnoseStatue();
            context = this.f11505b.f11019H;
            String m9591a = PreferencesManager.m9595a(context).m9591a("token");
            Bundle bundle = new Bundle();
            remoteDiagRunningInfo = this.f11505b.f11130n;
            bundle.putString("ip", remoteDiagRunningInfo.getService_ip());
            remoteDiagRunningInfo2 = this.f11505b.f11130n;
            bundle.putInt("port", remoteDiagRunningInfo2.getService_port());
            remoteDiagRunningInfo3 = this.f11505b.f11130n;
            bundle.putString("info", remoteDiagRunningInfo3.getUserInfo(diagnoseStatue, this.f11505b.mo7083i().getAppVersion(), "6021", m9591a));
            bundle.putInt("identify", diagnoseStatue);
            obtain2.setData(bundle);
            remoteDiagRunningInfo4 = this.f11505b.f11130n;
            if (remoteDiagRunningInfo4 == null) {
                return;
            }
            this.f11505b.m7692a(obtain2);
        } catch (NullPointerException unused) {
            NLog.m9451c("Sanda", "Error(RemoteDiag):NullPoiterException in Launching!");
        }
    }
}
