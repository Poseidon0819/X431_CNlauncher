package com.cnlaunch.x431pro.widget.p290a;

import android.view.View;

/* compiled from: SelectAutoDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bz */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2842bz implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SelectAutoDownloadDialog f16346a;

    public View$OnClickListenerC2842bz(SelectAutoDownloadDialog selectAutoDownloadDialog) {
        this.f16346a = selectAutoDownloadDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        SelectAutoDownloadDialog selectAutoDownloadDialog = this.f16346a;
        i = selectAutoDownloadDialog.f16343h;
        selectAutoDownloadDialog.mo4616a(i);
        this.f16346a.dismiss();
    }
}
