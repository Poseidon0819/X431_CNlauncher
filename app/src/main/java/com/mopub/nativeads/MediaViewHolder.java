package com.mopub.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;

/* renamed from: com.mopub.nativeads.f */
/* loaded from: classes2.dex */
final class MediaViewHolder {
    @VisibleForTesting

    /* renamed from: h */
    static final MediaViewHolder f21142h = new MediaViewHolder();

    /* renamed from: a */
    View f21143a;

    /* renamed from: b */
    MediaLayout f21144b;

    /* renamed from: c */
    TextView f21145c;

    /* renamed from: d */
    TextView f21146d;

    /* renamed from: e */
    ImageView f21147e;

    /* renamed from: f */
    TextView f21148f;

    /* renamed from: g */
    ImageView f21149g;

    private MediaViewHolder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static MediaViewHolder m2055a(View view, MediaViewBinder mediaViewBinder) {
        MediaViewHolder mediaViewHolder = new MediaViewHolder();
        mediaViewHolder.f21143a = view;
        try {
            mediaViewHolder.f21145c = (TextView) view.findViewById(mediaViewBinder.f20804c);
            mediaViewHolder.f21146d = (TextView) view.findViewById(mediaViewBinder.f20805d);
            mediaViewHolder.f21148f = (TextView) view.findViewById(mediaViewBinder.f20806e);
            mediaViewHolder.f21144b = (MediaLayout) view.findViewById(mediaViewBinder.f20803b);
            mediaViewHolder.f21147e = (ImageView) view.findViewById(mediaViewBinder.f20807f);
            mediaViewHolder.f21149g = (ImageView) view.findViewById(mediaViewBinder.f20808g);
            return mediaViewHolder;
        } catch (ClassCastException e) {
            MoPubLog.m2489w("Could not cast from id in MediaViewBinder to expected View type", e);
            return f21142h;
        }
    }
}
