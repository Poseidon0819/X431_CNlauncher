package com.cnlaunch.x431pro.activity.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.activity.setting.p235b.DiagLogHistoryInfoManager;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryInfo;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import java.util.List;

/* compiled from: OneKeyFeedbackHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.ag */
/* loaded from: classes.dex */
final class C2522ag implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ OneKeyFeedbackHistoryFragment f14571a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2522ag(OneKeyFeedbackHistoryFragment oneKeyFeedbackHistoryFragment) {
        this.f14571a = oneKeyFeedbackHistoryFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        Context context;
        Context context2;
        list = this.f14571a.f14568p;
        DiagLogHistoryInfo diagLogHistoryInfo = (DiagLogHistoryInfo) list.get(i);
        if (diagLogHistoryInfo.getReaded() < diagLogHistoryInfo.getCurrentState()) {
            diagLogHistoryInfo.setReaded(diagLogHistoryInfo.getCurrentState());
            context2 = this.f14571a.mContext;
            DBManager.m5036a(context2).f15794a.f15802e.update(diagLogHistoryInfo);
        }
        context = this.f14571a.mContext;
        DiagLogHistoryInfoManager.m5973a(context).m5974a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("diagLogHistoryInfo", diagLogHistoryInfo);
        this.f14571a.replaceFragment(DiagLogHistoryDetailFragment.class.getName(), bundle, 1);
    }
}
