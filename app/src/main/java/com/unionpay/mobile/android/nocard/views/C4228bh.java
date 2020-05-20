package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.location.Location;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.widget.LinearLayout;
import com.itextpdf.text.pdf.PdfWriter;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.utils.C4382c;
import com.unionpay.mobile.android.utils.C4385f;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.widgets.C4424ad;
import com.unionpay.tsmservice.p373mi.data.Constant;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jivesoftware.smackx.workgroup.packet.UserID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.bh */
/* loaded from: classes2.dex */
public final class C4228bh {
    /* renamed from: a */
    public static LinearLayout m1393a(Context context, JSONArray jSONArray, int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -2).topMargin = C4149a.f22115d;
        JSONObject jSONObject = null;
        while (i < i2 && i < jSONArray.length()) {
            try {
                jSONObject = jSONArray.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            linearLayout.addView(new C4424ad(context, C4149a.f22105I, jSONObject, ""));
            i++;
        }
        return linearLayout;
    }

    /* renamed from: a */
    public static String m1394a(Context context, String str, String str2, String str3, String str4, String str5) {
        NfcAdapter defaultAdapter;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tn", str);
            jSONObject.put(UserID.ELEMENT_NAME, C4385f.m865d(context));
            jSONObject.put("locale", m1392a(C4385f.m873a()));
            jSONObject.put("terminal_version", C4385f.m872a(context));
            jSONObject.put("terminal_resolution", C4385f.m866d());
            jSONObject.put("os_name", str2);
            jSONObject.put("os_version", Build.VERSION.RELEASE.trim());
            jSONObject.put("device_model", m1392a(C4385f.m868c()));
            jSONObject.put("terminal_type", str3);
            jSONObject.put("appId", str4);
            jSONObject.put("uid", PreferenceUtils.m905a(context));
            jSONObject.put(Constant.KEY_MAC, m1392a(C4385f.m867c(context)));
            try {
                jSONObject.put("time_zone", m1392a(C4385f.m862f()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                jSONObject.put("network_mode", C4385f.m861f(context));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                jSONObject.put("imsi", m1392a(C4385f.m863e(context)));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                jSONObject.put("baseband_version", m1392a(C4385f.m864e()));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                StringBuffer stringBuffer = new StringBuffer(com.unionpay.tsmservice.data.Constant.DEFAULT_CVN2);
                if (!com.unionpay.tsmservice.data.Constant.DEFAULT_CVN2.equals(str5)) {
                    stringBuffer.setCharAt(2, '1');
                }
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
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                jSONObject.put("se_map", str5);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            jSONObject.put("root", C4385f.m870b());
            jSONObject.put("country", m1392a(Locale.getDefault().getCountry()));
            jSONObject.put("package", m1392a(C4385f.m869b(context)));
            Location m860g = C4385f.m860g(context);
            jSONObject.put("latitude", m1392a(m860g != null ? Double.valueOf(m860g.getLatitude()).toString() : ""));
            Location m860g2 = C4385f.m860g(context);
            jSONObject.put("longitude", m1392a(m860g2 != null ? Double.valueOf(m860g2.getLongitude()).toString() : ""));
            jSONObject.put("tel", m1392a(C4385f.m859h(context)));
            jSONObject.put("packageId", C4382c.m883b(context));
        } catch (PatternSyntaxException e7) {
            e7.printStackTrace();
        } catch (JSONException e8) {
            e8.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        String substring = jSONObject2.substring(1, jSONObject2.length() - 1);
        C4390k.m838a("uppay", "init: ".concat(String.valueOf(substring)));
        return substring;
    }

    /* renamed from: a */
    private static String m1392a(String str) throws PatternSyntaxException {
        return str != null ? Pattern.compile("[\":,\\[\\]{}]").matcher(str).replaceAll("").trim() : "";
    }

    /* renamed from: a */
    public static String m1391a(String str, String str2, String str3, String str4) {
        return String.format("\"first_pay_flag\":\"%s\",\"card\":\"%s\",\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", str, str2, str3, str4);
    }

    /* renamed from: a */
    public static String m1390a(JSONObject jSONObject) {
        C4390k.m838a("uppay", "action:" + C4389j.m846a(jSONObject, "action"));
        return C4389j.m846a(jSONObject, "action");
    }

    /* renamed from: b */
    public static String m1389b(Context context, String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.unionpay.tsmservice.data.Constant.KEY_AMOUNT, str);
            jSONObject.put("aid", str5);
            jSONObject.put(UserID.ELEMENT_NAME, C4385f.m865d(context));
            jSONObject.put("locale", m1392a(C4385f.m873a()));
            jSONObject.put("terminal_version", C4385f.m872a(context));
            jSONObject.put("terminal_resolution", C4385f.m866d());
            jSONObject.put("os_name", str2);
            jSONObject.put("os_version", Build.VERSION.RELEASE.trim());
            jSONObject.put("device_model", m1392a(C4385f.m868c()));
            jSONObject.put("terminal_type", str3);
            jSONObject.put("appId", str4);
            jSONObject.put("uid", PreferenceUtils.m905a(context));
            jSONObject.put(Constant.KEY_MAC, m1392a(C4385f.m867c(context)));
            try {
                jSONObject.put("time_zone", m1392a(C4385f.m862f()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                jSONObject.put("network_mode", C4385f.m861f(context));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                jSONObject.put("imsi", m1392a(C4385f.m863e(context)));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                jSONObject.put("baseband_version", m1392a(C4385f.m864e()));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            jSONObject.put("root", C4385f.m870b());
            jSONObject.put("country", m1392a(Locale.getDefault().getCountry()));
            jSONObject.put("package", m1392a(C4385f.m869b(context)));
        } catch (PatternSyntaxException e5) {
            e5.printStackTrace();
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        String substring = jSONObject2.substring(1, jSONObject2.length() - 1);
        C4390k.m836c("uppay", "init: ".concat(String.valueOf(substring)));
        return substring;
    }

    /* renamed from: b */
    public static String m1388b(String str, String str2, String str3, String str4) {
        return String.format("\"first_pay_flag\":\"%s\",%s,\"pay_type\":\"%s\",\"pay_mode\":\"%s\"", str, str2, str3, str4);
    }

    /* renamed from: c */
    public static String m1387c(String str, String str2, String str3, String str4) {
        return (str3 == null || str3.length() <= 0) ? String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s", str, str2, str4) : String.format("\"pay_type\":\"%s\",\"pay_mode\":\"%s\",%s,%s", str, str2, str3, str4);
    }
}
