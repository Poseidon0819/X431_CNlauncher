package com.cnlaunch.x431pro.activity.mine;

import android.os.Handler;
import com.cnlaunch.physics.p201g.OnDownloadBinListener;
import com.cnlaunch.physics.p205k.C1856n;
import java.math.BigDecimal;

/* compiled from: FirmwareFixFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.ai */
/* loaded from: classes.dex */
final class C2399ai implements OnDownloadBinListener {

    /* renamed from: a */
    final /* synthetic */ FirmwareFixFragment f13649a;

    @Override // com.cnlaunch.physics.p201g.OnDownloadBinListener
    /* renamed from: a */
    public final void mo6134a(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2399ai(FirmwareFixFragment firmwareFixFragment) {
        this.f13649a = firmwareFixFragment;
    }

    @Override // com.cnlaunch.physics.p201g.OnDownloadBinListener
    /* renamed from: a */
    public final void mo6135a(int i, long j, long j2) {
        Handler handler;
        if (i == 8) {
            BigDecimal bigDecimal = new BigDecimal((((float) j) / ((float) j2)) * 100.0f);
            this.f13649a.f13633g = bigDecimal.setScale(0, 4).floatValue();
        }
        if (C1856n.f10135a) {
            C1856n.m8130a("FirmwareFixFragment", "OnDownloadBinListener state = " + i + " progress = " + j + " length = " + j2);
        }
        handler = this.f13649a.f13644r;
        handler.sendEmptyMessage(i);
    }
}
