package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.p210a.C1947h;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.setting.aa */
/* loaded from: classes.dex */
final class OneKeyClearFragment implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ View$OnClickListenerC2594z f14548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OneKeyClearFragment(View$OnClickListenerC2594z view$OnClickListenerC2594z) {
        this.f14548a = view$OnClickListenerC2594z;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        TextView textView;
        Context context;
        TextView textView2;
        String str;
        if (i >= 0) {
            try {
                list = this.f14548a.f14940n;
                String str2 = (String) list.get(i);
                textView = this.f14548a.f14935i;
                if (str2.equals(textView.getText().toString())) {
                    return;
                }
                this.f14548a.f14931e = str2;
                context = this.f14548a.mContext;
                PreferencesManager.m9595a(context).m9588a(C1947h.f10556h, str2);
                textView2 = this.f14548a.f14935i;
                str = this.f14548a.f14931e;
                textView2.setText(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
