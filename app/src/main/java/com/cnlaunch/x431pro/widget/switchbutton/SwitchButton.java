package com.cnlaunch.x431pro.widget.switchbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class SwitchButton extends CheckBox {

    /* renamed from: A */
    private boolean f16917A;

    /* renamed from: B */
    private RunnableC2977a f16918B;

    /* renamed from: C */
    private CompoundButton.OnCheckedChangeListener f16919C;

    /* renamed from: D */
    private CompoundButton.OnCheckedChangeListener f16920D;

    /* renamed from: E */
    private boolean f16921E;

    /* renamed from: F */
    private final float f16922F;

    /* renamed from: G */
    private float f16923G;

    /* renamed from: H */
    private final float f16924H;

    /* renamed from: I */
    private float f16925I;

    /* renamed from: J */
    private float f16926J;

    /* renamed from: K */
    private float f16927K;

    /* renamed from: a */
    private Paint f16928a;

    /* renamed from: b */
    private ViewParent f16929b;

    /* renamed from: c */
    private Bitmap f16930c;

    /* renamed from: d */
    private Bitmap f16931d;

    /* renamed from: e */
    private Bitmap f16932e;

    /* renamed from: f */
    private Bitmap f16933f;

    /* renamed from: g */
    private Bitmap f16934g;

    /* renamed from: h */
    private Bitmap f16935h;

    /* renamed from: i */
    private RectF f16936i;

    /* renamed from: j */
    private PorterDuffXfermode f16937j;

    /* renamed from: k */
    private float f16938k;

    /* renamed from: l */
    private float f16939l;

    /* renamed from: m */
    private float f16940m;

    /* renamed from: n */
    private float f16941n;

    /* renamed from: o */
    private float f16942o;

    /* renamed from: p */
    private float f16943p;

    /* renamed from: q */
    private float f16944q;

    /* renamed from: r */
    private float f16945r;

    /* renamed from: s */
    private float f16946s;

    /* renamed from: t */
    private float f16947t;

    /* renamed from: u */
    private int f16948u;

    /* renamed from: v */
    private int f16949v;

    /* renamed from: w */
    private final int f16950w;

    /* renamed from: x */
    private int f16951x;

    /* renamed from: y */
    private boolean f16952y;

    /* renamed from: z */
    private boolean f16953z;

    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    private SwitchButton(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 16842860);
        this.f16950w = 255;
        this.f16951x = 255;
        this.f16952y = false;
        this.f16922F = 350.0f;
        this.f16924H = 15.0f;
        this.f16928a = new Paint();
        this.f16928a.setColor(-1);
        Resources resources = context.getResources();
        this.f16948u = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.f16949v = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f16930c = BitmapFactory.decodeResource(resources, R.drawable.bottom);
        this.f16932e = BitmapFactory.decodeResource(resources, R.drawable.btn_pressed);
        this.f16933f = BitmapFactory.decodeResource(resources, R.drawable.btn_unpressed);
        this.f16934g = BitmapFactory.decodeResource(resources, R.drawable.frame);
        this.f16935h = BitmapFactory.decodeResource(resources, R.drawable.mask);
        this.f16931d = this.f16933f;
        this.f16946s = this.f16932e.getWidth();
        this.f16944q = this.f16935h.getWidth();
        this.f16945r = this.f16935h.getHeight();
        float f = this.f16946s;
        this.f16943p = f / 2.0f;
        this.f16942o = this.f16944q - (f / 2.0f);
        this.f16941n = this.f16952y ? this.f16942o : this.f16943p;
        this.f16940m = m4289a(this.f16941n);
        float f2 = getResources().getDisplayMetrics().density;
        this.f16923G = (int) ((350.0f * f2) + 0.5f);
        this.f16925I = (int) ((f2 * 15.0f) + 0.5f);
        this.f16936i = new RectF(ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f16925I, this.f16935h.getWidth(), this.f16935h.getHeight() + this.f16925I);
        this.f16937j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z) {
        this.f16951x = z ? 255 : 127;
        super.setEnabled(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.f16952y;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!this.f16952y);
    }

    private void setCheckedDelayed(boolean z) {
        postDelayed(new RunnableC2980b(this, z), 10L);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f16952y != z) {
            this.f16952y = z;
            this.f16941n = z ? this.f16942o : this.f16943p;
            this.f16940m = m4289a(this.f16941n);
            invalidate();
            if (this.f16953z) {
                return;
            }
            this.f16953z = true;
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f16919C;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.onCheckedChanged(this, this.f16952y);
            }
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = this.f16920D;
            if (onCheckedChangeListener2 != null) {
                onCheckedChangeListener2.onCheckedChanged(this, this.f16952y);
            }
            this.f16953z = false;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f16919C = onCheckedChangeListener;
    }

    void setOnCheckedChangeWidgetListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f16920D = onCheckedChangeListener;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float abs = Math.abs(x - this.f16939l);
        float abs2 = Math.abs(y - this.f16938k);
        switch (action) {
            case 0:
                this.f16929b = getParent();
                ViewParent viewParent = this.f16929b;
                if (viewParent != null) {
                    viewParent.requestDisallowInterceptTouchEvent(true);
                }
                this.f16939l = x;
                this.f16938k = y;
                this.f16931d = this.f16932e;
                this.f16947t = this.f16952y ? this.f16942o : this.f16943p;
                break;
            case 1:
                this.f16931d = this.f16933f;
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                int i = this.f16949v;
                if (abs2 < i && abs < i && eventTime < this.f16948u) {
                    if (this.f16918B == null) {
                        this.f16918B = new RunnableC2977a(this, (byte) 0);
                    }
                    if (!post(this.f16918B)) {
                        performClick();
                        break;
                    }
                } else {
                    m4287a(!this.f16917A);
                    break;
                }
                break;
            case 2:
                motionEvent.getEventTime();
                motionEvent.getDownTime();
                this.f16941n = (this.f16947t + motionEvent.getX()) - this.f16939l;
                float f = this.f16941n;
                float f2 = this.f16943p;
                if (f >= f2) {
                    this.f16941n = f2;
                }
                float f3 = this.f16941n;
                float f4 = this.f16942o;
                if (f3 <= f4) {
                    this.f16941n = f4;
                }
                float f5 = this.f16941n;
                float f6 = this.f16943p;
                float f7 = this.f16942o;
                this.f16917A = f5 > ((f6 - f7) / 2.0f) + f7;
                this.f16940m = m4289a(this.f16941n);
                break;
        }
        invalidate();
        return isEnabled();
    }

    /* renamed from: com.cnlaunch.x431pro.widget.switchbutton.SwitchButton$a */
    /* loaded from: classes.dex */
    final class RunnableC2977a implements Runnable {
        private RunnableC2977a() {
        }

        /* synthetic */ RunnableC2977a(SwitchButton switchButton, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            SwitchButton.this.performClick();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        m4287a(!this.f16952y);
        return true;
    }

    /* renamed from: a */
    private float m4289a(float f) {
        return f - (this.f16946s / 2.0f);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayerAlpha(this.f16936i, this.f16951x, 31);
        canvas.drawBitmap(this.f16935h, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f16925I, this.f16928a);
        this.f16928a.setXfermode(this.f16937j);
        canvas.drawBitmap(this.f16930c, this.f16940m, this.f16925I, this.f16928a);
        this.f16928a.setXfermode(null);
        canvas.drawBitmap(this.f16934g, ColumnText.GLOBAL_SPACE_CHAR_RATIO, this.f16925I, this.f16928a);
        canvas.drawBitmap(this.f16931d, this.f16940m, this.f16925I, this.f16928a);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension((int) this.f16944q, (int) (this.f16945r + (this.f16925I * 2.0f)));
    }

    /* renamed from: a */
    private void m4287a(boolean z) {
        this.f16921E = true;
        this.f16927K = z ? -this.f16923G : this.f16923G;
        this.f16926J = this.f16941n;
        new RunnableC2978b(this, (byte) 0).run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.switchbutton.SwitchButton$b */
    /* loaded from: classes.dex */
    public final class RunnableC2978b implements Runnable {
        private RunnableC2978b() {
        }

        /* synthetic */ RunnableC2978b(SwitchButton switchButton, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SwitchButton.this.f16921E) {
                SwitchButton.m4286b(SwitchButton.this);
                FrameAnimationController.m4285a(this);
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m4286b(SwitchButton switchButton) {
        switchButton.f16926J += (switchButton.f16927K * 16.0f) / 1000.0f;
        float f = switchButton.f16926J;
        float f2 = switchButton.f16942o;
        if (f > f2) {
            float f3 = switchButton.f16943p;
            if (f >= f3) {
                switchButton.f16921E = false;
                switchButton.f16926J = f3;
                switchButton.setCheckedDelayed(false);
            }
        } else {
            switchButton.f16921E = false;
            switchButton.f16926J = f2;
            switchButton.setCheckedDelayed(true);
        }
        switchButton.f16941n = switchButton.f16926J;
        switchButton.f16940m = switchButton.m4289a(switchButton.f16941n);
        switchButton.invalidate();
    }
}
