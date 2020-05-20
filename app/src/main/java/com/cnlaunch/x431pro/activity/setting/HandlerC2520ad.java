package com.cnlaunch.x431pro.activity.setting;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.activity.setting.p234a.OneKeyFeedbackAdapter;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;
import java.util.Vector;

/* compiled from: OneKeyFeedbackFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.ad */
/* loaded from: classes.dex */
final class HandlerC2520ad extends Handler {

    /* renamed from: a */
    final /* synthetic */ OneKeyFeedbackFragment f14551a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2520ad(OneKeyFeedbackFragment oneKeyFeedbackFragment) {
        this.f14551a = oneKeyFeedbackFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        OneKeyFeedbackAdapter oneKeyFeedbackAdapter;
        Vector<DiagnoseLogInfoSearchUtil.C2749a> vector;
        OneKeyFeedbackAdapter oneKeyFeedbackAdapter2;
        if (message2.what != 1) {
            return;
        }
        oneKeyFeedbackAdapter = this.f14551a.adapter;
        vector = this.f14551a.items_diagnosis_log;
        oneKeyFeedbackAdapter.f14526a = vector;
        oneKeyFeedbackAdapter2 = this.f14551a.adapter;
        oneKeyFeedbackAdapter2.notifyDataSetChanged();
    }
}
