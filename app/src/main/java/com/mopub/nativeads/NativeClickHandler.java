package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;

/* loaded from: classes2.dex */
public class NativeClickHandler {

    /* renamed from: a */
    private final Context f20920a;

    /* renamed from: b */
    private final String f20921b;

    /* renamed from: c */
    private boolean f20922c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ boolean m2125a(NativeClickHandler nativeClickHandler) {
        nativeClickHandler.f20922c = false;
        return false;
    }

    public NativeClickHandler(Context context) {
        this(context, null);
    }

    public NativeClickHandler(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.f20920a = context.getApplicationContext();
        this.f20921b = str;
    }

    public void setOnClickListener(View view, ClickInterface clickInterface) {
        if (Preconditions.NoThrow.checkNotNull(view, "Cannot set click listener on a null view") && Preconditions.NoThrow.checkNotNull(clickInterface, "Cannot set click listener with a null ClickInterface")) {
            m2126a(view, new View$OnClickListenerC3866aj(this, clickInterface));
        }
    }

    /* renamed from: a */
    private void m2126a(View view, View.OnClickListener onClickListener) {
        view.setOnClickListener(onClickListener);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m2126a(viewGroup.getChildAt(i), onClickListener);
            }
        }
    }

    public void clearOnClickListener(View view) {
        if (Preconditions.NoThrow.checkNotNull(view, "Cannot clear click listener from a null view")) {
            m2126a(view, null);
        }
    }

    public void openClickDestinationUrl(String str, View view) {
        SpinningProgressView spinningProgressView = new SpinningProgressView(this.f20920a);
        if (Preconditions.NoThrow.checkNotNull(str, "Cannot open a null click destination url")) {
            Preconditions.checkNotNull(spinningProgressView);
            if (this.f20922c) {
                return;
            }
            this.f20922c = true;
            if (view != null) {
                spinningProgressView.m2066a(view);
            }
            UrlHandler.Builder builder = new UrlHandler.Builder();
            if (!TextUtils.isEmpty(this.f20921b)) {
                builder.withDspCreativeId(this.f20921b);
            }
            builder.withSupportedUrlActions(UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK).withResultActions(new C3867ak(this, view, spinningProgressView)).build().handleUrl(this.f20920a, str);
        }
    }
}
