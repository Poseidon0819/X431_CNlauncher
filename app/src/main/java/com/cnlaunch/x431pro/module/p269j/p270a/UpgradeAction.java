package com.cnlaunch.x431pro.module.p269j.p270a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.SyncHttpTransportSE;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p241a.SoapObjectParams;
import com.cnlaunch.x431pro.module.p269j.SoftMaxVersionResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.GetLatestApkVersionResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.HistoryDiagSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestDiagSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestDivisionSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestPublicSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.PublicSoftLatestVersionResult;
import java.io.IOException;
import org.jivesoftware.smackx.packet.MultipleAddresses;
import org.p388a.p389a.SoapObject;
import org.p388a.p389a.SoapSerializationEnvelope;
import org.p393b.p395b.C4920a;
import org.xmlpull.p398v1.XmlPullParserException;

/* renamed from: com.cnlaunch.x431pro.module.j.a.a */
/* loaded from: classes.dex */
public final class UpgradeAction extends BaseAction {

    /* renamed from: s */
    private final int f15574s;

    public UpgradeAction(Context context) {
        super(context);
        this.f15574s = 10000;
    }

    /* renamed from: a */
    public final LatestDiagSoftsResponse m5281a(String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b(KeyConstant.f6840an);
        this.f15442d = m5447d("queryLatestDiagSofts");
        this.f15442d.mo169a("serialNo", str2);
        this.f15442d.mo169a("lanId", str3);
        this.f15442d.mo169a("defaultLanId", str4);
        this.f15442d.mo169a(MultipleAddresses.f24412CC, str);
        try {
            this.f15447g = m5439a(b, 10000);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                return (LatestDiagSoftsResponse) m5441a(LatestDiagSoftsResponse.class, "x431PadSoftList");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final LatestPublicSoftsResponse m5282a(String str, String str2, String str3) throws C1425f {
        String b = m5451b(KeyConstant.f6841ao);
        this.f15442d = m5447d("queryLatestPublicSofts");
        this.f15442d.mo169a("serialNo", str);
        this.f15442d.mo169a("lanId", str2);
        this.f15442d.mo169a("defaultLanId", str3);
        try {
            this.f15447g = m5439a(b, 10000);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                return (LatestPublicSoftsResponse) m5441a(LatestPublicSoftsResponse.class, "x431PadSoftList");
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: b */
    public final HistoryDiagSoftsResponse m5278b(String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b(KeyConstant.f6840an);
        this.f15442d = m5447d("queryHistoryDiagSofts");
        this.f15442d.mo169a("serialNo", str);
        this.f15442d.mo169a("softId", str2);
        this.f15442d.mo169a("lanId", str3);
        this.f15442d.mo169a("defaultLanId", str4);
        try {
            this.f15447g = m5439a(b, 10000);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                return (HistoryDiagSoftsResponse) m5441a(HistoryDiagSoftsResponse.class, "x431PadSoftList");
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: a */
    public final BaseResponse m5280a(String str, String str2, String str3, String str4, String str5, String str6) throws C1425f {
        String b = m5451b(KeyConstant.f6839am);
        this.f15442d = m5447d("updateDownloadLog");
        this.f15442d.mo169a("downloadId", str);
        this.f15442d.mo169a("state", str2);
        this.f15442d.mo169a("downloadedSize", str3);
        this.f15442d.mo169a("downloadDuration", str4);
        this.f15442d.mo169a("currentNetworkSpeed", str5);
        this.f15442d.mo169a("currentConfigArea", str6);
        try {
            this.f15447g = m5439a(b, 10000);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                return (BaseResponse) m5444a((Class<Object>) BaseResponse.class);
            }
            return null;
        } catch (IOException e) {
            throw new C1425f(e);
        } catch (XmlPullParserException e2) {
            throw new C1425f(e2);
        }
    }

    /* renamed from: a */
    public final PublicSoftLatestVersionResult m5283a(Integer num, String str, String str2, String str3) throws C1425f {
        String b = m5451b(KeyConstant.f6841ao);
        this.f15442d = m5447d("queryLatestSoftVersionInfoForUniversalTool");
        this.f15442d.mo169a("lanId", num);
        this.f15442d.mo169a("pdtType", str);
        this.f15442d.mo169a("softName", str2);
        this.f15442d.mo169a("serialNo", str3);
        try {
            this.f15447g = m5439a(b, 10000);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                return (PublicSoftLatestVersionResult) m5444a((Class<Object>) PublicSoftLatestVersionResult.class);
            }
            return null;
        } catch (Exception e) {
            throw new C1425f(e);
        }
    }

    /* renamed from: c */
    public final LatestDivisionSoftsResponse m5276c(String str, String str2, String str3, String str4) throws C1425f {
        NLog.m9456a("yhx", "queryTheSoftDivisions enter");
        String b = m5451b(KeyConstant.f6840an);
        this.f15442d = m5447d("queryDiagSoftSubPackOneSoft");
        this.f15442d.mo169a("serialNo", str);
        this.f15442d.mo169a("softPackageId", str2);
        this.f15442d.mo169a("lanId", str3);
        this.f15442d.mo169a("defaultLanId", str4);
        try {
            this.f15447g = m5439a(b, 10000);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            LatestDivisionSoftsResponse latestDivisionSoftsResponse = this.f15448h != null ? (LatestDivisionSoftsResponse) m5441a(LatestDivisionSoftsResponse.class, "diagSoftSubPackList") : null;
            NLog.m9456a("yhx", "queryTheSoftDivisions response=".concat(String.valueOf(latestDivisionSoftsResponse)));
            return latestDivisionSoftsResponse;
        } catch (Exception e) {
            NLog.m9455a(e);
            throw new C1425f(e);
        }
    }

    /* renamed from: b */
    public final LatestDivisionSoftsResponse m5279b(String str, String str2, String str3) throws C1425f {
        String b = m5451b(KeyConstant.f6840an);
        this.f15442d = m5447d("queryPDTDiagSoftSubPack");
        this.f15442d.mo169a("serialNo", str);
        this.f15442d.mo169a("lanId", str2);
        this.f15442d.mo169a("defaultLanId", str3);
        LatestDivisionSoftsResponse latestDivisionSoftsResponse = null;
        try {
            this.f15447g = m5439a(b, 10000);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                latestDivisionSoftsResponse = (LatestDivisionSoftsResponse) m5441a(LatestDivisionSoftsResponse.class, "diagSoftSubPackList");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        NLog.m9456a("yhx", "queryLatestDivisionSofts response=".concat(String.valueOf(latestDivisionSoftsResponse)));
        return latestDivisionSoftsResponse;
    }

    /* renamed from: d */
    public final LatestDiagSoftsResponse m5275d(String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b(KeyConstant.f6840an);
        NLog.m9456a("msp", "getSpecifiedDiagSoftLatestInfo, serviceUrl: ".concat(String.valueOf(b)));
        SoapObjectParams d = m5447d("getSpecifiedDiagSoftLatestInfo");
        d.mo169a("serialNo", str);
        d.mo169a("diagSoftId", str2);
        d.mo169a("lanId", str3);
        d.mo169a("defaultLanId", str4);
        NLog.m9456a("msp", "getSpecifiedDiagSoftLatestInfo, requestParams: " + d.toString());
        try {
            SyncHttpTransportSE a = m5439a(b, 10000);
            SoapSerializationEnvelope a2 = m5437a(m5453a((SoapObject) d), d);
            a.m141a("", a2);
            if (a2 != null) {
                return (LatestDiagSoftsResponse) m5442a(LatestDiagSoftsResponse.class, a2, "x431PadSoftList");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public final SoftMaxVersionResponse m5274e(String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b(KeyConstant.f6840an);
        SoapObjectParams d = m5447d("getDiagSoftLatestInfoBySoftName");
        d.mo169a("serialNo", str);
        d.mo169a("softName", str2);
        d.mo169a("lanId", str3);
        d.mo169a("defaultLanId", str4);
        NLog.m9456a("msp", "getDiagSoftLatestInfoBySoftName, requestParams: " + d.toString());
        try {
            SyncHttpTransportSE a = m5439a(b, 10000);
            SoapSerializationEnvelope a2 = m5437a(m5453a((SoapObject) d), d);
            a.m141a("", a2);
            if (a2 != null) {
                return (SoftMaxVersionResponse) m5443a(SoftMaxVersionResponse.class, a2);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public final GetLatestApkVersionResponse m5277c(String str, String str2, String str3) throws C1425f {
        String b = m5451b(KeyConstant.f6857bD);
        if (TextUtils.isEmpty(b)) {
            b = "https://mycar.x431.com/services/publicSoftService?wsdl";
        }
        NLog.m9456a("yhx", "queryLatestApkVersionApkVersion enter,softName=" + str + ",lanId=" + str2 + ",imei=" + str3 + ",serviceUrl=" + b);
        SoapObjectParams d = m5447d("getMaxVersionForMobileApp");
        d.mo169a("softName", str);
        d.mo169a("lanId", str2);
        if (!TextUtils.isEmpty(str3)) {
            d.mo169a("imei", str3);
        }
        GetLatestApkVersionResponse getLatestApkVersionResponse = null;
        try {
            SyncHttpTransportSE a = m5439a(b, 10000);
            SoapSerializationEnvelope a2 = m5437a((C4920a[]) null, d);
            a.m141a("", a2);
            if (a2 != null) {
                getLatestApkVersionResponse = (GetLatestApkVersionResponse) m5443a(GetLatestApkVersionResponse.class, a2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        NLog.m9456a("yhx", "queryLatestApkVersion response=".concat(String.valueOf(getLatestApkVersionResponse)));
        return getLatestApkVersionResponse;
    }
}
