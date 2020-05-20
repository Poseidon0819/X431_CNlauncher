package com.cnlaunch.x431pro.activity.login;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/* compiled from: RegistActivity_ja.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.aw */
/* loaded from: classes.dex */
final class HandlerC2324aw extends Handler {

    /* renamed from: a */
    final /* synthetic */ RegistActivity_ja f13431a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2324aw(RegistActivity_ja registActivity_ja) {
        this.f13431a = registActivity_ja;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ImageView imageView;
        Drawable drawable;
        super.handleMessage(message2);
        switch (message2.what) {
            case 2:
                new Thread(new RunnableC2325ax(this)).start();
                return;
            case 3:
                imageView = this.f13431a.f13246aM;
                drawable = this.f13431a.f13245aL;
                imageView.setImageDrawable(drawable);
                return;
            default:
                return;
        }
    }
}
