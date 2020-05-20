package com.baidu.mapapi.favorite;

import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.C1191a;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.C1215i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FavoriteManager {

    /* renamed from: a */
    private static FavoriteManager f4882a;

    /* renamed from: b */
    private static C1191a f4883b;

    private FavoriteManager() {
    }

    public static FavoriteManager getInstance() {
        if (f4882a == null) {
            f4882a = new FavoriteManager();
        }
        return f4882a;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        String str;
        String str2;
        if (f4883b == null) {
            str = "baidumapsdk";
            str2 = "you may have not call init method!";
        } else if (favoritePoiInfo != null && favoritePoiInfo.f4886c != null) {
            if (favoritePoiInfo.f4885b == null || favoritePoiInfo.f4885b.equals("")) {
                Log.e("baidumapsdk", "poiName can not be null or empty!");
                return -1;
            }
            FavSyncPoi m11269a = C1059a.m11269a(favoritePoiInfo);
            int m10815a = f4883b.m10815a(m11269a.f5887b, m11269a);
            if (m10815a == 1) {
                favoritePoiInfo.f4884a = m11269a.f5886a;
                favoritePoiInfo.f4890g = Long.parseLong(m11269a.f5893h);
            }
            return m10815a;
        } else {
            str = "baidumapsdk";
            str2 = "object or pt can not be null!";
        }
        Log.e(str, str2);
        return 0;
    }

    public boolean clearAllFavPois() {
        C1191a c1191a = f4883b;
        if (c1191a == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        return c1191a.m10811c();
    }

    public boolean deleteFavPoi(String str) {
        if (f4883b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        } else if (str == null || str.equals("")) {
            return false;
        } else {
            return f4883b.m10816a(str);
        }
    }

    public void destroy() {
        C1191a c1191a = f4883b;
        if (c1191a != null) {
            c1191a.m10814b();
            f4883b = null;
            BMapManager.destroy();
            C1215i.m10643b();
        }
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        JSONArray optJSONArray;
        C1191a c1191a = f4883b;
        if (c1191a == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        String m10807f = c1191a.m10807f();
        if (m10807f != null && !m10807f.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(m10807f);
                if (jSONObject.optInt("favpoinum") != 0 && (optJSONArray = jSONObject.optJSONArray("favcontents")) != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            arrayList.add(C1059a.m11267a(jSONObject2));
                        }
                    }
                    return arrayList;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public FavoritePoiInfo getFavPoi(String str) {
        FavSyncPoi m10813b;
        if (f4883b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        } else if (str == null || str.equals("") || (m10813b = f4883b.m10813b(str)) == null) {
            return null;
        } else {
            return C1059a.m11268a(m10813b);
        }
    }

    public void init() {
        if (f4883b == null) {
            C1215i.m10646a();
            BMapManager.init();
            f4883b = C1191a.m10817a();
        }
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        String str2;
        String str3;
        if (f4883b == null) {
            str2 = "baidumapsdk";
            str3 = "you may have not call init method!";
        } else if (str == null || str.equals("") || favoritePoiInfo == null) {
            return false;
        } else {
            if (favoritePoiInfo == null || favoritePoiInfo.f4886c == null) {
                str2 = "baidumapsdk";
                str3 = "object or pt can not be null!";
            } else if (favoritePoiInfo.f4885b != null && !favoritePoiInfo.f4885b.equals("")) {
                favoritePoiInfo.f4884a = str;
                return f4883b.m10812b(str, C1059a.m11269a(favoritePoiInfo));
            } else {
                str2 = "baidumapsdk";
                str3 = "poiName can not be null or empty!";
            }
        }
        Log.e(str2, str3);
        return false;
    }
}
