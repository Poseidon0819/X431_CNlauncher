package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.C1115a;
import com.baidu.platform.core.p098f.C1377b;
import com.baidu.platform.core.p098f.InterfaceC1376a;

/* loaded from: classes.dex */
public class SuggestionSearch extends C1115a {

    /* renamed from: b */
    private boolean f5659b = false;

    /* renamed from: a */
    InterfaceC1376a f5658a = new C1377b();

    private SuggestionSearch() {
    }

    public static SuggestionSearch newInstance() {
        BMapManager.init();
        return new SuggestionSearch();
    }

    public void destroy() {
        if (this.f5659b) {
            return;
        }
        this.f5659b = true;
        this.f5658a.mo9798a();
        BMapManager.destroy();
    }

    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        if (this.f5658a != null) {
            if (suggestionSearchOption == null || suggestionSearchOption.mKeyword == null || suggestionSearchOption.mCity == null) {
                throw new IllegalArgumentException("option or keyword or city can not be null");
            }
            return this.f5658a.mo9796a(suggestionSearchOption);
        }
        throw new IllegalStateException("suggestionsearch is null, please call newInstance() first.");
    }

    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        InterfaceC1376a interfaceC1376a = this.f5658a;
        if (interfaceC1376a == null) {
            throw new IllegalStateException("suggestionsearch is null, please call newInstance() first.");
        }
        if (onGetSuggestionResultListener == null) {
            throw new IllegalArgumentException("listener can not be null");
        }
        interfaceC1376a.mo9797a(onGetSuggestionResultListener);
    }
}
