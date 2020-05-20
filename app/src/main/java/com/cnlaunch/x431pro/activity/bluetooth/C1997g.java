package com.cnlaunch.x431pro.activity.bluetooth;

import android.os.Handler;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import java.math.BigDecimal;

/* compiled from: DownloadBinActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.bluetooth.g */
/* loaded from: classes.dex */
final class C1997g implements OnDownloadBinListener {

    /* renamed from: a */
    final /* synthetic */ DownloadBinActivity f10953a;

    @Override // com.cnlaunch.physics.p201g.OnDownloadBinListener
    /* renamed from: a */
    public final void mo6134a(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1997g(DownloadBinActivity downloadBinActivity) {
        this.f10953a = downloadBinActivity;
    }

    @Override // com.cnlaunch.physics.p201g.OnDownloadBinListener
    /* renamed from: a */
    public final void mo6135a(int i, long j, long j2) {
        Handler handler;
        if (i == 8) {
            BigDecimal bigDecimal = new BigDecimal((((float) j) / ((float) j2)) * 100.0f);
            this.f10953a.f10922m = bigDecimal.setScale(0, 4).floatValue();
        }
        handler = this.f10953a.f10935z;
        handler.sendEmptyMessage(i);
    }
}
