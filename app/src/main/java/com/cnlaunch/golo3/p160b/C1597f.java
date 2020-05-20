package com.cnlaunch.golo3.p160b;

import com.cnlaunch.golo3.p165g.ThreadPoolManager;
import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;

/* compiled from: InterfaceDao.java */
/* renamed from: com.cnlaunch.golo3.b.f */
/* loaded from: classes.dex */
public final class C1597f extends RequestCallBack<String> {

    /* renamed from: a */
    final /* synthetic */ Long f8399a;

    /* renamed from: b */
    final /* synthetic */ String f8400b;

    /* renamed from: c */
    final /* synthetic */ SearchCallBack f8401c;

    /* renamed from: d */
    final /* synthetic */ InterfaceDao f8402d;

    public C1597f(InterfaceDao interfaceDao, Long l, String str, SearchCallBack searchCallBack) {
        this.f8402d = interfaceDao;
        this.f8399a = l;
        this.f8400b = str;
        this.f8401c = searchCallBack;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<String> responseInfo) {
        ThreadPoolManager.m9119a(InterfaceDao.class.getName()).m9120a(new RunnableC1598g(this, responseInfo));
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        this.f8401c.mo251b();
    }
}
