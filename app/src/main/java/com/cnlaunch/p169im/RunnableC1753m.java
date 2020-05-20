package com.cnlaunch.p169im;

import android.content.SharedPreferences;
import android.os.Message;
import java.util.List;
import message.model.MessageObj;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShowImageDetailActivity.java */
/* renamed from: com.cnlaunch.im.m */
/* loaded from: classes.dex */
public final class RunnableC1753m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f9309a;

    /* renamed from: b */
    final /* synthetic */ ShowImageDetailActivity f9310b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1753m(ShowImageDetailActivity showImageDetailActivity, int i) {
        this.f9310b = showImageDetailActivity;
        this.f9309a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        List list2;
        List list3;
        List list4;
        ShowImageDetailActivity showImageDetailActivity = this.f9310b;
        list = showImageDetailActivity.f8869b;
        String m8953a = showImageDetailActivity.m8953a(((MessageObj) list.get(this.f9309a)).f24084a);
        if (m8953a == null) {
            this.f9310b.f8873g.sendEmptyMessage(1);
            return;
        }
        ShowImageDetailActivity showImageDetailActivity2 = this.f9310b;
        list2 = showImageDetailActivity2.f8869b;
        showImageDetailActivity2.f8880n = ((MessageObj) list2.get(this.f9309a)).f24084a;
        this.f9310b.f8870c = m8953a;
        ShowImageDetailActivity showImageDetailActivity3 = this.f9310b;
        list3 = showImageDetailActivity3.f8869b;
        showImageDetailActivity3.f8881o = ((MessageObj) list3.get(this.f9309a)).f24087d;
        SharedPreferences.Editor edit = this.f9310b.f8872f.edit();
        list4 = this.f9310b.f8869b;
        edit.putString(((MessageObj) list4.get(this.f9309a)).f24084a, m8953a).commit();
        Message message2 = new Message();
        message2.what = 0;
        message2.obj = m8953a;
        message2.arg1 = this.f9309a;
        this.f9310b.f8873g.sendMessage(message2);
    }
}
