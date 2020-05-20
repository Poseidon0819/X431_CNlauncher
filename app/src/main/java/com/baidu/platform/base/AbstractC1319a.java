package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.platform.core.p093a.C1330b;
import com.baidu.platform.core.p093a.C1331c;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.base.a */
/* loaded from: classes.dex */
public abstract class AbstractC1319a {

    /* renamed from: b */
    private AsyncHttpClient f6478b = new AsyncHttpClient();

    /* renamed from: c */
    private Handler f6479c = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    protected final Lock f6477a = new ReentrantLock();

    /* renamed from: d */
    private boolean f6480d = true;

    /* renamed from: e */
    private DistrictResult f6481e = null;

    /* renamed from: a */
    private void m9954a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        asyncHttpClient.get(new C1331c(((DistrictResult) searchResult).getCityName()).m9938a(), protoResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9953a(HttpClient.HttpStateError httpStateError, AbstractC1322b abstractC1322b, Object obj) {
        m9952a(abstractC1322b.mo9794a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}"), obj, abstractC1322b);
    }

    /* renamed from: a */
    private void m9952a(final SearchResult searchResult, final Object obj, final AbstractC1322b abstractC1322b) {
        this.f6479c.post(new Runnable() { // from class: com.baidu.platform.base.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (abstractC1322b != null) {
                    AbstractC1319a.this.f6477a.lock();
                    try {
                        abstractC1322b.mo9795a(searchResult, obj);
                    } finally {
                        AbstractC1319a.this.f6477a.unlock();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9945a(String str) {
        if (m9943b(str)) {
            return;
        }
        Log.e("BaseSearch", "Permission check unfinished, try again");
        int permissionCheck = PermissionCheck.permissionCheck();
        if (permissionCheck != 0) {
            Log.e("BaseSearch", "The authorized result is: ".concat(String.valueOf(permissionCheck)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9944a(String str, AbstractC1322b abstractC1322b, Object obj, AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback) {
        SearchResult mo9794a = abstractC1322b.mo9794a(str);
        mo9794a.status = m9942c(str);
        if (m9947a(abstractC1322b, mo9794a)) {
            m9954a(asyncHttpClient, protoResultCallback, mo9794a);
        } else if (!(abstractC1322b instanceof C1330b)) {
            m9952a(mo9794a, obj, abstractC1322b);
        } else {
            DistrictResult districtResult = this.f6481e;
            if (districtResult != null) {
                DistrictResult districtResult2 = (DistrictResult) mo9794a;
                districtResult2.setCityCode(districtResult.getCityCode());
                districtResult2.setCenterPt(this.f6481e.getCenterPt());
            }
            m9952a(mo9794a, obj, abstractC1322b);
            this.f6480d = true;
            this.f6481e = null;
            ((C1330b) abstractC1322b).m9917a(false);
        }
    }

    /* renamed from: a */
    private boolean m9947a(AbstractC1322b abstractC1322b, SearchResult searchResult) {
        if (abstractC1322b instanceof C1330b) {
            DistrictResult districtResult = (DistrictResult) searchResult;
            if (SearchResult.ERRORNO.RESULT_NOT_FOUND == districtResult.error && districtResult.getCityName() != null && this.f6480d) {
                this.f6480d = false;
                this.f6481e = districtResult;
                ((C1330b) abstractC1322b).m9917a(true);
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m9943b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError") && jSONObject.optJSONObject("SDK_InnerError").has("PermissionCheckError")) {
                Log.e("BaseSearch", "Permission check unfinished");
                return false;
            }
            return true;
        } catch (JSONException unused) {
            Log.e("BaseSearch", "Create JSONObject failed");
            return false;
        }
    }

    /* renamed from: c */
    private int m9942c(String str) {
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    return jSONObject.getInt("status");
                }
                if (jSONObject.has("status_sp")) {
                    return jSONObject.getInt("status_sp");
                }
                if (jSONObject.has("result")) {
                    return jSONObject.optJSONObject("result").optInt("error");
                }
                return 10204;
            } catch (JSONException unused) {
                Log.e("BaseSearch", "Create JSONObject failed when get response result status");
            }
        }
        return 10204;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m9946a(AbstractC1323c abstractC1323c, final Object obj, final AbstractC1322b abstractC1322b) {
        if (abstractC1322b == null) {
            Log.e(AbstractC1319a.class.getSimpleName(), "The SearchParser is null, must be applied.");
            return false;
        }
        String m9938a = abstractC1323c.m9938a();
        if (m9938a != null) {
            this.f6478b.get(m9938a, new HttpClient.ProtoResultCallback() { // from class: com.baidu.platform.base.a.1
                @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
                public void onFailed(HttpClient.HttpStateError httpStateError) {
                    AbstractC1319a.this.m9953a(httpStateError, abstractC1322b, obj);
                }

                @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
                public void onSuccess(String str) {
                    AbstractC1319a.this.m9945a(str);
                    AbstractC1319a abstractC1319a = AbstractC1319a.this;
                    abstractC1319a.m9944a(str, abstractC1322b, obj, abstractC1319a.f6478b, this);
                }
            });
            return true;
        }
        Log.e("BaseSearch", "The sendurl is: ".concat(String.valueOf(m9938a)));
        m9952a(abstractC1322b.mo9794a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, abstractC1322b);
        return false;
    }
}
