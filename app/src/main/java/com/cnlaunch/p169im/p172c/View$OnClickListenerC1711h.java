package com.cnlaunch.p169im.p172c;

import android.view.View;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p172c.MessageListFragment;
import com.cnlaunch.p169im.p177g.MessageInfo;

/* compiled from: MessageListFragment.java */
/* renamed from: com.cnlaunch.im.c.h */
/* loaded from: classes.dex */
final class View$OnClickListenerC1711h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MessageInfo f9091a;

    /* renamed from: b */
    final /* synthetic */ MessageListFragment.C1709a f9092b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1711h(MessageListFragment.C1709a c1709a, MessageInfo messageInfo) {
        this.f9092b = c1709a;
        this.f9091a = messageInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        IMPresenter.m8804a(MessageListFragment.this.getActivity()).m8801a(this.f9091a.f9270b);
    }
}
