package com.cnlaunch.x431pro.module.p252d.p254b;

import android.os.Bundle;
import com.cnlaunch.golo3.p163e.SignUtils;
import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cnlaunch.x431pro.module.d.b.n */
/* loaded from: classes.dex */
public final class RemoteDiagRunningInfo extends AbstractC2709c {
    private static final long serialVersionUID = 7803186176444522178L;
    private String otherUseID = "";
    private String otherUseName = "";
    private String remoteSerialNum = "";
    private String service_ip = "";
    private int service_port = 0;
    private String service_domain = "";
    private String userInfo = "";
    private String lan = "";
    private String userID = "";
    private int indetify = 0;
    private String goloLat = "";
    private String goloLon = "";
    private String otherFace = "";
    private C2726a diagSoft = null;
    private String carName = "";
    private int otherVer = 0;
    private String romote_diag_start_time = "";

    public final String getRomote_diag_start_time() {
        return this.romote_diag_start_time;
    }

    public final void setRomote_diag_start_time(String str) {
        this.romote_diag_start_time = str;
    }

    public final String getOtherUseID() {
        return this.otherUseID;
    }

    public final void setOtherUseID(String str) {
        this.otherUseID = str;
    }

    public final String getOtherUseName() {
        return this.otherUseName;
    }

    public final void setOtherUseName(String str) {
        this.otherUseName = str;
    }

    public final String getRemoteSerialNum() {
        return this.remoteSerialNum;
    }

    public final void setRemoteSerialNum(String str) {
        this.remoteSerialNum = str;
    }

    public final String getService_ip() {
        return this.service_ip;
    }

    public final void setService_ip(String str) {
        this.service_ip = str;
    }

    public final int getService_port() {
        return this.service_port;
    }

    public final void setService_port(int i) {
        this.service_port = i;
    }

    public final String getService_domain() {
        return this.service_domain;
    }

    public final void setService_domain(String str) {
        this.service_domain = str;
    }

    public final String getUserInfo(int i, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        HashMap hashMap = new HashMap();
        hashMap.put("action", "userinfo.get_base_info");
        hashMap.put("user_id", this.userID);
        hashMap.put("app_id", str2);
        hashMap.put("ver", str);
        hashMap.put("lan", getLan());
        String m9158a = SignUtils.m9158a(str3, hashMap);
        try {
            jSONObject2.put("identity", i);
            jSONObject2.put("deviceSN", this.remoteSerialNum);
            jSONObject2.put("userId", this.userID);
            jSONObject2.put("appId", str2);
            jSONObject2.put("sign", m9158a);
            jSONObject2.put("lan", getLan());
            jSONObject2.put("ver", str);
            jSONObject.put("protocolVer", 1);
            jSONObject.put(DataPacketExtension.ELEMENT_NAME, jSONObject2);
        } catch (JSONException unused) {
        }
        this.userInfo = jSONObject.toString();
        return jSONObject.toString();
    }

    public final String getUserInfo() {
        return this.userInfo;
    }

    public final String getUserID() {
        return this.userID;
    }

    public final void setUserID(String str) {
        this.userID = str;
    }

    public final String getLan() {
        return this.lan;
    }

    public final void setLan(String str) {
        this.lan = str;
    }

    public final int getIndetify() {
        return this.indetify;
    }

    public final void setIndetify(int i) {
        this.indetify = i;
    }

    public final void setInfo(Bundle bundle) {
        setRemoteSerialNum(bundle.getString("serialNum"));
        setOtherUseID(bundle.getString("userId"));
        setOtherUseName(bundle.getString("userName"));
        setIndetify(bundle.getInt("identify", 1));
        setGoloLat(bundle.getString("lat"));
        setGoloLon(bundle.getString("lon"));
        setOtherFace(bundle.getString("otherFaceUrl"));
        setService_ip(bundle.getString("ip"));
        setService_port(bundle.getInt("port"));
        setService_domain(bundle.getString("domain"));
        setCarName(bundle.getString("carName"));
        setDiagSoft(new C2726a());
        getDiagSoft().putAll(bundle);
    }

    public final String getGoloLon() {
        return this.goloLon;
    }

    public final void setGoloLon(String str) {
        this.goloLon = str;
    }

    public final String getGoloLat() {
        return this.goloLat;
    }

    public final void setGoloLat(String str) {
        this.goloLat = str;
    }

    public final String getOtherFace() {
        return this.otherFace;
    }

    public final void setOtherFace(String str) {
        this.otherFace = str;
    }

    public final C2726a getDiagSoft() {
        if (this.diagSoft == null) {
            this.diagSoft = new C2726a();
        }
        return this.diagSoft;
    }

    public final void setDiagSoft(C2726a c2726a) {
        this.diagSoft = c2726a;
    }

    public final int getOtherVer() {
        return this.otherVer;
    }

    public final void setOtherVer(int i) {
        this.otherVer = i;
    }

    public final String getCarName() {
        return this.carName;
    }

    public final void setCarName(String str) {
        this.carName = str;
    }

    /* compiled from: RemoteDiagRunningInfo.java */
    /* renamed from: com.cnlaunch.x431pro.module.d.b.n$a */
    /* loaded from: classes.dex */
    public class C2726a implements Serializable {
        private static final long serialVersionUID = -2928701576856506596L;
        public String versionlist = "";
        public String carname = "";
        public String carname_zh = "";
        public String softpackageid = "";
        public String areaId = "";
        ArrayList<CarVersionInfo> verList = null;

        public C2726a() {
        }

        public final void putAll(Bundle bundle) {
            if (bundle != null) {
                this.versionlist = bundle.getString("versionlist", "");
                this.carname = bundle.getString("carname", "");
                this.carname_zh = bundle.getString("carname_zh", "");
                this.softpackageid = bundle.getString("softpackageid", "");
                this.areaId = bundle.getString("areaId", "");
                this.verList = (ArrayList) bundle.getSerializable("verList");
            }
        }

        public final Bundle getSoftBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("versionlist", this.versionlist);
            bundle.putString("carname", this.carname);
            bundle.putString("carname_zh", this.carname_zh);
            bundle.putString("softpackageid", this.softpackageid);
            bundle.putString("areaId", this.areaId);
            bundle.putSerializable("verList", this.verList);
            return bundle;
        }
    }
}
