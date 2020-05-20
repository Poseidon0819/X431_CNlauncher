package com.baidu.mapsdkplatform.comapi.map;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.itextpdf.text.pdf.ColumnText;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class MapRenderer implements GLSurfaceView.Renderer {

    /* renamed from: d */
    private static final String f5942d = "MapRenderer";

    /* renamed from: a */
    public int f5943a;

    /* renamed from: b */
    public int f5944b;

    /* renamed from: c */
    public int f5945c;

    /* renamed from: e */
    private long f5946e;

    /* renamed from: f */
    private InterfaceC1205a f5947f;

    /* renamed from: g */
    private final GestureDetector$OnDoubleTapListenerC1216j f5948g;

    /* renamed from: com.baidu.mapsdkplatform.comapi.map.MapRenderer$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1205a {
        /* renamed from: f */
        void mo10625f();
    }

    public MapRenderer(GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j, InterfaceC1205a interfaceC1205a) {
        this.f5947f = interfaceC1205a;
        this.f5948g = gestureDetector$OnDoubleTapListenerC1216j;
    }

    /* renamed from: a */
    private void m10758a(GL10 gl10) {
        GLES20.glClear(16640);
        GLES20.glClearColor(0.85f, 0.8f, 0.8f, ColumnText.GLOBAL_SPACE_CHAR_RATIO);
    }

    /* renamed from: a */
    private boolean m10760a() {
        return this.f5946e != 0;
    }

    public static native void nativeInit(long j);

    public static native int nativeRender(long j);

    public static native void nativeResize(long j, int i, int i2);

    /* renamed from: a */
    public void m10759a(long j) {
        this.f5946e = j;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (!m10760a()) {
            m10758a(gl10);
            return;
        }
        if (this.f5945c <= 1) {
            nativeResize(this.f5946e, this.f5943a, this.f5944b);
            this.f5945c++;
        }
        this.f5947f.mo10625f();
        int nativeRender = nativeRender(this.f5946e);
        if (this.f5948g.m10642a() == null) {
            return;
        }
        if (this.f5948g.m10642a().f6009h != null) {
            for (InterfaceC1219k interfaceC1219k : this.f5948g.m10642a().f6009h) {
                if (this.f5948g.m10642a() == null) {
                    return;
                }
                C1236z m10749I = this.f5948g.m10642a().m10749I();
                if (interfaceC1219k != null) {
                    interfaceC1219k.mo10616a(gl10, m10749I);
                }
            }
        }
        GestureDetector$OnDoubleTapListenerC1216j gestureDetector$OnDoubleTapListenerC1216j = this.f5948g;
        if (nativeRender == 1) {
            gestureDetector$OnDoubleTapListenerC1216j.requestRender();
        } else if (gestureDetector$OnDoubleTapListenerC1216j.m10642a().m10710b()) {
            if (gestureDetector$OnDoubleTapListenerC1216j.getRenderMode() != 1) {
                gestureDetector$OnDoubleTapListenerC1216j.setRenderMode(1);
            }
        } else if (gestureDetector$OnDoubleTapListenerC1216j.getRenderMode() != 0) {
            gestureDetector$OnDoubleTapListenerC1216j.setRenderMode(0);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        long j = this.f5946e;
        if (j != 0) {
            nativeResize(j, i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        nativeInit(this.f5946e);
        if (m10760a()) {
            this.f5947f.mo10625f();
        }
    }
}
