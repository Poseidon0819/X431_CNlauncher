package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.C1115a;
import com.baidu.platform.core.p094b.C1334a;
import com.baidu.platform.core.p094b.InterfaceC1337d;

/* loaded from: classes.dex */
public class GeoCoder extends C1115a {

    /* renamed from: a */
    private InterfaceC1337d f5494a = new C1334a();

    /* renamed from: b */
    private boolean f5495b;

    private GeoCoder() {
    }

    public static GeoCoder newInstance() {
        BMapManager.init();
        return new GeoCoder();
    }

    public void destroy() {
        if (this.f5495b) {
            return;
        }
        this.f5495b = true;
        this.f5494a.mo9907a();
        BMapManager.destroy();
    }

    public boolean geocode(GeoCodeOption geoCodeOption) {
        if (this.f5494a != null) {
            if (geoCodeOption == null || geoCodeOption.mAddress == null || geoCodeOption.mCity == null) {
                throw new IllegalArgumentException("option or address or city can not be null");
            }
            return this.f5494a.mo9906a(geoCodeOption);
        }
        throw new IllegalStateException("GeoCoder is null, please call newInstance() first.");
    }

    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (this.f5494a != null) {
            if (reverseGeoCodeOption == null || reverseGeoCodeOption.getLocation() == null) {
                throw new IllegalArgumentException("option or mLocation can not be null");
            }
            return this.f5494a.mo9904a(reverseGeoCodeOption);
        }
        throw new IllegalStateException("GeoCoder is null, please call newInstance() first.");
    }

    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        InterfaceC1337d interfaceC1337d = this.f5494a;
        if (interfaceC1337d == null) {
            throw new IllegalStateException("GeoCoder is null, please call newInstance() first.");
        }
        if (onGetGeoCoderResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        interfaceC1337d.mo9905a(onGetGeoCoderResultListener);
    }
}
