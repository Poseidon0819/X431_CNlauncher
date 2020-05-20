package com.cnlaunch.golo3.p165g;

import android.os.Handler;
import com.cnlaunch.golo3.p164f.EventListener;
import com.cnlaunch.golo3.view.selectimg.p166a.ThumbnailsUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CompressImgManager.java */
/* renamed from: com.cnlaunch.golo3.g.d */
/* loaded from: classes.dex */
public final class RunnableC1611d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ArrayList f8448a;

    /* renamed from: b */
    final /* synthetic */ EventListener f8449b;

    /* renamed from: c */
    final /* synthetic */ CompressImgManager f8450c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1611d(CompressImgManager compressImgManager, ArrayList arrayList, EventListener eventListener) {
        this.f8450c = compressImgManager;
        this.f8448a = arrayList;
        this.f8449b = eventListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f8448a.iterator();
        while (it.hasNext()) {
            arrayList.add(ThumbnailsUtil.m9060a((String) it.next()));
        }
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        handler = this.f8450c.f8447a;
        handler.post(new RunnableC1612e(this, arrayList));
    }
}
