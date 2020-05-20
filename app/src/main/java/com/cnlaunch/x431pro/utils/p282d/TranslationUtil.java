package com.cnlaunch.x431pro.utils.p282d;

import com.cnlaunch.translate.LanguageSupport;
import com.cnlaunch.translate.TranslateEntity;
import com.cnlaunch.translate.TranslateManager;

/* renamed from: com.cnlaunch.x431pro.utils.d.h */
/* loaded from: classes.dex */
public final class TranslationUtil {

    /* compiled from: TranslationUtil.java */
    /* renamed from: com.cnlaunch.x431pro.utils.d.h$b */
    /* loaded from: classes.dex */
    public interface InterfaceC2755b {
        /* renamed from: a */
        void mo5065a();

        /* renamed from: a */
        void mo5064a(String str);

        /* renamed from: b */
        void mo5063b();
    }

    /* synthetic */ TranslationUtil(byte b) {
        this();
    }

    private TranslationUtil() {
    }

    /* compiled from: TranslationUtil.java */
    /* renamed from: com.cnlaunch.x431pro.utils.d.h$a */
    /* loaded from: classes.dex */
    public static class C2754a {

        /* renamed from: a */
        private static final TranslationUtil f15766a = new TranslationUtil((byte) 0);

        /* renamed from: a */
        public static /* synthetic */ TranslationUtil m5066a() {
            return f15766a;
        }
    }

    /* renamed from: a */
    public final void m5067a(String str, InterfaceC2755b interfaceC2755b) {
        TranslateEntity translateEntity = new TranslateEntity();
        translateEntity.f10342q = str;
        translateEntity.target = LanguageSupport.getTargetLan();
        TranslateManager.getInstance().translate(translateEntity, false, new C2756i(this, interfaceC2755b));
    }
}
