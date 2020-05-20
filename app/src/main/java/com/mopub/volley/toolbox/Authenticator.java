package com.mopub.volley.toolbox;

import com.mopub.volley.AuthFailureError;

/* loaded from: classes2.dex */
public interface Authenticator {
    String getAuthToken() throws AuthFailureError;

    void invalidateAuthToken(String str);
}
