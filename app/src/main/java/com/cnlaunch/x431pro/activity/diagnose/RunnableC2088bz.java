package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.os.Handler;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.itextpdf.text.pdf.codec.TIFFConstants;

/* compiled from: SelectSoftVersionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bz */
/* loaded from: classes.dex */
final class RunnableC2088bz implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SelectSoftVersionFragment f11703a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2088bz(SelectSoftVersionFragment selectSoftVersionFragment) {
        this.f11703a = selectSoftVersionFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context context;
        Handler handler2;
        handler = this.f11703a.f11682K;
        handler.sendEmptyMessage(275);
        context = this.f11703a.f11674B;
        DiagnoseUtils.m5081b(context);
        handler2 = this.f11703a.f11682K;
        handler2.sendEmptyMessage(TIFFConstants.TIFFTAG_ORIENTATION);
    }
}
