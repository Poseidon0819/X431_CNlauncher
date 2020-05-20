package com.cnlaunch.x431pro.activity.mine.p229a;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import java.util.List;

/* compiled from: MyReportAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.a.c */
/* loaded from: classes.dex */
final class View$OnClickListenerC2387c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f13569a;

    /* renamed from: b */
    final /* synthetic */ MyReportAdapter f13570b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2387c(MyReportAdapter myReportAdapter, int i) {
        this.f13570b = myReportAdapter;
        this.f13569a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List list;
        Handler handler;
        this.f13570b.m6513a(this.f13569a);
        Message message2 = new Message();
        message2.what = 0;
        list = this.f13570b.f13556a;
        if (list.size() == this.f13570b.m6514a()) {
            message2.arg1 = 1;
        } else {
            message2.arg1 = 0;
        }
        handler = this.f13570b.f13561f;
        handler.sendMessage(message2);
    }
}
