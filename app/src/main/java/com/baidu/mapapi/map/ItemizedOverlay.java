package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;

/* loaded from: classes.dex */
public class ItemizedOverlay extends Overlay {

    /* renamed from: a */
    MapView f5065a;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = EnumC1214h.marker;
        this.f5065a = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions == null || overlayOptions == null) {
            return;
        }
        this.f5065a.getMap().addOverlay(overlayOptions);
    }

    public void reAddAll() {
    }

    public void removeAll() {
        this.f5065a.getMap().clear();
    }
}
