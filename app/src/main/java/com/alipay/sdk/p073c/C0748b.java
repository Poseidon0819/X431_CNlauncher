package com.alipay.sdk.p073c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alipay.sdk.app.C0734g;
import com.alipay.sdk.app.EnumC0735h;
import com.alipay.sdk.app.p071a.C0727a;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
/* renamed from: com.alipay.sdk.c.b */
/* loaded from: classes.dex */
public final class C0748b {

    /* renamed from: com.alipay.sdk.c.b$a */
    /* loaded from: classes.dex */
    public static class C0749a {

        /* renamed from: a */
        public byte[] f3543a;

        /* renamed from: b */
        public int f3544b;
    }

    /* renamed from: a */
    public static String m12521a(byte[] bArr) {
        try {
            String obj = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey().toString();
            if (obj.indexOf("modulus") != -1) {
                return obj.substring(obj.indexOf("modulus") + 8, obj.lastIndexOf(",")).trim();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static C0749a m12524a(Context context, String str) {
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
            if (packageInfo.packageName.equals(str)) {
                C0749a c0749a = new C0749a();
                c0749a.f3543a = packageInfo.signatures[0].toByteArray();
                c0749a.f3544b = packageInfo.versionCode;
                return c0749a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m12525a(Context context) {
        String m12527a = m12527a();
        String m12520b = m12520b();
        String m12519b = m12519b(context);
        String m12517c = m12517c(context);
        return " (" + m12527a + ";" + m12520b + ";" + m12519b + ";;" + m12517c + ")(sdk android)";
    }

    /* renamed from: a */
    private static String m12527a() {
        return "Android " + Build.VERSION.RELEASE;
    }

    /* renamed from: a */
    public static WebView m12526a(Activity activity, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            CookieSyncManager.createInstance(activity.getApplicationContext()).sync();
            CookieManager.getInstance().setCookie(str, str2);
            CookieSyncManager.getInstance().sync();
        }
        LinearLayout linearLayout = new LinearLayout(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        activity.setContentView(linearLayout, layoutParams);
        WebView webView = new WebView(activity);
        layoutParams.weight = 1.0f;
        webView.setVisibility(0);
        linearLayout.addView(webView, layoutParams);
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + m12525a(activity));
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        settings.setAllowFileAccess(false);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        webView.setVerticalScrollbarOverlay(true);
        webView.setDownloadListener(new C0750c(activity));
        if (Build.VERSION.SDK_INT >= 7) {
            try {
                Method method = webView.getSettings().getClass().getMethod("setDomStorageEnabled", Boolean.TYPE);
                if (method != null) {
                    method.invoke(webView.getSettings(), Boolean.TRUE);
                }
            } catch (Exception unused) {
            }
        }
        try {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable unused2) {
                Method method2 = webView.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method2 != null) {
                    method2.invoke(webView, "searchBoxJavaBridge_");
                    method2.invoke(webView, "accessibility");
                    method2.invoke(webView, "accessibilityTraversal");
                }
            }
        } catch (Throwable unused3) {
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(1);
        }
        webView.loadUrl(str);
        return webView;
    }

    /* renamed from: b */
    private static String m12520b() {
        String m12518c = m12518c();
        int indexOf = m12518c.indexOf("-");
        if (indexOf != -1) {
            m12518c = m12518c.substring(0, indexOf);
        }
        int indexOf2 = m12518c.indexOf("\n");
        if (indexOf2 != -1) {
            m12518c = m12518c.substring(0, indexOf2);
        }
        return "Linux ".concat(String.valueOf(m12518c));
    }

    /* renamed from: c */
    private static String m12518c() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            if (matcher.matches() && matcher.groupCount() >= 4) {
                return matcher.group(1) + "\n" + matcher.group(2) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + matcher.group(3) + "\n" + matcher.group(4);
            }
            return "Unavailable";
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    /* renamed from: b */
    private static String m12519b(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    /* renamed from: c */
    private static String m12517c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    /* renamed from: a */
    public static boolean m12522a(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    /* renamed from: a */
    public static boolean m12523a(WebView webView, String str, Activity activity) {
        C0749a m12524a;
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (str.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
            try {
                m12524a = m12524a(activity, "com.eg.android.AlipayGphone");
            } catch (Throwable unused) {
            }
            if (m12524a != null) {
                String m12521a = m12521a(m12524a.f3543a);
                if (m12521a != null && !TextUtils.equals(m12521a, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649")) {
                    C0727a.m12556a("biz", "ClientSignError", m12521a);
                    return true;
                }
                if (str.startsWith("intent://platformapi/startapp")) {
                    str = str.replaceFirst("intent://platformapi/startapp?", "alipays://platformapi/startApp?");
                }
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
            return true;
        } else if (TextUtils.equals(str, "sdklite://h5quit") || TextUtils.equals(str, "http://m.alipay.com/?action=h5quit")) {
            C0734g.f3510a = C0734g.m12549a();
            activity.finish();
            return true;
        } else if (str.startsWith("sdklite://h5quit?result=")) {
            try {
                String substring = str.substring(str.indexOf("sdklite://h5quit?result=") + 24);
                parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf("&end_code=") + 10));
            } catch (Exception unused2) {
                EnumC0735h m12546a = EnumC0735h.m12546a(EnumC0735h.PARAMS_ERROR.m12547a());
                C0734g.f3510a = C0734g.m12548a(m12546a.m12547a(), m12546a.m12545b(), "");
            }
            if (parseInt != EnumC0735h.SUCCEEDED.m12547a() && parseInt != EnumC0735h.PAY_WAITTING.m12547a()) {
                EnumC0735h m12546a2 = EnumC0735h.m12546a(EnumC0735h.FAILED.m12547a());
                C0734g.f3510a = C0734g.m12548a(m12546a2.m12547a(), m12546a2.m12545b(), "");
                activity.runOnUiThread(new RunnableC0751d(activity));
                return true;
            }
            StringBuilder sb = new StringBuilder();
            String decode = URLDecoder.decode(str);
            String substring2 = decode.substring(decode.indexOf("sdklite://h5quit?result=") + 24, decode.lastIndexOf("&end_code="));
            if (substring2.contains("&return_url=")) {
                String str2 = substring2.split("&return_url=")[0];
                int indexOf = substring2.indexOf("&return_url=") + 12;
                sb.append(str2);
                sb.append("&return_url=");
                sb.append(substring2.substring(indexOf, substring2.indexOf("\"&", indexOf)));
                sb.append(substring2.substring(substring2.indexOf("\"&", indexOf)));
                substring2 = sb.toString();
            }
            EnumC0735h m12546a3 = EnumC0735h.m12546a(parseInt);
            C0734g.f3510a = C0734g.m12548a(m12546a3.m12547a(), m12546a3.m12545b(), substring2);
            activity.runOnUiThread(new RunnableC0751d(activity));
            return true;
        } else {
            webView.loadUrl(str);
            return true;
        }
    }
}
