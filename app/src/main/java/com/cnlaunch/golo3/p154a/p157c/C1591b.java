package com.cnlaunch.golo3.p154a.p157c;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.cnlaunch.golo3.p154a.p156b.C1580e;

/* compiled from: SimpleDisplayer.java */
/* renamed from: com.cnlaunch.golo3.a.c.b */
/* loaded from: classes.dex */
public final class C1591b implements InterfaceC1590a {
    @Override // com.cnlaunch.golo3.p154a.p157c.InterfaceC1590a
    /* renamed from: a */
    public final void mo9190a(View view, Drawable drawable) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.cnlaunch.golo3.p154a.p157c.InterfaceC1590a
    /* renamed from: a */
    public final void mo9191a(View view, Bitmap bitmap, C1580e c1580e) {
        switch (c1580e.f7743d) {
            case 0:
                Animation animation = c1580e.f7742c;
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
