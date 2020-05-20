package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.WinRound;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo;
import com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1256b;
import com.itextpdf.text.pdf.ColumnText;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.a */
/* loaded from: classes.dex */
public class HandlerC1281a extends Handler {

    /* renamed from: a */
    private static final String f6294a = "a";

    /* renamed from: d */
    private static RoleOptions f6295d = null;

    /* renamed from: e */
    private static DisplayOptions f6296e = null;

    /* renamed from: f */
    private static Marker f6297f = null;

    /* renamed from: g */
    private static volatile SyncResponseResult f6298g = null;

    /* renamed from: h */
    private static int f6299h = 1000;

    /* renamed from: p */
    private static volatile int f6300p;

    /* renamed from: r */
    private static LatLng f6301r;

    /* renamed from: A */
    private boolean f6302A;

    /* renamed from: B */
    private Thread f6303B;

    /* renamed from: C */
    private boolean f6304C;

    /* renamed from: D */
    private int f6305D;

    /* renamed from: E */
    private int f6306E;

    /* renamed from: F */
    private LatLngBounds f6307F;

    /* renamed from: G */
    private C1287e f6308G;

    /* renamed from: H */
    private volatile long f6309H;

    /* renamed from: I */
    private boolean f6310I;

    /* renamed from: J */
    private volatile boolean f6311J;

    /* renamed from: K */
    private volatile long f6312K;

    /* renamed from: L */
    private volatile int f6313L;

    /* renamed from: M */
    private List<LatLng> f6314M;

    /* renamed from: N */
    private List<BitmapDescriptor> f6315N;

    /* renamed from: O */
    private Polyline f6316O;

    /* renamed from: P */
    private List<Integer> f6317P;

    /* renamed from: Q */
    private volatile boolean f6318Q;

    /* renamed from: R */
    private int f6319R;

    /* renamed from: S */
    private String f6320S;

    /* renamed from: T */
    private String f6321T;

    /* renamed from: U */
    private boolean f6322U;

    /* renamed from: V */
    private boolean f6323V;

    /* renamed from: W */
    private volatile int f6324W;

    /* renamed from: X */
    private volatile boolean f6325X;

    /* renamed from: b */
    private BaiduMap f6326b;

    /* renamed from: c */
    private InterfaceC1288b f6327c;

    /* renamed from: i */
    private Marker f6328i;

    /* renamed from: j */
    private Marker f6329j;

    /* renamed from: k */
    private Marker f6330k;

    /* renamed from: l */
    private Marker f6331l;

    /* renamed from: m */
    private Marker f6332m;

    /* renamed from: n */
    private Marker f6333n;

    /* renamed from: o */
    private List<LinkPointPolyLineInfo> f6334o;

    /* renamed from: q */
    private Thread f6335q;

    /* renamed from: s */
    private int f6336s;

    /* renamed from: t */
    private double f6337t;

    /* renamed from: u */
    private int f6338u;

    /* renamed from: v */
    private boolean f6339v;

    /* renamed from: w */
    private volatile boolean f6340w;

    /* renamed from: x */
    private Thread f6341x;

    /* renamed from: y */
    private boolean f6342y;

    /* renamed from: z */
    private boolean f6343z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.a$a */
    /* loaded from: classes.dex */
    public class RunnableC1283a implements Runnable {
        private RunnableC1283a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!HandlerC1281a.this.f6304C) {
                if (HandlerC1281a.f6298g != null && HandlerC1281a.f6298g.m10431a() != null) {
                    if (!HandlerC1281a.this.f6325X) {
                        HandlerC1281a.this.m10229ak();
                        HandlerC1281a.this.f6310I = false;
                        HandlerC1281a handlerC1281a = HandlerC1281a.this;
                        handlerC1281a.m10251a(handlerC1281a.f6307F);
                    }
                    try {
                        HandlerC1281a.this.f6312K = System.currentTimeMillis();
                        if (HandlerC1281a.this.f6309H <= 0) {
                            HandlerC1281a.this.f6309H = 10000L;
                        }
                        Thread.sleep(HandlerC1281a.this.f6309H);
                    } catch (InterruptedException unused) {
                        C1255a.m10453b(HandlerC1281a.f6294a, "Sleep InterruptedException");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.a$b */
    /* loaded from: classes.dex */
    public class RunnableC1284b implements Runnable {
        private RunnableC1284b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LatLng latLng;
            LatLng endPosition;
            while (!HandlerC1281a.this.f6318Q) {
                LatLng m10237ac = HandlerC1281a.this.m10237ac();
                if (m10237ac == null) {
                    C1255a.m10453b(HandlerC1281a.f6294a, "Driver position is null, return");
                    return;
                }
                LatLng m10256a = HandlerC1281a.this.m10256a(m10237ac);
                if (m10256a == null) {
                    C1255a.m10453b(HandlerC1281a.f6294a, "Driver position not bind to route");
                    HandlerC1281a.m10206c(HandlerC1281a.this);
                    if (!HandlerC1281a.this.f6339v || HandlerC1281a.this.f6342y) {
                        String str = HandlerC1281a.f6294a;
                        C1255a.m10453b(str, "Driver position not bind to route times = " + HandlerC1281a.this.f6324W);
                        if (2 <= HandlerC1281a.this.f6324W) {
                            if (2 >= HandlerC1281a.f6299h) {
                                latLng = HandlerC1281a.f6301r;
                                endPosition = HandlerC1281a.f6295d.getStartPosition();
                            } else if (4 != HandlerC1281a.f6299h) {
                                HandlerC1281a.this.f6324W = 0;
                                return;
                            } else {
                                latLng = HandlerC1281a.f6301r;
                                endPosition = HandlerC1281a.f6295d.getEndPosition();
                            }
                            double m10451a = C1256b.m10451a(latLng, endPosition);
                            C1255a.m10453b(HandlerC1281a.f6294a, "Latest driver postion to end position distance = ".concat(String.valueOf(m10451a)));
                            if (300.0d >= m10451a) {
                                if (HandlerC1281a.this.f6316O != null) {
                                    HandlerC1281a.this.f6316O.remove();
                                }
                                HandlerC1281a.this.f6318Q = true;
                                HandlerC1281a.this.m10234af();
                            }
                            HandlerC1281a.this.f6324W = 0;
                        }
                        HandlerC1281a.this.m10221b(m10237ac);
                        HandlerC1281a.this.m10233ag();
                        HandlerC1281a.this.m10209c(m10237ac);
                        return;
                    }
                    return;
                } else if (HandlerC1281a.this.f6336s == 0) {
                    return;
                } else {
                    HandlerC1281a handlerC1281a = HandlerC1281a.this;
                    handlerC1281a.f6337t = handlerC1281a.m10236ad();
                    if (HandlerC1281a.this.f6337t > 500.0d) {
                        HandlerC1281a.this.m10221b(m10256a);
                        HandlerC1281a.this.m10233ag();
                        HandlerC1281a.this.m10209c(m10256a);
                        HandlerC1281a.this.m10196e(HandlerC1281a.f6300p - 1);
                        HandlerC1281a.this.f6313L = HandlerC1281a.f6300p - 1;
                        return;
                    }
                    HandlerC1281a.f6298g.m10422c().setPoint(null);
                    try {
                        HandlerC1281a.this.m10235ae();
                    } catch (Exception e) {
                        C1255a.m10456a(HandlerC1281a.f6294a, "Catch exception when car moving", e);
                    }
                    if (HandlerC1281a.f6300p >= HandlerC1281a.this.f6334o.size()) {
                        HandlerC1281a.this.f6318Q = true;
                        HandlerC1281a.this.m10234af();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.a$c */
    /* loaded from: classes.dex */
    public class RunnableC1285c implements Runnable {
        private RunnableC1285c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BitmapDescriptor passengerIcon = HandlerC1281a.f6296e != null ? HandlerC1281a.f6296e.getPassengerIcon() : null;
            if (passengerIcon == null) {
                passengerIcon = new DisplayOptions().getPassengerIcon();
            }
            int passengerMarkerZIndex = HandlerC1281a.f6296e.getPassengerMarkerZIndex();
            while (!HandlerC1281a.this.f6340w) {
                MyLocationData locationData = HandlerC1281a.this.f6326b.getLocationData();
                if (locationData != null && HandlerC1281a.this.m10257a(locationData)) {
                    C1255a.m10453b(HandlerC1281a.f6294a, "Get location data success");
                    LatLng latLng = new LatLng(locationData.latitude, locationData.longitude);
                    if (HandlerC1281a.this.f6333n == null) {
                        MarkerOptions zIndex = new MarkerOptions().position(latLng).anchor(0.5f, 0.5f).rotate(locationData.direction).icon(passengerIcon).zIndex(passengerMarkerZIndex);
                        HandlerC1281a handlerC1281a = HandlerC1281a.this;
                        handlerC1281a.f6333n = (Marker) handlerC1281a.f6326b.addOverlay(zIndex);
                    } else {
                        HandlerC1281a.this.f6333n.setPosition(latLng);
                        HandlerC1281a.this.f6333n.setRotate(locationData.direction);
                    }
                }
                try {
                    Thread.sleep(HandlerC1281a.this.f6319R * 1000);
                } catch (InterruptedException unused) {
                    C1255a.m10453b(HandlerC1281a.f6294a, "Sleep interrupt");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.a$d */
    /* loaded from: classes.dex */
    public enum EnumC1286d {
        NO_NEED_RENDER,
        RENDER_NEW_LINE,
        UPDATE_TRAFFIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.a$e */
    /* loaded from: classes.dex */
    public class C1287e implements BaiduMap.OnSynchronizationListener {

        /* renamed from: b */
        private int f6352b = 1;

        /* renamed from: c */
        private int f6353c = 2;

        /* renamed from: d */
        private int f6354d = 3;

        C1287e() {
        }

        @Override // com.baidu.mapapi.map.BaiduMap.OnSynchronizationListener
        public void onMapStatusChangeReason(int i) {
            if (this.f6352b != i && this.f6353c != i) {
                if (this.f6354d != i) {
                    C1255a.m10453b(HandlerC1281a.f6294a, "Undefined reason type: ".concat(String.valueOf(i)));
                    return;
                }
                HandlerC1281a handlerC1281a = HandlerC1281a.this;
                handlerC1281a.f6309H = handlerC1281a.f6306E * 1000;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - HandlerC1281a.this.f6312K;
            if (currentTimeMillis <= 0) {
                HandlerC1281a handlerC1281a2 = HandlerC1281a.this;
                handlerC1281a2.f6309H = handlerC1281a2.f6305D * 1000;
            } else {
                HandlerC1281a handlerC1281a3 = HandlerC1281a.this;
                handlerC1281a3.f6309H = (handlerC1281a3.f6305D * 1000) - (HandlerC1281a.this.f6309H - currentTimeMillis);
            }
            HandlerC1281a.this.f6311J = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1281a(Looper looper) {
        super(looper);
        this.f6328i = null;
        this.f6329j = null;
        this.f6330k = null;
        this.f6331l = null;
        this.f6332m = null;
        this.f6333n = null;
        this.f6334o = new CopyOnWriteArrayList();
        this.f6336s = 0;
        this.f6337t = 0.0d;
        this.f6338u = 5;
        this.f6339v = false;
        this.f6340w = false;
        this.f6342y = false;
        this.f6343z = true;
        this.f6302A = false;
        this.f6304C = true;
        this.f6305D = 10;
        this.f6306E = 10;
        this.f6307F = null;
        this.f6309H = 10000L;
        this.f6310I = true;
        this.f6311J = false;
        this.f6312K = 0L;
        this.f6313L = 0;
        this.f6314M = new CopyOnWriteArrayList();
        this.f6315N = new CopyOnWriteArrayList();
        this.f6316O = null;
        this.f6317P = new CopyOnWriteArrayList();
        this.f6318Q = true;
        this.f6319R = 5;
        this.f6320S = null;
        this.f6321T = null;
        this.f6322U = true;
        this.f6323V = false;
        this.f6324W = 0;
        this.f6325X = false;
        this.f6335q = new Thread(new RunnableC1284b(), "Car moving");
        this.f6341x = new Thread(new RunnableC1285c(), "Passenger marker");
        this.f6303B = new Thread(new RunnableC1283a(), "Adjust visible span");
    }

    /* renamed from: A */
    private void m10290A() {
        Marker marker = this.f6330k;
        if (marker != null) {
            marker.remove();
            this.f6330k = null;
        }
        Marker marker2 = this.f6331l;
        if (marker2 != null) {
            marker2.remove();
            this.f6331l = null;
        }
    }

    /* renamed from: B */
    private void m10289B() {
        Marker marker = this.f6328i;
        if (marker != null) {
            marker.remove();
            this.f6328i = null;
        }
        Marker marker2 = this.f6329j;
        if (marker2 != null) {
            marker2.remove();
            this.f6329j = null;
        }
    }

    /* renamed from: C */
    private void m10288C() {
        Marker marker = this.f6333n;
        if (marker != null) {
            marker.remove();
            this.f6333n = null;
        }
    }

    /* renamed from: D */
    private void m10287D() {
        Marker marker = this.f6332m;
        if (marker != null) {
            marker.remove();
            this.f6332m = null;
        }
        Marker marker2 = f6297f;
        if (marker2 != null) {
            marker2.remove();
            f6297f = null;
        }
    }

    /* renamed from: E */
    private void m10286E() {
        if (!this.f6339v || this.f6302A) {
            return;
        }
        Polyline polyline = this.f6316O;
        if (polyline != null) {
            polyline.remove();
            this.f6334o.clear();
            this.f6314M.clear();
            this.f6315N.clear();
            this.f6317P.clear();
            f6298g = null;
        }
        this.f6320S = null;
        this.f6321T = null;
    }

    /* renamed from: F */
    private void m10285F() {
        Marker marker = this.f6329j;
        if (marker != null) {
            marker.remove();
            this.f6329j = null;
        }
    }

    /* renamed from: G */
    private void m10284G() {
        Marker marker = f6297f;
        if (marker != null) {
            marker.remove();
            f6297f = null;
        }
    }

    /* renamed from: H */
    private void m10283H() {
        if (!this.f6339v || this.f6342y) {
            return;
        }
        this.f6318Q = true;
    }

    /* renamed from: I */
    private void m10282I() {
        if (!f6296e.isShowStartPositionMarker()) {
            C1255a.m10457a(f6294a, "User set start position marker not show");
            Marker marker = this.f6328i;
            if (marker != null) {
                marker.remove();
                this.f6328i = null;
            }
        } else if (this.f6328i != null && !this.f6339v) {
            C1255a.m10457a(f6294a, "Start position marker already render ok");
        } else {
            LatLng m10281J = m10281J();
            if (m10281J == null) {
                C1255a.m10453b(f6294a, "No startPosition");
                return;
            }
            BitmapDescriptor startPositionIcon = f6296e.getStartPositionIcon();
            if (startPositionIcon == null) {
                C1255a.m10453b(f6294a, "No startPositionIcon, use default");
                startPositionIcon = new DisplayOptions().getStartPositionIcon();
            }
            if (startPositionIcon == null) {
                C1255a.m10453b(f6294a, "There is no startPositionIcon");
                return;
            }
            MarkerOptions zIndex = new MarkerOptions().position(m10281J).icon(startPositionIcon).zIndex(f6296e.getStartPositionMarkerZIndex());
            Marker marker2 = this.f6328i;
            if (marker2 == null) {
                this.f6328i = (Marker) this.f6326b.addOverlay(zIndex);
                return;
            }
            marker2.setIcon(startPositionIcon);
            this.f6328i.setPosition(m10281J);
        }
    }

    /* renamed from: J */
    private LatLng m10281J() {
        LatLng startPosition = f6295d.getStartPosition();
        if (startPosition == null) {
            C1255a.m10453b(f6294a, "The start position is null");
            InterfaceC1288b interfaceC1288b = this.f6327c;
            if (interfaceC1288b != null) {
                interfaceC1288b.mo10146a(100001, "Start position is null");
            }
        }
        return startPosition;
    }

    /* renamed from: K */
    private void m10280K() {
        if (!f6296e.isShowStartPositionInfoWindow()) {
            C1255a.m10457a(f6294a, "User set start position infoWindow not show");
            Marker marker = this.f6329j;
            if (marker != null) {
                marker.remove();
                this.f6329j = null;
                return;
            }
            return;
        }
        LatLng startPosition = f6295d.getStartPosition();
        if (startPosition == null) {
            C1255a.m10453b(f6294a, "No startPosition");
            return;
        }
        View startPositionInfoWindowView = f6296e.getStartPositionInfoWindowView();
        if (startPositionInfoWindowView == null) {
            C1255a.m10453b(f6294a, "Start position infoWindow view is null, cannot display");
            Marker marker2 = this.f6329j;
            if (marker2 != null) {
                marker2.remove();
                this.f6329j = null;
                return;
            }
            return;
        }
        MarkerOptions alpha = new MarkerOptions().position(startPosition).icon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView)).zIndex(f6296e.getStartPositionInfoWindowZIndex()).alpha(0.9f);
        Marker marker3 = this.f6329j;
        if (marker3 == null) {
            this.f6329j = (Marker) this.f6326b.addOverlay(alpha);
            return;
        }
        marker3.setPosition(startPosition);
        this.f6329j.setIcon(BitmapDescriptorFactory.fromView(startPositionInfoWindowView));
    }

    /* renamed from: L */
    private void m10279L() {
        if (!f6296e.isShowEndPositionMarker()) {
            C1255a.m10457a(f6294a, "User set endPositionMarker not show");
            Marker marker = this.f6330k;
            if (marker != null) {
                marker.remove();
                this.f6330k = null;
            }
        } else if (this.f6330k != null && !this.f6339v) {
            C1255a.m10453b(f6294a, "EndPositionMarker already render ok");
        } else {
            LatLng endPosition = f6295d.getEndPosition();
            if (endPosition == null) {
                C1255a.m10453b(f6294a, "End position coord is null");
                return;
            }
            BitmapDescriptor endPositionIcon = f6296e.getEndPositionIcon();
            if (endPositionIcon == null) {
                C1255a.m10453b(f6294a, "The end position icon is null");
                endPositionIcon = new DisplayOptions().getEndPositionIcon();
            }
            if (endPositionIcon == null) {
                C1255a.m10453b(f6294a, "There is no endPositionIcon");
                return;
            }
            MarkerOptions zIndex = new MarkerOptions().position(endPosition).icon(endPositionIcon).zIndex(f6296e.getEndPositionMarkerZIndex());
            Marker marker2 = this.f6330k;
            if (marker2 == null) {
                this.f6330k = (Marker) this.f6326b.addOverlay(zIndex);
                return;
            }
            marker2.setIcon(endPositionIcon);
            this.f6330k.setPosition(endPosition);
        }
    }

    /* renamed from: M */
    private void m10278M() {
        if (!f6296e.isShowEndPositionInfoWindow()) {
            C1255a.m10457a(f6294a, "User set end position infoWindow not show");
            Marker marker = this.f6331l;
            if (marker != null) {
                marker.remove();
                this.f6331l = null;
                return;
            }
            return;
        }
        LatLng endPosition = f6295d.getEndPosition();
        if (endPosition == null) {
            C1255a.m10453b(f6294a, "End position coord is null when render end position infoWindow");
            return;
        }
        View endPositionInfoWindowView = f6296e.getEndPositionInfoWindowView();
        if (endPositionInfoWindowView == null) {
            C1255a.m10453b(f6294a, "End position infoWindow view is null, cannot display");
            Marker marker2 = this.f6331l;
            if (marker2 != null) {
                marker2.remove();
                this.f6331l = null;
                return;
            }
            return;
        }
        MarkerOptions zIndex = new MarkerOptions().position(endPosition).icon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView)).anchor(0.5f, 1.0f).zIndex(f6296e.getEndPositionInfoWindowZIndex());
        Marker marker3 = this.f6331l;
        if (marker3 == null) {
            this.f6331l = (Marker) this.f6326b.addOverlay(zIndex);
            return;
        }
        marker3.setPosition(endPosition);
        this.f6331l.setIcon(BitmapDescriptorFactory.fromView(endPositionInfoWindowView));
    }

    /* renamed from: N */
    private synchronized void m10277N() {
        if (this.f6341x == null) {
            return;
        }
        this.f6340w = false;
        if (Thread.State.NEW == this.f6341x.getState()) {
            this.f6341x.start();
        }
        if (this.f6339v && Thread.State.TERMINATED == this.f6341x.getState()) {
            this.f6341x = null;
            this.f6341x = new Thread(new RunnableC1285c(), "Passenger marker");
            this.f6341x.start();
        }
    }

    /* renamed from: O */
    private void m10276O() {
        if (f6296e.isShowPassengerIcon()) {
            m10277N();
            return;
        }
        C1255a.m10457a(f6294a, "User set not show passenger icon");
        Marker marker = this.f6333n;
        if (marker != null) {
            marker.remove();
            this.f6333n = null;
        }
    }

    /* renamed from: P */
    private synchronized void m10275P() {
        this.f6340w = true;
        if (this.f6341x != null && (Thread.State.NEW != this.f6341x.getState() || Thread.State.TERMINATED != this.f6341x.getState())) {
            this.f6341x.interrupt();
        }
    }

    /* renamed from: Q */
    private void m10274Q() {
        if (!f6296e.isShowCarMarker()) {
            C1255a.m10457a(f6294a, "User set carMarker not show");
            Marker marker = this.f6332m;
            if (marker != null) {
                marker.remove();
                this.f6332m = null;
            }
        } else if (this.f6332m != null && !this.f6339v) {
            C1255a.m10457a(f6294a, "CarIcon already render ok");
        } else {
            LatLng m10271T = m10271T();
            if (m10271T == null) {
                C1255a.m10453b(f6294a, "The car(driver) position is null");
                return;
            }
            BitmapDescriptor carIcon = f6296e.getCarIcon();
            if (carIcon == null) {
                C1255a.m10453b(f6294a, "The car icon is null");
                carIcon = new DisplayOptions().getCarIcon();
            }
            if (carIcon == null) {
                C1255a.m10453b(f6294a, "There is no car icon");
                return;
            }
            MarkerOptions anchor = new MarkerOptions().position(m10271T).icon(carIcon).flat(true).rotate(ColumnText.GLOBAL_SPACE_CHAR_RATIO).zIndex(f6296e.getCarPositionMarkerZIndex()).anchor(0.5f, 0.5f);
            Marker marker2 = this.f6332m;
            if (marker2 == null) {
                this.f6332m = (Marker) this.f6326b.addOverlay(anchor);
                return;
            }
            marker2.setPosition(m10271T);
            this.f6332m.setIcon(carIcon);
        }
    }

    /* renamed from: R */
    private void m10273R() {
        if (!f6296e.isShowCarInfoWindow()) {
            C1255a.m10457a(f6294a, "User set carInfoWindow not show");
            Marker marker = f6297f;
            if (marker != null) {
                marker.remove();
                f6297f = null;
                return;
            }
            return;
        }
        View carInfoWindowView = f6296e.getCarInfoWindowView();
        if (carInfoWindowView == null) {
            C1255a.m10453b(f6294a, "car position infoWindow view is null, cannot display");
            Marker marker2 = f6297f;
            if (marker2 != null) {
                marker2.remove();
                f6297f = null;
                return;
            }
            return;
        }
        LatLng m10272S = m10272S();
        if (m10272S == null) {
            C1255a.m10453b(f6294a, "CarPosition is null");
            return;
        }
        MarkerOptions alpha = new MarkerOptions().position(m10272S).icon(BitmapDescriptorFactory.fromView(carInfoWindowView)).zIndex(f6296e.getCarPositionInfoWindowZIndex()).anchor(0.5f, 1.0f).alpha(0.9f);
        Marker marker3 = f6297f;
        if (marker3 == null) {
            f6297f = (Marker) this.f6326b.addOverlay(alpha);
            return;
        }
        marker3.setPosition(m10272S);
        f6297f.setIcon(BitmapDescriptorFactory.fromView(carInfoWindowView));
    }

    /* renamed from: S */
    private LatLng m10272S() {
        if (this.f6332m != null || f6298g == null) {
            Marker marker = this.f6332m;
            if (marker != null) {
                return marker.getPosition();
            }
            return null;
        }
        return f6298g.m10422c().getPoint();
    }

    /* renamed from: T */
    private LatLng m10271T() {
        LatLng latLng = f6301r;
        return latLng != null ? latLng : (f6298g == null || f6298g.m10422c() == null || f6298g.m10422c().getPoint() == null) ? f6295d.getDriverPosition() : f6298g.m10422c().getPoint();
    }

    /* renamed from: U */
    private void m10270U() {
        DisplayOptions displayOptions = f6296e;
        if (displayOptions == null) {
            return;
        }
        if (!displayOptions.isShowRoutePlan()) {
            C1255a.m10457a(f6294a, "User set route line not show");
            Polyline polyline = this.f6316O;
            if (polyline != null) {
                polyline.remove();
                this.f6316O = null;
            }
        } else if (f6298g == null) {
            C1255a.m10453b(f6294a, "No route line data");
        } else {
            EnumC1286d m10269V = m10269V();
            if (EnumC1286d.NO_NEED_RENDER == m10269V) {
                this.f6343z = false;
            } else if (EnumC1286d.UPDATE_TRAFFIC == m10269V) {
                this.f6343z = false;
                m10268W();
            } else {
                this.f6343z = true;
                if (!this.f6318Q) {
                    this.f6318Q = true;
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e) {
                        C1255a.m10456a(f6294a, "Exception caught when renderRouteLine", e);
                    }
                }
                f6300p = 0;
                this.f6336s = 0;
                this.f6313L = 0;
                this.f6334o.clear();
                this.f6314M.clear();
                this.f6315N.clear();
                this.f6317P.clear();
                Polyline polyline2 = this.f6316O;
                if (polyline2 != null) {
                    polyline2.remove();
                    this.f6316O = null;
                }
                m10267X();
                List<LinkPointPolyLineInfo> list = this.f6334o;
                if (list == null || list.isEmpty()) {
                    C1255a.m10453b(f6294a, "LinkPointPolyline info is null");
                } else {
                    m10266Y();
                }
            }
        }
    }

    /* renamed from: V */
    private EnumC1286d m10269V() {
        String m10444a = f6298g.m10431a().m10444a();
        String m10417a = f6298g.m10426b().m10417a();
        if (this.f6339v && !this.f6302A) {
            this.f6320S = null;
            this.f6321T = null;
        }
        if (m10444a != null && (TextUtils.isEmpty(this.f6320S) || !this.f6320S.equals(m10444a) || this.f6316O == null)) {
            this.f6320S = m10444a;
            this.f6321T = m10417a;
            C1255a.m10453b(f6294a, "Route line or order state changed or no render, need render");
            return EnumC1286d.RENDER_NEW_LINE;
        } else if (m10417a == null || this.f6316O == null || (!TextUtils.isEmpty(this.f6321T) && this.f6321T.equals(m10417a))) {
            return EnumC1286d.NO_NEED_RENDER;
        } else {
            this.f6321T = m10417a;
            C1255a.m10453b(f6294a, "Route line only need update traffic");
            return EnumC1286d.UPDATE_TRAFFIC;
        }
    }

    /* renamed from: W */
    private void m10268W() {
        int[] iArr;
        ArrayList<Integer> m10413b = f6298g.m10426b().m10413b();
        if (m10413b == null || m10413b.isEmpty()) {
            C1255a.m10453b(f6294a, "Traffic status data is null");
            return;
        }
        if (!this.f6318Q) {
            this.f6318Q = true;
        }
        if (f6300p - this.f6336s < 0) {
            return;
        }
        try {
            if (m10413b.size() == this.f6334o.size()) {
                for (int i = f6300p - this.f6336s; i < this.f6334o.size(); i++) {
                    this.f6317P.set(i, m10413b.get(i));
                }
            } else {
                for (int i2 = f6300p - this.f6336s; i2 < this.f6334o.size(); i2++) {
                    this.f6317P.set(i2, m10413b.get((m10413b.size() + i2) - this.f6334o.size()));
                }
            }
            iArr = new int[(this.f6317P.size() - f6300p) + this.f6336s];
            for (int i3 = 0; i3 < (this.f6317P.size() - f6300p) + this.f6336s; i3++) {
                iArr[i3] = this.f6317P.get((f6300p + i3) - this.f6336s).intValue();
            }
        } catch (Exception e) {
            C1255a.m10456a(f6294a, "Exception caught when updateTrafficStatus", e);
        }
        if (iArr.length <= 0) {
            return;
        }
        this.f6316O.setIndexs(iArr);
        if (this.f6318Q) {
            this.f6318Q = false;
        }
    }

    /* renamed from: X */
    private void m10267X() {
        if (f6298g == null || f6298g.m10431a() == null) {
            C1255a.m10453b(f6294a, "Route info or syncResponseResult is null");
            return;
        }
        List<RouteLineInfo.RouteSectionInfo> m10440b = f6298g.m10431a().m10440b();
        ArrayList<Integer> m10413b = f6298g.m10426b().m10413b();
        if (m10440b == null || m10440b.isEmpty()) {
            C1255a.m10453b(f6294a, "route section info is null");
        } else if (m10440b.isEmpty() || m10413b == null || m10413b.isEmpty() || m10413b.size() == m10440b.size()) {
            for (int i = 0; i < m10440b.size(); i++) {
                if (m10440b.get(i) != null) {
                    LatLng m10437a = m10440b.get(i).m10437a();
                    LatLng m10435b = m10440b.get(i).m10435b();
                    int m10259a = m10259a(i, m10413b);
                    LinkPointPolyLineInfo linkPointPolyLineInfo = new LinkPointPolyLineInfo();
                    linkPointPolyLineInfo.m10296a(m10437a);
                    linkPointPolyLineInfo.m10294b(m10435b);
                    linkPointPolyLineInfo.m10297a(m10259a);
                    this.f6334o.add(linkPointPolyLineInfo);
                    this.f6314M.add(m10437a);
                }
            }
            this.f6314M.add(m10440b.get(m10440b.size() - 1).m10435b());
        } else {
            C1255a.m10453b(f6294a, "route section info or traffic status info is invalid");
        }
    }

    /* renamed from: Y */
    private void m10266Y() {
        if (!this.f6318Q) {
            this.f6318Q = true;
        }
        LatLng point = (f6298g == null || f6298g.m10422c() == null) ? null : f6298g.m10422c().getPoint();
        LatLng m10256a = point != null ? m10256a(point) : null;
        if (m10256a != null) {
            this.f6336s = 0;
            try {
                this.f6334o = this.f6334o.subList(f6300p, this.f6334o.size());
                this.f6314M = this.f6314M.subList(f6300p, this.f6314M.size());
            } catch (Exception e) {
                C1255a.m10456a(f6294a, "Caught exception when renderRoutePolyLine", e);
            }
            m10221b(m10256a);
            m10233ag();
            m10209c(m10256a);
            this.f6313L = f6300p;
        }
        f6300p = 0;
        int size = this.f6314M.size();
        if (size < 3) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            if (this.f6314M.get(i) != null) {
                this.f6317P.add(Integer.valueOf(this.f6334o.get(i).m10293c()));
            }
        }
        if (this.f6315N.isEmpty()) {
            this.f6315N.addAll(f6296e.getTrafficTextureList());
        }
        DisplayOptions displayOptions = f6296e;
        if (displayOptions == null) {
            displayOptions = new DisplayOptions();
        }
        PolylineOptions zIndex = new PolylineOptions().points(this.f6314M).dottedLine(true).width(displayOptions.getRouteLineWidth()).customTextureList(this.f6315N).textureIndex(this.f6317P).zIndex(f6296e.getRouteLineZIndex());
        if (!f6296e.isShowRoutePlan()) {
            C1255a.m10453b(f6294a, "User set route line not display");
            zIndex.visible(false);
        }
        this.f6316O = (Polyline) this.f6326b.addOverlay(zIndex);
        if (this.f6318Q) {
            this.f6318Q = false;
        }
    }

    /* renamed from: Z */
    private void m10265Z() {
        List<LinkPointPolyLineInfo> list;
        if (this.f6332m == null) {
            C1255a.m10453b(f6294a, "CarMarker is null");
        } else if (f6301r != null || (list = this.f6334o) == null || list.isEmpty()) {
            m10239aa();
        } else {
            f6301r = this.f6334o.get(0).m10298a();
            m10221b(f6301r);
            m10209c(f6301r);
        }
    }

    /* renamed from: a */
    private double m10263a(double d) {
        if (this.f6338u == 0) {
            this.f6338u = 5;
        }
        double abs = Math.abs(d);
        double d2 = this.f6338u;
        Double.isNaN(d2);
        return (abs * d2) / this.f6337t;
    }

    /* renamed from: a */
    private double m10262a(double d, double d2) {
        return d2 == Double.MAX_VALUE ? d : Math.abs((d * d2) / Math.sqrt((d2 * d2) + 1.0d));
    }

    /* renamed from: a */
    private double m10261a(double d, LatLng latLng) {
        return latLng.latitude - (d * latLng.longitude);
    }

    /* renamed from: a */
    private int m10259a(int i, ArrayList<Integer> arrayList) {
        if (arrayList == null || arrayList.isEmpty() || i >= arrayList.size()) {
            return 0;
        }
        return arrayList.get(i).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public LatLng m10256a(LatLng latLng) {
        if (3 == f6299h) {
            C1255a.m10457a(f6294a, "WAIT_PASSENGER State, no need calculate");
            return null;
        }
        List<LinkPointPolyLineInfo> list = this.f6334o;
        if (list == null || list.isEmpty()) {
            String str = f6294a;
            C1255a.m10453b(str, "mLinkPolyLineInfos size = " + this.f6334o.size());
            return null;
        }
        for (int i = f6300p; i < this.f6334o.size(); i++) {
            LatLng m10298a = this.f6334o.get(i).m10298a();
            LatLng m10295b = this.f6334o.get(i).m10295b();
            if (!m10255a(latLng, m10298a)) {
                if (m10255a(latLng, m10295b)) {
                    this.f6336s = m10201d(i + 1);
                    return m10295b;
                }
                boolean m10253a = m10253a(m10298a, m10295b, latLng);
                boolean m10218b = m10218b(m10298a, m10295b, latLng);
                if (!m10253a || !m10218b) {
                }
            }
            this.f6336s = m10201d(i);
            return m10298a;
        }
        return null;
    }

    /* renamed from: a */
    private void m10252a(LatLngBounds.Builder builder) {
        DisplayOptions displayOptions = f6296e;
        if (displayOptions == null || displayOptions.isShowStartPositionMarkerInSpan()) {
            builder.include(m10281J());
        } else {
            C1255a.m10453b(f6294a, "User set not show startPositionMarker in span");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m10251a(LatLngBounds latLngBounds) {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.f6311J && !this.f6325X) {
            this.f6311J = false;
            return;
        }
        MapStatus mapStatus = this.f6326b.getMapStatus();
        if (mapStatus == null) {
            C1255a.m10453b(f6294a, "Get map status failed");
            return;
        }
        WinRound winRound = mapStatus.winRound;
        int abs = Math.abs(winRound.right - winRound.left);
        int abs2 = Math.abs(winRound.bottom - winRound.top);
        if (f6296e != null) {
            i = f6296e.getPaddingLeft();
            i2 = f6296e.getPaddingTop();
            i3 = f6296e.getPaddingRight();
            i4 = f6296e.getPaddingBottom();
        } else {
            i = 50;
            i2 = 50;
            i3 = 50;
            i4 = 50;
        }
        int i5 = (abs - i) - i3;
        int i6 = (abs2 - i2) - i4;
        if (i5 < 0 || i6 < 0 || i5 > abs || i6 > abs2) {
            C1255a.m10453b(f6294a, "Invalid width and height，use default padding");
            i5 = (abs - 50) - 50;
            i6 = (abs2 - 50) - 50;
        }
        this.f6326b.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(latLngBounds, i5, i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m10257a(MyLocationData myLocationData) {
        long j;
        long j2;
        try {
            j = Double.valueOf(myLocationData.latitude).longValue();
            try {
                j2 = Double.valueOf(myLocationData.longitude).longValue();
            } catch (NumberFormatException unused) {
                C1255a.m10453b(f6294a, "Trans latitude and longitude failed");
                j2 = 0;
                if (0 == j) {
                }
            }
        } catch (NumberFormatException unused2) {
            j = 0;
        }
        return (0 == j || 0 != j2) && j >= -90 && j <= 90 && j2 >= -180 && j2 <= 180;
    }

    /* renamed from: a */
    private boolean m10255a(LatLng latLng, LatLng latLng2) {
        return (latLng == null || latLng2 == null) ? latLng == null && latLng2 == null : Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-4d && Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-4d;
    }

    /* renamed from: a */
    private boolean m10254a(LatLng latLng, LatLng latLng2, double d) {
        double d2;
        LatLng latLng3;
        boolean z = latLng.latitude > latLng2.latitude;
        double m10261a = m10261a(d, latLng);
        double m10191f = m10191f(latLng, latLng2);
        double m10262a = z ? m10262a(m10191f, d) : m10262a(m10191f, d) * (-1.0d);
        double m10263a = m10263a(m10262a);
        double d3 = latLng.latitude;
        double d4 = m10262a;
        while (true) {
            if ((d3 > latLng2.latitude) != z) {
                return true;
            }
            if (this.f6318Q) {
                return false;
            }
            if (Double.MAX_VALUE == d) {
                d2 = m10263a;
                latLng3 = new LatLng(d3, latLng.longitude);
            } else {
                d2 = m10263a;
                latLng3 = new LatLng(d3, (d3 - m10261a) / d);
            }
            m10221b(latLng3);
            m10209c(latLng3);
            double d5 = d2;
            if (!m10223b(d5)) {
                return false;
            }
            d3 -= d4;
            m10263a = d5;
        }
    }

    /* renamed from: a */
    private boolean m10253a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.latitude;
        double d2 = latLng.longitude;
        double d3 = latLng2.latitude;
        return Math.abs(((latLng3.latitude - d) * (latLng2.longitude - d2)) - ((d3 - d) * (latLng3.longitude - d2))) < 1.0E-4d;
    }

    /* renamed from: aa */
    private synchronized void m10239aa() {
        if (this.f6335q == null) {
            return;
        }
        this.f6318Q = false;
        if (Thread.State.NEW == this.f6335q.getState()) {
            this.f6335q.start();
            return;
        }
        if (Thread.State.TERMINATED == this.f6335q.getState()) {
            this.f6335q = null;
            this.f6335q = new Thread(new RunnableC1284b(), "Car moving");
            this.f6335q.start();
        }
    }

    /* renamed from: ab */
    private synchronized void m10238ab() {
        this.f6318Q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ac */
    public LatLng m10237ac() {
        if (f6298g == null || f6298g.m10422c() == null || f6298g.m10422c().getPoint() == null || this.f6323V) {
            return null;
        }
        return f6298g.m10422c().getPoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ad */
    public double m10236ad() {
        List<LinkPointPolyLineInfo> list = this.f6334o;
        if (list == null || list.isEmpty() || f6300p > this.f6334o.size()) {
            return 1.0d;
        }
        double d = 0.0d;
        for (int i = f6300p - this.f6336s; i < f6300p; i++) {
            d += m10191f(this.f6334o.get(i).m10298a(), this.f6334o.get(i).m10295b());
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ae */
    public void m10235ae() {
        if (f6300p == 0) {
            return;
        }
        for (int i = f6300p - this.f6336s; i < f6300p; i++) {
            LatLng m10298a = this.f6334o.get(i).m10298a();
            LatLng m10295b = this.f6334o.get(i).m10295b();
            double m10191f = m10191f(m10298a, m10295b) / 2.0d;
            double d = (m10295b.latitude - m10298a.latitude) / m10191f;
            double d2 = (m10295b.longitude - m10298a.longitude) / m10191f;
            double m10195e = m10195e(m10298a, m10295b);
            LatLng latLng = m10298a;
            int i2 = 1;
            while (i2 <= m10191f) {
                double d3 = latLng.longitude;
                double d4 = m10191f;
                double d5 = latLng.latitude;
                if (0.0d == m10195e) {
                    d3 = latLng.longitude + d2;
                } else {
                    if (Double.MAX_VALUE != m10195e) {
                        d3 = latLng.longitude + d2;
                    }
                    d5 = latLng.latitude + d;
                }
                LatLng latLng2 = new LatLng(d5, d3);
                List<LatLng> list = this.f6314M;
                if (list != null && !list.isEmpty()) {
                    if (this.f6343z) {
                        this.f6318Q = true;
                        return;
                    }
                    this.f6314M.set(i, latLng2);
                }
                List<Integer> list2 = this.f6317P;
                if (list2 != null && !list2.isEmpty()) {
                    this.f6317P.set(i, Integer.valueOf(this.f6334o.get(i).m10293c()));
                }
                if (!m10220b(latLng, latLng2)) {
                    return;
                }
                this.f6313L = i;
                m10196e(i);
                i2++;
                latLng = latLng2;
                m10191f = d4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: af */
    public void m10234af() {
        f6300p = 0;
        this.f6336s = 0;
        this.f6334o.clear();
        this.f6314M.clear();
        this.f6317P.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ag */
    public void m10233ag() {
        if (this.f6332m == null) {
            return;
        }
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        try {
            f = Double.valueOf(360.0d - f6298g.m10422c().getAngle()).floatValue();
        } catch (NumberFormatException e) {
            C1255a.m10456a(f6294a, "Get DriverPosition Angle failed", e);
        }
        this.f6332m.setRotate(f);
    }

    /* renamed from: ah */
    private synchronized void m10232ah() {
        this.f6304C = true;
    }

    /* renamed from: ai */
    private synchronized void m10231ai() {
        if (this.f6303B == null) {
            return;
        }
        if (this.f6304C) {
            this.f6304C = false;
        }
        if (Thread.State.NEW == this.f6303B.getState()) {
            this.f6310I = true;
            this.f6303B.start();
        }
        if (this.f6339v && Thread.State.TIMED_WAITING == this.f6303B.getState()) {
            this.f6303B.interrupt();
            this.f6310I = true;
        }
        if (Thread.State.TERMINATED == this.f6303B.getState()) {
            this.f6303B = null;
            this.f6310I = true;
            this.f6303B = new Thread(new RunnableC1283a(), "Adjust visible span");
            this.f6303B.start();
        }
    }

    /* renamed from: aj */
    private void m10230aj() {
        this.f6326b.setOnSynchronizationListener(this.f6308G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ak */
    public void m10229ak() {
        switch (f6299h) {
            case 0:
            case 5:
                m10232ah();
                return;
            case 1:
                m10228al();
                return;
            case 2:
                m10227am();
                return;
            case 3:
                m10226an();
                return;
            case 4:
                m10225ao();
                return;
            default:
                return;
        }
    }

    /* renamed from: al */
    private void m10228al() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        m10252a(builder);
        m10199d(builder);
        m10207c(builder);
        m10194e(builder);
        this.f6307F = m10184h(builder);
    }

    /* renamed from: am */
    private void m10227am() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        m10252a(builder);
        m10207c(builder);
        m10199d(builder);
        m10194e(builder);
        this.f6307F = m10184h(builder);
    }

    /* renamed from: an */
    private void m10226an() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        m10252a(builder);
        m10207c(builder);
        m10199d(builder);
        this.f6307F = m10184h(builder);
    }

    /* renamed from: ao */
    private void m10225ao() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        m10217b(builder);
        m10207c(builder);
        m10194e(builder);
        this.f6307F = m10184h(builder);
    }

    /* renamed from: b */
    private double m10219b(LatLng latLng, LatLng latLng2, double d) {
        if (Double.MAX_VALUE == d) {
            return latLng2.latitude > latLng.latitude ? 360.0d : 180.0d;
        }
        if (0.0d == d) {
            return latLng2.longitude > latLng.longitude ? 270.0d : 90.0d;
        }
        return (((Math.atan(d) / 3.141592653589793d) * 180.0d) + ((latLng2.latitude - latLng.latitude) * d < 0.0d ? 180.0d : 0.0d)) - 90.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10221b(LatLng latLng) {
        Marker marker = this.f6332m;
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    /* renamed from: b */
    private void m10217b(LatLngBounds.Builder builder) {
        DisplayOptions displayOptions = f6296e;
        if (displayOptions == null || displayOptions.isShowEndPositionMarkerInSpan()) {
            builder.include(f6295d.getEndPosition());
        } else {
            C1255a.m10453b(f6294a, "User set not show endPositionMarker in span");
        }
    }

    /* renamed from: b */
    private boolean m10223b(double d) {
        try {
            Thread.sleep(Double.valueOf((d * 1000.0d) + 50.0d).longValue());
            return true;
        } catch (InterruptedException unused) {
            return false;
        } catch (NumberFormatException e) {
            C1255a.m10456a(f6294a, "Calc sleep interval failed", e);
            return false;
        }
    }

    /* renamed from: b */
    private boolean m10220b(LatLng latLng, LatLng latLng2) {
        if (this.f6318Q) {
            return false;
        }
        m10221b(latLng);
        m10209c(latLng);
        double m10195e = m10195e(latLng, latLng2);
        float m10219b = (float) m10219b(latLng, latLng2, m10195e);
        Marker marker = this.f6332m;
        if (marker != null) {
            marker.setRotate(m10219b);
        }
        boolean m10208c = 0.0d == m10195e ? m10208c(latLng, latLng2) : m10254a(latLng, latLng2, m10195e);
        if (m10208c) {
            f6301r = latLng2;
        }
        return m10208c;
    }

    /* renamed from: b */
    private boolean m10218b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d = latLng.latitude;
        double d2 = latLng.longitude;
        double d3 = latLng2.latitude;
        double d4 = latLng2.longitude;
        double d5 = latLng3.latitude;
        double d6 = latLng3.longitude;
        return Math.min(d, d3) - 1.0E-4d <= d5 && d5 <= Math.max(d, d3) + 1.0E-4d && Math.min(d2, d4) - 1.0E-4d <= d6 && d6 <= Math.max(d2, d4) + 1.0E-4d;
    }

    /* renamed from: c */
    static /* synthetic */ int m10206c(HandlerC1281a handlerC1281a) {
        int i = handlerC1281a.f6324W;
        handlerC1281a.f6324W = i + 1;
        return i;
    }

    /* renamed from: c */
    private void m10210c(int i) {
        this.f6342y = 1000 == f6299h;
        this.f6302A = (1 == f6299h && 2 == i) || (1 == i && 2 == f6299h);
        if (f6299h == i) {
            this.f6339v = false;
            return;
        }
        f6299h = i;
        this.f6339v = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10209c(LatLng latLng) {
        Marker marker = f6297f;
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    /* renamed from: c */
    private void m10207c(LatLngBounds.Builder builder) {
        DisplayOptions displayOptions = f6296e;
        if (displayOptions != null && !displayOptions.isShowCarMarkerInSpan()) {
            C1255a.m10453b(f6294a, "User set not show carMarker in span");
            return;
        }
        Marker marker = this.f6332m;
        builder.include((marker == null || this.f6310I) ? m10271T() : marker.getPosition());
    }

    /* renamed from: c */
    private boolean m10208c(LatLng latLng, LatLng latLng2) {
        double m10200d = m10200d(latLng, latLng2);
        double m10263a = m10263a(m10200d);
        for (double d = latLng.longitude; d <= latLng2.longitude; d += m10200d) {
            if (this.f6318Q) {
                return false;
            }
            LatLng latLng3 = new LatLng(latLng.latitude, d);
            m10221b(latLng3);
            m10209c(latLng3);
            if (!m10223b(m10263a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private double m10200d(LatLng latLng, LatLng latLng2) {
        return C1256b.m10451a(latLng, latLng2);
    }

    /* renamed from: d */
    private synchronized int m10201d(int i) {
        int i2;
        i2 = i - f6300p;
        f6300p = i;
        return i2;
    }

    /* renamed from: d */
    private void m10199d(LatLngBounds.Builder builder) {
        LatLng position;
        String str;
        String str2;
        DisplayOptions displayOptions = f6296e;
        if (displayOptions == null || displayOptions.isShowPassengerIconInSpan()) {
            Marker marker = this.f6333n;
            if (marker == null) {
                MyLocationData locationData = this.f6326b.getLocationData();
                if (locationData == null) {
                    str = f6294a;
                    str2 = "No passenger location data";
                } else if (!m10257a(locationData)) {
                    return;
                } else {
                    position = new LatLng(locationData.latitude, locationData.longitude);
                }
            } else {
                position = marker.getPosition();
            }
            builder.include(position);
            return;
        }
        str = f6294a;
        str2 = "User set not show passengerMarker in span";
        C1255a.m10453b(str, str2);
    }

    /* renamed from: e */
    private double m10195e(LatLng latLng, LatLng latLng2) {
        if (latLng2.longitude == latLng.longitude) {
            return Double.MAX_VALUE;
        }
        return (latLng2.latitude - latLng.latitude) / (latLng2.longitude - latLng.longitude);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m10196e(int i) {
        int[] iArr;
        List<LatLng> list = this.f6314M;
        if (list == null || list.isEmpty()) {
            C1255a.m10453b(f6294a, "Route polyline points is null when remove");
        } else if (this.f6314M.size() <= 2 || i >= this.f6314M.size() - 2) {
            Polyline polyline = this.f6316O;
            if (polyline != null) {
                polyline.remove();
            }
        } else {
            List<Integer> list2 = this.f6317P;
            if (list2 == null || list2.isEmpty()) {
                C1255a.m10453b(f6294a, "No need removeTravelledPolyLine");
            } else if (!this.f6343z) {
                try {
                    List<Integer> list3 = this.f6317P;
                    List<Integer> subList = list3.subList(i, list3.size());
                    iArr = new int[subList.size()];
                    for (int i2 = 0; i2 < subList.size(); i2++) {
                        iArr[i2] = subList.get(i2).intValue();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.f6316O != null && !this.f6318Q) {
                    this.f6316O.setIndexs(iArr);
                    try {
                        List<LatLng> list4 = this.f6314M;
                        this.f6316O.setPoints(list4.subList(i, list4.size()));
                    } catch (Exception e2) {
                        C1255a.m10456a(f6294a, "Get subList of PolyLinePointList failed", e2);
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private void m10194e(LatLngBounds.Builder builder) {
        DisplayOptions displayOptions = f6296e;
        if (displayOptions != null && !displayOptions.isShowRoutePlanInSpan()) {
            C1255a.m10453b(f6294a, "User set not show routeLine in span");
            return;
        }
        List<LinkPointPolyLineInfo> list = this.f6334o;
        if (list == null || list.isEmpty()) {
            m10187g(builder);
        } else {
            m10190f(builder);
        }
    }

    /* renamed from: f */
    private double m10191f(LatLng latLng, LatLng latLng2) {
        return C1256b.m10451a(latLng, latLng2);
    }

    /* renamed from: f */
    private void m10190f(LatLngBounds.Builder builder) {
        for (int i = this.f6313L; i < this.f6334o.size(); i++) {
            builder.include(this.f6334o.get(i).m10298a());
        }
        List<LinkPointPolyLineInfo> list = this.f6334o;
        builder.include(list.get(list.size() - 1).m10295b());
    }

    /* renamed from: g */
    private void m10187g(LatLngBounds.Builder builder) {
        if (f6298g == null || f6298g.m10431a() == null) {
            C1255a.m10453b(f6294a, "There no routeLine info, no need show in span");
            return;
        }
        List<RouteLineInfo.RouteSectionInfo> m10440b = f6298g.m10431a().m10440b();
        if (m10440b == null || m10440b.isEmpty()) {
            C1255a.m10453b(f6294a, "There no routeLine position, no need show in span");
            return;
        }
        for (int i = 0; i < m10440b.size(); i++) {
            builder.include(m10440b.get(i).m10437a());
        }
        builder.include(m10440b.get(m10440b.size() - 1).m10435b());
    }

    /* renamed from: h */
    private LatLngBounds m10184h(LatLngBounds.Builder builder) {
        return builder.build();
    }

    /* renamed from: o */
    private void m10170o() {
        if (f6296e == null) {
            return;
        }
        Marker marker = f6297f;
        if (marker != null) {
            marker.remove();
            f6297f = null;
        }
        Marker marker2 = this.f6332m;
        if (marker2 != null) {
            marker2.remove();
            this.f6332m = null;
        }
        Marker marker3 = this.f6328i;
        if (marker3 != null) {
            marker3.remove();
            this.f6328i = null;
        }
        Marker marker4 = this.f6329j;
        if (marker4 != null) {
            marker4.remove();
            this.f6329j = null;
        }
        Marker marker5 = this.f6331l;
        if (marker5 != null) {
            marker5.remove();
            this.f6331l = null;
        }
        f6296e.getStartPositionIcon().recycle();
        f6296e.getCarIcon().recycle();
        if (f6296e.getEndPositionIcon() != null) {
            f6296e.getEndPositionIcon().recycle();
        }
        f6296e = null;
    }

    /* renamed from: p */
    private void m10168p() {
        f6300p = 0;
        this.f6338u = 0;
        this.f6318Q = true;
        Thread thread = this.f6335q;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException unused) {
                C1255a.m10453b(f6294a, "InterruptedException when release CarMoveThread");
            }
            this.f6335q = null;
        }
    }

    /* renamed from: q */
    private void m10166q() {
        this.f6340w = true;
        if (this.f6341x != null) {
            this.f6341x = null;
        }
    }

    /* renamed from: r */
    private void m10164r() {
        this.f6304C = true;
        if (this.f6303B != null) {
            this.f6303B = null;
        }
    }

    /* renamed from: s */
    private void m10162s() {
        f6295d = null;
        f6298g = null;
        f6299h = 1000;
        this.f6318Q = false;
        this.f6322U = true;
        this.f6323V = false;
        this.f6334o.clear();
        f6300p = 0;
        f6301r = null;
        this.f6336s = 0;
        this.f6337t = 0.0d;
        this.f6314M.clear();
        this.f6317P.clear();
        Polyline polyline = this.f6316O;
        if (polyline != null) {
            polyline.remove();
            this.f6316O = null;
        }
        for (int i = 0; i < this.f6315N.size(); i++) {
            this.f6315N.get(i).recycle();
        }
        this.f6315N.clear();
        this.f6326b.clear();
    }

    /* renamed from: t */
    private void m10160t() {
        m10275P();
        m10283H();
        m10232ah();
        m10286E();
        m10290A();
        m10289B();
        m10288C();
        m10287D();
        BaiduMap baiduMap = this.f6326b;
        if (baiduMap != null) {
            baiduMap.clear();
        }
    }

    /* renamed from: u */
    private void m10158u() {
        if (m10148z()) {
            m10286E();
            m10283H();
            m10231ai();
            m10282I();
            m10280K();
            m10279L();
            m10278M();
            m10276O();
            m10274Q();
            m10273R();
            m10270U();
            m10265Z();
        }
    }

    /* renamed from: v */
    private void m10156v() {
        if (m10148z()) {
            m10286E();
            m10283H();
            m10231ai();
            m10282I();
            m10280K();
            m10279L();
            m10278M();
            m10276O();
            m10274Q();
            m10273R();
            m10270U();
            m10265Z();
        }
    }

    /* renamed from: w */
    private void m10154w() {
        if (m10148z()) {
            m10286E();
            m10284G();
            m10285F();
            m10283H();
            m10231ai();
            m10282I();
            m10280K();
            m10279L();
            m10278M();
            m10276O();
            m10274Q();
            m10273R();
            m10265Z();
        }
    }

    /* renamed from: x */
    private void m10152x() {
        if (m10148z()) {
            m10275P();
            m10286E();
            m10289B();
            m10288C();
            m10283H();
            m10231ai();
            m10282I();
            m10280K();
            m10279L();
            m10278M();
            m10274Q();
            m10273R();
            m10270U();
            m10265Z();
        }
    }

    /* renamed from: y */
    private void m10150y() {
        m10275P();
        m10283H();
        m10232ah();
        m10290A();
        m10289B();
        m10288C();
        m10287D();
        BaiduMap baiduMap = this.f6326b;
        if (baiduMap != null) {
            baiduMap.clear();
        }
    }

    /* renamed from: z */
    private boolean m10148z() {
        if (f6295d == null || f6296e == null) {
            C1255a.m10453b(f6294a, "No render data");
            InterfaceC1288b interfaceC1288b = this.f6327c;
            if (interfaceC1288b != null) {
                interfaceC1288b.mo10146a(100001, "Get render data failed");
            }
            return false;
        } else if (this.f6326b == null) {
            C1255a.m10453b(f6294a, "BaiduMap is null");
            InterfaceC1288b interfaceC1288b2 = this.f6327c;
            if (interfaceC1288b2 != null) {
                interfaceC1288b2.mo10146a(100002, "BaiduMap instance is null.");
            }
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Marker m10264a() {
        return this.f6328i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10260a(int i) {
        this.f6305D = i;
    }

    /* renamed from: a */
    public void m10258a(BaiduMap baiduMap, RoleOptions roleOptions, DisplayOptions displayOptions) {
        this.f6326b = baiduMap;
        f6295d = roleOptions;
        f6296e = displayOptions;
        this.f6308G = new C1287e();
        m10230aj();
        f6301r = null;
        this.f6326b.getUiSettings().setRotateGesturesEnabled(false);
        this.f6326b.getUiSettings().setCompassEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m10250a(RoleOptions roleOptions, DisplayOptions displayOptions, SyncResponseResult syncResponseResult, int i) {
        f6295d = roleOptions;
        f6296e = displayOptions;
        if (displayOptions == null) {
            f6296e = new DisplayOptions();
        }
        f6298g = syncResponseResult;
        this.f6338u = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10240a(InterfaceC1288b interfaceC1288b) {
        this.f6327c = interfaceC1288b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Marker m10224b() {
        return this.f6330k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10222b(int i) {
        this.f6306E = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public Marker m10211c() {
        return this.f6332m;
    }

    /* renamed from: d */
    public void m10202d() {
        this.f6323V = false;
        if (this.f6322U) {
            this.f6322U = false;
            return;
        }
        m10277N();
        m10231ai();
        m10239aa();
    }

    /* renamed from: e */
    public void m10197e() {
        this.f6323V = true;
        m10238ab();
        m10275P();
        m10232ah();
    }

    /* renamed from: f */
    public void m10192f() {
        m10168p();
        m10166q();
        m10164r();
        m10170o();
        m10162s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m10188g() {
        this.f6325X = true;
        m10229ak();
        m10251a(this.f6307F);
        this.f6325X = false;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message2) {
        String str = f6294a;
        C1255a.m10452c(str, "The orderState in message is: " + message2.what);
        m10210c(message2.what);
        switch (message2.what) {
            case 0:
                m10160t();
                return;
            case 1:
                m10158u();
                return;
            case 2:
                m10156v();
                return;
            case 3:
                m10154w();
                return;
            case 4:
                m10152x();
                return;
            case 5:
                m10150y();
                return;
            default:
                String str2 = f6294a;
                C1255a.m10452c(str2, "Undefined Message type: " + message2.what);
                return;
        }
    }
}
