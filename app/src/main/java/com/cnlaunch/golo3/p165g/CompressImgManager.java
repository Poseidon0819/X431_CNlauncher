package com.cnlaunch.golo3.p165g;

import android.os.Handler;
import android.os.Looper;
import com.cnlaunch.golo3.p164f.EventListener;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.golo3.g.c */
/* loaded from: classes.dex */
public class CompressImgManager {

    /* renamed from: a */
    private Handler f8447a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public final void m9147a(ArrayList<String> arrayList, EventListener eventListener) {
        ThreadPoolManager.m9119a(CompressImgManager.class.getName()).m9120a(new RunnableC1611d(this, arrayList, eventListener));
    }
}
