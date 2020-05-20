package com.baidu.mapapi.map;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class MapBaseIndoorMapInfo {

    /* renamed from: d */
    private static final String f5067d = "MapBaseIndoorMapInfo";

    /* renamed from: a */
    String f5068a;

    /* renamed from: b */
    String f5069b;

    /* renamed from: c */
    ArrayList<String> f5070c;

    /* loaded from: classes.dex */
    public enum SwitchFloorError {
        SWITCH_OK,
        FLOOR_INFO_ERROR,
        FLOOR_OVERLFLOW,
        FOCUSED_ID_ERROR,
        SWITCH_ERROR
    }

    public MapBaseIndoorMapInfo() {
    }

    public MapBaseIndoorMapInfo(MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        this.f5068a = mapBaseIndoorMapInfo.f5068a;
        this.f5069b = mapBaseIndoorMapInfo.f5069b;
        this.f5070c = mapBaseIndoorMapInfo.f5070c;
    }

    public MapBaseIndoorMapInfo(String str, String str2, ArrayList<String> arrayList) {
        this.f5068a = str;
        this.f5069b = str2;
        this.f5070c = arrayList;
    }

    public final String getCurFloor() {
        return this.f5069b;
    }

    public final ArrayList<String> getFloors() {
        return this.f5070c;
    }

    public final String getID() {
        return this.f5068a;
    }
}
