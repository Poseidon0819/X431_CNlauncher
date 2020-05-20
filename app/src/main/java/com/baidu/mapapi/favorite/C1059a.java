package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.json.JSONObject;

/* renamed from: com.baidu.mapapi.favorite.a */
/* loaded from: classes.dex */
class C1059a {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static FavoritePoiInfo m11268a(FavSyncPoi favSyncPoi) {
        if (favSyncPoi == null || favSyncPoi.f5888c == null || favSyncPoi.f5887b.equals("")) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        favoritePoiInfo.f4884a = favSyncPoi.f5886a;
        favoritePoiInfo.f4885b = favSyncPoi.f5887b;
        double d = favSyncPoi.f5888c.f5414y;
        Double.isNaN(d);
        double d2 = favSyncPoi.f5888c.f5413x;
        Double.isNaN(d2);
        favoritePoiInfo.f4886c = new LatLng(d / 1000000.0d, d2 / 1000000.0d);
        favoritePoiInfo.f4888e = favSyncPoi.f5890e;
        favoritePoiInfo.f4889f = favSyncPoi.f5891f;
        favoritePoiInfo.f4887d = favSyncPoi.f5889d;
        favoritePoiInfo.f4890g = Long.parseLong(favSyncPoi.f5893h);
        return favoritePoiInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static FavoritePoiInfo m11267a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FavoritePoiInfo favoritePoiInfo = new FavoritePoiInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject("pt");
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt(GroupChatInvitation.ELEMENT_NAME);
            double optInt2 = optJSONObject.optInt("y");
            Double.isNaN(optInt2);
            double d = optInt;
            Double.isNaN(d);
            favoritePoiInfo.f4886c = new LatLng(optInt2 / 1000000.0d, d / 1000000.0d);
        }
        favoritePoiInfo.f4885b = jSONObject.optString("uspoiname");
        favoritePoiInfo.f4890g = Long.parseLong(jSONObject.optString("addtimesec"));
        favoritePoiInfo.f4887d = jSONObject.optString("addr");
        favoritePoiInfo.f4889f = jSONObject.optString("uspoiuid");
        favoritePoiInfo.f4888e = jSONObject.optString("ncityid");
        favoritePoiInfo.f4884a = jSONObject.optString("key");
        return favoritePoiInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static FavSyncPoi m11269a(FavoritePoiInfo favoritePoiInfo) {
        if (favoritePoiInfo == null || favoritePoiInfo.f4886c == null || favoritePoiInfo.f4885b == null || favoritePoiInfo.f4885b.equals("")) {
            return null;
        }
        FavSyncPoi favSyncPoi = new FavSyncPoi();
        favSyncPoi.f5887b = favoritePoiInfo.f4885b;
        favSyncPoi.f5888c = new Point((int) (favoritePoiInfo.f4886c.longitude * 1000000.0d), (int) (favoritePoiInfo.f4886c.latitude * 1000000.0d));
        favSyncPoi.f5889d = favoritePoiInfo.f4887d;
        favSyncPoi.f5890e = favoritePoiInfo.f4888e;
        favSyncPoi.f5891f = favoritePoiInfo.f4889f;
        favSyncPoi.f5894i = false;
        return favSyncPoi;
    }
}
