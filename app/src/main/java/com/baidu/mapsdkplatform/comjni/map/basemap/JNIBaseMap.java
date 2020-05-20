package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;

/* loaded from: classes.dex */
public class JNIBaseMap {

    /* renamed from: a */
    public long f6434a;

    public static native int MapProc(long j, int i, int i2, int i3);

    public static native void SetMapCustomEnable(long j, boolean z);

    public native long AddLayer(long j, int i, int i2, String str);

    public native void ClearLayer(long j, long j2);

    public native long Create();

    public native long CreateDuplicate(long j);

    public native String GeoPtToScrPoint(long j, int i, int i2);

    public native boolean GetBaiduHotMapCityInfo(long j);

    public native Bundle GetMapStatus(long j);

    public native String GetNearlyObjID(long j, long j2, int i, int i2, int i3);

    public native int[] GetScreenBuf(long j, int[] iArr, int i, int i2);

    public native float GetZoomToBound(long j, Bundle bundle);

    public native boolean Init(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public native boolean IsBaseIndoorMapMode(long j);

    public native boolean LayersIsShow(long j, long j2);

    public native void OnBackground(long j);

    public native void OnForeground(long j);

    public native String OnHotcityGet(long j);

    public native void OnPause(long j);

    public native boolean OnRecordAdd(long j, int i);

    public native String OnRecordGetAll(long j);

    public native String OnRecordGetAt(long j, int i);

    public native boolean OnRecordImport(long j, boolean z, boolean z2);

    public native boolean OnRecordReload(long j, int i, boolean z);

    public native boolean OnRecordRemove(long j, int i, boolean z);

    public native boolean OnRecordStart(long j, int i, boolean z, int i2);

    public native boolean OnRecordSuspend(long j, int i, boolean z, int i2);

    public native void OnResume(long j);

    public native String OnSchcityGet(long j, String str);

    public native void PostStatInfo(long j);

    public native int Release(long j);

    public native void ResetImageRes(long j);

    public native void SaveScreenToLocal(long j, String str, Bundle bundle);

    public native String ScrPtToGeoPoint(long j, int i, int i2);

    public native int SetCallback(long j, BaseMapCallback baseMapCallback);

    public native int SetMapControlMode(long j, int i);

    public native void SetMapStatus(long j, Bundle bundle);

    public native void ShowBaseIndoorMap(long j, boolean z);

    public native void ShowHotMap(long j, boolean z);

    public native void ShowLayers(long j, long j2, boolean z);

    public native void ShowSatelliteMap(long j, boolean z);

    public native void ShowTrafficMap(long j, boolean z);

    public native boolean SwitchBaseIndoorMapFloor(long j, String str, String str2);

    public native boolean SwitchLayer(long j, long j2, long j3);

    public native void UpdateLayers(long j, long j2);

    public native void addOneOverlayItem(long j, Bundle bundle);

    public native void addOverlayItems(long j, Bundle[] bundleArr, int i);

    public native boolean addtileOverlay(long j, Bundle bundle);

    public native boolean cleanSDKTileDataCache(long j, long j2);

    public native void clearHeatMapLayerCache(long j);

    public native void enableDrawHouseHeight(long j, boolean z);

    public native String getCompassPosition(long j, long j2);

    public native Bundle getDrawingMapStatus(long j);

    public native Bundle getMapStatusLimits(long j);

    public native void getProjectionMatrix(long j, float[] fArr, int i);

    public native void getViewMatrix(long j, float[] fArr, int i);

    public native String getfocusedBaseIndoorMapInfo(long j);

    public native boolean isDrawHouseHeightEnable(long j);

    public native void removeOneOverlayItem(long j, Bundle bundle);

    public native void resetBackgroundTransparent(long j);

    public native void setBackgroundTransparent(long j);

    public native void setCustomTrafficColor(long j, long j2, long j3, long j4, long j5, boolean z);

    public native void setMapStatusLimits(long j, Bundle bundle);

    public native void updateOneOverlayItem(long j, Bundle bundle);

    public native boolean updateSDKTile(long j, Bundle bundle);
}
