package com.baidu.mapsdkplatform.comapi.synchronization.p089b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceDisplayOptions;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.mapsdkplatform.comapi.synchronization.p090c.AbstractC1253c;
import com.baidu.mapsdkplatform.comapi.synchronization.p090c.C1247a;
import com.baidu.mapsdkplatform.comapi.synchronization.p090c.C1250b;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;

/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.b.b */
/* loaded from: classes.dex */
public class C1240b {

    /* renamed from: a */
    private static final String f6157a = "b";

    /* renamed from: b */
    private static C1247a f6158b;

    /* renamed from: c */
    private static OnHistoryTraceListener f6159c;

    /* renamed from: e */
    private static HandlerC1239a f6160e;

    /* renamed from: g */
    private static int f6161g;

    /* renamed from: d */
    private HandlerThread f6162d;

    /* renamed from: f */
    private HandlerC1242a f6163f;

    /* renamed from: h */
    private HandlerThread f6164h;

    /* renamed from: i */
    private HandlerC1244c f6165i;

    /* renamed from: j */
    private volatile boolean f6166j = false;

    /* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.b.b$a */
    /* loaded from: classes.dex */
    public static class HandlerC1242a extends Handler {
        /* renamed from: a */
        private String m10508a(HistoryTraceQueryOptions historyTraceQueryOptions) {
            String m10486a = new C1245d(historyTraceQueryOptions).m10486a();
            if (TextUtils.isEmpty(m10486a)) {
                C1255a.m10453b(C1240b.f6157a, "Build request url failed");
                return null;
            }
            return m10486a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m10509a(int i, String str, int i2, HistoryTraceQueryOptions historyTraceQueryOptions) {
            if (C1240b.f6160e == null) {
                C1255a.m10453b(C1240b.f6157a, "Data parser handler is null");
                return;
            }
            Message obtainMessage = C1240b.f6160e.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            obtainMessage.obj = str;
            C1240b.f6160e.sendMessage(obtainMessage);
            C1240b.f6160e.m10531a(historyTraceQueryOptions);
        }

        /* renamed from: a */
        private void m10507a(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
            String m10508a = m10508a(historyTraceQueryOptions);
            if (TextUtils.isEmpty(m10508a)) {
                C1240b.m10514b(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_URL_NULL, "QueryOptions is null, please check.", i);
            } else {
                m10502a(m10508a, i, historyTraceQueryOptions);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m10503a(C1250b.EnumC1252a enumC1252a, int i) {
            int i2;
            String str;
            switch (enumC1252a) {
                case SUCCESS:
                    i2 = 0;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
                    break;
                case INNER_ERROR:
                case SERVER_ERROR:
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_SERVER_INNER_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SERVER_INNER_ERROR;
                    break;
                case NETWORK_ERROR:
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_NETWORK_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_NETWORK_ERROR;
                    break;
                case REQUEST_ERROR:
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_REQUEST_PARAMETER_ERROR;
                    break;
                default:
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_UNDEFINE_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_UNDEFINE_ERROR;
                    break;
            }
            C1240b.m10514b(i2, str, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m10502a(final String str, final int i, final HistoryTraceQueryOptions historyTraceQueryOptions) {
            if (TextUtils.isEmpty(str)) {
                C1255a.m10453b(C1240b.f6157a, "Request url is null");
                return;
            }
            if (C1240b.f6158b == null) {
                C1247a unused = C1240b.f6158b = new C1247a();
            }
            C1240b.f6158b.m10477a(str, new AbstractC1253c() { // from class: com.baidu.mapsdkplatform.comapi.synchronization.b.b.a.1
                @Override // com.baidu.mapsdkplatform.comapi.synchronization.p090c.AbstractC1253c
                /* renamed from: a */
                public void mo10322a(C1250b.EnumC1252a enumC1252a) {
                    if ((C1250b.EnumC1252a.SERVER_ERROR == enumC1252a || C1250b.EnumC1252a.NETWORK_ERROR == enumC1252a || C1250b.EnumC1252a.INNER_ERROR == enumC1252a || C1250b.EnumC1252a.REQUEST_ERROR == enumC1252a) && C1240b.f6161g <= 2) {
                        HandlerC1242a.this.m10502a(str, i, historyTraceQueryOptions);
                        C1240b.f6161g++;
                    }
                    if (2 < C1240b.f6161g) {
                        HandlerC1242a.this.m10503a(enumC1252a, i);
                    }
                }

                @Override // com.baidu.mapsdkplatform.comapi.synchronization.p090c.AbstractC1253c
                /* renamed from: a */
                public void mo10321a(String str2) {
                    C1255a.m10453b(C1240b.f6157a, "Request success, the result = ".concat(String.valueOf(str2)));
                    HandlerC1242a.this.m10509a(3, str2, i, historyTraceQueryOptions);
                    int unused2 = C1240b.f6161g = 0;
                }
            });
        }

        @Override // android.os.Handler
        public void handleMessage(Message message2) {
            int i = message2.what;
            C1255a.m10452c(C1240b.f6157a, "The query type is: ".concat(String.valueOf(i)));
            HistoryTraceQueryOptions historyTraceQueryOptions = (HistoryTraceQueryOptions) message2.obj;
            if (i != 1) {
                return;
            }
            m10507a(historyTraceQueryOptions, i);
        }
    }

    public C1240b() {
        f6158b = new C1247a();
        this.f6163f = new HandlerC1242a();
        this.f6162d = new HandlerThread("HistoryTraceDataParser");
        this.f6162d.start();
        HandlerC1239a handlerC1239a = new HandlerC1239a(this.f6162d.getLooper());
        f6160e = handlerC1239a;
        handlerC1239a.m10529a(this.f6163f);
        this.f6164h = new HandlerThread("HistoryTraceRender");
        this.f6164h.start();
        this.f6165i = new HandlerC1244c(this.f6164h.getLooper());
    }

    /* renamed from: a */
    private void m10520a(HistoryTraceData historyTraceData, int i) {
        if (this.f6165i == null) {
            this.f6165i = new HandlerC1244c(this.f6164h.getLooper());
        }
        Message obtainMessage = this.f6165i.obtainMessage();
        obtainMessage.what = i;
        if (historyTraceData != null) {
            obtainMessage.obj = historyTraceData;
        }
        this.f6165i.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    private boolean m10518a(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
        int i2;
        String str;
        if (historyTraceQueryOptions == null) {
            C1255a.m10453b(f6157a, "QueryOptions is null, please check!");
            i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_OPTIONS_NULL;
            str = "QueryOptions is null, please check.";
        } else if (TextUtils.isEmpty(historyTraceQueryOptions.getOrderId())) {
            C1255a.m10453b(f6157a, "Query orderId is null, please check");
            i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ORDER_ID_NULL;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ORDER_ID_NULL;
        } else if (historyTraceQueryOptions.getRoleType() != 0) {
            C1255a.m10453b(f6157a, "Current role type not the passenger");
            i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ROLE_TYPE_ERROR;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ROLE_TYPE_ERROR;
        } else if (TextUtils.isEmpty(historyTraceQueryOptions.getUserId())) {
            C1255a.m10453b(f6157a, "Order's user id is null");
            i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_USER_ID_NULL;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_USER_ID_NULL;
        } else if (!TextUtils.isEmpty(historyTraceQueryOptions.getDriverId())) {
            return true;
        } else {
            C1255a.m10453b(f6157a, "Driver id is null");
            i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_DRIVER_ID_NULL;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_DRIVER_ID_NULL;
        }
        m10514b(i2, str, i);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m10514b(int i, String str, int i2) {
        OnHistoryTraceListener onHistoryTraceListener = f6159c;
        if (onHistoryTraceListener == null) {
            C1255a.m10453b(f6157a, "OnHistoryTraceListener is null");
            return;
        }
        switch (i2) {
            case 1:
                onHistoryTraceListener.onQueryHistroyTraceData(i, str, null);
                return;
            case 2:
                onHistoryTraceListener.onRenderHistroyTrace(i, str);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m10513b(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
        if (this.f6163f == null) {
            this.f6163f = new HandlerC1242a();
        }
        Message obtainMessage = this.f6163f.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = historyTraceQueryOptions;
        this.f6163f.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    public void m10524a() {
        if (f6158b != null) {
            f6158b = null;
        }
        if (f6159c != null) {
            f6159c = null;
        }
        HandlerC1242a handlerC1242a = this.f6163f;
        if (handlerC1242a != null) {
            handlerC1242a.removeCallbacksAndMessages(null);
            this.f6163f = null;
        }
        HandlerC1239a handlerC1239a = f6160e;
        if (handlerC1239a != null) {
            handlerC1239a.removeCallbacksAndMessages(null);
            f6160e.m10534a();
            f6160e = null;
        }
        HandlerThread handlerThread = this.f6162d;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f6162d = null;
        }
        HandlerC1244c handlerC1244c = this.f6165i;
        if (handlerC1244c != null) {
            handlerC1244c.removeCallbacksAndMessages(null);
            this.f6165i.m10501a();
            this.f6165i = null;
        }
        HandlerThread handlerThread2 = this.f6164h;
        if (handlerThread2 != null) {
            handlerThread2.quit();
            this.f6164h = null;
        }
        this.f6166j = false;
    }

    /* renamed from: a */
    public void m10521a(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i) {
        if (baiduMap == null) {
            C1255a.m10453b(f6157a, "BaiduMap instance is null");
            OnHistoryTraceListener onHistoryTraceListener = f6159c;
            if (onHistoryTraceListener != null) {
                onHistoryTraceListener.onRenderHistroyTrace(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
            }
        } else if (5 == i) {
            this.f6165i.m10495a(historyTraceDisplayOptions, baiduMap, i);
            m10520a(historyTraceData, 4);
        } else {
            OnHistoryTraceListener onHistoryTraceListener2 = f6159c;
            if (onHistoryTraceListener2 != null) {
                onHistoryTraceListener2.onRenderHistroyTrace(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
            }
        }
    }

    /* renamed from: a */
    public void m10519a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        if (m10518a(historyTraceQueryOptions, 1)) {
            m10513b(historyTraceQueryOptions, 1);
        } else {
            C1255a.m10453b(f6157a, "QueryOptions error, please check!");
        }
    }

    /* renamed from: a */
    public void m10517a(OnHistoryTraceListener onHistoryTraceListener) {
        f6159c = onHistoryTraceListener;
        f6160e.m10530a(onHistoryTraceListener);
        this.f6165i.m10494a(onHistoryTraceListener);
    }
}
