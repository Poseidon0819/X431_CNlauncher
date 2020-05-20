package com.cnlaunch.x431pro.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.activity.login.LoginFunction;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.cnlaunch.x431pro.module.p272k.p274b.ZipcodeInfoResponse;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.aa */
/* loaded from: classes.dex */
final class C1985aa implements LoginFunction.InterfaceC2301a {

    /* renamed from: a */
    final /* synthetic */ MainActivity f10880a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1985aa(MainActivity mainActivity) {
        this.f10880a = mainActivity;
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2301a
    /* renamed from: a */
    public final void mo6559a() {
        Handler handler;
        handler = this.f10880a.f10731U;
        handler.sendEmptyMessage(1);
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2301a
    /* renamed from: b */
    public final void mo6557b() {
        Handler handler;
        handler = this.f10880a.f10731U;
        handler.sendEmptyMessage(2);
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2301a
    /* renamed from: a */
    public final void mo6558a(Object obj) {
        Handler handler;
        Message message2 = new Message();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ZIPINFO", (ZipcodeInfoResponse) obj);
        message2.setData(bundle);
        message2.what = 3;
        handler = this.f10880a.f10731U;
        handler.sendMessage(message2);
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2301a
    /* renamed from: b */
    public final void mo6556b(Object obj) {
        Handler handler;
        Message message2 = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("FAILEDTIPS", (String) obj);
        message2.setData(bundle);
        message2.what = 4;
        handler = this.f10880a.f10731U;
        handler.sendMessage(message2);
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2301a
    /* renamed from: c */
    public final void mo6555c(Object obj) {
        Handler handler;
        Message message2 = new Message();
        Bundle bundle = new Bundle();
        bundle.putSerializable("USERBASEINFO", (UserBaseInfo) obj);
        message2.setData(bundle);
        message2.what = 5;
        handler = this.f10880a.f10731U;
        handler.sendMessage(message2);
    }

    @Override // com.cnlaunch.x431pro.activity.login.LoginFunction.InterfaceC2301a
    /* renamed from: d */
    public final void mo6554d(Object obj) {
        Handler handler;
        Message message2 = new Message();
        Bundle bundle = new Bundle();
        bundle.putSerializable("USERBASEINFO", (UserBaseInfo) obj);
        message2.setData(bundle);
        message2.what = 6;
        handler = this.f10880a.f10731U;
        handler.sendMessage(message2);
    }
}
