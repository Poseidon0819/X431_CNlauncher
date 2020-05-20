package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: OneKeyClearFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.ab */
/* loaded from: classes.dex */
final class C2519ab implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ List f14549a;

    /* renamed from: b */
    final /* synthetic */ View$OnClickListenerC2594z f14550b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2519ab(View$OnClickListenerC2594z view$OnClickListenerC2594z, List list) {
        this.f14550b = view$OnClickListenerC2594z;
        this.f14549a = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TextView textView;
        Context context;
        Context context2;
        Context context3;
        if (i >= 0) {
            try {
                String str = (String) this.f14549a.get(i);
                textView = this.f14550b.f14934h;
                if (str.equals(textView.getText().toString())) {
                    return;
                }
                View$OnClickListenerC2594z.m5831b(this.f14550b, str);
                context = this.f14550b.mContext;
                context2 = this.f14550b.mContext;
                LoadDialog.m4684a(context, context2.getString(R.string.refresh_txt));
                this.f14550b.request(10011, false);
                context3 = this.f14550b.mContext;
                PreferencesManager.m9595a(context3).m9587a("need_refresh", true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
