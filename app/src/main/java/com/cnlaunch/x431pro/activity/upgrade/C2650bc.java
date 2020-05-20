package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: UpgradeFragmentForPro.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.bc */
/* loaded from: classes.dex */
final class C2650bc implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ List f15235a;

    /* renamed from: b */
    final /* synthetic */ UpgradeFragmentForPro f15236b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2650bc(UpgradeFragmentForPro upgradeFragmentForPro, List list) {
        this.f15236b = upgradeFragmentForPro;
        this.f15235a = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TextView textView;
        Context context;
        Context context2;
        if (i >= 0) {
            try {
                String str = (String) this.f15235a.get(i);
                textView = this.f15236b.f15176ae;
                if (str.equals(textView.getText().toString())) {
                    return;
                }
                UpgradeFragmentForPro.m5705a(this.f15236b, str);
                this.f15236b.m5678b();
                context = this.f15236b.mContext;
                context2 = this.f15236b.mContext;
                LoadDialog.m4684a(context, context2.getString(R.string.refresh_txt));
                this.f15236b.request(2101);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
