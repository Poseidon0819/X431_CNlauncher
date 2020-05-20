package com.unionpay.p372b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.unionpay.UPQuerySEPayInfoCallback;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.utils.C4644b;
import com.unionpay.utils.C4652j;
import com.unionpay.utils.UPUtils;

/* renamed from: com.unionpay.b.b */
/* loaded from: classes2.dex */
public final class C4128b {

    /* renamed from: a */
    private Context f22056a;

    /* renamed from: b */
    private UPQuerySEPayInfoCallback f22057b;

    /* renamed from: c */
    private UPTsmAddon f22058c;

    /* renamed from: f */
    private boolean f22061f;

    /* renamed from: g */
    private QueryVendorPayStatusRequestParams f22062g;

    /* renamed from: d */
    private String f22059d = "";

    /* renamed from: e */
    private String f22060e = "";

    /* renamed from: h */
    private final Handler.Callback f22063h = new C4129c(this);

    /* renamed from: i */
    private final Handler f22064i = new Handler(this.f22063h);

    /* renamed from: j */
    private final UPTsmAddon.UPTsmConnectionListener f22065j = new C4130d(this);

    public C4128b(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback, boolean z) {
        this.f22061f = false;
        this.f22056a = context;
        this.f22057b = uPQuerySEPayInfoCallback;
        this.f22061f = z;
        if (this.f22061f) {
            System.loadLibrary("entryexpro");
            String m473a = UPUtils.m473a(this.f22056a, "mode");
            m473a = m473a == null ? "" : m473a;
            try {
                Integer.decode(C4644b.m453e(m473a) ? m473a : "02").intValue();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1634a(C4128b c4128b, int i, String str) {
        if (i != 4000) {
            return;
        }
        c4128b.m1630a(c4128b.f22059d, c4128b.f22060e, UPSEInfoResp.ERROR_NOT_SUPPORT, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1633a(C4128b c4128b, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        Context context;
        c4128b.f22059d = bundle.getString("vendorPayName");
        c4128b.f22060e = bundle.getString("vendorPayAliasType");
        int i = bundle.getInt("vendorPayStatus");
        String string = bundle.getString("errorDesc");
        int i2 = bundle.getInt("cardNumber", 0);
        if (!TextUtils.isEmpty(c4128b.f22060e) && (context = c4128b.f22056a) != null) {
            UPUtils.m472a(context, c4128b.f22060e, "se_type");
        }
        switch (i) {
            case 0:
                if (i2 <= 0) {
                    str = c4128b.f22059d;
                    str2 = c4128b.f22060e;
                    str3 = UPSEInfoResp.ERROR_NOT_READY;
                    str4 = "card number 0";
                    break;
                } else {
                    String str5 = c4128b.f22059d;
                    String str6 = c4128b.f22060e;
                    c4128b.m1627c();
                    if (c4128b.f22061f) {
                        String[] strArr = {"name", "seType", "cardNumbers"};
                        String[] strArr2 = {str5, str6, String.valueOf(i2)};
                    }
                    UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = c4128b.f22057b;
                    if (uPQuerySEPayInfoCallback != null) {
                        uPQuerySEPayInfoCallback.onResult(str5, str6, i2, bundle);
                        return;
                    }
                    return;
                }
            case 1:
                str = c4128b.f22059d;
                str2 = c4128b.f22060e;
                str3 = UPSEInfoResp.ERROR_NOT_READY;
                str4 = "not ready";
                break;
            case 2:
            case 3:
            case 4:
                c4128b.m1630a(c4128b.f22059d, c4128b.f22060e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
                return;
            default:
                return;
        }
        c4128b.m1630a(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1630a(String str, String str2, String str3, String str4) {
        m1627c();
        if (this.f22061f) {
            String[] strArr = {"name", "seType", "errorCode", "errorDesp"};
            String[] strArr2 = {str, str2, str3, str4};
        }
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.f22057b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onError(str, str2, str3, str4);
        }
    }

    /* renamed from: a */
    private boolean m1631a(String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f22056a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageInfo != null) {
            C4652j.m433a("tsm-client", "tsm version code=" + packageInfo.versionCode);
            return packageInfo.versionCode >= 18;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ UPQuerySEPayInfoCallback m1628b(C4128b c4128b) {
        c4128b.f22057b = null;
        return null;
    }

    /* renamed from: c */
    private void m1627c() {
        UPTsmAddon uPTsmAddon = this.f22058c;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.f22065j);
            this.f22058c.unbind();
        }
    }

    /* renamed from: a */
    public final int m1636a() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.f22056a == null || this.f22057b == null) {
            return UPSEInfoResp.PARAM_ERROR;
        }
        if (m1631a("com.unionpay.tsmservice")) {
            this.f22058c = UPTsmAddon.getInstance(this.f22056a);
            this.f22058c.addConnectionListener(this.f22065j);
            C4652j.m432b("uppay-spay", "type se  bind service");
            UPTsmAddon uPTsmAddon = this.f22058c;
            if (uPTsmAddon == null || uPTsmAddon.isConnected()) {
                UPTsmAddon uPTsmAddon2 = this.f22058c;
                if (uPTsmAddon2 != null && uPTsmAddon2.isConnected()) {
                    C4652j.m432b("uppay", "tsm service already connected");
                    m1629b();
                }
            } else {
                C4652j.m432b("uppay", "bind service");
                if (!this.f22058c.bind()) {
                    str = this.f22059d;
                    str2 = this.f22060e;
                    str3 = UPSEInfoResp.ERROR_NONE;
                    str4 = "Tsm service bind fail";
                }
            }
            return UPSEInfoResp.SUCCESS;
        } else if (C4644b.m455d(this.f22056a, "com.unionpay.tsmservice")) {
            str = this.f22059d;
            str2 = this.f22060e;
            str3 = UPSEInfoResp.ERROR_NOT_SUPPORT;
            str4 = "Tsm service apk version is low";
        } else {
            str = this.f22059d;
            str2 = this.f22060e;
            str3 = UPSEInfoResp.ERROR_TSM_UNINSTALLED;
            str4 = "Tsm service apk is not installed";
        }
        m1630a(str, str2, str3, str4);
        return UPSEInfoResp.SUCCESS;
    }

    /* renamed from: b */
    public final boolean m1629b() {
        try {
            C4652j.m432b("uppay", "getVendorPayStatus()");
            if (this.f22062g == null) {
                this.f22062g = new QueryVendorPayStatusRequestParams();
            }
            if (this.f22058c.queryVendorPayStatus(this.f22062g, new BinderC4127a(this.f22064i)) == 0) {
                this.f22064i.sendMessageDelayed(Message.obtain(this.f22064i, 4, UIMsg.m_AppUI.MSG_APP_SAVESCREEN, 0, ""), 5000L);
                return true;
            }
            C4652j.m432b("uppay", "ret != 0");
            m1630a(this.f22059d, this.f22060e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Tsm service apk version is low");
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
