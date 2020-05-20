package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

/* loaded from: classes.dex */
public final class MapStatusUpdateFactory {
    MapStatusUpdateFactory() {
    }

    public static MapStatusUpdate newLatLng(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(2);
        mapStatusUpdate.f5094c = latLng;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(3);
        mapStatusUpdate.f5095d = latLngBounds;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2) {
        if (latLngBounds == null || i <= 0 || i2 <= 0) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(9);
        mapStatusUpdate.f5095d = latLngBounds;
        mapStatusUpdate.f5096e = i;
        mapStatusUpdate.f5097f = i2;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(10);
        mapStatusUpdate.f5095d = latLngBounds;
        mapStatusUpdate.f5103l = i;
        mapStatusUpdate.f5104m = i2;
        mapStatusUpdate.f5105n = i3;
        mapStatusUpdate.f5106o = i4;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngZoom(LatLng latLng, float f) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(4);
        if (latLng == null) {
            return null;
        }
        mapStatusUpdate.f5094c = latLng;
        mapStatusUpdate.f5098g = f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newMapStatus(MapStatus mapStatus) {
        if (mapStatus == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(1);
        mapStatusUpdate.f5093b = mapStatus;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate scrollBy(int i, int i2) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(5);
        mapStatusUpdate.f5099h = i;
        mapStatusUpdate.f5100i = i2;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomBy(float f) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.f5101j = f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomBy(float f, Point point) {
        if (point == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(7);
        mapStatusUpdate.f5101j = f;
        mapStatusUpdate.f5102k = point;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomIn() {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.f5101j = 1.0f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomOut() {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.f5101j = -1.0f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomTo(float f) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(8);
        mapStatusUpdate.f5098g = f;
        return mapStatusUpdate;
    }
}
