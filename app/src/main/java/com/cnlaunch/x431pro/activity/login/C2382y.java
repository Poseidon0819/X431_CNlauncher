package com.cnlaunch.x431pro.activity.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import com.cnlaunch.x431pro.widget.DropdownEditText;

/* compiled from: LoginActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.y */
/* loaded from: classes.dex */
final class C2382y extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ LoginActivity f13538a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2382y(LoginActivity loginActivity) {
        this.f13538a = loginActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        DropdownEditText dropdownEditText;
        EditText editText;
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("username");
        if (action.equalsIgnoreCase("RESET_PASSWORD")) {
            dropdownEditText = this.f13538a.f13089f;
            if (stringExtra.equals(dropdownEditText.getText().toString())) {
                editText = this.f13538a.f13090g;
                editText.setText("");
                this.f13538a.f13096m = "";
            }
            RegisterInfoRecord registerInfoRecord = new RegisterInfoRecord();
            this.f13538a.f13086c = registerInfoRecord.m6546a();
        }
        if (action.equals("android.intent.action.LOCALE_CHANGED")) {
            this.f13538a.finish();
        }
    }
}
