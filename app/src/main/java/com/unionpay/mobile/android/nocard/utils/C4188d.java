package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.unionpay.mobile.android.callback.UPAndroidCallback;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.C4390k;

/* renamed from: com.unionpay.mobile.android.nocard.utils.d */
/* loaded from: classes2.dex */
public final class C4188d {

    /* renamed from: a */
    private static UPAndroidCallback f22521a;

    /* renamed from: a */
    public static void m1480a(Context context, C4173b c4173b) {
        String str;
        String str2;
        C4390k.m837b("uppay", "exit() +++");
        C4390k.m838a("uppay", "reqId=" + c4173b.f22383I.f22843a);
        BaseActivity baseActivity = (BaseActivity) context;
        if (c4173b.f22383I.f22848f.length() > 0) {
            C4390k.m838a("uppay", "result=" + c4173b.f22383I.f22848f);
            int i = c4173b.f22383I.f22843a;
            if (i != 1000) {
                switch (i) {
                    case 0:
                    case 2:
                    case 5:
                        C4390k.m837b("uppay", "notifyAppResult() +++");
                        Intent intent = new Intent();
                        intent.putExtra("pay_result", c4173b.f22383I.f22848f);
                        intent.putExtra("result_data", c4173b.f22460bj);
                        if (c4173b.f22396V != null && c4173b.f22396V.length() > 0 && c4173b.f22397W != null && c4173b.f22397W.length() > 0 && !c4173b.f22395U) {
                            intent.putExtra("notify_url", c4173b.f22396V);
                            intent.putExtra("notify_msg", c4173b.f22397W);
                        }
                        if (c4173b.f22478n != null) {
                            intent.putExtra("qn", c4173b.f22478n);
                            intent.putExtra("sid", c4173b.f22475k);
                            intent.putExtra("secret", c4173b.f22476l);
                        }
                        UPAndroidCallback uPAndroidCallback = f22521a;
                        if (uPAndroidCallback != null) {
                            uPAndroidCallback.UPAndroidOK(c4173b.f22383I.f22848f, c4173b.f22478n, c4173b.f22475k, c4173b.f22476l);
                        }
                        baseActivity.setResult(-1, intent);
                        str = "uppay";
                        str2 = "notifyAppResult() ---";
                        C4390k.m837b(str, str2);
                        break;
                    case 3:
                        C4390k.m837b("uppay", "notifyTencentJarResult() +++");
                        Intent intent2 = new Intent();
                        intent2.putExtra("pay_result", c4173b.f22383I.f22848f);
                        intent2.putExtra("tencentWID", c4173b.f22383I.f22850h);
                        intent2.putExtra("tencentUID", c4173b.f22383I.f22849g);
                        intent2.putExtra("bankInfo", c4173b.f22383I.f22852j);
                        intent2.putExtra("cardType", c4173b.f22383I.f22853k);
                        intent2.putExtra("cardNo", c4173b.f22383I.f22851i);
                        baseActivity.setResult(-1, intent2);
                        str = "uppay";
                        str2 = "notifyTencentJarResult() ---";
                        C4390k.m837b(str, str2);
                        break;
                }
            }
            C4390k.m837b("uppay", " notifyBrowserResult() +++ ");
            Intent intent3 = null;
            String str3 = c4173b.f22383I.f22848f;
            String str4 = str3.equalsIgnoreCase("fail") ? "1" : str3.equalsIgnoreCase("cancel") ? "-1" : "0";
            int i2 = c4173b.f22383I.f22843a;
            if (i2 == 1) {
                intent3 = new Intent(c4173b.f22383I.f22844b);
                C4390k.m837b("uppay", " other browser ");
                C4390k.m838a("uppay", " result Action=" + c4173b.f22383I.f22844b);
            } else if (i2 == 4) {
                Intent intent4 = new Intent("com.UCMobile.PluginApp.ActivityState");
                intent4.putExtra("ActivityState", "inactive");
                intent4.addCategory("android.intent.category.DEFAULT");
                baseActivity.sendBroadcast(intent4);
                intent3 = new Intent("com.unionpay.uppay.resultURL");
                C4390k.m837b("uppay", " uc browser ");
            }
            if (!TextUtils.isEmpty(c4173b.f22482r) && !"exit".equalsIgnoreCase(c4173b.f22482r)) {
                String str5 = c4173b.f22482r + str4;
                C4390k.m838a("uppay", "result URL= ".concat(String.valueOf(str5)));
                try {
                    if (1000 == c4173b.f22383I.f22843a) {
                        Intent intent5 = new Intent("android.intent.action.VIEW", Uri.parse(str5));
                        intent5.addCategory("android.intent.category.BROWSABLE");
                        baseActivity.startActivity(intent5);
                    } else {
                        intent3.putExtra("ResultURL", str5);
                        C4390k.m838a("browser", intent3.toURI());
                        baseActivity.sendBroadcast(intent3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                str = "uppay";
                str2 = " notifyBrowserResult() --- ";
                C4390k.m837b(str, str2);
            }
        }
        if (c4173b.f22396V != null && c4173b.f22396V.length() > 0 && c4173b.f22397W != null && c4173b.f22397W.length() > 0) {
            boolean z = c4173b.f22395U;
            String str6 = c4173b.f22396V;
            String str7 = c4173b.f22397W;
            if (z) {
                new Thread(new RunnableC4189e(str6, str7, context)).start();
            }
        }
        baseActivity.finish();
        C4390k.m837b("uppay", "exit() +++");
    }
}
