package com.cnlaunch.x431pro.module.report;

import android.content.Context;
import com.cnlaunch.diagnosemodule.utils.DiagnoseInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.C2725h;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.module.report.b */
/* loaded from: classes.dex */
public final class UpLoadReportTask implements Runnable {

    /* renamed from: a */
    private Context f15656a;

    /* renamed from: b */
    private C2725h f15657b;

    /* renamed from: c */
    private DiagnoseRunningInfo f15658c;

    /* renamed from: d */
    private ArrayList<DiagnoseInfo.FuncItem> f15659d;

    /* renamed from: e */
    private String f15660e;

    public UpLoadReportTask(Context context, DiagnoseRunningInfo diagnoseRunningInfo, ArrayList<DiagnoseInfo.FuncItem> arrayList, C2725h c2725h) {
        this.f15656a = context;
        this.f15657b = c2725h;
        this.f15658c = diagnoseRunningInfo;
        this.f15659d = arrayList;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        this.f15660e = sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x040c A[Catch: Exception -> 0x0513, TryCatch #1 {Exception -> 0x0513, blocks: (B:2:0x0000, B:4:0x000f, B:6:0x0017, B:8:0x002d, B:11:0x0035, B:12:0x003b, B:14:0x0044, B:16:0x009c, B:18:0x00a7, B:20:0x00f1, B:21:0x00f5, B:22:0x0125, B:24:0x0132, B:28:0x015c, B:32:0x0196, B:36:0x01b6, B:38:0x01c7, B:40:0x01d3, B:39:0x01ce, B:35:0x01aa, B:31:0x018e, B:27:0x0143, B:41:0x01fc, B:43:0x0208, B:47:0x0232, B:51:0x026c, B:55:0x028c, B:57:0x029d, B:59:0x02a9, B:58:0x02a4, B:54:0x0280, B:50:0x0264, B:46:0x0219, B:60:0x02d2, B:61:0x02d6, B:63:0x02dc, B:64:0x02e4, B:66:0x02ea, B:68:0x030a, B:69:0x030e, B:70:0x0312, B:72:0x032f, B:73:0x0334, B:76:0x0340, B:77:0x034f, B:79:0x035d, B:80:0x0369, B:82:0x0382, B:84:0x038a, B:122:0x04a7, B:125:0x04bd, B:127:0x04c5, B:129:0x04cb, B:130:0x04d2, B:135:0x04f1, B:133:0x04d8, B:138:0x04f8, B:87:0x0395, B:89:0x03d4, B:94:0x03e2, B:98:0x03fe, B:100:0x040c, B:101:0x0411, B:103:0x0419, B:105:0x0420, B:106:0x0446, B:110:0x0470, B:112:0x047b, B:113:0x0480, B:115:0x0488, B:116:0x048d, B:118:0x0495, B:119:0x049a, B:121:0x04a2, B:109:0x0451, B:97:0x03f8), top: B:145:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0419 A[Catch: Exception -> 0x0513, TryCatch #1 {Exception -> 0x0513, blocks: (B:2:0x0000, B:4:0x000f, B:6:0x0017, B:8:0x002d, B:11:0x0035, B:12:0x003b, B:14:0x0044, B:16:0x009c, B:18:0x00a7, B:20:0x00f1, B:21:0x00f5, B:22:0x0125, B:24:0x0132, B:28:0x015c, B:32:0x0196, B:36:0x01b6, B:38:0x01c7, B:40:0x01d3, B:39:0x01ce, B:35:0x01aa, B:31:0x018e, B:27:0x0143, B:41:0x01fc, B:43:0x0208, B:47:0x0232, B:51:0x026c, B:55:0x028c, B:57:0x029d, B:59:0x02a9, B:58:0x02a4, B:54:0x0280, B:50:0x0264, B:46:0x0219, B:60:0x02d2, B:61:0x02d6, B:63:0x02dc, B:64:0x02e4, B:66:0x02ea, B:68:0x030a, B:69:0x030e, B:70:0x0312, B:72:0x032f, B:73:0x0334, B:76:0x0340, B:77:0x034f, B:79:0x035d, B:80:0x0369, B:82:0x0382, B:84:0x038a, B:122:0x04a7, B:125:0x04bd, B:127:0x04c5, B:129:0x04cb, B:130:0x04d2, B:135:0x04f1, B:133:0x04d8, B:138:0x04f8, B:87:0x0395, B:89:0x03d4, B:94:0x03e2, B:98:0x03fe, B:100:0x040c, B:101:0x0411, B:103:0x0419, B:105:0x0420, B:106:0x0446, B:110:0x0470, B:112:0x047b, B:113:0x0480, B:115:0x0488, B:116:0x048d, B:118:0x0495, B:119:0x049a, B:121:0x04a2, B:109:0x0451, B:97:0x03f8), top: B:145:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0420 A[Catch: Exception -> 0x0513, TryCatch #1 {Exception -> 0x0513, blocks: (B:2:0x0000, B:4:0x000f, B:6:0x0017, B:8:0x002d, B:11:0x0035, B:12:0x003b, B:14:0x0044, B:16:0x009c, B:18:0x00a7, B:20:0x00f1, B:21:0x00f5, B:22:0x0125, B:24:0x0132, B:28:0x015c, B:32:0x0196, B:36:0x01b6, B:38:0x01c7, B:40:0x01d3, B:39:0x01ce, B:35:0x01aa, B:31:0x018e, B:27:0x0143, B:41:0x01fc, B:43:0x0208, B:47:0x0232, B:51:0x026c, B:55:0x028c, B:57:0x029d, B:59:0x02a9, B:58:0x02a4, B:54:0x0280, B:50:0x0264, B:46:0x0219, B:60:0x02d2, B:61:0x02d6, B:63:0x02dc, B:64:0x02e4, B:66:0x02ea, B:68:0x030a, B:69:0x030e, B:70:0x0312, B:72:0x032f, B:73:0x0334, B:76:0x0340, B:77:0x034f, B:79:0x035d, B:80:0x0369, B:82:0x0382, B:84:0x038a, B:122:0x04a7, B:125:0x04bd, B:127:0x04c5, B:129:0x04cb, B:130:0x04d2, B:135:0x04f1, B:133:0x04d8, B:138:0x04f8, B:87:0x0395, B:89:0x03d4, B:94:0x03e2, B:98:0x03fe, B:100:0x040c, B:101:0x0411, B:103:0x0419, B:105:0x0420, B:106:0x0446, B:110:0x0470, B:112:0x047b, B:113:0x0480, B:115:0x0488, B:116:0x048d, B:118:0x0495, B:119:0x049a, B:121:0x04a2, B:109:0x0451, B:97:0x03f8), top: B:145:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0451 A[Catch: Exception -> 0x0513, TryCatch #1 {Exception -> 0x0513, blocks: (B:2:0x0000, B:4:0x000f, B:6:0x0017, B:8:0x002d, B:11:0x0035, B:12:0x003b, B:14:0x0044, B:16:0x009c, B:18:0x00a7, B:20:0x00f1, B:21:0x00f5, B:22:0x0125, B:24:0x0132, B:28:0x015c, B:32:0x0196, B:36:0x01b6, B:38:0x01c7, B:40:0x01d3, B:39:0x01ce, B:35:0x01aa, B:31:0x018e, B:27:0x0143, B:41:0x01fc, B:43:0x0208, B:47:0x0232, B:51:0x026c, B:55:0x028c, B:57:0x029d, B:59:0x02a9, B:58:0x02a4, B:54:0x0280, B:50:0x0264, B:46:0x0219, B:60:0x02d2, B:61:0x02d6, B:63:0x02dc, B:64:0x02e4, B:66:0x02ea, B:68:0x030a, B:69:0x030e, B:70:0x0312, B:72:0x032f, B:73:0x0334, B:76:0x0340, B:77:0x034f, B:79:0x035d, B:80:0x0369, B:82:0x0382, B:84:0x038a, B:122:0x04a7, B:125:0x04bd, B:127:0x04c5, B:129:0x04cb, B:130:0x04d2, B:135:0x04f1, B:133:0x04d8, B:138:0x04f8, B:87:0x0395, B:89:0x03d4, B:94:0x03e2, B:98:0x03fe, B:100:0x040c, B:101:0x0411, B:103:0x0419, B:105:0x0420, B:106:0x0446, B:110:0x0470, B:112:0x047b, B:113:0x0480, B:115:0x0488, B:116:0x048d, B:118:0x0495, B:119:0x049a, B:121:0x04a2, B:109:0x0451, B:97:0x03f8), top: B:145:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x047b A[Catch: Exception -> 0x0513, TryCatch #1 {Exception -> 0x0513, blocks: (B:2:0x0000, B:4:0x000f, B:6:0x0017, B:8:0x002d, B:11:0x0035, B:12:0x003b, B:14:0x0044, B:16:0x009c, B:18:0x00a7, B:20:0x00f1, B:21:0x00f5, B:22:0x0125, B:24:0x0132, B:28:0x015c, B:32:0x0196, B:36:0x01b6, B:38:0x01c7, B:40:0x01d3, B:39:0x01ce, B:35:0x01aa, B:31:0x018e, B:27:0x0143, B:41:0x01fc, B:43:0x0208, B:47:0x0232, B:51:0x026c, B:55:0x028c, B:57:0x029d, B:59:0x02a9, B:58:0x02a4, B:54:0x0280, B:50:0x0264, B:46:0x0219, B:60:0x02d2, B:61:0x02d6, B:63:0x02dc, B:64:0x02e4, B:66:0x02ea, B:68:0x030a, B:69:0x030e, B:70:0x0312, B:72:0x032f, B:73:0x0334, B:76:0x0340, B:77:0x034f, B:79:0x035d, B:80:0x0369, B:82:0x0382, B:84:0x038a, B:122:0x04a7, B:125:0x04bd, B:127:0x04c5, B:129:0x04cb, B:130:0x04d2, B:135:0x04f1, B:133:0x04d8, B:138:0x04f8, B:87:0x0395, B:89:0x03d4, B:94:0x03e2, B:98:0x03fe, B:100:0x040c, B:101:0x0411, B:103:0x0419, B:105:0x0420, B:106:0x0446, B:110:0x0470, B:112:0x047b, B:113:0x0480, B:115:0x0488, B:116:0x048d, B:118:0x0495, B:119:0x049a, B:121:0x04a2, B:109:0x0451, B:97:0x03f8), top: B:145:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0488 A[Catch: Exception -> 0x0513, TryCatch #1 {Exception -> 0x0513, blocks: (B:2:0x0000, B:4:0x000f, B:6:0x0017, B:8:0x002d, B:11:0x0035, B:12:0x003b, B:14:0x0044, B:16:0x009c, B:18:0x00a7, B:20:0x00f1, B:21:0x00f5, B:22:0x0125, B:24:0x0132, B:28:0x015c, B:32:0x0196, B:36:0x01b6, B:38:0x01c7, B:40:0x01d3, B:39:0x01ce, B:35:0x01aa, B:31:0x018e, B:27:0x0143, B:41:0x01fc, B:43:0x0208, B:47:0x0232, B:51:0x026c, B:55:0x028c, B:57:0x029d, B:59:0x02a9, B:58:0x02a4, B:54:0x0280, B:50:0x0264, B:46:0x0219, B:60:0x02d2, B:61:0x02d6, B:63:0x02dc, B:64:0x02e4, B:66:0x02ea, B:68:0x030a, B:69:0x030e, B:70:0x0312, B:72:0x032f, B:73:0x0334, B:76:0x0340, B:77:0x034f, B:79:0x035d, B:80:0x0369, B:82:0x0382, B:84:0x038a, B:122:0x04a7, B:125:0x04bd, B:127:0x04c5, B:129:0x04cb, B:130:0x04d2, B:135:0x04f1, B:133:0x04d8, B:138:0x04f8, B:87:0x0395, B:89:0x03d4, B:94:0x03e2, B:98:0x03fe, B:100:0x040c, B:101:0x0411, B:103:0x0419, B:105:0x0420, B:106:0x0446, B:110:0x0470, B:112:0x047b, B:113:0x0480, B:115:0x0488, B:116:0x048d, B:118:0x0495, B:119:0x049a, B:121:0x04a2, B:109:0x0451, B:97:0x03f8), top: B:145:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0495 A[Catch: Exception -> 0x0513, TryCatch #1 {Exception -> 0x0513, blocks: (B:2:0x0000, B:4:0x000f, B:6:0x0017, B:8:0x002d, B:11:0x0035, B:12:0x003b, B:14:0x0044, B:16:0x009c, B:18:0x00a7, B:20:0x00f1, B:21:0x00f5, B:22:0x0125, B:24:0x0132, B:28:0x015c, B:32:0x0196, B:36:0x01b6, B:38:0x01c7, B:40:0x01d3, B:39:0x01ce, B:35:0x01aa, B:31:0x018e, B:27:0x0143, B:41:0x01fc, B:43:0x0208, B:47:0x0232, B:51:0x026c, B:55:0x028c, B:57:0x029d, B:59:0x02a9, B:58:0x02a4, B:54:0x0280, B:50:0x0264, B:46:0x0219, B:60:0x02d2, B:61:0x02d6, B:63:0x02dc, B:64:0x02e4, B:66:0x02ea, B:68:0x030a, B:69:0x030e, B:70:0x0312, B:72:0x032f, B:73:0x0334, B:76:0x0340, B:77:0x034f, B:79:0x035d, B:80:0x0369, B:82:0x0382, B:84:0x038a, B:122:0x04a7, B:125:0x04bd, B:127:0x04c5, B:129:0x04cb, B:130:0x04d2, B:135:0x04f1, B:133:0x04d8, B:138:0x04f8, B:87:0x0395, B:89:0x03d4, B:94:0x03e2, B:98:0x03fe, B:100:0x040c, B:101:0x0411, B:103:0x0419, B:105:0x0420, B:106:0x0446, B:110:0x0470, B:112:0x047b, B:113:0x0480, B:115:0x0488, B:116:0x048d, B:118:0x0495, B:119:0x049a, B:121:0x04a2, B:109:0x0451, B:97:0x03f8), top: B:145:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x04a2 A[Catch: Exception -> 0x0513, TryCatch #1 {Exception -> 0x0513, blocks: (B:2:0x0000, B:4:0x000f, B:6:0x0017, B:8:0x002d, B:11:0x0035, B:12:0x003b, B:14:0x0044, B:16:0x009c, B:18:0x00a7, B:20:0x00f1, B:21:0x00f5, B:22:0x0125, B:24:0x0132, B:28:0x015c, B:32:0x0196, B:36:0x01b6, B:38:0x01c7, B:40:0x01d3, B:39:0x01ce, B:35:0x01aa, B:31:0x018e, B:27:0x0143, B:41:0x01fc, B:43:0x0208, B:47:0x0232, B:51:0x026c, B:55:0x028c, B:57:0x029d, B:59:0x02a9, B:58:0x02a4, B:54:0x0280, B:50:0x0264, B:46:0x0219, B:60:0x02d2, B:61:0x02d6, B:63:0x02dc, B:64:0x02e4, B:66:0x02ea, B:68:0x030a, B:69:0x030e, B:70:0x0312, B:72:0x032f, B:73:0x0334, B:76:0x0340, B:77:0x034f, B:79:0x035d, B:80:0x0369, B:82:0x0382, B:84:0x038a, B:122:0x04a7, B:125:0x04bd, B:127:0x04c5, B:129:0x04cb, B:130:0x04d2, B:135:0x04f1, B:133:0x04d8, B:138:0x04f8, B:87:0x0395, B:89:0x03d4, B:94:0x03e2, B:98:0x03fe, B:100:0x040c, B:101:0x0411, B:103:0x0419, B:105:0x0420, B:106:0x0446, B:110:0x0470, B:112:0x047b, B:113:0x0480, B:115:0x0488, B:116:0x048d, B:118:0x0495, B:119:0x049a, B:121:0x04a2, B:109:0x0451, B:97:0x03f8), top: B:145:0x0000, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03f8 A[Catch: Exception -> 0x0513, TryCatch #1 {Exception -> 0x0513, blocks: (B:2:0x0000, B:4:0x000f, B:6:0x0017, B:8:0x002d, B:11:0x0035, B:12:0x003b, B:14:0x0044, B:16:0x009c, B:18:0x00a7, B:20:0x00f1, B:21:0x00f5, B:22:0x0125, B:24:0x0132, B:28:0x015c, B:32:0x0196, B:36:0x01b6, B:38:0x01c7, B:40:0x01d3, B:39:0x01ce, B:35:0x01aa, B:31:0x018e, B:27:0x0143, B:41:0x01fc, B:43:0x0208, B:47:0x0232, B:51:0x026c, B:55:0x028c, B:57:0x029d, B:59:0x02a9, B:58:0x02a4, B:54:0x0280, B:50:0x0264, B:46:0x0219, B:60:0x02d2, B:61:0x02d6, B:63:0x02dc, B:64:0x02e4, B:66:0x02ea, B:68:0x030a, B:69:0x030e, B:70:0x0312, B:72:0x032f, B:73:0x0334, B:76:0x0340, B:77:0x034f, B:79:0x035d, B:80:0x0369, B:82:0x0382, B:84:0x038a, B:122:0x04a7, B:125:0x04bd, B:127:0x04c5, B:129:0x04cb, B:130:0x04d2, B:135:0x04f1, B:133:0x04d8, B:138:0x04f8, B:87:0x0395, B:89:0x03d4, B:94:0x03e2, B:98:0x03fe, B:100:0x040c, B:101:0x0411, B:103:0x0419, B:105:0x0420, B:106:0x0446, B:110:0x0470, B:112:0x047b, B:113:0x0480, B:115:0x0488, B:116:0x048d, B:118:0x0495, B:119:0x049a, B:121:0x04a2, B:109:0x0451, B:97:0x03f8), top: B:145:0x0000, inners: #0, #2 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.module.report.UpLoadReportTask.run():void");
    }
}
