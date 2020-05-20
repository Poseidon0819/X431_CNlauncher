package com.cnlaunch.gmap.map.logic.control;

import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.p012v4.app.AbstractC0094s;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p147b.SuggestionSearch;
import com.cnlaunch.gmap.map.p150b.MapListener;
import com.cnlaunch.gmap.map.p150b.MapLocation;
import com.cnlaunch.gmap.map.p150b.MapManager;
import com.cnlaunch.gmap.map.p151c.C1535b;
import com.cnlaunch.gmap.map.p152d.NormalDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.gmap.map.logic.control.g */
/* loaded from: classes.dex */
public abstract class GoloMapBaseActivity extends BasicActivity implements View.OnClickListener {

    /* renamed from: o */
    private static String f7643o = "GoloMapBaseActivity";

    /* renamed from: F */
    public int f7645F;

    /* renamed from: I */
    protected InterfaceC1547a f7648I;

    /* renamed from: K */
    protected MapLocation f7650K;

    /* renamed from: L */
    private AbstractC0094s f7651L;

    /* renamed from: M */
    private FrameLayout f7652M;

    /* renamed from: N */
    private View f7653N;

    /* renamed from: P */
    private MapListener f7655P;

    /* renamed from: R */
    private NormalDialog f7657R;

    /* renamed from: S */
    private boolean f7658S;

    /* renamed from: n */
    private String f7659n = null;

    /* renamed from: p */
    private boolean f7660p = false;

    /* renamed from: E */
    public MapManager f7644E = null;

    /* renamed from: O */
    private PowerManager.WakeLock f7654O = null;

    /* renamed from: G */
    protected boolean f7646G = false;

    /* renamed from: H */
    protected boolean f7647H = true;

    /* renamed from: J */
    protected int f7649J = R.drawable.gmap_myposition;

    /* renamed from: Q */
    private boolean f7656Q = false;

    /* compiled from: GoloMapBaseActivity.java */
    /* renamed from: com.cnlaunch.gmap.map.logic.control.g$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1547a {
        /* renamed from: a */
        void mo9260a(boolean z, LocationResult locationResult);

        /* renamed from: b */
        void mo9259b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ boolean m9266b(GoloMapBaseActivity goloMapBaseActivity) {
        goloMapBaseActivity.f7660p = false;
        return false;
    }

    @Override // com.cnlaunch.gmap.map.logic.control.BasicActivity, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7655P = new MapListener();
        this.f7650K = new MapLocation();
        this.f7655P.f7574b = new C1548h(this);
        this.f7655P.f7575c = new C1549i(this);
        this.f7650K.f7566e = new C1550j(this);
    }

    /* renamed from: d */
    public final void m9263d() {
        if (this.f7647H) {
            MapLocation mapLocation = this.f7650K;
            mapLocation.f7564c = this;
            mapLocation.f7565d = false;
            mapLocation.m9299a();
            this.f7646G = true;
        }
    }

    /* renamed from: a */
    public final void m9268a(String str) {
        m9272a(str, new int[0]);
        m9267b();
        this.f7659n = null;
    }

    /* renamed from: b */
    public final void m9265b(String str, int... iArr) {
        m9272a(str, iArr);
        m9267b();
        this.f7659n = null;
    }

    /* renamed from: e */
    public final void m9261e() {
        m9271c();
        m9267b();
    }

    /* renamed from: b */
    private void m9267b() {
        this.f7645F = getResources().getConfiguration().orientation;
        this.f7651L = m15082d_();
        this.f7644E = new MapManager(this);
        MapManager mapManager = this.f7644E;
        mapManager.f7544l = this.f7655P;
        mapManager.m9291b(this.f7651L);
        this.f7652M = (FrameLayout) findViewById(R.id.subcontent);
        this.f7653N = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.gmap_map_location_layout, (ViewGroup) null);
        this.f7652M.addView(this.f7653N);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        MapLocation mapLocation;
        super.onStop();
        if (this.f7647H && this.f7646G && (mapLocation = this.f7650K) != null) {
            mapLocation.m9295c();
        }
        MapManager mapManager = this.f7644E;
        if (mapManager != null) {
            if (mapManager.f7537d != null) {
                mapManager.f7537d.onStop();
            }
            mapManager.f7542j = 4;
        }
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MapManager mapManager = this.f7644E;
        if (mapManager == null || mapManager.f7537d == null) {
            return;
        }
        mapManager.f7542j = 3;
        mapManager.f7537d.onPause();
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MapManager mapManager = this.f7644E;
        if (mapManager != null && mapManager.f7537d != null) {
            mapManager.f7537d.onResume();
            mapManager.m9319a();
            mapManager.f7542j = 1;
        }
        NormalDialog normalDialog = this.f7657R;
        if (normalDialog != null) {
            normalDialog.dismiss();
        }
    }

    @Override // com.cnlaunch.gmap.map.logic.control.BasicActivity, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        MapLocation mapLocation;
        if (this.f7647H && this.f7646G && (mapLocation = this.f7650K) != null) {
            mapLocation.m9295c();
            this.f7650K = null;
        }
        MapManager mapManager = this.f7644E;
        if (mapManager != null) {
            mapManager.f7536c = null;
            if (mapManager.f7545m != null) {
                SuggestionSearch suggestionSearch = mapManager.f7545m;
                suggestionSearch.f7500c = null;
                suggestionSearch.f7502e = null;
                suggestionSearch.f7503f = null;
                SuggestionSearch.f7498a = null;
                suggestionSearch.f7501d = null;
            }
            this.f7644E = null;
        }
        super.onDestroy();
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override // com.cnlaunch.gmap.map.logic.control.BasicActivity, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m9264c(GoloMapBaseActivity goloMapBaseActivity) {
        if (goloMapBaseActivity.f7658S || ((LocationManager) goloMapBaseActivity.getSystemService("location")).isProviderEnabled("gps")) {
            return;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) goloMapBaseActivity.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (goloMapBaseActivity.f7657R == null) {
                NormalDialog normalDialog = new NormalDialog(goloMapBaseActivity, null, goloMapBaseActivity.getString(R.string.open_gps_tips), goloMapBaseActivity.getString(R.string.cancel_img), goloMapBaseActivity.getString(R.string.immediately_open));
                normalDialog.f7615a = new C1535b(goloMapBaseActivity, normalDialog);
                goloMapBaseActivity.f7657R = normalDialog;
            }
            goloMapBaseActivity.f7657R.show();
            goloMapBaseActivity.f7658S = true;
        }
    }
}
