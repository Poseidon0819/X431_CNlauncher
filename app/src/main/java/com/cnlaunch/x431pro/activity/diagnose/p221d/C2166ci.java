package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: SystemStatusCodeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ci */
/* loaded from: classes.dex */
final class C2166ci implements TranslationUtil.InterfaceC2755b {

    /* renamed from: a */
    final /* synthetic */ Map f12288a;

    /* renamed from: b */
    final /* synthetic */ String f12289b;

    /* renamed from: c */
    final /* synthetic */ int f12290c;

    /* renamed from: d */
    final /* synthetic */ ArrayList f12291d;

    /* renamed from: e */
    final /* synthetic */ SystemStatusCodeFragment f12292e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2166ci(SystemStatusCodeFragment systemStatusCodeFragment, Map map, String str, int i, ArrayList arrayList) {
        this.f12292e = systemStatusCodeFragment;
        this.f12288a = map;
        this.f12289b = str;
        this.f12290c = i;
        this.f12291d = arrayList;
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5064a(String str) {
        this.f12288a.put(this.f12289b, str);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5065a() {
        Handler handler;
        Handler handler2;
        this.f12292e.f12268j = ((this.f12290c + 1) * 100) / this.f12291d.size();
        handler = this.f12292e.f12243G;
        Message obtainMessage = handler.obtainMessage(121212, this.f12292e.f12268j, 0);
        handler2 = this.f12292e.f12243G;
        handler2.sendMessage(obtainMessage);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: b */
    public final void mo5063b() {
        Handler handler;
        Handler handler2;
        SystemStatusCodeFragment.m7141i(this.f12292e);
        handler = this.f12292e.f12243G;
        Message obtainMessage = handler.obtainMessage(131313);
        handler2 = this.f12292e.f12243G;
        handler2.sendMessage(obtainMessage);
    }
}
