package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class SuggestionSearchOption {
    public String mCity = null;
    public String mKeyword = null;
    public LatLng mLocation = null;
    public Boolean mCityLimit = Boolean.FALSE;

    public SuggestionSearchOption city(String str) {
        this.mCity = str;
        return this;
    }

    public SuggestionSearchOption citylimit(Boolean bool) {
        this.mCityLimit = bool;
        return this;
    }

    public SuggestionSearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public SuggestionSearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }
}
