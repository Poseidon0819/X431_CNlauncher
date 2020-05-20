package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.HandlerThread;
import android.os.Message;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.data.C1272c;
import com.baidu.mapsdkplatform.comapi.synchronization.data.InterfaceC1276d;
import com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.d */
/* loaded from: classes.dex */
public class C1290d {

    /* renamed from: a */
    private static final String f6357a = "d";

    /* renamed from: d */
    private static HandlerThread f6358d;

    /* renamed from: b */
    private int f6359b;

    /* renamed from: c */
    private int f6360c;

    /* renamed from: e */
    private HandlerC1281a f6361e;

    /* renamed from: f */
    private C1272c f6362f;

    /* renamed from: g */
    private InterfaceC1276d f6363g;

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.d$a */
    /* loaded from: classes.dex */
    class C1292a implements InterfaceC1276d {
        private C1292a() {
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.InterfaceC1276d
        /* renamed from: a */
        public void mo10111a() {
            C1290d.this.m10112j();
            C1290d c1290d = C1290d.this;
            c1290d.m10118e(c1290d.f6359b);
        }

        @Override // com.baidu.mapsdkplatform.comapi.synchronization.data.InterfaceC1276d
        /* renamed from: b */
        public void mo10110b() {
            C1290d.this.m10113i();
        }
    }

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.render.d$b */
    /* loaded from: classes.dex */
    static class C1293b {

        /* renamed from: a */
        private static final C1290d f6365a = new C1290d();
    }

    private C1290d() {
        this.f6359b = 0;
        this.f6360c = 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C1290d m10133a() {
        return C1293b.f6365a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m10118e(int i) {
        C1255a.m10452c(f6357a, "The order state is: ".concat(String.valueOf(i)));
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                m10116f(i);
                return;
            default:
                C1255a.m10452c(f6357a, "Undefined order state: ".concat(String.valueOf(i)));
                return;
        }
    }

    /* renamed from: f */
    private void m10116f(int i) {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a == null) {
            C1255a.m10453b(f6357a, "SyncRenderHandler is null");
            return;
        }
        Message obtainMessage = handlerC1281a.obtainMessage();
        obtainMessage.what = i;
        this.f6361e.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m10113i() {
        RoleOptions m10329e = this.f6362f.m10329e();
        DisplayOptions m10328f = this.f6362f.m10328f();
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a == null) {
            C1255a.m10453b(f6357a, "SyncRenderHandler is null");
        } else {
            handlerC1281a.m10250a(m10329e, m10328f, null, this.f6360c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m10112j() {
        SyncResponseResult syncResponseResult;
        RoleOptions m10329e = this.f6362f.m10329e();
        DisplayOptions m10328f = this.f6362f.m10328f();
        try {
            syncResponseResult = this.f6362f.m10327g().take();
        } catch (InterruptedException e) {
            C1255a.m10456a(f6357a, "Get result when InterruptedException happened.", e);
            syncResponseResult = null;
        }
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a == null) {
            C1255a.m10453b(f6357a, "SyncRenderHandler is null");
        } else {
            handlerC1281a.m10250a(m10329e, m10328f, syncResponseResult, this.f6360c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10132a(int i) {
        this.f6359b = i;
        m10118e(this.f6359b);
    }

    /* renamed from: a */
    public void m10131a(BaiduMap baiduMap) {
        this.f6362f = C1272c.m10363a();
        this.f6363g = new C1292a();
        this.f6362f.m10352a(this.f6363g);
        HandlerThread handlerThread = new HandlerThread("SynchronizationRenderStrategy");
        f6358d = handlerThread;
        handlerThread.start();
        this.f6361e = new HandlerC1281a(f6358d.getLooper());
        this.f6361e.m10258a(baiduMap, this.f6362f.m10329e(), this.f6362f.m10328f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10130a(InterfaceC1288b interfaceC1288b) {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a != null) {
            handlerC1281a.m10240a(interfaceC1288b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Marker m10127b() {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a == null) {
            C1255a.m10453b(f6357a, "SyncRenderHandler created failed");
            return null;
        }
        return handlerC1281a.m10264a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10126b(int i) {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a != null) {
            handlerC1281a.m10260a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public Marker m10124c() {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a == null) {
            C1255a.m10453b(f6357a, "SyncRenderHandler created failed");
            return null;
        }
        return handlerC1281a.m10224b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m10123c(int i) {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a != null) {
            handlerC1281a.m10222b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public Marker m10121d() {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a == null) {
            C1255a.m10453b(f6357a, "SyncRenderHandler created failed");
            return null;
        }
        return handlerC1281a.m10211c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m10120d(int i) {
        this.f6360c = i;
    }

    /* renamed from: e */
    public void m10119e() {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a != null) {
            handlerC1281a.m10202d();
        }
    }

    /* renamed from: f */
    public void m10117f() {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a != null) {
            handlerC1281a.m10197e();
        }
    }

    /* renamed from: g */
    public void m10115g() {
        this.f6362f.m10337c();
        if (this.f6363g != null) {
            this.f6363g = null;
        }
        C1272c c1272c = this.f6362f;
        if (c1272c != null) {
            c1272c.m10326h();
            this.f6362f = null;
        }
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a != null) {
            handlerC1281a.m10192f();
            this.f6361e.removeCallbacksAndMessages(null);
            this.f6361e = null;
        }
        HandlerThread handlerThread = f6358d;
        if (handlerThread != null) {
            handlerThread.quit();
            f6358d = null;
        }
    }

    /* renamed from: h */
    public void m10114h() {
        HandlerC1281a handlerC1281a = this.f6361e;
        if (handlerC1281a != null) {
            handlerC1281a.m10188g();
        }
    }
}
