package com.cnlaunch.p169im.p170a;

import android.view.View;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatMessageAdapter.java */
/* renamed from: com.cnlaunch.im.a.h */
/* loaded from: classes.dex */
public final class View$OnLongClickListenerC1684h implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8974a;

    /* renamed from: b */
    final /* synthetic */ ChatMessageAdapter f8975b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnLongClickListenerC1684h(ChatMessageAdapter chatMessageAdapter, int i) {
        this.f8975b = chatMessageAdapter;
        this.f8974a = i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.f8975b.f8938u != null) {
            this.f8975b.f8938u.obtainMessage(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_URL_NULL, this.f8974a, 0).sendToTarget();
            return true;
        }
        return true;
    }
}
