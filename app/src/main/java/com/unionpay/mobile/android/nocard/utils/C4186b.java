package com.unionpay.mobile.android.nocard.utils;

import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.utils.b */
/* loaded from: classes2.dex */
public final class C4186b {
    /* renamed from: a */
    public static void m1483a(JSONObject jSONObject, C4173b c4173b) {
        c4173b.f22444as = C4389j.m846a(jSONObject, "red_packet_url");
    }

    /* renamed from: b */
    public static void m1482b(JSONObject jSONObject, C4173b c4173b) {
        c4173b.f22417aR = C4389j.m846a(jSONObject, "pay_msg");
        c4173b.f22460bj = C4389j.m846a(jSONObject, "reserved");
        c4173b.f22418aS = C4389j.m846a(jSONObject, "promotion_msg");
        c4173b.f22419aT = C4389j.m846a(jSONObject, "instalment_msg");
        c4173b.f22422aW = C4389j.m846a(jSONObject, "temporary_pay_flag");
        if ("0".equalsIgnoreCase(c4173b.f22422aW)) {
            c4173b.f22423aX = C4389j.m846a(jSONObject, "temporary_pay_info");
        }
        if ("0".equalsIgnoreCase(C4389j.m846a(jSONObject, "luck_draw_flag"))) {
            c4173b.f22421aV = true;
        }
    }
}
