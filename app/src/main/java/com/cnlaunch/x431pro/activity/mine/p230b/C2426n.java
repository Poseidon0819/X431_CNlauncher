package com.cnlaunch.x431pro.activity.mine.p230b;

import android.app.FragmentManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: DiagnosisPlaybackFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.n */
/* loaded from: classes.dex */
final class C2426n extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2424l f13822a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2426n(HandlerC2424l handlerC2424l) {
        this.f13822a = handlerC2424l;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        String str;
        FragmentManager fragmentManager;
        str = this.f13822a.f13820a.f13802i;
        FileUtils.m5000d(str);
        fragmentManager = this.f13822a.f13820a.fragmentManager;
        fragmentManager.popBackStack();
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
        FragmentManager fragmentManager;
        fragmentManager = this.f13822a.f13820a.fragmentManager;
        fragmentManager.popBackStack();
    }
}
