package com.cnlaunch.x431pro.activity.info;

import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.widget.MyWebView;

/* compiled from: InfoFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.h */
/* loaded from: classes.dex */
final class C2282h extends MyWebView.C2790a {

    /* renamed from: a */
    final /* synthetic */ InfoFragment f12907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2282h(InfoFragment infoFragment) {
        this.f12907a = infoFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.MyWebView.C2790a
    /* renamed from: a */
    public final void mo4782a(boolean z) {
        if (z) {
            ((ActivityC2004c) this.f12907a.getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((ActivityC2004c) this.f12907a.getActivity()).m7732g().setTouchModeAbove(2);
        }
    }
}
