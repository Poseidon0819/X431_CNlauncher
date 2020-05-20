package com.cnlaunch.p169im.p172c;

import android.graphics.drawable.AnimationDrawable;
import android.view.MotionEvent;
import android.view.View;
import com.cnlaunch.p169im.p170a.LayoutAdapter;

/* compiled from: ProMessageFragment.java */
/* renamed from: com.cnlaunch.im.c.q */
/* loaded from: classes.dex */
public final class View$OnTouchListenerC1721q implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ ProMessageFragment f9153a;

    public View$OnTouchListenerC1721q(ProMessageFragment proMessageFragment) {
        this.f9153a = proMessageFragment;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AnimationDrawable unused;
        LayoutAdapter layoutAdapter = this.f9153a.f9127j;
        unused = this.f9153a.f9111R;
        layoutAdapter.m8901a(motionEvent, this.f9153a.f9123f, this.f9153a.f9109P);
        return false;
    }
}
