package com.cnlaunch.golo3.p165g;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* renamed from: com.cnlaunch.golo3.g.f */
/* loaded from: classes.dex */
public final class DateUtil {

    /* renamed from: a */
    public static String f8453a = "MM-dd";

    /* renamed from: e */
    private static String f8457e = null;

    /* renamed from: f */
    private static String f8458f = "HH:mm";

    /* renamed from: g */
    private static Calendar f8459g = Calendar.getInstance();

    /* renamed from: b */
    public static final String f8454b = m9146a() + " HH:mm:ss.S";

    /* renamed from: c */
    public static String f8455c = "yyyy/MM/dd HH:mm:ss";

    /* renamed from: h */
    private static SimpleDateFormat f8460h = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: i */
    private static SimpleDateFormat f8461i = new SimpleDateFormat("HH:mm:ss");

    /* renamed from: j */
    private static SimpleDateFormat f8462j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: k */
    private static SimpleDateFormat f8463k = new SimpleDateFormat("MM-dd HH:mm");

    /* renamed from: l */
    private static String f8464l = "h";

    /* renamed from: m */
    private static String f8465m = "min";

    /* renamed from: n */
    private static String f8466n = "m";

    /* renamed from: d */
    public static String f8456d = "GMT+8";

    /* renamed from: a */
    private static synchronized String m9146a() {
        synchronized (DateUtil.class) {
            f8457e = "yyyy-MM-dd";
        }
        return "yyyy-MM-dd";
    }

    /* renamed from: a */
    public static String m9145a(long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000) {
            return new SimpleDateFormat("HH:mm").format(new Date(j));
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            return new SimpleDateFormat("MM-dd HH:mm").format(new Date(j));
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(j));
    }
}
