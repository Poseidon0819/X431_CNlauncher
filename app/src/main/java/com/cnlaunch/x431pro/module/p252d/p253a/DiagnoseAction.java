package com.cnlaunch.x431pro.module.p252d.p253a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.DiagnoseBusiness;
import com.cnlaunch.diagnosemodule.bean.BasicDiagDownloadFileBean;
import com.cnlaunch.diagnosemodule.bean.BasicOnlineArithBean;
import com.cnlaunch.diagnosemodule.bean.BasicOnlineCodeLib;
import com.cnlaunch.diagnosemodule.bean.BasicQueryArgToWebSiteBean;
import com.cnlaunch.diagnosemodule.utils.ByteHexHelper;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.p120d.p125c.p128c.SyncHttpTransportSE;
import com.cnlaunch.p120d.p130d.MD5Utils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.physics.p197c.DPUHardwareInfo;
import com.cnlaunch.physics.p205k.DeviceUtils;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.module.p241a.SoapObjectParams;
import com.cnlaunch.x431pro.module.p252d.p254b.AdvertiseResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.GetHelpDocResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.GetQueryWebResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.OnLineArithResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.OnLineFaultCodeQueryResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.OnLineFaultCodesWithSysQueryResponse;
import com.cnlaunch.x431pro.module.p252d.p254b.OnlineFaultCodeHelpInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.QuerySerialNosForbitFLagResponse;
import com.cnlaunch.x431pro.module.p263h.p265b.FormFile;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.itextpdf.text.pdf.PdfContentParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.jivesoftware.smackx.packet.MultipleAddresses;
import org.json.JSONArray;
import org.json.JSONException;
import org.p388a.p389a.SoapSerializationEnvelope;
import org.p393b.p395b.C4920a;

/* renamed from: com.cnlaunch.x431pro.module.d.a.a */
/* loaded from: classes.dex */
public final class DiagnoseAction extends BaseAction {

    /* renamed from: s */
    private static boolean f15532s = false;

    public DiagnoseAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final GetHelpDocResponse m5374a(String str, String str2, String str3, String str4) throws C1425f {
        this.f15440b = new C1426i();
        this.f15440b.m9506a("autoCode", str);
        this.f15440b.m9506a("version", str2);
        this.f15440b.m9506a("dtchId", str3);
        this.f15440b.m9506a("lanId", str4);
        String m9477a = this.f15446f.m9477a("http://repairdata.cnlaunch.com/serve/rest/queryHelpDtcDocBycondition.json", this.f15440b);
        if (TextUtils.isEmpty(m9477a)) {
            return null;
        }
        NLog.m9451c("test", "postUrl=".concat(String.valueOf(m9477a)));
        GetHelpDocResponse getHelpDocResponse = (GetHelpDocResponse) m5438a(m9477a, GetHelpDocResponse.class);
        NLog.m9451c("test", "response=" + getHelpDocResponse.toString());
        NLog.m9451c("test", "response=" + getHelpDocResponse.getGetHelpDocResult().toString());
        return getHelpDocResponse;
    }

    /* renamed from: b */
    public final GetHelpDocResponse m5367b(String str, String str2, String str3, String str4) throws C1425f {
        this.f15440b = m5452b();
        this.f15440b.m9506a("autoCode", str);
        this.f15440b.m9506a("version", str2);
        this.f15440b.m9506a("funchId", str3);
        this.f15440b.m9506a("lanId", str4);
        String m9477a = this.f15446f.m9477a("http://repairdata.cnlaunch.com/serve/rest/queryFunchDocBycondition.json", this.f15440b);
        if (TextUtils.isEmpty(m9477a)) {
            return null;
        }
        NLog.m9451c("test", "postUrl=".concat(String.valueOf(m9477a)));
        GetHelpDocResponse getHelpDocResponse = (GetHelpDocResponse) m5438a(m9477a, GetHelpDocResponse.class);
        NLog.m9451c("test", "response=" + getHelpDocResponse.toString());
        NLog.m9451c("test", "response=" + getHelpDocResponse.getGetHelpDocResult().toString());
        return getHelpDocResponse;
    }

    /* renamed from: a */
    public final String m5376a(String str, String str2) throws C1425f {
        String b = m5451b(KeyConstant.f6884be);
        if (TextUtils.isEmpty(b)) {
            b = "http://diagdata.x431.com/carcodeservice/carTypeData/queryCarDataJson.json";
        }
        NLog.m9452b("DiagnoseAction", "queryWebByCondition url = ".concat(String.valueOf(b)));
        C1426i c1426i = new C1426i();
        String m9460a = MD5Utils.m9460a(str + str2 + PreferencesManager.m9595a(this.f15439a).m9591a("token"));
        c1426i.m9506a("tableName", str);
        c1426i.m9506a("queryCondition", str2);
        c1426i.m9506a(MultipleAddresses.f24412CC, PreferencesManager.m9595a(this.f15439a).m9591a("user_id"));
        c1426i.m9506a("sign", m9460a);
        try {
            String m9475b = this.f15446f.m9475b(b, c1426i);
            String substring = m9475b.substring(m9475b.indexOf("["), m9475b.lastIndexOf("]") + 1);
            NLog.m9452b("DiagnoseAction", "webquery json=".concat(String.valueOf(m9475b)));
            NLog.m9452b("DiagnoseAction", "webquery data=".concat(String.valueOf(substring)));
            try {
                JSONArray jSONArray = new JSONArray(substring);
                NLog.m9452b("DiagnoseAction", "webquery jsonArray.size=" + jSONArray.length());
                return jSONArray.length() + "," + substring.replace("[", "").replace("]", "");
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        } catch (C1425f e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public final BaseResponse m5377a(String str, BasicQueryArgToWebSiteBean basicQueryArgToWebSiteBean) throws C1425f, FileNotFoundException {
        String trim = ByteHexHelper.hexStringToWord(basicQueryArgToWebSiteBean.getQueryWebSiteBean().get(0).getValue()).trim();
        String trim2 = ByteHexHelper.hexStringToWord(basicQueryArgToWebSiteBean.getQueryWebSiteBean().get(1).getValue()).trim();
        (m5451b("diagonline_url") + m5451b("diagreq_uploadzip_method")).isEmpty();
        String str2 = "zipRequestFile";
        String str3 = m5451b("diagonline_url") + m5451b("diagreq_uploadxml_method");
        if (str3.isEmpty()) {
            str3 = "http://172.16.65.79/online/kiswb/xmlRequest/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        sb.append(trim);
        sb.append("/");
        sb.append(trim2);
        sb.append("/");
        sb.append(str);
        sb.append("/");
        sb.append(basicQueryArgToWebSiteBean.getKey());
        sb.append("/");
        sb.append(basicQueryArgToWebSiteBean.getfunType());
        sb.append("/ECU/SUBECU/");
        sb.append(PreferencesManager.m9595a(this.f15439a).m9591a("user_id"));
        sb.append("/");
        sb.append(MD5Utils.m9460a(basicQueryArgToWebSiteBean.getfunType() + trim + trim2 + basicQueryArgToWebSiteBean.getKey() + str + "SUBECUECU" + PreferencesManager.m9595a(this.f15439a).m9591a("token")));
        sb.append("/");
        String sb2 = sb.toString();
        String str4 = "";
        StringBuilder sb3 = new StringBuilder();
        sb3.append(Environment.getExternalStorageDirectory());
        sb3.append(DiagnoseConstants.DIAGNOSE_LIB_PATH);
        String sb4 = sb3.toString();
        sb4.replaceAll("//", "/");
        int size = basicQueryArgToWebSiteBean.getFileList().size();
        FormFile[] formFileArr = new FormFile[size];
        for (int i = 0; i < size; i++) {
            File file = new File(sb4 + basicQueryArgToWebSiteBean.getFileList().get(i));
            if (i == 0) {
                str2 = "fAxmlFile";
            } else if (i == 1) {
                str2 = "sVTxmlFile";
            }
            formFileArr[i] = new FormFile(file.getName(), file, str2, "multipart/form-data");
        }
        try {
            str4 = FileUtils.m5010a(sb2, new HashMap(), formFileArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String substring = str4.substring(str4.indexOf("{"), str4.lastIndexOf("}") + 1);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        return (BaseResponse) m5438a(substring, BaseResponse.class);
    }

    /* renamed from: a */
    public final GetQueryWebResponse m5375a(String str, String str2, String str3) throws C1425f {
        String str4 = m5451b("diagonline_url") + m5451b("diagresult_queryjson_method");
        if (str4.isEmpty()) {
            str4 = "http://172.16.65.79/online/kiswb/zipResponse/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append(str2);
        sb.append("/");
        sb.append(str);
        sb.append("/");
        sb.append(str3);
        sb.append("/");
        sb.append(PreferencesManager.m9595a(this.f15439a).m9591a("user_id"));
        sb.append("/");
        sb.append(MD5Utils.m9460a(str + str2 + str3 + PreferencesManager.m9595a(this.f15439a).m9591a("token")));
        sb.append("/");
        String m9475b = this.f15446f.m9475b(sb.toString(), new C1426i());
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (GetQueryWebResponse) m5438a(m9475b, GetQueryWebResponse.class);
    }

    /* renamed from: b */
    public final GetQueryWebResponse m5368b(String str, String str2, String str3) throws C1425f {
        String b = m5451b("diagonline_response_url");
        if (b.isEmpty()) {
            b = "http://cntestcomdiag.x431.com:8000/query/response/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        sb.append(str2);
        sb.append("/");
        sb.append(str);
        sb.append("/");
        sb.append(str3);
        sb.append("/");
        sb.append(PreferencesManager.m9595a(this.f15439a).m9591a("user_id"));
        sb.append("/");
        sb.append(MD5Utils.m9460a(str + str2 + str3 + PreferencesManager.m9595a(this.f15439a).m9591a("token")));
        sb.append("/");
        String m9475b = this.f15446f.m9475b(sb.toString(), new C1426i());
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (GetQueryWebResponse) m5438a(m9475b, GetQueryWebResponse.class);
    }

    /* renamed from: b */
    public final BaseResponse m5370b(String str, BasicQueryArgToWebSiteBean basicQueryArgToWebSiteBean) throws C1425f {
        String trim = ByteHexHelper.hexStringToWord(basicQueryArgToWebSiteBean.getQueryWebSiteBean().get(0).getValue()).trim();
        String trim2 = ByteHexHelper.hexStringToWord(basicQueryArgToWebSiteBean.getQueryWebSiteBean().get(1).getValue()).trim();
        String b = m5451b("diagonline_request_url");
        if (b.isEmpty()) {
            b = "http://cntestcomdiag.x431.com:8000/query/request/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b);
        sb.append(str);
        sb.append("/");
        sb.append(basicQueryArgToWebSiteBean.getKey());
        sb.append("/");
        sb.append(basicQueryArgToWebSiteBean.getfunType());
        sb.append("/ECU/SUBECU/");
        sb.append(PreferencesManager.m9595a(this.f15439a).m9591a("user_id"));
        sb.append("/");
        sb.append(MD5Utils.m9460a(basicQueryArgToWebSiteBean.getfunType() + trim + trim2 + basicQueryArgToWebSiteBean.getKey() + str + "SUBECUECU" + PreferencesManager.m9595a(this.f15439a).m9591a("token")));
        sb.append("/");
        String sb2 = sb.toString();
        String str2 = "";
        try {
            C1426i c1426i = new C1426i();
            c1426i.m9506a("param1", trim);
            c1426i.m9506a("param2", trim2);
            str2 = this.f15446f.m9475b(sb2, c1426i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String substring = str2.substring(str2.indexOf("{"), str2.lastIndexOf("}") + 1);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        return (BaseResponse) m5438a(substring, BaseResponse.class);
    }

    /* renamed from: a */
    public final BaseResponse m5380a(String str, BasicDiagDownloadFileBean basicDiagDownloadFileBean) throws C1425f {
        BaseResponse baseResponse = new BaseResponse();
        String b = m5451b(KeyConstant.f6882bc);
        if (TextUtils.isEmpty(b)) {
            b = "http://dlcenter.x431.com/mycarDownload/downloadProgrammingFile.action";
        }
        String str2 = (String) m5373a(str, b, basicDiagDownloadFileBean.getSoftID(), basicDiagDownloadFileBean.getFileVersion(), basicDiagDownloadFileBean.getLocalpath());
        for (int i = 0; str2.equals("-1") && i < 3; i++) {
            str2 = (String) m5373a(str, b, basicDiagDownloadFileBean.getSoftID(), basicDiagDownloadFileBean.getFileVersion(), basicDiagDownloadFileBean.getLocalpath());
        }
        if (str2.equals("0")) {
            baseResponse.setCode(PdfContentParser.COMMAND_TYPE);
        } else {
            try {
                baseResponse.setCode(Integer.valueOf(str2).intValue());
            } catch (Exception unused) {
                baseResponse.setCode(255);
            }
        }
        return baseResponse;
    }

    /* renamed from: a */
    public final BaseResponse m5378a(String str, BasicOnlineCodeLib basicOnlineCodeLib) throws C1425f {
        String b = m5451b("onlineFaultCodeQuery_url");
        if (TextUtils.isEmpty(b)) {
            b = "https://mycar.x431.com/rest/syscode/getDiagSoftDtc.json";
        }
        f15532s = false;
        C1426i c1426i = new C1426i();
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        StringBuilder sb = new StringBuilder();
        sb.append("0X");
        sb.append(basicOnlineCodeLib.getHelpID().substring(2, 4).equalsIgnoreCase("FF") ? "" : basicOnlineCodeLib.getHelpID().substring(4, 8));
        sb.append(basicOnlineCodeLib.getCodeID());
        String sb2 = sb.toString();
        String softID = basicOnlineCodeLib.getSoftID();
        String str2 = "0X" + basicOnlineCodeLib.getSmallCode();
        String str3 = "0X" + basicOnlineCodeLib.getCodeStatusID();
        String matchedLanguage = DiagnoseBusiness.getMatchedLanguage();
        c1426i.m9506a(MultipleAddresses.f24412CC, m9591a);
        c1426i.m9506a("autoCode", softID);
        c1426i.m9506a("dtcId", sb2);
        c1426i.m9506a("dtcStatusId", str3);
        c1426i.m9506a("serialNo", str);
        c1426i.m9506a("smallId", str2);
        c1426i.m9506a("lanCode", matchedLanguage);
        c1426i.m9506a("sign", MD5Utils.m9460a(softID + sb2 + str3 + matchedLanguage + str + str2 + PreferencesManager.m9595a(this.f15439a).m9591a("token")));
        try {
            String m9477a = this.f15446f.m9477a(b, c1426i);
            String substring = m9477a.substring(m9477a.indexOf("{", 1), m9477a.lastIndexOf("}"));
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            return (OnLineFaultCodeQueryResponse) m5438a(substring, OnLineFaultCodeQueryResponse.class);
        } catch (C1425f e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private BaseResponse m5366b(String str, String str2, ArrayList<BasicOnlineCodeLib> arrayList) throws C1425f {
        f15532s = true;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        String b = m5451b("onlineFaultCodeQueryWithSys_url");
        if (TextUtils.isEmpty(b)) {
            b = "http://onlinedtc.x431.com:80/carcodeservice/carTypeData/getDiagSoftDtc.json";
        }
        C1426i c1426i = new C1426i();
        String systemID = arrayList.get(0).getSystemID();
        StringBuilder sb = new StringBuilder();
        sb.append(arrayList.size());
        String sb2 = sb.toString();
        String matchedLanguage = DiagnoseBusiness.getMatchedLanguage();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("0X");
        sb3.append(arrayList.get(0).getHelpID().substring(2, 4).equalsIgnoreCase("FF") ? "" : arrayList.get(0).getHelpID().substring(4, 8));
        sb3.append(arrayList.get(0).getCodeID());
        String sb4 = sb3.toString();
        String m5382a = m5382a();
        String str3 = "0X" + arrayList.get(0).getSmallCode();
        String str4 = "0X" + arrayList.get(0).getCodeStatusID();
        String str5 = sb4;
        int i = 1;
        while (i < arrayList.size()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str5 + ",");
            sb5.append("0X");
            String str6 = b;
            sb5.append(arrayList.get(i).getHelpID().substring(2, 4).equalsIgnoreCase("FF") ? "" : arrayList.get(i).getHelpID().substring(4, 8));
            sb5.append(arrayList.get(i).getCodeID());
            str3 = (str3 + ",") + "0X" + arrayList.get(i).getSmallCode();
            str4 = (str4 + ",") + "0X" + arrayList.get(i).getCodeStatusID();
            i++;
            str5 = sb5.toString();
            b = str6;
        }
        String str7 = b;
        String str8 = str3;
        c1426i.m9506a("dtcSize", sb2);
        c1426i.m9506a("autoCode", str2);
        c1426i.m9506a("serialNo", str);
        c1426i.m9506a("lanCode", matchedLanguage);
        c1426i.m9506a("systemId", systemID);
        c1426i.m9506a("dtcId", str5);
        c1426i.m9506a("dtcStatusId", str4);
        c1426i.m9506a("version", "2");
        c1426i.m9506a("smallId", str8);
        c1426i.m9506a("sign", MD5Utils.m9460a(str2 + str5 + sb2 + str4 + matchedLanguage + str + str8 + systemID + "2" + MD5Utils.m9460a(m5382a)));
        try {
            String m9475b = this.f15446f.m9475b(str7, c1426i);
            return !TextUtils.isEmpty(m9475b) ? (OnLineFaultCodesWithSysQueryResponse) m5438a(m9475b, OnLineFaultCodesWithSysQueryResponse.class) : null;
        } catch (C1425f e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final BaseResponse m5381a(String str) throws C1425f {
        String b = m5451b("onlineUploadCarInfo_url");
        if (TextUtils.isEmpty(b)) {
            b = "http://onlinedtc.x431.com:80/carcodeservice/carTypeData/addCarData.json";
        }
        C1426i c1426i = new C1426i();
        c1426i.m9506a("autoCode", str);
        c1426i.m9506a("make", DiagnoseInfo.getInstance().getMake());
        c1426i.m9506a("vin", DiagnoseConstants.VIN_CODE);
        c1426i.m9506a("model", DiagnoseInfo.getInstance().getModel());
        c1426i.m9506a("year", DiagnoseInfo.getInstance().getYear());
        c1426i.m9506a("sign", MD5Utils.m9460a(str + "_" + DiagnoseConstants.VIN_CODE + "_" + DiagnoseInfo.getInstance().getMake() + "_" + DiagnoseInfo.getInstance().getModel() + "_" + DiagnoseInfo.getInstance().getYear()));
        try {
            String m9475b = this.f15446f.m9475b(b, c1426i);
            if (TextUtils.isEmpty(m9475b)) {
                return null;
            }
            return (BaseResponse) m5438a(m9475b, OnLineFaultCodeQueryResponse.class);
        } catch (C1425f e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final BaseResponse m5372a(String str, String str2, ArrayList<BasicOnlineCodeLib> arrayList) throws C1425f {
        if (PreferencesManager.m9595a(this.f15439a).m9583b("online_dtc_no_login", true)) {
            return m5366b(str, str2, arrayList);
        }
        f15532s = true;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        String b = m5451b("onlineFaultCodeQueryWithSys_url");
        if (TextUtils.isEmpty(b)) {
            b = "http://onlinedtc.x431.com:80/carcodeservice/carTypeData/getDiagSoftDtc.json";
        }
        C1426i c1426i = new C1426i();
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String systemID = arrayList.get(0).getSystemID();
        StringBuilder sb = new StringBuilder();
        sb.append(arrayList.size());
        String sb2 = sb.toString();
        String matchedLanguage = DiagnoseBusiness.getMatchedLanguage();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("0X");
        sb3.append(arrayList.get(0).getHelpID().substring(2, 4).equalsIgnoreCase("FF") ? "" : arrayList.get(0).getHelpID().substring(4, 8));
        sb3.append(arrayList.get(0).getCodeID());
        String sb4 = sb3.toString();
        String str3 = "0X" + arrayList.get(0).getSmallCode();
        String str4 = "0X" + arrayList.get(0).getCodeStatusID();
        String str5 = sb4;
        int i = 1;
        while (i < arrayList.size()) {
            String str6 = str5 + ",";
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str6);
            sb5.append("0X");
            String str7 = b;
            sb5.append(arrayList.get(i).getHelpID().substring(2, 4).equalsIgnoreCase("FF") ? "" : arrayList.get(i).getHelpID().substring(4, 8));
            sb5.append(arrayList.get(i).getCodeID());
            str5 = sb5.toString();
            str3 = (str3 + ",") + "0X" + arrayList.get(i).getSmallCode();
            str4 = (str4 + ",") + "0X" + arrayList.get(i).getCodeStatusID();
            i++;
            b = str7;
        }
        String str8 = b;
        c1426i.m9506a(MultipleAddresses.f24412CC, m9591a);
        c1426i.m9506a("dtcSize", sb2);
        c1426i.m9506a("autoCode", str2);
        c1426i.m9506a("serialNo", str);
        c1426i.m9506a("lanCode", matchedLanguage);
        c1426i.m9506a("systemId", systemID);
        c1426i.m9506a("dtcId", str5);
        c1426i.m9506a("dtcStatusId", str4);
        c1426i.m9506a("smallId", str3);
        c1426i.m9506a("sign", MD5Utils.m9460a(str2 + str5 + sb2 + str4 + matchedLanguage + str + str3 + systemID + PreferencesManager.m9595a(this.f15439a).m9591a("token")));
        try {
            String m9475b = this.f15446f.m9475b(str8, c1426i);
            return !TextUtils.isEmpty(m9475b) ? (OnLineFaultCodesWithSysQueryResponse) m5438a(m9475b, OnLineFaultCodesWithSysQueryResponse.class) : null;
        } catch (C1425f e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final BaseResponse m5379a(String str, BasicOnlineArithBean basicOnlineArithBean) throws C1425f {
        boolean m4865a = PathUtils.m4865a(DiagnoseConstants.DIAGNOSE_LIB_PATH, "CalcLine");
        boolean z = m4865a && PreferencesManager.m9595a(this.f15439a).m9583b("online_dtc_no_login", true);
        String b = m5451b(m4865a ? "onlineArithQuery_new_url" : "onlineArithQuery_url");
        if (TextUtils.isEmpty(b)) {
            b = m4865a ? "http://onlinedtc.x431.com/rest/syscode/getTransDiagDataEx.json" : "https://mycar.x431.com/rest/syscode/getTransDiagDataEx.json";
        }
        C1426i c1426i = new C1426i();
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String softID = basicOnlineArithBean.getSoftID();
        StringBuilder sb = new StringBuilder();
        sb.append(basicOnlineArithBean.getAriType());
        String sb2 = sb.toString();
        String hexData = basicOnlineArithBean.getHexData();
        c1426i.m9506a("autoCode", softID);
        c1426i.m9506a("logicType", sb2);
        c1426i.m9506a("serialNo", str);
        c1426i.m9506a(DataPacketExtension.ELEMENT_NAME, hexData);
        String m9460a = z ? MD5Utils.m9460a(m5382a()) : PreferencesManager.m9595a(this.f15439a).m9591a("token");
        if (!z) {
            c1426i.m9506a(MultipleAddresses.f24412CC, m9591a);
        } else {
            c1426i.m9506a("version", "2");
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(softID);
        sb3.append(hexData);
        sb3.append(sb2);
        sb3.append(str);
        sb3.append(z ? "2" : "");
        sb3.append(m9460a);
        c1426i.m9506a("sign", MD5Utils.m9460a(sb3.toString()));
        try {
            String m9477a = this.f15446f.m9477a(b, c1426i);
            String substring = m9477a.substring(m9477a.indexOf("{", 1), m9477a.lastIndexOf("}"));
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            return (OnLineArithResponse) m5438a(substring, OnLineArithResponse.class);
        } catch (C1425f e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public final BaseResponse m5371b(String str, BasicOnlineCodeLib basicOnlineCodeLib) throws C1425f {
        String m9591a;
        String m9475b;
        boolean z = f15532s && PreferencesManager.m9595a(this.f15439a).m9583b("online_dtc_no_login", true);
        String b = m5451b(!f15532s ? "onlineFaultCodeHelpQuery_url" : "onlineFaultCodeHelpQueryWithSys_url");
        if (TextUtils.isEmpty(b)) {
            b = !f15532s ? "https://mycar.x431.com/rest/syscode/getDiagSoftDtcHelp.json" : "http://onlinedtc.x431.com:80/carcodeservice/carTypeData/getDiagSoftDtcHelp.json";
        }
        C1426i c1426i = new C1426i();
        String m9591a2 = PreferencesManager.m9595a(this.f15439a).m9591a("user_id");
        String str2 = "0X" + basicOnlineCodeLib.getHelpID();
        String softID = basicOnlineCodeLib.getSoftID();
        String matchedLanguage = DiagnoseBusiness.getMatchedLanguage();
        c1426i.m9506a("autoCode", softID);
        c1426i.m9506a("dtcHelpId", str2);
        c1426i.m9506a("serialNo", str);
        c1426i.m9506a("lanCode", matchedLanguage);
        if (!z) {
            c1426i.m9506a(MultipleAddresses.f24412CC, m9591a2);
        } else {
            c1426i.m9506a("version", "2");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(softID);
        sb.append(str2);
        sb.append(matchedLanguage);
        sb.append(str);
        if (z) {
            m9591a = "2" + MD5Utils.m9460a(m5382a());
        } else {
            m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("token");
        }
        sb.append(m9591a);
        c1426i.m9506a("sign", MD5Utils.m9460a(sb.toString()));
        try {
            if (f15532s) {
                m9475b = this.f15446f.m9475b(b, c1426i);
            } else {
                m9475b = this.f15446f.m9477a(b, c1426i);
            }
            if (!f15532s) {
                m9475b = m9475b.substring(m9475b.indexOf("{", 1), m9475b.lastIndexOf("}"));
            }
            if (TextUtils.isEmpty(m9475b)) {
                return null;
            }
            return (OnlineFaultCodeHelpInfo) m5438a(m9475b, OnlineFaultCodeHelpInfo.class);
        } catch (C1425f e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private Object m5373a(String str, String str2, String str3, String str4, String str5) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (TextUtils.isEmpty(str2)) {
                return "-1";
            }
            String m9460a = MD5Utils.m9460a(str5 + str + str3 + str4 + PreferencesManager.m9595a(this.f15439a).m9591a("token"));
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(str2);
            LinkedList linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair("softId", String.valueOf(str3)));
            linkedList.add(new BasicNameValuePair("versionNo", str4));
            linkedList.add(new BasicNameValuePair("filePath", str5));
            linkedList.add(new BasicNameValuePair("serialNo", str));
            httpPost.addHeader(MultipleAddresses.f24412CC, PreferencesManager.m9595a(this.f15439a).m9591a("user_id"));
            httpPost.addHeader("sign", m9460a);
            httpPost.setEntity(new UrlEncodedFormEntity(linkedList, "utf-8"));
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            long contentLength = execute.getEntity().getContentLength();
            if (contentLength == -1) {
                contentLength = execute.getEntity().getContent().available();
            }
            if (contentLength == 0) {
                return "405";
            }
            if (execute.getStatusLine().getStatusCode() == 200) {
                InputStream content = execute.getEntity().getContent();
                Header[] headers = execute.getHeaders("code");
                if (headers != null && headers.length > 0) {
                    if ("405".equals(headers[0].getValue())) {
                        return "405";
                    }
                    if ("402".equals(headers[0].getValue())) {
                        return "402";
                    }
                    if ("401".equals(headers[0].getValue())) {
                        return "401";
                    }
                    if ("771".equals(headers[0].getValue()) || "406".equals(headers[0].getValue())) {
                        return headers[0].getValue();
                    }
                }
                String str6 = Environment.getExternalStorageDirectory() + DiagnoseConstants.DIAGNOSE_LIB_PATH;
                File file = new File(str6, str5.substring(str5.lastIndexOf("/"), str5.length()));
                if (file.exists()) {
                    return "0";
                }
                new File(str6).mkdirs();
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = content.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    content.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return "0";
                } catch (Exception unused) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return "-1";
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return "-1";
        } catch (Exception unused2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    public final BaseResponse m5369b(String str, String str2) throws C1425f, FileNotFoundException {
        String b = m5451b("uploadECUFile_url");
        if (b.isEmpty()) {
            b = "http://mycar.test.x431.com:8000/rest/s_ajax_upload/ecuRecordFile";
        }
        String str3 = "";
        File file = new File(str2);
        FormFile[] formFileArr = {new FormFile(file.getName(), file, "ecufile", "multipart/form-data")};
        HashMap hashMap = new HashMap();
        hashMap.put("carSerial", str);
        hashMap.put("fileName", file.getName());
        hashMap.put("sign", MD5Utils.m9460a(file.getName() + str + "cf35d07b4d1c53dca0c4bba7ef76174c"));
        try {
            str3 = FileUtils.m5010a(b, hashMap, formFileArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String substring = str3.substring(str3.indexOf("{"), str3.lastIndexOf("}") + 1);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        return (BaseResponse) m5438a(substring, BaseResponse.class);
    }

    /* renamed from: c */
    public final AdvertiseResponse[] m5365c(String str, String str2) throws C1425f {
        String b = TextUtils.isEmpty(m5451b(KeyConstant.f6891bl)) ? "http://mycar.x431.com/discount/getSysDiscountInfo.action" : m5451b(KeyConstant.f6891bl);
        NLog.m9456a("DiagnoseAction", "getAdv url=".concat(String.valueOf(b)));
        C1426i c1426i = new C1426i();
        c1426i.m9506a("clientType", str);
        c1426i.m9506a("appType", str2);
        c1426i.m9506a("multiFlag", "1");
        String m9475b = this.f15446f.m9475b(b, c1426i);
        NLog.m9456a("DiagnoseAction", "getAdvertising.json=".concat(String.valueOf(m9475b)));
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        AdvertiseResponse[] advertiseResponseArr = (AdvertiseResponse[]) m5438a(m9475b, AdvertiseResponse[].class);
        if (advertiseResponseArr != null) {
            int length = advertiseResponseArr.length;
            for (int i = 0; i < length; i++) {
                NLog.m9456a("DiagnoseAction", "getAdv result=".concat(String.valueOf(advertiseResponseArr[i])));
            }
            return advertiseResponseArr;
        }
        return advertiseResponseArr;
    }

    /* renamed from: g */
    public final QuerySerialNosForbitFLagResponse m5364g(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6857bD);
        if (TextUtils.isEmpty(b)) {
            b = "https://mycar.x431.com/services/publicSoftService?wsdl";
        }
        SoapObjectParams d = m5447d("querySerialNosForbitFlag");
        d.mo169a("serialNos", str);
        QuerySerialNosForbitFLagResponse querySerialNosForbitFLagResponse = null;
        try {
            SyncHttpTransportSE a = m5439a(b, 10000);
            SoapSerializationEnvelope a2 = m5437a((C4920a[]) null, d);
            a.m141a("", a2);
            if (a2 != null) {
                querySerialNosForbitFLagResponse = (QuerySerialNosForbitFLagResponse) m5443a(QuerySerialNosForbitFLagResponse.class, a2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        NLog.m9456a("yhx", "getSerialNosState response=".concat(String.valueOf(querySerialNosForbitFLagResponse)));
        return querySerialNosForbitFLagResponse;
    }

    /* renamed from: h */
    public final BaseResponse m5363h(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6857bD);
        if (TextUtils.isEmpty(b)) {
            b = "https://mycar.x431.com/services/publicSoftService?wsdl";
        }
        SoapObjectParams d = m5447d("updatePdtForbitBlackFLag");
        d.mo169a("serialNo", str);
        BaseResponse baseResponse = null;
        try {
            SyncHttpTransportSE a = m5439a(b, 10000);
            SoapSerializationEnvelope a2 = m5437a((C4920a[]) null, d);
            a.m141a("", a2);
            if (a2 != null) {
                baseResponse = (BaseResponse) m5443a(BaseResponse.class, a2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        NLog.m9456a("yhx", "updateTheSerialNoState response=".concat(String.valueOf(baseResponse)));
        return baseResponse;
    }

    /* renamed from: a */
    private String m5382a() {
        String m9591a = PreferencesManager.m9595a(this.f15439a).m9591a("serialNo");
        DeviceUtils.m8149a();
        DPUHardwareInfo m8147a = DeviceUtils.m8147a(m9591a, PathUtils.m4858c());
        return m8147a != null ? m8147a.f9855f : "";
    }
}
