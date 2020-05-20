package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.os.Bundle;
import android.view.View;
import com.cnlaunch.x431pro.activity.mine.WebRemoteDiagReportFragment;

/* compiled from: CloudHistoryAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.h */
/* loaded from: classes.dex */
final class View$OnClickListenerC1957h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f10644a;

    /* renamed from: b */
    final /* synthetic */ CloudHistoryAdapter f10645b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1957h(CloudHistoryAdapter cloudHistoryAdapter, int i) {
        this.f10645b = cloudHistoryAdapter;
        this.f10644a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CloudHistoryFragment cloudHistoryFragment;
        CloudHistoryFragment cloudHistoryFragment2;
        cloudHistoryFragment = this.f10645b.f10621a;
        if (cloudHistoryFragment != null) {
            cloudHistoryFragment2 = this.f10645b.f10621a;
            int i = this.f10644a;
            Bundle bundle = new Bundle();
            bundle.putString("urlkey", cloudHistoryFragment2.f10647a.get(i).getReport_url());
            cloudHistoryFragment2.replaceFragment(WebRemoteDiagReportFragment.class.getName(), bundle);
        }
    }
}
