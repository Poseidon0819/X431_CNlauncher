package com.cnlaunch.x431pro.activity.pdf;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.itextpdf.text.xml.xmp.PdfSchema;

/* loaded from: classes.dex */
public class ReportIntentService extends IntentService {

    /* renamed from: a */
    private Context f14426a;

    public ReportIntentService() {
        super("ReportIntentService");
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f14426a = this;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null && "com.cnlaunch.report.action_save".equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra("reprot_type");
            if (stringExtra.equalsIgnoreCase(PdfSchema.DEFAULT_XPATH_ID)) {
                m6054a(new PDFReportsUtils().m6050a(this.f14426a, (PDFFaultCodeReportInfo) intent.getSerializableExtra("fault_code_report_content")));
            } else if (!stringExtra.equalsIgnoreCase("txt")) {
                if (stringExtra.equalsIgnoreCase("data_stream")) {
                    int intValue = Integer.valueOf(intent.getStringExtra("if_has_standard_value")).intValue();
                    m6054a(new PDFReportsUtils().m6051a(this.f14426a, (PDFDataStreamInfo) intent.getSerializableExtra("data_stream_report_content"), intValue));
                }
            } else {
                m6054a(FileUtils.m5016a(intent.getStringExtra("txt_content"), intent.getStringExtra("filepath")));
            }
        }
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
        System.gc();
    }

    /* renamed from: a */
    private void m6054a(boolean z) {
        Intent intent = new Intent("com.cnlaunch.report.action_result");
        intent.putExtra("save_result", z);
        sendBroadcast(intent);
    }
}
