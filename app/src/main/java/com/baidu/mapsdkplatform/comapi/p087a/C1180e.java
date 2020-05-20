package com.baidu.mapsdkplatform.comapi.p087a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* renamed from: com.baidu.mapsdkplatform.comapi.a.e */
/* loaded from: classes.dex */
public class C1180e extends AbstractC1175b {

    /* renamed from: a */
    private Animator f5852a = null;

    /* renamed from: b */
    private long f5853b = 0;

    /* renamed from: c */
    private Interpolator f5854c = null;

    /* renamed from: d */
    private Animation.AnimationListener f5855d = null;

    /* renamed from: e */
    private int f5856e = 1;

    /* renamed from: f */
    private int f5857f = 0;

    /* renamed from: g */
    private float[] f5858g;

    public C1180e(float... fArr) {
        this.f5858g = fArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    /* renamed from: a */
    public ObjectAnimator m10843a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "scale", this.f5858g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f5857f);
            ofFloat.setRepeatMode(m10841c());
            ofFloat.setDuration(this.f5853b);
            Interpolator interpolator = this.f5854c;
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
        Animator animator = this.f5852a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10836a(int i) {
        this.f5856e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10835a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f5853b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    protected void mo10834a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.mapsdkplatform.comapi.a.e.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                if (C1180e.this.f5855d != null) {
                    C1180e.this.f5855d.onAnimationCancel();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                if (C1180e.this.f5855d != null) {
                    C1180e.this.f5855d.onAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                if (C1180e.this.f5855d != null) {
                    C1180e.this.f5855d.onAnimationRepeat();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                if (C1180e.this.f5855d != null) {
                    C1180e.this.f5855d.onAnimationStart();
                }
            }
        });
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10833a(Interpolator interpolator) {
        this.f5854c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10832a(Animation.AnimationListener animationListener) {
        this.f5855d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10830a(Marker marker, Animation animation) {
        this.f5852a = m10843a(marker);
        mo10834a(this.f5852a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: b */
    public void mo10828b() {
        Animator animator = this.f5852a;
        if (animator != null) {
            animator.cancel();
            this.f5852a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: b */
    public void mo10827b(int i) {
        if (i > 0) {
            this.f5857f = i;
        }
    }

    /* renamed from: c */
    public int m10841c() {
        return this.f5856e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: c */
    public void mo10825c(int i) {
    }
}
