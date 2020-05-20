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
import com.unionpay.tsmservice.p373mi.UPTsmAddon;
import com.unionpay.tsmservice.p373mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.utils.C4644b;
import com.unionpay.utils.C4652j;
import com.unionpay.utils.UPUtils;

/* renamed from: com.unionpay.b.e */
/* loaded from: classes2.dex */
public final class C4131e {

    /* renamed from: a */
    private Context f22068a;

    /* renamed from: b */
    private UPQuerySEPayInfoCallback f22069b;

    /* renamed from: c */
    private UPTsmAddon f22070c;

    /* renamed from: f */
    private boolean f22073f;

    /* renamed from: g */
    private QueryVendorPayStatusRequestParams f22074g;

    /* renamed from: d */
    private String f22071d = "";

    /* renamed from: e */
    private String f22072e = "";

    /* renamed from: h */
    private final Handler.Callback f22075h = new C4132f(this);

    /* renamed from: i */
    private final Handler f22076i = new Handler(this.f22075h);

    /* renamed from: j */
    private final UPTsmAddon.UPTsmConnectionListener f22077j = new C4133g(this);

    public C4131e(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback, boolean z) {
        this.f22073f = false;
        this.f22068a = context;
        this.f22069b = uPQuerySEPayInfoCallback;
        this.f22073f = z;
        if (this.f22073f) {
            System.loadLibrary("entryexpro");
            String m473a = UPUtils.m473a(this.f22068a, "mode");
            m473a = m473a == null ? "" : m473a;
            try {
                Integer.decode(C4644b.m453e(m473a) ? m473a : "02").intValue();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1622a(C4131e c4131e, int i, String str) {
        if (i != 4000) {
            return;
        }
        c4131e.m1618a(c4131e.f22071d, c4131e.f22072e, UPSEInfoResp.ERROR_NOT_SUPPORT, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1621a(C4131e c4131e, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        Context context;
        c4131e.f22071d = bundle.getString("vendorPayName");
        c4131e.f22072e = bundle.getString("vendorPayAliasType");
        int i = bundle.getInt("vendorPayStatus");
        String string = bundle.getString("errorDesc");
        int i2 = bundle.getInt("cardNumber", 0);
        if (!TextUtils.isEmpty(c4131e.f22072e) && (context = c4131e.f22068a) != null) {
            UPUtils.m472a(context, c4131e.f22072e, "se_type");
        }
        switch (i) {
            case 0:
                if (i2 <= 0) {
                    str = c4131e.f22071d;
                    str2 = c4131e.f22072e;
                    str3 = UPSEInfoResp.ERROR_NOT_READY;
                    str4 = "card number 0";
                    break;
                } else {
                    String str5 = c4131e.f22071d;
                    String str6 = c4131e.f22072e;
                    c4131e.m1615c();
                    if (c4131e.f22073f) {
                        String[] strArr = {"name", "seType", "cardNumbers"};
                        String[] strArr2 = {str5, str6, String.valueOf(i2)};
                    }
                    UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = c4131e.f22069b;
                    if (uPQuerySEPayInfoCallback != null) {
                        uPQuerySEPayInfoCallback.onResult(str5, str6, i2, bundle);
                        return;
                    }
                    return;
                }
            case 1:
                str = c4131e.f22071d;
                str2 = c4131e.f22072e;
                str3 = UPSEInfoResp.ERROR_NOT_READY;
                str4 = "not ready";
                break;
            case 2:
            case 3:
            case 4:
                c4131e.m1618a(c4131e.f22071d, c4131e.f22072e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
                return;
            default:
                return;
        }
        c4131e.m1618a(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1618a(String str, String str2, String str3, String str4) {
        m1615c();
        if (this.f22073f) {
            String[] strArr = {"name", "seType", "errorCode", "errorDesp"};
            String[] strArr2 = {str, str2, str3, str4};
        }
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.f22069b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onError(str, str2, str3, str4);
        }
    }

    /* renamed from: a */
    private boolean m1619a(String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f22068a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageInfo != null) {
            C4652j.m433a("tsm-client", "tsm version code=" + packageInfo.versionCode);
            return packageInfo.versionCode >= 8;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ UPQuerySEPayInfoCallback m1616b(C4131e c4131e) {
        c4131e.f22069b = null;
        return null;
    }

    /* renamed from: c */
    private void m1615c() {
        UPTsmAddon uPTsmAddon = this.f22070c;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.f22077j);
            this.f22070c.unbind();
        }
    }

    /* renamed from: a */
    public final int m1624a() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.f22068a == null || this.f22069b == null) {
            return UPSEInfoResp.PARAM_ERROR;
        }
        if (m1619a("com.unionpay.tsmservice.mi")) {
            this.f22070c = UPTsmAddon.getInstance(this.f22068a);
            this.f22070c.addConnectionListener(this.f22077j);
            C4652j.m432b("uppay-spay", "type se  bind service");
            UPTsmAddon uPTsmAddon = this.f22070c;
            if (uPTsmAddon == null || uPTsmAddon.isConnected()) {
                UPTsmAddon uPTsmAddon2 = this.f22070c;
                if (uPTsmAddon2 != null && uPTsmAddon2.isConnected()) {
                    C4652j.m432b("uppay", "tsm service already connected");
                    m1617b();
                }
            } else {
                C4652j.m432b("uppay", "bind service");
                if (!this.f22070c.bind()) {
                    str = this.f22071d;
                    str2 = this.f22072e;
                    str3 = UPSEInfoResp.ERROR_NONE;
                    str4 = "Tsm service bind fail";
                }
            }
            return UPSEInfoResp.SUCCESS;
        } else if (C4644b.m455d(this.f22068a, "com.unionpay.tsmservice.mi")) {
            str = this.f22071d;
            str2 = this.f22072e;
            str3 = UPSEInfoResp.ERROR_NOT_SUPPORT;
            str4 = "Mi Tsm service apk version is low";
        } else {
            str = this.f22071d;
            str2 = this.f22072e;
            str3 = UPSEInfoResp.ERROR_TSM_UNINSTALLED;
            str4 = "Mi Tsm service apk is not installed";
        }
        m1618a(str, str2, str3, str4);
        return UPSEInfoResp.SUCCESS;
    }

    /* renamed from: b */
    public final boolean m1617b() {
        try {
            C4652j.m432b("uppay", "getVendorPayStatus()");
            if (this.f22074g == null) {
                this.f22074g = new QueryVendorPayStatusRequestParams();
            }
            if (this.f22070c.queryVendorPayStatus(this.f22074g, new BinderC4134h(this.f22076i)) == 0) {
                this.f22076i.sendMessageDelayed(Message.obtain(this.f22076i, 4, UIMsg.m_AppUI.MSG_APP_SAVESCREEN, 0, ""), 5000L);
                return true;
            }
            C4652j.m432b("uppay", "ret != 0");
            m1618a(this.f22071d, this.f22072e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Mi Tsm service apk version is low");
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
