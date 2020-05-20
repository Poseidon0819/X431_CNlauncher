package com.cnlaunch.x431pro.activity.upgrade;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.widget.progress.ProgressBarCircularIndeterminate;

/* compiled from: UpgradeDetailActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.z */
/* loaded from: classes.dex */
final class HandlerC2703z extends Handler {

    /* renamed from: a */
    final /* synthetic */ UpgradeDetailActivity f15433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2703z(UpgradeDetailActivity upgradeDetailActivity) {
        this.f15433a = upgradeDetailActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ProgressBarCircularIndeterminate progressBarCircularIndeterminate;
        switch (message2.what) {
            case 0:
                return;
            case 1:
                progressBarCircularIndeterminate = this.f15433a.f14982F;
                progressBarCircularIndeterminate.setVisibility(8);
                return;
            case 2:
                return;
            default:
                super.handleMessage(message2);
                return;
        }
    }
}
