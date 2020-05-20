package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.activity.setting.p235b.DiagLogHistoryInfoManager;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: OneKeyFeedbackHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.al */
/* loaded from: classes.dex */
final class C2527al implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ List f14576a;

    /* renamed from: b */
    final /* synthetic */ OneKeyFeedbackHistoryFragment f14577b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2527al(OneKeyFeedbackHistoryFragment oneKeyFeedbackHistoryFragment, List list) {
        this.f14577b = oneKeyFeedbackHistoryFragment;
        this.f14576a = list;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Context context;
        Context context2;
        Context context3;
        if (i >= 0) {
            try {
                String str = (String) this.f14576a.get(i);
                OneKeyFeedbackHistoryFragment.m6026a(this.f14577b, str);
                context = this.f14577b.mContext;
                context2 = this.f14577b.mContext;
                LoadDialog.m4684a(context, context2.getString(R.string.refresh_txt));
                context3 = this.f14577b.mContext;
                DiagLogHistoryInfoManager.m5973a(context3).m5970a(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
