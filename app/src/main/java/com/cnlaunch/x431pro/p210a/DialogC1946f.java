package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.widget.p290a.TipDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CommonTools.java */
/* renamed from: com.cnlaunch.x431pro.a.f */
/* loaded from: classes.dex */
public final class DialogC1946f extends TipDialog {

    /* renamed from: a */
    final /* synthetic */ Context f10545a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC1946f(Context context, Context context2) {
        super(context, (int) R.string.tab_menu_Identifix, (int) R.string.identifix_dialog_tips);
        this.f10545a = context2;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.TipDialog
    /* renamed from: a */
    public final void mo4580a(int i, boolean z) {
        if (i == 1) {
            if (z) {
                PreferencesManager.m9595a(this.f10545a).m9588a("show_identifix_tips", "1");
            } else {
                PreferencesManager.m9595a(this.f10545a).m9588a("show_identifix_tips", "0");
            }
            Context context = this.f10545a;
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                arrayList.add(installedPackages.get(i2).packageName);
            }
            Uri parse = Uri.parse("http://www.identifix.com");
            Intent intent = new Intent();
            if (arrayList.contains("com.android.chrome")) {
                intent.setData(parse);
                intent.setClassName("com.android.chrome", "com.google.android.apps.chrome.Main");
            } else if (arrayList.contains("com.android.browser")) {
                intent.setData(parse);
                intent.setAction("android.intent.action.VIEW");
                intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            } else {
                NToast.m9450a(context, (int) R.string.identifix_no_browser);
                return;
            }
            context.startActivity(intent);
        }
    }
}
