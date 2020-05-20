package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Handler;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.TimerTask;

/* compiled from: SelectSoftVersionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.cf */
/* loaded from: classes.dex */
final class C2108cf extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ HandlerC2107ce f11835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2108cf(HandlerC2107ce handlerC2107ce) {
        this.f11835a = handlerC2107ce;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        IconButton iconButton;
        Handler handler;
        iconButton = this.f11835a.f11834a.f11687l;
        if (iconButton.isEnabled()) {
            return;
        }
        handler = this.f11835a.f11834a.f11682K;
        handler.sendEmptyMessage(TIFFConstants.TIFFTAG_GRAYRESPONSECURVE);
    }
}
