package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.mapsdkplatform.comjni.map.commonmemcache.C1308a;

/* loaded from: classes.dex */
public class SysUpdateUtil implements SysUpdateObserver {

    /* renamed from: a */
    static C1308a f5881a = new C1308a();

    /* renamed from: b */
    public static boolean f5882b = false;

    /* renamed from: c */
    public static String f5883c = "";

    /* renamed from: d */
    public static int f5884d = 0;

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void init() {
        C1308a c1308a = f5881a;
        if (c1308a != null) {
            c1308a.m9982a();
            f5881a.m9981b();
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updateNetworkInfo(Context context) {
        NetworkUtil.updateNetworkProxy(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ca, code lost:
        if ("10.0.0.200".equals(r8.trim()) != false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00db  */
    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateNetworkProxy(android.content.Context r8) {
        /*
            r7 = this;
            android.net.NetworkInfo r8 = com.baidu.mapapi.NetworkUtil.getActiveNetworkInfo(r8)
            if (r8 == 0) goto Lde
            boolean r0 = r8.isAvailable()
            if (r0 == 0) goto Lde
            java.lang.String r0 = r8.getTypeName()
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r1 = "wifi"
            boolean r1 = r0.equals(r1)
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L2a
            boolean r1 = r8.isConnected()
            if (r1 == 0) goto L2a
            com.baidu.mapsdkplatform.comjni.engine.AppEngine.SetProxyInfo(r2, r3)
            com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5882b = r3
            return
        L2a:
            java.lang.String r1 = "mobile"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L40
            java.lang.String r1 = "wifi"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lde
            boolean r0 = com.baidu.mapapi.NetworkUtil.isWifiConnected(r8)
            if (r0 != 0) goto Lde
        L40:
            java.lang.String r8 = r8.getExtraInfo()
            com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5882b = r3
            r0 = 80
            r1 = 1
            if (r8 == 0) goto L9d
            java.lang.String r8 = r8.toLowerCase()
            java.lang.String r4 = "cmwap"
            boolean r4 = r8.startsWith(r4)
            if (r4 != 0) goto L94
            java.lang.String r4 = "uniwap"
            boolean r4 = r8.startsWith(r4)
            if (r4 != 0) goto L94
            java.lang.String r4 = "3gwap"
            boolean r4 = r8.startsWith(r4)
            if (r4 == 0) goto L68
            goto L94
        L68:
            java.lang.String r4 = "ctwap"
            boolean r4 = r8.startsWith(r4)
            if (r4 == 0) goto L71
            goto Lcc
        L71:
            java.lang.String r0 = "cmnet"
            boolean r0 = r8.startsWith(r0)
            if (r0 != 0) goto L91
            java.lang.String r0 = "uninet"
            boolean r0 = r8.startsWith(r0)
            if (r0 != 0) goto L91
            java.lang.String r0 = "ctnet"
            boolean r0 = r8.startsWith(r0)
            if (r0 != 0) goto L91
            java.lang.String r0 = "3gnet"
            boolean r8 = r8.startsWith(r0)
            if (r8 == 0) goto Lcf
        L91:
            com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5882b = r3
            goto Lcf
        L94:
            java.lang.String r8 = "10.0.0.172"
        L96:
            com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5883c = r8
            com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5884d = r0
        L9a:
            com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5882b = r1
            goto Lcf
        L9d:
            java.lang.String r8 = android.net.Proxy.getDefaultHost()
            int r4 = android.net.Proxy.getDefaultPort()
            if (r8 == 0) goto Lcf
            int r5 = r8.length()
            if (r5 <= 0) goto Lcf
            java.lang.String r5 = "10.0.0.172"
            java.lang.String r6 = r8.trim()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto Lc0
            java.lang.String r8 = "10.0.0.172"
            com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5883c = r8
            com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5884d = r4
            goto L9a
        Lc0:
            java.lang.String r4 = "10.0.0.200"
            java.lang.String r8 = r8.trim()
            boolean r8 = r4.equals(r8)
            if (r8 == 0) goto Lcf
        Lcc:
            java.lang.String r8 = "10.0.0.200"
            goto L96
        Lcf:
            boolean r8 = com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5882b
            if (r8 != r1) goto Ldb
            java.lang.String r8 = com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5883c
            int r0 = com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.f5884d
            com.baidu.mapsdkplatform.comjni.engine.AppEngine.SetProxyInfo(r8, r0)
            return
        Ldb:
            com.baidu.mapsdkplatform.comjni.engine.AppEngine.SetProxyInfo(r2, r3)
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.updateNetworkProxy(android.content.Context):void");
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver
    public void updatePhoneInfo() {
        C1308a c1308a = f5881a;
        if (c1308a != null) {
            c1308a.m9981b();
        }
    }
}
