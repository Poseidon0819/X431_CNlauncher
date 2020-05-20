package com.unionpay.mobile.android.nocard.utils;

import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.PdfBoolean;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.plugin.C4296c;
import com.unionpay.mobile.android.utils.C4390k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: com.unionpay.mobile.android.nocard.utils.a */
/* loaded from: classes2.dex */
public final class C4185a {
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m1487a(android.os.Bundle r1) {
        /*
            if (r1 == 0) goto L1c
            java.lang.String r0 = "paydata"
            boolean r0 = r1.containsKey(r0)
            if (r0 == 0) goto L11
            java.lang.String r0 = "paydata"
        Lc:
            java.lang.String r1 = r1.getString(r0)
            goto L1d
        L11:
            java.lang.String r0 = "tn"
            boolean r0 = r1.containsKey(r0)
            if (r0 == 0) goto L1c
            java.lang.String r0 = "tn"
            goto Lc
        L1c:
            r1 = 0
        L1d:
            if (r1 != 0) goto L21
            java.lang.String r1 = ""
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.nocard.utils.C4185a.m1487a(android.os.Bundle):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m1486a(java.lang.String r4) {
        /*
            java.lang.String r0 = "uppay"
            java.lang.String r1 = "decodePayInfo +++ \n"
            com.unionpay.mobile.android.utils.C4390k.m838a(r0, r1)
            r0 = 0
            if (r4 == 0) goto Lf
            java.lang.String r4 = java.net.URLDecoder.decode(r4)
            goto L10
        Lf:
            r4 = r0
        L10:
            java.lang.String r1 = "uppay"
            java.lang.String r2 = "url deocode result:"
            java.lang.String r3 = java.lang.String.valueOf(r4)
            java.lang.String r2 = r2.concat(r3)
            com.unionpay.mobile.android.utils.C4390k.m837b(r1, r2)
            if (r4 == 0) goto L2a
            byte[] r4 = com.unionpay.mobile.android.utils.C4380a.m893a(r4)     // Catch: java.io.IOException -> L26
            goto L2b
        L26:
            r4 = move-exception
            r4.printStackTrace()
        L2a:
            r4 = r0
        L2b:
            if (r4 == 0) goto L3a
            java.lang.String r1 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L36
            java.lang.String r2 = "UTF-8"
            r1.<init>(r4, r2)     // Catch: java.io.UnsupportedEncodingException -> L36
            r0 = r1
            goto L3a
        L36:
            r4 = move-exception
            r4.printStackTrace()
        L3a:
            java.lang.String r4 = "uppay"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "order info:"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r2 = "\n"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.unionpay.mobile.android.utils.C4390k.m838a(r4, r1)
            java.lang.String r4 = "uppay"
            java.lang.String r1 = "decodePayInfo --- \n"
            com.unionpay.mobile.android.utils.C4390k.m838a(r4, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.nocard.utils.C4185a.m1486a(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x013f, code lost:
        if (android.text.TextUtils.isEmpty(r8.f22468d) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01a6, code lost:
        if (r8.f22383I.f22850h.trim().length() > 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01a8, code lost:
        r0 = true;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m1488a(android.content.Intent r7, com.unionpay.mobile.android.model.C4173b r8) {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.nocard.utils.C4185a.m1488a(android.content.Intent, com.unionpay.mobile.android.model.b):boolean");
    }

    /* renamed from: a */
    private static boolean m1485a(String str, C4173b c4173b) {
        boolean z = false;
        if (str != null) {
            String[] split = str.split("\\?");
            if (split.length < 2) {
                C4390k.m836c("uppay", "uppay protocol params error!");
            } else {
                String str2 = split[1];
                C4390k.m838a("uppay", "parseUPPayURIParams() +++ ");
                C4390k.m838a("uppay", str2);
                String str3 = null;
                String str4 = null;
                for (String str5 : str2.split("&")) {
                    String[] split2 = str5.split("=");
                    if (split2.length >= 2) {
                        if (split2[0].equalsIgnoreCase(HtmlTags.STYLE)) {
                            str3 = split2[1];
                        } else if (split2[0].equalsIgnoreCase("paydata")) {
                            str4 = split2[1];
                        }
                    }
                }
                if (str3 != null && str3.equalsIgnoreCase("token") && str4 != null) {
                    C4390k.m838a("uppay", "paydata=".concat(String.valueOf(str4)));
                    z = m1484b(m1486a(str4), c4173b);
                }
                C4390k.m838a("uppay", "parseUPPayURIParams() ---");
            }
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m1484b(String str, C4173b c4173b) {
        C4296c c4296c;
        String str2;
        if (str == null || str.length() == 0) {
            return false;
        }
        c4173b.f22383I.f22845c = "00";
        for (String str3 : str.split(",")) {
            String[] split = str3.trim().split("=");
            if (split.length >= 2) {
                if (split[0].trim().equalsIgnoreCase("tn")) {
                    c4173b.f22452b = split[1].trim();
                } else if (split[0].trim().equalsIgnoreCase("usetestmode")) {
                    if (split[1].trim().equalsIgnoreCase(PdfBoolean.TRUE)) {
                        c4296c = c4173b.f22383I;
                        str2 = "01";
                    } else if (split[1].trim().equalsIgnoreCase("test")) {
                        c4296c = c4173b.f22383I;
                        str2 = "02";
                    } else if (split[1].trim().equalsIgnoreCase("inner")) {
                        c4296c = c4173b.f22383I;
                        str2 = "98";
                    }
                    c4296c.f22845c = str2;
                } else if (split[0].trim().equalsIgnoreCase("ResultURL")) {
                    try {
                        c4173b.f22482r = URLDecoder.decode(split[1].trim(), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return c4173b.f22452b != null && c4173b.f22452b.length() > 0;
    }
}
