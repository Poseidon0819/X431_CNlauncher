package com.mopub.network;

import android.content.Context;
import android.os.Looper;
import android.webkit.WebView;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.DeviceUtils;
import com.mopub.volley.toolbox.BasicNetwork;
import com.mopub.volley.toolbox.DiskBasedCache;
import com.mopub.volley.toolbox.ImageLoader;
import java.io.File;

/* loaded from: classes2.dex */
public class Networking {

    /* renamed from: b */
    private static volatile MoPubRequestQueue f21215b;

    /* renamed from: c */
    private static volatile String f21216c;

    /* renamed from: d */
    private static volatile MaxWidthImageLoader f21217d;

    /* renamed from: a */
    private static final String f21214a = System.getProperty("http.agent");

    /* renamed from: e */
    private static boolean f21218e = false;

    public static String getBaseUrlScheme() {
        return Constants.HTTP;
    }

    public static MoPubRequestQueue getRequestQueue() {
        return f21215b;
    }

    public static MoPubRequestQueue getRequestQueue(Context context) {
        MoPubRequestQueue moPubRequestQueue = f21215b;
        if (moPubRequestQueue == null) {
            synchronized (Networking.class) {
                moPubRequestQueue = f21215b;
                if (moPubRequestQueue == null) {
                    BasicNetwork basicNetwork = new BasicNetwork(new RequestQueueHttpStack(getUserAgent(context.getApplicationContext()), new PlayServicesUrlRewriter(ClientMetadata.getInstance(context).getDeviceId(), context), CustomSSLSocketFactory.getDefault(10000)));
                    File file = new File(context.getCacheDir().getPath() + File.separator + "mopub-volley-cache");
                    MoPubRequestQueue moPubRequestQueue2 = new MoPubRequestQueue(new DiskBasedCache(file, (int) DeviceUtils.diskCacheSizeBytes(file, 10485760L)), basicNetwork);
                    f21215b = moPubRequestQueue2;
                    moPubRequestQueue2.start();
                    moPubRequestQueue = moPubRequestQueue2;
                }
            }
        }
        return moPubRequestQueue;
    }

    public static ImageLoader getImageLoader(Context context) {
        MaxWidthImageLoader maxWidthImageLoader = f21217d;
        if (maxWidthImageLoader == null) {
            synchronized (Networking.class) {
                maxWidthImageLoader = f21217d;
                if (maxWidthImageLoader == null) {
                    MaxWidthImageLoader maxWidthImageLoader2 = new MaxWidthImageLoader(getRequestQueue(context), context, new C3914e(new C3913d(DeviceUtils.memoryCacheSizeBytes(context))));
                    f21217d = maxWidthImageLoader2;
                    maxWidthImageLoader = maxWidthImageLoader2;
                }
            }
        }
        return maxWidthImageLoader;
    }

    public static String getUserAgent(Context context) {
        String userAgentString;
        Preconditions.checkNotNull(context);
        String str = f21216c;
        if (str == null) {
            synchronized (Networking.class) {
                str = f21216c;
                if (str == null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        try {
                            userAgentString = new WebView(context).getSettings().getUserAgentString();
                        } catch (Exception unused) {
                        }
                        f21216c = userAgentString;
                        str = userAgentString;
                    }
                    userAgentString = f21214a;
                    f21216c = userAgentString;
                    str = userAgentString;
                }
            }
        }
        return str;
    }

    public static String getCachedUserAgent() {
        String str = f21216c;
        return str == null ? f21214a : str;
    }

    @VisibleForTesting
    public static synchronized void clearForTesting() {
        synchronized (Networking.class) {
            f21215b = null;
            f21217d = null;
            f21216c = null;
        }
    }

    @VisibleForTesting
    public static synchronized void setRequestQueueForTesting(MoPubRequestQueue moPubRequestQueue) {
        synchronized (Networking.class) {
            f21215b = moPubRequestQueue;
        }
    }

    @VisibleForTesting
    public static synchronized void setImageLoaderForTesting(MaxWidthImageLoader maxWidthImageLoader) {
        synchronized (Networking.class) {
            f21217d = maxWidthImageLoader;
        }
    }

    @VisibleForTesting
    public static synchronized void setUserAgentForTesting(String str) {
        synchronized (Networking.class) {
            f21216c = str;
        }
    }

    public static void useHttps(boolean z) {
        f21218e = z;
    }

    public static boolean useHttps() {
        return f21218e;
    }

    public static String getScheme() {
        return useHttps() ? Constants.HTTPS : Constants.HTTP;
    }
}
