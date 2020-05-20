package com.cnlaunch.x431pro.activity.pay;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.golo3.p164f.Event;
import com.cnlaunch.golo3.p164f.EventListener;

/* compiled from: ChoicePayModeActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.pay.e */
/* loaded from: classes.dex */
final class C2510e extends EventListener {

    /* renamed from: a */
    final /* synthetic */ ChoicePayModeActivity f14424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2510e(ChoicePayModeActivity choicePayModeActivity) {
        this.f14424a = choicePayModeActivity;
    }

    @Override // com.cnlaunch.golo3.p164f.EventListener
    /* renamed from: a */
    public final void mo6055a(Event<?> event) {
        Context unused;
        this.f14424a.f14376n = false;
        unused = this.f14424a.f10981q;
        if (TextUtils.equals((String) event.f8437a, "9000")) {
            Log.i("huchao", "alipayListener_sucess");
            ChoicePayModeActivity.m6068b(this.f14424a);
        }
    }
}
