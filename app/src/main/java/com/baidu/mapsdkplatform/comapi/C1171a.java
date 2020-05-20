package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.util.C1304e;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comjni.tools.C1312a;

/* renamed from: com.baidu.mapsdkplatform.comapi.a */
/* loaded from: classes.dex */
public class C1171a implements PermissionCheck.InterfaceC1297c {

    /* renamed from: a */
    private static final String f5821a = "a";

    /* renamed from: f */
    private static C1171a f5822f = null;

    /* renamed from: g */
    private static int f5823g = -100;

    /* renamed from: b */
    private Context f5824b;

    /* renamed from: c */
    private Handler f5825c;

    /* renamed from: d */
    private C1189c f5826d;

    /* renamed from: e */
    private int f5827e;

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        C1312a.m9960b();
    }

    private C1171a() {
    }

    /* renamed from: a */
    public static C1171a m10862a() {
        if (f5822f == null) {
            f5822f = new C1171a();
        }
        return f5822f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10860a(Message message2) {
        Intent intent;
        if (message2.what == 2012) {
            if (message2.arg1 == 0) {
                intent = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK);
            } else {
                Intent intent2 = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
                intent2.putExtra(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, message2.arg1);
                intent2.putExtra(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, (String) message2.obj);
                intent = intent2;
            }
            this.f5824b.sendBroadcast(intent);
            return;
        }
        if (message2.arg2 == 3) {
            this.f5824b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
        }
        if (message2.arg2 == 2 || message2.arg2 == 404 || message2.arg2 == 5 || message2.arg2 == 8) {
            this.f5824b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
        }
    }

    /* renamed from: f */
    private void m10854f() {
        C1189c c1189c;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        Context context = this.f5824b;
        if (context == null || (c1189c = this.f5826d) == null) {
            return;
        }
        context.registerReceiver(c1189c, intentFilter);
    }

    /* renamed from: g */
    private void m10853g() {
        Context context;
        C1189c c1189c = this.f5826d;
        if (c1189c == null || (context = this.f5824b) == null) {
            return;
        }
        context.unregisterReceiver(c1189c);
    }

    /* renamed from: a */
    public void m10861a(Context context) {
        this.f5824b = context;
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.InterfaceC1297c
    /* renamed from: a */
    public void mo10103a(PermissionCheck.C1296b c1296b) {
        if (c1296b == null) {
            return;
        }
        if (c1296b.f6374a == 0) {
            C1304e.f6430z = c1296b.f6378e;
            C1304e.m10072a(c1296b.f6375b, c1296b.f6376c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + c1296b.toString());
        }
        if (this.f5825c == null || c1296b.f6374a == f5823g) {
            return;
        }
        f5823g = c1296b.f6374a;
        Message obtainMessage = this.f5825c.obtainMessage();
        obtainMessage.what = 2012;
        obtainMessage.arg1 = c1296b.f6374a;
        obtainMessage.obj = c1296b.f6377d;
        this.f5825c.sendMessage(obtainMessage);
    }

    /* renamed from: b */
    public void m10858b() {
        if (this.f5827e == 0) {
            if (this.f5824b == null) {
                throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            this.f5826d = new C1189c();
            m10854f();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.f5824b);
        }
        this.f5827e++;
    }

    /* renamed from: c */
    public boolean m10857c() {
        if (this.f5824b != null) {
            this.f5825c = new Handler() { // from class: com.baidu.mapsdkplatform.comapi.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message2) {
                    C1171a.this.m10860a(message2);
                }
            };
            C1304e.m10070b(this.f5824b);
            C1304e.m10063f();
            PermissionCheck.init(this.f5824b);
            PermissionCheck.setPermissionCheckResultListener(this);
            PermissionCheck.permissionCheck();
            return true;
        }
        throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }

    /* renamed from: d */
    public void m10856d() {
        this.f5827e--;
        if (this.f5827e == 0) {
            m10853g();
            C1304e.m10075a();
        }
    }

    /* renamed from: e */
    public Context m10855e() {
        Context context = this.f5824b;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }
}
