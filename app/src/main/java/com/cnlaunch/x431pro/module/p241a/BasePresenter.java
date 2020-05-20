package com.cnlaunch.x431pro.module.p241a;

import android.content.Context;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.utils.C2778n;

/* renamed from: com.cnlaunch.x431pro.module.a.d */
/* loaded from: classes.dex */
public class BasePresenter implements OnDataListener {

    /* renamed from: a */
    protected Context f15451a;

    /* renamed from: b */
    protected AsyncTaskManager f15452b;

    /* renamed from: c */
    protected PresenterCallback f15453c;

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        return null;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
    }

    public BasePresenter(Context context) {
        this.f15451a = context;
    }

    /* renamed from: a */
    public final void m5435a() {
        if (!C2778n.m4917a(this.f15451a)) {
            PresenterCallback presenterCallback = this.f15453c;
            if (presenterCallback != null) {
                presenterCallback.mo5116a(1);
                return;
            }
            return;
        }
        if (this.f15452b == null) {
            this.f15452b = AsyncTaskManager.m9574a(this.f15451a);
        }
        this.f15452b.m9575a(100, true, this);
    }
}
