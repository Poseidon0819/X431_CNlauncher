package com.cnlaunch.x431pro.widget.p290a;

import android.content.Intent;
import android.view.View;

/* compiled from: PrinterFailrueDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bp */
/* loaded from: classes.dex */
final class View$OnClickListenerC2833bp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PrinterFailrueDialog f16321a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2833bp(PrinterFailrueDialog printerFailrueDialog) {
        this.f16321a = printerFailrueDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f16321a.f16320a.sendBroadcast(new Intent("show_PrintSetting"));
    }
}
