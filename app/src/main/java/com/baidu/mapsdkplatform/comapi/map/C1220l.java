package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

@SuppressLint({"NewApi"})
/* renamed from: com.baidu.mapsdkplatform.comapi.map.l */
/* loaded from: classes.dex */
public class C1220l extends Thread {

    /* renamed from: a */
    private AtomicBoolean f6060a;

    /* renamed from: b */
    private SurfaceTexture f6061b;

    /* renamed from: c */
    private InterfaceC1221a f6062c;

    /* renamed from: d */
    private EGL10 f6063d;

    /* renamed from: h */
    private GL10 f6067h;

    /* renamed from: k */
    private final GestureDetector$OnDoubleTapListenerC1196A f6070k;

    /* renamed from: e */
    private EGLDisplay f6064e = EGL10.EGL_NO_DISPLAY;

    /* renamed from: f */
    private EGLContext f6065f = EGL10.EGL_NO_CONTEXT;

    /* renamed from: g */
    private EGLSurface f6066g = EGL10.EGL_NO_SURFACE;

    /* renamed from: i */
    private int f6068i = 1;

    /* renamed from: j */
    private boolean f6069j = false;

    /* renamed from: com.baidu.mapsdkplatform.comapi.map.l$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1221a {
        /* renamed from: a */
        int mo10595a();
    }

    public C1220l(SurfaceTexture surfaceTexture, InterfaceC1221a interfaceC1221a, AtomicBoolean atomicBoolean, GestureDetector$OnDoubleTapListenerC1196A gestureDetector$OnDoubleTapListenerC1196A) {
        this.f6061b = surfaceTexture;
        this.f6062c = interfaceC1221a;
        this.f6060a = atomicBoolean;
        this.f6070k = gestureDetector$OnDoubleTapListenerC1196A;
    }

    /* renamed from: a */
    private boolean m10601a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f6063d = (EGL10) EGLContext.getEGL();
        this.f6064e = this.f6063d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f6064e == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.f6063d.eglGetError()));
        } else if (!this.f6063d.eglInitialize(this.f6064e, new int[2])) {
            throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.f6063d.eglGetError()));
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[100];
            int[] iArr = new int[1];
            if (!this.f6063d.eglChooseConfig(this.f6064e, new int[]{12352, 4, 12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, eGLConfigArr, 100, iArr) || iArr[0] <= 0) {
                return false;
            }
            this.f6065f = this.f6063d.eglCreateContext(this.f6064e, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.f6066g = this.f6063d.eglCreateWindowSurface(this.f6064e, eGLConfigArr[0], this.f6061b, null);
            if (this.f6066g == EGL10.EGL_NO_SURFACE || this.f6065f == EGL10.EGL_NO_CONTEXT) {
                if (this.f6063d.eglGetError() == 12299) {
                    throw new RuntimeException("eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                }
                GLUtils.getEGLErrorString(this.f6063d.eglGetError());
            }
            EGL10 egl10 = this.f6063d;
            EGLDisplay eGLDisplay = this.f6064e;
            EGLSurface eGLSurface = this.f6066g;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f6065f)) {
                this.f6067h = (GL10) this.f6065f.getGL();
                return true;
            }
            throw new RuntimeException("eglMakeCurrent failed : ".concat(String.valueOf(GLUtils.getEGLErrorString(this.f6063d.eglGetError()))));
        }
    }

    /* renamed from: b */
    private static boolean m10599b(int i, int i2, int i3, int i4, int i5, int i6) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
    }

    /* renamed from: d */
    private void m10597d() {
        try {
            if (m10599b(5, 6, 5, 0, 24, 0)) {
                m10601a(8, 8, 8, 0, 24, 0);
            } else {
                m10601a(8, 8, 8, 0, 24, 0);
            }
        } catch (IllegalArgumentException unused) {
            m10601a(8, 8, 8, 0, 24, 0);
        }
        MapRenderer.nativeInit(this.f6070k.m10783b().f6011j);
        MapRenderer.nativeResize(this.f6070k.m10783b().f6011j, GestureDetector$OnDoubleTapListenerC1196A.f5913a, GestureDetector$OnDoubleTapListenerC1196A.f5914b);
    }

    /* renamed from: e */
    private void m10596e() {
        if (this.f6066g != EGL10.EGL_NO_SURFACE) {
            EGL10 egl10 = this.f6063d;
            EGLDisplay eGLDisplay = this.f6064e;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.f6063d.eglDestroySurface(this.f6064e, this.f6066g);
            this.f6066g = EGL10.EGL_NO_SURFACE;
        }
        if (this.f6065f != EGL10.EGL_NO_CONTEXT) {
            this.f6063d.eglDestroyContext(this.f6064e, this.f6065f);
            this.f6065f = EGL10.EGL_NO_CONTEXT;
        }
        if (this.f6064e != EGL10.EGL_NO_DISPLAY) {
            this.f6063d.eglTerminate(this.f6064e);
            this.f6064e = EGL10.EGL_NO_DISPLAY;
        }
    }

    /* renamed from: a */
    public void m10602a() {
        this.f6068i = 1;
        this.f6069j = false;
        synchronized (this) {
            if (getState() == Thread.State.WAITING) {
                notify();
            }
        }
    }

    /* renamed from: b */
    public void m10600b() {
        this.f6068i = 0;
        synchronized (this) {
            this.f6069j = true;
        }
    }

    /* renamed from: c */
    public void m10598c() {
        this.f6069j = true;
        synchronized (this) {
            if (getState() == Thread.State.WAITING) {
                notify();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        m10597d();
        while (this.f6062c != null) {
            if (this.f6068i == 1 && !this.f6069j) {
                if (this.f6070k.m10783b() == null) {
                    break;
                }
                synchronized (this.f6070k.m10783b()) {
                    synchronized (this) {
                        if (!this.f6069j) {
                            this.f6068i = this.f6062c.mo10595a();
                        }
                    }
                    if (this.f6070k.m10783b().f6009h != null) {
                        for (InterfaceC1219k interfaceC1219k : this.f6070k.m10783b().f6009h) {
                            if (interfaceC1219k != null) {
                                C1236z m10749I = this.f6070k.m10783b().m10749I();
                                if (this.f6067h == null) {
                                    return;
                                }
                                if (interfaceC1219k != null) {
                                    interfaceC1219k.mo10616a(this.f6067h, m10749I);
                                }
                            }
                        }
                    }
                    this.f6063d.eglSwapBuffers(this.f6064e, this.f6066g);
                }
            } else {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (this.f6069j) {
                break;
            }
        }
        m10596e();
    }
}
