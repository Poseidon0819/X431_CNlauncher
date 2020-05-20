package com.cnlaunch.golo3.view.selectimg.clip;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.cnlaunch.p132e.p133a.C1464a;

/* compiled from: ClipImageActivity.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.clip.c */
/* loaded from: classes.dex */
final class HandlerC1640c extends Handler {

    /* renamed from: a */
    final /* synthetic */ ClipImageActivity f8672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1640c(ClipImageActivity clipImageActivity) {
        this.f8672a = clipImageActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        if (message2.what != 0) {
            return;
        }
        Toast.makeText(this.f8672a, C1464a.C1470f.msg_could_not_save_photo, 0).show();
    }
}
