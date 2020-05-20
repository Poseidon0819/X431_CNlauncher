package com.cnlaunch.x431pro.module.p263h.p264a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryDetailResponse;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagLogHistoryResponse;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagSoftRewardRecordResponse;
import com.cnlaunch.x431pro.module.p263h.p265b.DiagnosticLogCategoryResponse;
import com.cnlaunch.x431pro.module.p263h.p265b.UploadDiagnosticLogResponse;
import com.cnlaunch.x431pro.module.p263h.p265b.UploadServerCheckLogResponse;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseLogInfoSearchUtil;
import java.io.IOException;
import java.util.HashMap;
import org.p388a.p389a.SoapObject;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.cnlaunch.x431pro.module.h.a.a */
/* loaded from: classes.dex */
public final class SettingAction extends BaseAction {
    public SettingAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final UploadServerCheckLogResponse m5307a(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6810aJ);
        HashMap hashMap = new HashMap();
        hashMap.put("serialNo", str);
        hashMap.put("sign", m5445e(str2));
        return (UploadServerCheckLogResponse) m5438a(m5454a(b, hashMap, str2), UploadServerCheckLogResponse.class);
    }

    /* renamed from: a */
    public final UploadDiagnosticLogResponse m5309a(DiagnoseLogInfoSearchUtil.C2749a c2749a, String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b(KeyConstant.f6806aF);
        HashMap hashMap = new HashMap();
        hashMap.put("serialNo", c2749a.getDeviceSN());
        hashMap.put("sign", m5445e(c2749a.getZipFilePath()));
        hashMap.put("vehicleType", c2749a.getVehicleSoftname());
        hashMap.put("remark", str);
        hashMap.put("logType", str2);
        hashMap.put("lang", str3);
        if (!C2787z.m4821a(str4)) {
            hashMap.put("subLogType", str4);
        }
        if (!C2787z.m4821a(c2749a.getModel())) {
            hashMap.put("model", c2749a.getModel());
        }
        if (!C2787z.m4821a(c2749a.getModel())) {
            hashMap.put("year", c2749a.getYear());
        }
        if (!C2787z.m4821a(c2749a.getModel())) {
            hashMap.put("vin", c2749a.getVIN());
        }
        return (UploadDiagnosticLogResponse) m5438a(m5454a(b, hashMap, c2749a.getZipFilePath()), UploadDiagnosticLogResponse.class);
    }

    /* renamed from: a */
    public final DiagLogHistoryResponse m5306a(String str, String str2, String str3) throws C1425f {
        String b = m5451b(KeyConstant.f6818aR);
        this.f15442d = m5447d("queryDiagnosticLogBasic");
        this.f15442d.mo169a("serialNo", str);
        this.f15442d.mo169a("startDate", str2);
        this.f15442d.mo169a("endDate", str3);
        try {
            this.f15447g = m5436f(b);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            NLog.m9451c("settingAction", this.f15447g.f24138e);
            if (this.f15448h != null) {
                return (DiagLogHistoryResponse) m5441a(DiagLogHistoryResponse.class, "diagLogBasicDTOList");
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: a */
    public final DiagLogHistoryDetailResponse m5308a(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6818aR);
        this.f15442d = m5447d("queryDiagnosticLogDetail");
        this.f15442d.mo169a("logId", str);
        try {
            this.f15447g = m5436f(b);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            NLog.m9451c("settingAction", this.f15447g.f24138e);
            if (this.f15448h != null) {
                return (DiagLogHistoryDetailResponse) m5444a((Class<Object>) DiagLogHistoryDetailResponse.class);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: g */
    public final DiagnosticLogCategoryResponse m5304g(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6818aR);
        this.f15442d = m5447d("queryDiagnosticLogCategory");
        this.f15442d.mo169a("ids", str);
        try {
            this.f15447g = m5436f(b);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            NLog.m9451c("settingAction", this.f15447g.f24138e);
            if (this.f15448h != null) {
                return (DiagnosticLogCategoryResponse) m5444a((Class<Object>) DiagnosticLogCategoryResponse.class);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: b */
    public final DiagSoftRewardRecordResponse m5305b(String str, String str2) throws C1425f {
        String b = m5451b("getDiagSoftDescResult");
        this.f15442d = m5447d("queryDiagSoftRewardRecordForPro3");
        this.f15442d.mo169a("serialNo", str);
        if (!TextUtils.isEmpty(str2)) {
            this.f15442d.mo169a("rewardId", str2);
        } else {
            this.f15442d.mo169a("rewardId", "112");
        }
        try {
            this.f15447g = m5436f(b);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            NLog.m9451c("settingAction", this.f15447g.f24138e);
            if (this.f15448h != null) {
                return (DiagSoftRewardRecordResponse) m5444a((Class<Object>) DiagSoftRewardRecordResponse.class);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }
}
