package com.cnlaunch.p169im.p172c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.cnlaunch.p169im.IMPresenter;

/* compiled from: FriendListFragment.java */
/* renamed from: com.cnlaunch.im.c.b */
/* loaded from: classes.dex */
final class View$OnClickListenerC1705b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FriendListFragment f9081a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1705b(FriendListFragment friendListFragment) {
        this.f9081a = friendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        context = this.f9081a.mContext;
        IMPresenter.m8804a(context).m8800a(MessageListFragment.class.getName(), (Bundle) null);
    }
}
