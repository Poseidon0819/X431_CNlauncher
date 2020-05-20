package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.login.ad */
/* loaded from: classes.dex */
public class NetworkBase implements OnDataListener {

    /* renamed from: a */
    private final String f13410a = NetworkBase.class.getSimpleName();

    /* renamed from: b */
    private AsyncTaskManager f13411b;

    /* renamed from: d */
    protected Context f13412d;

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        return null;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
    }

    public NetworkBase(Context context) {
        this.f13412d = context;
        this.f13411b = AsyncTaskManager.m9574a(this.f13412d);
    }

    /* renamed from: a */
    public final void m6553a(int i) {
        this.f13411b.m9575a(i, true, this);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i2 == -999) {
            NToast.m9450a(this.f13412d, (int) R.string.common_network_error);
        } else if (i2 == -400) {
            NToast.m9450a(this.f13412d, (int) R.string.common_network_unavailable);
        } else if (i2 != -200) {
        } else {
            NToast.m9450a(this.f13412d, (int) R.string.common_network_error);
        }
    }
}
