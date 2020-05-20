package com.mopub.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import com.mopub.network.TrackingRequest;
import java.net.URISyntaxException;
import java.util.List;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class UrlAction {
    private final boolean mRequiresUserInteraction;
    public static final UrlAction HANDLE_MOPUB_SCHEME = new C3698l("HANDLE_MOPUB_SCHEME", 0, false);
    public static final UrlAction IGNORE_ABOUT_SCHEME = new UrlAction("IGNORE_ABOUT_SCHEME", 1, false) { // from class: com.mopub.common.n
        @Override // com.mopub.common.UrlAction
        public final boolean shouldTryHandlingUrl(Uri uri) {
            return "about".equalsIgnoreCase(uri.getScheme());
        }

        @Override // com.mopub.common.UrlAction
        protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
            MoPubLog.m2498d("Link to about page ignored.");
        }
    };
    public static final UrlAction HANDLE_PHONE_SCHEME = new UrlAction("HANDLE_PHONE_SCHEME", 2, true) { // from class: com.mopub.common.o
        @Override // com.mopub.common.UrlAction
        public final boolean shouldTryHandlingUrl(Uri uri) {
            String scheme = uri.getScheme();
            return "tel".equalsIgnoreCase(scheme) || "voicemail".equalsIgnoreCase(scheme) || "sms".equalsIgnoreCase(scheme) || "mailto".equalsIgnoreCase(scheme) || "geo".equalsIgnoreCase(scheme) || "google.streetview".equalsIgnoreCase(scheme);
        }

        @Override // com.mopub.common.UrlAction
        protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
            Intents.launchActionViewIntent(context, uri, "Could not handle intent with URI: " + uri + "\n\tIs this intent supported on your phone?");
        }
    };
    public static final UrlAction OPEN_NATIVE_BROWSER = new UrlAction("OPEN_NATIVE_BROWSER", 3, true) { // from class: com.mopub.common.p
        @Override // com.mopub.common.UrlAction
        public final boolean shouldTryHandlingUrl(Uri uri) {
            return "mopubnativebrowser".equalsIgnoreCase(uri.getScheme());
        }

        @Override // com.mopub.common.UrlAction
        protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
            String concat = "Unable to load mopub native browser url: ".concat(String.valueOf(uri));
            try {
                Intents.launchIntentForUserClick(context, Intents.intentForNativeBrowserScheme(uri), concat);
            } catch (UrlParseException e) {
                throw new IntentNotResolvableException(concat + "\n\t" + e.getMessage());
            }
        }
    };
    public static final UrlAction OPEN_APP_MARKET = new UrlAction("OPEN_APP_MARKET", 4, true) { // from class: com.mopub.common.q
        @Override // com.mopub.common.UrlAction
        public final boolean shouldTryHandlingUrl(Uri uri) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            return "play.google.com".equalsIgnoreCase(host) || "market.android.com".equalsIgnoreCase(host) || "market".equalsIgnoreCase(scheme) || uri.toString().toLowerCase().startsWith("play.google.com/") || uri.toString().toLowerCase().startsWith("market.android.com/");
        }

        @Override // com.mopub.common.UrlAction
        protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
            Intents.launchApplicationUrl(context, uri);
        }
    };
    public static final UrlAction OPEN_IN_APP_BROWSER = new UrlAction("OPEN_IN_APP_BROWSER", 5, true) { // from class: com.mopub.common.r
        @Override // com.mopub.common.UrlAction
        public final boolean shouldTryHandlingUrl(Uri uri) {
            String scheme = uri.getScheme();
            return Constants.HTTP.equalsIgnoreCase(scheme) || Constants.HTTPS.equalsIgnoreCase(scheme);
        }

        @Override // com.mopub.common.UrlAction
        protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
            if (urlHandler.f20100b) {
                return;
            }
            Intents.showMoPubBrowserForUrl(context, uri, str);
        }
    };
    public static final UrlAction HANDLE_SHARE_TWEET = new UrlAction("HANDLE_SHARE_TWEET", 6, true) { // from class: com.mopub.common.s
        @Override // com.mopub.common.UrlAction
        public final boolean shouldTryHandlingUrl(Uri uri) {
            Preconditions.checkNotNull(uri);
            return "mopubshare".equalsIgnoreCase(uri.getScheme()) && "tweet".equalsIgnoreCase(uri.getHost());
        }

        @Override // com.mopub.common.UrlAction
        protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(uri);
            String concat = "Could not handle share tweet intent with URI ".concat(String.valueOf(uri));
            try {
                Intents.launchIntentForUserClick(context, Intent.createChooser(Intents.intentForShareTweet(uri), "Share via"), concat);
            } catch (UrlParseException e) {
                throw new IntentNotResolvableException(concat + "\n\t" + e.getMessage());
            }
        }
    };
    public static final UrlAction FOLLOW_DEEP_LINK_WITH_FALLBACK = new UrlAction("FOLLOW_DEEP_LINK_WITH_FALLBACK", 7, true) { // from class: com.mopub.common.t
        @Override // com.mopub.common.UrlAction
        public final boolean shouldTryHandlingUrl(Uri uri) {
            return "deeplink+".equalsIgnoreCase(uri.getScheme());
        }

        @Override // com.mopub.common.UrlAction
        protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
            if (!"navigate".equalsIgnoreCase(uri.getHost())) {
                throw new IntentNotResolvableException("Deeplink+ URL did not have 'navigate' as the host.");
            }
            try {
                String queryParameter = uri.getQueryParameter("primaryUrl");
                List<String> queryParameters = uri.getQueryParameters("primaryTrackingUrl");
                String queryParameter2 = uri.getQueryParameter("fallbackUrl");
                List<String> queryParameters2 = uri.getQueryParameters("fallbackTrackingUrl");
                if (queryParameter == null) {
                    throw new IntentNotResolvableException("Deeplink+ did not have 'primaryUrl' query param.");
                }
                Uri parse = Uri.parse(queryParameter);
                if (shouldTryHandlingUrl(parse)) {
                    throw new IntentNotResolvableException("Deeplink+ had another Deeplink+ as the 'primaryUrl'.");
                }
                try {
                    Intents.launchApplicationUrl(context, parse);
                    TrackingRequest.makeTrackingHttpRequest(queryParameters, context, BaseEvent.Name.CLICK_REQUEST);
                } catch (IntentNotResolvableException unused) {
                    if (queryParameter2 == null) {
                        throw new IntentNotResolvableException("Unable to handle 'primaryUrl' for Deeplink+ and 'fallbackUrl' was missing.");
                    }
                    if (shouldTryHandlingUrl(Uri.parse(queryParameter2))) {
                        throw new IntentNotResolvableException("Deeplink+ URL had another Deeplink+ URL as the 'fallbackUrl'.");
                    }
                    urlHandler.handleUrl(context, queryParameter2, true, queryParameters2);
                }
            } catch (UnsupportedOperationException unused2) {
                throw new IntentNotResolvableException("Deeplink+ URL was not a hierarchical URI.");
            }
        }
    };
    public static final UrlAction FOLLOW_DEEP_LINK = new UrlAction("FOLLOW_DEEP_LINK", 8, true) { // from class: com.mopub.common.u
        @Override // com.mopub.common.UrlAction
        public final boolean shouldTryHandlingUrl(Uri uri) {
            return !TextUtils.isEmpty(uri.getScheme());
        }

        @Override // com.mopub.common.UrlAction
        protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
            if (Constants.INTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
                try {
                    Intents.launchApplicationIntent(context, Intent.parseUri(uri.toString(), 1));
                    return;
                } catch (URISyntaxException unused) {
                    throw new IntentNotResolvableException("Intent uri had invalid syntax: " + uri.toString());
                }
            }
            Intents.launchApplicationUrl(context, uri);
        }
    };
    public static final UrlAction NOOP = new UrlAction("NOOP", 9, false) { // from class: com.mopub.common.m
        @Override // com.mopub.common.UrlAction
        protected final void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException {
        }

        @Override // com.mopub.common.UrlAction
        public final boolean shouldTryHandlingUrl(Uri uri) {
            return false;
        }
    };

    /* renamed from: a */
    private static final /* synthetic */ UrlAction[] f20096a = {HANDLE_MOPUB_SCHEME, IGNORE_ABOUT_SCHEME, HANDLE_PHONE_SCHEME, OPEN_NATIVE_BROWSER, OPEN_APP_MARKET, OPEN_IN_APP_BROWSER, HANDLE_SHARE_TWEET, FOLLOW_DEEP_LINK_WITH_FALLBACK, FOLLOW_DEEP_LINK, NOOP};

    protected abstract void performAction(Context context, Uri uri, UrlHandler urlHandler, String str) throws IntentNotResolvableException;

    public abstract boolean shouldTryHandlingUrl(Uri uri);

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ UrlAction(String str, int i, boolean z, C3698l c3698l) {
        this(str, i, z);
    }

    public static UrlAction valueOf(String str) {
        return (UrlAction) Enum.valueOf(UrlAction.class, str);
    }

    public static UrlAction[] values() {
        return (UrlAction[]) f20096a.clone();
    }

    public void handleUrl(UrlHandler urlHandler, Context context, Uri uri, boolean z, String str) throws IntentNotResolvableException {
        MoPubLog.m2498d("Ad event URL: ".concat(String.valueOf(uri)));
        if (this.mRequiresUserInteraction && !z) {
            throw new IntentNotResolvableException("Attempted to handle action without user interaction.");
        }
        performAction(context, uri, urlHandler, str);
    }

    private UrlAction(String str, int i, boolean z) {
        this.mRequiresUserInteraction = z;
    }
}
