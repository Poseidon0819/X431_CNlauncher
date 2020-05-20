package com.cnlaunch.x431pro.activity.diagnose;

import android.media.SoundPool;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ac */
/* loaded from: classes.dex */
public final class C2042ac implements SoundPool.OnLoadCompleteListener {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11487a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2042ac(DiagnoseActivity diagnoseActivity) {
        this.f11487a = diagnoseActivity;
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
        int i3;
        int i4;
        int i5;
        i3 = this.f11487a.f11098bJ;
        if (i3 > 0) {
            i5 = this.f11487a.f11098bJ;
            soundPool.pause(i5);
        }
        DiagnoseActivity diagnoseActivity = this.f11487a;
        i4 = diagnoseActivity.f11097bI;
        diagnoseActivity.f11098bJ = soundPool.play(i4, 1.0f, 1.0f, 0, -1, 1.0f);
    }
}
