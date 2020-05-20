package com.cnlaunch.x431pro.module.report;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportInfo;
import com.cnlaunch.x431pro.utils.p280b.ObjectConversion;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.module.report.a */
/* loaded from: classes.dex */
public final class ReportProduceTool {

    /* renamed from: r */
    private static ReportProduceTool f15637r;

    /* renamed from: a */
    public ArrayList<BasicFaultCodeBean> f15638a;

    /* renamed from: b */
    JSONArray f15639b;

    /* renamed from: c */
    JSONArray f15640c;

    /* renamed from: d */
    public JSONArray f15641d;

    /* renamed from: e */
    JSONArray f15642e;

    /* renamed from: f */
    public String f15643f = "";

    /* renamed from: g */
    public String f15644g = "";

    /* renamed from: h */
    String f15645h = "";

    /* renamed from: i */
    String f15646i = "";

    /* renamed from: j */
    public String f15647j = "";

    /* renamed from: k */
    public String f15648k = "";

    /* renamed from: l */
    public String f15649l = "";

    /* renamed from: m */
    String f15650m = "";

    /* renamed from: n */
    String f15651n = "";

    /* renamed from: o */
    public String f15652o = "";

    /* renamed from: p */
    public String f15653p = "";

    /* renamed from: q */
    public String f15654q = "";

    /* renamed from: s */
    private ArrayList<BasicDataStreamBean> f15655s;

    /* renamed from: b */
    public static final boolean m5227b() {
        return true;
    }

    /* renamed from: a */
    public static ReportProduceTool m5233a() {
        if (f15637r == null) {
            f15637r = new ReportProduceTool();
        }
        return f15637r;
    }

    public ReportProduceTool() {
        this.f15638a = null;
        this.f15655s = null;
        this.f15639b = null;
        this.f15640c = null;
        this.f15641d = null;
        this.f15642e = null;
        this.f15638a = new ArrayList<>();
        this.f15639b = new JSONArray();
        this.f15640c = new JSONArray();
        this.f15655s = new ArrayList<>();
        this.f15641d = new JSONArray();
        this.f15642e = new JSONArray();
    }

    /* renamed from: c */
    public final void m5224c() {
        this.f15638a = null;
        this.f15655s = null;
        this.f15639b = null;
        this.f15640c = null;
        this.f15641d = null;
        this.f15642e = null;
        f15637r = null;
        this.f15647j = "";
        this.f15648k = "";
        this.f15649l = "";
        this.f15650m = "";
        this.f15651n = "";
        this.f15652o = "";
        this.f15653p = "";
    }

    /* renamed from: d */
    public final String m5223d() {
        JSONArray jSONArray = this.f15640c;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("syss", this.f15640c);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    public final String m5222e() {
        JSONArray jSONArray = this.f15639b;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("syss", this.f15639b);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private boolean m5229a(BasicFaultCodeBean basicFaultCodeBean) {
        Iterator<BasicFaultCodeBean> it = this.f15638a.iterator();
        while (it.hasNext()) {
            if (basicFaultCodeBean.equals(it.next())) {
                return true;
            }
        }
        this.f15638a.add(basicFaultCodeBean);
        return false;
    }

    /* renamed from: a */
    private boolean m5230a(BasicDataStreamBean basicDataStreamBean) {
        Iterator<BasicDataStreamBean> it = this.f15655s.iterator();
        while (it.hasNext()) {
            if (basicDataStreamBean.equals(it.next())) {
                return true;
            }
        }
        this.f15655s.add(basicDataStreamBean);
        return false;
    }

    /* renamed from: a */
    public final void m5228a(ArrayList<BasicFaultCodeBean> arrayList, String str, String str2) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int size = arrayList.size();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getId().equals("无故障码") || !m5229a(arrayList.get(i))) {
                    JSONObject jSONObject = new JSONObject();
                    if (TextUtils.isEmpty(arrayList.get(i).getId())) {
                        jSONObject.put("id", arrayList.get(i).getTitle().trim());
                    } else {
                        jSONObject.put("id", arrayList.get(i).getId());
                    }
                    jSONObject.put("code", arrayList.get(i).getTitle().trim());
                    jSONObject.put("status", arrayList.get(i).getStatus().trim());
                    jSONObject.put("fault_description", arrayList.get(i).getContext().trim());
                    jSONArray.put(jSONObject);
                } else {
                    size--;
                }
            }
            if (size > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sys", str + ">" + str2);
                jSONObject2.put("path", str2);
                jSONObject2.put("faults", jSONArray);
                this.f15639b.put(jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void m5225b(ArrayList<BasicDataStreamBean> arrayList, String str, String str2) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int size = arrayList.size();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < arrayList.size(); i++) {
                if (m5230a(arrayList.get(i))) {
                    size--;
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", arrayList.get(i).getId());
                    jSONObject.put("name", arrayList.get(i).getTitle().trim());
                    jSONObject.put("value", arrayList.get(i).getSrcValue().trim());
                    jSONObject.put("unit", arrayList.get(i).getSrcUnit().trim());
                    jSONArray.put(jSONObject);
                }
            }
            if (size > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sys", str);
                jSONObject2.put("path", str2);
                jSONObject2.put("dataflows", jSONArray);
                this.f15640c.put(jSONObject2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m5232a(Context context, int i) {
        String[] stringArray = context.getResources().getStringArray(R.array.func_type);
        if (i <= 0 || i > stringArray.length) {
            return String.valueOf(i);
        }
        return stringArray[i - 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m5226b(Context context, int i) {
        String[] stringArray = context.getResources().getStringArray(R.array.func_status);
        if (i < 0 || i > stringArray.length - 1) {
            return String.valueOf(i);
        }
        return stringArray[i];
    }

    /* renamed from: a */
    public static void m5231a(Context context, UpLoadReportInfo upLoadReportInfo) {
        HashMap hashMap;
        if (upLoadReportInfo == null) {
            return;
        }
        String pro_serial_no = upLoadReportInfo.getPro_serial_no();
        String m9591a = PreferencesManager.m9595a(context).m9591a("report_save");
        if (TextUtils.isEmpty(m9591a)) {
            hashMap = new HashMap();
        } else {
            hashMap = (HashMap) ObjectConversion.m5097a(m9591a.getBytes());
        }
        if (hashMap.get(pro_serial_no) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(upLoadReportInfo);
            hashMap.put(pro_serial_no, arrayList);
        } else {
            ArrayList arrayList2 = (ArrayList) hashMap.get(pro_serial_no);
            arrayList2.add(upLoadReportInfo);
            hashMap.put(pro_serial_no, arrayList2);
        }
        PreferencesManager.m9595a(context).m9588a("report_save", new String(ObjectConversion.m5098a(hashMap)));
    }
}
