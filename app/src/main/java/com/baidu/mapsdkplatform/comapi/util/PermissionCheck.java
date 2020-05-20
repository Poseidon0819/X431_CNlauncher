package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.cnlaunch.p169im.p174db.MessageDao;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PermissionCheck {

    /* renamed from: a */
    private static final String f6366a = "PermissionCheck";

    /* renamed from: b */
    private static Context f6367b = null;

    /* renamed from: c */
    private static String f6368c = null;

    /* renamed from: d */
    private static Hashtable<String, String> f6369d = null;

    /* renamed from: e */
    private static LBSAuthManager f6370e = null;

    /* renamed from: f */
    private static LBSAuthManagerListener f6371f = null;

    /* renamed from: g */
    private static InterfaceC1297c f6372g = null;

    /* renamed from: h */
    private static int f6373h = 601;

    /* renamed from: com.baidu.mapsdkplatform.comapi.util.PermissionCheck$a */
    /* loaded from: classes.dex */
    static class C1295a implements LBSAuthManagerListener {
        private C1295a() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i, String str) {
            if (str == null) {
                Log.e(PermissionCheck.f6366a, "The result is null");
                Log.d(PermissionCheck.f6366a, "onAuthResult try permissionCheck result is: ".concat(String.valueOf(PermissionCheck.permissionCheck())));
                return;
            }
            C1296b c1296b = new C1296b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    c1296b.f6374a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    c1296b.f6376c = jSONObject.optString("appid");
                }
                if (jSONObject.has("uid")) {
                    c1296b.f6375b = jSONObject.optString("uid");
                }
                if (jSONObject.has(MessageDao.TABLENAME)) {
                    c1296b.f6377d = jSONObject.optString(MessageDao.TABLENAME);
                }
                if (jSONObject.has("token")) {
                    c1296b.f6378e = jSONObject.optString("token");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            int unused = PermissionCheck.f6373h = c1296b.f6374a;
            if (PermissionCheck.f6372g != null) {
                PermissionCheck.f6372g.mo10103a(c1296b);
            }
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.util.PermissionCheck$b */
    /* loaded from: classes.dex */
    public static class C1296b {

        /* renamed from: a */
        public int f6374a = 0;

        /* renamed from: b */
        public String f6375b = "-1";

        /* renamed from: c */
        public String f6376c = "-1";

        /* renamed from: d */
        public String f6377d = "";

        /* renamed from: e */
        public String f6378e;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", C1298a.m10102a(PermissionCheck.f6367b), PermissionCheck.f6368c, Integer.valueOf(this.f6374a), this.f6375b, this.f6376c, this.f6377d);
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.util.PermissionCheck$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1297c {
        /* renamed from: a */
        void mo10103a(C1296b c1296b);
    }

    public static void destory() {
        f6372g = null;
        f6367b = null;
        f6371f = null;
    }

    public static int getPermissionResult() {
        return f6373h;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        f6367b = context;
        try {
            applicationInfo = f6367b.getPackageManager().getApplicationInfo(f6367b.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            f6368c = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (f6369d == null) {
            f6369d = new Hashtable<>();
        }
        if (f6370e == null) {
            f6370e = LBSAuthManager.getInstance(f6367b);
        }
        if (f6371f == null) {
            f6371f = new C1295a();
        }
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(f6367b.getPackageName(), 0).applicationInfo.loadLabel(f6367b.getPackageManager()).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Bundle m10071b = C1304e.m10071b();
        if (m10071b != null) {
            f6369d.put("mb", m10071b.getString("mb"));
            f6369d.put("os", m10071b.getString("os"));
            f6369d.put("sv", m10071b.getString("sv"));
            f6369d.put("imt", "1");
            f6369d.put("net", m10071b.getString("net"));
            f6369d.put("cpu", m10071b.getString("cpu"));
            f6369d.put("glr", m10071b.getString("glr"));
            f6369d.put("glv", m10071b.getString("glv"));
            f6369d.put("resid", m10071b.getString("resid"));
            f6369d.put("appid", "-1");
            f6369d.put("ver", "1");
            f6369d.put("screen", String.format("(%d,%d)", Integer.valueOf(m10071b.getInt("screen_x")), Integer.valueOf(m10071b.getInt("screen_y"))));
            f6369d.put("dpi", String.format("(%d,%d)", Integer.valueOf(m10071b.getInt("dpi_x")), Integer.valueOf(m10071b.getInt("dpi_y"))));
            f6369d.put("pcn", m10071b.getString("pcn"));
            f6369d.put("cuid", m10071b.getString("cuid"));
            f6369d.put("name", str);
        }
    }

    public static synchronized int permissionCheck() {
        synchronized (PermissionCheck.class) {
            if (f6370e != null && f6371f != null && f6367b != null) {
                int authenticate = f6370e.authenticate(false, "lbs_androidsdk", f6369d, f6371f);
                if (authenticate != 0) {
                    Log.e(f6366a, "permission check result is: ".concat(String.valueOf(authenticate)));
                }
                return authenticate;
            }
            String str = f6366a;
            Log.e(str, "The authManager is: " + f6370e + "; the authCallback is: " + f6371f + "; the mContext is: " + f6367b);
            return 0;
        }
    }

    public static void setPermissionCheckResultListener(InterfaceC1297c interfaceC1297c) {
        f6372g = interfaceC1297c;
    }
}
