package com.launch.p353a.p364k;

import android.app.Activity;
import android.util.Log;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.launch.a.k.i */
/* loaded from: classes.dex */
public final class UrlUtils {

    /* renamed from: a */
    public static boolean f19972a = false;

    /* renamed from: b */
    private static String f19973b = "http://ad.adbc9.com/push-api/v2/adservice";

    /* renamed from: c */
    private static String f19974c;

    /* renamed from: d */
    private static final char[] f19975d = {'0', '1', PdfWriter.VERSION_1_2, PdfWriter.VERSION_1_3, PdfWriter.VERSION_1_4, PdfWriter.VERSION_1_5, PdfWriter.VERSION_1_6, PdfWriter.VERSION_1_7, '8', '9', 'a', 'b', Barcode128.CODE_AB_TO_C, Barcode128.CODE_AC_TO_B, Barcode128.CODE_BC_TO_A, Barcode128.FNC1_INDEX};

    /* renamed from: a */
    public static String m2628a(Activity activity, String str, String str2) {
        f19974c = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("posId", str);
            jSONObject.accumulate("count", "1");
            jSONObject.accumulate("posWidth", "");
            jSONObject.accumulate("posHeight", "");
            jSONObject.accumulate("deviceType", "golo");
            jSONObject.accumulate("deviceUid", StringUtil.m2629a(PhoneInfoUtils.m2633a(activity)) ? PhoneInfoUtils.m2634a() : PhoneInfoUtils.m2633a(activity));
            jSONObject.accumulate("deviceOs", "android");
            jSONObject.accumulate("appId", LUAsdk.f19966a);
            if (C3667e.f19970b == 0.0d) {
                jSONObject.accumulate("locationType", "02");
            } else {
                jSONObject.accumulate("locationType", "01");
            }
            jSONObject.accumulate("longitude", Double.valueOf(C3667e.f19970b));
            jSONObject.accumulate("latitude", Double.valueOf(C3667e.f19969a));
            String string = activity.getSharedPreferences("SHARE_DATA", 0).getString("lauip", "");
            if (!string.equals("")) {
                jSONObject.accumulate("ip", string);
            } else {
                jSONObject.accumulate("ip", LUAsdk.f19967b);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis() / 1000);
            jSONObject.accumulate("request_time", sb.toString());
            if (StringUtil.m2629a(str2)) {
                str2 = "{}";
            }
            jSONObject.accumulate("extendParams", str2);
            String jSONObject2 = jSONObject.toString();
            f19974c = jSONObject2;
            Log.e("data==", jSONObject2);
            f19974c = f19974c.replace("\"", "%22").replace("{", "%7b").replace("}", "%7d");
            return f19973b + "/getadinfo?accessKeyId=" + LUAsdk.f19966a + "&paramData=" + f19974c + "&signature=" + m2623c("paramData=" + jSONObject2 + "&appKeySecret=" + LUAsdk.m2640a());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m2627a(String str) {
        try {
            f19974c = "";
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("view_id", str);
            String jSONObject2 = jSONObject.toString();
            f19974c = jSONObject2;
            f19974c = f19974c.replace("\"", "%22").replace("{", "%7b").replace("}", "%7d");
            return f19973b + "/displayevent?accessKeyId=" + LUAsdk.f19966a + "&paramData=" + f19974c + "&signature=" + m2623c("paramData=" + jSONObject2 + "&appKeySecret=" + LUAsdk.m2640a());
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    public static String m2624b(String str) {
        f19974c = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("view_id", str);
            f19974c = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String str2 = f19974c;
        f19974c = str2.replace("\"", "%22").replace("{", "%7b").replace("}", "%7d");
        return f19973b + "/clickevent?accessKeyId=" + LUAsdk.f19966a + "&paramData=" + f19974c + "&signature=" + m2623c("paramData=" + str2 + "&appKeySecret=" + LUAsdk.m2640a());
    }

    /* renamed from: c */
    private static String m2623c(String str) {
        return (str == null || str.length() == 0) ? "" : m2626a(m2625a(str.getBytes(), "md5"));
    }

    /* renamed from: a */
    private static String m2626a(byte[] bArr) {
        int length;
        if (bArr != null && (length = bArr.length) > 0) {
            char[] cArr = new char[length << 1];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i + 1;
                char[] cArr2 = f19975d;
                cArr[i] = cArr2[(bArr[i2] >> 4) & 15];
                i = i3 + 1;
                cArr[i3] = cArr2[bArr[i2] & 15];
            }
            return new String(cArr);
        }
        return "";
    }

    /* renamed from: a */
    private static byte[] m2625a(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
