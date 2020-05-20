package com.mopub.common.event;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.ScribeBackoffPolicy;
import com.mopub.network.ScribeRequestManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class ScribeEventRecorder implements EventRecorder {

    /* renamed from: a */
    private final EventSampler f20201a;

    /* renamed from: b */
    private final Queue<BaseEvent> f20202b;

    /* renamed from: c */
    private final EventSerializer f20203c;

    /* renamed from: d */
    private final ScribeRequestManager f20204d;

    /* renamed from: e */
    private final Handler f20205e;

    /* renamed from: f */
    private final RunnableC3688a f20206f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScribeEventRecorder(Looper looper) {
        this(new EventSampler(), new LinkedList(), new EventSerializer(), new ScribeRequestManager(looper), new Handler(looper));
    }

    @VisibleForTesting
    private ScribeEventRecorder(EventSampler eventSampler, Queue<BaseEvent> queue, EventSerializer eventSerializer, ScribeRequestManager scribeRequestManager, Handler handler) {
        this.f20201a = eventSampler;
        this.f20202b = queue;
        this.f20203c = eventSerializer;
        this.f20204d = scribeRequestManager;
        this.f20205e = handler;
        this.f20206f = new RunnableC3688a();
    }

    @Override // com.mopub.common.event.EventRecorder
    public void record(BaseEvent baseEvent) {
        EventSampler eventSampler = this.f20201a;
        Preconditions.checkNotNull(baseEvent);
        String requestId = baseEvent.getRequestId();
        if (requestId == null) {
            if (eventSampler.f20198a.nextDouble() >= baseEvent.getSamplingRate()) {
                r2 = false;
            }
        } else {
            Boolean bool = eventSampler.f20199b.get(requestId);
            if (bool != null) {
                r2 = bool.booleanValue();
            } else {
                r2 = eventSampler.f20198a.nextDouble() < baseEvent.getSamplingRate();
                eventSampler.f20199b.put(requestId, Boolean.valueOf(r2));
            }
        }
        if (r2) {
            if (this.f20202b.size() >= 500) {
                MoPubLog.m2498d("EventQueue is at max capacity. Event \"" + baseEvent.getName() + "\" is being dropped.");
                return;
            }
            this.f20202b.add(baseEvent);
            if (this.f20202b.size() >= 100) {
                m2504a();
            }
            m2502b();
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    final void m2504a() {
        if (this.f20204d.isAtCapacity()) {
            return;
        }
        List<BaseEvent> m2501c = m2501c();
        if (m2501c.isEmpty()) {
            return;
        }
        this.f20204d.makeRequest(new C3691c(this, m2501c), new ScribeBackoffPolicy());
    }

    @VisibleForTesting
    /* renamed from: c */
    private List<BaseEvent> m2501c() {
        ArrayList arrayList = new ArrayList();
        while (this.f20202b.peek() != null && arrayList.size() < 100) {
            arrayList.add(this.f20202b.poll());
        }
        return arrayList;
    }

    @VisibleForTesting
    /* renamed from: b */
    final void m2502b() {
        if (this.f20205e.hasMessages(0) || this.f20202b.isEmpty()) {
            return;
        }
        this.f20205e.postDelayed(this.f20206f, 120000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.event.ScribeEventRecorder$a */
    /* loaded from: classes.dex */
    public class RunnableC3688a implements Runnable {
        RunnableC3688a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ScribeEventRecorder.this.m2504a();
            ScribeEventRecorder.this.m2502b();
        }
    }
}
