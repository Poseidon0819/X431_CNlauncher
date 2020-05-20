package com.cnlaunch.p169im.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.cnlaunch.golo3.view.ViewPagerFixed;
import com.cnlaunch.p112a.p115c.DefaultRenderer;
import com.cnlaunch.x431pro.utils.C2778n;
import com.ifoer.expedition.pro.R;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* renamed from: com.cnlaunch.im.widget.ChatViewPager */
/* loaded from: classes.dex */
public class ChatViewPager extends ViewPagerFixed {

    /* renamed from: g */
    private Paint f9335g;

    /* renamed from: h */
    private boolean f9336h;

    /* renamed from: i */
    private float f9337i;

    public ChatViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9335g = new Paint(1);
        this.f9336h = false;
        this.f9337i = 3.0f;
    }

    public void setHeight(float f) {
        this.f9337i = f;
    }

    @Override // android.support.p012v4.view.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.f9336h) {
            this.f9336h = true;
            setPadding(0, 0, 0, 0);
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((int) (C2778n.m4900c(getContext()) / this.f9337i), NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE));
    }

    @Override // android.support.p012v4.view.ViewPager, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int mo1771a = getAdapter().mo1771a();
        if (mo1771a > 0) {
            float width = getWidth();
            float height = getHeight();
            float f = height / 80.0f;
            float f2 = ((mo1771a * 2) - 1) * f * 2.0f;
            float f3 = height - ((height / 40.0f) + (height / 60.0f));
            for (int i = 0; i < mo1771a; i++) {
                float f4 = ((width - f2) / 2.0f) + (i * width);
                if (mo1771a > 1) {
                    for (int i2 = 0; i2 < mo1771a; i2++) {
                        if (i2 == getCurrentItem()) {
                            this.f9335g.setColor(getResources().getColor(R.color.red));
                        } else {
                            this.f9335g.setColor(DefaultRenderer.TEXT_COLOR);
                        }
                        canvas.drawCircle((4.0f * f * i2) + f4, f3, f, this.f9335g);
                    }
                }
            }
        }
    }
}
