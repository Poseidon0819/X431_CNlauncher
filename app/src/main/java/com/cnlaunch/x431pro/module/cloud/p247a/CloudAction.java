package com.cnlaunch.x431pro.module.cloud.p247a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.cloud.model.CloudData;
import com.cnlaunch.x431pro.module.cloud.model.CloudHistoryDetailResponse;
import com.cnlaunch.x431pro.module.cloud.model.CloudReportListResponse;
import com.cnlaunch.x431pro.module.cloud.model.PlateResponse;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.html.HtmlTags;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.module.cloud.a.b */
/* loaded from: classes.dex */
public final class CloudAction extends BaseAction {
    public CloudAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final PlateResponse m5422a(String str) {
        try {
            String b = m5451b("get_plate_by_vin");
            NLog.m9452b("XEE", "431_HTT_GET_PLATE_BY_VIN url:".concat(String.valueOf(b)));
            if (TextUtils.isEmpty(b)) {
                b = "http://ait.golo365.com/Home/HttApi/getPlateByVin?";
            }
            C1426i c1426i = new C1426i();
            c1426i.m9506a("vin", str);
            NLog.m9452b("XEE", "查询车牌 vin=:" + c1426i.toString());
            String m9475b = this.f15446f.m9475b(b, c1426i);
            NLog.m9451c("XEE", "vin查询车牌返回json:".concat(String.valueOf(m9475b)));
            if (TextUtils.isEmpty(m9475b)) {
                return null;
            }
            return (PlateResponse) m5438a(m9475b, PlateResponse.class);
        } catch (C1425f e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final boolean m5423a(CloudData cloudData) {
        try {
            String b = m5451b("upload_report_data");
            if (TextUtils.isEmpty(b)) {
                b = "http://ait.golo365.com/Home/Cloud/upload_report_data?";
            }
            C1426i c1426i = new C1426i();
            c1426i.m9506a("serial_no", cloudData.f15491a);
            c1426i.m9506a(VastExtensionXmlManager.TYPE, cloudData.f15492b);
            c1426i.m9506a("diagnose_no", cloudData.f15493c);
            c1426i.m9506a("content", URLEncoder.encode(cloudData.f15494d, "utf-8"));
            c1426i.m9506a("bag_no", cloudData.f15495e);
            Log.i("XEE", "--->开始上传:" + cloudData.toString());
            String m9475b = this.f15446f.m9475b(b, c1426i);
            Log.e("XEE", "--->上传返回json:".concat(String.valueOf(m9475b)));
            try {
                return new JSONObject(m9475b).getInt("code") == 0;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        } catch (C1425f e2) {
            Log.e("XEE", "--->上传失败:" + e2.toString());
            e2.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e3) {
            Log.e("XEE", "--->上传失败UnsupportedEncodingException :" + e3.toString());
            e3.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final CloudReportListResponse m5420a(String str, String str2, String str3, int i, int i2) {
        try {
            String b = m5451b("report_list");
            NLog.m9452b("XEE", "X431_HTT_GET_REPORT_LIST 配置是否下发 url:".concat(String.valueOf(b)));
            if (TextUtils.isEmpty(b)) {
                b = "http://ait.golo365.com/Home/HttApi/reportList?";
            }
            C1426i c1426i = new C1426i();
            if (!TextUtils.isEmpty(str)) {
                c1426i.m9506a("vin", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                c1426i.m9506a("plate_num", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                c1426i.m9506a("cvn", str3);
            }
            if (i > 0) {
                c1426i.m9506a(Annotation.PAGE, String.valueOf(i));
            }
            if (i2 > 0) {
                c1426i.m9506a(HtmlTags.SIZE, String.valueOf(i2));
            }
            NLog.m9452b("XEE", "查询云历史列表参数:" + c1426i.toString());
            String m9475b = this.f15446f.m9475b(b, c1426i);
            NLog.m9452b("XEE", "查询历史记录列表返回json:".concat(String.valueOf(m9475b)));
            if (TextUtils.isEmpty(m9475b)) {
                return null;
            }
            return (CloudReportListResponse) m5438a(m9475b, CloudReportListResponse.class);
        } catch (C1425f e) {
            Log.e("XEE", "--->查询历史记录失败:" + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final CloudHistoryDetailResponse m5421a(String str, String str2) {
        try {
            String b = m5451b("report_detail");
            if (TextUtils.isEmpty(b)) {
                b = "http://ait.golo365.com/Home/HttApi/reportDetail?";
            }
            C1426i c1426i = new C1426i();
            c1426i.m9506a("diagnose_record_id", str);
            c1426i.m9506a("report_type", str2);
            NLog.m9452b("XEE", "查询云历史详情参数:" + c1426i.toString());
            String m9475b = this.f15446f.m9475b(b, c1426i);
            NLog.m9452b("XEE", "查询历史记录详情返回json:".concat(String.valueOf(m9475b)));
            if (TextUtils.isEmpty(m9475b)) {
                return null;
            }
            return (CloudHistoryDetailResponse) m5438a(m9475b, CloudHistoryDetailResponse.class);
        } catch (C1425f e) {
            Log.e("XEE", "--->getCloudHistroyDetail err:" + e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
