package com.mopub.volley.toolbox;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mopub.common.Constants;
import com.mopub.volley.AuthFailureError;

/* loaded from: classes2.dex */
public class AndroidAuthenticator implements Authenticator {

    /* renamed from: a */
    private final Context f21299a;

    /* renamed from: b */
    private final Account f21300b;

    /* renamed from: c */
    private final String f21301c;

    /* renamed from: d */
    private final boolean f21302d;

    public AndroidAuthenticator(Context context, Account account, String str) {
        this(context, account, str, false);
    }

    public AndroidAuthenticator(Context context, Account account, String str, boolean z) {
        this.f21299a = context;
        this.f21300b = account;
        this.f21301c = str;
        this.f21302d = z;
    }

    public Account getAccount() {
        return this.f21300b;
    }

    @Override // com.mopub.volley.toolbox.Authenticator
    public String getAuthToken() throws AuthFailureError {
        AccountManagerFuture<Bundle> authToken = AccountManager.get(this.f21299a).getAuthToken(this.f21300b, this.f21301c, this.f21302d, null, null);
        try {
            Bundle result = authToken.getResult();
            String str = null;
            if (authToken.isDone() && !authToken.isCancelled()) {
                if (result.containsKey(Constants.INTENT_SCHEME)) {
                    throw new AuthFailureError((Intent) result.getParcelable(Constants.INTENT_SCHEME));
                }
                str = result.getString("authtoken");
            }
            if (str != null) {
                return str;
            }
            throw new AuthFailureError("Got null auth token for type: " + this.f21301c);
        } catch (Exception e) {
            throw new AuthFailureError("Error while retrieving auth token", e);
        }
    }

    @Override // com.mopub.volley.toolbox.Authenticator
    public void invalidateAuthToken(String str) {
        AccountManager.get(this.f21299a).invalidateAuthToken(this.f21300b.type, str);
    }
}
