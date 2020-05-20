package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;
import java.util.Map;

/* compiled from: ActiveTestFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.j */
/* loaded from: classes.dex */
final class C2176j implements TranslationUtil.InterfaceC2755b {

    /* renamed from: a */
    final /* synthetic */ Map f12337a;

    /* renamed from: b */
    final /* synthetic */ String f12338b;

    /* renamed from: c */
    final /* synthetic */ int f12339c;

    /* renamed from: d */
    final /* synthetic */ ActiveTestFragment f12340d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2176j(ActiveTestFragment activeTestFragment, Map map, String str, int i) {
        this.f12340d = activeTestFragment;
        this.f12337a = map;
        this.f12338b = str;
        this.f12339c = i;
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5064a(String str) {
        this.f12337a.put(this.f12338b, str);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5065a() {
        Handler handler;
        Handler handler2;
        ActiveTestFragment activeTestFragment = this.f12340d;
        activeTestFragment.f11859a = ((this.f12339c + 1) * 100) / activeTestFragment.f11861j.size();
        handler = this.f12340d.f11850B;
        Message obtainMessage = handler.obtainMessage(121212, this.f12340d.f11859a, 0);
        handler2 = this.f12340d.f11850B;
        handler2.sendMessage(obtainMessage);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: b */
    public final void mo5063b() {
        Handler handler;
        Handler handler2;
        ActiveTestFragment.m7305r(this.f12340d);
        handler = this.f12340d.f11850B;
        Message obtainMessage = handler.obtainMessage(131313);
        handler2 = this.f12340d.f11850B;
        handler2.sendMessage(obtainMessage);
    }
}
