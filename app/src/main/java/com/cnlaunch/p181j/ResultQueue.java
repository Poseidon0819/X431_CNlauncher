package com.cnlaunch.p181j;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.j.aa */
/* loaded from: classes.dex */
public abstract class ResultQueue {

    /* renamed from: b */
    List<ExplainResult> f9418b = null;

    /* renamed from: c */
    public String f9419c = null;

    /* renamed from: d */
    int f9420d = 0;

    /* renamed from: e */
    ExplainResult f9421e = new ExplainResult(0, 0);

    /* renamed from: a */
    public abstract void mo8653a(int i, ExplainResult explainResult);

    /* renamed from: a */
    abstract boolean mo8652a(ExplainResult explainResult);

    /* renamed from: a */
    public final int m8685a() {
        Log.i("Sanda", "OnResultListener getVersion()=" + this.f9420d);
        return this.f9420d;
    }

    /* renamed from: a */
    public final void m8684a(String str) {
        this.f9419c = str;
        this.f9418b = new ArrayList();
    }

    /* renamed from: b */
    public final boolean m8683b() {
        List<ExplainResult> list = this.f9418b;
        return list == null || list.size() == 0;
    }

    /* renamed from: c */
    public final void m8681c() {
        List<ExplainResult> list = this.f9418b;
        if (list != null) {
            list.clear();
            this.f9418b = null;
        }
        this.f9419c = null;
        this.f9420d = 0;
    }

    /* renamed from: b */
    public final void m8682b(ExplainResult explainResult) {
        if (explainResult.getModel() == 0) {
            this.f9418b.add(explainResult);
        } else if (mo8652a(explainResult)) {
            Log.i("Sanda", "put " + explainResult.toString());
            if (this.f9418b == null) {
                m8684a(explainResult.f9478id);
            }
            this.f9418b.add(explainResult);
        }
    }
}
