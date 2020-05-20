package com.mopub.common.event;

import android.os.Handler;
import android.os.Message;
import com.mopub.common.logging.MoPubLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventDispatcher.java */
/* renamed from: com.mopub.common.event.a */
/* loaded from: classes.dex */
public final class C3689a implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ EventDispatcher f20208a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3689a(EventDispatcher eventDispatcher) {
        this.f20208a = eventDispatcher;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        Iterable<EventRecorder> iterable;
        if (message2.obj instanceof BaseEvent) {
            iterable = this.f20208a.f20194a;
            for (EventRecorder eventRecorder : iterable) {
                eventRecorder.record((BaseEvent) message2.obj);
            }
            return true;
        }
        MoPubLog.m2498d("EventDispatcher received non-BaseEvent message type.");
        return true;
    }
}
