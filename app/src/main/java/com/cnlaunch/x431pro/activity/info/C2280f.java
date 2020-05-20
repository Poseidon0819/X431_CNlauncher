package com.cnlaunch.x431pro.activity.info;

import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.widget.MyWebView;

/* compiled from: InfoEuroFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.f */
/* loaded from: classes.dex */
final class C2280f extends MyWebView.C2790a {

    /* renamed from: a */
    final /* synthetic */ InfoEuroFragment f12898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2280f(InfoEuroFragment infoEuroFragment) {
        this.f12898a = infoEuroFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.MyWebView.C2790a
    /* renamed from: a */
    public final void mo4782a(boolean z) {
        if (z) {
            ((ActivityC2004c) this.f12898a.getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((ActivityC2004c) this.f12898a.getActivity()).m7732g().setTouchModeAbove(2);
        }
    }
}
