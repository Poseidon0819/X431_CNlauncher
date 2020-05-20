package com.cnlaunch.x431pro.activity.setting;

import android.widget.ScrollView;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CheckServerFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.f */
/* loaded from: classes.dex */
public final class RunnableC2562f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CheckServerFragment f14795a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2562f(CheckServerFragment checkServerFragment) {
        this.f14795a = checkServerFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView;
        TextView textView;
        scrollView = this.f14795a.f14758c;
        textView = this.f14795a.f14757b;
        scrollView.scrollTo(0, textView.getBottom());
    }
}
