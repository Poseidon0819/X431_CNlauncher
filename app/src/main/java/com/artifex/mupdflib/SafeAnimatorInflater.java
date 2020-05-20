package com.artifex.mupdflib;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SafeAnimatorInflater {
    private View mView;

    public SafeAnimatorInflater(Activity activity, int i, View view) {
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(activity, C0835R.anim.info);
        this.mView = view;
        animatorSet.setTarget(view);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.artifex.mupdflib.SafeAnimatorInflater.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SafeAnimatorInflater.this.mView.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SafeAnimatorInflater.this.mView.setVisibility(4);
            }
        });
        animatorSet.start();
    }
}
