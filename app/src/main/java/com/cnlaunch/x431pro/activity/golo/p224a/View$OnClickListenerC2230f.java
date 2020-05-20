package com.cnlaunch.x431pro.activity.golo.p224a;

import android.view.View;
import com.cnlaunch.x431pro.utils.C2778n;

/* compiled from: SearchFriendAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.golo.a.f */
/* loaded from: classes.dex */
final class View$OnClickListenerC2230f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f12552a;

    /* renamed from: b */
    final /* synthetic */ SearchFriendAdapter f12553b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2230f(SearchFriendAdapter searchFriendAdapter, int i) {
        this.f12553b = searchFriendAdapter;
        this.f12552a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C2778n.m4905b() || this.f12553b.f12534e == null) {
            return;
        }
        this.f12553b.f12534e.obtainMessage(0, this.f12553b.f12531b.get(this.f12552a).getUserID()).sendToTarget();
    }
}
