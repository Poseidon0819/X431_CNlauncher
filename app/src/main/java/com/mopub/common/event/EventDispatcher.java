package com.mopub.common.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mopub.common.VisibleForTesting;

/* loaded from: classes.dex */
public class EventDispatcher {

    /* renamed from: a */
    private final Iterable<EventRecorder> f20194a;

    /* renamed from: b */
    private final Looper f20195b;

    /* renamed from: c */
    private final Handler f20196c;

    /* renamed from: d */
    private final Handler.Callback f20197d = new C3689a(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public EventDispatcher(Iterable<EventRecorder> iterable, Looper looper) {
        this.f20194a = iterable;
        this.f20195b = looper;
        this.f20196c = new Handler(this.f20195b, this.f20197d);
    }

    public void dispatch(BaseEvent baseEvent) {
        Message.obtain(this.f20196c, 0, baseEvent).sendToTarget();
    }
}
