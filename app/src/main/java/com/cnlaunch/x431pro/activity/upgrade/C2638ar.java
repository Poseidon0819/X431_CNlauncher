package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.upgrade.p238a.UpgradeAdapter;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.ar */
/* loaded from: classes.dex */
final class C2638ar implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ List f15135a;

    /* renamed from: b */
    final /* synthetic */ UpgradeFragment f15136b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2638ar(UpgradeFragment upgradeFragment, List list) {
        this.f15136b = upgradeFragment;
        this.f15135a = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TextView textView;
        UpgradeAdapter upgradeAdapter;
        UpgradeAdapter upgradeAdapter2;
        Context context;
        Context context2;
        if (i >= 0) {
            try {
                String str = (String) this.f15135a.get(i);
                textView = this.f15136b.f15072F;
                if (str.equals(textView.getText().toString())) {
                    return;
                }
                UpgradeFragment.m5776a(this.f15136b, str);
                UpgradeFragment.m5749k(this.f15136b);
                upgradeAdapter = this.f15136b.f15112r;
                upgradeAdapter.m5807a((List<X431PadDtoSoft>) null);
                upgradeAdapter2 = this.f15136b.f15112r;
                upgradeAdapter2.notifyDataSetChanged();
                context = this.f15136b.mContext;
                context2 = this.f15136b.mContext;
                LoadDialog.m4684a(context, context2.getString(R.string.refresh_txt));
                this.f15136b.request(2101);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
