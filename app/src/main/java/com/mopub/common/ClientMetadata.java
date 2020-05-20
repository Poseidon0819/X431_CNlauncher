package com.mopub.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.cnlaunch.physics.PAD3DHCPForDoIP;
import com.itextpdf.text.html.HtmlTags;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import java.util.Locale;

/* loaded from: classes.dex */
public class ClientMetadata {

    /* renamed from: k */
    private static volatile ClientMetadata f19988k;

    /* renamed from: a */
    private String f19989a;

    /* renamed from: b */
    private final String f19990b;

    /* renamed from: c */
    private String f19991c;

    /* renamed from: d */
    private final String f19992d;

    /* renamed from: e */
    private final String f19993e;

    /* renamed from: f */
    private String f19994f;

    /* renamed from: g */
    private String f19995g;

    /* renamed from: h */
    private String f19996h;

    /* renamed from: i */
    private boolean f19997i = false;

    /* renamed from: j */
    private boolean f19998j = false;

    /* renamed from: l */
    private final String f19999l = Build.MANUFACTURER;

    /* renamed from: m */
    private final String f20000m = Build.MODEL;

    /* renamed from: n */
    private final String f20001n = Build.PRODUCT;

    /* renamed from: o */
    private final String f20002o = Build.VERSION.RELEASE;

    /* renamed from: p */
    private final String f20003p = "4.11.0";

    /* renamed from: q */
    private final String f20004q;

    /* renamed from: r */
    private final String f20005r;

    /* renamed from: s */
    private String f20006s;

    /* renamed from: t */
    private final Context f20007t;

    /* renamed from: u */
    private final ConnectivityManager f20008u;

    /* loaded from: classes.dex */
    public enum MoPubNetworkType {
        UNKNOWN(0),
        ETHERNET(1),
        WIFI(2),
        MOBILE(3);
        
        private final int mId;

        MoPubNetworkType(int i) {
            this.mId = i;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return Integer.toString(this.mId);
        }

        public final int getId() {
            return this.mId;
        }

        static /* synthetic */ MoPubNetworkType access$000(int i) {
            if (i == 9) {
                return ETHERNET;
            }
            switch (i) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                    return MOBILE;
                case 1:
                    return WIFI;
                default:
                    return UNKNOWN;
            }
        }
    }

    public static ClientMetadata getInstance(Context context) {
        ClientMetadata clientMetadata = f19988k;
        if (clientMetadata == null) {
            synchronized (ClientMetadata.class) {
                clientMetadata = f19988k;
                if (clientMetadata == null) {
                    clientMetadata = new ClientMetadata(context);
                    f19988k = clientMetadata;
                }
            }
        }
        return clientMetadata;
    }

    public static ClientMetadata getInstance() {
        ClientMetadata clientMetadata = f19988k;
        if (clientMetadata == null) {
            synchronized (ClientMetadata.class) {
                clientMetadata = f19988k;
            }
        }
        return clientMetadata;
    }

    public ClientMetadata(Context context) {
        ApplicationInfo applicationInfo;
        this.f20007t = context.getApplicationContext();
        this.f20008u = (ConnectivityManager) this.f20007t.getSystemService("connectivity");
        this.f20004q = m2603a(this.f20007t);
        PackageManager packageManager = this.f20007t.getPackageManager();
        this.f20005r = context.getPackageName();
        try {
            applicationInfo = packageManager.getApplicationInfo(this.f20005r, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            this.f20006s = (String) packageManager.getApplicationLabel(applicationInfo);
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.f20007t.getSystemService("phone");
        this.f19989a = telephonyManager.getNetworkOperator();
        this.f19990b = telephonyManager.getNetworkOperator();
        if (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) {
            this.f19989a = telephonyManager.getSimOperator();
            this.f19991c = telephonyManager.getSimOperator();
        }
        this.f19992d = telephonyManager.getNetworkCountryIso();
        this.f19993e = telephonyManager.getSimCountryIso();
        try {
            this.f19994f = telephonyManager.getNetworkOperatorName();
            if (telephonyManager.getSimState() == 5) {
                this.f19995g = telephonyManager.getSimOperatorName();
            }
        } catch (SecurityException unused2) {
            this.f19994f = null;
            this.f19995g = null;
        }
        String string = Settings.Secure.getString(this.f20007t.getContentResolver(), "android_id");
        this.f19996h = "sha:".concat(String.valueOf(string == null ? "" : Utils.sha1(string)));
    }

    /* renamed from: a */
    private static String m2603a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            MoPubLog.m2498d("Failed to retrieve PackageInfo#versionName.");
            return null;
        }
    }

    public String getOrientationString() {
        int i = this.f20007t.getResources().getConfiguration().orientation;
        return i == 1 ? HtmlTags.f19632P : i == 2 ? PAD3DHCPForDoIP.f10141a : i == 3 ? HtmlTags.f19633S : HtmlTags.f19637U;
    }

    public MoPubNetworkType getActiveNetworkType() {
        NetworkInfo activeNetworkInfo;
        int i = -1;
        if (DeviceUtils.isPermissionGranted(this.f20007t, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = this.f20008u.getActiveNetworkInfo()) != null) {
            i = activeNetworkInfo.getType();
        }
        return MoPubNetworkType.access$000(i);
    }

    public float getDensity() {
        return this.f20007t.getResources().getDisplayMetrics().density;
    }

    public String getNetworkOperatorForUrl() {
        return this.f19989a;
    }

    public String getNetworkOperator() {
        return this.f19990b;
    }

    public Locale getDeviceLocale() {
        return this.f20007t.getResources().getConfiguration().locale;
    }

    public String getSimOperator() {
        return this.f19991c;
    }

    public String getIsoCountryCode() {
        return this.f19992d;
    }

    public String getSimIsoCountryCode() {
        return this.f19993e;
    }

    public String getNetworkOperatorName() {
        return this.f19994f;
    }

    public String getSimOperatorName() {
        return this.f19995g;
    }

    public synchronized String getDeviceId() {
        return this.f19996h;
    }

    public synchronized boolean isDoNotTrackSet() {
        return this.f19997i;
    }

    public synchronized void setAdvertisingInfo(String str, boolean z) {
        this.f19996h = "ifa:".concat(String.valueOf(str));
        this.f19997i = z;
        this.f19998j = true;
    }

    public synchronized boolean isAdvertisingInfoSet() {
        return this.f19998j;
    }

    public String getDeviceManufacturer() {
        return this.f19999l;
    }

    public String getDeviceModel() {
        return this.f20000m;
    }

    public String getDeviceProduct() {
        return this.f20001n;
    }

    public String getDeviceOsVersion() {
        return this.f20002o;
    }

    public int getDeviceScreenWidthDip() {
        return Dips.screenWidthAsIntDips(this.f20007t);
    }

    public int getDeviceScreenHeightDip() {
        return Dips.screenHeightAsIntDips(this.f20007t);
    }

    public Point getDeviceDimensions() {
        if (Preconditions.NoThrow.checkNotNull(this.f20007t)) {
            return DeviceUtils.getDeviceDimensions(this.f20007t);
        }
        return new Point(0, 0);
    }

    public String getSdkVersion() {
        return this.f20003p;
    }

    public String getAppVersion() {
        return this.f20004q;
    }

    public String getAppPackageName() {
        return this.f20005r;
    }

    public String getAppName() {
        return this.f20006s;
    }

    @VisibleForTesting
    @Deprecated
    public static void setInstance(ClientMetadata clientMetadata) {
        synchronized (ClientMetadata.class) {
            f19988k = clientMetadata;
        }
    }

    @VisibleForTesting
    public static void clearForTesting() {
        f19988k = null;
    }
}
