package com.cnlaunch.x431pro.activity.diagnose.p219b;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.golo.others.AsyLock;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.b.a */
/* loaded from: classes.dex */
public class CarIconManager implements OnDataListener {

    /* renamed from: b */
    private static final String f11521b = "a";

    /* renamed from: c */
    private static volatile CarIconManager f11522c;

    /* renamed from: a */
    CarIconUtils f11523a;

    /* renamed from: e */
    private Context f11525e;

    /* renamed from: d */
    private SparseArray<List<CarIcon>> f11524d = null;

    /* renamed from: f */
    private int f11526f = 1;

    /* renamed from: g */
    private boolean f11527g = false;

    /* renamed from: h */
    private ArrayList<Object> f11528h = new ArrayList<>();

    /* renamed from: a */
    private static boolean m7473a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: a */
    public static CarIconManager m7471a(Context context) {
        if (f11522c == null) {
            synchronized (CarIconManager.class) {
                if (f11522c == null) {
                    f11522c = new CarIconManager(context.getApplicationContext());
                }
            }
        }
        return f11522c;
    }

    private CarIconManager(Context context) {
        this.f11525e = null;
        this.f11523a = null;
        this.f11525e = context;
        this.f11523a = new CarIconUtils(context);
    }

    /* renamed from: a */
    public final void m7474a() {
        NLog.m9452b(f11521b, "changeSerial =");
        if (AsyLock.m6968a(10000)) {
            this.f11527g = true;
            return;
        }
        this.f11524d = null;
        AsyncTaskManager.m9574a(this.f11525e).m9575a(10000, false, this);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i != 10000) {
            if (i != 10004) {
                return null;
            }
            String m9591a = PreferencesManager.m9595a(this.f11525e).m9591a("carSerialNo");
            String m9591a2 = PreferencesManager.m9595a(this.f11525e).m9591a("heavydutySerialNo");
            if (TextUtils.isEmpty(m9591a) && TextUtils.isEmpty(m9591a2)) {
                this.f11524d = null;
                return this.f11524d;
            }
            SparseArray<List<CarIcon>> sparseArray = this.f11524d;
            if (sparseArray == null) {
                this.f11524d = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            this.f11524d = m7472a(m7470b(), m9591a2);
            return this.f11524d;
        }
        String m9591a3 = PreferencesManager.m9595a(this.f11525e).m9591a("carSerialNo");
        String m9591a4 = PreferencesManager.m9595a(this.f11525e).m9591a("heavydutySerialNo");
        if (TextUtils.isEmpty(m9591a3) && TextUtils.isEmpty(m9591a4)) {
            this.f11524d = null;
            return this.f11524d;
        }
        if (this.f11523a.m4978a()) {
            this.f11523a.m4967b();
        }
        if (C2744aa.m5161c(m9591a3, this.f11525e) && m9591a3.equals(m9591a4)) {
            this.f11523a.m4973a(m9591a3);
        } else {
            this.f11523a.m4972a(m9591a3, m9591a4);
        }
        SparseArray<List<CarIcon>> sparseArray2 = this.f11524d;
        if (sparseArray2 == null) {
            this.f11524d = new SparseArray<>();
        } else {
            sparseArray2.clear();
        }
        this.f11524d = m7472a(m7470b(), m9591a4);
        return this.f11524d;
    }

    /* renamed from: a */
    private SparseArray<List<CarIcon>> m7472a(int i, String str) {
        SparseArray<List<CarIcon>> sparseArray = new SparseArray<>();
        if (m7473a(i, 1)) {
            sparseArray.put(1, null);
        }
        if (m7473a(i, 64)) {
            sparseArray.put(64, null);
        }
        if (m7473a(i, 2)) {
            sparseArray.put(2, this.f11523a.m4953d(CarIconUtils.f15869i, CarIconUtils.f15868h, str));
        }
        if (m7473a(i, 4)) {
            sparseArray.put(4, this.f11523a.m4953d(CarIconUtils.f15870j, CarIconUtils.f15868h, str));
        }
        if (m7473a(i, 8)) {
            sparseArray.put(8, this.f11523a.m4953d(CarIconUtils.f15871k, CarIconUtils.f15868h, str));
        }
        if (m7473a(i, 16)) {
            sparseArray.put(16, this.f11523a.m4953d(CarIconUtils.f15872l, CarIconUtils.f15868h, str));
        }
        if (m7473a(i, 32)) {
            sparseArray.put(32, this.f11523a.m4953d(CarIconUtils.f15873m, CarIconUtils.f15868h, str));
        }
        return sparseArray;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case 10000:
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_URL_NULL /* 10002 */:
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ORDER_ID_NULL /* 10003 */:
                AsyLock.m6966c(i);
                if (this.f11527g) {
                    this.f11527g = false;
                    m7474a();
                    return;
                }
                m7469c();
                return;
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_OPTIONS_NULL /* 10001 */:
            default:
                return;
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ROLE_TYPE_ERROR /* 10004 */:
                m7469c();
                return;
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        switch (i) {
            case 10000:
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_URL_NULL /* 10002 */:
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ORDER_ID_NULL /* 10003 */:
                AsyLock.m6966c(i);
                if (this.f11527g) {
                    this.f11527g = false;
                    m7474a();
                    return;
                }
                m7469c();
                return;
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_OPTIONS_NULL /* 10001 */:
            default:
                return;
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ROLE_TYPE_ERROR /* 10004 */:
                m7469c();
                return;
        }
    }

    /* renamed from: b */
    private int m7470b() {
        int i = 0;
        PreferencesManager.m9595a(this.f11525e).m9583b("is_enable_favorites", false);
        C2744aa.m5164c(this.f11525e);
        boolean m9583b = PreferencesManager.m9595a(this.f11525e).m9583b("enable_history_diagnose", false);
        boolean m9583b2 = PreferencesManager.m9595a(this.f11525e).m9583b("enable_vinscan", false);
        if (m9583b && !DiagnoseConstants.isCloudDiagnose) {
            i = 64;
        }
        int i2 = i | 2 | 4 | 8 | 16 | 32;
        return (!m9583b2 || DiagnoseConstants.isCloudDiagnose) ? i2 : i2 | 1;
    }

    /* renamed from: c */
    private void m7469c() {
        ArrayList<Object> arrayList = this.f11528h;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<Object> it = this.f11528h.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
