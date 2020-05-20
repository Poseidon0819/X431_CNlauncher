package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.p087a.AbstractC1175b;

/* loaded from: classes.dex */
public abstract class Animation {
    public AbstractC1175b bdAnimation;

    /* loaded from: classes.dex */
    public interface AnimationListener {
        void onAnimationCancel();

        void onAnimationEnd();

        void onAnimationRepeat();

        void onAnimationStart();
    }

    /* loaded from: classes.dex */
    public enum RepeatMode {
        RESTART,
        REVERSE
    }

    public abstract void cancel();

    public abstract void setAnimationListener(AnimationListener animationListener);

    public abstract void setDuration(long j);

    public abstract void setInterpolator(Interpolator interpolator);
}
