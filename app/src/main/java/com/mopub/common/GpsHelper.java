package com.mopub.common;

import android.content.Context;
import android.os.AsyncTask;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class GpsHelper {
    public static final String ADVERTISING_ID_KEY = "advertisingId";
    public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
    public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";

    /* renamed from: a */
    private static String f20070a = "com.google.android.gms.common.GooglePlayServicesUtil";

    /* renamed from: b */
    private static String f20071b = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    /* loaded from: classes.dex */
    public interface GpsHelperListener {
        void onFetchAdInfoCompleted();
    }

    /* loaded from: classes.dex */
    public static class AdvertisingInfo {
        public final String advertisingId;
        public final boolean limitAdTracking;

        public AdvertisingInfo(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTracking = z;
        }
    }

    public static boolean isPlayServicesAvailable(Context context) {
        try {
            Object execute = MethodBuilderFactory.create(null, "isGooglePlayServicesAvailable").setStatic(Class.forName(f20070a)).addParam(Context.class, context).execute();
            if (execute != null) {
                if (((Integer) execute).intValue() == 0) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isLimitAdTrackingEnabled(Context context) {
        if (isPlayServicesAvailable(context)) {
            return SharedPreferencesHelper.getSharedPreferences(context).getBoolean(IS_LIMIT_AD_TRACKING_ENABLED_KEY, false);
        }
        return false;
    }

    public static void fetchAdvertisingInfoAsync(Context context, GpsHelperListener gpsHelperListener) {
        boolean isPlayServicesAvailable = isPlayServicesAvailable(context);
        if (isPlayServicesAvailable && !ClientMetadata.getInstance(context).isAdvertisingInfoSet()) {
            m2566a(context, gpsHelperListener);
            return;
        }
        if (gpsHelperListener != null) {
            gpsHelperListener.onFetchAdInfoCompleted();
        }
        if (isPlayServicesAvailable) {
            m2566a(context, (GpsHelperListener) null);
        }
    }

    public static AdvertisingInfo fetchAdvertisingInfoSync(Context context) {
        if (context == null) {
            return null;
        }
        try {
            Object execute = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(f20071b)).addParam(Context.class, context).execute();
            return new AdvertisingInfo(m2564a(execute), m2563b(execute));
        } catch (Exception unused) {
            MoPubLog.m2498d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            return null;
        }
    }

    /* renamed from: a */
    private static void m2566a(Context context, GpsHelperListener gpsHelperListener) {
        if (!Reflection.classFound(f20071b)) {
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
                return;
            }
            return;
        }
        try {
            AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC3682a(context, gpsHelperListener), new Void[0]);
        } catch (Exception e) {
            MoPubLog.m2497d("Error executing FetchAdvertisingInfoTask", e);
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.GpsHelper$a */
    /* loaded from: classes.dex */
    public static class AsyncTaskC3682a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private WeakReference<Context> f20072a;

        /* renamed from: b */
        private WeakReference<GpsHelperListener> f20073b;

        @Override // android.os.AsyncTask
        protected final /* synthetic */ Void doInBackground(Void[] voidArr) {
            return m2562a();
        }

        public AsyncTaskC3682a(Context context, GpsHelperListener gpsHelperListener) {
            this.f20072a = new WeakReference<>(context);
            this.f20073b = new WeakReference<>(gpsHelperListener);
        }

        /* renamed from: a */
        private Void m2562a() {
            Object execute;
            try {
                Context context = this.f20072a.get();
                if (context != null && (execute = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.f20071b)).addParam(Context.class, context).execute()) != null) {
                    GpsHelper.m2565a(context, execute);
                }
            } catch (Exception unused) {
                MoPubLog.m2498d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            }
            return null;
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Void r1) {
            GpsHelperListener gpsHelperListener = this.f20073b.get();
            if (gpsHelperListener != null) {
                gpsHelperListener.onFetchAdInfoCompleted();
            }
        }
    }

    /* renamed from: a */
    static void m2565a(Context context, Object obj) {
        ClientMetadata.getInstance(context).setAdvertisingInfo(m2564a(obj), m2563b(obj));
    }

    /* renamed from: a */
    private static String m2564a(Object obj) {
        try {
            return (String) MethodBuilderFactory.create(obj, "getId").execute();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m2563b(Object obj) {
        try {
            Boolean bool = (Boolean) MethodBuilderFactory.create(obj, IS_LIMIT_AD_TRACKING_ENABLED_KEY).execute();
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Deprecated
    public static void setClassNamesForTesting() {
        f20070a = "java.lang.Class";
        f20071b = "java.lang.Class";
    }
}
