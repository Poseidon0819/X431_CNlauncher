package com.cnlaunch.x431pro.activity.golo.p224a;

import android.view.View;
import com.cnlaunch.p169im.p172c.SearchFriendFragment;

/* compiled from: SearchFriendAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.a.e */
/* loaded from: classes.dex */
final class View$OnClickListenerC2229e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12550a;

    /* renamed from: b */
    final /* synthetic */ SearchFriendAdapter f12551b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2229e(SearchFriendAdapter searchFriendAdapter, int i) {
        this.f12551b = searchFriendAdapter;
        this.f12550a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SearchFriendFragment searchFriendFragment;
        SearchFriendFragment searchFriendFragment2;
        searchFriendFragment = this.f12551b.f12535f;
        if (searchFriendFragment != null) {
            searchFriendFragment2 = this.f12551b.f12535f;
            searchFriendFragment2.m8814a(this.f12551b.f12531b.get(this.f12550a), 3);
        }
    }
}
