package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.widget.p290a.LoginDialog;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginFunction.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ab */
/* loaded from: classes.dex */
public final class DialogC2304ab extends LoginDialog {

    /* renamed from: a */
    final /* synthetic */ LoginFunction f13408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2304ab(LoginFunction loginFunction, Context context) {
        super(context);
        this.f13408a = loginFunction;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.LoginDialog
    /* renamed from: a */
    public final void mo4676a(String str, String str2) {
        PreferencesManager preferencesManager;
        PreferencesManager preferencesManager2;
        PreferencesManager preferencesManager3;
        PreferencesManager preferencesManager4;
        preferencesManager = this.f13408a.f13401t;
        preferencesManager.m9588a("login_password", "");
        preferencesManager2 = this.f13408a.f13401t;
        String m9591a = preferencesManager2.m9591a("username_list");
        if (m9591a != null && !m9591a.equals("")) {
            try {
                this.f13408a.f13383a = (ArrayList) LoginActivity.m6764a(m9591a);
                if (this.f13408a.f13383a.contains(str)) {
                    preferencesManager3 = this.f13408a.f13401t;
                    preferencesManager3.m9588a(str, "");
                    this.f13408a.f13383a.remove(str);
                    preferencesManager4 = this.f13408a.f13401t;
                    preferencesManager4.m9588a("username_list", LoginActivity.m6763a(this.f13408a.f13383a));
                }
            } catch (StreamCorruptedException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
            }
        }
        this.f13408a.m6583a(str, str2);
    }
}
