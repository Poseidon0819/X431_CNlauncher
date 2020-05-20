package com.cnlaunch.x431pro.utils.p281c;

import com.cnlaunch.p120d.p130d.NLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import p031b.p032a.C0582a;

/* renamed from: com.cnlaunch.x431pro.utils.c.b */
/* loaded from: classes.dex */
public class DateUtils {

    /* renamed from: a */
    private static SimpleDateFormat f15749a = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: b */
    private static Calendar f15750b = Calendar.getInstance();

    /* renamed from: c */
    private static final String f15751c = DateUtils.class.getSimpleName();

    /* renamed from: a */
    public static String m5094a(String str) {
        String format = C0582a.now(TimeZone.getDefault()).format(str, Locale.getDefault());
        NLog.m9451c(f15751c, "currentDateTime: ".concat(String.valueOf(format)));
        return format;
    }

    /* renamed from: a */
    public static String m5093a(String str, int i) {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(5, 7)) - 1, Integer.parseInt(str.substring(8, 10)));
            gregorianCalendar.add(2, i);
            return f15749a.format(gregorianCalendar.getTime());
        } catch (Exception unused) {
            return m5096a();
        }
    }

    /* renamed from: a */
    private static String m5096a() {
        try {
            return f15749a.format(f15750b.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m5092a(String str, String str2) {
        return m5091a(str, "yyyy-MM-dd hh:mm:ss", str2);
    }

    /* renamed from: a */
    private static String m5091a(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        try {
            return new SimpleDateFormat(str3, Locale.getDefault()).format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m5095a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
    }
}
