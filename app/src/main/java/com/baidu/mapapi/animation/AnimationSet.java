package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapsdkplatform.comapi.p087a.C1176c;

/* loaded from: classes.dex */
public class AnimationSet extends Animation {
    public AnimationSet() {
        this.bdAnimation = new C1176c();
    }

    public void addAnimation(Animation animation) {
        if (animation != null) {
            ((C1176c) this.bdAnimation).m10849a(animation);
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        this.bdAnimation.mo10828b();
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.bdAnimation.mo10832a(animationListener);
    }

    public void setAnimatorSetMode(int i) {
        this.bdAnimation.mo10825c(i);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long j) {
        this.bdAnimation.mo10835a(j);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.bdAnimation.mo10833a(interpolator);
    }
}
