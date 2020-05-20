package com.cnlaunch.x431pro.module.p252d;

import android.content.Context;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteServiceInfoResponse;

/* renamed from: com.cnlaunch.x431pro.module.d.b */
/* loaded from: classes.dex */
public final class RemoteDiagAction extends BaseAction {
    public RemoteDiagAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final RemoteServiceInfoResponse m5362a(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6852az);
        this.f15440b = m5452b();
        this.f15440b.m9506a("target_user_id", str);
        String m9477a = this.f15446f.m9477a(m5455a(b, this.f15440b), this.f15440b);
        RemoteServiceInfoResponse remoteServiceInfoResponse = m9477a != null ? (RemoteServiceInfoResponse) m5438a(m9477a, RemoteServiceInfoResponse.class) : null;
        NLog.m9456a("Sanda", "json=".concat(String.valueOf(m9477a)));
        return remoteServiceInfoResponse;
    }
}
