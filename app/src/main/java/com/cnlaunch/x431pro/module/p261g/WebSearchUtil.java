package com.cnlaunch.x431pro.module.p261g;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.GDApplication;
import com.cnlaunch.x431pro.activity.diagnose.WebSearchFragment;
import com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import java.util.Locale;
import org.apache.http.conn.ssl.TokenParser;

/* renamed from: com.cnlaunch.x431pro.module.g.a */
/* loaded from: classes.dex */
public final class WebSearchUtil {

    /* compiled from: WebSearchUtil.java */
    /* renamed from: com.cnlaunch.x431pro.module.g.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2728a {
        /* renamed from: a */
        void mo5330a(String str);
    }

    /* compiled from: WebSearchUtil.java */
    /* renamed from: com.cnlaunch.x431pro.module.g.a$b */
    /* loaded from: classes.dex */
    interface InterfaceC2729b {
        /* renamed from: a */
        void mo5329a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m5333a() {
        try {
            boolean z = Build.VERSION.SDK_INT <= 22;
            new StringBuilder("Build.VERSION.SDK_INT=").append(Build.VERSION.SDK_INT);
            return z && Boolean.parseBoolean(C2778n.m4916a(GDApplication.f10694b, "search_by_browser_in_earlier_versions"));
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5331a(BaseDiagnoseFragment baseDiagnoseFragment, String str) {
        WebSearchFragment webSearchFragment = new WebSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("searchkey", str);
        webSearchFragment.setArguments(bundle);
        baseDiagnoseFragment.f12357d.mo7098a((Fragment) webSearchFragment, baseDiagnoseFragment.getClass().getName(), true);
    }

    /* renamed from: a */
    public static String m5332a(Context context, String str) {
        String country = Locale.getDefault().getCountry();
        if (TextUtils.isEmpty(str)) {
            return C2744aa.m5166c() ? (country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) ? "https://www.google.com.hk" : "https://www.google.com" : (country.equalsIgnoreCase("CN") || country.equalsIgnoreCase("ZH")) ? "https://www.baidu.com" : (country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) ? "https://www.google.com.hk" : "https://www.google.com";
        }
        if (str != null) {
            str = str.replace('&', TokenParser.f24154SP);
        }
        String str2 = "";
        String str3 = "";
        try {
            str2 = ConfigDBManager.m5398a(context).m5396a("Google_Search_HK");
            if (TextUtils.isEmpty(str2)) {
                str2 = "https://www.google.com.hk/search?hl=zh-HK&ie=UTF-8&source=android-browser&q=%s#hl=zh-HK&newwindow=1&q=%s&safe=strict";
            }
            str3 = ConfigDBManager.m5398a(context).m5396a("Google_Search");
            if (TextUtils.isEmpty(str3)) {
                str3 = "https://www.google.com/search?hl=%s&ie=UTF-8&source=android-browser&q=%s#hl=%s&newwindow=1&q=%s&safe=strict";
            }
        } catch (C1425f e) {
            e.printStackTrace();
        }
        if (C2744aa.m5166c()) {
            String m9469a = LangManager.m9469a();
            return (country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) ? String.format(str2, str, str) : String.format(str3, m9469a, str, m9469a, str);
        }
        String m9469a2 = LangManager.m9469a();
        return (country.equalsIgnoreCase("CN") || country.equalsIgnoreCase("ZH")) ? String.format("https://www.baidu.com/s?wd=%s", "汽车故障码".concat(String.valueOf(str))) : (country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) ? String.format(str2, str, str) : String.format(str3, m9469a2, str, m9469a2, str);
    }
}
