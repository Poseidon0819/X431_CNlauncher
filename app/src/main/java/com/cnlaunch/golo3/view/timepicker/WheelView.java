package com.cnlaunch.golo3.view.timepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.cnlaunch.p132e.p133a.C1464a;
import com.itextpdf.text.pdf.ColumnText;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class WheelView extends ViewGroup {

    /* renamed from: g */
    private static final int f8739g = Color.parseColor("#028478");

    /* renamed from: h */
    private static final int f8740h = Color.parseColor("#D3D3D3");

    /* renamed from: i */
    private static final int[] f8741i = {16777215, 16777215, 16777215};

    /* renamed from: A */
    private boolean f8742A;

    /* renamed from: B */
    private int f8743B;

    /* renamed from: C */
    private GestureDetector f8744C;

    /* renamed from: D */
    private Scroller f8745D;

    /* renamed from: E */
    private int f8746E;

    /* renamed from: F */
    private List<Object> f8747F;

    /* renamed from: G */
    private List<Object> f8748G;

    /* renamed from: H */
    private GestureDetector.SimpleOnGestureListener f8749H;

    /* renamed from: I */
    private final int f8750I;

    /* renamed from: J */
    private final int f8751J;

    /* renamed from: K */
    private Handler f8752K;

    /* renamed from: a */
    public int f8753a;

    /* renamed from: b */
    boolean f8754b;

    /* renamed from: c */
    boolean f8755c;

    /* renamed from: d */
    public ScrollView f8756d;

    /* renamed from: e */
    public View f8757e;

    /* renamed from: f */
    int f8758f;

    /* renamed from: j */
    private final int f8759j;

    /* renamed from: k */
    private WheelAdapter f8760k;

    /* renamed from: l */
    private int f8761l;

    /* renamed from: m */
    private int f8762m;

    /* renamed from: n */
    private int f8763n;

    /* renamed from: o */
    private int f8764o;

    /* renamed from: p */
    private int f8765p;

    /* renamed from: q */
    private TextPaint f8766q;

    /* renamed from: r */
    private TextPaint f8767r;

    /* renamed from: s */
    private TextPaint f8768s;

    /* renamed from: t */
    private StaticLayout f8769t;

    /* renamed from: u */
    private StaticLayout f8770u;

    /* renamed from: v */
    private StaticLayout f8771v;

    /* renamed from: w */
    private String f8772w;

    /* renamed from: x */
    private Drawable f8773x;

    /* renamed from: y */
    private GradientDrawable f8774y;

    /* renamed from: z */
    private GradientDrawable f8775z;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8759j = this.f8753a / 5;
        this.f8760k = null;
        this.f8761l = -1;
        this.f8762m = 0;
        this.f8763n = 0;
        this.f8764o = 3;
        this.f8765p = 0;
        this.f8754b = false;
        this.f8755c = true;
        this.f8747F = new LinkedList();
        this.f8748G = new LinkedList();
        this.f8749H = new C1656b(this);
        this.f8750I = 0;
        this.f8751J = 1;
        this.f8752K = new HandlerC1657c(this);
        this.f8744C = new GestureDetector(context, this.f8749H);
        this.f8744C.setIsLongpressEnabled(false);
        this.f8745D = new Scroller(context);
    }

    public WheelAdapter getAdapter() {
        return this.f8760k;
    }

    public void setAdapter(WheelAdapter wheelAdapter) {
        this.f8760k = wheelAdapter;
        m9001c();
        if (wheelAdapter.m8988a() < 30) {
            int i = this.f8761l;
            if (i == 30 || i == 29 || i == 28) {
                this.f8761l = wheelAdapter.m8988a() - 1;
            }
        } else if (this.f8761l == 30) {
            this.f8761l = wheelAdapter.m8988a() - 1;
        }
        invalidate();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f8745D.forceFinished(true);
        this.f8745D = new Scroller(getContext(), interpolator);
    }

    public int getVisibleItems() {
        return this.f8764o;
    }

    public void setVisibleItems(int i) {
        this.f8764o = i;
        invalidate();
    }

    public String getLabel() {
        return this.f8772w;
    }

    public void setLabel(String str) {
        String str2 = this.f8772w;
        if (str2 == null || !str2.equals(str)) {
            this.f8772w = str;
            this.f8770u = null;
            invalidate();
        }
    }

    /* renamed from: b */
    private void m9005b() {
        Iterator<Object> it = this.f8748G.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public int getCurrentItem() {
        return this.f8761l;
    }

    private void setCurrentItem$2563266(int i) {
        WheelAdapter wheelAdapter = this.f8760k;
        if (wheelAdapter == null || wheelAdapter.m8988a() == 0) {
            return;
        }
        if (i < 0 || i >= this.f8760k.m8988a()) {
            if (!this.f8754b) {
                return;
            }
            while (i < 0) {
                i += this.f8760k.m8988a();
            }
            i %= this.f8760k.m8988a();
        }
        if (i != this.f8761l) {
            m9001c();
            this.f8761l = i;
            Iterator<Object> it = this.f8747F.iterator();
            while (it.hasNext()) {
                it.next();
            }
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        setCurrentItem$2563266(i);
    }

    public void setCyclic(boolean z) {
        this.f8754b = z;
        invalidate();
        m9001c();
    }

    /* renamed from: c */
    private void m9001c() {
        this.f8769t = null;
        this.f8771v = null;
        this.f8743B = 0;
    }

    /* renamed from: a */
    private String m9006a(boolean z) {
        StringBuilder sb = new StringBuilder();
        int i = (this.f8764o / 2) + 1;
        int i2 = this.f8761l - i;
        while (true) {
            int i3 = this.f8761l;
            if (i2 <= i3 + i) {
                if (z || i2 != i3) {
                    WheelAdapter wheelAdapter = this.f8760k;
                    String str = null;
                    if (wheelAdapter != null && wheelAdapter.m8988a() != 0) {
                        int m8988a = this.f8760k.m8988a();
                        if ((i2 >= 0 && i2 < m8988a) || this.f8754b) {
                            str = this.f8760k.m8987b();
                        }
                    }
                    if (str != null) {
                        sb.append(str);
                    }
                }
                if (i2 < this.f8761l + i) {
                    sb.append("\n");
                }
                i2++;
            } else {
                return sb.toString();
            }
        }
    }

    private int getMaxTextLength() {
        WheelAdapter adapter = getAdapter();
        if (adapter == null) {
            return 0;
        }
        int m8986c = adapter.m8986c();
        if (m8986c > 0) {
            return m8986c;
        }
        String str = null;
        for (int max = Math.max(this.f8761l - (this.f8764o / 2), 0); max < Math.min(this.f8761l + this.f8764o, adapter.m8988a()); max++) {
            String m8987b = adapter.m8987b();
            if (m8987b != null && (str == null || str.length() < m8987b.length())) {
                str = m8987b;
            }
        }
        if (str != null) {
            return str.length();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemHeight() {
        int i = this.f8765p;
        if (i != 0) {
            return i;
        }
        StaticLayout staticLayout = this.f8769t;
        if (staticLayout != null && staticLayout.getLineCount() > 2) {
            this.f8765p = this.f8769t.getLineTop(2) - this.f8769t.getLineTop(1);
            return this.f8765p;
        }
        return getHeight() / this.f8764o;
    }

    /* renamed from: b */
    private void m9004b(int i, int i2) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2 = this.f8769t;
        if (staticLayout2 == null || staticLayout2.getWidth() > i) {
            this.f8769t = new StaticLayout(m9006a(this.f8742A), this.f8766q, i, i2 > 0 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER, 1.0f, 15.0f, false);
        } else {
            this.f8769t.increaseWidthTo(i);
        }
        if (!this.f8742A && ((staticLayout = this.f8771v) == null || staticLayout.getWidth() > i)) {
            String m8987b = getAdapter() != null ? getAdapter().m8987b() : null;
            if (m8987b == null) {
                m8987b = "";
            }
            this.f8771v = new StaticLayout(m8987b, this.f8767r, i, i2 > 0 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER, 1.0f, 15.0f, false);
        } else if (this.f8742A) {
            this.f8771v = null;
        } else {
            this.f8771v.increaseWidthTo(i);
        }
        if (i2 > 0) {
            StaticLayout staticLayout3 = this.f8770u;
            if (staticLayout3 == null || staticLayout3.getWidth() > i2) {
                this.f8770u = new StaticLayout(this.f8772w, this.f8768s, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 15.0f, false);
            } else {
                this.f8770u.increaseWidthTo(i2);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int m9009a = m9009a(size, mode);
        if (mode2 != 1073741824) {
            int max = this.f8769t == null ? 0 : Math.max(((getItemHeight() * this.f8764o) - (this.f8759j * 2)) - 15, getSuggestedMinimumHeight());
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(max, size2) : max;
        }
        setMeasuredDimension(m9009a, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8769t == null) {
            int i = this.f8762m;
            if (i == 0) {
                m9009a(getWidth(), NTLMConstants.FLAG_NEGOTIATE_KEY_EXCHANGE);
            } else {
                m9004b(i, this.f8763n);
            }
        }
        if (this.f8762m > 0) {
            canvas.save();
            canvas.translate(10.0f, -this.f8759j);
            canvas.save();
            canvas.translate(ColumnText.GLOBAL_SPACE_CHAR_RATIO, (-this.f8769t.getLineTop(1)) + this.f8743B);
            this.f8766q.setColor(f8740h);
            this.f8766q.drawableState = getDrawableState();
            this.f8769t.draw(canvas);
            canvas.restore();
            this.f8767r.setColor(f8739g);
            this.f8767r.drawableState = getDrawableState();
            this.f8768s.setColor(f8740h);
            this.f8768s.drawableState = getDrawableState();
            Rect rect = new Rect();
            this.f8769t.getLineBounds(this.f8764o / 2, rect);
            if (this.f8770u != null) {
                canvas.save();
                canvas.translate(this.f8769t.getWidth() + 10, rect.top + ((this.f8753a * 1) / 3));
                this.f8770u.draw(canvas);
                canvas.restore();
            }
            if (this.f8771v != null) {
                canvas.save();
                canvas.translate(ColumnText.GLOBAL_SPACE_CHAR_RATIO, rect.top + this.f8743B);
                this.f8771v.draw(canvas);
                canvas.restore();
            }
            canvas.restore();
        }
        int height = getHeight() / 2;
        int itemHeight = getItemHeight() / 2;
        this.f8773x.setBounds(0, height - itemHeight, getWidth(), height + itemHeight);
        this.f8773x.draw(canvas);
        this.f8774y.setBounds(0, 0, getWidth(), getHeight() / this.f8764o);
        this.f8774y.draw(canvas);
        this.f8775z.setBounds(0, getHeight() - (getHeight() / this.f8764o), getWidth(), getHeight());
        this.f8775z.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f8757e == null || this.f8756d == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.f8758f = (int) motionEvent.getY();
            setParentScrollAble(false);
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            setParentScrollAble(true);
        } else {
            motionEvent.getAction();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8757e != null && this.f8756d != null && motionEvent.getAction() == 2) {
            int measuredHeight = this.f8757e.getMeasuredHeight() - getMeasuredHeight();
            int scrollY = getScrollY();
            int y = (int) motionEvent.getY();
            int i = this.f8758f;
            if (i < y) {
                if (scrollY < 0) {
                    setParentScrollAble(true);
                    return false;
                }
                setParentScrollAble(false);
            } else if (i > y) {
                if (scrollY >= measuredHeight) {
                    setParentScrollAble(true);
                    return false;
                }
                setParentScrollAble(false);
            }
            this.f8758f = y;
        }
        if (getAdapter() != null && !this.f8744C.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            m8997e();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextMessage(int i) {
        m8999d();
        this.f8752K.sendEmptyMessage(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8999d() {
        this.f8752K.removeMessages(0);
        this.f8752K.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8997e() {
        if (this.f8760k == null) {
            return;
        }
        boolean z = false;
        this.f8746E = 0;
        int i = this.f8743B;
        int itemHeight = getItemHeight();
        if (i <= 0 ? this.f8761l > 0 : this.f8761l < this.f8760k.m8988a()) {
            z = true;
        }
        int i2 = ((this.f8754b || z) && Math.abs((float) i) > ((float) itemHeight) / 2.0f) ? i < 0 ? i + itemHeight + 1 : i - (itemHeight + 1) : i;
        if (Math.abs(i2) > 1) {
            this.f8745D.startScroll(0, 0, 0, i2, 400);
            setNextMessage(1);
            return;
        }
        m9010a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m9010a() {
        if (this.f8742A) {
            m9005b();
            this.f8742A = false;
        }
        m9001c();
        invalidate();
    }

    public void setShowLine(boolean z) {
        this.f8755c = z;
    }

    private void setParentScrollAble(boolean z) {
        this.f8756d.requestDisallowInterceptTouchEvent(!z);
    }

    /* renamed from: a */
    private int m9009a(int i, int i2) {
        boolean z = true;
        if (this.f8766q == null) {
            this.f8766q = new TextPaint(1);
            this.f8766q.density = getResources().getDisplayMetrics().density;
            this.f8766q.setTextSize(this.f8753a);
        }
        if (this.f8767r == null) {
            this.f8767r = new TextPaint(37);
            this.f8767r.density = getResources().getDisplayMetrics().density;
            this.f8767r.setTextSize(this.f8753a);
        }
        if (this.f8768s == null) {
            this.f8768s = new TextPaint(1);
            this.f8768s.density = getResources().getDisplayMetrics().density;
            this.f8768s.setTextSize((this.f8753a * 2) / 3);
        }
        if (this.f8773x == null) {
            if (this.f8755c) {
                this.f8773x = getContext().getResources().getDrawable(C1464a.C1467c.select_time_wheel_val);
            } else {
                this.f8773x = getContext().getResources().getDrawable(C1464a.C1467c.wheel_val);
            }
        }
        if (this.f8774y == null) {
            this.f8774y = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, f8741i);
        }
        if (this.f8775z == null) {
            this.f8775z = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, f8741i);
        }
        setBackgroundResource(C1464a.C1467c.wheel_bg);
        int maxTextLength = getMaxTextLength();
        if (maxTextLength > 0) {
            this.f8762m = (int) (maxTextLength * ((float) Math.ceil(Layout.getDesiredWidth("0", this.f8766q))));
        } else {
            this.f8762m = 0;
        }
        this.f8762m += 10;
        this.f8763n = 0;
        String str = this.f8772w;
        if (str != null && str.length() > 0) {
            this.f8763n = (int) Math.ceil(Layout.getDesiredWidth(this.f8772w, this.f8767r));
        }
        if (i2 != 1073741824) {
            int i3 = this.f8762m;
            int i4 = this.f8763n;
            int i5 = i3 + i4 + 20;
            if (i4 > 0) {
                i5 += 10;
            }
            int max = Math.max(i5, getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= max) {
                i = max;
                z = false;
            }
        }
        if (z) {
            int i6 = (i - 10) - 20;
            if (i6 <= 0) {
                this.f8763n = 0;
                this.f8762m = 0;
            }
            int i7 = this.f8763n;
            if (i7 > 0) {
                int i8 = this.f8762m;
                double d = i8;
                double d2 = i6;
                Double.isNaN(d);
                Double.isNaN(d2);
                double d3 = i8 + i7;
                Double.isNaN(d3);
                this.f8762m = (int) ((d * d2) / d3);
                this.f8763n = i6 - this.f8762m;
            } else {
                this.f8762m = i6 + 10;
            }
        }
        int i9 = this.f8762m;
        if (i9 > 0) {
            m9004b(i9, this.f8763n);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ void m8998d(WheelView wheelView) {
        if (wheelView.f8742A) {
            return;
        }
        wheelView.f8742A = true;
        Iterator<Object> it = wheelView.f8748G.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m9007a(WheelView wheelView, int i) {
        wheelView.f8743B += i;
        int itemHeight = wheelView.f8743B / wheelView.getItemHeight();
        int i2 = wheelView.f8761l - itemHeight;
        if (wheelView.f8754b && wheelView.f8760k.m8988a() > 0) {
            while (i2 < 0) {
                i2 += wheelView.f8760k.m8988a();
            }
            i2 %= wheelView.f8760k.m8988a();
        } else if (!wheelView.f8742A) {
            i2 = Math.min(Math.max(i2, 0), wheelView.f8760k.m8988a() - 1);
        } else if (i2 < 0) {
            itemHeight = wheelView.f8761l;
            i2 = 0;
        } else if (i2 >= wheelView.f8760k.m8988a()) {
            itemHeight = (wheelView.f8761l - wheelView.f8760k.m8988a()) + 1;
            i2 = wheelView.f8760k.m8988a() - 1;
        }
        int i3 = wheelView.f8743B;
        if (i2 != wheelView.f8761l) {
            wheelView.setCurrentItem$2563266(i2);
        } else {
            wheelView.invalidate();
        }
        wheelView.f8743B = i3 - (itemHeight * wheelView.getItemHeight());
        if (wheelView.f8743B > wheelView.getHeight()) {
            wheelView.f8743B = (wheelView.f8743B % wheelView.getHeight()) + wheelView.getHeight();
        }
    }
}
