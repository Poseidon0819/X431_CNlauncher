package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapsdkplatform.comapi.p087a.C1178d;
import com.itextpdf.text.pdf.ColumnText;

/* loaded from: classes.dex */
public class RotateAnimation extends Animation {
    public RotateAnimation(float f, float f2) {
        if (f < ColumnText.GLOBAL_SPACE_CHAR_RATIO || f2 < ColumnText.GLOBAL_SPACE_CHAR_RATIO) {
            throw new NullPointerException("the degrees can't less than zero");
        }
        this.bdAnimation = new C1178d(f, f2);
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
