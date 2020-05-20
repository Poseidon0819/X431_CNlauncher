package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.cnlaunch.p112a.p115c.DefaultRenderer;
import com.cnlaunch.x431pro.module.p252d.GraphConfiguration;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.l */
/* loaded from: classes.dex */
public final class DiagnoseGraphTouchUtil implements View.OnTouchListener {

    /* renamed from: b */
    public InterfaceC2096a f11754b;

    /* renamed from: c */
    public DefaultRenderer f11755c;

    /* renamed from: d */
    private int f11756d = 0;

    /* renamed from: e */
    private int f11757e = 100;

    /* renamed from: a */
    public float f11753a = 5.0f;

    /* renamed from: f */
    private PointF f11758f = new PointF();

    /* renamed from: g */
    private float f11759g = 1.0f;

    /* renamed from: h */
    private long f11760h = 0;

    /* compiled from: DiagnoseGraphTouchUtil.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.l$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2096a {
        /* renamed from: a */
        void mo7340a(View view);

        /* renamed from: a */
        void mo7337a(boolean z);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        InterfaceC2096a interfaceC2096a;
        int action = motionEvent.getAction() & 255;
        long currentTimeMillis = System.currentTimeMillis();
        switch (action) {
            case 0:
                this.f11760h = currentTimeMillis;
                this.f11758f.set(motionEvent.getX(), motionEvent.getY());
                InterfaceC2096a interfaceC2096a2 = this.f11754b;
                if (interfaceC2096a2 != null) {
                    interfaceC2096a2.mo7337a(true);
                }
                this.f11756d = 1;
                break;
            case 1:
            case 6:
                InterfaceC2096a interfaceC2096a3 = this.f11754b;
                if (interfaceC2096a3 != null) {
                    interfaceC2096a3.mo7337a(false);
                }
                int i = this.f11756d;
                if (i == 1 || i == 3) {
                    InterfaceC2096a interfaceC2096a4 = this.f11754b;
                    if (interfaceC2096a4 != null) {
                        interfaceC2096a4.mo7340a(view);
                    }
                    return true;
                }
                this.f11756d = 0;
                break;
            case 2:
                int i2 = this.f11756d;
                if (i2 == 1) {
                    this.f11756d = 3;
                    return true;
                } else if (i2 == 3 || i2 != 2 || currentTimeMillis - this.f11760h < this.f11757e) {
                    return true;
                } else {
                    this.f11760h = currentTimeMillis;
                    float m7377a = m7377a(motionEvent);
                    if (Math.abs(m7377a - this.f11759g) > this.f11753a) {
                        DefaultRenderer defaultRenderer = this.f11755c;
                        int xGridRange = defaultRenderer.getXGridRange();
                        if (m7377a / this.f11759g < 1.0f) {
                            if (xGridRange < GraphConfiguration.m5383b()) {
                                defaultRenderer.setXGridRange(xGridRange * 2);
                            }
                        } else {
                            GraphConfiguration.m5385a();
                            if (xGridRange > 180) {
                                defaultRenderer.setXGridRange(xGridRange / 2);
                            }
                        }
                        this.f11759g = m7377a;
                        view.invalidate();
                        break;
                    }
                }
                break;
            case 3:
                InterfaceC2096a interfaceC2096a5 = this.f11754b;
                if (interfaceC2096a5 != null) {
                    interfaceC2096a5.mo7337a(false);
                }
                long j = this.f11760h;
                int i3 = this.f11757e;
                if (currentTimeMillis - j > i3) {
                    int i4 = this.f11756d;
                    if (i4 == 1 || i4 == 3) {
                        InterfaceC2096a interfaceC2096a6 = this.f11754b;
                        if (interfaceC2096a6 != null) {
                            interfaceC2096a6.mo7340a(view);
                        }
                        return true;
                    }
                } else if (currentTimeMillis - j > i3 / 2 && this.f11756d == 3) {
                    PointF pointF = new PointF();
                    pointF.set(motionEvent.getX(), motionEvent.getY());
                    if (pointF.equals(this.f11758f) && (interfaceC2096a = this.f11754b) != null) {
                        interfaceC2096a.mo7340a(view);
                    }
                    return true;
                }
                this.f11756d = 0;
                break;
            case 5:
                this.f11759g = m7377a(motionEvent);
                this.f11756d = 2;
                break;
        }
        return true;
    }

    /* renamed from: a */
    private float m7377a(MotionEvent motionEvent) {
        try {
            float x = motionEvent.getX(motionEvent.getPointerId(0)) - motionEvent.getX(motionEvent.getPointerId(1));
            float y = motionEvent.getY(motionEvent.getPointerId(0)) - motionEvent.getY(motionEvent.getPointerId(1));
            return (float) Math.sqrt((x * x) + (y * y));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return this.f11759g;
        }
    }
}
