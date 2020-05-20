package com.cnlaunch.p169im.p172c;

import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.NetWorkDataModel;
import com.cnlaunch.p169im.p172c.FriendListFragment;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: FriendListFragment.java */
/* renamed from: com.cnlaunch.im.c.e */
/* loaded from: classes.dex */
final class C1708e extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ FriendInfo f9084a;

    /* renamed from: b */
    final /* synthetic */ FriendListFragment.C1699a f9085b;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1708e(FriendListFragment.C1699a c1699a, FriendInfo friendInfo) {
        this.f9085b = c1699a;
        this.f9084a = friendInfo;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        new NetWorkDataModel.AsyncTaskC1738b().execute(this.f9084a.getUser_id());
        IMPresenter.m8804a(FriendListFragment.this.getActivity()).m8801a(this.f9084a.getUser_id());
    }
}
