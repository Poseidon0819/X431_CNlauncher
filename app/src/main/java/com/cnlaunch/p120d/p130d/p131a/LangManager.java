package com.cnlaunch.p120d.p130d.p131a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NLog;
import com.itextpdf.text.html.HtmlTags;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.cnlaunch.d.d.a.c */
/* loaded from: classes.dex */
public class LangManager {

    /* renamed from: a */
    private static final String f7233a = "c";

    /* renamed from: c */
    private static List<LangInfo> m9463c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LangInfo("1", "德语", Lang.f7204b));
        arrayList.add(new LangInfo("2", "日文", Lang.f7205c, Lang.f7206d));
        arrayList.add(new LangInfo("3", "俄罗斯", Lang.f7207e));
        arrayList.add(new LangInfo("4", "法语", Lang.f7208f));
        arrayList.add(new LangInfo(DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_SUBMODEL, "西班牙", Lang.f7209g));
        arrayList.add(new LangInfo("6", "葡萄牙", Lang.f7210h, Lang.f7211i));
        arrayList.add(new LangInfo("7", "波兰", Lang.f7212j));
        arrayList.add(new LangInfo("8", "土耳其", Lang.f7213k));
        arrayList.add(new LangInfo("9", "荷兰语", Lang.f7214l));
        arrayList.add(new LangInfo(DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_MENUPATH, "希腊", Lang.f7215m, Lang.f7216n));
        arrayList.add(new LangInfo(DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_ODO, "匈牙利语", Lang.f7217o));
        arrayList.add(new LangInfo("12", "阿拉伯语", Lang.f7218p, Lang.f7219q));
        arrayList.add(new LangInfo("13", "丹麦语", Lang.f7220r, Lang.f7221s));
        arrayList.add(new LangInfo(DiagnoseConstants.FEEDBACK_FREEZEFRAME, "韩语", Lang.f7222t, Lang.f7223u));
        arrayList.add(new LangInfo(DiagnoseConstants.FEEDBACK_INPUT_NUMBER, "波斯语", Lang.f7224v, Lang.f7225w));
        arrayList.add(new LangInfo("16", "罗马尼亚语", Lang.f7226x));
        arrayList.add(new LangInfo("17", "塞尔维亚语", Lang.f7227y, Lang.f7228z));
        arrayList.add(new LangInfo(DiagnoseConstants.FEEDBACK_DATASTREAM, "芬兰语", Lang.f7192A));
        arrayList.add(new LangInfo(DiagnoseConstants.FEEDBACK_DATASTREAM_VW, "瑞典语", Lang.f7193B, Lang.f7194C));
        arrayList.add(new LangInfo("20", "捷克语", Lang.f7195D, Lang.f7196E));
        arrayList.add(new LangInfo("221", "香港", Lang.f7197F, Lang.f7198G));
        arrayList.add(new LangInfo("1001", "英语", Lang.f7203a));
        arrayList.add(new LangInfo("1002", "中文", Lang.f7199H));
        arrayList.add(new LangInfo("1003", "意大利", Lang.f7200I));
        arrayList.add(new LangInfo("231", "克罗地亚", Lang.f7201J));
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9467a(java.lang.String r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L16
            java.lang.String r3 = com.cnlaunch.p120d.p130d.p131a.LangManager.f7233a
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.String r2 = "getLangId langCode is not null."
            r0[r1] = r2
            com.cnlaunch.p120d.p130d.NLog.m9451c(r3, r0)
            java.lang.String r3 = "1001"
            return r3
        L16:
            java.util.List r0 = m9463c()
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r0.next()
            com.cnlaunch.d.d.a.b r1 = (com.cnlaunch.p120d.p130d.p131a.LangInfo) r1
            java.lang.String r2 = r1.f7230b
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 != 0) goto L3a
            java.lang.String r2 = r1.f7231c
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L1e
        L3a:
            java.lang.String r3 = r1.f7229a
            return r3
        L3d:
            java.lang.String r3 = "1001"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.p120d.p130d.p131a.LangManager.m9467a(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static String m9464b(String str) {
        if (TextUtils.isEmpty(str)) {
            NLog.m9451c(f7233a, "getLangCode langId is not null.");
            return Lang.f7203a;
        }
        for (LangInfo langInfo : m9463c()) {
            if (str.equals(langInfo.f7229a)) {
                return langInfo.f7230b;
            }
        }
        return Lang.f7203a;
    }

    /* renamed from: c */
    public static String m9461c(String str) {
        if (TextUtils.isEmpty(str)) {
            NLog.m9451c(f7233a, "getLangCode langId is not null.");
            return Lang.f7203a;
        }
        for (LangInfo langInfo : m9463c()) {
            if (str.equals(langInfo.f7229a)) {
                if (TextUtils.isEmpty(langInfo.f7231c)) {
                    return langInfo.f7230b;
                }
                return langInfo.f7231c;
            }
        }
        return Lang.f7203a;
    }

    /* renamed from: a */
    public static String m9469a() {
        return Locale.getDefault().getLanguage();
    }

    /* renamed from: b */
    public static String m9466b() {
        String country = Locale.getDefault().getCountry();
        return "MO".equalsIgnoreCase(country) ? "HK" : country;
    }

    /* renamed from: a */
    public static String m9468a(Context context) {
        return m9462c(context).getLanguage();
    }

    /* renamed from: b */
    public static String m9465b(Context context) {
        String country = m9462c(context).getCountry();
        return "MO".equalsIgnoreCase(country) ? "HK" : country;
    }

    /* renamed from: c */
    private static Locale m9462c(Context context) {
        switch (PreferencesManager.m9595a(context).m9585b("cust_lang", 0)) {
            case 0:
                return Locale.getDefault();
            case 1:
                return new Locale("ar");
            case 2:
                return new Locale("cs");
            case 3:
                return new Locale("da");
            case 4:
                return Locale.GERMAN;
            case 5:
                return new Locale("el");
            case 6:
                return Locale.ENGLISH;
            case 7:
                return new Locale("es");
            case 8:
                return new Locale("fa");
            case 9:
                return new Locale("fi");
            case 10:
                return Locale.FRENCH;
            case 11:
                return new Locale("hu");
            case 12:
                return Locale.ITALIAN;
            case 13:
                return Locale.JAPANESE;
            case 14:
                return Locale.KOREAN;
            case 15:
                return new Locale("nl");
            case 16:
                return new Locale("pl");
            case 17:
                return new Locale("pt");
            case 18:
                return new Locale("ro");
            case 19:
                return new Locale("ru");
            case 20:
                return new Locale("sr");
            case 21:
                return new Locale("sv");
            case 22:
                return new Locale(HtmlTags.f19636TR);
            case 23:
                return Locale.SIMPLIFIED_CHINESE;
            case 24:
                return Locale.TRADITIONAL_CHINESE;
            default:
                return Locale.getDefault();
        }
    }
}
