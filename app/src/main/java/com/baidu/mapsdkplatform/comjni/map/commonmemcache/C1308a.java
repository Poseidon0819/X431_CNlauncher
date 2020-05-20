package com.baidu.mapsdkplatform.comjni.map.commonmemcache;

/* renamed from: com.baidu.mapsdkplatform.comjni.map.commonmemcache.a */
/* loaded from: classes.dex */
public class C1308a {

    /* renamed from: a */
    private long f6440a = 0;

    /* renamed from: b */
    private JNICommonMemCache f6441b;

    public C1308a() {
        this.f6441b = null;
        this.f6441b = new JNICommonMemCache();
    }

    /* renamed from: a */
    public long m9982a() {
        if (this.f6440a == 0) {
            this.f6440a = this.f6441b.Create();
        }
        return this.f6440a;
    }

    /* renamed from: b */
    public void m9981b() {
        long j = this.f6440a;
        if (j != 0) {
            this.f6441b.Init(j);
        }
    }
}
