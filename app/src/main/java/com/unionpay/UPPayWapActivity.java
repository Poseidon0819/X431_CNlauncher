package com.unionpay;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.utils.C4648f;
import com.unionpay.utils.C4649g;
import com.unionpay.utils.C4650h;
import com.unionpay.utils.C4653k;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UPPayWapActivity extends Activity {

    /* renamed from: a */
    LinearLayout f22032a;

    /* renamed from: b */
    private WebView f22033b;

    /* renamed from: c */
    private WebViewJavascriptBridge f22034c;

    /* renamed from: d */
    private AlertDialog f22035d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m1649a(UPPayWapActivity uPPayWapActivity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("pay_result", str);
        intent.putExtra("result_data", str2);
        uPPayWapActivity.setResult(-1, intent);
        uPPayWapActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m1646b(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");
            if (str != null) {
                jSONObject.put("code", str);
            }
            if (str2 != null) {
                jSONObject.put("msg", str2);
            }
            if (str3 != null) {
                jSONObject.put("value", str3);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        View.OnClickListener view$OnClickListenerC4487n;
        super.onCreate(bundle);
        if (!"949A1CC".equalsIgnoreCase(getIntent().getStringExtra("magic_data"))) {
            finish();
        }
        String stringExtra = getIntent().getStringExtra("waptype");
        String str3 = "";
        if (stringExtra == null || !stringExtra.equals("new_page")) {
            String stringExtra2 = getIntent().getStringExtra("wapurl");
            String stringExtra3 = getIntent().getStringExtra("paydata");
            if (stringExtra3 != null) {
                str3 = stringExtra2 + "?s=" + stringExtra3;
            }
            str = str3;
            str2 = C4653k.m431a().f23766e;
            view$OnClickListenerC4487n = new View$OnClickListenerC4487n(this);
        } else {
            str = getIntent().getStringExtra("wapurl");
            String stringExtra4 = getIntent().getStringExtra("waptitle");
            if (str == null) {
                str = "";
            }
            str2 = stringExtra4 != null ? stringExtra4 : "";
            view$OnClickListenerC4487n = new View$OnClickListenerC4143j(this);
        }
        getWindow().requestFeature(1);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams);
        int m442a = C4648f.m442a(this, 10.0f);
        int m442a2 = C4648f.m442a(this, 52.0f);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, m442a2));
        relativeLayout.setBackgroundColor(-10705958);
        this.f22032a = new LinearLayout(this);
        this.f22032a.setPadding(m442a, m442a, m442a, m442a);
        this.f22032a.setGravity(16);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.leftMargin = m442a;
        this.f22032a.setOnClickListener(view$OnClickListenerC4487n);
        relativeLayout.addView(this.f22032a, layoutParams2);
        int m442a3 = C4648f.m442a(this, 20.0f);
        int m442a4 = C4648f.m442a(this, 11.0f);
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundDrawable(C4649g.m441a(C4650h.f23758a));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(m442a4, m442a3);
        layoutParams3.addRule(15, -1);
        this.f22032a.addView(imageView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(C4648f.m442a(this, 320.0f), m442a2);
        layoutParams4.addRule(13, -1);
        TextView textView = new TextView(this);
        textView.setTextSize(20.0f);
        textView.setTextColor(-1);
        textView.setText(str2);
        textView.setGravity(17);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        relativeLayout.addView(textView, layoutParams4);
        linearLayout.addView(relativeLayout);
        this.f22033b = new WebView(this);
        this.f22033b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        linearLayout.addView(this.f22033b);
        setContentView(linearLayout);
        this.f22034c = new WebViewJavascriptBridge(this, this.f22033b, null);
        this.f22033b.loadUrl(str);
        this.f22034c.registerHandler("getDeviceInfo", new C4490q(this));
        this.f22034c.registerHandler("saveData", new C4491r(this));
        this.f22034c.registerHandler("getData", new C4492s(this));
        this.f22034c.registerHandler("removeData", new C4493t(this));
        this.f22034c.registerHandler("setPageBackEnable", new C4642u(this));
        this.f22034c.registerHandler("payBySDK", new C4656v(this));
        this.f22034c.registerHandler("downloadApp", new C4657w(this));
        this.f22034c.registerHandler("payResult", new C4144k(this));
        this.f22034c.registerHandler("closePage", new C4145l(this));
        this.f22034c.registerHandler("openNewPage", new C4146m(this));
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            onPause();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
