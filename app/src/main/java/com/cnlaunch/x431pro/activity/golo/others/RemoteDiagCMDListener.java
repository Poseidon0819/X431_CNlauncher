package com.cnlaunch.x431pro.activity.golo.others;

import android.content.Context;
import com.cnlaunch.x431pro.module.golo.p262a.GoloAction;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.cnlaunch.x431pro.activity.golo.others.k */
/* loaded from: classes.dex */
public abstract class RemoteDiagCMDListener {

    /* renamed from: a */
    GoloAction f12688a;

    /* renamed from: b */
    public ExecutorService f12689b;

    /* renamed from: c */
    private Context f12690c;

    /* renamed from: d */
    private final String f12691d = "Sanda";

    /* renamed from: a */
    public abstract String mo6956a();

    public RemoteDiagCMDListener(Context context) {
        this.f12688a = null;
        this.f12690c = null;
        this.f12689b = null;
        this.f12690c = context;
        this.f12689b = Executors.newSingleThreadExecutor();
        this.f12688a = new GoloAction(context);
    }
}
