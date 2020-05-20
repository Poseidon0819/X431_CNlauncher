package com.cnlaunch.x431pro.module.cloud.model;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.bean.BasicECUInfoBean;
import com.cnlaunch.diagnosemodule.bean.BasicFaultCodeBean;
import com.cnlaunch.diagnosemodule.bean.BasicSystemStatusBean;
import com.cnlaunch.mycar.jni.JniX431File;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p135g.MyLocationLogic;
import com.cnlaunch.p188n.p191c.DiagCarInfo;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.module.cloud.model.e */
/* loaded from: classes.dex */
public final class CloudDataManager {

    /* renamed from: a */
    private static CloudDataManager f15500a;

    /* renamed from: b */
    private Context f15501b;

    /* renamed from: c */
    private DiagCarInfo f15502c;

    /* renamed from: d */
    private int f15503d = 0;

    /* renamed from: e */
    private int f15504e = 1;

    /* renamed from: f */
    private String f15505f = "";

    /* renamed from: g */
    private String f15506g = "";

    /* renamed from: h */
    private String f15507h = "";

    /* renamed from: i */
    private long f15508i;

    private CloudDataManager(Context context) {
        this.f15501b = context;
    }

    /* renamed from: a */
    public static CloudDataManager m5413a(Context context) {
        if (f15500a == null) {
            f15500a = new CloudDataManager(context);
        }
        return f15500a;
    }

    /* renamed from: b */
    private synchronized boolean m5407b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f15508i) < 300000) {
            return true;
        }
        this.f15508i = currentTimeMillis;
        return false;
    }

    /* renamed from: a */
    private CloudData m5408a(String str) {
        CloudData cloudData = new CloudData();
        cloudData.f15491a = PreferencesManager.m9595a(this.f15501b).m9591a("serialNo");
        cloudData.f15495e = String.valueOf(this.f15504e);
        cloudData.f15493c = String.valueOf(this.f15502c.getDiag_start_time());
        cloudData.f15492b = str;
        return cloudData;
    }

    /* renamed from: a */
    public final ArrayList<CloudData> m5411a(DiagCarInfo diagCarInfo, ArrayList<BasicSystemStatusBean> arrayList) {
        this.f15502c = diagCarInfo;
        ArrayList<CloudData> arrayList2 = new ArrayList<>();
        arrayList2.add(m5404c());
        if (arrayList != null) {
            DiagCarInfo diagCarInfo2 = this.f15502c;
            StringBuilder sb = new StringBuilder();
            sb.append(arrayList.size());
            diagCarInfo2.setSysNum(sb.toString());
            int i = 0;
            while (i < arrayList.size()) {
                i++;
                arrayList2.add(m5412a(arrayList.get(i), i));
            }
        }
        arrayList2.add(m5401d());
        return arrayList2;
    }

    /* renamed from: c */
    private CloudData m5404c() {
        CloudData m5408a = m5408a("1");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", this.f15502c.getReport_type());
            jSONObject.put("softpackageid", this.f15502c.getPackageId());
            jSONObject.put("diagnose_soft_ver", this.f15502c.getSoftVersion());
            jSONObject.put("language", this.f15502c.getLanguage());
            jSONObject.put("metric", this.f15502c.getMetric());
            jSONObject.put("product_url", this.f15502c.getPath());
            jSONObject.put("terminal_serial_no", this.f15502c.getPro_serial_no());
            jSONObject.put("pro_serial_no", this.f15502c.getSerialNo());
            jSONObject.put("app_ver", this.f15502c.getApkVersion());
            jSONObject.put("downloadbin_ver", this.f15502c.getBin_ver());
            jSONObject.put("gpstype", this.f15507h);
            jSONObject.put("net_type", this.f15502c.getNetInfo_type());
            jSONObject.put("technician_lon", this.f15506g);
            jSONObject.put("technician_lat", this.f15505f);
            jSONObject.put("user_lon", this.f15506g);
            jSONObject.put("user_lat", this.f15505f);
            jSONObject.put("system_ver", Build.DISPLAY);
            jSONObject.put("remote_tech_id", this.f15502c.getRemote_tech_id());
            jSONObject.put("remote_tech_advise", this.f15502c.getRemote_tech_advise());
        } catch (JSONException e) {
            Log.e("XEE", "get diagbase info error:" + e.toString());
            e.printStackTrace();
        }
        m5408a.f15494d = jSONObject.toString();
        return m5408a;
    }

    /* renamed from: d */
    private CloudData m5401d() {
        CloudData m5408a = m5408a("3");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("car_series", this.f15502c.getCar_series());
            jSONObject.put("vin", this.f15502c.getVin());
            jSONObject.put("cv", this.f15502c.getCvn());
            jSONObject.put("plate_num", this.f15502c.getPlate());
            jSONObject.put("plate_num_url", this.f15502c.getPlate_url());
            jSONObject.put("car_model", this.f15502c.getModel());
            jSONObject.put("diag_car_mode", this.f15502c.getDiag_car_mode());
            jSONObject.put("car_producing_year", this.f15502c.getYear());
            jSONObject.put("car_engine_num", this.f15502c.getEngineNum());
            jSONObject.put("displacement", this.f15502c.getDisplacement());
            jSONObject.put("transmission", this.f15502c.getTransmission());
            jSONObject.put("sys_num", this.f15502c.getSysNum());
            jSONObject.put("mileage", this.f15502c.getMileage());
            jSONObject.put("is_full_scan", this.f15502c.getFull_scan());
            jSONObject.put("diagnose_time", this.f15502c.getDiag_end_time() - this.f15502c.getDiag_start_time());
            jSONObject.put("end_flag", this.f15502c.getEndFlag());
        } catch (JSONException e) {
            NLog.m9451c("XEE", "get vehicles info error:" + e.toString());
            e.printStackTrace();
        }
        m5408a.f15494d = jSONObject.toString();
        return m5408a;
    }

    /* renamed from: a */
    private CloudData m5412a(BasicSystemStatusBean basicSystemStatusBean, int i) {
        long diag_start_time = this.f15502c.getDiag_start_time();
        int i2 = this.f15503d;
        long j = diag_start_time + i2;
        this.f15503d = i2 + 1;
        CloudData m5408a = m5408a("2");
        m5408a.f15495e = String.valueOf(i);
        JSONObject jSONObject = new JSONObject();
        try {
            Object systemUUID = basicSystemStatusBean.getSystemUUID();
            jSONObject.put("system", basicSystemStatusBean.getSystemName());
            jSONObject.put("name_id", basicSystemStatusBean.getSystemID());
            jSONObject.put("system_uid", systemUUID);
            if (basicSystemStatusBean.getIsNew() == 1) {
                jSONObject.put("is_new_sys", 1);
            } else {
                jSONObject.put("is_new_sys", 0);
            }
            ArrayList<BasicECUInfoBean> systemECUInfoBean = basicSystemStatusBean.getSystemECUInfoBean();
            JSONArray jSONArray = new JSONArray();
            if (systemECUInfoBean != null) {
                Iterator<BasicECUInfoBean> it = systemECUInfoBean.iterator();
                while (it.hasNext()) {
                    BasicECUInfoBean next = it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("title", next.getTitle());
                    jSONObject2.put("value", next.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("ecus", jSONArray);
            ArrayList<BasicFaultCodeBean> systemFaultCodeBean = basicSystemStatusBean.getSystemFaultCodeBean();
            JSONArray jSONArray2 = new JSONArray();
            if (systemFaultCodeBean != null) {
                Iterator<BasicFaultCodeBean> it2 = systemFaultCodeBean.iterator();
                while (it2.hasNext()) {
                    BasicFaultCodeBean next2 = it2.next();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", next2.getId());
                    jSONObject3.put("code", next2.getTitle());
                    if ("CONSULT HANDBOOK".equals(next2.getContext())) {
                        jSONObject3.put("fault_description", this.f15501b.getString(R.string.diagnose_consult_handbook));
                    } else {
                        jSONObject3.put("fault_description", next2.getContext());
                    }
                    jSONObject3.put("status", next2.getStatus());
                    jSONObject3.put("showsystem", basicSystemStatusBean.getSystemName());
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject.put(JniX431File.DSUNIT_DTCS, jSONArray2);
            ArrayList<BasicDataStreamBean> dataStreamInfoList = basicSystemStatusBean.getDataStreamInfoList();
            JSONArray jSONArray3 = new JSONArray();
            if (dataStreamInfoList != null) {
                Iterator<BasicDataStreamBean> it3 = dataStreamInfoList.iterator();
                while (it3.hasNext()) {
                    BasicDataStreamBean next3 = it3.next();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("id", next3.getId());
                    jSONObject4.put("title", next3.getTitle());
                    jSONObject4.put("unit", next3.getSrcUnit());
                    jSONObject4.put("value", next3.getSrcValue());
                    jSONObject4.put("time", String.valueOf(j));
                    jSONArray3.put(jSONObject4);
                }
            }
            jSONObject.put("datastreams", jSONArray3);
        } catch (JSONException e) {
            NLog.m9451c("XEE", "get system info error:" + e.toString());
            e.printStackTrace();
        }
        m5408a.f15494d = jSONObject.toString();
        return m5408a;
    }

    /* renamed from: a */
    public final void m5414a() {
        if (!m5407b() || TextUtils.isEmpty(this.f15506g) || TextUtils.isEmpty(this.f15505f)) {
            MyLocationLogic.m9420a();
            MyLocationLogic.m9417a(this.f15501b, new C2720f(this));
        }
    }
}
