package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: DataStreamShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ad */
/* loaded from: classes.dex */
final class C2116ad implements TranslationUtil.InterfaceC2755b {

    /* renamed from: a */
    final /* synthetic */ Map f11968a;

    /* renamed from: b */
    final /* synthetic */ String f11969b;

    /* renamed from: c */
    final /* synthetic */ int f11970c;

    /* renamed from: d */
    final /* synthetic */ DataStreamShowFragment f11971d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2116ad(DataStreamShowFragment dataStreamShowFragment, Map map, String str, int i) {
        this.f11971d = dataStreamShowFragment;
        this.f11968a = map;
        this.f11969b = str;
        this.f11970c = i;
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5064a(String str) {
        this.f11968a.put(this.f11969b, str);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: a */
    public final void mo5065a() {
        ArrayList arrayList;
        Handler handler;
        Handler handler2;
        DataStreamShowFragment dataStreamShowFragment = this.f11971d;
        arrayList = dataStreamShowFragment.f11903R;
        dataStreamShowFragment.f11951p = ((this.f11970c + 1) * 100) / arrayList.size();
        handler = this.f11971d.f11941as;
        Message obtainMessage = handler.obtainMessage(121212, this.f11971d.f11951p, 0);
        handler2 = this.f11971d.f11941as;
        handler2.sendMessage(obtainMessage);
    }

    @Override // com.cnlaunch.x431pro.utils.p282d.TranslationUtil.InterfaceC2755b
    /* renamed from: b */
    public final void mo5063b() {
        Handler handler;
        Handler handler2;
        DataStreamShowFragment.m7258y(this.f11971d);
        handler = this.f11971d.f11941as;
        Message obtainMessage = handler.obtainMessage(131313);
        handler2 = this.f11971d.f11941as;
        handler2.sendMessage(obtainMessage);
    }
}
