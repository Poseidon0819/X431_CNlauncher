package com.cnlaunch.x431pro.activity.diagnose.p223f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.physics.DPUDownloadbinVersionManager;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.utils.PathUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseWaitDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f.e */
/* loaded from: classes.dex */
public final class C2189e implements OnDownloadBinListener {

    /* renamed from: a */
    final /* synthetic */ DiagnoseWaitDialog f12451a;

    @Override // com.cnlaunch.physics.p201g.OnDownloadBinListener
    /* renamed from: a */
    public final void mo6135a(int i, long j, long j2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2189e(DiagnoseWaitDialog diagnoseWaitDialog) {
        this.f12451a = diagnoseWaitDialog;
    }

    @Override // com.cnlaunch.physics.p201g.OnDownloadBinListener
    /* renamed from: a */
    public final void mo6134a(int i, String str) {
        IFragmentCallback iFragmentCallback;
        String str2;
        Context context;
        String str3;
        Context context2;
        String str4;
        Context context3;
        String str5;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (i == 10) {
            handler4 = this.f12451a.f12449h;
            handler4.obtainMessage(6).sendToTarget();
            return;
        }
        iFragmentCallback = this.f12451a.f12446e;
        iFragmentCallback.mo7083i().setBinVersion(str);
        DPUDownloadbinVersionManager m8384a = DPUDownloadbinVersionManager.m8384a(PathUtils.m4858c());
        str2 = this.f12451a.f12444c;
        m8384a.m8383a(str2, str);
        context = this.f12451a.f12448g;
        str3 = this.f12451a.f12444c;
        String m7058b = DiagnoseWaitDialog.m7058b(context, str3);
        context2 = this.f12451a.f12448g;
        str4 = this.f12451a.f12444c;
        String m7063a = DiagnoseWaitDialog.m7063a(context2, str4);
        context3 = this.f12451a.f12448g;
        str5 = this.f12451a.f12444c;
        if (DiagnoseWaitDialog.m7057b(context3, str5, m7058b, str)) {
            handler2 = this.f12451a.f12449h;
            Message obtainMessage = handler2.obtainMessage(4);
            Bundle bundle = new Bundle();
            bundle.putString("downloadVersion", m7058b);
            bundle.putString("deviceVersion", str);
            bundle.putString("downloadBinPath", m7063a);
            obtainMessage.setData(bundle);
            handler3 = this.f12451a.f12449h;
            handler3.sendMessage(obtainMessage);
            return;
        }
        handler = this.f12451a.f12449h;
        handler.obtainMessage(5).sendToTarget();
    }
}
