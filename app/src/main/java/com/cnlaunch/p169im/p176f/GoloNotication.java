package com.cnlaunch.p169im.p176f;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.cnlaunch.im.f.b */
/* loaded from: classes.dex */
public final class GoloNotication {

    /* renamed from: a */
    public NotificationManager f9252a;

    /* renamed from: b */
    public Context f9253b;

    /* renamed from: c */
    public Set<Integer> f9254c = new HashSet();

    public GoloNotication(Context context) {
        this.f9252a = (NotificationManager) context.getSystemService("notification");
        this.f9253b = context;
    }

    /* renamed from: a */
    public final void m8734a(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (this.f9254c.remove(Integer.valueOf(i))) {
            this.f9252a.cancel(i);
        }
    }
}
