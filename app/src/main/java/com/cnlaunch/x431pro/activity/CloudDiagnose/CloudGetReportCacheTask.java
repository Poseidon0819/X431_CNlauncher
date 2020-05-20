package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.cloud.model.CloudData;
import com.cnlaunch.x431pro.utils.Base64Utils;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.d */
/* loaded from: classes.dex */
public final class CloudGetReportCacheTask implements Runnable {

    /* renamed from: a */
    private Context f10617a;

    /* renamed from: b */
    private ArrayList<CloudData> f10618b = new ArrayList<>();

    /* renamed from: c */
    private String f10619c = "";

    public CloudGetReportCacheTask(Context context) {
        this.f10617a = context;
    }

    /* renamed from: a */
    private ArrayList<File> m7930a(File[] fileArr) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (fileArr.length > 0) {
            for (int i = 0; i < fileArr.length; i++) {
                if (!fileArr[i].isDirectory() && fileArr[i].getName().endsWith(".txt")) {
                    arrayList.add(fileArr[i]);
                }
            }
            if (arrayList.size() > 0) {
                Collections.sort(arrayList, new C1953e(this));
                return arrayList;
            }
            return null;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList<File> m7930a;
        this.f10618b.clear();
        if (C2778n.m4917a(this.f10617a)) {
            File file = new File(CloudReportSaveTask.f10678a);
            if (!file.exists() || (m7930a = m7930a(file.listFiles())) == null || m7930a.size() <= 0) {
                return;
            }
            String absolutePath = m7930a.get(0).getAbsolutePath();
            if (this.f10619c.equalsIgnoreCase(absolutePath)) {
                NLog.m9451c("XEE", "上一次的未上传结束，取消本次上传");
                return;
            }
            this.f10619c = absolutePath;
            NLog.m9452b("XEE", "开始从此文件读取云诊断报告:".concat(String.valueOf(absolutePath)));
            try {
                String m4922b = Base64Utils.m4922b(FileUtils.m5005b(absolutePath));
                if (TextUtils.isEmpty(m4922b)) {
                    return;
                }
                JSONArray jSONArray = new JSONObject(m4922b).getJSONArray(DataPacketExtension.ELEMENT_NAME);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    CloudData cloudData = new CloudData();
                    cloudData.f15491a = jSONObject.getString("serial_no");
                    cloudData.f15492b = jSONObject.getString(VastExtensionXmlManager.TYPE);
                    cloudData.f15494d = jSONObject.getJSONObject("content").toString();
                    cloudData.f15493c = jSONObject.getString("diagnose_no");
                    cloudData.f15495e = jSONObject.getString("bag_no");
                    cloudData.f15496f = absolutePath;
                    this.f10618b.add(cloudData);
                }
                C2744aa.m5182a(this.f10617a, this.f10618b);
            } catch (JSONException e) {
                NLog.m9452b("XEE", " report file read err:" + e.toString());
                FileUtils.m5000d(this.f10619c);
                e.printStackTrace();
            }
        }
    }
}
