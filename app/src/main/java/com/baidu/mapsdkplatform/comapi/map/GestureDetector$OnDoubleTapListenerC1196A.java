package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.C1220l;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jivesoftware.smackx.GroupChatInvitation;

@SuppressLint({"NewApi"})
/* renamed from: com.baidu.mapsdkplatform.comapi.map.A */
/* loaded from: classes.dex */
public class GestureDetector$OnDoubleTapListenerC1196A extends TextureView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, TextureView.SurfaceTextureListener, C1220l.InterfaceC1221a {

    /* renamed from: a */
    public static int f5913a;

    /* renamed from: b */
    public static int f5914b;

    /* renamed from: c */
    public static int f5915c;

    /* renamed from: d */
    private GestureDetector f5916d;

    /* renamed from: e */
    private Handler f5917e;

    /* renamed from: f */
    private boolean f5918f;

    /* renamed from: g */
    private SurfaceTexture f5919g;

    /* renamed from: h */
    private C1220l f5920h;

    /* renamed from: i */
    private C1210e f5921i;

    public GestureDetector$OnDoubleTapListenerC1196A(Context context, C1234x c1234x, String str, int i) {
        super(context);
        this.f5918f = false;
        this.f5920h = null;
        m10786a(context, c1234x, str, i);
    }

    /* renamed from: a */
    private void m10786a(Context context, C1234x c1234x, String str, int i) {
        setSurfaceTextureListener(this);
        if (context == null) {
            throw new RuntimeException("when you create an mapview, the context can not be null");
        }
        this.f5916d = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.f5921i == null) {
            this.f5921i = new C1210e(context, str, i);
        }
        this.f5921i.m10735a(context.hashCode());
        this.f5921i.m10738a();
        this.f5921i.m10718a(c1234x);
        m10779e();
        this.f5921i.m10726a(this.f5917e);
        this.f5921i.m10686f();
    }

    /* renamed from: e */
    private void m10779e() {
        this.f5917e = new Handler() { // from class: com.baidu.mapsdkplatform.comapi.map.A.1
            /* JADX WARN: Code restructure failed: missing block: B:49:0x0104, code lost:
                if (r12.f5922a.f5920h != null) goto L117;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x0106, code lost:
                r12.f5922a.f5920h.m10602a();
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x011a, code lost:
                if (r12.f5922a.f5920h != null) goto L117;
             */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void handleMessage(android.os.Message r13) {
                /*
                    Method dump skipped, instructions count: 771
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.GestureDetector$OnDoubleTapListenerC1196A.HandlerC11971.handleMessage(android.os.Message):void");
            }
        };
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.C1220l.InterfaceC1221a
    /* renamed from: a */
    public int mo10595a() {
        C1210e c1210e = this.f5921i;
        if (c1210e == null) {
            return 0;
        }
        if (f5915c <= 1) {
            MapRenderer.nativeResize(c1210e.f6011j, f5913a, f5914b);
            f5915c++;
        }
        return MapRenderer.nativeRender(this.f5921i.f6011j);
    }

    /* renamed from: a */
    public void m10787a(int i) {
        synchronized (this.f5921i) {
            if (this.f5921i.f6009h != null) {
                for (InterfaceC1219k interfaceC1219k : this.f5921i.f6009h) {
                    if (interfaceC1219k != null) {
                        interfaceC1219k.mo10603f();
                    }
                }
            }
            if (this.f5921i != null) {
                this.f5921i.m10705b(this.f5917e);
                this.f5921i.m10708b(i);
                this.f5921i = null;
            }
            this.f5917e.removeCallbacksAndMessages(null);
            if (this.f5920h != null) {
                this.f5920h.m10598c();
                this.f5920h = null;
            }
            if (this.f5919g != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.f5919g.release();
                }
                this.f5919g = null;
            }
        }
    }

    /* renamed from: a */
    public void m10784a(String str, Rect rect) {
        C1210e c1210e = this.f5921i;
        if (c1210e == null || c1210e.f6010i == null) {
            return;
        }
        if (rect == null) {
            this.f5921i.f6010i.m10035a(str, (Bundle) null);
            C1220l c1220l = this.f5920h;
            if (c1220l != null) {
                c1220l.m10602a();
                return;
            }
            return;
        }
        int i = rect.left;
        int i2 = f5914b < rect.bottom ? 0 : f5914b - rect.bottom;
        int width = rect.width();
        int height = rect.height();
        if (i < 0 || i2 < 0 || width <= 0 || height <= 0) {
            return;
        }
        if (width > f5913a) {
            width = Math.abs(rect.width()) - (rect.right - f5913a);
        }
        if (height > f5914b) {
            height = Math.abs(rect.height()) - (rect.bottom - f5914b);
        }
        if (i > SysOSUtil.getScreenSizeX() || i2 > SysOSUtil.getScreenSizeY()) {
            this.f5921i.f6010i.m10035a(str, (Bundle) null);
            C1220l c1220l2 = this.f5920h;
            if (c1220l2 != null) {
                c1220l2.m10602a();
                return;
            }
            return;
        }
        f5913a = width;
        f5914b = height;
        Bundle bundle = new Bundle();
        bundle.putInt(GroupChatInvitation.ELEMENT_NAME, i);
        bundle.putInt("y", i2);
        bundle.putInt("width", width);
        bundle.putInt("height", height);
        this.f5921i.f6010i.m10035a(str, bundle);
        C1220l c1220l3 = this.f5920h;
        if (c1220l3 != null) {
            c1220l3.m10602a();
        }
    }

    /* renamed from: b */
    public C1210e m10783b() {
        return this.f5921i;
    }

    /* renamed from: c */
    public void m10781c() {
        C1210e c1210e = this.f5921i;
        if (c1210e == null || c1210e.f6010i == null) {
            return;
        }
        if (this.f5921i.f6009h != null) {
            for (InterfaceC1219k interfaceC1219k : this.f5921i.f6009h) {
                if (interfaceC1219k != null) {
                    interfaceC1219k.mo10607d();
                }
            }
        }
        this.f5921i.f6010i.m10002g();
        this.f5921i.f6010i.m10014d();
        this.f5921i.f6010i.m9993n();
        C1220l c1220l = this.f5920h;
        if (c1220l != null) {
            c1220l.m10602a();
        }
        if (this.f5921i.m10710b()) {
            this.f5918f = true;
        }
    }

    /* renamed from: d */
    public void m10780d() {
        C1210e c1210e = this.f5921i;
        if (c1210e == null || c1210e.f6010i == null) {
            return;
        }
        this.f5918f = false;
        this.f5921i.f6010i.m10019c();
        synchronized (this.f5921i) {
            this.f5921i.f6010i.m10019c();
            if (this.f5920h != null) {
                this.f5920h.m10600b();
            }
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        C1210e c1210e = this.f5921i;
        if (c1210e == null || c1210e.f6010i == null || !this.f5921i.f6012k) {
            return true;
        }
        GeoPoint m10707b = this.f5921i.m10707b((int) motionEvent.getX(), (int) motionEvent.getY());
        if (m10707b != null) {
            if (this.f5921i.f6009h != null) {
                for (InterfaceC1219k interfaceC1219k : this.f5921i.f6009h) {
                    if (interfaceC1219k != null) {
                        interfaceC1219k.mo10613b(m10707b);
                    }
                }
            }
            if (this.f5921i.f6007f) {
                C1236z m10753E = this.f5921i.m10753E();
                m10753E.f6114a += 1.0f;
                if (!this.f5921i.f6008g) {
                    m10753E.f6117d = m10707b.getLongitudeE6();
                    m10753E.f6118e = m10707b.getLatitudeE6();
                }
                BaiduMap.mapStatusReason |= 1;
                this.f5921i.m10716a(m10753E, 300);
                C1210e.f5957m = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        C1210e c1210e = this.f5921i;
        if (c1210e == null || c1210e.f6010i == null || !this.f5921i.f6012k) {
            return true;
        }
        if (this.f5921i.f6006e) {
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            if (sqrt <= 500.0f) {
                return false;
            }
            BaiduMap.mapStatusReason |= 1;
            this.f5921i.m10757A();
            this.f5921i.m10733a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
            this.f5921i.m10746L();
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        C1210e c1210e = this.f5921i;
        if (c1210e == null || c1210e.f6010i == null || !this.f5921i.f6012k) {
            return;
        }
        String m10046a = this.f5921i.f6010i.m10046a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f5921i.f6013l);
        if (this.f5921i.f6009h == null) {
            return;
        }
        if (m10046a == null || m10046a.equals("")) {
            for (InterfaceC1219k interfaceC1219k : this.f5921i.f6009h) {
                GeoPoint m10707b = this.f5921i.m10707b((int) motionEvent.getX(), (int) motionEvent.getY());
                if (interfaceC1219k != null) {
                    interfaceC1219k.mo10609c(m10707b);
                }
            }
            return;
        }
        for (InterfaceC1219k interfaceC1219k2 : this.f5921i.f6009h) {
            if (interfaceC1219k2.mo10611b(m10046a)) {
                this.f5921i.f6016p = true;
            } else {
                interfaceC1219k2.mo10609c(this.f5921i.m10707b((int) motionEvent.getX(), (int) motionEvent.getY()));
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onSingleTapConfirmed(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f5921i
            r1 = 1
            if (r0 == 0) goto La5
            com.baidu.mapsdkplatform.comjni.map.basemap.a r0 = r0.f6010i
            if (r0 == 0) goto La5
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f5921i
            boolean r0 = r0.f6012k
            if (r0 != 0) goto L11
            goto La5
        L11:
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f5921i
            java.util.List<com.baidu.mapsdkplatform.comapi.map.k> r0 = r0.f6009h
            if (r0 != 0) goto L18
            return r1
        L18:
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f5921i
            com.baidu.mapsdkplatform.comjni.map.basemap.a r0 = r0.f6010i
            r2 = -1
            float r3 = r7.getX()
            int r3 = (int) r3
            float r4 = r7.getY()
            int r4 = (int) r4
            com.baidu.mapsdkplatform.comapi.map.e r5 = r6.f5921i
            int r5 = r5.f6013l
            java.lang.String r0 = r0.m10046a(r2, r3, r4, r5)
            r2 = 0
            if (r0 == 0) goto L7b
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L7b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L56
            r3.<init>(r0)     // Catch: org.json.JSONException -> L56
            java.lang.String r0 = "px"
            float r2 = r7.getX()     // Catch: org.json.JSONException -> L54
            int r2 = (int) r2     // Catch: org.json.JSONException -> L54
            r3.put(r0, r2)     // Catch: org.json.JSONException -> L54
            java.lang.String r0 = "py"
            float r7 = r7.getY()     // Catch: org.json.JSONException -> L54
            int r7 = (int) r7     // Catch: org.json.JSONException -> L54
            r3.put(r0, r7)     // Catch: org.json.JSONException -> L54
            goto L5b
        L54:
            r7 = move-exception
            goto L58
        L56:
            r7 = move-exception
            r3 = r2
        L58:
            r7.printStackTrace()
        L5b:
            com.baidu.mapsdkplatform.comapi.map.e r7 = r6.f5921i
            java.util.List<com.baidu.mapsdkplatform.comapi.map.k> r7 = r7.f6009h
            java.util.Iterator r7 = r7.iterator()
        L63:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto La5
            java.lang.Object r0 = r7.next()
            com.baidu.mapsdkplatform.comapi.map.k r0 = (com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k) r0
            if (r3 == 0) goto L63
            if (r0 == 0) goto L63
            java.lang.String r2 = r3.toString()
            r0.mo10617a(r2)
            goto L63
        L7b:
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f5921i
            java.util.List<com.baidu.mapsdkplatform.comapi.map.k> r0 = r0.f6009h
            java.util.Iterator r0 = r0.iterator()
        L83:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto La5
            java.lang.Object r2 = r0.next()
            com.baidu.mapsdkplatform.comapi.map.k r2 = (com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k) r2
            if (r2 == 0) goto L83
            com.baidu.mapsdkplatform.comapi.map.e r3 = r6.f5921i
            float r4 = r7.getX()
            int r4 = (int) r4
            float r5 = r7.getY()
            int r5 = (int) r5
            com.baidu.mapapi.model.inner.GeoPoint r3 = r3.m10707b(r4, r5)
            r2.mo10619a(r3)
            goto L83
        La5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.GestureDetector$OnDoubleTapListenerC1196A.onSingleTapConfirmed(android.view.MotionEvent):boolean");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f5921i == null) {
            return;
        }
        SurfaceTexture surfaceTexture2 = this.f5919g;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.f5919g = surfaceTexture;
        this.f5920h = new C1220l(this.f5919g, this, new AtomicBoolean(true), this);
        this.f5920h.start();
        f5913a = i;
        f5914b = i2;
        C1236z m10753E = this.f5921i.m10753E();
        if (m10753E == null) {
            return;
        }
        if (m10753E.f6119f == 0 || m10753E.f6119f == -1 || m10753E.f6119f == (m10753E.f6123j.left - m10753E.f6123j.right) / 2) {
            m10753E.f6119f = -1;
        }
        if (m10753E.f6120g == 0 || m10753E.f6120g == -1 || m10753E.f6120g == (m10753E.f6123j.bottom - m10753E.f6123j.top) / 2) {
            m10753E.f6120g = -1;
        }
        m10753E.f6123j.left = 0;
        m10753E.f6123j.top = 0;
        m10753E.f6123j.bottom = i2;
        m10753E.f6123j.right = i;
        this.f5921i.m10717a(m10753E);
        this.f5921i.m10734a(f5913a, f5914b);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        C1210e c1210e = this.f5921i;
        if (c1210e == null) {
            return;
        }
        f5913a = i;
        f5914b = i2;
        f5915c = 1;
        C1236z m10753E = c1210e.m10753E();
        if (m10753E.f6119f == 0 || m10753E.f6119f == -1 || m10753E.f6119f == (m10753E.f6123j.left - m10753E.f6123j.right) / 2) {
            m10753E.f6119f = -1;
        }
        if (m10753E.f6120g == 0 || m10753E.f6120g == -1 || m10753E.f6120g == (m10753E.f6123j.bottom - m10753E.f6123j.top) / 2) {
            m10753E.f6120g = -1;
        }
        m10753E.f6123j.left = 0;
        m10753E.f6123j.top = 0;
        m10753E.f6123j.bottom = i2;
        m10753E.f6123j.right = i;
        this.f5921i.m10717a(m10753E);
        this.f5921i.m10734a(f5913a, f5914b);
        MapRenderer.nativeResize(this.f5921i.f6011j, i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        C1220l c1220l;
        if (!this.f5918f || (c1220l = this.f5920h) == null) {
            return;
        }
        c1220l.m10602a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1210e c1210e = this.f5921i;
        if (c1210e == null || c1210e.f6010i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        if (this.f5921i.f6009h != null) {
            for (InterfaceC1219k interfaceC1219k : this.f5921i.f6009h) {
                if (interfaceC1219k != null) {
                    interfaceC1219k.mo10620a(motionEvent);
                }
            }
        }
        if (this.f5916d.onTouchEvent(motionEvent)) {
            return true;
        }
        return this.f5921i.m10725a(motionEvent);
    }
}
