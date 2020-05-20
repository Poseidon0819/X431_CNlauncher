package com.cnlaunch.x431pro.activity.setting;

import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.activity.setting.p234a.OneKeyFeedbackAdapter;

/* compiled from: OneKeyFeedbackFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.ae */
/* loaded from: classes.dex */
final class C2521ae implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ OneKeyFeedbackFragment f14552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2521ae(OneKeyFeedbackFragment oneKeyFeedbackFragment) {
        this.f14552a = oneKeyFeedbackFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ((OneKeyFeedbackAdapter.C2516a) view.getTag()).f14531a.toggle();
    }
}
