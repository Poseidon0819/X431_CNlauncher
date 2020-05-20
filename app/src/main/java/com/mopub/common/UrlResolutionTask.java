package com.mopub.common;

import android.net.Uri;
import android.os.AsyncTask;
import com.mopub.common.util.AsyncTasks;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.http.HttpHeaders;

@VisibleForTesting
/* loaded from: classes.dex */
public class UrlResolutionTask extends AsyncTask<String, Void, String> {

    /* renamed from: a */
    private final InterfaceC3684a f20111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.UrlResolutionTask$a */
    /* loaded from: classes.dex */
    public interface InterfaceC3684a {
        void onFailure(String str, Throwable th);

        void onSuccess(String str);
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ String doInBackground(String[] strArr) {
        return m2538a(strArr);
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        super.onPostExecute(str2);
        if (isCancelled() || str2 == null) {
            onCancelled();
        } else {
            this.f20111a.onSuccess(str2);
        }
    }

    public static void getResolvedUrl(String str, InterfaceC3684a interfaceC3684a) {
        try {
            AsyncTasks.safeExecuteOnExecutor(new UrlResolutionTask(interfaceC3684a), str);
        } catch (Exception e) {
            interfaceC3684a.onFailure("Failed to resolve url", e);
        }
    }

    private UrlResolutionTask(InterfaceC3684a interfaceC3684a) {
        this.f20111a = interfaceC3684a;
    }

    /* renamed from: a */
    private static String m2538a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int i = 0;
        try {
            String str = null;
            for (String str2 = strArr[0]; str2 != null && i < 10; str2 = m2540a(str2)) {
                if (!UrlAction.OPEN_IN_APP_BROWSER.shouldTryHandlingUrl(Uri.parse(str2))) {
                    return str2;
                }
                i++;
                str = str2;
            }
            return str;
        } catch (IOException unused) {
            return null;
        } catch (URISyntaxException unused2) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m2540a(String str) throws IOException, URISyntaxException {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            String m2539a = m2539a(str, httpURLConnection);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return m2539a;
        } catch (Throwable th2) {
            th = th2;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private static String m2539a(String str, HttpURLConnection httpURLConnection) throws IOException, URISyntaxException {
        URI uri = new URI(str);
        int responseCode = httpURLConnection.getResponseCode();
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
        if (responseCode < 300 || responseCode >= 400) {
            return null;
        }
        try {
            return uri.resolve(headerField).toString();
        } catch (IllegalArgumentException unused) {
            throw new URISyntaxException(headerField, "Unable to parse invalid URL");
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        this.f20111a.onFailure("Task for resolving url was cancelled", null);
    }
}
