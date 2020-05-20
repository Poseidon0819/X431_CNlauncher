package com.unionpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.itextpdf.text.pdf.PdfWriter;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.p371a.C4121d;
import com.unionpay.p372b.C4128b;
import com.unionpay.p372b.C4131e;
import com.unionpay.tsmservice.p373mi.data.Constant;
import com.unionpay.utils.C4644b;
import com.unionpay.utils.C4647e;
import com.unionpay.utils.C4651i;
import com.unionpay.utils.C4652j;
import com.unionpay.utils.C4653k;
import com.unionpay.utils.UPUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UPPayAssistEx {

    /* renamed from: A */
    private static String f21980A = "";

    /* renamed from: B */
    private static String f21981B = "";

    /* renamed from: C */
    private static String f21982C = "";

    /* renamed from: D */
    private static String f21983D = "";

    /* renamed from: E */
    private static boolean f21984E = false;

    /* renamed from: F */
    private static int f21985F = 10;

    /* renamed from: G */
    private static Context f21986G = null;

    /* renamed from: H */
    private static String f21987H = "";

    /* renamed from: I */
    private static String f21988I = null;

    /* renamed from: J */
    private static String f21989J = null;

    /* renamed from: K */
    private static String f21990K = "";

    /* renamed from: L */
    private static String f21991L = "";

    /* renamed from: M */
    private static boolean f21992M = false;

    /* renamed from: N */
    private static String f21993N = "";

    /* renamed from: O */
    private static int f21994O = 0;

    /* renamed from: P */
    private static boolean f21995P = false;
    public static final int PLUGIN_NOT_FOUND = -1;
    public static final int PLUGIN_VALID = 0;

    /* renamed from: Q */
    private static C4121d f21996Q = null;

    /* renamed from: R */
    private static Handler f21997R = null;

    /* renamed from: S */
    private static String f21998S = "application/vnd.android.package-archive";

    /* renamed from: T */
    private static String f21999T = "http://mobile.unionpay.com/getclient?platform=android&type=securepayplugin";

    /* renamed from: U */
    private static String f22000U = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay\",\"version\":\"^[5-9]{1}+(.[0-9]{1})+(.[0-9]{1,3})?$\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":101}],\"need_install\":false,\"install_msg\":\"请先安装银联在线支付服务，安装完成后重新发起付款\",\"url\":\"https://mobile.unionpay.com/getclient?platform=android&type=securepayplugin\",\"download_app\":\"UPPayPluginEx.apk\",\"download_title\":\"银联在线支付服务\",\"download_desp\":\"正在下载银联在线支付服务…\",\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"},{\"type\":\"jar\",\"sort\":200}]";

    /* renamed from: V */
    private static String f22001V = "[{\"type\":\"app\",\"sort\":100,\"package_info\":[{\"schema\":\"com.unionpay.tsmservice\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[2-9].*|^01\\.00\\.1[012789].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":102},{\"schema\":\"com.unionpay.tsmservice.mi\",\"version\":\"^[1-9].*|^0[2-9].*|^01\\.[1-9].*|^01\\.0[1-9].*|^01\\.00\\.[1-9].*|^01\\.00\\.0[8-9].*\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":103}],\"need_install\":false,\"install_msg\":\"请先安装银联在线支付服务，安装完成后重新发起付款\",\"url\":\"https://mobile.unionpay.com/getclient?platform=android&type=securepayplugin\",\"download_app\":\"UPPayPluginEx.apk\",\"download_title\":\"银联在线支付服务\",\"download_desp\":\"正在下载银联在线支付服务…\",\"md5\":\"D75BB2802E61738A9A03BF014F927D9A\"}]";
    public static final String VERSION = "3.4.7";

    /* renamed from: W */
    private static JSONArray f22002W = null;

    /* renamed from: X */
    private static IntentFilter f22003X = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");

    /* renamed from: Y */
    private static BroadcastReceiver f22004Y = new C4117a();

    /* renamed from: Z */
    private static final Handler.Callback f22005Z = new C4126b();

    /* renamed from: a */
    private static String f22006a = "SpId";

    /* renamed from: b */
    private static String f22007b = "paydata";

    /* renamed from: c */
    private static String f22008c = "SysProvide";

    /* renamed from: d */
    private static String f22009d = "UseTestMode";

    /* renamed from: e */
    private static String f22010e = "SecurityChipType";

    /* renamed from: f */
    private static String f22011f = "uppayuri";

    /* renamed from: g */
    private static String f22012g = "resultIntentAction";

    /* renamed from: h */
    private static String f22013h = "reqOriginalId";

    /* renamed from: i */
    private static String f22014i = "wapurl";

    /* renamed from: j */
    private static String f22015j = "dlgstyle";

    /* renamed from: k */
    private static String f22016k = "com.unionpay.uppay";

    /* renamed from: l */
    private static String f22017l = "com.unionpay.uppay.PayActivity";

    /* renamed from: m */
    private static String f22018m = "ex_mode";

    /* renamed from: n */
    private static String f22019n = "server";

    /* renamed from: o */
    private static String f22020o = "source";

    /* renamed from: p */
    private static String f22021p = "samsung_out";

    /* renamed from: q */
    private static String f22022q = "se_type";

    /* renamed from: r */
    private static String f22023r = "se_title_logo";

    /* renamed from: s */
    private static String f22024s = "se_loading_logo";

    /* renamed from: t */
    private static String f22025t = "se_title_bg_color";

    /* renamed from: u */
    private static String f22026u = "se_cancel_bg_color";

    /* renamed from: v */
    private static String f22027v = "02";

    /* renamed from: w */
    private static String f22028w;

    /* renamed from: x */
    private static String f22029x;

    /* renamed from: y */
    private static String f22030y;

    /* renamed from: z */
    private static String f22031z;

    /* renamed from: a */
    private static int m1689a(Activity activity, String str, String str2) {
        try {
            String[] strArr = {"30820267308201d0a00302010202044", "ecb7d98300d06092a8", "64886f70d01010505003078310b30090603550", "406130238363111300f060355040813085", "368616e676", "861693111300f060355040713085368616e67686169311730", "15060355040a130e4368696e6120556e696f6e50617931173015060355040b130e4", "368696e612055", "6e696f6e5061793111300f06035504031308556e696f6e5061", "79301e170d3131313132323130343634385a170d333631313135313034", "3634385a3078310b300906035504061302383631", "11300f060355040813085368616e67686169311130", "0f060355040713085368616e676861693117", "3015060355040a130e4368696e6120556e696", "f6e50617931173015060355040b130e4368696e6120556e696", "f6e5061793111300f06035504031308556e696f6e50617930819f300d060", "92a864886f70d010101050003818d0030818902818100c42e6236d5054ffccaa", "a430ecd929d562", "b1ff56cef0e21c87260c63ce3ca868bf5974c14", "d9255940da7b6cd07483f4b4243fd1825b2705", "08eb9b5c67474d027fa03ce35109b11604083ab6bb4df2c46240f879f", "8cc1d6ed5e1b2cc00489215aec3fc2eac008e767b0215981cb5e", "e94ddc285669ec06b8a405dd4341eac4ea7030203010001300d06092a864886f70d010105050003818", "1001a3e74c601e3beb1b7ae4f9ab2872a0aaf1dbc2cba89c7528cd", "54aa526e7a37d8ba2311a1d3d2ab79b3fbeaf3ebb9e7da9e7cdd9be1ae5a53595f47", "b1fdf62b0f540fca5458b063af9354925a6c3505a18ff164b6b195f6e517eaee1fb783", "64c2f89fdffa16729c9779f99562bc189d2ce4722ba0faedb11aa22d0d9db228fda"};
            PackageManager packageManager = activity.getPackageManager();
            packageManager.getActivityInfo(activity.getComponentName(), 128);
            packageManager.getApplicationInfo("com.unionpay.uppay", 8192);
            PackageInfo packageInfo = packageManager.getPackageInfo("com.unionpay.uppay", 4160);
            String charsString = packageInfo.signatures[0].toCharsString();
            String str3 = "";
            for (int i = 0; i < 27; i++) {
                str3 = str3 + strArr[i];
            }
            if (charsString != null && charsString.equals(str3) && packageInfo.versionCode >= 31) {
                Bundle bundle = new Bundle();
                bundle.putInt(f22013h, 1);
                bundle.putString(f22011f, str);
                bundle.putString(f22012g, str2);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClassName(f22016k, f22017l);
                activity.startActivity(intent);
                return 0;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static int m1687a(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback, boolean z) {
        return C4644b.m455d(context, "com.unionpay.tsmservice.mi") ? new C4131e(context, uPQuerySEPayInfoCallback, z).m1624a() : new C4128b(context, uPQuerySEPayInfoCallback, z).m1636a();
    }

    /* renamed from: a */
    private static int m1684a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        f21986G = context;
        f21987H = str3;
        f21988I = str;
        f21989J = str2;
        f21990K = str4;
        f21982C = str6;
        f21981B = str5;
        f21983D = TextUtils.isEmpty(str6) ? "0" : "1";
        f22028w = null;
        f22029x = null;
        f22030y = null;
        if (!TextUtils.isEmpty(str6)) {
            f21980A = str6;
        } else if (TextUtils.isEmpty(UPUtils.m473a(context, "se_type"))) {
            if (m1687a(f21986G, (UPQuerySEPayInfoCallback) new C4135c(), false) == 0) {
                return 0;
            }
        }
        m1652s();
        return 0;
    }

    /* renamed from: a */
    private static String m1686a(Context context, String str) {
        try {
            InputStream open = context.getAssets().open(str);
            String absolutePath = context.getFilesDir().getAbsolutePath();
            if (absolutePath != null) {
                String str2 = absolutePath + File.separator + str;
                if (!new File(str2).exists()) {
                    FileOutputStream openFileOutput = context.openFileOutput(str, 1);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        openFileOutput.write(bArr, 0, read);
                    }
                    openFileOutput.close();
                    open.close();
                }
                return str2;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m1682a(Context context, boolean z) {
        int i;
        NfcAdapter defaultAdapter;
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                i = Integer.parseInt(f21990K);
            } catch (PatternSyntaxException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            } catch (Exception unused) {
            }
        } catch (NumberFormatException unused2) {
            i = 0;
        }
        if (!z) {
            jSONObject.put("tn", UPUtils.forWap(i, C4644b.m461a(f21987H)));
        }
        jSONObject.put("imei", C4647e.m446b(context));
        jSONObject.put("locale", Locale.getDefault().toString().startsWith("zh") ? "zh_CN" : "en_US");
        jSONObject.put("terminal_version", VERSION);
        jSONObject.put("terminal_resolution", (context.getResources().getDisplayMetrics().widthPixels + "*" + context.getResources().getDisplayMetrics().heightPixels).trim());
        jSONObject.put("os_name", "android");
        jSONObject.put("os_version", Build.VERSION.RELEASE.trim());
        String trim = Build.MODEL.trim();
        if (trim != null) {
            trim.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "");
        }
        jSONObject.put("device_model", trim);
        jSONObject.put(Constant.KEY_MAC, C4647e.m448a(context));
        try {
            jSONObject.put("time_zone", TimeZone.getDefault().getDisplayName(false, 0));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                str = "disConnect";
            } else if (activeNetworkInfo.getType() != 0) {
                str = activeNetworkInfo.getType() == 1 ? "wifi" : "other";
            } else if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                str = "mobile:" + activeNetworkInfo.getExtraInfo();
            } else {
                str = "mobile";
            }
            jSONObject.put("network_mode", str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("imsi", C4647e.m445c(context));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("baseband_version", m1667e(C4647e.m449a()));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("root", new File("/system/bin/su").exists() ? "1" : "0");
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            StringBuffer stringBuffer = new StringBuffer(com.unionpay.tsmservice.data.Constant.DEFAULT_CVN2);
            if (Build.VERSION.SDK_INT >= 10 && (defaultAdapter = ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) != null) {
                if (defaultAdapter.isEnabled()) {
                    stringBuffer.setCharAt(0, '1');
                } else {
                    stringBuffer.setCharAt(0, PdfWriter.VERSION_1_2);
                }
                if (Build.VERSION.SDK_INT >= 19 && context.getPackageManager().hasSystemFeature("android.hardware.nfc.hce")) {
                    stringBuffer.setCharAt(1, '1');
                }
            }
            jSONObject.put("support_map", stringBuffer.toString());
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        jSONObject.put("country", m1667e(Locale.getDefault().getCountry()));
        String packageName = ((Activity) context).getPackageName();
        if (packageName == null) {
            packageName = "";
        }
        jSONObject.put("package", m1667e(packageName));
        Location m444d = C4647e.m444d(context);
        jSONObject.put("latitude", m1667e(m444d != null ? Double.valueOf(m444d.getLatitude()).toString() : ""));
        Location m444d2 = C4647e.m444d(context);
        jSONObject.put("longitude", m1667e(m444d2 != null ? Double.valueOf(m444d2.getLongitude()).toString() : ""));
        jSONObject.put("tel", m1667e(C4647e.m443e(context)));
        if (z) {
            try {
                Class.forName("com.unionpay.uppay.PayActivity");
                jSONObject.put("has_sdk", "1");
            } catch (ClassNotFoundException unused3) {
                jSONObject.put("has_sdk", "0");
            }
        }
        jSONObject.put("seType", C4644b.m454d(f21980A));
        jSONObject.put("isLimitSe", f21983D);
        String jSONObject2 = jSONObject.toString();
        C4652j.m432b("uppay", "init: ".concat(String.valueOf(jSONObject2)));
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1685a(Context context, String str, String str2, String str3, String str4, String str5) {
        boolean z;
        String m1686a = m1686a(context, str2);
        if (m1686a == null || TextUtils.isEmpty(m1686a)) {
            z = false;
        } else {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse("file:".concat(String.valueOf(m1686a))), "application/vnd.android.package-archive");
            context.startActivity(intent);
            z = true;
        }
        if (!z && m1665f(str)) {
            f21991L = str5;
            f21993N = str2;
            if (f21992M) {
                return;
            }
            try {
                context.registerReceiver(f22004Y, f22003X);
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                request.setMimeType(f21998S);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str2);
                request.setTitle(str3);
                request.setDescription(str4);
                request.setNotificationVisibility(1);
                UPUtils.m474a(context, ((DownloadManager) context.getSystemService("download")).enqueue(request), "id");
                f21992M = true;
            } catch (Exception e) {
                if (!(e instanceof IllegalArgumentException)) {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(C4653k.m431a().f23765d);
                builder.setMessage(C4653k.m431a().f23767f);
                builder.setPositiveButton(C4653k.m431a().f23763b, new DialogInterface$OnClickListenerC4140g(context));
                builder.setNegativeButton(C4653k.m431a().f23764c, new DialogInterface$OnClickListenerC4141h(context));
                builder.create().show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017b A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void m1683a(android.content.Context r16, org.json.JSONArray r17, int r18) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.UPPayAssistEx.m1683a(android.content.Context, org.json.JSONArray, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1681a(String str) {
        Bundle bundle = new Bundle();
        m1680a(f21987H, bundle, f21990K);
        bundle.putString(f22006a, f21988I);
        bundle.putString(f22008c, f21989J);
        bundle.putString(f22007b, f21987H);
        bundle.putString(f22020o, f21981B);
        bundle.putString(f22022q, f21982C);
        if (!TextUtils.isEmpty(f21982C)) {
            bundle.putString(f22023r, f22028w);
            bundle.putString(f22024s, f22029x);
            bundle.putString(f22025t, f22030y);
            bundle.putString(f22026u, f22031z);
        }
        bundle.putString(f22019n, str);
        bundle.putBoolean(f22015j, f21984E);
        bundle.putInt(f22013h, 2);
        try {
            Class<?> cls = Class.forName("com.unionpay.uppay.PayActivity");
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setClass(f21986G, cls);
            if (f21986G instanceof Activity) {
                ((Activity) f21986G).startActivityForResult(intent, f21985F);
                return;
            }
            intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
            f21986G.startActivity(intent);
        } catch (ClassNotFoundException unused) {
        }
    }

    /* renamed from: a */
    private static void m1680a(String str, Bundle bundle, String str2) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        if (str.trim().charAt(0) != '<') {
            bundle.putString(f22018m, str2);
        } else if (str2 == null || !str2.trim().equalsIgnoreCase("00")) {
            bundle.putBoolean(f22009d, true);
        } else {
            bundle.putBoolean(f22009d, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static JSONArray m1674b(JSONArray jSONArray, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optJSONObject(i));
        }
        Collections.sort(arrayList, new C4142i(str));
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jSONArray2.put((JSONObject) arrayList.get(i2));
        }
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m1676b(Context context) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.android.providers.downloads"));
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            context.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m1672c(Context context) {
        int i;
        String str = f22000U;
        String m473a = UPUtils.m473a(context, "configs" + f21982C);
        String m473a2 = UPUtils.m473a(context, "mode" + f21982C);
        String m473a3 = UPUtils.m473a(context, "or" + f21982C);
        if (!TextUtils.isEmpty(m473a) && !TextUtils.isEmpty(m473a2) && !TextUtils.isEmpty(m473a3)) {
            try {
                System.loadLibrary("entryexpro");
                JSONObject jSONObject = new JSONObject(m473a);
                String m438a = C4651i.m438a(jSONObject, "sign");
                try {
                    i = Integer.parseInt(m473a2);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                String str2 = new String(Base64.decode(jSONObject.getString("configs"), 2));
                String str3 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : "";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                String m461a = C4644b.m461a(UPUtils.m471a(str2 + str3 + m473a3));
                String forConfig = UPUtils.forConfig(i, m438a);
                if (!TextUtils.isEmpty(forConfig)) {
                    if (forConfig.equals(m461a)) {
                        str = str2;
                    }
                }
            } catch (Exception unused2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                Object m439a = C4651i.m439a(jSONArray, i2);
                if (m439a != null) {
                    JSONObject jSONObject2 = (JSONObject) m439a;
                    if ("app".equals(C4651i.m438a(jSONObject2, VastExtensionXmlManager.TYPE))) {
                        JSONArray m1674b = m1674b(C4651i.m436c(jSONObject2, "package_info"), "sort");
                        if (m1674b.length() > 0) {
                            int length2 = m1674b.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                Object m439a2 = C4651i.m439a(m1674b, i3);
                                if (m439a2 != null) {
                                    JSONObject jSONObject3 = (JSONObject) m439a2;
                                    String m438a2 = C4651i.m438a(jSONObject3, "schema");
                                    String m438a3 = C4651i.m438a(jSONObject3, "sign");
                                    String m438a4 = C4651i.m438a(jSONObject3, "version");
                                    if (C4644b.m463a(context, m438a2) && m438a3.equalsIgnoreCase(C4644b.m459b(context, m438a2)) && C4644b.m457c(context, m438a2).matches(m438a4)) {
                                        return true;
                                    }
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (JSONException unused3) {
        }
        return false;
    }

    public static boolean checkWalletInstalled(Context context) {
        return C4644b.m463a(context, "com.unionpay") && "536C79B93ACFBEA950AE365D8CE1AEF91FEA9535".equalsIgnoreCase(C4644b.m459b(context, "com.unionpay"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m1669d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            f22028w = jSONObject.getString("titleLogo");
            f22029x = jSONObject.getString("loadingLogo");
            f22030y = jSONObject.getString("backGroundColor");
            f22031z = jSONObject.getString("textColor");
        } catch (JSONException unused) {
        }
    }

    /* renamed from: e */
    private static String m1667e(String str) {
        return str != null ? Pattern.compile("[\":,\\[\\]{}]").matcher(str).replaceAll("").trim() : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ boolean m1666f() {
        f21992M = false;
        return false;
    }

    /* renamed from: f */
    private static boolean m1665f(String str) {
        try {
            return Pattern.compile(".*(\\.95516\\.com|\\.chinaunionpay\\.com|\\.unionpay\\.com|\\.unionpaysecure\\.com|\\.95516\\.net)(,.*|$)", 2).matcher(new URL(str).getHost()).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getSEPayInfo(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback) {
        return m1687a(context, uPQuerySEPayInfoCallback, true);
    }

    public static boolean installUPPayPlugin(Context context) {
        try {
            InputStream open = context.getAssets().open("UPPayPluginEx.apk");
            String absolutePath = context.getFilesDir().getAbsolutePath();
            if (absolutePath != null) {
                String str = absolutePath + File.separator + "UPPayPluginEx.apk";
                if (!new File(str).exists()) {
                    FileOutputStream openFileOutput = context.openFileOutput("UPPayPluginEx.apk", 1);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        openFileOutput.write(bArr, 0, read);
                    }
                    openFileOutput.close();
                    open.close();
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse("file:".concat(String.valueOf(str))), "application/vnd.android.package-archive");
                context.startActivity(intent);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static /* synthetic */ boolean m1657n() {
        f21995P = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static /* synthetic */ int m1653r() {
        int i = f21994O + 1;
        f21994O = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static int m1652s() {
        int i;
        JSONArray jSONArray;
        String str;
        int i2;
        if (f21986G == null) {
            return 1;
        }
        if (TextUtils.isEmpty(f21981B) && TextUtils.isEmpty(f21982C)) {
            f21984E = false;
        } else {
            f21984E = true;
            if (f22027v.equalsIgnoreCase(f21982C)) {
                f21981B = f22021p;
            }
        }
        f21994O = 0;
        f21995P = false;
        System.loadLibrary("entryexpro");
        Context context = f21986G;
        String m473a = UPUtils.m473a(context, "configs" + f21982C);
        Context context2 = f21986G;
        String m473a2 = UPUtils.m473a(context2, "mode" + f21982C);
        Context context3 = f21986G;
        String m473a3 = UPUtils.m473a(context3, "or" + f21982C);
        if (!TextUtils.isEmpty(m473a) && !TextUtils.isEmpty(m473a2) && !TextUtils.isEmpty(m473a3)) {
            try {
                JSONObject jSONObject = new JSONObject(m473a);
                String m438a = C4651i.m438a(jSONObject, "sign");
                try {
                    i2 = Integer.parseInt(m473a2);
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                String str2 = new String(Base64.decode(jSONObject.getString("configs"), 2));
                String str3 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : "";
                if (TextUtils.isEmpty(str3)) {
                    str3 = "";
                }
                C4652j.m433a("uppay", str2);
                String m461a = C4644b.m461a(UPUtils.m471a(str2 + str3 + m473a3));
                String forConfig = UPUtils.forConfig(i2, m438a);
                if (!TextUtils.isEmpty(forConfig) && forConfig.equals(m461a)) {
                    if (TextUtils.isEmpty(f21982C)) {
                        f22000U = str2;
                    } else {
                        f22001V = str2;
                    }
                    if (!TextUtils.isEmpty(f21980A)) {
                        Context context4 = f21986G;
                        String m473a4 = UPUtils.m473a(context4, "se_configs" + f21980A);
                        if (!TextUtils.isEmpty(m473a4)) {
                            m1669d(m473a4);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
        try {
            if (TextUtils.isEmpty(f21982C)) {
                jSONArray = new JSONArray(f22000U);
                str = "sort";
            } else {
                jSONArray = new JSONArray(f22001V);
                str = "sort";
            }
            f22002W = m1674b(jSONArray, str);
        } catch (JSONException unused3) {
        }
        Context context5 = f21986G;
        try {
            i = Integer.parseInt(f21990K);
        } catch (NumberFormatException unused4) {
            i = 0;
        }
        String forUrl = UPUtils.forUrl(i);
        C4652j.m432b("uppay", "url: ".concat(String.valueOf(forUrl)));
        f21996Q = new C4121d(forUrl);
        String m1682a = m1682a(context5, false);
        C4652j.m432b("uppay", "postdata: ".concat(String.valueOf(m1682a)));
        f21996Q.m1640a(m1682a);
        f21997R = new Handler(f22005Z);
        new C4137d().start();
        return 0;
    }

    public static int startPay(Context context, String str, String str2, String str3, String str4) {
        return m1684a(context, str, str2, str3, str4, "", "");
    }

    public static void startPayByJAR(Context context, Class cls, String str, String str2, String str3, String str4) {
        startPay(context, str, str2, str3, str4);
    }

    public static int startPayFromBrowser(Activity activity, String str, String str2) {
        return m1689a(activity, str, str2);
    }

    public static int startSEPay(Context context, String str, String str2, String str3, String str4, String str5) {
        return m1684a(context, str, str2, str3, str4, "", str5);
    }

    public static void startSamsungPay(Context context, Class cls, String str, String str2, String str3, String str4) {
        m1684a(context, str, str2, str3, str4, f22021p, f22027v);
    }
}
