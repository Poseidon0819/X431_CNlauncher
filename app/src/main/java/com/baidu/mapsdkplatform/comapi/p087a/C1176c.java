package com.baidu.mapsdkplatform.comapi.p087a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.AlphaAnimation;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.RotateAnimation;
import com.baidu.mapapi.animation.ScaleAnimation;
import com.baidu.mapapi.animation.SingleScaleAnimation;
import com.baidu.mapapi.animation.Transformation;
import com.baidu.mapapi.map.Marker;
import java.util.ArrayList;

/* renamed from: com.baidu.mapsdkplatform.comapi.a.c */
/* loaded from: classes.dex */
public class C1176c extends AbstractC1175b {

    /* renamed from: a */
    private Animator f5837a = null;

    /* renamed from: b */
    private long f5838b = 0;

    /* renamed from: c */
    private Interpolator f5839c = null;

    /* renamed from: d */
    private Animation.AnimationListener f5840d = null;

    /* renamed from: e */
    private int f5841e = 0;

    /* renamed from: f */
    private ArrayList<Animation> f5842f = new ArrayList<>();

    @TargetApi(11)
    /* renamed from: b */
    private ObjectAnimator m10847b(Marker marker, Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return ((C1173a) animation.bdAnimation).m10852a(marker);
        }
        if (animation instanceof RotateAnimation) {
            return ((C1178d) animation.bdAnimation).m10846a(marker);
        }
        if (animation instanceof Transformation) {
            return ((C1184g) animation.bdAnimation).m10831a(marker);
        }
        if (animation instanceof ScaleAnimation) {
            return ((C1180e) animation.bdAnimation).m10843a(marker);
        }
        if (animation instanceof SingleScaleAnimation) {
            return ((C1182f) animation.bdAnimation).m10840a(marker);
        }
        return null;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10837a() {
        Animator animator = this.f5837a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10836a(int i) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10835a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f5838b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    protected void mo10834a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new Animator.AnimatorListener() { // from class: com.baidu.mapsdkplatform.comapi.a.c.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                if (C1176c.this.f5840d != null) {
                    C1176c.this.f5840d.onAnimationCancel();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                if (C1176c.this.f5840d != null) {
                    C1176c.this.f5840d.onAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                if (C1176c.this.f5840d != null) {
                    C1176c.this.f5840d.onAnimationRepeat();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                if (C1176c.this.f5840d != null) {
                    C1176c.this.f5840d.onAnimationStart();
                }
            }
        });
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10833a(Interpolator interpolator) {
        this.f5839c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: a */
    public void mo10832a(Animation.AnimationListener animationListener) {
        this.f5840d = animationListener;
    }

    /* renamed from: a */
    public void m10849a(Animation animation) {
        if (this.f5842f.contains(animation)) {
            return;
        }
        this.f5842f.add(animation);
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: a */
    public void mo10830a(Marker marker, Animation animation) {
        ObjectAnimator m10847b;
        this.f5837a = new AnimatorSet();
        ArrayList<Animation> arrayList = this.f5842f;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            Animation animation2 = arrayList.get(i);
            if (animation2 != null && (m10847b = m10847b(marker, animation2)) != null) {
                arrayList2.add(m10847b);
            }
        }
        long j = this.f5838b;
        if (j != 0) {
            this.f5837a.setDuration(j);
        }
        Interpolator interpolator = this.f5839c;
        if (interpolator != null) {
            this.f5837a.setInterpolator(interpolator);
        }
        if (arrayList2.size() != 0) {
            int i2 = this.f5841e;
            if (i2 == 0) {
                ((AnimatorSet) this.f5837a).playTogether(arrayList2);
            } else if (i2 == 1) {
                ((AnimatorSet) this.f5837a).playSequentially(arrayList2);
            }
        }
        mo10834a(this.f5837a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    @TargetApi(11)
    /* renamed from: b */
    public void mo10828b() {
        Animator animator = this.f5837a;
        if (animator != null) {
            animator.cancel();
            this.f5837a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: b */
    public void mo10827b(int i) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b
    /* renamed from: c */
    public void mo10825c(int i) {
        this.f5841e = i;
    }
}
