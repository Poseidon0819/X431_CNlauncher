package com.cnlaunch.x431pro.activity.mine;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: CardStatusFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.d */
/* loaded from: classes.dex */
final class C2474d implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ CardStatusFragment f14196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2474d(CardStatusFragment cardStatusFragment) {
        this.f14196a = cardStatusFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (2 == i) {
            CardStatusFragment.m6420a(this.f14196a);
            return false;
        }
        return false;
    }
}
