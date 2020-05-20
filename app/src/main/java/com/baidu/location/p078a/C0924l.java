package com.baidu.location.p078a;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.ServiceC1002f;
import com.itextpdf.text.pdf.ColumnText;

/* renamed from: com.baidu.location.a.l */
/* loaded from: classes.dex */
public class C0924l implements SensorEventListener {

    /* renamed from: c */
    private static C0924l f4067c;

    /* renamed from: a */
    private float[] f4068a;

    /* renamed from: b */
    private SensorManager f4069b;

    /* renamed from: d */
    private float f4070d;

    /* renamed from: e */
    private boolean f4071e = false;

    /* renamed from: f */
    private boolean f4072f = false;

    /* renamed from: g */
    private boolean f4073g = false;

    private C0924l() {
    }

    /* renamed from: a */
    public static synchronized C0924l m12078a() {
        C0924l c0924l;
        synchronized (C0924l.class) {
            if (f4067c == null) {
                f4067c = new C0924l();
            }
            c0924l = f4067c;
        }
        return c0924l;
    }

    /* renamed from: a */
    public void m12077a(boolean z) {
        this.f4071e = z;
    }

    /* renamed from: b */
    public synchronized void m12076b() {
        Sensor defaultSensor;
        if (this.f4073g) {
            return;
        }
        if (this.f4071e) {
            if (this.f4069b == null) {
                this.f4069b = (SensorManager) ServiceC1002f.getServiceContext().getSystemService("sensor");
            }
            if (this.f4069b != null && (defaultSensor = this.f4069b.getDefaultSensor(11)) != null && this.f4071e) {
                this.f4069b.registerListener(this, defaultSensor, 3);
            }
            this.f4073g = true;
        }
    }

    /* renamed from: b */
    public void m12075b(boolean z) {
        this.f4072f = z;
    }

    /* renamed from: c */
    public synchronized void m12074c() {
        if (this.f4073g) {
            if (this.f4069b != null) {
                this.f4069b.unregisterListener(this);
                this.f4069b = null;
            }
            this.f4073g = false;
        }
    }

    /* renamed from: d */
    public boolean m12073d() {
        return this.f4071e;
    }

    /* renamed from: e */
    public float m12072e() {
        return this.f4070d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 11) {
            return;
        }
        this.f4068a = (float[]) sensorEvent.values.clone();
        float[] fArr = this.f4068a;
        if (fArr != null) {
            float[] fArr2 = new float[9];
            try {
                SensorManager.getRotationMatrixFromVector(fArr2, fArr);
                float[] fArr3 = new float[3];
                SensorManager.getOrientation(fArr2, fArr3);
                this.f4070d = (float) Math.toDegrees(fArr3[0]);
                this.f4070d = (float) Math.floor(this.f4070d >= ColumnText.GLOBAL_SPACE_CHAR_RATIO ? this.f4070d : this.f4070d + 360.0f);
            } catch (Exception unused) {
                this.f4070d = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            }
        }
    }
}
