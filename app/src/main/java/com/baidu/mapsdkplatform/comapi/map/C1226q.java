package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comjni.map.basemap.C1306a;
import java.util.ArrayList;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mapsdkplatform.comapi.map.q */
/* loaded from: classes.dex */
public class C1226q {

    /* renamed from: a */
    private static final String f6076a = "q";

    /* renamed from: c */
    private static C1226q f6077c;

    /* renamed from: b */
    private C1306a f6078b;

    /* renamed from: d */
    private C1231u f6079d;

    /* renamed from: e */
    private Handler f6080e;

    private C1226q() {
    }

    /* renamed from: a */
    public static C1226q m10591a() {
        if (f6077c == null) {
            C1226q c1226q = new C1226q();
            f6077c = c1226q;
            c1226q.m10574g();
        }
        return f6077c;
    }

    /* renamed from: g */
    private void m10574g() {
        m10572h();
        this.f6079d = new C1231u();
        this.f6080e = new Handler() { // from class: com.baidu.mapsdkplatform.comapi.map.q.1
            @Override // android.os.Handler
            public void handleMessage(Message message2) {
                super.handleMessage(message2);
                if (C1226q.f6077c != null) {
                    C1226q.this.f6079d.m10568a(message2);
                }
            }
        };
        MessageCenter.registMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, this.f6080e);
    }

    /* renamed from: h */
    private void m10572h() {
        Context context = BMapManager.getContext();
        EnvironmentUtilities.initAppDirectory(context);
        this.f6078b = new C1306a();
        this.f6078b.m10048a(context.hashCode());
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        String str = SysOSUtil.getDensityDpi() >= 180 ? "/h/" : "/l/";
        String str2 = moduleFileName + "/cfg";
        String str3 = appSDCardPath + "/vmp";
        String str4 = str3 + str;
        String str5 = str3 + str;
        String str6 = appCachePath + "/tmp/";
        this.f6078b.m10033a(str2 + "/a/", str4, str6, appSecondCachePath + "/tmp/", str5, str2 + "/a/", null, 0, str2 + "/idrres/", SysOSUtil.getScreenSizeX(), SysOSUtil.getScreenSizeY(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
        this.f6078b.m10014d();
    }

    /* renamed from: a */
    public ArrayList<C1225p> m10587a(String str) {
        C1306a c1306a;
        String m10036a;
        JSONArray optJSONArray;
        if (!str.equals("") && (c1306a = this.f6078b) != null && (m10036a = c1306a.m10036a(str)) != null && !m10036a.equals("")) {
            ArrayList<C1225p> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(m10036a);
                if (jSONObject.length() == 0 || (optJSONArray = jSONObject.optJSONArray("dataset")) == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C1225p c1225p = new C1225p();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    int optInt = jSONObject2.optInt("id");
                    if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                        c1225p.f6071a = optInt;
                        c1225p.f6072b = jSONObject2.optString("name");
                        c1225p.f6073c = jSONObject2.optInt("mapsize");
                        c1225p.f6074d = jSONObject2.optInt("cty");
                        if (jSONObject2.has("child")) {
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("child");
                            ArrayList<C1225p> arrayList2 = new ArrayList<>();
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                C1225p c1225p2 = new C1225p();
                                JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                                c1225p2.f6071a = optJSONObject.optInt("id");
                                c1225p2.f6072b = optJSONObject.optString("name");
                                c1225p2.f6073c = optJSONObject.optInt("mapsize");
                                c1225p2.f6074d = optJSONObject.optInt("cty");
                                arrayList2.add(c1225p2);
                            }
                            c1225p.m10592a(arrayList2);
                        }
                        arrayList.add(c1225p);
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m10588a(InterfaceC1230t interfaceC1230t) {
        C1231u c1231u = this.f6079d;
        if (c1231u != null) {
            c1231u.m10567a(interfaceC1230t);
        }
    }

    /* renamed from: a */
    public boolean m10590a(int i) {
        if (this.f6078b == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return this.f6078b.m10013d(i);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m10586a(boolean z, boolean z2) {
        C1306a c1306a = this.f6078b;
        if (c1306a == null) {
            return false;
        }
        return c1306a.m10031a(z, z2);
    }

    /* renamed from: b */
    public void m10585b() {
        MessageCenter.unregistMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, this.f6080e);
        this.f6078b.m10027b(BMapManager.getContext().hashCode());
        f6077c = null;
    }

    /* renamed from: b */
    public void m10583b(InterfaceC1230t interfaceC1230t) {
        C1231u c1231u = this.f6079d;
        if (c1231u != null) {
            c1231u.m10566b(interfaceC1230t);
        }
    }

    /* renamed from: b */
    public boolean m10584b(int i) {
        if (this.f6078b == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return this.f6078b.m10043a(i, false, 0);
        }
        return false;
    }

    /* renamed from: c */
    public ArrayList<C1225p> m10582c() {
        C1306a c1306a = this.f6078b;
        if (c1306a == null) {
            return null;
        }
        String m9994m = c1306a.m9994m();
        ArrayList<C1225p> arrayList = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(m9994m).optJSONArray("dataset");
            for (int i = 0; i < optJSONArray.length(); i++) {
                C1225p c1225p = new C1225p();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                c1225p.f6071a = optJSONObject.optInt("id");
                c1225p.f6072b = optJSONObject.optString("name");
                c1225p.f6073c = optJSONObject.optInt("mapsize");
                c1225p.f6074d = optJSONObject.optInt("cty");
                if (optJSONObject.has("child")) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("child");
                    ArrayList<C1225p> arrayList2 = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        C1225p c1225p2 = new C1225p();
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        c1225p2.f6071a = optJSONObject2.optInt("id");
                        c1225p2.f6072b = optJSONObject2.optString("name");
                        c1225p2.f6073c = optJSONObject2.optInt("mapsize");
                        c1225p2.f6074d = optJSONObject2.optInt("cty");
                        arrayList2.add(c1225p2);
                    }
                    c1225p.m10592a(arrayList2);
                }
                arrayList.add(c1225p);
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public boolean m10581c(int i) {
        C1306a c1306a = this.f6078b;
        if (c1306a == null || i < 0) {
            return false;
        }
        return c1306a.m10024b(i, false, 0);
    }

    /* renamed from: d */
    public ArrayList<C1225p> m10580d() {
        C1306a c1306a = this.f6078b;
        if (c1306a == null) {
            return null;
        }
        String m10036a = c1306a.m10036a("");
        ArrayList<C1225p> arrayList = new ArrayList<>();
        try {
            JSONArray optJSONArray = new JSONObject(m10036a).optJSONArray("dataset");
            for (int i = 0; i < optJSONArray.length(); i++) {
                C1225p c1225p = new C1225p();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                int optInt = optJSONObject.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    c1225p.f6071a = optInt;
                    c1225p.f6072b = optJSONObject.optString("name");
                    c1225p.f6073c = optJSONObject.optInt("mapsize");
                    c1225p.f6074d = optJSONObject.optInt("cty");
                    if (optJSONObject.has("child")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("child");
                        ArrayList<C1225p> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            C1225p c1225p2 = new C1225p();
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            c1225p2.f6071a = optJSONObject2.optInt("id");
                            c1225p2.f6072b = optJSONObject2.optString("name");
                            c1225p2.f6073c = optJSONObject2.optInt("mapsize");
                            c1225p2.f6074d = optJSONObject2.optInt("cty");
                            arrayList2.add(c1225p2);
                        }
                        c1225p.m10592a(arrayList2);
                    }
                    arrayList.add(c1225p);
                }
            }
            return arrayList;
        } catch (JSONException | Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public boolean m10579d(int i) {
        C1306a c1306a = this.f6078b;
        if (c1306a == null) {
            return false;
        }
        return c1306a.m10024b(0, true, i);
    }

    /* renamed from: e */
    public ArrayList<C1229s> m10578e() {
        String m9995l;
        C1306a c1306a = this.f6078b;
        if (c1306a != null && (m9995l = c1306a.m9995l()) != null && !m9995l.equals("")) {
            ArrayList<C1229s> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(m9995l);
                if (jSONObject.length() == 0) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("dataset");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C1229s c1229s = new C1229s();
                    C1228r c1228r = new C1228r();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    c1228r.f6082a = optJSONObject.optInt("id");
                    c1228r.f6083b = optJSONObject.optString("name");
                    c1228r.f6084c = optJSONObject.optString("pinyin");
                    c1228r.f6089h = optJSONObject.optInt("mapoldsize");
                    c1228r.f6090i = optJSONObject.optInt("ratio");
                    c1228r.f6093l = optJSONObject.optInt("status");
                    c1228r.f6088g = new GeoPoint(optJSONObject.optInt("y"), optJSONObject.optInt(GroupChatInvitation.ELEMENT_NAME));
                    boolean z = true;
                    if (optJSONObject.optInt("up") != 1) {
                        z = false;
                    }
                    c1228r.f6091j = z;
                    c1228r.f6086e = optJSONObject.optInt("lev");
                    if (c1228r.f6091j) {
                        c1228r.f6092k = optJSONObject.optInt("mapsize");
                    } else {
                        c1228r.f6092k = 0;
                    }
                    c1229s.m10570a(c1228r);
                    arrayList.add(c1229s);
                }
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: e */
    public boolean m10577e(int i) {
        C1306a c1306a = this.f6078b;
        if (c1306a == null || i < 0) {
            return false;
        }
        return c1306a.m10025b(i, false);
    }

    /* renamed from: f */
    public boolean m10575f(int i) {
        if (this.f6078b == null || i < 0) {
            return false;
        }
        if (i <= 2000 || i == 2912 || i == 2911 || i == 9000) {
            return this.f6078b.m10044a(i, false);
        }
        return false;
    }

    /* renamed from: g */
    public C1229s m10573g(int i) {
        String m10008e;
        C1306a c1306a = this.f6078b;
        if (c1306a != null && i >= 0 && (m10008e = c1306a.m10008e(i)) != null && !m10008e.equals("")) {
            C1229s c1229s = new C1229s();
            C1228r c1228r = new C1228r();
            try {
                JSONObject jSONObject = new JSONObject(m10008e);
                if (jSONObject.length() == 0) {
                    return null;
                }
                int optInt = jSONObject.optInt("id");
                if (optInt <= 2000 || optInt == 2912 || optInt == 2911 || optInt == 9000) {
                    c1228r.f6082a = optInt;
                    c1228r.f6083b = jSONObject.optString("name");
                    c1228r.f6084c = jSONObject.optString("pinyin");
                    c1228r.f6085d = jSONObject.optString("headchar");
                    c1228r.f6089h = jSONObject.optInt("mapoldsize");
                    c1228r.f6090i = jSONObject.optInt("ratio");
                    c1228r.f6093l = jSONObject.optInt("status");
                    c1228r.f6088g = new GeoPoint(jSONObject.optInt("y"), jSONObject.optInt(GroupChatInvitation.ELEMENT_NAME));
                    boolean z = true;
                    if (jSONObject.optInt("up") != 1) {
                        z = false;
                    }
                    c1228r.f6091j = z;
                    c1228r.f6086e = jSONObject.optInt("lev");
                    if (c1228r.f6091j) {
                        c1228r.f6092k = jSONObject.optInt("mapsize");
                    } else {
                        c1228r.f6092k = 0;
                    }
                    c1228r.f6087f = jSONObject.optInt("ver");
                    c1229s.m10570a(c1228r);
                    return c1229s;
                }
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
