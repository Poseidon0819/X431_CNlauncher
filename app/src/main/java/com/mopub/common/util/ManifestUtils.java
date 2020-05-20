package com.mopub.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ManifestUtils {

    /* renamed from: c */
    private static final List<Class<? extends Activity>> f20228c;

    /* renamed from: b */
    private static C3711b f20227b = new C3711b();

    /* renamed from: a */
    private static final List<Class<? extends Activity>> f20226a = new ArrayList(4);

    private ManifestUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        try {
            Class<?> cls = Class.forName("com.mopub.mobileads.MoPubActivity");
            Class<?> cls2 = Class.forName("com.mopub.mobileads.MraidActivity");
            f20226a.add(cls);
            f20226a.add(cls2);
        } catch (ClassNotFoundException unused) {
            MoPubLog.m2494i("ManifestUtils running without interstitial module");
        }
        f20226a.add(MraidVideoPlayerActivity.class);
        f20226a.add(MoPubBrowser.class);
        ArrayList arrayList = new ArrayList(1);
        f20228c = arrayList;
        arrayList.add(MoPubBrowser.class);
    }

    public static void checkWebViewActivitiesDeclared(Context context) {
        if (Preconditions.NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            m2484a(context, f20226a);
            m2481b(context, f20226a);
        }
    }

    public static void checkNativeActivitiesDeclared(Context context) {
        if (Preconditions.NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            m2484a(context, f20228c);
            m2481b(context, f20228c);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    private static void m2484a(Context context, List<Class<? extends Activity>> list) {
        List<Class<? extends Activity>> m2483a = m2483a(context, list, false);
        if (m2483a.isEmpty()) {
            return;
        }
        m2486a(context);
        m2482a(m2483a);
    }

    @VisibleForTesting
    /* renamed from: b */
    private static void m2481b(Context context, List<Class<? extends Activity>> list) {
        List<Class<? extends Activity>> m2480c = m2480c(context, m2483a(context, list, true));
        if (m2480c.isEmpty()) {
            return;
        }
        m2486a(context);
        m2479d(context, m2480c);
    }

    public static boolean isDebuggable(Context context) {
        return Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, 2);
    }

    /* renamed from: a */
    private static List<Class<? extends Activity>> m2483a(Context context, List<Class<? extends Activity>> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (Class<? extends Activity> cls : list) {
            if (Intents.deviceCanHandleIntent(context, new Intent(context, cls)) == z) {
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    @TargetApi(13)
    /* renamed from: c */
    private static List<Class<? extends Activity>> m2480c(Context context, List<Class<? extends Activity>> list) {
        ArrayList arrayList = new ArrayList();
        for (Class<? extends Activity> cls : list) {
            try {
                C3710a m2485a = m2485a(context, cls);
                if (!m2485a.hasKeyboardHidden || !m2485a.hasOrientation || !m2485a.hasScreenSize) {
                    arrayList.add(cls);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m2482a(List<Class<? extends Activity>> list) {
        StringBuilder sb = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
        for (Class<? extends Activity> cls : list) {
            sb.append("\n\t");
            sb.append(cls.getName());
        }
        sb.append("\n\nPlease update your manifest to include them.");
        MoPubLog.m2490w(sb.toString());
    }

    /* renamed from: d */
    private static void m2479d(Context context, List<Class<? extends Activity>> list) {
        StringBuilder sb = new StringBuilder("In AndroidManifest, the android:configChanges param is missing values for the following MoPub activities:\n");
        for (Class<? extends Activity> cls : list) {
            try {
                C3710a m2485a = m2485a(context, cls);
                if (!m2485a.hasKeyboardHidden) {
                    sb.append("\n\tThe android:configChanges param for activity " + cls.getName() + " must include keyboardHidden.");
                }
                if (!m2485a.hasOrientation) {
                    sb.append("\n\tThe android:configChanges param for activity " + cls.getName() + " must include orientation.");
                }
                if (!m2485a.hasScreenSize) {
                    sb.append("\n\tThe android:configChanges param for activity " + cls.getName() + " must include screenSize.");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        sb.append("\n\nPlease update your manifest to include them.");
        MoPubLog.m2490w(sb.toString());
    }

    /* renamed from: a */
    private static C3710a m2485a(Context context, Class<? extends Activity> cls) throws PackageManager.NameNotFoundException {
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new ComponentName(context, cls.getName()), 0);
        C3710a c3710a = new C3710a((byte) 0);
        c3710a.hasKeyboardHidden = f20227b.hasFlag(cls, activityInfo.configChanges, 32);
        c3710a.hasOrientation = f20227b.hasFlag(cls, activityInfo.configChanges, 128);
        c3710a.hasScreenSize = true;
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB_MR2) && context.getApplicationInfo().targetSdkVersion >= VersionCode.HONEYCOMB_MR2.getApiLevel()) {
            c3710a.hasScreenSize = f20227b.hasFlag(cls, activityInfo.configChanges, 1024);
        }
        return c3710a;
    }

    /* renamed from: a */
    private static void m2486a(Context context) {
        if (isDebuggable(context)) {
            Toast makeText = Toast.makeText(context, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.", 1);
            makeText.setGravity(7, 0, 0);
            makeText.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.util.ManifestUtils$a */
    /* loaded from: classes.dex */
    public static class C3710a {
        public boolean hasKeyboardHidden;
        public boolean hasOrientation;
        public boolean hasScreenSize;

        private C3710a() {
        }

        /* synthetic */ C3710a(byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mopub.common.util.ManifestUtils$b */
    /* loaded from: classes.dex */
    public static class C3711b {
        C3711b() {
        }

        public final boolean hasFlag(Class cls, int i, int i2) {
            return Utils.bitMaskContainsFlag(i, i2);
        }
    }
}
