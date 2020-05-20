package com.launch.p353a.p358e;

import android.os.Handler;
import android.os.Message;
import android.support.p012v4.view.ViewPager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepDialog.java */
/* renamed from: com.launch.a.e.n */
/* loaded from: classes.dex */
public final class C3651n implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ StepDialog f19922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3651n(StepDialog stepDialog) {
        this.f19922a = stepDialog;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        Handler handler;
        Handler handler2;
        ViewPager viewPager;
        ViewPager viewPager2;
        Handler handler3;
        int i;
        if (message2.arg1 == 0) {
            handler = this.f19922a.f19920q;
            if (handler != null) {
                handler2 = this.f19922a.f19920q;
                handler2.removeMessages(0);
                viewPager = this.f19922a.f19914k;
                viewPager2 = this.f19922a.f19914k;
                viewPager.setCurrentItem(viewPager2.getCurrentItem() + 1);
                handler3 = this.f19922a.f19920q;
                i = this.f19922a.f19915l;
                handler3.sendEmptyMessageDelayed(0, i);
            }
        }
        return false;
    }
}
