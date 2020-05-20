package com.cnlaunch.x431pro.utils.p282d;

import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.translate.TranslateCallBack;
import com.cnlaunch.translate.TranslateResult;
import com.cnlaunch.x431pro.utils.p282d.TranslationUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TranslationUtil.java */
/* renamed from: com.cnlaunch.x431pro.utils.d.i */
/* loaded from: classes.dex */
public final class C2756i implements TranslateCallBack {

    /* renamed from: a */
    final /* synthetic */ TranslationUtil.InterfaceC2755b f15767a;

    /* renamed from: b */
    final /* synthetic */ TranslationUtil f15768b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2756i(TranslationUtil translationUtil, TranslationUtil.InterfaceC2755b interfaceC2755b) {
        this.f15768b = translationUtil;
        this.f15767a = interfaceC2755b;
    }

    @Override // com.cnlaunch.translate.TranslateCallBack
    public final void success(TranslateResult translateResult) {
        NLog.m9451c("TranslationUtil", "result :  " + translateResult.toString());
        String str = translateResult.data.translations.get(0).translatedText;
        TranslationUtil.InterfaceC2755b interfaceC2755b = this.f15767a;
        if (interfaceC2755b != null) {
            interfaceC2755b.mo5064a(str);
            this.f15767a.mo5065a();
        }
    }

    @Override // com.cnlaunch.translate.TranslateCallBack
    public final void fail(int i, String str) {
        TranslationUtil.InterfaceC2755b interfaceC2755b = this.f15767a;
        if (interfaceC2755b != null) {
            interfaceC2755b.mo5063b();
            this.f15767a.mo5065a();
        }
    }
}
