package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.common.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class TileOverlay {

    /* renamed from: b */
    private static final String f5324b = "TileOverlay";

    /* renamed from: f */
    private static int f5325f;

    /* renamed from: a */
    BaiduMap f5326a;

    /* renamed from: g */
    private TileProvider f5330g;

    /* renamed from: d */
    private HashMap<String, Tile> f5328d = new HashMap<>();

    /* renamed from: e */
    private HashSet<String> f5329e = new HashSet<>();

    /* renamed from: c */
    private ExecutorService f5327c = Executors.newFixedThreadPool(1);

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.f5326a = baiduMap;
        this.f5330g = tileProvider;
    }

    /* renamed from: a */
    private synchronized Tile m11117a(String str) {
        if (this.f5328d.containsKey(str)) {
            Tile tile = this.f5328d.get(str);
            this.f5328d.remove(str);
            return tile;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m11116a(String str, Tile tile) {
        this.f5328d.put(str, tile);
    }

    /* renamed from: b */
    private synchronized boolean m11113b(String str) {
        return this.f5329e.contains(str);
    }

    /* renamed from: c */
    private synchronized void m11111c(String str) {
        this.f5329e.add(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final Tile m11120a(final int i, final int i2, final int i3) {
        String str;
        String str2;
        final String str3 = i + "_" + i2 + "_" + i3;
        Tile m11117a = m11117a(str3);
        if (m11117a != null) {
            return m11117a;
        }
        BaiduMap baiduMap = this.f5326a;
        if (baiduMap != null && f5325f == 0) {
            MapStatus mapStatus = baiduMap.getMapStatus();
            f5325f = (((mapStatus.f5079a.f6123j.right - mapStatus.f5079a.f6123j.left) / 256) + 2) * (((mapStatus.f5079a.f6123j.bottom - mapStatus.f5079a.f6123j.top) / 256) + 2);
        }
        if (this.f5328d.size() > f5325f) {
            m11121a();
        }
        if (m11113b(str3) || this.f5327c.isShutdown()) {
            return null;
        }
        try {
            m11111c(str3);
            this.f5327c.execute(new Runnable() { // from class: com.baidu.mapapi.map.TileOverlay.1
                @Override // java.lang.Runnable
                public void run() {
                    String str4;
                    String str5;
                    Tile tile = ((FileTileProvider) TileOverlay.this.f5330g).getTile(i, i2, i3);
                    if (tile == null) {
                        str4 = TileOverlay.f5324b;
                        str5 = "FileTile pic is null";
                    } else if (tile.width == 256 && tile.height == 256) {
                        TileOverlay.this.m11116a(i + "_" + i2 + "_" + i3, tile);
                        TileOverlay.this.f5329e.remove(str3);
                    } else {
                        str4 = TileOverlay.f5324b;
                        str5 = "FileTile pic must be 256 * 256";
                    }
                    Log.e(str4, str5);
                    TileOverlay.this.f5329e.remove(str3);
                }
            });
            return null;
        } catch (RejectedExecutionException unused) {
            str = f5324b;
            str2 = "ThreadPool excepiton";
            Log.e(str, str2);
            return null;
        } catch (Exception unused2) {
            str = f5324b;
            str2 = "fileDir is not legal";
            Log.e(str, str2);
            return null;
        }
    }

    /* renamed from: a */
    final synchronized void m11121a() {
        Logger.logE(f5324b, "clearTaskSet");
        this.f5329e.clear();
        this.f5328d.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m11115b() {
        this.f5327c.shutdownNow();
    }

    public final boolean clearTileCache() {
        return this.f5326a.m11249b();
    }

    public final void removeTileOverlay() {
        BaiduMap baiduMap = this.f5326a;
        if (baiduMap == null) {
            return;
        }
        baiduMap.m11251a(this);
    }
}
