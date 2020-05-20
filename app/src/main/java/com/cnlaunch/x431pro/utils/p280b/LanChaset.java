package com.cnlaunch.x431pro.utils.p280b;

import com.cnlaunch.diagnosemodule.utils.AndroidToLan;

/* renamed from: com.cnlaunch.x431pro.utils.b.a */
/* loaded from: classes.dex */
public final class LanChaset {
    /* renamed from: a */
    public static String m5100a(String str) {
        switch (AndroidToLan.languages(str)) {
            case 0:
                return "GB2312";
            case 1:
                return "GB2312";
            case 2:
                return "EUC-JP";
            case 3:
                return "ISO-8859-1";
            case 4:
                return "BIG5";
            case 5:
                return "ISO-8859-1";
            case 6:
                return "ISO-8859-1";
            case 7:
                return "ISO-8859-5";
            case 8:
                return "ISO-8859-1";
            case 9:
                return "ISO-8859-1";
            case 10:
                return "ISO-8859-2";
            case 11:
                return "ISO-8859-9";
            case 12:
                return "ISO-8859-1";
            case 13:
                return "ISO-8859-7";
            case 14:
                return "ISO-8859-2";
            case 15:
                return "ISO-8859-6";
            case 16:
                return "ISO-8859-5";
            case 17:
                return "ISO-8859-2";
            case 18:
                return "ISO-8859-1";
            case 19:
                return "windows-1256";
            case 20:
                return "euc-kr";
            case 21:
                return "ISO-8859-1";
            case 22:
                return "ISO-8859-1";
            case 23:
                return "ISO-8859-2";
            default:
                return "GB2312";
        }
    }
}
