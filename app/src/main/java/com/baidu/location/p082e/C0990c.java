package com.baidu.location.p082e;

import com.itextpdf.text.Meta;

/* renamed from: com.baidu.location.e.c */
/* loaded from: classes.dex */
public final class C0990c {
    /* renamed from: a */
    public static String m11705a(int i) {
        if (C0998f.m11626j()) {
            return "WIFI";
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return Meta.UNKNOWN;
        }
    }
}
