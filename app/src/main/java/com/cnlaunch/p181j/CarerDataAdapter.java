package com.cnlaunch.p181j;

import android.content.Context;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;

/* renamed from: com.cnlaunch.j.a */
/* loaded from: classes.dex */
public final class CarerDataAdapter implements SocketDataAdapter {

    /* renamed from: a */
    private Context f9417a;

    public CarerDataAdapter(Context context) {
        this.f9417a = null;
        this.f9417a = context;
    }

    @Override // com.cnlaunch.p181j.SocketDataAdapter
    /* renamed from: a */
    public final void mo8677a(int i) {
        DiagnoseBusiness.getInstance(this.f9417a).sendRemoteDiagStatus(i);
    }

    @Override // com.cnlaunch.p181j.SocketDataAdapter
    /* renamed from: a */
    public final void mo8676a(String str) {
        DiagnoseBusiness.getInstance(this.f9417a).feekbackDataRemote(str);
    }
}
