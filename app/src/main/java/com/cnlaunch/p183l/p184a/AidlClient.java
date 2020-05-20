package com.cnlaunch.p183l.p184a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.cnlaunch.p183l.p185b.ILaunchAidlService;

/* renamed from: com.cnlaunch.l.a.a */
/* loaded from: classes.dex */
public final class AidlClient {

    /* renamed from: b */
    public Context f9520b;

    /* renamed from: a */
    String f9519a = "AidlClient";

    /* renamed from: c */
    public boolean f9521c = false;

    /* renamed from: d */
    public ILaunchAidlService f9522d = null;

    /* renamed from: e */
    public ServiceConnection f9523e = new ServiceConnectionC1796b(this);

    public AidlClient(Context context) {
        this.f9520b = context;
    }

    /* renamed from: a */
    public final boolean m8633a(String str, String str2, String str3) {
        if (this.f9520b == null) {
            this.f9521c = false;
            return false;
        }
        Intent intent = new Intent();
        intent.setAction(str);
        intent.setComponent(new ComponentName(str2, str3));
        this.f9521c = this.f9520b.getApplicationContext().bindService(intent, this.f9523e, 1);
        String str4 = this.f9519a;
        Log.i(str4, "bindService Service = " + str + " is " + this.f9521c);
        return this.f9521c;
    }
}
