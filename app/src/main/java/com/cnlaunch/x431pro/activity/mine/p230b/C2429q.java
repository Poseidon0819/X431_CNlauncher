package com.cnlaunch.x431pro.activity.mine.p230b;

import android.app.FragmentManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: DiagnosisPlaybackFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.b.q */
/* loaded from: classes.dex */
final class C2429q extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ DiagnosisPlaybackFragment f13825a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2429q(DiagnosisPlaybackFragment diagnosisPlaybackFragment) {
        this.f13825a = diagnosisPlaybackFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        String str;
        FragmentManager fragmentManager;
        str = this.f13825a.f13802i;
        FileUtils.m5000d(str);
        fragmentManager = this.f13825a.fragmentManager;
        fragmentManager.popBackStack();
    }
}
