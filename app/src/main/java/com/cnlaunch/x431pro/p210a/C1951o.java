package com.cnlaunch.x431pro.p210a;

import android.content.Intent;
import com.cnlaunch.x431pro.activity.login.LoginActivity;
import com.cnlaunch.x431pro.activity.login.RegistActivity;
import com.cnlaunch.x431pro.activity.login.RegisterInstructionActivity;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialogTri;
import java.util.Locale;

/* compiled from: RTUHelper.java */
/* renamed from: com.cnlaunch.x431pro.a.o */
/* loaded from: classes.dex */
public final class C1951o extends SelectMessageDialogTri {

    /* renamed from: a */
    final /* synthetic */ RTUHelper f10591a;

    public C1951o(RTUHelper rTUHelper) {
        this.f10591a = rTUHelper;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialogTri
    /* renamed from: a */
    public final void mo4604a() {
        Intent intent;
        if (Locale.getDefault().getLanguage().equalsIgnoreCase("ja")) {
            intent = new Intent(this.f10591a.f10589e, RegisterInstructionActivity.class);
        } else {
            intent = new Intent(this.f10591a.f10589e, RegistActivity.class);
        }
        this.f10591a.f10589e.startActivity(intent);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialogTri
    /* renamed from: b */
    public final void mo4602b() {
        this.f10591a.f10589e.startActivity(new Intent(this.f10591a.f10589e, LoginActivity.class));
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialogTri
    /* renamed from: c */
    public final void mo4601c() {
        System.exit(0);
    }
}
