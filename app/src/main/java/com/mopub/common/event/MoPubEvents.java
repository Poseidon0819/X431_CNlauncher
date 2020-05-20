package com.mopub.common.event;

import android.os.HandlerThread;
import com.mopub.common.VisibleForTesting;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MoPubEvents {

    /* renamed from: a */
    private static volatile EventDispatcher f20200a;

    public static void log(BaseEvent baseEvent) {
        m2505a().dispatch(baseEvent);
    }

    @VisibleForTesting
    public static void setEventDispatcher(EventDispatcher eventDispatcher) {
        f20200a = eventDispatcher;
    }

    @VisibleForTesting
    /* renamed from: a */
    private static EventDispatcher m2505a() {
        EventDispatcher eventDispatcher = f20200a;
        if (eventDispatcher == null) {
            synchronized (MoPubEvents.class) {
                eventDispatcher = f20200a;
                if (eventDispatcher == null) {
                    ArrayList arrayList = new ArrayList();
                    HandlerThread handlerThread = new HandlerThread("mopub_event_logging");
                    handlerThread.start();
                    arrayList.add(new ScribeEventRecorder(handlerThread.getLooper()));
                    EventDispatcher eventDispatcher2 = new EventDispatcher(arrayList, handlerThread.getLooper());
                    f20200a = eventDispatcher2;
                    eventDispatcher = eventDispatcher2;
                }
            }
        }
        return eventDispatcher;
    }
}
