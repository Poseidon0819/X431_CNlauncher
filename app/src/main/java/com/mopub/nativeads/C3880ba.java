package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;

/* compiled from: ServerPositioningSource.java */
/* renamed from: com.mopub.nativeads.ba */
/* loaded from: classes2.dex */
final class C3880ba implements Response.ErrorListener {

    /* renamed from: a */
    final /* synthetic */ ServerPositioningSource f21108a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3880ba(ServerPositioningSource serverPositioningSource) {
        this.f21108a = serverPositioningSource;
    }

    @Override // com.mopub.volley.Response.ErrorListener
    public final void onErrorResponse(VolleyError volleyError) {
        if (!(volleyError instanceof MoPubNetworkError) || ((MoPubNetworkError) volleyError).getReason().equals(MoPubNetworkError.Reason.WARMING_UP)) {
            MoPubLog.m2495e("Failed to load positioning data", volleyError);
            if (volleyError.networkResponse == null && !DeviceUtils.isNetworkAvailable(this.f21108a.f21095b)) {
                MoPubLog.m2500c(String.valueOf(MoPubErrorCode.NO_CONNECTION.toString()));
            }
        }
        ServerPositioningSource serverPositioningSource = this.f21108a;
        int pow = (int) (Math.pow(2.0d, serverPositioningSource.f21099f + 1) * 1000.0d);
        if (pow >= serverPositioningSource.f21094a) {
            MoPubLog.m2498d("Error downloading positioning information");
            if (serverPositioningSource.f21098e != null) {
                serverPositioningSource.f21098e.onFailed();
            }
            serverPositioningSource.f21098e = null;
            return;
        }
        serverPositioningSource.f21099f++;
        serverPositioningSource.f21096c.postDelayed(serverPositioningSource.f21097d, pow);
    }
}
