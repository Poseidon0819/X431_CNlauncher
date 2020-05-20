package com.cnlaunch.p169im;

import android.os.Environment;
import android.os.Handler;
import com.cnlaunch.golo3.p160b.ApplicationConfig;
import java.io.IOException;
import message.model.MessageObj;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShowVideoActivity.java */
/* renamed from: com.cnlaunch.im.p */
/* loaded from: classes.dex */
public final class C1756p extends Thread {

    /* renamed from: a */
    final /* synthetic */ ShowVideoActivity f9313a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1756p(ShowVideoActivity showVideoActivity) {
        this.f9313a = showVideoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z;
        MessageObj messageObj;
        Handler handler;
        z = this.f9313a.f8903n;
        if (z) {
            try {
                ShowVideoActivity showVideoActivity = this.f9313a;
                messageObj = this.f9313a.f8899j;
                handler = this.f9313a.f8907r;
                ShowVideoActivity.m8940a(showVideoActivity, messageObj.f24084a, Environment.getExternalStorageDirectory().getPath() + "/cnlaunch/golo3/" + ApplicationConfig.m9181a() + "/file", handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
