package com.cnlaunch.golo3.p165g;

import com.cnlaunch.golo3.p160b.GoloCacheManager;
import java.util.ArrayList;

/* compiled from: Event.java */
/* renamed from: com.cnlaunch.golo3.g.g */
/* loaded from: classes.dex */
public abstract class AbstractC1613g {

    /* renamed from: a */
    private ArrayList<AbstractC1614h> f8467a = GoloCacheManager.f7828a;

    /* renamed from: a */
    public final void m9144a() {
        for (int size = this.f8467a.size() - 1; size >= 0; size--) {
            if (this.f8467a.get(size) != null) {
                AbstractC1614h abstractC1614h = this.f8467a.get(size);
                abstractC1614h.f8468a.post(new RunnableC1615i(abstractC1614h, this));
            }
        }
    }
}
