package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class InfoWindow {

    /* renamed from: a */
    BitmapDescriptor f5060a;

    /* renamed from: b */
    View f5061b;

    /* renamed from: c */
    LatLng f5062c;

    /* renamed from: d */
    OnInfoWindowClickListener f5063d;

    /* renamed from: e */
    int f5064e;

    /* loaded from: classes.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public InfoWindow(View view, LatLng latLng, int i) {
        if (view == null || latLng == null) {
            throw new IllegalArgumentException("view and position can not be null");
        }
        this.f5061b = view;
        this.f5062c = latLng;
        this.f5064e = i;
    }

    public InfoWindow(BitmapDescriptor bitmapDescriptor, LatLng latLng, int i, OnInfoWindowClickListener onInfoWindowClickListener) {
        if (bitmapDescriptor == null || latLng == null) {
            throw new IllegalArgumentException("bitmapDescriptor and position can not be null");
        }
        this.f5060a = bitmapDescriptor;
        this.f5062c = latLng;
        this.f5063d = onInfoWindowClickListener;
        this.f5064e = i;
    }
}
