package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.view.View;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.info.RepairInfoFragment;
import com.cnlaunch.x431pro.p210a.DialogC1946f;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RepairInfoFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.ag */
/* loaded from: classes.dex */
final class View$OnClickListenerC2275ag implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12886a;

    /* renamed from: b */
    final /* synthetic */ RepairInfoFragment.C2274a f12887b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2275ag(RepairInfoFragment.C2274a c2274a, int i) {
        this.f12887b = c2274a;
        this.f12886a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        String[] strArr;
        String str;
        String[] strArr2;
        Context context2;
        Context context3;
        if (this.f12886a == 0) {
            context2 = RepairInfoFragment.this.mContext;
            if (PreferencesManager.m9595a(context2).m9584b("show_identifix_tips", "1").equals("1")) {
                context3 = RepairInfoFragment.this.mContext;
                DialogC1946f dialogC1946f = new DialogC1946f(context3, context3);
                dialogC1946f.m4719a(R.string.btn_confirm, true, null);
                dialogC1946f.m4578b();
                dialogC1946f.show();
                return;
            }
        }
        context = RepairInfoFragment.this.mContext;
        if (C2744aa.m5151f()) {
            strArr2 = RepairInfoFragment.this.f12882c;
            str = strArr2[this.f12886a];
        } else {
            strArr = RepairInfoFragment.this.f12881b;
            str = strArr[this.f12886a];
        }
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < installedPackages.size(); i++) {
            arrayList.add(installedPackages.get(i).packageName);
        }
        Uri parse = Uri.parse(str);
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
