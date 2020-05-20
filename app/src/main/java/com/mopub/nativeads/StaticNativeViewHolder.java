package com.mopub.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;

/* renamed from: com.mopub.nativeads.bc */
/* loaded from: classes2.dex */
final class StaticNativeViewHolder {
    @VisibleForTesting

    /* renamed from: h */
    static final StaticNativeViewHolder f21111h = new StaticNativeViewHolder();

    /* renamed from: a */
    View f21112a;

    /* renamed from: b */
    TextView f21113b;

    /* renamed from: c */
    TextView f21114c;

    /* renamed from: d */
    TextView f21115d;

    /* renamed from: e */
    ImageView f21116e;

    /* renamed from: f */
    ImageView f21117f;

    /* renamed from: g */
    ImageView f21118g;

    private StaticNativeViewHolder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static StaticNativeViewHolder m2065a(View view, ViewBinder viewBinder) {
        StaticNativeViewHolder staticNativeViewHolder = new StaticNativeViewHolder();
        staticNativeViewHolder.f21112a = view;
        try {
            staticNativeViewHolder.f21113b = (TextView) view.findViewById(viewBinder.f21027b);
            staticNativeViewHolder.f21114c = (TextView) view.findViewById(viewBinder.f21028c);
            staticNativeViewHolder.f21115d = (TextView) view.findViewById(viewBinder.f21029d);
            staticNativeViewHolder.f21116e = (ImageView) view.findViewById(viewBinder.f21030e);
            staticNativeViewHolder.f21117f = (ImageView) view.findViewById(viewBinder.f21031f);
            staticNativeViewHolder.f21118g = (ImageView) view.findViewById(viewBinder.f21032g);
            return staticNativeViewHolder;
        } catch (ClassCastException e) {
            MoPubLog.m2489w("Could not cast from id in ViewBinder to expected View type", e);
            return f21111h;
        }
    }
}
