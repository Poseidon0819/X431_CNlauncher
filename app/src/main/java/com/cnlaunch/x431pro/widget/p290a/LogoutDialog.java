package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import com.cnlaunch.x431pro.activity.login.LoginFunction;

/* renamed from: com.cnlaunch.x431pro.widget.a.bc */
/* loaded from: classes.dex */
public final class LogoutDialog extends SelectMessageDialog {

    /* renamed from: a */
    Context f16274a;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    public LogoutDialog(Context context) {
        this.f16274a = context;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        new LoginFunction(this.f16274a).m6575c();
    }
}
