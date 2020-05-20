package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.UrlHandler;
import com.mopub.exceptions.IntentNotResolvableException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UrlAction.java */
/* renamed from: com.mopub.common.l */
/* loaded from: classes.dex */
public enum C3698l extends UrlAction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C3698l(String str, int i, boolean z) {
        super(str, i, z, null);
    }

    @Override // com.mopub.common.UrlAction
    public final boolean shouldTryHandlingUrl(Uri uri) {
        return "mopub".equalsIgnoreCase(uri.getScheme());
    }

    @Override // com.mopub.common.UrlAction
    protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
        String host = uri.getHost();
        UrlHandler.MoPubSchemeListener moPubSchemeListener = urlHandler.f20099a;
        if ("finishLoad".equalsIgnoreCase(host)) {
            moPubSchemeListener.onFinishLoad();
        } else if ("close".equalsIgnoreCase(host)) {
            moPubSchemeListener.onClose();
        } else if ("failLoad".equalsIgnoreCase(host)) {
            moPubSchemeListener.onFailLoad();
        } else {
            throw new IntentNotResolvableException("Could not handle MoPub Scheme url: ".concat(String.valueOf(uri)));
        }
    }
}
