package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.platform.base.b */
/* loaded from: classes.dex */
public abstract class AbstractC1322b {

    /* renamed from: a */
    protected SearchType f6489a;

    /* renamed from: a */
    public abstract SearchResult mo9794a(String str);

    /* renamed from: a */
    public SearchType m9941a() {
        return this.f6489a;
    }

    /* renamed from: a */
    public abstract void mo9795a(SearchResult searchResult, Object obj);

    /* renamed from: a */
    public void m9940a(SearchType searchType) {
        this.f6489a = searchType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m9939a(String str, SearchResult searchResult, boolean z) {
        SearchResult.ERRORNO errorno;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    int optInt = new JSONObject(str).optInt(z ? "status" : "status_sp");
                    if (optInt != 0) {
                        if (optInt != 200 && optInt != 230) {
                            switch (optInt) {
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                case 108:
                                    errorno = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                                    break;
                                default:
                                    errorno = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                                    break;
                            }
                        } else {
                            errorno = SearchResult.ERRORNO.KEY_ERROR;
                        }
                        searchResult.error = errorno;
                        return true;
                    }
                    return false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                searchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return true;
            }
        }
        searchResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        return true;
    }
}
