package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.os.Environment;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.cloud.model.CloudData;
import com.cnlaunch.x431pro.utils.Base64Utils;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.File;
import java.util.List;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.q */
/* loaded from: classes.dex */
public final class CloudReportSaveTask implements Runnable {

    /* renamed from: a */
    public static final String f10678a = Environment.getExternalStorageDirectory() + File.separator + "cnlaunch" + File.separator + "cloud_report_cache";

    /* renamed from: b */
    private String f10679b = "";

    /* renamed from: c */
    private List<CloudData> f10680c;

    public CloudReportSaveTask(List<CloudData> list) {
        this.f10680c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            NLog.m9456a("XEE", "开始保存远程诊断报告...");
            if (this.f10680c != null && this.f10680c.size() != 0) {
                this.f10679b = f10678a + File.separator + this.f10680c.get(0).f15491a + "_" + DateUtils.m5094a("YYYYMMDD") + "_" + DateUtils.m5094a("hhmmss") + ".txt";
                File file = new File(f10678a);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.f10680c.size(); i++) {
                    CloudData cloudData = this.f10680c.get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("serial_no", cloudData.f15491a);
                    jSONObject2.put(VastExtensionXmlManager.TYPE, cloudData.f15492b);
                    jSONObject2.put("diagnose_no", cloudData.f15493c);
                    jSONObject2.put("content", new JSONObject(cloudData.f15494d));
                    jSONObject2.put("bag_no", cloudData.f15495e);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(DataPacketExtension.ELEMENT_NAME, jSONArray);
                NLog.m9452b("XEE", "诊断报告缓存在:" + this.f10679b);
                FileUtils.m5016a(Base64Utils.m4923a(jSONObject.toString()), this.f10679b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception e2) {
            NLog.m9451c("XEE", "保存远程诊断报告失败:" + e2.toString());
            e2.printStackTrace();
        }
    }
}
