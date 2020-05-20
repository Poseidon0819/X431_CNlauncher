package com.cnlaunch.p169im.p172c;

import android.os.Bundle;
import android.view.View;
import com.cnlaunch.p169im.IMPresenter;

/* compiled from: FriendListFragment.java */
/* renamed from: com.cnlaunch.im.c.d */
/* loaded from: classes.dex */
final class View$OnClickListenerC1707d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FriendListFragment f9083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1707d(FriendListFragment friendListFragment) {
        this.f9083a = friendListFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        IMPresenter.m8804a(this.f9083a.getActivity()).m8800a(SearchFriendFragment.class.getName(), (Bundle) null);
    }
}
