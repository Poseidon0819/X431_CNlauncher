package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.MapRenderer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import org.jivesoftware.smackx.GroupChatInvitation;

@SuppressLint({"NewApi"})
/* renamed from: com.baidu.mapsdkplatform.comapi.map.j */
/* loaded from: classes.dex */
public class GestureDetector$OnDoubleTapListenerC1216j extends GLSurfaceView implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, MapRenderer.InterfaceC1205a {

    /* renamed from: a */
    private static final String f6044a = "j";

    /* renamed from: b */
    private Handler f6045b;

    /* renamed from: c */
    private MapRenderer f6046c;

    /* renamed from: d */
    private int f6047d;

    /* renamed from: e */
    private int f6048e;

    /* renamed from: f */
    private GestureDetector f6049f;

    /* renamed from: g */
    private C1210e f6050g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mapsdkplatform.comapi.map.j$a */
    /* loaded from: classes.dex */
    public static class C1218a {

        /* renamed from: a */
        float f6052a;

        /* renamed from: b */
        float f6053b;

        /* renamed from: c */
        float f6054c;

        /* renamed from: d */
        float f6055d;

        /* renamed from: e */
        boolean f6056e;

        /* renamed from: f */
        float f6057f;

        /* renamed from: g */
        float f6058g;

        /* renamed from: h */
        double f6059h;

        public String toString() {
            return "MultiTouch{x1=" + this.f6052a + ", x2=" + this.f6053b + ", y1=" + this.f6054c + ", y2=" + this.f6055d + ", mTwoTouch=" + this.f6056e + ", centerX=" + this.f6057f + ", centerY=" + this.f6058g + ", length=" + this.f6059h + '}';
        }
    }

    public GestureDetector$OnDoubleTapListenerC1216j(Context context, C1234x c1234x, String str, int i) {
        super(context);
        if (context == null) {
            throw new RuntimeException("when you create an mapview, the context can not be null");
        }
        setEGLContextClientVersion(2);
        this.f6049f = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.f6050g == null) {
            this.f6050g = new C1210e(context, str, i);
        }
        this.f6050g.m10735a(context.hashCode());
        m10624g();
        this.f6050g.m10738a();
        this.f6050g.m10718a(c1234x);
        m10623h();
        this.f6050g.m10726a(this.f6045b);
        this.f6050g.m10686f();
        setBackgroundColor(0);
    }

    /* renamed from: a */
    private static boolean m10638a(int i, int i2, int i3, int i4, int i5, int i6) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
    }

    /* renamed from: g */
    private void m10624g() {
        try {
            if (m10638a(8, 8, 8, 8, 24, 0)) {
                setEGLConfigChooser(8, 8, 8, 8, 24, 0);
            } else if (m10638a(5, 6, 5, 0, 24, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 24, 0);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException unused) {
            setEGLConfigChooser(true);
        }
        this.f6046c = new MapRenderer(this, this);
        this.f6046c.m10759a(this.f6050g.f6011j);
        setRenderer(this.f6046c);
        setRenderMode(1);
    }

    /* renamed from: h */
    private void m10623h() {
        this.f6045b = new Handler() { // from class: com.baidu.mapsdkplatform.comapi.map.j.1
            @Override // android.os.Handler
            public void handleMessage(Message message2) {
                super.handleMessage(message2);
                if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g != null && ((Long) message2.obj).longValue() == GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6011j) {
                    if (message2.what == 4000) {
                        if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h == null) {
                            return;
                        }
                        for (InterfaceC1219k interfaceC1219k : GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h) {
                            Bitmap bitmap = null;
                            if (message2.arg2 == 1) {
                                int[] iArr = new int[GestureDetector$OnDoubleTapListenerC1216j.this.f6047d * GestureDetector$OnDoubleTapListenerC1216j.this.f6048e];
                                int[] iArr2 = new int[GestureDetector$OnDoubleTapListenerC1216j.this.f6047d * GestureDetector$OnDoubleTapListenerC1216j.this.f6048e];
                                if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6010i == null) {
                                    return;
                                }
                                int[] m10030a = GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6010i.m10030a(iArr, GestureDetector$OnDoubleTapListenerC1216j.this.f6047d, GestureDetector$OnDoubleTapListenerC1216j.this.f6048e);
                                for (int i = 0; i < GestureDetector$OnDoubleTapListenerC1216j.this.f6048e; i++) {
                                    for (int i2 = 0; i2 < GestureDetector$OnDoubleTapListenerC1216j.this.f6047d; i2++) {
                                        int i3 = m10030a[(GestureDetector$OnDoubleTapListenerC1216j.this.f6047d * i) + i2];
                                        iArr2[(((GestureDetector$OnDoubleTapListenerC1216j.this.f6048e - i) - 1) * GestureDetector$OnDoubleTapListenerC1216j.this.f6047d) + i2] = (i3 & (-16711936)) | ((i3 << 16) & 16711680) | ((i3 >> 16) & 255);
                                    }
                                }
                                bitmap = Bitmap.createBitmap(iArr2, GestureDetector$OnDoubleTapListenerC1216j.this.f6047d, GestureDetector$OnDoubleTapListenerC1216j.this.f6048e, Bitmap.Config.RGB_565);
                            }
                            if (interfaceC1219k != null) {
                                interfaceC1219k.mo10621a(bitmap);
                            }
                        }
                    } else if (message2.what != 39) {
                        if (message2.what == 41) {
                            if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g == null || GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h == null) {
                                return;
                            }
                            if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6014n || GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6015o) {
                                for (InterfaceC1219k interfaceC1219k2 : GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h) {
                                    if (interfaceC1219k2 != null) {
                                        interfaceC1219k2.mo10612b(GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10753E());
                                        if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10662q()) {
                                            if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10753E().f6114a >= 18.0f) {
                                                interfaceC1219k2.mo10615a(true);
                                            } else {
                                                interfaceC1219k2.mo10615a(false);
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (message2.what == 999) {
                            if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h == null) {
                                return;
                            }
                            for (InterfaceC1219k interfaceC1219k3 : GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h) {
                                if (interfaceC1219k3 != null) {
                                    interfaceC1219k3.mo10605e();
                                }
                            }
                        } else if (message2.what == 50 && GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h != null) {
                            for (InterfaceC1219k interfaceC1219k4 : GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h) {
                                if (interfaceC1219k4 != null) {
                                    if (message2.arg1 != 0) {
                                        if (message2.arg1 == 1) {
                                            if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10753E().f6114a >= 18.0f) {
                                                interfaceC1219k4.mo10615a(true);
                                            }
                                        }
                                    }
                                    interfaceC1219k4.mo10615a(false);
                                }
                            }
                        }
                    } else if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g != null && GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h != null) {
                        if (message2.arg1 == 100) {
                            GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10756B();
                        } else if (message2.arg1 == 200) {
                            GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10747K();
                        } else if (message2.arg1 == 1) {
                            GestureDetector$OnDoubleTapListenerC1216j.this.requestRender();
                        } else if (message2.arg1 == 0) {
                            GestureDetector$OnDoubleTapListenerC1216j.this.requestRender();
                            if (!GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10710b() && GestureDetector$OnDoubleTapListenerC1216j.this.getRenderMode() != 0) {
                                GestureDetector$OnDoubleTapListenerC1216j.this.setRenderMode(0);
                            }
                        } else if (message2.arg1 == 2) {
                            if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h == null) {
                                return;
                            }
                            for (InterfaceC1219k interfaceC1219k5 : GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h) {
                                if (interfaceC1219k5 != null) {
                                    interfaceC1219k5.mo10610c();
                                }
                            }
                        }
                        if (!GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6012k && GestureDetector$OnDoubleTapListenerC1216j.this.f6048e > 0 && GestureDetector$OnDoubleTapListenerC1216j.this.f6047d > 0 && GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10707b(0, 0) != null) {
                            GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6012k = true;
                            for (InterfaceC1219k interfaceC1219k6 : GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h) {
                                if (interfaceC1219k6 != null) {
                                    interfaceC1219k6.mo10614b();
                                }
                            }
                        }
                        for (InterfaceC1219k interfaceC1219k7 : GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h) {
                            if (interfaceC1219k7 != null) {
                                interfaceC1219k7.mo10622a();
                            }
                        }
                        if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10662q()) {
                            for (InterfaceC1219k interfaceC1219k8 : GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.f6009h) {
                                if (GestureDetector$OnDoubleTapListenerC1216j.this.f6050g.m10753E().f6114a >= 18.0f) {
                                    if (interfaceC1219k8 != null) {
                                        interfaceC1219k8.mo10615a(true);
                                    }
                                } else if (interfaceC1219k8 != null) {
                                    interfaceC1219k8.mo10615a(false);
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    /* renamed from: a */
    public C1210e m10642a() {
        return this.f6050g;
    }

    /* renamed from: a */
    public void m10641a(float f, float f2) {
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return;
        }
        this.f6050g.m10709b(f, f2);
    }

    /* renamed from: a */
    public void m10639a(int i) {
        int i2;
        if (this.f6050g == null) {
            return;
        }
        Message message2 = new Message();
        message2.what = 50;
        message2.obj = Long.valueOf(this.f6050g.f6011j);
        boolean m10662q = this.f6050g.m10662q();
        if (i != 3) {
            i2 = m10662q ? 1 : 1;
            this.f6045b.sendMessage(message2);
        }
        i2 = 0;
        message2.arg1 = i2;
        this.f6045b.sendMessage(message2);
    }

    /* renamed from: a */
    public void m10636a(String str, Rect rect) {
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return;
        }
        if (rect != null) {
            int i = rect.left;
            int i2 = this.f6048e < rect.bottom ? 0 : this.f6048e - rect.bottom;
            int width = rect.width();
            int height = rect.height();
            if (i < 0 || i2 < 0 || width <= 0 || height <= 0) {
                return;
            }
            if (width > this.f6047d) {
                width = Math.abs(rect.width()) - (rect.right - this.f6047d);
            }
            if (height > this.f6048e) {
                height = Math.abs(rect.height()) - (rect.bottom - this.f6048e);
            }
            if (i <= SysOSUtil.getScreenSizeX() && i2 <= SysOSUtil.getScreenSizeY()) {
                this.f6047d = width;
                this.f6048e = height;
                Bundle bundle = new Bundle();
                bundle.putInt(GroupChatInvitation.ELEMENT_NAME, i);
                bundle.putInt("y", i2);
                bundle.putInt("width", width);
                bundle.putInt("height", height);
                this.f6050g.f6010i.m10035a(str, bundle);
                requestRender();
            }
        }
        this.f6050g.f6010i.m10035a(str, (Bundle) null);
        requestRender();
    }

    /* renamed from: a */
    public boolean m10640a(float f, float f2, float f3, float f4) {
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return false;
        }
        return this.f6050g.m10736a(f, f2, f3, f4);
    }

    /* renamed from: b */
    public void m10635b() {
        C1210e c1210e = this.f6050g;
        if (c1210e == null) {
            return;
        }
        c1210e.m10654u();
    }

    /* renamed from: b */
    public void m10633b(int i) {
        C1210e c1210e = this.f6050g;
        if (c1210e != null) {
            if (c1210e.f6009h != null) {
                for (InterfaceC1219k interfaceC1219k : this.f6050g.f6009h) {
                    if (interfaceC1219k != null) {
                        interfaceC1219k.mo10603f();
                    }
                }
            }
            this.f6050g.m10705b(this.f6045b);
            this.f6050g.m10708b(i);
            this.f6050g = null;
        }
        Handler handler = this.f6045b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: b */
    public boolean m10634b(float f, float f2) {
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return false;
        }
        return this.f6050g.m10694d(f, f2);
    }

    /* renamed from: c */
    public void m10631c() {
        C1210e c1210e = this.f6050g;
        if (c1210e == null) {
            return;
        }
        c1210e.m10652v();
    }

    /* renamed from: c */
    public boolean m10630c(float f, float f2) {
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return false;
        }
        return this.f6050g.m10700c(f, f2);
    }

    /* renamed from: d */
    public void m10628d() {
        getHolder().setFormat(-3);
        this.f6050g.f6010i.m9988s();
    }

    /* renamed from: d */
    public boolean m10627d(float f, float f2) {
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return false;
        }
        return this.f6050g.m10699c((int) f, (int) f2);
    }

    /* renamed from: e */
    public void m10626e() {
        getHolder().setFormat(-1);
        this.f6050g.f6010i.m9987t();
    }

    @Override // com.baidu.mapsdkplatform.comapi.map.MapRenderer.InterfaceC1205a
    /* renamed from: f */
    public void mo10625f() {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null || !this.f6050g.f6012k) {
            return true;
        }
        GeoPoint m10707b = this.f6050g.m10707b((int) motionEvent.getX(), (int) motionEvent.getY());
        if (m10707b != null) {
            if (this.f6050g.f6009h != null) {
                for (InterfaceC1219k interfaceC1219k : this.f6050g.f6009h) {
                    if (interfaceC1219k != null) {
                        interfaceC1219k.mo10613b(m10707b);
                    }
                }
            }
            if (this.f6050g.f6007f) {
                C1236z m10753E = this.f6050g.m10753E();
                m10753E.f6114a += 1.0f;
                if (!this.f6050g.f6008g) {
                    m10753E.f6117d = m10707b.getLongitudeE6();
                    m10753E.f6118e = m10707b.getLatitudeE6();
                }
                BaiduMap.mapStatusReason |= 1;
                this.f6050g.m10716a(m10753E, 300);
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
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null || !this.f6050g.f6012k) {
            return true;
        }
        if (this.f6050g.f6006e) {
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            if (sqrt <= 500.0f) {
                return false;
            }
            BaiduMap.mapStatusReason |= 1;
            this.f6050g.m10757A();
            this.f6050g.m10733a(34, (int) (sqrt * 0.6f), ((int) motionEvent2.getX()) | (((int) motionEvent2.getY()) << 16));
            this.f6050g.m10746L();
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null || !this.f6050g.f6012k) {
            return;
        }
        String m10046a = this.f6050g.f6010i.m10046a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.f6050g.f6013l);
        if (m10046a == null || m10046a.equals("")) {
            if (this.f6050g.f6009h != null) {
                for (InterfaceC1219k interfaceC1219k : this.f6050g.f6009h) {
                    GeoPoint m10707b = this.f6050g.m10707b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (interfaceC1219k != null) {
                        interfaceC1219k.mo10609c(m10707b);
                    }
                }
            }
        } else if (this.f6050g.f6009h != null) {
            for (InterfaceC1219k interfaceC1219k2 : this.f6050g.f6009h) {
                if (interfaceC1219k2 != null) {
                    if (interfaceC1219k2.mo10611b(m10046a)) {
                        this.f6050g.f6016p = true;
                    } else {
                        interfaceC1219k2.mo10609c(this.f6050g.m10707b((int) motionEvent.getX(), (int) motionEvent.getY()));
                    }
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        super.onPause();
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return;
        }
        this.f6050g.f6010i.m10019c();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return;
        }
        if (this.f6050g.f6009h != null) {
            for (InterfaceC1219k interfaceC1219k : this.f6050g.f6009h) {
                if (interfaceC1219k != null) {
                    interfaceC1219k.mo10607d();
                }
            }
        }
        this.f6050g.f6010i.m10002g();
        this.f6050g.f6010i.m10014d();
        this.f6050g.f6010i.m9993n();
        setRenderMode(1);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onSingleTapConfirmed(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f6050g
            r1 = 1
            if (r0 == 0) goto Laa
            com.baidu.mapsdkplatform.comjni.map.basemap.a r0 = r0.f6010i
            if (r0 == 0) goto Laa
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f6050g
            boolean r0 = r0.f6012k
            if (r0 != 0) goto L11
            goto Laa
        L11:
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f6050g
            com.baidu.mapsdkplatform.comjni.map.basemap.a r0 = r0.f6010i
            r2 = -1
            float r3 = r7.getX()
            int r3 = (int) r3
            float r4 = r7.getY()
            int r4 = (int) r4
            com.baidu.mapsdkplatform.comapi.map.e r5 = r6.f6050g
            int r5 = r5.f6013l
            java.lang.String r0 = r0.m10046a(r2, r3, r4, r5)
            r2 = 0
            if (r0 == 0) goto L7a
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L7a
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4f
            r3.<init>(r0)     // Catch: org.json.JSONException -> L4f
            java.lang.String r0 = "px"
            float r2 = r7.getX()     // Catch: org.json.JSONException -> L4d
            int r2 = (int) r2     // Catch: org.json.JSONException -> L4d
            r3.put(r0, r2)     // Catch: org.json.JSONException -> L4d
            java.lang.String r0 = "py"
            float r7 = r7.getY()     // Catch: org.json.JSONException -> L4d
            int r7 = (int) r7     // Catch: org.json.JSONException -> L4d
            r3.put(r0, r7)     // Catch: org.json.JSONException -> L4d
            goto L54
        L4d:
            r7 = move-exception
            goto L51
        L4f:
            r7 = move-exception
            r3 = r2
        L51:
            r7.printStackTrace()
        L54:
            com.baidu.mapsdkplatform.comapi.map.e r7 = r6.f6050g
            java.util.List<com.baidu.mapsdkplatform.comapi.map.k> r7 = r7.f6009h
            if (r7 == 0) goto Laa
            com.baidu.mapsdkplatform.comapi.map.e r7 = r6.f6050g
            java.util.List<com.baidu.mapsdkplatform.comapi.map.k> r7 = r7.f6009h
            java.util.Iterator r7 = r7.iterator()
        L62:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto Laa
            java.lang.Object r0 = r7.next()
            com.baidu.mapsdkplatform.comapi.map.k r0 = (com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k) r0
            if (r3 == 0) goto L62
            if (r0 == 0) goto L62
            java.lang.String r2 = r3.toString()
            r0.mo10617a(r2)
            goto L62
        L7a:
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f6050g
            java.util.List<com.baidu.mapsdkplatform.comapi.map.k> r0 = r0.f6009h
            if (r0 == 0) goto Laa
            com.baidu.mapsdkplatform.comapi.map.e r0 = r6.f6050g
            java.util.List<com.baidu.mapsdkplatform.comapi.map.k> r0 = r0.f6009h
            java.util.Iterator r0 = r0.iterator()
        L88:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Laa
            java.lang.Object r2 = r0.next()
            com.baidu.mapsdkplatform.comapi.map.k r2 = (com.baidu.mapsdkplatform.comapi.map.InterfaceC1219k) r2
            if (r2 == 0) goto L88
            com.baidu.mapsdkplatform.comapi.map.e r3 = r6.f6050g
            float r4 = r7.getX()
            int r4 = (int) r4
            float r5 = r7.getY()
            int r5 = (int) r5
            com.baidu.mapapi.model.inner.GeoPoint r3 = r3.m10707b(r4, r5)
            r2.mo10619a(r3)
            goto L88
        Laa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.GestureDetector$OnDoubleTapListenerC1216j.onSingleTapConfirmed(android.view.MotionEvent):boolean");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        if (this.f6050g.f6009h != null) {
            for (InterfaceC1219k interfaceC1219k : this.f6050g.f6009h) {
                if (interfaceC1219k != null) {
                    interfaceC1219k.mo10620a(motionEvent);
                }
            }
        }
        if (this.f6049f.onTouchEvent(motionEvent)) {
            return true;
        }
        return this.f6050g.m10725a(motionEvent);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        C1210e c1210e = this.f6050g;
        if (c1210e == null || c1210e.f6010i == null) {
            return;
        }
        MapRenderer mapRenderer = this.f6046c;
        mapRenderer.f5943a = i2;
        mapRenderer.f5944b = i3;
        this.f6047d = i2;
        this.f6048e = i3;
        mapRenderer.f5945c = 0;
        C1236z m10753E = this.f6050g.m10753E();
        if (m10753E.f6119f == 0 || m10753E.f6119f == -1 || m10753E.f6119f == (m10753E.f6123j.left - m10753E.f6123j.right) / 2) {
            m10753E.f6119f = -1;
        }
        if (m10753E.f6120g == 0 || m10753E.f6120g == -1 || m10753E.f6120g == (m10753E.f6123j.bottom - m10753E.f6123j.top) / 2) {
            m10753E.f6120g = -1;
        }
        m10753E.f6123j.left = 0;
        m10753E.f6123j.top = 0;
        m10753E.f6123j.bottom = i3;
        m10753E.f6123j.right = i2;
        this.f6050g.m10717a(m10753E);
        this.f6050g.m10734a(this.f6047d, this.f6048e);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        if (surfaceHolder == null || surfaceHolder.getSurface().isValid()) {
            return;
        }
        surfaceDestroyed(surfaceHolder);
    }
}
