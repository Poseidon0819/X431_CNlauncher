package com.baidu.mapsdkplatform.comapi.synchronization.p089b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.mapsdkplatform.comapi.synchronization.p089b.C1240b;
import com.baidu.mapsdkplatform.comapi.synchronization.p091d.C1255a;
import com.cnlaunch.p169im.p174db.MessageDao;
import com.itextpdf.text.html.HtmlTags;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mapsdkplatform.comapi.synchronization.b.a */
/* loaded from: classes.dex */
public class HandlerC1239a extends Handler {

    /* renamed from: a */
    private static final String f6146a = "a";

    /* renamed from: b */
    private static OnHistoryTraceListener f6147b = null;

    /* renamed from: h */
    private static boolean f6148h = false;

    /* renamed from: c */
    private HistoryTraceData f6149c;

    /* renamed from: d */
    private List<HistoryTraceData.HistoryTracePoint> f6150d;

    /* renamed from: e */
    private C1240b.HandlerC1242a f6151e;

    /* renamed from: f */
    private HistoryTraceQueryOptions f6152f;

    /* renamed from: g */
    private boolean f6153g;

    /* renamed from: i */
    private int f6154i;

    /* renamed from: j */
    private String f6155j;

    /* renamed from: k */
    private SparseArray<List<HistoryTraceData.HistoryTracePoint>> f6156k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1239a(Looper looper) {
        super(looper);
        this.f6153g = false;
        this.f6154i = 0;
        this.f6155j = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
        this.f6150d = new ArrayList();
        this.f6149c = new HistoryTraceData();
        this.f6156k = new SparseArray<>();
    }

    /* renamed from: a */
    private LatLng m10528a(String str) {
        if (TextUtils.isEmpty(str)) {
            C1255a.m10453b(f6146a, "Coord string is null");
            return null;
        }
        String[] split = str.split(",");
        if (split.length == 0 || 2 != split.length) {
            C1255a.m10453b(f6146a, "Coord result is error");
            return null;
        }
        try {
            try {
                return new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
            } catch (NumberFormatException e) {
                C1255a.m10456a(f6146a, "Parser coord latitude failed", e);
                return null;
            }
        } catch (NumberFormatException e2) {
            C1255a.m10456a(f6146a, "Parser coord longitude failed", e2);
            return null;
        }
    }

    /* renamed from: a */
    private List<HistoryTraceData.HistoryTracePoint> m10526a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            C1255a.m10453b(f6146a, "Request result not contain points info");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                HistoryTraceData.HistoryTracePoint historyTracePoint = new HistoryTraceData.HistoryTracePoint();
                historyTracePoint.setPoint(new LatLng(optJSONObject.optDouble("latitude"), optJSONObject.optDouble("longitude")));
                historyTracePoint.setLocationTime(optJSONObject.optLong("loc_time"));
                historyTracePoint.setCreateTime(optJSONObject.optString("create_time"));
                arrayList.add(historyTracePoint);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m10533a(int i) {
        if (this.f6151e == null) {
            this.f6151e = new C1240b.HandlerC1242a();
        }
        Message obtainMessage = this.f6151e.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = this.f6152f;
        this.f6151e.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    private void m10532a(int i, String str, int i2, HistoryTraceData historyTraceData) {
        String str2;
        String str3;
        OnHistoryTraceListener onHistoryTraceListener = f6147b;
        if (onHistoryTraceListener == null) {
            str2 = f6146a;
            str3 = "OnHistoryTraceListener is null";
        } else if (1 == i2) {
            onHistoryTraceListener.onQueryHistroyTraceData(i, str, historyTraceData);
            return;
        } else {
            str2 = f6146a;
            str3 = "Undefined message type to notify";
        }
        C1255a.m10453b(str2, str3);
    }

    /* renamed from: a */
    private boolean m10527a(String str, HistoryTraceData historyTraceData, int i) {
        if (TextUtils.isEmpty(str) || historyTraceData == null) {
            C1255a.m10453b(f6146a, "Parameter error when parser");
            m10532a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_PARSER_FAILED, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i, null);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!m10525a(jSONObject, i)) {
                C1255a.m10453b(f6146a, "Request result contain error");
                return false;
            }
            this.f6153g = false;
            int optInt = jSONObject.optInt("total");
            historyTraceData.setTotalPoints(optInt);
            int optInt2 = jSONObject.optInt(HtmlTags.SIZE);
            int optInt3 = jSONObject.optInt("req_page_index");
            if (optInt2 * optInt3 < optInt) {
                f6148h = true;
                optInt3++;
                C1245d.m10485a(optInt3);
            }
            historyTraceData.setCurrentPageIndex(optInt3);
            historyTraceData.setDistance(jSONObject.optDouble("distance"));
            historyTraceData.setTollDiatance(jSONObject.optDouble("toll_distance"));
            historyTraceData.setCurrentOrderState(jSONObject.optInt("o_status"));
            historyTraceData.setOrderStartPosition(m10528a(jSONObject.optString("o_start_point")));
            historyTraceData.setOrderEndPosition(m10528a(jSONObject.optString("o_end_point")));
            List<HistoryTraceData.HistoryTracePoint> list = this.f6150d;
            if (list != null && !list.isEmpty()) {
                this.f6150d.clear();
            }
            List<HistoryTraceData.HistoryTracePoint> m10526a = m10526a(jSONObject.optJSONArray("points"));
            if (m10526a != null && !m10526a.isEmpty()) {
                this.f6150d.addAll(m10526a);
            }
            return true;
        } catch (JSONException e) {
            C1255a.m10456a(f6146a, "JSONException happened when parser request result", e);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m10525a(JSONObject jSONObject, int i) {
        if (jSONObject == null || !jSONObject.has("status")) {
            m10532a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_PARSER_FAILED, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i, null);
            C1255a.m10453b(f6146a, "Request result no status");
            return false;
        }
        this.f6154i = jSONObject.optInt("status");
        this.f6155j = jSONObject.optString(MessageDao.TABLENAME);
        int i2 = this.f6154i;
        if (i2 == 0) {
            this.f6153g = false;
            return true;
        } else if (1 != i2 || this.f6153g) {
            return true;
        } else {
            m10533a(i);
            this.f6153g = true;
            return false;
        }
    }

    /* renamed from: a */
    public void m10534a() {
        if (f6147b != null) {
            f6147b = null;
        }
        List<HistoryTraceData.HistoryTracePoint> list = this.f6150d;
        if (list != null) {
            list.clear();
            this.f6150d = null;
        }
        this.f6149c = null;
    }

    /* renamed from: a */
    public void m10531a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        this.f6152f = historyTraceQueryOptions;
    }

    /* renamed from: a */
    public void m10530a(OnHistoryTraceListener onHistoryTraceListener) {
        f6147b = onHistoryTraceListener;
    }

    /* renamed from: a */
    public void m10529a(C1240b.HandlerC1242a handlerC1242a) {
        this.f6151e = handlerC1242a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message2) {
        String str = f6146a;
        C1255a.m10452c(str, "Message type = " + message2.what);
        if (message2.what != 3) {
            C1255a.m10453b(f6146a, "Undefined message type");
            return;
        }
        int i = message2.arg1;
        String str2 = (String) message2.obj;
        if (str2 == null) {
            m10532a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_NULL, i, null);
            return;
        }
        boolean m10527a = m10527a(str2, this.f6149c, i);
        if (m10527a) {
            this.f6156k.put(this.f6149c.getCurrentPageIndex(), this.f6150d);
            if (f6148h) {
                m10533a(i);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f6156k.size(); i2++) {
            List<HistoryTraceData.HistoryTracePoint> list = this.f6156k.get(i2);
            if (list != null && !list.isEmpty()) {
                arrayList.addAll(this.f6150d);
            }
        }
        this.f6149c.setPointsList(arrayList);
        HistoryTraceData historyTraceData = this.f6149c;
        if (m10527a && !f6148h) {
            m10532a(this.f6154i, this.f6155j, i, historyTraceData);
            this.f6149c = null;
            this.f6149c = new HistoryTraceData();
            this.f6150d.clear();
            this.f6150d = null;
            this.f6150d = new ArrayList();
            this.f6156k.clear();
        }
        f6148h = false;
    }
}
