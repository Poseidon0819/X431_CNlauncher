package com.cnlaunch.diagnosemodule.utils;

import android.content.Context;
import java.util.Locale;

/* loaded from: classes.dex */
public class AndroidToLan {
    public static String getIdToLanName(int i) {
        return 1 == i ? "CN" : 2 == i ? "JP" : 3 == i ? "DE" : 4 == i ? "HK" : 5 == i ? "FR" : 6 == i ? "PT" : 7 == i ? "RU" : 8 == i ? "IT" : 9 == i ? "ES" : 10 == i ? "PL" : 11 == i ? "TR" : 12 == i ? "NL" : 13 == i ? "GR" : 14 == i ? "HU" : 15 == i ? "AR" : 18 == i ? "DA" : 19 == i ? "FA" : 20 == i ? "KO" : 21 == i ? "FI" : 22 == i ? "SV" : 23 == i ? "CS" : 16 == i ? "SR" : 17 == i ? "RO" : 231 == i ? "HR" : "EN";
    }

    public static String toLan(String str) {
        return str.equalsIgnoreCase("CN") ? "CN" : (str.equalsIgnoreCase("JP") || str.equalsIgnoreCase("JA")) ? "JP" : str.equalsIgnoreCase("DE") ? "DE" : (str.equalsIgnoreCase("HK") || str.equalsIgnoreCase("TW") || str.equalsIgnoreCase("MO")) ? "HK" : str.equalsIgnoreCase("FR") ? "FR" : (str.equalsIgnoreCase("PT") || str.equalsIgnoreCase("BR")) ? "PT" : str.equalsIgnoreCase("RU") ? "RU" : str.equalsIgnoreCase("IT") ? "IT" : str.equalsIgnoreCase("ES") ? "ES" : str.equalsIgnoreCase("PL") ? "PL" : str.equalsIgnoreCase("TR") ? "TR" : str.equalsIgnoreCase("NL") ? "NL" : (str.equalsIgnoreCase("GR") || str.equalsIgnoreCase("EL")) ? "GR" : str.equalsIgnoreCase("HU") ? "HU" : (str.equalsIgnoreCase("AR") || str.equalsIgnoreCase("EG")) ? "AR" : (str.equalsIgnoreCase("DA") || str.equalsIgnoreCase("DK")) ? "DA" : (str.equalsIgnoreCase("FA") || str.equalsIgnoreCase("IR")) ? "FA" : (str.equalsIgnoreCase("KO") || str.equalsIgnoreCase("KR")) ? "KO" : str.equalsIgnoreCase("FI") ? "FI" : (str.equalsIgnoreCase("SV") || str.equalsIgnoreCase("SE")) ? "SV" : (str.equalsIgnoreCase("CS") || str.equalsIgnoreCase("CZ")) ? "CS" : (str.equalsIgnoreCase("SR") || str.equalsIgnoreCase("RS")) ? "SR" : str.equalsIgnoreCase("RO") ? "RO" : str.equalsIgnoreCase("HR") ? "HR" : "EN";
    }

    public static int getDeviceAreaID(String str) {
        if (str.equals("American")) {
            return 1;
        }
        if (str.equals("Japanese")) {
            return 2;
        }
        if (str.equals("EUROPE")) {
            return 3;
        }
        if (str.equals("Asian")) {
            return 4;
        }
        return str.equals("CN") ? 5 : -1;
    }

    public static byte[] getDeviceArea(String str) {
        return str.equals("American") ? new byte[]{1} : str.equals("Japanese") ? new byte[]{2} : str.equals("EUROPE") ? new byte[]{3} : str.equals("Asian") ? new byte[]{4} : str.equals("Chinese") ? new byte[]{5} : new byte[]{-1};
    }

    public static int getLanId(String str) {
        if (str.equalsIgnoreCase("CN")) {
            return 1002;
        }
        if (str.equalsIgnoreCase("JP") || str.equalsIgnoreCase("JA")) {
            return 2;
        }
        if (str.equalsIgnoreCase("DE")) {
            return 1;
        }
        if (str.equalsIgnoreCase("HK") || str.equalsIgnoreCase("TW") || str.equalsIgnoreCase("MO")) {
            return 221;
        }
        if (str.equalsIgnoreCase("FR")) {
            return 4;
        }
        if (str.equalsIgnoreCase("PT") || str.equalsIgnoreCase("BR")) {
            return 6;
        }
        if (str.equalsIgnoreCase("RU")) {
            return 3;
        }
        if (str.equalsIgnoreCase("IT")) {
            return 1003;
        }
        if (str.equalsIgnoreCase("ES")) {
            return 5;
        }
        if (str.equalsIgnoreCase("PL")) {
            return 7;
        }
        if (str.equalsIgnoreCase("TR")) {
            return 8;
        }
        if (str.equalsIgnoreCase("NL")) {
            return 9;
        }
        if (str.equalsIgnoreCase("GR") || str.equalsIgnoreCase("EL")) {
            return 10;
        }
        if (str.equalsIgnoreCase("HU")) {
            return 11;
        }
        if (str.equalsIgnoreCase("AR") || str.equalsIgnoreCase("EG")) {
            return 12;
        }
        if (str.equalsIgnoreCase("DA") || str.equalsIgnoreCase("DK")) {
            return 13;
        }
        if (str.equalsIgnoreCase("FA") || str.equalsIgnoreCase("IR")) {
            return 15;
        }
        if (str.equalsIgnoreCase("KO") || str.equalsIgnoreCase("KR")) {
            return 14;
        }
        if (str.equalsIgnoreCase("FI")) {
            return 18;
        }
        if (str.equalsIgnoreCase("SV") || str.equalsIgnoreCase("SE")) {
            return 19;
        }
        if (str.equalsIgnoreCase("CS") || str.equalsIgnoreCase("CZ")) {
            return 20;
        }
        if (str.equalsIgnoreCase("RO")) {
            return 16;
        }
        if (str.equalsIgnoreCase("SR") || str.equalsIgnoreCase("RS")) {
            return 17;
        }
        return str.equalsIgnoreCase("HR") ? 231 : 1001;
    }

    public static int languages(String str) {
        if (str.equalsIgnoreCase("CN")) {
            return 1;
        }
        if (str.equalsIgnoreCase("JP") || str.equalsIgnoreCase("JA")) {
            return 2;
        }
        if (str.equalsIgnoreCase("DE")) {
            return 3;
        }
        if (str.equalsIgnoreCase("HK") || str.equalsIgnoreCase("TW") || str.equalsIgnoreCase("MO")) {
            return 4;
        }
        if (str.equalsIgnoreCase("FR")) {
            return 5;
        }
        if (str.equalsIgnoreCase("PT") || str.equalsIgnoreCase("BR")) {
            return 6;
        }
        if (str.equalsIgnoreCase("RU")) {
            return 7;
        }
        if (str.equalsIgnoreCase("IT")) {
            return 8;
        }
        if (str.equalsIgnoreCase("ES")) {
            return 9;
        }
        if (str.equalsIgnoreCase("PL")) {
            return 10;
        }
        if (str.equalsIgnoreCase("TR")) {
            return 11;
        }
        if (str.equalsIgnoreCase("NL")) {
            return 12;
        }
        if (str.equalsIgnoreCase("GR") || str.equalsIgnoreCase("EL")) {
            return 13;
        }
        if (str.equalsIgnoreCase("HU")) {
            return 14;
        }
        if (str.equalsIgnoreCase("AR") || str.equalsIgnoreCase("EG") || str.equalsIgnoreCase("ARABIC")) {
            return 15;
        }
        if (str.equalsIgnoreCase("DA") || str.equalsIgnoreCase("DK")) {
            return 18;
        }
        if (str.equalsIgnoreCase("FA") || str.equalsIgnoreCase("IR")) {
            return 19;
        }
        if (str.equalsIgnoreCase("KO") || str.equalsIgnoreCase("KR") || str.equalsIgnoreCase("KOREAN")) {
            return 20;
        }
        if (str.equalsIgnoreCase("FI")) {
            return 21;
        }
        if (str.equalsIgnoreCase("SV") || str.equalsIgnoreCase("SE")) {
            return 22;
        }
        if (str.equalsIgnoreCase("CS") || str.equalsIgnoreCase("CZ")) {
            return 23;
        }
        if (str.equalsIgnoreCase("SR") || str.equalsIgnoreCase("RS")) {
            return 16;
        }
        if (str.equalsIgnoreCase("RO")) {
            return 17;
        }
        return str.equalsIgnoreCase("HR") ? 231 : 0;
    }

    public static String getLanguage(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        String country = locale.getCountry();
        return language.equalsIgnoreCase("ZH") ? (country.equalsIgnoreCase("TW") || country.equalsIgnoreCase("HK")) ? "HK" : language : language;
    }
}
