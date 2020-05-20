package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: FaultCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.as */
/* loaded from: classes.dex */
final class C2130as implements TranslationUtil.InterfaceC2755b {

    /* renamed from: a */
    final /* synthetic */ Map f12017a;

    /* renamed from: b */
    final /* synthetic */ String f12018b;

    /* renamed from: c */
    final /* synthetic */ int f12019c;

    /* renamed from: d */
    final /* synthetic */ FaultCodeFragment f12020d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2130as(FaultCodeFragment faultCodeFragment, Map map, String str, int i) {
        this.f12020d = faultCodeFragment;
        this.f12017a = map;
        this.f12018b = str;
        this.f12019c = i;
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5064a(String str) {
        this.f12017a.put(this.f12018b, str);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5065a() {
        ArrayList arrayList;
        Handler handler;
        Handler handler2;
        FaultCodeFragment faultCodeFragment = this.f12020d;
        arrayList = faultCodeFragment.f11993a;
        faultCodeFragment.f11999n = ((this.f12019c + 1) * 100) / arrayList.size();
        handler = this.f12020d.f11982C;
        Message obtainMessage = handler.obtainMessage(121212, this.f12020d.f11999n, 0);
        handler2 = this.f12020d.f11982C;
        handler2.sendMessage(obtainMessage);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: b */
    public final void mo5063b() {
        Handler handler;
        Handler handler2;
        FaultCodeFragment.m7243i(this.f12020d);
        handler = this.f12020d.f11982C;
        Message obtainMessage = handler.obtainMessage(131313);
        handler2 = this.f12020d.f11982C;
        handler2.sendMessage(obtainMessage);
    }
}
