package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.itextpdf.text.Annotation;

/* loaded from: classes.dex */
public final class TileOverlayOptions {

    /* renamed from: c */
    private static Bundle f5336c = null;

    /* renamed from: j */
    private static final String f5337j = "TileOverlayOptions";

    /* renamed from: b */
    private TileProvider f5339b;
    public int datasource;
    public String urlString;

    /* renamed from: a */
    private int f5338a = 209715200;

    /* renamed from: d */
    private int f5340d = 20;

    /* renamed from: e */
    private int f5341e = 3;

    /* renamed from: f */
    private int f5342f = 15786414;

    /* renamed from: g */
    private int f5343g = -20037726;

    /* renamed from: h */
    private int f5344h = -15786414;

    /* renamed from: i */
    private int f5345i = 20037726;

    public TileOverlayOptions() {
        Bundle bundle = new Bundle();
        f5336c = bundle;
        bundle.putInt("rectr", this.f5342f);
        f5336c.putInt("rectb", this.f5343g);
        f5336c.putInt("rectl", this.f5344h);
        f5336c.putInt("rectt", this.f5345i);
    }

    /* renamed from: a */
    private TileOverlayOptions m11109a(int i, int i2) {
        this.f5340d = i;
        this.f5341e = i2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final Bundle m11110a() {
        f5336c.putString(Annotation.URL, this.urlString);
        f5336c.putInt("datasource", this.datasource);
        f5336c.putInt("maxDisplay", this.f5340d);
        f5336c.putInt("minDisplay", this.f5341e);
        f5336c.putInt("sdktiletmpmax", this.f5338a);
        return f5336c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final TileOverlay m11108a(BaiduMap baiduMap) {
        return new TileOverlay(baiduMap, this.f5339b);
    }

    public final TileOverlayOptions setMaxTileTmp(int i) {
        this.f5338a = i;
        return this;
    }

    public final TileOverlayOptions setPositionFromBounds(LatLngBounds latLngBounds) {
        if (latLngBounds != null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(latLngBounds.northeast);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLngBounds.southwest);
            double latitudeE6 = ll2mc.getLatitudeE6();
            double longitudeE6 = ll2mc2.getLongitudeE6();
            double latitudeE62 = ll2mc2.getLatitudeE6();
            double longitudeE62 = ll2mc.getLongitudeE6();
            if (latitudeE6 <= latitudeE62 || longitudeE62 <= longitudeE6) {
                Log.e(f5337j, "bounds is illegal, use default bounds");
            } else {
                f5336c.putInt("rectr", (int) longitudeE62);
                f5336c.putInt("rectb", (int) latitudeE62);
                f5336c.putInt("rectl", (int) longitudeE6);
                f5336c.putInt("rectt", (int) latitudeE6);
            }
            return this;
        }
        throw new IllegalArgumentException("bound can not be null");
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        String str;
        String str2;
        int maxDisLevel;
        if (tileProvider == null) {
            return null;
        }
        if (!(tileProvider instanceof UrlTileProvider)) {
            if (!(tileProvider instanceof FileTileProvider)) {
                str = f5337j;
                str2 = "tileProvider must be UrlTileProvider or FileTileProvider";
                Log.e(str, str2);
                return null;
            }
            this.datasource = 0;
            this.f5339b = tileProvider;
            maxDisLevel = tileProvider.getMaxDisLevel();
            int minDisLevel = tileProvider.getMinDisLevel();
            if (maxDisLevel <= 21) {
            }
            Log.e(f5337j, "display level is illegal");
            return this;
        }
        this.datasource = 1;
        String tileUrl = ((UrlTileProvider) tileProvider).getTileUrl();
        if (tileUrl == null || "".equals(tileUrl) || !tileUrl.contains("{x}") || !tileUrl.contains("{y}") || !tileUrl.contains("{z}")) {
            str = f5337j;
            str2 = "tile url template is illegal, must contains {x}、{y}、{z}";
            Log.e(str, str2);
            return null;
        }
        this.urlString = tileUrl;
        this.f5339b = tileProvider;
        maxDisLevel = tileProvider.getMaxDisLevel();
        int minDisLevel2 = tileProvider.getMinDisLevel();
        if (maxDisLevel <= 21 || minDisLevel2 < 3) {
            Log.e(f5337j, "display level is illegal");
        } else {
            m11109a(maxDisLevel, minDisLevel2);
        }
        return this;
    }
}
