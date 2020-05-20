package com.baidu.mapsdkplatform.comapi.p087a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* renamed from: com.baidu.mapsdkplatform.comapi.a.a */
/* loaded from: classes.dex */
public class C1173a extends AbstractC1175b {

    /* renamed from: a */
    private Animator f5829a = null;

    /* renamed from: b */
    private long f5830b = 0;

    /* renamed from: c */
    private Interpolator f5831c = null;

    /* renamed from: d */
    private Animation.AnimationListener f5832d = null;

    /* renamed from: e */
    private int f5833e = 1;

    /* renamed from: f */
    private int f5834f = 0;

    /* renamed from: g */
    private float[] f5835g;

    public C1173a(float... fArr) {
        this.f5835g = fArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    /* renamed from: a */
    public ObjectAnimator m10852a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "alpha", this.f5835g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f5834f);
            ofFloat.setRepeatMode(m10850c());
            ofFloat.setDuration(this.f5830b);
            Interpolator interpolator = this.f5831c;
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
        Animator animator = this.f5829a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10836a(int i) {
        this.f5833e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10835a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f5830b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    protected void mo10834a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.mapsdkplatform.comapi.a.a.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                if (C1173a.this.f5832d != null) {
                    C1173a.this.f5832d.onAnimationCancel();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                if (C1173a.this.f5832d != null) {
                    C1173a.this.f5832d.onAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                if (C1173a.this.f5832d != null) {
                    C1173a.this.f5832d.onAnimationRepeat();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                if (C1173a.this.f5832d != null) {
                    C1173a.this.f5832d.onAnimationStart();
                }
            }
        });
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10833a(Interpolator interpolator) {
        this.f5831c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10832a(Animation.AnimationListener animationListener) {
        this.f5832d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10830a(Marker marker, Animation animation) {
        this.f5829a = m10852a(marker);
        mo10834a(this.f5829a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: b */
    public void mo10828b() {
        Animator animator = this.f5829a;
        if (animator != null) {
            animator.cancel();
            this.f5829a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: b */
    public void mo10827b(int i) {
        if (i > 0) {
            this.f5834f = i;
        }
    }

    /* renamed from: c */
    public int m10850c() {
        return this.f5833e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: c */
    public void mo10825c(int i) {
    }
}
