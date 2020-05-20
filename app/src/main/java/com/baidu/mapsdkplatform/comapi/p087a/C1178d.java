package com.baidu.mapsdkplatform.comapi.p087a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* renamed from: com.baidu.mapsdkplatform.comapi.a.d */
/* loaded from: classes.dex */
public class C1178d extends AbstractC1175b {

    /* renamed from: a */
    private Animator f5844a = null;

    /* renamed from: b */
    private long f5845b = 0;

    /* renamed from: c */
    private Interpolator f5846c = null;

    /* renamed from: d */
    private Animation.AnimationListener f5847d = null;

    /* renamed from: e */
    private int f5848e = 1;

    /* renamed from: f */
    private int f5849f = 0;

    /* renamed from: g */
    private float[] f5850g;

    public C1178d(float... fArr) {
        this.f5850g = fArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    /* renamed from: a */
    public ObjectAnimator m10846a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "rotate", this.f5850g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f5849f);
            ofFloat.setRepeatMode(m10844c());
            ofFloat.setDuration(this.f5845b);
            Interpolator interpolator = this.f5846c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10837a() {
        Animator animator = this.f5844a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10836a(int i) {
        this.f5848e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10835a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f5845b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    protected void mo10834a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.mapsdkplatform.comapi.a.d.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                if (C1178d.this.f5847d != null) {
                    C1178d.this.f5847d.onAnimationCancel();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                if (C1178d.this.f5847d != null) {
                    C1178d.this.f5847d.onAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                if (C1178d.this.f5847d != null) {
                    C1178d.this.f5847d.onAnimationRepeat();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                if (C1178d.this.f5847d != null) {
                    C1178d.this.f5847d.onAnimationStart();
                }
            }
        });
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10833a(Interpolator interpolator) {
        this.f5846c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10832a(Animation.AnimationListener animationListener) {
        this.f5847d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10830a(Marker marker, Animation animation) {
        this.f5844a = m10846a(marker);
        mo10834a(this.f5844a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: b */
    public void mo10828b() {
        Animator animator = this.f5844a;
        if (animator != null) {
            animator.cancel();
            this.f5844a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: b */
    public void mo10827b(int i) {
        if (i > 0) {
            this.f5849f = i;
        }
    }

    /* renamed from: c */
    public int m10844c() {
        return this.f5848e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: c */
    public void mo10825c(int i) {
    }
}
