package com.baidu.mapapi.map;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p012v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class TextureSupportMapFragment extends Fragment {

    /* renamed from: a */
    private static final String f5321a = "TextureSupportMapFragment";

    /* renamed from: b */
    private TextureMapView f5322b;

    /* renamed from: c */
    private BaiduMapOptions f5323c;

    public TextureSupportMapFragment() {
    }

    private TextureSupportMapFragment(BaiduMapOptions baiduMapOptions) {
        this.f5323c = baiduMapOptions;
    }

    public static TextureSupportMapFragment newInstance() {
        return new TextureSupportMapFragment();
    }

    public static TextureSupportMapFragment newInstance(BaiduMapOptions baiduMapOptions) {
        return new TextureSupportMapFragment(baiduMapOptions);
    }

    public BaiduMap getBaiduMap() {
        TextureMapView textureMapView = this.f5322b;
        if (textureMapView == null) {
            return null;
        }
        return textureMapView.getMap();
    }

    public TextureMapView getMapView() {
        return this.f5322b;
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
        this.f5322b = new TextureMapView(getActivity(), this.f5323c);
        return this.f5322b;
    }

    @Override // android.support.p012v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f5322b.onDestroy();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f5322b.onPause();
    }

    @Override // android.support.p012v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f5322b.onResume();
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
