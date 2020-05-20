package com.baidu.platform.core.p097e;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.ShareUrlResult;
import com.baidu.platform.base.AbstractC1322b;
import com.itextpdf.text.Annotation;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.core.e.f */
/* loaded from: classes.dex */
public class C1373f extends AbstractC1322b {
    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public SearchResult mo9794a(String str) {
        SearchResult.ERRORNO errorno;
        ShareUrlResult shareUrlResult = new ShareUrlResult();
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        shareUrlResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return shareUrlResult;
                    } else if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        shareUrlResult.error = optString.equals("NETWORK_ERROR") ? SearchResult.ERRORNO.NETWORK_ERROR : optString.equals("REQUEST_ERROR") ? SearchResult.ERRORNO.REQUEST_ERROR : SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        return shareUrlResult;
                    }
                }
                if (str != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2.optString("state").equals(Constant.CASH_LOAD_SUCCESS)) {
                            shareUrlResult.setUrl(jSONObject2.optString(Annotation.URL));
                            shareUrlResult.setType(m9941a().ordinal());
                            errorno = SearchResult.ERRORNO.NO_ERROR;
                        } else {
                            errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        }
                        shareUrlResult.error = errorno;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return shareUrlResult;
                }
                shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return shareUrlResult;
            } catch (Exception unused) {
            }
        }
        shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return shareUrlResult;
    }

    @Override // com.baidu.platform.base.AbstractC1322b
    /* renamed from: a */
    public void mo9795a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetShareUrlResultListener)) {
            return;
        }
        OnGetShareUrlResultListener onGetShareUrlResultListener = (OnGetShareUrlResultListener) obj;
        switch (m9941a()) {
            case POI_DETAIL_SHARE:
                onGetShareUrlResultListener.onGetPoiDetailShareUrlResult((ShareUrlResult) searchResult);
                return;
            case LOCATION_SEARCH_SHARE:
                onGetShareUrlResultListener.onGetLocationShareUrlResult((ShareUrlResult) searchResult);
                return;
            default:
                return;
        }
    }
}
