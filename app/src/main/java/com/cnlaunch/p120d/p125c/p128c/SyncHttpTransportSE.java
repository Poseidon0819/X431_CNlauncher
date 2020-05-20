package com.cnlaunch.p120d.p125c.p128c;

import java.io.IOException;
import org.p388a.p390b.HttpTransportSE;
import org.p388a.p390b.ServiceConnection;
import org.p388a.p390b.ServiceConnectionSE;

/* renamed from: com.cnlaunch.d.c.c.p */
/* loaded from: classes.dex */
public final class SyncHttpTransportSE extends HttpTransportSE {

    /* renamed from: i */
    private int f7176i;

    public SyncHttpTransportSE(String str, int i) {
        super(str);
        this.f7176i = 30000;
        this.f7176i = i;
    }

    @Override // org.p388a.p390b.HttpTransportSE
    /* renamed from: a */
    public final ServiceConnection mo143a() throws IOException {
        return new ServiceConnectionSE(this.f24135b, this.f7176i);
    }
}
