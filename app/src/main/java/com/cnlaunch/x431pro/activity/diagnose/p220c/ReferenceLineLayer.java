package com.cnlaunch.x431pro.activity.diagnose.p220c;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.android.widget.MeasureResultObserver;
import com.cnlaunch.android.widget.MeasureSubject;
import com.cnlaunch.android.widget.SlideGaugeLayout;
import com.ifoer.expedition.pro.R;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.r */
/* loaded from: classes.dex */
public final class ReferenceLineLayer implements MeasureResultObserver {

    /* renamed from: a */
    public DecimalFormat f11770a;

    /* renamed from: c */
    private SlideGaugeLayout f11772c;

    /* renamed from: f */
    private double f11775f;

    /* renamed from: g */
    private double f11776g;

    /* renamed from: h */
    private TextView f11777h;

    /* renamed from: i */
    private TextView f11778i;

    /* renamed from: d */
    private MeasureSubject f11773d = null;

    /* renamed from: e */
    private Map<View, Double> f11774e = new HashMap();

    /* renamed from: b */
    InterfaceC2098a f11771b = null;

    /* compiled from: ReferenceLineLayer.java */
    /* renamed from: com.cnlaunch.x431pro.activity.diagnose.c.r$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2098a {
        /* renamed from: a */
        void mo7342a(int i, double d);
    }

    public ReferenceLineLayer(SlideGaugeLayout slideGaugeLayout) {
        this.f11772c = slideGaugeLayout;
        this.f11772c.setMeasureResultObserver(this);
        this.f11770a = new DecimalFormat();
        this.f11770a.setMaximumFractionDigits(2);
        this.f11770a.setGroupingUsed(false);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        this.f11770a.setDecimalFormatSymbols(decimalFormatSymbols);
    }

    @Override // com.cnlaunch.android.widget.MeasureResultObserver
    /* renamed from: a */
    public final void mo7360a(MeasureSubject measureSubject, View view, int i) {
        if (this.f11773d != measureSubject) {
            this.f11773d = measureSubject;
        }
        double mo7417a = measureSubject.mo7417a(i);
        TextView textView = (TextView) view.findViewById(R.id.measureValue);
        if (textView != null) {
            textView.setText(this.f11770a.format(mo7417a));
        }
        if (view.getId() == R.id.rlMax) {
            m7363a(measureSubject, mo7417a, this.f11776g);
            InterfaceC2098a interfaceC2098a = this.f11771b;
            if (interfaceC2098a != null) {
                interfaceC2098a.mo7342a(1, mo7417a);
            }
        } else if (view.getId() == R.id.rlMin) {
            m7363a(measureSubject, this.f11775f, mo7417a);
            InterfaceC2098a interfaceC2098a2 = this.f11771b;
            if (interfaceC2098a2 != null) {
                interfaceC2098a2.mo7342a(2, mo7417a);
            }
        }
        this.f11774e.put(view, Double.valueOf(mo7417a));
    }

    @Override // com.cnlaunch.android.widget.MeasureResultObserver
    /* renamed from: a */
    public final void mo7364a() {
        for (Map.Entry<View, Double> entry : this.f11774e.entrySet()) {
            View key = entry.getKey();
            this.f11772c.m9642a(key, key.getLeft(), (int) this.f11773d.mo7418a(entry.getValue().doubleValue()));
        }
    }

    /* renamed from: a */
    public final boolean m7361a(MeasureSubject measureSubject, int i, double d) {
        boolean z = true;
        View findViewById = this.f11772c.findViewById(i == 1 ? R.id.rlMax : i == 2 ? R.id.rlMin : 0);
        z = (d > measureSubject.mo7411f() || d < measureSubject.mo7412e()) ? false : false;
        if (findViewById != null) {
            if (!z) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
        return z;
    }

    /* renamed from: a */
    public final void m7362a(MeasureSubject measureSubject, double d, int i) {
        int i2;
        if (this.f11773d != measureSubject) {
            this.f11773d = measureSubject;
        }
        if (i == 1) {
            i2 = R.id.rlMax;
        } else if (i != 2) {
            return;
        } else {
            i2 = R.id.rlMin;
        }
        View findViewById = this.f11772c.findViewById(i2);
        this.f11772c.m9642a(findViewById, findViewById.getLeft(), (int) measureSubject.mo7418a(d));
        ((TextView) findViewById.findViewById(R.id.measureValue)).setText(this.f11770a.format(d));
        this.f11772c.requestLayout();
        this.f11774e.put(findViewById, Double.valueOf(d));
    }

    /* renamed from: a */
    public final void m7359a(boolean z) {
        if (z) {
            this.f11772c.setVisibility(0);
            this.f11777h = (TextView) this.f11772c.findViewById(R.id.rlMax).findViewById(R.id.measureValue);
            this.f11777h.setText("");
            this.f11778i = (TextView) this.f11772c.findViewById(R.id.rlMin).findViewById(R.id.measureValue);
            this.f11778i.setText("");
            return;
        }
        this.f11772c.setVisibility(8);
    }

    /* renamed from: a */
    public final void m7363a(MeasureSubject measureSubject, double d, double d2) {
        if (this.f11773d != measureSubject) {
            this.f11773d = measureSubject;
        }
        this.f11775f = d;
        this.f11776g = d2;
        this.f11772c.m9639b(this.f11772c.findViewById(R.id.rlMax), (int) measureSubject.mo7418a(measureSubject.mo7411f()), (int) measureSubject.mo7418a(d2));
        this.f11772c.m9639b(this.f11772c.findViewById(R.id.rlMin), (int) measureSubject.mo7418a(d), (int) measureSubject.mo7418a(measureSubject.mo7412e()));
    }
}
