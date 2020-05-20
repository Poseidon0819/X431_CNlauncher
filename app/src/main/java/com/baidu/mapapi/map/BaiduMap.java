package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.C1210e;
import com.baidu.mapsdkplatform.comapi.map.C1236z;
import com.baidu.mapsdkplatform.comapi.map.EnumC1214h;
import com.baidu.mapsdkplatform.comapi.map.EnumC1235y;
import com.baidu.mapsdkplatform.comapi.map.GestureDetector$OnDoubleTapListenerC1196A;
import com.baidu.mapsdkplatform.comapi.map.GestureDetector$OnDoubleTapListenerC1216j;
import com.baidu.mapsdkplatform.comapi.map.InterfaceC1202F;
import com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k;
import com.baidu.mapsdkplatform.comapi.map.InterfaceC1223n;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.nativeads.MoPubNativeAdPositioning;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.opengles.GL10;
import org.jivesoftware.smackx.GroupChatInvitation;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BaiduMap {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;

    /* renamed from: e */
    private static final String f4920e = "BaiduMap";
    public static int mapStatusReason;

    /* renamed from: A */
    private OnMapDrawFrameCallback f4921A;

    /* renamed from: B */
    private OnBaseIndoorMapListener f4922B;

    /* renamed from: C */
    private OnSynchronizationListener f4923C;

    /* renamed from: D */
    private TileOverlay f4924D;

    /* renamed from: E */
    private HeatMap f4925E;

    /* renamed from: F */
    private Lock f4926F;

    /* renamed from: G */
    private Lock f4927G;

    /* renamed from: H */
    private InfoWindow f4928H;

    /* renamed from: I */
    private Marker f4929I;

    /* renamed from: J */
    private View f4930J;

    /* renamed from: K */
    private Marker f4931K;

    /* renamed from: L */
    private MyLocationData f4932L;

    /* renamed from: M */
    private MyLocationConfiguration f4933M;

    /* renamed from: N */
    private boolean f4934N;

    /* renamed from: O */
    private boolean f4935O;

    /* renamed from: P */
    private boolean f4936P;

    /* renamed from: Q */
    private boolean f4937Q;

    /* renamed from: R */
    private Point f4938R;

    /* renamed from: a */
    MapView f4939a;

    /* renamed from: b */
    TextureMapView f4940b;

    /* renamed from: c */
    WearMapView f4941c;

    /* renamed from: d */
    EnumC1235y f4942d;

    /* renamed from: f */
    private Projection f4943f;

    /* renamed from: g */
    private UiSettings f4944g;

    /* renamed from: h */
    private GestureDetector$OnDoubleTapListenerC1216j f4945h;

    /* renamed from: i */
    private C1210e f4946i;

    /* renamed from: j */
    private GestureDetector$OnDoubleTapListenerC1196A f4947j;

    /* renamed from: k */
    private List<Overlay> f4948k;

    /* renamed from: l */
    private List<Marker> f4949l;

    /* renamed from: m */
    private List<Marker> f4950m;

    /* renamed from: n */
    private Overlay.InterfaceC1076a f4951n;

    /* renamed from: o */
    private OnMapStatusChangeListener f4952o;

    /* renamed from: p */
    private OnMapTouchListener f4953p;

    /* renamed from: q */
    private OnMapClickListener f4954q;

    /* renamed from: r */
    private OnMapLoadedCallback f4955r;

    /* renamed from: s */
    private OnMapRenderCallback f4956s;

    /* renamed from: t */
    private OnMapDoubleClickListener f4957t;

    /* renamed from: u */
    private OnMapLongClickListener f4958u;

    /* renamed from: v */
    private CopyOnWriteArrayList<OnMarkerClickListener> f4959v;

    /* renamed from: w */
    private CopyOnWriteArrayList<OnPolylineClickListener> f4960w;

    /* renamed from: x */
    private OnMarkerDragListener f4961x;

    /* renamed from: y */
    private OnMyLocationClickListener f4962y;

    /* renamed from: z */
    private SnapshotReadyCallback f4963z;

    /* loaded from: classes.dex */
    public interface OnBaseIndoorMapListener {
        void onBaseIndoorMapMode(boolean z, MapBaseIndoorMapInfo mapBaseIndoorMapInfo);
    }

    /* loaded from: classes.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);

        boolean onMapPoiClick(MapPoi mapPoi);
    }

    /* loaded from: classes.dex */
    public interface OnMapDoubleClickListener {
        void onMapDoubleClick(LatLng latLng);
    }

    /* loaded from: classes.dex */
    public interface OnMapDrawFrameCallback {
        void onMapDrawFrame(MapStatus mapStatus);

        @Deprecated
        void onMapDrawFrame(GL10 gl10, MapStatus mapStatus);
    }

    /* loaded from: classes.dex */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* loaded from: classes.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* loaded from: classes.dex */
    public interface OnMapRenderCallback {
        void onMapRenderFinished();
    }

    /* loaded from: classes.dex */
    public interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onMapStatusChange(MapStatus mapStatus);

        void onMapStatusChangeFinish(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus);

        void onMapStatusChangeStart(MapStatus mapStatus, int i);
    }

    /* loaded from: classes.dex */
    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* loaded from: classes.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* loaded from: classes.dex */
    public interface OnMyLocationClickListener {
        boolean onMyLocationClick();
    }

    /* loaded from: classes.dex */
    public interface OnPolylineClickListener {
        boolean onPolylineClick(Polyline polyline);
    }

    /* loaded from: classes.dex */
    public interface OnSynchronizationListener {
        void onMapStatusChangeReason(int i);
    }

    /* loaded from: classes.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaiduMap(GestureDetector$OnDoubleTapListenerC1196A gestureDetector$OnDoubleTapListenerC1196A) {
        this.f4959v = new CopyOnWriteArrayList<>();
        this.f4960w = new CopyOnWriteArrayList<>();
        this.f4926F = new ReentrantLock();
        this.f4927G = new ReentrantLock();
        this.f4947j = gestureDetector$OnDoubleTapListenerC1196A;
        this.f4946i = this.f4947j.m10783b();
        this.f4942d = EnumC1235y.TextureView;
        m11247c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaiduMap(GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j) {
        this.f4959v = new CopyOnWriteArrayList<>();
        this.f4960w = new CopyOnWriteArrayList<>();
        this.f4926F = new ReentrantLock();
        this.f4927G = new ReentrantLock();
        this.f4945h = gestureDetector$OnDoubleTapListenerC1216j;
        this.f4946i = this.f4945h.m10642a();
        this.f4942d = EnumC1235y.GLSurfaceView;
        m11247c();
    }

    /* renamed from: a */
    private Point m11250a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        for (String str2 : str.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",")) {
            String[] split = str2.replaceAll("\"", "").split(":");
            if (GroupChatInvitation.ELEMENT_NAME.equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
            }
            if ("y".equals(split[0])) {
                i2 = Integer.valueOf(split[1]).intValue();
            }
        }
        return new Point(i, i2);
    }

    /* renamed from: a */
    private C1236z m11253a(MapStatusUpdate mapStatusUpdate) {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return null;
        }
        C1236z m10753E = c1210e.m10753E();
        MapStatus m11173a = mapStatusUpdate.m11173a(this.f4946i, getMapStatus());
        if (m11173a == null) {
            return null;
        }
        return m11173a.m11180b(m10753E);
    }

    /* renamed from: a */
    private final void m11252a(MyLocationData myLocationData, MyLocationConfiguration myLocationConfiguration) {
        Bundle bundle;
        float f;
        if (myLocationData == null || myLocationConfiguration == null || !isMyLocationEnabled()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        LatLng latLng = new LatLng(myLocationData.latitude, myLocationData.longitude);
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        try {
            jSONObject.put(VastExtensionXmlManager.TYPE, 0);
            jSONObject2.put("ptx", ll2mc.getLongitudeE6());
            jSONObject2.put("pty", ll2mc.getLatitudeE6());
            jSONObject2.put("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(latLng, (int) myLocationData.accuracy));
            if (myLocationConfiguration.enableDirection) {
                f = myLocationData.direction % 360.0f;
                if (f > 180.0f) {
                    f -= 360.0f;
                } else if (f < -180.0f) {
                    f += 360.0f;
                }
            } else {
                f = -1.0f;
            }
            jSONObject2.put("direction", f);
            jSONObject2.put("iconarrownor", "NormalLocArrow");
            jSONObject2.put("iconarrownorid", 28);
            jSONObject2.put("iconarrowfoc", "FocusLocArrow");
            jSONObject2.put("iconarrowfocid", 29);
            jSONObject2.put("lineid", myLocationConfiguration.accuracyCircleStrokeColor);
            jSONObject2.put("areaid", myLocationConfiguration.accuracyCircleFillColor);
            jSONArray.put(jSONObject2);
            jSONObject.put(DataPacketExtension.ELEMENT_NAME, jSONArray);
            if (myLocationConfiguration.locationMode == MyLocationConfiguration.LocationMode.COMPASS) {
                jSONObject3.put("ptx", ll2mc.getLongitudeE6());
                jSONObject3.put("pty", ll2mc.getLatitudeE6());
                jSONObject3.put("radius", 0);
                jSONObject3.put("direction", 0);
                jSONObject3.put("iconarrownor", "direction_wheel");
                jSONObject3.put("iconarrownorid", 54);
                jSONObject3.put("iconarrowfoc", "direction_wheel");
                jSONObject3.put("iconarrowfocid", 54);
                jSONArray.put(jSONObject3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (myLocationConfiguration.customMarker == null) {
            bundle = null;
        } else {
            ArrayList<BitmapDescriptor> arrayList = new ArrayList();
            arrayList.add(myLocationConfiguration.customMarker);
            Bundle bundle2 = new Bundle();
            ArrayList arrayList2 = new ArrayList();
            for (BitmapDescriptor bitmapDescriptor : arrayList) {
                ParcelItem parcelItem = new ParcelItem();
                Bundle bundle3 = new Bundle();
                Bitmap bitmap = bitmapDescriptor.f4982a;
                ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
                bitmap.copyPixelsToBuffer(allocate);
                bundle3.putByteArray("imgdata", allocate.array());
                bundle3.putInt("imgindex", bitmapDescriptor.hashCode());
                bundle3.putInt("imgH", bitmap.getHeight());
                bundle3.putInt("imgW", bitmap.getWidth());
                parcelItem.setBundle(bundle3);
                arrayList2.add(parcelItem);
            }
            if (arrayList2.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList2.size()];
                for (int i = 0; i < arrayList2.size(); i++) {
                    parcelItemArr[i] = (ParcelItem) arrayList2.get(i);
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            bundle = bundle2;
        }
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            c1210e.m10715a(jSONObject.toString(), bundle);
        }
        switch (myLocationConfiguration.locationMode) {
            case COMPASS:
                animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().rotate(myLocationData.direction).overlook(-45.0f).target(new LatLng(myLocationData.latitude, myLocationData.longitude)).targetScreen(getMapStatus().targetScreen).zoom(getMapStatus().zoom).build()));
                return;
            case FOLLOWING:
                animateMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().target(new LatLng(myLocationData.latitude, myLocationData.longitude)).zoom(getMapStatus().zoom).rotate(getMapStatus().rotate).overlook(getMapStatus().overlook).targetScreen(getMapStatus().targetScreen).build()));
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    private void m11247c() {
        this.f4948k = new CopyOnWriteArrayList();
        this.f4949l = new CopyOnWriteArrayList();
        this.f4950m = new CopyOnWriteArrayList();
        this.f4938R = new Point((int) (SysOSUtil.getDensity() * 40.0f), (int) (SysOSUtil.getDensity() * 40.0f));
        this.f4944g = new UiSettings(this.f4946i);
        this.f4951n = new Overlay.InterfaceC1076a() { // from class: com.baidu.mapapi.map.BaiduMap.1
            @Override // com.baidu.mapapi.map.Overlay.InterfaceC1076a
            /* renamed from: a */
            public void mo11152a(Overlay overlay) {
                if (overlay != null && BaiduMap.this.f4948k.contains(overlay)) {
                    Bundle mo11139a = overlay.mo11139a();
                    if (BaiduMap.this.f4946i != null) {
                        BaiduMap.this.f4946i.m10693d(mo11139a);
                    }
                    BaiduMap.this.f4948k.remove(overlay);
                }
                if (overlay != null && BaiduMap.this.f4950m.contains(overlay)) {
                    BaiduMap.this.f4950m.remove(overlay);
                }
                if (overlay == null || !BaiduMap.this.f4949l.contains(overlay)) {
                    return;
                }
                Marker marker = (Marker) overlay;
                if (marker.f5165o != null) {
                    BaiduMap.this.f4949l.remove(marker);
                    if (BaiduMap.this.f4949l.size() != 0 || BaiduMap.this.f4946i == null) {
                        return;
                    }
                    BaiduMap.this.f4946i.m10702b(false);
                }
            }

            @Override // com.baidu.mapapi.map.Overlay.InterfaceC1076a
            /* renamed from: b */
            public void mo11151b(Overlay overlay) {
                if (overlay != null && BaiduMap.this.f4948k.contains(overlay)) {
                    boolean z = false;
                    if (overlay instanceof Marker) {
                        Marker marker = (Marker) overlay;
                        if (marker.f5152b != null) {
                            if (marker.f5165o != null && marker.f5165o.size() > 1) {
                                Bundle bundle = new Bundle();
                                if (BaiduMap.this.f4946i != null) {
                                    marker.remove();
                                    marker.f5165o.clear();
                                    BaiduMap.this.f4946i.m10706b(overlay.mo11138a(bundle));
                                    BaiduMap.this.f4948k.add(overlay);
                                    z = true;
                                }
                            }
                        } else if (marker.f5165o != null && marker.f5165o.size() != 0) {
                            if (BaiduMap.this.f4949l.contains(marker)) {
                                BaiduMap.this.f4949l.remove(marker);
                            }
                            BaiduMap.this.f4949l.add(marker);
                            if (BaiduMap.this.f4946i != null) {
                                BaiduMap.this.f4946i.m10702b(true);
                            }
                        }
                    }
                    if (BaiduMap.this.f4946i != null && !z) {
                        BaiduMap.this.f4946i.m10698c(overlay.mo11138a(new Bundle()));
                    }
                }
                if (BaiduMap.this.f4950m.contains(overlay)) {
                    BaiduMap.this.f4950m.remove(overlay);
                }
                if (overlay instanceof Marker) {
                    BaiduMap.this.f4950m.add((Marker) overlay);
                }
            }
        };
        this.f4946i.m10720a(new InterfaceC1219k() { // from class: com.baidu.mapapi.map.BaiduMap.2
            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10622a() {
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10621a(Bitmap bitmap) {
                if (BaiduMap.this.f4963z != null) {
                    BaiduMap.this.f4963z.onSnapshotReady(bitmap);
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10620a(MotionEvent motionEvent) {
                if (BaiduMap.this.f4953p != null) {
                    BaiduMap.this.f4953p.onTouch(motionEvent);
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10619a(GeoPoint geoPoint) {
                if (BaiduMap.this.f4954q != null) {
                    BaiduMap.this.f4954q.onMapClick(CoordUtil.mc2ll(geoPoint));
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10618a(C1236z c1236z) {
                if (BaiduMap.this.f4930J != null) {
                    BaiduMap.this.f4930J.setVisibility(4);
                }
                int i = (BaiduMap.mapStatusReason & 256) == 256 ? 3 : (BaiduMap.mapStatusReason & 16) == 16 ? 2 : 1;
                if (BaiduMap.this.f4952o != null) {
                    MapStatus m11182a = MapStatus.m11182a(c1236z);
                    BaiduMap.this.f4952o.onMapStatusChangeStart(m11182a);
                    BaiduMap.this.f4952o.onMapStatusChangeStart(m11182a, i);
                }
                if (BaiduMap.this.f4923C != null) {
                    BaiduMap.this.f4923C.onMapStatusChangeReason(i);
                }
                BaiduMap.mapStatusReason = 0;
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10617a(String str) {
                C1236z m10753E;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONArray("dataset").optJSONObject(0);
                    GeoPoint m10707b = BaiduMap.this.f4946i.m10707b(jSONObject.optInt("px"), jSONObject.optInt("py"));
                    int optInt = optJSONObject.optInt("ty");
                    if (optInt == 17) {
                        if (BaiduMap.this.f4954q != null) {
                            MapPoi mapPoi = new MapPoi();
                            mapPoi.m11184a(optJSONObject);
                            BaiduMap.this.f4954q.onMapPoiClick(mapPoi);
                        }
                    } else if (optInt == 18) {
                        if (BaiduMap.this.f4962y != null) {
                            BaiduMap.this.f4962y.onMyLocationClick();
                        } else {
                            mo10619a(m10707b);
                        }
                    } else if (optInt == 19) {
                        if (BaiduMap.this.f4946i == null || (m10753E = BaiduMap.this.f4946i.m10753E()) == null) {
                            return;
                        }
                        m10753E.f6116c = 0;
                        m10753E.f6115b = 0;
                        BaiduMap.mapStatusReason |= 16;
                        BaiduMap.this.f4946i.m10716a(m10753E, 300);
                    } else if (optInt != 90909) {
                        if (optInt == 90910) {
                            String optString = optJSONObject.optString("polyline_id");
                            for (Overlay overlay : BaiduMap.this.f4948k) {
                                if ((overlay instanceof Polyline) && overlay.f5201v.equals(optString)) {
                                    if (BaiduMap.this.f4960w.isEmpty()) {
                                        mo10619a(m10707b);
                                    } else {
                                        Iterator it = BaiduMap.this.f4960w.iterator();
                                        while (it.hasNext()) {
                                            ((OnPolylineClickListener) it.next()).onPolylineClick((Polyline) overlay);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        String optString2 = optJSONObject.optString("marker_id");
                        if (BaiduMap.this.f4928H != null && optString2.equals(BaiduMap.this.f4929I.f5201v)) {
                            InfoWindow.OnInfoWindowClickListener onInfoWindowClickListener = BaiduMap.this.f4928H.f5063d;
                            if (onInfoWindowClickListener != null) {
                                onInfoWindowClickListener.onInfoWindowClick();
                                return;
                            } else {
                                mo10619a(m10707b);
                                return;
                            }
                        }
                        for (Overlay overlay2 : BaiduMap.this.f4948k) {
                            if ((overlay2 instanceof Marker) && overlay2.f5201v.equals(optString2)) {
                                if (!BaiduMap.this.f4959v.isEmpty()) {
                                    Iterator it2 = BaiduMap.this.f4959v.iterator();
                                    while (it2.hasNext()) {
                                        ((OnMarkerClickListener) it2.next()).onMarkerClick((Marker) overlay2);
                                    }
                                    return;
                                }
                                mo10619a(m10707b);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10616a(GL10 gl10, C1236z c1236z) {
                if (BaiduMap.this.f4921A != null) {
                    BaiduMap.this.f4921A.onMapDrawFrame(MapStatus.m11182a(c1236z));
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: a */
            public void mo10615a(boolean z) {
                if (BaiduMap.this.f4922B != null) {
                    BaiduMap.this.f4922B.onBaseIndoorMapMode(z, BaiduMap.this.getFocusedBaseIndoorMapInfo());
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: b */
            public void mo10614b() {
                BaiduMap baiduMap = BaiduMap.this;
                baiduMap.f4943f = new Projection(baiduMap.f4946i);
                BaiduMap.this.f4937Q = true;
                if (BaiduMap.this.f4955r != null) {
                    BaiduMap.this.f4955r.onMapLoaded();
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: b */
            public void mo10613b(GeoPoint geoPoint) {
                if (BaiduMap.this.f4957t != null) {
                    BaiduMap.this.f4957t.onMapDoubleClick(CoordUtil.mc2ll(geoPoint));
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: b */
            public void mo10612b(C1236z c1236z) {
                if (BaiduMap.this.f4952o != null) {
                    BaiduMap.this.f4952o.onMapStatusChange(MapStatus.m11182a(c1236z));
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: b */
            public boolean mo10611b(String str) {
                try {
                    JSONObject optJSONObject = new JSONObject(str).optJSONArray("dataset").optJSONObject(0);
                    if (optJSONObject.optInt("ty") == 90909) {
                        String optString = optJSONObject.optString("marker_id");
                        if (BaiduMap.this.f4929I == null || !optString.equals(BaiduMap.this.f4929I.f5201v)) {
                            for (Overlay overlay : BaiduMap.this.f4948k) {
                                if ((overlay instanceof Marker) && overlay.f5201v.equals(optString)) {
                                    Marker marker = (Marker) overlay;
                                    if (marker.f5156f) {
                                        BaiduMap.this.f4931K = marker;
                                        Point screenLocation = BaiduMap.this.f4943f.toScreenLocation(BaiduMap.this.f4931K.f5151a);
                                        BaiduMap.this.f4931K.setPosition(BaiduMap.this.f4943f.fromScreenLocation(new Point(screenLocation.x, screenLocation.y - 60)));
                                        if (BaiduMap.this.f4961x != null) {
                                            BaiduMap.this.f4961x.onMarkerDragStart(BaiduMap.this.f4931K);
                                        }
                                        return true;
                                    }
                                    return false;
                                }
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: c */
            public void mo10610c() {
                if (BaiduMap.this.f4956s != null) {
                    BaiduMap.this.f4956s.onMapRenderFinished();
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: c */
            public void mo10609c(GeoPoint geoPoint) {
                if (BaiduMap.this.f4958u != null) {
                    BaiduMap.this.f4958u.onMapLongClick(CoordUtil.mc2ll(geoPoint));
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: c */
            public void mo10608c(C1236z c1236z) {
                if (BaiduMap.this.f4930J != null) {
                    BaiduMap.this.f4930J.setVisibility(0);
                }
                if (BaiduMap.this.f4952o != null) {
                    BaiduMap.this.f4952o.onMapStatusChangeFinish(MapStatus.m11182a(c1236z));
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: d */
            public void mo10607d() {
                BaiduMap.this.f4926F.lock();
                try {
                    if (BaiduMap.this.f4925E != null) {
                        BaiduMap.this.f4925E.m11210a();
                    }
                } finally {
                    BaiduMap.this.f4926F.unlock();
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: d */
            public void mo10606d(GeoPoint geoPoint) {
                if (BaiduMap.this.f4931K == null || !BaiduMap.this.f4931K.f5156f) {
                    return;
                }
                Point screenLocation = BaiduMap.this.f4943f.toScreenLocation(CoordUtil.mc2ll(geoPoint));
                BaiduMap.this.f4931K.setPosition(BaiduMap.this.f4943f.fromScreenLocation(new Point(screenLocation.x, screenLocation.y - 60)));
                if (BaiduMap.this.f4961x == null || !BaiduMap.this.f4931K.f5156f) {
                    return;
                }
                BaiduMap.this.f4961x.onMarkerDrag(BaiduMap.this.f4931K);
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: e */
            public void mo10605e() {
                BaiduMap.this.f4926F.lock();
                try {
                    if (BaiduMap.this.f4925E != null) {
                        BaiduMap.this.f4925E.m11210a();
                        BaiduMap.this.f4946i.m10666o();
                    }
                } finally {
                    BaiduMap.this.f4926F.unlock();
                }
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: e */
            public void mo10604e(GeoPoint geoPoint) {
                if (BaiduMap.this.f4931K == null || !BaiduMap.this.f4931K.f5156f) {
                    return;
                }
                Point screenLocation = BaiduMap.this.f4943f.toScreenLocation(CoordUtil.mc2ll(geoPoint));
                BaiduMap.this.f4931K.setPosition(BaiduMap.this.f4943f.fromScreenLocation(new Point(screenLocation.x, screenLocation.y - 60)));
                if (BaiduMap.this.f4961x != null && BaiduMap.this.f4931K.f5156f) {
                    BaiduMap.this.f4961x.onMarkerDragEnd(BaiduMap.this.f4931K);
                }
                BaiduMap.this.f4931K = null;
            }

            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k
            /* renamed from: f */
            public void mo10603f() {
                BaiduMap.this.f4946i.m10702b(false);
                BaiduMap.this.f4926F.lock();
                try {
                    if (BaiduMap.this.f4925E != null) {
                        BaiduMap.this.m11254a(BaiduMap.this.f4925E);
                    }
                } finally {
                    BaiduMap.this.f4926F.unlock();
                }
            }
        });
        this.f4946i.m10719a(new InterfaceC1223n() { // from class: com.baidu.mapapi.map.BaiduMap.3
            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1223n
            /* renamed from: a */
            public Bundle mo10594a(int i, int i2, int i3) {
                Tile m11207a;
                BaiduMap.this.f4926F.lock();
                try {
                    if (BaiduMap.this.f4925E == null || (m11207a = BaiduMap.this.f4925E.m11207a(i, i2, i3)) == null) {
                        BaiduMap.this.f4926F.unlock();
                        return null;
                    }
                    return m11207a.toBundle();
                } finally {
                    BaiduMap.this.f4926F.unlock();
                }
            }
        });
        this.f4946i.m10722a(new InterfaceC1202F() { // from class: com.baidu.mapapi.map.BaiduMap.4
            @Override // com.baidu.mapsdkplatform.comapi.map.InterfaceC1202F
            /* renamed from: a */
            public Bundle mo10772a(int i, int i2, int i3, Context context) {
                Tile m11120a;
                BaiduMap.this.f4927G.lock();
                try {
                    if (BaiduMap.this.f4924D == null || (m11120a = BaiduMap.this.f4924D.m11120a(i, i2, i3)) == null) {
                        BaiduMap.this.f4927G.unlock();
                        return null;
                    }
                    return m11120a.toBundle();
                } finally {
                    BaiduMap.this.f4927G.unlock();
                }
            }
        });
        this.f4934N = this.f4946i.m10755C();
        this.f4935O = this.f4946i.m10754D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11259a() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return;
        }
        c1210e.m10656t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11254a(HeatMap heatMap) {
        this.f4926F.lock();
        try {
            if (this.f4925E != null && this.f4946i != null && heatMap == this.f4925E) {
                this.f4925E.m11197b();
                this.f4925E.m11193c();
                this.f4925E.f5039a = null;
                this.f4946i.m10666o();
                this.f4925E = null;
                this.f4946i.m10667n(false);
            }
        } finally {
            this.f4926F.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11251a(TileOverlay tileOverlay) {
        this.f4927G.lock();
        if (tileOverlay != null) {
            try {
                if (this.f4924D == tileOverlay) {
                    tileOverlay.m11115b();
                    tileOverlay.f5326a = null;
                    if (this.f4946i != null) {
                        this.f4946i.m10687e(false);
                    }
                }
            } finally {
                this.f4924D = null;
                this.f4927G.unlock();
            }
        }
    }

    public void addHeatMap(HeatMap heatMap) {
        if (heatMap == null) {
            return;
        }
        this.f4926F.lock();
        try {
            if (heatMap != this.f4925E) {
                if (this.f4925E != null) {
                    this.f4925E.m11197b();
                    this.f4925E.m11193c();
                    this.f4925E.f5039a = null;
                    this.f4946i.m10666o();
                }
                this.f4925E = heatMap;
                this.f4925E.f5039a = this;
                this.f4946i.m10667n(true);
            }
        } finally {
            this.f4926F.unlock();
        }
    }

    public final Overlay addOverlay(OverlayOptions overlayOptions) {
        if (overlayOptions == null) {
            return null;
        }
        Overlay mo11137a = overlayOptions.mo11137a();
        mo11137a.listener = this.f4951n;
        if (mo11137a instanceof Marker) {
            Marker marker = (Marker) mo11137a;
            if (marker.f5165o != null && marker.f5165o.size() != 0) {
                this.f4949l.add(marker);
                C1210e c1210e = this.f4946i;
                if (c1210e != null) {
                    c1210e.m10702b(true);
                }
            }
            this.f4950m.add(marker);
        }
        Bundle bundle = new Bundle();
        mo11137a.mo11138a(bundle);
        C1210e c1210e2 = this.f4946i;
        if (c1210e2 != null) {
            c1210e2.m10706b(bundle);
        }
        this.f4948k.add(mo11137a);
        return mo11137a;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Bundle[] bundleArr = new Bundle[list.size()];
        int i = 0;
        for (OverlayOptions overlayOptions : list) {
            if (overlayOptions != null) {
                Bundle bundle = new Bundle();
                Overlay mo11137a = overlayOptions.mo11137a();
                mo11137a.listener = this.f4951n;
                if (mo11137a instanceof Marker) {
                    Marker marker = (Marker) mo11137a;
                    if (marker.f5165o != null && marker.f5165o.size() != 0) {
                        this.f4949l.add(marker);
                        C1210e c1210e = this.f4946i;
                        if (c1210e != null) {
                            c1210e.m10702b(true);
                        }
                    }
                    this.f4950m.add(marker);
                }
                this.f4948k.add(mo11137a);
                arrayList.add(mo11137a);
                mo11137a.mo11138a(bundle);
                bundleArr[i] = bundle;
                i++;
            }
        }
        int length = bundleArr.length / 400;
        for (int i2 = 0; i2 < length + 1; i2++) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < 400; i3++) {
                int i4 = (i2 * 400) + i3;
                if (i4 >= bundleArr.length) {
                    break;
                }
                if (bundleArr[i4] != null) {
                    arrayList2.add(bundleArr[i4]);
                }
            }
            C1210e c1210e2 = this.f4946i;
            if (c1210e2 != null) {
                c1210e2.m10712a(arrayList2);
            }
        }
        return arrayList;
    }

    public TileOverlay addTileLayer(TileOverlayOptions tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return null;
        }
        TileOverlay tileOverlay = this.f4924D;
        if (tileOverlay != null) {
            tileOverlay.m11115b();
            this.f4924D.f5326a = null;
        }
        C1210e c1210e = this.f4946i;
        if (c1210e == null || !c1210e.m10727a(tileOverlayOptions.m11110a())) {
            return null;
        }
        TileOverlay m11108a = tileOverlayOptions.m11108a(this);
        this.f4924D = m11108a;
        return m11108a;
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate) {
        animateMapStatus(mapStatusUpdate, 300);
    }

    public final void animateMapStatus(MapStatusUpdate mapStatusUpdate, int i) {
        if (mapStatusUpdate == null || i <= 0) {
            return;
        }
        C1236z m11253a = m11253a(mapStatusUpdate);
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return;
        }
        mapStatusReason |= 256;
        if (this.f4937Q) {
            c1210e.m10716a(m11253a, i);
        } else {
            c1210e.m10717a(m11253a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m11249b() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return false;
        }
        return c1210e.m10690e();
    }

    public void changeLocationLayerOrder(boolean z) {
        this.f4946i.m10696c(z);
    }

    public final void clear() {
        this.f4948k.clear();
        this.f4949l.clear();
        this.f4950m.clear();
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            c1210e.m10702b(false);
            this.f4946i.m10668n();
        }
        hideInfoWindow();
    }

    public final Point getCompassPosition() {
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            return m11250a(c1210e.m10680h());
        }
        return null;
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        return this.f4946i.m10664p();
    }

    public final MyLocationConfiguration getLocationConfigeration() {
        return getLocationConfiguration();
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        return this.f4933M;
    }

    public final MyLocationData getLocationData() {
        return this.f4932L;
    }

    public final MapStatus getMapStatus() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return null;
        }
        return MapStatus.m11182a(c1210e.m10753E());
    }

    public final LatLngBounds getMapStatusLimit() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return null;
        }
        return c1210e.m10752F();
    }

    public final int getMapType() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return 1;
        }
        if (c1210e.m10672l()) {
            return this.f4946i.m10674k() ? 2 : 1;
        }
        return 3;
    }

    public List<Marker> getMarkersInBounds(LatLngBounds latLngBounds) {
        if (getMapStatus() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f4950m.size() == 0) {
            return null;
        }
        for (Marker marker : this.f4950m) {
            if (latLngBounds.contains(marker.getPosition())) {
                arrayList.add(marker);
            }
        }
        return arrayList;
    }

    public final float getMaxZoomLevel() {
        C1210e c1210e = this.f4946i;
        return c1210e == null ? ColumnText.GLOBAL_SPACE_CHAR_RATIO : c1210e.f5983a;
    }

    public final float getMinZoomLevel() {
        C1210e c1210e = this.f4946i;
        return c1210e == null ? ColumnText.GLOBAL_SPACE_CHAR_RATIO : c1210e.f6004b;
    }

    public final Projection getProjection() {
        return this.f4943f;
    }

    public float[] getProjectionMatrix() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return null;
        }
        return c1210e.m10745M();
    }

    public final UiSettings getUiSettings() {
        return this.f4944g;
    }

    public float[] getViewMatrix() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return null;
        }
        return c1210e.m10744N();
    }

    public GestureDetector$OnDoubleTapListenerC1216j getmGLMapView() {
        return this.f4945h;
    }

    public void hideInfoWindow() {
        InfoWindow infoWindow = this.f4928H;
        if (infoWindow != null) {
            if (infoWindow.f5061b != null) {
                switch (this.f4942d) {
                    case TextureView:
                        TextureMapView textureMapView = this.f4940b;
                        if (textureMapView != null) {
                            textureMapView.removeView(this.f4930J);
                            break;
                        }
                        break;
                    case GLSurfaceView:
                        if (this.f4945h != null) {
                            this.f4939a.removeView(this.f4930J);
                            break;
                        }
                        break;
                }
                this.f4930J = null;
            }
            this.f4928H = null;
            this.f4929I.remove();
            this.f4929I = null;
        }
    }

    public void hideSDKLayer() {
        this.f4946i.m10701c();
    }

    public final boolean isBaiduHeatMapEnabled() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return false;
        }
        return c1210e.m10678i();
    }

    public boolean isBaseIndoorMapMode() {
        return this.f4946i.m10662q();
    }

    public final boolean isBuildingsEnabled() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return false;
        }
        return c1210e.m10670m();
    }

    public final boolean isMyLocationEnabled() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return false;
        }
        return c1210e.m10658s();
    }

    public final boolean isSupportBaiduHeatMap() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return false;
        }
        return c1210e.m10676j();
    }

    public final boolean isTrafficEnabled() {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return false;
        }
        return c1210e.m10683g();
    }

    public final void removeMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (this.f4959v.contains(onMarkerClickListener)) {
            this.f4959v.remove(onMarkerClickListener);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean z) {
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            c1210e.m10681g(z);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            c1210e.m10677i(z);
        }
    }

    public void setCompassEnable(boolean z) {
        this.f4946i.m10691d(z);
    }

    public void setCompassIcon(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("compass's icon can not be null");
        }
        this.f4946i.m10729a(bitmap);
    }

    public void setCompassPosition(Point point) {
        if (this.f4946i.m10728a(point)) {
            this.f4938R = point;
        }
    }

    public boolean setCustomTrafficColor(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                this.f4946i.m10731a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
                return true;
            }
            return true;
        } else if (str.matches("^#[0-9a-fA-F]{8}$") && str2.matches("^#[0-9a-fA-F]{8}$") && str3.matches("^#[0-9a-fA-F]{8}$") && str4.matches("^#[0-9a-fA-F]{8}$")) {
            this.f4946i.m10731a(Color.parseColor(str), Color.parseColor(str2), Color.parseColor(str3), Color.parseColor(str4), true);
            return true;
        } else {
            Log.e(f4920e, "the string of the input customTrafficColor is error");
            return false;
        }
    }

    public final void setIndoorEnable(boolean z) {
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            this.f4936P = z;
            c1210e.m10673k(z);
        }
        OnBaseIndoorMapListener onBaseIndoorMapListener = this.f4922B;
        if (onBaseIndoorMapListener == null || z) {
            return;
        }
        onBaseIndoorMapListener.onBaseIndoorMapMode(false, null);
    }

    public final void setMapStatus(MapStatusUpdate mapStatusUpdate) {
        if (mapStatusUpdate == null) {
            return;
        }
        C1236z m11253a = m11253a(mapStatusUpdate);
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return;
        }
        c1210e.m10717a(m11253a);
        OnMapStatusChangeListener onMapStatusChangeListener = this.f4952o;
        if (onMapStatusChangeListener != null) {
            onMapStatusChangeListener.onMapStatusChange(getMapStatus());
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return;
        }
        c1210e.m10724a(latLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds));
    }

    public final void setMapType(int i) {
        C1210e c1210e = this.f4946i;
        if (c1210e == null) {
            return;
        }
        switch (i) {
            case 1:
                c1210e.m10711a(false);
                this.f4946i.m10655t(this.f4934N);
                this.f4946i.m10653u(this.f4935O);
                this.f4946i.m10684f(true);
                this.f4946i.m10673k(this.f4936P);
                break;
            case 2:
                c1210e.m10711a(true);
                this.f4946i.m10655t(this.f4934N);
                this.f4946i.m10653u(this.f4935O);
                this.f4946i.m10684f(true);
                break;
            case 3:
                if (c1210e.m10755C()) {
                    this.f4946i.m10655t(false);
                }
                if (this.f4946i.m10754D()) {
                    this.f4946i.m10653u(false);
                }
                this.f4946i.m10684f(false);
                this.f4946i.m10673k(false);
                break;
        }
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f4945h;
        if (gestureDetector$OnDoubleTapListenerC1216j != null) {
            gestureDetector$OnDoubleTapListenerC1216j.m10639a(i);
        }
    }

    public final void setMaxAndMinZoomLevel(float f, float f2) {
        C1210e c1210e;
        if (f <= 21.0f && f2 >= 4.0f && f >= f2 && (c1210e = this.f4946i) != null) {
            c1210e.m10737a(f, f2);
        }
    }

    public final void setMyLocationConfigeration(MyLocationConfiguration myLocationConfiguration) {
        setMyLocationConfiguration(myLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration myLocationConfiguration) {
        this.f4933M = myLocationConfiguration;
        m11252a(this.f4932L, this.f4933M);
    }

    public final void setMyLocationData(MyLocationData myLocationData) {
        this.f4932L = myLocationData;
        if (this.f4933M == null) {
            this.f4933M = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
        }
        m11252a(myLocationData, this.f4933M);
    }

    public final void setMyLocationEnabled(boolean z) {
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            c1210e.m10669m(z);
        }
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener onBaseIndoorMapListener) {
        this.f4922B = onBaseIndoorMapListener;
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.f4954q = onMapClickListener;
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener onMapDoubleClickListener) {
        this.f4957t = onMapDoubleClickListener;
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback onMapDrawFrameCallback) {
        this.f4921A = onMapDrawFrameCallback;
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        this.f4955r = onMapLoadedCallback;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.f4958u = onMapLongClickListener;
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback onMapRenderCallback) {
        this.f4956s = onMapRenderCallback;
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener onMapStatusChangeListener) {
        this.f4952o = onMapStatusChangeListener;
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        this.f4953p = onMapTouchListener;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null || this.f4959v.contains(onMarkerClickListener)) {
            return;
        }
        this.f4959v.add(onMarkerClickListener);
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        this.f4961x = onMarkerDragListener;
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        this.f4962y = onMyLocationClickListener;
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener != null) {
            this.f4960w.add(onPolylineClickListener);
        }
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener onSynchronizationListener) {
        this.f4923C = onSynchronizationListener;
    }

    @Deprecated
    public final void setPadding(int i, int i2, int i3, int i4) {
        C1210e c1210e;
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || (c1210e = this.f4946i) == null) {
            return;
        }
        c1210e.m10753E();
        switch (this.f4942d) {
            case TextureView:
                TextureMapView textureMapView = this.f4940b;
                if (textureMapView == null) {
                    return;
                }
                float width = ((textureMapView.getWidth() - i) - i3) / this.f4940b.getWidth();
                float height = ((this.f4940b.getHeight() - i2) - i4) / this.f4940b.getHeight();
                MapStatusUpdate newMapStatus = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.f4940b.getWidth() + i) - i3) / 2, ((this.f4940b.getHeight() + i2) - i4) / 2)).build());
                this.f4946i.m10728a(new Point((int) (i + (this.f4938R.x * width)), (int) (i2 + (this.f4938R.y * height))));
                setMapStatus(newMapStatus);
                this.f4940b.setPadding(i, i2, i3, i4);
                this.f4940b.invalidate();
                return;
            case GLSurfaceView:
                MapView mapView = this.f4939a;
                if (mapView == null) {
                    return;
                }
                float width2 = ((mapView.getWidth() - i) - i3) / this.f4939a.getWidth();
                float height2 = ((this.f4939a.getHeight() - i2) - i4) / this.f4939a.getHeight();
                MapStatusUpdate newMapStatus2 = MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder().targetScreen(new Point(((this.f4939a.getWidth() + i) - i3) / 2, ((this.f4939a.getHeight() + i2) - i4) / 2)).build());
                this.f4946i.m10728a(new Point((int) (i + (this.f4938R.x * width2)), (int) (i2 + (this.f4938R.y * height2))));
                setMapStatus(newMapStatus2);
                this.f4939a.setPadding(i, i2, i3, i4);
                this.f4939a.invalidate();
                return;
            default:
                return;
        }
    }

    public void setPixelFormatTransparent(boolean z) {
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f4945h;
        if (gestureDetector$OnDoubleTapListenerC1216j == null) {
            return;
        }
        if (z) {
            gestureDetector$OnDoubleTapListenerC1216j.m10628d();
        } else {
            gestureDetector$OnDoubleTapListenerC1216j.m10626e();
        }
    }

    public final void setTrafficEnabled(boolean z) {
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            c1210e.m10679h(z);
        }
    }

    public final void setViewPadding(int i, int i2, int i3, int i4) {
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0 || this.f4946i == null) {
            return;
        }
        switch (this.f4942d) {
            case TextureView:
                TextureMapView textureMapView = this.f4940b;
                if (textureMapView == null) {
                    return;
                }
                this.f4946i.m10728a(new Point((int) (i + (this.f4938R.x * (((textureMapView.getWidth() - i) - i3) / this.f4940b.getWidth()))), (int) (i2 + (this.f4938R.y * (((this.f4940b.getHeight() - i2) - i4) / this.f4940b.getHeight())))));
                this.f4940b.setPadding(i, i2, i3, i4);
                this.f4940b.invalidate();
                return;
            case GLSurfaceView:
                MapView mapView = this.f4939a;
                if (mapView == null) {
                    return;
                }
                this.f4946i.m10728a(new Point((int) (i + (this.f4938R.x * (((mapView.getWidth() - i) - i3) / this.f4939a.getWidth()))), (int) (i2 + (this.f4938R.y * (((this.f4939a.getHeight() - i2) - i4) / this.f4939a.getHeight())))));
                this.f4939a.setPadding(i, i2, i3, i4);
                this.f4939a.invalidate();
                return;
            default:
                return;
        }
    }

    public void showInfoWindow(InfoWindow infoWindow) {
        if (infoWindow != null) {
            hideInfoWindow();
            if (infoWindow.f5061b != null) {
                this.f4930J = infoWindow.f5061b;
                this.f4930J.destroyDrawingCache();
                MapViewLayoutParams build = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(infoWindow.f5062c).yOffset(infoWindow.f5064e).build();
                switch (this.f4942d) {
                    case TextureView:
                        TextureMapView textureMapView = this.f4940b;
                        if (textureMapView != null) {
                            textureMapView.addView(this.f4930J, build);
                            break;
                        }
                        break;
                    case GLSurfaceView:
                        if (this.f4945h != null) {
                            this.f4939a.addView(this.f4930J, build);
                            break;
                        }
                        break;
                }
            }
            this.f4928H = infoWindow;
            Overlay mo11137a = new MarkerOptions().perspective(false).icon(infoWindow.f5061b != null ? BitmapDescriptorFactory.fromView(infoWindow.f5061b) : infoWindow.f5060a).position(infoWindow.f5062c).zIndex(MoPubNativeAdPositioning.MoPubClientPositioning.NO_REPEAT).yOffset(infoWindow.f5064e).mo11137a();
            mo11137a.listener = this.f4951n;
            mo11137a.type = EnumC1214h.popup;
            Bundle bundle = new Bundle();
            mo11137a.mo11138a(bundle);
            C1210e c1210e = this.f4946i;
            if (c1210e != null) {
                c1210e.m10706b(bundle);
            }
            this.f4948k.add(mo11137a);
            this.f4929I = (Marker) mo11137a;
        }
    }

    public final void showMapIndoorPoi(boolean z) {
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            c1210e.m10653u(z);
            this.f4935O = z;
        }
    }

    public final void showMapPoi(boolean z) {
        C1210e c1210e = this.f4946i;
        if (c1210e != null) {
            c1210e.m10655t(z);
            this.f4934N = z;
        }
    }

    public void showSDKLayer() {
        this.f4946i.m10695d();
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        this.f4963z = snapshotReadyCallback;
        switch (this.f4942d) {
            case TextureView:
                GestureDetector$OnDoubleTapListenerC1196A gestureDetector$OnDoubleTapListenerC1196A = this.f4947j;
                if (gestureDetector$OnDoubleTapListenerC1196A != null) {
                    gestureDetector$OnDoubleTapListenerC1196A.m10784a("anything", null);
                    return;
                }
                return;
            case GLSurfaceView:
                GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f4945h;
                if (gestureDetector$OnDoubleTapListenerC1216j != null) {
                    gestureDetector$OnDoubleTapListenerC1216j.m10636a("anything", (Rect) null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void snapshotScope(Rect rect, SnapshotReadyCallback snapshotReadyCallback) {
        this.f4963z = snapshotReadyCallback;
        switch (this.f4942d) {
            case TextureView:
                GestureDetector$OnDoubleTapListenerC1196A gestureDetector$OnDoubleTapListenerC1196A = this.f4947j;
                if (gestureDetector$OnDoubleTapListenerC1196A != null) {
                    gestureDetector$OnDoubleTapListenerC1196A.m10784a("anything", rect);
                    return;
                }
                return;
            case GLSurfaceView:
                GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f4945h;
                if (gestureDetector$OnDoubleTapListenerC1216j != null) {
                    gestureDetector$OnDoubleTapListenerC1216j.m10636a("anything", rect);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
        }
        MapBaseIndoorMapInfo focusedBaseIndoorMapInfo = getFocusedBaseIndoorMapInfo();
        if (focusedBaseIndoorMapInfo == null) {
            return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
        }
        if (str2.equals(focusedBaseIndoorMapInfo.f5068a)) {
            ArrayList<String> floors = focusedBaseIndoorMapInfo.getFloors();
            return (floors == null || !floors.contains(str)) ? MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW : this.f4946i.m10714a(str, str2) ? MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK : MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
        }
        return MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
    }
}
