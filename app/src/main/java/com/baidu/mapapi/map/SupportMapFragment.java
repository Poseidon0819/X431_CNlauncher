package com.baidu.mapapi.map;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p012v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class SupportMapFragment extends Fragment {

    /* renamed from: a */
    private static final String f5238a = "SupportMapFragment";

    /* renamed from: b */
    private MapView f5239b;

    /* renamed from: c */
    private BaiduMapOptions f5240c;

    public SupportMapFragment() {
    }

    private SupportMapFragment(BaiduMapOptions baiduMapOptions) {
        this.f5240c = baiduMapOptions;
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(BaiduMapOptions baiduMapOptions) {
        return new SupportMapFragment(baiduMapOptions);
    }

    public BaiduMap getBaiduMap() {
        MapView mapView = this.f5239b;
        if (mapView == null) {
            return null;
        }
        return mapView.getMap();
    }

    public MapView getMapView() {
        return this.f5239b;
    }

    @Override // android.support.p012v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.support.p012v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.p012v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.p012v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.p012v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5239b = new MapView(getActivity(), this.f5240c);
        return this.f5239b;
    }

    @Override // android.support.p012v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f5239b.onDestroy();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f5239b.onPause();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f5239b.onResume();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.p012v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // android.support.p012v4.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle == null) {
        }
    }
}
