package com.mopub.nativeads;

import android.content.Context;
import android.view.View;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;

/* compiled from: NativeRendererHelper.java */
/* renamed from: com.mopub.nativeads.an */
/* loaded from: classes2.dex */
final class View$OnClickListenerC3870an implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Context f21075a;

    /* renamed from: b */
    final /* synthetic */ String f21076b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC3870an(Context context, String str) {
        this.f21075a = context;
        this.f21076b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        new UrlHandler.Builder().withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).build().handleUrl(this.f21075a, this.f21076b);
    }
}
