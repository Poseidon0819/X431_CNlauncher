package com.cnlaunch.golo3.p165g;

import com.cnlaunch.golo3.p164f.Event;
import java.util.ArrayList;

/* compiled from: CompressImgManager.java */
/* renamed from: com.cnlaunch.golo3.g.e */
/* loaded from: classes.dex */
final class RunnableC1612e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f8451a;

    /* renamed from: b */
    final /* synthetic */ RunnableC1611d f8452b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1612e(RunnableC1611d runnableC1611d, ArrayList arrayList) {
        this.f8452b = runnableC1611d;
        this.f8451a = arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.ArrayList, Result] */
    @Override // java.lang.Runnable
    public final void run() {
        Event<?> event = new Event<>("");
        event.f8437a = this.f8451a;
        this.f8452b.f8449b.mo6055a(event);
    }
}
