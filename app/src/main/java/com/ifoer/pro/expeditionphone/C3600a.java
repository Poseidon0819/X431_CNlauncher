package com.ifoer.pro.expeditionphone;

import java.util.TimerTask;

/* compiled from: WelcomeActivity.java */
/* renamed from: com.ifoer.pro.expeditionphone.a */
/* loaded from: classes.dex */
final class C3600a extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ WelcomeActivity f19468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3600a(WelcomeActivity welcomeActivity) {
        this.f19468a = welcomeActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        boolean z;
        WelcomeActivity.m2769a(this.f19468a);
        z = this.f19468a.f19461g;
        if (z) {
            this.f19468a.m2771a();
        }
    }
}
