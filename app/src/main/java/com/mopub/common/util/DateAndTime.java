package com.mopub.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class DateAndTime {

    /* renamed from: a */
    protected static DateAndTime f20222a = new DateAndTime();

    @Deprecated
    public static void setInstance(DateAndTime dateAndTime) {
        f20222a = dateAndTime;
    }

    public static TimeZone localTimeZone() {
        return f20222a.internalLocalTimeZone();
    }

    public static Date now() {
        return f20222a.internalNow();
    }

    public static String getTimeZoneOffsetString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("Z", Locale.US);
        simpleDateFormat.setTimeZone(localTimeZone());
        return simpleDateFormat.format(now());
    }

    public TimeZone internalLocalTimeZone() {
        return TimeZone.getDefault();
    }

    public Date internalNow() {
        return new Date();
    }
}
