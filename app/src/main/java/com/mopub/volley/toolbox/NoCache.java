package com.mopub.volley.toolbox;

import com.mopub.volley.Cache;

/* loaded from: classes2.dex */
public class NoCache implements Cache {
    @Override // com.mopub.volley.Cache
    public void clear() {
    }

    @Override // com.mopub.volley.Cache
    public Cache.Entry get(String str) {
        return null;
    }

    @Override // com.mopub.volley.Cache
    public void initialize() {
    }

    @Override // com.mopub.volley.Cache
    public void invalidate(String str, boolean z) {
    }

    @Override // com.mopub.volley.Cache
    public void put(String str, Cache.Entry entry) {
    }

    @Override // com.mopub.volley.Cache
    public void remove(String str) {
    }
}
