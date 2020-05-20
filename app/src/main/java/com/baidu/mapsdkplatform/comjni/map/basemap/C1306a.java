package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mapsdkplatform.comjni.map.basemap.a */
/* loaded from: classes.dex */
public class C1306a {

    /* renamed from: a */
    private static final String f6435a = "a";

    /* renamed from: d */
    private static Set<Integer> f6436d = new HashSet();

    /* renamed from: e */
    private static List<JNIBaseMap> f6437e = new ArrayList();

    /* renamed from: b */
    private long f6438b = 0;

    /* renamed from: c */
    private JNIBaseMap f6439c;

    public C1306a() {
        this.f6439c = null;
        this.f6439c = new JNIBaseMap();
    }

    /* renamed from: a */
    public static int m10041a(long j, int i, int i2, int i3) {
        return JNIBaseMap.MapProc(j, i, i2, i3);
    }

    /* renamed from: b */
    public static List<JNIBaseMap> m10028b() {
        return f6437e;
    }

    /* renamed from: b */
    public static void m10022b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    /* renamed from: a */
    public long m10049a() {
        return this.f6438b;
    }

    /* renamed from: a */
    public long m10045a(int i, int i2, String str) {
        return this.f6439c.AddLayer(this.f6438b, i, i2, str);
    }

    /* renamed from: a */
    public String m10047a(int i, int i2) {
        return this.f6439c.ScrPtToGeoPoint(this.f6438b, i, i2);
    }

    /* renamed from: a */
    public String m10046a(int i, int i2, int i3, int i4) {
        return this.f6439c.GetNearlyObjID(this.f6438b, i, i2, i3, i4);
    }

    /* renamed from: a */
    public String m10036a(String str) {
        return this.f6439c.OnSchcityGet(this.f6438b, str);
    }

    /* renamed from: a */
    public void m10039a(long j, long j2, long j3, long j4, boolean z) {
        this.f6439c.setCustomTrafficColor(this.f6438b, j, j2, j3, j4, z);
    }

    /* renamed from: a */
    public void m10038a(long j, boolean z) {
        this.f6439c.ShowLayers(this.f6438b, j, z);
    }

    /* renamed from: a */
    public void m10037a(Bundle bundle) {
        this.f6439c.SetMapStatus(this.f6438b, bundle);
    }

    /* renamed from: a */
    public void m10035a(String str, Bundle bundle) {
        this.f6439c.SaveScreenToLocal(this.f6438b, str, bundle);
    }

    /* renamed from: a */
    public void m10032a(boolean z) {
        this.f6439c.ShowSatelliteMap(this.f6438b, z);
    }

    /* renamed from: a */
    public void m10029a(Bundle[] bundleArr) {
        this.f6439c.addOverlayItems(this.f6438b, bundleArr, bundleArr.length);
    }

    /* renamed from: a */
    public boolean m10048a(int i) {
        this.f6438b = (f6437e.size() == 0 || !f6436d.contains(Integer.valueOf(i))) ? this.f6439c.Create() : this.f6439c.CreateDuplicate(f6437e.get(0).f6434a);
        JNIBaseMap jNIBaseMap = this.f6439c;
        jNIBaseMap.f6434a = this.f6438b;
        f6437e.add(jNIBaseMap);
        f6436d.add(Integer.valueOf(i));
        this.f6439c.SetCallback(this.f6438b, null);
        return true;
    }

    /* renamed from: a */
    public boolean m10044a(int i, boolean z) {
        return this.f6439c.OnRecordReload(this.f6438b, i, z);
    }

    /* renamed from: a */
    public boolean m10043a(int i, boolean z, int i2) {
        return this.f6439c.OnRecordStart(this.f6438b, i, z, i2);
    }

    /* renamed from: a */
    public boolean m10042a(long j) {
        return this.f6439c.LayersIsShow(this.f6438b, j);
    }

    /* renamed from: a */
    public boolean m10040a(long j, long j2) {
        return this.f6439c.SwitchLayer(this.f6438b, j, j2);
    }

    /* renamed from: a */
    public boolean m10034a(String str, String str2) {
        return this.f6439c.SwitchBaseIndoorMapFloor(this.f6438b, str, str2);
    }

    /* renamed from: a */
    public boolean m10033a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return this.f6439c.Init(this.f6438b, str, str2, str3, str4, str5, str6, str7, i != 0 ? String.valueOf(i) : null, str8, i2, i3, i4, i5, i6, i7, i8);
    }

    /* renamed from: a */
    public boolean m10031a(boolean z, boolean z2) {
        return this.f6439c.OnRecordImport(this.f6438b, z, z2);
    }

    /* renamed from: a */
    public int[] m10030a(int[] iArr, int i, int i2) {
        return this.f6439c.GetScreenBuf(this.f6438b, iArr, i, i2);
    }

    /* renamed from: b */
    public String m10026b(int i, int i2) {
        return this.f6439c.GeoPtToScrPoint(this.f6438b, i, i2);
    }

    /* renamed from: b */
    public void m10023b(long j) {
        this.f6439c.UpdateLayers(this.f6438b, j);
    }

    /* renamed from: b */
    public void m10021b(Bundle bundle) {
        this.f6439c.setMapStatusLimits(this.f6438b, bundle);
    }

    /* renamed from: b */
    public void m10020b(boolean z) {
        this.f6439c.ShowHotMap(this.f6438b, z);
    }

    /* renamed from: b */
    public boolean m10027b(int i) {
        this.f6439c.Release(this.f6438b);
        f6437e.remove(this.f6439c);
        f6436d.remove(Integer.valueOf(i));
        return true;
    }

    /* renamed from: b */
    public boolean m10025b(int i, boolean z) {
        return this.f6439c.OnRecordRemove(this.f6438b, i, z);
    }

    /* renamed from: b */
    public boolean m10024b(int i, boolean z, int i2) {
        return this.f6439c.OnRecordSuspend(this.f6438b, i, z, i2);
    }

    /* renamed from: c */
    public float m10016c(Bundle bundle) {
        return this.f6439c.GetZoomToBound(this.f6438b, bundle);
    }

    /* renamed from: c */
    public int m10018c(int i) {
        return this.f6439c.SetMapControlMode(this.f6438b, i);
    }

    /* renamed from: c */
    public void m10019c() {
        this.f6439c.OnPause(this.f6438b);
    }

    /* renamed from: c */
    public void m10015c(boolean z) {
        this.f6439c.ShowTrafficMap(this.f6438b, z);
    }

    /* renamed from: c */
    public boolean m10017c(long j) {
        return this.f6439c.cleanSDKTileDataCache(this.f6438b, j);
    }

    /* renamed from: d */
    public void m10014d() {
        this.f6439c.OnResume(this.f6438b);
    }

    /* renamed from: d */
    public void m10012d(long j) {
        this.f6439c.ClearLayer(this.f6438b, j);
    }

    /* renamed from: d */
    public void m10010d(boolean z) {
        this.f6439c.enableDrawHouseHeight(this.f6438b, z);
    }

    /* renamed from: d */
    public boolean m10013d(int i) {
        return this.f6439c.OnRecordAdd(this.f6438b, i);
    }

    /* renamed from: d */
    public boolean m10011d(Bundle bundle) {
        return this.f6439c.updateSDKTile(this.f6438b, bundle);
    }

    /* renamed from: e */
    public String m10008e(int i) {
        return this.f6439c.OnRecordGetAt(this.f6438b, i);
    }

    /* renamed from: e */
    public String m10007e(long j) {
        return this.f6439c.getCompassPosition(this.f6438b, j);
    }

    /* renamed from: e */
    public void m10009e() {
        this.f6439c.OnBackground(this.f6438b);
    }

    /* renamed from: e */
    public void m10005e(boolean z) {
        this.f6439c.ShowBaseIndoorMap(this.f6438b, z);
    }

    /* renamed from: e */
    public boolean m10006e(Bundle bundle) {
        return this.f6439c.addtileOverlay(this.f6438b, bundle);
    }

    /* renamed from: f */
    public void m10004f() {
        this.f6439c.OnForeground(this.f6438b);
    }

    /* renamed from: f */
    public void m10003f(Bundle bundle) {
        this.f6439c.addOneOverlayItem(this.f6438b, bundle);
    }

    /* renamed from: g */
    public void m10002g() {
        this.f6439c.ResetImageRes(this.f6438b);
    }

    /* renamed from: g */
    public void m10001g(Bundle bundle) {
        this.f6439c.updateOneOverlayItem(this.f6438b, bundle);
    }

    /* renamed from: h */
    public Bundle m10000h() {
        return this.f6439c.GetMapStatus(this.f6438b);
    }

    /* renamed from: h */
    public void m9999h(Bundle bundle) {
        this.f6439c.removeOneOverlayItem(this.f6438b, bundle);
    }

    /* renamed from: i */
    public Bundle m9998i() {
        return this.f6439c.getMapStatusLimits(this.f6438b);
    }

    /* renamed from: j */
    public Bundle m9997j() {
        return this.f6439c.getDrawingMapStatus(this.f6438b);
    }

    /* renamed from: k */
    public boolean m9996k() {
        return this.f6439c.GetBaiduHotMapCityInfo(this.f6438b);
    }

    /* renamed from: l */
    public String m9995l() {
        return this.f6439c.OnRecordGetAll(this.f6438b);
    }

    /* renamed from: m */
    public String m9994m() {
        return this.f6439c.OnHotcityGet(this.f6438b);
    }

    /* renamed from: n */
    public void m9993n() {
        this.f6439c.PostStatInfo(this.f6438b);
    }

    /* renamed from: o */
    public boolean m9992o() {
        return this.f6439c.isDrawHouseHeightEnable(this.f6438b);
    }

    /* renamed from: p */
    public void m9991p() {
        this.f6439c.clearHeatMapLayerCache(this.f6438b);
    }

    /* renamed from: q */
    public MapBaseIndoorMapInfo m9990q() {
        JSONArray optJSONArray;
        String str = this.f6439c.getfocusedBaseIndoorMapInfo(this.f6438b);
        if (str == null) {
            return null;
        }
        String str2 = "";
        String str3 = new String();
        ArrayList arrayList = new ArrayList(1);
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("focusindoorid");
            str3 = jSONObject.optString("curfloor");
            optJSONArray = jSONObject.optJSONArray("floorlist");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (optJSONArray == null) {
            return null;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.get(i).toString());
        }
        return new MapBaseIndoorMapInfo(str2, str3, arrayList);
    }

    /* renamed from: r */
    public boolean m9989r() {
        return this.f6439c.IsBaseIndoorMapMode(this.f6438b);
    }

    /* renamed from: s */
    public void m9988s() {
        this.f6439c.setBackgroundTransparent(this.f6438b);
    }

    /* renamed from: t */
    public void m9987t() {
        this.f6439c.resetBackgroundTransparent(this.f6438b);
    }

    /* renamed from: u */
    public float[] m9986u() {
        JNIBaseMap jNIBaseMap = this.f6439c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getProjectionMatrix(this.f6438b, fArr, 16);
        return fArr;
    }

    /* renamed from: v */
    public float[] m9985v() {
        JNIBaseMap jNIBaseMap = this.f6439c;
        if (jNIBaseMap == null) {
            return null;
        }
        float[] fArr = new float[16];
        jNIBaseMap.getViewMatrix(this.f6438b, fArr, 16);
        return fArr;
    }
}
