package com.mopub.mobileads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.translate.TranslateManager;
import com.itextpdf.text.pdf.ColumnText;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.RewardedVideoCompletionRequest;
import com.mopub.network.Networking;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.VolleyError;

/* loaded from: classes.dex */
public class RewardedVideoCompletionRequestHandler implements RewardedVideoCompletionRequest.RewardedVideoCompletionRequestListener {

    /* renamed from: a */
    static final int[] f20397a = {UIMsg.m_AppUI.MSG_APP_GPS, 10000, TranslateManager.TIME_OUT, 40000, 60000};

    /* renamed from: b */
    private final String f20398b;

    /* renamed from: c */
    private final Handler f20399c;

    /* renamed from: d */
    private final RequestQueue f20400d;

    /* renamed from: e */
    private int f20401e;

    /* renamed from: f */
    private volatile boolean f20402f;

    private RewardedVideoCompletionRequestHandler(Context context, String str, String str2) {
        this(context, str, str2, new Handler());
    }

    private RewardedVideoCompletionRequestHandler(Context context, String str, String str2, Handler handler) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("&customer_id=");
        sb.append(str2 == null ? "" : Uri.encode(str2));
        sb.append("&nv=");
        sb.append(Uri.encode("4.11.0"));
        sb.append("&v=1");
        this.f20398b = sb.toString();
        this.f20401e = 0;
        this.f20399c = handler;
        this.f20400d = Networking.getRequestQueue(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2389a() {
        if (this.f20402f) {
            this.f20400d.cancelAll(this.f20398b);
            return;
        }
        RewardedVideoCompletionRequest rewardedVideoCompletionRequest = new RewardedVideoCompletionRequest(this.f20398b, new DefaultRetryPolicy(m2388a(this.f20401e) - 1000, 0, ColumnText.GLOBAL_SPACE_CHAR_RATIO), this);
        rewardedVideoCompletionRequest.setTag(this.f20398b);
        this.f20400d.add(rewardedVideoCompletionRequest);
        if (this.f20401e >= 17) {
            MoPubLog.m2498d("Exceeded number of retries for rewarded video completion request.");
            return;
        }
        this.f20399c.postDelayed(new RunnableC3747ag(this), m2388a(this.f20401e));
        this.f20401e++;
    }

    @Override // com.mopub.mobileads.RewardedVideoCompletionRequest.RewardedVideoCompletionRequestListener
    public void onResponse(Integer num) {
        if (num != null) {
            if (num.intValue() < 500 || num.intValue() >= 600) {
                this.f20402f = true;
            }
        }
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        if (volleyError == null || volleyError.networkResponse == null) {
            return;
        }
        if (volleyError.networkResponse.statusCode < 500 || volleyError.networkResponse.statusCode >= 600) {
            this.f20402f = true;
        }
    }

    public static void makeRewardedVideoCompletionRequest(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        new RewardedVideoCompletionRequestHandler(context, str, str2).m2389a();
    }

    /* renamed from: a */
    private static int m2388a(int i) {
        if (i >= 0) {
            int[] iArr = f20397a;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        int[] iArr2 = f20397a;
        return iArr2[iArr2.length - 1];
    }
}
