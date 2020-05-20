package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.physics.DeviceFactoryManager;
import com.cnlaunch.physics.p195b.DownloadBinUpdate;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.utils.PathUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseWaitDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.f */
/* loaded from: classes.dex */
public final class HandlerC2190f extends Handler {

    /* renamed from: a */
    final /* synthetic */ DiagnoseWaitDialog f12452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2190f(DiagnoseWaitDialog diagnoseWaitDialog) {
        this.f12452a = diagnoseWaitDialog;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        Context context;
        IFragmentCallback iFragmentCallback;
        IFragmentCallback iFragmentCallback2;
        DownloadBinUpdate downloadBinUpdate;
        String str;
        switch (message2.what) {
            case 3:
            case 4:
                Bundle data = message2.getData();
                String string = data.getString("downloadVersion");
                String string2 = data.getString("deviceVersion");
                String string3 = data.getString("downloadBinPath");
                context = this.f12452a.f12448g;
                DiagnoseWaitDialog.m7062a(context, string, string2, string3);
                this.f12452a.dismiss();
                return;
            case 5:
                iFragmentCallback = this.f12452a.f12446e;
                iFragmentCallback.mo7094a(DiagnoseConstants.DIAGNOSE_LIB_PATH, DiagnoseConstants.DIAGNOSE_LANGUAGE);
                this.f12452a.dismiss();
                return;
            case 6:
                if (!MainActivity.m7895b() && !MainActivity.m7881d()) {
                    iFragmentCallback2 = this.f12452a.f12446e;
                    iFragmentCallback2.mo7085f(2);
                }
                this.f12452a.dismiss();
                return;
            case 7:
                DiagnoseWaitDialog diagnoseWaitDialog = this.f12452a;
                diagnoseWaitDialog.f12445d = new DownloadBinUpdate(diagnoseWaitDialog.f12443a, DeviceFactoryManager.m8305a().f9901a);
                downloadBinUpdate = this.f12452a.f12445d;
                str = this.f12452a.f12444c;
                String m4858c = PathUtils.m4858c();
                if (downloadBinUpdate.f9807c == null) {
                    downloadBinUpdate.f9807c = new DownloadBinUpdate.RunnableC1830a(str, m4858c);
                }
                new Thread(downloadBinUpdate.f9807c).start();
                return;
            default:
                super.handleMessage(message2);
                this.f12452a.dismiss();
                return;
        }
    }
}
