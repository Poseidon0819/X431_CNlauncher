package com.mopub.common.event;

import com.mopub.network.ScribeRequest;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScribeEventRecorder.java */
/* renamed from: com.mopub.common.event.c */
/* loaded from: classes.dex */
public final class C3691c implements ScribeRequest.ScribeRequestFactory {

    /* renamed from: a */
    final /* synthetic */ List f20209a;

    /* renamed from: b */
    final /* synthetic */ ScribeEventRecorder f20210b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3691c(ScribeEventRecorder scribeEventRecorder, List list) {
        this.f20210b = scribeEventRecorder;
        this.f20209a = list;
    }

    @Override // com.mopub.network.ScribeRequest.ScribeRequestFactory
    public final ScribeRequest createRequest(ScribeRequest.Listener listener) {
        EventSerializer eventSerializer;
        List list = this.f20209a;
        eventSerializer = this.f20210b.f20203c;
        return new ScribeRequest("https://analytics.mopub.com/i/jot/exchange_client_event", list, eventSerializer, listener);
    }
}
