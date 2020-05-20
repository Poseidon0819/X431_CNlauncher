package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapsdkplatform.comapi.synchronization.p089b.C1240b;

/* loaded from: classes.dex */
public class HistoryTraceManager {

    /* renamed from: a */
    private C1240b f5749a = new C1240b();

    public void queryHistoryTraceData(HistoryTraceQueryOptions historyTraceQueryOptions) {
        C1240b c1240b = this.f5749a;
        if (c1240b != null) {
            c1240b.m10519a(historyTraceQueryOptions);
        }
    }

    public void release() {
        C1240b c1240b = this.f5749a;
        if (c1240b != null) {
            c1240b.m10524a();
        }
    }

    public void renderHistoryTrace(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i) {
        C1240b c1240b = this.f5749a;
        if (c1240b != null) {
            c1240b.m10521a(baiduMap, historyTraceData, historyTraceDisplayOptions, i);
        }
    }

    public void setOnHistoryTraceListener(OnHistoryTraceListener onHistoryTraceListener) {
        if (onHistoryTraceListener == null) {
            throw new IllegalArgumentException("HistoryTraceManager-- OnHistoryTraceListener must not be null.");
        }
        C1240b c1240b = this.f5749a;
        if (c1240b != null) {
            c1240b.m10517a(onHistoryTraceListener);
        }
    }
}
