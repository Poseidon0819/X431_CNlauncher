package com.mopub.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;

/* loaded from: classes.dex */
public class CloseableLayout extends FrameLayout {

    /* renamed from: a */
    private final int f20010a;

    /* renamed from: b */
    private OnCloseListener f20011b;

    /* renamed from: c */
    private final StateListDrawable f20012c;

    /* renamed from: d */
    private ClosePosition f20013d;

    /* renamed from: e */
    private final int f20014e;

    /* renamed from: f */
    private final int f20015f;

    /* renamed from: g */
    private final int f20016g;

    /* renamed from: h */
    private boolean f20017h;

    /* renamed from: i */
    private final Rect f20018i;

    /* renamed from: j */
    private final Rect f20019j;

    /* renamed from: k */
    private final Rect f20020k;

    /* renamed from: l */
    private final Rect f20021l;

    /* renamed from: m */
    private RunnableC3677a f20022m;

    /* loaded from: classes.dex */
    public interface OnCloseListener {
        void onClose();
    }

    /* loaded from: classes.dex */
    public enum ClosePosition {
        TOP_LEFT(51),
        TOP_CENTER(49),
        TOP_RIGHT(53),
        CENTER(17),
        BOTTOM_LEFT(83),
        BOTTOM_CENTER(81),
        BOTTOM_RIGHT(85);
        
        private final int mGravity;

        ClosePosition(int i) {
            this.mGravity = i;
        }

        final int getGravity() {
            return this.mGravity;
        }
    }

    public CloseableLayout(Context context) {
        super(context);
        this.f20018i = new Rect();
        this.f20019j = new Rect();
        this.f20020k = new Rect();
        this.f20021l = new Rect();
        this.f20012c = new StateListDrawable();
        this.f20013d = ClosePosition.TOP_RIGHT;
        this.f20012c.addState(SELECTED_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(context));
        this.f20012c.addState(EMPTY_STATE_SET, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(context));
        this.f20012c.setState(EMPTY_STATE_SET);
        this.f20012c.setCallback(this);
        this.f20010a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f20014e = Dips.asIntPixels(50.0f, context);
        this.f20015f = Dips.asIntPixels(30.0f, context);
        this.f20016g = Dips.asIntPixels(8.0f, context);
        setWillNotDraw(false);
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.f20011b = onCloseListener;
    }

    public void setClosePosition(ClosePosition closePosition) {
        Preconditions.checkNotNull(closePosition);
        this.f20013d = closePosition;
        this.f20017h = true;
        invalidate();
    }

    public void setCloseVisible(boolean z) {
        if (this.f20012c.setVisible(z, false)) {
            invalidate(this.f20019j);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f20017h = true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f20017h) {
            this.f20017h = false;
            this.f20018i.set(0, 0, getWidth(), getHeight());
            applyCloseRegionBounds(this.f20013d, this.f20018i, this.f20019j);
            this.f20021l.set(this.f20019j);
            Rect rect = this.f20021l;
            int i = this.f20016g;
            rect.inset(i, i);
            m2600a(this.f20013d, this.f20015f, this.f20021l, this.f20020k);
            this.f20012c.setBounds(this.f20020k);
        }
        if (this.f20012c.isVisible()) {
            this.f20012c.draw(canvas);
        }
    }

    public void applyCloseRegionBounds(ClosePosition closePosition, Rect rect, Rect rect2) {
        m2600a(closePosition, this.f20014e, rect, rect2);
    }

    /* renamed from: a */
    private static void m2600a(ClosePosition closePosition, int i, Rect rect, Rect rect2) {
        Gravity.apply(closePosition.getGravity(), i, i, rect, rect2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        return m2601a((int) motionEvent.getX(), (int) motionEvent.getY(), 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m2601a((int) motionEvent.getX(), (int) motionEvent.getY(), this.f20010a)) {
            setClosePressed(false);
            super.onTouchEvent(motionEvent);
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    setClosePressed(true);
                    break;
                case 1:
                    if (m2602a()) {
                        if (this.f20022m == null) {
                            this.f20022m = new RunnableC3677a(this, (byte) 0);
                        }
                        postDelayed(this.f20022m, ViewConfiguration.getPressedStateDuration());
                        playSoundEffect(0);
                        OnCloseListener onCloseListener = this.f20011b;
                        if (onCloseListener != null) {
                            onCloseListener.onClose();
                            break;
                        }
                    }
                    break;
            }
        } else {
            setClosePressed(false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClosePressed(boolean z) {
        if (z == m2602a()) {
            return;
        }
        this.f20012c.setState(z ? SELECTED_STATE_SET : EMPTY_STATE_SET);
        invalidate(this.f20019j);
    }

    @VisibleForTesting
    /* renamed from: a */
    private boolean m2602a() {
        return this.f20012c.getState() == SELECTED_STATE_SET;
    }

    @VisibleForTesting
    /* renamed from: a */
    private boolean m2601a(int i, int i2, int i3) {
        return i >= this.f20019j.left - i3 && i2 >= this.f20019j.top - i3 && i < this.f20019j.right + i3 && i2 < this.f20019j.bottom + i3;
    }

    /* renamed from: com.mopub.common.CloseableLayout$a */
    /* loaded from: classes.dex */
    final class RunnableC3677a implements Runnable {
        private RunnableC3677a() {
        }

        /* synthetic */ RunnableC3677a(CloseableLayout closeableLayout, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            CloseableLayout.this.setClosePressed(false);
        }
    }

    @VisibleForTesting
    void setCloseBounds(Rect rect) {
        this.f20019j.set(rect);
    }

    @VisibleForTesting
    Rect getCloseBounds() {
        return this.f20019j;
    }

    @VisibleForTesting
    void setCloseBoundChanged(boolean z) {
        this.f20017h = z;
    }

    @VisibleForTesting
    public boolean isCloseVisible() {
        return this.f20012c.isVisible();
    }
}
