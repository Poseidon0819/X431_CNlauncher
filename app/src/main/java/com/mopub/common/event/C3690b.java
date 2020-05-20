package com.mopub.common.event;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: EventSampler.java */
/* renamed from: com.mopub.common.event.b */
/* loaded from: classes.dex */
final class C3690b extends LinkedHashMap<String, Boolean> {
    final /* synthetic */ EventSampler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3690b(EventSampler eventSampler, int i, float f, boolean z) {
        super(i, f, z);
        this.this$0 = eventSampler;
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry<String, Boolean> entry) {
        return size() > 100;
    }
}
