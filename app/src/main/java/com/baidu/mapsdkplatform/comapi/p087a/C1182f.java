package com.baidu.mapsdkplatform.comapi.p087a;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* renamed from: com.baidu.mapsdkplatform.comapi.a.f */
/* loaded from: classes.dex */
public class C1182f extends AbstractC1175b {

    /* renamed from: a */
    private Animator f5860a = null;

    /* renamed from: b */
    private long f5861b = 0;

    /* renamed from: c */
    private Interpolator f5862c = null;

    /* renamed from: d */
    private Animation.AnimationListener f5863d = null;

    /* renamed from: e */
    private int f5864e = 1;

    /* renamed from: f */
    private int f5865f = 0;

    /* renamed from: g */
    private float[] f5866g;

    /* renamed from: h */
    private int f5867h;

    public C1182f(int i, float... fArr) {
        this.f5867h = 1;
        this.f5866g = fArr;
        this.f5867h = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    @android.annotation.TargetApi(11)
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.ObjectAnimator m10840a(com.baidu.mapapi.map.Marker r3) {
        /*
            r2 = this;
            int r0 = r2.f5867h
            r1 = 1
            if (r0 != r1) goto Le
            java.lang.String r0 = "scaleX"
        L7:
            float[] r1 = r2.f5866g
            android.animation.ObjectAnimator r3 = android.animation.ObjectAnimator.ofFloat(r3, r0, r1)
            goto L15
        Le:
            r1 = 2
            if (r0 != r1) goto L14
            java.lang.String r0 = "scaleY"
            goto L7
        L14:
            r3 = 0
        L15:
            if (r3 == 0) goto L2f
            int r0 = r2.f5865f
            r3.setRepeatCount(r0)
            int r0 = r2.m10838c()
            r3.setRepeatMode(r0)
            long r0 = r2.f5861b
            r3.setDuration(r0)
            android.view.animation.Interpolator r0 = r2.f5862c
            if (r0 == 0) goto L2f
            r3.setInterpolator(r0)
        L2f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.p087a.C1182f.m10840a(com.baidu.mapapi.map.Marker):android.animation.ObjectAnimator");
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10837a() {
        Animator animator = this.f5860a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10836a(int i) {
        this.f5864e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10835a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f5861b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    protected void mo10834a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.mapsdkplatform.comapi.a.f.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                if (C1182f.this.f5863d != null) {
                    C1182f.this.f5863d.onAnimationCancel();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                if (C1182f.this.f5863d != null) {
                    C1182f.this.f5863d.onAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                if (C1182f.this.f5863d != null) {
                    C1182f.this.f5863d.onAnimationRepeat();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                if (C1182f.this.f5863d != null) {
                    C1182f.this.f5863d.onAnimationStart();
                }
            }
        });
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10833a(Interpolator interpolator) {
        this.f5862c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10832a(Animation.AnimationListener animationListener) {
        this.f5863d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10830a(Marker marker, Animation animation) {
        this.f5860a = m10840a(marker);
        mo10834a(this.f5860a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: b */
    public void mo10828b() {
        Animator animator = this.f5860a;
        if (animator != null) {
            animator.cancel();
            this.f5860a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: b */
    public void mo10827b(int i) {
        if (i > 0) {
            this.f5865f = i;
        }
    }

    /* renamed from: c */
    public int m10838c() {
        return this.f5864e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: c */
    public void mo10825c(int i) {
    }
}
