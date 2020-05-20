package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.os.Bundle;
import com.cnlaunch.x431pro.module.p241a.PresenterCallback;

/* compiled from: CloudReportUploadService.java */
/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.r */
/* loaded from: classes.dex */
final class C1965r implements PresenterCallback {

    /* renamed from: a */
    final /* synthetic */ CloudReportUploadService f10681a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1965r(CloudReportUploadService cloudReportUploadService) {
        this.f10681a = cloudReportUploadService;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.PresenterCallback
    /* renamed from: a */
    public final void mo5115a(Bundle bundle) {
        CloudReportUploadService.m7935a(this.f10681a, true);
    }

    @Override // com.cnlaunch.x431pro.module.p241a.PresenterCallback
    /* renamed from: a */
    public final void mo5116a(int i) {
        CloudReportUploadService.m7935a(this.f10681a, false);
    }
}
