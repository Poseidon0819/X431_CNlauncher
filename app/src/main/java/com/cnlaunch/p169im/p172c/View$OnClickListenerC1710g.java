package com.cnlaunch.p169im.p172c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.cnlaunch.p169im.IMPresenter;

/* compiled from: MessageListFragment.java */
/* renamed from: com.cnlaunch.im.c.g */
/* loaded from: classes.dex */
final class View$OnClickListenerC1710g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageListFragment f9090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1710g(MessageListFragment messageListFragment) {
        this.f9090a = messageListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        if (this.f9090a.getFragmentManager().getBackStackEntryCount() <= 0) {
            context = this.f9090a.mContext;
            IMPresenter.m8804a(context).m8800a(MessageListFragment.class.getName(), (Bundle) null);
            return;
        }
        this.f9090a.getFragmentManager().popBackStack();
    }
}
