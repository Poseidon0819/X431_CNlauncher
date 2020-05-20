package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapsdkplatform.comapi.p087a.C1180e;

/* loaded from: classes.dex */
public class ScaleAnimation extends Animation {
    public ScaleAnimation(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            throw new NullPointerException("the scales is null");
        }
        this.bdAnimation = new C1180e(fArr);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        this.bdAnimation.mo10828b();
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.bdAnimation.mo10832a(animationListener);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long j) {
        this.bdAnimation.mo10835a(j);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.bdAnimation.mo10833a(interpolator);
    }

    public void setRepeatCount(int i) {
        this.bdAnimation.mo10827b(i);
    }

    public void setRepeatMode(Animation.RepeatMode repeatMode) {
        if (repeatMode == Animation.RepeatMode.RESTART) {
            this.bdAnimation.mo10836a(1);
        } else if (repeatMode == Animation.RepeatMode.REVERSE) {
            this.bdAnimation.mo10836a(2);
        }
    }
}
