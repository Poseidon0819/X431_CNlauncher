package com.cnlaunch.gmap.map.p150b;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.C3447j;
import com.google.android.gms.maps.GoogleMapOptions;

/* renamed from: com.cnlaunch.gmap.map.b.i */
/* loaded from: classes.dex */
public final class GoloSupportMapFragment extends C3447j {

    /* renamed from: a */
    InterfaceC1530a f7560a;

    /* renamed from: b */
    private GoogleMapOptions f7561b;

    /* compiled from: GoloSupportMapFragment.java */
    /* renamed from: com.cnlaunch.gmap.map.b.i$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1530a {
        /* renamed from: a */
        void mo9300a();
    }

    public GoloSupportMapFragment() {
    }

    public GoloSupportMapFragment(GoogleMapOptions googleMapOptions) {
        this.f7561b = googleMapOptions;
    }

    @Override // com.google.android.gms.maps.C3447j, android.support.p012v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.google.android.gms.maps.C3447j, android.support.p012v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.google.android.gms.maps.C3447j, android.support.p012v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.google.android.gms.maps.C3447j, android.support.p012v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.google.android.gms.maps.C3447j, android.support.p012v4.app.Fragment
    public final void onPause() {
        super.onPause();
    }

    @Override // com.google.android.gms.maps.C3447j, android.support.p012v4.app.Fragment
    public final void onResume() {
        super.onResume();
        InterfaceC1530a interfaceC1530a = this.f7560a;
        if (interfaceC1530a != null) {
            interfaceC1530a.mo9300a();
        }
    }
}
