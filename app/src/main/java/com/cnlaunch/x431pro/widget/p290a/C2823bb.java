package com.cnlaunch.x431pro.widget.p290a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import com.cnlaunch.x431pro.activity.login.RegisterInfoRecord;
import com.cnlaunch.x431pro.widget.DropdownEditText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bb */
/* loaded from: classes.dex */
public final class C2823bb extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ LoginDialog f16273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2823bb(LoginDialog loginDialog) {
        this.f16273a = loginDialog;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        DropdownEditText dropdownEditText;
        EditText editText;
        BroadcastReceiver broadcastReceiver;
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("username");
        if (action.equalsIgnoreCase("login")) {
            Context context2 = this.f16273a.f16252b;
            broadcastReceiver = this.f16273a.f16265r;
            context2.unregisterReceiver(broadcastReceiver);
            this.f16273a.dismiss();
        } else if (action.equalsIgnoreCase("RESET_PASSWORD")) {
            dropdownEditText = this.f16273a.f16257j;
            if (stringExtra.equals(dropdownEditText.getText().toString())) {
                editText = this.f16273a.f16258k;
                editText.setText("");
                this.f16273a.f16264q = "";
            }
            RegisterInfoRecord registerInfoRecord = new RegisterInfoRecord();
            this.f16273a.f16254g = registerInfoRecord.m6546a();
        }
    }
}
