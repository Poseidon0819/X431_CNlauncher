package com.cnlaunch.x431pro.widget.sortlistview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.x431pro.utils.C2778n;
import com.ifoer.expedition.pro.R;

/* loaded from: classes.dex */
public class SideBar extends View {

    /* renamed from: a */
    public static String[] f16798a = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    /* renamed from: b */
    private InterfaceC2960a f16799b;

    /* renamed from: c */
    private int f16800c;

    /* renamed from: d */
    private Paint f16801d;

    /* renamed from: e */
    private TextView f16802e;

    /* renamed from: f */
    private DisplayMetrics f16803f;

    /* renamed from: g */
    private int f16804g;

    /* renamed from: h */
    private int f16805h;

    /* renamed from: i */
    private int f16806i;

    /* renamed from: com.cnlaunch.x431pro.widget.sortlistview.SideBar$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2960a {
        /* renamed from: a */
        void mo4392a(String str);
    }

    public void setTextView(TextView textView) {
        this.f16802e = textView;
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16800c = -1;
        this.f16801d = new Paint();
        this.f16803f = getResources().getDisplayMetrics();
        this.f16804g = 0;
        this.f16805h = 16;
        this.f16806i = getResources().getInteger(R.integer.sidebaroffset);
        if (m4393a(getContext()) < 10.0d) {
            this.f16805h = getResources().getInteger(R.integer.sidebar_text);
        } else {
            this.f16805h = 19;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int length = height / f16798a.length;
        for (int i = 0; i < f16798a.length; i++) {
            this.f16801d.setColor(Color.rgb(33, 65, 98));
            this.f16801d.setTypeface(Typeface.DEFAULT_BOLD);
            this.f16801d.setAntiAlias(true);
            this.f16801d.setTextSize(this.f16805h);
            if (i == this.f16800c) {
                this.f16801d.setColor(Color.parseColor("#3399ff"));
                this.f16801d.setFakeBoldText(true);
            }
            canvas.drawText(f16798a[i], (width / 2) - (this.f16801d.measureText(f16798a[i]) / 2.0f), (length * i) + length, this.f16801d);
            this.f16801d.reset();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.f16800c;
        InterfaceC2960a interfaceC2960a = this.f16799b;
        int height = (int) ((y / getHeight()) * f16798a.length);
        if (action == 1) {
            setBackgroundColor(0);
            this.f16800c = -1;
            invalidate();
            TextView textView = this.f16802e;
            if (textView != null) {
                textView.setVisibility(4);
            }
        } else {
            setBackgroundResource(R.drawable.sidebar_background);
            if (i != height && height >= 0) {
                String[] strArr = f16798a;
                if (height < strArr.length) {
                    if (interfaceC2960a != null) {
                        interfaceC2960a.mo4392a(strArr[height]);
                    }
                    TextView textView2 = this.f16802e;
                    if (textView2 != null) {
                        textView2.setText(f16798a[height]);
                        this.f16802e.setVisibility(0);
                    }
                    this.f16800c = height;
                    invalidate();
                }
            }
        }
        return true;
    }

    public void setOnTouchingLetterChangedListener(InterfaceC2960a interfaceC2960a) {
        this.f16799b = interfaceC2960a;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f16804g = (int) TypedValue.applyDimension(1, this.f16806i, this.f16803f);
        C2778n.m4900c(getContext());
        if (m4393a(getContext()) < 10.0d) {
            C2778n.m4900c(getContext());
            getResources().getInteger(R.integer.sidebartemp);
        }
    }

    /* renamed from: a */
    private static double m4393a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        double sqrt = Math.sqrt(Math.pow(displayMetrics.widthPixels, 2.0d) + Math.pow(displayMetrics.heightPixels, 2.0d));
        Log.i("screenSize", "devicePixels:".concat(String.valueOf(sqrt)));
        double d = displayMetrics.density * 160.0f;
        Double.isNaN(d);
        double d2 = sqrt / d;
        Log.i("screenSize", "screenSize".concat(String.valueOf(d2)));
        return d2;
    }
}
