package com.cnlaunch.x431pro.activity.diagnose;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import com.cnlaunch.p169im.p173d.AutoVoiceHandler;
import com.cnlaunch.x431pro.widget.SlidingUpPanelLayout;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.az */
/* loaded from: classes.dex */
final class C2065az implements SlidingUpPanelLayout.InterfaceC2799c {

    /* renamed from: a */
    final /* synthetic */ DiagnoseActivity f11519a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2065az(DiagnoseActivity diagnoseActivity) {
        this.f11519a = diagnoseActivity;
    }

    @Override // com.cnlaunch.x431pro.widget.SlidingUpPanelLayout.InterfaceC2799c
    /* renamed from: a */
    public final void mo4733a(float f) {
        Button button;
        Button button2;
        Button button3;
        if (f == 1.0f) {
            button3 = this.f11519a.f11021K;
            button3.setVisibility(0);
            AutoVoiceHandler.f9188c = true;
            return;
        }
        button = this.f11519a.f11021K;
        if (button.getVisibility() == 0) {
            button2 = this.f11519a.f11021K;
            button2.setVisibility(8);
            AutoVoiceHandler.f9188c = false;
        }
    }

    @Override // com.cnlaunch.x431pro.widget.SlidingUpPanelLayout.InterfaceC2799c
    /* renamed from: a */
    public final void mo4734a() {
        AutoVoiceHandler.f9188c = false;
    }

    @Override // com.cnlaunch.x431pro.widget.SlidingUpPanelLayout.InterfaceC2799c
    /* renamed from: a */
    public final void mo4732a(View view) {
        if (view != null) {
            ((InputMethodManager) this.f11519a.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
