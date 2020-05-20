package com.cnlaunch.golo3.p154a.p159e;

import android.widget.AbsListView;
import com.cnlaunch.golo3.p154a.C1551a;

/* renamed from: com.cnlaunch.golo3.a.e.a */
/* loaded from: classes.dex */
public final class PauseOnScrollListener implements AbsListView.OnScrollListener {

    /* renamed from: a */
    private C1551a f7792a;

    /* renamed from: b */
    private final boolean f7793b;

    /* renamed from: c */
    private final boolean f7794c;

    /* renamed from: d */
    private final AbsListView.OnScrollListener f7795d;

    public PauseOnScrollListener(C1551a c1551a) {
        this(c1551a, (byte) 0);
    }

    private PauseOnScrollListener(C1551a c1551a, byte b) {
        this.f7792a = c1551a;
        this.f7793b = true;
        this.f7794c = true;
        this.f7795d = null;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
                this.f7792a.m9254a(false);
                break;
            case 1:
                if (this.f7793b) {
                    this.f7792a.m9254a(true);
                    break;
                }
                break;
            case 2:
                if (this.f7794c) {
                    this.f7792a.m9254a(true);
                    break;
                }
                break;
        }
        AbsListView.OnScrollListener onScrollListener = this.f7795d;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener = this.f7795d;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }
}
