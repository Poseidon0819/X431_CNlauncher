package com.cnlaunch.x431pro.widget.pulltorefresh;

import com.cnlaunch.x431pro.widget.pulltorefresh.PullToRefreshBase;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PullToRefreshBase.java */
/* renamed from: com.cnlaunch.x431pro.widget.pulltorefresh.j */
/* loaded from: classes.dex */
public final /* synthetic */ class C2944j {

    /* renamed from: a */
    static final /* synthetic */ int[] f16731a;

    /* renamed from: b */
    static final /* synthetic */ int[] f16732b;

    /* renamed from: c */
    static final /* synthetic */ int[] f16733c;

    /* renamed from: d */
    static final /* synthetic */ int[] f16734d = new int[PullToRefreshBase.EnumC2932a.values().length];

    static {
        try {
            f16734d[PullToRefreshBase.EnumC2932a.ROTATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16734d[PullToRefreshBase.EnumC2932a.FLIP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f16733c = new int[PullToRefreshBase.EnumC2933b.values().length];
        try {
            f16733c[PullToRefreshBase.EnumC2933b.PULL_FROM_END.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16733c[PullToRefreshBase.EnumC2933b.PULL_FROM_START.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f16733c[PullToRefreshBase.EnumC2933b.MANUAL_REFRESH_ONLY.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f16733c[PullToRefreshBase.EnumC2933b.BOTH.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        f16732b = new int[PullToRefreshBase.EnumC2941j.values().length];
        try {
            f16732b[PullToRefreshBase.EnumC2941j.RESET.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f16732b[PullToRefreshBase.EnumC2941j.PULL_TO_REFRESH.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f16732b[PullToRefreshBase.EnumC2941j.RELEASE_TO_REFRESH.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f16732b[PullToRefreshBase.EnumC2941j.REFRESHING.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f16732b[PullToRefreshBase.EnumC2941j.MANUAL_REFRESHING.ordinal()] = 5;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f16732b[PullToRefreshBase.EnumC2941j.OVERSCROLLING.ordinal()] = 6;
        } catch (NoSuchFieldError unused12) {
        }
        f16731a = new int[PullToRefreshBase.EnumC2939h.values().length];
        try {
            f16731a[PullToRefreshBase.EnumC2939h.HORIZONTAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f16731a[PullToRefreshBase.EnumC2939h.VERTICAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused14) {
        }
    }
}
