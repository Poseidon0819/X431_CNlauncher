package com.baidu.location.p078a;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.ServiceC1002f;
import com.itextpdf.text.pdf.ColumnText;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.location.a.k */
/* loaded from: classes.dex */
public class C0923k implements SensorEventListener {

    /* renamed from: a */
    private static Object f4058a = new Object();

    /* renamed from: b */
    private static C0923k f4059b = null;

    /* renamed from: c */
    private float[] f4060c;

    /* renamed from: d */
    private int f4061d = 0;

    /* renamed from: e */
    private List<Float> f4062e = new ArrayList();

    /* renamed from: f */
    private List<Float> f4063f = new ArrayList();

    /* renamed from: g */
    private boolean f4064g = false;

    /* renamed from: h */
    private boolean f4065h;

    /* renamed from: i */
    private SensorManager f4066i;

    public C0923k() {
        this.f4065h = false;
        try {
            if (this.f4066i == null) {
                this.f4066i = (SensorManager) ServiceC1002f.getServiceContext().getSystemService("sensor");
            }
            if (this.f4066i.getDefaultSensor(6) != null) {
                this.f4065h = true;
            }
        } catch (Exception unused) {
            this.f4065h = false;
        }
    }

    /* renamed from: a */
    public static C0923k m12082a() {
        C0923k c0923k;
        synchronized (f4058a) {
            if (f4059b == null) {
                f4059b = new C0923k();
            }
            c0923k = f4059b;
        }
        return c0923k;
    }

    /* renamed from: b */
    public void m12081b() {
        Sensor defaultSensor;
        if (this.f4065h && !this.f4064g) {
            try {
                this.f4061d = 0;
                this.f4062e.clear();
                this.f4063f.clear();
                if (this.f4066i == null) {
                    this.f4066i = (SensorManager) ServiceC1002f.getServiceContext().getSystemService("sensor");
                }
                if (this.f4066i != null && (defaultSensor = this.f4066i.getDefaultSensor(6)) != null) {
                    this.f4066i.registerListener(this, defaultSensor, 2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f4064g = true;
        }
    }

    /* renamed from: c */
    public void m12080c() {
        if (this.f4064g) {
            try {
                if (this.f4066i != null) {
                    this.f4066i.unregisterListener(this);
                    this.f4066i = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f4064g = false;
        }
    }

    /* renamed from: d */
    public float m12079d() {
        float f;
        synchronized (this.f4063f) {
            int abs = Math.abs(((int) (System.currentTimeMillis() / 1000)) - this.f4061d);
            f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            if (abs <= 5 && this.f4063f.size() > 0) {
                try {
                    f = this.f4063f.get(this.f4063f.size() - 1).floatValue();
                } catch (Throwable unused) {
                }
            }
        }
        return f;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 6 && this.f4064g) {
            this.f4060c = (float[]) sensorEvent.values.clone();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis == this.f4061d) {
                this.f4062e.add(Float.valueOf(this.f4060c[0]));
                return;
            }
            this.f4061d = currentTimeMillis;
            if (this.f4062e.size() > 0) {
                int size = this.f4062e.size();
                float f = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
                for (Float f2 : this.f4062e) {
                    f += f2.floatValue();
                }
                float f3 = f / size;
                synchronized (this.f4063f) {
                    try {
                        this.f4063f.add(Float.valueOf(f3));
                        if (this.f4063f.size() >= 4) {
                            this.f4063f.remove(0);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.f4063f.clear();
                    }
                }
                this.f4062e.clear();
            }
        }
    }
}
