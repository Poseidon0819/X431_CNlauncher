package com.mopub.mraid;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import com.mopub.common.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
public interface MraidWebViewDebugListener {
    boolean onConsoleMessage(ConsoleMessage consoleMessage);

    boolean onJsAlert(String str, JsResult jsResult);
}
