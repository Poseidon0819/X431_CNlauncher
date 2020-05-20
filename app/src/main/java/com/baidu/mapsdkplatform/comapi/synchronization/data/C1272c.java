package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo;
import com.baidu.mapsdkplatform.comapi.synchronization.p090c.AbstractC1253c;
import com.baidu.mapsdkplatform.comapi.synchronization.p090c.C1247a;
import com.baidu.mapsdkplatform.comapi.synchronization.p090c.C1250b;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.ColumnText;
import com.p297e.p298a.p306b.ImageLoader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.c */
/* loaded from: classes.dex */
public final class C1272c {

    /* renamed from: a */
    private static final String f6264a = "c";

    /* renamed from: b */
    private RoleOptions f6265b;

    /* renamed from: c */
    private DisplayOptions f6266c;

    /* renamed from: d */
    private BlockingQueue<SyncResponseResult> f6267d;

    /* renamed from: e */
    private InterfaceC1276d f6268e;

    /* renamed from: f */
    private String f6269f;

    /* renamed from: g */
    private String f6270g;

    /* renamed from: h */
    private C1247a f6271h;

    /* renamed from: i */
    private HandlerThread f6272i;

    /* renamed from: j */
    private HandlerC1275b f6273j;

    /* renamed from: k */
    private volatile int f6274k;

    /* renamed from: l */
    private InterfaceC1277e f6275l;

    /* renamed from: m */
    private boolean f6276m;

    /* renamed from: n */
    private float f6277n;

    /* renamed from: o */
    private long f6278o;

    /* renamed from: p */
    private int f6279p;

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.c$a */
    /* loaded from: classes.dex */
    static class C1274a {

        /* renamed from: a */
        private static final C1272c f6281a = new C1272c();
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.data.c$b */
    /* loaded from: classes.dex */
    class HandlerC1275b extends Handler {
        HandlerC1275b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            switch (message2.what) {
                case 100000:
                    SyncResponseResult m10340b = C1272c.this.m10340b((String) message2.obj);
                    if (m10340b == null) {
                        C1255a.m10453b(C1272c.f6264a, "parser response data is null");
                        return;
                    }
                    C1272c.this.m10357a(m10340b);
                    C1272c.this.m10324j();
                    C1272c.this.m10343b(m10340b);
                    return;
                case 100001:
                    C1272c.this.m10323k();
                    return;
                default:
                    C1255a.m10453b(C1272c.f6264a, "Undefined message type");
                    return;
            }
        }
    }

    private C1272c() {
        this.f6267d = new LinkedBlockingQueue();
        this.f6269f = "0";
        this.f6270g = "0";
        this.f6271h = new C1247a();
        this.f6274k = 0;
        this.f6276m = false;
        this.f6277n = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f6278o = 0L;
        this.f6279p = 0;
    }

    /* renamed from: a */
    private C1269b m10362a(int i) {
        if (this.f6265b == null) {
            C1255a.m10453b(f6264a, "RoleOptions is null");
            return null;
        }
        C1269b c1269b = new C1269b();
        c1269b.m10377a(this.f6265b.getOrderId());
        c1269b.m10375b(this.f6265b.getDriverId());
        c1269b.m10373c(this.f6265b.getUserId());
        c1269b.m10378a(i);
        if (this.f6276m) {
            this.f6269f = "0";
            this.f6270g = "0";
        }
        c1269b.m10371d(this.f6269f);
        c1269b.m10369e(this.f6270g);
        return c1269b;
    }

    /* renamed from: a */
    public static C1272c m10363a() {
        return C1274a.f6281a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10357a(SyncResponseResult syncResponseResult) {
        if (this.f6267d == null) {
            this.f6267d = new LinkedBlockingQueue();
        }
        if (this.f6276m) {
            this.f6276m = false;
            this.f6267d.clear();
        }
        try {
            this.f6267d.put(syncResponseResult);
        } catch (InterruptedException e) {
            C1255a.m10456a(f6264a, "InterruptedException happened when put item into queue", e);
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: a */
    private void m10350a(String str) {
        C1247a c1247a = this.f6271h;
        if (c1247a == null) {
            C1255a.m10453b(f6264a, "HttpClient cannot be null");
        } else {
            c1247a.m10477a(str, new AbstractC1253c() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.data.c.1
                @Override // com.baidu.mapsdkplatform.comapi.synchronization.p090c.AbstractC1253c
                /* renamed from: a */
                public void mo10322a(C1250b.EnumC1252a enumC1252a) {
                    Message obtainMessage = C1272c.this.f6273j.obtainMessage();
                    obtainMessage.what = 100001;
                    obtainMessage.obj = enumC1252a;
                    if (C1272c.this.f6273j != null) {
                        C1272c.this.f6273j.sendMessage(obtainMessage);
                    }
                    if (C1250b.EnumC1252a.SERVER_ERROR == enumC1252a || C1250b.EnumC1252a.NETWORK_ERROR == enumC1252a || C1250b.EnumC1252a.INNER_ERROR == enumC1252a) {
                        C1272c.m10342b(C1272c.this);
                    }
                }

                @Override // com.baidu.mapsdkplatform.comapi.synchronization.p090c.AbstractC1253c
                /* renamed from: a */
                public void mo10321a(String str2) {
                    Message obtainMessage = C1272c.this.f6273j.obtainMessage();
                    obtainMessage.what = 100000;
                    obtainMessage.obj = str2;
                    if (C1272c.this.f6273j != null) {
                        C1272c.this.f6273j.sendMessage(obtainMessage);
                    }
                    C1272c.this.f6274k = 0;
                }
            });
        }
    }

    /* renamed from: a */
    private void m10349a(String str, SyncResponseResult syncResponseResult) {
        LatLng latLng;
        String[] split = str.split(";");
        if (split.length == 0) {
            C1255a.m10453b(f6264a, "There's no section route data");
            return;
        }
        String[] split2 = split[0].split(",");
        if (2 != split2.length) {
            C1255a.m10453b(f6264a, "Section start position latlng invalid: " + split[0]);
            return;
        }
        LatLng latLng2 = null;
        try {
            latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
        } catch (NumberFormatException e) {
            C1255a.m10456a(f6264a, "Get startPosition failed", e);
            latLng = null;
        }
        for (int i = 1; i < split.length; i++) {
            RouteLineInfo.RouteSectionInfo routeSectionInfo = new RouteLineInfo.RouteSectionInfo();
            routeSectionInfo.m10436a(latLng);
            String[] split3 = split[i].split(",");
            if (2 != split3.length) {
                C1255a.m10453b(f6264a, "Section position latlng invalid: " + split[i]);
            } else {
                try {
                    latLng2 = new LatLng(Double.valueOf(split3[1]).doubleValue(), Double.valueOf(split3[0]).doubleValue());
                } catch (NumberFormatException e2) {
                    C1255a.m10456a(f6264a, "Get endPosition failed", e2);
                }
                routeSectionInfo.m10434b(latLng2);
                syncResponseResult.m10431a().m10443a(routeSectionInfo);
                latLng = latLng2;
            }
        }
    }

    /* renamed from: a */
    private void m10348a(JSONArray jSONArray, SyncResponseResult syncResponseResult) {
        double d;
        JSONObject optJSONObject = jSONArray.optJSONObject(jSONArray.length() - 1);
        if (optJSONObject == null) {
            C1255a.m10453b(f6264a, "Invalid driver position data");
            return;
        }
        syncResponseResult.m10422c().setTimeStamp(optJSONObject.optString("t"));
        String optString = optJSONObject.optString(HtmlTags.f19632P);
        if (optString == null) {
            C1255a.m10453b(f6264a, "No position info data");
            return;
        }
        String[] split = optString.split(";");
        if (split.length == 0) {
            C1255a.m10453b(f6264a, "Position info array is empty");
            return;
        }
        int i = 0;
        String[] split2 = split[0].split(",");
        if (2 != split2.length) {
            C1255a.m10453b(f6264a, "Position latlng invalid");
            return;
        }
        LatLng latLng = null;
        try {
            latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
        } catch (NumberFormatException e) {
            C1255a.m10456a(f6264a, "Get driver position failed", e);
        }
        syncResponseResult.m10422c().setPoint(latLng);
        double d2 = 0.0d;
        try {
            d = Double.valueOf(split[1]).doubleValue();
        } catch (NumberFormatException e2) {
            C1255a.m10456a(f6264a, "Get angle failed", e2);
            d = 0.0d;
        }
        syncResponseResult.m10422c().setAngle(d);
        try {
            d2 = Double.valueOf(split[2]).doubleValue();
        } catch (NumberFormatException e3) {
            C1255a.m10456a(f6264a, "Get speed failed", e3);
        }
        syncResponseResult.m10422c().setSpeed(d2);
        try {
            i = Integer.valueOf(split[3]).intValue();
        } catch (NumberFormatException e4) {
            C1255a.m10456a(f6264a, "Get orderStateInPosition failed", e4);
        }
        syncResponseResult.m10422c().setOrderStateInPosition(i);
    }

    /* renamed from: a */
    private void m10346a(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        JSONObject optJSONObject = jSONObject.optJSONObject("route");
        if (optJSONObject != null) {
            C1255a.m10457a(f6264a, "parser route data");
            m10338b(optJSONObject, syncResponseResult);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("traffic");
        if (optJSONObject2 != null) {
            C1255a.m10457a(f6264a, "parser traffic data");
            m10333c(optJSONObject2, syncResponseResult);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("positions");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            C1255a.m10457a(f6264a, "parser driver position data");
            m10348a(optJSONArray, syncResponseResult);
        }
        String optString = jSONObject.optString("run");
        if (!TextUtils.isEmpty(optString)) {
            C1255a.m10457a(f6264a, "parser travelled distance and elapsed time data");
            m10334c(optString, syncResponseResult);
        }
        String optString2 = jSONObject.optString("remain");
        if (!TextUtils.isEmpty(optString2)) {
            C1255a.m10457a(f6264a, "parser remain distance and estimated time data");
            m10330d(optString2, syncResponseResult);
        }
        syncResponseResult.m10429a(jSONObject.optInt(HtmlTags.f19633S));
        syncResponseResult.m10427a(jSONObject.optString("mtime"));
        syncResponseResult.m10423b(jSONObject.optString("ext"));
    }

    /* renamed from: a */
    private boolean m10347a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("status")) {
            InterfaceC1277e interfaceC1277e = this.f6275l;
            if (interfaceC1277e != null) {
                interfaceC1277e.mo10317c(SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED, SynchronizationConstants.LBS_STATUS_MESSAGE_QUERY_TRACK_ROUTE_FAILED);
            }
            return false;
        }
        int optInt = jSONObject.optInt("status");
        String optString = jSONObject.optString(MessageDao.TABLENAME);
        if (optInt != 0) {
            InterfaceC1277e interfaceC1277e2 = this.f6275l;
            if (interfaceC1277e2 != null) {
                interfaceC1277e2.mo10317c(optInt, optString);
            }
            return false;
        }
        InterfaceC1277e interfaceC1277e3 = this.f6275l;
        if (interfaceC1277e3 != null) {
            interfaceC1277e3.mo10318b(optInt, optString);
            return true;
        }
        return true;
    }

    /* renamed from: b */
    static /* synthetic */ int m10342b(C1272c c1272c) {
        int i = c1272c.f6274k;
        c1272c.f6274k = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public SyncResponseResult m10340b(String str) {
        if (TextUtils.isEmpty(str)) {
            C1255a.m10453b(f6264a, "Response result is null");
            return null;
        }
        SyncResponseResult syncResponseResult = new SyncResponseResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!m10347a(jSONObject)) {
                C1255a.m10453b(f6264a, "Response result is invalid");
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(DataPacketExtension.ELEMENT_NAME);
            if (optJSONObject != null && optJSONObject.length() > 0) {
                m10346a(optJSONObject, syncResponseResult);
                return syncResponseResult;
            }
            C1255a.m10453b(f6264a, "No route and traffic and driver data");
            return null;
        } catch (JSONException unused) {
            C1255a.m10453b(f6264a, "JSONException happened when parser");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10343b(SyncResponseResult syncResponseResult) {
        float m10421d = syncResponseResult.m10421d();
        long m10420e = syncResponseResult.m10420e();
        int i = this.f6279p;
        if (1 == i || 2 == i || 4 == i) {
            if (this.f6279p != 1 && this.f6276m) {
                this.f6277n = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                this.f6278o = 0L;
                m10420e = 0;
                m10421d = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
            if (ColumnText.GLOBAL_SPACE_CHAR_RATIO != m10421d) {
                this.f6277n = m10421d;
            }
            if (0 != m10420e) {
                this.f6278o = m10420e;
            }
        } else {
            this.f6277n = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            this.f6278o = 0L;
        }
        InterfaceC1277e interfaceC1277e = this.f6275l;
        if (interfaceC1277e != null) {
            interfaceC1277e.mo10319a(this.f6277n, this.f6278o);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[LOOP:1: B:26:0x0068->B:28:0x006c, LOOP_END] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m10339b(java.lang.String r10, com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult r11) {
        /*
            r9 = this;
            java.lang.String r0 = ";"
            java.lang.String[] r10 = r10.split(r0)
            int r0 = r10.length
            if (r0 != 0) goto L11
            java.lang.String r10 = com.baidu.mapsdkplatform.comapi.synchronization.data.C1272c.f6264a
            java.lang.String r11 = "There's no section traffic data"
            com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a.m10453b(r10, r11)
            return
        L11:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r10.length
            r2 = 0
            r3 = 0
        L19:
            if (r3 >= r1) goto L80
            r4 = r10[r3]
            java.lang.String r5 = ","
            java.lang.String[] r5 = r4.split(r5)
            r6 = 3
            int r7 = r5.length
            if (r6 == r7) goto L37
            java.lang.String r5 = com.baidu.mapsdkplatform.comapi.synchronization.data.C1272c.f6264a
            java.lang.String r6 = "section traffic data is invalid: "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = r6.concat(r4)
            com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a.m10453b(r5, r4)
            goto L7d
        L37:
            r4 = r5[r2]     // Catch: java.lang.NumberFormatException -> L5c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.NumberFormatException -> L5c
            int r4 = r4.intValue()     // Catch: java.lang.NumberFormatException -> L5c
            r6 = 1
            r6 = r5[r6]     // Catch: java.lang.NumberFormatException -> L5a
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.NumberFormatException -> L5a
            int r6 = r6.intValue()     // Catch: java.lang.NumberFormatException -> L5a
            r7 = 2
            r5 = r5[r7]     // Catch: java.lang.NumberFormatException -> L58
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.NumberFormatException -> L58
            int r5 = r5.intValue()     // Catch: java.lang.NumberFormatException -> L58
            goto L67
        L58:
            r5 = move-exception
            goto L5f
        L5a:
            r5 = move-exception
            goto L5e
        L5c:
            r5 = move-exception
            r4 = 0
        L5e:
            r6 = 0
        L5f:
            java.lang.String r7 = com.baidu.mapsdkplatform.comapi.synchronization.data.C1272c.f6264a
            java.lang.String r8 = "Get traffic status info failed"
            com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a.m10456a(r7, r8, r5)
            r5 = 0
        L67:
            r7 = r4
        L68:
            int r8 = r4 + r6
            if (r7 >= r8) goto L76
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r0.add(r8)
            int r7 = r7 + 1
            goto L68
        L76:
            com.baidu.mapsdkplatform.comapi.synchronization.data.TrafficInfo r4 = r11.m10426b()
            r4.m10415a(r0)
        L7d:
            int r3 = r3 + 1
            goto L19
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.data.C1272c.m10339b(java.lang.String, com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult):void");
    }

    /* renamed from: b */
    private void m10338b(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        syncResponseResult.m10431a().m10441a(jSONObject.optInt("c") != 0);
        this.f6269f = jSONObject.optString("f");
        syncResponseResult.m10431a().m10442a(this.f6269f);
        String optString = jSONObject.optString(ImageLoader.f17144a);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        m10349a(optString, syncResponseResult);
    }

    /* renamed from: c */
    private void m10334c(String str, SyncResponseResult syncResponseResult) {
        String[] split = str.split(";");
        if (2 != split.length) {
            C1255a.m10453b(f6264a, "The travelled data is null or invalid");
            return;
        }
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        try {
            f = Float.valueOf(split[0]).floatValue();
        } catch (NumberFormatException e) {
            C1255a.m10456a(f6264a, "Get travelledDistance failed", e);
        }
        syncResponseResult.m10430a(f);
        long j = 0;
        try {
            j = Long.valueOf(split[1]).longValue();
        } catch (NumberFormatException e2) {
            C1255a.m10456a(f6264a, "Get elapsedTime failed", e2);
        }
        syncResponseResult.m10428a(j);
    }

    /* renamed from: c */
    private void m10333c(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        syncResponseResult.m10426b().m10414a(jSONObject.optInt("c") != 0);
        this.f6270g = jSONObject.optString("f");
        syncResponseResult.m10426b().m10416a(this.f6270g);
        String optString = jSONObject.optString(ImageLoader.f17144a);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        m10339b(optString, syncResponseResult);
    }

    /* renamed from: d */
    private void m10330d(String str, SyncResponseResult syncResponseResult) {
        String[] split = str.split(";");
        if (2 != split.length) {
            C1255a.m10453b(f6264a, "The remain data is null or invalid: ");
            return;
        }
        float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        try {
            f = Float.valueOf(split[0]).floatValue();
        } catch (NumberFormatException e) {
            C1255a.m10456a(f6264a, "Get remainDistance failed", e);
        }
        syncResponseResult.m10425b(f);
        long j = 0;
        try {
            j = Long.valueOf(split[1]).longValue();
        } catch (NumberFormatException e2) {
            C1255a.m10456a(f6264a, "Get estimatedTime failed", e2);
        }
        syncResponseResult.m10424b(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m10324j() {
        InterfaceC1276d interfaceC1276d = this.f6268e;
        if (interfaceC1276d != null) {
            interfaceC1276d.mo10111a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m10323k() {
        InterfaceC1276d interfaceC1276d = this.f6268e;
        if (interfaceC1276d != null) {
            interfaceC1276d.mo10110b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m10361a(int i, boolean z) {
        String str;
        String str2;
        this.f6276m = z;
        this.f6279p = i;
        C1269b m10362a = m10362a(i);
        if (m10362a == null) {
            str = f6264a;
            str2 = "Data request option is null";
        } else {
            String m10305a = new C1279g(m10362a).m10305a();
            if (m10305a != null) {
                m10350a(m10305a);
                return;
            } else {
                str = f6264a;
                str2 = "send url string is null";
            }
        }
        C1255a.m10453b(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void m10360a(View view) {
        if (this.f6266c != null) {
            this.f6266c.setStartPositionInfoWindowView(view);
            return;
        }
        if (this.f6275l != null) {
            this.f6275l.mo10317c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void m10359a(DisplayOptions displayOptions) {
        this.f6266c = displayOptions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void m10358a(RoleOptions roleOptions) {
        this.f6265b = roleOptions;
    }

    /* renamed from: a */
    public final void m10352a(InterfaceC1276d interfaceC1276d) {
        this.f6268e = interfaceC1276d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m10351a(InterfaceC1277e interfaceC1277e) {
        this.f6275l = interfaceC1277e;
    }

    /* renamed from: b */
    public final void m10345b() {
        this.f6272i = new HandlerThread("SyncDataStorage");
        this.f6272i.start();
        this.f6273j = new HandlerC1275b(this.f6272i.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized void m10344b(View view) {
        if (this.f6266c != null) {
            this.f6266c.setEndPositionInfoWindowView(view);
            return;
        }
        if (this.f6275l != null) {
            this.f6275l.mo10317c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
        }
    }

    /* renamed from: c */
    public final void m10337c() {
        if (this.f6268e != null) {
            this.f6268e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final synchronized void m10336c(View view) {
        if (this.f6266c != null) {
            this.f6266c.setCarInfoWindowView(view);
            return;
        }
        if (this.f6275l != null) {
            this.f6275l.mo10317c(1004, SynchronizationConstants.LBS_STATUS_MESSAGE_DISPLAYOPTIONS_INSTANCE_INVALID);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final int m10332d() {
        return this.f6274k;
    }

    /* renamed from: e */
    public final RoleOptions m10329e() {
        return this.f6265b;
    }

    /* renamed from: f */
    public final DisplayOptions m10328f() {
        return this.f6266c;
    }

    /* renamed from: g */
    public final BlockingQueue<SyncResponseResult> m10327g() {
        return this.f6267d;
    }

    /* renamed from: h */
    public final void m10326h() {
        this.f6276m = false;
        this.f6277n = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
        this.f6278o = 0L;
        this.f6273j.removeCallbacksAndMessages(null);
        this.f6272i.quit();
    }
}
