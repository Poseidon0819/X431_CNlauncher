package com.unionpay.mobile.android.nocard.utils;

import android.text.TextUtils;
import com.itextpdf.text.pdf.PdfBoolean;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.unionpay.mobile.android.model.C4172a;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.C4177f;
import com.unionpay.mobile.android.model.InterfaceC4176e;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.utils.f */
/* loaded from: classes2.dex */
public final class C4190f {
    /* renamed from: a */
    public static int m1479a(C4173b c4173b, JSONObject jSONObject) {
        c4173b.f22466bt = C4389j.m846a(jSONObject, "promotion_change_info");
        c4173b.f22490z = C4389j.m842d(jSONObject, "rules");
        c4173b.f22429ad = C4389j.m842d(jSONObject, "available_area_codes");
        c4173b.f22378D = C4389j.m842d(jSONObject, "entrust_rules");
        c4173b.f22379E = C4389j.m846a(jSONObject, "pre_cmd");
        c4173b.f22375A = C4389j.m846a(jSONObject, "title");
        c4173b.f22377C = C4389j.m843c(jSONObject, "rules_button");
        c4173b.f22437al = C4389j.m843c(jSONObject, "service_checkbox");
        c4173b.f22438am = C4389j.m843c(jSONObject, "bind_card_checkbox");
        String m846a = C4389j.m846a(jSONObject, "timeout_msg");
        if (m846a != null && !TextUtils.isEmpty(m846a)) {
            c4173b.f22436ak = m846a;
        }
        c4173b.f22480p = new HashMap<>();
        JSONObject m843c = C4389j.m843c(jSONObject, "f55");
        String m846a2 = C4389j.m846a(m843c, "order_amount");
        HashMap<String, String> hashMap = c4173b.f22480p;
        if (m846a2 == null || m846a2.length() <= 0) {
            m846a2 = Constant.DEFAULT_BALANCE;
        }
        hashMap.put("trans_amt", m846a2);
        String m846a3 = C4389j.m846a(m843c, "order_currency");
        c4173b.f22480p.put("trans currcy code", (m846a3 == null || m846a3.length() <= 0) ? "0156" : "0156");
        String m846a4 = C4389j.m846a(m843c, "trans_type");
        c4173b.f22480p.put("trans_type", (m846a4 == null || m846a4.length() <= 0) ? "00" : "00");
        String m846a5 = C4389j.m846a(m843c, "mer_name");
        c4173b.f22480p.put("mer_name", (m846a5 == null || m846a5.length() <= 0) ? "" : "");
        c4173b.f22442aq = C4389j.m846a(jSONObject, Constant.KEY_PAN);
        c4173b.f22456bf = C4389j.m846a(jSONObject, "encrypt_key");
        c4173b.f22457bg = C4389j.m846a(jSONObject, "auth_id");
        String m846a6 = C4389j.m846a(jSONObject, "fail_continue");
        if (m846a6 != null && m846a6.equalsIgnoreCase("0")) {
            c4173b.f22380F = true;
        }
        return ((c4173b.f22490z == null || c4173b.f22490z.length() <= 0) && (c4173b.f22378D == null || c4173b.f22378D.length() <= 0)) ? 2 : 0;
    }

    /* renamed from: a */
    public static int m1478a(C4173b c4173b, JSONObject jSONObject, boolean z) {
        if (!z) {
            c4173b.f22381G = jSONObject;
        }
        return m1479a(c4173b, jSONObject);
    }

    /* renamed from: a */
    public static InterfaceC4176e m1476a(JSONObject jSONObject) {
        C4177f c4177f = new C4177f();
        c4177f.m1532a("promotion", C4389j.m843c(jSONObject, "promotion"));
        c4177f.m1532a("instalment", C4389j.m843c(jSONObject, "instalment"));
        c4177f.m1532a("promotion_instalment_msgbox", C4389j.m843c(jSONObject, "promotion_instalment_msgbox"));
        return c4177f;
    }

    /* renamed from: a */
    public static boolean m1477a(JSONArray jSONArray) {
        String m846a;
        String m846a2;
        boolean z = false;
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    m846a = C4389j.m846a(jSONObject, VastExtensionXmlManager.TYPE);
                    m846a2 = C4389j.m846a(jSONObject, "readonly");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (Constant.KEY_PAN.equalsIgnoreCase(m846a)) {
                    z = PdfBoolean.TRUE.equalsIgnoreCase(m846a2);
                    break;
                }
                continue;
            }
        }
        return z;
    }

    /* renamed from: b */
    public static int m1475b(C4173b c4173b, JSONObject jSONObject) {
        int i = jSONObject == null ? 2 : 0;
        if (c4173b.f22427ab == null) {
            c4173b.f22427ab = new ArrayList();
        }
        c4173b.f22427ab.clear();
        List<JSONArray> m841e = C4389j.m841e(jSONObject, "user_cards");
        if (m841e.size() > 0) {
            for (int i2 = 0; i2 < m841e.size(); i2++) {
                c4173b.f22427ab.add(new C4172a(C4389j.m847a(m841e.get(i2), 0), C4389j.m847a(m841e.get(i2), 1), C4389j.m847a(m841e.get(i2), 2), (byte) 0));
            }
        }
        c4173b.f22429ad = C4389j.m842d(jSONObject, "available_area_codes");
        c4173b.f22466bt = C4389j.m846a(jSONObject, "promotion_change_info");
        c4173b.f22428ac = C4389j.m842d(jSONObject, "user_info");
        c4173b.f22490z = C4389j.m842d(jSONObject, "rules");
        c4173b.f22400Z = C4389j.m843c(jSONObject, "service_url");
        c4173b.f22426aa = C4389j.m843c(jSONObject, "bind_url");
        c4173b.f22430ae = C4389j.m846a(jSONObject, "empty_info");
        c4173b.f22424aY = C4389j.m846a(jSONObject, "add_card_tip");
        c4173b.f22442aq = C4389j.m846a(jSONObject, Constant.KEY_PAN);
        return i;
    }

    /* renamed from: c */
    public static boolean m1474c(C4173b c4173b, JSONObject jSONObject) {
        c4173b.f22405aF = null;
        c4173b.f22405aF = C4389j.m843c(jSONObject, "cardExpireMsgBox");
        if (c4173b.f22405aF == null) {
            c4173b.f22405aF = C4389j.m843c(jSONObject, "openByCounterMsgBox");
        }
        if (c4173b.f22405aF == null) {
            c4173b.f22405aF = C4389j.m843c(jSONObject, "restrictPayMsgBox");
        }
        if (c4173b.f22405aF != null) {
            c4173b.f22406aG = C4389j.m846a(c4173b.f22405aF, "title");
            c4173b.f22407aH = C4389j.m846a(c4173b.f22405aF, "text");
            JSONObject m843c = C4389j.m843c(c4173b.f22405aF, "func");
            JSONObject m843c2 = C4389j.m843c(c4173b.f22405aF, "cancel");
            c4173b.f22410aK = C4389j.m846a(m843c, "label");
            c4173b.f22411aL = C4389j.m846a(m843c, "action");
            c4173b.f22408aI = C4389j.m846a(m843c2, "label");
            c4173b.f22409aJ = C4389j.m846a(m843c2, "action");
            return true;
        }
        return false;
    }
}
