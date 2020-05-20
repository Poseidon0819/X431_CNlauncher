package com.mopub.mobileads;

import android.os.AsyncTask;
import com.mopub.common.CacheService;
import com.mopub.common.MoPubHttpUrlConnection;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.ArrayDeque;
import java.util.Deque;

/* loaded from: classes.dex */
public class VideoDownloader {

    /* renamed from: a */
    private static final Deque<WeakReference<AsyncTaskC3739b>> f20494a = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.mobileads.VideoDownloader$a */
    /* loaded from: classes.dex */
    public interface InterfaceC3738a {
        void onComplete(boolean z);
    }

    private VideoDownloader() {
    }

    public static void cache(String str, InterfaceC3738a interfaceC3738a) {
        Preconditions.checkNotNull(interfaceC3738a);
        if (str == null) {
            MoPubLog.m2498d("VideoDownloader attempted to cache video with null url.");
            interfaceC3738a.onComplete(false);
            return;
        }
        try {
            AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC3739b(interfaceC3738a), str);
        } catch (Exception unused) {
            interfaceC3738a.onComplete(false);
        }
    }

    public static void cancelAllDownloaderTasks() {
        for (WeakReference<AsyncTaskC3739b> weakReference : f20494a) {
            m2319a(weakReference);
        }
        f20494a.clear();
    }

    public static void cancelLastDownloadTask() {
        if (f20494a.isEmpty()) {
            return;
        }
        m2319a(f20494a.peekLast());
        f20494a.removeLast();
    }

    /* renamed from: a */
    private static boolean m2319a(WeakReference<AsyncTaskC3739b> weakReference) {
        AsyncTaskC3739b asyncTaskC3739b;
        if (weakReference == null || (asyncTaskC3739b = weakReference.get()) == null) {
            return false;
        }
        return asyncTaskC3739b.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: com.mopub.mobileads.VideoDownloader$b */
    /* loaded from: classes.dex */
    public static class AsyncTaskC3739b extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a */
        private final InterfaceC3738a f20495a;

        /* renamed from: b */
        private final WeakReference<AsyncTaskC3739b> f20496b = new WeakReference<>(this);

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Boolean doInBackground(String[] strArr) {
            return m2318a(strArr);
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Boolean bool) {
            Boolean bool2 = bool;
            if (!isCancelled()) {
                VideoDownloader.f20494a.remove(this.f20496b);
                if (bool2 == null) {
                    this.f20495a.onComplete(false);
                    return;
                } else {
                    this.f20495a.onComplete(bool2.booleanValue());
                    return;
                }
            }
            onCancelled();
        }

        @VisibleForTesting
        AsyncTaskC3739b(InterfaceC3738a interfaceC3738a) {
            this.f20495a = interfaceC3738a;
            VideoDownloader.f20494a.add(this.f20496b);
        }

        /* renamed from: a */
        private static Boolean m2318a(String... strArr) {
            HttpURLConnection httpURLConnection;
            BufferedInputStream bufferedInputStream;
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                MoPubLog.m2498d("VideoDownloader task tried to execute null or empty url.");
                return Boolean.FALSE;
            }
            String str = strArr[0];
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    httpURLConnection = MoPubHttpUrlConnection.getHttpUrlConnection(str);
                    try {
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode >= 200 && responseCode < 300) {
                                int contentLength = httpURLConnection.getContentLength();
                                if (contentLength <= 26214400) {
                                    Boolean valueOf = Boolean.valueOf(CacheService.putToDiskCache(str, bufferedInputStream));
                                    Streams.closeStream(bufferedInputStream);
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    return valueOf;
                                }
                                MoPubLog.m2498d(String.format("VideoDownloader encountered video larger than disk cap. (%d bytes / %d maximum).", Integer.valueOf(contentLength), 26214400));
                                Boolean bool = Boolean.FALSE;
                                Streams.closeStream(bufferedInputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                return bool;
                            }
                            MoPubLog.m2498d("VideoDownloader encountered unexpected statusCode: ".concat(String.valueOf(responseCode)));
                            Boolean bool2 = Boolean.FALSE;
                            Streams.closeStream(bufferedInputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return bool2;
                        } catch (Exception e) {
                            e = e;
                            bufferedInputStream2 = bufferedInputStream;
                            MoPubLog.m2497d("VideoDownloader task threw an internal exception.", e);
                            Boolean bool3 = Boolean.FALSE;
                            Streams.closeStream(bufferedInputStream2);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return bool3;
                        } catch (Throwable th) {
                            th = th;
                            Streams.closeStream(bufferedInputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection = null;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = null;
                    bufferedInputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        }

        @Override // android.os.AsyncTask
        protected final void onCancelled() {
            MoPubLog.m2498d("VideoDownloader task was cancelled.");
            VideoDownloader.f20494a.remove(this.f20496b);
            this.f20495a.onComplete(false);
        }
    }

    @VisibleForTesting
    @Deprecated
    public static Deque<WeakReference<AsyncTaskC3739b>> getDownloaderTasks() {
        return f20494a;
    }

    @VisibleForTesting
    @Deprecated
    public static void clearDownloaderTasks() {
        f20494a.clear();
    }
}
