package com.cnlaunch.golo3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.golo3.p165g.WindowUtils;
import com.cnlaunch.p132e.p133a.C1464a;

/* loaded from: classes.dex */
public class SideBar extends View {

    /* renamed from: a */
    public static String[] f8513a = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /* renamed from: b */
    private InterfaceC1623a f8514b;

    /* renamed from: c */
    private int f8515c;

    /* renamed from: d */
    private Paint f8516d;

    /* renamed from: e */
    private TextView f8517e;

    /* renamed from: com.cnlaunch.golo3.view.SideBar$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1623a {
    }

    public void setTextView(TextView textView) {
        this.f8517e = textView;
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8515c = -1;
        this.f8516d = new Paint();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int length = height / f8513a.length;
        for (int i = 0; i < f8513a.length; i++) {
            this.f8516d.setColor(Color.rgb(33, 65, 98));
            this.f8516d.setAntiAlias(true);
            if (height > 800) {
                this.f8516d.setTextSize(WindowUtils.m9109a(14.0f));
            } else {
                this.f8516d.setTextSize(WindowUtils.m9109a(13.0f));
            }
            if (i == this.f8515c) {
                this.f8516d.setColor(Color.parseColor("#F8F8FF"));
                this.f8516d.setFakeBoldText(true);
            }
            canvas.drawText(f8513a[i], (width / 2) - (this.f8516d.measureText(f8513a[i]) / 2.0f), (length * i) + length, this.f8516d);
            this.f8516d.reset();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.f8515c;
        int height = (int) ((y / getHeight()) * f8513a.length);
        if (action == 1) {
            setBackgroundDrawable(new ColorDrawable(0));
            this.f8515c = -1;
            invalidate();
            TextView textView = this.f8517e;
            if (textView != null) {
                textView.setVisibility(4);
            }
        } else {
            setBackgroundResource(C1464a.C1467c.sidebar_background);
            if (i != height && height >= 0) {
                String[] strArr = f8513a;
                if (height < strArr.length) {
                    TextView textView2 = this.f8517e;
                    if (textView2 != null) {
                        textView2.setText(strArr[height]);
                        this.f8517e.setVisibility(0);
                    }
                    this.f8515c = height;
                    invalidate();
                }
            }
        }
        return true;
    }

    public void setOnTouchingLetterChangedListener(InterfaceC1623a interfaceC1623a) {
        this.f8514b = interfaceC1623a;
    }
}
