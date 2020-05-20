package com.cnlaunch.translate;

import android.text.TextUtils;
import com.itextpdf.text.html.HtmlTags;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class LanguageSupport {

    /* renamed from: AF */
    private static String f10244AF = "af";

    /* renamed from: AM */
    private static String f10245AM = "am";

    /* renamed from: AR */
    private static String f10246AR = "ar";

    /* renamed from: AZ */
    private static String f10247AZ = "az";

    /* renamed from: BE */
    private static String f10248BE = "be";

    /* renamed from: BG */
    private static String f10249BG = "bg";

    /* renamed from: BN */
    private static String f10250BN = "bn";

    /* renamed from: BS */
    private static String f10251BS = "bs";

    /* renamed from: CA */
    private static String f10252CA = "ca";
    private static String CEB = "ceb";

    /* renamed from: CO */
    private static String f10253CO = "co";

    /* renamed from: CS */
    private static String f10254CS = "cs";

    /* renamed from: CY */
    private static String f10255CY = "cy";

    /* renamed from: DA */
    private static String f10256DA = "da";

    /* renamed from: DE */
    private static String f10257DE = "de";

    /* renamed from: EL */
    private static String f10258EL = "el";

    /* renamed from: EN */
    private static String f10259EN = "en";

    /* renamed from: EO */
    private static String f10260EO = "eo";

    /* renamed from: ES */
    private static String f10261ES = "es";

    /* renamed from: ET */
    private static String f10262ET = "et";

    /* renamed from: EU */
    private static String f10263EU = "eu";

    /* renamed from: FA */
    private static String f10264FA = "fa";

    /* renamed from: FI */
    private static String f10265FI = "fi";

    /* renamed from: FR */
    private static String f10266FR = "fr";

    /* renamed from: FY */
    private static String f10267FY = "fy";

    /* renamed from: GA */
    private static String f10268GA = "ga";

    /* renamed from: GD */
    private static String f10269GD = "gd";

    /* renamed from: GL */
    private static String f10270GL = "gl";

    /* renamed from: GU */
    private static String f10271GU = "gu";

    /* renamed from: HA */
    private static String f10272HA = "ha";
    private static String HAW = "haw";

    /* renamed from: HI */
    private static String f10273HI = "hi";
    private static String HMN = "hmn";

    /* renamed from: HR */
    private static String f10274HR = "hr";

    /* renamed from: HT */
    private static String f10275HT = "ht";

    /* renamed from: HU */
    private static String f10276HU = "hu";

    /* renamed from: HY */
    private static String f10277HY = "hy";

    /* renamed from: ID */
    private static String f10278ID = "id";

    /* renamed from: IG */
    private static String f10279IG = "ig";

    /* renamed from: IS */
    private static String f10280IS = "is";

    /* renamed from: IT */
    private static String f10281IT = "it";

    /* renamed from: IW */
    private static String f10282IW = "iw";

    /* renamed from: JA */
    private static String f10283JA = "ja";

    /* renamed from: JW */
    private static String f10284JW = "jw";

    /* renamed from: KA */
    private static String f10285KA = "ka";

    /* renamed from: KK */
    private static String f10286KK = "kk";

    /* renamed from: KM */
    private static String f10287KM = "km";

    /* renamed from: KN */
    private static String f10288KN = "kn";

    /* renamed from: KO */
    private static String f10289KO = "ko";

    /* renamed from: KU */
    private static String f10290KU = "ku";

    /* renamed from: KY */
    private static String f10291KY = "ky";

    /* renamed from: LA */
    private static String f10292LA = "la";

    /* renamed from: LB */
    private static String f10293LB = "lb";

    /* renamed from: LO */
    private static String f10294LO = "lo";

    /* renamed from: LT */
    private static String f10295LT = "lt";

    /* renamed from: LV */
    private static String f10296LV = "lv";

    /* renamed from: MG */
    private static String f10297MG = "mg";

    /* renamed from: MI */
    private static String f10298MI = "mi";

    /* renamed from: MK */
    private static String f10299MK = "mk";

    /* renamed from: ML */
    private static String f10300ML = "ml";

    /* renamed from: MN */
    private static String f10301MN = "mn";

    /* renamed from: MR */
    private static String f10302MR = "mr";

    /* renamed from: MS */
    private static String f10303MS = "ms";

    /* renamed from: MT */
    private static String f10304MT = "mt";

    /* renamed from: MY */
    private static String f10305MY = "my";

    /* renamed from: NE */
    private static String f10306NE = "ne";

    /* renamed from: NL */
    private static String f10307NL = "nl";

    /* renamed from: NO */
    private static String f10308NO = "no";

    /* renamed from: NY */
    private static String f10309NY = "ny";

    /* renamed from: PA */
    private static String f10310PA = "pa";

    /* renamed from: PL */
    private static String f10311PL = "pl";

    /* renamed from: PS */
    private static String f10312PS = "ps";

    /* renamed from: PT */
    private static String f10313PT = "pt";

    /* renamed from: RO */
    private static String f10314RO = "ro";

    /* renamed from: SD */
    private static String f10315SD = "sd";

    /* renamed from: SI */
    private static String f10316SI = "si";

    /* renamed from: SK */
    private static String f10317SK = "sk";

    /* renamed from: SL */
    private static String f10318SL = "sl";

    /* renamed from: SM */
    private static String f10319SM = "sm";

    /* renamed from: SN */
    private static String f10320SN = "sn";

    /* renamed from: SO */
    private static String f10321SO = "so";

    /* renamed from: SQ */
    private static String f10322SQ = "sq";

    /* renamed from: SR */
    private static String f10323SR = "sr";

    /* renamed from: ST */
    private static String f10324ST = "st";

    /* renamed from: SU */
    private static String f10325SU = "su";

    /* renamed from: SV */
    private static String f10326SV = "sv";

    /* renamed from: SW */
    private static String f10327SW = "sw";

    /* renamed from: TA */
    private static String f10328TA = "ta";

    /* renamed from: TE */
    private static String f10329TE = "te";

    /* renamed from: TG */
    private static String f10330TG = "tg";

    /* renamed from: TH */
    private static String f10331TH = "th";

    /* renamed from: TL */
    private static String f10332TL = "tl";

    /* renamed from: TR */
    private static String f10333TR = "tr";

    /* renamed from: UK */
    private static String f10334UK = "uk";

    /* renamed from: UR */
    private static String f10335UR = "ur";

    /* renamed from: UZ */
    private static String f10336UZ = "uz";

    /* renamed from: VI */
    private static String f10337VI = "vi";

    /* renamed from: XH */
    private static String f10338XH = "xh";

    /* renamed from: YI */
    private static String f10339YI = "yi";

    /* renamed from: YO */
    private static String f10340YO = "yo";
    private static String ZH_CN = "zh-CN";
    private static String ZH_TW = "zh-TW";

    /* renamed from: ZU */
    private static String f10341ZU = "zu";

    private static Map<String, String> language() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("af", "南非荷兰语");
        linkedHashMap.put("sq", "阿尔巴尼亚语");
        linkedHashMap.put("am", "阿姆哈拉语");
        linkedHashMap.put("ar", "阿拉伯语");
        linkedHashMap.put("hy", "亚美尼亚语");
        linkedHashMap.put("az", "阿塞拜疆语");
        linkedHashMap.put("eu", "巴斯克语");
        linkedHashMap.put("be", "白俄罗斯语");
        linkedHashMap.put("bn", "孟加拉语");
        linkedHashMap.put("bs", "波斯尼亚语");
        linkedHashMap.put("bg", "保加利亚语");
        linkedHashMap.put("ca", "加泰罗尼亚语");
        linkedHashMap.put("ceb", "宿务语");
        linkedHashMap.put("zh-CN", "中文（简体）");
        linkedHashMap.put("zh-TW", " 中文（繁体）");
        linkedHashMap.put("co", "科西嘉语");
        linkedHashMap.put(HtmlTags.f19628HR, "克罗地亚语");
        linkedHashMap.put("cs", "捷克语");
        linkedHashMap.put("da", "丹麦语");
        linkedHashMap.put("nl", "荷兰语");
        linkedHashMap.put("en", "英语");
        linkedHashMap.put("eo", "世界语");
        linkedHashMap.put("et", "爱沙尼亚语");
        linkedHashMap.put("fi", "芬兰语");
        linkedHashMap.put("fr", "法语");
        linkedHashMap.put("fy", "弗里斯兰语");
        linkedHashMap.put("gl", "加利西亚语");
        linkedHashMap.put("ka", "格鲁吉亚语");
        linkedHashMap.put("de", "德语");
        linkedHashMap.put("el", "希腊语");
        linkedHashMap.put("gu", "古吉拉特语");
        linkedHashMap.put("ht", "海地克里奥尔语");
        linkedHashMap.put("ha", "豪萨语");
        linkedHashMap.put("haw", "夏威夷语");
        linkedHashMap.put("he**", "希伯来语");
        linkedHashMap.put("iw", "希伯来语");
        linkedHashMap.put("hi", "印地语");
        linkedHashMap.put("hmn", "苗语");
        linkedHashMap.put("hu", "匈牙利语");
        linkedHashMap.put("is", "冰岛语");
        linkedHashMap.put("ig", "伊博语");
        linkedHashMap.put("id", "印度尼西亚语");
        linkedHashMap.put("ga", "爱尔兰语");
        linkedHashMap.put("it", "意大利语");
        linkedHashMap.put("ja", "日语");
        linkedHashMap.put("jw", "爪哇语");
        linkedHashMap.put("kn", "卡纳达语");
        linkedHashMap.put("kk", "哈萨克语");
        linkedHashMap.put("km", "高棉语");
        linkedHashMap.put("ko", "韩语");
        linkedHashMap.put("ku", "库尔德语");
        linkedHashMap.put("ky", "吉尔吉斯语");
        linkedHashMap.put("lo", "老挝语");
        linkedHashMap.put("la", "拉丁语");
        linkedHashMap.put("lv", "拉脱维亚语");
        linkedHashMap.put("lt", "立陶宛语");
        linkedHashMap.put("lb", "卢森堡语");
        linkedHashMap.put("mk", "马其顿语");
        linkedHashMap.put("mg", "马尔加什语");
        linkedHashMap.put("ms", "马来语");
        linkedHashMap.put("ml", "马拉雅拉姆语");
        linkedHashMap.put("mt", "马耳他语");
        linkedHashMap.put("mi", "毛利语");
        linkedHashMap.put("mr", "马拉地语");
        linkedHashMap.put("mn", "蒙古语");
        linkedHashMap.put("my", "缅甸语");
        linkedHashMap.put("ne", "尼泊尔语");
        linkedHashMap.put("no", "挪威语");
        linkedHashMap.put("nb", "挪威语");
        linkedHashMap.put("ny", "尼杨扎语");
        linkedHashMap.put("ny", "齐切瓦语");
        linkedHashMap.put("ps", "普什图语");
        linkedHashMap.put("fa", "波斯语");
        linkedHashMap.put("pl", "波兰语");
        linkedHashMap.put("pt", "葡萄牙语");
        linkedHashMap.put("pt", "葡萄牙");
        linkedHashMap.put("pt", "巴西");
        linkedHashMap.put("pa", "旁遮普语");
        linkedHashMap.put("ro", "罗马尼亚语");
        linkedHashMap.put("ru", "俄语");
        linkedHashMap.put("sm", "萨摩亚语");
        linkedHashMap.put("gd", "苏格兰盖尔语");
        linkedHashMap.put("sr", "塞尔维亚语");
        linkedHashMap.put("st", "塞索托语");
        linkedHashMap.put("sn", "修纳语");
        linkedHashMap.put("sd", "信德语");
        linkedHashMap.put("si", "僧伽罗语");
        linkedHashMap.put("sk", "斯洛伐克语");
        linkedHashMap.put("sl", "斯洛文尼亚语");
        linkedHashMap.put("so", "索马里语");
        linkedHashMap.put("es", "西班牙语");
        linkedHashMap.put("su", "巽他语");
        linkedHashMap.put("sw", "斯瓦希里语");
        linkedHashMap.put("sv", "瑞典语");
        linkedHashMap.put("tl", "塔加路语");
        linkedHashMap.put("tl", "菲律宾语");
        linkedHashMap.put("tg", "塔吉克语");
        linkedHashMap.put("ta", "泰米尔语");
        linkedHashMap.put("te", "泰卢固语");
        linkedHashMap.put(HtmlTags.f19635TH, "泰语");
        linkedHashMap.put(HtmlTags.f19636TR, "土耳其语");
        linkedHashMap.put("uk", "乌克兰语");
        linkedHashMap.put("ur", "乌尔都语");
        linkedHashMap.put("uz", "乌兹别克语");
        linkedHashMap.put("vi", "越南语");
        linkedHashMap.put("cy", "威尔士语");
        linkedHashMap.put("xh", "班图语");
        linkedHashMap.put("yi", "意第绪语");
        linkedHashMap.put("yo", "约鲁巴语");
        linkedHashMap.put("zu", "祖鲁语");
        return linkedHashMap;
    }

    public static String getTargetLan() {
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase();
        System.out.println("系统语言 : ".concat(String.valueOf(lowerCase)));
        if (lowerCase.startsWith("zh")) {
            String upperCase = locale.getCountry().toUpperCase();
            if (!TextUtils.isEmpty(upperCase)) {
                if ("CN".equals(upperCase)) {
                    lowerCase = lowerCase + "-CN";
                } else {
                    lowerCase = lowerCase + "-TW";
                }
            } else {
                lowerCase = lowerCase + "-CN";
            }
        } else if (lowerCase.startsWith("he")) {
            lowerCase = "he**";
        }
        System.out.println("系统语言全称 : ".concat(String.valueOf(lowerCase)));
        String str = language().get(lowerCase);
        System.out.println("目标语言 : ".concat(String.valueOf(str)));
        return TextUtils.isEmpty(str) ? "en" : lowerCase;
    }
}
