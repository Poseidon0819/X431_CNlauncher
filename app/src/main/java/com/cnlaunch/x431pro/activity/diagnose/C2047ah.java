package com.cnlaunch.x431pro.activity.diagnose;

import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ah */
/* loaded from: classes.dex */
public final class C2047ah extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ String f11493a;

    /* renamed from: b */
    final /* synthetic */ String f11494b;

    /* renamed from: c */
    final /* synthetic */ DiagnoseActivity f11495c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2047ah(DiagnoseActivity diagnoseActivity, String str, String str2) {
        this.f11495c = diagnoseActivity;
        this.f11493a = str;
        this.f11494b = str2;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        this.f11495c.m7620n();
        this.f11495c.mo7094a(this.f11493a, this.f11494b);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
        this.f11495c.mo7088b(this.f11493a, this.f11494b);
    }
}
