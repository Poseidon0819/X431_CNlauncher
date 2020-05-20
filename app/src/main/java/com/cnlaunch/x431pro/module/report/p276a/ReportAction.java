package com.cnlaunch.x431pro.module.report.p276a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.report.p277b.DownLoadReportResponse;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportInfo;
import com.cnlaunch.x431pro.module.report.p277b.UpLoadReportResponse;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.html.HtmlTags;
import com.mopub.mobileads.VastExtensionXmlManager;

/* renamed from: com.cnlaunch.x431pro.module.report.a.a */
/* loaded from: classes.dex */
public final class ReportAction extends BaseAction {
    public ReportAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final UpLoadReportResponse m5221a(UpLoadReportInfo upLoadReportInfo) throws C1425f {
        String b = m5451b(KeyConstant.f6797X);
        this.f15440b = m5452b();
        this.f15440b.m9506a("language", upLoadReportInfo.getLanguage());
        this.f15440b.m9506a(VastExtensionXmlManager.TYPE, upLoadReportInfo.getType());
        this.f15440b.m9506a("technician_lon", upLoadReportInfo.getTechnician_lon());
        this.f15440b.m9506a("technician_lat", upLoadReportInfo.getTechnician_lat());
        this.f15440b.m9506a("car_lon", upLoadReportInfo.getCar_lon());
        this.f15440b.m9506a("car_lat", upLoadReportInfo.getCar_lat());
        this.f15440b.m9506a("diagnosis_time", upLoadReportInfo.getDiagnosis_time());
        this.f15440b.m9506a("diagnosis_start_time", upLoadReportInfo.getDiagnosis_start_time());
        this.f15440b.m9506a("fault_codes", upLoadReportInfo.getFault_codes());
        this.f15440b.m9506a("conclusion", upLoadReportInfo.getConclusion());
        this.f15440b.m9506a("messagelist", upLoadReportInfo.getMessagelist());
        this.f15440b.m9506a("pro_serial_no", upLoadReportInfo.getPro_serial_no());
        if (upLoadReportInfo.getVin() != null && !TextUtils.isEmpty(upLoadReportInfo.getVin())) {
            this.f15440b.m9506a("vin", upLoadReportInfo.getVin());
        }
        if (!TextUtils.isEmpty(upLoadReportInfo.getData_flow())) {
            this.f15440b.m9506a("data_flow", upLoadReportInfo.getData_flow());
        }
        if (!TextUtils.isEmpty(upLoadReportInfo.getSerial_no())) {
            this.f15440b.m9506a("serial_no", upLoadReportInfo.getSerial_no());
        }
        if (!TextUtils.isEmpty(upLoadReportInfo.getGoloId())) {
            this.f15440b.m9506a("diagnostic_user_id", upLoadReportInfo.getGoloId());
        }
        if (!TextUtils.isEmpty(upLoadReportInfo.getTheme())) {
            this.f15440b.m9506a("theme", upLoadReportInfo.getTheme());
        }
        if (!TextUtils.isEmpty(upLoadReportInfo.getCars())) {
            this.f15440b.m9506a("cars", upLoadReportInfo.getCars());
        }
        if (!TextUtils.isEmpty(upLoadReportInfo.getOdo())) {
            this.f15440b.m9506a("mileage", upLoadReportInfo.getOdo());
        }
        if (!TextUtils.isEmpty(upLoadReportInfo.getVersion())) {
            this.f15440b.m9506a("version", upLoadReportInfo.getVersion());
        }
        if (!TextUtils.isEmpty(upLoadReportInfo.getPlate_num())) {
            this.f15440b.m9506a("plate_num", upLoadReportInfo.getPlate_num());
        }
        this.f15440b.m9506a("operation_list", upLoadReportInfo.getOperationlist());
        if (!TextUtils.isEmpty(upLoadReportInfo.getModel())) {
            this.f15440b.m9506a("models", upLoadReportInfo.getModel());
        }
        if (!TextUtils.isEmpty(upLoadReportInfo.getYear())) {
            this.f15440b.m9506a("model_year", upLoadReportInfo.getYear());
        }
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (UpLoadReportResponse) m5438a(m9475b, UpLoadReportResponse.class);
    }

    /* renamed from: b */
    public final DownLoadReportResponse m5220b(String str, int i) throws C1425f {
        String b = m5451b(KeyConstant.f6829ac);
        this.f15440b = m5452b();
        this.f15440b.m9506a(Annotation.PAGE, "1");
        C1426i c1426i = this.f15440b;
        StringBuilder sb = new StringBuilder();
        sb.append(i * 10);
        c1426i.m9506a(HtmlTags.SIZE, sb.toString());
        this.f15440b.m9506a(VastExtensionXmlManager.TYPE, "1");
        this.f15440b.m9506a("technician_id", str);
        String m9477a = this.f15446f.m9477a(m5455a(b, this.f15440b), this.f15440b);
        if (TextUtils.isEmpty(m9477a)) {
            return null;
        }
        return (DownLoadReportResponse) m5438a(m9477a, DownLoadReportResponse.class);
    }
}
