package com.cnlaunch.p169im.p172c;

import android.os.Handler;
import android.os.Message;

/* compiled from: SearchFriendFragment.java */
/* renamed from: com.cnlaunch.im.c.y */
/* loaded from: classes.dex */
final class HandlerC1729y extends Handler {

    /* renamed from: a */
    final /* synthetic */ SearchFriendFragment f9176a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1729y(SearchFriendFragment searchFriendFragment) {
        this.f9176a = searchFriendFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        super.handleMessage(message2);
        if (message2.what != 0) {
            return;
        }
        this.f9176a.f9168l = (String) message2.obj;
        this.f9176a.request(40023);
    }
}
