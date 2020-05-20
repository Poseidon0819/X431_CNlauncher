package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.mopub.common.MoPub;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public class LocationService {

    /* loaded from: classes.dex */
    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED;

        @Deprecated
        public final MoPub.LocationAwareness getNewLocationAwareness() {
            if (this == TRUNCATED) {
                return MoPub.LocationAwareness.TRUNCATED;
            }
            if (this == DISABLED) {
                return MoPub.LocationAwareness.DISABLED;
            }
            return MoPub.LocationAwareness.NORMAL;
        }

        @Deprecated
        public static LocationAwareness fromMoPubLocationAwareness(MoPub.LocationAwareness locationAwareness) {
            if (locationAwareness == MoPub.LocationAwareness.DISABLED) {
                return DISABLED;
            }
            if (locationAwareness == MoPub.LocationAwareness.TRUNCATED) {
                return TRUNCATED;
            }
            return NORMAL;
        }
    }

    /* loaded from: classes.dex */
    public enum ValidLocationProvider {
        NETWORK("network"),
        GPS("gps");
        
        final String name;

        ValidLocationProvider(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.name;
        }

        static /* synthetic */ boolean access$000(ValidLocationProvider validLocationProvider, Context context) {
            switch (validLocationProvider) {
                case NETWORK:
                    return DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION") || DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION");
                case GPS:
                    return DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_FINE_LOCATION");
                default:
                    return false;
            }
        }
    }

    public static Location getLastKnownLocation(Context context, int i, MoPub.LocationAwareness locationAwareness) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(locationAwareness);
        if (locationAwareness == MoPub.LocationAwareness.DISABLED) {
            return null;
        }
        Location m2561a = m2561a(context, ValidLocationProvider.GPS);
        Location m2561a2 = m2561a(context, ValidLocationProvider.NETWORK);
        if (m2561a != null && (m2561a2 == null || m2561a.getTime() > m2561a2.getTime())) {
            m2561a2 = m2561a;
        }
        if (locationAwareness == MoPub.LocationAwareness.TRUNCATED && m2561a2 != null && i >= 0) {
            m2561a2.setLatitude(BigDecimal.valueOf(m2561a2.getLatitude()).setScale(i, 5).doubleValue());
            m2561a2.setLongitude(BigDecimal.valueOf(m2561a2.getLongitude()).setScale(i, 5).doubleValue());
        }
        return m2561a2;
    }

    @VisibleForTesting
    /* renamed from: a */
    private static Location m2561a(Context context, ValidLocationProvider validLocationProvider) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(validLocationProvider);
        if (ValidLocationProvider.access$000(validLocationProvider, context)) {
            try {
                return ((LocationManager) context.getSystemService("location")).getLastKnownLocation(validLocationProvider.toString());
            } catch (IllegalArgumentException unused) {
                MoPubLog.m2498d("Failed to retrieve location: device has no " + validLocationProvider.toString() + " location provider.");
                return null;
            } catch (NullPointerException unused2) {
                MoPubLog.m2498d("Failed to retrieve location: device has no " + validLocationProvider.toString() + " location provider.");
                return null;
            } catch (SecurityException unused3) {
                MoPubLog.m2498d("Failed to retrieve location from " + validLocationProvider.toString() + " provider: access appears to be disabled.");
                return null;
            }
        }
        return null;
    }
}
