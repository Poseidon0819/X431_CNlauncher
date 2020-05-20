package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.utils.C4386g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class UPRadiationView extends View {

    /* renamed from: a */
    private List<C4352a> f23039a;

    /* renamed from: b */
    private int f23040b;

    /* renamed from: c */
    private int f23041c;

    /* renamed from: d */
    private Context f23042d;

    /* renamed from: e */
    private Handler f23043e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.unionpay.mobile.android.upwidget.UPRadiationView$a */
    /* loaded from: classes2.dex */
    public class C4352a {

        /* renamed from: a */
        Paint f23044a;

        /* renamed from: b */
        int f23045b;

        /* renamed from: c */
        float f23046c;

        /* renamed from: d */
        int f23047d;

        private C4352a() {
        }

        /* synthetic */ C4352a(UPRadiationView uPRadiationView, byte b) {
            this();
        }
    }

    public UPRadiationView(Context context) {
        this(context, null);
    }

    public UPRadiationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23042d = context;
        this.f23039a = Collections.synchronizedList(new ArrayList());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f23042d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((Activity) this.f23042d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
        int i2 = displayMetrics2.heightPixels;
        if (i <= 0 || i2 <= 0) {
            throw new RuntimeException("size illegal");
        }
        this.f23040b = i / 2;
        this.f23041c = (i2 / 2) - C4150b.f22151n;
        this.f23043e = new HandlerC4375t(this);
        this.f23043e.sendEmptyMessage(0);
    }

    /* renamed from: a */
    private static Paint m999a(int i, float f) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(i);
        paint.setColor(-1);
        return paint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m998a(UPRadiationView uPRadiationView) {
        List<C4352a> list = uPRadiationView.f23039a;
        if (list != null) {
            if (list.size() == 0) {
                C4352a c4352a = new C4352a(uPRadiationView, (byte) 0);
                c4352a.f23045b = 0;
                c4352a.f23047d = 255;
                c4352a.f23046c = c4352a.f23045b / 4;
                c4352a.f23044a = m999a(c4352a.f23047d, c4352a.f23046c);
                uPRadiationView.f23039a.add(c4352a);
                return;
            }
            for (int i = 0; i < uPRadiationView.f23039a.size(); i++) {
                C4352a c4352a2 = uPRadiationView.f23039a.get(i);
                if (c4352a2.f23047d == 0) {
                    uPRadiationView.f23039a.remove(i);
                    c4352a2.f23044a = null;
                } else {
                    c4352a2.f23045b += 10;
                    c4352a2.f23047d -= 4;
                    if (c4352a2.f23047d < 0) {
                        c4352a2.f23047d = 0;
                    }
                    c4352a2.f23046c = c4352a2.f23045b / 4;
                    c4352a2.f23044a.setAlpha(c4352a2.f23047d);
                    c4352a2.f23044a.setStrokeWidth(c4352a2.f23046c);
                    if (c4352a2.f23045b == C4386g.m858a(uPRadiationView.f23042d, 60.0f)) {
                        C4352a c4352a3 = new C4352a(uPRadiationView, (byte) 0);
                        c4352a3.f23045b = 0;
                        c4352a3.f23047d = 255;
                        c4352a3.f23046c = c4352a3.f23045b / 4;
                        c4352a3.f23044a = m999a(c4352a3.f23047d, c4352a3.f23046c);
                        uPRadiationView.f23039a.add(c4352a3);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m1000a() {
        this.f23042d = null;
        this.f23043e.removeCallbacksAndMessages(null);
        this.f23043e = null;
        List<C4352a> list = this.f23039a;
        if (list != null) {
            list.clear();
        }
        this.f23039a = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < this.f23039a.size(); i++) {
            C4352a c4352a = this.f23039a.get(i);
            canvas.drawCircle(this.f23040b, this.f23041c, c4352a.f23045b, c4352a.f23044a);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
