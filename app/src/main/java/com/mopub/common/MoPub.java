package com.mopub.common;

import android.app.Activity;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class MoPub {
    public static final String SDK_VERSION = "4.11.0";

    /* renamed from: a */
    private static volatile LocationAwareness f20077a = LocationAwareness.NORMAL;

    /* renamed from: b */
    private static volatile int f20078b = 6;

    /* renamed from: c */
    private static boolean f20079c = false;

    /* renamed from: d */
    private static Method f20080d;

    /* loaded from: classes.dex */
    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED
    }

    public static LocationAwareness getLocationAwareness() {
        return f20077a;
    }

    public static void setLocationAwareness(LocationAwareness locationAwareness) {
        f20077a = locationAwareness;
    }

    public static int getLocationPrecision() {
        return f20078b;
    }

    public static void setLocationPrecision(int i) {
        f20078b = Math.min(Math.max(0, i), 6);
    }

    public static void onCreate(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onCreate(activity);
        m2560a(activity);
    }

    public static void onStart(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStart(activity);
        m2560a(activity);
    }

    public static void onPause(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onPause(activity);
    }

    public static void onResume(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onResume(activity);
        m2560a(activity);
    }

    public static void onRestart(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onRestart(activity);
        m2560a(activity);
    }

    public static void onStop(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onStop(activity);
    }

    public static void onDestroy(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onDestroy(activity);
    }

    public static void onBackPressed(Activity activity) {
        MoPubLifecycleManager.getInstance(activity).onBackPressed(activity);
    }

    @Deprecated
    public static void initializeRewardedVideo(Activity activity, MediationSettings... mediationSettingsArr) {
        try {
            new Reflection.MethodBuilder(null, "initializeRewardedVideo").setStatic(Class.forName("com.mopub.mobileads.MoPubRewardedVideos")).addParam(Activity.class, activity).addParam(MediationSettings[].class, mediationSettingsArr).execute();
        } catch (ClassNotFoundException unused) {
            MoPubLog.m2490w("initializeRewardedVideo was called without the rewarded video module");
        } catch (NoSuchMethodException unused2) {
            MoPubLog.m2490w("initializeRewardedVideo was called without the rewarded video module");
        } catch (Exception e) {
            MoPubLog.m2495e("Error while initializing rewarded video", e);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private static void m2560a(Activity activity) {
        if (!f20079c) {
            f20079c = true;
            try {
                f20080d = Reflection.getDeclaredMethodWithTraversal(Class.forName("com.mopub.mobileads.MoPubRewardedVideoManager"), "updateActivity", Activity.class);
            } catch (ClassNotFoundException unused) {
            } catch (NoSuchMethodException unused2) {
            }
        }
        Method method = f20080d;
        if (method != null) {
            try {
                method.invoke(null, activity);
            } catch (IllegalAccessException e) {
                MoPubLog.m2495e("Error while attempting to access the update activity method - this should not have happened", e);
            } catch (InvocationTargetException e2) {
                MoPubLog.m2495e("Error while attempting to access the update activity method - this should not have happened", e2);
            }
        }
    }

    @Deprecated
    public static void setRewardedVideoListener(Object obj) {
        try {
            new Reflection.MethodBuilder(null, "setRewardedVideoListener").setStatic(Class.forName("com.mopub.mobileads.MoPubRewardedVideos")).addParam(Class.forName("com.mopub.mobileads.MoPubRewardedVideoListener"), obj).execute();
        } catch (ClassNotFoundException unused) {
            MoPubLog.m2490w("setRewardedVideoListener was called without the rewarded video module");
        } catch (NoSuchMethodException unused2) {
            MoPubLog.m2490w("setRewardedVideoListener was called without the rewarded video module");
        } catch (Exception e) {
            MoPubLog.m2495e("Error while setting rewarded video listener", e);
        }
    }

    @Deprecated
    public static void loadRewardedVideo(String str, MediationSettings... mediationSettingsArr) {
        loadRewardedVideo(str, null, mediationSettingsArr);
    }

    @Deprecated
    public static void loadRewardedVideo(String str, Object obj, MediationSettings... mediationSettingsArr) {
        try {
            new Reflection.MethodBuilder(null, "loadRewardedVideo").setStatic(Class.forName("com.mopub.mobileads.MoPubRewardedVideos")).addParam(String.class, str).addParam(Class.forName("com.mopub.mobileads.MoPubRewardedVideoManager$RequestParameters"), obj).addParam(MediationSettings[].class, mediationSettingsArr).execute();
        } catch (ClassNotFoundException unused) {
            MoPubLog.m2490w("loadRewardedVideo was called without the rewarded video module");
        } catch (NoSuchMethodException unused2) {
            MoPubLog.m2490w("loadRewardedVideo was called without the rewarded video module");
        } catch (Exception e) {
            MoPubLog.m2495e("Error while loading rewarded video", e);
        }
    }

    @Deprecated
    public static boolean hasRewardedVideo(String str) {
        try {
            return ((Boolean) new Reflection.MethodBuilder(null, "hasRewardedVideo").setStatic(Class.forName("com.mopub.mobileads.MoPubRewardedVideos")).addParam(String.class, str).execute()).booleanValue();
        } catch (ClassNotFoundException unused) {
            MoPubLog.m2490w("hasRewardedVideo was called without the rewarded video module");
            return false;
        } catch (NoSuchMethodException unused2) {
            MoPubLog.m2490w("hasRewardedVideo was called without the rewarded video module");
            return false;
        } catch (Exception e) {
            MoPubLog.m2495e("Error while checking rewarded video", e);
            return false;
        }
    }

    @Deprecated
    public static void showRewardedVideo(String str) {
        try {
            new Reflection.MethodBuilder(null, "showRewardedVideo").setStatic(Class.forName("com.mopub.mobileads.MoPubRewardedVideos")).addParam(String.class, str).execute();
        } catch (ClassNotFoundException unused) {
            MoPubLog.m2490w("showRewardedVideo was called without the rewarded video module");
        } catch (NoSuchMethodException unused2) {
            MoPubLog.m2490w("showRewardedVideo was called without the rewarded video module");
        } catch (Exception e) {
            MoPubLog.m2495e("Error while showing rewarded video", e);
        }
    }
}
