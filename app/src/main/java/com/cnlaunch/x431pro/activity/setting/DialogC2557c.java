package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.widget.TextView;
import com.cnlaunch.x431pro.widget.p290a.SelectAutoDownloadDialog;
import com.ifoer.expedition.pro.R;

/* compiled from: AboutFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.c */
/* loaded from: classes.dex */
final class DialogC2557c extends SelectAutoDownloadDialog {

    /* renamed from: a */
    final /* synthetic */ AboutFragment f14710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2557c(AboutFragment aboutFragment, Context context) {
        super(context);
        this.f14710a = aboutFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectAutoDownloadDialog
    /* renamed from: a */
    public final void mo4616a(int i) {
        TextView textView;
        TextView textView2;
        if (i == 0) {
            textView2 = this.f14710a.f14499j;
            textView2.setText(R.string.auto_wifi_download);
            return;
        }
        textView = this.f14710a.f14499j;
        textView.setText(R.string.close_auto_download);
    }
}
