package com.cnlaunch.x431pro.activity.mine.p229a;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import java.util.List;

/* compiled from: NewLocalReportAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.a.f */
/* loaded from: classes.dex */
final class View$OnClickListenerC2390f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f13588a;

    /* renamed from: b */
    final /* synthetic */ NewLocalReportAdapter f13589b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2390f(NewLocalReportAdapter newLocalReportAdapter, int i) {
        this.f13589b = newLocalReportAdapter;
        this.f13588a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List list;
        Handler handler;
        NewLocalReportAdapter newLocalReportAdapter = this.f13589b;
        int i = this.f13588a;
        newLocalReportAdapter.f13573a.get(i).setCheck(!newLocalReportAdapter.f13573a.get(i).isCheck());
        newLocalReportAdapter.notifyDataSetChanged();
        Message message2 = new Message();
        message2.what = 0;
        list = this.f13589b.f13573a;
        if (list.size() == this.f13589b.m6507a()) {
            message2.arg1 = 1;
        } else {
            message2.arg1 = 0;
        }
        handler = this.f13589b.f13578f;
        handler.sendMessage(message2);
    }
}
