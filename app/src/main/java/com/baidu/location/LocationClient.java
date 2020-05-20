package com.baidu.location;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.location.p078a.C0896c;
import com.baidu.location.p078a.C0910h;
import com.baidu.location.p078a.C0911i;
import com.baidu.location.p080c.C0952a;
import com.unionpay.tsmservice.p373mi.data.Constant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class LocationClient implements C0896c.InterfaceC0897a {
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;

    /* renamed from: A */
    private Boolean f3814A;

    /* renamed from: B */
    private Boolean f3815B;

    /* renamed from: C */
    private Boolean f3816C;

    /* renamed from: D */
    private boolean f3817D;

    /* renamed from: E */
    private C0896c f3818E;

    /* renamed from: F */
    private boolean f3819F;

    /* renamed from: G */
    private boolean f3820G;

    /* renamed from: H */
    private boolean f3821H;

    /* renamed from: I */
    private ServiceConnection f3822I;

    /* renamed from: a */
    private long f3823a;

    /* renamed from: b */
    private String f3824b;

    /* renamed from: c */
    private LocationClientOption f3825c;

    /* renamed from: d */
    private LocationClientOption f3826d;

    /* renamed from: e */
    private boolean f3827e;

    /* renamed from: f */
    private Context f3828f;

    /* renamed from: g */
    private Messenger f3829g;

    /* renamed from: h */
    private HandlerC0888a f3830h;

    /* renamed from: i */
    private final Messenger f3831i;

    /* renamed from: j */
    private ArrayList<BDLocationListener> f3832j;

    /* renamed from: k */
    private ArrayList<BDAbstractLocationListener> f3833k;

    /* renamed from: l */
    private BDLocation f3834l;

    /* renamed from: m */
    private boolean f3835m;

    /* renamed from: n */
    private boolean f3836n;

    /* renamed from: o */
    private boolean f3837o;

    /* renamed from: p */
    private RunnableC0889b f3838p;

    /* renamed from: q */
    private boolean f3839q;

    /* renamed from: r */
    private final Object f3840r;

    /* renamed from: s */
    private long f3841s;

    /* renamed from: t */
    private long f3842t;

    /* renamed from: u */
    private C0952a f3843u;

    /* renamed from: v */
    private BDLocationListener f3844v;

    /* renamed from: w */
    private String f3845w;

    /* renamed from: x */
    private String f3846x;

    /* renamed from: y */
    private boolean f3847y;

    /* renamed from: z */
    private boolean f3848z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.LocationClient$a */
    /* loaded from: classes.dex */
    public static class HandlerC0888a extends Handler {

        /* renamed from: a */
        private final WeakReference<LocationClient> f3851a;

        HandlerC0888a(Looper looper, LocationClient locationClient) {
            super(looper);
            this.f3851a = new WeakReference<>(locationClient);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            LocationClient locationClient = this.f3851a.get();
            if (locationClient == null) {
                return;
            }
            int i = message2.what;
            if (i == 21) {
                Bundle data = message2.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                if (!locationClient.f3820G && locationClient.f3819F && bDLocation.getLocType() == 66) {
                    return;
                }
                if (!locationClient.f3820G && locationClient.f3819F) {
                    locationClient.f3820G = true;
                    return;
                }
                if (!locationClient.f3820G) {
                    locationClient.f3820G = true;
                }
                locationClient.m12322a(message2, 21);
            } else if (i == 303) {
                try {
                    Bundle data2 = message2.getData();
                    int i2 = data2.getInt("loctype");
                    int i3 = data2.getInt("diagtype");
                    byte[] byteArray = data2.getByteArray("diagmessage");
                    if (i2 <= 0 || i3 <= 0 || byteArray == null || locationClient.f3833k == null) {
                        return;
                    }
                    Iterator it = locationClient.f3833k.iterator();
                    while (it.hasNext()) {
                        ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i2, i3, new String(byteArray, "UTF-8"));
                    }
                } catch (Exception unused) {
                }
            } else if (i == 406) {
                try {
                    Bundle data3 = message2.getData();
                    byte[] byteArray2 = data3.getByteArray(Constant.KEY_MAC);
                    String str = byteArray2 != null ? new String(byteArray2, "UTF-8") : null;
                    int i4 = data3.getInt("hotspot", -1);
                    if (locationClient.f3833k != null) {
                        Iterator it2 = locationClient.f3833k.iterator();
                        while (it2.hasNext()) {
                            ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i4);
                        }
                    }
                } catch (Exception unused2) {
                }
            } else if (i == 701) {
                locationClient.m12321a((BDLocation) message2.obj);
            } else if (i == 1300) {
                locationClient.m12288f(message2);
            } else if (i == 1400) {
                locationClient.m12285g(message2);
            } else {
                switch (i) {
                    case 1:
                        locationClient.m12310b();
                        return;
                    case 2:
                        locationClient.m12304c();
                        return;
                    case 3:
                        locationClient.m12303c(message2);
                        return;
                    case 4:
                        locationClient.m12289f();
                        return;
                    case 5:
                        locationClient.m12293e(message2);
                        return;
                    case 6:
                        locationClient.m12282h(message2);
                        return;
                    case 7:
                        return;
                    case 8:
                        locationClient.m12298d(message2);
                        return;
                    case 9:
                        locationClient.m12323a(message2);
                        return;
                    case 10:
                        locationClient.m12308b(message2);
                        return;
                    case 11:
                        locationClient.m12294e();
                        return;
                    case 12:
                        locationClient.m12326a();
                        return;
                    default:
                        switch (i) {
                            case 26:
                                locationClient.m12322a(message2, 26);
                                return;
                            case 27:
                                locationClient.m12279i(message2);
                                return;
                            default:
                                switch (i) {
                                    case 54:
                                        if (locationClient.f3825c.location_change_notify) {
                                            locationClient.f3839q = true;
                                            return;
                                        }
                                        return;
                                    case 55:
                                        if (locationClient.f3825c.location_change_notify) {
                                            locationClient.f3839q = false;
                                            return;
                                        }
                                        return;
                                    default:
                                        switch (i) {
                                            case 703:
                                                try {
                                                    Bundle data4 = message2.getData();
                                                    int i5 = data4.getInt("id", 0);
                                                    if (i5 > 0) {
                                                        locationClient.m12324a(i5, (Notification) data4.getParcelable("notification"));
                                                        return;
                                                    }
                                                    return;
                                                } catch (Exception unused3) {
                                                    return;
                                                }
                                            case 704:
                                                try {
                                                    locationClient.m12311a(message2.getData().getBoolean("removenotify"));
                                                    return;
                                                } catch (Exception unused4) {
                                                    return;
                                                }
                                            default:
                                                super.handleMessage(message2);
                                                return;
                                        }
                                }
                        }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.LocationClient$b */
    /* loaded from: classes.dex */
    public class RunnableC0889b implements Runnable {
        private RunnableC0889b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.f3840r) {
                LocationClient.this.f3837o = false;
                if (LocationClient.this.f3829g != null && LocationClient.this.f3831i != null) {
                    if ((LocationClient.this.f3832j != null && LocationClient.this.f3832j.size() > 0) || (LocationClient.this.f3833k != null && LocationClient.this.f3833k.size() > 0)) {
                        if (!LocationClient.this.f3836n) {
                            LocationClient.this.f3830h.obtainMessage(4).sendToTarget();
                            return;
                        }
                        if (LocationClient.this.f3838p == null) {
                            LocationClient.this.f3838p = new RunnableC0889b();
                        }
                        LocationClient.this.f3830h.postDelayed(LocationClient.this.f3838p, LocationClient.this.f3825c.scanSpan);
                    }
                }
            }
        }
    }

    public LocationClient(Context context) {
        this.f3823a = 0L;
        this.f3824b = null;
        this.f3825c = new LocationClientOption();
        this.f3826d = new LocationClientOption();
        this.f3827e = false;
        this.f3828f = null;
        this.f3829g = null;
        this.f3832j = null;
        this.f3833k = null;
        this.f3834l = null;
        this.f3835m = false;
        this.f3836n = false;
        this.f3837o = false;
        this.f3838p = null;
        this.f3839q = false;
        this.f3840r = new Object();
        this.f3841s = 0L;
        this.f3842t = 0L;
        this.f3843u = null;
        this.f3844v = null;
        this.f3845w = null;
        this.f3847y = false;
        this.f3848z = true;
        this.f3814A = Boolean.FALSE;
        this.f3815B = Boolean.FALSE;
        this.f3816C = Boolean.TRUE;
        this.f3818E = null;
        this.f3819F = false;
        this.f3820G = false;
        this.f3821H = false;
        this.f3822I = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LocationClient.this.f3829g = new Messenger(iBinder);
                if (LocationClient.this.f3829g == null) {
                    return;
                }
                LocationClient.this.f3827e = true;
                Log.d("baidu_location_client", "baidu location connected ...");
                if (LocationClient.this.f3848z) {
                    LocationClient.this.f3830h.obtainMessage(2).sendToTarget();
                    return;
                }
                try {
                    Message obtain = Message.obtain((Handler) null, 11);
                    obtain.replyTo = LocationClient.this.f3831i;
                    obtain.setData(LocationClient.this.m12299d());
                    LocationClient.this.f3829g.send(obtain);
                    LocationClient.this.f3827e = true;
                    if (LocationClient.this.f3825c != null) {
                        LocationClient.this.f3816C.booleanValue();
                        LocationClient.this.f3830h.obtainMessage(4).sendToTarget();
                    }
                } catch (Exception unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                LocationClient.this.f3829g = null;
                LocationClient.this.f3827e = false;
            }
        };
        this.f3828f = context;
        this.f3825c = new LocationClientOption();
        this.f3830h = new HandlerC0888a(Looper.getMainLooper(), this);
        this.f3831i = new Messenger(this.f3830h);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.f3823a = 0L;
        this.f3824b = null;
        this.f3825c = new LocationClientOption();
        this.f3826d = new LocationClientOption();
        this.f3827e = false;
        this.f3828f = null;
        this.f3829g = null;
        this.f3832j = null;
        this.f3833k = null;
        this.f3834l = null;
        this.f3835m = false;
        this.f3836n = false;
        this.f3837o = false;
        this.f3838p = null;
        this.f3839q = false;
        this.f3840r = new Object();
        this.f3841s = 0L;
        this.f3842t = 0L;
        this.f3843u = null;
        this.f3844v = null;
        this.f3845w = null;
        this.f3847y = false;
        this.f3848z = true;
        this.f3814A = Boolean.FALSE;
        this.f3815B = Boolean.FALSE;
        this.f3816C = Boolean.TRUE;
        this.f3818E = null;
        this.f3819F = false;
        this.f3820G = false;
        this.f3821H = false;
        this.f3822I = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LocationClient.this.f3829g = new Messenger(iBinder);
                if (LocationClient.this.f3829g == null) {
                    return;
                }
                LocationClient.this.f3827e = true;
                Log.d("baidu_location_client", "baidu location connected ...");
                if (LocationClient.this.f3848z) {
                    LocationClient.this.f3830h.obtainMessage(2).sendToTarget();
                    return;
                }
                try {
                    Message obtain = Message.obtain((Handler) null, 11);
                    obtain.replyTo = LocationClient.this.f3831i;
                    obtain.setData(LocationClient.this.m12299d());
                    LocationClient.this.f3829g.send(obtain);
                    LocationClient.this.f3827e = true;
                    if (LocationClient.this.f3825c != null) {
                        LocationClient.this.f3816C.booleanValue();
                        LocationClient.this.f3830h.obtainMessage(4).sendToTarget();
                    }
                } catch (Exception unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                LocationClient.this.f3829g = null;
                LocationClient.this.f3827e = false;
            }
        };
        this.f3828f = context;
        this.f3825c = locationClientOption;
        this.f3826d = new LocationClientOption(locationClientOption);
        this.f3830h = new HandlerC0888a(Looper.getMainLooper(), this);
        this.f3831i = new Messenger(this.f3830h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12326a() {
        Message obtain = Message.obtain((Handler) null, 28);
        try {
            obtain.replyTo = this.f3831i;
            this.f3829g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12324a(int i, Notification notification) {
        try {
            Intent intent = new Intent(this.f3828f, ServiceC1002f.class);
            intent.putExtra("notification", notification);
            intent.putExtra("id", i);
            intent.putExtra("command", 1);
            if (Build.VERSION.SDK_INT >= 26) {
                this.f3828f.startForegroundService(intent);
            } else {
                this.f3828f.startService(intent);
            }
            this.f3821H = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12323a(Message message2) {
        if (message2 == null || message2.obj == null) {
            return;
        }
        BDNotifyListener bDNotifyListener = (BDNotifyListener) message2.obj;
        if (this.f3843u == null) {
            this.f3843u = new C0952a(this.f3828f, this);
        }
        this.f3843u.m11946a(bDNotifyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12322a(Message message2, int i) {
        if (this.f3827e) {
            try {
                Bundle data = message2.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                this.f3834l = (BDLocation) data.getParcelable("locStr");
                if (this.f3834l.getLocType() == 61) {
                    this.f3841s = System.currentTimeMillis();
                }
                m12309b(i);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12321a(BDLocation bDLocation) {
        if (this.f3848z) {
            return;
        }
        this.f3834l = bDLocation;
        if (!this.f3820G && bDLocation.getLocType() == 161) {
            this.f3819F = true;
        }
        ArrayList<BDLocationListener> arrayList = this.f3832j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.f3833k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12311a(boolean z) {
        try {
            Intent intent = new Intent(this.f3828f, ServiceC1002f.class);
            intent.putExtra("removenotify", z);
            intent.putExtra("command", 2);
            this.f3828f.startService(intent);
            this.f3821H = true;
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private boolean m12325a(int i) {
        if (this.f3829g != null && this.f3827e) {
            try {
                this.f3829g.send(Message.obtain((Handler) null, i));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.location.LocationClient$2] */
    /* renamed from: b */
    public void m12310b() {
        if (this.f3827e) {
            return;
        }
        if (this.f3816C.booleanValue()) {
            new Thread() { // from class: com.baidu.location.LocationClient.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (LocationClient.this.f3818E == null) {
                        LocationClient locationClient = LocationClient.this;
                        locationClient.f3818E = new C0896c(locationClient.f3828f, LocationClient.this.f3826d, LocationClient.this);
                    }
                    LocationClient.this.f3818E.m12218c();
                }
            }.start();
            this.f3816C = Boolean.FALSE;
        }
        this.f3824b = this.f3828f.getPackageName();
        this.f3845w = this.f3824b + "_bdls_v2.9";
        Intent intent = new Intent(this.f3828f, ServiceC1002f.class);
        try {
            intent.putExtra("debug_dev", this.f3817D);
        } catch (Exception unused) {
        }
        if (this.f3825c == null) {
            this.f3825c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.f3825c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.f3825c.isIgnoreKillProcess);
        try {
            this.f3828f.bindService(intent, this.f3822I, 1);
        } catch (Exception e) {
            e.printStackTrace();
            this.f3827e = false;
        }
    }

    /* renamed from: b */
    private void m12309b(int i) {
        if (this.f3834l.getCoorType() == null) {
            this.f3834l.setCoorType(this.f3825c.coorType);
        }
        if (this.f3835m || ((this.f3825c.location_change_notify && this.f3834l.getLocType() == 61) || this.f3834l.getLocType() == 66 || this.f3834l.getLocType() == 67 || this.f3847y || this.f3834l.getLocType() == 161)) {
            ArrayList<BDLocationListener> arrayList = this.f3832j;
            if (arrayList != null) {
                Iterator<BDLocationListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(this.f3834l);
                }
            }
            ArrayList<BDAbstractLocationListener> arrayList2 = this.f3833k;
            if (arrayList2 != null) {
                Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onReceiveLocation(this.f3834l);
                }
            }
            if (this.f3834l.getLocType() == 66 || this.f3834l.getLocType() == 67) {
                return;
            }
            this.f3835m = false;
            this.f3842t = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12308b(Message message2) {
        if (message2 == null || message2.obj == null) {
            return;
        }
        BDNotifyListener bDNotifyListener = (BDNotifyListener) message2.obj;
        C0952a c0952a = this.f3843u;
        if (c0952a != null) {
            c0952a.m11939c(bDNotifyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12304c() {
        if (!this.f3827e || this.f3829g == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 12);
        obtain.replyTo = this.f3831i;
        try {
            this.f3829g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f3828f.unbindService(this.f3822I);
            if (this.f3821H) {
                try {
                    this.f3828f.stopService(new Intent(this.f3828f, ServiceC1002f.class));
                } catch (Exception unused) {
                }
                this.f3821H = false;
            }
        } catch (Exception unused2) {
        }
        synchronized (this.f3840r) {
            try {
                if (this.f3837o) {
                    this.f3830h.removeCallbacks(this.f3838p);
                    this.f3837o = false;
                }
            } catch (Exception unused3) {
            }
        }
        C0952a c0952a = this.f3843u;
        if (c0952a != null) {
            c0952a.m11949a();
        }
        this.f3829g = null;
        this.f3836n = false;
        this.f3847y = false;
        this.f3827e = false;
        this.f3819F = false;
        this.f3820G = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12303c(Message message2) {
        this.f3836n = false;
        if (message2 == null || message2.obj == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) message2.obj;
        if (this.f3825c.optionEquals(locationClientOption)) {
            return;
        }
        if (this.f3825c.scanSpan != locationClientOption.scanSpan) {
            try {
                synchronized (this.f3840r) {
                    if (this.f3837o) {
                        this.f3830h.removeCallbacks(this.f3838p);
                        this.f3837o = false;
                    }
                    if (locationClientOption.scanSpan >= 1000 && !this.f3837o) {
                        if (this.f3838p == null) {
                            this.f3838p = new RunnableC0889b();
                        }
                        this.f3830h.postDelayed(this.f3838p, locationClientOption.scanSpan);
                        this.f3837o = true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        this.f3825c = new LocationClientOption(locationClientOption);
        if (this.f3829g == null) {
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 15);
            obtain.replyTo = this.f3831i;
            obtain.setData(m12299d());
            this.f3829g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Bundle m12299d() {
        if (this.f3825c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.f3824b);
        bundle.putString("prodName", this.f3825c.prodName);
        bundle.putString("coorType", this.f3825c.coorType);
        bundle.putString("addrType", this.f3825c.addrType);
        bundle.putBoolean("openGPS", this.f3825c.openGps);
        bundle.putBoolean("location_change_notify", this.f3825c.location_change_notify);
        bundle.putInt("scanSpan", this.f3825c.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.f3825c.enableSimulateGps);
        bundle.putInt("timeOut", this.f3825c.timeOut);
        bundle.putInt("priority", this.f3825c.priority);
        bundle.putBoolean("map", this.f3814A.booleanValue());
        bundle.putBoolean("import", this.f3815B.booleanValue());
        bundle.putBoolean("needDirect", this.f3825c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.f3825c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.f3825c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.f3825c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.f3825c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.f3825c.isNeedAltitude);
        bundle.putInt("autoNotifyMaxInterval", this.f3825c.m12263a());
        bundle.putInt("autoNotifyMinTimeInterval", this.f3825c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.f3825c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.f3825c.m12262b());
        bundle.putInt("wifitimeout", this.f3825c.wifiCacheTimeOut);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12298d(Message message2) {
        if (message2 == null || message2.obj == null) {
            return;
        }
        this.f3844v = (BDLocationListener) message2.obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12294e() {
        if (this.f3829g == null) {
            return;
        }
        Message obtain = Message.obtain((Handler) null, 22);
        try {
            obtain.replyTo = this.f3831i;
            this.f3829g.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12293e(Message message2) {
        if (message2 == null || message2.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message2.obj;
        if (this.f3832j == null) {
            this.f3832j = new ArrayList<>();
        }
        if (this.f3832j.contains(bDLocationListener)) {
            return;
        }
        this.f3832j.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12289f() {
        if (this.f3829g == null) {
            return;
        }
        if ((System.currentTimeMillis() - this.f3841s > 3000 || !this.f3825c.location_change_notify || this.f3836n) && (!this.f3847y || System.currentTimeMillis() - this.f3842t > 20000 || this.f3836n)) {
            Message obtain = Message.obtain((Handler) null, 22);
            if (this.f3836n) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isWaitingLocTag", this.f3836n);
                this.f3836n = false;
                obtain.setData(bundle);
            }
            try {
                obtain.replyTo = this.f3831i;
                this.f3829g.send(obtain);
                this.f3823a = System.currentTimeMillis();
                this.f3835m = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        synchronized (this.f3840r) {
            if (this.f3825c != null && this.f3825c.scanSpan >= 1000 && !this.f3837o) {
                if (this.f3838p == null) {
                    this.f3838p = new RunnableC0889b();
                }
                this.f3830h.postDelayed(this.f3838p, this.f3825c.scanSpan);
                this.f3837o = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12288f(Message message2) {
        if (message2 == null || message2.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message2.obj;
        if (this.f3833k == null) {
            this.f3833k = new ArrayList<>();
        }
        if (this.f3833k.contains(bDAbstractLocationListener)) {
            return;
        }
        this.f3833k.add(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12285g(Message message2) {
        if (message2 == null || message2.obj == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) message2.obj;
        ArrayList<BDAbstractLocationListener> arrayList = this.f3833k;
        if (arrayList == null || !arrayList.contains(bDAbstractLocationListener)) {
            return;
        }
        this.f3833k.remove(bDAbstractLocationListener);
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(coorEncrypt[1]);
        bDLocation2.setLongitude(coorEncrypt[0]);
        return bDLocation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m12282h(Message message2) {
        if (message2 == null || message2.obj == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) message2.obj;
        ArrayList<BDLocationListener> arrayList = this.f3832j;
        if (arrayList == null || !arrayList.contains(bDLocationListener)) {
            return;
        }
        this.f3832j.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m12279i(Message message2) {
        try {
            Bundle data = message2.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
            if (this.f3844v != null) {
                if (this.f3825c != null && this.f3825c.isDisableCache() && bDLocation.getLocType() == 65) {
                    return;
                }
                this.f3844v.onReceiveLocation(bDLocation);
            }
        } catch (Exception unused) {
        }
    }

    public final void disableAssistantLocation() {
        C0911i.m12144a().m12134b();
    }

    public final void disableLocInForeground(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("removenotify", z);
        Message obtainMessage = this.f3830h.obtainMessage(704);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public final void enableAssistantLocation(WebView webView) {
        C0911i.m12144a().m12142a(this.f3828f, webView, this);
    }

    public final void enableLocInForeground(int i, Notification notification) {
        if (i <= 0 || notification == null) {
            Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        bundle.putParcelable("notification", notification);
        Message obtainMessage = this.f3830h.obtainMessage(703);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public final String getAccessKey() {
        try {
            this.f3846x = C0910h.m12146b(this.f3828f);
            if (TextUtils.isEmpty(this.f3846x)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s", this.f3846x);
        } catch (Exception unused) {
            return null;
        }
    }

    public final BDLocation getLastKnownLocation() {
        return this.f3834l;
    }

    public final LocationClientOption getLocOption() {
        return this.f3825c;
    }

    public final String getVersion() {
        return "7.5.1";
    }

    public final boolean isStarted() {
        return this.f3827e;
    }

    @Override // com.baidu.location.p078a.C0896c.InterfaceC0897a
    public final void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.f3820G || this.f3819F) && bDLocation != null) {
            Message obtainMessage = this.f3830h.obtainMessage(701);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public final void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.f3830h.obtainMessage(1300);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public final void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.f3830h.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public final void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f3830h.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public final void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.f3830h.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public final void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.f3830h.obtainMessage(10);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public final boolean requestHotSpotState() {
        if (this.f3829g != null && this.f3827e) {
            try {
                this.f3829g.send(Message.obtain((Handler) null, 406));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public final int requestLocation() {
        ArrayList<BDAbstractLocationListener> arrayList;
        if (this.f3829g == null || this.f3831i == null) {
            return 1;
        }
        ArrayList<BDLocationListener> arrayList2 = this.f3832j;
        if ((arrayList2 == null || arrayList2.size() <= 0) && ((arrayList = this.f3833k) == null || arrayList.size() <= 0)) {
            return 2;
        }
        if (System.currentTimeMillis() - this.f3823a < 1000) {
            return 6;
        }
        this.f3836n = true;
        Message obtainMessage = this.f3830h.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public final void requestNotifyLocation() {
        this.f3830h.obtainMessage(11).sendToTarget();
    }

    public final int requestOfflineLocation() {
        ArrayList<BDAbstractLocationListener> arrayList;
        if (this.f3829g == null || this.f3831i == null) {
            return 1;
        }
        ArrayList<BDLocationListener> arrayList2 = this.f3832j;
        if ((arrayList2 == null || arrayList2.size() <= 0) && ((arrayList = this.f3833k) == null || arrayList.size() <= 0)) {
            return 2;
        }
        this.f3830h.obtainMessage(12).sendToTarget();
        return 0;
    }

    public final void restart() {
        stop();
        this.f3848z = false;
        this.f3830h.sendEmptyMessageDelayed(1, 1000L);
    }

    public final void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.m12263a() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        this.f3826d = new LocationClientOption(locationClientOption);
        Message obtainMessage = this.f3830h.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public final void start() {
        this.f3848z = false;
        this.f3830h.obtainMessage(1).sendToTarget();
    }

    public final boolean startIndoorMode() {
        boolean m12325a = m12325a(110);
        if (m12325a) {
            this.f3847y = true;
        }
        return m12325a;
    }

    public final void stop() {
        this.f3848z = true;
        this.f3830h.obtainMessage(2).sendToTarget();
        this.f3818E = null;
    }

    public final boolean stopIndoorMode() {
        boolean m12325a = m12325a(111);
        if (m12325a) {
            this.f3847y = false;
        }
        return m12325a;
    }

    public final void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.f3830h.obtainMessage(1400);
        obtainMessage.obj = bDAbstractLocationListener;
        obtainMessage.sendToTarget();
    }

    public final void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.f3830h.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public final boolean updateLocation(Location location) {
        if (this.f3829g == null || this.f3831i == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 57);
            obtain.obj = location;
            this.f3829g.send(obtain);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
