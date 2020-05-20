package com.cnlaunch.x431pro.activity.diagnose;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseWebFragment;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.cnlaunch.x431pro.module.config.ConfigDBManager;
import com.cnlaunch.x431pro.utils.C2744aa;
import java.util.Locale;
import org.apache.http.conn.ssl.TokenParser;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.ci */
/* loaded from: classes.dex */
public final class WebSearchFragment extends BaseWebFragment implements OnKeyDownListenter {

    /* renamed from: c */
    private IFragmentCallback f11841c = null;

    /* renamed from: d */
    private String f11842d = "";

    /* renamed from: e */
    private final String f11843e = "https://www.baidu.com";

    /* renamed from: f */
    private final String f11844f = "https://www.google.com";

    /* renamed from: g */
    private final String f11845g = "https://www.google.com.hk";

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter
    /* renamed from: i_ */
    public final void mo6838i_() {
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f11841c = (IFragmentCallback) activity;
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f11842d = arguments.getString("searchkey");
            }
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement FragmentCallback.OnMenuOnClickListener");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f11841c.mo7096a(this);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f12969a.canGoBack()) {
            this.f12969a.goBack();
            return true;
        }
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseWebFragment
    /* renamed from: a */
    public final void mo5836a(WebView webView) {
        String format;
        String format2;
        String country = Locale.getDefault().getCountry();
        if (TextUtils.isEmpty(this.f11842d)) {
            if (C2744aa.m5166c()) {
                if (country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) {
                    webView.loadUrl("https://www.google.com.hk");
                    return;
                } else {
                    webView.loadUrl("https://www.google.com");
                    return;
                }
            } else if (country.equalsIgnoreCase("CN") || country.equalsIgnoreCase("ZH")) {
                webView.loadUrl("https://www.baidu.com");
                return;
            } else if (country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) {
                webView.loadUrl("https://www.google.com.hk");
                return;
            } else {
                webView.loadUrl("https://www.google.com");
                return;
            }
        }
        String str = this.f11842d;
        if (str != null) {
            this.f11842d = str.replace('&', TokenParser.f24154SP);
        }
        String str2 = "";
        String str3 = "";
        try {
            str2 = ConfigDBManager.m5398a(this.mContext).m5396a("Google_Search_HK");
            if (TextUtils.isEmpty(str2)) {
                str2 = "https://www.google.com.hk/search?hl=zh-HK&ie=UTF-8&source=android-browser&q=%s#hl=zh-HK&newwindow=1&q=%s&safe=strict";
            }
            str3 = ConfigDBManager.m5398a(this.mContext).m5396a("Google_Search");
            if (TextUtils.isEmpty(str3)) {
                str3 = "https://www.google.com/search?hl=%s&ie=UTF-8&source=android-browser&q=%s#hl=%s&newwindow=1&q=%s&safe=strict";
            }
        } catch (C1425f e) {
            e.printStackTrace();
        }
        if (C2744aa.m5166c()) {
            String m9469a = LangManager.m9469a();
            if (country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) {
                String str4 = this.f11842d;
                format2 = String.format(str2, str4, str4);
            } else {
                String str5 = this.f11842d;
                format2 = String.format(str3, m9469a, str5, m9469a, str5);
            }
            webView.loadUrl(format2);
            return;
        }
        String m9469a2 = LangManager.m9469a();
        if (country.equalsIgnoreCase("CN") || country.equalsIgnoreCase("ZH")) {
            this.f11842d = "汽车故障码" + this.f11842d;
            format = String.format("https://www.baidu.com/s?wd=%s", this.f11842d);
        } else if (country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) {
            String str6 = this.f11842d;
            format = String.format(str2, str6, str6);
        } else {
            String str7 = this.f11842d;
            format = String.format(str3, m9469a2, str7, m9469a2, str7);
        }
        webView.loadUrl(format);
    }
}
