package com.cnlaunch.p169im.p172c;

import com.cnlaunch.x431pro.widget.sortlistview.SideBar;

/* compiled from: FriendListFragment.java */
/* renamed from: com.cnlaunch.im.c.c */
/* loaded from: classes.dex */
final class C1706c implements SideBar.InterfaceC2960a {

    /* renamed from: a */
    final /* synthetic */ FriendListFragment f9082a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1706c(FriendListFragment friendListFragment) {
        this.f9082a = friendListFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.sortlistview.SideBar.InterfaceC2960a
    /* renamed from: a */
    public final void mo4392a(String str) {
        int m7035a;
        if (this.f9082a.f9044b == null || (m7035a = this.f9082a.f9044b.m7035a(str.charAt(0))) == -1) {
            return;
        }
        this.f9082a.f9043a.setSelection(m7035a);
    }
}
