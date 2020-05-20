package com.cnlaunch.x431pro.utils.p288h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NetPOSPrinterUtil;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.utils.PrintInfoProperties;
import com.ifoer.expedition.pro.R;
import com.itextpdf.text.pdf.ColumnText;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.cnlaunch.x431pro.utils.h.a */
/* loaded from: classes.dex */
public final class NetPOSPrinterUtilPro extends NetPOSPrinterUtil {

    /* renamed from: a */
    private static SimpleDateFormat f15896a;

    /* renamed from: b */
    private static Date f15897b;

    /* renamed from: c */
    private static String f15898c;

    /* renamed from: d */
    private static TextPaint f15899d;

    /* renamed from: e */
    private static Bitmap f15900e;

    /* renamed from: a */
    public static Bitmap m4936a(Context context, String str, DiagnoseRunningInfo diagnoseRunningInfo) {
        String m4837a = PrintInfoProperties.m4838a().m4837a("companyName");
        String m4837a2 = PrintInfoProperties.m4838a().m4837a("companyAddress");
        String m4837a3 = PrintInfoProperties.m4838a().m4837a("companyPhoneNumber");
        String m4837a4 = PrintInfoProperties.m4838a().m4837a("companyEmail");
        String m9591a = PreferencesManager.m9595a(context).m9591a("licensePlateNumberDiagnew");
        String m9591a2 = PreferencesManager.m9595a(context).m9591a("serialNo");
        f15896a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f15897b = new Date(System.currentTimeMillis());
        f15898c = f15896a.format(f15897b);
        if (m4837a == null) {
            m4837a = "";
        }
        if (m4837a2 == null) {
            m4837a2 = "";
        }
        if (m4837a3 == null) {
            m4837a3 = "";
        }
        if (m4837a4 == null) {
            m4837a4 = "";
        }
        if (m9591a == null) {
            m9591a = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(context.getResources().getString(R.string.print_test_time) + f15898c + "\n");
        stringBuffer.append(context.getResources().getString(R.string.diagnose_report_serialnum) + m9591a2 + "\n");
        stringBuffer.append(context.getResources().getString(R.string.diagnose_report_repairplant) + m4837a + "\n");
        stringBuffer.append(context.getResources().getString(R.string.diagnose_report_address) + m4837a2 + "\n");
        stringBuffer.append(context.getResources().getString(R.string.diagnose_report_tel) + m4837a3 + "\n");
        stringBuffer.append(context.getResources().getString(R.string.register_hint_email) + " :" + m4837a4 + "\n");
        if (!TextUtils.isEmpty(m9591a)) {
            stringBuffer.append(context.getResources().getString(R.string.diagnose_report_plate_number) + m9591a + "\n");
        }
        if (diagnoseRunningInfo != null && "" != diagnoseRunningInfo.getSoftVersion() && "" != diagnoseRunningInfo.getCarSoftName()) {
            stringBuffer.append(context.getResources().getString(R.string.diagnose_report_carname) + diagnoseRunningInfo.getCarSoftName() + "\n");
            stringBuffer.append(context.getResources().getString(R.string.diagnose_report_carver) + diagnoseRunningInfo.getSoftVersion() + "\n");
        }
        stringBuffer.append(str);
        TextPaint textPaint = new TextPaint();
        f15899d = textPaint;
        textPaint.setColor(-16777216);
        f15899d.setTextSize(20.0f);
        StaticLayout staticLayout = new StaticLayout(stringBuffer, f15899d, 384, Layout.Alignment.ALIGN_NORMAL, 1.0f, ColumnText.GLOBAL_SPACE_CHAR_RATIO, true);
        f15900e = Bitmap.createBitmap(384, staticLayout.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(f15900e);
        canvas.drawColor(-1);
        staticLayout.draw(canvas);
        return f15900e;
    }
}
