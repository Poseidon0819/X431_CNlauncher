package com.unionpay.mobile.android.nocard.views.xlistview;

import android.content.Context;
import android.text.TextUtils;
import com.itextpdf.text.html.HtmlTags;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.InterfaceC4174c;
import com.unionpay.mobile.android.resource.C4342c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.nocard.views.xlistview.a */
/* loaded from: classes2.dex */
public final class C4257a {
    /* renamed from: a */
    public static List<Map<String, Object>> m1339a(Context context, List<InterfaceC4174c> list, boolean z) {
        String str;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            InterfaceC4174c interfaceC4174c = list.get(i);
            if (interfaceC4174c != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("text1", interfaceC4174c.mo1539e());
                if (interfaceC4174c.mo1541c() == 0) {
                    str = interfaceC4174c.mo1542b();
                } else if (!TextUtils.isEmpty(interfaceC4174c.mo1542b())) {
                    str = interfaceC4174c.mo1542b().substring(0, 4) + " **** **** " + interfaceC4174c.mo1542b().substring(interfaceC4174c.mo1542b().length() - 4);
                }
                hashMap.put("text2", str);
                if (z) {
                    if (interfaceC4174c.mo1541c() == 0) {
                        hashMap.put("editable", Boolean.TRUE);
                        hashMap.put("icon", C4342c.m1036a(context).m1037a(1016, -1, -1));
                    } else {
                        hashMap.put("editable", Boolean.FALSE);
                        hashMap.put("icon", null);
                    }
                }
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static JSONObject m1338a(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("href_label", jSONObject.get("label"));
            jSONObject2.put("name", "");
            jSONObject2.put("value", "");
            jSONObject2.put("href_title", str);
            jSONObject2.put("label", C4171c.f22227bD.f22360z);
            jSONObject2.put("required", "0");
            jSONObject2.put("href_url", jSONObject.get(HtmlTags.HREF));
            jSONObject2.put("error_info", C4171c.f22227bD.f22260aF);
            jSONObject2.put("checked", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject2;
    }
}
