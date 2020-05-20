package message.p384g;

import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.p134f.C1473a;
import java.util.Calendar;
import java.util.Locale;
import message.p378a.MessageParameters;

/* renamed from: message.g.a */
/* loaded from: classes2.dex */
public final class DateTool {

    /* renamed from: a */
    public static String f24033a = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: b */
    public static String f24034b = "yyyy/MM/dd HH:mm:ss";

    /* renamed from: c */
    private static DateTool f24035c;

    /* renamed from: e */
    private Locale f24037e = ApplicationConfig.f7803b.getConfiguration().locale;

    /* renamed from: f */
    private String f24038f = this.f24037e.getLanguage();

    /* renamed from: d */
    private Calendar f24036d = Calendar.getInstance();

    private DateTool() {
    }

    /* renamed from: a */
    public static synchronized DateTool m241a() {
        DateTool dateTool;
        synchronized (DateTool.class) {
            if (f24035c == null) {
                f24035c = new DateTool();
            }
            dateTool = f24035c;
        }
        return dateTool;
    }

    /* renamed from: a */
    public final String m239a(long j) {
        this.f24036d.setTimeInMillis(j);
        int i = this.f24036d.get(1);
        int i2 = this.f24036d.get(2) + 1;
        int i3 = this.f24036d.get(5);
        int i4 = this.f24036d.get(11);
        int i5 = this.f24036d.get(12);
        this.f24036d.setTimeInMillis(System.currentTimeMillis() + MessageParameters.f23943h);
        int i6 = this.f24036d.get(1);
        int i7 = this.f24036d.get(2) + 1;
        int i8 = this.f24036d.get(5);
        if (i != i6) {
            if (this.f24038f.endsWith("zh")) {
                return i + ApplicationConfig.f7802a.getString(C1473a.C1477d.amount_years) + i2 + ApplicationConfig.f7802a.getString(C1473a.C1477d.amount_month) + i3 + ApplicationConfig.f7802a.getString(C1473a.C1477d.day);
            }
            return i + "/" + i2 + "/" + i3;
        } else if (i2 == i7 && i3 == i8) {
            return m240a(i4) + m238b(i4) + ":" + m238b(i5);
        } else if (i2 == i7 && i3 == i8 - 1) {
            return ApplicationConfig.f7802a.getString(C1473a.C1477d.yesterday2) + m240a(i4);
        } else if (this.f24038f.endsWith("zh")) {
            return i2 + ApplicationConfig.f7802a.getString(C1473a.C1477d.amount_month) + i3 + ApplicationConfig.f7802a.getString(C1473a.C1477d.day);
        } else {
            return i2 + "/" + i3 + "/" + i4;
        }
    }

    /* renamed from: b */
    public final String m237b(long j) {
        this.f24036d.setTimeInMillis(j);
        int i = this.f24036d.get(11);
        int i2 = this.f24036d.get(12);
        int i3 = this.f24036d.get(13);
        int i4 = this.f24036d.get(14);
        this.f24036d.setTimeInMillis(System.currentTimeMillis() + MessageParameters.f23943h);
        return m240a(i) + m238b(i) + ":" + m238b(i2) + ":" + m238b(i3) + ":" + i4;
    }

    /* renamed from: a */
    private String m240a(int i) {
        if (this.f24038f.endsWith("zh")) {
            if (i < 0 || i >= 5) {
                if (i < 5 || i >= 11) {
                    if (i < 11 || i >= 13) {
                        if (i < 13 || i >= 17) {
                            if (i >= 17 && i < 19) {
                                return ApplicationConfig.f7802a.getString(C1473a.C1477d.nightfall);
                            }
                            return ApplicationConfig.f7802a.getString(C1473a.C1477d.night);
                        }
                        return ApplicationConfig.f7802a.getString(C1473a.C1477d.afternoon);
                    }
                    return ApplicationConfig.f7802a.getString(C1473a.C1477d.noon);
                }
                return ApplicationConfig.f7802a.getString(C1473a.C1477d.morning);
            }
            return ApplicationConfig.f7802a.getString(C1473a.C1477d.before_dawn);
        }
        return "";
    }

    /* renamed from: b */
    private static String m238b(int i) {
        String valueOf = String.valueOf(i);
        while (valueOf.length() < 2) {
            valueOf = "0".concat(String.valueOf(valueOf));
        }
        return valueOf;
    }
}
