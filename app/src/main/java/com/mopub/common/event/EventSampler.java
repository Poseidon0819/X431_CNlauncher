package com.mopub.common.event;

import com.mopub.common.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.Random;

/* loaded from: classes.dex */
public class EventSampler {

    /* renamed from: a */
    Random f20198a;

    /* renamed from: b */
    LinkedHashMap<String, Boolean> f20199b;

    public EventSampler() {
        this(new Random());
    }

    @VisibleForTesting
    public EventSampler(Random random) {
        this.f20198a = random;
        this.f20199b = new C3690b(this, 135, 0.75f, true);
    }
}
