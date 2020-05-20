package com.cnlaunch.x431pro.activity;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import com.cnlaunch.golo3.p165g.AbstractC1613g;
import com.cnlaunch.golo3.p165g.AbstractC1614h;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p169im.p178h.GoloOBManager;
import com.cnlaunch.p169im.service.GoloMessageService;
import com.cnlaunch.x431pro.module.p272k.p274b.User;
import message.p379b.XmppEvent;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.x */
/* loaded from: classes.dex */
final class C2706x extends AbstractC1614h {

    /* renamed from: b */
    final /* synthetic */ MainActivity f15436b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2706x(MainActivity mainActivity, Looper looper) {
        super(looper);
        this.f15436b = mainActivity;
    }

    @Override // com.cnlaunch.golo3.p165g.AbstractC1614h
    /* renamed from: a */
    public final void mo270a(AbstractC1613g abstractC1613g) {
        PreferencesManager preferencesManager;
        PreferencesManager preferencesManager2;
        PreferencesManager preferencesManager3;
        PreferencesManager preferencesManager4;
        PreferencesManager preferencesManager5;
        PreferencesManager preferencesManager6;
        PreferencesManager preferencesManager7;
        if (abstractC1613g instanceof XmppEvent) {
            switch (((XmppEvent) abstractC1613g).f23966a) {
                case conflict:
                    ((NotificationManager) this.f15436b.f10736a.getSystemService("notification")).cancel(0);
                    this.f15436b.sendBroadcast(new Intent("logout"));
                    preferencesManager = this.f15436b.f10742h;
                    preferencesManager.m9587a("isconflict", true);
                    preferencesManager2 = this.f15436b.f10742h;
                    preferencesManager2.m9588a("login_password", "");
                    preferencesManager3 = this.f15436b.f10742h;
                    preferencesManager3.m9588a("login_state", "0");
                    preferencesManager4 = this.f15436b.f10742h;
                    preferencesManager4.m9588a("if_auto_login", "0");
                    preferencesManager5 = this.f15436b.f10742h;
                    preferencesManager5.m9588a("USER_PUBLIC_ID", "");
                    preferencesManager6 = this.f15436b.f10742h;
                    preferencesManager6.m9588a("USER_PUBLIC_NAME", "");
                    User user = new User();
                    preferencesManager7 = this.f15436b.f10742h;
                    preferencesManager7.m9592a((PreferencesManager) user);
                    GoloOBManager.m8721a().m8716c();
                    return;
                case service_stop:
                    Log.e("Sanda", "------>service_stop");
                    Intent intent = new Intent(this.f15436b, GoloMessageService.class);
                    intent.setAction("action_login");
                    this.f15436b.startService(intent);
                    return;
                case relogin_failed:
                    return;
                case ping_failed:
                case send_failed:
                case connect_error:
                    GoloOBManager.m8721a().m8720a(1);
                    PreferencesManager.m9595a(this.f15436b.f10736a).m9587a("isConnect", false);
                    return;
                case connect_successfully:
                    PreferencesManager.m9595a(this.f15436b.f10736a).m9587a("isConnect", true);
                    GoloOBManager.m8721a().m8720a(0);
                    return;
                default:
                    return;
            }
        }
    }
}
