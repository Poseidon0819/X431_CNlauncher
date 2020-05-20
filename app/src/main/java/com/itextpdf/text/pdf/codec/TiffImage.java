package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public class TiffImage {
    public static int getNumberOfPages(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            return TIFFDirectory.getNumDirectories(randomAccessFileOrArray);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    static int getDpi(TIFFField tIFFField, int i) {
        if (tIFFField == null) {
            return 0;
        }
        long[] asRational = tIFFField.getAsRational(0);
        float f = ((float) asRational[0]) / ((float) asRational[1]);
        switch (i) {
            case 1:
            case 2:
                double d = f;
                Double.isNaN(d);
                return (int) (d + 0.5d);
            case 3:
                double d2 = f;
                Double.isNaN(d2);
                return (int) ((d2 * 2.54d) + 0.5d);
            default:
                return 0;
        }
    }

    public static Image getTiffImage(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
        return getTiffImage(randomAccessFileOrArray, i, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0294 A[Catch: Exception -> 0x02a7, TryCatch #2 {Exception -> 0x02a7, blocks: (B:4:0x0005, B:6:0x0015, B:8:0x0021, B:9:0x0024, B:11:0x0029, B:13:0x0034, B:29:0x0061, B:31:0x0077, B:33:0x007e, B:36:0x0096, B:40:0x00a1, B:42:0x00a9, B:49:0x00b8, B:51:0x00c8, B:53:0x00cb, B:55:0x00d1, B:60:0x00f2, B:62:0x00fa, B:64:0x0101, B:66:0x0109, B:72:0x011b, B:92:0x018e, B:113:0x025f, B:116:0x0271, B:118:0x0284, B:122:0x028c, B:124:0x0294, B:93:0x01ae, B:94:0x01b8, B:96:0x01bb, B:98:0x01e9, B:111:0x0236, B:100:0x01ed, B:103:0x020c, B:108:0x0228, B:107:0x0225, B:109:0x022e, B:110:0x022f, B:112:0x0246, B:74:0x0128, B:76:0x0130, B:78:0x0146, B:80:0x0150, B:84:0x0163, B:86:0x016b, B:89:0x0180, B:58:0x00e1, B:126:0x0298, B:127:0x02a6), top: B:138:0x0005, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077 A[Catch: Exception -> 0x02a7, TryCatch #2 {Exception -> 0x02a7, blocks: (B:4:0x0005, B:6:0x0015, B:8:0x0021, B:9:0x0024, B:11:0x0029, B:13:0x0034, B:29:0x0061, B:31:0x0077, B:33:0x007e, B:36:0x0096, B:40:0x00a1, B:42:0x00a9, B:49:0x00b8, B:51:0x00c8, B:53:0x00cb, B:55:0x00d1, B:60:0x00f2, B:62:0x00fa, B:64:0x0101, B:66:0x0109, B:72:0x011b, B:92:0x018e, B:113:0x025f, B:116:0x0271, B:118:0x0284, B:122:0x028c, B:124:0x0294, B:93:0x01ae, B:94:0x01b8, B:96:0x01bb, B:98:0x01e9, B:111:0x0236, B:100:0x01ed, B:103:0x020c, B:108:0x0228, B:107:0x0225, B:109:0x022e, B:110:0x022f, B:112:0x0246, B:74:0x0128, B:76:0x0130, B:78:0x0146, B:80:0x0150, B:84:0x0163, B:86:0x016b, B:89:0x0180, B:58:0x00e1, B:126:0x0298, B:127:0x02a6), top: B:138:0x0005, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a9 A[Catch: Exception -> 0x02a7, TryCatch #2 {Exception -> 0x02a7, blocks: (B:4:0x0005, B:6:0x0015, B:8:0x0021, B:9:0x0024, B:11:0x0029, B:13:0x0034, B:29:0x0061, B:31:0x0077, B:33:0x007e, B:36:0x0096, B:40:0x00a1, B:42:0x00a9, B:49:0x00b8, B:51:0x00c8, B:53:0x00cb, B:55:0x00d1, B:60:0x00f2, B:62:0x00fa, B:64:0x0101, B:66:0x0109, B:72:0x011b, B:92:0x018e, B:113:0x025f, B:116:0x0271, B:118:0x0284, B:122:0x028c, B:124:0x0294, B:93:0x01ae, B:94:0x01b8, B:96:0x01bb, B:98:0x01e9, B:111:0x0236, B:100:0x01ed, B:103:0x020c, B:108:0x0228, B:107:0x0225, B:109:0x022e, B:110:0x022f, B:112:0x0246, B:74:0x0128, B:76:0x0130, B:78:0x0146, B:80:0x0150, B:84:0x0163, B:86:0x016b, B:89:0x0180, B:58:0x00e1, B:126:0x0298, B:127:0x02a6), top: B:138:0x0005, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8 A[Catch: Exception -> 0x02a7, TryCatch #2 {Exception -> 0x02a7, blocks: (B:4:0x0005, B:6:0x0015, B:8:0x0021, B:9:0x0024, B:11:0x0029, B:13:0x0034, B:29:0x0061, B:31:0x0077, B:33:0x007e, B:36:0x0096, B:40:0x00a1, B:42:0x00a9, B:49:0x00b8, B:51:0x00c8, B:53:0x00cb, B:55:0x00d1, B:60:0x00f2, B:62:0x00fa, B:64:0x0101, B:66:0x0109, B:72:0x011b, B:92:0x018e, B:113:0x025f, B:116:0x0271, B:118:0x0284, B:122:0x028c, B:124:0x0294, B:93:0x01ae, B:94:0x01b8, B:96:0x01bb, B:98:0x01e9, B:111:0x0236, B:100:0x01ed, B:103:0x020c, B:108:0x0228, B:107:0x0225, B:109:0x022e, B:110:0x022f, B:112:0x0246, B:74:0x0128, B:76:0x0130, B:78:0x0146, B:80:0x0150, B:84:0x0163, B:86:0x016b, B:89:0x0180, B:58:0x00e1, B:126:0x0298, B:127:0x02a6), top: B:138:0x0005, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa A[Catch: Exception -> 0x02a7, TryCatch #2 {Exception -> 0x02a7, blocks: (B:4:0x0005, B:6:0x0015, B:8:0x0021, B:9:0x0024, B:11:0x0029, B:13:0x0034, B:29:0x0061, B:31:0x0077, B:33:0x007e, B:36:0x0096, B:40:0x00a1, B:42:0x00a9, B:49:0x00b8, B:51:0x00c8, B:53:0x00cb, B:55:0x00d1, B:60:0x00f2, B:62:0x00fa, B:64:0x0101, B:66:0x0109, B:72:0x011b, B:92:0x018e, B:113:0x025f, B:116:0x0271, B:118:0x0284, B:122:0x028c, B:124:0x0294, B:93:0x01ae, B:94:0x01b8, B:96:0x01bb, B:98:0x01e9, B:111:0x0236, B:100:0x01ed, B:103:0x020c, B:108:0x0228, B:107:0x0225, B:109:0x022e, B:110:0x022f, B:112:0x0246, B:74:0x0128, B:76:0x0130, B:78:0x0146, B:80:0x0150, B:84:0x0163, B:86:0x016b, B:89:0x0180, B:58:0x00e1, B:126:0x0298, B:127:0x02a6), top: B:138:0x0005, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0109 A[Catch: Exception -> 0x02a7, TryCatch #2 {Exception -> 0x02a7, blocks: (B:4:0x0005, B:6:0x0015, B:8:0x0021, B:9:0x0024, B:11:0x0029, B:13:0x0034, B:29:0x0061, B:31:0x0077, B:33:0x007e, B:36:0x0096, B:40:0x00a1, B:42:0x00a9, B:49:0x00b8, B:51:0x00c8, B:53:0x00cb, B:55:0x00d1, B:60:0x00f2, B:62:0x00fa, B:64:0x0101, B:66:0x0109, B:72:0x011b, B:92:0x018e, B:113:0x025f, B:116:0x0271, B:118:0x0284, B:122:0x028c, B:124:0x0294, B:93:0x01ae, B:94:0x01b8, B:96:0x01bb, B:98:0x01e9, B:111:0x0236, B:100:0x01ed, B:103:0x020c, B:108:0x0228, B:107:0x0225, B:109:0x022e, B:110:0x022f, B:112:0x0246, B:74:0x0128, B:76:0x0130, B:78:0x0146, B:80:0x0150, B:84:0x0163, B:86:0x016b, B:89:0x0180, B:58:0x00e1, B:126:0x0298, B:127:0x02a6), top: B:138:0x0005, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011b A[Catch: Exception -> 0x02a7, TryCatch #2 {Exception -> 0x02a7, blocks: (B:4:0x0005, B:6:0x0015, B:8:0x0021, B:9:0x0024, B:11:0x0029, B:13:0x0034, B:29:0x0061, B:31:0x0077, B:33:0x007e, B:36:0x0096, B:40:0x00a1, B:42:0x00a9, B:49:0x00b8, B:51:0x00c8, B:53:0x00cb, B:55:0x00d1, B:60:0x00f2, B:62:0x00fa, B:64:0x0101, B:66:0x0109, B:72:0x011b, B:92:0x018e, B:113:0x025f, B:116:0x0271, B:118:0x0284, B:122:0x028c, B:124:0x0294, B:93:0x01ae, B:94:0x01b8, B:96:0x01bb, B:98:0x01e9, B:111:0x0236, B:100:0x01ed, B:103:0x020c, B:108:0x0228, B:107:0x0225, B:109:0x022e, B:110:0x022f, B:112:0x0246, B:74:0x0128, B:76:0x0130, B:78:0x0146, B:80:0x0150, B:84:0x0163, B:86:0x016b, B:89:0x0180, B:58:0x00e1, B:126:0x0298, B:127:0x02a6), top: B:138:0x0005, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01bb A[Catch: Exception -> 0x02a7, TryCatch #2 {Exception -> 0x02a7, blocks: (B:4:0x0005, B:6:0x0015, B:8:0x0021, B:9:0x0024, B:11:0x0029, B:13:0x0034, B:29:0x0061, B:31:0x0077, B:33:0x007e, B:36:0x0096, B:40:0x00a1, B:42:0x00a9, B:49:0x00b8, B:51:0x00c8, B:53:0x00cb, B:55:0x00d1, B:60:0x00f2, B:62:0x00fa, B:64:0x0101, B:66:0x0109, B:72:0x011b, B:92:0x018e, B:113:0x025f, B:116:0x0271, B:118:0x0284, B:122:0x028c, B:124:0x0294, B:93:0x01ae, B:94:0x01b8, B:96:0x01bb, B:98:0x01e9, B:111:0x0236, B:100:0x01ed, B:103:0x020c, B:108:0x0228, B:107:0x0225, B:109:0x022e, B:110:0x022f, B:112:0x0246, B:74:0x0128, B:76:0x0130, B:78:0x0146, B:80:0x0150, B:84:0x0163, B:86:0x016b, B:89:0x0180, B:58:0x00e1, B:126:0x0298, B:127:0x02a6), top: B:138:0x0005, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.itextpdf.text.Image getTiffImage(com.itextpdf.text.pdf.RandomAccessFileOrArray r38, int r39, boolean r40) {
        /*
            Method dump skipped, instructions count: 732
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TiffImage.getTiffImage(com.itextpdf.text.pdf.RandomAccessFileOrArray, int, boolean):com.itextpdf.text.Image");
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x019f, code lost:
        r4 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01a3, code lost:
        if (r4 != 8) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01b1, code lost:
        throw new java.lang.RuntimeException(com.itextpdf.text.error_messages.MessageLocalization.getComposedMessage("1.bit.samples.are.not.supported.for.horizontal.differencing.predictor", r4));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c7 A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01e4 A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0233 A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0431 A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x04cc A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x04d7 A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x04de A[Catch: Exception -> 0x04f6, TRY_LEAVE, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3 A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b8 A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c8 A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0116 A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012b A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0136 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x014a A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017d A[Catch: Exception -> 0x04f6, TryCatch #0 {Exception -> 0x04f6, blocks: (B:3:0x0006, B:7:0x0018, B:8:0x001b, B:9:0x0026, B:10:0x0027, B:12:0x0033, B:16:0x003b, B:17:0x0046, B:18:0x0047, B:20:0x0053, B:33:0x0073, B:35:0x007c, B:38:0x0087, B:39:0x0094, B:40:0x0095, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:50:0x00c5, B:51:0x00c8, B:52:0x00d3, B:53:0x00d4, B:55:0x00ed, B:57:0x00fa, B:59:0x0116, B:64:0x0123, B:66:0x012b, B:73:0x013c, B:75:0x014a, B:77:0x014d, B:79:0x0155, B:86:0x017d, B:88:0x0185, B:92:0x018f, B:93:0x019c, B:102:0x01b8, B:105:0x01c7, B:111:0x01e4, B:121:0x0233, B:123:0x023b, B:125:0x0250, B:127:0x0261, B:199:0x03fb, B:203:0x0404, B:206:0x0412, B:208:0x0426, B:210:0x042b, B:212:0x0431, B:214:0x0446, B:216:0x0468, B:218:0x046b, B:226:0x047a, B:227:0x0496, B:229:0x04c7, B:221:0x0471, B:231:0x04cc, B:235:0x04d7, B:237:0x04de, B:128:0x028a, B:129:0x0298, B:132:0x029e, B:134:0x02a2, B:136:0x02b8, B:138:0x02c3, B:140:0x02ca, B:142:0x02cf, B:144:0x02d7, B:146:0x02e0, B:147:0x02e2, B:149:0x02ff, B:150:0x030f, B:151:0x031b, B:153:0x0321, B:155:0x0324, B:157:0x033d, B:160:0x0351, B:182:0x038d, B:187:0x03aa, B:185:0x0395, B:186:0x03a7, B:174:0x0373, B:172:0x0369, B:175:0x0377, B:197:0x03ca, B:198:0x03dc, B:113:0x0201, B:117:0x0216, B:98:0x01a6, B:99:0x01b1, B:82:0x0165), top: B:244:0x0006 }] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.itextpdf.text.Image] */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static com.itextpdf.text.Image getTiffImageColor(com.itextpdf.text.pdf.codec.TIFFDirectory r38, com.itextpdf.text.pdf.RandomAccessFileOrArray r39) {
        /*
            Method dump skipped, instructions count: 1310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TiffImage.getTiffImageColor(com.itextpdf.text.pdf.codec.TIFFDirectory, com.itextpdf.text.pdf.RandomAccessFileOrArray):com.itextpdf.text.Image");
    }

    static Image ProcessExtraSamples(DeflaterOutputStream deflaterOutputStream, DeflaterOutputStream deflaterOutputStream2, byte[] bArr, int i, int i2, int i3, int i4) throws IOException {
        if (i2 == 8) {
            int i5 = i3 * i4;
            byte[] bArr2 = new byte[i5];
            int i6 = i5 * i;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i6) {
                int i10 = i8;
                int i11 = 0;
                while (i11 < i - 1) {
                    bArr[i10] = bArr[i7 + i11];
                    i11++;
                    i10++;
                }
                i7 += i;
                bArr2[i9] = bArr[i7 - 1];
                i9++;
                i8 = i10;
            }
            deflaterOutputStream.write(bArr, 0, i8);
            deflaterOutputStream2.write(bArr2, 0, i9);
            return null;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("extra.samples.are.not.supported", new Object[0]));
    }

    static long[] getArrayLongShort(TIFFDirectory tIFFDirectory, int i) {
        TIFFField field = tIFFDirectory.getField(i);
        if (field == null) {
            return null;
        }
        if (field.getType() == 4) {
            return field.getAsLongs();
        }
        char[] asChars = field.getAsChars();
        long[] jArr = new long[asChars.length];
        for (int i2 = 0; i2 < asChars.length; i2++) {
            jArr[i2] = asChars[i2];
        }
        return jArr;
    }

    public static void decodePackbits(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (i < bArr2.length) {
            try {
                int i3 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0 && b <= Byte.MAX_VALUE) {
                    int i4 = i3;
                    int i5 = i;
                    int i6 = 0;
                    while (i6 < b + 1) {
                        bArr2[i5] = bArr[i4];
                        i6++;
                        i5++;
                        i4++;
                    }
                    i = i5;
                    i2 = i4;
                } else if (b >= 0 || b < -127) {
                    i2 = i3 + 1;
                } else {
                    int i7 = i3 + 1;
                    byte b2 = bArr[i3];
                    int i8 = i;
                    int i9 = 0;
                    while (i9 < (-b) + 1) {
                        int i10 = i8 + 1;
                        bArr2[i8] = b2;
                        i9++;
                        i8 = i10;
                    }
                    i2 = i7;
                    i = i8;
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    public static void inflate(byte[] bArr, byte[] bArr2) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        try {
            inflater.inflate(bArr2);
        } catch (DataFormatException e) {
            throw new ExceptionConverter(e);
        }
    }
}
