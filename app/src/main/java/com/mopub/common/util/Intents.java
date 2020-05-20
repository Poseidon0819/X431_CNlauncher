package com.mopub.common.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.itextpdf.text.Annotation;
import com.mopub.common.Constants;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.logging.MoPubLog;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* loaded from: classes.dex */
public class Intents {
    @Deprecated
    public static boolean canHandleApplicationUrl(Context context, Uri uri) {
        return false;
    }

    @Deprecated
    public static boolean canHandleApplicationUrl(Context context, Uri uri, boolean z) {
        return false;
    }

    private Intents() {
    }

    public static void startActivity(Context context, Intent intent) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (!(context instanceof Activity)) {
            intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        }
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            throw new IntentNotResolvableException(e);
        }
    }

    public static Intent getStartActivityIntent(Context context, Class cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    public static boolean deviceCanHandleIntent(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static Intent intentForNativeBrowserScheme(Uri uri) throws UrlParseException {
        Preconditions.checkNotNull(uri);
        if (!UrlAction.OPEN_NATIVE_BROWSER.shouldTryHandlingUrl(uri)) {
            throw new UrlParseException("URL does not have mopubnativebrowser:// scheme.");
        }
        if (!"navigate".equals(uri.getHost())) {
            throw new UrlParseException("URL missing 'navigate' host parameter.");
        }
        try {
            String queryParameter = uri.getQueryParameter(Annotation.URL);
            if (queryParameter == null) {
                throw new UrlParseException("URL missing 'url' query parameter.");
            }
            return new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
        } catch (UnsupportedOperationException unused) {
            MoPubLog.m2490w("Could not handle url: ".concat(String.valueOf(uri)));
            throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
        }
    }

    public static Intent intentForShareTweet(Uri uri) throws UrlParseException {
        if (!UrlAction.HANDLE_SHARE_TWEET.shouldTryHandlingUrl(uri)) {
            throw new UrlParseException("URL does not have mopubshare://tweet? format.");
        }
        try {
            String queryParameter = uri.getQueryParameter("screen_name");
            String queryParameter2 = uri.getQueryParameter("tweet_id");
            if (TextUtils.isEmpty(queryParameter)) {
                throw new UrlParseException("URL missing non-empty 'screen_name' query parameter.");
            }
            if (TextUtils.isEmpty(queryParameter2)) {
                throw new UrlParseException("URL missing non-empty 'tweet_id' query parameter.");
            }
            String format = String.format("Check out @%s's Tweet: %s", queryParameter, String.format("https://twitter.com/%s/status/%s", queryParameter, queryParameter2));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", format);
            intent.putExtra("android.intent.extra.TEXT", format);
            return intent;
        } catch (UnsupportedOperationException unused) {
            MoPubLog.m2490w("Could not handle url: ".concat(String.valueOf(uri)));
            throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
        }
    }

    public static void showMoPubBrowserForUrl(Context context, Uri uri, String str) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        MoPubLog.m2498d("Final URI to show in browser: ".concat(String.valueOf(uri)));
        Bundle bundle = new Bundle();
        bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, uri.toString());
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(MoPubBrowser.DSP_CREATIVE_ID, str);
        }
        Intent startActivityIntent = getStartActivityIntent(context, MoPubBrowser.class, bundle);
        launchIntentForUserClick(context, startActivityIntent, "Could not show MoPubBrowser for url: " + uri + "\n\tPerhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.");
    }

    public static void launchIntentForUserClick(Context context, Intent intent, String str) throws IntentNotResolvableException {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        try {
            startActivity(context, intent);
        } catch (IntentNotResolvableException e) {
            throw new IntentNotResolvableException(str + "\n" + e.getMessage());
        }
    }

    public static void launchApplicationUrl(Context context, Uri uri) throws IntentNotResolvableException {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        if (deviceCanHandleIntent(context, intent)) {
            launchApplicationIntent(context, intent);
            return;
        }
        throw new IntentNotResolvableException("Could not handle application specific action: " + uri + "\n\tYou may be running in the emulator or another device which does not have the required application.");
    }

    public static void launchApplicationIntent(Context context, Intent intent) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (deviceCanHandleIntent(context, intent)) {
            String concat = "Unable to open intent: ".concat(String.valueOf(intent));
            if (!(context instanceof Activity)) {
                intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
            }
            launchIntentForUserClick(context, intent, concat);
            return;
        }
        String stringExtra = intent.getStringExtra("browser_fallback_url");
        if (TextUtils.isEmpty(stringExtra)) {
            if (!"market".equalsIgnoreCase(intent.getScheme())) {
                launchApplicationUrl(context, getPlayStoreUri(intent));
                return;
            }
            throw new IntentNotResolvableException("Device could not handle neither intent nor market url.\nIntent: " + intent.toString());
        }
        Uri parse = Uri.parse(stringExtra);
        String scheme = parse.getScheme();
        if (Constants.HTTP.equalsIgnoreCase(scheme) || Constants.HTTPS.equalsIgnoreCase(scheme)) {
            showMoPubBrowserForUrl(context, parse, null);
        } else {
            launchApplicationUrl(context, parse);
        }
    }

    public static Uri getPlayStoreUri(Intent intent) {
        Preconditions.checkNotNull(intent);
        return Uri.parse("market://details?id=" + intent.getPackage());
    }

    public static void launchActionViewIntent(Context context, Uri uri, String str) throws IntentNotResolvableException {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        if (!(context instanceof Activity)) {
            intent.addFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        }
        launchIntentForUserClick(context, intent, str);
    }
}
