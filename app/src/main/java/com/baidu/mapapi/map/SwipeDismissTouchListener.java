package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {

    /* renamed from: a */
    private int f5241a;

    /* renamed from: b */
    private int f5242b;

    /* renamed from: c */
    private int f5243c;

    /* renamed from: d */
    private long f5244d;

    /* renamed from: e */
    private View f5245e;

    /* renamed from: f */
    private DismissCallbacks f5246f;

    /* renamed from: g */
    private int f5247g = 1;

    /* renamed from: h */
    private float f5248h;

    /* renamed from: i */
    private float f5249i;

    /* renamed from: j */
    private boolean f5250j;

    /* renamed from: k */
    private int f5251k;

    /* renamed from: l */
    private Object f5252l;

    /* renamed from: m */
    private VelocityTracker f5253m;

    /* renamed from: n */
    private float f5254n;

    /* renamed from: o */
    private boolean f5255o;

    /* renamed from: p */
    private boolean f5256p;

    /* loaded from: classes.dex */
    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotify();
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f5241a = viewConfiguration.getScaledTouchSlop();
        this.f5242b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5243c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f5244d = view.getContext().getResources().getInteger(17694720);
        this.f5245e = view;
        this.f5245e.getContext();
        this.f5252l = obj;
        this.f5246f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    /* renamed from: a */
    public void m11145a() {
        final ViewGroup.LayoutParams layoutParams = this.f5245e.getLayoutParams();
        final int height = this.f5245e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f5244d);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.mapapi.map.SwipeDismissTouchListener.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.f5246f.onDismiss(SwipeDismissTouchListener.this.f5245e, SwipeDismissTouchListener.this.f5252l);
                SwipeDismissTouchListener.this.f5245e.setTranslationX(ColumnText.GLOBAL_SPACE_CHAR_RATIO);
                layoutParams.height = height;
                SwipeDismissTouchListener.this.f5245e.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.mapapi.map.SwipeDismissTouchListener.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SwipeDismissTouchListener.this.f5245e.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        r8.f5245e.animate().translationX(com.itextpdf.text.pdf.ColumnText.GLOBAL_SPACE_CHAR_RATIO).setDuration(r8.f5244d).setListener(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0155, code lost:
        if (r8.f5253m.getXVelocity() > com.itextpdf.text.pdf.ColumnText.GLOBAL_SPACE_CHAR_RATIO) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0181, code lost:
        if (r8.f5250j != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r8.f5253m != null) goto L8;
     */
    @Override // android.view.View.OnTouchListener
    @android.annotation.TargetApi(12)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.SwipeDismissTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
