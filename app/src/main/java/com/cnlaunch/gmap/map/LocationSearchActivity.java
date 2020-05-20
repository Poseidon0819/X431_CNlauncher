package com.cnlaunch.gmap.map;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cnlaunch.gmap.map.logic.control.GoloMapBaseActivity;
import com.cnlaunch.gmap.map.logic.p153a.GoloMarkerClickListener;
import com.cnlaunch.gmap.map.logic.p153a.IPoiSearchCallBack;
import com.cnlaunch.gmap.map.logic.p153a.LcLatlng;
import com.cnlaunch.gmap.map.logic.p153a.LocationResult;
import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;
import com.cnlaunch.gmap.map.p145a.p147b.SuggestionSearch;
import com.cnlaunch.gmap.map.p150b.BaseMapManager;
import com.cnlaunch.gmap.map.p150b.BaseMapTools;
import com.cnlaunch.gmap.map.p150b.MapManager;
import com.cnlaunch.gmap.map.p150b.MarkerOption;
import com.cnlaunch.gmap.map.p150b.PoiSearchInfo;
import com.cnlaunch.gmap.map.p150b.PoiSearchResult;
import com.cnlaunch.gmap.map.p151c.LanguageUtils;
import com.cnlaunch.gmap.map.p151c.StringUtils;
import com.cnlaunch.gmap.map.p152d.MapSearchResultPop;
import com.cnlaunch.gmap.p138a.p143e.PropertyListener;
import com.google.android.gms.maps.BinderC3443f;
import com.google.android.gms.maps.C3435b;
import com.google.android.gms.maps.C3436c;
import com.google.android.gms.maps.model.C3452a;
import com.google.android.gms.maps.model.C3487l;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ifoer.expedition.pro.R;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LocationSearchActivity extends GoloMapBaseActivity implements MapSearchResultPop.InterfaceC1536a, GoloMarkerClickListener, IPoiSearchCallBack, IPoiSearchCallBack.InterfaceC1541a, GoloMapBaseActivity.InterfaceC1547a {

    /* renamed from: L */
    private ImageButton f7458L;

    /* renamed from: M */
    private ImageButton f7459M;

    /* renamed from: N */
    private ImageButton f7460N;

    /* renamed from: O */
    private Intent f7461O;

    /* renamed from: P */
    private LcLatlng f7462P;

    /* renamed from: Q */
    private LocationResult f7463Q;

    /* renamed from: R */
    private TextView f7464R;

    /* renamed from: S */
    private View f7465S;

    /* renamed from: T */
    private String f7466T;

    /* renamed from: U */
    private EditText f7467U;

    /* renamed from: V */
    private ImageView f7468V;

    /* renamed from: W */
    private String f7469W;

    /* renamed from: X */
    private View f7470X;

    /* renamed from: aa */
    private String f7473aa;

    /* renamed from: n */
    public int f7475n;

    /* renamed from: o */
    MapSearchResultPop f7476o;

    /* renamed from: Y */
    private boolean f7471Y = false;

    /* renamed from: Z */
    private boolean f7472Z = false;

    /* renamed from: ab */
    private boolean f7474ab = true;

    /* renamed from: p */
    PropertyListener f7477p = new C1534c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ boolean m9340b(LocationSearchActivity locationSearchActivity) {
        locationSearchActivity.f7474ab = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ boolean m9337d(LocationSearchActivity locationSearchActivity) {
        locationSearchActivity.f7471Y = false;
        return false;
    }

    @Override // com.cnlaunch.gmap.map.logic.control.GoloMapBaseActivity, com.cnlaunch.gmap.map.logic.control.BasicActivity, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7461O = getIntent();
        this.f7466T = this.f7461O.getStringExtra(VastExtensionXmlManager.TYPE);
        if (this.f7461O.hasExtra("point")) {
            this.f7462P = (LcLatlng) this.f7461O.getSerializableExtra("point");
        }
        if (this.f7461O.hasExtra("image")) {
            this.f7475n = this.f7461O.getIntExtra("image", 0);
        }
        if (this.f7466T.equals("1")) {
            m9268a(getString(R.string.position));
        } else if (this.f7466T.equals("2")) {
            m9265b(getString(R.string.get_position_title), R.drawable.gmap_titlebar_sure_icon);
        } else {
            m9261e();
            findViewById(R.id.title_layout).setVisibility(0);
            findViewById(R.id.title_left_layout).setOnClickListener(this);
            findViewById(R.id.add_confirm).setOnClickListener(this);
            this.f7467U = (EditText) findViewById(R.id.search_input);
            this.f7468V = (ImageView) findViewById(R.id.search_clear);
            this.f7470X = findViewById(R.id.search_layout);
            this.f7468V.setOnClickListener(this);
            this.f7467U.addTextChangedListener(new C1512a(this));
        }
        this.f7465S = findViewById(R.id.map_set);
        this.f7458L = (ImageButton) findViewById(R.id.pos);
        this.f7459M = (ImageButton) findViewById(R.id.big);
        this.f7460N = (ImageButton) findViewById(R.id.small);
        this.f7464R = (TextView) findViewById(R.id.address);
        if (this.f7466T.equals("1")) {
            this.f7465S.setVisibility(8);
            this.f7464R.setVisibility(8);
        }
        this.f7458L.setOnClickListener(this);
        this.f7459M.setOnClickListener(this);
        this.f7460N.setOnClickListener(this);
        this.f7647H = true;
        if (this.f7647H) {
            this.f7648I = this;
        }
    }

    @Override // com.cnlaunch.gmap.map.logic.control.GoloMapBaseActivity.InterfaceC1547a
    /* renamed from: a */
    public final void mo9260a(boolean z, LocationResult locationResult) {
        if (z) {
            this.f7463Q = locationResult;
            this.f7469W = this.f7463Q.getCityName();
            LocationSearch.m9324a().m9322a(this, locationResult.getLclatlng(), LanguageUtils.m9283b(), new C1523b(this));
            locationResult.setIsMove(true);
            if (this.f7644E != null && locationResult != null) {
                int i = -1;
                if (this.f7649J != -1) {
                    MapManager mapManager = this.f7644E;
                    int i2 = this.f7649J;
                    if (locationResult != null) {
                        mapManager.m9308a(BaseMapManager.f7529p);
                        double d = locationResult.getLclatlng().latitude;
                        double d2 = locationResult.getLclatlng().longitude;
                        if (mapManager.f7538e != null && mapManager.f7542j < 3) {
                            MarkerOption markerOption = new MarkerOption();
                            markerOption.f7584e = 0.5f;
                            markerOption.f7585f = 0.5f;
                            markerOption.f7582c = i2;
                            LcLatlng lcLatlng = new LcLatlng(d, d2);
                            lcLatlng.setDescription(BaseMapManager.f7529p);
                            markerOption.f7581b = lcLatlng;
                            markerOption.f7580a = false;
                            if (markerOption.f7581b != null) {
                                LatLng m9304a = BaseMapTools.m9304a(markerOption.f7580a, markerOption.f7581b);
                                MarkerOptions markerOptions = null;
                                if (markerOption.f7583d != null) {
                                    C3452a m9315a = BaseMapManager.m9315a(markerOption.f7583d);
                                    if (m9315a != null) {
                                        MarkerOptions markerOptions2 = new MarkerOptions();
                                        markerOptions2.f19318c = m9304a;
                                        markerOptions2.f19321f = m9315a;
                                        markerOptions = markerOptions2.m2940a(markerOption.f7584e, markerOption.f7585f);
                                        markerOptions.f19327l = markerOption.f7586g;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(markerOption.f7587h);
                                        markerOptions.f19320e = sb.toString();
                                        markerOptions.f19319d = markerOption.f7588i;
                                    }
                                } else {
                                    C3452a m9317a = mapManager.m9317a(markerOption.f7582c);
                                    if (m9317a != null) {
                                        MarkerOptions markerOptions3 = new MarkerOptions();
                                        markerOptions3.f19318c = m9304a;
                                        markerOptions3.f19321f = m9317a;
                                        markerOptions3.f19327l = markerOption.f7586g;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(markerOption.f7587h);
                                        markerOptions3.f19320e = sb2.toString();
                                        markerOptions3.f19319d = markerOption.f7588i;
                                        markerOptions = markerOptions3.m2940a(markerOption.f7584e, markerOption.f7585f);
                                    }
                                }
                                if (mapManager.f7538e != null && mapManager.f7542j < 3) {
                                    i = mapManager.m9309a(markerOptions, markerOption.f7581b);
                                }
                            }
                            mapManager.f7547o = i;
                            if (locationResult.isMove()) {
                                LatLng m9304a2 = BaseMapTools.m9304a(false, locationResult.getLclatlng());
                                if (mapManager.f7538e != null && mapManager.f7542j < 3) {
                                    mapManager.f7538e.m2974a(C3435b.m2976a(m9304a2, 17.0f));
                                }
                            }
                        }
                    }
                }
            }
            if (this.f7647H && this.f7646G) {
                this.f7650K.m9297b();
            }
        }
    }

    @Override // com.cnlaunch.gmap.map.logic.control.GoloMapBaseActivity.InterfaceC1547a
    /* renamed from: b */
    public final void mo9259b() {
        if (!this.f7466T.equals("1")) {
            m9263d();
        }
        if (this.f7466T.equals("3")) {
            MapManager mapManager = this.f7644E;
            if (mapManager.f7538e != null) {
                C3436c c3436c = mapManager.f7538e;
                try {
                    c3436c.f19258a.mo3085a(new BinderC3443f(c3436c, mapManager));
                } catch (RemoteException e) {
                    throw new C3487l(e);
                }
            }
            this.f7644E.m9352a(this.f7477p);
            this.f7644E.f7543k = this;
            MapManager mapManager2 = this.f7644E;
            if (SuggestionSearch.f7498a == null) {
                SuggestionSearch.f7498a = new SuggestionSearch();
            }
            mapManager2.f7545m = SuggestionSearch.f7498a;
            mapManager2.f7545m.f7499b = mapManager2;
            mapManager2.f7546n = this;
        } else if (!this.f7466T.equals("1") || this.f7462P == null) {
        } else {
            if (this.f7475n == 0) {
                this.f7475n = R.drawable.myposition;
            }
            this.f7644E.m9310a(this.f7462P, this.f7475n);
            this.f7644E.m9311a(this.f7462P);
        }
    }

    @Override // com.cnlaunch.gmap.map.logic.control.BasicActivity
    /* renamed from: c */
    public final void mo9270c(int i) {
        super.mo9270c(i);
        if (this.f7463Q != null) {
            Intent intent = new Intent();
            intent.putExtra("result", this.f7463Q);
            setResult(-1, intent);
            finish();
            return;
        }
        Toast.makeText(this, (int) R.string.locating, 0).show();
    }

    @Override // com.cnlaunch.gmap.map.logic.control.BasicActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_confirm /* 2131296300 */:
                if (this.f7463Q != null) {
                    Intent intent = new Intent();
                    intent.putExtra("result", this.f7463Q);
                    setResult(-1, intent);
                    finish();
                    return;
                }
                Toast.makeText(this, (int) R.string.locating, 0).show();
                return;
            case R.id.big /* 2131296335 */:
                MapManager mapManager = this.f7644E;
                if (mapManager.f7538e != null) {
                    CameraPosition m2975a = mapManager.f7538e.m2975a();
                    if (m2975a.f19279d <= mapManager.f7538e.m2972b()) {
                        float f = m2975a.f19279d;
                        if (f < mapManager.f7540g) {
                            float f2 = f + 1.0f;
                            mapManager.m9318a(f2);
                            mapManager.f7541h = f2;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case R.id.pos /* 2131297620 */:
                m9263d();
                return;
            case R.id.search_clear /* 2131297813 */:
                this.f7467U.setText("");
                this.f7471Y = false;
                this.f7472Z = false;
                this.f7473aa = null;
                return;
            case R.id.small /* 2131297878 */:
                MapManager mapManager2 = this.f7644E;
                if (mapManager2.f7538e != null) {
                    CameraPosition m2975a2 = mapManager2.f7538e.m2975a();
                    if (m2975a2.f19279d >= mapManager2.f7538e.m2970c()) {
                        float f3 = m2975a2.f19279d;
                        if (f3 > mapManager2.f7539f) {
                            float f4 = f3 - 1.0f;
                            mapManager2.m9318a(f4);
                            mapManager2.f7541h = f4;
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case R.id.title_left_layout /* 2131297988 */:
                finish();
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.gmap.map.logic.control.GoloMapBaseActivity, com.cnlaunch.gmap.map.logic.control.BasicActivity, android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ArrayList<PropertyListener> m9353a = this.f7644E.f7451a.m9353a(21);
        if ((m9353a != null ? m9353a.size() : 0) > 0) {
            this.f7644E.m9349b(this.f7477p);
        }
        super.onDestroy();
    }

    @Override // com.cnlaunch.gmap.map.logic.p153a.IPoiSearchCallBack.InterfaceC1541a
    /* renamed from: a */
    public final void mo9273a(PoiSearchResult poiSearchResult) {
        if (isFinishing() || poiSearchResult == null) {
            return;
        }
        if (this.f7476o == null) {
            this.f7476o = new MapSearchResultPop(this.f7470X, this, this);
        }
        MapSearchResultPop mapSearchResultPop = this.f7476o;
        mapSearchResultPop.f7601a.showAsDropDown(mapSearchResultPop.f7604d, 0, 0);
        MapSearchResultPop mapSearchResultPop2 = this.f7476o;
        if (poiSearchResult != null && poiSearchResult.f7594a.size() > 0) {
            List<PoiSearchInfo> list = poiSearchResult.f7594a;
            MapSearchResultPop.C1537b c1537b = mapSearchResultPop2.f7602b;
            c1537b.f7609a.clear();
            c1537b.f7609a.addAll(list);
            c1537b.notifyDataSetChanged();
        }
        this.f7476o.f7603c = 1;
    }

    @Override // com.cnlaunch.gmap.map.p152d.MapSearchResultPop.InterfaceC1536a
    /* renamed from: a */
    public final void mo9276a(PoiSearchInfo poiSearchInfo, int i) {
        switch (i) {
            case 0:
                this.f7471Y = true;
                this.f7469W = poiSearchInfo.f7590b;
                this.f7467U.setText(poiSearchInfo.f7589a);
                return;
            case 1:
                this.f7474ab = false;
                this.f7463Q = null;
                this.f7472Z = true;
                LocationResult locationResult = new LocationResult();
                locationResult.setAddress(poiSearchInfo.f7589a);
                LcLatlng lcLatlng = new LcLatlng(poiSearchInfo.f7591c, poiSearchInfo.f7592d);
                locationResult.setLclatlng(lcLatlng);
                if (StringUtils.m9282a(poiSearchInfo.f7589a)) {
                    this.f7467U.setText(poiSearchInfo.f7593e);
                    this.f7464R.setText(poiSearchInfo.f7593e);
                    this.f7644E.m9306b(lcLatlng);
                    return;
                }
                this.f7463Q = locationResult;
                this.f7467U.setText(poiSearchInfo.f7589a);
                this.f7464R.setText(poiSearchInfo.f7589a);
                this.f7644E.m9307b();
                this.f7644E.m9310a(lcLatlng, R.drawable.gmap_share_city_select);
                this.f7644E.m9311a(lcLatlng);
                return;
            default:
                return;
        }
    }
}
