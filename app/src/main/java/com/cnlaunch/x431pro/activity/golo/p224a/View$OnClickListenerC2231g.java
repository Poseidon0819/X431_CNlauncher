package com.cnlaunch.x431pro.activity.golo.p224a;

import android.view.View;
import com.cnlaunch.x431pro.activity.golo.p225b.OnFaceTouchListener;

/* compiled from: SearchFriendAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.a.g */
/* loaded from: classes.dex */
final class View$OnClickListenerC2231g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12554a;

    /* renamed from: b */
    final /* synthetic */ SearchFriendAdapter f12555b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2231g(SearchFriendAdapter searchFriendAdapter, int i) {
        this.f12555b = searchFriendAdapter;
        this.f12554a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        OnFaceTouchListener onFaceTouchListener;
        OnFaceTouchListener onFaceTouchListener2;
        onFaceTouchListener = this.f12555b.f12536g;
        if (onFaceTouchListener != null) {
            onFaceTouchListener2 = this.f12555b.f12536g;
            onFaceTouchListener2.mo7021a(this.f12555b.f12531b.get(this.f12554a).getName(), this.f12555b.f12531b.get(this.f12554a).getUserID(), this.f12555b.f12531b.get(this.f12554a).isFriend());
        }
    }
}
