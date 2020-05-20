package com.cnlaunch.gmap.map.p150b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.support.p012v4.app.AbstractC0094s;
import android.support.p012v4.app.FragmentTransaction;
import android.view.View;
import com.cnlaunch.gmap.map.logic.p153a.GoloMarkerClickListener;
import com.cnlaunch.gmap.map.logic.p153a.IPoiSearchCallBack;
import com.cnlaunch.gmap.map.logic.p153a.LcLatlng;
import com.cnlaunch.gmap.map.p145a.p146a.LocationSearch;
import com.cnlaunch.gmap.map.p145a.p147b.SuggestionSearch;
import com.cnlaunch.gmap.map.p145a.p147b.p149b.SuggestionInfo;
import com.cnlaunch.gmap.map.p145a.p147b.p149b.SuggestionResult;
import com.cnlaunch.gmap.map.p151c.StringUtils;
import com.cnlaunch.gmap.p138a.p143e.PropertyObservable;
import com.google.android.gms.maps.C3435b;
import com.google.android.gms.maps.C3436c;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.C3452a;
import com.google.android.gms.maps.model.C3477b;
import com.google.android.gms.maps.model.C3483h;
import com.google.android.gms.maps.model.C3487l;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.cnlaunch.gmap.map.b.b */
/* loaded from: classes.dex */
public class BaseMapManager extends PropertyObservable implements SuggestionSearch.InterfaceC1518a, C3436c.InterfaceC3438b, C3436c.InterfaceC3440d {

    /* renamed from: i */
    public static int f7528i = 10000;

    /* renamed from: v */
    private static List<BaseMarker> f7533v;

    /* renamed from: b */
    public Context f7535b;

    /* renamed from: k */
    public IPoiSearchCallBack f7543k;

    /* renamed from: l */
    public MapListener f7544l;

    /* renamed from: m */
    public SuggestionSearch f7545m;

    /* renamed from: n */
    public IPoiSearchCallBack.InterfaceC1541a f7546n;

    /* renamed from: w */
    private AbstractC0094s f7550w;

    /* renamed from: x */
    private FragmentTransaction f7551x;

    /* renamed from: y */
    private GoloMarkerClickListener f7552y;

    /* renamed from: A */
    private static String[] f7527A = {"/storage/sdcard1", "/storage/extSdCard"};

    /* renamed from: p */
    public static String f7529p = "locationMarker";

    /* renamed from: q */
    public static String f7530q = "trackStartMarker";

    /* renamed from: r */
    public static String f7531r = "trackCarMarker";

    /* renamed from: s */
    public static String f7532s = "endPoint";

    /* renamed from: t */
    private String f7548t = "BaseMapManager";

    /* renamed from: u */
    private boolean f7549u = false;

    /* renamed from: c */
    public List<C3452a> f7536c = null;

    /* renamed from: d */
    public GoloSupportMapFragment f7537d = null;

    /* renamed from: e */
    public C3436c f7538e = null;

    /* renamed from: f */
    public float f7539f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;

    /* renamed from: g */
    public float f7540g = 21.0f;

    /* renamed from: h */
    public float f7541h = 17.0f;

    /* renamed from: j */
    public int f7542j = 0;

    /* renamed from: z */
    private LcLatlng f7553z = null;

    /* renamed from: B */
    private boolean f7534B = false;

    /* renamed from: o */
    public int f7547o = -1;

    public BaseMapManager(Context context) {
        this.f7535b = context;
    }

    /* renamed from: a */
    public final void m9316a(AbstractC0094s abstractC0094s) {
        this.f7536c = new ArrayList();
        f7533v = new ArrayList();
        this.f7541h = 17.0f;
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        googleMapOptions.m3109b(false);
        googleMapOptions.m3110a(false);
        this.f7550w = abstractC0094s;
        this.f7537d = new GoloSupportMapFragment(googleMapOptions);
        this.f7551x = abstractC0094s.mo15058a();
        if (this.f7551x != null && !this.f7537d.isAdded()) {
            this.f7551x.mo15113a(R.id.bmapView, this.f7537d, "map_fragment").mo15096c();
        } else {
            this.f7551x.mo15100b(this.f7537d);
        }
        this.f7537d.f7560a = new C1524c(this);
        this.f7542j = 0;
    }

    /* renamed from: a */
    public final C3436c m9319a() {
        GoloSupportMapFragment goloSupportMapFragment = this.f7537d;
        if (goloSupportMapFragment != null) {
            if (this.f7538e == null) {
                this.f7538e = goloSupportMapFragment.m2957a();
            }
            return this.f7538e;
        }
        return null;
    }

    /* renamed from: a */
    public final void m9318a(float f) {
        if (this.f7538e != null) {
            if (f == -1.0f) {
                f = 17.0f;
            }
            this.f7538e.m2971b(C3435b.m2977a(f));
        }
    }

    /* renamed from: b */
    public final synchronized void m9307b() {
        this.f7534B = true;
        if (f7533v != null && f7533v.size() > 0) {
            for (int i = 0; i < f7533v.size(); i++) {
                C3483h c3483h = f7533v.get(i).f7557a;
                if (c3483h != null) {
                    c3483h.m2798a();
                }
            }
            Iterator<BaseMarker> it = f7533v.iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
        if (this.f7536c != null && this.f7536c.size() > 0) {
            Iterator<C3452a> it2 = this.f7536c.iterator();
            while (it2.hasNext()) {
                if (it2.next() != null && this.f7536c != null) {
                    this.f7536c.size();
                }
                it2.remove();
            }
            this.f7536c.clear();
        }
        if (this.f7542j < 3 && this.f7538e != null) {
            try {
                this.f7538e.f19258a.mo3063e();
            } catch (RemoteException e) {
                throw new C3487l(e);
            }
        }
        this.f7534B = false;
    }

    /* renamed from: a */
    public final void m9311a(LcLatlng lcLatlng) {
        LatLng m9304a = BaseMapTools.m9304a(false, lcLatlng);
        if (this.f7538e == null || this.f7542j >= 3) {
            return;
        }
        this.f7538e.m2974a(C3435b.m2976a(m9304a, this.f7541h));
    }

    /* renamed from: a */
    public final int m9310a(LcLatlng lcLatlng, int i) {
        LatLng m9304a = BaseMapTools.m9304a(false, lcLatlng);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.f19318c = m9304a;
        markerOptions.f19321f = m9317a(i);
        MarkerOptions m2940a = markerOptions.m2940a(0.5f, 1.0f);
        if (this.f7538e == null || this.f7542j >= 3) {
            return 0;
        }
        return m9309a(m2940a, lcLatlng);
    }

    /* renamed from: a */
    public final int m9309a(MarkerOptions markerOptions, LcLatlng lcLatlng) {
        C3436c c3436c = this.f7538e;
        if (c3436c == null || markerOptions == null || this.f7542j >= 3) {
            return -1;
        }
        C3483h m2973a = c3436c.m2973a(markerOptions);
        BaseMarker baseMarker = new BaseMarker();
        baseMarker.f7557a = m2973a;
        baseMarker.f7558b = lcLatlng;
        if (lcLatlng != null && !StringUtils.m9282a(lcLatlng.getDescription())) {
            baseMarker.f7559c = lcLatlng.getDescription();
        }
        List<BaseMarker> list = f7533v;
        if (list != null) {
            list.add(baseMarker);
            return f7533v.indexOf(baseMarker);
        }
        return -1;
    }

    /* renamed from: a */
    public final synchronized void m9308a(String... strArr) {
        int i;
        if (f7533v != null && f7533v.size() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(f7533v);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BaseMarker baseMarker = (BaseMarker) it.next();
                C3483h c3483h = baseMarker.f7557a;
                String str = baseMarker.f7559c;
                for (int i2 = 0; i2 <= 0; i2++) {
                    if (!StringUtils.m9282a(str) && c3483h != null && str.equals(strArr[0])) {
                        arrayList2.add(c3483h);
                        it.remove();
                        f7533v.remove(baseMarker);
                    }
                }
            }
            for (i = 0; i < arrayList2.size(); i++) {
                ((C3483h) arrayList2.get(i)).m2798a();
            }
            arrayList2.clear();
            arrayList.clear();
        }
    }

    /* renamed from: a */
    public final C3452a m9317a(int i) {
        C3452a c3452a;
        List<C3452a> list;
        try {
            c3452a = C3477b.m2810a(i);
        } catch (Exception e) {
            e.printStackTrace();
            c3452a = null;
        }
        if (c3452a != null && (list = this.f7536c) != null) {
            list.add(c3452a);
        }
        return c3452a;
    }

    /* renamed from: a */
    public static C3452a m9315a(View view) {
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        C3452a m2809a = !drawingCache.isRecycled() ? C3477b.m2809a(drawingCache) : null;
        if (drawingCache != null) {
            drawingCache.recycle();
        }
        view.setDrawingCacheEnabled(false);
        return m2809a;
    }

    @Override // com.google.android.gms.maps.C3436c.InterfaceC3438b
    /* renamed from: a */
    public final void mo2967a(LatLng latLng) {
        if (latLng != null) {
            m9306b(new LcLatlng(latLng.f19310c, latLng.f19311d));
        }
    }

    @Override // com.google.android.gms.maps.C3436c.InterfaceC3440d
    /* renamed from: a */
    public final boolean mo2965a(C3483h c3483h) {
        if (this.f7552y != null) {
            LatLng m2797b = c3483h.m2797b();
            new LcLatlng(m2797b.f19310c, m2797b.f19311d);
            try {
                Integer.parseInt(c3483h.m2795d());
                c3483h.m2796c();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
        return true;
    }

    /* renamed from: b */
    public final void m9306b(LcLatlng lcLatlng) {
        LocationSearch.m9324a().m9323a(this.f7535b, lcLatlng, new C1526e(this));
    }

    @Override // com.cnlaunch.gmap.map.p145a.p147b.SuggestionSearch.InterfaceC1518a
    /* renamed from: a */
    public final void mo9314a(SuggestionResult suggestionResult) {
        if (suggestionResult == null) {
            this.f7546n.mo9273a(null);
            return;
        }
        List<SuggestionInfo> list = suggestionResult.f7525a;
        if (list != null && list.size() > 0) {
            PoiSearchResult poiSearchResult = new PoiSearchResult();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                SuggestionInfo suggestionInfo = list.get(i);
                PoiSearchInfo poiSearchInfo = new PoiSearchInfo();
                poiSearchInfo.f7589a = suggestionInfo.f7520a;
                poiSearchInfo.f7590b = suggestionInfo.f7521b;
                poiSearchInfo.f7591c = suggestionInfo.f7522c;
                poiSearchInfo.f7592d = suggestionInfo.f7523d;
                arrayList.add(poiSearchInfo);
            }
            poiSearchResult.f7594a = arrayList;
            this.f7546n.mo9273a(poiSearchResult);
            return;
        }
        this.f7546n.mo9273a(null);
    }
}
