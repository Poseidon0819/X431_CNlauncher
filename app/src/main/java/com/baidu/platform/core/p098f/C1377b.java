package com.baidu.platform.core.p098f;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.platform.base.AbstractC1319a;
import com.baidu.platform.base.SearchType;

/* renamed from: com.baidu.platform.core.f.b */
/* loaded from: classes.dex */
public class C1377b extends AbstractC1319a implements InterfaceC1376a {

    /* renamed from: b */
    private OnGetSuggestionResultListener f6525b = null;

    @Override // com.baidu.platform.core.p098f.InterfaceC1376a
    /* renamed from: a */
    public void mo9798a() {
        this.f6477a.lock();
        this.f6525b = null;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p098f.InterfaceC1376a
    /* renamed from: a */
    public void mo9797a(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        this.f6477a.lock();
        this.f6525b = onGetSuggestionResultListener;
        this.f6477a.unlock();
    }

    @Override // com.baidu.platform.core.p098f.InterfaceC1376a
    /* renamed from: a */
    public boolean mo9796a(SuggestionSearchOption suggestionSearchOption) {
        C1378c c1378c = new C1378c();
        c1378c.m9940a(SearchType.SUGGESTION_SEARCH_TYPE);
        return m9946a(new C1379d(suggestionSearchOption), this.f6525b, c1378c);
    }
}
