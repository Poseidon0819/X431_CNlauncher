package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.x431pro.activity.diagnose.p223f.RemoteDiagHandler;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ar */
/* loaded from: classes.dex */
final class HandlerC2057ar extends RemoteDiagHandler {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11511a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2057ar(DiagnoseActivity diagnoseActivity, Context context) {
        super(context);
        this.f11511a = diagnoseActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0070, code lost:
        r8 = com.cnlaunch.p181j.DealDiagMessageHandler.m8673a();
        r0 = r7.f11511a.f11130n;
        r0 = r0.getService_ip();
        r1 = r7.f11511a.f11130n;
        r1 = r1.getService_port();
        r3 = r7.f11511a.f11130n;
        r3 = r3.getService_domain();
        r4 = new com.cnlaunch.p181j.ExplainResult(r8.f9430f.m8685a(), 0);
        r4.f9479ip = r0;
        r4.port = java.lang.String.valueOf(r1);
        r4.domain = r3;
        r4.f9478id = r8.f9430f.f9419c;
        r8.m8669a(r4.f9478id, com.ifoer.expedition.pro.R.string.remote_diag_start, r4.toJsonString(com.cnlaunch.p181j.ExplainResult.START));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00bb, code lost:
        return;
     */
    @Override // com.cnlaunch.x431pro.activity.diagnose.p223f.RemoteDiagHandler
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo7050a(int r8) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.HandlerC2057ar.mo7050a(int):void");
    }
}
