package com.artifex.mupdflib;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class Stepper {
    protected boolean mPending = false;
    protected final View mPoster;
    protected final Runnable mTask;

    public Stepper(View view, Runnable runnable) {
        this.mPoster = view;
        this.mTask = runnable;
    }

    @SuppressLint({"NewApi"})
    public void prod() {
        if (this.mPending) {
            return;
        }
        this.mPending = true;
        if (Build.VERSION.SDK_INT >= 16) {
            this.mPoster.postOnAnimation(new Runnable() { // from class: com.artifex.mupdflib.Stepper.1
                @Override // java.lang.Runnable
                public void run() {
                    Stepper stepper = Stepper.this;
                    stepper.mPending = false;
                    stepper.mTask.run();
                }
            });
        } else {
            this.mPoster.post(new Runnable() { // from class: com.artifex.mupdflib.Stepper.2
                @Override // java.lang.Runnable
                public void run() {
                    Stepper stepper = Stepper.this;
                    stepper.mPending = false;
                    stepper.mTask.run();
                }
            });
        }
    }
}
