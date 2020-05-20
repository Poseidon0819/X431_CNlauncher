package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.os.Bundle;
import android.view.View;

/* compiled from: CloudHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.n */
/* loaded from: classes.dex */
final class View$OnClickListenerC1962n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ CloudHistoryFragment f10675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1962n(CloudHistoryFragment cloudHistoryFragment) {
        this.f10675a = cloudHistoryFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        String str3;
        String str4;
        Bundle bundle = new Bundle();
        bundle.putInt("scan_type", VINPlateScanFragment.f10683b);
        str = this.f10675a.f10654h;
        bundle.putString("vin", str);
        str2 = this.f10675a.f10656j;
        bundle.putString("brand", str2);
        str3 = this.f10675a.f10657k;
        bundle.putString("year", str3);
        str4 = this.f10675a.f10670x;
        bundle.putString("package_id", str4);
        this.f10675a.replaceFragment(VINPlateScanFragment.class.getName(), bundle, false);
    }
}
