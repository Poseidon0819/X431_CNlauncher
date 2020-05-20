package com.cnlaunch.golo3.p165g;

import com.cnlaunch.golo3.p160b.ApplicationConfig;
import java.util.ArrayList;

/* compiled from: PropertyObservable.java */
/* renamed from: com.cnlaunch.golo3.g.q */
/* loaded from: classes.dex */
public class C1619q {

    /* renamed from: a */
    public C1617n<Integer, InterfaceC1618p> f8480a = new C1617n<>();

    /* renamed from: a */
    private void m9125a(Object obj, int i, Object... objArr) {
        synchronized (this) {
            C1617n<Integer, InterfaceC1618p> c1617n = this.f8480a;
            ArrayList<InterfaceC1618p> arrayList = c1617n.f8479a.get(Integer.valueOf(i));
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            InterfaceC1618p[] interfaceC1618pArr = new InterfaceC1618p[size];
            arrayList.toArray(interfaceC1618pArr);
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC1618p interfaceC1618p = interfaceC1618pArr[i2];
                if (interfaceC1618p != null) {
                    try {
                        ApplicationConfig.f7805d.post(new RunnableC1620r(this, interfaceC1618p, obj, i, objArr));
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m9126a(int i, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            m9125a(this, i, objArr);
        } else {
            m9125a(this, i, new Object[0]);
        }
    }
}
