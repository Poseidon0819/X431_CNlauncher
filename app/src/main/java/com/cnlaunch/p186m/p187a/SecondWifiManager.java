package com.cnlaunch.p186m.p187a;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.cnlaunch.p186m.p187a.ISecondWifiService;

/* renamed from: com.cnlaunch.m.a.b */
/* loaded from: classes.dex */
public final class SecondWifiManager {

    /* renamed from: a */
    public static boolean f9527a = true;

    /* renamed from: b */
    private ISecondWifiService f9528b = ISecondWifiService.AbstractBinderC1799a.m8630a(ServiceManager.getService("second_wifi_service"));

    /* renamed from: a */
    public static SecondWifiManager m8617a() {
        return new SecondWifiManager();
    }

    public SecondWifiManager() {
        if (this.f9528b != null) {
            Log.d("SecondWifiManager", "The ISecondWifiService object is ready.");
        }
    }

    /* renamed from: b */
    public final boolean m8613b() throws RemoteException {
        if (f9527a) {
            Log.d("SecondWifiManager", "addIpRule");
        }
        return this.f9528b.mo8629a();
    }

    /* renamed from: c */
    public final boolean m8611c() throws RemoteException {
        if (f9527a) {
            Log.d("SecondWifiManager", "deleteIpRule ");
        }
        return this.f9528b.mo8625b();
    }

    /* renamed from: a */
    public final boolean m8615a(String str, String str2) throws RemoteException {
        if (f9527a) {
            Log.d("SecondWifiManager", String.format("addIpRouteForIPV4 ipMask=%s ipForFirstRoute=%s", str, str2));
        }
        return this.f9528b.mo8627a(str, str2);
    }

    /* renamed from: a */
    public final boolean m8616a(String str) throws RemoteException {
        if (f9527a) {
            Log.d("SecondWifiManager", String.format("setStaticIP ip=%s ", str));
        }
        return this.f9528b.mo8628a(str);
    }

    /* renamed from: b */
    public final String m8612b(String str) throws RemoteException {
        if (f9527a) {
            Log.d("SecondWifiManager", String.format("getCurrentState bssid=%s", str));
        }
        return this.f9528b.mo8624b(str);
    }

    /* renamed from: a */
    public final boolean m8614a(boolean z) throws RemoteException {
        if (f9527a) {
            Log.d("SecondWifiManager", String.format("setWifiEnabled enabled=%b ", Boolean.valueOf(z)));
        }
        return this.f9528b.mo8626a(z);
    }

    /* renamed from: d */
    public final boolean m8609d() throws RemoteException {
        if (f9527a) {
            Log.d("SecondWifiManager", "getWifiEnabled()");
        }
        return this.f9528b.mo8619d();
    }

    /* renamed from: c */
    public final String m8610c(String str) throws RemoteException {
        if (f9527a) {
            Log.d("SecondWifiManager", String.format("doCustomSupplicantCommand command=%s", str));
        }
        return this.f9528b.mo8620c(str);
    }

    /* renamed from: e */
    public final int m8608e() throws RemoteException {
        if (f9527a) {
            Log.d("SecondWifiManager", "getInternalReleaseVersionCode");
        }
        return this.f9528b.mo8618e();
    }
}
