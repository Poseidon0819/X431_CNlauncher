package com.mopub.nativeads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ViewBinder {

    /* renamed from: a */
    final int f21026a;

    /* renamed from: b */
    final int f21027b;

    /* renamed from: c */
    final int f21028c;

    /* renamed from: d */
    final int f21029d;

    /* renamed from: e */
    final int f21030e;

    /* renamed from: f */
    final int f21031f;

    /* renamed from: g */
    final int f21032g;

    /* renamed from: h */
    final Map<String, Integer> f21033h;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        private final int f21034a;

        /* renamed from: b */
        private int f21035b;

        /* renamed from: c */
        private int f21036c;

        /* renamed from: d */
        private int f21037d;

        /* renamed from: e */
        private int f21038e;

        /* renamed from: f */
        private int f21039f;

        /* renamed from: g */
        private int f21040g;

        /* renamed from: h */
        private Map<String, Integer> f21041h;

        public Builder(int i) {
            this.f21041h = Collections.emptyMap();
            this.f21034a = i;
            this.f21041h = new HashMap();
        }

        public final Builder titleId(int i) {
            this.f21035b = i;
            return this;
        }

        public final Builder textId(int i) {
            this.f21036c = i;
            return this;
        }

        public final Builder callToActionId(int i) {
            this.f21037d = i;
            return this;
        }

        public final Builder mainImageId(int i) {
            this.f21038e = i;
            return this;
        }

        public final Builder iconImageId(int i) {
            this.f21039f = i;
            return this;
        }

        public final Builder privacyInformationIconImageId(int i) {
            this.f21040g = i;
            return this;
        }

        public final Builder addExtras(Map<String, Integer> map) {
            this.f21041h = new HashMap(map);
            return this;
        }

        public final Builder addExtra(String str, int i) {
            this.f21041h.put(str, Integer.valueOf(i));
            return this;
        }

        public final ViewBinder build() {
            return new ViewBinder(this, (byte) 0);
        }
    }

    /* synthetic */ ViewBinder(Builder builder, byte b) {
        this(builder);
    }

    private ViewBinder(Builder builder) {
        this.f21026a = builder.f21034a;
        this.f21027b = builder.f21035b;
        this.f21028c = builder.f21036c;
        this.f21029d = builder.f21037d;
        this.f21030e = builder.f21038e;
        this.f21031f = builder.f21039f;
        this.f21032g = builder.f21040g;
        this.f21033h = builder.f21041h;
    }
}
