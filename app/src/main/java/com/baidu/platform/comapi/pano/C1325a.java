package com.baidu.platform.comapi.pano;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.mopub.common.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.comapi.pano.a */
/* loaded from: classes.dex */
public class C1325a {

    /* renamed from: a */
    AsyncHttpClient f6499a = new AsyncHttpClient();

    /* renamed from: com.baidu.platform.comapi.pano.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1327a<T> {
        /* renamed from: a */
        void mo9926a(HttpClient.HttpStateError httpStateError);

        /* renamed from: a */
        void mo9925a(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public C1328b m9928a(String str) {
        if (str == null || str.equals("")) {
            return new C1328b(PanoStateError.PANO_NOT_FOUND);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                return new C1328b(PanoStateError.PANO_NOT_FOUND);
            }
            if (optJSONObject.optInt("error") == 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray("content");
                if (optJSONArray == null) {
                    return new C1328b(PanoStateError.PANO_NOT_FOUND);
                }
                C1328b c1328b = null;
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i).optJSONObject("poiinfo");
                    if (optJSONObject2 != null) {
                        c1328b = new C1328b(PanoStateError.PANO_NO_ERROR);
                        c1328b.m9922a(optJSONObject2.optString("PID"));
                        c1328b.m9923a(optJSONObject2.optInt("hasstreet"));
                    }
                }
                return c1328b;
            }
            return new C1328b(PanoStateError.PANO_UID_ERROR);
        } catch (JSONException e) {
            e.printStackTrace();
            return new C1328b(PanoStateError.PANO_NOT_FOUND);
        }
    }

    /* renamed from: a */
    private String m9931a(Uri.Builder builder) {
        String uri = builder.build().toString();
        Uri.Builder buildUpon = Uri.parse(uri + HttpClient.getPhoneInfo()).buildUpon();
        buildUpon.appendQueryParameter("sign", AppMD5.getSignMD5String(buildUpon.build().getEncodedQuery()));
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    private void m9930a(Uri.Builder builder, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    /* renamed from: a */
    public void m9927a(String str, final InterfaceC1327a<C1328b> interfaceC1327a) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(HttpClient.isHttpsEnable ? Constants.HTTPS : Constants.HTTP);
        builder.encodedAuthority("api.map.baidu.com");
        builder.path("/sdkproxy/lbs_androidsdk/pano/v1/");
        m9930a(builder, "qt", "poi");
        m9930a(builder, "uid", str);
        m9930a(builder, "action", "0");
        String authToken = HttpClient.getAuthToken();
        if (authToken == null) {
            interfaceC1327a.mo9925a((InterfaceC1327a<C1328b>) new C1328b(PanoStateError.PANO_NO_TOKEN));
            return;
        }
        m9930a(builder, "token", authToken);
        this.f6499a.get(m9931a(builder), new HttpClient.ProtoResultCallback() { // from class: com.baidu.platform.comapi.pano.a.1
            @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
            public void onFailed(HttpClient.HttpStateError httpStateError) {
                interfaceC1327a.mo9926a(httpStateError);
            }

            @Override // com.baidu.mapapi.http.HttpClient.ProtoResultCallback
            public void onSuccess(String str2) {
                interfaceC1327a.mo9925a((InterfaceC1327a) C1325a.this.m9928a(str2));
            }
        });
    }
}
