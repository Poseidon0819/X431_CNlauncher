package com.cnlaunch.x431pro.activity.setting;

import android.os.Looper;
import android.widget.Button;
import com.cnlaunch.p120d.p125c.p129d.NetworkObserver;

/* compiled from: CheckServerFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.e */
/* loaded from: classes.dex */
final class C2561e extends NetworkObserver {

    /* renamed from: b */
    final /* synthetic */ CheckServerFragment f14794b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2561e(CheckServerFragment checkServerFragment, Looper looper) {
        super(looper);
        this.f14794b = checkServerFragment;
    }

    @Override // com.cnlaunch.p120d.p125c.p129d.NetworkObserver
    /* renamed from: a */
    public final void mo5917a() {
        Button button;
        button = this.f14794b.f14759d;
        button.setEnabled(false);
        this.f14794b.f14717F = false;
    }

    @Override // com.cnlaunch.p120d.p125c.p129d.NetworkObserver
    /* renamed from: b */
    public final void mo5916b() {
        Button button;
        button = this.f14794b.f14759d;
        button.setEnabled(true);
        this.f14794b.f14717F = true;
    }
}
