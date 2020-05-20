package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: SpeciaFunctionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bv */
/* loaded from: classes.dex */
final class C2153bv implements TranslationUtil.InterfaceC2755b {

    /* renamed from: a */
    final /* synthetic */ Map f12224a;

    /* renamed from: b */
    final /* synthetic */ String f12225b;

    /* renamed from: c */
    final /* synthetic */ int f12226c;

    /* renamed from: d */
    final /* synthetic */ SpeciaFunctionFragment f12227d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2153bv(SpeciaFunctionFragment speciaFunctionFragment, Map map, String str, int i) {
        this.f12227d = speciaFunctionFragment;
        this.f12224a = map;
        this.f12225b = str;
        this.f12226c = i;
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5064a(String str) {
        this.f12224a.put(this.f12225b, str);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5065a() {
        ArrayList arrayList;
        Handler handler;
        Handler handler2;
        SpeciaFunctionFragment speciaFunctionFragment = this.f12227d;
        arrayList = speciaFunctionFragment.f12208k;
        speciaFunctionFragment.f12205a = ((this.f12226c + 1) * 100) / arrayList.size();
        handler = this.f12227d.f12222z;
        Message obtainMessage = handler.obtainMessage(121212, this.f12227d.f12205a, 0);
        handler2 = this.f12227d.f12222z;
        handler2.sendMessage(obtainMessage);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: b */
    public final void mo5063b() {
        Handler handler;
        Handler handler2;
        this.f12227d.f12201O = true;
        handler = this.f12227d.f12222z;
        Message obtainMessage = handler.obtainMessage(131313);
        handler2 = this.f12227d.f12222z;
        handler2.sendMessage(obtainMessage);
    }
}
