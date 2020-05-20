package com.cnlaunch.p169im.p170a;

import android.view.View;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatMessageAdapter.java */
/* renamed from: com.cnlaunch.im.a.i */
/* loaded from: classes.dex */
public final class View$OnLongClickListenerC1685i implements View.OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8976a;

    /* renamed from: b */
    final /* synthetic */ ChatMessageAdapter f8977b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnLongClickListenerC1685i(ChatMessageAdapter chatMessageAdapter, int i) {
        this.f8977b = chatMessageAdapter;
        this.f8976a = i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.f8977b.f8938u != null) {
            try {
                this.f8977b.f8938u.obtainMessage(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_URL_NULL, this.f8976a, 0).sendToTarget();
                return true;
            } catch (NullPointerException e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }
}
