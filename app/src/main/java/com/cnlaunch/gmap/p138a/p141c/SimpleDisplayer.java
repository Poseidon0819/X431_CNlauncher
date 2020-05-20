package com.cnlaunch.gmap.p138a.p141c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.cnlaunch.gmap.p138a.p140b.BitmapDisplayConfig;

/* renamed from: com.cnlaunch.gmap.a.c.b */
/* loaded from: classes.dex */
public final class SimpleDisplayer implements Displayer {
    @Override // com.cnlaunch.gmap.p138a.p141c.Displayer
    /* renamed from: a */
    public final void mo9357a(View view, Drawable drawable) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.cnlaunch.gmap.p138a.p141c.Displayer
    /* renamed from: a */
    public final void mo9358a(View view, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig) {
        switch (bitmapDisplayConfig.f7401d) {
            case 0:
                Animation animation = bitmapDisplayConfig.f7400c;
                animation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageBitmap(bitmap);
                } else {
                    view.setBackgroundDrawable(new BitmapDrawable(bitmap));
                }
                view.startAnimation(animation);
                return;
            case 1:
                TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(17170445), new BitmapDrawable(view.getResources(), bitmap)});
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageDrawable(transitionDrawable);
                } else {
                    view.setBackgroundDrawable(transitionDrawable);
                }
                transitionDrawable.startTransition(300);
                return;
            default:
                return;
        }
    }
}
