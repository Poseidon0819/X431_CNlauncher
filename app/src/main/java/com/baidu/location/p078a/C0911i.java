package com.baidu.location.p078a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.i */
/* loaded from: classes.dex */
public class C0911i {

    /* renamed from: j */
    private static long f3998j = 12000;

    /* renamed from: a */
    public C0917e f3999a;

    /* renamed from: b */
    private Context f4000b;

    /* renamed from: c */
    private WebView f4001c;

    /* renamed from: d */
    private LocationClient f4002d;

    /* renamed from: e */
    private HandlerC0913a f4003e;

    /* renamed from: f */
    private List<C0914b> f4004f;

    /* renamed from: g */
    private boolean f4005g;

    /* renamed from: h */
    private long f4006h;

    /* renamed from: i */
    private BDLocation f4007i;

    /* renamed from: k */
    private RunnableC0918f f4008k;

    /* renamed from: l */
    private boolean f4009l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.i$a */
    /* loaded from: classes.dex */
    public class HandlerC0913a extends Handler {
        HandlerC0913a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        private String m12124a(BDLocation bDLocation) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", bDLocation.getLatitude());
                jSONObject.put("longitude", bDLocation.getLongitude());
                jSONObject.put("radius", bDLocation.getRadius());
                jSONObject.put("errorcode", 1);
                if (bDLocation.hasAltitude()) {
                    jSONObject.put("altitude", bDLocation.getAltitude());
                }
                if (bDLocation.hasSpeed()) {
                    jSONObject.put("speed", bDLocation.getSpeed() / 3.6f);
                }
                if (bDLocation.getLocType() == 61) {
                    jSONObject.put("direction", bDLocation.getDirection());
                }
                if (bDLocation.getBuildingName() != null) {
                    jSONObject.put("buildingname", bDLocation.getBuildingName());
                }
                if (bDLocation.getBuildingID() != null) {
                    jSONObject.put("buildingid", bDLocation.getBuildingID());
                }
                if (bDLocation.getFloor() != null) {
                    jSONObject.put("floor", bDLocation.getFloor());
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }

        /* renamed from: a */
        private void m12123a(String str) {
            if (C0911i.this.f4009l) {
                C0911i.this.f4003e.removeCallbacks(C0911i.this.f4008k);
                C0911i.this.f4009l = false;
            }
            if (C0911i.this.f4004f == null || C0911i.this.f4004f.size() <= 0) {
                return;
            }
            Iterator it = C0911i.this.f4004f.iterator();
            while (it.hasNext()) {
                try {
                    C0914b c0914b = (C0914b) it.next();
                    if (c0914b.m12121b() != null) {
                        C0911i.this.f4001c.loadUrl("javascript:" + c0914b.m12121b() + "('" + str + "')");
                    }
                    it.remove();
                } catch (Exception unused) {
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r9) {
            /*
                Method dump skipped, instructions count: 370
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p078a.C0911i.HandlerC0913a.handleMessage(android.os.Message):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.i$b */
    /* loaded from: classes.dex */
    public class C0914b {

        /* renamed from: b */
        private String f4012b;

        /* renamed from: c */
        private String f4013c;

        /* renamed from: d */
        private long f4014d;

        C0914b(String str) {
            this.f4012b = null;
            this.f4013c = null;
            this.f4014d = 0L;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    this.f4012b = jSONObject.getString("action");
                }
                if (jSONObject.has("callback")) {
                    this.f4013c = jSONObject.getString("callback");
                }
                if (jSONObject.has("timeout")) {
                    long j = jSONObject.getLong("timeout");
                    if (j >= 1000) {
                        long unused = C0911i.f3998j = j;
                    }
                }
                this.f4014d = System.currentTimeMillis();
            } catch (Exception unused2) {
                this.f4012b = null;
                this.f4013c = null;
            }
        }

        /* renamed from: a */
        public String m12122a() {
            return this.f4012b;
        }

        /* renamed from: b */
        public String m12121b() {
            return this.f4013c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.i$c */
    /* loaded from: classes.dex */
    public static final class C0915c {

        /* renamed from: a */
        private static final C0911i f4015a = new C0911i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.i$d */
    /* loaded from: classes.dex */
    public class C0916d {
        private C0916d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str == null || !C0911i.this.f4005g) {
                return;
            }
            C0914b c0914b = new C0914b(str);
            if (c0914b.m12122a() == null || !c0914b.m12122a().equals("requestLoc") || C0911i.this.f4003e == null) {
                return;
            }
            Message obtainMessage = C0911i.this.f4003e.obtainMessage(1);
            obtainMessage.obj = c0914b;
            obtainMessage.sendToTarget();
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    /* renamed from: com.baidu.location.a.i$e */
    /* loaded from: classes.dex */
    public class C0917e extends BDAbstractLocationListener {
        public C0917e() {
        }

        @Override // com.baidu.location.BDAbstractLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            String str;
            if (!C0911i.this.f4005g || bDLocation == null) {
                return;
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            int locType = bDLocation2.getLocType();
            String coorType = bDLocation2.getCoorType();
            if (locType != 61 && locType != 161 && locType != 66) {
                C0911i.this.f4003e.obtainMessage(5).sendToTarget();
                return;
            }
            if (coorType != null) {
                if (coorType.equals(CoordinateType.GCJ02)) {
                    bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                } else {
                    if (coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                        str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
                    } else if (coorType.equals("bd09ll")) {
                        str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
                    }
                    bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, str), "gcj2wgs");
                }
            }
            C0911i.this.f4006h = System.currentTimeMillis();
            C0911i.this.f4007i = new BDLocation(bDLocation2);
            Message obtainMessage = C0911i.this.f4003e.obtainMessage(2);
            obtainMessage.obj = bDLocation2;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.a.i$f */
    /* loaded from: classes.dex */
    public class RunnableC0918f implements Runnable {
        private RunnableC0918f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0911i.this.f4009l = false;
            C0911i.this.f4003e.obtainMessage(6).sendToTarget();
        }
    }

    private C0911i() {
        this.f4000b = null;
        this.f4002d = null;
        this.f3999a = new C0917e();
        this.f4003e = null;
        this.f4004f = null;
        this.f4005g = false;
        this.f4006h = 0L;
        this.f4007i = null;
        this.f4008k = null;
        this.f4009l = false;
    }

    /* renamed from: a */
    public static C0911i m12144a() {
        return C0915c.f4015a;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    /* renamed from: a */
    private void m12141a(WebView webView) {
        webView.addJavascriptInterface(new C0916d(), "BaiduLocAssistant");
    }

    /* renamed from: a */
    public void m12142a(Context context, WebView webView, LocationClient locationClient) {
        if (!this.f4005g && Build.VERSION.SDK_INT >= 17) {
            this.f4000b = context;
            this.f4001c = webView;
            this.f4002d = locationClient;
            this.f4003e = new HandlerC0913a(Looper.getMainLooper());
            this.f4003e.obtainMessage(3).sendToTarget();
            webView.getSettings().setJavaScriptEnabled(true);
            m12141a(this.f4001c);
            this.f4005g = true;
        }
    }

    /* renamed from: b */
    public void m12134b() {
        if (this.f4005g) {
            this.f4003e.obtainMessage(4).sendToTarget();
            this.f4005g = false;
        }
    }
}
