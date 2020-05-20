package com.unionpay;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.unionpay.utils.C4644b;
import com.unionpay.utils.C4651i;
import com.unionpay.utils.UPUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.b */
/* loaded from: classes2.dex */
final class C4126b implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        boolean z;
        String str;
        Context context;
        String str2;
        Context context2;
        String str3;
        String str4;
        Context context3;
        String str5;
        String str6;
        String str7;
        boolean z2;
        JSONArray m1674b;
        Context context4;
        String str8;
        String str9;
        Context context5;
        JSONArray jSONArray;
        int i;
        switch (message2.what) {
            case 1001:
                UPPayAssistEx.m1657n();
                break;
            case 1002:
                try {
                    if (message2.obj != null) {
                        JSONObject jSONObject = new JSONObject((String) message2.obj);
                        String m438a = C4651i.m438a(jSONObject, "sign");
                        int i2 = 0;
                        try {
                            str9 = UPPayAssistEx.f21990K;
                            i2 = Integer.parseInt(str9);
                        } catch (NumberFormatException unused) {
                        }
                        String str10 = new String(Base64.decode(jSONObject.getString("configs"), 2));
                        String str11 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : "";
                        if (TextUtils.isEmpty(str11)) {
                            str11 = "";
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(str10);
                        sb.append(str11);
                        str = UPPayAssistEx.f21987H;
                        sb.append(str);
                        String m461a = C4644b.m461a(UPUtils.m471a(sb.toString()));
                        String forConfig = UPUtils.forConfig(i2, m438a);
                        if (!TextUtils.isEmpty(forConfig) && forConfig.equals(m461a)) {
                            context = UPPayAssistEx.f21986G;
                            StringBuilder sb2 = new StringBuilder("configs");
                            str2 = UPPayAssistEx.f21982C;
                            sb2.append(str2);
                            UPUtils.m472a(context, (String) message2.obj, sb2.toString());
                            context2 = UPPayAssistEx.f21986G;
                            str3 = UPPayAssistEx.f21990K;
                            StringBuilder sb3 = new StringBuilder("mode");
                            str4 = UPPayAssistEx.f21982C;
                            sb3.append(str4);
                            UPUtils.m472a(context2, str3, sb3.toString());
                            context3 = UPPayAssistEx.f21986G;
                            str5 = UPPayAssistEx.f21987H;
                            StringBuilder sb4 = new StringBuilder("or");
                            str6 = UPPayAssistEx.f21982C;
                            sb4.append(str6);
                            UPUtils.m472a(context3, str5, sb4.toString());
                            str7 = UPPayAssistEx.f21980A;
                            if (!TextUtils.isEmpty(str7)) {
                                context4 = UPPayAssistEx.f21986G;
                                StringBuilder sb5 = new StringBuilder("se_configs");
                                str8 = UPPayAssistEx.f21980A;
                                sb5.append(str8);
                                UPUtils.m472a(context4, str11, sb5.toString());
                            }
                            z2 = UPPayAssistEx.f21995P;
                            if (!z2) {
                                m1674b = UPPayAssistEx.m1674b(new JSONArray(str10), "sort");
                                JSONArray unused2 = UPPayAssistEx.f22002W = m1674b;
                                UPPayAssistEx.m1669d(str11);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                z = UPPayAssistEx.f21995P;
                if (z) {
                    return true;
                }
                break;
            default:
                return true;
        }
        context5 = UPPayAssistEx.f21986G;
        jSONArray = UPPayAssistEx.f22002W;
        i = UPPayAssistEx.f21994O;
        UPPayAssistEx.m1683a(context5, jSONArray, i);
        return true;
    }
}
