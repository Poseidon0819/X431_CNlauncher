package com.mopub.nativeads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MediaViewBinder {

    /* renamed from: a */
    final int f20802a;

    /* renamed from: b */
    final int f20803b;

    /* renamed from: c */
    final int f20804c;

    /* renamed from: d */
    final int f20805d;

    /* renamed from: e */
    final int f20806e;

    /* renamed from: f */
    final int f20807f;

    /* renamed from: g */
    final int f20808g;

    /* renamed from: h */
    final Map<String, Integer> f20809h;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        private final int f20810a;

        /* renamed from: b */
        private int f20811b;

        /* renamed from: c */
        private int f20812c;

        /* renamed from: d */
        private int f20813d;

        /* renamed from: e */
        private int f20814e;

        /* renamed from: f */
        private int f20815f;

        /* renamed from: g */
        private int f20816g;

        /* renamed from: h */
        private Map<String, Integer> f20817h;

        public Builder(int i) {
            this.f20817h = Collections.emptyMap();
            this.f20810a = i;
            this.f20817h = new HashMap();
        }

        public final Builder mediaLayoutId(int i) {
            this.f20811b = i;
            return this;
        }

        public final Builder titleId(int i) {
            this.f20812c = i;
            return this;
        }

        public final Builder textId(int i) {
            this.f20813d = i;
            return this;
        }

        public final Builder iconImageId(int i) {
            this.f20814e = i;
            return this;
        }

        public final Builder callToActionId(int i) {
            this.f20815f = i;
            return this;
        }

        public final Builder privacyInformationIconImageId(int i) {
            this.f20816g = i;
            return this;
        }

        public final Builder addExtras(Map<String, Integer> map) {
            this.f20817h = new HashMap(map);
            return this;
        }

        public final Builder addExtra(String str, int i) {
            this.f20817h.put(str, Integer.valueOf(i));
            return this;
        }

        public final MediaViewBinder build() {
            return new MediaViewBinder(this, (byte) 0);
        }
    }

    /* synthetic */ MediaViewBinder(Builder builder, byte b) {
        this(builder);
    }

    private MediaViewBinder(Builder builder) {
        this.f20802a = builder.f20810a;
        this.f20803b = builder.f20811b;
        this.f20804c = builder.f20812c;
        this.f20805d = builder.f20813d;
        this.f20806e = builder.f20815f;
        this.f20807f = builder.f20814e;
        this.f20808g = builder.f20816g;
        this.f20809h = builder.f20817h;
    }
}
